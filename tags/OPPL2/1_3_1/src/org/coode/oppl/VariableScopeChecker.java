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

import org.coode.oppl.exceptions.NullReasonerException;
import org.coode.oppl.exceptions.OPPLException;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * Visitor that checks whether a value is within the scope of the visited
 * VariableScope or not
 * 
 * 
 * 
 * @author Luigi Iannone
 * 
 */
public class VariableScopeChecker {
	private final OWLOntologyManager ontologyManager;
	private final OWLReasoner reasoner;

	/**
	 * @param ontologyManager
	 * @param reasoner
	 */
	public VariableScopeChecker(OWLOntologyManager ontologyManager, OWLReasoner reasoner)
			throws OPPLException {
		if (reasoner == null) {
			throw new NullReasonerException();
		} else {
			this.ontologyManager = ontologyManager;
			this.reasoner = reasoner;
		}
	}

	/**
	 * @param owlCass
	 * @param scope
	 * @return true is the input owlClass is in the input scope, false otherwise
	 * @throws OWLReasonerException
	 */
	protected boolean check(OWLClass owlCass, SubClassVariableScope scope)
			throws OWLReasonerException {
		OWLDescription description = scope.getDescription();
		return this.getReasoner().isSubClassOf(owlCass, description);
	}

	/**
	 * @param owlCass
	 * @param scope
	 * @return true is the input owlClass is in the input scope, false otherwise
	 * @throws OWLReasonerException
	 */
	protected boolean check(OWLClass owlCass, SuperClassVariableScope scope)
			throws OWLReasonerException {
		OWLDescription description = scope.getDescription();
		return this.getReasoner().isSubClassOf(description, owlCass);
	}

	/**
	 * @param individual
	 * @param scope
	 * @return true is the input individual is in the input scope, false
	 *         otherwise
	 * @throws OWLReasonerException
	 */
	protected boolean check(OWLIndividual individual, IndividualVariableScope scope)
			throws OWLReasonerException {
		OWLDescription description = scope.getDescription();
		return this.getReasoner().hasType(individual, description, false);
	}

	/**
	 * @return the reasoner
	 * @throws OWLReasonerException
	 */
	public OWLReasoner getReasoner() throws OWLReasonerException {
		if (!this.reasoner.isClassified()) {
			this.reasoner.classify();
		}
		return this.reasoner;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}
}
