package org.coode.oppl.variabletypes;

import java.util.HashMap;
import java.util.Map;

public enum VariableTypeName {
	CLASS, CONSTANT, OBJECTPROPERTY, DATAPROPERTY, INDIVIDUAL;
	private static final Map<String, VariableTypeName> cache = new HashMap<String, VariableTypeName>();
	static {
		cache.put("CLASS", CLASS);
		cache.put("OBJECTPROPERTY", OBJECTPROPERTY);
		cache.put("DATAPROPERTY", DATAPROPERTY);
		cache.put("INDIVIDUAL", INDIVIDUAL);
		cache.put("CONSTANT", CONSTANT);
	}

	public static VariableTypeName getVariableTypeName(String string) {
		return cache.get(string);
	}
}
