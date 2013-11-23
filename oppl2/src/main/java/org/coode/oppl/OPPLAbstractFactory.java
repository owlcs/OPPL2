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

import java.util.List;

import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.exceptions.NullReasonerException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone */
public interface OPPLAbstractFactory {
    OWLOntology getOntology();

    /** @return the OWLEntityChecker used by the factory */
    OWLEntityChecker getOWLEntityChecker();

    /** @return the VariableScopeChecker used by the factory
     * @throws NullReasonerException
     *             if no reasoner is available for checking the scope */
    VariableScopeChecker getVariableScopeChecker() throws OPPLException;

    /** @param cs
     *            the ConstraintSystem containing the variables. Cannot be
     *            {@code null}.
     * @return the OWLEntityRenderer instance used by this factory
     * @throws NullPointerException
     *             when the input is {@code null}. */
    OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs);

    /** @return the OWLEntityFactory used by this factory */
    OWLEntityFactory getOWLEntityFactory();

    /** @param constraintSystem
     * @param variables
     * @param opplQuery
     * @param actions
     * @return an instance of OPPLScript on the input ConstraintSystem with the
     *         input Variable instances the input OPPLQuery and the input set of
     *         actions */
    OPPLScript
            buildOPPLScript(ConstraintSystem constraintSystem,
                    List<Variable<?>> variables, OPPLQuery opplQuery,
                    List<OWLAxiomChange> actions);

    /** @return a new blank OPPLQuery instance */
    OPPLQuery buildNewQuery(ConstraintSystem constraintSystem);

    /** Creates a fresh instance of ConstraintSystem
     * 
     * @return the created ConstraintSystem */
    ConstraintSystem createConstraintSystem();

    /** @param cs
     *            the ConstraintSystem containing all the variable that can be
     *            rendered. Cannot be {@code null}.
     * @return the Manchester OWL Syntax renderer for this factory.
     * @throws NullPointerException
     *             when the input is {@code null}. */
    ManchesterSyntaxRenderer getManchesterSyntaxRenderer(ConstraintSystem cs);

    /** @return the appropriate OWLDataFactory used by this OPPLAbstractFactory */
    OWLDataFactory getOWLDataFactory();

    /** @return the OWLOntologyManager used by this OPPLAbstractFactory. */
    OWLOntologyManager getOntologyManager();

    /** Builds an OPPLScript whose content is identical to the input one. Its
     * factory and reasoner will be set by this factory.
     * 
     * @param opplScript
     *            . The starting OPPL Script whose content will be copied.
     *            Cannot be {@code null}.
     * @return an OPPLScript.
     * @throws NullPointerException
     *             when the input is {@code null}. */
    OPPLScript importOPPLScript(OPPLScript opplScript);

    /** Retrieves a default IRI which will serve the purpose of an Ontology IRI
     * when the one returned by {@code this.getOntology()} is {@code null}.
     * 
     * @return default ontology iri */
    IRI getDefaultOntologyIRI();
}
