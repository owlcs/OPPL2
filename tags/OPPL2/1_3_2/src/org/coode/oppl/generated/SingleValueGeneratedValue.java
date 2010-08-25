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
package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.bindingtree.BindingNode;

/**
 * Generic interface that abstracts over a generated Value to be assigned to a
 * generated variable
 * 
 * @see AbstractGeneratedVariable
 * 
 * @param <O>
 *            Generic object that will be used to generate a value.
 * 
 * @author Luigi Iannone
 * 
 */
public interface SingleValueGeneratedValue<O> {
	/**
	 * @param node
	 * @return the generated value determined by the assignments in the input
	 *         node, it may be null
	 */
	O getGeneratedValue(BindingNode node);

	/**
	 * @return the List of possible generated values
	 */
	public abstract List<O> computePossibleValues();

	public void accept(SingleValueGeneratedValueVisitor visitor);

	public <P> P accept(SingleValueGeneratedValueVisitorEx<P> visitor);
}
