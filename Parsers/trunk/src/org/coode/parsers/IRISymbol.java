/**
 * 
 */
package org.coode.parsers;

import org.semanticweb.owlapi.model.IRI;

/** @author Luigi Iannone */
public class IRISymbol extends Symbol {
    private final IRI iri;

    /** @return the iri */
    public IRI getIRI() {
        return iri;
    }

    public IRISymbol(String name, IRI iri) {
        super(name, OWLType.IRI);
        if (iri == null) {
            throw new NullPointerException("The IRI cannot be null");
        }
        this.iri = iri;
    }

    @Override
    public void accept(SymbolVisitor visitor) {
        visitor.visitIRI(this);
    }

    @Override
    public <O> O accept(SymbolVisitorEx<O> visitor) {
        return visitor.visitIRI(this);
    }
}
