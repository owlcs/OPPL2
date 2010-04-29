/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

/**
 * @author Luigi Iannone
 * 
 */
public class GroupVariableAttributeSymbol extends StringVariableAttributeSymbol {
	private final int index;

	/**
	 * @param name
	 * @param factory
	 */
	public GroupVariableAttributeSymbol(final String name, final int index,
			VariableAttribute<?> variableAttribute) {
		super(name, new GroupAttributeSymbolFactory(name, index), variableAttribute);
		this.index = index;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public String getName() {
		return super.getName() + "(" + this.index + ")";
	}
}
