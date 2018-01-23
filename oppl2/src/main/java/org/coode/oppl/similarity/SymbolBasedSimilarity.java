package org.coode.oppl.similarity;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.utils.OWLObjectExtractor;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Compares OWLObject instances only based on the symbols they contain.
 * 
 * @author Luigi Iannone
 */
public class SymbolBasedSimilarity implements SimilarityMeasure<OWLObject> {

    @Override
    public double compare(OWLObject anObject, OWLObject anotherObject) {
        Set<OWLObject> anObjectOWLPrimitives = extractSymbols(checkNotNull(anObject, "anObject"));
        Set<OWLObject> anotherObjectOWLPrimitives =
            extractSymbols(checkNotNull(anotherObject, "anotherObject"));
        return compareSymbols(anObjectOWLPrimitives, anotherObjectOWLPrimitives);
    }

    /**
     * Compares symbols computing the ratio of the size of their intersection over the size of their
     * union. Users may override this for different comparison strategies.
     * 
     * @param anObjectSymbols First Collection of Symbols. Cannot be {@code null}.
     * @param anotherObjectSymbols Second Collection of Symbols. Cannot be {@code null}.
     * @throws NullPointerException when either input is {@code null}.
     * @return the double representing the result of the comparison.
     */
    protected double compareSymbols(Collection<? extends OWLObject> anObjectSymbols,
        Collection<? extends OWLObject> anotherObjectSymbols) {
        checkNotNull(anObjectSymbols, "anObjectSymbols");
        checkNotNull(anotherObjectSymbols, "anotherObjectSymbols");
        // If both collection are empty 0 the method wil return 0
        double toReturn = anObjectSymbols.isEmpty() && anotherObjectSymbols.isEmpty() ? 0 : 1;
        if (toReturn > 0) {
            Set<OWLObject> intersection = new HashSet<>(anObjectSymbols);
            intersection.retainAll(anotherObjectSymbols);
            Set<OWLObject> union = new HashSet<>(anObjectSymbols);
            union.addAll(anotherObjectSymbols);
            toReturn = (double) intersection.size() / (double) union.size();
        }
        return toReturn;
    }

    /**
     * Extracts the relevant symbols for the comparison. Override this when a different set of
     * symbols from the all the OWLEntity and OWLConstant appearing the input object should be used.
     * 
     * @param anObject The OWLObject from which the symbols should be extracted. Cannot be
     *        {@code null}.
     * @return a Set containing the OWL Object (symbols) that can be used for the comparison. 1
     *         corresponds to maximum similarity, 0 to minimal.
     * @throws NullPointerException when the input is {@code null}.
     */
    protected Set<OWLObject> extractSymbols(OWLObject anObject) {
        return asSet(OWLObjectExtractor.getAllOWLPrimitives(checkNotNull(anObject, "anObject")));
    }

    @Override
    public boolean isSymmetric() {
        return true;
    }
}
