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
package org.coode.oppl.protege.ui.rendering;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import org.coode.oppl.protege.ui.ActionListItem;
import org.coode.oppl.protege.ui.OPPLSelectClauseListItem;
import org.coode.oppl.protege.ui.OWLObjectListItem;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableOWLCellRenderer extends OWLCellRenderer implements
		ListCellRenderer {
	private final ConstraintSystem constraintSystem;
	private final OWLCellRenderer defaultRenderer;

	/**
	 * Builds a an instance of this VariableOWLCellRenderer from a constraint
	 * system and a default renderer for non variable OWLObject instances.
	 * 
	 * @param owlEditorKit
	 *            the OWLEditorKit. Cannot be {@code null}.
	 * @param constraintSystem
	 *            the ConstraintSystem for detecting variables. Cannot be
	 *            {@code null}.
	 * @param defaultRenderer
	 *            the fall-back renderer for non variable OWLObjects. Cannot be
	 *            {@code null}.
	 * @throws IllegalArgumentException
	 *             when either of the inputs is {@code null}.
	 */
	public VariableOWLCellRenderer(OWLEditorKit owlEditorKit,
			ConstraintSystem constraintSystem, OWLCellRenderer defaultRenderer) {
		super(owlEditorKit);
		ArgCheck.checkNullArgument("The OWL editor kit", owlEditorKit);
		ArgCheck.checkNullArgument("The constraint system", constraintSystem);
		ArgCheck.checkNullArgument("The default cell renderer", defaultRenderer);
		this.constraintSystem = constraintSystem;
		this.defaultRenderer = defaultRenderer;
		setHighlightKeywords(true);
		setWrap(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Component toReturn = this.defaultRenderer.getListCellRendererComponent(
				list, value, index, isSelected, cellHasFocus);
		if (value instanceof ActionListItem) {
			ActionListItem actionListItem = (ActionListItem) value;
			OWLAxiomChange axiomChange = actionListItem.getAxiomChange();
			toReturn = super.getListCellRendererComponent(list, axiomChange
					.getAxiom(), index, isSelected, cellHasFocus);
		}
		if (value instanceof OPPLSelectClauseListItem) {
			OWLAxiom axiom = ((OPPLSelectClauseListItem) value).getAxiom();
			toReturn = super.getListCellRendererComponent(list, axiom, index,
					isSelected, cellHasFocus);
		}
		if (value instanceof OWLObjectListItem) {
			toReturn = super.getListCellRendererComponent(list,
					((OWLObjectListItem) value).getOwlObject(), index,
					isSelected, cellHasFocus);
		}
		return toReturn;
	}

	@Override
	public String getRendering(Object object) {
		if (object instanceof OWLObject) {
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = ParserFactory
					.getInstance().getOPPLFactory()
					.getManchesterSyntaxRenderer(this.constraintSystem);
			OWLObject owlObject = (OWLObject) object;
			owlObject.accept(manchesterSyntaxRenderer);
			return manchesterSyntaxRenderer.toString();
		}
		return super.getRendering(object);
	}
}
