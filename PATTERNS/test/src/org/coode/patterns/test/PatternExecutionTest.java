package org.coode.patterns.test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import junit.framework.TestCase;

import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.common.JUnitTestErrorListener;
import org.coode.patterns.ClassPatternExecutor;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.ParserFactory;
import org.coode.patterns.PatternModel;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeVisitor;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.RemoveImport;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;
import org.semanticweb.owlapi.model.SetOntologyID;

public class PatternExecutionTest extends TestCase {
	public void testPatternReference() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLAnnotationProperty patternAnnotationProperty = dataFactory.getOWLAnnotationProperty(IRI.create("http://www.co-ode.org/patterns#Free"));
			AddOntologyAnnotation addFoodPattern = new AddOntologyAnnotation(
					ontology,
					dataFactory.getOWLAnnotation(
							patternAnnotationProperty,
							dataFactory.getOWLLiteral("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo hasTopping only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass")));
			manager.applyChanges(Arrays.asList(addFoodPattern));
			String string = "?content:CLASS BEGIN ADD $thisClass subClassOf hasTopping only ($Free(?content) ) END;  A ?content free menu";
			ParserFactory factory = new ParserFactory(ontology, manager);
			final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
			OPPLPatternParser parser = factory.build(errorListener);
			PatternModel patternModel = parser.parse(string);
			assertNotNull(patternModel);
			System.out.println(patternModel.render());
			RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
				public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}

				public void handleOWLRuntimeException(OWLRuntimeException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}

				public void handleException(RuntimeException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}
			};
			OWLClass patternCreatedOWLClass = dataFactory.getOWLClass(IRI.create("PatternCreated"));
			InstantiatedPatternModel instantiatedPatternModel = patternModel.getPatternModelFactory().createInstantiatedPatternModel(
					patternModel,
					handler);
			instantiatedPatternModel.instantiate(
					patternModel.getConstraintSystem().getVariable("?content"),
					dataFactory.getOWLClass(IRI.create("blah#A")));
			instantiatedPatternModel.instantiate(
					patternModel.getConstraintSystem().getVariable("?content"),
					dataFactory.getOWLClass(IRI.create("blah#B")));
			ClassPatternExecutor executor = new ClassPatternExecutor(patternCreatedOWLClass,
					instantiatedPatternModel, ontology, manager,
					IRI.create("http://www.co-ode.org/patterns#menuInstantiated"), handler);
			List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel.getPatternModel());
			assertTrue(changes.size() > 0);
			for (OWLAxiomChange owlAxiomChange : changes) {
				final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
						patternModel.getConstraintSystem());
				owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
					public void visit(RemoveOntologyAnnotation change) {
					}

					public void visit(AddOntologyAnnotation change) {
					}

					public void visit(RemoveImport change) {
					}

					public void visit(AddImport change) {
					}

					public void visit(SetOntologyID change) {
					}

					public void visit(RemoveAxiom change) {
						change.getAxiom().accept(renderer);
						System.out.printf("REMOVE %s \n", renderer.toString());
					}

					public void visit(AddAxiom change) {
						change.getAxiom().accept(renderer);
						System.out.printf("ADD %s \n", renderer.toString());
					}
				});
			}
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testPatternReferenceMultipleValuesPerArgument() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLAnnotationProperty patternAnnotationProperty = dataFactory.getOWLAnnotationProperty(IRI.create("http://www.co-ode.org/patterns#Free"));
			AddOntologyAnnotation addFoodPattern = new AddOntologyAnnotation(
					ontology,
					dataFactory.getOWLAnnotation(
							patternAnnotationProperty,
							dataFactory.getOWLLiteral("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo hasTopping only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass")));
			manager.applyChanges(Arrays.asList(addFoodPattern));
			String string = "BEGIN ADD $thisClass subClassOf hasTopping only ($Free({Thing,Nothing}) ) END;  A content free menu";
			ParserFactory factory = new ParserFactory(ontology, manager);
			final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
			OPPLPatternParser parser = factory.build(errorListener);
			PatternModel patternModel = parser.parse(string);
			assertNotNull(patternModel);
			System.out.println(patternModel.render());
			RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
				public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}

				public void handleOWLRuntimeException(OWLRuntimeException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}

				public void handleException(RuntimeException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}
			};
			OWLClass patternCreatedOWLClass = dataFactory.getOWLClass(IRI.create("PatternCreated"));
			InstantiatedPatternModel instantiatedPatternModel = patternModel.getPatternModelFactory().createInstantiatedPatternModel(
					patternModel,
					handler);
			ClassPatternExecutor executor = new ClassPatternExecutor(patternCreatedOWLClass,
					instantiatedPatternModel, ontology, manager,
					IRI.create("http://www.co-ode.org/patterns#menuInstantiated"), handler);
			List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel.getPatternModel());
			assertTrue(changes.size() > 0);
			for (OWLAxiomChange owlAxiomChange : changes) {
				final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
						patternModel.getConstraintSystem());
				owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
					public void visit(RemoveOntologyAnnotation change) {
					}

					public void visit(AddOntologyAnnotation change) {
					}

					public void visit(RemoveImport change) {
					}

					public void visit(AddImport change) {
					}

					public void visit(SetOntologyID change) {
					}

					public void visit(RemoveAxiom change) {
						change.getAxiom().accept(renderer);
						System.out.printf("REMOVE %s \n", renderer.toString());
					}

					public void visit(AddAxiom change) {
						change.getAxiom().accept(renderer);
						System.out.printf("ADD %s \n", renderer.toString());
					}
				});
			}
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testPatternReferenceVariableValuesPerArgument() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLAnnotationProperty patternAnnotationProperty = dataFactory.getOWLAnnotationProperty(IRI.create("http://www.co-ode.org/patterns#Free"));
			AddOntologyAnnotation addFoodPattern = new AddOntologyAnnotation(
					ontology,
					dataFactory.getOWLAnnotation(
							patternAnnotationProperty,
							dataFactory.getOWLLiteral("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo hasTopping only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass")));
			manager.applyChanges(Arrays.asList(addFoodPattern));
			String string = "?v:CLASS BEGIN ADD $thisClass subClassOf hasTopping only ($Free(?v.VALUES)) END;  A content free menu";
			ParserFactory factory = new ParserFactory(ontology, manager);
			final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
			OPPLPatternParser parser = factory.build(errorListener);
			PatternModel patternModel = parser.parse(string);
			assertNotNull(patternModel);
			System.out.println(patternModel.render());
			RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
				public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}

				public void handleOWLRuntimeException(OWLRuntimeException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}

				public void handleException(RuntimeException e) {
					errorListener.reportThrowable(e, 0, 0, 0);
				}
			};
			OWLClass patternCreatedOWLClass = dataFactory.getOWLClass(IRI.create("PatternCreated"));
			InstantiatedPatternModel instantiatedPatternModel = patternModel.getPatternModelFactory().createInstantiatedPatternModel(
					patternModel,
					handler);
			Variable<?> variable = instantiatedPatternModel.getConstraintSystem().getVariable("?v");
			instantiatedPatternModel.instantiate(
					variable,
					dataFactory.getOWLClass(IRI.create("blah#Luigi")));
			instantiatedPatternModel.instantiate(
					variable,
					dataFactory.getOWLClass(IRI.create("blah#Monica")));
			ClassPatternExecutor executor = new ClassPatternExecutor(patternCreatedOWLClass,
					instantiatedPatternModel, ontology, manager,
					IRI.create("http://www.co-ode.org/patterns#menuInstantiated"), handler);
			List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel.getPatternModel());
			assertTrue(changes.size() > 0);
			for (OWLAxiomChange owlAxiomChange : changes) {
				final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
						patternModel.getConstraintSystem());
				owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
					public void visit(RemoveOntologyAnnotation change) {
					}

					public void visit(AddOntologyAnnotation change) {
					}

					public void visit(RemoveImport change) {
					}

					public void visit(AddImport change) {
					}

					public void visit(SetOntologyID change) {
					}

					public void visit(RemoveAxiom change) {
						change.getAxiom().accept(renderer);
						System.out.printf("REMOVE %s \n", renderer.toString());
					}

					public void visit(AddAxiom change) {
						change.getAxiom().accept(renderer);
						System.out.printf("ADD %s \n", renderer.toString());
					}
				});
			}
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
