package org.coode.oppl.function.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.datafactory.OPPLOWLDataFactory;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.Adapter;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.IRIVariableAttribute;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.search.AssignableValueExtractor;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

@SuppressWarnings("javadoc")
public class OPPLFunctionTest {

    private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();
    OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

    @Test
    public void shouldTestRendering() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(x);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
        bindingNode.addAssignment(new Assignment(x, a));
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        String value = renderingVariableAttribute.compute(parameters);
        ManchesterSyntaxRenderer renderer = factory.getManchesterSyntaxRenderer(constraintSystem);
        a.accept(renderer);
        assertTrue(value.compareTo(renderer.toString()) == 0);
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestVariableIRI() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        IRIVariableAttribute iriVariableAttribute = new IRIVariableAttribute(x);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
        bindingNode.addAssignment(new Assignment(x, a));
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        IRI value = iriVariableAttribute.compute(parameters);
        assertTrue(value.equals(a.getIRI()));
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestExpressionValues() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        Variable<OWLClassExpression> y =
            constraintSystem.createVariable("?y", VariableTypeFactory.getCLASSVariableType(), null);
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI.create("blah#p"));
        Expression<OWLClassExpression> expressionOPPLFunction =
            new Expression<>(dataFactory.getOWLObjectIntersectionOf(
                dataFactory.getOWLObjectSomeValuesFrom(p, dataFactory.getOWLClass(x.getIRI())),
                dataFactory.getOWLObjectIntersectionOf(dataFactory.getOWLObjectSomeValuesFrom(p,
                    dataFactory.getOWLClass(y.getIRI())))));
        GeneratedVariable<OWLClassExpression> expression = GeneratedVariable.getGeneratedVariable(
            "?expression", VariableTypeFactory.getCLASSVariableType(), expressionOPPLFunction);
        ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute =
            ValuesVariableAtttribute.getValuesVariableAtttribute(expression);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        OWLClass a = dataFactory.getOWLClass(IRI.create("blah#a"));
        OWLClass b = dataFactory.getOWLClass(IRI.create("blah#b"));
        BindingNode aBindingNode = new BindingNode(new Assignment(x, a), new Assignment(y, b));
        OWLClass c = dataFactory.getOWLClass(IRI.create("blah#c"));
        OWLClass d = dataFactory.getOWLClass(IRI.create("blah#d"));
        BindingNode anotherBindingNode =
            new BindingNode(new Assignment(x, c), new Assignment(y, d));
        constraintSystem.setLeaves(new HashSet<>(Arrays.asList(aBindingNode, anotherBindingNode)));
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        Collection<? extends OWLClassExpression> values =
            valuesVariableAtttribute.compute(parameters);
        assertTrue(values.size() == 2);
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestValues() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute =
            ValuesVariableAtttribute.getValuesVariableAtttribute(x);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
        OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#b"));
        BindingNode aBindingNode = new BindingNode(new Assignment(x, a));
        BindingNode anotherBindingNode = new BindingNode(new Assignment(x, b));
        constraintSystem.setLeaves(new HashSet<>(Arrays.asList(aBindingNode, anotherBindingNode)));
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        Collection<? extends OWLClassExpression> values =
            valuesVariableAtttribute.compute(parameters);
        assertTrue(values.containsAll(Arrays.asList(a, b)));
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestValuesNoValues() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute =
            ValuesVariableAtttribute.getValuesVariableAtttribute(x);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        Collection<? extends OWLClassExpression> values =
            valuesVariableAtttribute.compute(parameters);
        assertNull(values);
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestGroupValue() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#monica"));
        OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#luigi"));
        manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(a));
        manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(b));
        RegexpGeneratedVariable<OWLClassExpression> x =
            new RegexpGeneratedVariable<>("?x", VariableTypeFactory.getCLASSVariableType(),
                Adapter.buildRegexpPatternAdapter(new Constant<>("(lu)igi")));
        GroupVariableAttribute<OWLClassExpression> groupVariableAttribute =
            GroupVariableAttribute.getGroupVariableAttribute(x, 1);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        bindingNode.addAssignment(new Assignment(x, b));
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        String value = groupVariableAttribute.compute(parameters);
        assertTrue(value.compareTo("lu") == 0);
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestRenderingNoValue() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(x);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        String value = renderingVariableAttribute.compute(parameters);
        assertNull(value);
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestCreateIntersection() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        OWLClassExpression a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#monica"));
        OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#luigi"));
        Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>> classExpressionIntersection =
            Aggregation.buildClassExpressionIntersection(
                Adapter.buildOWLObjectCollectionAdapter(Arrays.asList(a, b)),
                manager.getOWLDataFactory());
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        OWLClassExpression value = classExpressionIntersection.compute(parameters);
        assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b)));
        // Variable values
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        BindingNode aBindingNode = new BindingNode(new Assignment(x, a));
        BindingNode anotherBindingNode = new BindingNode(new Assignment(x, b));
        constraintSystem.setLeaves(new HashSet<>(Arrays.asList(aBindingNode, anotherBindingNode)));
        ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute =
            new ValuesVariableAtttribute<>(x);
        Collection<? extends OWLClassExpression> values =
            valuesVariableAtttribute.compute(parameters);
        classExpressionIntersection = Aggregation.buildClassExpressionIntersection(
            Adapter.buildOWLObjectCollectionAdapter(values), manager.getOWLDataFactory());
        value = classExpressionIntersection.compute(parameters);
        assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b)));
        // Mix them up
        OWLClass stop = manager.getOWLDataFactory().getOWLClass(IRI.create("stop"));
        Set<OWLClassExpression> operands = new HashSet<>(values);
        operands.add(stop);
        classExpressionIntersection = Aggregation.buildClassExpressionIntersection(
            Adapter.buildOWLObjectCollectionAdapter(operands), manager.getOWLDataFactory());
        value = classExpressionIntersection.compute(parameters);
        assertTrue(
            value.equals(manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b, stop)));
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestCreateUnion() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        OWLClassExpression a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#monica"));
        OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#luigi"));
        Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>> classExpressionIntersection =
            Aggregation.buildClassExpressionUnion(
                Adapter.buildOWLObjectCollectionAdapter(Arrays.asList(a, b)),
                manager.getOWLDataFactory());
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        OWLClassExpression value = classExpressionIntersection.compute(parameters);
        assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectUnionOf(a, b)));
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestExpression() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        Variable<OWLClassExpression> y =
            constraintSystem.createVariable("?y", VariableTypeFactory.getCLASSVariableType(), null);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
        OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#b"));
        OWLObjectProperty p =
            manager.getOWLDataFactory().getOWLObjectProperty(IRI.create("blah#p"));
        OWLObjectSomeValuesFrom owlObjectSomeValuesFrom = manager.getOWLDataFactory()
            .getOWLObjectSomeValuesFrom(p, manager.getOWLDataFactory().getOWLClass(x.getIRI()));
        Expression<OWLClassExpression> expression = new Expression<>(owlObjectSomeValuesFrom);
        bindingNode.addAssignment(new Assignment(x, a));
        bindingNode.addAssignment(new Assignment(y, b));
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        OWLClassExpression values = expression.compute(parameters);
        assertTrue(values.equals(manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(p, a)));
        owlObjectSomeValuesFrom = manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(p,
            manager.getOWLDataFactory().getOWLObjectIntersectionOf(
                manager.getOWLDataFactory().getOWLClass(x.getIRI()),
                manager.getOWLDataFactory().getOWLClass(y.getIRI())));
        expression = new Expression<>(owlObjectSomeValuesFrom);
        values = expression.compute(parameters);
        assertTrue(values.equals(manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(p,
            manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b))));
        manager.removeOntology(ontology);
    }

    @Test
    public void shouldTestOWLEntityAnnotationRendering() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OWLAnnotationAssertionAxiom axiom =
            manager.getOWLDataFactory().getOWLAnnotationAssertionAxiom(
                manager.getOWLDataFactory()
                    .getOWLAnnotationProperty(IRI.create("blah#annotationProperty")),
                manager.getOWLDataFactory().getOWLThing().getIRI(),
                manager.getOWLDataFactory().getOWLLiteral("Luigi and Monica"));
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        ManchesterSyntaxRenderer renderer =
            constraintSystem.getOPPLFactory().getManchesterSyntaxRenderer(constraintSystem);
        axiom.accept(renderer);
        assertEquals(
            "<http://www.w3.org/2002/07/owl#Thing> annotationProperty \"Luigi and Monica\"",
            renderer.toString());
    }

    @Test
    public void shouldTestOWLDisjointClassesAxiomInlineSet() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLOWLDataFactory dataFactory = new OPPLOWLDataFactory(manager.getOWLDataFactory());
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        InputVariable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        BindingNode aBindingNode = BindingNode.createNewEmptyBindingNode();
        aBindingNode
            .addAssignment(new Assignment(x, dataFactory.getOWLClass(IRI.create("Blah#Luigi"))));
        BindingNode anotherBindingNode = BindingNode.createNewEmptyBindingNode();
        anotherBindingNode
            .addAssignment(new Assignment(x, dataFactory.getOWLClass(IRI.create("Blah#Monica"))));
        constraintSystem.setLeaves(new HashSet<>(Arrays.asList(aBindingNode, anotherBindingNode)));
        ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute =
            ValuesVariableAtttribute.getValuesVariableAtttribute(x);
        Aggregandum<Collection<? extends OWLClassExpression>> aggregandum =
            Adapter.buildAggregandumCollection(Collections.singleton(valuesVariableAtttribute));
        OWLAxiom axiom = dataFactory
            .getOWLDisjointClassesAxiom(new InlineSet<>(VariableTypeFactory.getCLASSVariableType(),
                Collections.singleton(aggregandum), dataFactory, constraintSystem));
        OWLObjectInstantiator instantiator =
            new OWLObjectInstantiator(new SimpleValueComputationParameters(constraintSystem,
                BindingNode.createNewEmptyBindingNode(), HANDLER));
        OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
        assertTrue(instantiatedAxiom.getAxiomType() == AxiomType.DISJOINT_CLASSES);
    }

    @Test
    public void shouldTestRegularExpressionDependentOnAnotherVariable() throws Exception {
        OWLOntology ontology = manager.createOntology();
        OPPLFactory factory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = factory.createConstraintSystem();
        Variable<OWLClassExpression> x =
            constraintSystem.createVariable("?x", VariableTypeFactory.getCLASSVariableType(), null);
        RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(x);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
        OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#b"));
        bindingNode.addAssignment(new Assignment(x, a));
        BindingNode anotherBindingNode = BindingNode.createNewEmptyBindingNode();
        anotherBindingNode.addAssignment(new Assignment(x, b));
        List<Aggregandum<String>> list = new ArrayList<>();
        list.add(Adapter.buildSingletonAggregandum(new Constant<>("(")));
        list.add(Adapter.buildSingletonAggregandum(renderingVariableAttribute));
        list.add(Adapter.buildSingletonAggregandum(new Constant<>(")")));
        Aggregation<String, String> stringConcatenation =
            Aggregation.buildStringConcatenation(list);
        RegexpGeneratedVariable<OWLClassExpression> regexpGeneratedVariable =
            new RegexpGeneratedVariable<>("?regexp", VariableTypeFactory.getCLASSVariableType(),
                Adapter.buildRegexpPatternAdapter(stringConcatenation));
        manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(a));
        manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(b));
        VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValueVisitor =
            new VariableTypeVisitorEx<Set<? extends OWLObject>>() {

                @Override
                public Set<OWLClass> visitCLASSVariableType(CLASSVariableType t) {
                    return asSet(axioms().flatMap(OWLObjectExtractor::getAllClasses));
                }

                @Override
                public Set<OWLLiteral> visitCONSTANTVariableType(CONSTANTVariableType t) {
                    return asSet(axioms().flatMap(OWLObjectExtractor::getAllOWLLiterals));
                }

                @Override
                public Set<OWLObjectProperty> visitOBJECTPROPERTYVariableType(
                    OBJECTPROPERTYVariableType t) {
                    return asSet(axioms().flatMap(OWLObjectExtractor::getAllOWLObjectProperties));
                }

                @Override
                public Set<OWLDataProperty> visitDATAPROPERTYVariableType(
                    DATAPROPERTYVariableType t) {
                    return asSet(axioms().flatMap(OWLObjectExtractor::getAllOWLDataProperties));
                }

                @Override
                public Set<OWLAnnotationProperty> visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                    return asSet(axioms().flatMap(OWLObjectExtractor::getAllAnnotationProperties));
                }

                @Override
                public Set<OWLNamedIndividual> visitINDIVIDUALVariableType(
                    INDIVIDUALVariableType t) {
                    return asSet(axioms().flatMap(OWLObjectExtractor::getAllOWLIndividuals));
                }
            };
        ValueComputationParameters parameters =
            new SimpleValueComputationParameters(constraintSystem, bindingNode, HANDLER);
        AssignableValueExtractor assignableValueExtractor =
            new AssignableValueExtractor(assignableValueVisitor, parameters);
        Set<? extends OWLObject> values = regexpGeneratedVariable.accept(assignableValueExtractor);
        assertTrue(!values.isEmpty());
        list = new ArrayList<>();
        list.add(Adapter.buildSingletonAggregandum(new Constant<>("Test")));
        list.add(Adapter.buildSingletonAggregandum(renderingVariableAttribute));
        stringConcatenation = Aggregation.buildStringConcatenation(list);
        regexpGeneratedVariable =
            new RegexpGeneratedVariable<>("?regexp", VariableTypeFactory.getCLASSVariableType(),
                Adapter.buildRegexpPatternAdapter(stringConcatenation));
        parameters =
            new SimpleValueComputationParameters(constraintSystem, anotherBindingNode, HANDLER);
        assignableValueExtractor = new AssignableValueExtractor(assignableValueVisitor, parameters);
        values = regexpGeneratedVariable.accept(assignableValueExtractor);
        assertTrue(values.isEmpty());
        manager.removeOntology(ontology);
    }

    Stream<OWLAxiom> axioms() {
        return manager.ontologies().flatMap(OWLOntology::axioms);
    }
}
