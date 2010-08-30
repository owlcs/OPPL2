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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 *         Jun 19, 2008
 */
public class PatternConstraintSystem extends ConstraintSystem {
	public static final String THIS_CLASS_VARIABLE_NAME = "?_thisClass";
	public static final String THIS_CLASS_VARIABLE_CONSTANT_SYMBOL = "$thisClass";
	private Map<String, SingleValueGeneratedVariable<?>> specialVariables = new HashMap<String, SingleValueGeneratedVariable<?>>();
	private final ConstraintSystem constraintSystem;
	private Map<String, String> specialVariableRenderings = new HashMap<String, String>();
	private final AbstractPatternModelFactory factory;

	public PatternConstraintSystem(ConstraintSystem cs, OWLOntologyManager ontologyManager,
			AbstractPatternModelFactory f) {
		super(cs.getOntology(), ontologyManager, f.getOPPLFactory());
		try {
			this.setReasoner(cs.getReasoner());
		} catch (OWLReasonerException e) {
			e.printStackTrace();
		}
		this.constraintSystem = cs;
		this.factory = f;
		this.init();
	}

	// public PatternConstraintSystem(OWLOntology ontology,
	// OWLOntologyManager ontologyManager) {
	// this(new ConstraintSystem(ontology, ontologyManager), ontologyManager);
	// }
	/**
	 * @param ontologyManager
	 * @param reasoner
	 */
	public PatternConstraintSystem(OWLOntology ontology, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner, AbstractPatternModelFactory f) {
		this(new ConstraintSystem(ontology, ontologyManager, reasoner, f.getOPPLFactory()),
				ontologyManager, f);
	}

	@Override
	public Variable createVariable(String name, VariableType type) throws OPPLException {
		return this.constraintSystem.createVariable(name, type);
	}

	private void init() {
		PatternConstant<OWLClass> patternConstant = new PatternConstant<OWLClass>(
				THIS_CLASS_VARIABLE_NAME, VariableType.CLASS,
				this.constraintSystem.getOntologyManager().getOWLDataFactory());
		this.createSpecialVariable(
				patternConstant.getName(),
				THIS_CLASS_VARIABLE_CONSTANT_SYMBOL,
				patternConstant);
	}

	public Variable getThisClassVariable() {
		return this.specialVariables.get(PatternConstraintSystem.THIS_CLASS_VARIABLE_NAME);
	}

	@Override
	public Variable getVariable(String name) {
		Variable variable = this.constraintSystem.getVariable(name);
		if (variable == null) {
			Iterator<String> it = this.specialVariables.keySet().iterator();
			boolean found = false;
			SingleValueGeneratedVariable<?> specialVariable = null;
			while (!found && it.hasNext()) {
				String referenceName = it.next();
				specialVariable = this.specialVariables.get(referenceName);
				found = referenceName.equals(name)
						|| this.specialVariableRenderings.get(specialVariable.getName()) != null
						&& this.specialVariableRenderings.get(specialVariable.getName()).equals(
								name);
			}
			if (found) {
				variable = specialVariable;
			}
		}
		return variable;
	}

	@Override
	public Variable getVariable(URI uri) {
		Variable variable = this.constraintSystem.getVariable(uri);
		if (variable == null) {
			variable = this.getSpecialVariable(uri);
		}
		return variable;
	}

	private Variable getSpecialVariable(URI uri) {
		boolean found = false;
		Iterator<? extends Variable> it = this.specialVariables.values().iterator();
		Variable variable = null;
		while (!found && it.hasNext()) {
			variable = it.next();
			found = uri.equals(variable.getURI());
		}
		return found ? variable : null;
	}

	@Override
	public boolean isVariableURI(URI uri) {
		boolean found = this.constraintSystem.isVariableURI(uri);
		if (!found) {
			Iterator<? extends Variable> it = this.specialVariables.values().iterator();
			while (!found && it.hasNext()) {
				Variable variable = it.next();
				found = uri.equals(variable.getURI());
			}
		}
		return found;
	}

	public String resolvePatternConstants(String s) {
		String toReturn = s;
		for (String specialVariableName : this.specialVariables.keySet()) {
			SingleValueGeneratedVariable<?> variable = this.specialVariables.get(specialVariableName);
			if (variable != null) {
				toReturn = toReturn.replaceAll("\\" + specialVariableName, variable.getName());
			}
		}
		return toReturn;
	}

	public boolean isThisClassVariable(Variable variable) {
		return variable.equals(this.specialVariables.get(PatternConstraintSystem.THIS_CLASS_VARIABLE_NAME));
	}

	@Override
	public Set<Variable> getVariables() {
		Set<Variable> toReturn = this.constraintSystem.getVariables();
		toReturn.addAll(this.specialVariables.values());
		return toReturn;
	}

	public String resolvePattern(String patternName, OWLOntologyManager ontologyManager,
			Set<String> visitedPatterns, List<PatternOPPLScript> dependencies,
			ErrorListener errorListener, List<String>... args) throws PatternException {
		Set<String> visited = new HashSet<String>(visitedPatterns);
		PatternReference patternReference = new PatternReference(patternName, this,
				ontologyManager, visited, errorListener, args);
		dependencies.add(patternReference.getExtractedPattern());
		VariableType variableType = VariableType.getVariableType(patternReference.getResolution().get(
				0));
		PatternReferenceGeneratedVariable patternReferenceGeneratedVariable = new PatternReferenceGeneratedVariable(
				variableType,
				PatternReferenceGeneratedVariable.getPatternReferenceGeneratedValue(patternReference));
		this.createSpecialVariable(
				patternReferenceGeneratedVariable.getName(),
				patternReference.toString(),
				patternReferenceGeneratedVariable);
		List<Variable> referenceVariables = patternReference.getExtractedPattern().getVariables();
		for (Variable variable : referenceVariables) {
			if (variable instanceof SingleValueGeneratedVariable<?>) {
				this.importVariable(variable);
			}
		}
		return patternReferenceGeneratedVariable.getName();
	}

	public InstantiatedPatternModel resolvePatternInstantiation(String patternName,
			OWLOntologyManager ontologyManager, Set<String> visitedPatterns,
			List<PatternOPPLScript> dependencies, ErrorListener errorListener, List<String>... args)
			throws PatternException {
		PatternReference patternReference = new PatternReference(patternName, this,
				ontologyManager, visitedPatterns, errorListener, args);
		dependencies.add(patternReference.getExtractedPattern());
		return patternReference.getInstantiation();
	}

	public void instantiateThisClass(PatternConstant<OWLClass> patternConstant) {
		this.createSpecialVariable(
				patternConstant.getName(),
				THIS_CLASS_VARIABLE_CONSTANT_SYMBOL,
				patternConstant);
	}

	@Override
	public SingleValueGeneratedVariable<String> createStringGeneratedVariable(String name,
			VariableType type, SingleValueGeneratedValue<String> value) {
		return this.constraintSystem.createStringGeneratedVariable(name, type, value);
	}

	@Override
	public void removeVariable(Variable variable) {
		this.constraintSystem.removeVariable(variable);
	}

	@Override
	public SingleValueGeneratedVariable<Collection<OWLClass>> createIntersectionGeneratedVariable(
			String name, VariableType type, AbstractCollectionGeneratedValue<OWLClass> collection) {
		return this.constraintSystem.createIntersectionGeneratedVariable(name, type, collection);
	}

	@Override
	public SingleValueGeneratedVariable<Collection<OWLClass>> createUnionGeneratedVariable(
			String name, VariableType type, AbstractCollectionGeneratedValue<OWLClass> collection) {
		return this.constraintSystem.createUnionGeneratedVariable(name, type, collection);
	}

	@Override
	public Set<Variable> getInputVariables() {
		return this.constraintSystem.getInputVariables();
	}

	@Override
	public String render(Variable variable) {
		SingleValueGeneratedVariable<?> specialVariable = this.specialVariables.get(variable.getName());
		boolean specialRenderingPresent = specialVariable != null
				&& this.specialVariableRenderings.get(specialVariable.getName()) != null;
		String rendering = specialRenderingPresent ? this.specialVariableRenderings.get(specialVariable.getName())
				: super.render(variable);
		return rendering;
	}

	private void createSpecialVariable(String name, String renderedName,
			SingleValueGeneratedVariable<?> variable) {
		this.specialVariables.put(name, variable);
		this.specialVariableRenderings.put(name, renderedName);
	}

	@Override
	public void importVariable(Variable v) {
		this.constraintSystem.importVariable(v);
	}

	@Override
	public void clearVariables() {
		this.constraintSystem.clearVariables();
		this.init();
	}

	public AbstractPatternModelFactory getPatternModelFactory() {
		return this.factory;
	}
}
