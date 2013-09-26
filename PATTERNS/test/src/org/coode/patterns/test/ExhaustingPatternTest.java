package org.coode.patterns.test;

import org.antlr.runtime.tree.CommonTree;
import org.coode.oppl.OPPLScript;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.coode.parsers.common.SystemErrorEcho;
import org.coode.parsers.test.AbstractExpectedErrorCheckerErrorListener;
import org.coode.parsers.test.JunitTestErrorChecker;

@SuppressWarnings("javadoc")
public class ExhaustingPatternTest extends AbstractPatternTestCase {
	private final static ErrorListener JUNITERR_ERROR_LISTENER = new SystemErrorEcho();

	public void testDocumentationScriptFood() {
		String formula = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS=CreateUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff ; RETURN $thisClass;";
		parseCorrect(formula, getOntology("food.owl"));
	}

	public void testRegExpGroupUse() {
		OPPLScript result = this.parse("?island:CLASS=Match(\"(BoundaryFragment)\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(1)) BEGIN ADD ?newIsland subClassOf ?island END;");
		expectedCorrect(result);
		this.execute(result, getOntology("test.owl"), 0);
	}

	public void testDocumentationScriptPizza() {
		String formula = "?base:CLASS, ?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES)\n"
				+ "BEGIN\n"
				+ "ADD $thisClass subClassOf Pizza,\n"
				+ "ADD $thisClass subClassOf hasTopping some ?topping,\n"
				+ "ADD $thisClass subClassOf hasTopping only ?allToppings,\n"
				+ "ADD $thisClass subClassOf hasBase some ?base\n"
				+ "END;\n"
				+ "A pizza with ?base base and ?topping toppings ";
		parseCorrect(formula, getOntology("patternedPizza.owl"));
	}

	public void testDocumentationScriptDOLCE() {
		String formula = "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN "
				+ "ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, "
				+ "ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject "
				+ "and ?realizationProperty some ?informationObject END;\n"
				+ "Information Realization Pattern:\n"
				+ "?informationRealization ?realizationProperty ?informationObject\n"
				+ "	Named pizza pattern";
		parseCorrect(formula, getOntology("patternedDUL.owl"));
	}

	public void testDocumentationScriptDolce2() {
		String formula = "?person:CLASS,\n"
				+ "?role:CLASS,\n"
				+ "?timeInterval:CLASS\n"
				+ "BEGIN\n"
				+ "ADD $thisClass subClassOf Situation,\n"
				+ "ADD $thisClass subClassOf isSettingFor some ?person,\n"
				+ "ADD $thisClass subClassOf isSettingFor some ?role,\n"
				+ "ADD $thisClass subClassOf isSettingFor some ?timeInterval\n"
				+ "END;\n"
				+ "Situation where ?person play the role ?role during the time interval ?timeInterval ";
		parseCorrect(formula, getOntology("patternedDUL.owl"));
	}

	public void _testDocumentationScriptPizzaRefersPattern() {
		String formula = "?x:CLASS[subClassOf Food]\n" + "BEGIN\n"
				+ "ADD $thisClass subClassOf Menu,\n"
				+ "ADD $thisClass subClassOf contains Course and only ($FreeFromPattern(?x))\n"
				+ "END;\n" + "A ?x - free Menu";
		parseCorrect(formula, getOntology("patternedPizza.owl"));
	}

	public void testMultilineError() {
		String formula = "?x:CLASS\n" + "BEGIN\n" + "ADD $thisClass sub_ClassOf Menu\n" + "END;\n"
				+ "A ?x  free Menu";
		parseWrong(
				formula,
				getOntology("patternedPizza.owl"),
				new AbstractExpectedErrorCheckerErrorListener(new JunitTestErrorChecker(
						JUNITERR_ERROR_LISTENER)) {
					@Override
					public void illegalToken(CommonTree t, String message) {
						getErrorChecker().getErrorListenerForExpectedError().illegalToken(
								t,
								message);
					}

					@Override
					public void unrecognisedSymbol(CommonTree t) {
						getErrorChecker().getErrorListenerForExpectedError().unrecognisedSymbol(
								t);
					}

					@Override
					public void incompatibleSymbolType(CommonTree t, Type type,
							CommonTree expression) {
						getErrorChecker().getErrorListenerForExpectedError().incompatibleSymbolType(
								t,
								type,
								expression);
						;
					}
				});
	}

	public void testParseMissingQuery() {
		OPPLScript result = this.parse("?island:INDIVIDUAL BEGIN ADD Asinara InstanceOf Country END;");
		expectedCorrect(result);
		this.execute(result, getOntology("test.owl"), 0);
		String script = "?island:INDIVIDUAL BEGIN REMOVE Asinara InstanceOf Country END;";
		parseWrong(
				script,
				getOntology("test.owl"),
				AbstractExpectedErrorCheckerErrorListener.getIllegalTokenExpected(new JunitTestErrorChecker(
						JUNITERR_ERROR_LISTENER)));
		this.execute(result, getOntology("test.owl"), 0);
	}

	@Override
	protected OPPLScript parse(String script) {
		return super.parsePattern(script, getOntology("test.owl"));
	}
}
