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

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.generated.GeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/** Represents a limitation in the range of values that can be assigned to a
 * {@link GeneratedVariable} instance
 * 
 * @author Luigi Iannone
 * @param <O> */
public interface VariableScope<O extends OWLObject> extends Renderable {
    /** @param owlObject
     * @param checker
     * @return true if the input OWLObject is into the VariableScope
     * @throws OWLRuntimeException */
    boolean check(OWLObject owlObject) throws OWLRuntimeException;

    /** @return the direction of the VariableScope */
    Direction getDirection();

    /** @return the scope delimiter for the VariableScope */
    O getScopingObject();
}
