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

import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.coode.oppl.InstantiatedOPPLScript;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.classexpression.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor;
import org.semanticweb.owlapi.model.OWLException;

/** GUI component that allows to instantiate a generic OPPL Script
 * 
 * @author Luigi Iannone
 * @param <P>
 *            type */
public abstract class OPPLScriptInstantiationEditor<P extends InstantiatedOPPLScript>
        implements VerifiedInputEditor, InputVerificationStatusChangedListener {
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    protected ExpressionEditor<P> editor;
    protected OWLEditorKit owlEditorKit;
    protected JPanel mainPane = new JPanel(new BorderLayout());
    protected P instantiatedScript = null;

    /** @param instantiatedOPPLScript
     *            instantiatedOPPLScript
     * @param owlEditorKit
     *            owlEditorKit */
    public OPPLScriptInstantiationEditor(P instantiatedOPPLScript,
            OWLEditorKit owlEditorKit) {
        this.instantiatedScript = instantiatedOPPLScript;
        this.owlEditorKit = owlEditorKit;
        this.init();
    }

    protected void init() {
        this.editor = this.getScriptExpressionEditor();
        // will go away when the completer will be removed from the expression
        // editor
        this.removeKeyListeners();
        this.setupAutoCompleter();
    }

    protected abstract void setupAutoCompleter();

    protected abstract ExpressionEditor<P> getScriptExpressionEditor();

    private void removeKeyListeners() {
        KeyListener[] keyListeners = this.editor.getKeyListeners();
        for (KeyListener keyListener : keyListeners) {
            this.editor.removeKeyListener(keyListener);
        }
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        this.listeners.add(listener);
        this.notifyListener(listener);
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        this.listeners.remove(listener);
    }

    /** @param listener
     *            listener */
    private void notifyListener(InputVerificationStatusChangedListener listener) {
        boolean valid = this.instantiatedScript != null ? this.instantiatedScript
                .isValid() : false;
        listener.verifiedStatusChanged(valid);
    }

    @Override
    public void verifiedStatusChanged(boolean newState) {
        this.instantiatedScript = null;
        if (newState) {
            try {
                this.instantiatedScript = this.editor.createObject();
                this.handleChange();
            } catch (OWLExpressionParserException e) {
                e.printStackTrace();
            } catch (OWLException e) {
                e.printStackTrace();
            }
        }
        this.handleChange();
    }

    /**
     * 
     */
    public void handleChange() {
        for (InputVerificationStatusChangedListener listener : this.listeners) {
            this.notifyListener(listener);
        }
    }

    /**
     * 
     */
    public void clear() {
        this.mainPane.removeAll();
        this.init();
    }

    /**
     * 
     */
    public void dispose() {
        this.editor.removeStatusChangedListener(this);
    }

    /** @return edited oppl script */
    public InstantiatedOPPLScript getEditedObject() {
        return this.instantiatedScript;
    }

    /** @return editor */
    public JComponent getEditorComponent() {
        return this.mainPane;
    }
}
