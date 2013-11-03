package org.coode.patterns.test;

public class BrokenTest extends AbstractPatternTestCase {
	public void testSpaces() {
		String formula = "?y:CLASS=create(\"face\"), ?x:CLASS = create(\"'test and \" + ?y.RENDERING+ \"'\") BEGIN ADD $thisClass subClassOf ?x END;";
		this.parseCorrect(formula, this.getOntology("food.owl"));
	}
}
