/**
 * 
 */
package org.coode.oppl.syntax;

/**
 * @author Luigi Iannone
 * 
 */
public interface SymbolVisitor {
	void visitSymbol(Symbol symbol);

	void visitOWLEntity(OWLEntitySymbol owlEntitySymbol);
}
