package org.coode.parsers.oppl;

import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;

public interface OPPLSymbolVisitor extends SymbolVisitor {
	void visitStringVariableAttributeSymbol(
			StringVariableAttributeSymbol stringVariableAttributeSymbol);

	void visitCollectionVariableAttributeSymbol(
			CollectionVariableAttributeSymbol<?> collectionVariableAttributeSymbol);
}
