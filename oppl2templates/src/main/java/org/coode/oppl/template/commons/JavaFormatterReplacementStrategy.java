/**
 * 
 */
package org.coode.oppl.template.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.coode.oppl.template.ReplacementStrategy;

/** Uses {@link Formatter} to perform the substitution.
 * 
 * @author Luigi Iannone */
public final class JavaFormatterReplacementStrategy implements
        ReplacementStrategy<String, String> {
    private List<Object> params;

    /** @param params */
    public JavaFormatterReplacementStrategy(Collection<? extends Object> params) {
        if (params == null) {
            throw new NullPointerException("The parameters collection cannot be null");
        }
        this.params = new ArrayList<Object>(params);
    }

    @Override
    public String replace(String templateString) {
        return String.format(templateString, params.toArray());
    }

    @Override
    public String toString() {
        return "java.util.Formatter based Strategy";
    }
}
