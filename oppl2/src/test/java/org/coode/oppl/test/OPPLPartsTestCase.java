package org.coode.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.*;
import static org.junit.Assert.*;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.PatternSyntaxException;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.log.Logging;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.junit.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;

@SuppressWarnings("javadoc")
public class OPPLPartsTestCase {
    ErrorListener errorListener = new SilentListener();
    private final RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
        @Override
        public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
            errorListener.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleOWLRuntimeException(OWLRuntimeException e) {
            errorListener.reportThrowable(e, 0, 0, 0);
        }

        @Override
        public void handleException(RuntimeException e) {
            errorListener.reportThrowable(e, 0, 0, 0);
        }
    };

    protected OPPLParser getParser(OWLOntology ontology) {
        OPPLParser parser = new ParserFactory(ontology.getOWLOntologyManager(), ontology,
                null).build(errorListener);
        return parser;
    }

    @Test
    public void testParseInSetConstraint() {
        OPPLParser parser = getParser(test);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        AbstractConstraint constraint = parser.parseConstraint("?x!= Thing", symbolTable,
                constraintSystem);
        assertNotNull("The constraint cannot be null", constraint);
        constraint = parser.parseConstraint("?x IN {?y, Thing}", symbolTable,
                constraintSystem);
        assertNotNull("The constraint cannot be null", constraint);
        Logging.getParseTestLogging().info(constraint);
        constraint = parser.parseConstraint("?Thing and ?y", symbolTable,
                constraintSystem);
        assertNull("The constraint should be null", constraint);
    }

    @Test
    public void testParseInequalityConstraint() {
        OPPLParser parser = getParser(test);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        AbstractConstraint constraint = parser.parseConstraint("?x!= Thing", symbolTable,
                constraintSystem);
        assertNotNull("The constraint cannot be null", constraint);
        constraint = parser.parseConstraint("?x!= ?y", symbolTable, constraintSystem);
        Logging.getParseTestLogging().info(constraint);
        assertNotNull("The constraint cannot be null", constraint);
        constraint = parser.parseConstraint("?x!= Thing and ?y", symbolTable,
                constraintSystem);
        Logging.getParseTestLogging().info(constraint);
        assertNotNull("The constraint cannot be null", constraint);
    }

    @Test
    public void testParseOPPLFunction() {
        OPPLParser parser = getParser(test);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        Variable<?> tempVariable = this.createTempVariable("?z",
                VariableTypeFactory.getCLASSVariableType());
        Variable<?> opplFunction = parser.parseOPPLFunction(
                "CreateIntersection(?x.VALUES)", tempVariable, symbolTable,
                constraintSystem);
        assertNotNull("The oppl function cannot be null", opplFunction);
        Logging.getParseTestLogging().info(opplFunction, constraintSystem);
    }

    @Test
    public void testParseOPPLFunctionAggregatingLooseObjectAndVariableValues() {
        OPPLParser parser = getParser(test);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        Variable<?> tempVariable = this.createTempVariable("?z",
                VariableTypeFactory.getCLASSVariableType());
        Variable<?> opplFunction = parser.parseOPPLFunction(
                "CreateIntersection(?x.VALUES, Thing)", tempVariable, symbolTable,
                constraintSystem);
        assertNotNull("The oppl function cannot be null", opplFunction);
        BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
        bindingNode.addAssignment(new Assignment(constraintSystem.getVariable("?x"),
                constraintSystem.getOntologyManager().getOWLDataFactory()
                        .getOWLClass(IRI.create("blah#Luigi"))));
        BindingNode anotherBindingNode = BindingNode.createNewEmptyBindingNode();
        anotherBindingNode.addAssignment(new Assignment(constraintSystem
                .getVariable("?x"), constraintSystem.getOntologyManager()
                .getOWLDataFactory().getOWLClass(IRI.create("blah#Monica"))));
        constraintSystem.setLeaves(new HashSet<BindingNode>(Arrays.asList(bindingNode,
                anotherBindingNode)));
        final ValueComputationParameters parameters = new SimpleValueComputationParameters(
                constraintSystem, BindingNode.createNewEmptyBindingNode(), handler);
        Logging.getParseTestLogging().info(opplFunction, constraintSystem);
        opplFunction.accept(new VariableVisitor() {
            @Override
            public <P extends OWLObject> void visit(
                    RegexpGeneratedVariable<P> regExpGenerated) {
                fail("Wrong kind of variable expected generated variable found regexp ");
            }

            @Override
            public <P extends OWLObject> void visit(GeneratedVariable<P> v) {
                P value = v.getOPPLFunction().compute(parameters);
                assertNotNull(value);
            }

            @Override
            public <P extends OWLObject> void visit(InputVariable<P> v) {
                fail("Wrong kind of variable expected generated variable found input ");
            }
        });
    }

    @Test
    public void testParseAxiom() {
        OPPLParser parser = getParser(test);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        OWLAxiom axiom = parser.parseAxiom("?x subClassOf !hasP some ?y", symbolTable,
                constraintSystem);
        assertNotNull("The axiom cannot be null", axiom);
    }

    @Test
    public void testParseNAFConstraint() {
        OPPLParser parser = getParser(naf);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        AbstractConstraint constraint = parser.parseConstraint(
                "FAIL ?x subClassOf hasP some ?y", symbolTable, constraintSystem);
        assertNotNull("The constraint cannot be null", constraint);
        Logging.getParseTestLogging().info(constraint);
    }

    @Test
    public void testParseRegExpConstraint() {
        OPPLParser parser = getParser(test);
        ConstraintSystem constraintSystem = parser.getOPPLAbstractFactory()
                .createConstraintSystem();
        OPPLSymbolTable symbolTable = parser.getSymbolTableFactory().createSymbolTable();
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?x")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        symbolTable.defineVariable(createImaginaryTreeNode(createImaginaryToken("?y")),
                createImaginaryTreeNode(createImaginaryToken("CLASS")), constraintSystem);
        AbstractConstraint constraint = parser.parseConstraint("?x Match(\"Island\")",
                symbolTable, constraintSystem);
        assertNotNull("The constraint cannot be null", constraint);
        Logging.getParseTestLogging().info(constraint);
    }

    private Token createImaginaryToken(final String text) {
        return new Token() {
            @Override
            public void setType(int ttype) {}

            @Override
            public void setTokenIndex(int index) {}

            @Override
            public void setText(String t) {}

            @Override
            public void setLine(int line) {}

            @Override
            public void setInputStream(CharStream input) {}

            @Override
            public void setCharPositionInLine(int pos) {}

            @Override
            public void setChannel(int channel) {}

            @Override
            public int getType() {
                return 0;
            }

            @Override
            public int getTokenIndex() {
                return 0;
            }

            @Override
            public String getText() {
                return text;
            }

            @Override
            public int getLine() {
                return 0;
            }

            @Override
            public CharStream getInputStream() {
                return null;
            }

            @Override
            public int getCharPositionInLine() {
                return 0;
            }

            @Override
            public int getChannel() {
                return 0;
            }
        };
    }

    private ManchesterOWLSyntaxTree createImaginaryTreeNode(Token token) {
        return new ManchesterOWLSyntaxTree(token);
    }

    private <O extends OWLObject> Variable<O> createTempVariable(final String name,
            final VariableType<O> type) {
        return new Variable<O>() {
            @Override
            public IRI getIRI() {
                return IRI.create(URI.create(ManchesterVariableSyntax.NAMESPACE
                        + getName()));
            }

            @Override
            public VariableType<O> getType() {
                return type;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public void accept(VariableVisitor visitor) {}

            @Override
            public <T> T accept(VariableVisitorEx<T> visitor) {
                return null;
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return String.format("%s:%s", getName(), getType());
            }
        };
    }
}
