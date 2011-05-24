package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.function.AttributeName;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.semanticweb.owlapi.model.OWLObject;

public class ValuesVariableAttributeSymbol<P extends OWLObject> extends
		CollectionVariableAttributeSymbol<P, ValuesVariableAtttribute<P>> {
	/**
	 * @param name
	 * @param type
	 * @param variableAttribute
	 */
	public ValuesVariableAttributeSymbol(String name, ValuesVariableAtttribute<P> variableAttribute) {
		super(String.format("%s.%s", name, AttributeName.VALUES), variableAttribute);
	}

	public static <T extends OWLObject> ValuesVariableAttributeSymbol<T> getValuesVariableAttributeSymbol(
			String name, ValuesVariableAtttribute<T> variableAttribute) {
		return new ValuesVariableAttributeSymbol<T>(name, variableAttribute);
	}
}
