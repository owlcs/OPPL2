package org.coode.oppltestcase.ui.utils;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.core.ui.util.VerifyingOptionPane;

public class JOptionPaneEx {
	public static int showValidatingConfirmDialog(Component parent,
			String title, JComponent component,
			VerifiedInputEditor verifiedInputEditor, int messageType,
			int optionType, final JComponent defaultFocusedComponent) {
		final VerifyingOptionPane optionPane = new VerifyingOptionPane(
				component, messageType, optionType) {
			/**
                 * 
                 */
			private static final long serialVersionUID = 7128847118051849761L;

			@Override
			public void selectInitialValue() {
				// This is overridden so that the option pane dialog default
				// button doesn't get the focus.
			}
		};
		final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
			public void verifiedStatusChanged(boolean verified) {
				optionPane.setOKEnabled(verified);
			}
		};
		verifiedInputEditor.addStatusChangedListener(verificationListener);
		final JDialog dlg = createDialog(parent, title, optionPane,
				defaultFocusedComponent);
		dlg.setModal(true);
		dlg.setVisible(true);
		return getReturnValue(optionPane);
	}

	private static JDialog createDialog(Component parent, String title,
			JOptionPane optionPane, final JComponent defaultFocusedComponent) {
		JDialog dlg = optionPane.createDialog(parent, title);
		dlg.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (defaultFocusedComponent != null) {
					defaultFocusedComponent.requestFocusInWindow();
				}
			}
		});
		dlg.setLocationRelativeTo(parent);
		dlg.setResizable(true);
		dlg.pack();
		return dlg;
	}

	private static int getReturnValue(JOptionPane optionPane) {
		Object value = optionPane.getValue();
		if (value != null && optionPane.getOptions() != null) {
			value = Arrays.binarySearch(optionPane.getOptions(), value);
		}
		return value != null ? (Integer) value : JOptionPane.CLOSED_OPTION;
	}
}
