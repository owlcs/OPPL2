package org.coode.oppl.similarity;

/** A generic metric to asses the similarity between two objects of the same
 * kind.
 * 
 * @author Luigi Iannone
 * @param <O>
 *            type */
public interface SimilarityMeasure<O> {
    /** @return {@code true} if {@code compare(A,B) == compare (B,A)} */
    boolean isSymmetric();

    /** Compares the two input objects. It required for this interface to
     * implement this method in accordance to the {@code equals} method available
     * for {@code O}. If {@code isSymmetric} returns {@code true}, then it must
     * hold that {@code compare(A,B) == compare (B,A)}.
     * 
     * @param anObject
     *            the first object to compare. cannot be {@code null}.
     * @param anotherObject
     *            the first object to compare. cannot be {@code null}.
     * @return a number between 0 and 1. 1 corresponds to maximum similarity, 0
     *         to minimal
     * @throws NullPointerException
     *             if either input is {@code null}. */
    double compare(O anObject, O anotherObject);
}
