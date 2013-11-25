package org.coode.parsers.ui.autocompletionmatcher;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Matches (case insensitively) the string to complete against a set of keywords
 * and returns those that start with the string to complete
 * 
 * @author Luigi Iannone */
public final class KeywordAutoCompletionMatcher implements AutoCompletionMatcher {
    private final Set<String> keywords = new HashSet<String>();

    public KeywordAutoCompletionMatcher(Collection<? extends String> keywords) {
        this.keywords.addAll(checkNotNull(keywords, "keywords"));
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        List<String> toReturn = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\A" + string2Complete + ".*",
                Pattern.CASE_INSENSITIVE);
        for (String kw : keywords) {
            Matcher matcher = pattern.matcher(kw);
            if (matcher.matches()) {
                toReturn.add(kw);
            }
        }
        Collections.sort(toReturn);
        return toReturn;
    }
}
