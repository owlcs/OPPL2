package org.coode.parsers.oppl.lint.test;

import java.util.regex.PatternSyntaxException;



import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.lint.OPPLLintParser;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.lint.ParserFactory;
import org.coode.parsers.common.JUnitTestErrorListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
/** @author Luigi Iannone */
public class CorrectOPPLLintTestCase  {
    private static final JUnitTestErrorListener ERROR_LISTENER = new JUnitTestErrorListener();
    private static final RuntimeExceptionHandler HANDLER = new RuntimeExceptionHandler() {
        public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }

        public void handleOWLRuntimeException(OWLRuntimeException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }

        public void handleException(RuntimeException e) {
            ERROR_LISTENER.reportThrowable(e, 0, 0, 0);
        }
    };

    @Test public void shouldTestTransitivePropertyHierarchy() throws Exception {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager
                .createOntology(IRI
                        .create("http://oppl2.sourceforge.net/owllint/transitivePropertyHierachyTest.owl"));
        String script = "Transitivity in property hierarchies lint; ?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ?y subPropertyOf ?x, Transitive ?y, Transitive ?x  WHERE ?x!= ?y BEGIN REMOVE Transitive ?y END; RETURN ?y; Transitive property ?y is also a sub-property of the Trasitive property ?x; Lint that corrects the undesirable situation in which a transitive object property is sub-property of another transitive object property";
        ParserFactory factory = new ParserFactory(ontology, ontologyManager);
        OPPLLintParser parser = factory.build(CorrectOPPLLintTestCase.ERROR_LISTENER);
        OPPLLintScript parsed = parser.parse(script, HANDLER);
        assertNotNull(parsed);
    }

    @Test public void shouldTestNoActions() throws Exception {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager
                .createOntology(IRI
                        .create("http://oppl2.sourceforge.net/owllint/transitivePropertyHierachyTest.owl"));
        String script = "Missing display name lint; ?x:CLASS SELECT ?x subClassOf Thing or Nothing RETURN ?x;  ?x is without a display name; Lint that detects Thing sub-classes without a display name";
        ParserFactory factory = new ParserFactory(ontology, ontologyManager);
        OPPLLintParser parser = factory.build(CorrectOPPLLintTestCase.ERROR_LISTENER);
        OPPLLintScript parsed = parser.parse(script, HANDLER);
        assertNotNull(parsed);
    }
}
