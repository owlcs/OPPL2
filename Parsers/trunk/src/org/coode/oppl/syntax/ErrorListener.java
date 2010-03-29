/**
 * 
 */
package org.coode.oppl.syntax;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.RewriteEmptyStreamException;

/**
 * @author Luigi Iannone
 * 
 */
public interface ErrorListener {
	public void unrecognisedSymbol(Token t);

	public void incompatibleSymbolType(Token t, Type type, Token expression);

	public void incompatibleSymbols(Token parentExpression, Token... tokens);

	public void illegalToken(Token token, String message);

	public void recognitionException(RecognitionException e);

	public void rewriteEmptyStreamException(RewriteEmptyStreamException e);
}
