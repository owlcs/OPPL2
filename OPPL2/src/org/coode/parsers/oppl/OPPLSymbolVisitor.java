package org.coode.parsers.oppl;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLSymbolVisitor extends SymbolVisitor {
	void visitStringVariableAttributeSymbol(
			StringVariableAttributeSymbol stringVariableAttributeSymbol);

	<P extends OWLObject, T extends VariableAttribute<Collection<P>>> void visitCollectionVariableAttributeSymbol(
			CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol);

	void visitCreateOnDemandIdentifier(
			CreateOnDemandIdentifier createOnDemandIdentifier);
}
