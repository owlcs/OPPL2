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
package org.coode.oppl.syntax;

import java.util.Collections;
import java.util.Set;

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.VariableManchesterOWLSyntaxParser;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.generated.RegExpGenerated;
import org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variablemansyntax.generated.VariableExpressionGeneratedVariable;
import org.semanticweb.owl.expression.ParserException;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class Utils {
	public static ParserException buildException(int beginningSubSection,
			int beginningSubSectionLine, ParserException e) {
		ParserException test = new ParserException(e.getCurrentToken(), e
				.getStartPos()
				+ beginningSubSection, e.getLineNumber()
				+ beginningSubSectionLine - 1, e.getColumnNumber()
				+ beginningSubSection, e.isClassNameExpected(), e
				.isObjectPropertyNameExpected(),
				e.isDataPropertyNameExpected(), e.isIndividualNameExpected(), e
						.isDatatypeNameExpected(), e.getExpectedKeywords());
		return test;
	}

	public static ParserException buildException(Object expression,
			int beginningSubSection, int beginningSubSectionLine, Exception e) {
		Set<String> set = Collections.emptySet();
		ParserException test = new ParserException(expression + "\n"
				+ e.getMessage(), beginningSubSection, beginningSubSectionLine,
				beginningSubSection, false, false, false, false, false, set);
		return test;
	}

	public static String readString(OPPLParser parser, boolean spaceTokens,
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

	public static SingleValueGeneratedVariable<OWLObject> parseVariableExpressionGeneratedVariable(
			String name, VariableType type, String string,
			ConstraintSystem constraintSystem) throws ParserException {
		VariableManchesterOWLSyntaxParser parser = new VariableManchesterOWLSyntaxParser(
				string, constraintSystem);
		// TODO move to VariableType
		OWLObject owlObject = type.parseOWLObject(parser);
		// switch (type) {
		// case CLASS:
		// owlObject = parser.parseDescription();
		// break;
		// case OBJECTPROPERTY:
		// owlObject = parser.parseObjectPropertyExpression();
		// break;
		// case DATAPROPERTY:
		// owlObject = parser.parseDataProperty();
		// break;
		// case INDIVIDUAL:
		// owlObject = parser.parseIndividual();
		// break;
		// case CONSTANT:
		// owlObject = parser.parseConstant();
		// break;
		// default:
		// throw new IllegalArgumentException("Unsupported type: "
		// + type.name());
		// }
		VariableExpressionGeneratedVariable variableExpressionGeneratedVariable = new VariableExpressionGeneratedVariable(
				name, owlObject, constraintSystem);
		constraintSystem.importVariable(variableExpressionGeneratedVariable);
		return variableExpressionGeneratedVariable;
	}

	public static RegExpGenerated parseRegexpGeneratedVariable(String name,
			VariableType type, SingleValueGeneratedValue<String> string,
			ConstraintSystem constraintSystem) throws ParserException {
		Set<? extends OWLObject> referencedValues = type
				.getReferencedValues(constraintSystem.getOntologyManager()
						.getOntologies());
		OWLEntityRenderer renderer = ParserFactory.getInstance()
				.getOPPLFactory().getOWLEntityRenderer(constraintSystem);
		RegExpGeneratedValue val = new RegExpGeneratedValue(referencedValues,
				string, renderer);
		RegExpGenerated v = type.instantiateRegexpVariable(name, val);
		constraintSystem.importVariable(v);
		return v;
	}
}
