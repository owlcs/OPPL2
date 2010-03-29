/**
 * 
 */
package org.coode.oppl.syntax;

import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLEntity;

/**
 * Scope based on an OWLEntityChecker instance. All the symbols are derived from
 * the entities recognised by the OWLEntityChecker.
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLEntityCheckerScope implements Scope {
	private final OWLEntityChecker owlEntityChecker;

	/**
	 * @param owlEntityChecker
	 */
	public OWLEntityCheckerScope(OWLEntityChecker owlEntityChecker) {
		if (owlEntityChecker == null) {
			throw new NullPointerException("The entity checker cannot be null");
		}
		this.owlEntityChecker = owlEntityChecker;
	}

	/**
	 * @see org.coode.oppl.syntax.Scope#define(org.coode.oppl.syntax.Symbol)
	 */
	public void define(Symbol symbol) {
		// Cannot define new symbols
	}

	/**
	 * @see org.coode.oppl.syntax.Scope#getEnclosingScope()
	 */
	public Scope getEnclosingScope() {
		return null;
	}

	/**
	 * @see org.coode.oppl.syntax.Scope#getScopeName()
	 */
	public String getScopeName() {
		return "global";
	}

	/**
	 * @see org.coode.oppl.syntax.Scope#resolve(java.lang.String)
	 */
	public Symbol resolve(String name) {
		Symbol toReturn = null;
		OWLEntity owlEntity = this.getOWLEntityChecker().getOWLClass(name);
		if (owlEntity != null) {
			toReturn = new OWLEntitySymbol(name, OWLType.OWL_CLASS, owlEntity);
		} else {
			owlEntity = this.owlEntityChecker.getOWLDataProperty(name);
			if (owlEntity != null) {
				toReturn = new OWLEntitySymbol(name, OWLType.OWL_DATA_PROPERTY,
						owlEntity);
			} else {
				owlEntity = this.owlEntityChecker.getOWLObjectProperty(name);
				if (owlEntity != null) {
					toReturn = new OWLEntitySymbol(name,
							OWLType.OWL_OBJECT_PROPERTY, owlEntity);
				} else {
					owlEntity = this.owlEntityChecker.getOWLIndividual(name);
					if (owlEntity != null) {
						toReturn = new OWLEntitySymbol(name,
								OWLType.OWL_INDIVIDUAL, owlEntity);
					} else {
						owlEntity = this.owlEntityChecker.getOWLDataType(name);
						if (owlEntity != null) {
							toReturn = new OWLEntitySymbol(name,
									OWLType.OWL_DATA_TYPE, owlEntity);
						}
					}
				}
			}
		}
		return toReturn;
	}

	/**
	 * @return the owlEntityChecker
	 */
	public OWLEntityChecker getOWLEntityChecker() {
		return this.owlEntityChecker;
	}
}
