/**
 * 
 */
package org.coode.parsers.oppl.factory;

import org.coode.parsers.BidirectionalShortFormProviderAdapter;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.OPPLSymbolTable;
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
	public OPPLSymbolTable createSymbolTable() {
		ShortFormEntityChecker entityChecker = new ShortFormEntityChecker(
				new BidirectionalShortFormProviderAdapter(this.manager.getOntologies(),
						new SimpleShortFormProvider()));
		ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
				new SimpleShortFormProvider());
		EntityFinder entityFinder = new EntityFinderImpl(this.manager,
				new OWLEntityRenderingCacheImpl(this.manager, entityRenderer), false);
		return new OPPLSymbolTable(new OPPLScope(entityChecker, entityFinder, entityRenderer),
				this.manager.getOWLDataFactory());
	}
}
