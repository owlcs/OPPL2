package org.coode.parsers.oppl.test;

import static org.coode.oppl.Ontologies.*;
import static org.junit.Assert.*;

import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.semanticweb.owlapi.model.OWLOntology;

@SuppressWarnings("javadoc")
public class OPPLScriptExtendedParserTest {
    public void testRoundTripSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, syntax, null,
                getOPPLSymbolTable(syntax));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        assertEquals("parsed content:  \t", parsed.getOPPLContent());
        query = parsed.getOPPLContent().toString();
        parsed = OPPLScriptTypesParserTest.parse(query, syntax, null,
                getOPPLSymbolTable(syntax));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
    }

    public void testRegexp() {
        String query = "?regexp:CLASS=MATCH(\"([A-Z]+)izza\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing WHERE ?regexp MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?x subClassOf ?regexp END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, syntax, null,
                getOPPLSymbolTable(syntax));
        System.out.println(parsed.toStringTree());
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        System.out.println(parsed.getOPPLContent().toString());
    }

    public void testOld0() {
        this.tester("?x:CLASS, ?y:CLASS SELECT ?x subClassOf Pizza, ?y subClassOf Pizza WHERE ?x != ?y BEGIN ADD ?x disjointWith ?y END;");
    }

    public void testOld1() {
        this.tester("?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Thing  BEGIN ADD ?x subClassOf ?y END;");
    }

    public void testOld2() {
        this.tester("?y:CLASS, ?k:CONSTANT=create(\"mytest\"), ?x:CLASS=create(\"Test\"+?k.RENDERING) SELECT ?y subClassOf Pizza BEGIN ADD ?x subClassOf ?y END;");
    }

    public void testOld3() {
        this.tester("?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;");
    }

    public void testOld4() {
        this.tester("?y:CLASS, ?x:CLASS=create(\"test and \"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;");
    }

    public void testOld5() {
        this.tester("?regexp:CLASS=MATCH(\"([A-Z]+)izza\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Thing WHERE ?regexp MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?x subClassOf ?regexp END;");
    }

    public void testOld6() {
        this.tester("?y:CLASS SELECT ?y subClassOf Food WHERE ?y MATCH(\"(([A-Z]+))izza\") BEGIN ADD ?y subClassOf Thing END;");
    }

    public void testOld8() {
        this.tester("SELECT America InstanceOf Country BEGIN REMOVE America InstanceOf Pizza END;");
    }

    public void testOld12() {
        this.tester("SELECT America InstanceOf Country BEGIN ADD America InstanceOf Thing END;");
    }

    public void testOld13() {
        testerExpectFail("SELECT America InstanceOf Pais BEGIN ADD Am InstanceOf Pizza END;");
    }

    public void testOld14() {
        this.tester("?Chunk:CLASS SELECT ?Chunk subClassOf Thing BEGIN ADD ?Chunk subClassOf Pizza END;");
    }

    public void testOld15() {
        this.tester("?regexp:CLASS=MATCH(\"(Piz)za\"), ?x:CLASS=create(?regexp.GROUPS(1)) SELECT ?regexp subClassOf Food WHERE ?regexp MATCH(\"(Piz)za\")  BEGIN ADD ?x subClassOf Food END;");
    }

    public void testOld16() {
        this.tester("?y:CLASS, ?x:CLASS=create(\"Test\"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?x subClassOf ?y END;");
    }

    public void testOld17() {
        this.tester("?y:CLASS, ?x:CLASS=create(\"test \"+?y.RENDERING) SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;");
    }

    public void testOld18() {
        this.tester("?y:CLASS, ?x:CLASS=create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y subClassOf Pizza  BEGIN ADD ?y subClassOf ?x END;");
    }

    public void testOld19() {
        this.tester("?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"(([\\w]*))Pizza\") BEGIN ADD ?island subClassOf Thing END;");
    }

    public void testOld20() {
        this.tester("?island:CLASS SELECT ?island subClassOf Thing WHERE ?island MATCH(\"[A-Z][a-z]+Topping\") BEGIN ADD ?island subClassOf Thing END;");
    }

    public void testOld21() {
        this.tester("?x:CLASS, ?y:CLASS=MATCH(\"[Pizza]+\"+?x.RENDERING) SELECT ?y subClassOf Food, ?x subClassOf Thing WHERE ?y MATCH(\"[Piza]+\"+?x.RENDERING) BEGIN ADD ?y subClassOf Thing END;");
    }

    public void tester(String query) {
        this.tester(query, syntax);
    }

    public void tester(String query, OWLOntology ontology) {
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, ontology, null,
                getOPPLSymbolTable(ontology));
        assertNotNull(parsed);
        assertNotNull(query, parsed.getOPPLContent());
        assertEquals("parsed content:  \t", parsed.getOPPLContent());
    }

    public void testerExpectFail(String query) {
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, syntax, null,
                getOPPLSymbolTable(syntax));
        assertNotNull(parsed);
        assertNull(query, parsed.getOPPLContent());
    }
}
