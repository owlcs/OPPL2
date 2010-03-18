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

import java.io.StringWriter;
import java.net.URI;
import java.util.List;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.SimpleVariableShortFormProvider;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

import uk.ac.manchester.cs.owl.mansyntaxrenderer.ManchesterOWLSyntaxObjectRenderer;

/**
 * @author Luigi Iannone
 * 
 *         Jun 16, 2008
 */
public class PatternModelFactory implements AbstractPatternModelFactory {
	private OWLOntologyManager ontologyManager;
	private OWLOntology ontology;
	private OPPLParser opplParser;

	/**
	 * @param ontologyManager
	 */
	public PatternModelFactory(OWLOntology ontology,
			OWLOntologyManager ontologyManager, OWLReasoner reasoner,
			String script) {
		this.ontologyManager = ontologyManager;
		this.ontology = ontology;
		this.initOPPLParser(script, reasoner);
	}

	public PatternModelFactory(OWLOntology ontology,
			OWLOntologyManager ontologyManager) {
		this(ontology, ontologyManager, null, ";");
	}

	public PatternModel createPatternModel(OPPLScript opplScript)
			throws UnsuitableOPPLScriptException {
		if (opplScript.getActions().isEmpty()) {
			throw new UnsuitableOPPLScriptException(opplScript);
		} else {
			return new PatternModel(opplScript, this.ontologyManager, this);
		}
	}

	public InstantiatedPatternModel createInstantiatedPatternModel(
			PatternModel patternModel) {
		return new InstantiatedPatternModel(patternModel);
	}

	public PatternExtractor getPatternExtractor() {
		return new PatternExtractor(this.ontology, this.ontologyManager);
	}

	public PatternExtractor getPatternExtractor(
			Set<OWLConstantAnnotation> visitedAnnotations) {
		return new PatternExtractor(this.ontology, this.ontologyManager,
				visitedAnnotations);
	}

	public PatternConstraintSystem createConstraintSystem() {
		return new PatternConstraintSystem(new ConstraintSystem(this.ontology,
				this.ontologyManager), this.ontologyManager, this);
	}

	public void initOPPLParser(String string, OWLReasoner resoner) {
		this.opplParser = org.coode.oppl.utils.ParserFactory.initParser(string,
				this.ontology, this.ontologyManager, resoner, PatternModel
						.getScriptValidator());
	}

	public ManchesterOWLSyntaxObjectRenderer getRenderer(
			PatternConstraintSystem constraintSystem, StringWriter writer) {
		ManchesterOWLSyntaxObjectRenderer renderer = new ManchesterOWLSyntaxObjectRenderer(
				writer);
		renderer.setShortFormProvider(new SimpleVariableShortFormProvider(
				constraintSystem));
		return renderer;
	}

	/**
	 * @see org.coode.patterns.AbstractPatternModelFactory#createPatternModel(java.lang.String,
	 *      java.util.List, java.util.List,
	 *      org.coode.oppl.variablemansyntax.Variable, java.lang.String,
	 *      org.coode.oppl.variablemansyntax.ConstraintSystem)
	 */
	public PatternModel createPatternModel(String name,
			List<Variable> variables, List<OWLAxiomChange> actions,
			Variable returnClause, String rendering,
			ConstraintSystem constraintSystem)
			throws EmptyVariableListException, EmptyActionListException {
		if (variables.isEmpty()) {
			throw new EmptyVariableListException();
		} else if (actions.isEmpty()) {
			throw new EmptyActionListException();
		} else {
			OPPLScript opplScript = this.opplParser
					.getOPPLFactory()
					.buildOPPLScript(constraintSystem, variables, null, actions);
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

	public OPPLParser getOPPLParser() {
		return this.opplParser;
	}

	public void setOPPLParser(OPPLParser parser) {
		this.opplParser = parser;
	}
}
