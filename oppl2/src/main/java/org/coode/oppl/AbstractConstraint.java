package org.coode.oppl;

import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public interface AbstractConstraint extends Renderable {
    /** @param visitor
     *            visitor
     * @param <O>
     *            visitor value type
     * @return visitor value */
    <O> O accept(ConstraintVisitorEx<O> visitor);

    /** @param visitor
     *            visitor */
    void accept(ConstraintVisitor visitor);

    /** @param shortFormProvider
     *            shortFormProvider
     * @return rendering */
    String render(ShortFormProvider shortFormProvider);
}
