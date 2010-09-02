package org.coode.oppl.template.opplscript.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.MissingFormatArgumentException;
import java.util.Properties;

import junit.framework.TestCase;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.oppl.template.commons.JavaFormatterReplacementStrategy;
import org.coode.oppl.template.commons.KeyBasedReplacementStrategy;
import org.coode.oppl.template.commons.StringTemplate;
import org.coode.oppl.template.commons.opplscript.AnnotationBasedSimpleOPPLParserCreationStrategy;
import org.coode.oppl.template.commons.opplscript.SimpleOPPLParserCreationStrategy;
import org.coode.parsers.test.JUnitTestErrorListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class TestStringTemplates extends TestCase {
	private static final JUnitTestErrorListener ERROR_LISTENER = new JUnitTestErrorListener();

	@Override
	protected void setUp() throws Exception {
	}

	public void testTemplateNoPlaceHolder() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager.createOntology();
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new SimpleOPPLParserCreationStrategy(
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new JavaFormatterReplacementStrategy(Collections
							.emptyList()), parserCreationStrategy);
			OPPLScript opplScript = stringTemplate.replace();
			assertNotNull(opplScript);
			System.out
					.println("TestStringTemplates.testTemplateNoPlaceHolder() "
							+ opplScript);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testTemplateOnePlaceHolder() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager.createOntology();
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new SimpleOPPLParserCreationStrategy(
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf %s BEGIN ADD ?x subClassOf Thing END;";
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new JavaFormatterReplacementStrategy(Arrays
							.asList("Thing")), parserCreationStrategy);
			OPPLScript opplScript = stringTemplate.replace();
			assertNotNull(opplScript);
			System.out
					.println("TestStringTemplates.testTemplateOnePlaceHolder() "
							+ opplScript);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testTemplateOnePlaceHolderButNoData() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager.createOntology();
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new SimpleOPPLParserCreationStrategy(
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf %s BEGIN ADD ?x subClassOf Thing END;";
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new JavaFormatterReplacementStrategy(Collections
							.emptyList()), parserCreationStrategy);
			stringTemplate.replace();
			fail("Should not get to here");
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (MissingFormatArgumentException e) {
		}
	}

	public void testTestPropertyBasedStringTemplateOnePlaceholder() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager.createOntology();
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new SimpleOPPLParserCreationStrategy(
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf ${Thing} BEGIN ADD ?x subClassOf Thing END;";
			Properties properties = new Properties();
			properties.setProperty("Thing", "Thing");
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new KeyBasedReplacementStrategy(properties),
					parserCreationStrategy);
			OPPLScript opplScript = stringTemplate.replace();
			assertNotNull(opplScript);
			System.out
					.println("TestStringTemplates.testTestPropertyBasedStringTemplateOnePlaceholder() "
							+ opplScript);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testTestPropertyBasedStringTemplateOnePlaceholderButNoData() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager.createOntology();
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new SimpleOPPLParserCreationStrategy(
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf ${Thing} BEGIN ADD ?x subClassOf Thing END;";
			Properties properties = new Properties();
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new KeyBasedReplacementStrategy(properties),
					parserCreationStrategy);
			stringTemplate.replace();
			fail("Should not get to here");
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (NullPointerException e) {
			System.out
					.println("TestStringTemplates.testTestPropertyBasedStringTemplateOnePlaceholderButNoData() Missing value (as expected)  "
							+ e.getMessage());
		}
	}

	public void testTestPropertyBasedStringTemplateOnePlaceholderUsedTwice() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager.createOntology();
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new SimpleOPPLParserCreationStrategy(
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf ${Thing} BEGIN ADD ?x subClassOf ${Thing} END;";
			Properties properties = new Properties();
			properties.setProperty("Thing", "Thing");
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new KeyBasedReplacementStrategy(properties),
					parserCreationStrategy);
			OPPLScript opplScript = stringTemplate.replace();
			assertNotNull(opplScript);
			System.out
					.println("TestStringTemplates.testTestPropertyBasedStringTemplateOnePlaceholderUsedTwice() "
							+ opplScript);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testTestPropertyBasedStringTemplateOnePlaceholderUsingAnnotationForParsing() {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		try {
			OWLOntology emptyOntology = ontologyManager
					.loadOntology(IRI
							.create("http://www.co-ode.org/ontologies/pizza/2007/02/12/pizza.owl"));
			ParsingStrategy<String, OPPLScript> parserCreationStrategy = new AnnotationBasedSimpleOPPLParserCreationStrategy(
					Arrays
							.asList(IRI
									.create("http://www.w3.org/2000/01/rdf-schema#label")),
					ontologyManager, emptyOntology, null, ERROR_LISTENER);
			String template = "?x:CLASS SELECT ?x subClassOf ${ValuePartition} BEGIN ADD ?x subClassOf Thing END;";
			Properties properties = new Properties();
			properties.setProperty("ValuePartition", "ValorDaParticao");
			StringTemplate<OPPLScript> stringTemplate = new StringTemplate<OPPLScript>(
					template, new KeyBasedReplacementStrategy(properties),
					parserCreationStrategy);
			OPPLScript opplScript = stringTemplate.replace();
			assertNotNull(opplScript);
			System.out
					.println("TestStringTemplates.testTestPropertyBasedStringTemplateOnePlaceholderUsingAnnotationForParsing() "
							+ opplScript);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
