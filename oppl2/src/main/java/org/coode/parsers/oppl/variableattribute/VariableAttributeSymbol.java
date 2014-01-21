package org.coode.parsers.oppl.variableattribute;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.OPPLSymbol;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public abstract class VariableAttributeSymbol<O extends VariableAttribute<?>> extends
        Symbol implements OPPLSymbol {
    private final O variableAttribute;

    /** @return the variableAttribute */
    public O getVariableAttribute() {
        return this.variableAttribute;
    }

    /** @param name
     *            name
     * @param type
     *            type
     * @param variableAttribute
     *            variableAttribute */
    public VariableAttributeSymbol(String name, Type type, O variableAttribute) {
        super(name, type);
        this.variableAttribute = checkNotNull(variableAttribute, "variableAttribute");
    }

    @Override
    public String toString() {
        return String.format("%s.%s", getName(), this.getVariableAttribute());
    }
}
