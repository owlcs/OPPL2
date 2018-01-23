package org.coode.oppl.semanticweb.owlapi.model;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/**
 * @author Luigi Iannone
 */
public class OWLPropertyChainImpl implements OWLPropertyChain {

    private static final long serialVersionUID = 20100L;
    private final List<OWLObjectPropertyExpression> delegate = new ArrayList<>();

    /**
     * @param delegate delegate
     */
    public OWLPropertyChainImpl(List<? extends OWLObjectPropertyExpression> delegate) {
        this.delegate.addAll(checkNotNull(delegate, "delegate"));
        if (delegate.size() < 2) {
            throw new IllegalArgumentException("The list cannot have less than 2 elements");
        }
    }

    @Override
    public List<OWLObjectPropertyExpression> list() {
        return new ArrayList<>(delegate);
    }


    @Override
    public boolean equals(Object o) {
        return delegate.equals(o);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public Stream<?> components() {
        return Stream.of(delegate);
    }

    @Override
    public int hashIndex() {
        return 19907;
    }

    @Override
    public int initHashCode() {
        return delegate.hashCode();
    }

    @Override
    public int typeIndex() {
        return 19907;
    }

    @Override
    public void accept(OWLObjectVisitor visitor) {
        // Broken visitor pattern
    }

    @Override
    public <O> O accept(OWLObjectVisitorEx<O> visitor) {
        // Broken visitor pattern
        return null;
    }

    @Override
    public int compareTo(OWLObject o) {
        // Broken comparator
        return 1;
    }

    @Override
    public Set<OWLEntity> getSignature() {
        return asSet(delegate.stream().flatMap(OWLObjectPropertyExpression::signature));
    }

    @Override
    public boolean containsEntityInSignature(OWLEntity owlEntity) {
        for (OWLObjectPropertyExpression e : delegate) {
            if (e.containsEntityInSignature(owlEntity)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<OWLClass> getClassesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLAnnotationProperty> getAnnotationPropertiesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLNamedIndividual> getIndividualsInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLDatatype> getDatatypesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
        return asSet(
            delegate.stream().flatMap(OWLObjectPropertyExpression::objectPropertiesInSignature));
    }

    @Override
    public Set<OWLClassExpression> getNestedClassExpressions() {
        return Collections.emptySet();
    }

    @Override
    public boolean isBottomEntity() {
        return false;
    }

    @Override
    public boolean isTopEntity() {
        return false;
    }

    @Override
    public Set<OWLAnonymousIndividual> getAnonymousIndividuals() {
        return Collections.emptySet();
    }
}
