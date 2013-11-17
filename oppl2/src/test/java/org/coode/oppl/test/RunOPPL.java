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
import org.coode.parsers.common.SilentListener;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeVisitor;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.RemoveImport;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;
import org.semanticweb.owlapi.model.SetOntologyID;

public class RunOPPL {
    public void feedOPPL(String script, String ontologyName)
            throws OWLOntologyCreationException {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        String opplScriptString = script;
        OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(this
                .getClass().getResourceAsStream(ontologyName));
        ParserFactory parserFactory = new ParserFactory(ontologyManager, ontology, null);
        // OPPLParser parser = parserFactory.build(new SystemErrorEcho());
        AnnotationBasedSymbolTableFactory annotationBasedSymbolTableFactory = new AnnotationBasedSymbolTableFactory(
                ontologyManager, Arrays.asList(ontologyManager.getOWLDataFactory()
                        .getRDFSLabel().getIRI()));
        OPPLParser parser = parserFactory.build(new SilentListener(),
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
