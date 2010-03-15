package org.coode.oppl.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import junit.framework.TestCase;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.log.Logging;
import org.coode.oppl.syntax.ParseException;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.PartialOWLObjectInstantiator;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.Assignment;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.io.PhysicalURIInputSource;
import org.semanticweb.owl.model.AxiomType;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLSubClassAxiom;

public class SpecificQueriesTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMBTExportRedundantContentComponentQuery() {
		String opplString = "?x:CLASS SELECT ASSERTED ?x subClassOf OWLClass_01234980498623736000 BEGIN REMOVE ?x subClassOf OWLClass_01234980498623736000 END;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			URI skeletonURI = this.getClass().getResource("skeleton.owl")
					.toURI();
			URI exportURI = this.getClass().getResource("export.owl").toURI();
			ontologyManager
					.loadOntology(new PhysicalURIInputSource(skeletonURI));
			OWLOntology exportOntology = ontologyManager
					.loadOntology(new PhysicalURIInputSource(exportURI));
			OPPLScript opplScript = this.parsescript(opplString,
					ontologyManager, exportOntology);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(changes.size() > 0);
			Logging.getQueryTestLogging().log(Level.INFO,
					"Changes count " + changes.size());
			assertTrue(
					"Instantiated axioms count expected "
							+ this
									.getMBTExportRedundantContentComponentInstantiatedAxioms(
											ontologyManager).size()
							+ " actual "
							+ this.getOPPLScriptInstantiatedAxioms(opplScript)
									.size(),
					this
							.getMBTExportRedundantContentComponentInstantiatedAxioms(
									ontologyManager).size() == this
							.getOPPLScriptInstantiatedAxioms(opplScript).size());
			assertTrue(this.getOPPLLeaves(opplScript).size() == this
					.getMBTExportRedundantContentComponentLeaves(
							opplScript.getConstraintSystem().getVariable("?x"),
							ontologyManager).size());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private OPPLScript parsescript(String opplString,
			OWLOntologyManager ontologyManager, OWLOntology exportOntology)
			throws ParseException {
		OPPLScript opplScript = ParserFactory.initParser(opplString,
				exportOntology, ontologyManager, null).Start();
		return opplScript;
	}

	private Set<BindingNode> getMBTExportRedundantContentComponentLeaves(
			Variable x, OWLOntologyManager manager) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		for (OWLOntology ontology : manager.getOntologies()) {
			Set<OWLSubClassAxiom> subClassAxioms = ontology
					.getSubClassAxiomsForRHS(manager
							.getOWLDataFactory()
							.getOWLClass(
									URI
											.create("http://www.siemens-health.com/SiemensDemo/considerations2documentation.owl#OWLClass_01234980498623736000")));
			for (OWLSubClassAxiom owlSubClassAxiom : subClassAxioms) {
				OWLDescription xValue = owlSubClassAxiom.getSubClass();
				toReturn.add(new BindingNode(new HashSet<Assignment>(Arrays
						.asList(new Assignment(x, xValue))),
						new HashSet<Variable>()));
			}
		}
		return toReturn;
	}

	public void testMBTExportRedundantSubClassesQuery() {
		String opplString = "?x:CLASS, ?y:CLASS, ?z:CLASS SELECT ASSERTED ?x subClassOf ?y, ASSERTED ?y subClassOf ?z, ASSERTED ?x subClassOf ?z BEGIN REMOVE ?x subClassOf ?z END;";
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			URI skeletonURI = this.getClass().getResource("skeleton.owl")
					.toURI();
			URI exportURI = this.getClass().getResource("export.owl").toURI();
			ontologyManager
					.loadOntology(new PhysicalURIInputSource(skeletonURI));
			OWLOntology exportOntology = ontologyManager
					.loadOntology(new PhysicalURIInputSource(exportURI));
			OPPLScript opplScript = this.parsescript(opplString,
					ontologyManager, exportOntology);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue(changes.size() > 0);
			Logging.getQueryTestLogging().log(Level.INFO,
					"Changes count " + changes.size());
			this
					.displaySetDifference(
							this
									.getMBTExportRedundantSubClassesInstantiatedAxioms(ontologyManager),
							this.getOPPLScriptInstantiatedAxioms(opplScript));
			assertTrue("Instantiated axioms count expected "
					+ this.getMBTExportRedundantSubClassesInstantiatedAxioms(
							ontologyManager).size() + " actual "
					+ this.getOPPLScriptInstantiatedAxioms(opplScript).size(),
					this.getMBTExportRedundantSubClassesInstantiatedAxioms(
							ontologyManager).size() == this
							.getOPPLScriptInstantiatedAxioms(opplScript).size());
			assertTrue("Leaves count expected "
					+ this.getOPPLLeaves(opplScript).size()
					+ " actual "
					+ this.getMBTExportRedundantSubClassesLeaves(
							opplScript.getConstraintSystem().getVariable("?x"),
							opplScript.getConstraintSystem().getVariable("?y"),
							opplScript.getConstraintSystem().getVariable("?z"),
							ontologyManager).size(), this.getOPPLLeaves(
					opplScript).size() == this
					.getMBTExportRedundantSubClassesLeaves(
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
		} catch (ParseException e) {
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

	private Set<OWLAxiom> getMBTExportRedundantSubClassesInstantiatedAxioms(
			OWLOntologyManager manager) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		for (OWLOntology ontology : manager.getOntologies()) {
			Set<OWLSubClassAxiom> subClassAxioms = ontology
					.getAxioms(AxiomType.SUBCLASS);
			for (OWLSubClassAxiom subClassAxiom : subClassAxioms) {
				OWLDescription x = subClassAxiom.getSubClass();
				OWLDescription y = subClassAxiom.getSuperClass();
				if (!y.isAnonymous()) {
					for (OWLSubClassAxiom anotherSubClassAxiom : subClassAxioms) {
						if (anotherSubClassAxiom.getSubClass().equals(y)) {
							OWLDescription z = anotherSubClassAxiom
									.getSuperClass();
							if (!z.isAnonymous()) {
								for (OWLSubClassAxiom yetAnotherSubClassAxiom : subClassAxioms) {
									if (yetAnotherSubClassAxiom.getSubClass()
											.equals(x)
											&& yetAnotherSubClassAxiom
													.getSuperClass().equals(z)) {
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
			toReturn
					.addAll(ontology
							.getSubClassAxiomsForRHS(manager
									.getOWLDataFactory()
									.getOWLClass(
											URI
													.create("http://www.siemens-health.com/SiemensDemo/considerations2documentation.owl#OWLClass_01234980498623736000"))));
		}
		return toReturn;
	}

	private Set<BindingNode> getMBTExportRedundantSubClassesLeaves(Variable x,
			Variable y, Variable z, OWLOntologyManager manager) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		for (OWLOntology ontology : manager.getOntologies()) {
			Set<OWLSubClassAxiom> subClassAxioms = ontology
					.getAxioms(AxiomType.SUBCLASS);
			for (OWLSubClassAxiom subClassAxiom : subClassAxioms) {
				OWLDescription xValue = subClassAxiom.getSubClass();
				OWLDescription yValue = subClassAxiom.getSuperClass();
				if (!yValue.isAnonymous()) {
					for (OWLSubClassAxiom anotherSubClassAxiom : subClassAxioms) {
						if (anotherSubClassAxiom.getSubClass().equals(yValue)) {
							OWLDescription zValue = anotherSubClassAxiom
									.getSuperClass();
							if (!zValue.isAnonymous()) {
								for (OWLSubClassAxiom yetAnotherSubClassAxiom : subClassAxioms) {
									if (yetAnotherSubClassAxiom.getSubClass()
											.equals(xValue)
											&& yetAnotherSubClassAxiom
													.getSuperClass().equals(
															zValue)) {
										toReturn
												.add(new BindingNode(
														new HashSet<Assignment>(
																Arrays
																		.asList(
																				new Assignment(
																						x,
																						xValue),
																				new Assignment(
																						y,
																						yValue),
																				new Assignment(
																						z,
																						zValue))),
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
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology testOntology = ontologyManager
					.loadOntology(URI
							.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			String opplString = "?x:CLASS SELECT ASSERTED ?x subClassOf Pizza WHERE ?x!= NamedPizza BEGIN REMOVE ?x subClassOf NamedPizza END;";
			OPPLScript opplScript = this.parsescript(opplString,
					ontologyManager, testOntology);
			ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
					.getConstraintSystem(), true);
			List<OWLAxiomChange> changes = opplScript.accept(changeExtractor);
			assertTrue("Expected empty changes list obtained, instead "
					+ changes, changes.size() == 0);
			Logging.getQueryTestLogging().log(Level.INFO,
					"Changes count " + changes.size());
			Set<BindingNode> leaves = this.getOPPLLeaves(opplScript);
			assertTrue("Expected empty leaf set, obtained, instead "
					+ leaves.toString(), leaves.isEmpty());
			Set<OWLAxiom> instantiatedAxioms = this
					.getOPPLScriptInstantiatedAxioms(opplScript);
			assertTrue(
					"Expected empty instantiated axiom set, obtained, instead "
							+ instantiatedAxioms.toString(), instantiatedAxioms
							.isEmpty());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}