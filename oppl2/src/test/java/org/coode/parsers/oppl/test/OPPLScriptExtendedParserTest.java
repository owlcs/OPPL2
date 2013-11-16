package org.coode.parsers.oppl.test;

import static org.coode.oppl.testontologies.TestOntologies.pizza;
import static org.coode.parsers.oppl.test.SymbolTables.getOPPLSymbolTable;
import static org.junit.Assert.*;

import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;

@SuppressWarnings("javadoc")
public class OPPLScriptExtendedParserTest {
    @Test
    public void shouldTestRoundTripSubClassQuery() {
        String query = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, pizza, null,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        Object opplContent = parsed.getOPPLContent();
        assertNotNull(opplContent);
        String string = opplContent.toString();
        assertEquals("?x:CLASS SELECT ?x SubClassOf Thing\n"
                + " BEGIN ADD ?x SubClassOf Thing END;", string);
        query = string;
        parsed = OPPLScriptTypesParserTest.parse(query, pizza, null,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        assertNotNull(opplContent);
    }

    @Test
    public void shouldTestRegexp() {
        String query = "?regexp:CLASS=MATCH(\"([A-Z]+)izza\"), ?x:CLASS=create(?regexp.GROUPS(1)) "
                + "SELECT ?regexp SubClassOf Thing WHERE ?regexp MATCH(\"(([A-Z]+))izza\") "
                + "BEGIN ADD ?x SubClassOf ?regexp END;";
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, pizza, null,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        assertEquals(
                "?regexp:CLASS= MATCH (\"([A-Z]+)izza\"), ?x:CLASS = create(?regexp.GROUPS(1)) SELECT ?regexp SubClassOf Thing\n"
                        + " WHERE ?regexp Match(\"(([A-Z]+))izza\")\n"
                        + " BEGIN ADD ?x SubClassOf ?regexp END;", parsed
                        .getOPPLContent().toString());
    }

    @Test
    public void shouldTestOld6() {
        tester("?y:CLASS SELECT ?y SubClassOf DomainConcept\n"
                + " WHERE ?y Match(\"(([A-Z]+))izza\")\n"
                + " BEGIN ADD ?y SubClassOf Thing END;", pizza);
    }

    @Test
    public void shouldTestOld0() {
        tester("?x:CLASS, ?y:CLASS SELECT ?x SubClassOf Pizza,\n"
                + "?y SubClassOf Pizza\n" + " WHERE ?x != ?y\n"
                + " BEGIN ADD ?x DisjointWith ?y END;", pizza);
    }

    @Test
    public void shouldTestOld1() {
        tester("?y:CLASS, ?x:CLASS = create(\"Test\"+?y.RENDERING) SELECT ?y SubClassOf Thing\n"
                + " BEGIN ADD ?x SubClassOf ?y END;", pizza);
    }

    @Test
    public void shouldTestOld2() {
        tester("?y:CLASS, ?k:CONSTANT = create(\"mytest\"), ?x:CLASS = create(\"Test\"+?k.RENDERING) SELECT ?y SubClassOf Pizza\n"
                + " BEGIN ADD ?x SubClassOf ?y END;", pizza);
    }

    @Test
    public void shouldTestOld3() {
        tester("?y:CLASS, ?x:CLASS = create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y SubClassOf Pizza\n"
                + " BEGIN ADD ?y SubClassOf ?x END;", pizza);
    }

    @Test
    public void shouldTestOld4() {
        tester("?y:CLASS, ?x:CLASS = create(\"test and \"+?y.RENDERING) SELECT ?y SubClassOf Pizza\n"
                + " BEGIN ADD ?y SubClassOf ?x END;", pizza);
    }

    @Test
    public void shouldTestOld5() {
        tester("?regexp:CLASS= MATCH (\"([A-Z]+)izza\"), ?x:CLASS = create(?regexp.GROUPS(1)) SELECT ?regexp SubClassOf Thing\n"
                + " WHERE ?regexp Match(\"(([A-Z]+))izza\")\n"
                + " BEGIN ADD ?x SubClassOf ?regexp END;", pizza);
    }

    @Test
    public void shouldTestOld8() {
        tester("SELECT America Type Country\n" + " BEGIN REMOVE America Type Pizza END;",
                pizza);
    }

    @Test
    public void shouldTestOld12() {
        tester("SELECT America Type Country\n" + " BEGIN ADD America Type Thing END;",
                pizza);
    }

    @Test
    public void shouldTestOld13() {
        shouldTesterExpectFail("SELECT America InstanceOf Pais "
                + "BEGIN ADD Am InstanceOf Pizza END;", pizza);
    }

    @Test
    public void shouldTestOld14() {
        tester("?Chunk:CLASS SELECT ?Chunk SubClassOf Thing\n"
                + " BEGIN ADD ?Chunk SubClassOf Pizza END;", pizza);
    }

    @Test
    public void shouldTestOld15() {
        tester("?regexp:CLASS= MATCH (\"(Piz)za\"), ?x:CLASS = create(?regexp.GROUPS(1)) SELECT ?regexp SubClassOf DomainConcept\n"
                + " WHERE ?regexp Match(\"(Piz)za\")\n"
                + " BEGIN ADD ?x SubClassOf DomainConcept END;", pizza);
    }

    @Test
    public void shouldTestOld16() {
        tester("?y:CLASS, ?x:CLASS = create(\"Test\"+?y.RENDERING) SELECT ?y SubClassOf Pizza\n"
                + " BEGIN ADD ?x SubClassOf ?y END;", pizza);
    }

    @Test
    public void shouldTestOld17() {
        tester("?y:CLASS, ?x:CLASS = create(\"test \"+?y.RENDERING) SELECT ?y SubClassOf Pizza\n"
                + " BEGIN ADD ?y SubClassOf ?x END;", pizza);
    }

    @Test
    public void shouldTestOld18() {
        tester("?y:CLASS, ?x:CLASS = create(\"'test \"+?y.RENDERING+\"'\") SELECT ?y SubClassOf Pizza\n"
                + " BEGIN ADD ?y SubClassOf ?x END;", pizza);
    }

    @Test
    public void shouldTestOld19() {
        tester("?island:CLASS SELECT ?island SubClassOf Thing\n"
                + " WHERE ?island Match(\"(([\\w]*))Pizza\")\n"
                + " BEGIN ADD ?island SubClassOf Thing END;", pizza);
    }

    @Test
    public void shouldTestOld20() {
        tester("?island:CLASS SELECT ?island SubClassOf Thing\n"
                + " WHERE ?island Match(\"[A-Z][a-z]+Topping\")\n"
                + " BEGIN ADD ?island SubClassOf Thing END;", pizza);
    }

    @Test
    public void shouldTestOld21() {
        tester("?x:CLASS, ?y:CLASS= MATCH (\"[Pizza]+\"+?x.RENDERING) SELECT ?x SubClassOf Thing\n"
                + " WHERE ?y Match(\"[Piza]+\"+?x.RENDERING)\n"
                + " BEGIN ADD ?y SubClassOf Thing END;", pizza);
    }

    public void tester(String query, OWLOntology ontology) {
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, ontology, null,
                getOPPLSymbolTable(ontology));
        assertNotNull(parsed);
        assertNotNull(parsed.getOPPLContent());
        assertEquals(query, parsed.getOPPLContent().toString());
    }

    public void shouldTesterExpectFail(String query, OWLOntology o) {
        OPPLSyntaxTree parsed = OPPLScriptTypesParserTest.parse(query, o, null,
                getOPPLSymbolTable(pizza));
        assertNotNull(parsed);
        assertNull(query, parsed.getOPPLContent());
    }
}
