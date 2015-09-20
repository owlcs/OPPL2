package org.coode.oppl.similarity;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public class ProgressiveSimilarityMeasure<O> implements SimilarityMeasure<O> {

    private final List<SimilarityMeasure<O>> measureList = new ArrayList<>();

    /**
     * @param measures
     *        measures
     */
    public ProgressiveSimilarityMeasure(List<? extends SimilarityMeasure<O>> measures) {
        this.measureList.addAll(checkNotNull(measures, "measures"));
        if (measures.isEmpty()) {
            throw new IllegalArgumentException("The measure list cannot be empty");
        }
    }

    @Override
    public boolean isSymmetric() {
        boolean notSymmetric = false;
        Iterator<SimilarityMeasure<O>> iterator = this.measureList.iterator();
        while (iterator.hasNext() && !notSymmetric) {
            SimilarityMeasure<O> similarityMeasure = iterator.next();
            notSymmetric = !similarityMeasure.isSymmetric();
        }
        return !notSymmetric;
    }

    @Override
    public double compare(O anObject, O anotherObject) {
        double toReturn = 1;
        boolean found = false;
        Iterator<SimilarityMeasure<O>> iterator = this.measureList.iterator();
        while (!found && iterator.hasNext()) {
            SimilarityMeasure<O> similarityMeasure = iterator.next();
            toReturn = toReturn * similarityMeasure.compare(anObject, anotherObject);
            found = toReturn != 1;
        }
        return toReturn;
    }

    /**
     * @return the measureList
     */
    public final List<SimilarityMeasure<O>> getMeasureList() {
        return new ArrayList<>(this.measureList);
    }
}
