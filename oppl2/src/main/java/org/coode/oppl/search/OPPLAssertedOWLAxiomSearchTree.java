package org.coode.oppl.search;

import java.util.Iterator;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 */
public class OPPLAssertedOWLAxiomSearchTree extends AbstractOPPLAxiomSearchTree {

    /**
     * @param constraintSystem
     *        constraintSystem
     * @param runtimeExceptionHandler
     *        runtimeExceptionHandler
     */
    public OPPLAssertedOWLAxiomSearchTree(ConstraintSystem constraintSystem,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        super(constraintSystem, runtimeExceptionHandler);
    }

    @Override
    protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
        boolean found = false;
        Iterator<OWLOntology> iterator = getConstraintSystem().getOntologyManager()
            .getOntologies().iterator();
        while (!found && iterator.hasNext()) {
            OWLOntology ontology = iterator.next();
            found = ontology.containsAxiom(start.getAxiom());
        }
        return found;
    }
}
