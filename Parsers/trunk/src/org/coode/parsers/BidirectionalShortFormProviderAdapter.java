package org.coode.parsers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChange;
import org.semanticweb.owl.model.OWLOntologyChangeListener;
import org.semanticweb.owl.model.OWLOntologyLoaderListener;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.RemoveAxiom;
import org.semanticweb.owl.util.CachingBidirectionalShortFormProvider;
import org.semanticweb.owl.util.ShortFormProvider;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 18-Apr-2007<br>
 * <br>
 * 
 * A bidirectional short form provider which uses a specified short form
 * provider to generate the bidirectional entity--shortform mappings.
 */
public class BidirectionalShortFormProviderAdapter extends CachingBidirectionalShortFormProvider {
	private ShortFormProvider shortFormProvider;
	private Set<OWLOntology> ontologies;
	private OWLOntologyManager man;
	private OWLOntologyLoaderListener loaderListener = new OWLOntologyLoaderListener() {
		public void finishedLoadingOntology(LoadingFinishedEvent event) {
			BidirectionalShortFormProviderAdapter.this.ontologies.clear();
			BidirectionalShortFormProviderAdapter.this.ontologies.addAll(BidirectionalShortFormProviderAdapter.this.man.getOntologies());
			BidirectionalShortFormProviderAdapter.this.rebuild(new ReferencedEntitySetProvider(
					BidirectionalShortFormProviderAdapter.this.ontologies,
					BidirectionalShortFormProviderAdapter.this.man.getOWLDataFactory()));
		}

		public void startedLoadingOntology(LoadingStartedEvent event) {
			// Do nothing
		}
	};
	private OWLOntologyChangeListener changeListener = new OWLOntologyChangeListener() {
		public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
				throws OWLException {
			BidirectionalShortFormProviderAdapter.this.handleChanges(changes);
		}
	};

	public BidirectionalShortFormProviderAdapter(ShortFormProvider shortFormProvider) {
		this.shortFormProvider = shortFormProvider;
	}

	/**
	 * Creates a BidirectionalShortFormProvider that maps between the entities
	 * that are referenced in the specified ontologies and the shortforms of
	 * these entities. Note that the <code>dispose</code> method must be called
	 * when the provider has been finished with so that the provider may remove
	 * itself as a listener from the manager.
	 * 
	 * @param ontologies
	 *            The ontologies that contain references to the entities to be
	 *            mapped.
	 * @param shortFormProvider
	 *            The short form provider that should be used to generate the
	 *            short forms of the referenced entities.
	 * @param man
	 *            This short form provider will track changes to ontologies. The
	 *            provider will listen for ontology changes and update the cache
	 *            of entity--shortform mappings based on whether the specified
	 *            ontologies contain references to entities or not.
	 */
	public BidirectionalShortFormProviderAdapter(OWLOntologyManager man,
			Set<OWLOntology> ontologies, ShortFormProvider shortFormProvider) {
		this.man = man;
		this.ontologies = ontologies;
		this.shortFormProvider = shortFormProvider;
		this.man = man;
		this.man.addOntologyChangeListener(this.changeListener);
		this.rebuild(new ReferencedEntitySetProvider(ontologies, man.getOWLDataFactory()));
		man.addOntologyLoaderListener(this.loaderListener);
	}

	@Override
	protected String generateShortForm(OWLEntity entity) {
		return this.shortFormProvider.getShortForm(entity);
	}

	/**
	 * Disposes of this short form provider. Note that this method MUST be
	 * called if the constructor that specifies an ontology manager was used.
	 */
	@Override
	public void dispose() {
		if (this.man != null) {
			this.man.removeOntologyChangeListener(this.changeListener);
			this.man.removeOntologyLoaderListener(this.loaderListener);
		}
	}

	private void handleChanges(List<? extends OWLOntologyChange> changes) {
		Set<OWLEntity> processed = new HashSet<OWLEntity>();
		for (OWLOntologyChange chg : changes) {
			if (this.ontologies.contains(chg.getOntology())) {
				if (chg instanceof AddAxiom) {
					AddAxiom addAx = (AddAxiom) chg;
					for (OWLEntity ent : addAx.getEntities()) {
						if (!processed.contains(ent)) {
							processed.add(ent);
							this.add(ent);
						}
					}
				} else if (chg instanceof RemoveAxiom) {
					RemoveAxiom remAx = (RemoveAxiom) chg;
					for (OWLEntity ent : remAx.getEntities()) {
						if (!processed.contains(ent)) {
							processed.add(ent);
							boolean stillRef = false;
							for (OWLOntology ont : this.ontologies) {
								if (ont.containsEntityReference(ent)) {
									stillRef = true;
									break;
								}
							}
							if (!stillRef) {
								this.remove(ent);
							}
						}
					}
				}
			}
		}
	}
}
