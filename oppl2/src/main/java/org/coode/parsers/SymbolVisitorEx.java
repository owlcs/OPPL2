package org.coode.parsers;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public interface SymbolVisitorEx<O> {
    /** @param symbol
     *            symbol
     * @return visitor value */
    O visitSymbol(Symbol symbol);

    /** @param owlConstantSymbol
     *            owlConstantSymbol
     * @return visitor value */
    O visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol);

    /** @param owlEntitySymbol
     *            owlEntitySymbol
     * @return visitor value */
    O visitOWLEntity(OWLEntitySymbol owlEntitySymbol);

    /** @param iriSymbol
     *            iriSymbol
     * @return visitor value */
    O visitIRI(IRISymbol iriSymbol);
}
