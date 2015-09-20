package org.coode.parsers.oppl.testcase.assertions;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;

/**
 * @author Luigi Iannone
 */
public class AssertionComplement implements Assertion {

    private final Assertion assertion;

    /**
     * @param assertion
     *        assertion
     */
    public AssertionComplement(Assertion assertion) {
        this.assertion = checkNotNull(assertion, "assertion");
    }

    @Override
    public void accept(AssertionVisitor visitor) {
        visitor.visitAssertionComplement(this);
    }

    @Override
    public <O> O accept(AssertionVisitorEx<O> visitor) {
        return visitor.visitAssertionComplement(this);
    }

    /**
     * @return assertion
     */
    public Assertion getOperand() {
        return assertion;
    }

    @Override
    public boolean holds(Set<? extends BindingNode> bindings,
        ConstraintSystem constraintSystem) {
        return !getOperand().holds(bindings, constraintSystem);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (assertion == null ? 0 : assertion.hashCode());
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
        AssertionComplement other = (AssertionComplement) obj;
        if (assertion == null) {
            if (other.assertion != null) {
                return false;
            }
        } else if (!assertion.equals(other.assertion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("NOT %s", getOperand().toString());
    }
}
