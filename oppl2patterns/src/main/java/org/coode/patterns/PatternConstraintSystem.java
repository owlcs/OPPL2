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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.VariableFactory;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone Jun 19, 2008 */
public class PatternConstraintSystem extends ConstraintSystem {
    /** constant symbol for this class */
    public static final String THIS_CLASS_VARIABLE_CONSTANT_SYMBOL = "$thisClass";
    private final Map<String, GeneratedVariable<?>> specialVariables = new HashMap<String, GeneratedVariable<?>>();
    private final ConstraintSystem constraintSystem;
    private final Map<String, String> specialVariableRenderings = new HashMap<String, String>();
    private final AbstractPatternModelFactory factory;

    /** @param cs
     * @param ontologyManager
     * @param f */
    public PatternConstraintSystem(ConstraintSystem cs,
            OWLOntologyManager ontologyManager, AbstractPatternModelFactory f) {
        super(cs.getOntology(), ontologyManager, f.getOPPLFactory());
        setReasoner(cs.getReasoner());
        constraintSystem = cs;
        factory = f;
    }

    /** @param ontology
     * @param ontologyManager
     * @param reasoner
     * @param f */
    public PatternConstraintSystem(OWLOntology ontology,
            OWLOntologyManager ontologyManager, OWLReasoner reasoner,
            AbstractPatternModelFactory f) {
        this(
                new ConstraintSystem(ontology, ontologyManager, reasoner,
                        f.getOPPLFactory()), ontologyManager, f);
    }

    @Override
    public <O extends OWLObject> InputVariable<O> createVariable(String name,
            VariableType<O> type, VariableScope<?> variableScope) throws OPPLException {
        return constraintSystem.createVariable(name, type, variableScope);
    }

    /** @return variable for this class */
    public Variable<?> getThisClassVariable() {
        Variable<OWLClassExpression> toReturn = VariableFactory.getCLASSVariable(
                THIS_CLASS_VARIABLE_CONSTANT_SYMBOL, null);
        importVariable(toReturn);
        return toReturn;
    }

    @Override
    public Variable<?> getVariable(String name) {
        Variable<?> variable = constraintSystem.getVariable(name);
        if (variable == null) {
            Iterator<String> it = specialVariables.keySet().iterator();
            boolean found = false;
            GeneratedVariable<?> specialVariable = null;
            while (!found && it.hasNext()) {
                String referenceName = it.next();
                specialVariable = specialVariables.get(referenceName);
                found = referenceName.equals(name)
                        || specialVariableRenderings.get(specialVariable.getName()) != null
                        && specialVariableRenderings.get(specialVariable.getName())
                                .equals(name);
            }
            if (found) {
                variable = specialVariable;
            }
        }
        return variable;
    }

    @Override
    public Variable<?> getVariable(IRI iri) {
        Variable<?> variable = constraintSystem.getVariable(iri);
        if (variable == null) {
            variable = getSpecialVariable(iri);
        }
        return variable;
    }

    private Variable<?> getSpecialVariable(IRI iri) {
        boolean found = false;
        Iterator<? extends Variable<?>> it = specialVariables.values().iterator();
        Variable<?> variable = null;
        while (!found && it.hasNext()) {
            variable = it.next();
            found = iri.equals(variable.getIRI());
        }
        return found ? variable : null;
    }

    @Override
    public boolean isVariableIRI(IRI uri) {
        boolean found = constraintSystem.isVariableIRI(uri);
        if (!found) {
            Iterator<? extends Variable<?>> it = specialVariables.values().iterator();
            while (!found && it.hasNext()) {
                Variable<?> variable = it.next();
                found = uri.equals(variable.getIRI());
            }
        }
        return found;
    }

    /** @param s
     * @return resolved pattern constants */
    public String resolvePatternConstants(String s) {
        String toReturn = s;
        for (String specialVariableName : specialVariables.keySet()) {
            GeneratedVariable<?> variable = specialVariables.get(specialVariableName);
            if (variable != null) {
                toReturn = toReturn.replaceAll("\\" + specialVariableName,
                        variable.getName());
            }
        }
        return toReturn;
    }

    /** @param variable
     * @return true if variable is this class variable */
    public boolean isThisClassVariable(Variable<?> variable) {
        return variable.equals(specialVariables
                .get(PatternConstraintSystem.THIS_CLASS_VARIABLE_CONSTANT_SYMBOL));
    }

    @Override
    public Set<Variable<?>> getVariables() {
        Set<Variable<?>> toReturn = constraintSystem.getVariables();
        toReturn.addAll(specialVariables.values());
        return toReturn;
    }

    /** @param patternName
     * @param visitedPatterns
     * @param dependencies
     * @param errorListener
     * @param args
     * @return resolved pattern
     * @throws PatternException */
    public String resolvePattern(String patternName, Set<String> visitedPatterns,
            List<PatternOPPLScript> dependencies, ErrorListener errorListener,
            List<Object>... args) throws PatternException {
        Set<String> visited = new HashSet<String>(visitedPatterns);
        PatternReference patternReference = new PatternReference(patternName, this,
                visited, errorListener, args);
        dependencies.add(patternReference.getExtractedPattern());
        VariableType<?> variableType = patternReference.getExtractedPattern()
                .getReturnVariable().getType();
        PatternReferenceGeneratedVariable<?> patternReferenceGeneratedVariable = PatternReferenceGeneratedVariable
                .getPatternReferenceGeneratedVariable(patternReference.toString(),
                        variableType, patternReference);
        importVariable(patternReferenceGeneratedVariable);
        return patternReferenceGeneratedVariable.getName();
    }

    /** @param patternName
     * @param visitedPatterns
     * @param dependencies
     * @param errorListener
     * @param args
     * @return instantiated pattern
     * @throws PatternException */
    public InstantiatedPatternModel resolvePatternInstantiation(String patternName,
            Set<String> visitedPatterns, List<PatternOPPLScript> dependencies,
            final ErrorListener errorListener, List<String>... args)
            throws PatternException {
        RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
            @Override
            public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
                errorListener.reportThrowable(e, 0, 0, 0);
            }

            @Override
            public void handleOWLRuntimeException(OWLRuntimeException e) {
                errorListener.reportThrowable(e, 0, 0, 0);
            }

            @Override
            public void handleException(RuntimeException e) {
                errorListener.reportThrowable(e, 0, 0, 0);
            }
        };
        PatternReference patternReference = new PatternReference(patternName, this,
                visitedPatterns, errorListener, args);
        dependencies.add(patternReference.getExtractedPattern());
        return patternReference.getInstantiation(handler);
    }

    @Override
    public <O extends OWLObject> GeneratedVariable<O> createStringGeneratedVariable(
            String name, VariableType<O> type, OPPLFunction<String> value) {
        return constraintSystem.createStringGeneratedVariable(name, type, value);
    }

    @Override
    public void removeVariable(Variable<?> variable) {
        constraintSystem.removeVariable(variable);
    }

    @Override
    public
            GeneratedVariable<OWLClassExpression>
            createIntersectionGeneratedVariable(
                    String name,
                    VariableType<?> type,
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> operands) {
        return constraintSystem.createIntersectionGeneratedVariable(name, type, operands);
    }

    @Override
    public
            GeneratedVariable<OWLClassExpression>
            createUnionGeneratedVariable(
                    String name,
                    VariableType<?> type,
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> operands) {
        return constraintSystem.createUnionGeneratedVariable(name, type, operands);
    }

    @Override
    public Set<InputVariable<?>> getInputVariables() {
        return constraintSystem.getInputVariables();
    }

    @Override
    public String render(Variable<?> variable) {
        GeneratedVariable<?> specialVariable = specialVariables.get(variable.getName());
        String rendering = null;
        if (specialVariable != null) {
            rendering = specialVariableRenderings.get(specialVariable.getName());
        }
        if (rendering == null) {
            rendering = constraintSystem.render(variable);
        }
        return rendering;
    }

    @Override
    public <O extends OWLObject> RegexpGeneratedVariable<? extends O>
            createRegexpGeneratedVariable(String name, VariableType<O> type,
                    OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return constraintSystem.createRegexpGeneratedVariable(name, type,
                patternGeneratingOPPLFunction);
    }

    @Override
    public void importVariable(Variable<?> v) {
        constraintSystem.importVariable(v);
    }

    @Override
    public void clearVariables() {
        constraintSystem.clearVariables();
    }

    /** @return pattern model factory */
    public AbstractPatternModelFactory getPatternModelFactory() {
        return factory;
    }

    @Override
    public Set<Variable<?>> getAxiomVariables(OWLAxiom axiom) {
        return constraintSystem.getAxiomVariables(axiom);
    }

    @Override
    public boolean isVariable(OWLObject desc) {
        return constraintSystem.isVariable(desc);
    }

    @Override
    public void addLeaf(BindingNode bindingNode) {
        constraintSystem.addLeaf(bindingNode);
    }

    @Override
    public Set<OWLObject> getVariableBindings(Variable<?> v,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        return constraintSystem.getVariableBindings(v, runtimeExceptionHandler);
    }

    @Override
    public boolean addLeaf(Variable<?> variable, OWLObject object) {
        return constraintSystem.addLeaf(variable, object);
    }

    @Override
    public Set<BindingNode> getLeaves() {
        return constraintSystem.getLeaves();
    }

    @Override
    public OPPLAbstractFactory getOPPLFactory() {
        return constraintSystem.getOPPLFactory();
    }

    @Override
    public void removeBinding(BindingNode binding) {
        constraintSystem.removeBinding(binding);
    }

    @Override
    public boolean isVariable(OWLLiteral node) {
        return constraintSystem.isVariable(node);
    }

    @Override
    public void setLeaves(Collection<? extends BindingNode> newLeaves) {
        constraintSystem.setLeaves(newLeaves);
    }

    @Override
    public Set<GeneratedVariable<?>> getGeneratedVariables() {
        return constraintSystem.getGeneratedVariables();
    }

    @Override
    public boolean isGenerated(Variable<?> v) {
        return constraintSystem.isGenerated(v);
    }

    @Override
    public void reset() {
        constraintSystem.reset();
    }

    @Override
    public <O extends OWLObject> GeneratedVariable<O> createExpressionGeneratedVariable(
            String name, O expression) {
        return constraintSystem.createExpressionGeneratedVariable(name, expression);
    }
}
