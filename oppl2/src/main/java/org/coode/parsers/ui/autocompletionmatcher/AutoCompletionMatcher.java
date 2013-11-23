package org.coode.parsers.ui.autocompletionmatcher;

import java.util.List;

/** Represents a means to retrieve the completions matching a String.
 * 
 * @author Luigi Iannone */
public interface AutoCompletionMatcher {
    /** Gets all the matches for the input String.
     * 
     * @param string2Complete
     *            . Cannot be <code>null</code>.
     * @return a List of matching String elements.
     * @throws NullPointerException
     *             if the input string is <code>null</code>. */
    List<String> getMatches(String string2Complete);
}
