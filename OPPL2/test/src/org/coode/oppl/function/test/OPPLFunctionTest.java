package org.coode.oppl.function.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.Adapter;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.search.AssignableValueExtractor;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class OPPLFunctionTest extends TestCase {
	private final static OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
	private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testRendering() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
			bindingNode.addAssignment(new Assignment(x, a));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			String value = renderingVariableAttribute.compute(parameters);
			ManchesterSyntaxRenderer renderer = factory.getManchesterSyntaxRenderer(constraintSystem);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute = ValuesVariableAtttribute.getValuesVariableAtttribute(x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#b"));
			BindingNode aBindingNode = new BindingNode(Collections.singleton(new Assignment(x, a)),
					Collections.<Variable<?>> emptySet());
			BindingNode anotherBindingNode = new BindingNode(Collections.singleton(new Assignment(
					x, b)), Collections.<Variable<?>> emptySet());
			constraintSystem.setLeaves(new HashSet<BindingNode>(Arrays.asList(
					aBindingNode,
					anotherBindingNode)));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			Collection<OWLClassExpression> values = valuesVariableAtttribute.compute(parameters);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute = ValuesVariableAtttribute.getValuesVariableAtttribute(x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			Collection<OWLClassExpression> values = valuesVariableAtttribute.compute(parameters);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#monica"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#luigi"));
			manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(a));
			manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(b));
			RegexpGeneratedVariable<OWLClassExpression> x = new RegexpGeneratedVariable<OWLClassExpression>(
					"?x", VariableTypeFactory.getCLASSVariableType(),
					Adapter.buildRegexpPatternAdapter(new Constant<String>("(lu)igi")));
			GroupVariableAttribute<OWLClassExpression> groupVariableAttribute = GroupVariableAttribute.getGroupVariableAttribute(
					x,
					1);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			bindingNode.addAssignment(new Assignment(x, b));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			OWLClassExpression a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#monica"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#luigi"));
			Aggregation<OWLClassExpression, OWLClassExpression> classExpressionIntersection = Aggregation.buildClassExpressionIntersection(
					Adapter.buildOWLObjectCollectionAdapter(Arrays.asList(a, b)),
					manager.getOWLDataFactory());
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			OWLClassExpression value = classExpressionIntersection.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b)));
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = factory.getManchesterSyntaxRenderer(constraintSystem);
			value.accept(manchesterSyntaxRenderer);
			System.out.println(manchesterSyntaxRenderer);
			// Variable values
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			BindingNode aBindingNode = new BindingNode(Collections.singleton(new Assignment(x, a)),
					Collections.<Variable<?>> emptySet());
			BindingNode anotherBindingNode = new BindingNode(Collections.singleton(new Assignment(
					x, b)), Collections.<Variable<?>> emptySet());
			constraintSystem.setLeaves(new HashSet<BindingNode>(Arrays.asList(
					aBindingNode,
					anotherBindingNode)));
			ValuesVariableAtttribute<OWLClassExpression> valuesVariableAtttribute = new ValuesVariableAtttribute<OWLClassExpression>(
					x);
			Collection<OWLClassExpression> values = valuesVariableAtttribute.compute(parameters);
			classExpressionIntersection = Aggregation.buildClassExpressionIntersection(
					Adapter.buildOWLObjectCollectionAdapter(values),
					manager.getOWLDataFactory());
			value = classExpressionIntersection.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b)));
			manchesterSyntaxRenderer = factory.getManchesterSyntaxRenderer(constraintSystem);
			value.accept(manchesterSyntaxRenderer);
			System.out.println(manchesterSyntaxRenderer);
			// Mix them up
			OWLClass stop = manager.getOWLDataFactory().getOWLClass(IRI.create("stop"));
			Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>(values);
			operands.add(stop);
			classExpressionIntersection = Aggregation.buildClassExpressionIntersection(
					Adapter.buildOWLObjectCollectionAdapter(operands),
					manager.getOWLDataFactory());
			value = classExpressionIntersection.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectIntersectionOf(
					a,
					b,
					stop)));
			manchesterSyntaxRenderer = factory.getManchesterSyntaxRenderer(constraintSystem);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			OWLClassExpression a = manager.getOWLDataFactory().getOWLClass(
					IRI.create("blah#monica"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#luigi"));
			Aggregation<OWLClassExpression, OWLClassExpression> classExpressionIntersection = Aggregation.buildClassExpressionUnion(
					Adapter.buildOWLObjectCollectionAdapter(Arrays.asList(a, b)),
					manager.getOWLDataFactory());
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			OWLClassExpression value = classExpressionIntersection.compute(parameters);
			assertTrue(value.equals(manager.getOWLDataFactory().getOWLObjectUnionOf(a, b)));
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = factory.getManchesterSyntaxRenderer(constraintSystem);
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
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			Variable<OWLClassExpression> y = constraintSystem.createVariable(
					"?y",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#b"));
			OWLObjectProperty p = manager.getOWLDataFactory().getOWLObjectProperty(
					IRI.create("blah#p"));
			OWLObjectSomeValuesFrom owlObjectSomeValuesFrom = manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(
					p,
					manager.getOWLDataFactory().getOWLClass(x.getIRI()));
			Expression<OWLClassExpression> expression = new Expression<OWLClassExpression>(
					owlObjectSomeValuesFrom);
			bindingNode.addAssignment(new Assignment(x, a));
			bindingNode.addAssignment(new Assignment(y, b));
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			OWLClassExpression values = expression.compute(parameters);
			assertTrue(values.equals(manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(p, a)));
			owlObjectSomeValuesFrom = manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(
					p,
					manager.getOWLDataFactory().getOWLObjectIntersectionOf(
							manager.getOWLDataFactory().getOWLClass(x.getIRI()),
							manager.getOWLDataFactory().getOWLClass(y.getIRI())));
			expression = new Expression<OWLClassExpression>(owlObjectSomeValuesFrom);
			values = expression.compute(parameters);
			assertTrue(values.equals(manager.getOWLDataFactory().getOWLObjectSomeValuesFrom(
					p,
					manager.getOWLDataFactory().getOWLObjectIntersectionOf(a, b))));
			manager.removeOntology(ontology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testOWLEntityAnnotationRendering() {
		OWLOntology ontology;
		try {
			ontology = manager.createOntology();
			OWLAnnotationAssertionAxiom axiom = manager.getOWLDataFactory().getOWLAnnotationAssertionAxiom(
					manager.getOWLDataFactory().getOWLAnnotationProperty(
							IRI.create("blah#annotationProperty")),
					manager.getOWLDataFactory().getOWLThing().getIRI(),
					manager.getOWLDataFactory().getOWLLiteral("Luigi and Monica"));
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			ManchesterSyntaxRenderer renderer = constraintSystem.getOPPLFactory().getManchesterSyntaxRenderer(
					constraintSystem);
			axiom.accept(renderer);
			System.out.println(renderer);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testRegularExpressionDependentOnAnotherVariable() {
		try {
			OWLOntology ontology = manager.createOntology();
			OPPLFactory factory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = factory.createConstraintSystem();
			Variable<OWLClassExpression> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			RenderingVariableAttribute renderingVariableAttribute = new RenderingVariableAttribute(
					x);
			BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
			OWLClass a = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#a"));
			OWLClass b = manager.getOWLDataFactory().getOWLClass(IRI.create("blah#b"));
			bindingNode.addAssignment(new Assignment(x, a));
			BindingNode anotherBindingNode = BindingNode.createNewEmptyBindingNode();
			anotherBindingNode.addAssignment(new Assignment(x, b));
			List<Aggregandum<String>> list = new ArrayList<Aggregandum<String>>();
			list.add(Adapter.buildSingletonAggregandum("("));
			list.add(Adapter.buildSingletonAggregandum(renderingVariableAttribute));
			list.add(Adapter.buildSingletonAggregandum(")"));
			Aggregation<String, String> stringConcatenation = Aggregation.buildStringConcatenation(list);
			RegexpGeneratedVariable<OWLClassExpression> regexpGeneratedVariable = new RegexpGeneratedVariable<OWLClassExpression>(
					"?regexp", VariableTypeFactory.getCLASSVariableType(),
					Adapter.buildRegexpPatternAdapter(stringConcatenation));
			manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(a));
			manager.addAxiom(ontology, manager.getOWLDataFactory().getOWLDeclarationAxiom(b));
			VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValueVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {
				public Set<OWLClass> visitCLASSVariableType(CLASSVariableType t) {
					Set<OWLClass> toReturn = new HashSet<OWLClass>();
					for (OWLOntology ontology : manager.getOntologies()) {
						for (OWLAxiom axiom : ontology.getAxioms()) {
							toReturn.addAll(OWLObjectExtractor.getAllClasses(axiom));
						}
					}
					return toReturn;
				}

				public Set<OWLLiteral> visitCONSTANTVariableType(CONSTANTVariableType t) {
					Set<OWLLiteral> toReturn = new HashSet<OWLLiteral>();
					for (OWLOntology ontology : manager.getOntologies()) {
						for (OWLAxiom axiom : ontology.getAxioms()) {
							toReturn.addAll(OWLObjectExtractor.getAllOWLLiterals(axiom));
						}
					}
					return toReturn;
				}

				public Set<OWLObjectProperty> visitOBJECTPROPERTYVariableType(
						OBJECTPROPERTYVariableType t) {
					Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
					for (OWLOntology ontology : manager.getOntologies()) {
						for (OWLAxiom axiom : ontology.getAxioms()) {
							toReturn.addAll(OWLObjectExtractor.getAllOWLObjectProperties(axiom));
						}
					}
					return toReturn;
				}

				public Set<OWLDataProperty> visitDATAPROPERTYVariableType(DATAPROPERTYVariableType t) {
					Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
					for (OWLOntology ontology : manager.getOntologies()) {
						for (OWLAxiom axiom : ontology.getAxioms()) {
							toReturn.addAll(OWLObjectExtractor.getAllOWLDataProperties(axiom));
						}
					}
					return toReturn;
				}

				public Set<OWLNamedIndividual> visitINDIVIDUALVariableType(INDIVIDUALVariableType t) {
					Set<OWLNamedIndividual> toReturn = new HashSet<OWLNamedIndividual>();
					for (OWLOntology ontology : manager.getOntologies()) {
						for (OWLAxiom axiom : ontology.getAxioms()) {
							toReturn.addAll(OWLObjectExtractor.getAllOWLIndividuals(axiom));
						}
					}
					return toReturn;
				}
			};
			ValueComputationParameters parameters = new SimpleValueComputationParameters(
					constraintSystem, bindingNode, HANDLER);
			AssignableValueExtractor assignableValueExtractor = new AssignableValueExtractor(
					assignableValueVisitor, parameters);
			Set<? extends OWLObject> values = regexpGeneratedVariable.accept(assignableValueExtractor);
			assertTrue(!values.isEmpty());
			System.out.println(values);
			list = new ArrayList<Aggregandum<String>>();
			list.add(Adapter.buildSingletonAggregandum("Test"));
			list.add(Adapter.buildSingletonAggregandum(renderingVariableAttribute));
			stringConcatenation = Aggregation.buildStringConcatenation(list);
			regexpGeneratedVariable = new RegexpGeneratedVariable<OWLClassExpression>("?regexp",
					VariableTypeFactory.getCLASSVariableType(),
					Adapter.buildRegexpPatternAdapter(stringConcatenation));
			parameters = new SimpleValueComputationParameters(constraintSystem, anotherBindingNode,
					HANDLER);
			assignableValueExtractor = new AssignableValueExtractor(assignableValueVisitor,
					parameters);
			values = regexpGeneratedVariable.accept(assignableValueExtractor);
			assertTrue(values.isEmpty());
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
