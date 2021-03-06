package org.coode.oppl.protege.ui;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.coode.oppl.Variable;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public abstract class AbstractVariableEditor<O extends Variable<?>> extends JPanel
    implements VerifiedInputEditor {

    private static final long serialVersionUID = 20100L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<>();
    private O variable = null;
    protected ExpressionEditor<String> variableNameExpressionEditor;
    protected ButtonGroup variableTypeButtonGroup;

    /**
     * @param variable
     *        variable
     */
    public void setVariable(O variable) {
        this.variable = variable;
    }

    protected abstract boolean check();

    @Override
    public void addStatusChangedListener(
        final InputVerificationStatusChangedListener listener) {
        // listener.verifiedStatusChanged(check());
        this.listeners.add(listener);
    }

    @Override
    public void removeStatusChangedListener(
        final InputVerificationStatusChangedListener listener) {
        this.listeners.remove(listener);
    }

    protected void notifyListeners() {
        for (InputVerificationStatusChangedListener listener : this.listeners) {
            listener.verifiedStatusChanged(this.check());
        }
    }

    /**
     * @return variable
     */
    public Variable<?> getVariable() {
        return this.variable;
    }

    /**
     * @return editor name
     */
    public abstract String getEditorName();

    /** dispose */
    public abstract void dispose();

    protected void clear() {
        this.variableNameExpressionEditor.setText("");
        Enumeration<AbstractButton> elements = this.variableTypeButtonGroup.getElements();
        while (elements.hasMoreElements()) {
            elements.nextElement().setSelected(false);
        }
    }

    protected JRadioButton findSelectedButton() {
        JRadioButton button = null;
        Enumeration<AbstractButton> directions = this.variableTypeButtonGroup
            .getElements();
        boolean found = false;
        while (!found && directions.hasMoreElements()) {
            button = (JRadioButton) directions.nextElement();
            found = button.isSelected();
        }
        return found ? button : null;
    }
}
