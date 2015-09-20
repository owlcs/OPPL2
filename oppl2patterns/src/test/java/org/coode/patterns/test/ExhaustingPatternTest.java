package org.coode.patterns.test;

import static org.coode.oppl.patterntestontologies.PatternTestOntologies.*;

import org.coode.oppl.OPPLScript;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ExhaustingPatternTest extends AbstractPatternTestCase {

    @Test
    public void shouldTestDocumentationScriptFood() {
        String formula = "?x:CLASS, ?y:CLASS, ?forbiddenContent:CLASS=CreateUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent) END; A ?x free stuff ; RETURN $thisClass;";
        parseCorrect(formula, food);
    }

    @Test
    public void shouldTestRegExpGroupUse() {
        OPPLScript result = this
            .parsePattern(
                "?island:CLASS=Match(\"(BoundaryFragment)\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(1)) BEGIN ADD ?newIsland subClassOf ?island END;",
                test);
        expectedCorrect(result);
        this.execute(result, 0);
    }

    @Test
    public void shouldTestDocumentationScriptPizza() {
        String formula = "?base:CLASS, ?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES)\n"
            + "BEGIN\n"
            + "ADD $thisClass subClassOf Pizza,\n"
            + "ADD $thisClass subClassOf hasTopping some ?topping,\n"
            + "ADD $thisClass subClassOf hasTopping only ?allToppings,\n"
            + "ADD $thisClass subClassOf hasBase some ?base\n"
            + "END;\n"
            + "A pizza with ?base base and ?topping toppings ";
        parseCorrect(formula, patternedPizza);
    }

    @Test
    public void shouldTestDocumentationScriptDOLCE() {
        String formula = "?informationObject:CLASS, ?informationRealization:CLASS, ?realizationProperty:OBJECTPROPERTY BEGIN "
            + "ADD ?informationRealization subClassOf InformationRealization, ADD ?informationObject subClassOf InformationObject, "
            + "ADD ?realizationProperty subPropertyOf realizes, ADD ?informationRealization subClassOf PhysicalObject "
            + "and ?realizationProperty some ?informationObject END;\n"
            + "Information Realization Pattern:\n"
            + "?informationRealization ?realizationProperty ?informationObject\n"
            + "	Named pizza pattern";
        parseCorrect(formula, patternedDUL);
    }

    @Test
    public void shouldTestDocumentationScriptDolce2() {
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
        parseCorrect(formula, patternedDUL);
    }

    public void _testDocumentationScriptPizzaRefersPattern() {
        String formula = "?x:CLASS[subClassOf Food]\n"
            + "BEGIN\n"
            + "ADD $thisClass subClassOf Menu,\n"
            + "ADD $thisClass subClassOf contains Course and only ($FreeFromPattern(?x))\n"
            + "END;\n" + "A ?x - free Menu";
        parseCorrect(formula, patternedPizza);
    }

    @Test
    public void shouldTestMultilineError() {
        String formula = "?x:CLASS\n" + "BEGIN\n" + "ADD $thisClass sub_ClassOf Menu\n"
            + "END;\n" + "A ?x  free Menu";
        parseWrong(formula, patternedPizza,
            new AbstractExpectedErrorCheckerErrorListener());
    }

    @Test
    public void shouldTestParseMissingQuery() {
        OPPLScript result = this.parsePattern(
            "?island:INDIVIDUAL BEGIN ADD Asinara InstanceOf Country END;", test);
        expectedCorrect(result);
        this.execute(result, 0);
        String script = "?island:INDIVIDUAL BEGIN REMOVE Asinara InstanceOf Country END;";
        parseWrong(script, test, new AbstractExpectedErrorCheckerErrorListener());
        this.execute(result, 0);
    }
}
