package org.coode.parsers.oppl;

import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLLiteralSymbol;
import org.coode.parsers.Symbol;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;

public abstract class DefaultOPPLSymbolVisitorEx<O> implements OPPLSymbolVisitorEx<O> {
	protected abstract O doDefault(Symbol symbol);

	public <P> O visitCollectionVariableAttributeSymbol(
			CollectionVariableAttributeSymbol<P> collectionVariableAttributeSymbol) {
		return this.doDefault(collectionVariableAttributeSymbol);
	}

	public O visitStringVariableAttributeSymbol(
			StringVariableAttributeSymbol stringVariableAttributeSymbol) {
		return this.doDefault(stringVariableAttributeSymbol);
	}

	public O visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
		return this.doDefault(owlEntitySymbol);
	}

	public O visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
		return this.doDefault(owlConstantSymbol);
	}

	public O visitSymbol(Symbol symbol) {
		return this.doDefault(symbol);
	}

	public O visitCreateOnDemandIdentifier(CreateOnDemandIdentifier createOnDemandIdentifier) {
		return this.doDefault(createOnDemandIdentifier);
	}
}
