/**
 * 
 */
package org.coode.oppl.search.solvability;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
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
		Set<OWLClass> toReturn = this.reasoner.getSubClasses(superClass, false).getFlattened();
		toReturn.addAll(this.reasoner.getEquivalentClasses(superClass).getEntities());
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
		Set<OWLClass> toReturn = this.reasoner.getSuperClasses(subClass, false).getFlattened();
		toReturn.addAll(this.reasoner.getEquivalentClasses(subClass).getEntities());
		if (!subClass.isAnonymous()) {
			toReturn.add(subClass.asOWLClass());
		}
		return toReturn;
	}
}
