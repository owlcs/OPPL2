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

import uk.ac.manchester.cs.jfact.JFactFactory;

public class TestObjectAssertions {
    /** @param args */
    public static void main(String[] args) {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        URL url;
        try {
            url = new URL(args[0]);
            File parentFile = new File(url.toURI()).getParentFile();
            if (parentFile != null && parentFile.isDirectory()) {
                AutoIRIMapper mapper = new AutoIRIMapper(parentFile, true);
                ontologyManager.addIRIMapper(mapper);
            }
            OWLOntology ontology = ontologyManager.loadOntology(IRI.create(url));
            JFactFactory factory = new JFactFactory();
            OWLReasoner reasoner = factory.createReasoner(ontology);
            Set<OWLNamedIndividual> individualsInSignature = ontology
                    .getIndividualsInSignature();
            Set<OWLObjectProperty> objectPropertiesInSignature = ontology
                    .getObjectPropertiesInSignature();
            for (OWLNamedIndividual owlNamedIndividual : individualsInSignature) {
                for (OWLObjectProperty owlObjectProperty : objectPropertiesInSignature) {
                    long start = System.currentTimeMillis();
                    NodeSet<OWLNamedIndividual> objectPropertyValues = reasoner
                            .getObjectPropertyValues(owlNamedIndividual,
                                    owlObjectProperty);
                    long elapsed = System.currentTimeMillis() - start;
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
