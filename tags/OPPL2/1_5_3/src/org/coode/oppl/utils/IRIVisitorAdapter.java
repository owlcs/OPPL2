package org.coode.oppl.utils;

import org.coode.parsers.oppl.IRIVisitor;
import org.coode.parsers.oppl.VariableIRI;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.util.OWLObjectVisitorAdapter;

public class IRIVisitorAdapter extends OWLObjectVisitorAdapter implements IRIVisitor {
	public void visitIRI(IRI iri) {
	}

	public void visitVariableIRI(VariableIRI iri) {
	}
}
