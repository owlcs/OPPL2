package org.coode.parsers.oppl;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.SymbolVisitorEx;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLSymbolVisitorEx<O> extends SymbolVisitorEx<O> {
    O visitStringVariableAttributeSymbol(
            StringVariableAttributeSymbol stringVariableAttributeSymbol);

            <P extends OWLObject, T extends VariableAttribute<Collection<? extends P>>>
            O
            visitCollectionVariableAttributeSymbol(
                    CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol);

    O visitCreateOnDemandIdentifier(CreateOnDemandIdentifier createOnDemandIdentifier);
}
