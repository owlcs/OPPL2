package org.coode.parsers.oppl.test;

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
			"?y:CLASS SELECT ?y subClassOf Thing WHERE ?y MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?y subClassOf Thing END;",
			"?x:CLASS, ?y:CLASS=MATCH(\"[Piza]+\"+?x.RENDERING) SELECT ?y subClassOf Thing, ?x subClassOf Thing WHERE ?y MATCH(\"[Piza]+\"+?x.RENDERING) BEGIN ADD ?y subClassOf Thing END;",
			"?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"(([\\w]*))Pizza\") BEGIN ADD ?island subClassOf Thing END;",
			"?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"[A-Z][a-z]+Topping\") BEGIN ADD ?island subClassOf Thing END;",
			// "?island:CLASS=MATCH(\"(Pizza)\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(1)) BEGIN ADD ?newIsland subClassOf ?island END;",
			"?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?x subClassOf ?y END;",
			"?y:CLASS, ?x:CLASS=create(\"test \"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;",
			"?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;",
			"?regexp:CLASS=MATCH(\"'test ([a-z]+)'\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing  BEGIN ADD ?x subClassOf Thing END;",
			"?x:CLASS, ?y:CLASS=MATCH(\"'abc \"+?x.RENDERING+\"'\") SELECT ?y subClassOf Thing BEGIN ADD ?y subClassOf Thing END;",
			"?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"([a-zA-Z])*[Pp](iz)*(za)*\") BEGIN ADD ?island subClassOf Thing END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN ADD MargheritaPizza InstanceOf Thing END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN REMOVE MargheritaPizza InstanceOf Pizza END;",
			"?island:INDIVIDUAL BEGIN ADD MargheritaPizza InstanceOf Pizza END;",
			"?island:INDIVIDUAL BEGIN REMOVE MargheritaPizza InstanceOf Pizza END;",
			"BEGIN ADD MargheritaPizza InstanceOf Pizza END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN ADD MargheritaPizza InstanceOf Pizza END;",
			"SELECT MargheritaPizza InstanceOf Pizza BEGIN ADD Margh InstanceOf Pizza END;",
			"?Chunk:CLASS SELECT ?Chunk subClassOf Thing BEGIN ADD ?Chunk subClassOf Pizza END;" };

	public void testOldQueries() {
		for (String query : this.queries) {
			System.out.println("query: " + query);
			boolean ok = true;
			try {
				OPPLSyntaxTree parsed = this.parse(query, SYNTAX_ONTOLOGY);
				System.out.println(parsed.toStringTree());
				assertNotNull(parsed);
				assertNotNull(query, parsed.getOPPLContent());
				System.out.println("original script: \t" + query);
				System.out.println("parsed content:  \t"
						+ parsed.getOPPLContent());
			} catch (Exception e) {
				ok = false;
				e.printStackTrace(System.out);
			}
			if (ok) {
				System.out.println("OK");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		OPPLScriptExtendedParserTest t = new OPPLScriptExtendedParserTest();
		t.setUp();
		t.testOldQueries();
		t.tearDown();
	}
}
