package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.AnnotationValueShortFormProvider;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * SimbleTable factory that builds symbol tables based on the short form provided by annotations
 * rather than IRI fragments.
 * 
 * @author Luigi Iannone
 */
public class AnnotationBasedSymbolTableFactory implements SymbolTableFactory<OPPLSymbolTable> {

    private final OWLOntologyManager manager;
    private final List<OWLAnnotationProperty> annotations = new ArrayList<>();

    /**
     * @param manager manager
     * @param iris iris
     */
    public AnnotationBasedSymbolTableFactory(OWLOntologyManager manager, List<? extends IRI> iris) {
        this.manager = checkNotNull(manager, "The ontology manager");
        OWLDataFactory dataFactory = this.manager.getOWLDataFactory();
        for (IRI iri : checkNotNull(iris, "The iri list")) {
            annotations.add(dataFactory.getOWLAnnotationProperty(iri));
        }
    }

    @Override
    public OPPLSymbolTable createSymbolTable() {
        ShortFormProvider baseShortFormProvider = new AnnotationValueShortFormProvider(annotations,
            Collections.<OWLAnnotationProperty, List<String>>emptyMap(), manager);
        BidirectionalShortFormProviderAdapter shortFormProvider =
            new BidirectionalShortFormProviderAdapter(manager, baseShortFormProvider);
        DisposableOWLEntityChecker entityChecker =
            new DisposableShortFormEntityChecker(shortFormProvider);
        ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(baseShortFormProvider);
        EntityFinder entityFinder = new EntityFinderImpl(manager,
            new OWLEntityRenderingCacheImpl(manager, entityRenderer), false);
        return new OPPLSymbolTable(new OPPLScope(entityChecker, entityFinder, entityRenderer),
            manager.getOWLDataFactory());
    }
}
