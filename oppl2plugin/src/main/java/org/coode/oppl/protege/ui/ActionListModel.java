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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;

import org.semanticweb.owlapi.model.OWLAxiomChange;

/** @author Luigi Iannone */
public class ActionListModel extends DefaultListModel<Object> {
    /** @param canAdd */
    public ActionListModel(boolean canAdd) {
        if (canAdd) {
            addElement(new ActionListSectionHeader());
        }
    }

    private static final long serialVersionUID = -5708452398843328281L;

    /** @param axiomChange
     * @param isEditable
     * @param isDeleteable */
    public void addAction(OWLAxiomChange axiomChange, boolean isEditable,
            boolean isDeleteable) {
        addElement(new ActionListItem(axiomChange, isEditable, isDeleteable));
    }

    /** @return the changes */
    public List<OWLAxiomChange> getOWLAxiomChanges() {
        List<OWLAxiomChange> toReturn = new ArrayList<OWLAxiomChange>();
        Enumeration<? extends Object> elements = elements();
        while (elements.hasMoreElements()) {
            ActionListItem actionListItem = (ActionListItem) elements.nextElement();
            OWLAxiomChange axiomChange = actionListItem.getAxiomChange();
            toReturn.add(axiomChange);
        }
        return toReturn;
    }
}
