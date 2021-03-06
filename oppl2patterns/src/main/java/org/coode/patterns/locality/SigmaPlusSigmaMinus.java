package org.coode.patterns.locality;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.semanticweb.owlapi.model.OWLEntity;

/**
 * holder for the extra symbols, one to be added to the signature, one to stay
 * outside the signature
 */
public class SigmaPlusSigmaMinus extends AbstractCollection<OWLEntity>implements
    Collection<OWLEntity> {

    private final OWLEntity plus;
    private final OWLEntity minus;

    /**
     * @param plus
     *        the new value contained in the signature
     * @param minus
     *        the new value not contained in the signature
     */
    public SigmaPlusSigmaMinus(OWLEntity plus, OWLEntity minus) {
        this.plus = plus;
        this.minus = minus;
    }

    @Override
    public Iterator<OWLEntity> iterator() {
        return Arrays.asList(plus, minus).iterator();
    }

    @Override
    public int size() {
        return 2;
    }

    /**
     * @return plus entity
     */
    public OWLEntity getPlus() {
        return plus;
    }

    /**
     * @return minus entity
     */
    public OWLEntity getMinus() {
        return minus;
    }
}
