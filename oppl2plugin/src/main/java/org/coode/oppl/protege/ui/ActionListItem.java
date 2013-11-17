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
import org.semanticweb.owlapi.model.OWLAxiomChange;

/** @author Luigi Iannone */
public class ActionListItem implements MListItem {
    private final OWLAxiomChange axiomChange;
    private final boolean isDeleteable;
    private final boolean isEditable;

    /** @param axiomChange
     * @param isEditable
     * @param isDeleteable */
    public ActionListItem(OWLAxiomChange axiomChange, boolean isEditable,
            boolean isDeleteable) {
        this.axiomChange = axiomChange;
        this.isDeleteable = isDeleteable;
        this.isEditable = isEditable;
    }

    @Override
    public String getTooltip() {
        String addOrRemove = axiomChange.isAddAxiom() ? "ADD " : "REMOVE ";
        String toFrom = axiomChange.isAddAxiom() ? " to " : " from ";
        return addOrRemove + " the axiom" + toFrom
                + axiomChange.getOntology().getOntologyID().getOntologyIRI().toString();
    }

    @Override
    public boolean handleDelete() {
        return true;
    }

    @Override
    public void handleEdit() {}

    @Override
    public boolean isDeleteable() {
        return isDeleteable;
    }

    @Override
    public boolean isEditable() {
        return isEditable;
    }

    /** @return the axiomChange */
    public OWLAxiomChange getAxiomChange() {
        return axiomChange;
    }
}
