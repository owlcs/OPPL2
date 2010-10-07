package org.coode.oppl.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;
import net.sf.saxon.exslt.Math;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.SystemErrorEcho;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyDocumentAlreadyExistsException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

public abstract class AbstractTestCase extends TestCase {
	private final Map<String, OWLOntology> loadedOntologies = new HashMap<String, OWLOntology>();
	private static final int TOLERANCE = 3;
	// ontology manager
	protected OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
	protected TestQueries testQueries = new TestQueries();
	private final ErrorListener errorListener = new SystemErrorEcho();

	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	public OWLOntology getOntology(String name) {
		OWLOntology o = this.loadedOntologies.get(name);
		if (o == null) {
			try {
				URL resource = this.getClass().getResource(name);
				if (resource != null) {
					IRI iri = IRI.create(resource.toURI());
					o = this.ontologyManager.contains(iri) ? this.ontologyManager.getOntology(iri)
							: this.ontologyManager.loadOntology(iri);
				} else {
					fail("Could not load the ontology " + name);
				}
			} catch (OWLOntologyDocumentAlreadyExistsException e) {
				o = this.ontologyManager.getOntology(e.getOntologyDocumentIRI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				fail(e.getMessage());
			} catch (OWLOntologyCreationException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
			this.loadedOntologies.put(name, o);
		}
		return o;
	}

	// last generated exception; used to check that the exception being raised
	// is the one being expected
	private StringWriter lastStackTrace = new StringWriter();
	private PrintWriter p = new PrintWriter(this.lastStackTrace);
	// utility methods to set up the ontology, parse a script, check the
	// exceptions
	protected boolean longStackTrace = true;

	protected void execute(OPPLScript script, OWLOntology ontology, int expected) {
		try {
			ChangeExtractor changeExtractor = new ChangeExtractor(script.getConstraintSystem(),
					true);
			List<OWLAxiomChange> changes = script.accept(changeExtractor);
			List<OWLAxiomChange> actions = new ArrayList<OWLAxiomChange>();
			changeExtractor.visitActions(changes, actions);
			for (OWLAxiomChange change : actions) {
				System.out.println(change);
			}
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
					PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
							bindingNode, script.getConstraintSystem());
					for (OWLAxiom owlAxiom : queryAxioms) {
						OWLAxiom match = (OWLAxiom) owlAxiom.accept(partialOWLObjectInstantiator);
						matches.add(match);
						resultWriter.append(match.toString());
						resultWriter.append("\n");
					}
				}
			}
			assertTrue(
					"Query " + script.render() + "\n" + " Actual " + changes.size() + " Expected "
							+ expected + "\n" + resultWriter.toString(),
					matches.size() == expected);
		} catch (Exception e) {
			this.log(e);
		}
	}

	@Override
	protected void setUp() throws Exception {
		VariableExtractor.clear();
		this.testQueries.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		this.lastStackTrace = new StringWriter();
		this.p = new PrintWriter(this.lastStackTrace);
		for (OWLOntology ontology : this.ontologyManager.getOntologies()) {
			this.ontologyManager.removeOntology(ontology);
		}
		super.tearDown();
	}

	protected String popStackTrace() {
		String toReturn = this.lastStackTrace.toString();
		this.lastStackTrace = new StringWriter();
		this.p = new PrintWriter(this.lastStackTrace);
		return toReturn;
	}

	protected OWLReasoner initReasoner(OWLOntology ontology) throws OWLRuntimeException {
		OWLReasonerFactory reasonerFactory = new com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);
		return reasoner;
	}

	protected OWLReasoner initDummyReasoner() throws OWLRuntimeException {
		return null;
	}

	private static OWLReasoner testReasoner = null;

	protected OPPLScript parse(String script) {
		System.out.println("AbstractTestCase.parse() " + script);
		return this.parse(script, "test.owl");
	}

	protected OPPLScript parse(String script, String ontology) {
		try {
			if (testReasoner == null) {
				testReasoner = this.initReasoner(this.getOntology(ontology));
			}
			return this.parse(script, ontology, testReasoner);
		} catch (Exception e) {
			if (this.longStackTrace) {
				e.printStackTrace(this.p);
			} else {
				this.p.print(e.getMessage().replace("\n", "\t"));
			}
			this.p.flush();
		}
		return null;
	}

	protected OPPLScript parse(String script, String ontology, OWLReasoner reasoner) {
		try {
			OPPLParser parser = new ParserFactory(this.ontologyManager, this.getOntology(ontology),
					reasoner).build(this.errorListener);
			return parser.parse(script);
		} catch (Exception e) {
			if (this.longStackTrace) {
				e.printStackTrace(this.p);
			} else {
				this.p.print(e.getMessage().replace("\n", "\t"));
			}
			this.p.flush();
		}
		return null;
	}

	protected void log(Exception e) {
		if (this.longStackTrace) {
			e.printStackTrace(this.p);
		} else {
			this.p.print(e.getMessage().replace("\n", "\t"));
		}
		this.p.flush();
	}

	protected void checkProperStackTrace(String expected, int expectedIndex) {
		String stackTrace = this.popStackTrace();
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
						System.out.println("ExhaustingTestCase.testParseDoubleVariableDeclaration() Correct stack trace");
					} else {
						System.out.println("ExhaustingTestCase The error type is correct but the column does not match the expected one. Expected error column: "
								+ expectedIndex);
						System.out.println(stackTrace);
					}
				} catch (NumberFormatException e) {
					System.out.println("ExhaustingTestCase.checkProperStackTrace() Could not parse a column number to verify the correctness of the stack trace:\nExpected error type: "
							+ expected + "\nExpected error column: " + expectedIndex);
					System.out.println(stackTrace);
				}
			} else {
				// there is no full stop after the expected string. No column
				// number info should be available
				System.out.println("ExhaustingTestCase.testParseDoubleVariableDeclaration() No column info checked; stack trace correct unless a column number was expected.");
			}
		} else {
			System.out.println("ExhaustingTestCase The stack trace does not correspond to the expected one! \nExpected error type: "
					+ expected + "\nExpected error column: " + expectedIndex);
			System.out.println(stackTrace);
		}
	}

	protected void reportUnexpectedStacktrace(String stackTrace) {
		// assertEquals(0, stackTrace.length());
		if (stackTrace.length() != 0) {
			System.out.println("ExhaustingTestCase There should not have been a stacktrace!");
			System.out.println(stackTrace);
		}
	}

	protected void expectedCorrect(OPPLScript result) {
		this.reportUnexpectedStacktrace(this.popStackTrace());
		assertNotNull(result);
	}
}
