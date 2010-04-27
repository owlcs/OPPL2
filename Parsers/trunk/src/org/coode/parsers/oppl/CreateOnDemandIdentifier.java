/**
 * 
 */
package org.coode.parsers.oppl;

import org.coode.parsers.Symbol;

/**
 * @author Luigi Iannone
 * 
 */
public class CreateOnDemandIdentifier extends Symbol implements OPPLSymbol {
	/**
	 * @param name
	 * @param type
	 */
	public CreateOnDemandIdentifier(String name) {
		super(name, CreateOnDemand.get());
	}

	/**
	 * @see org.coode.parsers.oppl.OPPLSymbol#accept(org.coode.parsers.oppl.OPPLSymbolVisitor)
	 */
	public void accept(OPPLSymbolVisitor visitor) {
		visitor.visitCreateOnDemandIdentifier(this);
	}

	/**
	 * @see org.coode.parsers.oppl.OPPLSymbol#accept(org.coode.parsers.oppl.
	 *      OPPLSymbolVisitorEx)
	 */
	public <O> O accept(OPPLSymbolVisitorEx<O> visitor) {
		return visitor.visitCreateOnDemandIdentifier(this);
	}
}
