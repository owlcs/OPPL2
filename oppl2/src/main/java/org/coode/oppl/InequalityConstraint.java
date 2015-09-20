/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl;

import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class InequalityConstraint implements AbstractConstraint {

    private final Variable<?> variable;
    private final OWLObject expression;
    private final ConstraintSystem constraintSystem;

    /**
     * @param variable
     *        variable
     * @param expression
     *        expression
     * @param constraintSystem
     *        constraintSystem
     */
    public InequalityConstraint(Variable<?> variable, OWLObject expression,
        ConstraintSystem constraintSystem) {
        this.variable = variable;
        this.expression = expression;
        this.constraintSystem = constraintSystem;
    }

    /**
     * @return the variable
     */
    public Variable<?> getVariable() {
        return variable;
    }

    /**
     * @return the expression
     */
    public OWLObject getExpression() {
        return expression;
    }

    @Override
    public <O> O accept(ConstraintVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return this.render(getConstraintSystem());
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(
            shortFormProvider);
        expression.accept(renderer);
        return variable.getName() + " != " + renderer.toString();
    }

    @Override
    public String render(ConstraintSystem cs) {
        ManchesterSyntaxRenderer renderer = cs.getOPPLFactory()
            .getManchesterSyntaxRenderer(cs);
        expression.accept(renderer);
        return variable.getName() + " != " + renderer.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (expression == null ? 0 : expression.hashCode());
        result = prime * result + (variable == null ? 0 : variable.hashCode());
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
        InequalityConstraint other = (InequalityConstraint) obj;
        if (expression == null) {
            if (other.expression != null) {
                return false;
            }
        } else if (!expression.equals(other.expression)) {
            return false;
        }
        if (variable == null) {
            if (other.variable != null) {
                return false;
            }
        } else if (!variable.equals(other.variable)) {
            return false;
        }
        return true;
    }

    @Override
    public void accept(ConstraintVisitor visitor) {
        visitor.visitInequalityConstraint(this);
    }
}
