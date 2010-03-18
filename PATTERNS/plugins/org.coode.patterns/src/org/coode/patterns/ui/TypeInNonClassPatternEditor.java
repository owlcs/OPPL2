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
package org.coode.patterns.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.coode.oppl.protege.ui.OPPLScriptInstantiationEditor;
import org.coode.patterns.InstantiatedPatternModel;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;

/**
 * @author Luigi Iannone
 * 
 *         Sep 18, 2008
 */
public class TypeInNonClassPatternEditor extends
		OPPLScriptInstantiationEditor<InstantiatedPatternModel> {
	public TypeInNonClassPatternEditor(
			InstantiatedPatternModel instantiatedPatternModel,
			OWLEditorKit owlEditorKit) {
		super(instantiatedPatternModel, owlEditorKit);
	}

	/**
	 * @see org.coode.oppl.protege.ui.OPPLScriptInstantiationEditor#getScriptExpressionEditor()
	 */
	@Override
	protected ExpressionEditor<InstantiatedPatternModel> getScriptExpressionEditor() {
		return new ExpressionEditor<InstantiatedPatternModel>(
				this.owlEditorKit,
				new InstantiatedPatternModelArgumentExpressionChecker(
						this.instantiatedScript.getName(), this.owlEditorKit));
	}

	/**
	 * 
	 * @see org.coode.oppl.protege.ui.OPPLScriptInstantiationEditor#setupAutoCompleter()
	 */
	@Override
	protected void setupAutoCompleter() {
		new InstantiatedPatternArgumentCompleter(this.instantiatedScript
				.getName(), this.owlEditorKit, this.editor, this.editor
				.getExpressionChecker());
	}

	@Override
	protected void init() {
		super.init();
		this.editor.setPreferredSize(new Dimension(50, 20));
		this.editor.addStatusChangedListener(this);
		JScrollPane editorPane = ComponentFactory.createScrollPane(this.editor);
		JPanel editorPanel = new JPanel(new BorderLayout());
		editorPanel.setBorder(ComponentFactory
				.createTitledBorder("Instantiated Pattern "));
		editorPanel.add(new JLabel(this.instantiatedScript.getName() + "("),
				BorderLayout.WEST);
		editorPanel.add(editorPane, BorderLayout.CENTER);
		editorPanel.add(new JLabel(")"), BorderLayout.EAST);
		this.mainPane.add(editorPanel);
	}
}
