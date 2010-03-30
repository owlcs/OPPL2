package org.coode.parsers;

public interface SymbolVisitorEx<O> {
	O visitSymbol(Symbol symbol);

	O visitOWLEntity(OWLEntitySymbol owlEntitySymbol);
}
