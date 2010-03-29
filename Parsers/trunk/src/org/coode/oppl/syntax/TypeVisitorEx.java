/**
 * 
 */
package org.coode.oppl.syntax;

/**
 * @author Luigi Iannone
 * 
 */
public interface TypeVisitorEx<O> {
	O visitOWLType(OWLType owlType);

	O visitOWLAxiomType(OWLAxiomType owlAxiomType);
}
