/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns.syntax;

import org.coode.oppl.syntax.OPPLParserConstants;
import org.coode.patterns.PatternConstraintSystem;

/**
 * @author Luigi Iannone
 * 
 */
public class PatternUtils {
	//XXX needs to be manually synchronized between the two Utils classes for the parsers, since JavaCC makes the Token class specific to each package and therefore very hard to abstract from the specific Parser class.
	public static String readString(PatternParser parser, boolean spaceTokens,
			int... delimiterTokenKinds) {
		StringBuilder toReturn = new StringBuilder();
		boolean found = false;
		Token token = parser.getToken(1);
		while (!found) {
			for (int i = 0; !found && i < delimiterTokenKinds.length; i++) {
				found = token.kind == OPPLParserConstants.EOF
						|| delimiterTokenKinds[i] == token.kind;
			}
			if (!found) {
				toReturn.append(token.image);
				int end = token.endColumn;
				parser.getNextToken();
				token = parser.getToken(1);
				if (spaceTokens) {
					// verify whether there is a space in the original token sequence
					if (end < token.beginColumn - 1) {
						toReturn.append(" ");
					}
				}
			}
		}
		String s = toReturn.toString();
		return s;
	}

	public static String readAndResolveString(PatternParser patternParser,
			PatternConstraintSystem cs, boolean spaceTokens,
			int... delimiterTokenKinds) throws ParseException {
		StringBuilder toReturn = new StringBuilder();
		Token token = patternParser.getToken(1);
		boolean found = false;
		while (!found) {
			for (int i = 0; !found && i < delimiterTokenKinds.length; i++) {
				found = token.kind == PatternParserConstants.EOF
						|| delimiterTokenKinds[i] == token.kind;
			}
			if (!found) {
				int end = token.endColumn;
				toReturn.append(patternParser.resolvedString(cs, false));
				token = patternParser.getToken(1);
				if (spaceTokens) {
					// verify whether there is a space in the original token sequence
					if (end < token.beginColumn - 1) {
						toReturn.append(" ");
					}
				}
			}
		}
		return toReturn.toString();
	}
}
