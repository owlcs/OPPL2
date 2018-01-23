package org.coode.oppl.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.AutoIRIMapper;

import uk.ac.manchester.cs.jfact.JFactFactory;

@SuppressWarnings("javadoc")
public class TestObjectAssertions {

    /**
     * @param args
     */
    public static void main(String[] args) {
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        URL url;
        try {
            url = new URL(args[0]);
            File parentFile = new File(url.toURI()).getParentFile();
            if (parentFile != null && parentFile.isDirectory()) {
                AutoIRIMapper mapper = new AutoIRIMapper(parentFile, true);
                ontologyManager.getIRIMappers().add(mapper);
            }
            OWLOntology ontology = ontologyManager.loadOntology(IRI.create(url));
            JFactFactory factory = new JFactFactory();
            OWLReasoner reasoner = factory.createReasoner(ontology);
            ontology.individualsInSignature()
                .forEach(i -> ontology.objectPropertiesInSignature().forEach(p -> {
                    long start = System.currentTimeMillis();
                    reasoner.getObjectPropertyValues(i, p);
                    long elapsed = System.currentTimeMillis() - start;
                    System.out.println("TestObjectAssertions.main() " + elapsed);
                }));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
    }
}
