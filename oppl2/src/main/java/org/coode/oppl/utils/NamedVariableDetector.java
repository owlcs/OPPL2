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
package org.coode.oppl.utils;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * Detects the presence of a particular variable in an OWLObject instance.
 * 
 * @author Luigi Iannone
 */
public class NamedVariableDetector extends AbstractVariableDetector {

    private final Variable<?> variable;

    /**
     * @param variable variable
     * @param constraintSystem constraintSystem
     */
    public NamedVariableDetector(Variable<?> variable, ConstraintSystem constraintSystem) {
        super(constraintSystem);
        this.variable = variable;
    }

    @Override
    public Boolean visit(OWLClass desc) {
        return Boolean.valueOf(constraintSystem.isVariableIRI(desc.getIRI())
            && constraintSystem.getVariable(desc.getIRI()).equals(variable));
    }

    @Override
    public Boolean visit(OWLLiteral node) {
        return Boolean.valueOf(constraintSystem.isVariable(node)
            && constraintSystem.getVariable(node.getLiteral()).equals(variable));
    }

    @Override
    public Boolean visit(OWLObjectProperty property) {
        return Boolean.valueOf(constraintSystem.isVariable(property)
            && constraintSystem.getVariable(property.getIRI()).equals(variable));
    }

    @Override
    public Boolean visit(OWLDataProperty property) {
        return Boolean.valueOf(constraintSystem.isVariable(property)
            && constraintSystem.getVariable(property.getIRI()).equals(variable));
    }

    @Override
    public Boolean visit(OWLNamedIndividual individual) {
        return Boolean.valueOf(constraintSystem.isVariable(individual)
            && constraintSystem.getVariable(individual.getIRI()).equals(variable));
    }
}
