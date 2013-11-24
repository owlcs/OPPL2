package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public class NAFConstraint implements AbstractConstraint {
    private final OWLAxiom axiom;
    private final ConstraintSystem constraintSystem;

    /** @param axiom
     * @param constraintSystem */
    public NAFConstraint(OWLAxiom axiom, ConstraintSystem constraintSystem) {
        this.axiom = checkNotNull(axiom, "axiom");
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
    }

    @Override
    public <O> O accept(ConstraintVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void accept(ConstraintVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        ManchesterSyntaxRenderer r = new ManchesterSyntaxRenderer(shortFormProvider);
        getAxiom().accept(r);
        return String.format("FAIL %s", r.toString());
    }

    @Override
    public String render(ConstraintSystem cs) {
        ManchesterSyntaxRenderer r = cs.getOPPLFactory().getManchesterSyntaxRenderer(cs);
        getAxiom().accept(r);
        return String.format("FAIL %s", r);
    }

    @Override
    public String toString() {
        return this.render(getConstraintSystem());
    }

    /** @return the axiom */
    public OWLAxiom getAxiom() {
        return axiom;
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (axiom == null ? 0 : axiom.hashCode());
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
        NAFConstraint other = (NAFConstraint) obj;
        if (axiom == null) {
            if (other.axiom != null) {
                return false;
            }
        } else if (!axiom.equals(other.axiom)) {
            return false;
        }
        return true;
    }
}
