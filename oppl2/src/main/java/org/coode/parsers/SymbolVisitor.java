package org.coode.parsers;

/** @author Luigi Iannone */
public interface SymbolVisitor {
    /** @param symbol */
    void visitSymbol(Symbol symbol);

    /** @param owlEntitySymbol */
    void visitOWLEntity(OWLEntitySymbol owlEntitySymbol);

    /** @param owlConstantSymbol */
    void visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol);

    /** @param iriSymbol */
    void visitIRI(IRISymbol iriSymbol);
}
