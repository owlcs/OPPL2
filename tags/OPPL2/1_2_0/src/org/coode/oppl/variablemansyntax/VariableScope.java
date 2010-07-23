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
package org.coode.oppl.variablemansyntax;

import org.coode.oppl.variablemansyntax.VariableScopes.Direction;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLObject;

/**
 * Represents a limitation in the range of values that can be assigned to a
 * {@link GeneratedVariable} instance
 * 
 * 
 * @author Luigi Iannone
 * 
 */
public interface VariableScope {
	/**
	 * @param owlObject
	 * @param checker
	 * @return true if the input OWLObject is into the VariableScope
	 * @throws OWLReasonerException
	 */
	boolean check(OWLObject owlObject, VariableScopeChecker checker)
			throws OWLReasonerException;

	/**
	 * @return the direction of the VariableScope
	 * 
	 */
	Direction getDirection();

	/**
	 * @return the scope delimiter for the VariableScope
	 */
	OWLObject getScopingObject();
}
