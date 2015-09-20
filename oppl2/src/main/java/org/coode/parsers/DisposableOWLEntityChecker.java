package org.coode.parsers;

import org.semanticweb.owlapi.expression.OWLEntityChecker;

/**
 * @author Luigi Iannone
 */
public interface DisposableOWLEntityChecker extends OWLEntityChecker {

    /** Frees up the resources used by this DisposableOWLEntityChecker. */
    void dispose();
}
