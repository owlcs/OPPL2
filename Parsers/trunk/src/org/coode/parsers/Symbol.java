/**
 * 
 */
package org.coode.parsers;

/**
 * A generic symbol
 * 
 * @author Luigi Iannone
 * 
 */
public class Symbol {
	private final String name;
	private final Type type;

	/**
	 * @param name
	 */
	public Symbol(String name, Type type) {
		if (name == null) {
			throw new NullPointerException("The name cannot be null");
		}
		if (type == null) {
			throw new NullPointerException("The type cannot be null");
		}
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public Type getType() {
		return this.type;
	}

	public void accept(SymbolVisitor visitor) {
		visitor.visitSymbol(this);
	}

	public <O> O accept(SymbolVisitorEx<O> visitor) {
		return visitor.visitSymbol(this);
	}
}
