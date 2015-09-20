package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Renders an OWLEntity into a String.
 * 
 * @author Luigi Iannone
 */
public interface OWLEntityRenderer {

    /**
     * Renders an OWLEntity into a String.
     * 
     * @param entity
     *        the OWLEntity to render. Cannot be {@code null}.
     * @return the String rendering of the input OWLEntity.
     * @throws NullPointerException
     *         when the input is {@code null}.
     */
    String render(OWLEntity entity);
}
