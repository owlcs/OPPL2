package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.Scope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.testcase.assertions.AssertContains;
import org.coode.parsers.oppl.testcase.assertions.AssertEqual;
import org.coode.parsers.oppl.testcase.assertions.AssertNotEqual;
import org.coode.parsers.oppl.testcase.assertions.Assertion;
import org.coode.parsers.oppl.testcase.assertions.AssertionComplement;
import org.coode.parsers.oppl.testcase.assertions.AssertionExpression;
import org.coode.parsers.oppl.testcase.assertions.AssertionExpressionVisitorEx;
import org.coode.parsers.oppl.testcase.assertions.BindingNodeCountAssertionExpression;
import org.coode.parsers.oppl.testcase.assertions.CountAssertionExpression;
import org.coode.parsers.oppl.testcase.assertions.CountStarAssertionExpression;
import org.coode.parsers.oppl.testcase.assertions.DefaultAssertionExpressionVisitorExAdapter;
import org.coode.parsers.oppl.testcase.assertions.GreatThanAssertion;
import org.coode.parsers.oppl.testcase.assertions.GreaterThanEqualToAssertion;
import org.coode.parsers.oppl.testcase.assertions.IntegerAssertionExpression;
import org.coode.parsers.oppl.testcase.assertions.LessThanAssertion;
import org.coode.parsers.oppl.testcase.assertions.LessThanEqualToAssertion;
import org.coode.parsers.oppl.testcase.assertions.OWLExpressionAssertionExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class OPPLTestCaseSymbolTable extends OPPLSymbolTable {

    private static final DefaultAssertionExpressionVisitorExAdapter<Boolean> INTEGER_EXPRESSION_DETECTOR =
        new DefaultAssertionExpressionVisitorExAdapter<Boolean>(Boolean.FALSE) {

            @Override
            public Boolean visitIntegerAssertionExpressionVisitor(
                IntegerAssertionExpression integerAssertionExpression) {
                return Boolean.TRUE;
            }

            @Override
            public Boolean visitBindingNodeCountAssertionExpression(
                BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
                return Boolean.TRUE;
            }

            @Override
            public Boolean visitCountAssertionExpression(
                CountAssertionExpression countAssertionExpression) {
                return Boolean.TRUE;
            }

            @Override
            public Boolean visitCountStarAssertionExpression(
                CountStarAssertionExpression countStarAssertionExpression) {
                return Boolean.TRUE;
            }
        };

    /**
     * @param globalScope globalScope
     * @param dataFactory dataFactory
     */
    public OPPLTestCaseSymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
        super(globalScope, dataFactory);
    }

    /**
     * @param left left
     * @param leftNode leftNode
     * @param right right
     * @param rightNode rightNode
     * @param parentExpression parentExpression
     * @return assert equals
     */
    public AssertEqual getAssertEqual(AssertionExpression<?> left, OPPLSyntaxTree leftNode,
        AssertionExpression<?> right, OPPLSyntaxTree rightNode, OPPLSyntaxTree parentExpression) {
        AssertEqual toReturn = null;
        if (left == null) {
            getErrorListener().illegalToken(leftNode, "null left hand side assertion expression");
        } else if (right == null) {
            getErrorListener().illegalToken(leftNode, "null right hand side assertion expression");
        } else if (!areCompatible(left, right)) {
            getErrorListener().incompatibleSymbols(parentExpression, leftNode, rightNode);
        } else {
            toReturn = new AssertEqual(left, right);
        }
        return toReturn;
    }

    /**
     * @param left left
     * @param leftNode leftNode
     * @param right right
     * @param rightNode rightNode
     * @param parentExpression parentExpression
     * @return assert not equals
     */
    public AssertNotEqual getAssertNotEqual(AssertionExpression<?> left, OPPLSyntaxTree leftNode,
        AssertionExpression<?> right, OPPLSyntaxTree rightNode, OPPLSyntaxTree parentExpression) {
        AssertNotEqual toReturn = null;
        if (left == null) {
            getErrorListener().illegalToken(leftNode, "null left hand side assertion expression");
        } else if (right == null) {
            getErrorListener().illegalToken(leftNode, "null right hand side assertion expression");
        } else if (!areCompatible(left, right)) {
            getErrorListener().incompatibleSymbols(parentExpression, leftNode, rightNode);
        } else {
            toReturn = new AssertNotEqual(left, right);
        }
        return toReturn;
    }

    /**
     * @param variableNode variableNode
     * @param expressionNodes expressionNodes
     * @param constraintSystem constraintSystem
     * @param testCaseFactory testCaseFactory
     * @param parentExpression parentExpression
     * @param handler handler
     * @return assert contains
     */
    public AssertContains getAssertContains(OPPLSyntaxTree variableNode,
        Collection<? extends OPPLSyntaxTree> expressionNodes, ConstraintSystem constraintSystem,
        AbstractOPPLTestCaseFactory testCaseFactory, OPPLSyntaxTree parentExpression,
        RuntimeExceptionHandler handler) {
        checkNotNull(constraintSystem, "constraintSystem");
        checkNotNull(testCaseFactory, "testCaseFactory");
        checkNotNull(handler, "handler");
        Variable<?> variable = constraintSystem.getVariable(variableNode.getText());
        AssertContains toReturn = null;
        Set<OWLObject> expressions = new HashSet<>();
        boolean allFine = true;
        for (OPPLSyntaxTree expressionNode : expressionNodes) {
            OWLObject owlObject = expressionNode.getOWLObject();
            if (owlObject != null) {
                if (variable.getType().isCompatibleWith(owlObject)) {
                    expressions.add(owlObject);
                } else {
                    allFine = false;
                    getErrorListener().incompatibleSymbols(parentExpression, variableNode,
                        expressionNode);
                }
            } else {
                getErrorListener().illegalToken(expressionNode, "Null OWL object");
            }
        }
        if (expressions.isEmpty()) {
            allFine = false;
            reportIllegalToken(parentExpression, "Empty set of contained expressions");
        }
        if (variable != null) {
            if (allFine) {
                toReturn = new AssertContains(variable, expressions, constraintSystem,
                    testCaseFactory, handler);
            }
        } else {
            getErrorListener().illegalToken(variableNode, "Undefined variable");
        }
        return toReturn;
    }

    /**
     * @param variableNode variableNode
     * @param constraintSystem constraintSystem
     * @param handler handler
     * @return count assertion
     */
    public CountAssertionExpression getCountAssertionExpression(OPPLSyntaxTree variableNode,
        ConstraintSystem constraintSystem, RuntimeExceptionHandler handler) {
        checkNotNull(handler, "handler");
        Variable<?> variable = constraintSystem.getVariable(variableNode.getText());
        CountAssertionExpression toReturn = null;
        if (variable != null) {
            toReturn = new CountAssertionExpression(variable, handler);
        } else {
            getErrorListener().illegalToken(variableNode, "Undefined variable");
        }
        return toReturn;
    }

    /**
     * @param intValueNode intValueNode
     * @return integer assertion
     */
    public IntegerAssertionExpression getIntegerAssertionExpression(OPPLSyntaxTree intValueNode) {
        IntegerAssertionExpression toReturn = null;
        try {
            int intValue = Integer.parseInt(intValueNode.getText());
            toReturn = new IntegerAssertionExpression(intValue);
        } catch (RuntimeException e) {
            getErrorListener().reportThrowable(e, intValueNode.getToken().getLine(),
                intValueNode.getCharPositionInLine(), intValueNode.getText().length());
        }
        return toReturn;
    }

    /**
     * @param owlObjectNode owlObjectNode
     * @param constraintSystem constraintSystem
     * @param testCaseFactory testCaseFactory
     * @param handler handler
     * @return expression assertion
     */
    public OWLExpressionAssertionExpression getOWLExpressionAssertionExpression(
        OPPLSyntaxTree owlObjectNode, ConstraintSystem constraintSystem,
        AbstractOPPLTestCaseFactory testCaseFactory, RuntimeExceptionHandler handler) {
        checkNotNull(testCaseFactory, "testCaseFactory");
        checkNotNull(constraintSystem, "constraintSystem");
        checkNotNull(handler, "handler");
        OWLExpressionAssertionExpression toReturn = null;
        OWLObject owlObject = owlObjectNode.getOWLObject();
        if (owlObject != null) {
            toReturn = new OWLExpressionAssertionExpression(owlObject, constraintSystem,
                testCaseFactory, handler);
        } else {
            getErrorListener().illegalToken(owlObjectNode, "Null OWL Object");
        }
        return toReturn;
    }

    private static boolean areCompatible(AssertionExpression<?> assertionExpression,
        AssertionExpression<?> anotherAssertionExpression) {
        return anotherAssertionExpression.accept(getCompatibilityChecker(assertionExpression))
            .booleanValue();
    }

    private static AssertionExpressionVisitorEx<Boolean> getCompatibilityChecker(
        AssertionExpression<?> assertionExpression) {
        return assertionExpression
            .accept(new AssertionExpressionVisitorEx<AssertionExpressionVisitorEx<Boolean>>() {

                @Override
                public AssertionExpressionVisitorEx<Boolean> visitCountAssertionExpression(
                    CountAssertionExpression countAssertionExpression) {
                    return new AssertionExpressionVisitorEx<Boolean>() {

                        @Override
                        public Boolean visitCountAssertionExpression(CountAssertionExpression ce) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitBindingNodeCountAssertionExpression(
                            BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitIntegerAssertionExpressionVisitor(
                            IntegerAssertionExpression integerAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitCountStarAssertionExpression(
                            CountStarAssertionExpression countStarAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitOWLExpressionAssertionExpression(
                            OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
                            return Boolean.FALSE;
                        }
                    };
                }

                @Override
                public AssertionExpressionVisitorEx<Boolean> visitCountStarAssertionExpression(
                    CountStarAssertionExpression countStarAssertionExpression) {
                    return new AssertionExpressionVisitorEx<Boolean>() {

                        @Override
                        public Boolean visitCountAssertionExpression(
                            CountAssertionExpression countAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitBindingNodeCountAssertionExpression(
                            BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitIntegerAssertionExpressionVisitor(
                            IntegerAssertionExpression integerAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitCountStarAssertionExpression(
                            CountStarAssertionExpression ce) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitOWLExpressionAssertionExpression(
                            OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
                            return Boolean.FALSE;
                        }
                    };
                }

                @Override
                public AssertionExpressionVisitorEx<Boolean> visitIntegerAssertionExpressionVisitor(
                    IntegerAssertionExpression integerAssertionExpression) {
                    return new AssertionExpressionVisitorEx<Boolean>() {

                        @Override
                        public Boolean visitCountAssertionExpression(
                            CountAssertionExpression countAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitBindingNodeCountAssertionExpression(
                            BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitCountStarAssertionExpression(
                            CountStarAssertionExpression countStarAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitIntegerAssertionExpressionVisitor(
                            IntegerAssertionExpression i) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitOWLExpressionAssertionExpression(
                            OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
                            return Boolean.FALSE;
                        }
                    };
                }

                @Override
                public AssertionExpressionVisitorEx<Boolean> visitBindingNodeCountAssertionExpression(
                    BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
                    return new AssertionExpressionVisitorEx<Boolean>() {

                        @Override
                        public Boolean visitCountAssertionExpression(
                            CountAssertionExpression countAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitBindingNodeCountAssertionExpression(
                            BindingNodeCountAssertionExpression b) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitIntegerAssertionExpressionVisitor(
                            IntegerAssertionExpression integerAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitCountStarAssertionExpression(
                            CountStarAssertionExpression countStarAssertionExpression) {
                            return Boolean.TRUE;
                        }

                        @Override
                        public Boolean visitOWLExpressionAssertionExpression(
                            OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
                            return Boolean.FALSE;
                        }
                    };
                }

                @Override
                public AssertionExpressionVisitorEx<Boolean> visitOWLExpressionAssertionExpression(
                    OWLExpressionAssertionExpression owlExpressionAssertionExpression) {
                    return new AssertionExpressionVisitorEx<Boolean>() {

                        @Override
                        public Boolean visitCountAssertionExpression(
                            CountAssertionExpression countAssertionExpression) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitBindingNodeCountAssertionExpression(
                            BindingNodeCountAssertionExpression bindingNodeCountAssertionExpression) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitIntegerAssertionExpressionVisitor(
                            IntegerAssertionExpression integerAssertionExpression) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitCountStarAssertionExpression(
                            CountStarAssertionExpression countStarAssertionExpression) {
                            return Boolean.FALSE;
                        }

                        @Override
                        public Boolean visitOWLExpressionAssertionExpression(
                            OWLExpressionAssertionExpression o) {
                            return Boolean.TRUE;
                        }
                    };
                }
            });
    }

    /**
     * @param a a
     * @return assertion complement
     */
    public AssertionComplement getAssertionComplement(Assertion a) {
        return new AssertionComplement(a);
    }

    /**
     * @return count star assertion
     */
    public CountStarAssertionExpression getCountStarAssertionExpression() {
        return CountStarAssertionExpression.getInstance();
    }

    /**
     * @param left left
     * @param leftNode leftNode
     * @param right right
     * @param rightNode rightNode
     * @return assert less than
     */
    @SuppressWarnings("unchecked")
    public LessThanAssertion getAssertLessThan(AssertionExpression<?> left, OPPLSyntaxTree leftNode,
        AssertionExpression<?> right, OPPLSyntaxTree rightNode) {
        LessThanAssertion toReturn = null;
        if (left == null) {
            getErrorListener().illegalToken(leftNode, "null left hand side assertion expression");
        } else if (right == null) {
            getErrorListener().illegalToken(leftNode, "null right hand side assertion expression");
        } else if (!left.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(leftNode,
                "Only integer values expressions can be used for comparisons");
        } else if (!right.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(rightNode,
                "Only integer values expressions can be used for comparisons");
        } else {
            toReturn = new LessThanAssertion((AssertionExpression<Integer>) left,
                (AssertionExpression<Integer>) right);
        }
        return toReturn;
    }

    /**
     * @param left left
     * @param leftNode leftNode
     * @param right right
     * @param rightNode rightNode
     * @return assert less or equal
     */
    @SuppressWarnings("unchecked")
    public LessThanEqualToAssertion getAssertLessThanEqualtTo(AssertionExpression<?> left,
        OPPLSyntaxTree leftNode, AssertionExpression<?> right, OPPLSyntaxTree rightNode) {
        LessThanEqualToAssertion toReturn = null;
        if (left == null) {
            getErrorListener().illegalToken(leftNode, "null left hand side assertion expression");
        } else if (right == null) {
            getErrorListener().illegalToken(leftNode, "null right hand side assertion expression");
        } else if (!left.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(leftNode,
                "Only integer values expressions can be used for comparisons");
        } else if (!right.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(rightNode,
                "Only integer values expressions can be used for comparisons");
        } else {
            toReturn = new LessThanEqualToAssertion((AssertionExpression<Integer>) left,
                (AssertionExpression<Integer>) right);
        }
        return toReturn;
    }

    /**
     * @param left left
     * @param leftNode leftNode
     * @param right right
     * @param rightNode rightNode
     * @return assert greater
     */
    @SuppressWarnings("unchecked")
    public GreatThanAssertion getAssertGreaterThan(AssertionExpression<?> left,
        OPPLSyntaxTree leftNode, AssertionExpression<?> right, OPPLSyntaxTree rightNode) {
        GreatThanAssertion toReturn = null;
        if (left == null) {
            getErrorListener().illegalToken(leftNode, "null left hand side assertion expression");
        } else if (right == null) {
            getErrorListener().illegalToken(leftNode, "null right hand side assertion expression");
        } else if (!left.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(leftNode,
                "Only integer values expressions can be used for comparisons");
        } else if (!right.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(rightNode,
                "Only integer values expressions can be used for comparisons");
        } else {
            toReturn = new GreatThanAssertion((AssertionExpression<Integer>) left,
                (AssertionExpression<Integer>) right);
        }
        return toReturn;
    }

    /**
     * @param left left
     * @param leftNode leftNode
     * @param right right
     * @param rightNode rightNode
     * @return assert greater or equal
     */
    @SuppressWarnings("unchecked")
    public GreaterThanEqualToAssertion getAssertGreaterThanEqualTo(AssertionExpression<?> left,
        OPPLSyntaxTree leftNode, AssertionExpression<?> right, OPPLSyntaxTree rightNode) {
        GreaterThanEqualToAssertion toReturn = null;
        if (left == null) {
            getErrorListener().illegalToken(leftNode, "null left hand side assertion expression");
        } else if (right == null) {
            getErrorListener().illegalToken(leftNode, "null right hand side assertion expression");
        } else if (!left.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(leftNode,
                "Only integer values expressions can be used for comparisons");
        } else if (!right.accept(INTEGER_EXPRESSION_DETECTOR).booleanValue()) {
            getErrorListener().illegalToken(rightNode,
                "Only integer values expressions can be used for comparisons");
        } else {
            toReturn = new GreaterThanEqualToAssertion((AssertionExpression<Integer>) left,
                (AssertionExpression<Integer>) right);
        }
        return toReturn;
    }

    /**
     * @param bindingNode bindingNode
     * @param constraintSystem constraintSystem
     * @param testCaseFactory testCaseFactory
     * @return binding node count assertion
     */
    public BindingNodeCountAssertionExpression getBindingNodeCount(BindingNode bindingNode,
        ConstraintSystem constraintSystem, AbstractOPPLTestCaseFactory testCaseFactory) {
        return new BindingNodeCountAssertionExpression(bindingNode, constraintSystem,
            testCaseFactory);
    }
}
