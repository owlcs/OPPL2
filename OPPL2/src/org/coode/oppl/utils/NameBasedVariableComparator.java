package org.coode.oppl.utils;

import java.util.Comparator;

import org.coode.oppl.Variable;

public class NameBasedVariableComparator implements Comparator<Variable<?>> {
	private final static NameBasedVariableComparator INSTANCE = new NameBasedVariableComparator();

	private NameBasedVariableComparator() {
	}

	public int compare(Variable<?> aVariable, Variable<?> anotherVariable) {
		int toReturn = 0;
		if (aVariable == null) {
			if (anotherVariable != null) {
				toReturn = -1;
			}
		} else if (anotherVariable == null) {
			toReturn = 1;
		} else {
			toReturn = aVariable.getName().compareTo(anotherVariable.getName());
			if (toReturn == 0) {
				toReturn = aVariable.getType().toString().compareTo(
						anotherVariable.getType().toString());
			}
		}
		return toReturn;
	}

	/**
	 * @return the instance
	 */
	public static NameBasedVariableComparator getInstance() {
		return INSTANCE;
	}
}
