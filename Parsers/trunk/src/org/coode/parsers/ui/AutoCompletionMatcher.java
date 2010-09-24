/**
 * 
 */
package org.coode.parsers.ui;

import java.util.List;

/**
 * Represents a means to retrieve the completions matching a String.
 * 
 * @author Luigi Iannone
 * 
 */
public interface AutoCompletionMatcher {
	/**
	 * Gets all the matches for the input String.
	 * 
	 * @return a List of matching String elements.
	 */
	public List<String> getMatches(String string2Complete);
}
