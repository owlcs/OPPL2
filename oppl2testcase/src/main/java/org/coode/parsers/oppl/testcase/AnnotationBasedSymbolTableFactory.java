package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.coode.parsers.*;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.AnnotationValueShortFormProvider;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * SimbleTable factory that builds symbol tables based on the short form
 * provided by annotations rather than IRI fragments.
 * 
 * @author Luigi Iannone
 */
public class AnnotationBasedSymbolTableFactory implements
    SymbolTableFactory<OPPLTestCaseSymbolTable> {

    private final OWLOntologyManager manager;
    private final List<OWLAnnotationProperty> annotations = new ArrayList<>();

    /**
     * @param manager
     *        manager
     * @param iris
     *        iris
     */
    public AnnotationBasedSymbolTableFactory(OWLOntologyManager manager,
        List<? extends IRI> iris) {
        this.manager = checkNotNull(manager, "manager");
        OWLDataFactory dataFactory = this.manager.getOWLDataFactory();
        for (IRI iri : checkNotNull(iris, "iris")) {
            annotations.add(dataFactory.getOWLAnnotationProperty(iri));
        }
    }

    @Override
    public OPPLTestCaseSymbolTable createSymbolTable() {
        ShortFormProvider baseShortFormProvider = new AnnotationValueShortFormProvider(
            annotations,
            Collections.<OWLAnnotationProperty, List<String>> emptyMap(), manager);
        BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
            manager, manager.getOntologies(), baseShortFormProvider);
        DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
            shortFormProvider);
        ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(
            baseShortFormProvider);
        EntityFinder entityFinder = new EntityFinderImpl(manager,
            new OWLEntityRenderingCacheImpl(manager, entityRenderer), false);
        return new OPPLTestCaseSymbolTable(new OPPLScope(entityChecker, entityFinder,
            entityRenderer), manager.getOWLDataFactory());
    }
}
