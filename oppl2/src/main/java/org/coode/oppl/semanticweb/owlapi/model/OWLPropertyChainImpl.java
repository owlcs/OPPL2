package org.coode.oppl.semanticweb.owlapi.model;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

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

/** @author Luigi Iannone */
public class OWLPropertyChainImpl implements OWLPropertyChain {
    private final List<OWLObjectPropertyExpression> delegate = new ArrayList<OWLObjectPropertyExpression>();

    /** @param delegate */
    public OWLPropertyChainImpl(List<? extends OWLObjectPropertyExpression> delegate) {
        this.delegate.addAll(checkNotNull(delegate, "delegate"));
        if (delegate.size() < 2) {
            throw new IllegalArgumentException(
                    "The list cannot have less than 2 elements");
        }
    }

    @Override
    public void add(int index, OWLObjectPropertyExpression element) {
        delegate.add(index, element);
    }

    @Override
    public boolean add(OWLObjectPropertyExpression e) {
        return delegate.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends OWLObjectPropertyExpression> c) {
        return delegate.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends OWLObjectPropertyExpression> c) {
        return delegate.addAll(index, c);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return delegate.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return delegate.equals(o);
    }

    @Override
    public OWLObjectPropertyExpression get(int index) {
        return delegate.get(index);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public Iterator<OWLObjectPropertyExpression> iterator() {
        return delegate.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    @Override
    public ListIterator<OWLObjectPropertyExpression> listIterator() {
        return delegate.listIterator();
    }

    @Override
    public ListIterator<OWLObjectPropertyExpression> listIterator(int index) {
        return delegate.listIterator(index);
    }

    @Override
    public OWLObjectPropertyExpression remove(int index) {
        return delegate.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return delegate.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return delegate.retainAll(c);
    }

    @Override
    public OWLObjectPropertyExpression
            set(int index, OWLObjectPropertyExpression element) {
        return delegate.set(index, element);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public List<OWLObjectPropertyExpression> subList(int fromIndex, int toIndex) {
        return delegate.subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return delegate.toArray(a);
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
        Set<OWLEntity> toReturn = new HashSet<OWLEntity>();
        for (OWLObjectPropertyExpression propertyExpression : delegate) {
            toReturn.addAll(propertyExpression.getSignature());
        }
        return toReturn;
    }

    @Override
    public Set<OWLClass> getClassesInSignature() {
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
        Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
        for (OWLObjectPropertyExpression propertyExpression : delegate) {
            toReturn.addAll(propertyExpression.getObjectPropertiesInSignature());
        }
        return toReturn;
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
