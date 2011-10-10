package org.coode.oppl.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.common.SystemErrorEcho;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
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
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.AutoIRIMapper;

import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;

public class RunQuery {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		if (args.length >= 2) {
			OWLOntology ontology = null;
			try {
				for (int i = 1; i < args.length; i++) {
					URL url = new URL(args[i]);
					File parentFile = new File(url.toURI()).getParentFile();
					if (parentFile != null && parentFile.isDirectory()) {
						AutoIRIMapper mapper = new AutoIRIMapper(parentFile,
								true);
						ontologyManager.addIRIMapper(mapper);
					}
					ontology = ontology == null ? ontologyManager
							.loadOntology(IRI.create(url)) : ontology;
				}
				String opplScriptString = args[0];
				FaCTPlusPlusReasonerFactory factory = new FaCTPlusPlusReasonerFactory();
				OWLReasoner reasoner = factory.createReasoner(ontology);
				reasoner.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
				ParserFactory parserFactory = new ParserFactory(
						ontologyManager, ontology, reasoner);
				OPPLParser parser = parserFactory.build(new SystemErrorEcho());
				OPPLScript parsed = parser.parse(opplScriptString);
				ChangeExtractor extractor = new ChangeExtractor(
						new RuntimeExceptionHandler() {
							public void handlePatternSyntaxExcpetion(
									PatternSyntaxException e) {
								e.printStackTrace();
							}

							public void handleOWLRuntimeException(
									OWLRuntimeException e) {
								e.printStackTrace();
							}

							public void handleException(RuntimeException e) {
								e.printStackTrace();
							}
						}, true);
				List<OWLAxiomChange> changes = extractor.visit(parsed);
				for (OWLAxiomChange owlAxiomChange : changes) {
					final ManchesterSyntaxRenderer renderer = parserFactory
							.getOPPLFactory().getManchesterSyntaxRenderer(
									parsed.getConstraintSystem());
					owlAxiomChange.accept(new OWLOntologyChangeVisitor() {
						public void visit(RemoveOntologyAnnotation change) {
							System.out.println(change);
						}

						public void visit(AddOntologyAnnotation change) {
							System.out.println(change);
						}

						public void visit(RemoveImport change) {
							System.out.println(change);
						}

						public void visit(AddImport change) {
							System.out.println(change);
						}

						public void visit(SetOntologyID change) {
							System.out.println(change);
						}

						public void visit(RemoveAxiom change) {
							OWLAxiom axiom = change.getAxiom();
							axiom.accept(renderer);
							System.out.println(String.format("REMOVE %s",
									renderer));
						}

						public void visit(AddAxiom change) {
							OWLAxiom axiom = change.getAxiom();
							axiom.accept(renderer);
							System.out.println(String
									.format("ADD %s", renderer));
						}
					});
				}
			} catch (OWLOntologyCreationException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			System.out
					.println("Usage java org.coode.oppl.test.RunQuery <OPPL Script> <ontology URL>...<ontology URL>");
		}
	}
}
