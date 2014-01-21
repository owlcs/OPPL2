package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public abstract class VariableAttribute<O> extends AbstractOPPLFunction<O> implements
        OPPLFunction<O> {
    private final Variable<?> variable;
    private final AttributeName attribute;

    /** @param variable
     *            variable
     * @param attribute
     *            attribute */
    public VariableAttribute(Variable<?> variable, AttributeName attribute) {
        this.variable = checkNotNull(variable, "variable");
        this.attribute = checkNotNull(attribute, "attribute");
    }

    /** @return the variable */
    public Variable<?> getVariable() {
        return this.variable;
    }

    /** @return the attribute */
    public AttributeName getAttribute() {
        return this.attribute;
    }

    @Override
    public String toString() {
        return String.format("%s.%s", this.getVariable().getName(), this.getAttribute());
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return this.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return this.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + (this.attribute == null ? 0 : this.attribute.hashCode());
        result = prime * result + (this.variable == null ? 0 : this.variable.hashCode());
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
        VariableAttribute<?> other = (VariableAttribute<?>) obj;
        if (this.attribute != other.attribute) {
            return false;
        }
        if (this.variable == null) {
            if (other.variable != null) {
                return false;
            }
        } else if (!this.variable.equals(other.variable)) {
            return false;
        }
        return true;
    }
}
