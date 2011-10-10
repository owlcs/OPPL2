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

import java.util.List;

import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * Generic interface representing an OPPL Script
 * 
 * @author Luigi Iannone
 * 
 */
public interface OPPLScript {
	public void addVariable(Variable<?> variable);

	/**
	 * @return the List of the variables declared in this OPPLScript
	 */
	public List<Variable<?>> getVariables();

	/**
	 * @return the List of the InputVariable elements
	 */
	public List<InputVariable<?>> getInputVariables();

	/**
	 * @return the ConstraintSystem used by this OPPLScript
	 */
	public ConstraintSystem getConstraintSystem();

	/**
	 * @return the appropriate rendering of this OPPLScript
	 */
	public String render();

	public List<OWLAxiomChange> getActions();

	public OPPLQuery getQuery();

	void accept(OPPLScriptVisitor visitor);

	<P> P accept(OPPLScriptVisitorEx<P> visitor);

	public String render(ShortFormProvider shortFormProvider);
}
