package org.coode.oppl.test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.AnnotationBasedSymbolTableFactory;
import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.common.SystemErrorEcho;
import org.junit.Ignore;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.model.*;

@SuppressWarnings("javadoc")
public class RunOPPL {

    public void feedOPPL(String script, String ontologyName)
        throws OWLOntologyCreationException {
        feedOPPL(script, OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(this
            .getClass().getResourceAsStream(ontologyName)));
    }

    public void feedOPPLWithContent(String script, String content)
        throws OWLOntologyCreationException {
        feedOPPL(script, OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(
            new StringDocumentSource(content)));
    }

    public void feedOPPL(String script, OWLOntology ontology) {
        String opplScriptString = script;
        ParserFactory parserFactory = new ParserFactory(ontology.getOWLOntologyManager(), ontology, null);
        // OPPLParser parser = parserFactory.build(new SystemErrorEcho());
        AnnotationBasedSymbolTableFactory annotationBasedSymbolTableFactory = new AnnotationBasedSymbolTableFactory(
            ontology.getOWLOntologyManager(), Arrays.asList(ontology.getOWLOntologyManager().getOWLDataFactory()
                .getRDFSLabel().getIRI()));
        OPPLParser parser = parserFactory.build(new SystemErrorEcho(),
            annotationBasedSymbolTableFactory);
        // OPPLParser parser = parserFactory.build(new SystemErrorEcho(), new
        // AnnotationBasedSymbolTableFactory(ontologyManager,
        // Arrays.asList(ontologyManager.getOWLDataFactory().getRDFSLabel().getIRI())));
        OPPLScript parsed = parser.parse(opplScriptString);
        ChangeExtractor extractor = new ChangeExtractor(new RuntimeExceptionHandler() {

            @Override
            public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
                e.printStackTrace();
            }

            @Override
            public void handleOWLRuntimeException(OWLRuntimeException e) {
                e.printStackTrace();
            }

            @Override
            public void handleException(RuntimeException e) {
                e.printStackTrace();
            }
        }, true);
        List<OWLAxiomChange> changes = extractor.visit(parsed);
        for (OWLAxiomChange owlAxiomChange : changes) {
            final ManchesterSyntaxRenderer renderer = parserFactory.getOPPLFactory()
                .getManchesterSyntaxRenderer(parsed.getConstraintSystem());
            owlAxiomChange.accept(new OWLOntologyChangeVisitor() {

                @Override
                public void visit(RemoveOntologyAnnotation change) {
                    System.out.println(change);
                }

                @Override
                public void visit(AddOntologyAnnotation change) {
                    System.out.println(change);
                }

                @Override
                public void visit(RemoveImport change) {
                    System.out.println(change);
                }

                @Override
                public void visit(AddImport change) {
                    System.out.println(change);
                }

                @Override
                public void visit(SetOntologyID change) {
                    System.out.println(change);
                }

                @Override
                public void visit(RemoveAxiom change) {
                    OWLAxiom axiom = change.getAxiom();
                    axiom.accept(renderer);
                    System.out.println(String.format("REMOVE %s", renderer));
                }

                @Override
                public void visit(AddAxiom change) {
                    OWLAxiom axiom = change.getAxiom();
                    axiom.accept(renderer);
                    System.out.println(String.format("ADD %s", renderer));
                }
            });
        }
    }

    @Ignore
    @Test
    public void should() throws OWLOntologyCreationException {
        String input = "Prefix: : <http://www.semanticweb.org/ontologies/2015/8/issue1#>\n" +
            "Prefix: owl: <http://www.w3.org/2002/07/owl#>\n" +
            "Prefix: rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "Prefix: xml: <http://www.w3.org/XML/1998/namespace>\n" +
            "Prefix: xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "Prefix: rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "Ontology: <http://www.semanticweb.org/ontologies/2015/8/issue1>\n" +
            "AnnotationProperty: rdfs:label\n" +
            "Datatype: rdf:PlainLiteral\n" +
            "ObjectProperty: rolegroup_attribute\n    Annotations: \n        rdfs:label \"Role group (attribute)\"\n" +
            "ObjectProperty: findingcontext_attribute\n    Annotations: \n        rdfs:label \"Finding context (attribute)\"\n"
            +
            "ObjectProperty: associatedfinding_attribute\n    Annotations: \n        rdfs:label \"Associated finding (attribute)\"\n"
            +
            "ObjectProperty: subjectrelationshipcontext\n    Annotations: \n        rdfs:label \"Subject relationship context (attribute)\"\n"
            +
            "ObjectProperty: temporalcontext_attribute\n    Annotations: \n        rdfs:label \"Temporal context (attribute)\"\n"
            +
            "Class: heartmurmur_finding\n    Annotations: \n        rdfs:label \"Heart murmur (finding)\"\n" +
            "Class: currentorspecifiedtime\n    Annotations: \n        rdfs:label \"Current or specified time (qualifier value)\"\n"
            +
            "Class: knownpresent_qualifiervalue\n    Annotations: \n        rdfs:label \"Known present (qualifier value)\"\n"
            +
            "Class: subjectofrecord_person\n    Annotations: \n        rdfs:label \"Subject of record (person)\"\n" +
            "Class: TestClass\n" +
            "Class: clinicalfindingpresent_situation\n    Annotations: \n        rdfs:label \"Clinical finding present (situation)\"\n"
            +
            "Class: VerifyClass\n" +
            "    SubClassOf: \n        clinicalfindingpresent_situation and \n" +
            "        rolegroup_attribute some     (\n            associatedfinding_attribute some heartmurmur_finding \n"
            +
            "            and \n            findingcontext_attribute some knownpresent_qualifiervalue \n" +
            "            and \n            temporalcontext_attribute some currentorspecifiedtime \n" +
            "            and \n            subjectrelationshipcontext some subjectofrecord_person)";
        String script = "?PresentSituation:CLASS SELECT ?PresentSituation SubClassOf "
            + "'Clinical finding present (situation)' and 'Role group (attribute)' some "
            + "('Associated finding (attribute)' some 'Heart murmur (finding)' "
            + "and 'Finding context (attribute)' some 'Known present (qualifier value)' "
            + "and 'Temporal context (attribute)' some 'Current or specified time (qualifier value)' "
            + "and 'Subject relationship context (attribute)' some 'Subject of record (person)')\n\n" +
            "BEGIN\nADD ?PresentSituation SubClassOf TestClass\nEND;";
        System.out.println(script);
        new RunOPPL().feedOPPLWithContent(script, input);
    }

    public static void main(String[] args) {
        RunOPPL r = new RunOPPL();
        String query1 = "?A:CLASS SELECT ?A SubClassOf 'Heart disease (disorder)' BEGIN ADD ?A SubClassOf !Candidate END;";
        try {
            r.feedOPPL(query1, "entire-june-21-prop-paths.owl");
        } catch (OWLOntologyCreationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
