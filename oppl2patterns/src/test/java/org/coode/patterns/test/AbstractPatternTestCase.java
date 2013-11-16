package org.coode.patterns.test;

import static org.junit.Assert.assertNull;

import org.coode.parsers.ErrorListener;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.ParserFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.semanticweb.owlapi.model.OWLOntology;

public abstract class AbstractPatternTestCase extends BasePatternTestCase {
    protected void parseCorrect(String formula, OWLOntology o) {
        PatternOPPLScript script = this.parsePattern(formula, o);
        expectedCorrect(script);
        this.execute(script, o, formula.contains("$thisClass"));
        reportUnexpectedStacktrace(popStackTrace());
    }

    protected void parseWrong(String formula, OWLOntology o, ErrorListener errorListener) {
        PatternOPPLScript script = this.parsePattern(formula, o, errorListener);
        assertNull(script);
    }

    protected void execute(PatternOPPLScript p, OWLOntology o, boolean noClass) {
        TestPatternHarness tph = new TestPatternHarness(o, o.getOWLOntologyManager());
        try {
            if (noClass) {
                tph.executeNonClass(p);
            } else {
                tph.executeClass(o.getOWLOntologyManager().getOWLDataFactory()
                        .getOWLThing(), p);
            }
        } catch (Exception e) {
            log(e);
        }
    }

    protected PatternOPPLScript parsePattern(String pattern, OWLOntology o) {
        return this.parsePattern(pattern, o,
                new AbstractExpectedErrorCheckerErrorListener());
    }

    protected PatternOPPLScript parsePattern(String pattern, OWLOntology o,
            ErrorListener errorListener) {
        try {
            OPPLPatternParser p = new ParserFactory(o, o.getOWLOntologyManager())
                    .build(errorListener);
            PatternModel script = p.parse(pattern);
            return script;
        } catch (Exception e) {
            log(e);
        }
        return null;
    }
}
