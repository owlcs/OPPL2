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
			throw new NullPointerException("The input assignment map cannot be null");
		}
		this.bindingNodes.addAll(assignmentMap.bindingNodes);
		this.delegate.clear();
		this.delegate.putAll(assignmentMap.delegate);
	}

	public AssignmentMap(Collection<? extends BindingNode> bindingNodes) {
		if (bindingNodes == null) {
			throw new NullPointerException("The binding nodes collection cannot be null");
		}
		this.bindingNodes.addAll(bindingNodes);
		for (BindingNode bindingNode : bindingNodes) {
			for (Assignment assignment : bindingNode.getAssignments()) {
				Variable<?> assignedVariable = assignment.getAssignedVariable();
				OWLObject assignedValue = assignment.getAssignment();
				Set<OWLObject> previousAssignements = this.get(assignedVariable);
				if (previousAssignements == null) {
					previousAssignements = new HashSet<OWLObject>();
					this.put(assignedVariable, previousAssignements);
				}
				previousAssignements.add(assignedValue);
			}
		}
	}

	/**
	 * @return
	 * @see java.util.Map#size()
	 */
	public int size() {
		return this.delegate.size();
	}

	/**
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return this.delegate.isEmpty();
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		return this.delegate.containsKey(key);
	}

	/**
	 * @param value
	 * @return
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		return this.delegate.containsValue(value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Set<OWLObject> get(Object key) {
		return this.delegate.get(key);
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Set<OWLObject> put(Variable<?> key, Set<OWLObject> value) {
		return this.delegate.put(key, value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public Set<OWLObject> remove(Object key) {
		return this.delegate.remove(key);
	}

	/**
	 * @param arg0
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map<? extends Variable<?>, ? extends Set<OWLObject>> arg0) {
		this.delegate.putAll(arg0);
	}

	/**
	 * 
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		this.delegate.clear();
	}

	/**
	 * @return
	 * @see java.util.Map#keySet()
	 */
	public Set<Variable<?>> keySet() {
		return this.delegate.keySet();
	}

	/**
	 * @return
	 * @see java.util.Map#values()
	 */
	public Collection<Set<OWLObject>> values() {
		return this.delegate.values();
	}

	/**
	 * @return
	 * @see java.util.Map#entrySet()
	 */
	public Set<java.util.Map.Entry<Variable<?>, Set<OWLObject>>> entrySet() {
		return this.delegate.entrySet();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Map#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return this.delegate.equals(o);
	}

	/**
	 * @return
	 * @see java.util.Map#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}

	/**
	 * The set of Variables in this AssignementMap
	 * 
	 * @return a Set of Variable
	 */
	public Set<Variable<?>> getVariables() {
		return new HashSet<Variable<?>>(this.keySet());
	}

	/**
	 * @return the bindingNodes
	 */
	public Set<BindingNode> getBindingNodes() {
		return new HashSet<BindingNode>(this.bindingNodes);
	}

	public boolean isDisjointWith(AssignmentMap anotherAssignmentMap) {
		if (anotherAssignmentMap == null) {
			throw new NullPointerException("The input assignment map cannot be null");
		}
		boolean found = false;
		Iterator<Variable<?>> iterator = this.getVariables().iterator();
		while (!found && iterator.hasNext()) {
			Variable<?> variable = iterator.next();
			if (anotherAssignmentMap.getVariables().contains(variable)) {
				Set<OWLObject> set = new HashSet<OWLObject>(this.get(variable));
				set.retainAll(anotherAssignmentMap.get(variable));
				found = !set.isEmpty();
			}
		}
		return !found;
	}

	public static boolean areDisjoint(Collection<? extends AssignmentMap> assignmentMaps) {
		if (assignmentMaps == null) {
			throw new NullPointerException("The colleciton of AssignmentMap cannot be null");
		}
		if (assignmentMaps.isEmpty()) {
			throw new IllegalArgumentException("The collection of AssignmentMap cannot be empty");
		}
		boolean found = false;
		Iterator<? extends AssignmentMap> iterator = assignmentMaps.iterator();
		while (!found && iterator.hasNext()) {
			AssignmentMap assignmentMap = iterator.next();
			Iterator<? extends AssignmentMap> anotherIterator = assignmentMaps.iterator();
			while (!found && anotherIterator.hasNext()) {
				AssignmentMap anotherAssignmentMap = anotherIterator.next();
				if (assignmentMap != anotherAssignmentMap) {
					found = !assignmentMap.isDisjointWith(anotherAssignmentMap);
				}
			}
		}
		return !found;
	}

	@Override
	public String toString() {
		return this.delegate.toString();
	}
}
