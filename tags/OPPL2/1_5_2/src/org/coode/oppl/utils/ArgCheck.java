package org.coode.oppl.utils;

public class ArgCheck {
	public static void checkNullArgument(String name, Object o) {
		if (o == null) {
			throw new IllegalArgumentException(name + " cannot be null");
		}
	}
}
