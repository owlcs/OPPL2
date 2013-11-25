package org.coode.oppl.template.commons;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;

import org.coode.oppl.template.ReplacementStrategy;

/** Uses String.format to perform the substitution.
 * 
 * @author Luigi Iannone */
public final class StringFormatReplacementStrategy implements
        ReplacementStrategy<String, String> {
    private final Object[] params;

    /** @param params */
    public StringFormatReplacementStrategy(Collection<? extends Object> params) {
        this.params = checkNotNull(params, "params").toArray();
    }

    @Override
    public String replace(String templateString) {
        return String.format(templateString, params);
    }

    @Override
    public String toString() {
        return "String.format based Strategy";
    }
}
