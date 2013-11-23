package org.coode.parsers;

public interface Type {
    void accept(TypeVisitor visitor);

    <O> O accept(TypeVisitorEx<O> visitor);
}
