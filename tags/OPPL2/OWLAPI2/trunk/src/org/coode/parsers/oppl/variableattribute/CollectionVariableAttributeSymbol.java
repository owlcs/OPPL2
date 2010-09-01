package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.generated.AbstractCollectionGeneratedValue;
import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.SymbolVisitorEx;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;

public class CollectionVariableAttributeSymbol<O> extends
		VariableAttributeSymbol<AbstractCollectionGeneratedValue<O>> {
	/**
	 * @param name
	 * @param type
	 * @param factory
	 */
	public CollectionVariableAttributeSymbol(String name,
			AttributeFactory<AbstractCollectionGeneratedValue<O>> factory,
			VariableAttribute<?> variableAttribute) {
		super(name, VariableAttributeType.COLLECTION, factory, variableAttribute);
	}

	/**
	 * @see org.coode.parsers.oppl.OPPLSymbol#accept(org.coode.parsers.oppl.
	 *      OPPLSymbolVisitor)
	 */
	public void accept(OPPLSymbolVisitor visitor) {
		visitor.visitCollectionVariableAttributeSymbol(this);
	}

	/**
	 * @see org.coode.parsers.oppl.OPPLSymbol#accept(org.coode.parsers.oppl.
	 *      OPPLSymbolVisitorEx)
	 */
	public <N> N accept(OPPLSymbolVisitorEx<N> visitor) {
		return visitor.visitCollectionVariableAttributeSymbol(this);
	}

	@Override
	public void accept(SymbolVisitor visitor) {
		if (OPPLSymbolVisitor.class.isAssignableFrom(visitor.getClass())) {
			((OPPLSymbolVisitor) visitor).visitCollectionVariableAttributeSymbol(this);
		} else {
			super.accept(visitor);
		}
	}

	@Override
	public <P> P accept(SymbolVisitorEx<P> visitor) {
		P toReturn = super.accept(visitor);
		if (OPPLSymbolVisitorEx.class.isAssignableFrom(visitor.getClass())) {
			toReturn = ((OPPLSymbolVisitorEx<P>) visitor).visitCollectionVariableAttributeSymbol(this);
		}
		return toReturn;
	}
}
