package org.coode.parsers;

import java.util.Set;

/** @author Luigi Iannone */
public interface Scope {
    /** Retrieves the name of the scope
     * 
     * @return the name of this Scope as a String */
    String getScopeName();

    /** Retrieves the Scope enclosing this.
     * 
     * @return a Scope that includes this Scope, or {@code null} if this Scope
     *         is the top-most (global) one. */
    Scope getEnclosingScope();

    /** Defines a symbol inside this Scope.
     * 
     * @param symbol
     *            The Symbol to define. Cannot be {@code null}.
     * @throws NullPointerException
     *             if the input is {@code null}. */
    void define(Symbol symbol);

    /** Retrieves the symbol corresponding to the input name.
     * 
     * @param name
     *            the name of the Symbol to retrieve. Cannot be {@code null}.
     * @return the corresponding symbol if it has been defined previously,
     *         {@code null} otherwise.
     * @throws NullPointerException
     *             if the input is {@code null}. */
    Symbol resolve(String name);

    /** Retrieves the set of Symbol instances whose name starts with the input
     * prefix.
     * 
     * @param prefix
     *            The input prefix. Cannot be {@code null}.
     * @return A Set of Symbol.
     * @throws NullPointerException
     *             if the input is {@code null}. */
    Set<Symbol> match(String prefix);

    /** Retrieves all the Symbol instances in this Scope
     * 
     * @return A Set of Symbol elements. */
    Set<Symbol> getAllSymbols();

    /** Retrieves all the Symbol instances in this Scope whose tyoe is equal to
     * the input Type.
     * 
     * @param type
     *            . The Type of the Symbols to retrieve. Cannot be {@code null}.
     * @return A Set of Symbol elements.
     * @throws NullPointerException
     *             if the input is {@code null}. */
    Set<Symbol> getAllSymbols(Type type);

    /** Frees up resources used by this Scope */
    void dispose();
}
