package org.coode.oppl.protege.ui;

import java.awt.Component;
import java.util.regex.PatternSyntaxException;

import javax.swing.JOptionPane;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLRuntimeException;

public class ShowMessageRuntimeExceptionHandler implements RuntimeExceptionHandler {
	private final Component parentComponent;

	/**
	 * @param parentComponent
	 */
	public ShowMessageRuntimeExceptionHandler(Component parentComponent) {
		if (parentComponent == null) {
			throw new NullPointerException("The parent component cannot be null");
		}
		this.parentComponent = parentComponent;
	}

	public void handleOWLRuntimeException(OWLRuntimeException e) {
		JOptionPane.showMessageDialog(
				this.getParentComponent(),
				e.getMessage(),
				"OPPL Runtime error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
		JOptionPane.showMessageDialog(
				this.getParentComponent(),
				e.getMessage(),
				"OPPL Runtime error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void handleException(RuntimeException e) {
		JOptionPane.showMessageDialog(
				this.getParentComponent(),
				e.getMessage(),
				"OPPL Runtime error",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * @return the parentComponent
	 */
	public Component getParentComponent() {
		return this.parentComponent;
	}
}
