/**
 * 
 */
package org.coode.oppl.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.PrimeNumbersUtils;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class SymbolBasedHashFunction implements HashFunction {
	private final Map<OWLEntity, Integer> entityHashCodes = new HashMap<OWLEntity, Integer>();
	private final Map<OWLConstant, Integer> owlConstantHashCodes = new HashMap<OWLConstant, Integer>();
	private int maxPrime = 1;

	public int getHashCode(OWLObject owlObject) {
		Set<OWLEntity> entities = OWLObjectExtractor.getAllOWLEntities(owlObject);
		int toReturn = 1;
		for (OWLEntity owlEntity : entities) {
			toReturn = toReturn * this.createHashCode(owlEntity);
		}
		Set<OWLConstant> allOWLConstants = OWLObjectExtractor.getAllOWLConstants(owlObject);
		for (OWLConstant owlConstant : allOWLConstants) {
			toReturn = toReturn * this.createHashCode(owlConstant);
		}
		return toReturn;
	}

	protected int createHashCode(OWLConstant constant) {
		return this.createHashCode(constant, this.owlConstantHashCodes);
	}

	protected int createHashCode(OWLEntity owlEntity) {
		return this.createHashCode(owlEntity, this.entityHashCodes);
	}

	private <O extends Object> int createHashCode(O key, Map<O, Integer> map) {
		int toReturn = PrimeNumbersUtils.getNextPrime(this.getMaxPrime());
		map.put(key, toReturn);
		this.setMaxPrime(toReturn);
		return toReturn;
	}

	/**
	 * @return the maxPrime
	 */
	public int getMaxPrime() {
		return this.maxPrime;
	}

	/**
	 * @param maxPrime
	 *            the maxPrime to set
	 */
	private void setMaxPrime(int maxPrime) {
		this.maxPrime = maxPrime;
	}
}
