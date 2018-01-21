package org.coode.oppl.utils;

import org.coode.parsers.oppl.IRIVisitorEx;
import org.coode.parsers.oppl.VariableIRI;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/**
 * @author Luigi Iannone
 * @param <O> type
 */
public class IRIVisitorExAdapter<O> implements OWLObjectVisitorEx<O>, IRIVisitorEx<O> {

    private O value;

    /** default constructor */
    public IRIVisitorExAdapter() {
        this(null);
    }

    @Override
    public <T> O doDefault(T object) {
        return value;
    }

    /**
     * @param defaultReturnValue defaultReturnValue
     */
    public IRIVisitorExAdapter(O defaultReturnValue) {
        value = defaultReturnValue;
    }

    @Override
    public O visit(IRI iri) {
        return this.visitIRI(iri);
    }

    @Override
    public O visitIRI(IRI iri) {
        return doDefault(iri);
    }

    @Override
    public O visitVariableIRI(VariableIRI iri) {
        return doDefault(iri);
    }
}
