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
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.LeafBrusher;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.Create;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.IRIVariableAttribute;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.OPPLFunctionVisitor;
import org.coode.oppl.function.OPPLFunctionVisitorEx;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ToLowerCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ToUpperCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone Jun 25, 2008
 * @param <O>
 *            type */
public class PatternReference<O extends OWLObject> implements OPPLFunction<O> {
    private String patternName;
    private final PatternConstraintSystem patternConstraintSystem;
    private boolean resolvable;
    private final Set<String> visited = new HashSet<String>();
    private List<Object>[] arguments;
    private PatternModel extractedPattern;
    protected final ErrorListener errorListener;
    protected final RuntimeExceptionHandler runtimeExceptionHandler = new RuntimeExceptionHandler() {
        @Override
        public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
            PatternReference.this.errorListener.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleOWLRuntimeException(OWLRuntimeException e) {
            PatternReference.this.errorListener.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleException(RuntimeException e) {
            PatternReference.this.errorListener.reportThrowable(e, 0, 0, 0);
        }
    };

    /** @param patternName
     *            patternName
     * @param constraintSystem
     *            constraintSystem
     * @param errorListener
     *            errorListener
     * @param args
     *            args
     * @throws PatternException
     *             PatternException */
    public PatternReference(String patternName, PatternConstraintSystem constraintSystem,
            ErrorListener errorListener, List<Object>... args) throws PatternException {
        this(patternName, constraintSystem, Collections.<String> emptySet(),
                errorListener, args);
    }

    /** @param patternName
     *            patternName
     * @param constraintSystem
     *            constraintSystem
     * @param visitedPatterns
     *            visitedPatterns
     * @param errorListener
     *            errorListener
     * @param args
     *            args
     * @throws PatternException
     *             PatternException */
    public PatternReference(String patternName, PatternConstraintSystem constraintSystem,
            Collection<? extends String> visitedPatterns, ErrorListener errorListener,
            List<Object>... args) throws PatternException {
        this.patternName = checkNotNull(patternName, "patternName");
        this.errorListener = checkNotNull(errorListener, "errorListener");
        this.patternName = patternName;
        this.patternConstraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.visited.addAll(checkNotNull(visitedPatterns, "visitedPatterns"));
        this.init(args);
    }

    protected void init(List<Object>... args) throws PatternException {
        Set<OWLOntology> ontologies = this.getConstraintSystem().getOntologyManager()
                .getOntologies();
        Iterator<OWLOntology> ontologyIterator = ontologies.iterator();
        boolean found = false;
        OWLOntology anOntology;
        this.extractedPattern = null;
        // first check whether a pattern with that name is present
        while (!found && ontologyIterator.hasNext()) {
            anOntology = ontologyIterator.next();
            Set<OWLAnnotation> ontologyAnnotationAxioms = anOntology.getAnnotations();
            Iterator<OWLAnnotation> it = ontologyAnnotationAxioms.iterator();
            while (!found && it.hasNext()) {
                OWLAnnotation annotation = it.next();
                OWLAnnotationProperty p = annotation.getProperty();
                if (!this.hasBeenVisited(p)
                        && this.patternName.equals(p.getIRI().getFragment())) {
                    PatternExtractor patternExtractor = this.patternConstraintSystem
                            .getPatternModelFactory()
                            .getPatternExtractor(this.getVisitedAnnotations(),
                                    this.getErrorListener());
                    this.extractedPattern = (PatternModel) annotation
                            .accept(patternExtractor);
                    found = this.extractedPattern != null;
                }
            }
        }
        if (!found) {
            throw new PatternReferenceNotFoundException(this.patternName);
        }
        // Now check its variable compatibility
        this.checkCompatibility(args);
        this.resolvable = this.isResolvable(args);
        this.arguments = args;
    }

    /** @param args
     *            args
     * @return replacements */
    protected List<List<Object>> computeReplacements(List<Object>... args) {
        List<List<Object>> replacements = new ArrayList<List<Object>>();
        for (List<Object> iThAssignments : args) {
            List<Object> iThReplacement = new ArrayList<Object>();
            for (Object iThAssignment : iThAssignments) {
                iThReplacement.add(iThAssignment);
            }
            replacements.add(iThReplacement);
        }
        return replacements;
    }

    /** @param args
     *            args
     * @return true if resolvable */
    protected boolean isResolvable(List<Object>... args) {
        boolean isResolvable = true;
        for (int i = 0; i < args.length && isResolvable; i++) {
            List<Object> iThArgumentAssignments = args[i];
            Iterator<Object> it = iThArgumentAssignments.iterator();
            Object anIthAssignment;
            while (it.hasNext() && isResolvable) {
                anIthAssignment = it.next();
                isResolvable = anIthAssignment instanceof OWLObject;
            }
        }
        return isResolvable;
    }

    /** @param args
     *            args
     * @throws PatternException
     *             PatternException
     * @throws IncompatibleArgumentException
     *             IncompatibleArgumentException
     * @throws InvalidNumebrOfArgumentException
     *             InvalidNumebrOfArgumentException */
    protected void checkCompatibility(List<Object>... args) throws PatternException,
            IncompatibleArgumentException, InvalidNumebrOfArgumentException {
        boolean compatible = true;
        List<InputVariable<?>> variables = this.extractedPattern.getInputVariables();
        if (variables.size() == args.length) {
            for (int i = 0; i < args.length; i++) {
                List<Object> iThArgAssignements = args[i];
                for (Object anIthAssignment : iThArgAssignements) {
                    InputVariable<?> variable = this.getExtractedPattern()
                            .getInputVariables().get(i);
                    if (anIthAssignment instanceof Variable<?>) {
                        compatible = ((Variable<?>) anIthAssignment).getType().equals(
                                variable.getType());
                    } else {
                        compatible = anIthAssignment instanceof OWLObject
                                && variable.getType().isCompatibleWith(
                                        (OWLObject) anIthAssignment)
                                || anIthAssignment instanceof Aggregandum<?>
                                && ((Aggregandum<?>) anIthAssignment)
                                        .isCompatible(variable.getType());
                    }
                    if (!compatible) {
                        throw new IncompatibleArgumentException(anIthAssignment, variable);
                    }
                }
            }
        } else {
            throw new InvalidNumebrOfArgumentException(this.patternName, args.length,
                    variables.size());
        }
    }

    /** @return the resolvable */
    public boolean isResolvable() {
        return this.resolvable;
    }

    /** @return the resolution
     * @throws PatternException
     *             PatternException */
    public List<OWLObject> getResolution() throws PatternException {
        Map<Variable<?>, Set<OWLObject>> bindings = this.getBindingsMap();
        // Will use the leaf brusher to compute the binding nodes and when the
        // replacement is a variable will create an OWLObject corresponding to
        // it.
        LeafBrusher leafBrusher = new LeafBrusher(bindings);
        BindingNode root = new BindingNode(bindings.keySet());
        root.accept(leafBrusher);
        final Set<BindingNode> leaves = leafBrusher.getLeaves();
        List<OWLObject> toReturn = new ArrayList<OWLObject>(leaves.size());
        for (BindingNode bindingNode : leaves) {
            toReturn.add(this.getExtractedPattern().getDefinitorialPortion(
                    Collections.singleton(bindingNode), this.runtimeExceptionHandler));
        }
        return toReturn;
    }

    /** @return bindings map */
    private Map<Variable<?>, Set<OWLObject>> getBindingsMap() {
        Map<Variable<?>, Set<OWLObject>> bindings = new HashMap<Variable<?>, Set<OWLObject>>();
        List<List<Object>> replacements = this.computeReplacements(this.getArguments());
        for (int i = 0; i < replacements.size(); i++) {
            List<Object> values = replacements.get(i);
            final InputVariable<?> variable = this.getExtractedPattern()
                    .getInputVariables().get(i);
            final Set<OWLObject> set = new HashSet<OWLObject>(values.size());
            bindings.put(variable, set);
            for (Object object : values) {
                if (object instanceof OWLObject) {
                    set.add((OWLObject) object);
                } else if (object instanceof Variable<?>) {
                    final OWLDataFactory dataFactory = this.getConstraintSystem()
                            .getOntologyManager().getOWLDataFactory();
                    final Variable<?> v = (Variable<?>) object;
                    set.add(v.getType().accept(new VariableTypeVisitorEx<OWLObject>() {
                        @Override
                        public OWLObject visitCLASSVariableType(
                                CLASSVariableType classVariableType) {
                            return dataFactory.getOWLClass(v.getIRI());
                        }

                        @Override
                        public OWLObject visitOBJECTPROPERTYVariableType(
                                OBJECTPROPERTYVariableType objectpropertyVariableType) {
                            return dataFactory.getOWLObjectProperty(v.getIRI());
                        }

                        @Override
                        public OWLObject visitDATAPROPERTYVariableType(
                                DATAPROPERTYVariableType datapropertyVariableType) {
                            return dataFactory.getOWLDataProperty(v.getIRI());
                        }

                        @Override
                        public OWLObject visitINDIVIDUALVariableType(
                                INDIVIDUALVariableType individualVariableType) {
                            return dataFactory.getOWLNamedIndividual(v.getIRI());
                        }

                        @Override
                        public OWLObject visitCONSTANTVariableType(
                                CONSTANTVariableType constantVariableType) {
                            return dataFactory.getOWLLiteral(v.getIRI().toString());
                        }

                        @Override
                        public
                                OWLObject
                                visitANNOTATIONPROPERTYVariableType(
                                        ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                            return dataFactory.getOWLAnnotationProperty(v.getIRI());
                        }
                    }));
                } else if (object instanceof Aggregandum<?>) {
                    Set<?> opplFunctions = ((Aggregandum<?>) object).getOPPLFunctions();
                    final ValueComputationParameters parameters = new SimpleValueComputationParameters(
                            this.getConstraintSystem(),
                            BindingNode.createNewEmptyBindingNode(),
                            this.runtimeExceptionHandler);
                    for (Object o : opplFunctions) {
                        ((OPPLFunction<?>) o).accept(new OPPLFunctionVisitor() {
                            @Override
                            public
                                    <P extends OWLObject>
                                    void
                                    visitValuesVariableAtttribute(
                                            ValuesVariableAtttribute<P> valuesVariableAtttribute) {
                                if (variable.getType() == valuesVariableAtttribute
                                        .getVariable().getType()) {
                                    Collection<? extends P> computedValues = valuesVariableAtttribute
                                            .compute(parameters);
                                    set.addAll(computedValues);
                                } else {
                                    PatternReference.this.runtimeExceptionHandler
                                            .handleException(new IncompatibleArgumentException(
                                                    valuesVariableAtttribute.render(PatternReference.this
                                                            .getConstraintSystem()),
                                                    variable));
                                }
                            }

                            @Override
                            public
                                    void
                                    visitRenderingVariableAttribute(
                                            RenderingVariableAttribute renderingVariableAttribute) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                renderingVariableAttribute
                                                        .render(PatternReference.this
                                                                .getConstraintSystem()),
                                                variable));
                            }

                            @Override
                            public void visitIRIVariableAttribute(
                                    IRIVariableAttribute iriVariableAttribute) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                iriVariableAttribute
                                                        .render(PatternReference.this
                                                                .getConstraintSystem()),
                                                variable));
                            }

                            @Override
                            public
                                    <P extends OWLObject>
                                    void
                                    visitGroupVariableAttribute(
                                            GroupVariableAttribute<P> groupVariableAttribute) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                groupVariableAttribute
                                                        .render(PatternReference.this
                                                                .getConstraintSystem()),
                                                variable));
                            }

                            @Override
                            public <P extends OWLObject> void visitGenericOPPLFunction(
                                    OPPLFunction<P> opplFunction) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                opplFunction.render(PatternReference.this
                                                        .getConstraintSystem()), variable));
                            }

                            @Override
                            public <P extends OWLObject> void visitExpression(
                                    Expression<P> expression) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                expression.render(PatternReference.this
                                                        .getConstraintSystem()), variable));
                            }

                            @Override
                            public <P, I extends OPPLFunction<?>> void visitCreate(
                                    Create<I, P> create) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                create.render(PatternReference.this
                                                        .getConstraintSystem()), variable));
                            }

                            @Override
                            public
                                    void
                                    visitToLowerCaseStringManipulationOPPLFunction(
                                            ToLowerCaseStringManipulationOPPLFunction toLowerCaseStringManipulationOPPLFunction) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                toLowerCaseStringManipulationOPPLFunction
                                                        .render(PatternReference.this
                                                                .getConstraintSystem()),
                                                variable));
                            }

                            @Override
                            public
                                    void
                                    visitToUpperCaseStringManipulationOPPLFunction(
                                            ToUpperCaseStringManipulationOPPLFunction upperCaseStringManipulationOPPLFunction) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                upperCaseStringManipulationOPPLFunction
                                                        .render(PatternReference.this
                                                                .getConstraintSystem()),
                                                variable));
                            }

                            @Override
                            public <P> void visitConstant(Constant<P> constant) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                constant.render(PatternReference.this
                                                        .getConstraintSystem()), variable));
                            }

                            @Override
                            public <P, I> void visitAggregation(
                                    Aggregation<P, I> aggregation) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                aggregation.render(PatternReference.this
                                                        .getConstraintSystem()), variable));
                            }

                            @Override
                            public <K extends OWLObject> void visitInlineSet(
                                    InlineSet<K> inlineSet) {
                                PatternReference.this.runtimeExceptionHandler
                                        .handleException(new IncompatibleArgumentException(
                                                inlineSet.render(PatternReference.this
                                                        .getConstraintSystem()), variable));
                            }
                        });
                    }
                }
            }
        }
        return bindings;
    }

    protected boolean hasBeenVisited(OWLEntity e) {
        boolean found = false;
        if (PatternModel.NAMESPACE.equals(e.getIRI().getNamespace())) {
            found = this.visited.contains(e.getIRI().getFragment());
        }
        return found;
    }

    protected Set<OWLAnnotation> getVisitedAnnotations() {
        Set<OWLAnnotation> toReturn = new HashSet<OWLAnnotation>();
        for (String visitedPatternName : this.visited) {
            Iterator<OWLOntology> it = this.getConstraintSystem().getOntologyManager()
                    .getOntologies().iterator();
            boolean found = false;
            OWLOntology ontology;
            while (!found && it.hasNext()) {
                ontology = it.next();
                Iterator<OWLAnnotation> annotationIterator = ontology.getAnnotations()
                        .iterator();
                OWLAnnotation anOntologyAnnotation = null;
                while (!found && annotationIterator.hasNext()) {
                    anOntologyAnnotation = annotationIterator.next();
                    found = anOntologyAnnotation
                            .getProperty()
                            .getIRI()
                            .equals(IRI.create(PatternModel.NAMESPACE
                                    + visitedPatternName));
                    if (found) {
                        toReturn.add(anOntologyAnnotation);
                    }
                }
            }
        }
        return toReturn;
    }

    /** @param handler
     *            handler
     * @return instantiation
     * @throws PatternException
     *             PatternException */
    public InstantiatedPatternModel getInstantiation(RuntimeExceptionHandler handler)
            throws PatternException {
        if (this.isResolvable()) {
            InstantiatedPatternModel toReturn = null;
            toReturn = this.getExtractedPattern().getPatternModelFactory()
                    .createInstantiatedPatternModel(this.getExtractedPattern(), handler);
            List<List<Object>> replacements = this.computeReplacements(this.arguments);
            int i = 0;
            for (Variable<?> variable : toReturn.getInputVariables()) {
                List<Object> variableReplacements = replacements.get(i);
                for (Object object : variableReplacements) {
                    if (object instanceof OWLObject) {
                        toReturn.instantiate(variable, (OWLObject) object);
                    }
                }
                i++;
            }
            return toReturn;
        } else {
            throw new NonResovableArgumentsException(this.patternName, this.arguments);
        }
    }

    /** @return the extractedPattern */
    public PatternModel getExtractedPattern() {
        return this.extractedPattern;
    }

    @Override
    public String toString() {
        return this.render(this.getConstraintSystem());
    }

    /** @return pattern name */
    public String getPatternName() {
        return this.patternName;
    }

    /** @return the arguments */
    public List<Object>[] getArguments() {
        return this.arguments;
    }

    /** @return the patternConstraintSystem */
    public PatternConstraintSystem getConstraintSystem() {
        return this.patternConstraintSystem;
    }

    /** @return the patternConstraintSystem */
    public PatternConstraintSystem getPatternConstraintSystem() {
        return this.patternConstraintSystem;
    }

    /** @return the errorListener */
    public ErrorListener getErrorListener() {
        return this.errorListener;
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("$%s(", this.getPatternName()));
        for (List<Object> args : this.getArguments()) {
            String openingBrace = args.size() > 1 ? "{" : "";
            String closingBrace = args.size() > 1 ? "}" : "";
            builder.append(openingBrace);
            Iterator<Object> iterator = args.iterator();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (object instanceof OWLObject) {
                    OWLObject owlObject = (OWLObject) object;
                    ManchesterSyntaxRenderer renderer = this.getConstraintSystem()
                            .getOPPLFactory()
                            .getManchesterSyntaxRenderer(this.getConstraintSystem());
                    owlObject.accept(renderer);
                    builder.append(renderer.toString());
                } else if (object instanceof Variable<?>) {
                    builder.append(((Variable<?>) object).getName());
                } else {
                    builder.append(((Aggregandum<?>) object).render(constraintSystem));
                }
                if (iterator.hasNext()) {
                    builder.append(", ");
                }
            }
            builder.append(closingBrace);
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("$%s(", this.getPatternName()));
        for (List<Object> args : this.getArguments()) {
            String openingBrace = args.size() > 1 ? "{" : "";
            String closingBrace = args.size() > 1 ? "}" : "";
            builder.append(openingBrace);
            Iterator<Object> iterator = args.iterator();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (object instanceof OWLObject) {
                    OWLObject owlObject = (OWLObject) object;
                    ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(
                            shortFormProvider);
                    owlObject.accept(renderer);
                    builder.append(renderer.toString());
                } else if (object instanceof Variable<?>) {
                    builder.append(((Variable<?>) object).getName());
                } else {
                    builder.append(((Aggregandum<?>) object).render(shortFormProvider));
                }
                if (iterator.hasNext()) {
                    builder.append(", ");
                }
            }
            builder.append(closingBrace);
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public O compute(ValueComputationParameters params) {
        try {
            Map<Variable<?>, Set<OWLObject>> bindingsMap = this.getBindingsMap();
            LeafBrusher leafBrusher = new LeafBrusher(bindingsMap);
            BindingNode root = new BindingNode(params.getBindingNode().getAssignments(),
                    bindingsMap.keySet());
            root.accept(leafBrusher);
            Set<BindingNode> leaves = leafBrusher.getLeaves();
            return (O) this.getExtractedPattern().getDefinitorialPortion(leaves,
                    this.runtimeExceptionHandler);
        } catch (PatternException e) {
            params.getRuntimeExceptionHandler().handleException(e);
        }
        return null;
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitGenericOPPLFunction(this);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitGenericOPPLFunction(this);
    }
}
