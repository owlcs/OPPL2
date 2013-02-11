package org.coode.oppl.bindingtree;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.Variable;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Convenience class to represents assignments indexed by variables.
 * 
 * @author Luigi Iannone
 * 
 */
public class AssignmentMap implements Map<Variable<?>, Set<OWLObject>> {
	private final Map<Variable<?>, Set<OWLObject>> delegate = new HashMap<Variable<?>, Set<OWLObject>>();
	private final Set<BindingNode> bindingNodes = new HashSet<BindingNode>();

	/**
	 * Copy constructor.
	 * 
	 * @param assignmentMap
	 *            . Cannot be {@code null}.
	 */
	public AssignmentMap(AssignmentMap assignmentMap) {
		if (assignmentMap == null) {
			throw new NullPointerException(
					"The input assignment map cannot be null");
		}
		bindingNodes.addAll(assignmentMap.bindingNodes);
		delegate.putAll(assignmentMap.delegate);
	}

	public AssignmentMap(Collection<? extends BindingNode> bindingNodes) {
		if (bindingNodes == null) {
			throw new NullPointerException(
					"The binding nodes collection cannot be null");
		}
		if (bindingNodes.isEmpty()) {
			return;
		}
		this.bindingNodes.addAll(bindingNodes);
		for (BindingNode bindingNode : bindingNodes) {
			for (Assignment assignment : bindingNode.getAssignments()) {
				Variable<?> assignedVariable = assignment.getAssignedVariable();
				OWLObject assignedValue = assignment.getAssignment();
				Set<OWLObject> previousAssignements = get(assignedVariable);
				if (previousAssignements == null) {
					previousAssignements = new HashSet<OWLObject>();
					put(assignedVariable, previousAssignements);
				}
				previousAssignements.add(assignedValue);
			}
		}
	}

	/**
	 * @return
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return delegate.size();
	}

	/**
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return delegate.containsKey(key);
	}

	/**
	 * @param value
	 * @return
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Set<OWLObject> get(Object key) {
		return delegate.get(key);
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Set<OWLObject> put(Variable<?> key, Set<OWLObject> value) {
		return delegate.put(key, value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Set<OWLObject> remove(Object key) {
		return delegate.remove(key);
	}

	/**
	 * @param arg0
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends Variable<?>, ? extends Set<OWLObject>> arg0) {
		delegate.putAll(arg0);
	}

	/**
	 * 
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		delegate.clear();
	}

	/**
	 * @return
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<Variable<?>> keySet() {
		return delegate.keySet();
	}

	/**
	 * @return
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<Set<OWLObject>> values() {
		return delegate.values();
	}

	/**
	 * @return
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<Variable<?>, Set<OWLObject>>> entrySet() {
		return delegate.entrySet();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Map#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return delegate.equals(o);
	}

	/**
	 * @return
	 * @see java.util.Map#hashCode()
	 */
	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	/**
	 * The set of Variables in this AssignementMap
	 * 
	 * @return a Set of Variable
	 */
	public Set<Variable<?>> getVariables() {
		return new HashSet<Variable<?>>(keySet());
	}

	/**
	 * @return the bindingNodes
	 */
	public Set<BindingNode> getBindingNodes() {
		return new HashSet<BindingNode>(bindingNodes);
	}

	public boolean isDisjointWith(AssignmentMap anotherAssignmentMap) {
		if (anotherAssignmentMap == null) {
			throw new NullPointerException(
					"The input assignment map cannot be null");
		}
		boolean found = false;
		Iterator<Variable<?>> iterator = keySet().iterator();
		while (!found && iterator.hasNext()) {
			Variable<?> variable = iterator.next();
			if (anotherAssignmentMap.keySet().contains(variable)) {
				Set<OWLObject> set = new HashSet<OWLObject>(get(variable));
				set.retainAll(anotherAssignmentMap.get(variable));
				found = !set.isEmpty();
			}
		}
		return !found;
	}

	public static boolean areDisjoint(
			Collection<? extends AssignmentMap> assignmentMaps) {
		if (assignmentMaps == null) {
			throw new NullPointerException(
					"The colleciton of AssignmentMap cannot be null");
		}
		if (assignmentMaps.isEmpty()) {
			throw new IllegalArgumentException(
					"The collection of AssignmentMap cannot be empty");
		}
		boolean found = false;
		Iterator<? extends AssignmentMap> iterator = assignmentMaps.iterator();
		while (!found && iterator.hasNext()) {
			AssignmentMap assignmentMap = iterator.next();
			Iterator<? extends AssignmentMap> anotherIterator = assignmentMaps
					.iterator();
			while (!found && anotherIterator.hasNext()) {
				AssignmentMap anotherAssignmentMap = anotherIterator.next();
				if (assignmentMap != anotherAssignmentMap) {
					found = assignmentMap.isDisjointWith(anotherAssignmentMap);
				}
			}
		}
		return found;
	}

	@Override
	public String toString() {
		return delegate.toString();
	}
}
