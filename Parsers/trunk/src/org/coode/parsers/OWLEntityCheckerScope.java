/**
 * 
 */
package org.coode.parsers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
	private final EntityFinder entityFinder;
	private final OWLEntityRenderer owlEntityRenderer;

	/**
	 * @param owlEntityChecker
	 */
	public OWLEntityCheckerScope(OWLEntityChecker owlEntityChecker,
			EntityFinder entityFinder, OWLEntityRenderer owlEntityRenderer) {
		if (owlEntityChecker == null) {
			throw new NullPointerException("The entity checker cannot be null");
		}
		if (entityFinder == null) {
			throw new NullPointerException("The entity finder cannot be null");
		}
		if (owlEntityRenderer == null) {
			throw new NullPointerException(
					"The OWL entity renderer cannot be null");
		}
		this.owlEntityChecker = owlEntityChecker;
		this.entityFinder = entityFinder;
		this.owlEntityRenderer = owlEntityRenderer;
	}

	/**
	 * @see org.coode.parsers.Scope#define(org.coode.parsers.Symbol)
	 */
	public void define(Symbol symbol) {
		// Cannot define new symbols
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
		return "global";
	}

	/**
	 * @see org.coode.parsers.Scope#resolve(java.lang.String)
	 */
	public Symbol resolve(String name) {
		Symbol toReturn = null;
		OWLEntity owlEntity = this.getOWLEntityChecker().getOWLClass(name);
		if (owlEntity != null) {
			toReturn = new OWLEntitySymbol(name, owlEntity);
		} else {
			owlEntity = this.getOWLEntityChecker().getOWLDataProperty(name);
			if (owlEntity != null) {
				toReturn = new OWLEntitySymbol(name, owlEntity);
			} else {
				owlEntity = this.getOWLEntityChecker().getOWLObjectProperty(
						name);
				if (owlEntity != null) {
					toReturn = new OWLEntitySymbol(name, owlEntity);
				} else {
					owlEntity = this.getOWLEntityChecker().getOWLIndividual(
							name);
					if (owlEntity != null) {
						toReturn = new OWLEntitySymbol(name, owlEntity);
					} else {
						owlEntity = this.getOWLEntityChecker().getOWLDataType(
								name);
						if (owlEntity != null) {
							toReturn = new OWLEntitySymbol(name, owlEntity);
						}
					}
				}
			}
		}
		return toReturn;
	}

	public Set<Symbol> match(String prefix) {
		if (prefix == null) {
			throw new NullPointerException("The initial prefix cannot be null");
		}
		Set<Symbol> toReturn = new HashSet<Symbol>();
		Set<OWLEntity> entities = this.getEntityFinder().getEntities(prefix);
		for (OWLEntity owlEntity : entities) {
			toReturn.add(new OWLEntitySymbol(this.getOWLEntityRenderer()
					.render(owlEntity), owlEntity));
		}
		return toReturn;
	}

	/**
	 * @return the owlEntityChecker
	 */
	public OWLEntityChecker getOWLEntityChecker() {
		return this.owlEntityChecker;
	}

	/**
	 * @return the entityFinder
	 */
	public EntityFinder getEntityFinder() {
		return this.entityFinder;
	}

	/**
	 * @return the owlEntityRenderer
	 */
	public OWLEntityRenderer getOWLEntityRenderer() {
		return this.owlEntityRenderer;
	}

	public Set<Symbol> getAllSymbols() {
		Set<OWLEntity> entities = this.getEntityFinder().getEntities("");
		Set<Symbol> toReturn = new HashSet<Symbol>(entities.size());
		for (OWLEntity owlEntity : entities) {
			toReturn.add(new OWLEntitySymbol(this.getOWLEntityRenderer()
					.render(owlEntity), owlEntity));
		}
		return toReturn;
	}

	public Set<Symbol> getAllSymbols(Type type) {
		Set<OWLEntity> entities = type
				.accept(new TypeVisitorEx<Set<OWLEntity>>() {
					public Set<OWLEntity> visitOWLAxiomType(
							OWLAxiomType owlAxiomType) {
						return Collections.emptySet();
					}

					public Set<OWLEntity> visitOWLType(OWLType owlType) {
						Set<OWLEntity> toReturn = new HashSet<OWLEntity>();
						switch (owlType) {
						case OWL_CLASS:
							toReturn.addAll(OWLEntityCheckerScope.this
									.getEntityFinder().getMatchingOWLClasses(
											"*"));
							break;
						case OWL_DATA_PROPERTY:
							toReturn.addAll(OWLEntityCheckerScope.this
									.getEntityFinder()
									.getMatchingOWLDataProperties("*"));
							break;
						case OWL_OBJECT_PROPERTY:
							toReturn.addAll(OWLEntityCheckerScope.this
									.getEntityFinder()
									.getMatchingOWLObjectProperties("*"));
							break;
						case OWL_INDIVIDUAL:
							toReturn.addAll(OWLEntityCheckerScope.this
									.getEntityFinder()
									.getMatchingOWLIndividuals("*"));
							break;
						default:
							break;
						}
						return toReturn;
					}
				});
		Set<Symbol> toReturn = new HashSet<Symbol>(entities.size());
		for (OWLEntity owlEntity : entities) {
			toReturn.add(new OWLEntitySymbol(this.getOWLEntityRenderer()
					.render(owlEntity), owlEntity));
		}
		return toReturn;
	}
}
