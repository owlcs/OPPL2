/**
 * 
 */
package org.coode.oppl.similarity;

import org.semanticweb.owlapi.model.OWLObject;

/** This measure is based on an Hashing function that maps each OWLObject into a
 * product of prime numbers. Prime number factorization is unique, hence
 * dividing the hash codes one can easily spot the differences.
 * 
 * @author Luigi Iannone */
public class OWLObjectStructuralPrimeHashingBasedSimilarityMeasure implements
        SimilarityMeasure<OWLObject> {
    private final HashFunction hashFunction = new StructuralHashFunction();

    @Override
    public double compare(OWLObject anObject, OWLObject anotherObject) {
        double anObjectHashValue = getHashFunction().getHashCode(anObject);
        double anotherObjectHashValue = getHashFunction().getHashCode(anotherObject);
        return anObjectHashValue > anotherObjectHashValue ? anotherObjectHashValue
                / anObjectHashValue : anObjectHashValue / anotherObjectHashValue;
    }

    @Override
    public boolean isSymmetric() {
        return true;
    }

    /** @return the hashFunction */
    public HashFunction getHashFunction() {
        return hashFunction;
    }
}
