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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.VariableFactory;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 *         Jun 19, 2008
 */
public class PatternConstraintSystem extends ConstraintSystem {
	public static final String THIS_CLASS_VARIABLE_CONSTANT_SYMBOL = "$thisClass";
	private Map<String, GeneratedVariable<?>> specialVariables = new HashMap<String, GeneratedVariable<?>>();
	private final ConstraintSystem constraintSystem;
	private Map<String, String> specialVariableRenderings = new HashMap<String, String>();
	private final AbstractPatternModelFactory factory;

	public PatternConstraintSystem(ConstraintSystem cs,
			OWLOntologyManager ontologyManager, AbstractPatternModelFactory f) {
		super(cs.getOntology(), ontologyManager, f.getOPPLFactory());
		this.setReasoner(cs.getReasoner());
		this.constraintSystem = cs;
		this.factory = f;
	}

	/**
	 * @param ontologyManager
	 * @param reasoner
	 */
	public PatternConstraintSystem(OWLOntology ontology,
			OWLOntologyManager ontologyManager, OWLReasoner reasoner,
			AbstractPatternModelFactory f) {
		this(new ConstraintSystem(ontology, ontologyManager, reasoner,
				f.getOPPLFactory()), ontologyManager, f);
	}

	@Override
	public <O extends OWLObject> InputVariable<O> createVariable(String name,
			VariableType<O> type, VariableScope<?> variableScope)
			throws OPPLException {
		return this.constraintSystem.createVariable(name, type, variableScope);
	}

	public Variable<?> getThisClassVariable() {
		Variable<OWLClassExpression> toReturn = VariableFactory
				.getCLASSVariable(THIS_CLASS_VARIABLE_CONSTANT_SYMBOL, null);
		this.importVariable(toReturn);
		return toReturn;
	}

	@Override
	public Variable<?> getVariable(String name) {
		Variable<?> variable = this.constraintSystem.getVariable(name);
		if (variable == null) {
			Iterator<String> it = this.specialVariables.keySet().iterator();
			boolean found = false;
			GeneratedVariable<?> specialVariable = null;
			while (!found && it.hasNext()) {
				String referenceName = it.next();
				specialVariable = this.specialVariables.get(referenceName);
				found = referenceName.equals(name)
						|| this.specialVariableRenderings.get(specialVariable
								.getName()) != null
						&& this.specialVariableRenderings.get(
								specialVariable.getName()).equals(name);
			}
			if (found) {
				variable = specialVariable;
			}
		}
		return variable;
	}

	@Override
	public Variable<?> getVariable(IRI iri) {
		Variable<?> variable = this.constraintSystem.getVariable(iri);
		if (variable == null) {
			variable = this.getSpecialVariable(iri);
		}
		return variable;
	}

	private Variable<?> getSpecialVariable(IRI iri) {
		boolean found = false;
		Iterator<? extends Variable<?>> it = this.specialVariables.values()
				.iterator();
		Variable<?> variable = null;
		while (!found && it.hasNext()) {
			variable = it.next();
			found = iri.equals(variable.getIRI());
		}
		return found ? variable : null;
	}

	@Override
	public boolean isVariableIRI(IRI uri) {
		boolean found = this.constraintSystem.isVariableIRI(uri);
		if (!found) {
			Iterator<? extends Variable<?>> it = this.specialVariables.values()
					.iterator();
			while (!found && it.hasNext()) {
				Variable<?> variable = it.next();
				found = uri.equals(variable.getIRI());
			}
		}
		return found;
	}

	public String resolvePatternConstants(String s) {
		String toReturn = s;
		for (String specialVariableName : this.specialVariables.keySet()) {
			GeneratedVariable<?> variable = this.specialVariables
					.get(specialVariableName);
			if (variable != null) {
				toReturn = toReturn.replaceAll("\\" + specialVariableName,
						variable.getName());
			}
		}
		return toReturn;
	}

	public boolean isThisClassVariable(Variable<?> variable) {
		return variable
				.equals(this.specialVariables
						.get(PatternConstraintSystem.THIS_CLASS_VARIABLE_CONSTANT_SYMBOL));
	}

	@Override
	public Set<Variable<?>> getVariables() {
		Set<Variable<?>> toReturn = this.constraintSystem.getVariables();
		toReturn.addAll(this.specialVariables.values());
		return toReturn;
	}

	public String resolvePattern(String patternName,
			OWLOntologyManager ontologyManager, Set<String> visitedPatterns,
			List<PatternOPPLScript> dependencies, ErrorListener errorListener,
			List<Object>... args) throws PatternException {
		Set<String> visited = new HashSet<String>(visitedPatterns);
		PatternReference patternReference = new PatternReference(patternName,
				this, visited, errorListener, args);
		dependencies.add(patternReference.getExtractedPattern());
		VariableType<?> variableType = patternReference.getExtractedPattern()
				.getReturnVariable().getType();
		PatternReferenceGeneratedVariable<?> patternReferenceGeneratedVariable = PatternReferenceGeneratedVariable
				.getPatternReferenceGeneratedVariable(
						patternReference.toString(), variableType,
						patternReference);
		this.importVariable(patternReferenceGeneratedVariable);
		return patternReferenceGeneratedVariable.getName();
	}

	public InstantiatedPatternModel resolvePatternInstantiation(
			String patternName, OWLOntologyManager ontologyManager,
			Set<String> visitedPatterns, List<PatternOPPLScript> dependencies,
			final ErrorListener errorListener, List<String>... args)
			throws PatternException {
		RuntimeExceptionHandler handler = new RuntimeExceptionHandler() {
			public void handlePatternSyntaxExcpetion(PatternSyntaxException e) {
				errorListener.reportThrowable(e, 0, 0, 0);
			}

			public void handleOWLRuntimeException(OWLRuntimeException e) {
				errorListener.reportThrowable(e, 0, 0, 0);
			}

			public void handleException(RuntimeException e) {
				errorListener.reportThrowable(e, 0, 0, 0);
			}
		};
		PatternReference patternReference = new PatternReference(patternName,
				this, visitedPatterns, errorListener, args);
		dependencies.add(patternReference.getExtractedPattern());
		return patternReference.getInstantiation(handler);
	}

	@Override
	public <O extends OWLObject> GeneratedVariable<O> createStringGeneratedVariable(
			String name, VariableType<O> type, OPPLFunction<String> value) {
		return this.constraintSystem.createStringGeneratedVariable(name, type,
				value);
	}

	@Override
	public void removeVariable(Variable<?> variable) {
		this.constraintSystem.removeVariable(variable);
	}

	@Override
	public GeneratedVariable<OWLClassExpression> createIntersectionGeneratedVariable(
			String name,
			VariableType<?> type,
			Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> operands) {
		return this.constraintSystem.createIntersectionGeneratedVariable(name,
				type, operands);
	}

	@Override
	public GeneratedVariable<OWLClassExpression> createUnionGeneratedVariable(
			String name,
			VariableType<?> type,
			Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> operands) {
		return this.constraintSystem.createUnionGeneratedVariable(name, type,
				operands);
	}

	@Override
	public Set<InputVariable<?>> getInputVariables() {
		return this.constraintSystem.getInputVariables();
	}

	@Override
	public String render(Variable<?> variable) {
		GeneratedVariable<?> specialVariable = this.specialVariables
				.get(variable.getName());
		boolean specialRenderingPresent = specialVariable != null
				&& this.specialVariableRenderings
						.get(specialVariable.getName()) != null;
		String rendering = specialRenderingPresent ? this.specialVariableRenderings
				.get(specialVariable.getName()) : this.constraintSystem
				.render(variable);
		return rendering;
	}

	@Override
	public <O extends OWLObject> RegexpGeneratedVariable<? extends O> createRegexpGeneratedVariable(
			String name, VariableType<O> type,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		return this.constraintSystem.createRegexpGeneratedVariable(name, type,
				patternGeneratingOPPLFunction);
	}

	@Override
	public void importVariable(Variable<?> v) {
		this.constraintSystem.importVariable(v);
	}

	@Override
	public void clearVariables() {
		this.constraintSystem.clearVariables();
	}

	public AbstractPatternModelFactory getPatternModelFactory() {
		return this.factory;
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#getAxiomVariables(org.semanticweb.owlapi.model.OWLAxiom)
	 */
	@Override
	public Set<Variable<?>> getAxiomVariables(OWLAxiom axiom) {
		return this.constraintSystem.getAxiomVariables(axiom);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isVariable(org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	@Override
	public boolean isVariable(OWLClassExpression desc) {
		return this.constraintSystem.isVariable(desc);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isVariable(org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	@Override
	public boolean isVariable(OWLAnnotationProperty property) {
		return this.constraintSystem.isVariable(property);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isVariable(org.semanticweb.owlapi.model.OWLObjectProperty)
	 */
	@Override
	public boolean isVariable(OWLObjectProperty property) {
		return this.constraintSystem.isVariable(property);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isVariable(org.semanticweb.owlapi.model.OWLDataProperty)
	 */
	@Override
	public boolean isVariable(OWLDataProperty property) {
		return this.constraintSystem.isVariable(property);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isVariable(org.semanticweb.owlapi.model.OWLNamedIndividual)
	 */
	@Override
	public boolean isVariable(OWLNamedIndividual individual) {
		return this.constraintSystem.isVariable(individual);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#addLeaf(org.coode.oppl.bindingtree.BindingNode)
	 */
	@Override
	public void addLeaf(BindingNode bindingNode) {
		this.constraintSystem.addLeaf(bindingNode);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#getVariableBindings(org.coode.oppl.Variable,
	 *      org.coode.oppl.exceptions.RuntimeExceptionHandler)
	 */
	@Override
	public Set<OWLObject> getVariableBindings(Variable<?> v,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		return this.constraintSystem.getVariableBindings(v,
				runtimeExceptionHandler);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#addLeaf(org.coode.oppl.Variable,
	 *      org.semanticweb.owlapi.model.OWLObject)
	 */
	@Override
	public boolean addLeaf(Variable<?> variable, OWLObject object) {
		return this.constraintSystem.addLeaf(variable, object);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#getLeaves()
	 */
	@Override
	public Set<BindingNode> getLeaves() {
		return this.constraintSystem.getLeaves();
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#getOPPLFactory()
	 */
	@Override
	public OPPLAbstractFactory getOPPLFactory() {
		return this.constraintSystem.getOPPLFactory();
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#removeBinding(org.coode.oppl.bindingtree.BindingNode)
	 */
	@Override
	public void removeBinding(BindingNode binding) {
		this.constraintSystem.removeBinding(binding);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isVariable(org.semanticweb.owlapi.model.OWLLiteral)
	 */
	@Override
	public boolean isVariable(OWLLiteral node) {
		return this.constraintSystem.isVariable(node);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#setLeaves(java.util.Set)
	 */
	@Override
	public void setLeaves(Set<BindingNode> newLeaves) {
		this.constraintSystem.setLeaves(newLeaves);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#getGeneratedVariables()
	 */
	@Override
	public Set<GeneratedVariable<?>> getGeneratedVariables() {
		return this.constraintSystem.getGeneratedVariables();
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#isGenerated(org.coode.oppl.Variable)
	 */
	@Override
	public boolean isGenerated(Variable<?> v) {
		return this.constraintSystem.isGenerated(v);
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#reset()
	 */
	@Override
	public void reset() {
		this.constraintSystem.reset();
	}

	/**
	 * @see org.coode.oppl.ConstraintSystem#createExpressionGeneratedVariable(java.lang.String,
	 *      org.semanticweb.owlapi.model.OWLObject)
	 */
	@Override
	public <O extends OWLObject> GeneratedVariable<O> createExpressionGeneratedVariable(
			String name, O expression) {
		return this.constraintSystem.createExpressionGeneratedVariable(name,
				expression);
	}
}