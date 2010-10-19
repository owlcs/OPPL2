package org.coode.patterns.test;

import org.coode.oppl.test.AbstractTestCase;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.common.JUnitTestErrorListener;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.ParserFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.semanticweb.owlapi.model.OWLOntology;

public abstract class AbstractPatternTestCase extends AbstractTestCase {
	private final ErrorListener erroListener = new JUnitTestErrorListener();

	protected void parseCorrect(String formula, OWLOntology o) {
		PatternOPPLScript script = this.parsePattern(formula, o);
		this.expectedCorrect(script);
		this.execute(script, o, formula.contains("$thisClass"));
		this.reportUnexpectedStacktrace(this.popStackTrace());
	}

	protected void parseWrong(String formula, OWLOntology o, ErrorListener errorListener) {
		PatternOPPLScript script = this.parsePattern(formula, o, errorListener);
		assertNull(script);
	}

	protected void execute(PatternOPPLScript p, OWLOntology o, boolean noClass) {
		TestPatternHarness tph = new TestPatternHarness(o, this.getOntologyManager());
		try {
			if (noClass) {
				tph.executeNonClass(p);
			} else {
				tph.executeClass(this.getOntologyManager().getOWLDataFactory().getOWLThing(), p);
			}
		} catch (Exception e) {
			this.log(e);
		}
	}

	protected PatternOPPLScript parsePattern(String pattern, OWLOntology o) {
		return this.parsePattern(pattern, o, this.getErroListener());
	}

	protected PatternOPPLScript parsePattern(String pattern, OWLOntology o,
			ErrorListener errorListener) {
		try {
			OPPLPatternParser p = new ParserFactory(o, ontologyManager).build(errorListener);
			PatternModel script = p.parse(pattern);
			return script;
		} catch (Exception e) {
			this.log(e);
		}
		return null;
	}

	/**
	 * @return the erroListener
	 */
	public ErrorListener getErroListener() {
		return this.erroListener;
	}
}
