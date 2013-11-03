/**
 * 
 */
package org.coode.parsers;

import org.semanticweb.owlapi.model.OWLEntity;

/** @author Luigi Iannone */
public class OWLEntitySymbol extends Symbol {
    private final OWLEntity entity;

    /** @param name
     * @param type */
    public OWLEntitySymbol(String name, OWLEntity entity) {
        super(name, OWLType.get(entity));
        if (entity == null) {
            throw new NullPointerException("The entity cannot be null");
        }
        this.entity = entity;
    }

    /** @return the entity */
    public OWLEntity getEntity() {
        return entity;
    }

    @Override
    public void accept(SymbolVisitor visitor) {
        visitor.visitOWLEntity(this);
    }

    @Override
    public <O> O accept(SymbolVisitorEx<O> visitor) {
        return visitor.visitOWLEntity(this);
    }

    @Override
    public String toString() {
        return "Symbol name: " + getName() + " OWL Entity " + getEntity().toString();
    }
}
