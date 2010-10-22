package org.coode.oppl.test;

import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.log.Logging;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

public class SpecificInferenceQueries extends TestCase {
	private final static IRI TEST_NS = IRI
			.create("http://www.co-ode.org/opp/test#");
	private final ErrorListener errorListener = new ErrorListener() {
		public void unrecognisedSymbol(CommonTree t) {
			fail("Unrecognised symbol " + t);
		}

		public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
			fail(e.getMessage());
		}

		public void reportThrowable(Throwable t, int line, int charPosInLine,
				int length) {
			fail(t.getMessage() + " at line " + line + " position "
					+ charPosInLine + " length " + length);
		}

		public void recognitionException(RecognitionException e,
				String... tokenNames) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			for (String string : tokenNames) {
				formatter.format("%s ", string);
			}
			fail(e.getMessage() + out.toString());
		}

		public void recognitionException(RecognitionException e) {
			fail(e.getMessage());
		}

		public void incompatibleSymbols(CommonTree parentExpression,
				CommonTree... trees) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			formatter.format("Incompatible symbols in %s ", parentExpression
					.getText());
			for (CommonTree commonTree : trees) {
				formatter.format("%s ", commonTree.getText());
			}
			fail(out.toString());
		}

		public void incompatibleSymbolType(CommonTree t, Type type,
				CommonTree expression) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			formatter.format("Incompatible symbols type [%s] for %s  in %s ",
					type, t.getText(), expression.getText());
			fail(out.toString());
		}

		public void illegalToken(CommonTree t, String message) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			formatter.format("Illegal token %s  additional information: [%s]",
					t, message);
			fail(out.toString());
		}
	};

	public void testTransitiveSubClassClosure() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLClass a = ontologyManager.getOWLDataFactory().getOWLClass(
					IRI.create(TEST_NS.toString() + "A"));
			OWLClass b = ontologyManager.getOWLDataFactory().getOWLClass(
					IRI.create(TEST_NS.toString() + "B"));
			OWLClass c = ontologyManager.getOWLDataFactory().getOWLClass(
					IRI.create(TEST_NS.toString() + "C"));
			ontologyManager.addAxiom(testOntology, ontologyManager
					.getOWLDataFactory().getOWLSubClassOfAxiom(a, b));
			ontologyManager.addAxiom(testOntology, ontologyManager
					.getOWLDataFactory().getOWLSubClassOfAxiom(b, c));
			String opplString = "?x:CLASS SELECT  ?x subClassOf C BEGIN ADD ?x subClassOf A END;";
			// FaCTPlusPlusReasonerFactory factory = new
			// FaCTPlusPlusReasonerFactory();
			OWLReasonerFactory factory = new com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory();
			OWLReasoner reasoner = factory.createReasoner(testOntology);
			OPPLScript opplScript = new ParserFactory(ontologyManager,
					testOntology, reasoner).build(this.errorListener).parse(
					opplString);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(changes.size() > 0);
			Set<OWLAxiom> instantiatedAxioms = this
					.getOPPLScriptInstantiatedAxioms(opplScript);
			assertTrue("Instantiated axioms: " + instantiatedAxioms.size()
					+ " count does not match with the expected (3)",
					instantiatedAxioms.size() == 4);
			for (OWLAxiom axiom : instantiatedAxioms) {
				Logging.getQueryTestLogging().log(Level.INFO, axiom.toString());
			}
			NodeSet<OWLClass> subClasses = reasoner.getSubClasses(c, false);
			Logging.getQueryTestLogging()
					.log(Level.INFO, subClasses.toString());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLRuntimeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private Set<OWLAxiom> getOPPLScriptInstantiatedAxioms(OPPLScript opplScript) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		Set<BindingNode> leaves = opplScript.getConstraintSystem().getLeaves();
		if (leaves != null) {
			for (BindingNode bindingNode : leaves) {
				List<OWLAxiom> queryAxioms = opplScript.getQuery()
						.getAssertedAxioms();
				queryAxioms.addAll(opplScript.getQuery().getAxioms());
				PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
						bindingNode, opplScript.getConstraintSystem());
				for (OWLAxiom axiom : queryAxioms) {
					toReturn.add((OWLAxiom) axiom
							.accept(partialOWLObjectInstantiator));
				}
			}
		}
		return toReturn;
	}
}
