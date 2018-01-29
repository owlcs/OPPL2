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
package org.coode.oppl.querymatching;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.ConstraintVisitorEx;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.OWLObjectInstantiator;
import org.coode.oppl.RegExpConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * This ConstraintVisitor implementation verifies if the visited Constraint holds
 * 
 * @author Luigi Iannone
 */
public class ConstraintChecker implements ConstraintVisitorEx<Boolean> {

    private final ValueComputationParameters parameters;
    private final OWLObjectInstantiator instantiator;

    /**
     * @param parameters parameters
     */
    public ConstraintChecker(ValueComputationParameters parameters) {
        this.parameters = checkNotNull(parameters, "parameters");
        instantiator = new OWLObjectInstantiator(getParameters());
    }

    /**
     * @return the parameters
     */
    public ValueComputationParameters getParameters() {
        return parameters;
    }

    @Override
    public Boolean visit(InequalityConstraint c) {
        OWLObject expression = c.getExpression();
        OWLObject instantiatedObject = expression.accept(instantiator);
        Variable<?> variable = c.getVariable();
        OWLObject assignedValue =
            getParameters().getBindingNode().getAssignmentValue(variable, getParameters());
        return Boolean.valueOf(!assignedValue.equals(instantiatedObject));
    }

    @Override
    public Boolean visit(InCollectionConstraint<? extends OWLObject> c) {
        OWLObject assignedValue =
            getParameters().getBindingNode().getAssignmentValue(c.getVariable(), getParameters());
        return Boolean
            .valueOf(c.collection().anyMatch(o -> assignedValue.equals(o.accept(instantiator))));
    }

    @Override
    public Boolean visit(RegExpConstraint c) {
        return Boolean.valueOf(c.matches(getParameters()));
    }

    @Override
    public Boolean visit(NAFConstraint nafConstraint) {
        OWLAxiom instantiatedAxiom = (OWLAxiom) nafConstraint.getAxiom().accept(instantiator);
        boolean toReturn = false;
        try {
            if (getParameters().getConstraintSystem().getReasoner() != null
                && nafConstraint.getAxiom().isLogicalAxiom()) {
                toReturn = !getParameters().getConstraintSystem().getReasoner()
                    .isEntailed(instantiatedAxiom);
            } else {
                boolean found = getParameters().getConstraintSystem().getOntologyManager()
                    .ontologies().anyMatch(o -> o.containsAxiom(instantiatedAxiom));
                toReturn = !found;
            }
        } catch (OWLRuntimeException e) {
            Logging.getQueryLogger().log(
                "OWLReasonerException caught whilst checking the constraint ", nafConstraint,
                getParameters().getConstraintSystem(), e);
        }
        return Boolean.valueOf(toReturn);
    }
}
