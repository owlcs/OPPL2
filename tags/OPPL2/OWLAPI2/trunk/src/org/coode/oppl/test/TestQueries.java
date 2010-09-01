package org.coode.oppl.test;

import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.LeafBrusher;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.log.Logging;
import org.coode.oppl.utils.VariableDetector;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.RemoveAxiom;

public class TestQueries extends TestCase {
	private enum DescriptionType {
		// visit(OWLObjectSelfRestriction)
		CLASS, OWLDATARESTRICTION, OWLDATAEXACTCARDINALITYRESTRICTION, OWLDATAMINCARDINALITYRESTRICTION, OWLDATAMAXCARDINALITYRESTRICTION, OWLDATASOMERESTRICTION, OWLDATAVALUERESTRICTION, OWLOBJECTALLRESTRICTION, OWLOBJECTCOMPLEMENTOF, OWLOBJECTEXACTCARDINALITYRESTRICTION, OWLOBJECTINTERSECTIONOF, OWLOBJECTEXACTCARDINALITYRESTRCTION, OWLOBJECTMAXCARDINALITYRESTRICTION, OWLOBJECTMINCARDINALITYRESTRICTION, OWLOBJECTONEOF, OWLOBJECTSOMERESTRICTION, OWLOBJECTUNIONOF, OWLOBJECTVALUERESTRICTION
	}

	private final int valuesCount = 1;
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
	private final static URI TEST_NS = URI
			.create("http://www.co-ode.org/opp/test#");

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	private void buildOntologyForQuery(OPPLScript opplScript,
			OWLOntology testOntology, OWLOntologyManager manager) {
		// Clear test ontology
		this.clearOntology(testOntology, manager);
		List<Variable> inputVariables = opplScript.getInputVariables();
		Map<Variable, Set<OWLObject>> bindings = new HashMap<Variable, Set<OWLObject>>();
		for (Variable variable : inputVariables) {
			bindings.put(variable, this.generateValues(variable, manager));
		}
		BindingNode root = new BindingNode(new HashSet<Assignment>(),
				new HashSet<Variable>(inputVariables));
		LeafBrusher leafBrusher = new LeafBrusher(bindings);
		root.accept(leafBrusher);
		Set<BindingNode> leaves = leafBrusher.getLeaves();
		OPPLQuery query = opplScript.getQuery();
		try {
			if (query != null) {
				List<OWLAxiom> axioms = query.getAssertedAxioms();
				axioms.addAll(query.getAxioms());
				if (leaves != null) {
					for (BindingNode bindingNode : leaves) {
						PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
								bindingNode, opplScript.getConstraintSystem());
						for (OWLAxiom owlAxiom : axioms) {
							manager.addAxiom(testOntology, (OWLAxiom) owlAxiom
									.accept(partialOWLObjectInstantiator));
						}
					}
				}
			}
		} catch (OWLOntologyChangeException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * @param testOntology
	 * @param manager
	 */
	private void clearOntology(OWLOntology testOntology,
			OWLOntologyManager manager) {
		for (OWLAxiom axiom : testOntology.getAxioms()) {
			try {
				manager.applyChange(new RemoveAxiom(testOntology, axiom));
			} catch (OWLOntologyChangeException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}
	}

	private Set<OWLObject> generateValues(Variable variable,
			OWLOntologyManager manager) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		int questionMarkIndex = variable.getName().indexOf('?');
		String fragment = questionMarkIndex != -1 ? variable.getName()
				.substring(questionMarkIndex + 1) : variable.getName();
		for (int i = 0; i < this.valuesCount; i++) {
			toReturn.add(this.generateValue(fragment + "_" + i, variable,
					manager.getOWLDataFactory()));
		}
		return toReturn;
	}

	private OWLObject generateValue(final String string, Variable variable,
			final OWLDataFactory dataFactory) {
		VariableTypeVisitorEx<OWLObject> visitor = new VariableTypeVisitorEx<OWLObject>() {
			public OWLObject visit(SingleValueGeneratedVariable<?> v) {
				return v.getType().buildOWLObject(dataFactory,
						URI.create(TEST_NS.toString() + string), null);
			}

			public OWLObject visit(INDIVIDUALVariable v) {
				return dataFactory.getOWLIndividual(URI.create(TEST_NS
						.toString()
						+ string));
			}

			public OWLObject visit(DATAPROPERTYVariable v) {
				return dataFactory.getOWLDataProperty(URI.create(TEST_NS
						.toString()
						+ string));
			}

			public OWLObject visit(OBJECTPROPERTYVariable v) {
				return dataFactory.getOWLObjectProperty(URI.create(TEST_NS
						.toString()
						+ string));
			}

			public OWLObject visit(CONSTANTVariable v) {
				return dataFactory.getOWLUntypedConstant(string);
			}

			public OWLObject visit(CLASSVariable v) {
				return dataFactory.getOWLClass(URI.create(TEST_NS.toString()
						+ string));
			}
		};
		return variable.accept(visitor);
		// switch (variable.getType()) {
		// case CLASS:
		//
		// case OBJECTPROPERTY:
		// case DATAPROPERTY:
		// case INDIVIDUAL:
		// case CONSTANT:
		// default:
		// return null;
		// }
	}

	// TRANSITIVE_OBJECT_PROPERTY : AxiomType<OWLTransitiveObjectPropertyAxiom>
	public void testTransitiveObjectPropertyQuery() {
		String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED Transitive ?x BEGIN ADD transitive ?x END;";
		this.genericTestQuery(opplString);
	}

	public void genericTestQuery(String opplString) {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			this.testQuery(opplScript, ontologyManager, testOntology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void genericTestQuery(OPPLScript opplScript) {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			this.testQuery(opplScript, ontologyManager, testOntology);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private OPPLScript parseScript(String opplString,
			OWLOntologyManager ontologyManager, OWLOntology testOntology) {
		OPPLParser parser = new ParserFactory(ontologyManager, testOntology,
				null).build(this.errorListener);
		return parser.parse(opplString);
	}

	public void testSymmetricObjectPropertyQuery() {
		String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED symmetric ?x BEGIN ADD symmetric ?x END;";
		this.genericTestQuery(opplString);
	}

	public void testReflexiveObjectPropertyQuery() {
		String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED reflexive ?x BEGIN ADD reflexive ?x END;";
		this.genericTestQuery(opplString);
	}

	public void testIrreflexiveObjectPropertyQuery() {
		String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED Irreflexive ?x BEGIN ADD Irreflexive ?x END;";
		this.genericTestQuery(opplString);
	}

	public void testInverseObjectPropertiesQuery() {
		String opplString = "?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ASSERTED ?x InverseOf ?y BEGIN ADD ?x InverseOf ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testInverseFunctionalObjectPropertiesQuery() {
		String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED InverseFunctional ?x BEGIN ADD InverseFunctional ?x END;";
		this.genericTestQuery(opplString);
	}

	public void testFunctionalDataPropertiesQuery() {
		String opplString = "?x:DATAPROPERTY SELECT ASSERTED Functional ?x BEGIN ADD Functional ?x END;";
		this.genericTestQuery(opplString);
	}

	public void testFunctionalObjectPropertiesQuery() {
		String opplString = "?x:OBJECTPROPERTY SELECT ASSERTED Functional ?x BEGIN ADD Functional ?x END;";
		this.genericTestQuery(opplString);
	}

	public void testEquivalentObjectPropertiesQuery() {
		String opplString = "?x:OBJECTPROPERTY,?y:OBJECTPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testEquivalentDataPropertiesQuery() {
		String opplString = "?x:DATAPROPERTY,?y:DATAPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testEquivalentClassesQuery() {
		String opplString = "?x:CLASS,?y:CLASS SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDisjointObjectPropertiesQuery() {
		String opplString = "?x:OBJECTPROPERTY,?y:OBJECTPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDisjointDataPropertiesQuery() {
		String opplString = "?x:DATAPROPERTY,?y:DATAPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDisjointClassesQuery() {
		String opplString = "?x:CLASS,?y:CLASS SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDataPropertyRangeQuery() {
		String opplString = "?x:DATAPROPERTY SELECT ASSERTED ?x range int BEGIN ADD ?x range int END;";
		this.genericTestQuery(opplString);
	}

	public void testObjectPropertyDomainQuery() {
		String opplString = "?x:OBJECTPROPERTY, ?y:CLASS SELECT ASSERTED ?x domain ?y BEGIN ADD ?x domain ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testObjectPropertyRangeQuery() {
		String opplString = "?x:OBJECTPROPERTY, ?y:CLASS SELECT ASSERTED ?x range ?y BEGIN ADD ?x range ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDataPropertyDomainQuery() {
		String opplString = "?x:DATAPROPERTY, ?y:CLASS SELECT ASSERTED	?x domain ?y  BEGIN ADD ?x domain ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testSameIndividualsQuery() {
		String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL SELECT ASSERTED ?x  SameAs  ?y BEGIN ADD ?x  DifferentFrom ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDifferentIndividualsQuery() {
		String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL SELECT ASSERTED ?x  DifferentFrom  ?y BEGIN ADD ?x  DifferentFrom ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testNegativeObjectPropertyAssertionQuery() {
		String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL,?z:OBJECTPROPERTY SELECT ASSERTED not ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testObjectPropertyAssertionQuery() {
		String opplString = "?x:INDIVIDUAL,?y:INDIVIDUAL,?z:OBJECTPROPERTY SELECT ASSERTED ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testNegativeDataPropertyAssertionQuery() {
		String opplString = "?x:INDIVIDUAL,?y:CONSTANT,?z:DATAPROPERTY SELECT ASSERTED not ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testDataPropertyAssertionQuery() {
		String opplString = "?x:INDIVIDUAL,?y:CONSTANT,?z:DATAPROPERTY SELECT ASSERTED ?x ?z ?y BEGIN ADD ?x ?z ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testSubClassQuery() {
		String opplString = "?x:CLASS,?y:CLASS SELECT ASSERTED ?x subClassOf ?y BEGIN ADD ?x subClassOf ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testComplexSubClassUnaryQueries() {
		try {
			OWLOntologyManager ontologyManager = OWLManager
					.createOWLOntologyManager();
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLOntology testOntology = ontologyManager.createOntology(TEST_NS);
			OPPLAbstractFactory opplFactory = new OPPLFactory(ontologyManager,
					testOntology, null);
			ConstraintSystem cs = opplFactory.createConstraintSystem();
			Set<OWLDescription> subClasses = this.generateClasses(dataFactory,
					0, cs);
			Set<OWLDescription> superClasses = this.generateClasses(
					dataFactory, 1, cs);
			VariableExtractor variableExtractor = new VariableExtractor(cs,
					false);
			int testSize = subClasses.size() * superClasses.size();
			int i = 1;
			for (OWLDescription subClass : subClasses) {
				for (OWLDescription superClass : superClasses) {
					OWLSubClassAxiom axiom = dataFactory.getOWLSubClassAxiom(
							subClass, superClass);
					Set<Variable> variables = variableExtractor
							.extractVariables(axiom);
					OPPLQuery query = opplFactory.buildNewQuery(cs);
					query.addAssertedAxiom(axiom);
					ArrayList<OWLAxiomChange> actions = new ArrayList<OWLAxiomChange>();
					actions.add(new AddAxiom(testOntology, axiom));
					OPPLScript opplScript = opplFactory.buildOPPLScript(cs,
							new ArrayList<Variable>(variables), query, actions);
					Logging.getQueryTestLogging().log(Level.INFO,
							i++ + " out of " + testSize);
					this.testQuery(opplScript, ontologyManager, testOntology);
				}
			}
		} catch (OPPLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testBinarySubClassQuery() {
		String opplString = "?x:CLASS,?y:CLASS, ?z:CLASS SELECT ASSERTED ?x subClassOf ?z, ASSERTED ?y subClassOf ?z BEGIN ADD ?x subClassOf ?y END;";
		this.genericTestQuery(opplString);
		opplString = "?x:CLASS,?y:CLASS, ?z:CLASS SELECT ASSERTED ?x subClassOf ?y, ASSERTED ?x subClassOf ?z BEGIN ADD ?x subClassOf ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testSubDataPropertyQuery() {
		String opplString = "?x:DATAPROPERTY,?y:DATAPROPERTY SELECT ASSERTED ?x subPropertyOf ?y BEGIN ADD ?x subPropertyOf ?y END;";
		this.genericTestQuery(opplString);
	}

	public void testSubObjectPropertyQuery() {
		String opplString = "?x:OBJECTPROPERTY,?y:OBJECTPROPERTY SELECT ASSERTED ?x subPropertyOf ?y BEGIN ADD ?x subPropertyOf ?y END;";
		this.genericTestQuery(opplString);
	}

	private void testQuery(OPPLScript opplScript,
			OWLOntologyManager ontologyManager, OWLOntology testOntology) {
		this.buildOntologyForQuery(opplScript, testOntology, ontologyManager);
		Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
		StringWriter resultWriter = new StringWriter();
		for (OWLAxiom owlAxiom : results) {
			resultWriter.append(owlAxiom.toString());
			resultWriter.append("\n");
		}
		OPPLQuery query = opplScript.getQuery();
		if (query != null) {
			List<OWLAxiom> queryAxioms = query.getAssertedAxioms();
			queryAxioms.addAll(query.getAxioms());
			double expected = 0;
			VariableExtractor variableExtractor = new VariableExtractor(
					opplScript.getConstraintSystem(), false);
			for (OWLAxiom owlAxiom : queryAxioms) {
				Set<Variable> axiomVariables = variableExtractor
						.extractVariables(owlAxiom);
				expected += Math.pow(this.valuesCount, axiomVariables.size());
			}
			assertTrue("Query " + opplScript.render() + "\n" + " Actual "
					+ results.size() + " Expected " + expected + "\n"
					+ resultWriter.toString(), results.size() == expected);
		}
		VariableDetector variableDetector = new VariableDetector(opplScript
				.getConstraintSystem());
		for (OWLAxiom owlAxiom : results) {
			assertFalse("Result with variable axiom " + owlAxiom, owlAxiom
					.accept(variableDetector));
		}
	}

	public void testQueryManualExpected(int expected, OPPLScript opplScript,
			OWLOntologyManager ontologyManager, OWLOntology testOntology) {
		this.buildOntologyForQuery(opplScript, testOntology, ontologyManager);
		Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
		StringWriter resultWriter = new StringWriter();
		for (OWLAxiom owlAxiom : results) {
			resultWriter.append(owlAxiom.toString());
			resultWriter.append("\n");
		}
		OPPLQuery query = opplScript.getQuery();
		if (query != null) {
			List<OWLAxiom> queryAxioms = query.getAssertedAxioms();
			queryAxioms.addAll(query.getAxioms());
			assertTrue("Query " + opplScript.render() + "\n" + " Actual "
					+ results.size() + " Expected " + expected + "\n"
					+ resultWriter.toString(), results.size() == expected);
		}
		VariableDetector variableDetector = new VariableDetector(opplScript
				.getConstraintSystem());
		for (OWLAxiom owlAxiom : results) {
			assertFalse("Result with variable axiom " + owlAxiom, owlAxiom
					.accept(variableDetector));
		}
	}

	private Set<OWLAxiom> getOPPLScriptResults(final OPPLScript opplScript) {
		ChangeExtractor changeExtractor = new ChangeExtractor(opplScript
				.getConstraintSystem(), true);
		opplScript.accept(changeExtractor);
		Set<BindingNode> checkLeaves = opplScript.getConstraintSystem()
				.getLeaves();
		final Set<OWLAxiom> correctResults = new HashSet<OWLAxiom>();
		Set<OWLAxiom> queryAxioms = new HashSet<OWLAxiom>();
		if (opplScript.getQuery() != null) {
			queryAxioms.addAll(opplScript.getQuery().getAssertedAxioms());
			queryAxioms.addAll(opplScript.getQuery().getAxioms());
		}
		if (checkLeaves != null && !checkLeaves.isEmpty()) {
			for (BindingNode bindingNode : checkLeaves) {
				PartialOWLObjectInstantiator partialOWLObjectInstantiator = new PartialOWLObjectInstantiator(
						bindingNode, opplScript.getConstraintSystem());
				for (OWLAxiom owlAxiom : queryAxioms) {
					correctResults.add((OWLAxiom) owlAxiom
							.accept(partialOWLObjectInstantiator));
				}
			}
		}
		return correctResults;
	}

	private Set<OWLDescription> generateClasses(OWLDataFactory dataFactory,
			int counter, ConstraintSystem cs) throws OPPLException {
		EnumSet<DescriptionType> descriptionTypes = EnumSet
				.allOf(DescriptionType.class);
		Set<OWLDescription> toReturn = new HashSet<OWLDescription>();
		for (DescriptionType descriptionType : descriptionTypes) {
			Variable classVariable = cs.createVariable("?aClass_" + counter,
					VariableType.CLASS);
			Variable anotherClassVariable = cs.createVariable("?anotherClass_"
					+ counter, VariableType.CLASS);
			Variable dataPropertyVariable = cs.createVariable("?aDataProperty_"
					+ counter, VariableType.DATAPROPERTY);
			Variable objectPropertyVariable = cs
					.createVariable("?anObjectProperty_" + counter,
							VariableType.OBJECTPROPERTY);
			Variable constantVariable = cs.createVariable("?aConstant_"
					+ counter, VariableType.CONSTANT);
			Variable anIndividualVariable = cs.createVariable("?anIndividual_"
					+ counter, VariableType.INDIVIDUAL);
			Variable anotherIndividualVariable = cs.createVariable(
					"?anotherIndividual_" + counter, VariableType.INDIVIDUAL);
			switch (descriptionType) {
			case CLASS:
				toReturn.add(dataFactory.getOWLClass(classVariable.getURI()));
				break;
			case OWLDATAEXACTCARDINALITYRESTRICTION:
				toReturn.add(dataFactory.getOWLDataExactCardinalityRestriction(
						dataFactory.getOWLDataProperty(dataPropertyVariable
								.getURI()), 3));
				break;
			case OWLDATAMAXCARDINALITYRESTRICTION:
				toReturn.add(dataFactory.getOWLDataMaxCardinalityRestriction(
						dataFactory.getOWLDataProperty(dataPropertyVariable
								.getURI()), 3));
				break;
			case OWLDATAMINCARDINALITYRESTRICTION:
				toReturn.add(dataFactory.getOWLDataMinCardinalityRestriction(
						dataFactory.getOWLDataProperty(dataPropertyVariable
								.getURI()), 3));
				break;
			case OWLDATAVALUERESTRICTION:
				toReturn.add(dataFactory.getOWLDataValueRestriction(dataFactory
						.getOWLDataProperty(dataPropertyVariable.getURI()),
						dataFactory.getOWLUntypedConstant(constantVariable
								.getName())));
				break;
			case OWLOBJECTALLRESTRICTION:
				toReturn.add(dataFactory.getOWLObjectAllRestriction(dataFactory
						.getOWLObjectProperty(objectPropertyVariable.getURI()),
						dataFactory.getOWLClass(classVariable.getURI())));
				break;
			case OWLOBJECTCOMPLEMENTOF:
				toReturn.add(dataFactory.getOWLObjectComplementOf(dataFactory
						.getOWLClass(classVariable.getURI())));
				break;
			case OWLOBJECTEXACTCARDINALITYRESTRICTION:
				toReturn.add(dataFactory
						.getOWLObjectExactCardinalityRestriction(dataFactory
								.getOWLObjectProperty(objectPropertyVariable
										.getURI()), 2));
				break;
			case OWLOBJECTINTERSECTIONOF:
				toReturn.add(dataFactory.getOWLObjectIntersectionOf(dataFactory
						.getOWLClass(classVariable.getURI()), dataFactory
						.getOWLClass(anotherClassVariable.getURI())));
				break;
			case OWLOBJECTEXACTCARDINALITYRESTRCTION:
				toReturn.add(dataFactory
						.getOWLObjectExactCardinalityRestriction(dataFactory
								.getOWLObjectProperty(objectPropertyVariable
										.getURI()), 4));
				break;
			case OWLOBJECTMINCARDINALITYRESTRICTION:
				toReturn.add(dataFactory.getOWLObjectMinCardinalityRestriction(
						dataFactory.getOWLObjectProperty(objectPropertyVariable
								.getURI()), 4));
				break;
			case OWLOBJECTSOMERESTRICTION:
				toReturn.add(dataFactory.getOWLObjectSomeRestriction(
						dataFactory.getOWLObjectProperty(objectPropertyVariable
								.getURI()), dataFactory
								.getOWLClass(classVariable.getURI())));
				break;
			case OWLOBJECTONEOF:
				toReturn.add(dataFactory.getOWLObjectOneOf(dataFactory
						.getOWLIndividual(anIndividualVariable.getURI()),
						dataFactory.getOWLIndividual(anotherIndividualVariable
								.getURI())));
				break;
			case OWLOBJECTUNIONOF:
				toReturn.add(dataFactory.getOWLObjectUnionOf(dataFactory
						.getOWLClass(classVariable.getURI()), dataFactory
						.getOWLClass(anotherClassVariable.getURI())));
				break;
			case OWLOBJECTVALUERESTRICTION:
				toReturn.add(dataFactory.getOWLObjectValueRestriction(
						dataFactory.getOWLObjectProperty(objectPropertyVariable
								.getURI()),
						dataFactory.getOWLIndividual(anIndividualVariable
								.getURI())));
				break;
			case OWLOBJECTMAXCARDINALITYRESTRICTION:
				toReturn.add(dataFactory.getOWLObjectMaxCardinalityRestriction(
						dataFactory.getOWLObjectProperty(objectPropertyVariable
								.getURI()), 4));
				break;
			default:
				break;
			}
		}
		return toReturn;
	}

	public void testDoublyMatchingEquivalentObjectProperties() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLObjectProperty aProperty = dataFactory.getOWLObjectProperty(URI
					.create(TEST_NS.toString() + "aProperty"));
			OWLObjectProperty anotherProperty = dataFactory
					.getOWLObjectProperty(URI.create(TEST_NS.toString()
							+ "anotherProperty"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLEquivalentObjectPropertiesAxiom(aProperty,
							anotherProperty)));
			String opplString = "?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingEquivalentDataProperties() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLDataProperty aProperty = dataFactory.getOWLDataProperty(URI
					.create(TEST_NS.toString() + "aProperty"));
			OWLDataProperty anotherProperty = dataFactory
					.getOWLDataProperty(URI.create(TEST_NS.toString()
							+ "anotherProperty"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLEquivalentDataPropertiesAxiom(aProperty,
							anotherProperty)));
			String opplString = "?x:DATAPROPERTY, ?y:DATAPROPERTY SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingDisjointDataProperties() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLDataProperty aProperty = dataFactory.getOWLDataProperty(URI
					.create(TEST_NS.toString() + "aProperty"));
			OWLDataProperty anotherProperty = dataFactory
					.getOWLDataProperty(URI.create(TEST_NS.toString()
							+ "anotherProperty"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLDisjointDataPropertiesAxiom(aProperty,
							anotherProperty)));
			String opplString = "?x:DATAPROPERTY, ?y:DATAPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingDisjointObjectProperties() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLObjectProperty aProperty = dataFactory.getOWLObjectProperty(URI
					.create(TEST_NS.toString() + "aProperty"));
			OWLObjectProperty anotherProperty = dataFactory
					.getOWLObjectProperty(URI.create(TEST_NS.toString()
							+ "anotherProperty"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLDisjointObjectPropertiesAxiom(aProperty,
							anotherProperty)));
			String opplString = "?x:OBJECTPROPERTY, ?y:OBJECTPROPERTY SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingEquivalentClasses() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLClass aClass = dataFactory.getOWLClass(URI.create(TEST_NS
					.toString()
					+ "aClass"));
			OWLClass anotherClass = dataFactory.getOWLClass(URI.create(TEST_NS
					.toString()
					+ "anotherClass"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLEquivalentClassesAxiom(aClass, anotherClass)));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x equivalentTo ?y BEGIN ADD ?x equivalentTo ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingDisjointClasses() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLClass aClass = dataFactory.getOWLClass(URI.create(TEST_NS
					.toString()
					+ "aClass"));
			OWLClass anotherClass = dataFactory.getOWLClass(URI.create(TEST_NS
					.toString()
					+ "anotherClass"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLDisjointClassesAxiom(aClass, anotherClass)));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x disjointWith ?y BEGIN ADD ?x disjointWith ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingSameIndividuals() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLIndividual anIndividual = dataFactory.getOWLIndividual(URI
					.create(TEST_NS.toString() + "anIndividual"));
			OWLIndividual anotherIndividual = dataFactory.getOWLIndividual(URI
					.create(TEST_NS.toString() + "anotherIndividual"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLSameIndividualsAxiom(new HashSet<OWLIndividual>(
							Arrays.asList(anIndividual, anotherIndividual)))));
			String opplString = "?x:INDIVIDUAL, ?y:INDIVIDUAL SELECT ASSERTED ?x SameAs ?y BEGIN ADD ?x SameAs ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingDifferentIndividuals() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLIndividual anIndividual = dataFactory.getOWLIndividual(URI
					.create(TEST_NS.toString() + "anIndividual"));
			OWLIndividual anotherIndividual = dataFactory.getOWLIndividual(URI
					.create(TEST_NS.toString() + "anotherIndividual"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLDifferentIndividualsAxiom(anIndividual,
							anotherIndividual)));
			String opplString = "?x:INDIVIDUAL, ?y:INDIVIDUAL SELECT ASSERTED ?x DifferentFrom ?y BEGIN ADD ?x DifferentFrom ?y END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue(opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testDoublyMatchingClassDescription() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		OWLOntology testOntology;
		try {
			testOntology = ontologyManager.createOntology(TEST_NS);
			OWLDataFactory dataFactory = ontologyManager.getOWLDataFactory();
			OWLClass aClass = dataFactory.getOWLClass(URI.create(TEST_NS
					.toString()
					+ "A"));
			OWLClass anotherClass = dataFactory.getOWLClass(URI.create(TEST_NS
					.toString()
					+ "B"));
			OWLClass yetAnotherClass = dataFactory.getOWLClass(URI
					.create(TEST_NS.toString() + "C"));
			ontologyManager.applyChange(new AddAxiom(testOntology, dataFactory
					.getOWLSubClassAxiom(dataFactory
							.getOWLObjectIntersectionOf(aClass, anotherClass),
							yetAnotherClass)));
			String opplString = "?x:CLASS, ?y:CLASS SELECT ASSERTED ?x and ?y subClassOf C BEGIN ADD ?x and ?y subClassOf C END;";
			OPPLScript opplScript = this.parseScript(opplString,
					ontologyManager, testOntology);
			Set<OWLAxiom> results = this.getOPPLScriptResults(opplScript);
			assertTrue(results.size() == 1);
			assertTrue("Expected 2 Actual "
					+ opplScript.getConstraintSystem().getLeaves().size(),
					opplScript.getConstraintSystem().getLeaves().size() == 2);
			Logging.getQueryTestLogging().log(Level.INFO,
					" Leaves " + opplScript.getConstraintSystem().getLeaves());
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
