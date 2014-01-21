package org.coode.parsers.oppl;

/** @author Luigi Iannone */
public interface OPPLSymbol {
    /** @param visitor
     *            visitor */
    void accept(OPPLSymbolVisitor visitor);

    /** @param visitor
     *            visitor
     * @param <O>
     *            visitor return type
     * @return visitor value */
    <O> O accept(OPPLSymbolVisitorEx<O> visitor);
}
