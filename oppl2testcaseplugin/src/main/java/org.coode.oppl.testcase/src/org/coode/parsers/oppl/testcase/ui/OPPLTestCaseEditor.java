/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.coode.oppl.protege.ui.OPPLExpressionChecker;
import org.coode.oppl.protege.ui.ShowMessageRuntimeExceptionHandler;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.protege.DuplicateOPPLTestCaseNameException;
import org.coode.parsers.oppl.testcase.protege.OPPLTestCaseAnnotationContainer;
import org.coode.parsers.oppl.testcase.protege.ProtegeParserFactory;
import org.coode.parsers.oppl.ui.autocompletionmatcher.ProtegeOPPLTestCaseAutoCompletionMatcher;
import org.coode.parsers.ui.AutoCompleter;
import org.coode.parsers.ui.ExpressionEditor;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.editor.AbstractOWLObjectEditor;

/** @author Luigi Iannone */
public class OPPLTestCaseEditor extends AbstractOWLObjectEditor<OPPLTestCase> implements
        VerifiedInputEditor {
    private final OWLEditorKit owlEditorKit;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private JPanel mainPanel;
    private OPPLTestCase opplTestCase = null;
    private final Set<OPPLTestCase> otherOPPLTestCases = new HashSet<OPPLTestCase>();
    private final ExpressionEditor<OPPLTestCase> editor;
    private final ProtegeOPPLTestCaseAutoCompletionMatcher autoCompletionMatcher;

    /** @param owlEditorKit */
    public OPPLTestCaseEditor(OWLEditorKit owlEditorKit) {
        if (owlEditorKit == null) {
            throw new NullPointerException("The OWL editor kit cannot be null");
        }
        this.owlEditorKit = owlEditorKit;
        otherOPPLTestCases.addAll(new OPPLTestCaseAnnotationContainer(getOWLEditorKit())
                .getOPPLTestCases());
        editor = new ExpressionEditor<OPPLTestCase>(getOWLEditorKit()
                .getOWLModelManager().getOWLOntologyManager(),
                new OPPLExpressionChecker<OPPLTestCase>(getOWLEditorKit()) {
                    @Override
                    protected OPPLTestCase parse(String text) {
                        ProtegeParserFactory parserFactory = new ProtegeParserFactory(
                                getOWLEditorKit());
                        OPPLTestCaseParser parser = parserFactory.build(getListener());
                        OPPLTestCase toReturn = null;
                        OPPLTestCase parsed = parser.parse(text,
                                new ShowMessageRuntimeExceptionHandler(
                                        OPPLTestCaseEditor.this.getEditorComponent()));
                        // Need to check that he test name is unique.
                        if (parsed != null && !isNameUnique(parsed)) {
                            getListener().reportThrowable(
                                    new DuplicateOPPLTestCaseNameException(parsed
                                            .getName()), 1, 0, parsed.getName().length());
                        } else {
                            toReturn = parsed;
                        }
                        return toReturn;
                    }

                    private final boolean isNameUnique(OPPLTestCase opplTestCase) {
                        boolean found = false;
                        Iterator<OPPLTestCase> iterator = otherOPPLTestCases.iterator();
                        while (!found && iterator.hasNext()) {
                            OPPLTestCase existingOPPLTestCase = iterator.next();
                            found = opplTestCase.getName().compareTo(
                                    existingOPPLTestCase.getName()) == 0;
                        }
                        return !found;
                    }
                });
        autoCompletionMatcher = new ProtegeOPPLTestCaseAutoCompletionMatcher(
                getOWLEditorKit());
        new AutoCompleter(editor, autoCompletionMatcher);
        editor.addStatusChangedListener(new org.coode.parsers.ui.InputVerificationStatusChangedListener() {
            @Override
            public void verifiedStatusChanged(boolean newState) {
                opplTestCase = editor.createObject();
                OPPLTestCaseEditor.this.handleChange();
            }
        });
        initGUI();
    }

    protected void handleChange() {
        boolean newStatus = check();
        for (InputVerificationStatusChangedListener l : listeners) {
            l.verifiedStatusChanged(newStatus);
        }
    }

    private void initGUI() {
        mainPanel = new JPanel(new BorderLayout());
        editor.setPreferredSize(new Dimension(300, 200));
        mainPanel.add(editor, BorderLayout.CENTER);
    }

    private boolean check() {
        return opplTestCase != null;
    }

    /** @see org.protege.editor.core.ui.util.VerifiedInputEditor#addStatusChangedListener
     *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener) */
    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        if (listener != null) {
            listener.verifiedStatusChanged(check());
            listeners.add(listener);
        }
    }

    /** @see org.protege.editor.core.ui.util.VerifiedInputEditor#
     *      removeStatusChangedListener
     *      (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener) */
    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @see org.protege.editor.owl.ui.editor.OWLObjectEditor#getEditorTypeName() */
    @Override
    public String getEditorTypeName() {
        return "OPPL Test Case";
    }

    /** @see org.protege.editor.owl.ui.editor.OWLObjectEditor#canEdit(java.lang.Object
     *      ) */
    @Override
    public boolean canEdit(Object object) {
        return true;
    }

    /** @see org.protege.editor.owl.ui.editor.OWLObjectEditor#getEditorComponent() */
    @Override
    public JComponent getEditorComponent() {
        return mainPanel;
    }

    /** @see org.protege.editor.owl.ui.editor.OWLObjectEditor#getEditedObject() */
    @Override
    public OPPLTestCase getEditedObject() {
        return opplTestCase;
    }

    /** @see org.protege.editor.owl.ui.editor.OWLObjectEditor#setEditedObject(java
     *      .lang.Object) */
    @Override
    public boolean setEditedObject(OPPLTestCase editedObject) {
        // This needs to be reset as the parser checks for duplicates test case
        // names.
        otherOPPLTestCases.clear();
        otherOPPLTestCases.addAll(new OPPLTestCaseAnnotationContainer(getOWLEditorKit())
                .getOPPLTestCases());
        if (editedObject != null) {
            // I have to remove the one I am actually operating on.
            otherOPPLTestCases.remove(editedObject);
            editor.setText(editedObject.toString());
        } else {
            editor.setText("");
        }
        return true;
    }

    /** @see org.protege.editor.owl.ui.editor.OWLObjectEditor#dispose() */
    @Override
    public void dispose() {
        autoCompletionMatcher.dispose();
    }
}
