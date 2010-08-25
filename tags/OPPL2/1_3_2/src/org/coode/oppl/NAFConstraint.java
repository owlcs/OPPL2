/**
 * 
 */
package org.coode.oppl;

import java.util.Formatter;

import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owl.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class NAFConstraint implements AbstractConstraint {
	private final OWLAxiom axiom;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param axiom
	 */
	public NAFConstraint(OWLAxiom axiom, ConstraintSystem constraintSystem) {
		if (axiom == null) {
			throw new NullPointerException("The OWLAxiom xannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The Constraint system cannot be null");
		}
		this.axiom = axiom;
		this.constraintSystem = constraintSystem;
	}

	/**
	 * @see org.coode.oppl.AbstractConstraint#accept(org.coode.oppl.ConstraintVisitorEx
	 *      )
	 */
	public <O> O accept(ConstraintVisitorEx<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @see org.coode.oppl.AbstractConstraint#accept(org.coode.oppl.ConstraintVisitor
	 *      )
	 */
	public void accept(ConstraintVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * @see org.coode.oppl.AbstractConstraint#render()
	 */
	public String render() {
		Formatter formatter = new Formatter();
		ManchesterSyntaxRenderer manchesterSyntaxRenderer = this
				.getConstraintSystem().getOPPLFactory()
				.getManchesterSyntaxRenderer(this.getConstraintSystem());
		this.getAxiom().accept(manchesterSyntaxRenderer);
		formatter.format("FAIL %s", manchesterSyntaxRenderer.toString());
		return formatter.out().toString();
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("FAIL %s", this.axiom.toString());
		return formatter.out().toString();
	}

	/**
	 * @return the axiom
	 */
	public OWLAxiom getAxiom() {
		return this.axiom;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
