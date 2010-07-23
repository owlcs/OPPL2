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
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.core.ui.list.MListSectionHeader;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLSelectClauseList extends MList {
	/**
	 *
	 */
	private static final long serialVersionUID = 3978563738563698974L;
	private final OWLEditorKit owlEditorKit;
	private ConstraintSystem constraintSystem;

	public OPPLSelectClauseList(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The editorKit cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = constraintSystem;
		DefaultListModel model = this.clearModel();
		this.setModel(model);
		this.setCellRenderer(new OPPLSelectListItemCellRederer());
	}

	/**
	 * @return
	 */
	private DefaultListModel clearModel() {
		DefaultListModel model = new DefaultListModel();
		model.addElement(new MListSectionHeader() {
			public boolean canAdd() {
				return true;
			}

			public String getName() {
				return "SELECT";
			}
		});
		return model;
	}

	@Override
	protected Border createListItemBorder(JList list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		Border toReturn = super.createListItemBorder(list, value, index,
				isSelected, cellHasFocus);
		if (value instanceof OPPLSelectClauseListItem
				&& ((OPPLSelectClauseListItem) value).isAsserted()) {
			toReturn = BorderFactory.createCompoundBorder(toReturn,
					new OPPLAssertedSelectClauseListItemBorder());
		}
		return toReturn;
	}

	private static class OPPLAssertedSelectClauseListItemBorder implements
			Border {
		public OPPLAssertedSelectClauseListItemBorder() {
		}

		private static final String ASSERTED = "ASSERTED";

		public Insets getBorderInsets(Component c) {
			return new Insets(0, c.getFontMetrics(c.getFont()).getStringBounds(
					ASSERTED, c.getGraphics()).getBounds().width + 8, 0, 0);
		}

		public boolean isBorderOpaque() {
			return false;
		}

		@SuppressWarnings("unused")
		public void paintBorder(Component c, Graphics g, int x, int y,
				int width, int height) {
			Color oldColor = g.getColor();
			g.setColor(Color.DARK_GRAY);
			g.drawString(OPPLAssertedSelectClauseListItemBorder.ASSERTED,
					x + 4, y + 2 + g.getFontMetrics().getAscent()
							+ g.getFontMetrics().getLeading());
			g.setColor(oldColor);
		}
	}

	private class OPPLSelectListItemCellRederer implements ListCellRenderer {
		private final DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
		private final VariableOWLCellRenderer variableAxiomRenderer = new VariableOWLCellRenderer(
				OPPLSelectClauseList.this.getOwlEditorKit(),
				OPPLSelectClauseList.this.getConstraintSystem(),
				new OWLCellRenderer(OPPLSelectClauseList.this.getOwlEditorKit()));

		public OPPLSelectListItemCellRederer() {
			this.variableAxiomRenderer.setHighlightKeywords(true);
			this.variableAxiomRenderer.setWrap(true);
		}

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Component toReturn = this.defaultListCellRenderer
					.getListCellRendererComponent(list, value, index,
							isSelected, cellHasFocus);
			if (value instanceof OPPLSelectClauseListItem) {
				OPPLSelectClauseListItem item = (OPPLSelectClauseListItem) value;
				toReturn = this.variableAxiomRenderer
						.getListCellRendererComponent(list, item, index,
								isSelected, cellHasFocus);
			}
			return toReturn;
		}
	}

	public void clear() {
		this.setModel(this.clearModel());
	}

	/**
	 * @return the owlEditorKit
	 */
	public final OWLEditorKit getOwlEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
