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

import org.coode.oppl.function.ValueComputationParameters;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class PartialOWLObjectInstantiator extends AbstractOWLObjectInstantiator {
	public PartialOWLObjectInstantiator(ValueComputationParameters parameters) {
		super(parameters);
	}

	@Override
	public OWLObject visit(OWLLiteral node) {
		OWLLiteral toReturn = node;
		if (this.getParameters().getConstraintSystem().isVariable(node)) {
			Variable<?> variable = this.getParameters().getConstraintSystem().getVariable(
					node.getLiteral());
			OWLLiteral assignmentValue = (OWLLiteral) this.getParameters().getBindingNode().getAssignmentValue(
					variable,
					this.getParameters());
			toReturn = assignmentValue == null ? node : assignmentValue;
		}
		return toReturn;
	}
}
