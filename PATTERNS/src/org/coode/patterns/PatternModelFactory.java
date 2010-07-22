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
package org.coode.patterns;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.entity.OWLEntityRendererImpl;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.rendering.VariableOWLEntityRenderer;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 *         Jun 16, 2008
 */
public class PatternModelFactory implements AbstractPatternModelFactory {
	private OWLOntologyManager ontologyManager;
	private OWLOntology ontology;
	private final OWLReasoner reasoner;

	/**
	 * @param ontologyManager
	 */
	public PatternModelFactory(OWLOntology ontology, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner) {
		this.ontologyManager = ontologyManager;
		this.ontology = ontology;
		this.reasoner = reasoner;
	}

	public PatternModelFactory(OWLOntology ontology, OWLOntologyManager ontologyManager) {
		this(ontology, ontologyManager, null);
	}

	public PatternModel createPatternModel(OPPLScript opplScript)
			throws UnsuitableOPPLScriptException {
		if (opplScript.getActions().isEmpty()) {
			throw new UnsuitableOPPLScriptException(opplScript);
		} else {
			return new PatternModel(opplScript, this.ontologyManager, this);
		}
	}

	public InstantiatedPatternModel createInstantiatedPatternModel(PatternModel patternModel) {
		return new InstantiatedPatternModel(patternModel);
	}

	public PatternExtractor getPatternExtractor(ErrorListener errorListener) {
		return new PatternExtractor(this.ontology, this.ontologyManager, errorListener);
	}

	public PatternExtractor getPatternExtractor(Set<OWLConstantAnnotation> visitedAnnotations,
			ErrorListener errorListener) {
		return new PatternExtractor(this.ontology, this.ontologyManager, errorListener,
				visitedAnnotations);
	}

	public PatternConstraintSystem createConstraintSystem() {
		return new PatternConstraintSystem(new ConstraintSystem(this.ontology,
				this.ontologyManager, this.getOPPLFactory()), this.ontologyManager, this);
	}

	/**
	 * @see org.coode.patterns.AbstractPatternModelFactory#createPatternModel(java.lang.String,
	 *      java.util.List, java.util.List,
	 *      org.coode.oppl.Variable, java.lang.String,
	 *      org.coode.oppl.ConstraintSystem)
	 */
	public PatternModel createPatternModel(String name, List<Variable> variables,
			List<OWLAxiomChange> actions, Variable returnClause, String rendering,
			ConstraintSystem constraintSystem) throws EmptyVariableListException,
			EmptyActionListException {
		if (variables.isEmpty()) {
			throw new EmptyVariableListException();
		} else if (actions.isEmpty()) {
			throw new EmptyActionListException();
		} else {
			OPPLScript opplScript = this.getOPPLFactory().buildOPPLScript(
					constraintSystem,
					variables,
					null,
					actions);
			try {
				PatternModel patternModel = this.createPatternModel(opplScript);
				patternModel.setRendering(rendering);
				patternModel.setUri(URI.create(PatternModel.NAMESPACE + name));
				return patternModel;
			} catch (UnsuitableOPPLScriptException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	public ManchesterSyntaxRenderer getRenderer(PatternConstraintSystem patternConstraintSystem) {
		return new ManchesterSyntaxRenderer(this.ontologyManager,
				this.getOWLEntityRenderer(patternConstraintSystem), patternConstraintSystem);
	}

	public OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs) {
		OWLEntityRendererImpl defaultRenderer = new OWLEntityRendererImpl();
		return new VariableOWLEntityRenderer(cs, defaultRenderer);
	}

	public OPPLAbstractFactory getOPPLFactory() {
		ParserFactory parserFactory = new ParserFactory(this.ontologyManager, this.ontology,
				this.getReasoner());
		return parserFactory.getOPPLFactory();
	}

	/**
	 * @return the reasoner
	 */
	public OWLReasoner getReasoner() {
		return this.reasoner;
	}
}
