package org.coode.parsers.oppl;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

public interface IRIVisitorEx<O> extends OWLObjectVisitorEx<O> {
	public O visitIRI(IRI iri);

	public O visitVariableIRI(VariableIRI iri);
}
