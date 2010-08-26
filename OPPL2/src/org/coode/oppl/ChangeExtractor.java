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

import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.utils.ArgCheck;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;

/**
 * Returns the changes that will occur if the visited OPPL construct is executed
 * 
 * @author Luigi Iannone
 * 
 */
public class ChangeExtractor implements OPPLScriptVisitorEx<List<OWLAxiomChange>> {
	private final boolean considerImportClosure;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param ontologyManager
	 */
	public ChangeExtractor(ConstraintSystem constraintSystem, boolean considerImportClosure) {
		ArgCheck.checkNullArgument("The constraint system", constraintSystem);
		this.constraintSystem = constraintSystem;
		this.considerImportClosure = considerImportClosure;
	}

	public List<OWLAxiomChange> visit(OPPLQuery q, List<OWLAxiomChange> p) {
		if (q != null) {
			try {
				q.execute();
			} catch (OPPLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	public List<OWLAxiomChange> visit(Variable v, List<OWLAxiomChange> p) {
		return p;
	}

	public List<OWLAxiomChange> visitActions(List<OWLAxiomChange> changes, List<OWLAxiomChange> p) {
		if (p == null) {
			p = new ArrayList<OWLAxiomChange>();
		}
		for (OWLAxiomChange change : changes) {
			boolean isAdd = change instanceof AddAxiom;
			ActionType action = isAdd ? ActionType.ADD : ActionType.REMOVE;
			if (this.considerImportClosure && !isAdd) {
				p.addAll(ActionFactory.createChanges(
						action,
						change.getAxiom(),
						this.constraintSystem,
						this.getConstraintSystem().getOntologyManager().getImportsClosure(
								this.getConstraintSystem().getOntology())));
			} else {
				p.addAll(ActionFactory.createChanges(
						action,
						change.getAxiom(),
						this.getConstraintSystem(),
						this.getConstraintSystem().getOntology()));
			}
		}
		return p;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
