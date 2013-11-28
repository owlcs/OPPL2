package org.coode.parsers.oppl;

/** @author Luigi Iannone */
public interface OPPLSymbol {
    /** @param visitor */
    void accept(OPPLSymbolVisitor visitor);

    /** @param visitor
     * @return visitor value */
    <O> O accept(OPPLSymbolVisitorEx<O> visitor);
}
