package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.function.ValuesVariableAtttribute;
import org.semanticweb.owlapi.model.OWLObject;

public class ValuesVariableAttributeSymbol<O extends OWLObject> extends
		CollectionVariableAttributeSymbol<O> {
	/**
	 * @param name
	 * @param type
	 * @param variableAttribute
	 */
	public ValuesVariableAttributeSymbol(String name, ValuesVariableAtttribute<O> variableAttribute) {
		super(name, variableAttribute);
	}
}
