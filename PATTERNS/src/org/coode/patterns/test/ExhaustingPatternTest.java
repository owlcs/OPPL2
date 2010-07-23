package org.coode.patterns.test;

import org.coode.oppl.OPPLScript;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.SystemErrorEcho;
import org.coode.parsers.test.AbstractExpectedErrorCheckerErrorListener;
import org.coode.parsers.test.JunitTestErrorChecker;

public class ExhaustingPatternTest extends AbstractPatternTestCase {
	private final static ErrorListener JUNITERR_ERROR_LISTENER = new SystemErrorEcho();

	public void testDocumentationScriptFood() {
		String formula = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS=CreateUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff ; RETURN $thisClass;";
		this.parseCorrect(formula, this.getOntology("food.owl"));
	}

	public void testRegExpGroupUse() {
		OPPLScript result = this
				.parse("?island:CLASS=Match(\"(BoundaryFragment)\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(1)) BEGIN ADD ?newIsland subClassOf ?island END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
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
		this.parseCorrect(formula, this.getOntology("patternedPizza.owl"));
	}

	public void testDocumentationScriptDOLCE() {
		String formula = "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN "
				+ "ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, "
				+ "ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject "
				+ "and ?realizationProperty some ?informationObject END;\n"
				+ "Information Realization Pattern:\n"
				+ "?informationRealization ?realizationProperty ?informationObject\n"
				+ "	Named pizza pattern";
		this.parseCorrect(formula, this.getOntology("patternedDUL.owl"));
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
		this.parseCorrect(formula, this.getOntology("patternedDUL.owl"));
	}

	public void _testDocumentationScriptPizzaRefersPattern() {
		String formula = "?x:CLASS[subClassOf Food]\n"
				+ "BEGIN\n"
				+ "ADD $thisClass subClassOf Menu,\n"
				+ "ADD $thisClass subClassOf contains Course and only ($FreeFromPattern(?x))\n"
				+ "END;\n" + "A ?x - free Menu";
		this.parseCorrect(formula, this.getOntology("patternedPizza.owl"));
	}

	public void testMultilineError() {
		String formula = "?x:CLASS[subClassOf Food]\n" + "BEGIN\n"
				+ "ADD $thisClass sub_ClassOf Menu\n" + "END;\n"
				+ "A ?x  free Menu";
		this.parseWrong(formula, this.getOntology("patternedPizza.owl"),
				AbstractExpectedErrorCheckerErrorListener
						.getIllegalTokenExpected(new JunitTestErrorChecker(
								JUNITERR_ERROR_LISTENER)));
	}

	public void testParseMissingQuery() {
		OPPLScript result = this
				.parse("?island:INDIVIDUAL BEGIN ADD Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		String script = "?island:INDIVIDUAL BEGIN REMOVE Asinara InstanceOf Country END;";
		this.parseWrong(script, this.getOntology("test.owl"),
				AbstractExpectedErrorCheckerErrorListener
						.getIllegalTokenExpected(new JunitTestErrorChecker(
								JUNITERR_ERROR_LISTENER)));
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	@Override
	protected OPPLScript parse(String script) {
		return super.parsePattern(script, this.getOntology("test.owl"));
	}
}
