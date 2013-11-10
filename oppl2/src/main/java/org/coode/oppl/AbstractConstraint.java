package org.coode.oppl;

import org.semanticweb.owlapi.util.ShortFormProvider;

public interface AbstractConstraint extends Renderable {
    <O> O accept(ConstraintVisitorEx<O> visitor);

    void accept(ConstraintVisitor visitor);

    String render(ShortFormProvider shortFormProvider);
}
