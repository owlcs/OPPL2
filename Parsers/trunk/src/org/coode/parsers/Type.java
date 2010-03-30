package org.coode.parsers;

public interface Type {
	public void accept(TypeVisitor visitor);

	public <O> O accept(TypeVisitorEx<O> visitor);
}
