package org.coode.patterns.test;

public class PerformanceTest extends ExhaustingPatternTest {
	public void testPerformance() {
		String string = "?element:CLASS,?exposedSubElement:CLASS,?hiddenSubElement:CLASS,?exposedFeature:CLASS,?hiddenFeature:CLASS,?quantity:CLASS,\n"
				+ "?hasExposedSubElement:CLASS = OWLObjectProperty_01241019394335806000 some ?exposedSubElement,"
				+ "?hasHiddenSubElement:CLASS = OWLObjectProperty_01241019337607959000 some ?hiddenSubElement,"
				+ "?hasExposedFeature:CLASS = OWLObjectProperty_01241018787395832000 some ?exposedFeature,"
				+ "?hasHiddenFeature:CLASS = OWLObjectProperty_01241019324612330000 some ?hiddenFeature,"
				+ "?hasQuantity:CLASS = OWLObjectProperty_01237305548139854000 some ?quantity,"
				+ "?allExposedSubElements:CLASS = createIntersection(?hasExposedSubElement . VALUES ),"
				+ "?allHiddenSubElements:CLASS = createIntersection(?hasHiddenSubElement . VALUES ),"
				+ "?allExposedFeatures:CLASS = createIntersection(?hasExposedFeature . VALUES ),"
				+ "?allHiddenFeatures:CLASS = createIntersection(?hasHiddenFeature . VALUES ),"
				+ "?allQuantities:CLASS = createIntersection(?hasQuantity . VALUES )\n"
				+ "BEGIN\n"
				+ "ADD $thisClass equivalentTo ?element and ?allExposedSubElements and ?allHiddenSubElements and ?allExposedSubElements and ?allExposedFeatures and ?allHiddenFeatures and ?allQuantities\n"
				+ "END;";
		long start = System.currentTimeMillis();
		parseCorrect(string, getOntology("AnnotatedSiemensStart.owl"));
		System.out.println("PerformanceTest.testPerformance() elapsed: "
				+ (System.currentTimeMillis() - start));
	}

	public static void main(String[] args) throws Exception {
		PerformanceTest p = new PerformanceTest();
		p.setUp();
		p.testPerformance();
		p.tearDown();
	}
}
