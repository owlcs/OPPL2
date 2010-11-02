package org.coode.parsers.oppl.variableattribute;

import java.util.Collection;

import org.coode.oppl.Variable;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

public abstract class CollectionVariableAttributeSymbol<O> extends
		VariableAttributeSymbol<Collection<O>> {
	/**
	 * @param name
	 * @param type
	 * @param variableAttribute
	 */
	public CollectionVariableAttributeSymbol(String name,
			VariableAttribute<Collection<O>> variableAttribute) {
		super(name, VariableAttributeType.COLLECTION, variableAttribute);
	}

	public void accept(OPPLSymbolVisitor visitor) {
		visitor.visitCollectionVariableAttributeSymbol(this);
	}

	public <P> P accept(OPPLSymbolVisitorEx<P> visitor) {
		return visitor.visitCollectionVariableAttributeSymbol(this);
	}

	public static <P extends OWLObject> CollectionVariableAttributeSymbol<P> getValues(
			Variable variable) {
		return new CollectionVariableAttributeSymbol<P>(variable.getName(),
				new ValuesVariableAtttribute<P>(variable)) {
		};
	}
}
