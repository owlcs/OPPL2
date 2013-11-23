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

import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

/** Any variable not generated implements this interface; generated variables
 * implement Variable
 * 
 * @see SingleValueGeneratedVariable
 * @author Luigi Iannone */
public interface Variable<O extends OWLObject> extends Renderable {
    /** @return the name of the Variable */
    String getName();

    /** @return an URI for the Variable */
    IRI getIRI();

    /** @return the type of the Variable
     * @see VariableType */
    VariableType<O> getType();

    /** Visitor pattern interface method for visitors without return type
     * 
     * @param visitor */
    void accept(VariableVisitor visitor);

    /** Visitor pattern interface method for visitors with return type
     * 
     * @param visitor
     * @return an instance of T */
    <T> T accept(VariableVisitorEx<T> visitor);
}
