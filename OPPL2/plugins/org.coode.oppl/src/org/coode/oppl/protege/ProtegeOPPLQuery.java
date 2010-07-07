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
package org.coode.oppl.protege;

import java.util.List;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeOPPLQuery implements OPPLQuery {
	private final OPPLQuery opplQuery;

	/**
	 * @param opplQuery
	 * @param modelManager
	 */
	public ProtegeOPPLQuery(OPPLQuery opplQuery, OWLModelManager modelManager) {
		this.opplQuery = opplQuery;
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#addAssertedAxiom(org.semanticweb.owl.model.OWLAxiom)
	 */
	public void addAssertedAxiom(OWLAxiom axiom) {
		this.opplQuery.addAssertedAxiom(axiom);
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#addAxiom(org.semanticweb.owl.model.OWLAxiom)
	 */
	public void addAxiom(OWLAxiom axiom) {
		this.opplQuery.addAxiom(axiom);
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#addConstraint(org.coode.oppl.InequalityConstraint)
	 */
	public void addConstraint(AbstractConstraint constraint) {
		this.opplQuery.addConstraint(constraint);
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#getAssertedAxioms()
	 */
	public List<OWLAxiom> getAssertedAxioms() {
		return this.opplQuery.getAssertedAxioms();
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#getAxioms()
	 */
	public List<OWLAxiom> getAxioms() {
		return this.opplQuery.getAxioms();
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#getConstraints()
	 */
	public List<AbstractConstraint> getConstraints() {
		return this.opplQuery.getConstraints();
	}

	/**
	 * @see org.coode.oppl.OPPLQuery#toString(org.coode.oppl.variablemansyntax.ConstraintSystem)
	 */
	@Override
	public String toString() {
		return this.opplQuery.toString();
	}

	public String render() {
		return this.opplQuery.render();
	}

	public ConstraintSystem getConstraintSystem() {
		return this.opplQuery.getConstraintSystem();
	}

	public void execute() {
		try {
			this.opplQuery.execute();
		} catch (OPPLException e) {
			e.printStackTrace();
		}
	}
}
