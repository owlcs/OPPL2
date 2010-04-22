/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;

/**
 * @author Luigi Iannone
 * 
 */
public class StringVariableAttributeSymbol extends
		VariableAttributeSymbol<SingleValueGeneratedValue<String>> {
	public StringVariableAttributeSymbol(String name,
			SingleValueGeneratedValueFactory<String> factory) {
		super(name, VariableAttributeType.STRING, factory);
	}

	/**
	 * @see org.coode.parsers.oppl.OPPLSymbol#accept(org.coode.parsers.oppl.
	 *      OPPLSymbolVisitor)
	 */
	public void accept(OPPLSymbolVisitor visitor) {
		visitor.visitStringVariableAttributeSymbol(this);
	}

	/**
	 * @see org.coode.parsers.oppl.OPPLSymbol#accept(org.coode.parsers.oppl.
	 *      OPPLSymbolVisitorEx)
	 */
	public <O> O accept(OPPLSymbolVisitorEx<O> visitor) {
		return visitor.visitStringVariableAttributeSymbol(this);
	}
}
