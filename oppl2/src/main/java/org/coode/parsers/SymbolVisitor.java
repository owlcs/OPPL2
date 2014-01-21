package org.coode.parsers;

/** @author Luigi Iannone */
public interface SymbolVisitor {
    /** @param symbol
     *            symbol */
    void visitSymbol(Symbol symbol);

    /** @param owlEntitySymbol
     *            owlEntitySymbol */
    void visitOWLEntity(OWLEntitySymbol owlEntitySymbol);

    /** @param owlConstantSymbol
     *            owlConstantSymbol */
    void visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol);

    /** @param iriSymbol
     *            iriSymbol */
    void visitIRI(IRISymbol iriSymbol);
}
