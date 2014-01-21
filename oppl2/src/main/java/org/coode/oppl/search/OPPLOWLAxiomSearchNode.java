package org.coode.oppl.search;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public class OPPLOWLAxiomSearchNode {
    private final BindingNode binding;
    private final OWLAxiom axiom;

    /** @param axiom
     *            axiom
     * @param bindingNode
     *            bindingNode */
    public OPPLOWLAxiomSearchNode(OWLAxiom axiom, BindingNode bindingNode) {
        this.axiom = checkNotNull(axiom, "axiom");
        binding = checkNotNull(bindingNode, "bindingNode");
    }

    /** @return the axiom */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    @Override
    public String toString() {
        return axiom + " " + binding;
    }

    /** @return the binding */
    public BindingNode getBinding() {
        return binding;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (axiom == null ? 0 : axiom.hashCode());
        result = prime * result + (binding == null ? 0 : binding.hashCode());
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
        OPPLOWLAxiomSearchNode other = (OPPLOWLAxiomSearchNode) obj;
        if (axiom == null) {
            if (other.axiom != null) {
                return false;
            }
        } else if (!axiom.equals(other.axiom)) {
            return false;
        }
        if (binding == null) {
            if (other.binding != null) {
                return false;
            }
        } else if (!binding.equals(other.binding)) {
            return false;
        }
        return true;
    }
}
