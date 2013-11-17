package org.coode.oppl.protege.ui;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.owl.OWLEditorKit;

/** @author Luigi Iannone */
public class OPPLConstraintListItem implements MListItem {
    private final AbstractConstraint constraint;
    private final OWLEditorKit owlEditorKit;
    private final ConstraintSystem constraintSystem;

    /** @param owlEditorKit
     * @param constraint
     * @param constraintSystem */
    protected OPPLConstraintListItem(OWLEditorKit owlEditorKit,
            AbstractConstraint constraint, ConstraintSystem constraintSystem) {
        if (owlEditorKit == null) {
            throw new NullPointerException("The editor kit cannot be null");
        }
        if (constraint == null) {
            throw new NullPointerException("The constraint cannot be null");
        }
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        this.owlEditorKit = owlEditorKit;
        this.constraint = constraint;
        this.constraintSystem = constraintSystem;
    }

    @Override
    public String getTooltip() {
        return "";
    }

    @Override
    public boolean handleDelete() {
        return false;
    }

    @Override
    public void handleEdit() {}

    // public void handleEdit() {
    // final OPPLConstraintEditor editor = new OPPLConstraintEditor(
    // this.owlEditorKit, this.constraintSystem);
    // editor.setConstraint(this.getConstraint());
    // final VerifyingOptionPane optionPane = new
    // NoDefaultFocusVerifyingOptionPane(editor);
    // final InputVerificationStatusChangedListener verificationListener = new
    // InputVerificationStatusChangedListener() {
    // public void verifiedStatusChanged(boolean verified) {
    // optionPane.setOKEnabled(verified);
    // }
    // };
    // editor.addStatusChangedListener(verificationListener);
    // final JDialog dlg = optionPane.createDialog(this.owlEditorKit
    // .getWorkspace(), null);
    // // The editor shouldn't be modal (or should it?)
    // dlg.setModal(true);
    // dlg.setTitle("Constraint editor");
    // dlg.setResizable(true);
    // dlg.pack();
    // dlg.setLocationRelativeTo(this.owlEditorKit.getWorkspace());
    // dlg.addComponentListener(new ComponentAdapter() {
    // @Override
    // public void componentHidden(ComponentEvent e) {
    // Object retVal = optionPane.getValue();
    // if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
    // OPPLConstraintListItem.this.constraint = editor
    // .getConstraint();
    // }
    // editor.removeStatusChangedListener(verificationListener);
    // editor.dispose();
    // }
    // });
    // dlg.setVisible(true);
    // }
    @Override
    public boolean isDeleteable() {
        return true;
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    /** @return the constraint */
    public AbstractConstraint getConstraint() {
        return constraint;
    }

    @Override
    public String toString() {
        return constraint.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (constraint == null ? 0 : constraint.hashCode());
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
        OPPLConstraintListItem other = (OPPLConstraintListItem) obj;
        if (constraint == null) {
            if (other.constraint != null) {
                return false;
            }
        } else if (!constraint.equals(other.constraint)) {
            return false;
        }
        return true;
    }

    /** @return the owlEditorKit */
    protected OWLEditorKit getOwlEditorKit() {
        return owlEditorKit;
    }

    /** @return the constraintSystem */
    protected ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}
