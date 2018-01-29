/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.InstantiatedOPPLScript;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScriptVisitor;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.LeafBrusher;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.search.EntitySearcher;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone Jun 11, 2008
 */
public class InstantiatedPatternModel
    implements InstantiatedOPPLScript, PatternOPPLScript, HasPatternModel {

    private IRI uri = null;
    private final PatternModel patternModel;
    private final RuntimeExceptionHandler runtimeExceptionHandler;

    /**
     * Creates an InstantiatedPatternModel instance starting from the input PatternModel
     * 
     * @param patternModel the Pattern on which the this instantiated pattern will be built. Cannot
     *        be {@code null}.
     * @param handler handler
     */
    public InstantiatedPatternModel(PatternModel patternModel, RuntimeExceptionHandler handler) {
        this.patternModel = checkNotNull(patternModel, "patternModel");
        runtimeExceptionHandler = checkNotNull(handler, "handler");
    }

    private final Map<Variable<?>, Set<OWLObject>> instantiations = new HashMap<>();
    private String unresolvedOPPLStatementString;

    /**
     * @param variable variable
     * @return instantiations
     * @deprecated use the stream version
     */
    @Deprecated
    public Set<OWLObject> getInstantiations(Variable<?> variable) {
        // defensive copy; it also guarantees that no nulls are returned
        Set<OWLObject> toReturn = new HashSet<>();
        if (instantiations.containsKey(variable)) {
            toReturn.addAll(instantiations.get(variable));
        }
        return toReturn;
    }

    /**
     * @param variable variable
     * @return instantiations
     */
    public Stream<OWLObject> instantiations(Variable<?> variable) {
        return instantiations.getOrDefault(variable, Collections.emptySet()).stream();
    }

    /**
     * @param variable variable
     * @param owlObject owlObject
     * @return true if any instantiation removed
     */
    public boolean removeInstantiation(Variable<?> variable, OWLObject owlObject) {
        Set<OWLObject> variableInstantiations = instantiations.get(variable);
        boolean toReturn = false;
        if (variableInstantiations != null) {
            toReturn = variableInstantiations.remove(owlObject);
        }
        return toReturn;
    }

    /**
     * Assigns the input value to the input variable, if the variable is already in the
     * InstantiatedPatternModel. To add a Variable instance use
     * {@link InstantiatedPatternModel#addVariable(Variable)}
     * 
     * @param variable variable
     * @param value value
     */
    @Override
    public void instantiate(Variable<?> variable, OWLObject value) {
        if (getPatternModel().getVariables().contains(variable) || getPatternModel()
            .getConstraintSystem().getThisClassVariable().equals(variable)
            && getPatternModel().getConstraintSystem().getVariable(variable.getName()) != null) {
            Set<OWLObject> instantiation = getInstantiations(variable);
            instantiation.add(value);
            instantiations.put(variable, instantiation);
        }
    }

    @Override
    public boolean isValid() {
        boolean unassignedVariables = false;
        Iterator<? extends Variable<?>> it = getInputVariables().iterator();
        Variable<?> variable;
        while (!unassignedVariables && it.hasNext()) {
            variable = it.next();
            unassignedVariables =
                instantiations.get(variable) == null || instantiations.get(variable).isEmpty();
        }
        return patternModel.isValid() && !unassignedVariables;
    }

    @Override
    public String getRendering() {
        String toReturn = patternModel.getRendering();
        for (Variable<?> variable : instantiations.keySet()) {
            Set<OWLObject> instantiation = instantiations.get(variable);
            if (instantiation != null) {
                if (instantiation.size() == 1) {
                    OWLObject singleInstantiation = instantiation.iterator().next();
                    toReturn = toReturn.replaceAll("\\" + variable.getName(),
                        this.render(singleInstantiation));
                } else {
                    String instantiationReplacement = "{";
                    boolean firstInstantiationValue = true;
                    for (OWLObject object : instantiation) {
                        instantiationReplacement += firstInstantiationValue ? this.render(object)
                            : ", " + this.render(object);
                        firstInstantiationValue =
                            firstInstantiationValue ? false : firstInstantiationValue;
                    }
                    instantiationReplacement += "}";
                    toReturn =
                        toReturn.replaceAll("\\" + variable.getName(), instantiationReplacement);
                }
            } else {
                toReturn += variable.getName();
            }
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "$" + patternModel.getPatternLocalName();
        boolean first = true;
        toReturn += "(";
        for (Variable<?> variable : getInputVariables()) {
            if (!first) {
                toReturn += ", ";
            } else {
                first = false;
            }
            ManchesterSyntaxRenderer renderer =
                patternModel.getPatternModelFactory().getRenderer(getConstraintSystem());
            Set<OWLObject> instantiation = instantiations.get(variable);
            if (instantiation != null) {
                if (instantiation.size() == 1) {
                    OWLObject singleInstantiation = instantiation.iterator().next();
                    singleInstantiation.accept(renderer);
                    toReturn += renderer.toString();
                } else {
                    toReturn += "{";
                    boolean firstInstantiationValue = true;
                    for (OWLObject object : instantiation) {
                        object.accept(renderer);
                        toReturn += firstInstantiationValue ? renderer.toString()
                            : ", " + renderer.toString();
                        firstInstantiationValue =
                            firstInstantiationValue ? false : firstInstantiationValue;
                        renderer = patternModel.getPatternModelFactory()
                            .getRenderer(getConstraintSystem());
                    }
                    toReturn += "}";
                }
            } else {
                toReturn += variable.getName();
            }
        }
        toReturn += ")";
        return toReturn;
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        String toReturn = "$" + patternModel.getPatternLocalName();
        boolean first = true;
        toReturn += "(";
        for (Variable<?> variable : getInputVariables()) {
            if (!first) {
                toReturn += ", ";
            } else {
                first = false;
            }
            ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
            Set<OWLObject> instantiation = instantiations.get(variable);
            if (instantiation != null) {
                if (instantiation.size() == 1) {
                    OWLObject singleInstantiation = instantiation.iterator().next();
                    singleInstantiation.accept(renderer);
                    toReturn += renderer.toString();
                } else {
                    toReturn += "{";
                    boolean firstInstantiationValue = true;
                    for (OWLObject object : instantiation) {
                        object.accept(renderer);
                        toReturn += firstInstantiationValue ? renderer.toString()
                            : ", " + renderer.toString();
                        firstInstantiationValue =
                            firstInstantiationValue ? false : firstInstantiationValue;
                        renderer = new ManchesterSyntaxRenderer(shortFormProvider);
                    }
                    toReturn += "}";
                }
            } else {
                toReturn += variable.getName();
            }
        }
        toReturn += ")";
        return toReturn;
    }

    protected String render(OWLObject owlObject) {
        ManchesterSyntaxRenderer renderer =
            patternModel.getPatternModelFactory().getRenderer(getConstraintSystem());
        owlObject.accept(renderer);
        return renderer.toString();
    }

    /**
     * @return the instantiatedPatternLocalName
     */
    public String getInstantiatedPatternLocalName() {
        return patternModel.getPatternLocalName();
    }

    /**
     * @return binding nodes
     */
    public Set<BindingNode> extractBindingNodes() {
        List<InputVariable<?>> inputVariables = getInputVariables();
        Map<Variable<?>, Set<OWLObject>> bindings = new HashMap<>();
        for (InputVariable<?> v : inputVariables) {
            if (instantiations.containsKey(v)) {
                bindings.put(v, new HashSet<>(instantiations.get(v)));
            }
        }
        Set<Variable<?>> toAssign = new HashSet<>(inputVariables);
        if (isClassPattern()) {
            Variable<?> thisClassVariable = getConstraintSystem().getThisClassVariable();
            toAssign.add(thisClassVariable);
            if (instantiations.containsKey(thisClassVariable)) {
                bindings.put(thisClassVariable,
                    new HashSet<>(instantiations.get(thisClassVariable)));
            }
        }
        BindingNode rootBindingNode = new BindingNode(toAssign);
        LeafBrusher leafBrusher = new LeafBrusher(bindings);
        rootBindingNode.accept(leafBrusher);
        return leafBrusher.getLeaves();
    }

    @Override
    public Set<OWLObject> getOWLObjects(OWLOntology ontology, ErrorListener errorListener) {
        Set<OWLObject> toReturn = new HashSet<>();
        ontology.classesInSignature().forEach(owlClass -> EntitySearcher
            .getAnnotationAssertionAxioms(owlClass.getIRI(), ontology).forEach(annotationAxiom -> {
                PatternExtractor patternExtractor =
                    patternModel.getPatternModelFactory().getPatternExtractor(errorListener);
                OWLAnnotation annotation = annotationAxiom.getAnnotation();
                PatternOPPLScript script = annotation.accept(patternExtractor);
                if (script != null && getName().equals(script.getName())) {
                    toReturn.add(annotationAxiom);
                }
            }));

        return toReturn;
    }

    /**
     * @return originating ontology
     */
    public OWLOntology getOriginatingOntology() {
        OWLOntology toReturn = patternModel.getOriginatingOntology();
        return toReturn;
    }

    /**
     * Adds the input Variable to this InstantiatedPatternModel. The instantiations after the
     * addition will be {@code null}
     * 
     * @param v v
     */
    @Override
    public void addVariable(Variable<?> v) {
        instantiations.put(v, null);
    }

    @Override
    public String getName() {
        return patternModel.getPatternLocalName();
    }

    @Override
    public List<Variable<?>> getVariables() {
        return patternModel.getVariables();
    }

    @Override
    public PatternConstraintSystem getConstraintSystem() {
        return patternModel.getConstraintSystem();
    }

    /**
     * @return instantiated pattern
     */
    public PatternModel getInstantiatedPattern() {
        return patternModel;
    }

    @Override
    public void addDependency(PatternOPPLScript script) {}

    @Override
    public boolean dependsOn(PatternOPPLScript patternOPPLScript) {
        return patternOPPLScript.getName().equals(patternModel.getName())
            || patternModel.dependsOn(patternOPPLScript);
    }

    /**
     * @param unresolvedString unresolvedString
     */
    public void setUnresolvedOPPLStatement(String unresolvedString) {
        unresolvedOPPLStatementString = unresolvedString;
    }

    /**
     * @return unresolved oppl statement
     */
    public String gettUnresolvedOPPLStatement() {
        return unresolvedOPPLStatementString;
    }

    @Override
    public IRI getIRI() {
        return uri;
    }

    @Override
    public void setIRI(IRI uri) {
        this.uri = uri;
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return render();
    }

    @Override
    public String render() {
        String toReturn = "$" + getInstantiatedPatternLocalName();
        boolean first = true;
        toReturn += "(";
        for (Variable<?> variable : getInputVariables()) {
            if (!first) {
                toReturn += ", ";
            } else {
                first = false;
            }
            Set<OWLObject> instantiationsValues = getInstantiations(variable);
            if (instantiationsValues != null && !instantiationsValues.isEmpty()) {
                if (instantiationsValues.size() == 1) {
                    OWLObject instantiation = instantiationsValues.iterator().next();
                    toReturn += this.render(instantiation);
                } else {
                    boolean firstInstantiation = true;
                    toReturn += "{";
                    for (OWLObject instantiation : instantiationsValues) {
                        String instantiationRendering = this.render(instantiation);
                        toReturn += firstInstantiation ? instantiationRendering
                            : ", " + instantiationRendering;
                        firstInstantiation = firstInstantiation ? false : firstInstantiation;
                    }
                    toReturn += "}";
                }
            } else {
                toReturn += variable.getName();
            }
        }
        toReturn += ")";
        return toReturn;
    }

    @Override
    public PatternModel getPatternModel() {
        return patternModel;
    }

    @Override
    public boolean isClassPattern() {
        return patternModel.isClassPattern();
    }

    @Override
    public List<InputVariable<?>> getInputVariables() {
        return patternModel.getOpplStatement().getInputVariables();
    }

    @Override
    public boolean hasScopedVariables() {
        return getPatternModel().hasScopedVariables();
    }

    @Override
    public void accept(OPPLScriptVisitor visitor) {
        patternModel.accept(visitor);
    }

    @Override
    public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
        return patternModel.accept(visitor);
    }

    @Override
    public List<OWLAxiomChange> getActions() {
        List<OWLAxiomChange> actions = patternModel.getActions();
        Set<BindingNode> bindingNodes = extractBindingNodes();
        List<OWLAxiomChange> toReturn = new ArrayList<>();
        for (BindingNode bindingNode : bindingNodes) {
            for (OWLAxiomChange axiomChange : actions) {
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), bindingNode, getRuntimeExceptionHandler());
                PartialOWLObjectInstantiator partialObjectInstantiator =
                    new PartialOWLObjectInstantiator(parameters);
                OWLAxiom axiom = axiomChange.getAxiom();
                OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(partialObjectInstantiator);
                OWLAxiomChange instantiatedChange = axiomChange.isAddAxiom()
                    ? new AddAxiom(axiomChange.getOntology(), instantiatedAxiom)
                    : new RemoveAxiom(axiomChange.getOntology(), instantiatedAxiom);
                toReturn.add(instantiatedChange);
            }
        }
        return toReturn;
    }

    @Override
    public OPPLQuery getQuery() {
        return null;
    }

    @Override
    public OWLObject getDefinitorialPortion(Collection<? extends BindingNode> bindingNodes,
        RuntimeExceptionHandler reh) throws PatternException {
        return getPatternModel().getDefinitorialPortion(bindingNodes, reh);
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
