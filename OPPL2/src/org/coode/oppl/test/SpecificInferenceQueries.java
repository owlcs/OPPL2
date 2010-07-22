package org.coode.oppl.test;

import java.net.URI;
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
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerAdapter;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

import uk.ac.manchester.cs.factplusplus.protege.FaCTPlusPlusReasonerFactory;

public class SpecificInferenceQueries extends TestCase {
	private final static URI TEST_NS = URI.create("http://www.co-ode.org/opp/test#");
	private final ErrorListener errorListener = new ErrorListener() {
		public void unrecognisedSymbol(CommonTree t) {
			fail("Unrecognised symbol " + t);
		}

		public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
			fail(e.getMessage());
		}

		public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
			fail(t.getMessage() + " at line " + line + " position " + charPosInLine + " length "
					+ length);
		}

		public void recognitionException(RecognitionException e, String... tokenNames) {
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

		public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			formatter.format("Incompatible symbols in %s ", parentExpression.getText());
			for (CommonTree commonTree : trees) {
				formatter.format("%s ", commonTree.getText());
			}
			fail(out.toString());
		}

		public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			formatter.format(
					"Incompatible symbols type [%s] for %s  in %s ",
					type,
					t.getText(),
					expression.getText());
			fail(out.toString());
		}

		public void illegalToken(CommonTree t, String message) {
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			formatter.format("Illegal token %s  additional information: [%s]", t, message);
			fail(out.toString());
		}
	};

	public void testTransitiveSubClassClosure() {
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLClass a = ontologyManager.getOWLDataFactory().getOWLClass(
					URI.create(TEST_NS.toString() + "A"));
			OWLClass b = ontologyManager.getOWLDataFactory().getOWLClass(
					URI.create(TEST_NS.toString() + "B"));
			OWLClass c = ontologyManager.getOWLDataFactory().getOWLClass(
					URI.create(TEST_NS.toString() + "C"));
			ontologyManager.addAxiom(
					testOntology,
					ontologyManager.getOWLDataFactory().getOWLSubClassAxiom(a, b));
			ontologyManager.addAxiom(
					testOntology,
					ontologyManager.getOWLDataFactory().getOWLSubClassAxiom(b, c));
			String opplString = "?x:CLASS SELECT  ?x subClassOf C BEGIN ADD ?x subClassOf A END;";
			FaCTPlusPlusReasonerFactory factory = new FaCTPlusPlusReasonerFactory();
			OWLReasoner reasoner = factory.createReasoner(ontologyManager);
			OPPLScript opplScript = new ParserFactory(ontologyManager, testOntology, reasoner).build(
					this.errorListener).parse(opplString);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript.getConstraintSystem(),
					true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(changes.size() > 0);
			Set<OWLAxiom> instantiatedAxioms = this.getOPPLScriptInstantiatedAxioms(opplScript);
			assertTrue("Instantiated axioms: " + instantiatedAxioms.size()
					+ " count does not match with the expected (3)", instantiatedAxioms.size() == 3);
			for (OWLAxiom axiom : instantiatedAxioms) {
				Logging.getQueryTestLogging().log(Level.INFO, axiom.toString());
			}
			Set<OWLClass> subClasses = OWLReasonerAdapter.flattenSetOfSets(reasoner.getDescendantClasses(c));
			Logging.getQueryTestLogging().log(Level.INFO, subClasses.toString());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLReasonerException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private Set<OWLAxiom> getOPPLScriptInstantiatedAxioms(OPPLScript opplScript) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		Set<BindingNode> leaves = opplScript.getConstraintSystem().getLeaves();
		if (leaves != null) {
			for (BindingNode bindingNode : leaves) {
				List<OWLAxiom> queryAxioms = opplScript.getQuery().getAssertedAxioms();
				queryAxioms.addAll(opplScript.getQuery().getAxioms());
				PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
						bindingNode, opplScript.getConstraintSystem());
				for (OWLAxiom axiom : queryAxioms) {
					toReturn.add((OWLAxiom) axiom.accept(partialOWLObjectInstantiator));
				}
			}
		}
		return toReturn;
	}
}
