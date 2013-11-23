package org.coode.parsers;

import org.semanticweb.owlapi.model.OWLEntity;

public interface OWLEntityRenderer {
    String render(OWLEntity entity);
}
