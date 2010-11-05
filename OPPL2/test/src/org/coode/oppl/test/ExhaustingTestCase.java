package org.coode.oppl.test;

import java.util.List;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.CLASSRegexpGeneratedVariable;

public class ExhaustingTestCase extends AbstractTestCase {
	public void testParseMissingVariableDeclaration() {
		OPPLScript result = this
				.parse("SELECT Asinara InstanceOf Country BEGIN ADD Asinara InstanceOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 1);
		result = this
				.parse("SELECT Asinara InstanceOf Country BEGIN REMOVE Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 1);
	}

	public void testParseActionsError() {
		OPPLScript result = this
				.parse("SELECT Asinara InstanceOf Country BEGIN ADD Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 1);
		String correctPortion = "SELECT Asinara InstanceOf Country BEGIN ADD ";
		String script = correctPortion + "Asin InstanceOf Country END;";
		result = this.parse(script);
		assertNull(result);
		this.checkProperStackTrace("Encountered Asin at line 1 column ",
				correctPortion.length());
	}

	public void testParseVariableDeclarationAdvancedErrors() {
		String correctPortion = "?island:";
		String script = correctPortion + "INDIVIDUAL_;";
		OPPLScript result = this.parse(script);
		assertNull(result);
		// reportUnexpectedStacktrace(popStackTrace());
		this
				.checkProperStackTrace(
						"Encountered \" <ENTITYNAMES> \"INDIVIDUAL_ \"\" at line 1, column ",
						correctPortion.length());
		correctPortion = "?someClass:INDIVIDUAL[";
		result = this
				.parse(correctPortion
						+ "subClassOf Country], ?island:CLASS=CreateIntersection(?someClass.VALUES);");
		assertNull(result);
		this
				.checkProperStackTrace(
						"Type mismatch for variable ?someClass: type CLASS needed instead of the actual INDIVIDUAL",
						correctPortion.length());
		correctPortion = "?island:INDIVIDUAL=";
		script = correctPortion + "createe(\"TestIndividual\");";
		result = this.parse(script);
		assertNull(result);
		this.checkProperStackTrace("Encountered createe at line 1 column ",
				correctPortion.length());
		correctPortion = "?someClass:CLASS[subClassOf ";
		script = correctPortion
				+ "__Country], ?island:CLASS=CreateUnion(?someClass.VALUES);";
		result = this.parse(script);
		assertNull(result);
		this.checkProperStackTrace("Encountered __Country at line 1 column ",
				correctPortion.length());
		correctPortion = "?island:CLASS[subClassOf hasHeight";
		result = this.parse(correctPortion + "];");
		assertNull(result);
		this.checkProperStackTrace("Encountered <EOF> at line 1 column ",
				correctPortion.length());
		correctPortion = "?test:OBJECTPROPERTY[subPropertyOf ";
		result = this.parse(correctPortion + "hasHeight];");
		assertNull("hasHeight is a datatype property, should not be allowed",
				result);
		this.checkProperStackTrace("Encountered hasHeight at line 1 column ",
				correctPortion.length());
	}

	public void testParseWhereClauses() {
		OPPLScript result = this
				.parse("?island:INDIVIDUAL SELECT ?island InstanceOf Country WHERE ?island != Asinara BEGIN ADD ?island InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("?island:INDIVIDUAL SELECT ?island InstanceOf Country WHERE ?island IN {Asinara} BEGIN ADD ?island InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 1);
	}

	public void testAssembleVariables() {
		OPPLScript result = this
				.parse("?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Country  BEGIN ADD ?x subClassOf ?y END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 2);
	}

	public void testAssembleConstantVariables() {
		OPPLScript result = this
				.parse("?y:CLASS, ?x:CLASS=create(\"test \"+?y.RENDERING) SELECT ?y subClassOf Country  BEGIN ADD ?y subClassOf ?x END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 2);
	}

	public void testAssembleConstantAndVariables() {
		OPPLScript result = this
				.parse("?y:CLASS, ?x:CLASS=create(\"'test and \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Country  BEGIN ADD ?y subClassOf ?x END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 2);
	}

	public void testReverseRegularExpressions() {
		OPPLScript result = this
				.parse("?regexp:CLASS=Match(\"'test ([a-z]+)'\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing  BEGIN ADD ?x subClassOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testAssembleRegExpVariables() {
		OPPLScript result = this
				.parse("?x:CLASS, ?y:CLASS=Match(\"'abc \"+?x.RENDERING+\"'\") SELECT ?y subClassOf Thing BEGIN ADD ?y subClassOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testRegExpConstraints() {
		String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"Island\") BEGIN ADD ?island subClassOf Thing END;";
		OPPLScript result = this.parse(correct);
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		// result = this.parse(correct + " \"Is**land\");");
		// assertNull("the reg expr is broken, should not be allowed", result);
		// this.checkProperStackTrace("Encountered Is**land", correct.length());
	}

	public void testRegExpGroupConstraints() {
		String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"([a-zA-Z])*[Ii](sl)*(and)*\") BEGIN ADD ?island subClassOf Thing END;";
		OPPLScript result = this.parse(correct);
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testClassNameSameAsVariable() {
		String script = "?Chunk:CLASS SELECT ?Chunk subClassOf Thing BEGIN ADD ?Chunk subClassOf Country END;";
		OPPLScript result = this.parse(script);
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 8);
	}

	public static void main(String[] args) throws Exception {
		ExhaustingTestCase t = new ExhaustingTestCase();
		t.setUp();
		t.testClassNameSameAsVariable();
	}

	public void testRobertsScripts1() {
		String script = "?island:INDIVIDUAL[instanceOf Country],\n"
				+ "?height:CONSTANT\n" + "SELECT ?island size ?height\n"
				+ "BEGIN\n" + " 	REMOVE ?island size ?height,\n"
				+ " 	ADD ?island !hasMaximumHeight ?height\n" + "END;";
		OPPLScript result = this.parse(script);
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testNAF() {
		String script = "?x:CLASS,?y:CLASS,?z:CLASS = MATCH(\"A_\"+?x.RENDERING) SELECT ?x subClassOf A, ?x subClassOf hasP some ?y,?z subClassOf  A_A WHERE FAIL ?z subClassOf hasP some ?y BEGIN ADD ?z subClassOf hasP some ?y END;";
		OPPLScript opplScript = this.parse(script, "NAF.owl", null);
		assertNotNull(opplScript);
		List<Variable> variables = opplScript.getVariables();
		assertEquals(3, variables.size());
		for (Variable variable : variables) {
			if (variable.getName().compareTo("?z") == 0) {
				assertTrue(variable instanceof CLASSRegexpGeneratedVariable);
			}
		}
	}

	public void testComplexRestrictionInQuery() {
		String script = "?x:CLASS SELECT ?x subClassOf  Pizza and hasTopping some (Thing and hasTopping some (hasBase some Thing)) BEGIN ADD ?x subClassOf Thing END;";
		OPPLScript opplScript = this.parse(script, "pizza.owl", null);
		assertNotNull(opplScript);
		List<Variable> variables = opplScript.getVariables();
		assertEquals(1, variables.size());
	}
}
