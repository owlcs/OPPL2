
package org.coode.parsers.ui.autocompletionmatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.coode.parsers.EntityFinder;
import org.coode.parsers.EntityFinderImpl;
import org.coode.parsers.OWLEntityRenderer;
import org.coode.parsers.OWLEntityRenderingCacheImpl;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** Retrieves the OWL Entities whose rendering match the string to complete
 * 
 * @author Luigi Iannone */
public final class OWLEntityRendererAutoCompletionMatcher implements
        AutoCompletionMatcher {
    private final EntityFinder entityFinder;
    private final OWLEntityRenderer entityRenderer;

    public OWLEntityRendererAutoCompletionMatcher(OWLEntityRenderer entityRenderer,
            OWLOntologyManager manager) {
        if (entityRenderer == null) {
            throw new NullPointerException("The entity renderer cannot be null");
        }
        if (manager == null) {
            throw new NullPointerException("The ontology manager cannot be null");
        }
        this.entityRenderer = entityRenderer;
        entityFinder = new EntityFinderImpl(manager, new OWLEntityRenderingCacheImpl(
                manager, entityRenderer), false);
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        List<String> toReturn = new ArrayList<String>();
        Set<OWLEntity> entities = entityFinder.getEntities(string2Complete);
        for (OWLEntity owlEntity : entities) {
            toReturn.add(entityRenderer.render(owlEntity));
        }
        Collections.sort(toReturn);
        return toReturn;
    }
}
