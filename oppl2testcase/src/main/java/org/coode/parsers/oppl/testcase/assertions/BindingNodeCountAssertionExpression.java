package org.coode.parsers.oppl.testcase.assertions;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;

/** Represents the count of the occurrences a particular set of assignments in
 * the results of the query.
 * 
 * @author Luigi Iannone */
public class BindingNodeCountAssertionExpression implements AssertionExpression<Integer> {
    private final BindingNode bindingNode;
    private final AbstractOPPLTestCaseFactory testCaseFactory;
    private final ConstraintSystem constraintSystem;

    /** @param bindingNode
     *            bindingNode
     * @param constraintSystem
     *            constraintSystem
     * @param testCaseFactory
     *            testCaseFactory */
    public BindingNodeCountAssertionExpression(BindingNode bindingNode,
            ConstraintSystem constraintSystem, AbstractOPPLTestCaseFactory testCaseFactory) {
        this.bindingNode = checkNotNull(bindingNode, "bindingNode");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.testCaseFactory = checkNotNull(testCaseFactory, "testCaseFactory");
    }

    @Override
    public void accept(AssertionExpressionVisitor assertionExpressionVisitor) {
        assertionExpressionVisitor.visitBindingNodeCountAssertionExpression(this);
    }

    @Override
    public <O> O accept(AssertionExpressionVisitorEx<O> assertionExpressionVisitor) {
        return assertionExpressionVisitor.visitBindingNodeCountAssertionExpression(this);
    }

    @Override
    public Integer resolve(Set<? extends BindingNode> bindings, ConstraintSystem cs) {
        int count = 0;
        Collection<Assignment> assignments = getBindingNode().getAssignments();
        for (BindingNode n : bindings) {
            if (n.getAssignments().containsAll(assignments)) {
                count++;
            }
        }
        return count;
    }

    /** @return the bindingNode */
    public BindingNode getBindingNode() {
        return bindingNode;
    }

    /** @return the testCaseFactory */
    public AbstractOPPLTestCaseFactory getTestCaseFactory() {
        return testCaseFactory;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("count(");
        boolean first = true;
        TreeSet<Assignment> sortedAssignment = new TreeSet<Assignment>(
                new Comparator<Assignment>() {
                    @Override
                    public int compare(Assignment o1, Assignment o2) {
                        return o1.getAssignedVariable().getName()
                                .compareTo(o2.getAssignedVariable().getName());
                    }
                });
        sortedAssignment.addAll(getBindingNode().getAssignments());
        for (Assignment a : sortedAssignment) {
            String comma = first ? "" : ", ";
            ManchesterSyntaxRenderer renderer = getTestCaseFactory().getOPPLFactory()
                    .getManchesterSyntaxRenderer(getConstraintSystem());
            a.getAssignment().accept(renderer);
            b.append(String.format("%s%s = %s", comma, a.getAssignedVariable().getName(),
                    renderer));
            first = false;
        }
        b.append(")");
        return b.toString();
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (bindingNode == null ? 0 : bindingNode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        BindingNodeCountAssertionExpression other = (BindingNodeCountAssertionExpression) obj;
        if (bindingNode == null) {
            if (other.bindingNode != null) {
                return false;
            }
        } else if (!bindingNode.equals(other.bindingNode)) {
            return false;
        }
        return true;
    }
}
