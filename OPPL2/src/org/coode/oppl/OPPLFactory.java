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

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.entity.OWLEntityRendererImpl;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.rendering.VariableOWLEntityRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableScopeChecker;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owl.util.SimpleShortFormProvider;

import uk.ac.manchester.cs.owl.mansyntaxrenderer.ManchesterOWLSyntaxObjectRenderer;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLFactory implements OPPLAbstractFactory {
	private final OWLOntologyManager ontologyManager;
	private ConstraintSystem constraintSystem;
	private VariableScopeChecker variableScopeChecker = null;
	private final OWLReasoner reasoner;
	private final OWLOntology ontology;
	private OWLEntityChecker entityChecker = null;

	/**
	 * @param ontologyManager
	 * @param constraintSystem
	 * @param dataFactory
	 */
	public OPPLFactory(OWLOntologyManager ontologyManager,
			OWLOntology ontology, OWLReasoner reasoner) {
		this.ontologyManager = ontologyManager;
		this.ontology = ontology;
		this.reasoner = reasoner;
		this.entityChecker = this.defaultEntityChecker();
	}

	private OWLEntityChecker defaultEntityChecker() {
		BidirectionalShortFormProviderAdapter bshp = new BidirectionalShortFormProviderAdapter(
				this.ontologyManager.getOntologies(),
				new SimpleShortFormProvider());
		// XXX fix for missing Thing
		bshp.add(this.ontologyManager.getOWLDataFactory().getOWLThing());
		bshp.add(this.ontologyManager.getOWLDataFactory().getOWLNothing());
		return new ShortFormEntityChecker(bshp);
	}

	/**
	 * 
	 * @see org.coode.oppl.OPPLAbstractFactory#getOWLEntityChecker()
	 */
	public OWLEntityChecker getOWLEntityChecker() {
		return this.entityChecker;
	}

	public void setOWLEntityChecker(OWLEntityChecker c) {
		this.entityChecker = c;
	}

	/**
	 * @return the variableScopeChecker
	 * @throws OPPLException
	 */
	public VariableScopeChecker getVariableScopeChecker() throws OPPLException {
		if (this.variableScopeChecker == null && this.reasoner != null) {
			this.variableScopeChecker = new VariableScopeChecker(
					this.ontologyManager, this.reasoner);
		}
		return this.variableScopeChecker;
	}

	public OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs) {
		ArgCheck.checkNullArgument("The constraint system", cs);
		OWLEntityRendererImpl defaultRenderer = new OWLEntityRendererImpl();
		return new VariableOWLEntityRenderer(cs, defaultRenderer);
	}

	public org.coode.oppl.entity.OWLEntityFactory getOWLEntityFactory() {
		return new EntityFactory(this);
	}

	public OPPLScript buildOPPLScript(ConstraintSystem constraintSystem1,
			List<Variable> variables, OPPLQuery opplQuery,
			List<OWLAxiomChange> actions) {
		return new OPPLScriptImpl(constraintSystem1, variables, opplQuery,
				actions);
	}

	public OPPLQuery buildNewQuery(ConstraintSystem constraintSystem1) {
		return new OPPLQueryImpl(constraintSystem1);
	}

	public ManchesterOWLSyntaxObjectRenderer getOWLObjectRenderer(
			StringWriter writer) {
		ManchesterOWLSyntaxObjectRenderer renderer = new ManchesterOWLSyntaxObjectRenderer(
				writer);
		renderer.setShortFormProvider(new SimpleVariableShortFormProvider(this
				.getConstraintSystem()));
		return renderer;
	}

	/**
	 * @return the constraintSystem
	 */
	public final ConstraintSystem getConstraintSystem() {
		return this.constraintSystem == null ? this.createConstraintSystem()
				: this.constraintSystem;
	}

	public ConstraintSystem createConstraintSystem() {
		this.constraintSystem = this.reasoner == null ? new ConstraintSystem(
				this.ontology, this.ontologyManager) : new ConstraintSystem(
				this.ontology, this.ontologyManager, this.reasoner);
		return this.constraintSystem;
	}

	/**
	 * @return the OWLDataFactory instance used by the internal
	 *         OWLOntologyManager instance
	 * @see org.coode.oppl.OPPLAbstractFactory#getOWLDataFactory()
	 */
	public OWLDataFactory getOWLDataFactory() {
		return this.ontologyManager.getOWLDataFactory();
	}

	public ManchesterSyntaxRenderer getManchesterSyntaxRenderer(
			ConstraintSystem cs) {
		ArgCheck.checkNullArgument("The constraint system", cs);
		return new ManchesterSyntaxRenderer(this.ontologyManager, this
				.getOWLEntityRenderer(cs), cs);
	}

	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}
}
