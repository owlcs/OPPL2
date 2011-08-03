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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.InstantiatedOPPLScript;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScriptVisitor;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.LeafBrusher;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 *         Jun 11, 2008
 */
public class InstantiatedPatternModel implements InstantiatedOPPLScript, PatternOPPLScript {
	private IRI uri = null;
	private final PatternModel patternModel;
	private final RuntimeExceptionHandler runtimeExceptionHandler;

	/**
	 * Creates an InstantiatedPatternModel instance starting from the input
	 * PatternModel
	 * 
	 * @param patternModel
	 *            the Pattern on which the this instantiated pattern will be
	 *            built. Cannot be {@code null}.
	 */
	public InstantiatedPatternModel(PatternModel patternModel, RuntimeExceptionHandler handler) {
		if (patternModel == null) {
			throw new NullPointerException("The pattern cannot be null");
		}
		if (handler == null) {
			throw new NullPointerException("Theruntime exception  handler cannot be null");
		}
		this.patternModel = patternModel;
		this.runtimeExceptionHandler = handler;
	}

	private Map<Variable<?>, Set<OWLObject>> instantiations = new HashMap<Variable<?>, Set<OWLObject>>();
	private String unresolvedOPPLStatementString;

	public Set<OWLObject> getInstantiations(Variable<?> variable) {
		// defensive copy; it also guarantees that no nulls are returned
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.instantiations.containsKey(variable)) {
			toReturn.addAll(this.instantiations.get(variable));
		}
		return toReturn;
	}

	public boolean removeInstantiation(Variable<?> variable, OWLObject owlObject) {
		Set<OWLObject> variableInstantiations = this.instantiations.get(variable);
		boolean toReturn = false;
		if (variableInstantiations != null) {
			toReturn = variableInstantiations.remove(owlObject);
		}
		return toReturn;
	}

	/**
	 * Assigns the input value to the input variable, if the variable is already
	 * in the InstantiatedPatternModel. To add a Variable instance use
	 * {@link InstantiatedPatternModel#addVariable(Variable)}
	 * 
	 * @param variable
	 * @param value
	 */
	public void instantiate(Variable<?> variable, OWLObject value) {
		if (this.getPatternModel().getVariables().contains(variable)
				|| this.getPatternModel().getConstraintSystem().getThisClassVariable().equals(
						variable)
				&& this.getPatternModel().getConstraintSystem().getVariable(variable.getName()) != null) {
			Set<OWLObject> instantiation = this.getInstantiations(variable);
			if (instantiation == null) {
				instantiation = new HashSet<OWLObject>();
			}
			instantiation.add(value);
			this.instantiations.put(variable, instantiation);
		}
	}

	public boolean isValid() {
		boolean unassignedVariables = false;
		Iterator<? extends Variable<?>> it = this.getInputVariables().iterator();
		Variable<?> variable;
		while (!unassignedVariables && it.hasNext()) {
			variable = it.next();
			unassignedVariables = this.instantiations.get(variable) == null
					|| this.instantiations.get(variable).isEmpty();
		}
		return this.patternModel.isValid() && !unassignedVariables;
	}

	public String getRendering() {
		String toReturn = this.patternModel.getRendering();
		for (Variable<?> variable : this.instantiations.keySet()) {
			Set<OWLObject> instantiation = this.instantiations.get(variable);
			if (instantiation != null) {
				if (instantiation.size() == 1) {
					OWLObject singleInstantiation = instantiation.iterator().next();
					toReturn = toReturn.replaceAll(
							"\\" + variable.getName(),
							this.render(singleInstantiation));
				} else {
					String instantiationReplacement = "{";
					boolean firstInstantiationValue = true;
					for (OWLObject object : instantiation) {
						instantiationReplacement += firstInstantiationValue ? this.render(object)
								: ", " + this.render(object);
						firstInstantiationValue = firstInstantiationValue ? false
								: firstInstantiationValue;
					}
					instantiationReplacement += "}";
					toReturn = toReturn.replaceAll(
							"\\" + variable.getName(),
							instantiationReplacement);
				}
			} else {
				toReturn += variable.getName();
			}
		}
		return toReturn;
	}

	@Override
	public String toString() {
		String toReturn = "$" + this.patternModel.getPatternLocalName();
		boolean first = true;
		toReturn += "(";
		for (Variable<?> variable : this.getInputVariables()) {
			if (!first) {
				toReturn += ", ";
			} else {
				first = false;
			}
			ManchesterSyntaxRenderer renderer = this.patternModel.getPatternModelFactory().getRenderer(
					this.getConstraintSystem());
			Set<OWLObject> instantiation = this.instantiations.get(variable);
			if (instantiation != null) {
				if (instantiation.size() == 1) {
					OWLObject singleInstantiation = instantiation.iterator().next();
					singleInstantiation.accept(renderer);
					toReturn += renderer.toString();
				} else {
					toReturn += "{";
					boolean firstInstantiationValue = true;
					for (OWLObject object : instantiation) {
						object.accept(renderer);
						toReturn += firstInstantiationValue ? renderer.toString() : ", "
								+ renderer.toString();
						firstInstantiationValue = firstInstantiationValue ? false
								: firstInstantiationValue;
						renderer = this.patternModel.getPatternModelFactory().getRenderer(
								this.getConstraintSystem());
					}
					toReturn += "}";
				}
			} else {
				toReturn += variable.getName();
			}
		}
		toReturn += ")";
		return toReturn;
	}

	public String render(ShortFormProvider shortFormProvider) {
		String toReturn = "$" + this.patternModel.getPatternLocalName();
		boolean first = true;
		toReturn += "(";
		for (Variable<?> variable : this.getInputVariables()) {
			if (!first) {
				toReturn += ", ";
			} else {
				first = false;
			}
			ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
			Set<OWLObject> instantiation = this.instantiations.get(variable);
			if (instantiation != null) {
				if (instantiation.size() == 1) {
					OWLObject singleInstantiation = instantiation.iterator().next();
					singleInstantiation.accept(renderer);
					toReturn += renderer.toString();
				} else {
					toReturn += "{";
					boolean firstInstantiationValue = true;
					for (OWLObject object : instantiation) {
						object.accept(renderer);
						toReturn += firstInstantiationValue ? renderer.toString() : ", "
								+ renderer.toString();
						firstInstantiationValue = firstInstantiationValue ? false
								: firstInstantiationValue;
						renderer = new ManchesterSyntaxRenderer(shortFormProvider);
					}
					toReturn += "}";
				}
			} else {
				toReturn += variable.getName();
			}
		}
		toReturn += ")";
		return toReturn;
	}

	protected String render(OWLObject owlObject) {
		ManchesterSyntaxRenderer renderer = this.patternModel.getPatternModelFactory().getRenderer(
				this.getConstraintSystem());
		owlObject.accept(renderer);
		return renderer.toString();
	}

	/**
	 * @return the instantiatedPatternLocalName
	 */
	public String getInstantiatedPatternLocalName() {
		return this.patternModel.getPatternLocalName();
	}

	public Set<BindingNode> extractBindingNodes() {
		Set<Assignment> assignments = new HashSet<Assignment>();
		List<InputVariable<?>> inputVariables = this.getInputVariables();
		Map<Variable<?>, Set<OWLObject>> bindings = new HashMap<Variable<?>, Set<OWLObject>>();
		for (InputVariable<?> v : inputVariables) {
			if (this.instantiations.containsKey(v)) {
				bindings.put(v, new HashSet<OWLObject>(this.instantiations.get(v)));
			}
		}
		Set<Variable<?>> toAssign = new HashSet<Variable<?>>(inputVariables);
		if (this.isClassPattern()) {
			Variable<?> thisClassVariable = this.getConstraintSystem().getThisClassVariable();
			toAssign.add(thisClassVariable);
			if (this.instantiations.containsKey(thisClassVariable)) {
				bindings.put(
						thisClassVariable,
						new HashSet<OWLObject>(this.instantiations.get(thisClassVariable)));
			}
		}
		BindingNode rootBindingNode = new BindingNode(assignments, toAssign);
		LeafBrusher leafBrusher = new LeafBrusher(bindings);
		rootBindingNode.accept(leafBrusher);
		Set<BindingNode> leaves = leafBrusher.getLeaves();
		return leaves;
	}

	public Set<OWLObject> getOWLObjects(OWLOntology ontology, ErrorListener errorListener) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		boolean found = false;
		OWLAnnotationAssertionAxiom annotationAxiom = null;
		OWLClass owlClass;
		Iterator<OWLClass> classIterator = ontology.getClassesInSignature().iterator();
		while (classIterator.hasNext()) {
			owlClass = classIterator.next();
			Iterator<OWLAnnotationAssertionAxiom> annotationIterator = owlClass.getAnnotationAssertionAxioms(
					ontology).iterator();
			while (annotationIterator.hasNext()) {
				annotationAxiom = annotationIterator.next();
				PatternExtractor patternExtractor = this.patternModel.getPatternModelFactory().getPatternExtractor(
						errorListener);
				OWLAnnotation annotation = annotationAxiom.getAnnotation();
				PatternOPPLScript script = annotation.accept(patternExtractor);
				found = script != null && this.getName().equals(script.getName());
				if (found) {
					toReturn.add(annotationAxiom);
				}
			}
		}
		return toReturn;
	}

	public OWLOntology getOriginatingOntology() {
		OWLOntology toReturn = this.patternModel.getOriginatingOntology();
		return toReturn;
	}

	/**
	 * Adds the input Variable to this InstantiatedPatternModel. The
	 * instantiations after the addition will be <code>null</code>
	 * 
	 * @param v
	 */
	public void addVariable(Variable<?> v) {
		this.instantiations.put(v, null);
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getName()
	 */
	public String getName() {
		return this.patternModel.getPatternLocalName();
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getVariables()
	 */
	public List<Variable<?>> getVariables() {
		return this.patternModel.getVariables();
	}

	public PatternConstraintSystem getConstraintSystem() {
		return this.patternModel.getConstraintSystem();
	}

	public PatternModel getInstantiatedPattern() {
		return this.patternModel;
	}

	public void addDependency(PatternOPPLScript script) {
	}

	public boolean dependsOn(PatternOPPLScript patternOPPLScript) {
		return patternOPPLScript.getName().equals(this.patternModel.getName())
				|| this.patternModel.dependsOn(patternOPPLScript);
	}

	public void setUnresolvedOPPLStatement(String unresolvedString) {
		this.unresolvedOPPLStatementString = unresolvedString;
	}

	public String gettUnresolvedOPPLStatement() {
		return this.unresolvedOPPLStatementString;
	}

	public IRI getIRI() {
		return this.uri;
	}

	/**
	 * @param uri
	 *            the uri to set
	 */
	public void setIRI(IRI uri) {
		this.uri = uri;
	}

	/**
	 * @return the pattern instantiation rendered
	 */
	public String render() {
		String toReturn = "$" + this.getInstantiatedPatternLocalName();
		boolean first = true;
		toReturn += "(";
		for (Variable<?> variable : this.getInputVariables()) {
			if (!first) {
				toReturn += ", ";
			} else {
				first = false;
			}
			Set<OWLObject> instantiationsValues = this.getInstantiations(variable);
			if (instantiationsValues != null && !instantiationsValues.isEmpty()) {
				if (instantiationsValues.size() == 1) {
					OWLObject instantiation = instantiationsValues.iterator().next();
					toReturn += this.render(instantiation);
				} else {
					boolean firstInstantiation = true;
					toReturn += "{";
					for (OWLObject instantiation : instantiationsValues) {
						String instantiationRendering = this.render(instantiation);
						toReturn += firstInstantiation ? instantiationRendering : ", "
								+ instantiationRendering;
						firstInstantiation = firstInstantiation ? false : firstInstantiation;
					}
					toReturn += "}";
				}
			} else {
				toReturn += variable.getName();
			}
		}
		toReturn += ")";
		return toReturn;
	}

	/**
	 * @return the patternModel
	 */
	public PatternModel getPatternModel() {
		return this.patternModel;
	}

	public boolean isClassPattern() {
		return this.patternModel.isClassPattern();
	}

	public List<InputVariable<?>> getInputVariables() {
		return this.patternModel.getOpplStatement().getInputVariables();
	}

	public boolean hasScopedVariables() {
		return this.getPatternModel().hasScopedVariables();
	}

	public void accept(OPPLScriptVisitor visitor) {
		this.patternModel.accept(visitor);
	}

	public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
		return this.patternModel.accept(visitor);
	}

	public List<OWLAxiomChange> getActions() {
		List<OWLAxiomChange> actions = this.patternModel.getActions();
		Set<BindingNode> bindingNodes = this.extractBindingNodes();
		List<OWLAxiomChange> toReturn = new ArrayList<OWLAxiomChange>();
		for (BindingNode bindingNode : bindingNodes) {
			for (OWLAxiomChange axiomChange : actions) {
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), bindingNode, this.getRuntimeExceptionHandler());
				PartialOWLObjectInstantiator partialObjectInstantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom axiom = axiomChange.getAxiom();
				OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(partialObjectInstantiator);
				OWLAxiomChange instantiatedChange = axiomChange instanceof AddAxiom ? new AddAxiom(
						axiomChange.getOntology(), instantiatedAxiom) : new RemoveAxiom(
						axiomChange.getOntology(), instantiatedAxiom);
				toReturn.add(instantiatedChange);
			}
		}
		return toReturn;
	}

	public OPPLQuery getQuery() {
		return null;
	}

	public OWLObject getDefinitorialPortion(Collection<? extends BindingNode> bindingNodes,
			RuntimeExceptionHandler runtimeExceptionHandler) throws PatternException {
		return this.getPatternModel().getDefinitorialPortion(bindingNodes, runtimeExceptionHandler);
	}

	/**
	 * @return the runtimeExceptionHandler
	 */
	public RuntimeExceptionHandler getRuntimeExceptionHandler() {
		return this.runtimeExceptionHandler;
	}
}
