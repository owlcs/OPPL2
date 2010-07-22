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
package org.coode.oppl.protege.ui;

import org.coode.oppl.Variable;
import org.semanticweb.owl.model.OWLObject;

public interface OPPLMacroListener {
	/**
	 * Handles the notification that an entity has been genearlised as a new
	 * Variable
	 * 
	 * @param variable
	 */
	void handleGeneralisedOWLObject(Variable variable);

	/**
	 * Handles the notification that an entity has been generalised and assigned
	 * to an existing Variable
	 * 
	 * @param variable
	 * @param owlObject
	 */
	void handleGeneralisedOWLObject(Variable variable, OWLObject owlObject);

	/**
	 * Handles the notification that a Variable has been deleted from the
	 * OPPLMacro
	 * 
	 * @param variable
	 */
	void handleDeletedVariable(Variable variable);
}