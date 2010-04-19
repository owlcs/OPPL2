package org.coode.parsers.oppl;

import org.coode.parsers.OWLType;
import org.coode.parsers.Symbol;
import org.semanticweb.owl.model.OWLConstant;

public class OWLConstantSymbol extends Symbol {
	private final OWLConstant owlConstant;

	/**
	 * @param name
	 * @param type
	 */
	public OWLConstantSymbol(String name, OWLConstant constant) {
		super(name, OWLType.OWL_CONSTANT);
		if (constant == null) {
			throw new NullPointerException("The constant cannot be null");
		}
		this.owlConstant = constant;
	}

	/**
	 * @return the owlConstant
	 */
	public OWLConstant getOWLConstant() {
		return this.owlConstant;
	}
}
