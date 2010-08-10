package org.coode.oppl.test;

import java.io.File;
import java.net.URI;
import java.util.logging.Level;

import junit.framework.TestCase;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.log.Logging;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.SystemErrorEcho;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

public class OPPLPartsTestCase extends TestCase {
	// ontology manager
	private final static OWLOntologyManager ontologyManager = OWLManager
			.createOWLOntologyManager();
	private final ErrorListener errorListener = new SystemErrorEcho();
	// ontology file for tests
	private static String baseURI = "file:///"
			+ new File("../OPPL2/ontologies/").getAbsolutePath() + "/";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected OPPLParser getParser(String ontology) {
		OPPLParser parser = new ParserFactory(ontologyManager, this
				.getOntology(ontology), null).build(this.errorListener);
		return parser;
	}

	private OWLOntology getOntology(String name) {
		try {
			// if (cache.containsKey(name)) {
			// return cache.get(name);
			// }
			OWLOntology o = ontologyManager.loadOntologyFromPhysicalURI(URI
					.create(baseURI + name));
			// cache.put(name, o);
			return o;
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void testParseInSetConstraint() {
		OPPLParser parser = this.getParser("test.owl");
		ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
				.createConstraintSystem();
		OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
				.createSymbolTable();
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?x")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?y")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		AbstractConstraint constraint = parser.parseConstraint("?x!= Thing",
				symbolTable, constraintSystem);
		assertNotNull("The constraint cannot be null", constraint);
		constraint = parser.parseConstraint("?x IN {?y, Thing}", symbolTable,
				constraintSystem);
		assertNotNull("The constraint cannot be null", constraint);
		Logging.getParseTestLogging().log(Level.INFO, constraint.toString());
		constraint = parser.parseConstraint("?Thing and ?y", symbolTable,
				constraintSystem);
		assertNull("The constraint should be null", constraint);
	}

	public void testParseInequalityConstraint() {
		OPPLParser parser = this.getParser("test.owl");
		ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
				.createConstraintSystem();
		OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
				.createSymbolTable();
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?x")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?y")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		AbstractConstraint constraint = parser.parseConstraint("?x!= Thing",
				symbolTable, constraintSystem);
		assertNotNull("The constraint cannot be null", constraint);
		constraint = parser.parseConstraint("?x!= ?y", symbolTable,
				constraintSystem);
		Logging.getParseTestLogging().log(Level.INFO, constraint.toString());
		assertNotNull("The constraint cannot be null", constraint);
		constraint = parser.parseConstraint("?x!= Thing and ?y", symbolTable,
				constraintSystem);
		Logging.getParseTestLogging().log(Level.INFO, constraint.toString());
		assertNotNull("The constraint cannot be null", constraint);
	}

	public void testParseOPPLFunction() {
		OPPLParser parser = this.getParser("test.owl");
		ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
				.createConstraintSystem();
		OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
				.createSymbolTable();
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?x")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?y")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		Variable tempVariable = this.createTempVariable("?z",
				VariableType.CLASS);
		Variable opplFunction = parser.parseOPPLFunction(
				"CreateIntersection(?x.VALUES)", tempVariable, symbolTable,
				constraintSystem);
		assertNotNull("The oppl function cannot be null", opplFunction);
		Logging.getParseTestLogging().log(Level.INFO, opplFunction.toString());
	}

	public void testParseAxiom() {
		OPPLParser parser = this.getParser("test.owl");
		ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
				.createConstraintSystem();
		OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
				.createSymbolTable();
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?x")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?y")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		OWLAxiom axiom = parser.parseAxiom("?x subClassOf !hasP some ?y",
				symbolTable, constraintSystem);
		assertNotNull("The axiom cannot be null", axiom);
		Logging.getParseTestLogging().log(Level.INFO, axiom.toString());
	}

	public void testParseNAFConstraint() {
		OPPLParser parser = this.getParser("NAF.owl");
		ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
				.createConstraintSystem();
		OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
				.createSymbolTable();
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?x")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?y")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		AbstractConstraint constraint = parser.parseConstraint(
				"FAIL ?x subClassOf hasP some ?y", symbolTable,
				constraintSystem);
		assertNotNull("The constraint cannot be null", constraint);
		Logging.getParseTestLogging().log(Level.INFO, constraint.toString());
	}

	public void testParseRegExpConstraint() {
		OPPLParser parser = this.getParser("test.owl");
		ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
				.createConstraintSystem();
		OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
				.createSymbolTable();
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?x")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		symbolTable.defineVariable(this.createImaginaryTreeNode(this
				.createImaginaryToken("?y")), this.createImaginaryTreeNode(this
				.createImaginaryToken("CLASS")), constraintSystem);
		AbstractConstraint constraint = parser.parseConstraint(
				"?x Match(\"Island\")", symbolTable, constraintSystem);
		assertNotNull("The constraint cannot be null", constraint);
		Logging.getParseTestLogging().log(Level.INFO, constraint.toString());
	}

	private Token createImaginaryToken(final String text) {
		return new Token() {
			public void setType(int ttype) {
			}

			public void setTokenIndex(int index) {
			}

			public void setText(String text) {
			}

			public void setLine(int line) {
			}

			public void setInputStream(CharStream input) {
			}

			public void setCharPositionInLine(int pos) {
			}

			public void setChannel(int channel) {
			}

			public int getType() {
				return 0;
			}

			public int getTokenIndex() {
				return 0;
			}

			public String getText() {
				return text;
			}

			public int getLine() {
				return 0;
			}

			public CharStream getInputStream() {
				return null;
			}

			public int getCharPositionInLine() {
				return 0;
			}

			public int getChannel() {
				return 0;
			}
		};
	}

	private ManchesterOWLSyntaxTree createImaginaryTreeNode(Token token) {
		return new ManchesterOWLSyntaxTree(token);
	}

	private Variable createTempVariable(final String name,
			final VariableType type) {
		return new Variable() {
			public void setVariableScope(VariableScope variableScope,
					VariableScopeChecker variableScopeChecker) {
			}

			public VariableScope getVariableScope() {
				return null;
			}

			public URI getURI() {
				return URI.create(ManchesterVariableSyntax.NAMESPACE
						+ this.getName());
			}

			public VariableType getType() {
				return type;
			}

			public String getName() {
				return name;
			}

			public void accept(PlainVariableVisitor visitor) {
				// TODO Auto-generated method stub
			}

			public <P> P accept(VariableTypeVisitorEx<P> visitor) {
				// TODO Auto-generated method stub
				return null;
			}

			public <P> P accept(VariableVisitor<P> visitor) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
