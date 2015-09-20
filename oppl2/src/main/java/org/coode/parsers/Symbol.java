package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

/**
 * A generic symbol
 * 
 * @author Luigi Iannone
 */
public class Symbol {

    private final String name;
    private final Type type;

    /**
     * @param name
     *        name
     * @param type
     *        type
     */
    public Symbol(String name, Type type) {
        this.name = checkNotNull(name, "name");
        this.type = checkNotNull(type, "type");
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param visitor
     *        visitor
     */
    public void accept(SymbolVisitor visitor) {
        visitor.visitSymbol(this);
    }

    /**
     * @param visitor
     *        visitor
     * @param <O>
     *        visitor return type
     * @return visitor value
     */
    public <O> O accept(SymbolVisitorEx<O> visitor) {
        return visitor.visitSymbol(this);
    }
}
