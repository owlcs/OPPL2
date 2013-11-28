package org.coode.oppl;

import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public class OPPLShortFormProvider implements ShortFormProvider {
    private final ShortFormProvider delegate;

    /** @param provider */
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
