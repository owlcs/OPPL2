package org.coode.oppl.queryplanner;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public abstract class AbstractQueryPlannerItem implements QueryPlannerItem {
    private final ConstraintSystem constraintSystem;

    /** @param constraintSystem
     *            constraintSystem */
    public AbstractQueryPlannerItem(ConstraintSystem constraintSystem) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
    }

    protected Set<BindingNode> merge(BindingNode leaf,
            Collection<? extends BindingNode> newLeaves) {
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        for (BindingNode bindingNode : newLeaves) {
            Set<Assignment> newAssignment = new HashSet<Assignment>(leaf.getAssignments());
            newAssignment.addAll(bindingNode.getAssignments());
            Set<Variable<?>> newUnassigendVariables = new HashSet<Variable<?>>(
                    leaf.getUnassignedVariables());
            newUnassigendVariables.addAll(bindingNode.getUnassignedVariables());
            toReturn.add(new BindingNode(newAssignment, newUnassigendVariables));
        }
        return toReturn;
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    protected boolean isVariableAxiom(OWLAxiom axiom) {
        return !getConstraintSystem().getAxiomVariables(axiom).isEmpty();
    }
}
