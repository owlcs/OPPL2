package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.semanticweb.owlapi.model.IRI;

/** @author Luigi Iannone */
public class IRISymbol extends Symbol {
    private final IRI iri;

    /** @return the iri */
    public IRI getIRI() {
        return iri;
    }

    /** @param name
     *            name
     * @param iri
     *            iri */
    public IRISymbol(String name, IRI iri) {
        super(name, OWLType.IRI);
        this.iri = checkNotNull(iri, "iri");
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
