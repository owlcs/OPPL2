package org.coode.parsers.oppl.lint.test;

import junit.framework.TestCase;

import org.coode.oppl.lint.OPPLLintParser;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.lint.ParserFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.common.SystemErrorEcho;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class IncorrectOPPLLintTestCase extends TestCase {
	private static final ErrorListener ERROR_LISTENER = new SystemErrorEcho();

	public void testOntologyDoesNotContainEntities() throws Exception {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology ontology = ontologyManager
				.createOntology(IRI
						.create("http://oppl2.sourceforge.net/owllint/transitivePropertyHierachyTest.owl"));
		String script = "Missing display name lint; ?x:CLASS SELECT ?x subClassOf Element or Feature or Consideration RETURN ?x;  ?x is without a display name; Lint that detects Elements Features or Considerations without a display name";
		ParserFactory factory = new ParserFactory(ontology, ontologyManager);
		OPPLLintParser parser = factory
				.build(IncorrectOPPLLintTestCase.ERROR_LISTENER);
		OPPLLintScript parsed = parser.parse(script);
		assertNull(parsed);
		System.out.println(parsed);
	}
}
