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

import java.util.List;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLConstantAnnotation;

/**
 * @author Luigi Iannone
 * 
 *         Jun 16, 2008
 */
public interface AbstractPatternModelFactory {
	/**
	 * 
	 * Creates a PatternModel using the input (name, variables, actions, return
	 * value, rendering, and constraint system) returnClause can be
	 * <code>null</code> variables and actions must be non empty Lists
	 * 
	 * @param name
	 * @param variables
	 * @param actions
	 * @param returnClause
	 * @param rendering
	 * @param constraintSystem
	 * @return a PatternModel
	 * @throws UnsuitableOPPLScriptException
	 */
	PatternModel createPatternModel(String name, List<Variable> variables,
			List<OWLAxiomChange> actions, Variable returnClause,
			String rendering, ConstraintSystem constraintSystem)
			throws EmptyVariableListException, EmptyActionListException,
			UnsuitableOPPLScriptException;

	/**
	 * Builds a PatternModel instance starting from the input opplScript
	 * 
	 * @param opplScript
	 * @return a PatternModel
	 * @throws UnsuitableOPPLScriptException
	 *             when the input OPPLScript is not suitable for creating a
	 *             pattern model out of it
	 */
	PatternModel createPatternModel(OPPLScript opplScript)
			throws UnsuitableOPPLScriptException;

	/**
	 * @param patternModel
	 * @return a InstantiatedPatternModel instance created from the input
	 *         patternModel
	 */
	InstantiatedPatternModel createInstantiatedPatternModel(
			PatternModel patternModel);

	/**
	 * @return a PatternVisitor that extracts patterns from annotations
	 */
	PatternExtractor getPatternExtractor();

	/**
	 * @param visitedAnnotations
	 * @return a PatternVisitor that extracts patterns from annotations
	 *         excluding the input visited ones
	 */
	PatternExtractor getPatternExtractor(
			Set<OWLConstantAnnotation> visitedAnnotations);

	/**
	 * @return a fresh instance of a PatternConstraintSystem
	 */
	PatternConstraintSystem createConstraintSystem();

	/**
	 * Initialises the OPPL Parser with the input String using the input
	 * PatternConstraintSystem
	 * 
	 * @param string
	 * @param constraintSystem
	 */
	void initOPPLParser(String string, OWLReasoner reasoner);

	OPPLParser getOPPLParser();

	void setOPPLParser(OPPLParser parser);

	ManchesterSyntaxRenderer getRenderer(
			PatternConstraintSystem patternConstraintSystem);
}
