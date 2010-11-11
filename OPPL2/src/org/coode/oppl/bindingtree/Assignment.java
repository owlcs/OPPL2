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

import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class Assignment {
	private final Variable<?> assignedVariable;
	private final OWLObject assignment;

	/**
	 * @param assignedVariable
	 * @param assignment
	 */
	public Assignment(Variable<?> assignedVariable, OWLObject assignment) {
		if (assignedVariable == null) {
			throw new NullPointerException("The assigned variable cannot be null");
		}
		if (assignment == null) {
			throw new NullPointerException("The assigned value cannot be null");
		}
		if (VariableTypeFactory.getVariableType(assignment) != assignedVariable.getType()) {
			throw new IllegalArgumentException(
					"The assigned value is incompatible with the variabl it is assigned to");
		}
		this.assignedVariable = assignedVariable;
		this.assignment = assignment;
	}

	/**
	 * @return the assignedVariable
	 */
	public Variable<?> getAssignedVariable() {
		return this.assignedVariable;
	}

	/**
	 * @return the assignment
	 */
	public OWLObject getAssignment() {
		return this.assignment;
	}

	@Override
	public String toString() {
		return this.assignedVariable.getName() + "=" + this.assignment.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.assignedVariable == null ? 0 : this.assignedVariable.hashCode());
		result = prime * result + (this.assignment == null ? 0 : this.assignment.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (this.assignedVariable == null) {
			if (other.assignedVariable != null) {
				return false;
			}
		} else if (!this.assignedVariable.equals(other.assignedVariable)) {
			return false;
		}
		if (this.assignment == null) {
			if (other.assignment != null) {
				return false;
			}
		} else if (!this.assignment.equals(other.assignment)) {
			return false;
		}
		return true;
	}
}
