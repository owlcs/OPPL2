package org.coode.parsers.oppl;

import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLSymbolVisitor extends SymbolVisitor {
	void visitStringVariableAttributeSymbol(
			StringVariableAttributeSymbol stringVariableAttributeSymbol);

	<P extends OWLObject> void visitCollectionVariableAttributeSymbol(
			CollectionVariableAttributeSymbol<P> collectionVariableAttributeSymbol);

	void visitCreateOnDemandIdentifier(CreateOnDemandIdentifier createOnDemandIdentifier);
}
