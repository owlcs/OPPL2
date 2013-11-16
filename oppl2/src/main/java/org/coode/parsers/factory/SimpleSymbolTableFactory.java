/**
 * 
 */
package org.coode.parsers.factory;

import org.coode.oppl.OPPLShortFormProvider;
import org.coode.parsers.BidirectionalShortFormProviderAdapter;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityCheckerScope;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.SymbolTable;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class SimpleSymbolTableFactory implements SymbolTableFactory<SymbolTable> {
    private final OWLOntologyManager manager;

    /** @param manager */
    public SimpleSymbolTableFactory(OWLOntologyManager manager) {
        if (manager == null) {
            throw new NullPointerException("The manager cannot be null");
        }
        this.manager = manager;
    }

    @Override
    public SymbolTable createSymbolTable() {
        BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
                manager, manager.getOntologies(), new OPPLShortFormProvider(
                        new SimpleShortFormProvider()));
        DisposableShortFormEntityChecker entityChecker = new DisposableShortFormEntityChecker(
                shortFormProvider);
        ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
                new OPPLShortFormProvider(new SimpleShortFormProvider()));
        EntityFinder entityFinder = new EntityFinderImpl(manager,
                new OWLEntityRenderingCacheImpl(manager, entityRenderer), false);
        return new SymbolTable(new OWLEntityCheckerScope(entityChecker, entityFinder,
                entityRenderer), manager.getOWLDataFactory());
    }
}
