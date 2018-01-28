package org.coode.oppl.bindingtree;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.Variable;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * Convenience class to represents assignments indexed by variables.
 * 
 * @author Luigi Iannone
 */
public class AssignmentMap implements Map<Variable<?>, Set<OWLObject>> {

    private final Map<Variable<?>, Set<OWLObject>> delegate = new HashMap<>();
    private final Set<BindingNode> bindingNodes = new HashSet<>();

    /**
     * Copy constructor.
     * 
     * @param assignmentMap . Cannot be {@code null}.
     */
    public AssignmentMap(AssignmentMap assignmentMap) {
        checkNotNull(assignmentMap, "assignmentMap");
        bindingNodes.addAll(assignmentMap.bindingNodes);
        delegate.putAll(assignmentMap.delegate);
    }

    /**
     * @param bindingNodes bindingNodes
     */
    public AssignmentMap(Collection<? extends BindingNode> bindingNodes) {
        if (bindingNodes == null || bindingNodes.isEmpty()) {
            return;
        }
        this.bindingNodes.addAll(bindingNodes);
        for (BindingNode bindingNode : bindingNodes) {
            for (Assignment assignment : bindingNode.getAssignments()) {
                Variable<?> assignedVariable = assignment.getAssignedVariable();
                OWLObject assignedValue = assignment.getAssignment();
                delegate.computeIfAbsent(assignedVariable, x -> new HashSet<>()).add(assignedValue);
            }
        }
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    @Override
    public Set<OWLObject> get(Object key) {
        return delegate.get(key);
    }

    @Override
    public Set<OWLObject> put(Variable<?> key, Set<OWLObject> value) {
        return delegate.put(key, value);
    }

    @Override
    public Set<OWLObject> remove(Object key) {
        return delegate.remove(key);
    }

    @Override
    public void putAll(Map<? extends Variable<?>, ? extends Set<OWLObject>> arg0) {
        delegate.putAll(arg0);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public Set<Variable<?>> keySet() {
        return delegate.keySet();
    }

    @Override
    public Collection<Set<OWLObject>> values() {
        return delegate.values();
    }

    @Override
    public Set<Map.Entry<Variable<?>, Set<OWLObject>>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        return delegate.equals(o);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    /**
     * The set of Variables in this AssignementMap
     * 
     * @return a collection of Variables, without duplicates
     * @deprecated use the stream methods to save on defensive copies
     */
    @Deprecated
    public Set<Variable<?>> getVariables() {
        return new HashSet<>(keySet());
    }

    /**
     * The Variables in this AssignementMap
     * 
     * @return a stream of Variables, without duplicates
     */
    public Stream<Variable<?>> variables() {
        return delegate.keySet().stream();
    }

    /**
     * @return the bindingNodes, without duplicates
     * @deprecated use the stream methods to save on defensive copies
     */
    @Deprecated
    public Set<BindingNode> getBindingNodes() {
        return new HashSet<>(bindingNodes);
    }

    /**
     * @return the bindingNodes, without duplicates
     */
    public Stream<BindingNode> bindingNodes() {
        return bindingNodes.stream();
    }

    /**
     * @param anotherAssignmentMap anotherAssignmentMap
     * @return true if disjoint
     */
    public boolean isDisjointWith(AssignmentMap anotherAssignmentMap) {
        checkNotNull(anotherAssignmentMap, "anotherAssignmentMap");
        return delegate.entrySet().stream().noneMatch(
            e -> anotherAssignmentMap.variableHasMatchingValues(e.getKey(), e.getValue()));
    }

    /**
     * @param v variable to test
     * @param values values to match
     * @return true if the variable has one of the input values in this assignment map
     */
    public boolean variableHasMatchingValues(Variable<?> v, Collection<OWLObject> values) {
        Set<OWLObject> o = delegate.get(v);
        if (o == null) {
            return false;
        }
        return values.stream().anyMatch(o::contains);
    }

    /**
     * @param assignmentMaps assignmentMaps
     * @return true if disjoint
     */
    public static boolean areDisjoint(Collection<? extends AssignmentMap> assignmentMaps) {
        checkNotNull(assignmentMaps, "assignmentMaps");
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
