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
package org.coode.oppl.exceptions;

/**
 * Generic OPPL Exception
 * 
 * @author Luigi Iannone
 * 
 */
public class OPPLException extends Exception {
	private static final long serialVersionUID = 567886696227544902L;

	/**
	 * @param message
	 * @see Exception#Exception(String)
	 */
	public OPPLException(String message) {
		super(message);
	}

	/**
	 * @see Exception#Exception(Throwable)
	 * @param t
	 */
	public OPPLException(Throwable t) {
		super(t);
	}

	/**
	 * @param message
	 * @param t
	 * @see Exception#Exception(String, Throwable)
	 */
	public OPPLException(String message, Throwable t) {
		super(message, t);
	}
}
