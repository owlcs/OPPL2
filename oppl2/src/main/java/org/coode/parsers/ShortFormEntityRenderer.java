package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public class ShortFormEntityRenderer implements OWLEntityRenderer {
    private final ShortFormProvider shortFormProvider;

    /** @param shortFormProvider */
    public ShortFormEntityRenderer(ShortFormProvider shortFormProvider) {
        this.shortFormProvider = checkNotNull(shortFormProvider, "shortFormProvider");
    }

    @Override
    public String render(OWLEntity entity) {
        return shortFormProvider.getShortForm(entity);
    }
}
