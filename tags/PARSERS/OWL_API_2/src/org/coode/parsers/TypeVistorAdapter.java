/**
 * 
 */
package org.coode.parsers;

/**
 * Void implementation of a TypeVisitor. Does nothing by default. Developer can
 * override the methods they are interested in leaving the others untouched.
 * 
 * @author Luigi Iannone
 * 
 */
public class TypeVistorAdapter implements TypeVisitor {
	/**
	 * @see org.coode.parsers.TypeVisitor#visitNonOWLType(org.coode.parsers.Type)
	 */
	public void visitNonOWLType(Type type) {
	}

	/**
	 * @see org.coode.parsers.TypeVisitor#visitOWLAxiomType(org.coode.parsers.OWLAxiomType)
	 */
	public void visitOWLAxiomType(OWLAxiomType owlAxiomType) {
	}

	/**
	 * @see org.coode.parsers.TypeVisitor#visitOWLType(org.coode.parsers.OWLType)
	 */
	public void visitOWLType(OWLType owlType) {
	}
}
