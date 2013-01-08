/**
 * 
 */
package org.coode.oppl.similarity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Luigi Iannone
 * 
 */
public class ProgressiveSimilarityMeasure<O> implements SimilarityMeasure<O> {
	private final List<SimilarityMeasure<O>> measureList = new ArrayList<SimilarityMeasure<O>>();

	public ProgressiveSimilarityMeasure(List<? extends SimilarityMeasure<O>> measures) {
		if (measures == null) {
			throw new NullPointerException("The measure list cannot be null");
		}
		if (measures.isEmpty()) {
			throw new IllegalArgumentException("The measure list cannot be empty");
		}
		this.measureList.addAll(measures);
	}

	public boolean isSymmetric() {
		boolean notSymmetric = false;
        Iterator<SimilarityMeasure<O>> iterator = this.measureList.iterator();
		while (iterator.hasNext() && !notSymmetric) {
			SimilarityMeasure<O> similarityMeasure = iterator.next();
			notSymmetric = !similarityMeasure.isSymmetric();
		}
		return !notSymmetric;
	}

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
		return new ArrayList<SimilarityMeasure<O>>(this.measureList);
	}
}
