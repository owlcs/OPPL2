/**
 * 
 */
package org.coode.parsers.oppl;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObjectVisitor;

/**
 * @author Luigi Iannone
 * 
 */
public interface IRIVisitor extends OWLObjectVisitor {
	public void visitIRI(IRI iri);

	public void visitVariableIRI(VariableIRI iri);
}
