/**
 * 
 */
package org.semanticweb.owlapi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * @author Luigi Iannone
 * 
 */
public class OWLPropertyChainImpl implements OWLPropertyChain {
	private final List<OWLObjectPropertyExpression> delegate = new ArrayList<OWLObjectPropertyExpression>();

	/**
	 * @param delegate
	 */
	public OWLPropertyChainImpl(List<? extends OWLObjectPropertyExpression> delegate) {
		if (delegate == null) {
			throw new NullPointerException("The list cannot be null");
		}
		if (delegate.size() < 2) {
			throw new IllegalArgumentException("The list cannot have less than 2 elements");
		}
		this.delegate.clear();
		this.delegate.addAll(delegate);
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, OWLObjectPropertyExpression element) {
		this.delegate.add(index, element);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(OWLObjectPropertyExpression e) {
		return this.delegate.add(e);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends OWLObjectPropertyExpression> c) {
		return this.delegate.addAll(c);
	}

	/**
	 * @param index
	 * @param c
	 * @return
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends OWLObjectPropertyExpression> c) {
		return this.delegate.addAll(index, c);
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		this.delegate.clear();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return this.delegate.contains(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return this.delegate.containsAll(c);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return this.delegate.equals(o);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public OWLObjectPropertyExpression get(int index) {
		return this.delegate.get(index);
	}

	/**
	 * @return
	 * @see java.util.List#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return this.delegate.indexOf(o);
	}

	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return this.delegate.isEmpty();
	}

	/**
	 * @return
	 * @see java.util.List#iterator()
	 */
	public Iterator<OWLObjectPropertyExpression> iterator() {
		return this.delegate.iterator();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return this.delegate.lastIndexOf(o);
	}

	/**
	 * @return
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<OWLObjectPropertyExpression> listIterator() {
		return this.delegate.listIterator();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<OWLObjectPropertyExpression> listIterator(int index) {
		return this.delegate.listIterator(index);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public OWLObjectPropertyExpression remove(int index) {
		return this.delegate.remove(index);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return this.delegate.remove(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return this.delegate.removeAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return this.delegate.retainAll(c);
	}

	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public OWLObjectPropertyExpression set(int index, OWLObjectPropertyExpression element) {
		return this.delegate.set(index, element);
	}

	/**
	 * @return
	 * @see java.util.List#size()
	 */
	public int size() {
		return this.delegate.size();
	}

	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @see java.util.List#subList(int, int)
	 */
	public List<OWLObjectPropertyExpression> subList(int fromIndex, int toIndex) {
		return this.delegate.subList(fromIndex, toIndex);
	}

	/**
	 * @return
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return this.delegate.toArray();
	}

	/**
	 * @param <T>
	 * @param a
	 * @return
	 * @see java.util.List#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return this.delegate.toArray(a);
	}

	public void accept(OWLObjectVisitor visitor) {
		// Broken visitor pattern
	}

	public <O> O accept(OWLObjectVisitorEx<O> visitor) {
		// Broken visitor pattern
		return null;
	}

	public int compareTo(OWLObject o) {
		// Broken comparator
		return 1;
	}

	public Set<OWLEntity> getSignature() {
		Set<OWLEntity> toReturn = new HashSet<OWLEntity>();
		for (OWLObjectPropertyExpression propertyExpression : this.delegate) {
			toReturn.addAll(propertyExpression.getSignature());
		}
		return toReturn;
	}

	public Set<OWLClass> getClassesInSignature() {
		return Collections.emptySet();
	}

	public Set<OWLNamedIndividual> getIndividualsInSignature() {
		return Collections.emptySet();
	}

	public Set<OWLDataProperty> getDataPropertiesInSignature() {
		return Collections.emptySet();
	}

	public Set<OWLDatatype> getDatatypesInSignature() {
		return Collections.emptySet();
	}

	public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
		Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
		for (OWLObjectPropertyExpression propertyExpression : this.delegate) {
			toReturn.addAll(propertyExpression.getObjectPropertiesInSignature());
		}
		return toReturn;
	}

	public Set<OWLClassExpression> getNestedClassExpressions() {
		return Collections.emptySet();
	}

	public boolean isBottomEntity() {
		return false;
	}

	public boolean isTopEntity() {
		return false;
	}
}
