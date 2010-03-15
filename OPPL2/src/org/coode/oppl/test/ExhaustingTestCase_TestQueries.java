package org.coode.oppl.test;

import org.coode.oppl.OPPLScript;

public class ExhaustingTestCase_TestQueries extends AbstractTestCase {
	public void testRegExp() {
		OPPLScript result = this.parse("?island:CLASS=Match(\"[iI]sland\");");
		this.expectedCorrect(result);
		this.execute(result);
		result = this.parse("?island:CLASS=Match(\"[iI]s*land\");");
		this.expectedCorrect(result);
		this.execute(result);
		//		result = this.parse("?island:CLASS=Match(\"[iI]s**land\");");
		//
		//		assertNull("the reg expr is broken, should not be allowed", result);
		//		this.checkProperStackTrace("Encountered [iI]s**land", 22);
	}

	public void testRegExpGroupUse() {
		OPPLScript result = this
				.parse("?island:CLASS=Match(\"([iI]sland)\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(0)) BEGIN ADD ?newIsland subClassOf ?island END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testAssembleVariables() {
		OPPLScript result = this
				.parse("?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ASSERTED ?y subClassOf Island  BEGIN ADD ?x subClassOf ?y END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testAssembleVariablesConstants() {
		OPPLScript result = this
				.parse("?y:CLASS, ?k:CONSTANT=create(\"mytest\"), ?x:CLASS=create(\"Test\"+?k.RENDERING) SELECT ASSERTED ?y subClassOf Island  BEGIN ADD ?x subClassOf ?y END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testAssembleConstantVariables() {
		OPPLScript result = this
				.parse("?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ASSERTED ?y subClassOf Island  BEGIN ADD ?y subClassOf ?x END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testAssembleConstantAndVariables() {
		OPPLScript result = this
				.parse("?y:CLASS, ?x:CLASS=create(\"'test and \"+?y.RENDERING+\"'\") SELECT ASSERTED ?y subClassOf Island  BEGIN ADD ?y subClassOf ?x END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testReverseRegularExpressions() {
		OPPLScript result = this
				.parse("?regexp:CLASS=Match(\"(([a-z]+))Division\"), "
						+ "?x:CLASS=create(?regexp.GROUPS(1)) "
						+ "SELECT ?regexp subClassOf Thing WHERE ?regexp Match(\"(([a-z]+))Division\") "
						+ "BEGIN ADD ?x subClassOf ?regexp END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testReverseRegularExpressions_() {
		OPPLScript result = this
				.parse("?y:CLASS SELECT ?y subClassOf Thing WHERE ?y Match(\"(([a-z]+))Division\") BEGIN ADD ?y subClassOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testAssembleRegExpVariables() {
		OPPLScript result = this
				.parse("?x:CLASS, ?y:CLASS=Match(\"[abc ]*\"+?x.RENDERING) SELECT ?y subClassOf Thing, ?x subClassOf Thing WHERE ?y Match(\"[abc ]*\"+?x.RENDERING)BEGIN ADD ?y subClassOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result);
	}

	public void testRegExpConstraints() {
		String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(";
		OPPLScript result = this
				.parse(correct
						+ " \"(([\\w]*))Island\") BEGIN ADD ?island subClassOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result);
		//		result = this.parse(correct + " \"Is**land\");");
		//		assertNull("the reg expr is broken, should not be allowed", result);
		//		this.checkProperStackTrace("Encountered Is**land", correct.length());
	}

	public void testRegExpGroupConstraints() {
		String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"([a-zA-Z])*[Ii](sl)*(and)*\") BEGIN ADD ?island subClassOf Thing END;";
		OPPLScript result = this.parse(correct);
		this.expectedCorrect(result);
		this.execute(result);
	}

	public static void main(String[] args) {
		new ExhaustingTestCase_TestQueries().testReverseRegularExpressions_();
	}
}
