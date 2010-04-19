/**
 * 
 */
package org.coode.parsers;

/**
 * @author Luigi Iannone
 * 
 */
public interface TypeVisitorEx<O> {
	O visitOWLType(OWLType owlType);

	O visitOWLAxiomType(OWLAxiomType owlAxiomType);

	O visitNonOWLType(Type type);
}
