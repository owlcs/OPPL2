package org.coode.oppl.test;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQConstants;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.Configuration;
import net.sf.saxon.xqj.SaxonXQDataSource;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.rendering.xquery.XQueryRenderer;
import org.w3c.dom.Document;

public class ExhaustingTestCase extends AbstractTestCase {
	public void testParseAllMissing() {
		// test contained in the static initialization; the script containing
		// only ";" must parse correctly
		OPPLScript result = this.parse(";");
		this.expectedCorrect(result);
	}

	public void testParseMissingVariableDeclaration() {
		OPPLScript result = this
				.parse("SELECT Asinara InstanceOf Country BEGIN ADD Asinara InstanceOf Thing END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("SELECT Asinara InstanceOf Country BEGIN REMOVE Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testParseMissingQuery() {
		OPPLScript result = this
				.parse("?island:INDIVIDUAL BEGIN ADD Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("?island:INDIVIDUAL BEGIN REMOVE Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testParseMissingAction() {
		OPPLScript result = this
				.parse("?island:INDIVIDUAL SELECT Asinara InstanceOf Country;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testParseMissingVariableDeclarationQuery() {
		OPPLScript result = this
				.parse("BEGIN ADD Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testParseMissingVariableDeclarationAction() {
		OPPLScript result = this.parse("SELECT Asinara InstanceOf Country;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testParseMissingQueryAction() {
		OPPLScript result = this.parse("?island:INDIVIDUAL;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testParseVariableDeclarationError() {
		OPPLScript result = this
				.parse("?island:INDIVIDUAL, ?otherIsland:INDIVIDUAL;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		String correctPortion = "?island:INDIVIDUAL, ?otherIsland:";
		String script = correctPortion + "INDIVIDU;";
		result = this.parse(script);
		assertNull(result);
		String expected = "Encountered \" <ENTITYNAMES> \"INDIVIDU \"\" at line 1, column ";
		this.checkProperStackTrace(expected, correctPortion.length());
		correctPortion = "?island:";
		script = correctPortion + "INDIVIDU, ?otherIsland:INDIVIDUAL;";
		result = this.parse(script);
		assertNull(result);
		this.checkProperStackTrace(expected, correctPortion.length());
		correctPortion = "?island:";
		script = correctPortion + "INDIVIDU, ?otherIsland:INDIVIDU;";
		result = this.parse(script);
		assertNull(result);
		this.checkProperStackTrace(expected, correctPortion.length());
	}

	public void testParseQueryError() {
		String correctPortion = "SELECT Asinara InstanceOf Country;";
		OPPLScript result = this.parse(correctPortion);
		this.expectedCorrect(result);
		correctPortion = "SELECT Asinara InstanceOf ";
		String script = correctPortion + "Continental;";
		result = this.parse(script);
		this.checkProperStackTrace("Encountered Continental at line 1 column ",
				correctPortion.length());
		assertNull(result);
		script = correctPortion + "?test;";
		result = this.parse(script);
		this.checkProperStackTrace("Encountered ?test at line 1 column ",
				correctPortion.length());
		assertNull(result);
		// TODO the error is generic, does not mention variables at all; needs
		// to
		// be more detailed
	}

	public void testParseActionsError() {
		OPPLScript result = this
				.parse("SELECT Asinara InstanceOf Country BEGIN ADD Asinara InstanceOf Country END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		String correctPortion = "SELECT Asinara InstanceOf Country BEGIN ADD ";
		String script = correctPortion + "Asin InstanceOf Country END;";
		result = this.parse(script);
		assertNull(result);
		this.checkProperStackTrace("Encountered Asin at line 1 column ",
				correctPortion.length());
	}

	public void testParseVariableDeclarationAdvanced() {
		OPPLScript result = this.parse("?island:INDIVIDUAL;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?island:INDIVIDUAL=create(\"TestIndividual\");");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("?island:INDIVIDUAL=create(\"TestIndividual\"+\"No2\");");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("?someClass:CLASS[subClassOf Country], ?island:CLASS=CreateIntersection(?someClass.VALUES);");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("?someClass:CLASS[subClassOf Country], ?island:CLASS=CreateUnion(?someClass.VALUES);");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?island:INDIVIDUAL[instanceOf Country];");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?island:CLASS[subClassOf Country];");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?test:DATAPROPERTY[subPropertyOf size];");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?test:DATAPROPERTY[superPropertyOf size];");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this
				.parse("?someClass:CLASS[subClassOf Thing], ?island:CLASS=CreateIntersection(?someClass.VALUES);");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?someClass:CLASS[SuperClassOf Country];");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?someIndividual:INDIVIDUAL[instanceOf Thing];");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
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
				.parse("?island:INDIVIDUAL SELECT ?island InstanceOf Country WHERE ?island != Asinara;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 1);
		result = this
				.parse("?island:INDIVIDUAL SELECT ?island InstanceOf Country WHERE ?island IN {Asinara};");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
	}

	public void testRegExp() {
		OPPLScript result = this.parse("?island:CLASS=Match(\"[cC]ountry\");");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		result = this.parse("?island:CLASS=Match(\"[cC]o*untry\");");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		//		result = this.parse("?island:CLASS=Match(\"[iI]s**land\");");
		//
		//		assertNull("the reg expr is broken, should not be allowed", result);
		//		this.checkProperStackTrace("Encountered [iI]s**land", 22);
	}

	public void testRegExpGroupUse() {
		OPPLScript result = this
				.parse("?island:CLASS=Match(\"((BoundaryFragment))\"), ?newIsland:CLASS=create(\"Test\"+?island.GROUPS(0)) BEGIN ADD ?newIsland subClassOf ?island END;");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
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
				.parse("?regexp:CLASS=Match(\"'test ([a-z]+)'\"), ?x:CLASS=create(?regexp.GROUPS(0)) SELECT ?regexp subClassOf Thing  BEGIN ADD ?x subClassOf Thing END;");
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
		String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(";
		OPPLScript result = this.parse(correct + " \"Island\");");
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
		//		result = this.parse(correct + " \"Is**land\");");
		//		assertNull("the reg expr is broken, should not be allowed", result);
		//		this.checkProperStackTrace("Encountered Is**land", correct.length());
	}

	public void testRegExpGroupConstraints() {
		String correct = "?island:CLASS SELECT ?island subClassOf Thing WHERE ?island Match(\"([a-zA-Z])*[Ii](sl)*(and)*\") BEGIN ADD ?island subClassOf Thing END;";
		OPPLScript result = this.parse(correct);
		this.expectedCorrect(result);
		this.execute(result, this.getOntology("test.owl"), 0);
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

	public void testXQueryExecution() {
		// OWLOntologyManager tempmanager =
		// OWLManager.createOWLOntologyManager();
		// URI MIKELS_FAMILY_ONTOLOGY = URI
		// .create("http://www.cs.man.ac.uk/~iannonel/oppl/ontologies/mikelsFamily.owl");
		OPPLScript statement;
		String owlXMLFilePath = "ontologies/test.owl";
		// OWLOntology ontology;
		try {
			// ontology = tempmanager.loadOntology(MIKELS_FAMILY_ONTOLOGY);
			// ParserFactory
			// .initParser(
			// "?x:CLASS, ?y:CLASS SELECT ?x subClassOf gender, ?y subClassOf gender WHERE ?x != ?y BEGIN ADD ?x disjointWith ?y END;",
			// ontology, tempmanager, null);
			// statement = OPPLParser.Start();
			statement = this
					.parse("?x:CLASS, ?y:CLASS SELECT ?x subClassOf Fragment, ?y subClassOf Fragment WHERE ?x != ?y BEGIN ADD ?x disjointWith ?y END;");
			XQueryRenderer testrenderer = new XQueryRenderer(
					"doc(\"test.owl\")/");
			System.out.println(testrenderer.render(statement));
			Configuration configuration = new Configuration();
			XQueryRenderer renderer = new XQueryRenderer("");
			String xQueryString = renderer.render(statement);
			// System.out.println(xQueryString);
			Document document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(new File(owlXMLFilePath));
			DOMSource source = new DOMSource(document);
			configuration.buildDocument(source);
			SaxonXQDataSource dataSource = new SaxonXQDataSource(configuration);
			XQConnection connection = dataSource.getConnection();
			XQPreparedExpression expression = connection
					.prepareExpression(xQueryString);
			expression.bindDocument(XQConstants.CONTEXT_ITEM, source,
					connection.createDocumentType());
			XQResultSequence result = expression.executeQuery();
			while (result.next()) {
				System.out.println(result.getItemAsString(null));
			}
			//FIXME the query does not bind ?y, but the same script works from inside Protege. ??
			//	this.execute(statement, this.getOntology("test.owl"), 4);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
