package org.coode.oppl.entity;

import org.semanticweb.owl.model.OWLEntity;

public class OWLEntityRendererImpl implements OWLEntityRenderer {
	public String render(OWLEntity entity) {
		try {
			String rendering = entity.getURI().getFragment();
			if (rendering == null) {
				// Get last bit of path
				String path = entity.getURI().getPath();
				if (path == null) {
					return entity.getURI().toString();
				}
				return entity.getURI().getPath().substring(
						path.lastIndexOf("/") + 1);
			}
			return RenderingEscapeUtils.getEscapedRendering(rendering);
		} catch (Exception e) {
			return "<Error! " + e.getMessage() + ">";
		}
	}
}
