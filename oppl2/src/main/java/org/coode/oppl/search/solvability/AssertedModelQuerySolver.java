package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Set;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 */
public final class AssertedModelQuerySolver implements QuerySolver {

    private final OWLOntologyManager ontologyManager;

    /**
     * @param ontologyManager ontologyManager
     */
    public AssertedModelQuerySolver(OWLOntologyManager ontologyManager) {
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
    }

    @Override
    public Set<OWLClass> getSubClasses(OWLClassExpression superClass) {
        return asSet(
            ontologyManager.ontologies().flatMap(o -> o.axioms(AxiomType.SUBCLASS_OF))
                .filter(owlAxiom -> owlAxiom.getSuperClass().equals(superClass)
                    && !owlAxiom.getSubClass().isAnonymous())
                .map(a -> a.getSubClass().asOWLClass()));
    }

    @Override
    public Set<OWLClass> getSuperClasses(OWLClassExpression subClass) {
        return asSet(ontologyManager.ontologies().flatMap(o -> o.axioms(AxiomType.SUBCLASS_OF))
            .filter(owlAxiom -> owlAxiom.getSubClass().equals(subClass)
                && !owlAxiom.getSuperClass().isAnonymous())
            .map(a -> a.getSuperClass().asOWLClass()));
    }

    @Override
    public Set<OWLNamedIndividual> getNamedFillers(OWLNamedIndividual subject,
        OWLObjectPropertyExpression objectProperty) {
        return asSet(
            ontologyManager.ontologies().flatMap(o -> o.axioms(AxiomType.OBJECT_PROPERTY_ASSERTION))
                .filter(ax -> ax.getSubject().equals(subject)
                    && ax.getProperty().equals(objectProperty) && !ax.getObject().isAnonymous())
                .map(ax -> ax.getObject().asOWLNamedIndividual()));
    }

    @Override
    public boolean hasNoSubClass(OWLClassExpression superClass) {
        return ontologyManager.ontologies().flatMap(o -> o.axioms(AxiomType.SUBCLASS_OF))
            .noneMatch(a -> a.getSuperClass().equals(superClass));
    }

    @Override
    public boolean hasNoSuperClass(OWLClassExpression subClass) {
        return ontologyManager.ontologies().flatMap(o -> o.axioms(AxiomType.SUBCLASS_OF))
            .noneMatch(a -> a.getSubClass().equals(subClass));
    }
}
