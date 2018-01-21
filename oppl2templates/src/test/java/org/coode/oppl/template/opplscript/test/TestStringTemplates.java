package org.coode.oppl.template.opplscript.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.MissingFormatArgumentException;
import java.util.Properties;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.oppl.template.commons.KeyBasedReplacementStrategy;
import org.coode.oppl.template.commons.StringFormatReplacementStrategy;
import org.coode.oppl.template.commons.StringTemplate;
import org.coode.oppl.template.commons.opplscript.AnnotationBasedSimpleOPPLParserCreationStrategy;
import org.coode.oppl.template.commons.opplscript.SimpleOPPLParserCreationStrategy;
import org.coode.oppl.testcaseontologies.TemplateTestOntologies;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

@SuppressWarnings("javadoc")
public class TestStringTemplates {

    private static final ErrorListener ERROR_LISTENER = new ErrorListener() {

        @Override
        public void unrecognisedSymbol(CommonTree t) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
            throw new RuntimeException(parentExpression.toString());
        }

        @Override
        public void illegalToken(CommonTree t, String message) {
            throw new RuntimeException(t.toString());
        }

        @Override
        public void recognitionException(RecognitionException e) {
            throw new RuntimeException(e);
        }

        @Override
        public void recognitionException(RecognitionException e, String... tokenNames) {
            throw new RuntimeException(e);
        }

        @Override
        public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
            throw new RuntimeException(e);
        }

        @Override
        public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
            throw new RuntimeException(t);
        }
    };

    @Test
    public void shouldTestTemplateNoPlaceHolder() throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology emptyOntology = ontologyManager.createOntology();
        ParsingStrategy<String, OPPLScript> parserCreationStrategy =
            new SimpleOPPLParserCreationStrategy(ontologyManager, emptyOntology, null,
                ERROR_LISTENER);
        String template = "?x:CLASS SELECT ?x subClassOf Thing BEGIN ADD ?x subClassOf Thing END;";
        StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
            new StringFormatReplacementStrategy(Collections.emptyList()), parserCreationStrategy);
        OPPLScript opplScript = stringTemplate.replace();
        assertNotNull(opplScript);
    }

    @Test
    public void shouldTestTemplateOnePlaceHolder() throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology emptyOntology = ontologyManager.createOntology();
        ParsingStrategy<String, OPPLScript> parserCreationStrategy =
            new SimpleOPPLParserCreationStrategy(ontologyManager, emptyOntology, null,
                ERROR_LISTENER);
        String template = "?x:CLASS SELECT ?x subClassOf %s BEGIN ADD ?x subClassOf Thing END;";
        StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
            new StringFormatReplacementStrategy(Arrays.asList("Thing")), parserCreationStrategy);
        OPPLScript opplScript = stringTemplate.replace();
        assertNotNull(opplScript);
    }

    @Test
    public void shouldTestTemplateOnePlaceHolderButNoData() {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        try {
            OWLOntology emptyOntology = ontologyManager.createOntology();
            ParsingStrategy<String, OPPLScript> parserCreationStrategy =
                new SimpleOPPLParserCreationStrategy(ontologyManager, emptyOntology, null,
                    ERROR_LISTENER);
            String template = "?x:CLASS SELECT ?x subClassOf %s BEGIN ADD ?x subClassOf Thing END;";
            StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
                new StringFormatReplacementStrategy(Collections.emptyList()),
                parserCreationStrategy);
            stringTemplate.replace();
            fail("Should not get to here");
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (MissingFormatArgumentException e) {
        }
    }

    @Test
    public void shouldTestTestPropertyBasedStringTemplateOnePlaceholder()
        throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology emptyOntology = ontologyManager.createOntology();
        ParsingStrategy<String, OPPLScript> parserCreationStrategy =
            new SimpleOPPLParserCreationStrategy(ontologyManager, emptyOntology, null,
                ERROR_LISTENER);
        String template =
            "?x:CLASS SELECT ?x subClassOf ${Thing} BEGIN ADD ?x subClassOf Thing END;";
        Properties properties = new Properties();
        properties.setProperty("Thing", "Thing");
        StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
            new KeyBasedReplacementStrategy(properties), parserCreationStrategy);
        OPPLScript opplScript = stringTemplate.replace();
        assertNotNull(opplScript);
    }

    @Test(expected = NullPointerException.class)
    public void shouldTestTestPropertyBasedStringTemplateOnePlaceholderButNoData()
        throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology emptyOntology = ontologyManager.createOntology();
        ParsingStrategy<String, OPPLScript> parserCreationStrategy =
            new SimpleOPPLParserCreationStrategy(ontologyManager, emptyOntology, null,
                ERROR_LISTENER);
        String template =
            "?x:CLASS SELECT ?x subClassOf ${Thing} BEGIN ADD ?x subClassOf Thing END;";
        Properties properties = new Properties();
        StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
            new KeyBasedReplacementStrategy(properties), parserCreationStrategy);
        stringTemplate.replace();
    }

    @Test
    public void shouldTestTestPropertyBasedStringTemplateOnePlaceholderUsedTwice()
        throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology emptyOntology = ontologyManager.createOntology();
        ParsingStrategy<String, OPPLScript> parserCreationStrategy =
            new SimpleOPPLParserCreationStrategy(ontologyManager, emptyOntology, null,
                ERROR_LISTENER);
        String template =
            "?x:CLASS SELECT ?x subClassOf ${Thing} BEGIN ADD ?x subClassOf ${Thing} END;";
        Properties properties = new Properties();
        properties.setProperty("Thing", "Thing");
        StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
            new KeyBasedReplacementStrategy(properties), parserCreationStrategy);
        OPPLScript opplScript = stringTemplate.replace();
        assertNotNull(opplScript);
    }

    @Test
    public void testTestPropertyBasedStringTemplateOnePlaceholderUsingAnnotationForParsing() {
        OWLOntology emptyOntology = TemplateTestOntologies.pizza;
        ParsingStrategy<String, OPPLScript> parserCreationStrategy =
            new AnnotationBasedSimpleOPPLParserCreationStrategy(
                Arrays.asList(IRI.create("http://www.w3.org/2000/01/rdf-schema#label")),
                emptyOntology.getOWLOntologyManager(), emptyOntology, null, ERROR_LISTENER);
        String template =
            "?x:CLASS SELECT ?x subClassOf ${ValuePartition} BEGIN ADD ?x subClassOf Thing END;";
        Properties properties = new Properties();
        properties.setProperty("ValuePartition", "ValorDaParticao");
        StringTemplate<OPPLScript> stringTemplate = new StringTemplate<>(template,
            new KeyBasedReplacementStrategy(properties), parserCreationStrategy);
        OPPLScript opplScript = stringTemplate.replace();
        assertNotNull(opplScript);
    }
}
