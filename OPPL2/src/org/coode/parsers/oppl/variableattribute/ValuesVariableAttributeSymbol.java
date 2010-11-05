package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.function.ValuesVariableAtttribute;
import org.semanticweb.owlapi.model.OWLObject;

public class ValuesVariableAttributeSymbol<P extends OWLObject> extends
		CollectionVariableAttributeSymbol<P, ValuesVariableAtttribute<P>> {
	/**
	 * @param name
	 * @param type
	 * @param variableAttribute
	 */
	public ValuesVariableAttributeSymbol(String name,
			ValuesVariableAtttribute<P> variableAttribute) {
		super(name, variableAttribute);
	}
}
