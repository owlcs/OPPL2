package org.coode.oppl.similarity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Pair<O> {
    private final Set<O> members = new HashSet<O>(2);

    public Pair(O anOWLObject, O anotherOWLObject) {
        if (anOWLObject == null) {
            throw new NullPointerException("The first memebr of this pair cannot be null");
        }
        if (anotherOWLObject == null) {
            throw new NullPointerException(
                    "The second memebr of this pair cannot be null");
        }
        if (anotherOWLObject.equals(anOWLObject)) {
            throw new IllegalArgumentException(
                    "The pair is meant to be made of two distic entities");
        }
        this.members.add(anOWLObject);
        this.members.add(anotherOWLObject);
    }

    public Set<O> getMembers() {
        return new HashSet<O>(this.members);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.members == null ? 0 : this.members.hashCode());
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
        Pair<?> other = (Pair<?>) obj;
        if (this.members == null) {
            if (other.members != null) {
                return false;
            }
        } else if (!this.members.equals(other.members)) {
            return false;
        }
        return true;
    }

    public static <T> Set<Pair<T>> getAllPossiblePairs(Collection<? extends T> c) {
        Set<Pair<T>> toReturn = new HashSet<Pair<T>>();
        for (T t : c) {
            for (T anotherT : c) {
                if (!t.equals(anotherT)) {
                    toReturn.add(new Pair<T>(t, anotherT));
                }
            }
        }
        return toReturn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        // Explicit argument indices may be used to re-order output.
        Formatter format = formatter.format("(%s, %s)",
                new ArrayList<O>(this.members).toArray());
        return format.toString();
    }
}
