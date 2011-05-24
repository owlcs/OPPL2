/**
 * 
 */
package org.coode.parsers.common;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;

/**
 * This implementation does not do anything when any error is encountered.
 * 
 * @author Luigi Iannone
 * 
 */
public class SilentListener implements ErrorListener {
	/**
	 * @see org.coode.parsers.ErrorListener#illegalToken(org.antlr.runtime.tree.CommonTree,
	 *      java.lang.String)
	 */
	public void illegalToken(CommonTree t, String message) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#incompatibleSymbolType(org.antlr.runtime.tree.CommonTree,
	 *      org.coode.parsers.Type, org.antlr.runtime.tree.CommonTree)
	 */
	public void incompatibleSymbolType(CommonTree t, Type type,
			CommonTree expression) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#incompatibleSymbols(org.antlr.runtime.tree.CommonTree,
	 *      org.antlr.runtime.tree.CommonTree[])
	 */
	public void incompatibleSymbols(CommonTree parentExpression,
			CommonTree... trees) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#recognitionException(org.antlr.runtime.RecognitionException)
	 */
	public void recognitionException(RecognitionException e) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#recognitionException(org.antlr.runtime.RecognitionException,
	 *      java.lang.String[])
	 */
	public void recognitionException(RecognitionException e,
			String... tokenNames) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#reportThrowable(java.lang.Throwable,
	 *      int, int, int)
	 */
	public void reportThrowable(Throwable t, int line, int charPosInLine,
			int length) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#rewriteEmptyStreamException(org.antlr.runtime.tree.RewriteEmptyStreamException)
	 */
	public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
	}

	/**
	 * @see org.coode.parsers.ErrorListener#unrecognisedSymbol(org.antlr.runtime.tree.CommonTree)
	 */
	public void unrecognisedSymbol(CommonTree t) {
	}
}
