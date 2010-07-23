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

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableScope;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableList extends MList {
	class VariableListCellRenderer extends DefaultListCellRenderer {
		/**
		 *
		 */
		private static final long serialVersionUID = -6717057306871665492L;

		// private final DefaultListCellRenderer defaultCellRenderer = new
		// DefaultListCellRenderer();
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list,
					value, index, isSelected, cellHasFocus);
			if (value instanceof VariableListItem) {
				Variable variable = ((VariableListItem) value).getVariable();
				VariableScope variableScope = variable.getVariableScope();
				String variableScopeString = null;
				if (variableScope == null) {
					variableScopeString = "";
				} else {
					String rendering = VariableList.this.owlEditorKit
							.getModelManager().getRendering(
									variableScope.getScopingObject());
					variableScopeString = new StringBuilder("[").append(
							variableScope.getDirection()).append(" ").append(
							rendering).append("] ").toString();
				}
				label.setIcon(new ImageIcon(
						this.getClass()
								.getClassLoader()
								.getResource(
										variable instanceof SingleValueGeneratedVariable<?> ? "cog.png"
												: "user-icon.gif")));
				label.setText(VariableList.this.constraintSystem
						.render(variable)
						+ ":" + variable.getType() + variableScopeString);
			}
			return label;
		}
	}

	private static final long serialVersionUID = 6135780833694887712L;
	private final VariableListCellRenderer variableListCellRenderer = new VariableListCellRenderer();
	protected final OWLEditorKit owlEditorKit;
	protected ConstraintSystem constraintSystem;

	public VariableList(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem) {
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = constraintSystem;
		this.setModel(new DefaultListModel());
		this.setCellRenderer(this.variableListCellRenderer);
	}

	@Override
	protected void handleDelete() {
		super.handleDelete();
		DefaultListModel model = (DefaultListModel) this.getModel();
		Object selectedValue = this.getSelectedValue();
		if (selectedValue != null) {
			model.removeElement(selectedValue);
		}
	}

	protected OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	public ListCellRenderer getVariableListCellRenderer() {
		return this.variableListCellRenderer;
	}
}
