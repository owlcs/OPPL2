package org.coode.oppl.protege.ui;

import org.protege.editor.core.ui.list.MListItem;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * @author Luigi Iannone
 */
public class OPPLSelectClauseListItem implements MListItem {

    private final boolean asserted;
    private final OWLAxiom axiom;

    /**
     * @param asserted
     *        asserted
     * @param axiom
     *        axiom
     */
    public OPPLSelectClauseListItem(boolean asserted, OWLAxiom axiom) {
        this.asserted = asserted;
        this.axiom = axiom;
    }

    @Override
    public String getTooltip() {
        String isAsserted = isAsserted() ? "ASSERTED " : "";
        return isAsserted;
    }

    @Override
    public boolean isDeleteable() {
        return true;
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    /**
     * @return the asserted
     */
    public boolean isAsserted() {
        return asserted;
    }

    /**
     * @return the axiom
     */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    @Override
    public boolean handleDelete() {
        return true;
    }

    @Override
    public void handleEdit() {}
}
