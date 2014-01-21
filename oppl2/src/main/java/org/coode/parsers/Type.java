package org.coode.parsers;

/** @author Luigi Iannone */
public interface Type {
    /** @param visitor
     *            visitor */
    void accept(TypeVisitor visitor);

    /** @param visitor
     *            visitor
     * @param <O>
     *            visitor return type
     * @return visitor value */
    <O> O accept(TypeVisitorEx<O> visitor);
}
