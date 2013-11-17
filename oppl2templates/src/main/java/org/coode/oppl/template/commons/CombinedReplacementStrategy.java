/**
 * 
 */
package org.coode.oppl.template.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.coode.oppl.template.ReplacementStrategy;

/** Use this Strategy to combine several ones that use different place-holders.
 * The replacement will happen in the order specified by the user in the
 * constructor
 * 
 * @author Luigi Iannone */
public class CombinedReplacementStrategy<I, P extends I> implements
        ReplacementStrategy<I, P> {
    private final List<ReplacementStrategy<I, P>> strategies = new ArrayList<ReplacementStrategy<I, P>>();

    public CombinedReplacementStrategy(List<ReplacementStrategy<I, P>> strategies) {
        if (strategies == null) {
            throw new NullPointerException(
                    "The list of the combined strategies cannot be null");
        }
        if (strategies.isEmpty()) {
            throw new IllegalArgumentException(
                    "The list of the combined strategies cannot be empty");
        }
        this.strategies.addAll(strategies);
    }

    @Override
    public final P replace(I input) {
        P replaced = null;
        Iterator<ReplacementStrategy<I, P>> iterator = this.strategies.iterator();
        // There is at least one strategy.
        do {
            ReplacementStrategy<I, P> strategy = iterator.next();
            replaced = strategy.replace(replaced == null ? input : replaced);
        } while (iterator.hasNext());
        return replaced;
    }

    /** @return the strategies */
    public final List<ReplacementStrategy<I, P>> getStrategies() {
        return new ArrayList<ReplacementStrategy<I, P>>(this.strategies);
    }
}
