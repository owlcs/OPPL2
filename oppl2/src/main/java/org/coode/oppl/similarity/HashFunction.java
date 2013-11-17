/**
 * 
 */
package org.coode.oppl.similarity;

import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public interface HashFunction {
    int getHashCode(OWLObject owlObject);
}
