/**
 * 
 */
package org.coode.oppl.search;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owl.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLOWLAxiomSearchNode {
	private final BindingNode binding;
	private final OWLAxiom axiom;

	/**
	 * @param axiom
	 */
	public OPPLOWLAxiomSearchNode(OWLAxiom axiom, BindingNode bindingNode) {
		if (axiom == null) {
			throw new NullPointerException("The axiom cannot be null");
		}
		if (bindingNode == null) {
			throw new NullPointerException("The binding node cannot be null");
		}
		this.binding = bindingNode;
		this.axiom = axiom;
	}

	/**
	 * @return the axiom
	 */
	public OWLAxiom getAxiom() {
		return this.axiom;
	}

	@Override
	public String toString() {
		return this.axiom + " " + this.binding;
	}

	/**
	 * @return the binding
	 */
	public BindingNode getBinding() {
		return this.binding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.axiom == null ? 0 : this.axiom.hashCode());
		result = prime * result
				+ (this.binding == null ? 0 : this.binding.hashCode());
		return result;
	}

	/**
	 * @return {@code true} if the input Object is an instance of
	 *         OPPLOWLAxiomSearchNode and both its axiom and its binding
	 *         correspond to those in this.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		OPPLOWLAxiomSearchNode other = (OPPLOWLAxiomSearchNode) obj;
		if (this.axiom == null) {
			if (other.axiom != null) {
				return false;
			}
		} else if (!this.axiom.equals(other.axiom)) {
			return false;
		}
		if (this.binding == null) {
			if (other.binding != null) {
				return false;
			}
		} else if (!this.binding.equals(other.binding)) {
			return false;
		}
		return true;
	}
}
