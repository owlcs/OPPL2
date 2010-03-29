/**
 * 
 */
package org.coode.oppl.syntax;

import org.antlr.runtime.Token;

/**
 * @author Luigi Iannone
 * 
 */
public interface ErrorListener {
	public void unrecognisedSymbol(Token t);

	public void incompatibleSymbolType(Token t, Type type, Token expression);

	public void incompatibleSymbols(Token parentExpression, Token... tokens);

	public void illegalToken(Token token, String message);
}
