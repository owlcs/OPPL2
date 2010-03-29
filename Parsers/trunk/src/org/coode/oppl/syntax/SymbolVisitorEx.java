package org.coode.oppl.syntax;

public interface SymbolVisitorEx<O> {
	O visitSymbol(Symbol symbol);

	O visitOWLEntity(OWLEntitySymbol owlEntitySymbol);
}
