package org.coode.parsers;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.CachingBidirectionalShortFormProvider;
import org.semanticweb.owlapi.util.OWLEntitySetProvider;
import org.semanticweb.owlapi.util.ShortFormProvider;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

/** Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 18-Apr-2007<br>
 * <br>
 * A bidirectional short form provider which uses a specified short form
 * provider to generate the bidirectional entity--shortform mappings. */
public class BidirectionalShortFormProviderAdapter extends
        CachingBidirectionalShortFormProvider implements OWLEntitySetProvider<OWLEntity> {
    private final ShortFormProvider shortFormProvider;
    protected Set<OWLOntology> ontologies;
    private OWLOntologyManager man;

    public BidirectionalShortFormProviderAdapter(ShortFormProvider shortFormProvider) {
        this.shortFormProvider = shortFormProvider;
    }

    /** Creates a BidirectionalShortFormProvider that maps between the entities
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
     *            ontologies contain references to entities or not. */
    public BidirectionalShortFormProviderAdapter(OWLOntologyManager man,
            Set<OWLOntology> ontologies, ShortFormProvider shortFormProvider) {
        this.man = man;
        this.ontologies = ontologies;
        this.shortFormProvider = shortFormProvider;
        this.man = man;
        rebuild(this);
        // Apparently Thing, Nothing, and the well know datatypes are not
        // referenced entities, so I need to add them.
        addWellKnownEntities(man.getOWLDataFactory());
    }

    private void addWellKnownEntities(OWLDataFactory dataFactory) {
        add(dataFactory.getOWLThing());
        add(dataFactory.getOWLNothing());
        add(dataFactory.getTopDatatype());
        add(dataFactory.getOWLTopObjectProperty());
        add(dataFactory.getOWLTopDataProperty());
        for (OWL2Datatype datatype : EnumSet.allOf(OWL2Datatype.class)) {
            add(dataFactory.getOWLDatatype(datatype.getIRI()));
        }
    }

    @Override
    protected String generateShortForm(OWLEntity entity) {
        return shortFormProvider.getShortForm(entity);
    }

    @Override
    public void dispose() {}

    @Override
    public Set<OWLEntity> getEntities() {
        if (man == null) {
            return Collections.emptySet();
        }
        Set<OWLEntity> set = new HashSet<OWLEntity>();
        for (OWLOntology o : man.getOntologies()) {
            set.addAll(o.getSignature());
        }
        return set;
    }
}
