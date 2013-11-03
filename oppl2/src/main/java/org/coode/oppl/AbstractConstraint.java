package org.coode.oppl;

import org.semanticweb.owlapi.util.ShortFormProvider;

public interface AbstractConstraint {
	<O> O accept(ConstraintVisitorEx<O> visitor);

	void accept(ConstraintVisitor visitor);

	String render(ConstraintSystem constraintSystem);

	String render(ShortFormProvider shortFormProvider);
}