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
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.oppl.variabletypes.VariableType;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.core.ui.list.MListButton;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * List that contains the OWLObject instances used in a series of OWLAxiomChange
 * elements
 * 
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLObjectList extends MList implements ActionListener, OPPLMacroStatusChange,
		ListDataListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 6844484022100475838L;

	/**
	 * This button will generalise the corresponding OWLObject into the
	 * appropriate Variable
	 * 
	 * @author Luigi Iannone
	 * 
	 */
	static class CreateNewVariableButton extends MListButton {
		protected CreateNewVariableButton(ActionListener actionListener) {
			super("Create new Variable", new Color(0, 0, 255), actionListener);
		}

		@Override
		public void paintButtonContent(Graphics2D g) {
			int stringWidth = g.getFontMetrics().getStringBounds("V*", g).getBounds().width;
			int w = this.getBounds().width;
			int h = this.getBounds().height;
			g.drawString("V*", this.getBounds().x + w / 2 - stringWidth / 2, this.getBounds().y
					+ g.getFontMetrics().getAscent() / 2 + h / 2);
		}
	}

	static class AddToVariableButton extends MListButton {
		protected AddToVariableButton(ActionListener actionListener) {
			super("Add to Variable", new Color(0, 0, 255), actionListener);
		}

		@Override
		public void paintButtonContent(Graphics2D g) {
			int stringWidth = g.getFontMetrics().getStringBounds("V+", g).getBounds().width;
			int w = this.getBounds().width;
			int h = this.getBounds().height;
			g.drawString("V+", this.getBounds().x + w / 2 - stringWidth / 2, this.getBounds().y
					+ g.getFontMetrics().getAscent() / 2 + h / 2);
		}
	}

	private final ConstraintSystem constraintSystem;
	private final List<Variable> variables = new ArrayList<Variable>();
	private final List<OPPLMacroListener> listeners = new ArrayList<OPPLMacroListener>();
	private final OWLEditorKit owlEditorKit;

	protected OWLObjectList(ConstraintSystem cs, OWLEditorKit owlEditorKit) {
		this.owlEditorKit = owlEditorKit;
		this.constraintSystem = cs;
		this.setCellRenderer(new VariableOWLCellRenderer(owlEditorKit, this.constraintSystem,
				new OWLCellRenderer(owlEditorKit)));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof CreateNewVariableButton) {
			this.createVariable();
		} else if (e.getSource() instanceof AddToVariableButton) {
			this.addToVariable();
		}
	}

	private void addToVariable() {
		Object selectedValue = this.getSelectedValue();
		if (selectedValue instanceof OWLObjectListItem) {
			OWLObject owlObject = ((OWLObjectListItem) selectedValue).getOwlObject();
			VariableList variableList = new VariableList(this.owlEditorKit, this.constraintSystem);
			VariableType variableType = VariableType.getVariableType(owlObject);
			for (Variable variable : this.getVariables()) {
				if (variable.getType().equals(variableType)) {
					((DefaultListModel) variableList.getModel()).addElement(new VariableListItem(
							variable, this.getConstraintSystem(), this.getOWLEditorKit(), false,
							false));
				}
			}
			JScrollPane panel = ComponentFactory.createScrollPane(variableList);
			JOptionPane jOptionPane = new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION);
			JDialog jDialog = jOptionPane.createDialog(this.getParent(), "Choose your Variable");
			jDialog.pack();
			jDialog.setVisible(true);
			Object value = variableList.getSelectedValue();
			if (value instanceof VariableListItem) {
				Variable selectedVariable = ((VariableListItem) value).getVariable();
				boolean added = this.constraintSystem.addLeaf(selectedVariable, owlObject);
				if (!added) {
					JOptionPane.showMessageDialog(
							this.getParent(),
							"Incompatible variable selected",
							this.owlEditorKit.getModelManager().getRendering(owlObject),
							JOptionPane.PLAIN_MESSAGE);
				} else {
					this.notifyAdded2Variable(selectedVariable, owlObject);
				}
			}
		}
	}

	/**
	 *
	 */
	private void createVariable() {
		Object[] selectedValues = this.getSelectedValues();
		for (Object object : selectedValues) {
			if (object instanceof OWLObjectListItem) {
				OWLObjectListItem owlObjectListItem = (OWLObjectListItem) object;
				OWLObject owlObject = owlObjectListItem.getOwlObject();
				VariableType variableType = VariableType.getVariableType(owlObject);
				try {
					String name = JOptionPane.showInputDialog("Please input a name for the variable that will generalise this entity: ");
					if (name != null) {
						name = name.startsWith("?") ? name : "?" + name;
						Variable variable = this.getConstraintSystem().createVariable(
								name,
								variableType);
						boolean added = this.getConstraintSystem().addLeaf(variable, owlObject);
						if (added) {
							this.addVariable(variable);
							((DefaultListModel) this.getModel()).removeElement(owlObjectListItem);
						} else {
							JOptionPane.showMessageDialog(
									this.getParent(),
									"Incompatible variable selected",
									this.owlEditorKit.getModelManager().getRendering(owlObject),
									JOptionPane.PLAIN_MESSAGE);
						}
					}
				} catch (OPPLException opplException) {
					opplException.printStackTrace();
				}
			}
		}
	}

	private void addVariable(Variable variable) {
		this.variables.add(variable);
		this.notifyAddedVariable(variable);
	}

	@Override
	protected List<MListButton> getListItemButtons(MListItem item) {
		List<MListButton> toReturn = new ArrayList<MListButton>(super.getListItemButtons(item));
		toReturn.add(new CreateNewVariableButton(this));
		if (!this.getVariables().isEmpty()) {
			Iterator<Variable> it = this.getVariables().iterator();
			boolean found = false;
			while (!found && it.hasNext()) {
				Variable existingVariable = it.next();
				VariableType existingVariableType = existingVariable.getType();
				if (item instanceof OWLObjectListItem) {
					VariableType itemVariableType = VariableType.getVariableType(((OWLObjectListItem) item).getOwlObject());
					found = existingVariableType.equals(itemVariableType);
				}
			}
			if (found) {
				toReturn.add(new AddToVariableButton(this));
			}
		}
		return toReturn;
	}

	private void notifyAddedVariable(Variable variable) {
		for (OPPLMacroListener listener : this.listeners) {
			listener.handleGeneralisedOWLObject(variable);
		}
	}

	private void notifyAdded2Variable(Variable variable, OWLObject owlObject) {
		for (OPPLMacroListener listener : this.listeners) {
			listener.handleGeneralisedOWLObject(variable, owlObject);
		}
	}

	/**
	 * @see org.coode.oppl.protege.ui.OPPLMacroStatusChange#addOPPLMacroListener(org.coode.oppl.protege.ui.OPPLMacroListener)
	 */
	public void addOPPLMacroListener(OPPLMacroListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * @see org.coode.oppl.protege.ui.OPPLMacroStatusChange#removeOPPLMacroListener(org.coode.oppl.protege.ui.OPPLMacroListener)
	 */
	public void removeOPPLMacroListener(OPPLMacroListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * @return the variables
	 */
	public List<Variable> getVariables() {
		return this.variables;
	}

	public void contentsChanged(ListDataEvent e) {
		Object source = e.getSource();
		if (source instanceof DefaultListModel) {
			DefaultListModel variableList = (DefaultListModel) source;
			this.updateVariables(variableList);
		}
	}

	/**
	 * @param variableList
	 */
	private void updateVariables(DefaultListModel model) {
		this.variables.clear();
		for (int i = 0; i < model.getSize(); i++) {
			VariableListItem item = (VariableListItem) model.getElementAt(i);
			this.variables.add(item.getVariable());
		}
	}

	public void intervalAdded(ListDataEvent e) {
		Object source = e.getSource();
		if (source instanceof DefaultListModel) {
			DefaultListModel variableList = (DefaultListModel) source;
			this.updateVariables(variableList);
		}
	}

	public void intervalRemoved(ListDataEvent e) {
		Object source = e.getSource();
		if (source instanceof DefaultListModel) {
			DefaultListModel variableList = (DefaultListModel) source;
			this.updateVariables(variableList);
		}
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
