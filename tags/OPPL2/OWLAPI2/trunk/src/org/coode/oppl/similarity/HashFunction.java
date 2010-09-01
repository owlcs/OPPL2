/**
 * 
 */
package org.coode.oppl.similarity;

import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public interface HashFunction {
	int getHashCode(OWLObject owlObject);
}
