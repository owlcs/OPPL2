package org.coode.oppl.utils;

import org.coode.parsers.oppl.IRIVisitorEx;
import org.coode.parsers.oppl.VariableIRI;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public class IRIVisitorExAdapter<O> extends OWLObjectVisitorExAdapter<O> implements
        IRIVisitorEx<O> {
    /** default constructor */
    public IRIVisitorExAdapter() {
        super();
    }

    /** @param defaultReturnValue
     *            defaultReturnValue */
    public IRIVisitorExAdapter(O defaultReturnValue) {
        super(defaultReturnValue);
    }

    @Override
    public O visit(IRI iri) {
        return this.visitIRI(iri);
    }

    @Override
    public O visitIRI(IRI iri) {
        return getDefaultReturnValue(iri);
    }

    @Override
    public O visitVariableIRI(VariableIRI iri) {
        return getDefaultReturnValue(iri);
    }
}
