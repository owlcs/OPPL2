/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.coode.oppl.protege.ui.OPPLExpressionChecker;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.protege.ProtegeParserFactory;
import org.coode.parsers.ui.ExpressionEditor;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.editor.AbstractOWLObjectEditor;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseEditor extends AbstractOWLObjectEditor<OPPLTestCase> implements
		VerifiedInputEditor {
	private final OWLEditorKit owlEditorKit;
	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private JPanel mainPanel;
	private OPPLTestCase opplTestCase = null;
	private final ExpressionEditor<OPPLTestCase> editor;

	/**
	 * @param owlEditorKit
	 */
	public OPPLTestCaseEditor(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.editor = new ExpressionEditor<OPPLTestCase>(
				this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager(),
				new OPPLExpressionChecker<OPPLTestCase>(this.getOWLEditorKit()) {
					@Override
					protected OPPLTestCase parse(String text) {
						ProtegeParserFactory parserFactory = new ProtegeParserFactory(
								this.getOWLEditorKit());
						OPPLTestCaseParser parser = parserFactory.build(this.getListener());
						return parser.parse(text);
					}
				});
		this.editor.addStatusChangedListener(new org.coode.parsers.ui.InputVerificationStatusChangedListener() {
			public void verifiedStatusChanged(boolean newState) {
				OPPLTestCaseEditor.this.opplTestCase = OPPLTestCaseEditor.this.editor.createObject();
				OPPLTestCaseEditor.this.handleChange();
			}
		});
		this.initGUI();
	}

	protected void handleChange() {
		boolean newStatus = this.check();
		for (InputVerificationStatusChangedListener l : this.listeners) {
			l.verifiedStatusChanged(newStatus);
		}
	}

	private void initGUI() {
		this.mainPanel = new JPanel(new BorderLayout());
		this.editor.setPreferredSize(new Dimension(300, 200));
		this.mainPanel.add(this.editor, BorderLayout.CENTER);
	}

	private boolean check() {
		return this.opplTestCase != null;
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener
	 *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
		if (listener != null) {
			listener.verifiedStatusChanged(this.check());
			this.listeners.add(listener);
		}
	}

	/**
	 * @see org.protege.editor.core.ui.util.VerifiedInputEditor#
	 *      removeStatusChangedListener
	 *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener)
	 */
	public void removeStatusChangedListener(InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @see org.protege.editor.owl.ui.editor.OWLObjectEditor#getEditorTypeName()
	 */
	public String getEditorTypeName() {
		return "OPPL Test Case";
	}

	/**
	 * @see org.protege.editor.owl.ui.editor.OWLObjectEditor#canEdit(java.lang.Object
	 *      )
	 */
	public boolean canEdit(Object object) {
		return true;
	}

	/**
	 * @see org.protege.editor.owl.ui.editor.OWLObjectEditor#getEditorComponent()
	 */
	public JComponent getEditorComponent() {
		return this.mainPanel;
	}

	/**
	 * @see org.protege.editor.owl.ui.editor.OWLObjectEditor#getEditedObject()
	 */
	public OPPLTestCase getEditedObject() {
		return this.opplTestCase;
	}

	/**
	 * @see org.protege.editor.owl.ui.editor.OWLObjectEditor#setEditedObject(java
	 *      .lang.Object)
	 */
	public boolean setEditedObject(OPPLTestCase editedObject) {
		if (editedObject != null) {
			this.editor.setText(editedObject.toString());
		}
		return true;
	}

	/**
	 * @see org.protege.editor.owl.ui.editor.OWLObjectEditor#dispose()
	 */
	public void dispose() {
	}
}
