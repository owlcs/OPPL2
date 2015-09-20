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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.coode.oppl.ConstraintSystem;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 */
public class OPPLSelectClauseEditor extends JPanel implements VerifiedInputEditor {

    private static final long serialVersionUID = 20100L;
    private final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<>();
    private final AxiomEditor axiomEditor;
    private final JCheckBox assertedCheckBox = new JCheckBox("ASSERTED");
    private OPPLSelectClauseListItem selectListItem;

    /**
     * @return the selectListItem
     */
    public OPPLSelectClauseListItem getSelectListItem() {
        return selectListItem;
    }

    /**
     * @param selectListItem
     *        the selectListItem to set
     */
    public void setSelectListItem(OPPLSelectClauseListItem selectListItem) {
        assertedCheckBox.setSelected(selectListItem.isAsserted());
        axiomEditor.setOWLAxiom(selectListItem.getAxiom());
    }

    /**
     * @param owlEditorKit
     *        owlEditorKit
     * @param constraintSystem
     *        constraintSystem
     */
    public OPPLSelectClauseEditor(OWLEditorKit owlEditorKit,
        ConstraintSystem constraintSystem) {
        setLayout(new BorderLayout());
        this.owlEditorKit = owlEditorKit;
        this.constraintSystem = constraintSystem;
        // Setting up the axiom editor
        axiomEditor = new AxiomEditor(this.owlEditorKit, this.constraintSystem);
        JPanel axiomEditorPanel = new JPanel(new BorderLayout());
        axiomEditorPanel.add(ComponentFactory.createScrollPane(axiomEditor));
        axiomEditor
            .addStatusChangedListener(new InputVerificationStatusChangedListener() {

                @Override
                public void verifiedStatusChanged(boolean newState) {
                    OPPLSelectClauseEditor.this.handleChange();
                }
            });
        this.add(axiomEditorPanel, BorderLayout.CENTER);
        // Setting up the Asserted flag
        assertedCheckBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OPPLSelectClauseEditor.this.handleChange();
            }
        });
        this.add(assertedCheckBox, BorderLayout.EAST);
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        listener.verifiedStatusChanged(check());
    }

    private boolean check() {
        return axiomEditor.getAxiom() != null;
    }

    @Override
    public void removeStatusChangedListener(
        InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    /** hndle change */
    public void handleChange() {
        boolean isValid = check();
        if (isValid) {
            selectListItem = new OPPLSelectClauseListItem(assertedCheckBox.getModel()
                .isSelected(), axiomEditor.getAxiom());
        }
        notifyListeners(isValid);
    }

    /**
     * @param isValid
     *        isValid
     */
    private void notifyListeners(boolean isValid) {
        for (InputVerificationStatusChangedListener listener : listeners) {
            listener.verifiedStatusChanged(isValid);
        }
    }

    /** dispose */
    public void dispose() {}
}
