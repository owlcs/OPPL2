/**
 * 
 */
package org.coode.parsers.factory;

import org.coode.parsers.SymbolTable;

/**
 * @author Luigi Iannone
 * 
 */
public interface SymbolTableFactory {
	/**
	 * Creates a SymbolTable
	 * 
	 * @return the SymbolTable
	 */
	SymbolTable createSymbolTable();
}
