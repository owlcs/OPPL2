package org.coode.oppl.test;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;
import net.sf.saxon.exslt.Math;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.utils.ParserFactory;
import org.mindswap.pellet.owlapi.PelletReasonerFactory;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.inference.OWLReasonerFactory;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLOntologyURIMapper;
import org.semanticweb.owl.util.AutoURIMapper;

public abstract class AbstractTestCase extends TestCase {
	private static final int TOLERANCE = 3;
	// ontology file for tests
	private static String baseURI = "file:///"
			+ new File("../OPPL2/ontologies/").getAbsolutePath() + "/";
	// ontology manager
	protected static OWLOntologyManager ontologyManager = OWLManager
			.createOWLOntologyManager();
	// ontology for tests
	private OWLOntologyURIMapper siemensmapper = new AutoURIMapper(new File(
			"../OPPL2/ontologies/"), true);
	//private static Map<String, OWLOntology> cache = new HashMap<String, OWLOntology>();
	protected TestQueries testQueries = new TestQueries();

	public AbstractTestCase() {
		ontologyManager.addURIMapper(this.siemensmapper);
	}

	public OWLOntologyManager getOntologyManager() {
		return ontologyManager;
	}

	public OWLOntology getOntology(String name) {
		try {
			//			if (cache.containsKey(name)) {
			//				return cache.get(name);
			//			}
			OWLOntology o = ontologyManager.loadOntologyFromPhysicalURI(URI
					.create(baseURI + name));
			//cache.put(name, o);
			return o;
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			ChangeExtractor changeExtractor = new ChangeExtractor(script
					.getConstraintSystem(), true);
			List<OWLAxiomChange> changes = script.accept(changeExtractor);
			List<OWLAxiomChange> actions = new ArrayList<OWLAxiomChange>();
			changeExtractor.visitActions(changes, actions);
			try {
				changeExtractor.getConstraintSystem().getOntologyManager()
						.applyChanges(actions);
			} catch (OWLOntologyChangeException e) {
				e.printStackTrace();
			}
			for (OWLAxiomChange change : actions) {
				System.out.println(change);
			}
		} catch (Exception e) {
			this.log(e);
		}
		this.testQueries.testQueryManualExpected(expected, script,
				ontologyManager, ontology);
	}

	protected void init(String name) {
		ParserFactory.initParser(";", this.getOntology(name), ontologyManager,
				null);
		//		OWLModelManager manager = new OWLModelManagerImpl();
		//		manager.setActiveOntology(this.getOntology(name));
		//		OWLEntityChecker test = new ProtegeOWLEntityChecker(manager);
		//		ParserFactory.getInstance().getOPPLFactory().setOWLEntityChecker(test);
	}

	@Override
	protected void setUp() throws Exception {
		// reload the ontology for each test;
		// tests are independent of each other
		this.init("test.owl");
		this.testQueries.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		this.lastStackTrace = new StringWriter();
		this.p = new PrintWriter(this.lastStackTrace);
		super.tearDown();
	}

	protected String popStackTrace() {
		String toReturn = this.lastStackTrace.toString();
		this.lastStackTrace = new StringWriter();
		this.p = new PrintWriter(this.lastStackTrace);
		return toReturn;
	}

	protected OWLReasoner initReasoner(OWLOntology... ontologies)
			throws OWLReasonerException {
		OWLReasonerFactory reasonerFactory = new PelletReasonerFactory();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontologyManager);
		reasoner.loadOntologies(new HashSet<OWLOntology>(Arrays
				.asList(ontologies)));
		reasoner.classify();
		return reasoner;
	}

	protected OWLReasoner initDummyReasoner() throws OWLReasonerException {
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
			OPPLParser parser = ParserFactory.initParser(script, this
					.getOntology("test.owl"), ontologyManager, testReasoner);
			return parser.Start();
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

	protected OPPLScript parse(String script, String ontology,
			OWLEntityChecker checker) {
		try {
			if (testReasoner == null) {
				testReasoner = this.initReasoner(this.getOntology(ontology));
			}
			OPPLParser parser = ParserFactory.initParser(script, this
					.getOntology("test.owl"), ontologyManager, testReasoner);
			parser.getOPPLFactory().setOWLEntityChecker(checker);
			return parser.Start();
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
						System.out
								.println("ExhaustingTestCase.testParseDoubleVariableDeclaration() Correct stack trace");
					} else {
						System.out
								.println("ExhaustingTestCase The error type is correct but the column does not match the expected one. Expected error column: "
										+ expectedIndex);
						System.out.println(stackTrace);
					}
				} catch (NumberFormatException e) {
					System.out
							.println("ExhaustingTestCase.checkProperStackTrace() Could not parse a column number to verify the correctness of the stack trace:\nExpected error type: "
									+ expected
									+ "\nExpected error column: "
									+ expectedIndex);
					System.out.println(stackTrace);
				}
			} else {
				// there is no full stop after the expected string. No column
				// number info should be available
				System.out
						.println("ExhaustingTestCase.testParseDoubleVariableDeclaration() No column info checked; stack trace correct unless a column number was expected.");
			}
		} else {
			System.out
					.println("ExhaustingTestCase The stack trace does not correspond to the expected one! \nExpected error type: "
							+ expected
							+ "\nExpected error column: "
							+ expectedIndex);
			System.out.println(stackTrace);
		}
	}

	protected void reportUnexpectedStacktrace(String stackTrace) {
		// assertEquals(0, stackTrace.length());
		if (stackTrace.length() != 0) {
			System.out
					.println("ExhaustingTestCase There should not have been a stacktrace!");
			System.out.println(stackTrace);
		}
	}

	protected void expectedCorrect(OPPLScript result) {
		this.reportUnexpectedStacktrace(this.popStackTrace());
		assertNotNull(result);
	}
}
