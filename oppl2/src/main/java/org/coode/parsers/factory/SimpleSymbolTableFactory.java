package org.coode.parsers.factory;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.OPPLShortFormProvider;
import org.coode.parsers.*;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class SimpleSymbolTableFactory implements SymbolTableFactory<SymbolTable> {

    private final OWLOntologyManager manager;

    /**
     * @param manager
     *        manager
     */
    public SimpleSymbolTableFactory(OWLOntologyManager manager) {
        this.manager = checkNotNull(manager, "manager");
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
