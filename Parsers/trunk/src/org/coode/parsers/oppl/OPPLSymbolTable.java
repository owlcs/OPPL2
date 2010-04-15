package org.coode.parsers.oppl;

import org.antlr.runtime.Token;
import org.coode.parsers.OWLEntityCheckerScope;
import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolTable;
import org.semanticweb.owl.model.OWLDataFactory;

public class OPPLSymbolTable extends SymbolTable {
	/**
	 * @param globalScope
	 * @param dataFactory
	 */
	public OPPLSymbolTable(OWLEntityCheckerScope globalScope, OWLDataFactory dataFactory) {
		super(globalScope, dataFactory);
	}

	/**
	 * Defines a new Symbol in this OPPLSymbolTable under the input Token.
	 * 
	 * @param token
	 *            The input token. Cannot be {@code null}.
	 * @param symbol
	 *            The Symbol to be defined. Cannot be {@code null}.
	 * 
	 */
	public void define(Token token, Symbol symbol) {
		if (token == null) {
			throw new NullPointerException("The token cannot be null");
		}
		if (symbol == null) {
			throw new NullPointerException("The symbol cannot be null");
		}
		this.storeSymbol(token, symbol);
	}
}
