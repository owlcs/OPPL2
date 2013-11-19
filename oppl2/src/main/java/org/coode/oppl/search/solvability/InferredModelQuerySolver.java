package org.coode.oppl.search.solvability;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** @author Luigi Iannone */
public final class InferredModelQuerySolver implements QuerySolver {
    private final OWLReasoner reasoner;

    /** @param reasoner */
    public InferredModelQuerySolver(OWLReasoner reasoner) {
        if (reasoner == null) {
            throw new NullPointerException("The reasoner canot be null");
        }
        this.reasoner = reasoner;
    }

    @Override
    public Set<OWLClass> getSubClasses(OWLClassExpression superClass) {
        Set<OWLClass> toReturn = reasoner.getSubClasses(superClass, false).getFlattened();
        toReturn.addAll(reasoner.getEquivalentClasses(superClass).getEntities());
        if (!superClass.isAnonymous()) {
            toReturn.add(superClass.asOWLClass());
        }
        return toReturn;
    }

    @Override
    public Set<OWLClass> getSuperClasses(OWLClassExpression subClass) {
        Set<OWLClass> toReturn = reasoner.getSuperClasses(subClass, false).getFlattened();
        toReturn.addAll(reasoner.getEquivalentClasses(subClass).getEntities());
        if (!subClass.isAnonymous()) {
            toReturn.add(subClass.asOWLClass());
        }
        return toReturn;
    }

    @Override
    public boolean hasNoSubClass(OWLClassExpression superClass) {
        Set<OWLClass> subClasses = reasoner.getSubClasses(superClass, false)
                .getFlattened();
        subClasses.addAll(reasoner.getEquivalentClasses(superClass).getEntities());
        subClasses.remove(superClass);
        subClasses.removeAll(reasoner.getBottomClassNode().getEntities());
        return subClasses.isEmpty();
    }

    @Override
    public boolean hasNoSuperClass(OWLClassExpression subClass) {
        Set<OWLClass> superClasses = reasoner.getSubClasses(subClass, false)
                .getFlattened();
        superClasses.addAll(reasoner.getEquivalentClasses(subClass).getEntities());
        superClasses.remove(subClass);
        superClasses.removeAll(reasoner.getTopClassNode().getEntities());
        return superClasses.isEmpty();
    }

    @Override
    public Set<OWLNamedIndividual> getNamedFillers(OWLNamedIndividual subject,
            OWLObjectPropertyExpression objectProperty) {
        NodeSet<OWLNamedIndividual> fillers = reasoner.getObjectPropertyValues(subject,
                objectProperty);
        return fillers.getFlattened();
    }
}
