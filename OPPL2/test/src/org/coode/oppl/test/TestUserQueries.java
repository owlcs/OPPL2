package org.coode.oppl.test;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.parsers.common.QuickFailErrorListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;

public class TestUserQueries extends TestCase {
	public void testSimpleQuery() {
		String string = "?y:CLASS, ?z:CLASS SELECT ?y subClassOf q some ?z WHERE ?y!=Nothing BEGIN ADD ?y subClassOf p some ?y END;";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.createOntology();
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI
					.create("blah#p"));
			OWLObjectProperty q = dataFactory.getOWLObjectProperty(IRI
					.create("blah#q"));
			OWLClass a = dataFactory.getOWLClass(IRI.create("blah#a"));
			OWLClass b = dataFactory.getOWLClass(IRI.create("blah#b"));
			OWLClass c = dataFactory.getOWLClass(IRI.create("blah#c"));
			// a subClassOf p some b
			// b subClassOf q some c
			OWLSubClassOfAxiom axiom1 = dataFactory.getOWLSubClassOfAxiom(a,
					dataFactory.getOWLObjectSomeValuesFrom(p, b));
			OWLSubClassOfAxiom axiom2 = dataFactory.getOWLSubClassOfAxiom(b,
					dataFactory.getOWLObjectSomeValuesFrom(q, c));
			manager.addAxioms(ontology, new HashSet<OWLAxiom>(Arrays.asList(
					axiom1, axiom2)));
			FaCTPlusPlusReasonerFactory factory = new FaCTPlusPlusReasonerFactory();
			OWLReasoner reasoner = factory.createReasoner(ontology);
			ParserFactory parserFactory = new ParserFactory(manager, ontology,
					reasoner);
			OPPLParser parser = parserFactory
					.build(new QuickFailErrorListener());
			OPPLScript opplScript = parser.parse(string);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			opplScript.accept(changeExtractor);
			Set<BindingNode> leaves = opplScript.getConstraintSystem()
					.getLeaves();
			assertTrue(leaves != null);
			assertFalse(leaves.isEmpty());
			System.out.println(leaves);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testSimpleTwoQueries() {
		String string = "?x:CLASS, ?y:CLASS, ?z:CLASS SELECT ?x subClassOf p some ?y, ?y subClassOf q some ?z WHERE ?x !=Nothing BEGIN ADD ?x subClassOf p some ?y END;";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.createOntology();
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI
					.create("blah#p"));
			OWLObjectProperty q = dataFactory.getOWLObjectProperty(IRI
					.create("blah#q"));
			OWLClass a = dataFactory.getOWLClass(IRI.create("blah#a"));
			OWLClass b = dataFactory.getOWLClass(IRI.create("blah#b"));
			OWLClass c = dataFactory.getOWLClass(IRI.create("blah#c"));
			// a subClassOf p some b
			// b subClassOf q some c
			OWLSubClassOfAxiom axiom1 = dataFactory.getOWLSubClassOfAxiom(a,
					dataFactory.getOWLObjectSomeValuesFrom(p, b));
			OWLSubClassOfAxiom axiom2 = dataFactory.getOWLSubClassOfAxiom(b,
					dataFactory.getOWLObjectSomeValuesFrom(q, c));
			manager.addAxioms(ontology, new HashSet<OWLAxiom>(Arrays.asList(
					axiom1, axiom2)));
			FaCTPlusPlusReasonerFactory factory = new FaCTPlusPlusReasonerFactory();
			OWLReasoner reasoner = factory.createReasoner(ontology);
			ParserFactory parserFactory = new ParserFactory(manager, ontology,
					reasoner);
			OPPLParser parser = parserFactory
					.build(new QuickFailErrorListener());
			OPPLScript opplScript = parser.parse(string);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			opplScript.accept(changeExtractor);
			Set<BindingNode> leaves = opplScript.getConstraintSystem()
					.getLeaves();
			assertTrue(leaves != null);
			assertFalse(leaves.isEmpty());
			System.out.println(leaves);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testSequentialUnion() {
		String string = "?a:CLASS, ?f:CLASS, ?g:CLASS SELECT ?f subClassOf Union_Mapping some ?g, ?g subClassOf has_DPWS_Output some ?a WHERE ?f !=Nothing BEGIN ADD ?f subClassOf Union_Mapping some ?g END;";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.loadOntology(IRI.create(this
					.getClass().getResource("SequentialUnion.owl").toURI()));
			FaCTPlusPlusReasonerFactory factory = new FaCTPlusPlusReasonerFactory();
			OWLReasoner reasoner = factory.createReasoner(ontology);
			ParserFactory parserFactory = new ParserFactory(manager, ontology,
					reasoner);
			OPPLParser parser = parserFactory
					.build(new QuickFailErrorListener());
			OPPLScript opplScript = parser.parse(string);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			opplScript.accept(changeExtractor);
			Set<BindingNode> leaves = opplScript.getConstraintSystem()
					.getLeaves();
			assertTrue(leaves != null);
			assertFalse(leaves.isEmpty());
			System.out.println(leaves);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}