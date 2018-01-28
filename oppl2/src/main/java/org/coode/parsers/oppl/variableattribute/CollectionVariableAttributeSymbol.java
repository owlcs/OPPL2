package org.coode.parsers.oppl.variableattribute;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * @param <P> type
 * @param <O> attribute type
 */
public abstract class CollectionVariableAttributeSymbol<P extends OWLObject, O extends VariableAttribute<Collection<P>>>
    extends VariableAttributeSymbol<O> {

    /**
     * @param name name
     * @param variableAttribute variableAttribute
     */
    public CollectionVariableAttributeSymbol(String name, O variableAttribute) {
        super(name, VariableAttributeType.COLLECTION, variableAttribute);
    }

    @Override
    public void accept(OPPLSymbolVisitor visitor) {
        visitor.visitCollectionVariableAttributeSymbol(this);
    }

    @Override
    public <T> T accept(OPPLSymbolVisitorEx<T> visitor) {
        return visitor.visitCollectionVariableAttributeSymbol(this);
    }
}
