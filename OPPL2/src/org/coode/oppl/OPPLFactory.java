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

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.entity.OWLEntityRendererImpl;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.rendering.VariableOWLEntityRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.ShortFormEntityChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLFactory implements OPPLAbstractFactory {
	private final OWLOntologyManager ontologyManager;
	private VariableScopeChecker variableScopeChecker = null;
	private final OWLReasoner reasoner;
	private final OWLOntology ontology;
	private OWLEntityChecker entityChecker = null;
	public static final IRI DEFAULT_ONTOLOGY_IRI = IRI
			.create("http://www.coode.org/oppl");

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
				actions, this);
	}

	public OPPLQuery buildNewQuery(ConstraintSystem constraintSystem1) {
		return new OPPLQueryImpl(constraintSystem1, this);
	}

	public ConstraintSystem createConstraintSystem() {
		return this.reasoner == null ? new ConstraintSystem(this.ontology,
				this.ontologyManager, this) : new ConstraintSystem(
				this.ontology, this.ontologyManager, this.reasoner, this);
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
		return new ManchesterSyntaxRenderer(new SimpleShortFormProvider());
	}

	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	public OPPLScript importOPPLScript(OPPLScript opplScript) {
		ConstraintSystem newConstraintSystem = this.createConstraintSystem();
		for (Variable variable : opplScript.getConstraintSystem()
				.getVariables()) {
			newConstraintSystem.importVariable(variable);
		}
		return new OPPLScriptImpl(newConstraintSystem, opplScript
				.getVariables(), opplScript.getQuery(),
				opplScript.getActions(), this, true);
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	public IRI getDefaultOntologyIRI() {
		return DEFAULT_ONTOLOGY_IRI;
	}
}
