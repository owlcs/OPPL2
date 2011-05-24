/**
 * 
 */
package org.coode.parsers.common;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.common.exception.IllegalTokenParsingException;
import org.coode.parsers.common.exception.IncompatibleSymbolTypeParsingException;
import org.coode.parsers.common.exception.IncompatibleSymbolsParsingException;
import org.coode.parsers.common.exception.ParsingException;
import org.coode.parsers.common.exception.RecognitionParsingException;
import org.coode.parsers.common.exception.RewriteEmptyStreamParsingException;
import org.coode.parsers.common.exception.UnrecognisedSymbolParsingException;

/**
 * @author Luigi Iannone
 * 
 */
public class QuickFailErrorListener implements ErrorListener {
	/**
	 * @see org.coode.parsers.ErrorListener#unrecognisedSymbol(org.antlr.runtime.tree.CommonTree)
	 */
	public void unrecognisedSymbol(CommonTree t) {
		throw new UnrecognisedSymbolParsingException(t.getText(), t.getLine(),
				t.getCharPositionInLine());
	}

	/**
	 * @see org.coode.parsers.ErrorListener#incompatibleSymbolType(org.antlr.runtime.tree.CommonTree,
	 *      org.coode.parsers.Type, org.antlr.runtime.tree.CommonTree)
	 */
	public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
		throw new IncompatibleSymbolTypeParsingException(t.getText(), type, expression.getText(),
				t.getLine(), t.getCharPositionInLine());
	}

	/**
	 * @see org.coode.parsers.ErrorListener#incompatibleSymbols(org.antlr.runtime.tree.CommonTree,
	 *      org.antlr.runtime.tree.CommonTree[])
	 */
	public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
		List<String> symbols = new ArrayList<String>(trees.length);
		for (CommonTree commonTree : trees) {
			symbols.add(commonTree.getText());
		}
		throw new IncompatibleSymbolsParsingException(parentExpression.getText(),
				parentExpression.getLine(), parentExpression.getCharPositionInLine(),
				symbols.toArray(new String[symbols.size()]));
	}

	/**
	 * @see org.coode.parsers.ErrorListener#illegalToken(org.antlr.runtime.tree.CommonTree,
	 *      java.lang.String)
	 */
	public void illegalToken(CommonTree t, String message) {
		throw new IllegalTokenParsingException(t.getText(), t.getLine(), t.getCharPositionInLine(),
				message);
	}

	/**
	 * @see org.coode.parsers.ErrorListener#recognitionException(org.antlr.runtime.RecognitionException)
	 */
	public void recognitionException(RecognitionException e) {
		throw new RecognitionParsingException(e.line, e.charPositionInLine);
	}

	/**
	 * @see org.coode.parsers.ErrorListener#recognitionException(org.antlr.runtime.RecognitionException,
	 *      java.lang.String[])
	 */
	public void recognitionException(RecognitionException e, String... tokenNames) {
		throw new RecognitionParsingException(e.line, e.charPositionInLine, tokenNames);
	}

	/**
	 * @see org.coode.parsers.ErrorListener#rewriteEmptyStreamException(org.antlr.runtime.tree.RewriteEmptyStreamException)
	 */
	public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
		throw new RewriteEmptyStreamParsingException(0, 0);
	}

	/**
	 * @see org.coode.parsers.ErrorListener#reportThrowable(java.lang.Throwable,
	 *      int, int, int)
	 */
	public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
		throw new ParsingException(line, charPosInLine, t);
	}
}
