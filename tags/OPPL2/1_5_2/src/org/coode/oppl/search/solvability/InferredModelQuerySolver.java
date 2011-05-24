/**
 * 
 */
package org.coode.oppl.search.solvability;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public final class InferredModelQuerySolver implements QuerySolver {
	private final OWLReasoner reasoner;

	/**
	 * @param reasoner
	 */
	public InferredModelQuerySolver(OWLReasoner reasoner) {
		if (reasoner == null) {
			throw new NullPointerException("The reasoner canot be null");
		}
		this.reasoner = reasoner;
	}

	/**
	 * @see org.coode.oppl.search.solvability.QuerySolver#getSubClasses(org.semanticweb
	 *      .owlapi.model.OWLClassExpression)
	 */
	public Set<OWLClass> getSubClasses(OWLClassExpression superClass) {
		Set<OWLClass> toReturn = this.reasoner.getSubClasses(superClass, false)
				.getFlattened();
		toReturn.addAll(this.reasoner.getEquivalentClasses(superClass)
				.getEntities());
		if (!superClass.isAnonymous()) {
			toReturn.add(superClass.asOWLClass());
		}
		return toReturn;
	}

	/**
	 * @see org.coode.oppl.search.solvability.QuerySolver#getSuperClasses(org.semanticweb
	 *      .owlapi.model.OWLClassExpression)
	 */
	public Set<OWLClass> getSuperClasses(OWLClassExpression subClass) {
		Set<OWLClass> toReturn = this.reasoner.getSuperClasses(subClass, false)
				.getFlattened();
		toReturn.addAll(this.reasoner.getEquivalentClasses(subClass)
				.getEntities());
		if (!subClass.isAnonymous()) {
			toReturn.add(subClass.asOWLClass());
		}
		return toReturn;
	}

	public boolean hasNoSubClass(OWLClassExpression superClass) {
		Set<OWLClass> subClasses = this.reasoner.getSubClasses(superClass,
				false).getFlattened();
		subClasses.addAll(this.reasoner.getEquivalentClasses(superClass)
				.getEntities());
		subClasses.remove(superClass);
		subClasses.removeAll(this.reasoner.getBottomClassNode().getEntities());
		return subClasses.isEmpty();
	}

	public boolean hasNoSuperClass(OWLClassExpression subClass) {
		Set<OWLClass> superClasses = this.reasoner.getSubClasses(subClass,
				false).getFlattened();
		superClasses.addAll(this.reasoner.getEquivalentClasses(subClass)
				.getEntities());
		superClasses.remove(subClass);
		superClasses.removeAll(this.reasoner.getTopClassNode().getEntities());
		return superClasses.isEmpty();
	}

	public Set<OWLNamedIndividual> getNamedFillers(OWLNamedIndividual subject,
			OWLObjectPropertyExpression objectProperty) {
		NodeSet<OWLNamedIndividual> fillers = this.reasoner
				.getObjectPropertyValues(subject, objectProperty);
		return fillers.getFlattened();
	}
}
