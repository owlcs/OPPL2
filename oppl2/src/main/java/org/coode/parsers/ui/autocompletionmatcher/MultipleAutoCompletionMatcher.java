/**
 * 
 */
package org.coode.parsers.ui.autocompletionmatcher;

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

    public MultipleAutoCompletionMatcher(
            Collection<? extends AutoCompletionMatcher> matchers) {
        if (matchers == null) {
            throw new NullPointerException("The matcher collection cannot be null");
        }
        this.matchers.addAll(matchers);
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        if (string2Complete == null) {
            throw new NullPointerException("The String to complete cannot be null");
        }
        List<String> toReturn = new ArrayList<String>();
        for (AutoCompletionMatcher matcher : matchers) {
            toReturn.addAll(matcher.getMatches(string2Complete));
        }
        Collections.sort(toReturn);
        return toReturn;
    }
}
