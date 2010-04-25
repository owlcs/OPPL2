package org.coode.parsers.oppl;

import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.Symbol;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;

public abstract class DefaultOPPLSymbolVisitorEx<O> implements
		OPPLSymbolVisitorEx<O> {
	protected abstract O doDefault(Symbol symbol);

	public O visitCollectionVariableAttributeSymbol(
			CollectionVariableAttributeSymbol<?> collectionVariableAttributeSymbol) {
		return this.doDefault(collectionVariableAttributeSymbol);
	}

	public O visitStringVariableAttributeSymbol(
			StringVariableAttributeSymbol stringVariableAttributeSymbol) {
		return this.doDefault(stringVariableAttributeSymbol);
	}

	public O visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
		return this.doDefault(owlEntitySymbol);
	}

	public O visitSymbol(Symbol symbol) {
		return this.doDefault(symbol);
	}
}
