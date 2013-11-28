package org.coode.parsers.ui.autocompletionmatcher;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Combines more than one AutoCompletionMatcher.
 * 
 * @author Luigi Iannone */
public final class MultipleAutoCompletionMatcher implements AutoCompletionMatcher {
    private final Set<AutoCompletionMatcher> matchers = new HashSet<AutoCompletionMatcher>();

    /** @param matchers */
    public MultipleAutoCompletionMatcher(
            Collection<? extends AutoCompletionMatcher> matchers) {
        this.matchers.addAll(checkNotNull(matchers, "matchers"));
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        checkNotNull(string2Complete, "string2Complete");
        List<String> toReturn = new ArrayList<String>();
        for (AutoCompletionMatcher matcher : matchers) {
            toReturn.addAll(matcher.getMatches(string2Complete));
        }
        Collections.sort(toReturn);
        return toReturn;
    }
}
