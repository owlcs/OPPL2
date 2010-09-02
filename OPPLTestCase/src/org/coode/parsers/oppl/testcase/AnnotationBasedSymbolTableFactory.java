package org.coode.parsers.oppl.testcase;

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
 * 
 */
public class AnnotationBasedSymbolTableFactory implements
		SymbolTableFactory<OPPLTestCaseSymbolTable> {
	private final OWLOntologyManager manager;
	private final List<OWLAnnotationProperty> annotations = new ArrayList<OWLAnnotationProperty>();

	/**
	 * @param manager
	 */
	public AnnotationBasedSymbolTableFactory(OWLOntologyManager manager, List<? extends IRI> iris) {
		if (manager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		if (iris == null) {
			throw new NullPointerException("The iri list cannot be null");
		}
		this.manager = manager;
		OWLDataFactory dataFactory = this.manager.getOWLDataFactory();
		for (IRI iri : iris) {
			this.annotations.add(dataFactory.getOWLAnnotationProperty(iri));
		}
	}

	public OPPLTestCaseSymbolTable createSymbolTable() {
		ShortFormProvider baseShortFormProvider = new AnnotationValueShortFormProvider(
				this.annotations, Collections.<OWLAnnotationProperty, List<String>> emptyMap(),
				this.manager);
		BidirectionalShortFormProviderAdapter shortFormProvider = new BidirectionalShortFormProviderAdapter(
				this.manager, this.manager.getOntologies(), baseShortFormProvider);
		DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
				shortFormProvider);
		ShortFormEntityRenderer entityRenderer = new ShortFormEntityRenderer(baseShortFormProvider);
		EntityFinder entityFinder = new EntityFinderImpl(this.manager,
				new OWLEntityRenderingCacheImpl(this.manager, entityRenderer), false);
		return new OPPLTestCaseSymbolTable(new OPPLScope(entityChecker, entityFinder,
				entityRenderer), this.manager.getOWLDataFactory());
	}
}
