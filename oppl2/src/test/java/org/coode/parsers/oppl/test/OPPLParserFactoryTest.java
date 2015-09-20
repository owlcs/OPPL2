package org.coode.parsers.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.entire;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.coode.oppl.AnnotationBasedSymbolTableFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;

@SuppressWarnings("javadoc")
public class OPPLParserFactoryTest {

    private OPPLScript parseScript(String opplString, OWLOntologyManager ontologyManager,
        OWLOntology testOntology,
        SymbolTableFactory<OPPLSymbolTable> symbolTableFactory) {
        OPPLParser parser = new ParserFactory(ontologyManager, testOntology, null).build(
            new JUnitTestErrorListener(), symbolTableFactory);
        return parser.parse(opplString);
    }

    @Test
    public void shouldTestNewEntityCreationInline() {
        String opplString = "?A:CLASS SELECT ?A SubClassOf 'Heart disease (disorder)' BEGIN ADD ?A SubClassOf !Candidate END;";
        AnnotationBasedSymbolTableFactory annotationBasedSymbolTableFactory = new AnnotationBasedSymbolTableFactory(
            entire.getOWLOntologyManager(), Arrays.asList(OWLRDFVocabulary.RDFS_LABEL
                .getIRI()));
        OPPLScript parsedScript = parseScript(opplString, entire.getOWLOntologyManager(),
            entire, annotationBasedSymbolTableFactory);
        assertNotNull(parsedScript);
    }
}
