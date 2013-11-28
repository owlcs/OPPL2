package org.coode.parsers;

import org.semanticweb.owlapi.model.OWLEntity;

/** @author Luigi Iannone */
public interface OWLEntityRenderer {
    /** @param entity
     * @return rendering */
    String render(OWLEntity entity);
}
