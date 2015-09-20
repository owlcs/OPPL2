package org.coode.parsers;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public abstract class DefaultTypeVistorEx<O> implements TypeVisitorEx<O> {

    protected abstract O doDefault(Type type);

    @Override
    public O visitNonOWLType(Type type) {
        return this.doDefault(type);
    }

    @Override
    public O visitOWLAxiomType(OWLAxiomType owlAxiomType) {
        return this.doDefault(owlAxiomType);
    }

    @Override
    public O visitOWLType(OWLType owlType) {
        return this.doDefault(owlType);
    }
}
