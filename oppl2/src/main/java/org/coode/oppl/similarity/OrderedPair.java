package org.coode.oppl.similarity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public class OrderedPair<O> extends Pair<O> {

    /**
     * @param first
     *        first
     * @param second
     *        second
     */
    public OrderedPair(O first, O second) {
        super(first, second);
    }

    /**
     * @return the first
     */
    public O getFirst() {
        return o1;
    }

    /**
     * @return the second
     */
    public O getSecond() {
        return o2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + o1.hashCode();
        result = prime * result + o2.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        OrderedPair<?> other = (OrderedPair<?>) obj;
        return o1.equals(other.o2) && o2.equals(other.o2);
    }

    /**
     * @param c
     *        c
     * @param <T>
     *        type
     * @return all ordered pairs
     */
    public static <T> Set<OrderedPair<T>> getAllPossibleOrderedPairs(
        Collection<? extends T> c) {
        Set<OrderedPair<T>> toReturn = new HashSet<>();
        for (T t : c) {
            for (T anotherT : c) {
                toReturn.add(new OrderedPair<>(t, anotherT));
            }
        }
        return toReturn;
    }
}
