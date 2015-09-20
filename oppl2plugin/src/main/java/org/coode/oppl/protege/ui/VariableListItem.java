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
package org.coode.oppl.protege.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class VariableListItem implements MListItem, OPPLMacroStatusChange {

    protected Variable<?> variable;
    private final OWLEditorKit owlEditorKit;
    private final RuntimeExceptionHandler runtimeExceptionHandler;
    private final List<OPPLMacroListener> listeners = new ArrayList<>();
    private final boolean isEditable;
    private final boolean isDeleteable;
    private final ConstraintSystem constraintSystem;

    /**
     * @param variable
     *        variable
     * @param constraintSystem
     *        constraintSystem
     * @param owlEditorKit
     *        owlEditorKit
     * @param isEditable
     *        isEditable
     * @param isDeleatable
     *        isDeleatable
     */
    public VariableListItem(Variable<?> variable, ConstraintSystem constraintSystem,
        OWLEditorKit owlEditorKit, boolean isEditable, boolean isDeleatable) {
        this.variable = checkNotNull(variable, "variable");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        this.isEditable = isEditable;
        isDeleteable = isDeleatable;
        runtimeExceptionHandler = new ShowMessageRuntimeExceptionHandler(
            getOwlEditorKit().getOWLWorkspace());
    }

    @Override
    public String getTooltip() {
        StringBuilder toReturnBuilder = new StringBuilder(variable.getName());
        boolean first = true;
        toReturnBuilder.append(" = ");
        for (OWLObject value : getConstraintSystem().getVariableBindings(variable,
            getRuntimeExceptionHandler())) {
            String rendering = first ? owlEditorKit.getModelManager().getRendering(value)
                : ", " + owlEditorKit.getModelManager().getRendering(value);
            toReturnBuilder.append(rendering);
        }
        return toReturnBuilder.toString();
    }

    @Override
    public boolean handleDelete() {
        notifyListeners(getVariable());
        for (OPPLMacroListener l : new ArrayList<>(getListeners())) {
            removeOPPLMacroListener(l);
        }
        return true;
    }

    @Override
    public void handleEdit() {
        VariableScopeChecker checker;
        try {
            checker = getConstraintSystem().getOPPLFactory().getVariableScopeChecker();
            final ScopeEditor scopeEditor = ScopeEditor.getTypeScopeEditor(
                variable.getType(), checker, owlEditorKit);
            final VerifyingOptionPane optionPane = new VerifyingOptionPane(scopeEditor) {

                private static final long serialVersionUID = 20100L;

                @Override
                public void selectInitialValue() {
                    // This is overridden so that the option pane dialog default
                    // button
                    // doesn't get the focus.
                }
            };
            if (owlEditorKit.getModelManager().getReasoner() instanceof NoOpReasoner) {
                JOptionPane
                    .showMessageDialog(
                        owlEditorKit.getWorkspace(),
                        "You are not using any reasoner, in order to scope variables, please activate reasoning.",
                        "No Reasoner", JOptionPane.ERROR_MESSAGE);
            } else {
                final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {

                    @Override
                    public void verifiedStatusChanged(boolean verified) {
                        optionPane.setOKEnabled(verified);
                    }
                };
                scopeEditor.addStatusChangedListener(verificationListener);
                final JDialog dlg = optionPane.createDialog(owlEditorKit.getWorkspace(),
                    null);
                // The editor shouldn't be modal (or should it?)
                dlg.setModal(false);
                dlg.setTitle(scopeEditor.getTitle());
                dlg.setResizable(true);
                dlg.pack();
                dlg.setLocationRelativeTo(owlEditorKit.getWorkspace());
                dlg.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentHidden(ComponentEvent e) {
                        Object retVal = optionPane.getValue();
                        if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
                            VariableScope<?> variableScope = scopeEditor
                                .getVariableScope();
                            try {
                                variable = VariableListItem.this.getConstraintSystem()
                                    .createVariable(
                                        VariableListItem.this.getVariable()
                                            .getName(),
                                        VariableListItem.this.getVariable()
                                            .getType(), variableScope);
                            } catch (OPPLException e1) {
                                throw new RuntimeException(e1);
                            }
                        }
                        scopeEditor.removeStatusChangedListener(verificationListener);
                    }
                });
                dlg.setVisible(true);
            }
        } catch (OPPLException e2) {
            JOptionPane.showMessageDialog(owlEditorKit.getWorkspace(),
                "Choose a reasoner first");
        }
    }

    @Override
    public boolean isDeleteable() {
        return isDeleteable;
    }

    @Override
    public boolean isEditable() {
        return isEditable
            && variable.getType() != VariableTypeFactory.getCONSTANTVariableType();
    }

    /**
     * @return the variable
     */
    public Variable<?> getVariable() {
        return variable;
    }

    @Override
    public void addOPPLMacroListener(OPPLMacroListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeOPPLMacroListener(OPPLMacroListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(Variable<?> variable1) {
        for (OPPLMacroListener listener : listeners) {
            listener.handleDeletedVariable(variable1);
        }
    }

    /**
     * @return the listeners
     */
    private Collection<OPPLMacroListener> getListeners() {
        return listeners;
    }

    /**
     * @return the owlEditorKit
     */
    protected final OWLEditorKit getOwlEditorKit() {
        return owlEditorKit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isDeleteable ? 1231 : 1237);
        result = prime * result + (isEditable ? 1231 : 1237);
        result = prime * result + (variable == null ? 0 : variable.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        VariableListItem other = (VariableListItem) obj;
        if (isDeleteable != other.isDeleteable) {
            return false;
        }
        if (isEditable != other.isEditable) {
            return false;
        }
        if (variable == null) {
            if (other.variable != null) {
                return false;
            }
        } else if (!variable.equals(other.variable)) {
            return false;
        }
        return true;
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
