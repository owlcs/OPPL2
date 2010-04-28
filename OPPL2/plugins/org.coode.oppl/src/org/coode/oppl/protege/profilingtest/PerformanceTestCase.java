package org.coode.oppl.protege.profilingtest;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.protege.RenderingOWLEntityChecker;
import org.coode.oppl.test.AbstractTestCase;
import org.coode.oppl.utils.ParserFactory;
import org.protege.editor.owl.model.OWLModelManager;
import org.protege.editor.owl.model.OWLModelManagerImpl;
import org.semanticweb.owl.expression.OWLEntityChecker;

/** This test is to be run for profiling reasons only */
public class PerformanceTestCase extends AbstractTestCase {
	OWLEntityChecker test;

	@Override
	protected void setUp() throws Exception {
		this.init("solomf.owl");
		//this.testQueries.setUp();
	}

	@Override
	protected void init(String name) {
		ParserFactory.initParser(";", this.getOntology(name), ontologyManager,
				null);
		this.test = this.initOwlEntityChecker(name);
	}

	private OWLEntityChecker initOwlEntityChecker(String name) {
		OWLModelManager manager = new OWLModelManagerImpl();
		manager.setActiveOntology(this.getOntology(name));
		return new RenderingOWLEntityChecker(manager);
	}

	public void testScript() {
		String regexp = "Match(\"structural_constituent_of_(\\w+)\")";
		OPPLScript result = this.parse("?regexp:CLASS=" + regexp + ", "
				+ "?x:CLASS=create(?regexp.GROUPS(1)) "
				+ "SELECT ?regexp subClassOf Thing WHERE ?regexp " + regexp
				+ "BEGIN " + "ADD ?regexp subClassOf ?x, " + " END;",
				"solomf.owl", this.test);
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public static void main(String[] args) throws Exception {
		PerformanceTestCase t = new PerformanceTestCase();
		t.setUp();
		t.testScript();
		// infinite cycle: to be used for memory snapshots
		//		while(true);
	}
}
