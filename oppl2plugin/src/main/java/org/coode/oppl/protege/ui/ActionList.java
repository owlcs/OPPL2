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

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.Border;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owlapi.model.OWLAxiomChange;

/** @author Luigi Iannone */
public class ActionList extends MList {
    
    private static final long serialVersionUID = 6135780833694887712L;
    private final OWLEditorKit owlEditorKit;
    private final boolean canAdd;

    public ActionList(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem,
            boolean canAdd) {
        this.owlEditorKit = owlEditorKit;
        setModel(new ActionListModel(canAdd));
        this.canAdd = canAdd;
        VariableOWLCellRenderer variableAxiomRenderer = new VariableOWLCellRenderer(
                owlEditorKit, constraintSystem, new OWLCellRenderer(owlEditorKit));
        setCellRenderer(variableAxiomRenderer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final DefaultListModel<Object> getModel() {
        return (DefaultListModel<Object>) super.getModel();
    }

    @SuppressWarnings("unchecked")
    public void setModel(DefaultListModel<Object> model) {
        super.setModel(model);
    }

    @Override
    protected void handleDelete() {
        super.handleDelete();
        Object selectedValue = getSelectedValue();
        ((ActionListModel) getModel()).removeElement(selectedValue);
    }

    @Override
    protected Border createListItemBorder(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Border border = super.createListItemBorder(list, value, index, isSelected,
                cellHasFocus);
        return BorderFactory.createCompoundBorder(border, new ActionBorder(
                ((ActionListItem) value).getAxiomChange()));
    }

    private static class ActionBorder implements Border {
        private static final String REMOVE = "Remove";
        private static final String ADD = "Add";
        private final OWLAxiomChange axiomChange;

        ActionBorder(OWLAxiomChange axiomChange) {
            this.axiomChange = axiomChange;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, c.getFontMetrics(c.getFont())
                    .getStringBounds(REMOVE, c.getGraphics()).getBounds().width + 8, 0, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        protected String getString() {
            return axiomChange.isAddAxiom() ? ActionBorder.ADD : ActionBorder.REMOVE;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width,
                int height) {
            Color oldColor = g.getColor();
            g.setColor(Color.DARK_GRAY);
            g.drawString(getString(), x + 4, y + 2 + g.getFontMetrics().getAscent()
                    + g.getFontMetrics().getLeading());
            g.setColor(oldColor);
        }
    }

    public void setConstraintSystem(ConstraintSystem constraintSystem) {
        setCellRenderer(new VariableOWLCellRenderer(owlEditorKit, constraintSystem,
                new OWLCellRenderer(owlEditorKit)));
    }

    public void clear() {
        setModel(new ActionListModel(canAdd));
    }
}
