/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.parsers.Symbol;
import org.coode.parsers.oppl.OPPLSymbol;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class VariableAttributeSymbol<O> extends Symbol implements OPPLSymbol {
	private final AttributeFactory<O> factory;

	/**
	 * @param name
	 * @param type
	 */
	public VariableAttributeSymbol(String name, VariableAttributeType type,
			AttributeFactory<O> factory) {
		super(name, type);
		if (factory == null) {
			throw new NullPointerException("The factory cannot be null");
		}
		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public AttributeFactory<O> getFactory() {
		return this.factory;
	}

	public O create(ConstraintSystem constraintSystem) {
		return this.getFactory().create(constraintSystem);
	}
}
