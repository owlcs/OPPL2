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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.parsers.oppl.ui.autocompletionmatcher.ProtegeOPPLAutoCompletionMatcher;
import org.coode.parsers.ui.AutoCompleter;
import org.coode.parsers.ui.ExpressionEditor;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;

/** Text based editor for OPPL scripts
 * 
 * @author Luigi Iannone */
public final class OPPLTextEditor extends JPanel implements VerifiedInputEditor,
        OWLModelManagerListener {
    private static final long serialVersionUID = 20100L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private final OWLEditorKit owlEditorKit;
    private OPPLScript opplScript = null;
    private final ExpressionEditor<OPPLScript> editor;
    protected final OPPLScriptValidator validator;
    private final OPPLExpressionChecker<OPPLScript> opplExpressionChecker;
    private final ProtegeOPPLAutoCompletionMatcher autoCompletionMatcher;
    private final OWLOntologyChangeListener ontologyChangeListener = new OWLOntologyChangeListener() {
        @Override
        public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
                throws OWLException {
            // Force refresh
            editor.setText(editor.getText());
        }
    };
    private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            // Force refresh
            editor.setText(editor.getText());
        }
    };

    /** @return the opplScript */
    public OPPLScript getOPPLScript() {
        return opplScript;
    }

    /** @param opplScript
     *            the opplScript to set */
    public void setOPPLScript(OPPLScript opplScript) {
        String rendering = opplScript.render();
        editor.setText(rendering);
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** Builds an instance of this OPPLTextBuilder.
     * 
     * @param owlEditorKit
     *            the editor kit for building the instance. Cannot be
     *            {@code null}. */
    protected OPPLTextEditor(OWLEditorKit owlEditorKit) {
        this(owlEditorKit, null);
    }

    /** Builds an instance of this OPPLTextBuilder.
     * 
     * @param owlEditorKit
     *            the editor kit for building the instance. Cannot be
     *            {@code null}.
     * @param validator
     *            performs custom validation checks on a syntactical valid
     *            OPPLScript.
     * @throws NullPointerException
     *             when the input is {@code null}. */
    protected OPPLTextEditor(OWLEditorKit owlEditorKit, OPPLScriptValidator validator) {
        this.owlEditorKit = owlEditorKit;
        this.validator = validator;
        opplExpressionChecker = new OPPLExpressionChecker<OPPLScript>(getOWLEditorKit()) {
            @Override
            protected OPPLScript parse(String text) {
                AbstractParserFactory factory = ProtegeParserFactory
                        .getInstance(getOWLEditorKit());
                OPPLParser parser = factory.build(getListener());
                OPPLScript toReturn = parser.parse(text);
                return toReturn;
            }
        };
        editor = new ExpressionEditor<OPPLScript>(getOWLEditorKit().getOWLModelManager()
                .getOWLOntologyManager(), opplExpressionChecker);
        editor.addStatusChangedListener(new InputVerificationStatusChangedListener() {
            @Override
            public void verifiedStatusChanged(boolean newState) {
                OPPLTextEditor.this.handleChange();
            }
        });
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .addOntologyChangeListener(ontologyChangeListener);
        autoCompletionMatcher = new ProtegeOPPLAutoCompletionMatcher(getOWLEditorKit());
        getOWLEditorKit().getModelManager().addListener(this);
        new AutoCompleter(editor, autoCompletionMatcher);
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        this.add(ComponentFactory.createScrollPane(editor));
    }

    protected void handleChange() {
        boolean b = check();
        notifyListeners(b);
    }

    private boolean check() {
        opplScript = editor.createObject();
        return opplScript != null;
    }

    private void notifyListeners(boolean b) {
        for (InputVerificationStatusChangedListener l : listeners) {
            l.verifiedStatusChanged(b);
        }
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        ArgCheck.checkNullArgument("The listener", listener);
        listeners.add(listener);
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    protected void clear() {
        editor.setText("");
    }

    @Override
    public String getName() {
        return "OPPL Text Editor";
    }

    @Override
    public void handleChange(OWLModelManagerChangeEvent event) {
        EventType type = event.getType();
        if (type.equals(EventType.REASONER_CHANGED)) {
            this.handleChange();
        }
    }

    public void dispose() {
        getOWLEditorKit().getModelManager().removeListener(this);
        autoCompletionMatcher.dispose();
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .removeOntologyChangeListener(ontologyChangeListener);
    }
}
