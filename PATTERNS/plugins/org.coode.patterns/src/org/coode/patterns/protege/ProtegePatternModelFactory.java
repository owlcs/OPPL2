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
package org.coode.patterns.protege;

import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.ErrorListener;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.EmptyActionListException;
import org.coode.patterns.EmptyVariableListException;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternModelFactory;
import org.coode.patterns.UnsuitableOPPLScriptException;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiomChange;

/**
 * @author Luigi Iannone
 * 
 *         Jun 16, 2008
 */
public class ProtegePatternModelFactory implements AbstractPatternModelFactory {
	private final AbstractPatternModelFactory delegate;

	/**
	 * @param modelManager
	 */
	public ProtegePatternModelFactory(OWLModelManager modelManager) {
		if (modelManager == null) {
			throw new NullPointerException("The model manager cannot be null");
		}
		this.delegate = new PatternModelFactory(modelManager.getActiveOntology(),
				modelManager.getOWLOntologyManager(), modelManager.getReasoner());
	}

	/**
	 * @param name
	 * @param variables
	 * @param actions
	 * @param returnClause
	 * @param rendering
	 * @param constraintSystem
	 * @return
	 * @throws EmptyVariableListException
	 * @throws EmptyActionListException
	 * @throws UnsuitableOPPLScriptException
	 * @see org.coode.patterns.AbstractPatternModelFactory#createPatternModel(java.lang.String,
	 *      java.util.List, java.util.List, org.coode.oppl.Variable,
	 *      java.lang.String, org.coode.oppl.ConstraintSystem)
	 */
	public PatternModel createPatternModel(String name, List<Variable> variables,
			List<OWLAxiomChange> actions, Variable returnClause, String rendering,
			ConstraintSystem constraintSystem) throws EmptyVariableListException,
			EmptyActionListException, UnsuitableOPPLScriptException {
		return this.delegate.createPatternModel(
				name,
				variables,
				actions,
				returnClause,
				rendering,
				constraintSystem);
	}

	/**
	 * @param opplScript
	 * @return
	 * @throws UnsuitableOPPLScriptException
	 * @see org.coode.patterns.AbstractPatternModelFactory#createPatternModel(org.coode.oppl.OPPLScript)
	 */
	public PatternModel createPatternModel(OPPLScript opplScript)
			throws UnsuitableOPPLScriptException {
		return this.delegate.createPatternModel(opplScript);
	}

	/**
	 * @param patternModel
	 * @return
	 * @see org.coode.patterns.AbstractPatternModelFactory#createInstantiatedPatternModel(org.coode.patterns.PatternModel)
	 */
	public InstantiatedPatternModel createInstantiatedPatternModel(PatternModel patternModel) {
		return this.delegate.createInstantiatedPatternModel(patternModel);
	}

	/**
	 * @param errorListener
	 * @return
	 * @see org.coode.patterns.AbstractPatternModelFactory#getPatternExtractor(org.coode.parsers.ErrorListener)
	 */
	public PatternExtractor getPatternExtractor(ErrorListener errorListener) {
		return this.delegate.getPatternExtractor(errorListener);
	}

	/**
	 * @param visitedAnnotations
	 * @param errorListener
	 * @return
	 * @see org.coode.patterns.AbstractPatternModelFactory#getPatternExtractor(java.util.Set,
	 *      org.coode.parsers.ErrorListener)
	 */
	public PatternExtractor getPatternExtractor(Set<OWLAnnotation> visitedAnnotations,
			ErrorListener errorListener) {
		return this.delegate.getPatternExtractor(visitedAnnotations, errorListener);
	}

	/**
	 * @return
	 * @see org.coode.patterns.AbstractPatternModelFactory#createConstraintSystem()
	 */
	public PatternConstraintSystem createConstraintSystem() {
		return this.delegate.createConstraintSystem();
	}

	/**
	 * @param patternConstraintSystem
	 * @return
	 * @see org.coode.patterns.AbstractPatternModelFactory#getRenderer(org.coode.patterns.PatternConstraintSystem)
	 */
	public ManchesterSyntaxRenderer getRenderer(PatternConstraintSystem patternConstraintSystem) {
		return this.delegate.getRenderer(patternConstraintSystem);
	}

	/**
	 * @return
	 * @see org.coode.patterns.AbstractPatternModelFactory#getOPPLFactory()
	 */
	public OPPLAbstractFactory getOPPLFactory() {
		return this.delegate.getOPPLFactory();
	}
}
