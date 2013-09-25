package org.coode.patterns.locality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

/** @author Luigi Iannone */
public class LocalityCheckerLeafBrusher implements BindingVisitor {
    private final LocalityEvaluator evaluator;
    private final ConstraintSystem constraintSystem;
    private final PatternModel patternModel;
    private final RuntimeExceptionHandler handler;
    private final Set<OWLEntity> signature = new HashSet<OWLEntity>();
    private final Map<Variable<?>, SigmaPlusSigmaMinus> variableBindings = new HashMap<Variable<?>, SigmaPlusSigmaMinus>();
    private final List<BindingNode> exploredBindings = new ArrayList<BindingNode>();

    public List<BindingNode> getExploredBindings() {
        return exploredBindings;
    }

    public List<Boolean> getExploredBindingsLocality() {
        return exploredBindingsLocality;
    }

    private final List<Boolean> exploredBindingsLocality = new ArrayList<Boolean>();
    private final List<OWLAxiom> foundNonLocals = new ArrayList<OWLAxiom>();

    public LocalityCheckerLeafBrusher(LocalityEvaluator evaluator,
            ConstraintSystem constraintSystem, PatternModel patternModel,
            Map<Variable<?>, SigmaPlusSigmaMinus> variableBindings,
            Set<OWLEntity> signature, RuntimeExceptionHandler runtimeExceptionHandler) {
        if (evaluator == null) {
            throw new NullPointerException("The evaluator cannot be null");
        }
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        if (variableBindings == null) {
            throw new NullPointerException("The bindings cannot be null");
        }
        if (signature == null) {
            throw new NullPointerException("The signature cannot be null");
        }
        if (runtimeExceptionHandler == null) {
            throw new NullPointerException("The runtime exception handler cannot be null");
        }
        this.evaluator = evaluator;
        this.constraintSystem = constraintSystem;
        this.patternModel = patternModel;
        handler = runtimeExceptionHandler;
        this.signature.addAll(signature);
        this.variableBindings.putAll(variableBindings);
    }

    @Override
    public void visit(BindingNode bindingNode) {
        if (!bindingNode.isEmpty()) {
            Set<BindingNode> allLeaves = new HashSet<BindingNode>();
            List<BindingNode> nodes = new ArrayList<BindingNode>();
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
        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                getConstraintSystem(), bindingNode, getHandler());
        PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                parameters);
        exploredBindings.add(bindingNode);
        List<OWLAxiomChange> changes = patternModel.getActions();
        boolean safe = true;
        for (int i = 0; i < changes.size(); i++) {
            OWLAxiom axiom = changes.get(i).getAxiom();
            OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
            try {
                Set<OWLEntity> actualSignature = new HashSet<OWLEntity>(signature);
                for (SigmaPlusSigmaMinus s : variableBindings.values()) {
                    actualSignature.add(s.getPlus());
                }
                if (!evaluator.isLocal(instantiatedAxiom, actualSignature)) {
                    foundNonLocals.add(instantiatedAxiom);
                    safe = false;
                }
            } catch (OWLRuntimeException e) {
                e.printStackTrace();
                throw e;
            }
        }
        exploredBindingsLocality.add(Boolean.valueOf(safe));
    }

    /** @return the leaves */
    public boolean isLocal() {
        return foundNonLocals.size() == 0;
    }

    public List<OWLAxiom> getNonLocalAxioms() {
        return foundNonLocals;
    }

    private Set<BindingNode> generateChildren(BindingNode node) {
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        Set<Variable<?>> unassignedVariables = node.getUnassignedVariables();
        for (Variable<?> variable : unassignedVariables) {
            for (OWLObject owlObject : variableBindings.get(variable)) {
                Set<Variable<?>> childUnassignedVariables = new HashSet<Variable<?>>(
                        unassignedVariables);
                childUnassignedVariables.remove(variable);
                Set<Assignment> childAssignements = new HashSet<Assignment>(
                        node.getAssignments());
                childAssignements.add(new Assignment(variable, owlObject));
                BindingNode newNode = new BindingNode(childAssignements,
                        childUnassignedVariables);
                toReturn.add(newNode);
            }
        }
        return toReturn;
    }

    /** @return the signature */
    public Set<OWLEntity> getSignature() {
        return new HashSet<OWLEntity>(signature);
    }

    /** @param signature
     *            the signature to set */
    public void setSignature(Collection<? extends OWLEntity> signature) {
        this.signature.clear();
        this.signature.addAll(signature);
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    /** @return the handler */
    public RuntimeExceptionHandler getHandler() {
        return handler;
    }
}
