package org.coode.parsers.factory;

import org.coode.parsers.SymbolTable;

/**
 * @author Luigi Iannone
 * @param <S>
 *        type
 */
public interface SymbolTableFactory<S extends SymbolTable> {

    /**
     * Creates a SymbolTable
     * 
     * @return the SymbolTable
     */
    S createSymbolTable();
}
