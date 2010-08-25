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

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;

/**
 * @author Luigi Iannone
 * 
 */
public class OWLObjectInstantiator extends AbstractOWLObjectInstantiator {
	public OWLObjectInstantiator(BindingNode bindingNode, ConstraintSystem cs) {
		super(bindingNode, cs);
	}

	@Override
	public OWLObject visit(OWLTypedConstant node) {
		OWLConstant toReturn = node;
		if (this.getConstraintSystem().isVariable(node)) {
			// XXX the other OwlOBjectInstantiator uses getLiteral - is this the
			// same?
			Variable variable = this.getConstraintSystem().getVariable(
					node.toString());
			toReturn = (OWLConstant) this.getBindingNode().getAssignmentValue(
					variable);
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLUntypedConstant node) {
		OWLConstant toReturn = node;
		if (this.getConstraintSystem().isVariable(node)) {
			Variable variable = this.getConstraintSystem().getVariable(
					node.getLiteral());
			toReturn = (OWLConstant) this.getBindingNode().getAssignmentValue(
					variable);
		}
		return toReturn;
	}
}
