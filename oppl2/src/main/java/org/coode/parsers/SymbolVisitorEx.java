package org.coode.parsers;

/** @author Luigi Iannone
 * @param <O> */
public interface SymbolVisitorEx<O> {
    /** @param symbol
     * @return visitor value */
    O visitSymbol(Symbol symbol);

    /** @param owlConstantSymbol
     * @return visitor value */
    O visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol);

    /** @param owlEntitySymbol
     * @return visitor value */
    O visitOWLEntity(OWLEntitySymbol owlEntitySymbol);

    /** @param iriSymbol
     * @return visitor value */
    O visitIRI(IRISymbol iriSymbol);
}
