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
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.ui.ExpressionChecker;
import org.coode.parsers.ui.ExpressionEditor;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public class AxiomEditor extends JPanel implements VerifiedInputEditor {
    private static final long serialVersionUID = 20100L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private final ExpressionEditor<OWLAxiom> editor;
    private final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;
    private OWLAxiom axiom = null;
    private final ExpressionChecker<OWLAxiom> expressionChecker;

    protected AxiomEditor(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem) {
        this.owlEditorKit = owlEditorKit;
        this.constraintSystem = constraintSystem;
        expressionChecker = new OPPLExpressionChecker<OWLAxiom>(this.owlEditorKit) {
            @Override
            protected OWLAxiom parse(String text) {
                AbstractParserFactory factory = ProtegeParserFactory
                        .getInstance(getOWLEditorKit());
                OPPLParser parser = factory.build(getListener());
                OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
                        .createSymbolTable();
                symbolTable
                        .importConstraintSystem(AxiomEditor.this.getConstraintSystem());
                OWLAxiom toReturn = parser.parseAxiom(text, symbolTable);
                return toReturn;
            }
        };
        setLayout(new BorderLayout());
        editor = new ExpressionEditor<OWLAxiom>(this.owlEditorKit.getOWLModelManager()
                .getOWLOntologyManager(), expressionChecker);
        // Deactivating auto completions
        for (KeyListener l : editor.getKeyListeners()) {
            editor.removeKeyListener(l);
        }
        editor.addStatusChangedListener(new InputVerificationStatusChangedListener() {
            @Override
            public void verifiedStatusChanged(boolean newState) {
                AxiomEditor.this.check();
                AxiomEditor.this.notifyListeners(newState);
            }
        });
        JPanel editorPanel = new JPanel(new BorderLayout());
        editorPanel.setBorder(ComponentFactory.createTitledBorder("Axiom body:"));
        editor.setPreferredSize(new Dimension(50, 100));
        editorPanel.add(ComponentFactory.createScrollPane(editor));
        this.add(editorPanel, BorderLayout.CENTER);
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listener.verifiedStatusChanged(check());
        listeners.add(listener);
    }

    protected boolean check() {
        axiom = editor.createObject();
        return axiom != null;
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    protected void notifyListeners(boolean newStatus) {
        for (InputVerificationStatusChangedListener listener : listeners) {
            listener.verifiedStatusChanged(newStatus);
        }
    }

    /** @return axiom */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    protected void clear() {
        editor.setText("");
    }

    /** @param anOWLAxiom */
    public void setOWLAxiom(OWLAxiom anOWLAxiom) {
        VariableOWLCellRenderer renderer = new VariableOWLCellRenderer(owlEditorKit,
                constraintSystem, new OWLCellRenderer(owlEditorKit));
        editor.setText(renderer.getRendering(anOWLAxiom));
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}
