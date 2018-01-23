package org.coode.oppl.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.PrimeNumbersUtils;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class SymbolBasedHashFunction implements HashFunction {

    private final Map<OWLEntity, Integer> entityHashCodes = new HashMap<>();
    private final Map<OWLLiteral, Integer> owlConstantHashCodes = new HashMap<>();
    private int maxPrime = 1;

    @Override
    public int getHashCode(OWLObject owlObject) {
        AtomicInteger toReturn = new AtomicInteger(1);
        OWLObjectExtractor.getAllOWLEntities(owlObject)
            .forEach(e -> toReturn.set(toReturn.get() * this.createHashCode(e)));
        OWLObjectExtractor.getAllOWLLiterals(owlObject)
            .forEach(e -> toReturn.set(toReturn.get() * this.createHashCode(e)));
        return toReturn.get();
    }

    protected int createHashCode(OWLLiteral constant) {
        return this.createHashCode(constant, owlConstantHashCodes);
    }

    protected int createHashCode(OWLEntity owlEntity) {
        return this.createHashCode(owlEntity, entityHashCodes);
    }

    private <O extends Object> int createHashCode(O key, Map<O, Integer> map) {
        int toReturn = PrimeNumbersUtils.getNextPrime(getMaxPrime());
        map.put(key, Integer.valueOf(toReturn));
        setMaxPrime(toReturn);
        return toReturn;
    }

    /**
     * @return the maxPrime
     */
    public int getMaxPrime() {
        return maxPrime;
    }

    /**
     * @param maxPrime the maxPrime to set
     */
    private void setMaxPrime(int maxPrime) {
        this.maxPrime = maxPrime;
    }
}
