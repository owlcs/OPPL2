package org.coode.patterns.locality;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.BindingVisitor;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.patterns.PatternModel;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 */
public class LocalityCheckerLeafBrusher implements BindingVisitor {

    private final LocalityEvaluator evaluator;
    private final ConstraintSystem constraintSystem;
    private final PatternModel patternModel;
    private final RuntimeExceptionHandler handler;
    private final Set<OWLEntity> signature = new HashSet<>();
    private final Map<Variable<?>, SigmaPlusSigmaMinus> variableBindings = new HashMap<>();
    private final List<BindingNode> exploredBindings = new ArrayList<>();

    /**
     * @return explored bindings
     */
    public List<BindingNode> getExploredBindings() {
        return exploredBindings;
    }

    /**
     * @return locality explored bindings
     */
    public List<Boolean> getExploredBindingsLocality() {
        return exploredBindingsLocality;
    }

    private final List<Boolean> exploredBindingsLocality = new ArrayList<>();
    private final List<OWLAxiom> foundNonLocals = new ArrayList<>();

    /**
     * @param evaluator evaluator
     * @param constraintSystem constraintSystem
     * @param patternModel patternModel
     * @param variableBindings variableBindings
     * @param signature signature
     * @param runtimeExceptionHandler runtimeExceptionHandler
     */
    public LocalityCheckerLeafBrusher(LocalityEvaluator evaluator,
        ConstraintSystem constraintSystem, PatternModel patternModel,
        Map<Variable<?>, SigmaPlusSigmaMinus> variableBindings, Set<OWLEntity> signature,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        this.evaluator = checkNotNull(evaluator, "evaluator");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.patternModel = checkNotNull(patternModel, "patternModel");
        handler = checkNotNull(runtimeExceptionHandler, "runtimeExceptionHandler");
        this.signature.addAll(checkNotNull(signature, "signature"));
        this.variableBindings.putAll(checkNotNull(variableBindings, "variableBindings"));
    }

    @Override
    public void visit(BindingNode bindingNode) {
        if (!bindingNode.isEmpty()) {
            Set<BindingNode> allLeaves = new HashSet<>();
            List<BindingNode> nodes = new ArrayList<>();
            nodes.add(bindingNode);
            while (nodes.size() > 0) {
                BindingNode node = nodes.remove(0);
                if (!node.isLeaf()) {
                    nodes.addAll(generateChildren(node));
                } else {
                    allLeaves.add(node);
                }
            }
            for (BindingNode node : allLeaves) {
                checkLocal(node);
            }
        }
    }

    private void checkLocal(BindingNode bindingNode) {
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(getConstraintSystem(), bindingNode, getHandler());
        PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(parameters);
        exploredBindings.add(bindingNode);
        List<OWLAxiomChange> changes = patternModel.getActions();
        boolean safe = true;
        for (int i = 0; i < changes.size(); i++) {
            OWLAxiom axiom = changes.get(i).getAxiom();
            OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
            try {
                Set<OWLEntity> actualSignature = new HashSet<>(signature);
                for (SigmaPlusSigmaMinus s : variableBindings.values()) {
                    actualSignature.add(s.getPlus());
                }
                if (!evaluator.isLocal(instantiatedAxiom, actualSignature)) {
                    foundNonLocals.add(instantiatedAxiom);
                    safe = false;
                }
            } catch (OWLRuntimeException e) {
                throw e;
            }
        }
        exploredBindingsLocality.add(Boolean.valueOf(safe));
    }

    /**
     * @return the leaves
     */
    public boolean isLocal() {
        return foundNonLocals.size() == 0;
    }

    /**
     * @return non local axioms
     */
    public List<OWLAxiom> getNonLocalAxioms() {
        return foundNonLocals;
    }

    private Set<BindingNode> generateChildren(BindingNode node) {
        Set<BindingNode> toReturn = new HashSet<>();
        Set<Variable<?>> unassignedVariables = node.getUnassignedVariables();
        for (Variable<?> variable : unassignedVariables) {
            for (OWLObject owlObject : variableBindings.get(variable)) {
                Set<Variable<?>> childUnassignedVariables = new HashSet<>(unassignedVariables);
                childUnassignedVariables.remove(variable);
                Set<Assignment> childAssignements = new HashSet<>(node.getAssignments());
                childAssignements.add(new Assignment(variable, owlObject));
                BindingNode newNode = new BindingNode(childAssignements, childUnassignedVariables);
                toReturn.add(newNode);
            }
        }
        return toReturn;
    }

    /**
     * @return the signature
     * @deprecated use the stream version
     */
    @Deprecated
    public Set<OWLEntity> getSignature() {
        return new HashSet<>(signature);
    }

    /**
     * @return the signature
     */
    public Stream<OWLEntity> signature() {
        return signature.stream();
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(Collection<? extends OWLEntity> signature) {
        this.signature.clear();
        this.signature.addAll(signature);
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    /**
     * @return the handler
     */
    public RuntimeExceptionHandler getHandler() {
        return handler;
    }
}
