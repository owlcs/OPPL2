/**
 * 
 */
package org.coode.parsers;

import org.semanticweb.owl.model.OWLEntity;

/**
 * @author Luigi Iannone
 * 
 */
public class OWLEntitySymbol extends Symbol {
	private final OWLEntity entity;

	/**
	 * @param name
	 * @param type
	 */
	public OWLEntitySymbol(String name, OWLType type, OWLEntity entity) {
		super(name, type);
		if (entity == null) {
			throw new NullPointerException("The entity cannot be null");
		}
		this.entity = entity;
	}

	/**
	 * @return the entity
	 */
	public OWLEntity getEntity() {
		return this.entity;
	}

	@Override
	public void accept(SymbolVisitor visitor) {
		visitor.visitOWLEntity(this);
	}

	@Override
	public <O> O accept(SymbolVisitorEx<O> visitor) {
		return visitor.visitOWLEntity(this);
	}
}
