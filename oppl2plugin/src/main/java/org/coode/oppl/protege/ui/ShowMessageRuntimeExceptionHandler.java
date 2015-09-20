package org.coode.oppl.protege.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.awt.Component;
import java.util.regex.PatternSyntaxException;

import javax.swing.JOptionPane;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 */
public class ShowMessageRuntimeExceptionHandler implements RuntimeExceptionHandler {

    private final Component parentComponent;

    /**
     * @param parentComponent
     *        parentComponent
     */
    public ShowMessageRuntimeExceptionHandler(Component parentComponent) {
        this.parentComponent = checkNotNull(parentComponent, "parentComponent");
    }

    @Override
    public void handleOWLRuntimeException(OWLRuntimeException e) {
        JOptionPane.showMessageDialog(getParentComponent(), e.getMessage(),
            "OPPL Runtime error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
        JOptionPane.showMessageDialog(getParentComponent(), e.getMessage(),
            "OPPL Runtime error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void handleException(RuntimeException e) {
        JOptionPane.showMessageDialog(getParentComponent(), e.getMessage(),
            "OPPL Runtime error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @return the parentComponent
     */
    public Component getParentComponent() {
        return parentComponent;
    }
}
