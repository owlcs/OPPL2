package org.coode.oppl;

import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public interface AbstractConstraint extends Renderable {
    /** @param visitor
     * @return visitor value */
    <O> O accept(ConstraintVisitorEx<O> visitor);

    /** @param visitor */
    void accept(ConstraintVisitor visitor);

    /** @param shortFormProvider
     * @return */
    String render(ShortFormProvider shortFormProvider);
}
