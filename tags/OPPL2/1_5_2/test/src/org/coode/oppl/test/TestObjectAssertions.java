package org.coode.oppl.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.AutoIRIMapper;

import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;

public class TestObjectAssertions {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OWLOntologyManager ontologyManager = OWLManager
				.createOWLOntologyManager();
		URL url;
		try {
			url = new URL(args[0]);
			File parentFile = new File(url.toURI()).getParentFile();
			if (parentFile != null && parentFile.isDirectory()) {
				AutoIRIMapper mapper = new AutoIRIMapper(parentFile, true);
				ontologyManager.addIRIMapper(mapper);
			}
			OWLOntology ontology = ontologyManager
					.loadOntology(IRI.create(url));
			FaCTPlusPlusReasonerFactory factory = new FaCTPlusPlusReasonerFactory();
			OWLReasoner reasoner = factory.createReasoner(ontology);
			Set<OWLNamedIndividual> individualsInSignature = ontology
					.getIndividualsInSignature();
			Set<OWLObjectProperty> objectPropertiesInSignature = ontology
					.getObjectPropertiesInSignature();
			System.out
					.println(String
							.format("Computing fillers for %d individuals on %d object properties ",
									individualsInSignature.size(),
									objectPropertiesInSignature.size()));
			for (OWLNamedIndividual owlNamedIndividual : individualsInSignature) {
				for (OWLObjectProperty owlObjectProperty : objectPropertiesInSignature) {
					long start = System.currentTimeMillis();
					NodeSet<OWLNamedIndividual> objectPropertyValues = reasoner
							.getObjectPropertyValues(owlNamedIndividual,
									owlObjectProperty);
					long elapsed = System.currentTimeMillis() - start;
					System.out.println(String.format(
							"After %d millisecs inferred %s %s %s ", elapsed,
							owlNamedIndividual, owlObjectProperty,
							objectPropertyValues.getFlattened()));
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}
	}
}
