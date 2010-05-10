/**
 * 
 */
package org.coode.parsers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.variablemansyntax.Variable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternException;
import org.coode.patterns.PatternOPPLScript;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLPatternScope implements Scope {
	private final Scope delegate;
	private final OWLOntologyManager ontologyManager;

	public OPPLPatternScope(Scope scope, OWLOntologyManager ontologyManager) {
		if (scope == null) {
			throw new NullPointerException("The delegate  scope cannot be null");
		}
		if (ontologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		this.delegate = scope;
		this.ontologyManager = ontologyManager;
	}

	/**
	 * @param symbol
	 * @see org.coode.parsers.Scope#define(org.coode.parsers.Symbol)
	 */
	public void define(Symbol symbol) {
		this.delegate.define(symbol);
	}

	/**
	 * @return
	 * @see org.coode.parsers.Scope#getAllSymbols()
	 */
	public Set<Symbol> getAllSymbols() {
		return this.delegate.getAllSymbols();
	}

	/**
	 * @param type
	 * @return
	 * @see org.coode.parsers.Scope#getAllSymbols(org.coode.parsers.Type)
	 */
	public Set<Symbol> getAllSymbols(Type type) {
		return this.delegate.getAllSymbols(type);
	}

	/**
	 * @return
	 * @see org.coode.parsers.Scope#getEnclosingScope()
	 */
	public Scope getEnclosingScope() {
		return this.delegate.getEnclosingScope();
	}

	/**
	 * @return
	 * @see org.coode.parsers.Scope#getScopeName()
	 */
	public String getScopeName() {
		return this.delegate.getScopeName();
	}

	/**
	 * @param prefix
	 * @return
	 * @see org.coode.parsers.Scope#match(java.lang.String)
	 */
	public Set<Symbol> match(String prefix) {
		return this.delegate.match(prefix);
	}

	/**
	 * @param name
	 * @return
	 * @see org.coode.parsers.Scope#resolve(java.lang.String)
	 */
	public Symbol resolve(String name) {
		Symbol toReturn = this.delegate.resolve(name);
		return toReturn;
	}

	/**
	 * @return the delegate
	 */
	protected Scope getDelegate() {
		return this.delegate;
	}

	public Variable resolvePatternReference(OPPLSyntaxTree reference, String patternName,
			PatternConstraintSystem constraintSystem, ErrorListener listener, List<String>... args) {
		return this.resolvePatternReference(
				reference,
				patternName,
				constraintSystem,
				new HashSet<String>(),
				listener,
				args);
	}

	private Variable resolvePatternReference(OPPLSyntaxTree reference, String patternName,
			PatternConstraintSystem constraintSystem, Collection<? extends String> visited,
			ErrorListener listener, List<String>... args) {
		Variable toReturn = null;
		try {
			String resolvedPattern = constraintSystem.resolvePattern(
					patternName,
					this.getOntologyManager(),
					new HashSet<String>(visited),
					new ArrayList<PatternOPPLScript>(),
					args);
			toReturn = constraintSystem.getVariable(resolvedPattern);
		} catch (PatternException e) {
			listener.illegalToken(reference, "Could not resolve the reference: " + e.getMessage());
		}
		return toReturn;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}
}
