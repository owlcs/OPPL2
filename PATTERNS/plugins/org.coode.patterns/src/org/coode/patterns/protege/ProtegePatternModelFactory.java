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

import java.io.StringWriter;
import java.net.URI;
import java.util.List;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.protege.ProtegeSimpleVariableShortFormProvider;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.utils.ProtegeParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.EmptyActionListException;
import org.coode.patterns.EmptyVariableListException;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.UnsuitableOPPLScriptException;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLConstantAnnotation;

import uk.ac.manchester.cs.owl.mansyntaxrenderer.ManchesterOWLSyntaxObjectRenderer;

/**
 * @author Luigi Iannone
 * 
 *         Jun 16, 2008
 */
public class ProtegePatternModelFactory implements AbstractPatternModelFactory {
	private final OWLModelManager modelManager;
	private OPPLParser parser;

	public OPPLParser getOPPLParser() {
		return this.parser;
	}

	public void setOPPLParser(OPPLParser parser) {
		this.parser = parser;
	}

	/**
	 * @param modelManager
	 */
	public ProtegePatternModelFactory(OWLModelManager modelManager,
			String script) {
		if (modelManager == null) {
			throw new NullPointerException("The model manager cannot be null");
		}
		this.modelManager = modelManager;
		this.initOPPLParser(script, modelManager.getReasoner());
	}

	public ProtegePatternModelFactory(OWLModelManager modelManager) {
		this(modelManager, ";");
	}

	public PatternModel createPatternModel(OPPLScript opplScript)
			throws UnsuitableOPPLScriptException {
		if (opplScript.getActions().isEmpty()) {
			throw new UnsuitableOPPLScriptException(opplScript);
		} else {
			return new ProtegePatternModel(opplScript, this.modelManager, this);
		}
	}

	public InstantiatedPatternModel createInstantiatedPatternModel(
			PatternModel patternModel) {
		ProtegeInstantiatedPatternModel protegeInstantiatedPatternModel = new ProtegeInstantiatedPatternModel(
				patternModel);
		protegeInstantiatedPatternModel.modelManager = this.modelManager;
		return protegeInstantiatedPatternModel;
	}

	public PatternExtractor getPatternExtractor() {
		return new ProtegePatternExtractor(this.modelManager);
	}

	public PatternExtractor getPatternExtractor(
			Set<OWLConstantAnnotation> visitedAnnotations) {
		return new ProtegePatternExtractor(this.modelManager,
				visitedAnnotations);
	}

	public PatternConstraintSystem createConstraintSystem() {
		return new PatternConstraintSystem(this.modelManager
				.getActiveOntology(),
				this.modelManager.getOWLOntologyManager(), this.modelManager
						.getReasoner(), this);
	}

	public void initOPPLParser(String string, OWLReasoner reasoner) {
		this.parser = ProtegeParserFactory.initParser(string,
				this.modelManager, PatternModel.getScriptValidator());
	}

	public ManchesterOWLSyntaxObjectRenderer getRenderer(
			PatternConstraintSystem constraintSystem, StringWriter writer) {
		ManchesterOWLSyntaxObjectRenderer renderer = new ManchesterOWLSyntaxObjectRenderer(
				writer);
		renderer
				.setShortFormProvider(new ProtegeSimpleVariableShortFormProvider(
						this.modelManager, constraintSystem));
		return renderer;
	}

	public PatternModel createPatternModel(String name,
			List<Variable> variables, List<OWLAxiomChange> actions,
			Variable returnClause, String rendering,
			ConstraintSystem constraintSystem)
			throws EmptyVariableListException, EmptyActionListException,
			UnsuitableOPPLScriptException {
		if (variables.isEmpty()) {
			throw new EmptyVariableListException();
		} else if (actions.isEmpty()) {
			throw new EmptyActionListException();
		} else {
			OPPLScript opplScript = this.parser
					.getOPPLFactory()
					.buildOPPLScript(constraintSystem, variables, null, actions);
			PatternModel patternModel = this.createPatternModel(opplScript);
			patternModel.setRendering(rendering);
			patternModel.setUri(URI.create(PatternModel.NAMESPACE + name));
			return patternModel;
		}
	}
}
