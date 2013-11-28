package org.coode.parsers;

/** @author Luigi Iannone */
public interface Type {
    /** @param visitor */
    void accept(TypeVisitor visitor);

    /** @param visitor
     * @return visitor value */
    <O> O accept(TypeVisitorEx<O> visitor);
}
