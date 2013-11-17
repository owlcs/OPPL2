package org.coode.patterns.test;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.common.SilentListener;
import org.junit.After;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import uk.ac.manchester.cs.jfact.JFactFactory;

@SuppressWarnings("javadoc")
public abstract class BasePatternTestCase {
    private static final int TOLERANCE = 3;
    private final static RuntimeExceptionHandler HANDLER = new QuickFailRuntimeExceptionHandler();
    // ontology manager
    // protected TestQueries testQueries = new TestQueries();
    private final ErrorListener errorListener = new SilentListener();
    // last generated exception; used to check that the exception being raised
    // is the one being expected
    private StringWriter lastStackTrace = new StringWriter();
    private PrintWriter p = new PrintWriter(lastStackTrace);
    // utility methods to set up the ontology, parse a script, check the
    // exceptions
    protected boolean longStackTrace = true;

    protected void execute(OPPLScript script, int expected) {
        try {
            ChangeExtractor changeExtractor = new ChangeExtractor(HANDLER, true);
            changeExtractor.visit(script);
            Set<OWLAxiom> queryAxioms = new HashSet<OWLAxiom>();
            if (script.getQuery() != null) {
                queryAxioms.addAll(script.getQuery().getAssertedAxioms());
                queryAxioms.addAll(script.getQuery().getAxioms());
            }
            Set<OWLAxiom> matches = new HashSet<OWLAxiom>();
            StringWriter resultWriter = new StringWriter();
            if (script.getConstraintSystem().getLeaves() != null
                    && !script.getConstraintSystem().getLeaves().isEmpty()) {
                for (BindingNode bindingNode : script.getConstraintSystem().getLeaves()) {
                    ValueComputationParameters parameters = new SimpleValueComputationParameters(
                            script.getConstraintSystem(), bindingNode, HANDLER);
                    PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
                            parameters);
                    for (OWLAxiom owlAxiom : queryAxioms) {
                        OWLAxiom match = (OWLAxiom) owlAxiom
                                .accept(partialOWLObjectInstantiator);
                        matches.add(match);
                        resultWriter.append(match.toString());
                        resultWriter.append("\n");
                    }
                }
            }
            assertEquals("Query " + script.toString() + "\n" + resultWriter.toString(),
                    expected, matches.size());
        } catch (Exception e) {
            log(e);
        }
    }

    @After
    public void tearDown() {
        lastStackTrace = new StringWriter();
        p = new PrintWriter(lastStackTrace);
    }

    protected String popStackTrace() {
        String toReturn = lastStackTrace.toString();
        lastStackTrace = new StringWriter();
        p = new PrintWriter(lastStackTrace);
        return toReturn;
    }

    protected OWLReasoner initReasoner(OWLOntology ontology) throws OWLRuntimeException {
        OWLReasonerFactory reasonerFactory = new JFactFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);
        return reasoner;
    }

    protected OWLReasoner initDummyReasoner() throws OWLRuntimeException {
        return null;
    }

    private static OWLReasoner testReasoner = null;

    protected OPPLScript parse(String script, OWLOntology ontology) {
        try {
            if (testReasoner == null) {
                testReasoner = initReasoner(ontology);
            }
            return this.parse(script, ontology, testReasoner);
        } catch (Exception e) {
            if (longStackTrace) {
                e.printStackTrace(p);
            } else {
                p.print(e.getMessage().replace("\n", "\t"));
            }
            p.flush();
        }
        return null;
    }

    protected OPPLScript parse(String script, OWLOntology ontology, OWLReasoner reasoner) {
        try {
            OPPLParser parser = new ParserFactory(ontology.getOWLOntologyManager(),
                    ontology, reasoner).build(errorListener);
            return parser.parse(script);
        } catch (Exception e) {
            if (longStackTrace) {
                e.printStackTrace(p);
            } else {
                p.print(e.getMessage().replace("\n", "\t"));
            }
            p.flush();
        }
        return null;
    }

    protected void log(Exception e) {
        if (longStackTrace) {
            e.printStackTrace(p);
        } else {
            p.print(e.getMessage().replace("\n", "\t"));
        }
        p.flush();
    }

    protected void checkProperStackTrace(String expected, int expectedIndex) {
        String stackTrace = popStackTrace();
        if (stackTrace.contains(expected)) {
            int lineStart = stackTrace.indexOf(expected);
            int lineEnd = stackTrace.indexOf("\n", lineStart);
            String line = null;
            if (lineEnd > -1) {
                line = stackTrace.substring(lineStart, lineEnd);
            } else {
                line = stackTrace.substring(lineStart);
            }
            int index = line.indexOf(expected) + expected.length();
            int fullStop = line.indexOf(".", index);
            // if both are valid and the full stop is closer than ten chars,
            // then there is likely a column number to parse; otherwise, the
            // column number is probably missing (and unneeded)
            if (index > -1 && fullStop > -1 && fullStop - index < 10) {
                String columnIndex = line.substring(index, fullStop);
                try {
                    int value = Integer.parseInt(columnIndex.trim());
                    if (Math.abs(value - expectedIndex) < TOLERANCE) {
                        // then the position is close enough
                    } else {
                        fail("ExhaustingTestCase The error type is correct but the column does not match the expected one. Expected error column: "
                                + expectedIndex + "\n actual stacktrace: " + stackTrace);
                    }
                } catch (NumberFormatException e) {
                    fail("ExhaustingTestCase.checkProperStackTrace() Could not parse a column number to verify the correctness of the stack trace:\nExpected error type: "
                            + expected
                            + "\nExpected error column: "
                            + expectedIndex
                            + "\n actual stacktrace: " + stackTrace);
                }
            } else {
                // there is no full stop after the expected string. No column
                // number info should be available
                fail("ExhaustingTestCase.testParseDoubleVariableDeclaration() No column info checked; stack trace correct unless a column number was expected.");
            }
        } else {
            fail("ExhaustingTestCase The stack trace does not correspond to the expected one! \nExpected error type: "
                    + expected
                    + "\nExpected error column: "
                    + expectedIndex
                    + "\n actual stacktrace: " + stackTrace);
        }
    }

    protected void reportUnexpectedStacktrace(String stackTrace) {
        // assertEquals(0, stackTrace.length());
        if (stackTrace.length() != 0) {
            fail("ExhaustingTestCase There should not have been a stacktrace!\n actual stacktrace: "
                    + stackTrace);
        }
    }

    protected void expectedCorrect(OPPLScript result) {
        reportUnexpectedStacktrace(popStackTrace());
        assertNotNull(result);
    }
}
