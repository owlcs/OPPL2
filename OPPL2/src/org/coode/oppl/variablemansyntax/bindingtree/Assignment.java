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
package org.coode.oppl.variablemansyntax.bindingtree;

import org.coode.oppl.variablemansyntax.Variable;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class Assignment {
	protected final Variable assignedVariable;
	protected final OWLObject assignment;
	protected final int hashcode;

	/**
	 * @param assignedVariable
	 * @param assignment
	 */
	public Assignment(Variable assignedVariable, OWLObject assignment) {
		this.assignedVariable = assignedVariable;
		this.assignment = assignment;
		this.hashcode = assignedVariable.hashCode() * assignment.hashCode();
	}

	/**
	 * @return the assignedVariable
	 */
	public Variable getAssignedVariable() {
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
		return this.assignedVariable.getName() + "="
				+ this.assignment.toString();
	}

	@Override
	public int hashCode() {
		return this.hashcode;
	}

	@Override
	public boolean equals(Object obj) {
		boolean toReturn = obj instanceof Assignment;
		if (toReturn) {
			Assignment toCompare = (Assignment) obj;
			toReturn = this.assignedVariable.equals(toCompare.assignedVariable)
					&& this.assignment.equals(toCompare.assignment);
		}
		return toReturn;
	}
}
