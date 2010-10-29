package org.coode.oppl.function.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.Adapter;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.StringGeneratedValue;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class OPPLFunctionTest extends TestCase {
	private final static OWLOntologyManager manager = OWLManager
			.createOWLOntologyManager();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testRendering() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x",
					VariableType.CLASS);
			RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#a"));
			bindingNode.addAssignment(new Assignment(x, a));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			String value = renderingVariableAttribute.compute(parameters);
			ManchesterSyntaxRenderer renderer = factory
					.getManchesterSyntaxRenderer(constraintSystem);
			a.accept(renderer);
			assertTrue(value.compareTo(renderer.toString()) == 0);
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testValues() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x",
					VariableType.CLASS);
			ValuesVariableAtttribute<OWLClass> valuesVariableAtttribute = new ValuesVariableAtttribute<OWLClass>(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#a"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#b"));
			BindingNode aBindingNode = new BindingNode(Collections
					.singleton(new Assignment(x, a)), Collections
					.<Variable> emptySet());
			BindingNode anotherBindingNode = new BindingNode(Collections
					.singleton(new Assignment(x, b)), Collections
					.<Variable> emptySet());
			constraintSystem.setLeaves(new HashSet<BindingNode>(Arrays.asList(
					aBindingNode, anotherBindingNode)));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			Collection<OWLClass> values = valuesVariableAtttribute
					.compute(parameters);
			assertTrue(values.containsAll(Arrays.asList(a, b)));
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testValuesNoValues() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x",
					VariableType.CLASS);
			ValuesVariableAtttribute<OWLClass> valuesVariableAtttribute = new ValuesVariableAtttribute<OWLClass>(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			Collection<OWLClass> values = valuesVariableAtttribute
					.compute(parameters);
			assertNull(values);
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testGroupValue() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#monica"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#luigi"));
			manager.addAxiom(ontology, manager.getOWLDataFactory()
					.getOWLDeclarationAxiom(a));
			manager.addAxiom(ontology, manager.getOWLDataFactory()
					.getOWLDeclarationAxiom(b));
			RegExpGenerated<OWLClass> x = (RegExpGenerated<OWLClass>) VariableType.CLASS
					.getRegExpGenerated("?x", factory
							.getOWLEntityRenderer(constraintSystem),
							new StringGeneratedValue("(lu)igi"), manager
									.getOntologies());
			GroupVariableAttribute<OWLClass> groupVariableAttribute = new GroupVariableAttribute<OWLClass>(
					x, 1);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			bindingNode.addAssignment(new Assignment(x, b));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			String value = groupVariableAttribute.compute(parameters);
			assertTrue(value.compareTo("lu") == 0);
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testRenderingNoValue() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x",
					VariableType.CLASS);
			RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			String value = renderingVariableAttribute.compute(parameters);
			assertNull(value);
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCreateIntersection() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#monica"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#luigi"));
			Aggregation<OWLClassExpression, OWLClassExpression> classExpressionIntersection = Aggregation
					.buildClassExpressionIntersection(Adapter
							.buildOWLObjectCollectionAdapter(Arrays
									.asList(a, b)), manager.getOWLDataFactory());
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			OWLClassExpression value = classExpressionIntersection
					.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory()
					.getOWLObjectIntersectionOf(a, b)));
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = factory
					.getManchesterSyntaxRenderer(constraintSystem);
			value.accept(manchesterSyntaxRenderer);
			System.out.println(manchesterSyntaxRenderer);
			// Variable values
			Variable x = constraintSystem.createVariable("?x",
					VariableType.CLASS);
			BindingNode aBindingNode = new BindingNode(Collections
					.singleton(new Assignment(x, a)), Collections
					.<Variable> emptySet());
			BindingNode anotherBindingNode = new BindingNode(Collections
					.singleton(new Assignment(x, b)), Collections
					.<Variable> emptySet());
			constraintSystem.setLeaves(new HashSet<BindingNode>(Arrays.asList(
					aBindingNode, anotherBindingNode)));
			ValuesVariableAtttribute<OWLClass> valuesVariableAtttribute = new ValuesVariableAtttribute<OWLClass>(
					x);
			Collection<OWLClass> values = valuesVariableAtttribute
					.compute(parameters);
			classExpressionIntersection = Aggregation
					.buildClassExpressionIntersection(Adapter
							.buildOWLObjectCollectionAdapter(values), manager
							.getOWLDataFactory());
			value = classExpressionIntersection.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory()
					.getOWLObjectIntersectionOf(a, b)));
			manchesterSyntaxRenderer = factory
					.getManchesterSyntaxRenderer(constraintSystem);
			value.accept(manchesterSyntaxRenderer);
			System.out.println(manchesterSyntaxRenderer);
			// Mix them up
			OWLClass stop = manager.getOWLDataFactory().getOWLClass(
					IRI.create("stop"));
			Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>(
					values);
			operands.add(stop);
			classExpressionIntersection = Aggregation
					.buildClassExpressionIntersection(Adapter
							.buildOWLObjectCollectionAdapter(operands), manager
							.getOWLDataFactory());
			value = classExpressionIntersection.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory()
					.getOWLObjectIntersectionOf(a, b, stop)));
			manchesterSyntaxRenderer = factory
					.getManchesterSyntaxRenderer(constraintSystem);
			value.accept(manchesterSyntaxRenderer);
			System.out.println(manchesterSyntaxRenderer);
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCreateUnion() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#monica"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#luigi"));
			Aggregation<OWLClassExpression, OWLClassExpression> classExpressionIntersection = Aggregation
					.buildClassExpressionUnion(Adapter
							.buildOWLObjectCollectionAdapter(Arrays
									.asList(a, b)), manager.getOWLDataFactory());
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			OWLClassExpression value = classExpressionIntersection
					.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory()
					.getOWLObjectUnionOf(a, b)));
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = factory
					.getManchesterSyntaxRenderer(constraintSystem);
			value.accept(manchesterSyntaxRenderer);
			System.out.println(manchesterSyntaxRenderer);
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testExpression() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory
					.createConstraintSystem();
			Variable x = constraintSystem.createVariable("?x",
					VariableType.CLASS);
			Variable y = constraintSystem.createVariable("?y",
					VariableType.CLASS);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#a"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#b"));
			OWLObjectProperty p = manager.getOWLDataFactory()
					.getOWLObjectProperty(IRI.create("blah#p"));
			OWLObjectSomeValuesFrom owlObjectSomeValuesFrom = manager
					.getOWLDataFactory()
					.getOWLObjectSomeValuesFrom(p,
							manager.getOWLDataFactory().getOWLClass(x.getIRI()));
			Expression<OWLClassExpression> expression = new Expression<OWLClassExpression>(
					owlObjectSomeValuesFrom);
			bindingNode.addAssignment(new Assignment(x, a));
			bindingNode.addAssignment(new Assignment(y, b));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, factory);
			OWLClassExpression values = expression.compute(parameters);
			assertTrue(values.equals(manager.getOWLDataFactory()
					.getOWLObjectSomeValuesFrom(p, a)));
			owlObjectSomeValuesFrom = manager.getOWLDataFactory()
					.getOWLObjectSomeValuesFrom(
							p,
							manager.getOWLDataFactory()
									.getOWLObjectIntersectionOf(
											manager.getOWLDataFactory()
													.getOWLClass(x.getIRI()),
											manager.getOWLDataFactory()
													.getOWLClass(y.getIRI())));
			expression = new Expression<OWLClassExpression>(
					owlObjectSomeValuesFrom);
			values = expression.compute(parameters);
			assertTrue(values.equals(manager.getOWLDataFactory()
					.getOWLObjectSomeValuesFrom(
							p,
							manager.getOWLDataFactory()
									.getOWLObjectIntersectionOf(a, b))));
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
