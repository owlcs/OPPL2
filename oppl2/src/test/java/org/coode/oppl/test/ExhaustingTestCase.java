package org.coode.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.*;
import static org.junit.Assert.*;

import java.util.List;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ExhaustingTestCase extends AbstractTestCase {
    @Test
    public void shouldTestParseMissingVariableDeclaration() {
        OPPLScript result = this
                .parse("SELECT Asinara InstanceOf Country BEGIN ADD Asinara InstanceOf Thing END;",
                        test);
        expectedCorrect(result);
        execute(result, 1);
        result = this
                .parse("SELECT Asinara InstanceOf Country BEGIN REMOVE Asinara InstanceOf Country END;",
                        test);
        expectedCorrect(result);
        execute(result, 1);
    }

    @Test
    public void shouldTestParseActionsError() {
        OPPLScript result = this
                .parse("SELECT Asinara InstanceOf Country BEGIN ADD Asinara InstanceOf Country END;",
                        test);
        expectedCorrect(result);
        execute(result, 1);
        String correctPortion = "SELECT Asinara InstanceOf Country BEGIN ADD ";
        String script = correctPortion + "Asin InstanceOf Country END;";
        result = this.parse(script, test);
        assertNull(result);
        // XXX it appears the parser digests some exceptions without throwing
        // them
        // checkProperStackTrace("Encountered Asin at line 1 column ",
        // correctPortion.length());
    }

    @Test
    public void shouldTestParseVariableDeclarationAdvancedErrors() {
        String correctPortion = "?island:";
        String script = correctPortion + "INDIVIDUAL_;";
        OPPLScript result = this.parse(script, test);
        assertNull(result);
        // reportUnexpectedStacktrace(popStackTrace());
        // XXX it appears the parser digests some exceptions without throwing
        // them
        // checkProperStackTrace(
        // "Encountered \" <ENTITYNAMES> \"INDIVIDUAL_ \"\" at line 1, column ",
        // correctPortion.length());
        correctPortion = "?someClass:INDIVIDUAL[";
        result = this
                .parse(correctPortion
                        + "subClassOf Country], ?island:CLASS=CreateIntersection(?someClass.VALUES);",
                        test);
        assertNull(result);
        // checkProperStackTrace(
        // "Type mismatch for variable ?someClass: type CLASS needed instead of the actual INDIVIDUAL",
        // correctPortion.length());
        correctPortion = "?island:INDIVIDUAL=";
        script = correctPortion + "createe(\"TestIndividual\");";
        result = this.parse(script, test);
        assertNull(result);
        // checkProperStackTrace("Encountered createe at line 1 column ",
        // correctPortion.length());
        correctPortion = "?someClass:CLASS[subClassOf ";
        script = correctPortion
                + "__Country], ?island:CLASS=CreateUnion(?someClass.VALUES);";
        result = this.parse(script, test);
        assertNull(result);
        // checkProperStackTrace("Encountered __Country at line 1 column ",
        // correctPortion.length());
        correctPortion = "?island:CLASS[subClassOf hasHeight";
        result = this.parse(correctPortion + "];", test);
        assertNull(result);
        // checkProperStackTrace("Encountered <EOF> at line 1 column ",
        // correctPortion.length());
        correctPortion = "?test:OBJECTPROPERTY[subPropertyOf ";
        result = this.parse(correctPortion + "hasHeight];", test);
        assertNull("hasHeight is a datatype property, should not be allowed", result);
        // checkProperStackTrace("Encountered hasHeight at line 1 column ",
        // correctPortion.length());
    }

    @Test
    public void shouldTestParseWhereClauses() {
        OPPLScript result = this
                .parse("?island:INDIVIDUAL SELECT ?island InstanceOf Country WHERE ?island != Asinara BEGIN ADD ?island InstanceOf Country END;",
                        test);
        expectedCorrect(result);
        execute(result, 0);
        result = this
                .parse("?island:INDIVIDUAL SELECT ?island InstanceOf Country WHERE ?island IN {Asinara} BEGIN ADD ?island InstanceOf Country END;",
                        test);
        expectedCorrect(result);
        execute(result, 1);
    }

    @Test
    public void shouldTestAssembleVariables() {
        OPPLScript result = this
                .parse("?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Country  BEGIN ADD ?x subClassOf ?y END;",
                        test);
        expectedCorrect(result);
        execute(result, 2);
    }

    @Test
    public void shouldTestAssembleConstantVariables() {
        OPPLScript result = this
                .parse("?y:CLASS, ?x:CLASS=create(\"test \"+?y.RENDERING) SELECT ?y subClassOf Country  BEGIN ADD ?y subClassOf ?x END;",
                        test);
        expectedCorrect(result);
        execute(result, 2);
    }

    @Test
    public void shouldTestAssembleConstantAndVariables() {
        OPPLScript result = this
                .parse("?y:CLASS, ?x:CLASS=create(\"'test and \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Country  BEGIN ADD ?y subClassOf ?x END;",
                        test);
        expectedCorrect(result);
        execute(result, 2);
    }

    @Test
    public void shouldTestReverseRegularExpressions() {
        OPPLScript result = this
                .parse("?regexp:CLASS=Match(\"'test ([a-z]+)'\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing  BEGIN ADD ?x subClassOf Thing END;",
                        test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestAssembleRegExpVariables() {
        OPPLScript result = this
                .parse("?x:CLASS, ?y:CLASS=Match(\"'abc \"+?x.RENDERING+\"'\") SELECT ?y subClassOf Thing BEGIN ADD ?y subClassOf Thing END;",
                        test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestRegExpConstraints() {
        String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"Island\") BEGIN ADD ?island subClassOf Thing END;";
        OPPLScript result = this.parse(correct, test);
        expectedCorrect(result);
        execute(result, 0);
        // result = this.parse(correct + " \"Is**land\");");
        // assertNull("the reg expr is broken, should not be allowed", result);
        // this.checkProperStackTrace("Encountered Is**land", correct.length());
    }

    @Test
    public void shouldTestRegExpGroupConstraints() {
        String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"([a-zA-Z])*[Ii](sl)*(and)*\") BEGIN ADD ?island subClassOf Thing END;";
        OPPLScript result = this.parse(correct, test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestClassNameSameAsVariable() {
        String script = "?Chunk:CLASS SELECT ?Chunk subClassOf Thing BEGIN ADD ?Chunk subClassOf Country END;";
        OPPLScript result = this.parse(script, test);
        expectedCorrect(result);
        execute(result, 8);
    }

    @Test
    public void shouldTestRobertsScripts1() {
        String script = "?island:INDIVIDUAL[instanceOf Country],\n"
                + "?height:CONSTANT\n" + "SELECT ?island size ?height\n" + "BEGIN\n"
                + " 	REMOVE ?island size ?height,\n"
                + " 	ADD ?island !hasMaximumHeight ?height\n" + "END;";
        OPPLScript result = this.parse(script, test);
        expectedCorrect(result);
        execute(result, 0);
    }

    @Test
    public void shouldTestNAF() {
        String script = "?x:CLASS,?y:CLASS,?z:CLASS = MATCH(\"A_\"+?x.RENDERING) SELECT ?x subClassOf A, ?x subClassOf hasP some ?y,?z subClassOf  A_A WHERE FAIL ?z subClassOf hasP some ?y BEGIN ADD ?z subClassOf hasP some ?y END;";
        OPPLScript opplScript = this.parse(script, naf, null);
        assertNotNull(opplScript);
        List<Variable<?>> variables = opplScript.getVariables();
        assertEquals(3, variables.size());
        for (Variable<?> variable : variables) {
            if (variable.getName().compareTo("?z") == 0) {
                assertTrue(variable instanceof RegexpGeneratedVariable<?>
                        && variable.getType() == VariableTypeFactory
                                .getCLASSVariableType());
            }
        }
    }

    @Test
    public void shouldTestComplexRestrictionInQuery() {
        String script = "?x:CLASS SELECT ?x subClassOf  Pizza and hasTopping some (Thing and hasTopping some (hasBase some Thing)) BEGIN ADD ?x subClassOf Thing END;";
        OPPLScript opplScript = this.parse(script, pizza, null);
        assertNotNull(opplScript);
        List<Variable<?>> variables = opplScript.getVariables();
        assertEquals(1, variables.size());
    }
}
