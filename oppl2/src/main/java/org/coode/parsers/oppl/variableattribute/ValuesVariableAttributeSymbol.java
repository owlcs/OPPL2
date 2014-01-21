package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.function.AttributeName;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone
 * @param <P>
 *            type */
public class ValuesVariableAttributeSymbol<P extends OWLObject> extends
        CollectionVariableAttributeSymbol<P, ValuesVariableAtttribute<P>> {
    /** @param name
     *            name
     * @param variableAttribute
     *            variableAttribute */
    public ValuesVariableAttributeSymbol(String name,
            ValuesVariableAtttribute<P> variableAttribute) {
        super(String.format("%s.%s", name, AttributeName.VALUES), variableAttribute);
    }

    /** @param name
     *            name
     * @param variableAttribute
     *            variableAttribute
     * @param <T>
     *            variable type
     * @return values variable attribute symbol */
    public static <T extends OWLObject> ValuesVariableAttributeSymbol<T>
            getValuesVariableAttributeSymbol(String name,
                    ValuesVariableAtttribute<T> variableAttribute) {
        return new ValuesVariableAttributeSymbol<T>(name, variableAttribute);
    }
}
