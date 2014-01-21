package org.coode.oppl.similarity;

import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public interface HashFunction {
    /** @param owlObject
     *            owlObject
     * @return hashcode */
    int getHashCode(OWLObject owlObject);
}
