/**
 * 
 */
package org.coode.oppl.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.PrimeNumbersUtils;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class SymbolBasedHashFunction implements HashFunction {
    private final Map<OWLEntity, Integer> entityHashCodes = new HashMap<OWLEntity, Integer>();
    private final Map<OWLLiteral, Integer> owlConstantHashCodes = new HashMap<OWLLiteral, Integer>();
    private int maxPrime = 1;

    @Override
    public int getHashCode(OWLObject owlObject) {
        Set<OWLEntity> entities = OWLObjectExtractor.getAllOWLEntities(owlObject);
        int toReturn = 1;
        for (OWLEntity owlEntity : entities) {
            toReturn = toReturn * this.createHashCode(owlEntity);
        }
        Set<OWLLiteral> allOWLConstants = OWLObjectExtractor.getAllOWLLiterals(owlObject);
        for (OWLLiteral owlConstant : allOWLConstants) {
            toReturn = toReturn * this.createHashCode(owlConstant);
        }
        return toReturn;
    }

    protected int createHashCode(OWLLiteral constant) {
        return this.createHashCode(constant, owlConstantHashCodes);
    }

    protected int createHashCode(OWLEntity owlEntity) {
        return this.createHashCode(owlEntity, entityHashCodes);
    }

    private <O extends Object> int createHashCode(O key, Map<O, Integer> map) {
        int toReturn = PrimeNumbersUtils.getNextPrime(getMaxPrime());
        map.put(key, toReturn);
        setMaxPrime(toReturn);
        return toReturn;
    }

    /** @return the maxPrime */
    public int getMaxPrime() {
        return maxPrime;
    }

    /** @param maxPrime
     *            the maxPrime to set */
    private void setMaxPrime(int maxPrime) {
        this.maxPrime = maxPrime;
    }
}
