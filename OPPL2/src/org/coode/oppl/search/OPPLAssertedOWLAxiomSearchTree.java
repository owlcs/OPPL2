/**
 *
 */
package org.coode.oppl.search;

import java.util.Iterator;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLAssertedOWLAxiomSearchTree extends AbstractOPPLAxiomSearchTree {
	/**
	 * @param constraintSystem
	 * @param runtimeExceptionHandler
	 */
	public OPPLAssertedOWLAxiomSearchTree(ConstraintSystem constraintSystem,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		super(constraintSystem, runtimeExceptionHandler);
	}

	/**
	 * @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
	 *         represents an OWLAxiom that is contained in one of the ontologies
	 *         managed by the ontology manager encapsulated in this
	 *         OPPLOWLAxiomSearchTree.
	 * @see org.coode.oppl.search.SearchTree#goalReached(java.lang.Object)
	 */
	@Override
	protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
		boolean found = false;
		Iterator<OWLOntology> iterator = this.getConstraintSystem()
				.getOntologyManager().getOntologies().iterator();
		while (!found && iterator.hasNext()) {
			OWLOntology ontology = iterator.next();
			found = ontology.containsAxiom(start.getAxiom());
		}
		return found;
	}
}
