package org.coode.parsers.ui.autocompletionmatcher;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.*;

/**
 * Combines more than one AutoCompletionMatcher.
 * 
 * @author Luigi Iannone
 */
public final class MultipleAutoCompletionMatcher implements AutoCompletionMatcher {

    private final Set<AutoCompletionMatcher> matchers = new HashSet<>();

    /**
     * @param matchers
     *        matchers
     */
    public MultipleAutoCompletionMatcher(
        Collection<? extends AutoCompletionMatcher> matchers) {
        this.matchers.addAll(checkNotNull(matchers, "matchers"));
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        checkNotNull(string2Complete, "string2Complete");
        List<String> toReturn = new ArrayList<>();
        for (AutoCompletionMatcher matcher : matchers) {
            toReturn.addAll(matcher.getMatches(string2Complete));
        }
        Collections.sort(toReturn);
        return toReturn;
    }
}
