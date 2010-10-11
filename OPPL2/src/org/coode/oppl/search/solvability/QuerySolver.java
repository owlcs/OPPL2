package org.coode.oppl.search.solvability;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;

public interface QuerySolver {
	/**
	 * Retrieves all the named classes that are a sub-classes of the input
	 * OWLClassExpression. The implementation decides whether and how much
	 * inference is used for determining the sub-class relationship.
	 * 
	 * @param superClass
	 * @return A Set of OWLClass instances.
	 */
	Set<OWLClass> getSubClasses(OWLClassExpression superClass);

	/**
	 * Retrieves all the named classes that are a super-classes of the input
	 * OWLClassExpression. The implementation decides whether and how much
	 * inference is used for determining the sub-class relationship.
	 * 
	 * @param subClass
	 * @return A Set of OWLClass instances.
	 */
	Set<OWLClass> getSuperClasses(OWLClassExpression subClass);

	/**
	 * Determines whether the input OWLClassExpression has no sub-class. The
	 * implementation decides whether and how much inference is used for
	 * determining the sub-class relationship. Please notice that owl:Nothing
	 * <b>must not</b> be taken into account.
	 * 
	 * @param superClass
	 * @return <code>true</code> is the input superClass does not have any
	 *         sub-class except for owl:Nothing.
	 */
	boolean hasNoSubClass(OWLClassExpression superClass);

	/**
	 * Determines whether the input OWLClassExpression has no super-class. The
	 * implementation decides whether and how much inference is used for
	 * determining the sub-class relationship. Please notice that owl:Thing
	 * <b>must not</b> be taken into account.
	 * 
	 * @param subClass
	 * @return <code>true</code> is the input subClass does not have any
	 *         super-class except for owl:Thing.
	 */
	boolean hasNoSuperClass(OWLClassExpression subClass);
}
