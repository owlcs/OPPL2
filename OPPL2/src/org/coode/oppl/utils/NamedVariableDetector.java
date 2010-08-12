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
 * 
 */
public class NamedVariableDetector extends AbstractVariableDetector {
	private final Variable variable;

	/**
	 * @param constraintSystem
	 */
	public NamedVariableDetector(Variable variable, ConstraintSystem constraintSystem) {
		super(constraintSystem);
		this.variable = variable;
	}

	public Boolean visit(OWLClass desc) {
		return this.constraintSystem.isVariableIRI(desc.getIRI())
				&& this.constraintSystem.getVariable(desc.getIRI()).equals(this.variable);
	}

	public Boolean visit(OWLLiteral node) {
		return this.constraintSystem.isVariable(node)
				&& this.constraintSystem.getVariable(node.getLiteral()).equals(this.variable);
	}

	public Boolean visit(OWLObjectProperty property) {
		return this.constraintSystem.isVariable(property)
				&& this.constraintSystem.getVariable(property.getIRI()).equals(this.variable);
	}

	public Boolean visit(OWLDataProperty property) {
		return this.constraintSystem.isVariable(property)
				&& this.constraintSystem.getVariable(property.getIRI()).equals(this.variable);
	}

	public Boolean visit(OWLNamedIndividual individual) {
		return this.constraintSystem.isVariable(individual)
				&& this.constraintSystem.getVariable(individual.getIRI()).equals(this.variable);
	}
}
