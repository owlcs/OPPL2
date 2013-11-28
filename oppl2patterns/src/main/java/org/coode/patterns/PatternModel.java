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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptVisitor;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.ErrorListener;
import org.coode.patterns.utils.Utils;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone Jun 10, 2008 */
public class PatternModel implements OPPLScript, PatternOPPLScript {
    private final static class PatternOPPLScriptValidator implements OPPLScriptValidator {
        public PatternOPPLScriptValidator() {}

        @Override
        public boolean accept(OPPLScript script) {
            boolean toReturn = script.getQuery() == null;
            if (toReturn) {
                List<OWLAxiomChange> actions = script.getActions();
                Iterator<OWLAxiomChange> it = actions.iterator();
                while (toReturn && it.hasNext()) {
                    toReturn = it.next().isAddAxiom();
                }
            }
            return toReturn;
        }

        @Override
        public String getValidationRuleDescription() {
            return "The Script can only have ADD as its actions and cannot have any query";
        }
    }

    class ClassPatternDetector extends OWLObjectVisitorExAdapter<Boolean> implements
            OWLAxiomVisitorEx<Boolean>, OPPLScriptVisitorEx<Boolean> {
        private final OWLClass thisClass = ontologyManager.getOWLDataFactory()
                .getOWLClass(getConstraintSystem().getThisClassVariable().getIRI());

        @Override
        protected Boolean getDefaultReturnValue(OWLObject object) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visit(OWLSubClassOfAxiom axiom) {
            return axiom.getSubClass().equals(thisClass);
        }

        @Override
        public Boolean visit(OWLDisjointClassesAxiom axiom) {
            return axiom.getClassExpressions().contains(thisClass);
        }

        @Override
        public Boolean visit(OWLEquivalentClassesAxiom axiom) {
            return axiom.getClassExpressions().contains(thisClass);
        }

        public Boolean visit(OPPLQuery q) {
            return Boolean.FALSE;
        }

        public Boolean visit(Variable<?> v) {
            return Boolean.FALSE;
        }

        public Boolean visitActions(List<OWLAxiomChange> changes) {
            boolean found = false;
            Iterator<OWLAxiomChange> it = changes.iterator();
            while (!found && it.hasNext()) {
                found = it.next().getAxiom().accept(this);
            }
            return found;
        }

        @Override
        public Boolean visit(OPPLQuery q, Boolean p) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visit(Variable<?> v, Boolean p) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visitActions(List<OWLAxiomChange> changes, Boolean p) {
            boolean found = false;
            Iterator<OWLAxiomChange> it = changes.iterator();
            while (!found && it.hasNext()) {
                found = it.next().getAxiom().accept(this);
            }
            return found;
        }
    }

    /** Extracts the definition
     * 
     * @author Luigi Iannone Jun 26, 2008 */
    static class DefinitorialExtractor extends OWLObjectVisitorExAdapter<OWLObject>
            implements OWLAxiomVisitorEx<OWLObject>,
            OPPLScriptVisitorEx<OWLClassExpression> {
        protected final Set<OWLClassExpression> extractedDescriptions = new HashSet<OWLClassExpression>();
        protected OWLPropertyExpression<?, ?> extractedProperty = null;
        protected OWLObject owlObject;
        protected OWLDataFactory dataFactory;
        private final VariableType<?> variableType;

        public OWLObject getExtractedObject() {
            OWLObject toReturn = null;
            toReturn = variableType.accept(new VariableTypeVisitorEx<OWLObject>() {
                @Override
                public OWLObject visitCLASSVariableType(
                        CLASSVariableType classVariableType) {
                    return dataFactory.getOWLObjectIntersectionOf(extractedDescriptions);
                }

                @Override
                public OWLObject visitOBJECTPROPERTYVariableType(
                        OBJECTPROPERTYVariableType objectpropertyVariableType) {
                    return extractedProperty;
                }

                @Override
                public OWLObject visitDATAPROPERTYVariableType(
                        DATAPROPERTYVariableType datapropertyVariableType) {
                    return extractedProperty;
                }

                @Override
                public OWLObject visitINDIVIDUALVariableType(
                        INDIVIDUALVariableType individualVariableType) {
                    throw new RuntimeException("Unsupported variable type: "
                            + individualVariableType
                            + " for pattern used in functional mode");
                }

                @Override
                public OWLObject visitCONSTANTVariableType(
                        CONSTANTVariableType constantVariableType) {
                    throw new RuntimeException("Unsupported variable type: "
                            + constantVariableType
                            + " for pattern used in functional mode");
                }

                @Override
                public OWLObject visitANNOTATIONPROPERTYVariableType(
                        ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                    throw new RuntimeException("Unsupported variable type: "
                            + annotationpropertyVariableType
                            + " for pattern used in functional mode");
                }
            });
            return toReturn;
        }

        /** @param owlObject
         * @param variableType
         * @param dataFactory */
        public DefinitorialExtractor(OWLObject owlObject, VariableType<?> variableType,
                OWLDataFactory dataFactory) {
            this.owlObject = owlObject;
            this.dataFactory = dataFactory;
            this.variableType = variableType;
        }

        @Override
        public OWLClassExpression visit(OWLEquivalentClassesAxiom axiom) {
            OWLClassExpression toReturn = null;
            if (variableType == VariableTypeFactory.getCLASSVariableType()) {
                Set<OWLClassExpression> descriptions = new HashSet<OWLClassExpression>(
                        axiom.getClassExpressions());
                descriptions.remove(owlObject);
                extractedDescriptions.addAll(descriptions);
                toReturn = !descriptions.isEmpty() ? descriptions.iterator().next()
                        : null;
            }
            return toReturn;
        }

        @Override
        public OWLObjectPropertyExpression
                visit(OWLEquivalentObjectPropertiesAxiom axiom) {
            OWLObjectPropertyExpression toReturn = null;
            if (variableType == VariableTypeFactory.getOBJECTPROPERTYTypeVariableType()) {
                Set<OWLObjectPropertyExpression> properties = new HashSet<OWLObjectPropertyExpression>(
                        axiom.getProperties());
                properties.remove(owlObject);
                toReturn = !properties.isEmpty() ? properties.iterator().next() : null;
                extractedProperty = toReturn;
            }
            return toReturn;
        }

        @Override
        public OWLDataPropertyExpression visit(OWLEquivalentDataPropertiesAxiom axiom) {
            OWLDataPropertyExpression toReturn = null;
            if (variableType == VariableTypeFactory.getDATAPROPERTYVariableType()) {
                Set<OWLDataPropertyExpression> properties = new HashSet<OWLDataPropertyExpression>(
                        axiom.getProperties());
                properties.remove(owlObject);
                toReturn = !properties.isEmpty() ? properties.iterator().next() : null;
                extractedProperty = toReturn;
            }
            return toReturn;
        }

        public OWLClassExpression visitActions(List<OWLAxiomChange> changes) {
            OWLClassExpression toReturn = null;
            for (OWLAxiomChange axiomChange : changes) {
                OWLAxiom axiom = axiomChange.getAxiom();
                OWLObject description = axiom.accept(this);
                toReturn = toReturn == null ? (OWLClassExpression) description
                        : dataFactory.getOWLObjectIntersectionOf(toReturn,
                                (OWLClassExpression) description);
            }
            return toReturn;
        }

        @Override
        public OWLClassExpression visit(OPPLQuery q, OWLClassExpression p) {
            return null;
        }

        @Override
        public OWLClassExpression visit(Variable<?> v, OWLClassExpression p) {
            return null;
        }

        @Override
        public OWLClassExpression visitActions(List<OWLAxiomChange> changes,
                OWLClassExpression p) {
            return this.visitActions(changes);
        }
    }

    static class ReplacementExtractor {
        public static List<List<Object>> permutations(List<List<Object>> elements) {
            return permutations(new ArrayList<Object>(), elements);
        }

        private static List<List<Object>> permutations(List<Object> path,
                List<List<Object>> elements) {
            List<List<Object>> toReturn = new ArrayList<List<Object>>();
            if (!elements.isEmpty()) {
                List<Object> elem = elements.iterator().next();
                elements.remove(elem);
                for (Object string : elem) {
                    List<Object> newPath = new ArrayList<Object>(path);
                    newPath.add(string);
                    toReturn.addAll(permutations(newPath, elements));
                }
            } else {
                return new ArrayList<List<Object>>(
                        Collections.singleton(new ArrayList<Object>(path)));
            }
            return toReturn;
        }
    }

    private final List<PatternOPPLScript> dependencies = new ArrayList<PatternOPPLScript>();
    private String rendering = null;
    private IRI iri = null;
    private final OPPLScript opplStatement;
    protected final OWLOntologyManager ontologyManager;
    private boolean valid = true;
    private final Set<PatternModelChangeListener> listeners = new HashSet<PatternModelChangeListener>();
    private Variable<?> returnVariable = null;
    /**
     * 
     */
    public final static String NAMESPACE = "http://www.co-ode.org/patterns#";
    private final AbstractPatternModelFactory factory;

    /** @return pattern model factory */
    public AbstractPatternModelFactory getPatternModelFactory() {
        return factory;
    }

    /** @return ontology manager */
    public OWLOntologyManager getOWLOntologyManager() {
        return ontologyManager;
    }

    /** @param opplScript
     * @param ontologyManager
     * @param f
     * @throws UnsuitableOPPLScriptException */
    public PatternModel(OPPLScript opplScript, OWLOntologyManager ontologyManager,
            AbstractPatternModelFactory f) throws UnsuitableOPPLScriptException {
        checkNotNull(opplScript, "OPPL script");
        if (!getScriptValidator().accept(opplScript)) {
            throw new UnsuitableOPPLScriptException(opplScript, getScriptValidator()
                    .getValidationRuleDescription());
        }
        opplStatement = opplScript;
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
        factory = f;
    }

    private final static OPPLScriptValidator SCRIPT_VALIDATOR = new PatternOPPLScriptValidator();

    @Override
    public List<Variable<?>> getVariables() {
        List<Variable<?>> toReturn = new ArrayList<Variable<?>>();
        if (opplStatement != null) {
            toReturn = opplStatement.getVariables();
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String r = rendering == null ? "" : rendering;
        return String.format("%s %s", opplStatement, r).trim();
    }

    /** @return the string rendering of this PatternModel. Override/use this
     *         method in tools like Protege that have different strategies to
     *         render OWL objects */
    @Override
    public String render() {
        StringBuffer buffer = new StringBuffer(getOpplStatement().render());
        buffer.append('\n');
        if (getRendering() != null) {
            buffer.append(getRendering());
        }
        Variable<?> v = getReturnVariable();
        if (v != null) {
            buffer.append(";\n RETURN ");
            buffer.append(getConstraintSystem().render(v));
        }
        return buffer.toString();
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return render();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        String r = rendering == null ? "" : rendering;
        return String.format("%s %s", opplStatement.render(shortFormProvider), r).trim();
    }

    @Override
    public String getRendering() {
        return rendering;
    }

    /** @param rendering
     *            the rendering to set */
    public void setRendering(String rendering) {
        this.rendering = rendering;
        StringTokenizer tokenizer = new StringTokenizer(rendering, " \n\t\r\f");
        boolean foundUndefinedVariable = false;
        while (!foundUndefinedVariable && tokenizer.hasMoreTokens()) {
            String nextToken = tokenizer.nextToken();
            if (nextToken.startsWith("?")) {
                boolean found = false;
                Iterator<Variable<?>> it = getVariables().iterator();
                while (!found && it.hasNext()) {
                    Variable<?> variable = it.next();
                    found = variable.getName().equals(nextToken.trim());
                }
                foundUndefinedVariable = !found;
            }
        }
        valid = !foundUndefinedVariable;
    }

    /** @return the valid */
    public boolean isValid() {
        return valid;
    }

    /** @param l */
    public void addChangeListener(PatternModelChangeListener l) {
        listeners.add(l);
    }

    /** @param l */
    public void removeChangeListener(PatternModelChangeListener l) {
        listeners.remove(l);
    }

    @Override
    public IRI getIRI() {
        return iri;
    }

    @Override
    public void setIRI(IRI iri) {
        this.iri = iri;
    }

    /** @return the opplStatement */
    public OPPLScript getOpplStatement() {
        return opplStatement;
    }

    /** @return pattern local name */
    public String getPatternLocalName() {
        String toReturn = null;
        if (iri != null) {
            toReturn = iri.getFragment();
        }
        return toReturn;
    }

    @Override
    public PatternConstraintSystem getConstraintSystem() {
        return opplStatement == null ? factory.createConstraintSystem()
                : (PatternConstraintSystem) opplStatement.getConstraintSystem();
    }

    private boolean hasValuesFor(Collection<? extends Variable<?>> variables,
            BindingNode bindingNode, ValueComputationParameters parameters) {
        boolean found = false;
        Iterator<? extends Variable<?>> iterator = variables.iterator();
        while (!found && iterator.hasNext()) {
            Variable<?> variable = iterator.next();
            found = bindingNode.getAssignmentValue(variable, parameters) != null;
        }
        return found;
    }

    @Override
    public OWLObject getDefinitorialPortion(
            Collection<? extends BindingNode> bindingNodes,
            RuntimeExceptionHandler runtimeExceptionHandler) throws PatternException {
        DefinitorialExtractor extractor = createDefinitorialExtractor(getReturnVariable());
        getConstraintSystem().setLeaves(new HashSet<BindingNode>(bindingNodes));
        for (BindingNode bindingNode : bindingNodes) {
            SimpleValueComputationParameters parameters = new SimpleValueComputationParameters(
                    getConstraintSystem(), bindingNode, runtimeExceptionHandler);
            PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
                    parameters);
            ConstraintSystem newConstraintSystem = getConstraintSystem().getOPPLFactory()
                    .createConstraintSystem();
            for (Variable<?> v : bindingNode.getAssignedVariables()) {
                newConstraintSystem.importVariable(v);
            }
            VariableExtractor variableExtractor = new VariableExtractor(
                    newConstraintSystem, false);
            for (OWLAxiomChange owlAxiomChange : getActions()) {
                OWLObject instantiatedAxiom = owlAxiomChange.getAxiom().accept(
                        instantiator);
                Set<Variable<?>> remainingVariables = variableExtractor
                        .extractVariables(instantiatedAxiom);
                boolean instantiate = !remainingVariables.isEmpty()
                        && hasValuesFor(remainingVariables, bindingNode, parameters);
                instantiator = new PartialOWLObjectInstantiator(
                        new SimpleValueComputationParameters(newConstraintSystem,
                                bindingNode, runtimeExceptionHandler));
                while (instantiate) {
                    instantiatedAxiom = instantiatedAxiom.accept(instantiator);
                    remainingVariables = variableExtractor
                            .extractVariables(instantiatedAxiom);
                    instantiate = !remainingVariables.isEmpty()
                            && hasValuesFor(remainingVariables, bindingNode, parameters);
                }
                instantiatedAxiom.accept(extractor);
            }
        }
        getConstraintSystem().setLeaves(null);
        OWLObject extractedObject = extractor.getExtractedObject();
        return extractedObject;
    }

    private DefinitorialExtractor createDefinitorialExtractor(final Variable<?> variable) {
        final OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
        OWLObject owlObject = null;
        VariableTypeVisitorEx<OWLObject> visitor = new VariableTypeVisitorEx<OWLObject>() {
            @Override
            public OWLObject visitINDIVIDUALVariableType(INDIVIDUALVariableType t) {
                throw new RuntimeException("Unsupported variable type: "
                        + variable.getType() + " for pattern used in functional mode");
            }

            @Override
            public OWLObject visitDATAPROPERTYVariableType(DATAPROPERTYVariableType t) {
                return dataFactory.getOWLDataProperty(variable.getIRI());
            }

            @Override
            public OWLObject
                    visitOBJECTPROPERTYVariableType(OBJECTPROPERTYVariableType t) {
                return dataFactory.getOWLObjectProperty(variable.getIRI());
            }

            @Override
            public OWLObject visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                return dataFactory.getOWLAnnotationProperty(variable.getIRI());
            }

            @Override
            public OWLObject visitCONSTANTVariableType(CONSTANTVariableType t) {
                throw new RuntimeException("Unsupported variable type: "
                        + variable.getType() + " for pattern used in functional mode");
            }

            @Override
            public OWLObject visitCLASSVariableType(CLASSVariableType v) {
                return dataFactory.getOWLClass(variable.getIRI());
            }
        };
        owlObject = variable.getType().accept(visitor);
        return new DefinitorialExtractor(owlObject, variable.getType(), dataFactory);
    }

    /** @param patternModel
     * @return true if this PatternModel instance depends on the input one,
     *         false otherwise */
    @Override
    public boolean dependsOn(PatternOPPLScript patternModel) {
        boolean toReturn = isDependent();
        if (toReturn) {
            toReturn = false;
            Iterator<PatternOPPLScript> it = dependencies.iterator();
            while (!toReturn && it.hasNext()) {
                PatternOPPLScript aPatternModel = it.next();
                toReturn = aPatternModel.getName().equals(patternModel.getName())
                        || aPatternModel.dependsOn(patternModel);
            }
        }
        return toReturn;
    }

    /** @return true if there are dependencies */
    public boolean isDependent() {
        return !dependencies.isEmpty();
    }

    /** @param ontologies
     * @param errorListener
     * @return the set of PatternModel instances that depend on this. Please
     *         notice that InstantiatedPatternModel instances will be returned
     *         as well */
    public Set<PatternOPPLScript> getDependingPatterns(Set<OWLOntology> ontologies,
            ErrorListener errorListener) {
        Set<PatternOPPLScript> toReturn = new HashSet<PatternOPPLScript>();
        for (OWLOntology ontology : ontologies) {
            Set<PatternModel> existingPatterns = Utils.getExistingPatterns(ontology,
                    factory);
            for (PatternModel patternModel : existingPatterns) {
                if (patternModel.dependsOn(this)) {
                    toReturn.add(patternModel);
                    toReturn.addAll(patternModel.getInstantiations(errorListener));
                }
            }
        }
        toReturn.addAll(getInstantiations(errorListener));
        return toReturn;
    }

    /** @param errorListener
     * @return instantiations */
    public Set<InstantiatedPatternModel> getInstantiations(ErrorListener errorListener) {
        Set<InstantiatedPatternModel> toReturn = new HashSet<InstantiatedPatternModel>();
        Set<OWLOntology> ontologies = ontologyManager.getOntologies();
        PatternExtractor patternExtractor = factory.getPatternExtractor(errorListener);
        for (OWLOntology ontology : ontologies) {
            Set<OWLClass> referencedClasses = ontology.getClassesInSignature();
            for (OWLClass owlClass : referencedClasses) {
                Set<OWLAnnotationAssertionAxiom> annotationAxioms = owlClass
                        .getAnnotationAssertionAxioms(ontology);
                for (OWLAnnotationAssertionAxiom annotationAxiom : annotationAxioms) {
                    OPPLScript extractedPatternModel = annotationAxiom.getAnnotation()
                            .accept(patternExtractor);
                    if (extractedPatternModel != null
                            && extractedPatternModel instanceof InstantiatedPatternModel
                            && ((InstantiatedPatternModel) extractedPatternModel)
                                    .getInstantiatedPatternLocalName().equals(
                                            getPatternLocalName())) {
                        toReturn.add((InstantiatedPatternModel) extractedPatternModel);
                    }
                }
            }
        }
        return toReturn;
    }

    @Override
    public Set<OWLObject>
            getOWLObjects(OWLOntology ontology, ErrorListener errorListener) {
        Set<OWLObject> toReturn = new HashSet<OWLObject>();
        boolean found = false;
        OWLAnnotation ontologyAnnotation = null;
        Iterator<OWLAnnotation> annotationIterator = ontology.getAnnotations().iterator();
        while (!found && annotationIterator.hasNext()) {
            ontologyAnnotation = annotationIterator.next();
            found = iri.equals(ontologyAnnotation.getProperty().getIRI());
        }
        if (found) {
            toReturn.add(ontologyAnnotation);
        }
        return toReturn;
    }

    /** @return originating ontology */
    public OWLOntology getOriginatingOntology() {
        OWLOntology toReturn = null;
        Set<OWLOntology> ontologies = ontologyManager.getOntologies();
        boolean found = false;
        Iterator<OWLOntology> it = ontologies.iterator();
        OWLOntology ontology = null;
        OWLAnnotation ontologyAnnotation = null;
        while (!found && it.hasNext()) {
            ontology = it.next();
            Iterator<OWLAnnotation> annotationIterator = ontology.getAnnotations()
                    .iterator();
            while (!found && annotationIterator.hasNext()) {
                ontologyAnnotation = annotationIterator.next();
                found = iri.equals(ontologyAnnotation.getProperty().getIRI());
            }
        }
        if (found) {
            toReturn = ontology;
        }
        return toReturn;
    }

    /** Sets the return variable
     * 
     * @param returnVariable */
    public void setReturnVariable(Variable<?> returnVariable) {
        this.returnVariable = returnVariable;
    }

    /** @return the returnVariable */
    public Variable<?> getReturnVariable() {
        return returnVariable;
    }

    /** @return true if the patterns returns a value, false otherwise */
    public boolean isFunctional() {
        return returnVariable != null;
    }

    /** @return true if the pattern is applicable to OWL classes (must edit the
     *         semantics of the class it applies to), false otherwise */
    @Override
    public boolean isClassPattern() {
        ClassPatternDetector classPatternDetector = new ClassPatternDetector();
        return this.accept(classPatternDetector);
    }

    @Override
    public String getName() {
        return getPatternLocalName();
    }

    @Override
    public void addDependency(PatternOPPLScript dependency) {
        dependencies.add(dependency);
    }

    @Override
    public List<InputVariable<?>> getInputVariables() {
        return getOpplStatement().getInputVariables();
    }

    @Override
    public boolean hasScopedVariables() {
        List<Variable<?>> variables = getVariables();
        Iterator<Variable<?>> it = variables.iterator();
        boolean found = false;
        while (!found && it.hasNext()) {
            Variable<?> v = it.next();
            found = v.accept(new VariableVisitorEx<Boolean>() {
                @Override
                public <P extends OWLObject> Boolean visit(GeneratedVariable<P> gv) {
                    return Boolean.FALSE;
                }

                @Override
                public <P extends OWLObject> Boolean visit(InputVariable<P> iv) {
                    return iv.getVariableScope() != null;
                }

                @Override
                public <P extends OWLObject> Boolean visit(
                        RegexpGeneratedVariable<P> regExpGenerated) {
                    return Boolean.FALSE;
                }
            });
        }
        return found;
    }

    @Override
    public void accept(OPPLScriptVisitor visitor) {
        getOpplStatement().accept(visitor);
    }

    @Override
    public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
        return getOpplStatement().accept(visitor);
    }

    @Override
    public List<OWLAxiomChange> getActions() {
        return getOpplStatement().getActions();
    }

    @Override
    public OPPLQuery getQuery() {
        return getOpplStatement().getQuery();
    }

    @Override
    @Deprecated
    public void addVariable(Variable<?> variable) {
        if (opplStatement != null) {
            opplStatement.addVariable(variable);
        }
    }

    /** @return the scriptValidator */
    public static final OPPLScriptValidator getScriptValidator() {
        return SCRIPT_VALIDATOR;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (opplStatement == null ? 0 : opplStatement.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        PatternModel other = (PatternModel) obj;
        if (opplStatement == null) {
            if (other.opplStatement != null) {
                return false;
            }
        } else if (!opplStatement.equals(other.opplStatement)) {
            return false;
        }
        return true;
    }
}
