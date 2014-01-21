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
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** Visitor that checks whether a value is within the scope of the visited
 * VariableScope or not
 * 
 * @author Luigi Iannone */
public class VariableScopeChecker {
    private final OWLOntologyManager ontologyManager;
    private final OWLReasoner reasoner;

    /** @param ontologyManager
     *            ontologyManager
     * @param reasoner
     *            reasoner
     * @throws OPPLException
     *             OPPLException */
    public VariableScopeChecker(OWLOntologyManager ontologyManager, OWLReasoner reasoner)
            throws OPPLException {
        if (reasoner == null) {
            throw new NullReasonerException();
        } else {
            this.ontologyManager = ontologyManager;
            this.reasoner = reasoner;
        }
    }

    /** @param owlCass
     *            owlCass
     * @param scope
     *            scope
     * @return true is the input owlClass is in the input scope, false otherwise
     * @throws OWLRuntimeException
     *             OWLRuntimeException */
    protected boolean check(OWLClass owlCass, SubClassVariableScope scope) {
        OWLClassExpression description = scope.getClassExpression();
        OWLSubClassOfAxiom axiom = getOntologyManager().getOWLDataFactory()
                .getOWLSubClassOfAxiom(owlCass, description);
        return getReasoner().isEntailed(axiom);
    }

    /** @param owlCass
     *            owlCass
     * @param scope
     *            scope
     * @return true is the input owlClass is in the input scope, false otherwise
     * @throws OWLRuntimeException
     *             OWLRuntimeException */
    protected boolean check(OWLClass owlCass, SuperClassVariableScope scope)
            throws OWLRuntimeException {
        OWLClassExpression description = scope.getClassExpression();
        OWLSubClassOfAxiom axiom = getOntologyManager().getOWLDataFactory()
                .getOWLSubClassOfAxiom(description, owlCass);
        return getReasoner().isEntailed(axiom);
    }

    /** @param individual
     *            individual
     * @param scope
     *            scope
     * @return true is the input individual is in the input scope, false
     *         otherwise
     * @throws OWLRuntimeException
     *             OWLRuntimeException */
    protected boolean check(OWLIndividual individual, IndividualVariableScope scope)
            throws OWLRuntimeException {
        OWLClassExpression description = scope.getClassExpression();
        OWLClassAssertionAxiom axiom = getOntologyManager().getOWLDataFactory()
                .getOWLClassAssertionAxiom(description, individual);
        return getReasoner().isEntailed(axiom);
    }

    /** @return the reasoner
     * @throws OWLRuntimeException
     *             OWLRuntimeException */
    public OWLReasoner getReasoner() {
        return reasoner;
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }
}
