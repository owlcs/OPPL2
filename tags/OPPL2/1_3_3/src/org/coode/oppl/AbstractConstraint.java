package org.coode.oppl;

public interface AbstractConstraint {
	abstract <O> O accept(ConstraintVisitorEx<O> visitor);

	void accept(ConstraintVisitor visitor);

	String render();
}