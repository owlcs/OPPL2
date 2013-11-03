package org.coode.oppl.test;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.LeafBrusher;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.oppl.utils.VariableDetector;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.RemoveAxiom;

public class TestQueries {
    private enum DescriptionType {
        // visit(OWLObjectHasSelf)
        CLASS, OWLDATARESTRICTION, OWLDATAEXACTCARDINALITYRESTRICTION, OWLDATAMINCARDINALITYRESTRICTION, OWLDATAMAXCARDINALITYRESTRICTION, OWLDATASOMERESTRICTION, OWLDATAVALUERESTRICTION, OWLOBJECTALLRESTRICTION, OWLOBJECTCOMPLEMENTOF, OWLOBJECTEXACTCARDINALITYRESTRICTION, OWLOBJECTINTERSECTIONOF, OWLOBJECTEXACTCARDINALITYRESTRCTION, OWLOBJECTMAXCARDINALITYRESTRICTION, OWLOBJECTMINCARDINALITYRESTRICTION, OWLOBJECTONEOF, OWLOBJECTSOMERESTRICTION, OWLOBJECTUNIONOF, OWLOBJECTVALUERESTRICTION
    }

    private final int valuesCount = 1;
    private final ErrorListener errorListener = new ErrorListener() {
        public void unrecognisedSymbol(CommonTree t) {
            fail("Unrecognised symbol " + t);
        }

        public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
            fail(e.getMessage());
        }

        public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
            fail(t.getMessage() + " at line " + line + " position " + charPosInLine
                    + " length " + length);
        }

        public void recognitionException(RecognitionException e, String... tokenNames) {
            StringBuilder out = new StringBuilder();
            Formatter formatter = new Formatter(out, Locale.getDefault());
            for (String string : tokenNames) {
                formatter.format("%s ", string);
            }
            fail(e.getMessage() + out.toString());
        }

        public void recognitionException(RecognitionException e) {
            fail(e.getMessage());
        }

        public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
            StringBuilder out = new StringBuilder();
            Formatter formatter = new Formatter(out, Locale.getDefault());
            formatter.format("Incompatible symbols in %s ", parentExpression.getText());
            for (CommonTree commonTree : trees) {
                formatter.format("%s ", commonTree.getText());
            }
            fail(out.toString());
        }

        public void
                incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
            StringBuilder out = new StringBuilder();
            Formatter formatter = new Formatter(out, Locale.getDefault());
            formatter.format("Incompatible symbols type [%s] for %s  in %s ", type,
                    t.getText(), expression.getText());
            fail(out.toString());
        }

        public void illegalToken(CommonTree t, String message) {
            StringBuilder out = new StringBuilder();
            Formatter formatter = new Formatter(out, Locale.getDefault());
            formatter
                    .format("Illegal token %s  additional information: [%s]", t, message);
            fail(out.toString());
        }
    };
    private final static IRI TEST_NS = IRI.create("http://www.co-ode.org/opp/test#");
    private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();

    private void buildOntologyForQuery(OPPLScript opplScript, OWLOntology testOntology,
            OWLOntologyManager manager) {
        // Clear test ontology
        clearOntology(testOntology, manager);
        List<InputVariable<?>> inputVariables = opplScript.getInputVariables();
        Map<Variable<?>, Set<OWLObject>> bindings = new HashMap<Variable<?>, Set<OWLObject>>();
        for (Variable<?> variable : inputVariables) {
            bindings.put(variable, generateValues(variable, manager));
        }
        BindingNode root = new BindingNode(new HashSet<Assignment>(),
                new HashSet<Variable<?>>(inputVariables));
        LeafBrusher leafBrusher = new LeafBrusher(bindings);
        root.accept(leafBrusher);
        Set<BindingNode> leaves = leafBrusher.getLeaves();
        OPPLQuery query = opplScript.getQuery();
        try {
            if (query != null) {
                List<OWLAxiom> axioms = query.getAssertedAxioms();
                axioms.addAll(query.getAxioms());
                if (leaves != null) {
                    for (BindingNode bindingNode : leaves) {
                        ValueComputationParameters parameters = new SimpleValueComputationParameters(
                                opplScript.getConstraintSystem(), bindingNode, HANDLER);
                        PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
                                parameters);
                        for (OWLAxiom owlAxiom : axioms) {
                            manager.addAxiom(testOntology, (OWLAxiom) owlAxiom
                                    .accept(partialOWLObjectInstantiator));
                        }
                    }
                }
            }
        } catch (OWLOntologyChangeException e) {
            fail(e.getMessage());
        }
    }

    /** @param testOntology
     * @param manager */
    private void clearOntology(OWLOntology testOntology, OWLOntologyManager manager) {
        for (OWLAxiom axiom : testOntology.getAxioms()) {
            try {
                manager.applyChange(new RemoveAxiom(testOntology, axiom));
            } catch (OWLOntologyChangeException e) {
                e.printStackTrace();
                fail(e.getMessage());
            }
        }
    }

    private Set<OWLObject>
            generateValues(Variable<?> variable, OWLOntologyManager manager) {
        Set<OWLObject> toReturn = new HashSet<OWLObject>();
        int questionMarkIndex = variable.getName().indexOf('?');
        String fragment = questionMarkIndex != -1 ? variable.getName().substring(
                questionMarkIndex + 1) : variable.getName();
        for (int i = 0; i < valuesCount; i++) {
            toReturn.add(generateValue(fragment + "_" + i, variable,
                    manager.getOWLDataFactory()));
        }
        return toReturn;
    }

    private OWLObject generateValue(final String string, Variable<?> variable,
            final OWLDataFactory dataFactory) {
        VariableTypeVisitorEx<OWLObject> visitor = new VariableTypeVisitorEx<OWLObject>() {
            public OWLObject visitINDIVIDUALVariableType(INDIVIDUALVariableType v) {
                return dataFactory.getOWLNamedIndividual(IRI.create(TEST_NS.toString()
                        + string));
            }

            public OWLObject visitDATAPROPERTYVariableType(DATAPROPERTYVariableType v) {
                return dataFactory.getOWLDataProperty(IRI.create(TEST_NS.toString()
                        + string));
            }

            public OWLObject
                    visitOBJECTPROPERTYVariableType(OBJECTPROPERTYVariableType v) {
                return dataFactory.getOWLObjectProperty(IRI.create(TEST_NS.toString()
                        + string));
            }

            public OWLObject visitCONSTANTVariableType(CONSTANTVariableType v) {
                return dataFactory.getOWLLiteral(string);
            }

            public OWLObject visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                return dataFactory.getOWLAnnotationProperty(IRI.create(TEST_NS.toString()
                        + string));
            }

            public OWLObject visitCLASSVariableType(CLASSVariableType v) {
                return dataFactory.getOWLClass(IRI.create(TEST_NS.toString() + string));
            }
        };
        return variable.getType().accept(visitor);
    }

    @Test
    public void testTransitiveObjectPropertyQuery() {
        String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED Transitive ?x BEGIN ADD transitive ?x END;";
        this.genericTestQuery(opplString);
    }

    public void genericTestQuery(String opplString) {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            testQuery(opplScript, ontologyManager, testOntology);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void genericTestQuery(OPPLScript opplScript) {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            testQuery(opplScript, ontologyManager, testOntology);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    private OPPLScript parseScript(String opplString, OWLOntologyManager ontologyManager,
            OWLOntology testOntology) {
        OPPLParser parser = new ParserFactory(ontologyManager, testOntology, null)
                .build(errorListener);
        return parser.parse(opplString);
    }

    @Test
    public void testSymmetricObjectPropertyQuery() {
        String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED symmetric ?x BEGIN ADD symmetric ?x END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testReflexiveObjectPropertyQuery() {
        String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED reflexive ?x BEGIN ADD reflexive ?x END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testIrreflexiveObjectPropertyQuery() {
        String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED Irreflexive ?x BEGIN ADD Irreflexive ?x END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testInverseObjectPropertiesQuery() {
        String opplString = "?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ASSERTED ?x InverseOf ?y BEGIN ADD ?x InverseOf ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testInverseFunctionalObjectPropertiesQuery() {
        String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED InverseFunctional ?x BEGIN ADD InverseFunctional ?x END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testFunctionalDataPropertiesQuery() {
        String opplString = "?x:DATAPROPERTY SELECT ASSERTED Functional ?x BEGIN ADD Functional ?x END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testFunctionalObjectPropertiesQuery() {
        String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED Functional ?x BEGIN ADD Functional ?x END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testEquivalentObjectPropertiesQuery() {
        String opplString = "?x:OBJECTPROPERTY,?y:OBJECTPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testEquivalentDataPropertiesQuery() {
        String opplString = "?x:DATAPROPERTY,?y:DATAPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testEquivalentClassesQuery() {
        String opplString = "?x:CLASS,?y:CLASS SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDisjointObjectPropertiesQuery() {
        String opplString = "?x:OBJECTPROPERTY,?y:OBJECTPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDisjointDataPropertiesQuery() {
        String opplString = "?x:DATAPROPERTY,?y:DATAPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDisjointClassesQuery() {
        String opplString = "?x:CLASS,?y:CLASS SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDataPropertyRangeQuery() {
        String opplString = "?x:DATAPROPERTY SELECT ASSERTED ?x range int BEGIN ADD ?x range int END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testObjectPropertyDomainQuery() {
        String opplString = "?x:OBJECTPROPERTY, ?y:CLASS SELECT ASSERTED ?x domain ?y BEGIN ADD ?x domain ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testObjectPropertyRangeQuery() {
        String opplString = "?x:OBJECTPROPERTY, ?y:CLASS SELECT ASSERTED ?x range ?y BEGIN ADD ?x range ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDataPropertyDomainQuery() {
        String opplString = "?x:DATAPROPERTY, ?y:CLASS SELECT ASSERTED	?x domain ?y  BEGIN ADD ?x domain ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testSameIndividualsQuery() {
        String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL SELECT ASSERTED ?x  SameAs  ?y BEGIN ADD ?x  DifferentFrom ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDifferentIndividualsQuery() {
        String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL SELECT ASSERTED ?x  DifferentFrom  ?y BEGIN ADD ?x  DifferentFrom ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testNegativeObjectPropertyAssertionQuery() {
        String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL,?z:OBJECTPROPERTY SELECT ASSERTED not ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testObjectPropertyAssertionQuery() {
        String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL,?z:OBJECTPROPERTY SELECT ASSERTED ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testNegativeDataPropertyAssertionQuery() {
        String opplString = "?x:INDIVIDUAL,?y:CONSTANT,?z:DATAPROPERTY SELECT ASSERTED not ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testDataPropertyAssertionQuery() {
        String opplString = "?x:INDIVIDUAL,?y:CONSTANT,?z:DATAPROPERTY SELECT ASSERTED ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testSubClassQuery() {
        String opplString = "?x:CLASS,?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testComplexSubClassUnaryQueries() {
        try {
            OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLOntology testOntology = ontologyManager.createOntology(TEST_NS);
            OPPLAbstractFactory opplFactory = new OPPLFactory(ontologyManager,
                    testOntology, null);
            ConstraintSystem cs = opplFactory.createConstraintSystem();
            Set<OWLClassExpression> subClasses = generateClasses(dataFactory, 0, cs);
            Set<OWLClassExpression> superClasses = generateClasses(dataFactory, 1, cs);
            VariableExtractor variableExtractor = new VariableExtractor(cs, false);
            int testSize = subClasses.size() * superClasses.size();
            int i = 1;
            for (OWLClassExpression subClass : subClasses) {
                for (OWLClassExpression superClass : superClasses) {
                    OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(
                            subClass, superClass);
                    Set<Variable<?>> variables = variableExtractor
                            .extractVariables(axiom);
                    OPPLQuery query = opplFactory.buildNewQuery(cs);
                    query.addAssertedAxiom(axiom);
                    ArrayList<OWLAxiomChange> actions = new ArrayList<OWLAxiomChange>();
                    actions.add(new AddAxiom(testOntology, axiom));
                    OPPLScript opplScript = opplFactory.buildOPPLScript(cs,
                            new ArrayList<Variable<?>>(variables), query, actions);
                    Logging.getQueryTestLogging().log(Level.INFO,
                            i++ + " out of " + testSize);
                    testQuery(opplScript, ontologyManager, testOntology);
                }
            }
        } catch (OPPLException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testBinarySubClassQuery() {
        String opplString = "?x:CLASS,?y:CLASS, ?z:CLASS SELECT ASSERTED ?x subClassOf ?z, ASSERTED ?y subClassOf ?z BEGIN ADD ?x subClassOf ?y END;";
        this.genericTestQuery(opplString);
        opplString = "?x:CLASS,?y:CLASS, ?z:CLASS SELECT ASSERTED ?x subClassOf ?y, ASSERTED ?x subClassOf ?z BEGIN ADD ?x subClassOf ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testSubDataPropertyQuery() {
        String opplString = "?x:DATAPROPERTY,?y:DATAPROPERTY SELECT ASSERTED ?x subPropertyOf ?y BEGIN ADD ?x subPropertyOf ?y END;";
        this.genericTestQuery(opplString);
    }

    @Test
    public void testSubObjectPropertyQuery() {
        String opplString = "?x:OBJECTPROPERTY,?y:OBJECTPROPERTY SELECT ASSERTED ?x subPropertyOf ?y BEGIN ADD ?x subPropertyOf ?y END;";
        this.genericTestQuery(opplString);
    }

    private void testQuery(OPPLScript opplScript, OWLOntologyManager ontologyManager,
            OWLOntology testOntology) {
        buildOntologyForQuery(opplScript, testOntology, ontologyManager);
        Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
        StringWriter resultWriter = new StringWriter();
        for (OWLAxiom owlAxiom : results) {
            resultWriter.append(owlAxiom.toString());
            resultWriter.append("\n");
        }
        OPPLQuery query = opplScript.getQuery();
        if (query != null) {
            List<OWLAxiom> queryAxioms = query.getAssertedAxioms();
            queryAxioms.addAll(query.getAxioms());
            double expected = 0;
            VariableExtractor variableExtractor = new VariableExtractor(
                    opplScript.getConstraintSystem(), false);
            for (OWLAxiom owlAxiom : queryAxioms) {
                Set<Variable<?>> axiomVariables = variableExtractor
                        .extractVariables(owlAxiom);
                expected += Math.pow(valuesCount, axiomVariables.size());
            }
            assertTrue(
                    "Query " + opplScript.render() + "\n" + " Actual " + results.size()
                            + " Expected " + expected + "\n" + resultWriter.toString(),
                    results.size() == expected);
        }
        VariableDetector variableDetector = new VariableDetector(
                opplScript.getConstraintSystem());
        for (OWLAxiom owlAxiom : results) {
            assertFalse("Result with variable axiom " + owlAxiom,
                    owlAxiom.accept(variableDetector));
        }
    }

    public void testQueryManualExpected(int expected, OPPLScript opplScript,
            OWLOntologyManager ontologyManager, OWLOntology testOntology) {
        buildOntologyForQuery(opplScript, testOntology, ontologyManager);
        Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
        StringWriter resultWriter = new StringWriter();
        for (OWLAxiom owlAxiom : results) {
            resultWriter.append(owlAxiom.toString());
            resultWriter.append("\n");
        }
        OPPLQuery query = opplScript.getQuery();
        if (query != null) {
            List<OWLAxiom> queryAxioms = query.getAssertedAxioms();
            queryAxioms.addAll(query.getAxioms());
            assertTrue(
                    "Query " + opplScript.render() + "\n" + " Actual " + results.size()
                            + " Expected " + expected + "\n" + resultWriter.toString(),
                    results.size() == expected);
        }
        VariableDetector variableDetector = new VariableDetector(
                opplScript.getConstraintSystem());
        for (OWLAxiom owlAxiom : results) {
            assertFalse("Result with variable axiom " + owlAxiom,
                    owlAxiom.accept(variableDetector));
        }
    }

    private Set<OWLAxiom> getOPPLScriptResults(final OPPLScript opplScript) {
        ChangeExtractor changeExtractor = new ChangeExtractor(HANDLER, true);
        changeExtractor.visit(opplScript);
        Set<BindingNode> checkLeaves = opplScript.getConstraintSystem().getLeaves();
        final Set<OWLAxiom> correctResults = new HashSet<OWLAxiom>();
        Set<OWLAxiom> queryAxioms = new HashSet<OWLAxiom>();
        if (opplScript.getQuery() != null) {
            queryAxioms.addAll(opplScript.getQuery().getAssertedAxioms());
            queryAxioms.addAll(opplScript.getQuery().getAxioms());
        }
        if (checkLeaves != null) {
            for (BindingNode bindingNode : checkLeaves) {
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                        opplScript.getConstraintSystem(), bindingNode, HANDLER);
                PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
                        parameters);
                for (OWLAxiom owlAxiom : queryAxioms) {
                    correctResults.add((OWLAxiom) owlAxiom
                            .accept(partialOWLObjectInstantiator));
                }
            }
        }
        return correctResults;
    }

    private Set<OWLClassExpression> generateClasses(OWLDataFactory dataFactory,
            int counter, ConstraintSystem cs) throws OPPLException {
        EnumSet<DescriptionType> descriptionTypes = EnumSet.allOf(DescriptionType.class);
        Set<OWLClassExpression> toReturn = new HashSet<OWLClassExpression>();
        for (DescriptionType descriptionType : descriptionTypes) {
            Variable<?> classVariable = cs.createVariable("?aClass_" + counter,
                    VariableTypeFactory.getCLASSVariableType(), null);
            Variable<?> anotherClassVariable = cs.createVariable("?anotherClass_"
                    + counter, VariableTypeFactory.getCLASSVariableType(), null);
            Variable<?> dataPropertyVariable = cs.createVariable("?aDataProperty_"
                    + counter, VariableTypeFactory.getDATAPROPERTYVariableType(), null);
            Variable<?> objectPropertyVariable = cs.createVariable("?anObjectProperty_"
                    + counter, VariableTypeFactory.getOBJECTPROPERTYTypeVariableType(),
                    null);
            Variable<?> constantVariable = cs.createVariable("?aConstant_" + counter,
                    VariableTypeFactory.getCONSTANTVariableType(), null);
            Variable<?> anIndividualVariable = cs.createVariable("?anIndividual_"
                    + counter, VariableTypeFactory.getINDIVIDUALVariableType(), null);
            Variable<?> anotherIndividualVariable = cs.createVariable(
                    "?anotherIndividual_" + counter,
                    VariableTypeFactory.getINDIVIDUALVariableType(), null);
            switch (descriptionType) {
                case CLASS:
                    toReturn.add(dataFactory.getOWLClass(classVariable.getIRI()));
                    break;
                case OWLDATAEXACTCARDINALITYRESTRICTION:
                    toReturn.add(dataFactory.getOWLDataExactCardinality(3,
                            dataFactory.getOWLDataProperty(dataPropertyVariable.getIRI())));
                    break;
                case OWLDATAMAXCARDINALITYRESTRICTION:
                    toReturn.add(dataFactory.getOWLDataMaxCardinality(3,
                            dataFactory.getOWLDataProperty(dataPropertyVariable.getIRI())));
                    break;
                case OWLDATAMINCARDINALITYRESTRICTION:
                    toReturn.add(dataFactory.getOWLDataMinCardinality(3,
                            dataFactory.getOWLDataProperty(dataPropertyVariable.getIRI())));
                    break;
                case OWLDATAVALUERESTRICTION:
                    toReturn.add(dataFactory.getOWLDataHasValue(
                            dataFactory.getOWLDataProperty(dataPropertyVariable.getIRI()),
                            dataFactory.getOWLLiteral(constantVariable.getName())));
                    break;
                case OWLOBJECTALLRESTRICTION:
                    toReturn.add(dataFactory.getOWLObjectAllValuesFrom(dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI()),
                            dataFactory.getOWLClass(classVariable.getIRI())));
                    break;
                case OWLOBJECTCOMPLEMENTOF:
                    toReturn.add(dataFactory.getOWLObjectComplementOf(dataFactory
                            .getOWLClass(classVariable.getIRI())));
                    break;
                case OWLOBJECTEXACTCARDINALITYRESTRICTION:
                    toReturn.add(dataFactory.getOWLObjectExactCardinality(2, dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI())));
                    break;
                case OWLOBJECTINTERSECTIONOF:
                    toReturn.add(dataFactory.getOWLObjectIntersectionOf(
                            dataFactory.getOWLClass(classVariable.getIRI()),
                            dataFactory.getOWLClass(anotherClassVariable.getIRI())));
                    break;
                case OWLOBJECTEXACTCARDINALITYRESTRCTION:
                    toReturn.add(dataFactory.getOWLObjectExactCardinality(4, dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI())));
                    break;
                case OWLOBJECTMINCARDINALITYRESTRICTION:
                    toReturn.add(dataFactory.getOWLObjectMinCardinality(4, dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI())));
                    break;
                case OWLOBJECTSOMERESTRICTION:
                    toReturn.add(dataFactory.getOWLObjectSomeValuesFrom(dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI()),
                            dataFactory.getOWLClass(classVariable.getIRI())));
                    break;
                case OWLOBJECTONEOF:
                    toReturn.add(dataFactory.getOWLObjectOneOf(dataFactory
                            .getOWLNamedIndividual(anIndividualVariable.getIRI()),
                            dataFactory.getOWLNamedIndividual(anotherIndividualVariable
                                    .getIRI())));
                    break;
                case OWLOBJECTUNIONOF:
                    toReturn.add(dataFactory.getOWLObjectUnionOf(
                            dataFactory.getOWLClass(classVariable.getIRI()),
                            dataFactory.getOWLClass(anotherClassVariable.getIRI())));
                    break;
                case OWLOBJECTVALUERESTRICTION:
                    toReturn.add(dataFactory.getOWLObjectHasValue(dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI()),
                            dataFactory.getOWLNamedIndividual(anIndividualVariable
                                    .getIRI())));
                    break;
                case OWLOBJECTMAXCARDINALITYRESTRICTION:
                    toReturn.add(dataFactory.getOWLObjectMaxCardinality(4, dataFactory
                            .getOWLObjectProperty(objectPropertyVariable.getIRI())));
                    break;
                default:
                    break;
            }
        }
        return toReturn;
    }

    @Test
    public void testDoublyMatchingEquivalentObjectProperties() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLObjectProperty aProperty = dataFactory.getOWLObjectProperty(IRI
                    .create(TEST_NS.toString() + "aProperty"));
            OWLObjectProperty anotherProperty = dataFactory.getOWLObjectProperty(IRI
                    .create(TEST_NS.toString() + "anotherProperty"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLEquivalentObjectPropertiesAxiom(aProperty, anotherProperty)));
            String opplString = "?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingEquivalentDataProperties() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLDataProperty aProperty = dataFactory.getOWLDataProperty(IRI.create(TEST_NS
                    .toString() + "aProperty"));
            OWLDataProperty anotherProperty = dataFactory.getOWLDataProperty(IRI
                    .create(TEST_NS.toString() + "anotherProperty"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLEquivalentDataPropertiesAxiom(aProperty, anotherProperty)));
            String opplString = "?x:DATAPROPERTY, ?y:DATAPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingDisjointDataProperties() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLDataProperty aProperty = dataFactory.getOWLDataProperty(IRI.create(TEST_NS
                    .toString() + "aProperty"));
            OWLDataProperty anotherProperty = dataFactory.getOWLDataProperty(IRI
                    .create(TEST_NS.toString() + "anotherProperty"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLDisjointDataPropertiesAxiom(aProperty, anotherProperty)));
            String opplString = "?x:DATAPROPERTY, ?y:DATAPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingDisjointObjectProperties() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLObjectProperty aProperty = dataFactory.getOWLObjectProperty(IRI
                    .create(TEST_NS.toString() + "aProperty"));
            OWLObjectProperty anotherProperty = dataFactory.getOWLObjectProperty(IRI
                    .create(TEST_NS.toString() + "anotherProperty"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLDisjointObjectPropertiesAxiom(aProperty, anotherProperty)));
            String opplString = "?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingEquivalentClasses() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLClass aClass = dataFactory.getOWLClass(IRI.create(TEST_NS.toString()
                    + "aClass"));
            OWLClass anotherClass = dataFactory.getOWLClass(IRI.create(TEST_NS.toString()
                    + "anotherClass"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLEquivalentClassesAxiom(aClass, anotherClass)));
            String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingDisjointClasses() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLClass aClass = dataFactory.getOWLClass(IRI.create(TEST_NS.toString()
                    + "aClass"));
            OWLClass anotherClass = dataFactory.getOWLClass(IRI.create(TEST_NS.toString()
                    + "anotherClass"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLDisjointClassesAxiom(aClass, anotherClass)));
            String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingSameIndividuals() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLIndividual anIndividual = dataFactory.getOWLNamedIndividual(IRI
                    .create(TEST_NS.toString() + "anIndividual"));
            OWLIndividual anotherIndividual = dataFactory.getOWLNamedIndividual(IRI
                    .create(TEST_NS.toString() + "anotherIndividual"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLSameIndividualAxiom(new HashSet<OWLIndividual>(Arrays.asList(
                            anIndividual, anotherIndividual)))));
            String opplString = "?x:INDIVIDUAL, ?y:INDIVIDUAL SELECT ASSERTED ?x SameAs ?y BEGIN ADD ?x SameAs ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingDifferentIndividuals() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLIndividual anIndividual = dataFactory.getOWLNamedIndividual(IRI
                    .create(TEST_NS.toString() + "anIndividual"));
            OWLIndividual anotherIndividual = dataFactory.getOWLNamedIndividual(IRI
                    .create(TEST_NS.toString() + "anotherIndividual"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLDifferentIndividualsAxiom(anIndividual, anotherIndividual)));
            String opplString = "?x:INDIVIDUAL, ?y:INDIVIDUAL SELECT ASSERTED ?x DifferentFrom ?y BEGIN ADD ?x DifferentFrom ?y END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testDoublyMatchingClassDescription() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology;
        try {
            testOntology = ontologyManager.createOntology(TEST_NS);
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLClass aClass = dataFactory
                    .getOWLClass(IRI.create(TEST_NS.toString() + "A"));
            OWLClass anotherClass = dataFactory.getOWLClass(IRI.create(TEST_NS.toString()
                    + "B"));
            OWLClass yetAnotherClass = dataFactory.getOWLClass(IRI.create(TEST_NS
                    .toString() + "C"));
            ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
                    .getOWLSubClassOfAxiom(
                            dataFactory.getOWLObjectIntersectionOf(aClass, anotherClass),
                            yetAnotherClass)));
            String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x and ?y subClassOf C BEGIN ADD ?x and ?y subClassOf C END;";
            OPPLScript opplScript = parseScript(opplString, ontologyManager, testOntology);
            Set<OWLAxiom> results = getOPPLScriptResults(opplScript);
            assertTrue(results.size() == 1);
            assertTrue("Expected 2 Actual "
                    + opplScript.getConstraintSystem().getLeaves().size(), opplScript
                    .getConstraintSystem().getLeaves().size() == 2);
            Logging.getQueryTestLogging().log(Level.INFO,
                    " Leaves " + opplScript.getConstraintSystem().getLeaves());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLOntologyChangeException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
