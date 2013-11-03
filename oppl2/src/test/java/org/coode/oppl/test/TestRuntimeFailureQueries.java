package org.coode.oppl.test;

import static org.junit.Assert.fail;

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
import org.semanticweb.owlapi.model.OWLRuntimeException;

public class TestRuntimeFailureQueries {
    @Test
    public void testIllegalPattern() {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        try {
            OWLOntology ontology = manager.createOntology();
            // Add an axiom so the query results will be matched against the
            // constraint
            manager.addAxiom(
                    ontology,
                    manager.getOWLDataFactory()
                            .getOWLSubClassOfAxiom(
                                    manager.getOWLDataFactory().getOWLClass(
                                            IRI.create("blah#A")),
                                    manager.getOWLDataFactory().getOWLThing()));
            String script = "?x:CLASS SELECT ?x subClassOf Thing WHERE ?x MATCH (\"+\") BEGIN ADD ?x subClassOf Thing END;";
            ParserFactory parserFactory = new ParserFactory(manager, ontology, null);
            OPPLParser parser = parserFactory.build(new JUnitTestErrorListener());
            OPPLScript parsed = parser.parse(script);
            ChangeExtractor changeExtractor = new ChangeExtractor(
                    new QuickFailRuntimeExceptionHandler(), false);
            changeExtractor.visit(parsed);
            fail("Should not go through");
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (OWLRuntimeException e) {
            fail("Wrong exception " + e.getMessage());
        } catch (PatternSyntaxException e) {
            System.out.println("Right exception thrown" + e);
        } catch (Exception e) {
            fail("Wrong exception " + e.getMessage());
        }
    }
}
