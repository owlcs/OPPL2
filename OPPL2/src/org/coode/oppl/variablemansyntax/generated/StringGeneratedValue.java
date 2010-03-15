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
package org.coode.oppl.variablemansyntax.generated;

import java.util.Arrays;
import java.util.List;

import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;

/**
 * Represents a constant value. All the variables generated from this will have
 * a constant value in their bindings
 * 
 * 
 * @author Luigi Iannone
 * 
 */
public class StringGeneratedValue implements SingleValueGeneratedValue<String> {
	private final String constant;

	public StringGeneratedValue(String constant) {
		this.constant = constant;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue#getGeneratedValues()
	 */
	public List<String> computePossibleValues() {
		// no need to return an unmodifiable list: the only element in the list
		// is the string representing this constant, and that is immutable per
		// se
		return Arrays.asList(this.constant);
	}

	@Override
	public String toString() {
		return "\"" + this.constant + "\"";
	}

	public String getGeneratedValue(BindingNode node) {
		return this.constant;
	}
}
