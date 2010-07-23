package org.coode.patterns.test;

public class ExhaustingPatternTest extends AbstractPatternTestCase {
	public void testDocumentationScriptFood() {
		String formula = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS=CreateUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff ; RETURN $thisClass;";
		this.parseCorrect(formula, this.getOntology("food.owl"));
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
				+ "A ?x - free Menu";
		this.parseWrong(formula, this.getOntology("patternedPizza.owl"),
				"Encountered ?_thisClass at line 3 column ", 7);
	}
}
