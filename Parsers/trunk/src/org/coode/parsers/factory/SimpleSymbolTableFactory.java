/**
 * 
 */
package org.coode.parsers.factory;

import org.coode.parsers.BidirectionalShortFormProviderAdapter;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityCheckerScope;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.SymbolTable;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
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
	public SymbolTable createSymbolTable() {
		ShortFormEntityChecker entityChecker = new ShortFormEntityChecker(
				new BidirectionalShortFormProviderAdapter(this.manager
						.getOntologies(), new SimpleShortFormProvider()));
		ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
				new SimpleShortFormProvider());
		EntityFinder entityFinder = new EntityFinderImpl(this.manager,
				new OWLEntityRenderingCacheImpl(this.manager, entityRenderer),
				false);
		return new SymbolTable(new OWLEntityCheckerScope(entityChecker,
				entityFinder, entityRenderer), this.manager.getOWLDataFactory());
	}
}
