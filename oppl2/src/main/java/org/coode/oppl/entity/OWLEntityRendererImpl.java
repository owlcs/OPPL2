package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.OWLEntity;

public class OWLEntityRendererImpl implements OWLEntityRenderer {
    @Override
    public String render(OWLEntity entity) {
        try {
            String rendering = entity.getIRI().getFragment();
            if (rendering == null) {
                // Get last bit of path
                String path = entity.getIRI().toURI().getPath();
                if (path == null) {
                    return entity.getIRI().toString();
                }
                return entity.getIRI().toURI().getPath()
                        .substring(path.lastIndexOf("/") + 1);
            }
            return RenderingEscapeUtils.getEscapedRendering(rendering);
        } catch (Exception e) {
            return "<Error! " + e.getMessage() + ">";
        }
    }
}
