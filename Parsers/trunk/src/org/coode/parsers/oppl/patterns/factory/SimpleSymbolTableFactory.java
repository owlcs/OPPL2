/**
 * 
 */
package org.coode.parsers.oppl.patterns.factory;

import org.coode.parsers.BidirectionalShortFormProviderAdapter;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class SimpleSymbolTableFactory implements SymbolTableFactory {
	private final OWLOntologyManager manager;

	/**
	 * @param manager
	 */
	public SimpleSymbolTableFactory(OWLOntologyManager manager) {
		if (manager == null) {
			throw new NullPointerException("The manager cannot be null");
		}
		this.manager = manager;
	}

	/**
	 * @see org.coode.parsers.factory.SymbolTableFactory#createSymbolTable()
	 */
	public OPPLPatternsSymbolTable createSymbolTable() {
		BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
				this.manager, this.manager.getOntologies(), new SimpleShortFormProvider());
		DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
				shortFormProvider);
		ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
				new SimpleShortFormProvider());
		EntityFinder entityFinder = new EntityFinderImpl(this.manager,
				new OWLEntityRenderingCacheImpl(this.manager, entityRenderer), false);
		return new OPPLPatternsSymbolTable(new OPPLScope(entityChecker, entityFinder,
				entityRenderer), this.getManager());
	}

	/**
	 * @return the manager
	 */
	public OWLOntologyManager getManager() {
		return this.manager;
	}
}
