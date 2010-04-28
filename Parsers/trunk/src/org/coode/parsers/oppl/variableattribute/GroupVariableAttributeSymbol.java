/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

/**
 * @author Luigi Iannone
 * 
 */
public class GroupVariableAttributeSymbol extends StringVariableAttributeSymbol {
	private final String variableName;
	private final int index;

	/**
	 * @param name
	 * @param factory
	 */
	public GroupVariableAttributeSymbol(final String name, final int index) {
		super(getName(name, index), new GroupAttributeSymbolFactory(name, index));
		this.variableName = name;
		this.index = index;
	}

	public static final String getName(String variableName, int index) {
		if (variableName == null) {
			throw new NullPointerException("The variable name cannot be null");
		}
		return variableName + "(" + index + ")";
	}

	@Override
	public String toString() {
		return this.variableName + "(" + this.index + ")";
	}
}
