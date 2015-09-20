package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.parsers.*;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class SimpleSymbolTableFactory implements
    SymbolTableFactory<OPPLTestCaseSymbolTable> {

    private final OWLOntologyManager manager;

    /**
     * @param manager
     *        manager
     */
    public SimpleSymbolTableFactory(OWLOntologyManager manager) {
        this.manager = checkNotNull(manager, "manager");
    }

    @Override
    public OPPLTestCaseSymbolTable createSymbolTable() {
        BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
            getOntologyManager(), getOntologyManager().getOntologies(),
            new SimpleShortFormProvider());
        DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
            shortFormProvider);
        ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
            new SimpleShortFormProvider());
        EntityFinder entityFinder = new EntityFinderImpl(getOntologyManager(),
            new OWLEntityRenderingCacheImpl(getOntologyManager(), entityRenderer),
            false);
        return new OPPLTestCaseSymbolTable(new OPPLScope(entityChecker, entityFinder,
            entityRenderer), getOntologyManager().getOWLDataFactory());
    }

    /**
     * @return the manager
     */
    public OWLOntologyManager getOntologyManager() {
        return manager;
    }
}
