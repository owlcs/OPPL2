package org.coode.oppl.test;

import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

@SuppressWarnings("javadoc")
public class TestRuntimeFailureQueries {

    @Test(expected = PatternSyntaxException.class)
    public void shouldTestIllegalPattern() throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.createOntology();
        // Add an axiom so the query results will be matched against the
        // constraint
        manager.addAxiom(
            ontology,
            manager.getOWLDataFactory().getOWLSubClassOfAxiom(
                manager.getOWLDataFactory().getOWLClass(IRI.create("blah#A")),
                manager.getOWLDataFactory().getOWLThing()));
        String script = "?x:CLASS SELECT ?x subClassOf Thing WHERE ?x MATCH (\"+\") BEGIN ADD ?x subClassOf Thing END;";
        ParserFactory parserFactory = new ParserFactory(manager, ontology, null);
        OPPLParser parser = parserFactory.build(new JUnitTestErrorListener());
        OPPLScript parsed = parser.parse(script);
        ChangeExtractor changeExtractor = new ChangeExtractor(
            new QuickFailRuntimeExceptionHandler(), false);
        changeExtractor.visit(parsed);
    }
}
