/**
 * 
 */
package org.coode.oppl.similarity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

final class OrderedPair<O> extends Pair<O> {
	private final O first;
	private final O second;

	/**
	 * @param first
	 * @param second
	 */
	public OrderedPair(O first, O second) {
		super(first, second);
		this.first = first;
		this.second = second;
	}

	/**
	 * @return the first
	 */
	public O getFirst() {
		return this.first;
	}

	/**
	 * @return the second
	 */
	public O getSecond() {
		return this.second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.getFirst() == null ? 0 : this.getFirst().hashCode());
		result = prime * result + (this.getSecond() == null ? 0 : this.getSecond().hashCode());
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
		if (this.getFirst() == null) {
			if (other.getFirst() != null) {
				return false;
			}
		} else if (!this.getFirst().equals(other.getFirst())) {
			return false;
		}
		if (this.getSecond() == null) {
			if (other.getSecond() != null) {
				return false;
			}
		} else if (!this.getSecond().equals(other.getSecond())) {
			return false;
		}
		return true;
	}

	public static <T> Set<OrderedPair<T>> getAllPossibleOrderedPairs(Collection<? extends T> c) {
		Set<OrderedPair<T>> toReturn = new HashSet<OrderedPair<T>>();
		for (T t : c) {
			for (T anotherT : c) {
				toReturn.add(new OrderedPair<T>(t, anotherT));
			}
		}
		return toReturn;
	}
}