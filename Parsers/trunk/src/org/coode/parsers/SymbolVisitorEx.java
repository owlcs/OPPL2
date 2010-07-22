package org.coode.parsers;

public interface SymbolVisitorEx<O> {
	O visitSymbol(Symbol symbol);

	O visitOWLConstant(OWLConstantSymbol owlConstantSymbol);

	O visitOWLEntity(OWLEntitySymbol owlEntitySymbol);
}
