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
	private final VariableAttribute<?> variableAttribute;

	/**
	 * @param name
	 * @param type
	 */
	public VariableAttributeSymbol(String name, VariableAttributeType type,
			AttributeFactory<O> factory, VariableAttribute<?> variableAttribute) {
		super(name, type);
		if (factory == null) {
			throw new NullPointerException("The factory cannot be null");
		}
		if (variableAttribute == null) {
			throw new NullPointerException("The attribute canot be null");
		}
		this.factory = factory;
		this.variableAttribute = variableAttribute;
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

	/**
	 * @return the variableAttribute
	 */
	public VariableAttribute<?> getVariableAttribute() {
		return this.variableAttribute;
	}

	@Override
	public String getName() {
		return super.getName() + "." + this.getVariableAttribute();
	}

	@Override
	public String toString() {
		return this.getName() + "." + this.getVariableAttribute();
	}
}
