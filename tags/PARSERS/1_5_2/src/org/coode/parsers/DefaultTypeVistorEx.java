/**
 * 
 */
package org.coode.parsers;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultTypeVistorEx<O> implements TypeVisitorEx<O> {
	protected abstract O doDefault(Type type);

	/**
	 * @see org.coode.parsers.TypeVisitorEx#visitNonOWLType(org.coode.parsers.Type)
	 */
	public O visitNonOWLType(Type type) {
		return this.doDefault(type);
	}

	/**
	 * @see org.coode.parsers.TypeVisitorEx#visitOWLAxiomType(org.coode.parsers.OWLAxiomType)
	 */
	public O visitOWLAxiomType(OWLAxiomType owlAxiomType) {
		return this.doDefault(owlAxiomType);
	}

	/**
	 * @see org.coode.parsers.TypeVisitorEx#visitOWLType(org.coode.parsers.OWLType)
	 */
	public O visitOWLType(OWLType owlType) {
		return this.doDefault(owlType);
	}
}
