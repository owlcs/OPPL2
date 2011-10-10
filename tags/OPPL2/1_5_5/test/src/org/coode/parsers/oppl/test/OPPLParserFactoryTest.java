package org.coode.parsers.oppl.test;

import java.io.InputStream;
import java.util.Arrays;

import junit.framework.TestCase;

import org.coode.oppl.AnnotationBasedSymbolTableFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.parsers.common.JUnitTestErrorListener;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class OPPLParserFactoryTest extends TestCase {
	private OPPLScript parseScript(String opplString, OWLOntologyManager ontologyManager,
			OWLOntology testOntology, SymbolTableFactory<OPPLSymbolTable> symbolTableFactory) {
		OPPLParser parser = new ParserFactory(ontologyManager, testOntology, null).build(
				new JUnitTestErrorListener(),
				symbolTableFactory);
		return parser.parse(opplString);
	}

	public void testNewEntityCreationInline() {
		String opplString = "?A:CLASS SELECT ?A SubClassOf 'Heart disease (disorder)' BEGIN ADD ?A SubClassOf !Candidate END;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		try {
			InputStream in = this.getClass().getResourceAsStream("entire-june-21-prop-paths.owl");
			assertNotNull(in);
			OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(in);
			AnnotationBasedSymbolTableFactory annotationBasedSymbolTableFactory = new AnnotationBasedSymbolTableFactory(
					ontologyManager,
					Arrays.asList(ontologyManager.getOWLDataFactory().getRDFSLabel().getIRI()));
			OPPLScript parsedScript = this.parseScript(
					opplString,
					ontologyManager,
					ontology,
					annotationBasedSymbolTableFactory);
			assertNotNull(parsedScript);
			System.out.println(parsedScript);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
