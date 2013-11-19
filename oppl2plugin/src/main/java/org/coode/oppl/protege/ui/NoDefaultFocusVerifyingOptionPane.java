package org.coode.oppl.protege.ui;

import javax.swing.JComponent;

import org.protege.editor.core.ui.util.VerifyingOptionPane;

public final class NoDefaultFocusVerifyingOptionPane extends VerifyingOptionPane {
    private static final long serialVersionUID = 20100L;

    public NoDefaultFocusVerifyingOptionPane(JComponent c) {
        super(c);
    }

    @Override
    public void selectInitialValue() {
        // This is overridden so that the option pane dialog default
        // button
        // doesn't get the focus.
    }
}
