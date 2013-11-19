
package org.coode.parsers.oppl.testcase;

import org.coode.parsers.BidirectionalShortFormProviderAdapter;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class SimpleSymbolTableFactory implements
        SymbolTableFactory<OPPLTestCaseSymbolTable> {
    private final OWLOntologyManager manager;

    /** @param manager */
    public SimpleSymbolTableFactory(OWLOntologyManager manager) {
        if (manager == null) {
            throw new NullPointerException("The ontology manager cannot be null");
        }
        this.manager = manager;
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

    /** @return the manager */
    public OWLOntologyManager getOntologyManager() {
        return manager;
    }
}
