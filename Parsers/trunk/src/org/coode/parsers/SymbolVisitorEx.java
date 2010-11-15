package org.coode.parsers;

public interface SymbolVisitorEx<O> {
	O visitSymbol(Symbol symbol);

	O visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol);

	O visitOWLEntity(OWLEntitySymbol owlEntitySymbol);

	O visitIRI(IRISymbol iriSymbol);
}
