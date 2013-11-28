package org.coode.parsers.oppl;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObjectVisitor;

/** @author Luigi Iannone */
public interface IRIVisitor extends OWLObjectVisitor {
    /** @param iri */
    void visitIRI(IRI iri);

    /** @param iri */
    void visitVariableIRI(VariableIRI iri);
}
