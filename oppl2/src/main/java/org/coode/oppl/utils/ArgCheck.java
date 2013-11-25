package org.coode.oppl.utils;


public class ArgCheck {
    public static <T> T checkNotNull(T o, String name) {
        if (o == null) {
            throw new IllegalArgumentException(name + " cannot be null");
        }
        if (o instanceof Iterable) {
            int i = 0;
            for (Object obj : (Iterable<?>) o) {
                if (obj == null) {
                    throw new IllegalArgumentException(name
                            + " cannot contain nulls, but contains a null at position: "
                            + i);
                }
                i++;
            }
        }
        return o;
    }

    public static <T> T checkNotNull(T o) {
        return checkNotNull(o, "the object");
    }
}
