package org.coode.parsers.oppl;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.SymbolVisitorEx;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone
 * @param <O> */
public interface OPPLSymbolVisitorEx<O> extends SymbolVisitorEx<O> {
    /** @param stringVariableAttributeSymbol
     * @return visitor value */
    O visitStringVariableAttributeSymbol(
            StringVariableAttributeSymbol stringVariableAttributeSymbol);

    /** @param collectionVariableAttributeSymbol
     * @return visitor value */
            <P extends OWLObject, T extends VariableAttribute<Collection<? extends P>>>
            O
            visitCollectionVariableAttributeSymbol(
                    CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol);

    /** @param createOnDemandIdentifier
     * @return visitor value */
    O visitCreateOnDemandIdentifier(CreateOnDemandIdentifier createOnDemandIdentifier);
}
