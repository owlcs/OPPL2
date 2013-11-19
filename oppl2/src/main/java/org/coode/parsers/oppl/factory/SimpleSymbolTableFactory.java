
package org.coode.parsers.oppl.factory;

import org.coode.oppl.OPPLShortFormProvider;
import org.coode.parsers.BidirectionalShortFormProviderAdapter;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class SimpleSymbolTableFactory implements SymbolTableFactory<OPPLSymbolTable> {
    private final OWLOntologyManager manager;

    /** @param manager */
    public SimpleSymbolTableFactory(OWLOntologyManager manager) {
        if (manager == null) {
            throw new NullPointerException("The manager cannot be null");
        }
        this.manager = manager;
    }

    @Override
    public OPPLSymbolTable createSymbolTable() {
        BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
                manager, manager.getOntologies(), new OPPLShortFormProvider(
                        new SimpleShortFormProvider()));
        DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
                shortFormProvider);
        ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
                new OPPLShortFormProvider(new SimpleShortFormProvider()));
        EntityFinder entityFinder = new EntityFinderImpl(manager,
                new OWLEntityRenderingCacheImpl(manager, entityRenderer), false);
        return new OPPLSymbolTable(new OPPLScope(entityChecker, entityFinder,
                entityRenderer), manager.getOWLDataFactory());
    }
}
