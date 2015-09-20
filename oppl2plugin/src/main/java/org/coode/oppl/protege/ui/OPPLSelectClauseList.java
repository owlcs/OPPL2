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

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.protege.editor.core.ui.list.MListSectionHeader;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;

/**
 * @author Luigi Iannone
 */
public class OPPLSelectClauseList extends OPPLMList {

    private static final long serialVersionUID = 20100L;
    private final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;

    /**
     * @param owlEditorKit
     *        owlEditorKit
     * @param constraintSystem
     *        constraintSystem
     */
    public OPPLSelectClauseList(OWLEditorKit owlEditorKit,
        ConstraintSystem constraintSystem) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        DefaultListModel model = clearModel();
        setModel(model);
        setCellRenderer(new OPPLSelectListItemCellRederer());
    }

    /**
     * @return empty model
     */
    private DefaultListModel clearModel() {
        DefaultListModel model = new DefaultListModel();
        model.addElement(new MListSectionHeader() {

            @Override
            public boolean canAdd() {
                return true;
            }

            @Override
            public String getName() {
                return "SELECT";
            }
        });
        return model;
    }

    @Override
    protected Border createListItemBorder(JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {
        Border toReturn = super.createListItemBorder(list, value, index, isSelected,
            cellHasFocus);
        if (value instanceof OPPLSelectClauseListItem
            && ((OPPLSelectClauseListItem) value).isAsserted()) {
            toReturn = BorderFactory.createCompoundBorder(toReturn,
                new OPPLAssertedSelectClauseListItemBorder());
        }
        return toReturn;
    }

    private static class OPPLAssertedSelectClauseListItemBorder implements Border {

        public OPPLAssertedSelectClauseListItemBorder() {}

        private static final String ASSERTED = "ASSERTED";

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, c.getFontMetrics(c.getFont())
                .getStringBounds(ASSERTED, c.getGraphics()).getBounds().width + 8, 0,
                0);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width,
            int height) {
            Color oldColor = g.getColor();
            g.setColor(Color.DARK_GRAY);
            g.drawString(OPPLAssertedSelectClauseListItemBorder.ASSERTED, x + 4, y + 2
                + g.getFontMetrics().getAscent() + g.getFontMetrics().getLeading());
            g.setColor(oldColor);
        }
    }

    private class OPPLSelectListItemCellRederer implements ListCellRenderer {

        private final DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
        private final VariableOWLCellRenderer variableAxiomRenderer = new VariableOWLCellRenderer(
            getOwlEditorKit(), getConstraintSystem(), new OWLCellRenderer(
                getOwlEditorKit()));

        public OPPLSelectListItemCellRederer() {
            variableAxiomRenderer.setHighlightKeywords(true);
            variableAxiomRenderer.setWrap(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
            Component toReturn = defaultListCellRenderer.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
            if (value instanceof OPPLSelectClauseListItem) {
                OPPLSelectClauseListItem item = (OPPLSelectClauseListItem) value;
                toReturn = variableAxiomRenderer.getListCellRendererComponent(list, item,
                    index, isSelected, cellHasFocus);
            }
            return toReturn;
        }
    }

    /**
     * 
     */
    public void clear() {
        setModel(clearModel());
    }

    /**
     * @return the owlEditorKit
     */
    public final OWLEditorKit getOwlEditorKit() {
        return owlEditorKit;
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}
