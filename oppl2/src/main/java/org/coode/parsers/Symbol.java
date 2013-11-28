package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

/** A generic symbol
 * 
 * @author Luigi Iannone */
public class Symbol {
    private final String name;
    private final Type type;

    /** @param name
     * @param type */
    public Symbol(String name, Type type) {
        this.name = checkNotNull(name, "name");
        this.type = checkNotNull(type, "type");
    }

    /** @return name */
    public String getName() {
        return name;
    }

    /** @return type */
    public Type getType() {
        return type;
    }

    /** @param visitor */
    public void accept(SymbolVisitor visitor) {
        visitor.visitSymbol(this);
    }

    /** @param visitor
     * @return visitor value */
    public <O> O accept(SymbolVisitorEx<O> visitor) {
        return visitor.visitSymbol(this);
    }
}
