package org.coode.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.test;

import org.coode.oppl.OPPLScript;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ExhaustingTestCase_TestQueries extends AbstractTestCase {
    @Test
    public void shouldTestRegExpGroupUse() {
        OPPLScript result = this
                .parse("?island:CLASS=Match(\"[A-Za-z]*(Fragment)\"),\n"
                        + "?newIsland:CLASS=create(\"Test\"+?island.GROUPS(1)) \n"
                        + "SELECT ?island subClassOf Fragment  WHERE ?island Match(\"[A-Za-z]*(Fragment)\")\n"
                        + "BEGIN \n" + "ADD ?newIsland subClassOf ?island\n" + "END;",
                        test);
        expectedCorrect(result);
        execute(result, 4);
    }

    @Test
    public void shouldTestAssembleVariables() {
        OPPLScript result = this
                .parse("?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Thing  BEGIN ADD ?x subClassOf ?y END;",
                        test);
        expectedCorrect(result);
        execute(result, 8);
    }

    @Test
    public void shouldTestAssembleVariablesConstants() {
        OPPLScript result = this
                .parse("?y:CLASS, ?k:CONSTANT=create(\"mytest\"), ?x:CLASS=create(\"Test\"+?k.RENDERING) SELECT ?y subClassOf Country BEGIN ADD ?x subClassOf ?y END;",
                        test);
        expectedCorrect(result);
        execute(result, 2);
    }

    @Test
    public void shouldTestAssembleConstantVariables() {
        OPPLScript result = this
                .parse("?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Country  BEGIN ADD ?y subClassOf ?x END;",
                        test);
        expectedCorrect(result);
        execute(result, 2);
    }

    @Test
    public void shouldTestAssembleConstantAndVariables() {
        OPPLScript result = this
                .parse("?y:CLASS, ?x:CLASS=create(\"test and \"+?y.RENDERING) SELECT ?y subClassOf Country  BEGIN ADD ?y subClassOf ?x END;",
                        test);
        expectedCorrect(result);
        execute(result, 2);
    }

    @Test
    public void shouldTestReverseRegularExpressions() {
        OPPLScript result = this
                .parse("?regexp:CLASS=Match(\"([a-z]+)Division\"), "
                        + "?x:CLASS=create(?regexp.GROUPS(1)) "
                        + "SELECT ?regexp subClassOf Thing WHERE ?regexp Match(\"(([a-z]+))Division\") "
                        + "BEGIN ADD ?x subClassOf ?regexp END;", test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestReverseRegularExpressions_() {
        OPPLScript result = this
                .parse("?y:CLASS SELECT ?y subClassOf Thing WHERE ?y Match(\"(([a-z]+))Division\") BEGIN ADD ?y subClassOf Thing END;",
                        test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestAssembleRegExpVariables() {
        OPPLScript result = this
                .parse("?x:CLASS, ?y:CLASS=Match(\"[abc ]*\"+?x.RENDERING) SELECT ?y subClassOf Thing, ?x subClassOf Thing WHERE ?y Match(\"[abc ]*\"+?x.RENDERING)BEGIN ADD ?y subClassOf Thing END;",
                        test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestRegExpConstraints() {
        String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(";
        OPPLScript result = this.parse(correct
                + " \"(([\\w]*))Island\") BEGIN ADD ?island subClassOf Thing END;", test);
        expectedCorrect(result);
        execute(result, 0);
        // result = this.parse(correct + " \"Is**land\");");
        // assertNull("the reg expr is broken, should not be allowed", result);
        // this.checkProperStackTrace("Encountered Is**land", correct.length());
    }

    @Test
    public void shouldTestRegExpGroupConstraints() {
        String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"[A-Z][a-z]+Fragment\") BEGIN ADD ?island subClassOf Thing END;";
        OPPLScript result = this.parse(correct, test);
        expectedCorrect(result);
        execute(result, 1);
    }
}
