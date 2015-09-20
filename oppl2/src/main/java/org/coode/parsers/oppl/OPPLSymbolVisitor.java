package org.coode.parsers.oppl;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public interface OPPLSymbolVisitor extends SymbolVisitor {

    /**
     * @param stringVariableAttributeSymbol
     *        stringVariableAttributeSymbol
     */
    void visitStringVariableAttributeSymbol(
        StringVariableAttributeSymbol stringVariableAttributeSymbol);

    /**
     * @param collectionVariableAttributeSymbol
     *        collectionVariableAttributeSymbol
     * @param
     *        <P>
     *        variable type
     * @param <T>
     *        attribute type
     */
    <P extends OWLObject, T extends VariableAttribute<Collection<? extends P>>> void visitCollectionVariableAttributeSymbol(
        CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol);

    /**
     * @param createOnDemandIdentifier
     *        createOnDemandIdentifier
     */
    void visitCreateOnDemandIdentifier(CreateOnDemandIdentifier createOnDemandIdentifier);
}
