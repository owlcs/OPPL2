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
package org.coode.oppl.bindingtree;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class Assignment {

    private final Variable<?> assignedVariable;
    private final OWLObject assignment;

    /**
     * @param assignedVariable
     *        assignedVariable
     * @param assignment
     *        assignment
     */
    public Assignment(Variable<?> assignedVariable, OWLObject assignment) {
        this.assignedVariable = checkNotNull(assignedVariable, "assignedVariable");
        this.assignment = checkNotNull(assignment, "assignment");
        if (VariableTypeFactory.getVariableType(assignment) != assignedVariable.getType()) {
            throw new IllegalArgumentException(
                "The assigned value is incompatible with the variable it is assigned to: "
                    + assignment.getClass() + " "
                    + VariableTypeFactory.getVariableType(assignment) + " "
                    + assignedVariable.getType());
        }
    }

    /**
     * @return the assignedVariable
     */
    public Variable<?> getAssignedVariable() {
        return assignedVariable;
    }

    /**
     * @return the assignment
     */
    public OWLObject getAssignment() {
        return assignment;
    }

    @Override
    public String toString() {
        return assignedVariable.getName() + "=" + assignment.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + assignedVariable.hashCode();
        result = prime * result + assignment.hashCode();
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
        Assignment other = (Assignment) obj;
        if (!assignedVariable.equals(other.assignedVariable)) {
            return false;
        }
        return assignment.equals(other.assignment);
    }
}
