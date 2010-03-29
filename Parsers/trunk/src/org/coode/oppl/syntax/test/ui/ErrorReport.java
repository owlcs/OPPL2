/**
 * 
 */
package org.coode.oppl.syntax.test.ui;

/**
 * @author Luigi Iannone
 * 
 */
public interface ErrorReport {
	String getMessage();

	int getStartIndex();

	int getEndIndex();

	int getLine();
}
