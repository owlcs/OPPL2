package org.coode.parsers.oppl.patterns.factory;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class SimpleSymbolTableFactory implements
        SymbolTableFactory<OPPLPatternsSymbolTable> {
    private final OWLOntologyManager manager;

    /** @param manager */
    public SimpleSymbolTableFactory(OWLOntologyManager manager) {
        this.manager = checkNotNull(manager, "manager");
    }

    @Override
    public OPPLPatternsSymbolTable createSymbolTable() {
        BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
                manager, manager.getOntologies(), new SimpleShortFormProvider());
        DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
                shortFormProvider);
        ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
                new SimpleShortFormProvider());
        EntityFinder entityFinder = new EntityFinderImpl(manager,
                new OWLEntityRenderingCacheImpl(manager, entityRenderer), false);
        return new OPPLPatternsSymbolTable(new OPPLScope(entityChecker, entityFinder,
                entityRenderer), getManager());
    }

    /** @return the manager */
    public OWLOntologyManager getManager() {
        return manager;
    }
}
