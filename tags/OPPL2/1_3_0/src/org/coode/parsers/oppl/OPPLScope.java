/**
 * 
 */
package org.coode.parsers.oppl;

import java.util.Set;

import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.OWLEntityCheckerScope;
import org.coode.parsers.OWLEntityRenderer;
import org.coode.parsers.Scope;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLScope implements Scope {
	private final OWLEntityCheckerScope owlEntityCheckerScope;

	public OPPLScope(DisposableOWLEntityChecker owlEntityChecker, EntityFinder entityFinder,
			OWLEntityRenderer owlEntityRenderer) {
		if (owlEntityChecker == null) {
			throw new NullPointerException("The entity checker cannot be null");
		}
		if (entityFinder == null) {
			throw new NullPointerException("The entity finder cannot be null");
		}
		if (owlEntityRenderer == null) {
			throw new NullPointerException("The OWL entity renderer cannot be null");
		}
		this.owlEntityCheckerScope = new OWLEntityCheckerScope(owlEntityChecker, entityFinder,
				owlEntityRenderer);
	}

	/**
	 * @see org.coode.parsers.Scope#define(org.coode.parsers.Symbol)
	 */
	public void define(Symbol symbol) {
	}

	/**
	 * @see org.coode.parsers.Scope#getAllSymbols()
	 */
	public Set<Symbol> getAllSymbols() {
		return this.owlEntityCheckerScope.getAllSymbols();
	}

	/**
	 * @see org.coode.parsers.Scope#getAllSymbols(org.coode.parsers.Type)
	 */
	public Set<Symbol> getAllSymbols(Type type) {
		return this.owlEntityCheckerScope.getAllSymbols();
	}

	/**
	 * @see org.coode.parsers.Scope#getEnclosingScope()
	 */
	public Scope getEnclosingScope() {
		return null;
	}

	/**
	 * @see org.coode.parsers.Scope#getScopeName()
	 */
	public String getScopeName() {
		return "global OPPL scope";
	}

	/**
	 * @see org.coode.parsers.Scope#match(java.lang.String)
	 */
	public Set<Symbol> match(String prefix) {
		return this.owlEntityCheckerScope.match(prefix);
	}

	/**
	 * @see org.coode.parsers.Scope#resolve(java.lang.String)
	 */
	public Symbol resolve(String name) {
		Symbol toReturn = this.owlEntityCheckerScope.resolve(name);
		if (toReturn == null) {
			if (name.startsWith("!")) {
				toReturn = new CreateOnDemandIdentifier(name);
			}
		}
		return toReturn;
	}

	public void dispose() {
		this.owlEntityCheckerScope.dispose();
	}
}
