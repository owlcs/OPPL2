package org.coode.oppl.syntax;

public interface Type {
	public void accept(TypeVisitor visitor);

	public <O> O accept(TypeVisitorEx<O> visitor);
}
