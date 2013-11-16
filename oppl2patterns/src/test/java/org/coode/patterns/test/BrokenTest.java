package org.coode.patterns.test;

import static org.coode.oppl.patterntestontologies.PatternTestOntologies.food;

import org.junit.Test;

public class BrokenTest extends AbstractPatternTestCase {
    @Test
    public void shouldTestSpaces() {
        String formula = "?y:CLASS=create(\"face\"), ?x:CLASS = create(\"'test and \" + ?y.RENDERING+ \"'\") BEGIN ADD $thisClass subClassOf ?x END;";
        parseCorrect(formula, food);
    }
}
