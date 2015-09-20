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

import java.awt.Component;

import javax.swing.*;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
import org.coode.oppl.variabletypes.InputVariable;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class VariableList extends OPPLMList {

    class VariableListCellRenderer extends DefaultListCellRenderer {

        private static final long serialVersionUID = 20100L;

        // private final DefaultListCellRenderer defaultCellRenderer = new
        // DefaultListCellRenderer();
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value,
                index, isSelected, cellHasFocus);
            if (value instanceof VariableListItem) {
                Variable<?> variable = ((VariableListItem) value).getVariable();
                VariableScope<?> variableScope = variable
                    .accept(new AbstractVariableVisitorExAdapter<VariableScope<?>>(
                        null) {

                        @Override
                        public <P extends OWLObject> VariableScope<?> visit(
                            InputVariable<P> v) {
                            return v.getVariableScope();
                        }
                    });
                String variableScopeString = null;
                if (variableScope == null) {
                    variableScopeString = "";
                } else {
                    String rendering = owlEditorKit.getModelManager().getRendering(
                        variableScope.getScopingObject());
                    variableScopeString = new StringBuilder("[")
                        .append(variableScope.getDirection()).append(" ")
                        .append(rendering).append("] ").toString();
                }
                label.setIcon(new ImageIcon(this
                    .getClass()
                    .getClassLoader()
                    .getResource(
                        variable instanceof GeneratedVariable<?> ? "cog.png"
                            : "user-icon.gif")));
                label.setText(constraintSystem.render(variable) + ":"
                    + variable.getType() + variableScopeString);
            }
            return label;
        }
    }

    private static final long serialVersionUID = 20100L;
    private final VariableListCellRenderer variableListCellRenderer = new VariableListCellRenderer();
    protected final OWLEditorKit owlEditorKit;
    protected ConstraintSystem constraintSystem;

    /**
     * @param owlEditorKit
     *        owlEditorKit
     * @param constraintSystem
     *        constraintSystem
     */
    public VariableList(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem) {
        this.owlEditorKit = owlEditorKit;
        this.constraintSystem = constraintSystem;
        setModel(new DefaultListModel());
        setCellRenderer(variableListCellRenderer);
    }

    @Override
    protected void handleDelete() {
        super.handleDelete();
        Object selectedValue = getSelectedValue();
        if (selectedValue != null) {
            getDefaultModel().removeElement(selectedValue);
        }
    }

    protected OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /**
     * @return variable list cell renderer
     */
    public ListCellRenderer getVariableListCellRenderer() {
        return variableListCellRenderer;
    }
}
