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
package org.coode.patterns.protege.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.coode.oppl.utils.ArgCheck;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternModel;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.editor.AbstractOWLObjectEditor;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;

/** @author Luigi Iannone Apr 2, 2009 */
public class PatternEditor extends AbstractOWLObjectEditor<PatternModel> implements
        org.protege.editor.core.ui.util.VerifiedInputEditor, ChangeListener {
    protected final JTabbedPane mainPanel = new JTabbedPane();
    private final Set<org.protege.editor.core.ui.util.InputVerificationStatusChangedListener> listeners = new HashSet<org.protege.editor.core.ui.util.InputVerificationStatusChangedListener>();
    protected final PatternBuilder patternBuilder;
    protected final TypeInPatternBuilder patternTextEditor;
    protected PatternModel patternModel = null;
    private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            mainPanel.setSelectedComponent(patternBuilder.getEditorComponent());
        }
    };
    private final OWLOntologyChangeListener ontologyChangeListener = new OWLOntologyChangeListener() {
        @Override
        public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
                throws OWLException {
            mainPanel.setSelectedComponent(patternBuilder.getEditorComponent());
        }
    };
    private final OWLEditorKit owlEditorKit;

    /** @param owlEditorKit
     * @param f */
    public PatternEditor(OWLEditorKit owlEditorKit, AbstractPatternModelFactory f) {
        if (owlEditorKit == null) {
            throw new NullPointerException("The OWL editor kit cannot be null");
        }
        if (f == null) {
            throw new NullPointerException("The Pattern factory cannot be null");
        }
        this.owlEditorKit = owlEditorKit;
        patternBuilder = new PatternBuilder(getOWLEditorKit(), f);
        patternTextEditor = new TypeInPatternBuilder(getOWLEditorKit());
        patternBuilder
                .addStatusChangedListener(new InputVerificationStatusChangedListener() {
                    @Override
                    public void verifiedStatusChanged(boolean newState) {
                        patternModel = null;
                        if (newState) {
                            patternModel = patternBuilder.getEditedObject();
                        }
                        PatternEditor.this.handleChange();
                    }
                });
        patternTextEditor
                .addStatusChangedListener(new InputVerificationStatusChangedListener() {
                    @Override
                    public void verifiedStatusChanged(boolean newState) {
                        patternModel = null;
                        if (newState) {
                            patternModel = patternTextEditor.getEditedObject();
                        }
                        PatternEditor.this.handleChange();
                    }
                });
        mainPanel.addChangeListener(this);
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .addOntologyChangeListener(ontologyChangeListener);
        initGUI();
        handleChange();
    }

    protected void handleChange() {
        boolean newState = patternModel != null;
        notifyListeners(newState);
    }

    private void notifyListeners(boolean newState) {
        for (org.protege.editor.core.ui.util.InputVerificationStatusChangedListener l : listeners) {
            l.verifiedStatusChanged(newState);
        }
    }

    
    private void initGUI() {
        mainPanel.add(patternBuilder.getEditorComponent());
        mainPanel.add(patternTextEditor.getEditorComponent());
        mainPanel.setPreferredSize(new Dimension(600, 700));
    }

    @Override
    public
            void
            addStatusChangedListener(
                    org.protege.editor.core.ui.util.InputVerificationStatusChangedListener listener) {
        ArgCheck.checkNullArgument("The listener", listener);
        listener.verifiedStatusChanged(patternModel != null);
        listeners.add(listener);
    }

    @Override
    public
            void
            removeStatusChangedListener(
                    org.protege.editor.core.ui.util.InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void dispose() {
        listeners.clear();
        patternBuilder.dispose();
        patternTextEditor.dispose();
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .removeOntologyChangeListener(ontologyChangeListener);
    }

    @Override
    public PatternModel getEditedObject() {
        return patternModel;
    }

    @Override
    public JComponent getEditorComponent() {
        return mainPanel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Component selectedComponent = mainPanel.getSelectedComponent();
        if (patternModel != null) {
            if (selectedComponent.equals(patternBuilder.getEditorComponent())) {
                patternBuilder.setPatternModel(patternModel);
            }
            if (selectedComponent.equals(patternTextEditor.getEditorComponent())) {
                patternTextEditor.setPatternModel(patternModel);
            }
        }
    }

    /** @param patternModel */
    public void setPatternModel(PatternModel patternModel) {
        patternTextEditor.setPatternModel(patternModel);
        patternBuilder.setPatternModel(patternModel);
    }

    @Override
    public boolean canEdit(Object object) {
        return true;
    }

    @Override
    public String getEditorTypeName() {
        return "Pattern model editor";
    }

    @Override
    public boolean setEditedObject(PatternModel editedObject) {
        setPatternModel(editedObject);
        return true;
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }
}
