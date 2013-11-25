package org.coode.oppl.search.solvability;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class SolvableSearchNode extends SolvabilitySearchNode {
    private final Set<OWLObject> values = new HashSet<OWLObject>();
    private final Variable<?> variable;

    /** @param axiom
     * @param bindingNode */
    public SolvableSearchNode(Variable<?> variable, OWLAxiom axiom,
            BindingNode bindingNode, Collection<? extends OWLObject> values) {
        super(axiom, bindingNode);
        this.variable = checkNotNull(variable, "variable");
        this.values.addAll(checkNotNull(values, "values"));
    }

    @Override
    public void accept(SolvabilitySearchNodeVisitor visitor) {
        visitor.visitSolvableSearchNode(this);
    }

    @Override
    public <O> O accept(SolvabilitySearchNodeVisitorEx<O> visitor) {
        return visitor.visitSolvableSearchNode(this);
    }

    /** @return the values */
    public Set<OWLObject> getValues() {
        return new HashSet<OWLObject>(values);
    }

    /** @return the variable */
    public Variable<?> getVariable() {
        return variable;
    }
}
