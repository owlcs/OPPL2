/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.OPPLSymbol;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class VariableAttributeSymbol<O> extends Symbol implements OPPLSymbol {
	private final VariableAttribute<O> variableAttribute;

	/**
	 * @return the variableAttribute
	 */
	public VariableAttribute<O> getVariableAttribute() {
		return this.variableAttribute;
	}

	/**
	 * @param name
	 * @param type
	 */
	public VariableAttributeSymbol(String name, Type type, VariableAttribute<O> variableAttribute) {
		super(name, type);
		if (variableAttribute == null) {
			throw new NullPointerException("The variable attribute cannot be null");
		}
		this.variableAttribute = variableAttribute;
	}

	@Override
	public String toString() {
		return String.format("%s.%s", this.getName(), this.getVariableAttribute());
	}
}
