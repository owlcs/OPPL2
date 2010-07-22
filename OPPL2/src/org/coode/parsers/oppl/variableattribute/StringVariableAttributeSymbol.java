/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.SymbolVisitorEx;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;

/**
 * @author Luigi Iannone
 * 
 */
public class StringVariableAttributeSymbol extends
		VariableAttributeSymbol<SingleValueGeneratedValue<String>> {
	public StringVariableAttributeSymbol(String name,
			SingleValueGeneratedValueFactory<String> factory, VariableAttribute<?> variableAttribute) {
		super(name, VariableAttributeType.STRING, factory, variableAttribute);
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

	@Override
	public void accept(SymbolVisitor visitor) {
		if (OPPLSymbolVisitor.class.isAssignableFrom(visitor.getClass())) {
			((OPPLSymbolVisitor) visitor).visitStringVariableAttributeSymbol(this);
		} else {
			super.accept(visitor);
		}
	}

	@Override
	public <O> O accept(SymbolVisitorEx<O> visitor) {
		O toReturn = super.accept(visitor);
		if (OPPLSymbolVisitorEx.class.isAssignableFrom(visitor.getClass())) {
			toReturn = ((OPPLSymbolVisitorEx<O>) visitor).visitStringVariableAttributeSymbol(this);
		}
		return toReturn;
	}
}
