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

import org.semanticweb.owlapi.model.OWLAxiomChange;

/** @author Luigi Iannone
 * @param <P>
 *            type */
public interface OPPLScriptVisitorEx<P> {
    /** @param q
     *            q
     * @param p
     *            p
     * @return visitor value */
    P visit(OPPLQuery q, P p);

    /** @param v
     *            v
     * @param p
     *            p
     * @return visitor value */
    P visit(Variable<?> v, P p);

    /** @param changes
     *            changes
     * @param p
     *            p
     * @return visitor value */
    P visitActions(List<OWLAxiomChange> changes, P p);
}
