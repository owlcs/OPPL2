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

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLQueryImpl;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptImpl;
import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.rendering.VariableOWLEntityRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.ProtegeScopeVariableChecker;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableScopeChecker;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public final class ProtegeOPPLFactory implements OPPLAbstractFactory {
	/**
	 * Adapter between {@code org.coode.oppl.entity.OWLEntityRenderer} and
	 * {@code org.protege.editor.owl.ui.renderer.OWLEntityRenderer}
	 * 
	 * @author Luigi Iannone
	 * 
	 */
	private final class ProtegeOWLEntityRenderer implements OWLEntityRenderer {
		public ProtegeOWLEntityRenderer() {
		}

		public String render(OWLEntity entity) {
			return ProtegeOPPLFactory.this.modelManager.getRendering(entity);
		}
	}

	protected OWLModelManager modelManager;
	private ProtegeScopeVariableChecker variableScopeVariableChecker = null;
	private final ProtegeOWLEntityFactory entityFactory;
	private final ProtegeOWLEntityRenderer entityRenderer;
	private OWLEntityChecker entityChecker;

	/**
	 * @param modelManager
	 * @param constraintSystem
	 * @param dataFactory
	 */
	public ProtegeOPPLFactory(OWLModelManager modelManager) {
		if (modelManager == null) {
			throw new NullPointerException("The model manager cannot be null");
		}
		this.modelManager = modelManager;
		this.entityFactory = new ProtegeOWLEntityFactory(this);
		this.entityRenderer = new ProtegeOWLEntityRenderer();
		this.entityChecker = new RenderingOWLEntityChecker(this.modelManager);
	}

	/**
	 * @see org.coode.oppl.OPPLAbstractFactory#getOWLEntityChecker()
	 */
	public OWLEntityChecker getOWLEntityChecker() {
		return this.entityChecker;
	}

	public void setOWLEntityChecker(OWLEntityChecker c) {
		this.entityChecker = c;
	}

	/**
	 * @see org.coode.oppl.OPPLAbstractFactory#getVariableScopeChecker()
	 */
	public VariableScopeChecker getVariableScopeChecker() throws OPPLException {
		if (this.variableScopeVariableChecker == null) {
			this.variableScopeVariableChecker = new ProtegeScopeVariableChecker(this.modelManager);
		}
		return this.variableScopeVariableChecker;
	}

	/**
	 * @see org.coode.oppl.OPPLAbstractFactory#getOWLEntityRenderer()
	 */
	public org.coode.oppl.entity.OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs) {
		ArgCheck.checkNullArgument("The constraint system", cs);
		return new VariableOWLEntityRenderer(cs, this.entityRenderer);
	}

	/**
	 * @see org.coode.oppl.OPPLAbstractFactory#getOWLEntityFactory()
	 */
	public OWLEntityFactory getOWLEntityFactory() {
		return this.entityFactory;
	}

	public OPPLScript buildOPPLScript(ConstraintSystem constraintSystem1, List<Variable> variables,
			OPPLQuery opplQuery, List<OWLAxiomChange> actions) {
		ProtegeOPPLScript toReturn = new ProtegeOPPLScript(new OPPLScriptImpl(constraintSystem1,
				variables, opplQuery, actions, this), this.modelManager);
		return toReturn;
	}

	public OPPLQuery buildNewQuery(ConstraintSystem constraintSystem1) {
		OPPLQuery opplQuery = new OPPLQueryImpl(constraintSystem1, this);
		return new ProtegeOPPLQuery(opplQuery, this.modelManager);
	}

	public ConstraintSystem createConstraintSystem() {
		return new ConstraintSystem(this.modelManager.getActiveOntology(),
				this.modelManager.getOWLOntologyManager(), this.modelManager.getReasoner(), this);
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.createConstraintSystem();
	}

	/**
	 * @return the OWLDataFactory exposed by this ProtegeOPPLFactory's internal
	 *         OWLModelManager instance
	 * @see org.coode.oppl.OPPLAbstractFactory#getOWLDataFactory()
	 */
	public OWLDataFactory getOWLDataFactory() {
		return this.modelManager.getOWLDataFactory();
	}

	/**
	 * @see org.coode.oppl.OPPLAbstractFactory#getManchesterSyntaxRenderer()
	 */
	public ManchesterSyntaxRenderer getManchesterSyntaxRenderer(ConstraintSystem cs) {
		ArgCheck.checkNullArgument("The constraint system", cs);
		return new ManchesterSyntaxRenderer(this.modelManager.getOWLOntologyManager(),
				this.getOWLEntityRenderer(cs), cs);
	}

	public OWLOntologyManager getOntologyManager() {
		return this.modelManager.getOWLOntologyManager();
	}
}
