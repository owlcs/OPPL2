package org.coode.parsers.oppl;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLLiteralSymbol;
import org.coode.parsers.Symbol;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public abstract class DefaultOPPLSymbolVisitorEx<O> implements OPPLSymbolVisitorEx<O> {
    protected abstract O doDefault(Symbol symbol);

    @Override
    public
            <P extends OWLObject, T extends VariableAttribute<Collection<? extends P>>>
            O
            visitCollectionVariableAttributeSymbol(
                    CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol) {
        return this.doDefault(collectionVariableAttributeSymbol);
    }

    @Override
    public O visitStringVariableAttributeSymbol(
            StringVariableAttributeSymbol stringVariableAttributeSymbol) {
        return this.doDefault(stringVariableAttributeSymbol);
    }

    @Override
    public O visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
        return this.doDefault(owlEntitySymbol);
    }

    @Override
    public O visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
        return this.doDefault(owlConstantSymbol);
    }

    @Override
    public O visitSymbol(Symbol symbol) {
        return this.doDefault(symbol);
    }

    @Override
    public O visitCreateOnDemandIdentifier(
            CreateOnDemandIdentifier createOnDemandIdentifier) {
        return this.doDefault(createOnDemandIdentifier);
    }
}
