package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.semanticweb.owlapi.model.*;

/**
 * @author Luigi Iannone
 */
public final class AssertedModelQuerySolver implements QuerySolver {

    private final OWLOntologyManager ontologyManager;

    /**
     * @param ontologyManager
     *        ontologyManager
     */
    public AssertedModelQuerySolver(OWLOntologyManager ontologyManager) {
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
    }

    @Override
    public Set<OWLClass> getSubClasses(OWLClassExpression superClass) {
        Set<OWLClass> toReturn = new HashSet<>();
        for (OWLOntology ontology : ontologyManager.getOntologies()) {
            for (OWLSubClassOfAxiom owlAxiom : ontology.getAxioms(AxiomType.SUBCLASS_OF)) {
                if (owlAxiom.getSuperClass().equals(superClass)
                    && !owlAxiom.getSubClass().isAnonymous()) {
                    toReturn.add(owlAxiom.getSubClass().asOWLClass());
                }
            }
        }
        return toReturn;
    }

    @Override
    public Set<OWLClass> getSuperClasses(OWLClassExpression subClass) {
        Set<OWLClass> toReturn = new HashSet<>();
        for (OWLOntology ontology : ontologyManager.getOntologies()) {
            for (OWLSubClassOfAxiom owlAxiom : ontology.getAxioms(AxiomType.SUBCLASS_OF)) {
                if (owlAxiom.getSubClass().equals(subClass)
                    && !owlAxiom.getSuperClass().isAnonymous()) {
                    toReturn.add(owlAxiom.getSuperClass().asOWLClass());
                }
            }
        }
        return toReturn;
    }

    @Override
    public Set<OWLNamedIndividual> getNamedFillers(OWLNamedIndividual subject,
        OWLObjectPropertyExpression objectProperty) {
        Set<OWLNamedIndividual> toReturn = new HashSet<>();
        for (OWLOntology ontology : ontologyManager.getOntologies()) {
            for (OWLObjectPropertyAssertionAxiom owlAxiom : ontology
                .getAxioms(AxiomType.OBJECT_PROPERTY_ASSERTION)) {
                if (owlAxiom.getSubject().equals(subject)
                    && owlAxiom.getProperty().equals(objectProperty)
                    && !owlAxiom.getObject().isAnonymous()) {
                    toReturn.add(owlAxiom.getObject().asOWLNamedIndividual());
                }
            }
        }
        return toReturn;
    }

    @Override
    public boolean hasNoSubClass(OWLClassExpression superClass) {
        boolean found = false;
        Iterator<OWLOntology> ontologyIterator = ontologyManager.getOntologies()
            .iterator();
        while (!found && ontologyIterator.hasNext()) {
            OWLOntology owlOntology = ontologyIterator.next();
            Iterator<OWLSubClassOfAxiom> iterator = owlOntology.getAxioms(
                AxiomType.SUBCLASS_OF).iterator();
            while (!found && iterator.hasNext()) {
                OWLSubClassOfAxiom owlSubClassOfAxiom = iterator.next();
                found = owlSubClassOfAxiom.getSuperClass().equals(superClass);
            }
        }
        return !found;
    }

    @Override
    public boolean hasNoSuperClass(OWLClassExpression subClass) {
        boolean found = false;
        Iterator<OWLOntology> ontologyIterator = ontologyManager.getOntologies()
            .iterator();
        while (!found && ontologyIterator.hasNext()) {
            OWLOntology owlOntology = ontologyIterator.next();
            Iterator<OWLSubClassOfAxiom> iterator = owlOntology.getAxioms(
                AxiomType.SUBCLASS_OF).iterator();
            while (!found && iterator.hasNext()) {
                OWLSubClassOfAxiom owlSubClassOfAxiom = iterator.next();
                found = owlSubClassOfAxiom.getSubClass().equals(subClass);
            }
        }
        return !found;
    }
}
