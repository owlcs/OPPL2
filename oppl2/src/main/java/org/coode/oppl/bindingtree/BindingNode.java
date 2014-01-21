/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl.bindingtree;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Renderable;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class BindingNode implements Renderable {
    private static final BindingNode EMPTY_BINDING_NODE = new BindingNode();

    private static class AssignmentFinder implements VariableVisitorEx<OWLObject> {
        private final BindingNode node;
        private final ValueComputationParameters parameters;

        AssignmentFinder(ValueComputationParameters parameters, BindingNode node) {
            this.parameters = parameters;
            this.node = node;
        }

        @Override
        public <O extends OWLObject> OWLObject visit(InputVariable<O> v) {
            return findAssignment(v);
        }

        /** @param v
         *            v
         * @return assignment */
        public OWLObject findAssignment(Variable<?> v) {
            Iterator<Assignment> iterator = node.assignments.iterator();
            boolean found = false;
            OWLObject toReturn = null;
            while (!found && iterator.hasNext()) {
                Assignment assignment = iterator.next();
                found = assignment.getAssignedVariable().equals(v);
                if (found) {
                    toReturn = assignment.getAssignment();
                }
            }
            return toReturn;
        }

        @Override
        public <O extends OWLObject> OWLObject visit(GeneratedVariable<O> v) {
            return v.getOPPLFunction().compute(parameters);
        }

        @Override
        public <O extends OWLObject> OWLObject visit(RegexpGeneratedVariable<O> v) {
            return findAssignment(v);
        }
    }

    private static class VariableInspector implements VariableVisitor {
        private final Set<Variable<?>> toUpdate;

        public VariableInspector(Set<Variable<?>> toUpdate) {
            this.toUpdate = toUpdate;
        }

        @Override
        public <P extends OWLObject> void visit(InputVariable<P> v) {
            toUpdate.add(v);
        }

        @Override
        public <P extends OWLObject> void visit(GeneratedVariable<P> v) {}

        @Override
        public <P extends OWLObject> void
                visit(RegexpGeneratedVariable<P> regExpGenerated) {}
    }

    protected final Set<Assignment> assignments = new HashSet<Assignment>();
    protected final Set<Variable<?>> unassignedVariables = new LinkedHashSet<Variable<?>>();
    protected final VariableInspector unassignedVariablesUpdater = new VariableInspector(
            unassignedVariables);

    /** @param assignments
     *            assignments
     * @param unassignedVariables
     *            unassignedVariables */
    public BindingNode(Collection<Assignment> assignments,
            Collection<? extends Variable<?>> unassignedVariables) {
        this.assignments.addAll(assignments);
        this.unassignedVariables.addAll(unassignedVariables);
    }

    /** @param assignments
     *            assignments */
    public BindingNode(Assignment... assignments) {
        for (Assignment a : assignments) {
            this.assignments.add(a);
        }
    }

    /** @param unassignedVariables
     *            unassignedVariables */
    public BindingNode(Collection<? extends Variable<?>> unassignedVariables) {
        this.unassignedVariables.addAll(unassignedVariables);
    }

    /** @param assignment
     *            assignment */
    public BindingNode(Assignment assignment) {
        assignments.add(assignment);
    }

    /** @param bindingNode
     *            bindingNode */
    public BindingNode(BindingNode bindingNode) {
        this(bindingNode.assignments, bindingNode.unassignedVariables);
    }

    protected BindingNode() {}

    /** @param visitor
     *            visitor */
    public void accept(BindingVisitor visitor) {
        visitor.visit(this);
    }

    /** @param visitor
     *            visitor
     * @param <O>
     *            visitor return type
     * @return visitor value */
    public <O> O accept(BindingVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    /** @return true if leaf */
    public boolean isLeaf() {
        // boolean found = false;
        // Iterator<Variable> it = this.unassignedVariables.iterator();
        // while (!found && it.hasNext()) {
        // found = !it.next().getPossibleBindings().isEmpty();
        // }
        // return this.unassignedVariables.isEmpty() || !found;
        return unassignedVariables.isEmpty();
    }

    @Override
    public String toString() {
        return assignments + "\n"
                + (unassignedVariables.isEmpty() ? "" : unassignedVariables);
    }

    @Override
    public String render(ConstraintSystem cs) {
        boolean first = true;
        StringBuilder b = new StringBuilder();
        OWLEntityRenderer entityRenderer = cs.getOPPLFactory().getOWLEntityRenderer(cs);
        for (Assignment assignment : assignments) {
            OWLObject value = assignment.getAssignment();
            String assignmentRendering = value instanceof OWLEntity ? entityRenderer
                    .render((OWLEntity) value) : value.toString();
            if (!first) {
                b.append(", ");
            }
            first = false;
            b.append(assignment.getAssignedVariable().getName()).append(" = ")
                    .append(assignmentRendering);
        }
        if (!unassignedVariables.isEmpty()) {
            b.append(" ").append(unassignedVariables);
        }
        return b.toString();
    }

    /** @param variable
     *            variable
     * @param parameters
     *            parameters
     * @return assignment */
    public OWLObject getAssignmentValue(Variable<?> variable,
            ValueComputationParameters parameters) {
        return variable.accept(new AssignmentFinder(parameters, this));
    }

    /** @param assignment
     *            assignment */
    public void addAssignment(final Assignment assignment) {
        assignment.getAssignedVariable().accept(new VariableVisitor() {
            @Override
            public <P extends OWLObject> void visit(
                    RegexpGeneratedVariable<P> regExpGenerated) {
                assignments.add(assignment);
                unassignedVariables.remove(assignment.getAssignedVariable());
            }

            @Override
            public <P extends OWLObject> void visit(GeneratedVariable<P> v) {}

            @Override
            public <P extends OWLObject> void visit(InputVariable<P> v) {
                assignments.add(assignment);
                unassignedVariables.remove(assignment.getAssignedVariable());
            }
        });
    }

    /** @return assigned variables */
    public Set<Variable<?>> getAssignedVariables() {
        Set<Variable<?>> toReturn = new HashSet<Variable<?>>();
        for (Assignment assignment : assignments) {
            toReturn.add(assignment.getAssignedVariable());
        }
        return toReturn;
    }

    /** @param v
     *            v
     * @return true if v is an assigned variable */
    public boolean containsAssignedVariable(Variable<?> v) {
        for (Assignment assignment : assignments) {
            if (assignment.getAssignedVariable().equals(v)) {
                return true;
            }
        }
        return false;
    }

    /** @return the assignments */
    public Collection<Assignment> getAssignments() {
        return new ArrayList<Assignment>(assignments);
    }

    /** @return unassigned variables */
    public Set<Variable<?>> getUnassignedVariables() {
        return new LinkedHashSet<Variable<?>>(unassignedVariables);
    }

    /** Adds a variable to the set of the unassigned ones
     * 
     * @param v
     *            v */
    public void addUnassignedVariable(Variable<?> v) {
        v.accept(unassignedVariablesUpdater);
    }

    /** @return true if the Binding node has got no assigned variable nor to
     *         assign variables */
    public boolean isEmpty() {
        return assignments.isEmpty() && unassignedVariables.isEmpty();
    }

    /** @return empty binding node */
    public static BindingNode getEmptyBindingNode() {
        return BindingNode.EMPTY_BINDING_NODE;
    }

    /** @return new binding node */
    public static BindingNode createNewEmptyBindingNode() {
        return new BindingNode();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + assignments.hashCode();
        result = prime * result + unassignedVariables.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        BindingNode other = (BindingNode) obj;
        return assignments.equals(other.assignments)
                && unassignedVariables.equals(other.unassignedVariables);
    }

    /** Determines if this binding node assignments agree with those in the input
     * binding node
     * 
     * @param bindingNode
     *            The input BindingNode. Cannot be <code>null</code>.
     * @return <code>true</code> if this BindingNode agrees with the input one.
     * @throws NullPointerException
     *             if the input binding node is <code>null</code>. */
    public boolean agreesWith(BindingNode bindingNode) {
        checkNotNull(bindingNode, "bindingNode");
        return bindingNode.assignments.containsAll(assignments);
    }
}
