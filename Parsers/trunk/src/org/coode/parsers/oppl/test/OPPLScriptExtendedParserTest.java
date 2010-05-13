package org.coode.parsers.oppl.test;

import org.coode.oppl.utils.ParserFactory;
import org.coode.parsers.oppl.OPPLSyntaxTree;

public class OPPLScriptExtendedParserTest extends OPPLScriptTypesParserTest {
	public void testRoundTripSubClassQuery() {
		String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
		OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
		System.out.println("original script: \t" + query);
		System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		query = parsed.getOPPLContent().toString();
		parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
	}

	public void testRegexp() {
		String query = "?regexp:CLASS=MATCH(\"([A-Z]+)izza\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing WHERE ?regexp MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?x subClassOf ?regexp END;";
		OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
		System.out.println(parsed.toStringTree());
		assertNotNull(parsed);
		assertNotNull(parsed.getOPPLContent());
	}

	String[] queries = new String[] {
			"?x:CLASS, ?y:CLASS SELECT ?x subClassOf Pizza, ?y subClassOf Pizza WHERE ?x != ?y BEGIN ADD ?x disjointWith ?y END;",
			"?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Thing  BEGIN ADD ?x subClassOf ?y END;",
			"?y:CLASS, ?k:CONSTANT=create(\"mytest\"), ?x:CLASS=create(\"Test\"+?k.RENDERING) SELECT ?y subClassOf Pizza BEGIN ADD ?x subClassOf ?y END;",
			"?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;",
			"?y:CLASS, ?x:CLASS=create(\"test and \"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;",
			"?regexp:CLASS=MATCH(\"([A-Z]+)izza\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing WHERE ?regexp MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?x subClassOf ?regexp END;",
			"?y:CLASS SELECT ?y subClassOf Food WHERE ?y MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?y subClassOf Thing END;",
			// "?island:CLASS=MATCH(\"(Pizza)\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(1)) BEGIN ADD ?newIsland subClassOf ?island END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN ADD MargheritaPizza InstanceOf Thing END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN REMOVE MargheritaPizza InstanceOf Pizza END;",
			"?island:INDIVIDUAL BEGIN ADD MargheritaPizza InstanceOf Pizza END;",
			"?island:INDIVIDUAL BEGIN REMOVE MargheritaPizza InstanceOf Pizza END;",
			"BEGIN ADD MargheritaPizza InstanceOf Pizza END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN ADD MargheritaPizza InstanceOf Pizza END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN ADD Margh InstanceOf Pizza END;",
			"?Chunk:CLASS SELECT ?Chunk subClassOf Thing BEGIN ADD ?Chunk subClassOf Pizza END;",
			"?regexp:CLASS=MATCH(\"(Piz)za\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Food WHERE ?regexp MATCH(\"(Piz)za\")  BEGIN ADD ?x subClassOf Food END;",
			"?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?x subClassOf ?y END;",
			"?y:CLASS, ?x:CLASS=create(\"test \"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;",
			"?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;",
			"?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"[A-Z][a-z]+Topping\") BEGIN ADD ?island subClassOf Thing END;",
			"?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"(([\\w]*))Pizza\") BEGIN ADD ?island subClassOf Thing END;",
			"?x:CLASS, ?y:CLASS=MATCH(\"[Piza]+\"+?x.RENDERING) SELECT ?y subClassOf Food, ?x subClassOf Thing WHERE ?y MATCH(\"[Piza]+\"+?x.RENDERING) BEGIN ADD ?y subClassOf Thing END;" };

	public void testOld0() {
		tester(queries[0]);
	}

	public void testOld1() {
		tester(queries[1]);
	}

	public void testOld2() {
		tester(queries[2]);
	}

	public void testOld3() {
		tester(queries[3]);
	}

	public void testOld4() {
		tester(queries[4]);
	}

	public void testOld5() {
		tester(queries[5]);
	}

	public void testOld6() {
		tester(queries[6]);
	}

	public void testOld7() {
		tester(queries[7]);
	}

	public void testOld8() {
		tester(queries[8]);
	}

	public void testOld9() {
		tester(queries[9]);
	}

	public void testOld10() {
		tester(queries[10]);
	}

	public void testOld11() {
		tester(queries[11]);
	}

	public void testOld12() {
		tester(queries[12]);
	}

	public void testOld13() {
		tester(queries[13]);
	}

	public void testOld14() {
		tester(queries[14]);
	}

	public void testOld15() {
		tester(queries[15]);
	}

	public void testOld16() {
		tester(queries[16]);
	}

	public void testOld17() {
		tester(queries[17]);
	}

	public void testOld18() {
		tester(queries[18]);
	}

	public void testOld19() {
		tester(queries[19]);
	}

	public void testOld20() {
		tester(queries[20]);
	}

	public void testOld21() {
		tester(queries[21]);
	}

	public void tester(String query) {
		try {
			OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
			System.out.println(parsed.toStringTree());
			assertNotNull(parsed);
			assertNotNull(query, parsed.getOPPLContent());
			System.out.println("original script: \t" + query);
			System.out.println("parsed content:  \t" + parsed.getOPPLContent());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			fail();
		}
	}
}
