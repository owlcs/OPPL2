/**
 * 
 */
package org.coode.parsers;

/**
 * @author Luigi Iannone
 * 
 */
public interface TypeVisitor {
	void visitOWLType(OWLType owlType);

	void visitOWLAxiomType(OWLAxiomType owlAxiomType);

	void visitNonOWLType(Type type);
}
