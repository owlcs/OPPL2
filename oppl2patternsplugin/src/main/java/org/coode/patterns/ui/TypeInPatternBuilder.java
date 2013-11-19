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
package org.coode.patterns.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.coode.oppl.protege.ui.OPPLExpressionChecker;
import org.coode.parsers.oppl.patterns.ui.autocompletionmatcher.ProtegeOPPLPatternsAutoCompletionMatcher;
import org.coode.parsers.ui.AutoCompleter;
import org.coode.parsers.ui.ExpressionChecker;
import org.coode.parsers.ui.ExpressionEditor;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.coode.patterns.HasPatternModel;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternModelChangeListener;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.classexpression.OWLExpressionParserException;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone Jun 10, 2008 */
public class TypeInPatternBuilder implements VerifiedInputEditor,
        InputVerificationStatusChangedListener, PatternModelChangeListener,
        HasPatternModel {
    private static final long serialVersionUID = -4071865934355642992L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private final OWLEditorKit owlEditorKit;
    protected PatternModel patternModel = null;
    private final JPanel mainPanel = new JPanel();
    protected ExpressionEditor<PatternModel> patternModelEditor;
    protected IRI iri;
    protected org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor<String> patternNameTextField;
    private final ProtegeOPPLPatternsAutoCompletionMatcher autoCompletionMatcher;
    private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            patternModelEditor.setText(patternModelEditor.getText());
        }
    };
    private final OWLOntologyChangeListener ontologyChangeListener = new OWLOntologyChangeListener() {
        @Override
        public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
                throws OWLException {
            patternModelEditor.setText(patternModelEditor.getText());
        }
    };

    /** @param owlEditorKit */
    public TypeInPatternBuilder(OWLEditorKit owlEditorKit) {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setName("Pattern Text Editor");
        this.owlEditorKit = owlEditorKit;
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .addOntologyChangeListener(ontologyChangeListener);
        patternNameTextField = new org.protege.editor.owl.ui.clsdescriptioneditor.ExpressionEditor<String>(
                owlEditorKit, new OWLExpressionChecker<String>() {
                    private String lastName;

                    @Override
                    public void check(String text) throws OWLExpressionParserException {
                        if (text.matches("\\w+")) {
                            lastName = text;
                        } else {
                            throw new OWLExpressionParserException(new Exception(
                                    "Invalid pattern name " + text));
                        }
                    }

                    @Override
                    public String createObject(String text)
                            throws OWLExpressionParserException {
                        this.check(text);
                        return lastName;
                    }
                });
        JPanel patternNamePanel = new JPanel(new BorderLayout());
        patternNamePanel.add(patternNameTextField);
        patternNameTextField
                .addStatusChangedListener(new org.protege.editor.core.ui.util.InputVerificationStatusChangedListener() {
                    private void updateIRI() {
                        iri = null;
                        String localName = patternNameTextField.getText();
                        if (localName.length() != 0) {
                            try {
                                iri = IRI.create(PatternModel.NAMESPACE + localName);
                            } catch (Exception e) {} finally {
                                TypeInPatternBuilder.this.handleChange();
                            }
                        }
                    }

                    @Override
                    public void verifiedStatusChanged(boolean newState) {
                        updateIRI();
                    }
                });
        patternNamePanel.setBorder(ComponentFactory.createTitledBorder("Pattern name"));
        mainPanel.add(patternNamePanel, BorderLayout.NORTH);
        ExpressionChecker<PatternModel> expressionChecker = new OPPLExpressionChecker<PatternModel>(
                getOWLEditorKit()) {
            @Override
            protected PatternModel parse(String text) {
                OPPLPatternParser parser = ProtegeParserFactory.getInstance(
                        getOWLEditorKit()).build(getListener());
                return parser.parse(text);
            }
        };
        patternModelEditor = new ExpressionEditor<PatternModel>(getOWLEditorKit()
                .getOWLModelManager().getOWLOntologyManager(), expressionChecker);
        autoCompletionMatcher = new ProtegeOPPLPatternsAutoCompletionMatcher(
                getOWLEditorKit());
        new AutoCompleter(patternModelEditor, autoCompletionMatcher);
        removeKeyListeners();
        patternModelEditor.setPreferredSize(new Dimension(50, 200));
        JScrollPane opplStatementEditorPane = ComponentFactory
                .createScrollPane(patternModelEditor);
        JPanel opplStatementEditorPanel = new JPanel(new BorderLayout());
        opplStatementEditorPanel.setBorder(ComponentFactory
                .createTitledBorder("Pattern statement"));
        patternModelEditor.addStatusChangedListener(this);
        opplStatementEditorPanel.add(opplStatementEditorPane);
        mainPanel.add(opplStatementEditorPanel, BorderLayout.CENTER);
        if (patternModel != null) {
            patternModel.addChangeListener(this);
        }
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        notifyListener(check(), listener);
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    @Override
    public PatternModel getPatternModel() {
        return patternModel;
    }

    @Override
    public void verifiedStatusChanged(boolean newState) {
        patternModel = null;
        if (newState) {
            patternModel = patternModelEditor.createObject();
        }
        handleChange();
    }

    @Override
    public void handleChange() {
        if (patternModel != null) {
            patternModel.setIRI(iri);
        }
        boolean newState = check();
        for (InputVerificationStatusChangedListener listener : listeners) {
            notifyListener(newState, listener);
        }
    }

    /** @param listener */
    private void notifyListener(boolean newState,
            InputVerificationStatusChangedListener listener) {
        listener.verifiedStatusChanged(newState);
    }

    /** @return */
    private boolean check() {
        return patternModel != null && patternModel.isValid()
                && patternModel.getIRI() != null;
    }

    /** clear editors */
    public void clear() {
        patternModelEditor.setText("");
        patternNameTextField.setText("");
    }

    /** dispose editors */
    public void dispose() {
        if (patternModel != null) {
            patternModel.removeChangeListener(this);
        }
        patternModelEditor.removeStatusChangedListener(this);
        autoCompletionMatcher.dispose();
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .removeOntologyChangeListener(ontologyChangeListener);
    }

    /** @return the edited object */
    public PatternModel getEditedObject() {
        return patternModel;
    }

    /** @return editor component */
    public JComponent getEditorComponent() {
        return mainPanel;
    }

    /** @param patternModel
     *            the patternModel to set */
    public void setPatternModel(PatternModel patternModel) {
        patternModelEditor.setText(patternModel == null ? "" : patternModel
                .render(new ShortFormProvider() {
                    @Override
                    public String getShortForm(OWLEntity entity) {
                        return TypeInPatternBuilder.this.getOWLEditorKit()
                                .getOWLModelManager().getRendering(entity);
                    }

                    @Override
                    public void dispose() {}
                }));
        patternNameTextField.setText(patternModel == null ? "" : patternModel
                .getPatternLocalName());
    }

    
    private void removeKeyListeners() {
        KeyListener[] keyListeners = patternNameTextField.getKeyListeners();
        for (KeyListener keyListener : keyListeners) {
            patternNameTextField.removeKeyListener(keyListener);
        }
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }
}
