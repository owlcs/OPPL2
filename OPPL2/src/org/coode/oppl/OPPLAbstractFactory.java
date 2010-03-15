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

import java.io.StringWriter;
import java.util.List;

import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.exceptions.NullReasonerException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableScopeChecker;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLOntologyManager;

import uk.ac.manchester.cs.owl.mansyntaxrenderer.ManchesterOWLSyntaxObjectRenderer;

/**
 * @author Luigi Iannone
 * 
 */
public interface OPPLAbstractFactory {
	/**
	 * @return the OWLEntityChecker used by the factory
	 */
	OWLEntityChecker getOWLEntityChecker();

	/**
	 * sets the OWLEntityChecker used by the factory
	 * 
	 * @param c
	 *            the new OWLEntityChecker
	 */
	void setOWLEntityChecker(OWLEntityChecker c);

	/**
	 * @return the VariableScopeChecker used by the factory
	 * @throws NullReasonerException
	 *             if no reasoner is available for checking the scope
	 */
	VariableScopeChecker getVariableScopeChecker() throws OPPLException;

	/**
	 * @param cs
	 *            the ConstraintSystem containing the variables. Cannot be
	 *            {@code null}.
	 * @return the OWLEntityRenderer instance used by this factory
	 * @throws NullPointerException
	 *             when the input is {@code null}.
	 */
	OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs);

	/**
	 * @return the OWLEntityFactory used by this factory
	 */
	OWLEntityFactory getOWLEntityFactory();

	/**
	 * @param constraintSystem
	 * @param variables
	 * @param opplQuery
	 * @param actions
	 * @return an instance of OPPLScript on the input ConstraintSystem with the
	 *         input Variable instances the input OPPLQuery and the input set of
	 *         actions
	 */
	OPPLScript buildOPPLScript(ConstraintSystem constraintSystem,
			List<Variable> variables, OPPLQuery opplQuery,
			List<OWLAxiomChange> actions);

	/**
	 * @return a new blank OPPLQuery instance
	 */
	OPPLQuery buildNewQuery(ConstraintSystem constraintSystem);

	/**
	 * Creates a fresh instance of ConstraintSystem
	 * 
	 * 
	 * 
	 * @return the created ConstraintSystem
	 */
	ConstraintSystem createConstraintSystem();

	/** @return the constraint system */
	ConstraintSystem getConstraintSystem();

	@Deprecated
	public ManchesterOWLSyntaxObjectRenderer getOWLObjectRenderer(
			StringWriter writer);

	/**
	 * @param cs
	 *            the ConstraintSystem containing all the variable that can be
	 *            rendered. Cannot be {@code null}.
	 * @return the Manchester OWL Syntax renderer for this factory.
	 * @throws NullPointerException
	 *             when the input is {@code null}.
	 */
	public ManchesterSyntaxRenderer getManchesterSyntaxRenderer(
			ConstraintSystem cs);

	/**
	 * @return the appropriate OWLDataFactory used by this OPPLAbstractFactory
	 */
	public OWLDataFactory getOWLDataFactory();

	/**
	 * @return the OWLOntologyManager used by this OPPLAbstractFactory.
	 */
	public OWLOntologyManager getOntologyManager();
}
