package org.coode.oppl.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.common.SilentListener;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import uk.ac.manchester.cs.jfact.JFactFactory;

public class SpecificInferenceQueries {
    private final static String TEST_NS = "http://www.co-ode.org/opp/test#";
    private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();
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

    @Test
    public void testRedundantSubClasses() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        try {
            OWLOntology ontology = ontologyManager.createOntology();
            OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
            OWLClass a = dataFactory.getOWLClass(IRI.create("blah#A"));
            OWLClass b = dataFactory.getOWLClass(IRI.create("blah#B"));
            OWLClass c = dataFactory.getOWLClass(IRI.create("blah#C"));
            OWLClass d = dataFactory.getOWLClass(IRI.create("blah#D"));
            OWLClass e = dataFactory.getOWLClass(IRI.create("blah#E"));
            List<AddAxiom> changes = Arrays.asList(
                    new AddAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(b, a)),
                    new AddAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(c, b)),
                    new AddAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(d, b)),
                    new AddAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(e, b)),
                    // Redundant
                    new AddAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(c, a)),
                    // Redundant
                    new AddAxiom(ontology, dataFactory.getOWLSubClassOfAxiom(d, a)));
            ontologyManager.applyChanges(changes);
            String xVariableName = "?x";
            String yVariableName = "?y";
            String opplScripString = String
                    .format("%1$s:CLASS, %2$s:CLASS SELECT ASSERTED %1$s SubClassOf A, ASSERTED %2$s SubClassOf A, %1$s SubClassOf %2$s WHERE %1$s != %2$s BEGIN REMOVE %1$s SubClassOf A END;",
                            xVariableName, yVariableName);
            JFactFactory factory = new JFactFactory();
            OWLReasoner reasoner = factory.createReasoner(ontology);
            ParserFactory parserFactory = new ParserFactory(ontologyManager, ontology,
                    reasoner);
            OPPLParser parser = parserFactory.build(new SilentListener());
            OPPLScript opplScript = parser.parse(opplScripString);
            ChangeExtractor changeExtractor = new ChangeExtractor(HANDLER, false);
            List<OWLAxiomChange> extractedChanges = changeExtractor.visit(opplScript);
            assertTrue(extractedChanges.size() == 2);
            Set<BindingNode> leaves = opplScript.getConstraintSystem().getLeaves();
            assertNotNull(leaves);
            assertTrue(leaves.size() == 2);
            Map<String, Set<OWLObject>> assignments = new HashMap<String, Set<OWLObject>>();
            for (BindingNode bindingNode : leaves) {
                Set<Variable<?>> assignedVariables = bindingNode.getAssignedVariables();
                for (Variable<?> variable : assignedVariables) {
                    String name = variable.getName();
                    if (name.compareTo(xVariableName) == 0
                            || name.compareTo(yVariableName) == 0) {
                        Set<OWLObject> set = assignments.get(name);
                        if (set == null) {
                            set = new HashSet<OWLObject>();
                            assignments.put(name, set);
                        }
                        set.add(bindingNode.getAssignmentValue(
                                variable,
                                new SimpleValueComputationParameters(opplScript
                                        .getConstraintSystem(), bindingNode, HANDLER)));
                    }
                }
            }
            Set<OWLObject> xValues = assignments.get(xVariableName);
            assertNotNull(xValues);
            assertTrue(xValues.size() == 2);
            assertTrue(xValues.containsAll(Arrays.asList(c, d)));
            Set<OWLObject> yValues = assignments.get(yVariableName);
            assertNotNull(yValues);
            assertTrue(yValues.size() == 1);
            assertTrue(yValues.containsAll(Arrays.asList(b)));
            for (OWLObject owlObject : xValues) {
                System.out.println(owlObject);
            }
        } catch (OWLOntologyCreationException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testTransitiveSubClassClosure() throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology testOntology = ontologyManager.createOntology(IRI.create(TEST_NS));
        OWLClass a = ontologyManager.getOWLDataFactory().getOWLClass(
                IRI.create(TEST_NS, "A"));
        OWLClass b = ontologyManager.getOWLDataFactory().getOWLClass(
                IRI.create(TEST_NS, "B"));
        OWLClass c = ontologyManager.getOWLDataFactory().getOWLClass(
                IRI.create(TEST_NS, "C"));
        ontologyManager.addAxiom(testOntology, ontologyManager.getOWLDataFactory()
                .getOWLSubClassOfAxiom(a, b));
        ontologyManager.addAxiom(testOntology, ontologyManager.getOWLDataFactory()
                .getOWLSubClassOfAxiom(b, c));
        String opplString = "?x:CLASS SELECT  ?x subClassOf C BEGIN ADD ?x subClassOf A END;";
        OWLReasonerFactory factory = new JFactFactory();
        OWLReasoner reasoner = factory.createReasoner(testOntology);
        System.out.println("SpecificInferenceQueries.testTransitiveSubClassClosure() "
                + testOntology.getAxioms().toString().replace(",", ",\n"));
        OPPLScript opplScript = new ParserFactory(ontologyManager, testOntology, reasoner)
                .build(errorListener).parse(opplString);
        ChangeExtractor changeExtractor = new ChangeExtractor(HANDLER, true);
        List<OWLAxiomChange> changes = changeExtractor.visit(opplScript);
        assertTrue(changes.size() > 0);
        Set<OWLAxiom> instantiatedAxioms = getOPPLScriptInstantiatedAxioms(opplScript);
        assertEquals("Instantiated axioms number does not match", 4,
                instantiatedAxioms.size());
        for (OWLAxiom axiom : instantiatedAxioms) {
            Logging.getQueryTestLogging().info(axiom);
        }
        NodeSet<OWLClass> subClasses = reasoner.getSubClasses(c, false);
        Logging.getQueryTestLogging().info(subClasses);
    }

    private Set<OWLAxiom> getOPPLScriptInstantiatedAxioms(OPPLScript opplScript) {
        Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
        Set<BindingNode> leaves = opplScript.getConstraintSystem().getLeaves();
        if (leaves != null) {
            for (BindingNode bindingNode : leaves) {
                List<OWLAxiom> queryAxioms = opplScript.getQuery().getAssertedAxioms();
                queryAxioms.addAll(opplScript.getQuery().getAxioms());
                ValueComputationParameters parameters = new SimpleValueComputationParameters(
                        opplScript.getConstraintSystem(), bindingNode, HANDLER);
                PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
                        parameters);
                for (OWLAxiom axiom : queryAxioms) {
                    toReturn.add((OWLAxiom) axiom.accept(partialOWLObjectInstantiator));
                }
            }
        }
        return toReturn;
    }
}
