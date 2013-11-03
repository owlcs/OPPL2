package org.coode.parsers.oppl.test;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.Arrays;

import org.coode.oppl.AnnotationBasedSymbolTableFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class OPPLParserFactoryTest {
    private OPPLScript parseScript(String opplString, OWLOntologyManager ontologyManager,
            OWLOntology testOntology,
            SymbolTableFactory<OPPLSymbolTable> symbolTableFactory) {
        OPPLParser parser = new ParserFactory(ontologyManager, testOntology, null).build(
                new JUnitTestErrorListener(), symbolTableFactory);
        return parser.parse(opplString);
    }

    @Test
    public void testNewEntityCreationInline() throws OWLOntologyCreationException {
        String opplString = "?A:CLASS SELECT ?A SubClassOf 'Heart disease (disorder)' BEGIN ADD ?A SubClassOf !Candidate END;";
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        InputStream in = this.getClass().getResourceAsStream(
                "/entire-june-21-prop-paths.owl");
        assertNotNull(in);
        OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(in);
        AnnotationBasedSymbolTableFactory annotationBasedSymbolTableFactory = new AnnotationBasedSymbolTableFactory(
                ontologyManager, Arrays.asList(ontologyManager.getOWLDataFactory()
                        .getRDFSLabel().getIRI()));
        OPPLScript parsedScript = parseScript(opplString, ontologyManager, ontology,
                annotationBasedSymbolTableFactory);
        assertNotNull(parsedScript);
        System.out.println(parsedScript);
    }
}
