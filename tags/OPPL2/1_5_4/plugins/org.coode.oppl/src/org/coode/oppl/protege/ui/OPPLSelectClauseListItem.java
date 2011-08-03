package org.coode.oppl.protege.ui;

import org.protege.editor.core.ui.list.MListItem;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLSelectClauseListItem implements MListItem {
	private final boolean asserted;
	private final OWLAxiom axiom;

	/**
	 * @param asserted
	 * @param axiom
	 */
	public OPPLSelectClauseListItem(boolean asserted, OWLAxiom axiom) {
		this.asserted = asserted;
		this.axiom = axiom;
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#getTooltip()
	 */
	public String getTooltip() {
		String isAsserted = this.isAsserted() ? "ASSERTED " : "";
		return isAsserted;
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#isDeleteable()
	 */
	public boolean isDeleteable() {
		return true;
	}

	/**
	 * @see org.protege.editor.core.ui.list.MListItem#isEditable()
	 */
	public boolean isEditable() {
		return true;
	}

	/**
	 * @return the asserted
	 */
	public boolean isAsserted() {
		return this.asserted;
	}

	/**
	 * @return the axiom
	 */
	public OWLAxiom getAxiom() {
		return this.axiom;
	}

	public boolean handleDelete() {
		return true;
	}

	public void handleEdit() {
	}
}