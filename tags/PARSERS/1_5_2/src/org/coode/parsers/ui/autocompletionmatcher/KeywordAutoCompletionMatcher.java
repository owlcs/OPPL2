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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matches (case insensitively) the string to complete against a set of keywords
 * and returns those that start with the string to complete
 * 
 * @author Luigi Iannone
 * 
 */
public final class KeywordAutoCompletionMatcher implements AutoCompletionMatcher {
	private final Set<String> keywords = new HashSet<String>();

	public KeywordAutoCompletionMatcher(Collection<? extends String> keywords) {
		if (keywords == null) {
			throw new NullPointerException("The keywords colleciton cannot be null");
		}
		this.keywords.addAll(keywords);
	}

	/**
	 * @see org.coode.parsers.ui.autocompletionmatcher.AutoCompletionMatcher#getMatches(java.lang.String)
	 */
	public List<String> getMatches(String string2Complete) {
		List<String> toReturn = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\A" + string2Complete + ".*", Pattern.CASE_INSENSITIVE);
		for (String kw : this.keywords) {
			Matcher matcher = pattern.matcher(kw);
			if (matcher.matches()) {
				toReturn.add(kw);
			}
		}
		Collections.sort(toReturn);
		return toReturn;
	}
}
