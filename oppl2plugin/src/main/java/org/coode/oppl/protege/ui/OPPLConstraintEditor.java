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

import javax.swing.JPanel;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.ui.ExpressionEditor;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;

/** @author Luigi Iannone */
public class OPPLConstraintEditor extends JPanel implements VerifiedInputEditor {
    /**
	 *
	 */
    private static final long serialVersionUID = 3477960268272607549L;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private final ExpressionEditor<AbstractConstraint> constraintEditor;
    private AbstractConstraint constraint;
    private final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;
    private final OPPLExpressionChecker<AbstractConstraint> constraintExpressionChecker;

    /** @return the constraint */
    public AbstractConstraint getConstraint() {
        return constraint;
    }

    /** @param constraint
     *            the constraint to set */
    public void setConstraint(AbstractConstraint constraint) {
        constraintEditor.setText(constraint.toString());
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        listener.verifiedStatusChanged(check());
    }

    private boolean check() {
        boolean toReturn = false;
        constraint = constraintEditor.createObject();
        toReturn = constraint != null;
        return toReturn;
    }

    /** @param isValid */
    private void notifyListeners(boolean isValid) {
        for (InputVerificationStatusChangedListener listener : listeners) {
            listener.verifiedStatusChanged(isValid);
        }
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    public void handleChange() {
        boolean isValid = check();
        notifyListeners(isValid);
    }

    public OPPLConstraintEditor(OWLEditorKit owlEditorKit,
            ConstraintSystem constraintSystem) {
        setLayout(new BorderLayout());
        this.owlEditorKit = owlEditorKit;
        this.constraintSystem = constraintSystem;
        constraintExpressionChecker = new OPPLExpressionChecker<AbstractConstraint>(
                getOWLEditorKit()) {
            @Override
            protected AbstractConstraint parse(String text) {
                AbstractParserFactory factory = ProtegeParserFactory
                        .getInstance(getOWLEditorKit());
                OPPLParser parser = factory.build(getListener());
                OPPLSymbolTable symbolTable = parser.getSymbolTableFactory()
                        .createSymbolTable();
                symbolTable.importConstraintSystem(OPPLConstraintEditor.this
                        .getConstraintSystem());
                AbstractConstraint toReturn = parser.parseConstraint(text, symbolTable,
                        OPPLConstraintEditor.this.getConstraintSystem());
                return toReturn;
            }
        };
        // Setup the constraint editor
        constraintEditor = new ExpressionEditor<AbstractConstraint>(getOWLEditorKit()
                .getOWLModelManager().getOWLOntologyManager(),
                constraintExpressionChecker);
        JPanel constraintEditorPanel = new JPanel(new BorderLayout());
        constraintEditorPanel.add(ComponentFactory.createScrollPane(constraintEditor));
        // remove listeners
        KeyListener[] keyListeners = constraintEditor.getKeyListeners();
        for (KeyListener keyListener : keyListeners) {
            constraintEditor.removeKeyListener(keyListener);
        }
        constraintEditor
                .addStatusChangedListener(new InputVerificationStatusChangedListener() {
                    @Override
                    public void verifiedStatusChanged(boolean newState) {
                        OPPLConstraintEditor.this.handleChange();
                    }
                });
        this.add(constraintEditorPanel, BorderLayout.CENTER);
    }

    public void dispose() {}

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}
