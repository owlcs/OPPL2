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

import org.protege.editor.core.ui.list.MListItem;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class OWLObjectListItem implements MListItem {

    private final OWLObject owlObject;

    /**
     * @param owlObject
     *        owlObject
     */
    public OWLObjectListItem(OWLObject owlObject) {
        this.owlObject = owlObject;
    }

    @Override
    public String getTooltip() {
        return owlObject.toString();
    }

    @Override
    public boolean handleDelete() {
        return false;
    }

    @Override
    public void handleEdit() {}

    @Override
    public boolean isDeleteable() {
        return false;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    /**
     * @return the owlObject
     */
    public OWLObject getOwlObject() {
        return owlObject;
    }
}
