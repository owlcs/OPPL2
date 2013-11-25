package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

/** A generic symbol
 * 
 * @author Luigi Iannone */
public class Symbol {
    private final String name;
    private final Type type;

    /** @param name */
    public Symbol(String name, Type type) {
        this.name = checkNotNull(name, "name");
        this.type = checkNotNull(type, "type");
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void accept(SymbolVisitor visitor) {
        visitor.visitSymbol(this);
    }

    public <O> O accept(SymbolVisitorEx<O> visitor) {
        return visitor.visitSymbol(this);
    }
}
