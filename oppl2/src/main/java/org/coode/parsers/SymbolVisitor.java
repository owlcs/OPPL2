/**
 * 
 */
package org.coode.parsers;

/** @author Luigi Iannone */
public interface SymbolVisitor {
    void visitSymbol(Symbol symbol);

    void visitOWLEntity(OWLEntitySymbol owlEntitySymbol);

    void visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol);

    void visitIRI(IRISymbol iriSymbol);
}
