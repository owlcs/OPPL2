package org.coode.oppl;

import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.util.ShortFormProvider;

public class OPPLShortFormProvider implements ShortFormProvider {
    private final ShortFormProvider delegate;

    public OPPLShortFormProvider(ShortFormProvider provider) {
        delegate = provider;
    }

    @Override
    public String getShortForm(OWLEntity entity) {
        if (entity.getIRI().getNamespace().endsWith("?")) {
            return "?" + entity.getIRI().getFragment();
        }
        return delegate.getShortForm(entity);
    }

    @Override
    public void dispose() {
        delegate.dispose();
    }
}
