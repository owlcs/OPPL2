package org.coode.oppl.variabletypes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luigi Iannone
 */
public enum VariableTypeName {
    /** class */
    CLASS,
    /** literal */
    CONSTANT,
    /** object property */
    OBJECTPROPERTY,
    /** data property */
    DATAPROPERTY,
    /** annotation property */
    ANNOTATIONPROPERTY,
    /** individual */
    INDIVIDUAL;

    private static final Map<String, VariableTypeName> cache = new HashMap<>();

    static {
        cache.put("CLASS", CLASS);
        cache.put("OBJECTPROPERTY", OBJECTPROPERTY);
        cache.put("DATAPROPERTY", DATAPROPERTY);
        cache.put("INDIVIDUAL", INDIVIDUAL);
        cache.put("CONSTANT", CONSTANT);
    }

    /**
     * @param string
     *        string
     * @return cache variable type name
     */
    public static VariableTypeName getVariableTypeName(String string) {
        return cache.get(string);
    }
}
