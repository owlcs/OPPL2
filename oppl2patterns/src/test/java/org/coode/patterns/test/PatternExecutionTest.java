package org.coode.patterns.test;

import static org.coode.oppl.test.Ontologies.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.coode.patterns.ClassPatternExecutor;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.NonClassPatternExecutor;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.ParserFactory;
import org.coode.patterns.PatternModel;
import org.junit.Test;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyChangeVisitor;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.RemoveImport;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;
import org.semanticweb.owlapi.model.SetOntologyID;

public class PatternExecutionTest {
    @Test
    public void testPatternReference() {
        OWLAnnotationProperty patternAnnotationProperty = df.getOWLAnnotationProperty(IRI
                .create("http://www.co-ode.org/patterns#Free"));
        AddOntologyAnnotation addFoodPattern = new AddOntologyAnnotation(
                pizza,
                df.getOWLAnnotation(
                        patternAnnotationProperty,
                        df.getOWLLiteral("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo hasTopping only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass")));
        pizza.getOWLOntologyManager().applyChanges(Arrays.asList(addFoodPattern));
        String string = "?content:CLASS BEGIN ADD $thisClass subClassOf hasTopping only ($Free(?content.VALUES) ) END;  A ?content free menu";
        ParserFactory factory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
        OPPLPatternParser parser = factory.build(errorListener);
        PatternModel patternModel = parser.parse(string);
        assertNotNull(patternModel);
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
        OWLClass patternCreatedOWLClass = df.getOWLClass(IRI.create("PatternCreated"));
        InstantiatedPatternModel instantiatedPatternModel = patternModel
                .getPatternModelFactory().createInstantiatedPatternModel(patternModel,
                        handler);
        instantiatedPatternModel.instantiate(patternModel.getConstraintSystem()
                .getVariable("?content"), df.getOWLClass(IRI.create("blah#A")));
        instantiatedPatternModel.instantiate(patternModel.getConstraintSystem()
                .getVariable("?content"), df.getOWLClass(IRI.create("blah#B")));
        ClassPatternExecutor executor = new ClassPatternExecutor(patternCreatedOWLClass,
                instantiatedPatternModel, pizza, pizza.getOWLOntologyManager(),
                IRI.create("http://www.co-ode.org/patterns#menuInstantiated"), handler);
        List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel
                .getPatternModel());
        assertTrue(changes.size() > 0);
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(patternModel.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
                @Override
                public void visit(RemoveOntologyAnnotation change) {}

                @Override
                public void visit(AddOntologyAnnotation change) {}

                @Override
                public void visit(RemoveImport change) {}

                @Override
                public void visit(AddImport change) {}

                @Override
                public void visit(SetOntologyID change) {}

                @Override
                public void visit(RemoveAxiom change) {
                    change.getAxiom().accept(renderer);
                }

                @Override
                public void visit(AddAxiom change) {
                    change.getAxiom().accept(renderer);
                }
            });
        }
    }

    @Test
    public void testPatternReferenceMultipleValuesPerArgument() {
        OWLAnnotationProperty patternAnnotationProperty = df.getOWLAnnotationProperty(IRI
                .create("http://www.co-ode.org/patterns#Free"));
        AddOntologyAnnotation addFoodPattern = new AddOntologyAnnotation(
                pizza,
                df.getOWLAnnotation(
                        patternAnnotationProperty,
                        df.getOWLLiteral("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo hasTopping only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass")));
        pizza.getOWLOntologyManager().applyChanges(Arrays.asList(addFoodPattern));
        String string = "BEGIN ADD $thisClass subClassOf hasTopping only ($Free({Thing,Nothing}) ) END;  A content free menu";
        ParserFactory factory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
        OPPLPatternParser parser = factory.build(errorListener);
        PatternModel patternModel = parser.parse(string);
        assertNotNull(patternModel);
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
        OWLClass patternCreatedOWLClass = df.getOWLClass(IRI.create("PatternCreated"));
        InstantiatedPatternModel instantiatedPatternModel = patternModel
                .getPatternModelFactory().createInstantiatedPatternModel(patternModel,
                        handler);
        ClassPatternExecutor executor = new ClassPatternExecutor(patternCreatedOWLClass,
                instantiatedPatternModel, pizza, pizza.getOWLOntologyManager(),
                IRI.create("http://www.co-ode.org/patterns#menuInstantiated"), handler);
        List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel
                .getPatternModel());
        assertTrue(changes.size() > 0);
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(patternModel.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
                @Override
                public void visit(RemoveOntologyAnnotation change) {}

                @Override
                public void visit(AddOntologyAnnotation change) {}

                @Override
                public void visit(RemoveImport change) {}

                @Override
                public void visit(AddImport change) {}

                @Override
                public void visit(SetOntologyID change) {}

                @Override
                public void visit(RemoveAxiom change) {
                    change.getAxiom().accept(renderer);
                }

                @Override
                public void visit(AddAxiom change) {
                    change.getAxiom().accept(renderer);
                }
            });
        }
    }

    @Test
    public void testPatternReferenceVariableValuesPerArgument() {
        OWLAnnotationProperty patternAnnotationProperty = df.getOWLAnnotationProperty(IRI
                .create("http://www.co-ode.org/patterns#Free"));
        AddOntologyAnnotation addFoodPattern = new AddOntologyAnnotation(
                pizza,
                df.getOWLAnnotation(
                        patternAnnotationProperty,
                        df.getOWLLiteral("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo hasTopping only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass")));
        pizza.getOWLOntologyManager().applyChanges(Arrays.asList(addFoodPattern));
        String string = "?v:CLASS BEGIN ADD $thisClass subClassOf hasTopping only ($Free(?v.VALUES)) END;  A content free menu";
        ParserFactory factory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
        OPPLPatternParser parser = factory.build(errorListener);
        PatternModel patternModel = parser.parse(string);
        assertNotNull(patternModel);
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
        OWLClass patternCreatedOWLClass = df.getOWLClass(IRI.create("PatternCreated"));
        InstantiatedPatternModel instantiatedPatternModel = patternModel
                .getPatternModelFactory().createInstantiatedPatternModel(patternModel,
                        handler);
        Variable<?> variable = instantiatedPatternModel.getConstraintSystem()
                .getVariable("?v");
        instantiatedPatternModel.instantiate(variable,
                df.getOWLClass(IRI.create("blah#Luigi")));
        instantiatedPatternModel.instantiate(variable,
                df.getOWLClass(IRI.create("blah#Monica")));
        ClassPatternExecutor executor = new ClassPatternExecutor(patternCreatedOWLClass,
                instantiatedPatternModel, pizza, pizza.getOWLOntologyManager(),
                IRI.create("http://www.co-ode.org/patterns#menuInstantiated"), handler);
        List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel
                .getPatternModel());
        assertTrue(changes.size() > 0);
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(patternModel.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
                @Override
                public void visit(RemoveOntologyAnnotation change) {}

                @Override
                public void visit(AddOntologyAnnotation change) {}

                @Override
                public void visit(RemoveImport change) {}

                @Override
                public void visit(AddImport change) {}

                @Override
                public void visit(SetOntologyID change) {}

                @Override
                public void visit(RemoveAxiom change) {
                    change.getAxiom().accept(renderer);
                }

                @Override
                public void visit(AddAxiom change) {
                    change.getAxiom().accept(renderer);
                }
            });
        }
    }

    @Test
    public void testComplexExpressionConjuntionGeneratedVariablePattern() {
        pizza.getOWLOntologyManager().addAxiom(
                pizza,
                df.getOWLDeclarationAxiom(df.getOWLObjectProperty(IRI
                        .create(" http://www.co-ode.org/ontologies/ont.owl#part_of"))));
        String patternString = "?cell:CLASS, ?anatomyPart:CLASS, ?partOfRestriction:CLASS = part_of some ?anatomyPart, ?anatomyIntersection:CLASS = createIntersection(?partOfRestriction.VALUES) BEGIN ADD ?cell equivalentTo ?anatomyIntersection END;";
        ParserFactory factory = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        final JUnitTestErrorListener errorListener = new JUnitTestErrorListener();
        OPPLPatternParser parser = factory.build(errorListener);
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
        PatternModel patternModel = parser.parse(patternString);
        assertNotNull(patternModel);
        InstantiatedPatternModel instantiatedPatternModel = patternModel
                .getPatternModelFactory().createInstantiatedPatternModel(patternModel,
                        handler);
        NonClassPatternExecutor executor = new NonClassPatternExecutor(
                instantiatedPatternModel, pizza, pizza.getOWLOntologyManager(),
                IRI.create("http://e-lico.eu/populous#OPPL_pattern"), handler);
        Variable<?> cell = instantiatedPatternModel.getConstraintSystem().getVariable(
                "?cell");
        Variable<?> anatomyPart = instantiatedPatternModel.getConstraintSystem()
                .getVariable("?anatomyPart");
        instantiatedPatternModel.instantiate(cell, df.getOWLClass(IRI
                .create("http://www.co-ode.org/ontologies/ont.owl#kidney_cell")));
        instantiatedPatternModel.instantiate(anatomyPart,
                df.getOWLClass(IRI.create("http://purl.org/obo/owl/MA#MA_0000368")));
        List<OWLAxiomChange> changes = executor.visit(instantiatedPatternModel
                .getPatternModel());
        assertTrue(changes.size() == 1);
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(patternModel.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
                @Override
                public void visit(RemoveOntologyAnnotation change) {}

                @Override
                public void visit(AddOntologyAnnotation change) {}

                @Override
                public void visit(RemoveImport change) {}

                @Override
                public void visit(AddImport change) {}

                @Override
                public void visit(SetOntologyID change) {}

                @Override
                public void visit(RemoveAxiom change) {
                    change.getAxiom().accept(renderer);
                }

                @Override
                public void visit(AddAxiom change) {
                    change.getAxiom().accept(renderer);
                }
            });
        }
    }

    @Test
    public void testNoVariables() {
        String pattern = "BEGIN ADD FishTopping equivalentTo FruitTopping END;";
        ParserFactory pf = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        OPPLPatternParser parser = pf.build(new SystemErrorEcho());
        PatternModel patternModel = parser.parse(pattern);
        List<OWLAxiomChange> changes = new ArrayList<OWLAxiomChange>();
        QuickFailRuntimeExceptionHandler handler = new QuickFailRuntimeExceptionHandler();
        InstantiatedPatternModel ipm = pf.getPatternFactory()
                .createInstantiatedPatternModel(patternModel, handler);
        NonClassPatternExecutor patternExecutor = new NonClassPatternExecutor(ipm, pizza,
                pizza.getOWLOntologyManager(),
                IRI.create("http://example.owl#OPPL_pattern"), handler);
        changes.addAll(patternExecutor.visit(ipm.getPatternModel()));
        assertTrue(changes.size() == 1);
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(patternModel.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
                @Override
                public void visit(RemoveOntologyAnnotation change) {}

                @Override
                public void visit(AddOntologyAnnotation change) {}

                @Override
                public void visit(RemoveImport change) {}

                @Override
                public void visit(AddImport change) {}

                @Override
                public void visit(SetOntologyID change) {}

                @Override
                public void visit(RemoveAxiom change) {
                    change.getAxiom().accept(renderer);
                }

                @Override
                public void visit(AddAxiom change) {
                    change.getAxiom().accept(renderer);
                }
            });
        }
    }

    @Test
    public void testPizzaMultipleValuedVariables() {
        String pattern = "?pizza:CLASS, "
                + "?topping:CLASS, "
                + "?toppingRestriction:CLASS = hasTopping some ?topping, "
                + "?toppingIntersection:CLASS = createIntersection(?toppingRestriction.VALUES)"
                + "BEGIN ADD ?pizza equivalentTo ?toppingIntersection END;";
        OWLClass pizzaClass = df.getOWLClass(IRI.create("http://example.owl#JuppsPizza"));
        OWLClass meatTopping = df.getOWLClass(IRI
                .create("http://pizza.com/pizza.owl#MeatTopping"));
        OWLClass fishTopping = df.getOWLClass(IRI
                .create("http://pizza.com/pizza.owl#FishTopping"));
        ParserFactory pf = new ParserFactory(pizza, pizza.getOWLOntologyManager());
        OPPLPatternParser parser = pf.build(new SystemErrorEcho());
        PatternModel patternModel = parser.parse(pattern);
        List<OWLAxiomChange> changes = new ArrayList<OWLAxiomChange>();
        QuickFailRuntimeExceptionHandler handler = new QuickFailRuntimeExceptionHandler();
        InstantiatedPatternModel ipm = pf.getPatternFactory()
                .createInstantiatedPatternModel(patternModel, handler);
        Map<String, Variable> opplVariableMap = new HashMap<String, Variable>();
        for (Variable v : patternModel.getInputVariables()) {
            opplVariableMap.put(v.getName(), v);
        }
        for (String var : opplVariableMap.keySet()) {
            if (var.equals("?pizza")) {
                ipm.instantiate(opplVariableMap.get(var), pizzaClass);
            } else if (var.equals("?topping")) {
                ipm.instantiate(opplVariableMap.get(var), meatTopping);
                ipm.instantiate(opplVariableMap.get(var), fishTopping);
            }
        }
        NonClassPatternExecutor patternExecutor = new NonClassPatternExecutor(ipm, pizza,
                pizza.getOWLOntologyManager(),
                IRI.create("http://example.owl#OPPL_pattern"), handler);
        changes.addAll(patternExecutor.visit(ipm.getPatternModel()));
        assertEquals(1, changes.size());
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = patternModel.getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(patternModel.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
                @Override
                public void visit(RemoveOntologyAnnotation change) {}

                @Override
                public void visit(AddOntologyAnnotation change) {}

                @Override
                public void visit(RemoveImport change) {}

                @Override
                public void visit(AddImport change) {}

                @Override
                public void visit(SetOntologyID change) {}

                @Override
                public void visit(RemoveAxiom change) {
                    change.getAxiom().accept(renderer);
                }

                @Override
                public void visit(AddAxiom change) {
                    change.getAxiom().accept(renderer);
                }
            });
        }
    }
}
