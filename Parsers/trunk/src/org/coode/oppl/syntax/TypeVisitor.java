/**
 * 
 */
package org.coode.oppl.syntax;

/**
 * @author Luigi Iannone
 * 
 */
public interface TypeVisitor {
	void visitOWLType(OWLType owlType);

	void visitOWLAxiomType(OWLAxiomType owlAxiomType);
}
