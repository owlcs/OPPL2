package org.coode.patterns.test;

import org.coode.oppl.test.AbstractTestCase;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.syntax.PatternParser;
import org.semanticweb.owl.model.OWLOntology;

public class AbstractPatternTestCase extends AbstractTestCase {
	protected void parseCorrect(String formula, OWLOntology o) {
		PatternOPPLScript script = this.parsePattern(formula, o);
		this.expectedCorrect(script);
		this.execute(script, o, formula.contains("$thisClass"));
		this.reportUnexpectedStacktrace(this.popStackTrace());
	}

	protected void parseWrong(String formula, OWLOntology o, String error,
			int index) {
		PatternOPPLScript script = this.parsePattern(formula, o);
		this.checkProperStackTrace(error, index);
		assertNull(script);
	}

	protected void execute(PatternOPPLScript p, OWLOntology o, boolean noClass) {
		TestPatternHarness tph = new TestPatternHarness(o, this
				.getOntologyManager());
		try {
			if (noClass) {
				tph.executeNonClass(p);
			} else {
				tph.executeClass(this.getOntologyManager().getOWLDataFactory()
						.getOWLThing(), p);
			}
		} catch (Exception e) {
			this.log(e);
		}
	}

	protected PatternOPPLScript parsePattern(String pattern, OWLOntology o) {
		try {
			PatternParser p = org.coode.patterns.utils.ParserFactory
					.initParser(pattern, o, this.getOntologyManager(), this
							.initReasoner(o));
			PatternOPPLScript script = p.Start();
			return script;
		} catch (Exception e) {
			this.log(e);
		}
		return null;
	}
}
