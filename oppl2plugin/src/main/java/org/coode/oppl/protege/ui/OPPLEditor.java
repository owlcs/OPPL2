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

import java.awt.Component;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;

/**
 * Tabbed pane containing two editors for OPPL, namely the text based
 * OPPLTextEditor and OPPLBuilder.
 * 
 * @author Luigi Iannone
 */
public final class OPPLEditor extends JTabbedPane implements VerifiedInputEditor,
    ChangeListener {

    private static final long serialVersionUID = 20100L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<>();
    private final OWLEditorKit owlEditorKit;
    protected final OPPLBuilder opplBuilder;
    protected final OPPLTextEditor opplTextEditor;
    protected OPPLScript opplScript;
    private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {

        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            OPPLEditor.this.setSelectedComponent(opplTextEditor);
        }
    };
    private final OWLOntologyChangeListener ontologyChangeListener = new OWLOntologyChangeListener() {

        @Override
        public void ontologiesChanged(List<? extends OWLOntologyChange> changes) {
            OPPLEditor.this.setSelectedComponent(opplTextEditor);
        }
    };

    /**
     * @return the opplScript
     */
    public OPPLScript getOPPLScript() {
        return opplScript;
    }

    /**
     * @param opplScript
     *        the opplScript to set
     */
    public void setOPPLScript(OPPLScript opplScript) {
        opplTextEditor.setOPPLScript(opplScript);
        setSelectedComponent(opplTextEditor);
        fireStateChanged();
    }

    /**
     * @return the owlEditorKit
     */
    public final OWLEditorKit getOwlEditorKit() {
        return owlEditorKit;
    }

    /**
     * @param owlEditor
     *        owlEditor
     * @param builder
     *        builder
     * @param textEditor
     *        textEditor
     */
    public OPPLEditor(OWLEditorKit owlEditor, OPPLBuilder builder,
        OPPLTextEditor textEditor) {
        owlEditorKit = owlEditor;
        opplBuilder = builder;
        opplTextEditor = textEditor;
        opplBuilder
            .addStatusChangedListener(new org.coode.parsers.ui.InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean newState) {
                    opplScript = null;
                    if (newState) {
                        opplScript = opplBuilder.getOPPLScript();
                    }
                    OPPLEditor.this.handleChange();
                }
            });
        opplTextEditor
            .addStatusChangedListener(new org.coode.parsers.ui.InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean newState) {
                    opplScript = null;
                    if (newState) {
                        opplScript = opplTextEditor.getOPPLScript();
                    }
                    OPPLEditor.this.handleChange();
                }
            });
        getOwlEditorKit().getOWLModelManager().addListener(modelManagerListener);
        getOwlEditorKit().getOWLModelManager().getOWLOntologyManager()
            .addOntologyChangeListener(ontologyChangeListener);
        addChangeListener(this);
        initGUI();
    }

    /**
     * @param owlEditor
     *        owlEditor
     */
    public OPPLEditor(OWLEditorKit owlEditor) {
        this(owlEditor, new OPPLBuilder(owlEditor), new OPPLTextEditor(owlEditor));
    }

    /**
     * @param owlEditor
     *        owlEditor
     * @param validator
     *        validator
     */
    public OPPLEditor(OWLEditorKit owlEditor, OPPLScriptValidator validator) {
        this(owlEditor, new OPPLBuilder(owlEditor, validator), new OPPLTextEditor(
            owlEditor, validator));
    }

    private void initGUI() {
        this.add(opplBuilder);
        this.add(opplTextEditor);
    }

    protected void handleChange() {
        boolean newStatus = check();
        notifyListeners(newStatus);
    }

    /**
     * @return true if oppl script is not null
     */
    private boolean check() {
        return getOPPLScript() != null;
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(checkNotNull(listener, "listener"));
    }

    @Override
    public void removeStatusChangedListener(
        InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(boolean newStatus) {
        for (InputVerificationStatusChangedListener l : listeners) {
            l.verifiedStatusChanged(newStatus);
        }
    }

    /** Clears both internal editors. */
    public void clear() {
        opplBuilder.clear();
        opplTextEditor.clear();
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent1) {
        Component selectedComponent = getSelectedComponent();
        if (selectedComponent.equals(opplBuilder) && opplScript != null) {
            opplBuilder.setOPPLScript(opplScript);
        } else if (selectedComponent.equals(opplTextEditor) && opplScript != null) {
            opplTextEditor.setOPPLScript(opplScript);
        }
    }

    /** dispose */
    public void dispose() {
        opplBuilder.dispose();
        opplTextEditor.dispose();
        getOwlEditorKit().getOWLModelManager().removeListener(modelManagerListener);
        getOwlEditorKit().getOWLModelManager().getOWLOntologyManager()
            .removeOntologyChangeListener(ontologyChangeListener);
    }
}
