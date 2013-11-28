package org.coode.parsers.oppl;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/** @author Luigi Iannone
 * @param <O> */
public interface IRIVisitorEx<O> extends OWLObjectVisitorEx<O> {
    /** @param iri
     * @return visitor value */
    O visitIRI(IRI iri);

    /** @param iri
     * @return visitor value */
    O visitVariableIRI(VariableIRI iri);
}
