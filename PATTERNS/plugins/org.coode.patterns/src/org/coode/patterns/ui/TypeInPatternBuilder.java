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
import java.awt.event.KeyListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternModelChangeListener;
import org.coode.patterns.protege.ProtegePatternModel;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSectionRowObjectEditor;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRowObjectEditor;
import org.semanticweb.owl.model.OWLException;

/**
 * @author Luigi Iannone
 * 
 *         Jun 10, 2008
 */
public class TypeInPatternBuilder extends
		AbstractOWLFrameSectionRowObjectEditor<PatternModel> implements
		OWLFrameSectionRowObjectEditor<PatternModel>, VerifiedInputEditor,
		InputVerificationStatusChangedListener, PatternModelChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -4071865934355642992L;
	private Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private OWLEditorKit owlEditorKit;
	private PatternModel patternModel = null;
	private JPanel mainPanel = new JPanel();
	private ExpressionEditor<ProtegePatternModel> patternModelEditor;
	private ExpressionEditor<String> patternNameTextField;

	public TypeInPatternBuilder(OWLEditorKit owlEditorKit) {
		this.mainPanel.setLayout(new BorderLayout());
		this.mainPanel.setName("Pattern Text Editor");
		this.owlEditorKit = owlEditorKit;
		this.patternNameTextField = new ExpressionEditor<String>(owlEditorKit,
				new OWLExpressionChecker<String>() {
					private String lastName;

					public void check(String text)
							throws OWLExpressionParserException {
						if (text.matches("\\w+")) {
							this.lastName = text;
						} else {
							throw new OWLExpressionParserException(
									new Exception("Invalid pattern name "
											+ text));
						}
					}

					public String createObject(String text)
							throws OWLExpressionParserException {
						this.check(text);
						return this.lastName;
					}
				});
		JPanel patternNamePanel = new JPanel(new BorderLayout());
		patternNamePanel.add(this.patternNameTextField);
		this.patternNameTextField
				.addStatusChangedListener(new InputVerificationStatusChangedListener() {
					private void updateURI() {
						URI anURI = null;
						String localName = TypeInPatternBuilder.this.patternNameTextField
								.getText();
						try {
							if (localName.length() != 0) {
								try {
									anURI = new URI(PatternModel.NAMESPACE
											+ localName);
								} catch (URISyntaxException e) {
									anURI = null;
								}
							}
						} finally {
							if (TypeInPatternBuilder.this.patternModel != null) {
								TypeInPatternBuilder.this.patternModel
										.setUri(anURI);
							}
						}
						TypeInPatternBuilder.this.handleChange();
					}

					public void verifiedStatusChanged(boolean newState) {
						this.updateURI();
					}
				});
		patternNamePanel.setBorder(ComponentFactory
				.createTitledBorder("Pattern name"));
		this.mainPanel.add(patternNamePanel, BorderLayout.NORTH);
		this.patternModelEditor = new ExpressionEditor<ProtegePatternModel>(
				this.owlEditorKit, new PatternModelExpressionChecker(
						this.owlEditorKit));
		this.removeKeyListeners();
		this.patternModelEditor.setPreferredSize(new Dimension(50, 200));
		JScrollPane opplStatementEditorPane = ComponentFactory
				.createScrollPane(this.patternModelEditor);
		JPanel opplStatementEditorPanel = new JPanel(new BorderLayout());
		opplStatementEditorPanel.setBorder(ComponentFactory
				.createTitledBorder("Pattern statement"));
		this.patternModelEditor.addStatusChangedListener(this);
		opplStatementEditorPanel.add(opplStatementEditorPane);
		this.mainPanel.add(opplStatementEditorPanel, BorderLayout.CENTER);
		if (this.patternModel != null) {
			this.patternModel.addChangeListener(this);
		}
	}

	/**
	 * @see org.protege.editor.owl.ui.frame.VerifiedInputEditor#addStatusChangedListener(org.protege.editor.owl.ui.frame.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
		this.notifyListener(listener);
	}

	/**
	 * @see org.protege.editor.owl.ui.frame.VerifiedInputEditor#removeStatusChangedListener(org.protege.editor.owl.ui.frame.InputVerificationStatusChangedListener)
	 */
	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public PatternModel getPatternModel() {
		return this.patternModel;
	}

	public void verifiedStatusChanged(boolean newState) {
		this.patternModel = null;
		// There's valid stuff in the expression editors
		if (newState) {
			try {
				this.patternModel = this.patternModelEditor.createObject();
				this.patternModel.setUri(URI.create(PatternModel.NAMESPACE
						+ this.patternNameTextField.getText()));
			} catch (OWLExpressionParserException e) {
				e.printStackTrace();
			} catch (OWLException e) {
				e.printStackTrace();
			}
		}
		this.handleChange();
	}

	public void handleChange() {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			this.notifyListener(listener);
		}
	}

	/**
	 * @param listener
	 */
	private void notifyListener(InputVerificationStatusChangedListener listener) {
		listener.verifiedStatusChanged(this.patternModel != null
				&& this.patternModel.isValid()
				&& this.patternModel.getUri() != null);
	}

	public void clear() {
		this.patternModelEditor.setText("");
		this.patternNameTextField.setText("");
	}

	public void dispose() {
		if (this.patternModel != null) {
			this.patternModel.removeChangeListener(this);
		}
		this.patternModelEditor.removeStatusChangedListener(this);
	}

	public PatternModel getEditedObject() {
		return this.patternModel;
	}

	public JComponent getEditorComponent() {
		return this.mainPanel;
	}

	/**
	 * @param patternModel
	 *            the patternModel to set
	 */
	public void setPatternModel(PatternModel patternModel) {
		this.patternModelEditor.setText(patternModel.render());
		this.patternNameTextField.setText(patternModel.getPatternLocalName());
	}

	/**
	 *
	 */
	private void removeKeyListeners() {
		KeyListener[] keyListeners = this.patternModelEditor.getKeyListeners();
		for (KeyListener keyListener : keyListeners) {
			this.patternModelEditor.removeKeyListener(keyListener);
		}
	}
}
