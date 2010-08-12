package org.coode.oppl.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
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
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.log.Logging;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

public class SpecificQueriesTest extends TestCase {
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

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMBTExportRedundantContentComponentQuery() {
		String opplString = "?x:CLASS SELECT ASSERTED ?x subClassOf OWLClass_01234980498623736000 BEGIN REMOVE ?x subClassOf OWLClass_01234980498623736000 END;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		try {
			URI skeletonURI = this.getClass().getResource("skeleton.owl").toURI();
			URI exportURI = this.getClass().getResource("export.owl").toURI();
			ontologyManager.loadOntologyFromOntologyDocument(IRI.create(skeletonURI));
			OWLOntology exportOntology = ontologyManager.loadOntologyFromOntologyDocument(IRI.create(exportURI));
			OPPLScript opplScript = this.parseScript(opplString, ontologyManager, exportOntology);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript.getConstraintSystem(),
					true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(changes.size() > 0);
			Logging.getQueryTestLogging().log(Level.INFO, "Changes count " + changes.size());
			assertTrue(
					"Instantiated axioms count expected "
							+ this.getMBTExportRedundantContentComponentInstantiatedAxioms(
									ontologyManager).size() + " actual "
							+ this.getOPPLScriptInstantiatedAxioms(opplScript).size(),
					this.getMBTExportRedundantContentComponentInstantiatedAxioms(ontologyManager).size() == this.getOPPLScriptInstantiatedAxioms(
							opplScript).size());
			assertTrue(this.getOPPLLeaves(opplScript).size() == this.getMBTExportRedundantContentComponentLeaves(
					opplScript.getConstraintSystem().getVariable("?x"),
					ontologyManager).size());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private OPPLScript parseScript(String opplString, OWLOntologyManager ontologyManager,
			OWLOntology exportOntology) {
		OPPLScript opplScript = new ParserFactory(ontologyManager, exportOntology, null).build(
				this.errorListener).parse(opplString);
		return opplScript;
	}

	private Set<BindingNode> getMBTExportRedundantContentComponentLeaves(Variable x,
			OWLOntologyManager manager) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		for (OWLOntology ontology : manager.getOntologies()) {
			Set<OWLSubClassOfAxiom> subClassAxioms = ontology.getSubClassAxiomsForSuperClass(manager.getOWLDataFactory().getOWLClass(
					IRI.create("http://www.siemens-health.com/SiemensDemo/considerations2documentation.owl#OWLClass_01234980498623736000")));
			for (OWLSubClassOfAxiom owlSubClassAxiom : subClassAxioms) {
				OWLClassExpression xValue = owlSubClassAxiom.getSubClass();
				toReturn.add(new BindingNode(new HashSet<Assignment>(Arrays.asList(new Assignment(
						x, xValue))), new HashSet<Variable>()));
			}
		}
		return toReturn;
	}

	public void testMBTExportRedundantSubClassesQuery() {
		String opplString = "?x:CLASS, ?y:CLASS, ?z:CLASS SELECT ASSERTED ?x subClassOf ?y, ASSERTED ?y subClassOf ?z, ASSERTED ?x subClassOf ?z BEGIN REMOVE ?x subClassOf ?z END;";
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		try {
			URI skeletonURI = this.getClass().getResource("skeleton.owl").toURI();
			URI exportURI = this.getClass().getResource("export.owl").toURI();
			ontologyManager.loadOntologyFromOntologyDocument(IRI.create(skeletonURI));
			OWLOntology exportOntology = ontologyManager.loadOntologyFromOntologyDocument(IRI.create(exportURI));
			OPPLScript opplScript = this.parseScript(opplString, ontologyManager, exportOntology);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript.getConstraintSystem(),
					true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(changes.size() > 0);
			Logging.getQueryTestLogging().log(Level.INFO, "Changes count " + changes.size());
			this.displaySetDifference(
					this.getMBTExportRedundantSubClassesInstantiatedAxioms(ontologyManager),
					this.getOPPLScriptInstantiatedAxioms(opplScript));
			assertTrue(
					"Instantiated axioms count expected "
							+ this.getMBTExportRedundantSubClassesInstantiatedAxioms(
									ontologyManager).size() + " actual "
							+ this.getOPPLScriptInstantiatedAxioms(opplScript).size(),
					this.getMBTExportRedundantSubClassesInstantiatedAxioms(ontologyManager).size() == this.getOPPLScriptInstantiatedAxioms(
							opplScript).size());
			assertTrue(
					"Leaves count expected "
							+ this.getOPPLLeaves(opplScript).size()
							+ " actual "
							+ this.getMBTExportRedundantSubClassesLeaves(
									opplScript.getConstraintSystem().getVariable("?x"),
									opplScript.getConstraintSystem().getVariable("?y"),
									opplScript.getConstraintSystem().getVariable("?z"),
									ontologyManager).size(),
					this.getOPPLLeaves(opplScript).size() == this.getMBTExportRedundantSubClassesLeaves(
							opplScript.getConstraintSystem().getVariable("?x"),
							opplScript.getConstraintSystem().getVariable("?y"),
							opplScript.getConstraintSystem().getVariable("?z"),
							ontologyManager).size());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyCreationException e) {
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

	private Set<OWLAxiom> getMBTExportRedundantSubClassesInstantiatedAxioms(
			OWLOntologyManager manager) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		for (OWLOntology ontology : manager.getOntologies()) {
			Set<OWLSubClassOfAxiom> subClassAxioms = ontology.getAxioms(AxiomType.SUBCLASS_OF);
			for (OWLSubClassOfAxiom subClassAxiom : subClassAxioms) {
				OWLClassExpression x = subClassAxiom.getSubClass();
				OWLClassExpression y = subClassAxiom.getSuperClass();
				if (!y.isAnonymous()) {
					for (OWLSubClassOfAxiom anotherSubClassAxiom : subClassAxioms) {
						if (anotherSubClassAxiom.getSubClass().equals(y)) {
							OWLClassExpression z = anotherSubClassAxiom.getSuperClass();
							if (!z.isAnonymous()) {
								for (OWLSubClassOfAxiom yetAnotherSubClassAxiom : subClassAxioms) {
									if (yetAnotherSubClassAxiom.getSubClass().equals(x)
											&& yetAnotherSubClassAxiom.getSuperClass().equals(z)) {
										toReturn.add(subClassAxiom);
										toReturn.add(anotherSubClassAxiom);
										toReturn.add(yetAnotherSubClassAxiom);
									}
								}
							}
						}
					}
				}
			}
		}
		return toReturn;
	}

	private <T> void displaySetDifference(Set<T> aSet, Set<T> anotherSet) {
		Set<T> biggerSet = aSet.size() >= anotherSet.size() ? aSet : anotherSet;
		Set<T> smallerSet = biggerSet == aSet ? anotherSet : aSet;
		Set<T> difference = new HashSet<T>(biggerSet);
		difference.removeAll(smallerSet);
		for (T t : difference) {
			System.out.println(t);
		}
	}

	private Set<BindingNode> getOPPLLeaves(OPPLScript opplScript) {
		return opplScript.getConstraintSystem().getLeaves();
	}

	private Set<OWLAxiom> getMBTExportRedundantContentComponentInstantiatedAxioms(
			OWLOntologyManager manager) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		for (OWLOntology ontology : manager.getOntologies()) {
			toReturn.addAll(ontology.getSubClassAxiomsForSuperClass(manager.getOWLDataFactory().getOWLClass(
					IRI.create("http://www.siemens-health.com/SiemensDemo/considerations2documentation.owl#OWLClass_01234980498623736000"))));
		}
		return toReturn;
	}

	private Set<BindingNode> getMBTExportRedundantSubClassesLeaves(Variable x, Variable y,
			Variable z, OWLOntologyManager manager) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		for (OWLOntology ontology : manager.getOntologies()) {
			Set<OWLSubClassOfAxiom> subClassAxioms = ontology.getAxioms(AxiomType.SUBCLASS_OF);
			for (OWLSubClassOfAxiom subClassAxiom : subClassAxioms) {
				OWLClassExpression xValue = subClassAxiom.getSubClass();
				OWLClassExpression yValue = subClassAxiom.getSuperClass();
				if (!yValue.isAnonymous()) {
					for (OWLSubClassOfAxiom anotherSubClassAxiom : subClassAxioms) {
						if (anotherSubClassAxiom.getSubClass().equals(yValue)) {
							OWLClassExpression zValue = anotherSubClassAxiom.getSuperClass();
							if (!zValue.isAnonymous()) {
								for (OWLSubClassOfAxiom yetAnotherSubClassAxiom : subClassAxioms) {
									if (yetAnotherSubClassAxiom.getSubClass().equals(xValue)
											&& yetAnotherSubClassAxiom.getSuperClass().equals(
													zValue)) {
										toReturn.add(new BindingNode(new HashSet<Assignment>(
												Arrays.asList(
														new Assignment(x, xValue),
														new Assignment(y, yValue),
														new Assignment(z, zValue))),
												new HashSet<Variable>()));
									}
								}
							}
						}
					}
				}
			}
		}
		return toReturn;
	}

	public void testConstraintsOnPizzaOntology() {
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology testOntology = ontologyManager.loadOntology(IRI.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			String opplString = "?x:CLASS SELECT ASSERTED ?x subClassOf Pizza WHERE ?x!= NamedPizza BEGIN REMOVE ?x subClassOf NamedPizza END;";
			OPPLScript opplScript = this.parseScript(opplString, ontologyManager, testOntology);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript.getConstraintSystem(),
					true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(
					"Expected empty changes list obtained, instead " + changes,
					changes.size() == 0);
			Logging.getQueryTestLogging().log(Level.INFO, "Changes count " + changes.size());
			Set<BindingNode> leaves = this.getOPPLLeaves(opplScript);
			assertTrue(
					"Expected empty leaf set, obtained, instead " + leaves.toString(),
					leaves.isEmpty());
			Set<OWLAxiom> instantiatedAxioms = this.getOPPLScriptInstantiatedAxioms(opplScript);
			assertTrue("Expected empty instantiated axiom set, obtained, instead "
					+ instantiatedAxioms.toString(), instantiatedAxioms.isEmpty());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}