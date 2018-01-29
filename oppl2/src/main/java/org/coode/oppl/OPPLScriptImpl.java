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
package org.coode.oppl;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.VariableRecogniser;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class OPPLScriptImpl implements OPPLScript {

    private final ConstraintSystem constraintSystem;
    private final List<Variable<?>> variables = new ArrayList<>();
    private final OPPLQuery query;
    private final List<OWLAxiomChange> actions;
    private final OPPLAbstractFactory factory;

    /**
     * @param constraintSystem
     *        constraintSystem
     * @param variables
     *        variables
     * @param query
     *        query
     * @param actions
     *        actions
     * @param factory
     *        factory
     */
    public OPPLScriptImpl(ConstraintSystem constraintSystem, List<Variable<?>> variables,
        OPPLQuery query, List<OWLAxiomChange> actions, OPPLAbstractFactory factory) {
        this(constraintSystem, variables, query, actions, factory, false);
    }

    /**
     * @param constraintSystem
     *        constraintSystem
     * @param variables
     *        variables
     * @param query
     *        query
     * @param actions
     *        actions
     * @param factory
     *        factory
     * @param resetExecution
     *        resetExecution
     */
    public OPPLScriptImpl(ConstraintSystem constraintSystem, List<Variable<?>> variables,
        OPPLQuery query, List<OWLAxiomChange> actions, OPPLAbstractFactory factory,
        boolean resetExecution) {
        this.constraintSystem = constraintSystem;
        this.variables.addAll(variables);
        if (!resetExecution) {
            this.query = query;
        } else {
            this.query = query == null ? null : new OPPLQueryImpl(query, factory);
        }
        this.actions = new ArrayList<>(actions);
        this.factory = factory;
    }

    @Override
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public List<InputVariable<?>> getInputVariables() {
        List<InputVariable<?>> toReturn = new ArrayList<>(variables.size());
        for (Variable<?> v : variables) {
            if (VariableRecogniser.INPUT_VARIABLE_RECOGNISER.recognise(v)) {
                toReturn.add((InputVariable<?>) v);
            }
        }
        return toReturn;
    }

    @Override
    public List<Variable<?>> getVariables() {
        return new ArrayList<>(variables);
    }

    /**
     * @return the query
     */
    @Override
    public OPPLQuery getQuery() {
        return query;
    }

    /**
     * @return the actions
     */
    @Override
    public List<OWLAxiomChange> getActions() {
        return actions;
    }

    @Override
    public void accept(OPPLScriptVisitor visitor) {
        for (Variable<?> v : variables) {
            visitor.visit(v);
        }
        visitor.visit(getQuery());
        visitor.visitActions(getActions());
    }

    @Override
    public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
        P p = null;
        for (Variable<?> v : variables) {
            p = visitor.visit(v, p);
        }
        p = visitor.visit(getQuery(), p);
        p = visitor.visitActions(getActions(), p);
        return p;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        boolean first = true;
        for (Variable<?> v : variables) {
            String commaString = first ? "" : ", ";
            first = false;
            buffer.append(commaString);
            buffer.append(v.render(getConstraintSystem()));
        }
        if (buffer.length() > 0) {
            buffer.append(" ");
        }
        OPPLQuery opplQuery = getQuery();
        if (query != null) {
            buffer.append(opplQuery.toString());
        }
        if (!getActions().isEmpty()) {
            buffer.append(" BEGIN ");
            first = true;
            for (OWLAxiomChange action : getActions()) {
                String commaString = first ? "" : ", ";
                ManchesterSyntaxRenderer renderer =
                    factory.getManchesterSyntaxRenderer(constraintSystem);
                String actionString = action.isAddAxiom() ? "ADD " : "REMOVE ";
                first = false;
                buffer.append(commaString);
                buffer.append(actionString);
                action.getAxiom().accept(renderer);
                buffer.append(renderer.toString());
            }
            buffer.append(" END;");
        }
        return buffer.toString();
    }

    @Override
    public String render() {
        return toString();
    }

    @Override
    public String render(ConstraintSystem cs) {
        return render();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        StringBuilder buffer = new StringBuilder();
        boolean first = true;
        for (Variable<?> v : variables) {
            String commaString = first ? "" : ", ";
            first = false;
            buffer.append(commaString);
            buffer.append(v.render(getConstraintSystem()));
        }
        if (buffer.length() > 0) {
            buffer.append(" ");
        }
        OPPLQuery opplQuery = getQuery();
        if (query != null) {
            buffer.append(opplQuery.render(shortFormProvider));
        }
        if (!getActions().isEmpty()) {
            buffer.append(" BEGIN ");
            first = true;
            for (OWLAxiomChange action : getActions()) {
                String commaString = first ? "" : ", ";
                ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
                String actionString = action.isAddAxiom() ? "ADD " : "REMOVE ";
                first = false;
                buffer.append(commaString);
                buffer.append(actionString);
                action.getAxiom().accept(renderer);
                buffer.append(renderer.toString());
            }
            buffer.append(" END;");
        }
        return buffer.toString();
    }

    @Override
    public void addVariable(Variable<?> variable) {
        variables.add(variable);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (actions == null ? 0 : actions.hashCode());
        result = prime * result + (query == null ? 0 : query.hashCode());
        result = prime * result + (variables == null ? 0 : variables.hashCode());
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
        OPPLScriptImpl other = (OPPLScriptImpl) obj;
        if (actions == null) {
            if (other.actions != null) {
                return false;
            }
        } else if (!actions.equals(other.actions)) {
            return false;
        }
        if (query == null) {
            if (other.query != null) {
                return false;
            }
        } else if (!query.equals(other.query)) {
            return false;
        }
        if (variables == null) {
            if (other.variables != null) {
                return false;
            }
        } else if (!variables.equals(other.variables)) {
            return false;
        }
        return true;
    }
}
