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
import java.io.Writer;
import java.net.URI;
import java.util.ArrayList;
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
import org.coode.oppl.SimpleVariableShortFormProvider;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.variablemansyntax.PartialOWLObjectInstantiator;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.Assignment;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.bindingtree.LeafBrusher;
import org.coode.oppl.visitors.InputVariableCollector;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.RemoveAxiom;

/**
 * @author Luigi Iannone
 * 
 *         Jun 11, 2008
 */
public class InstantiatedPatternModel implements InstantiatedOPPLScript,
		PatternOPPLScript {
	private URI uri = null;
	// The pattern model that this instantiates
	private final PatternModel patternModel;

	/**
	 * Creates an InstantiatedPatternModel instance starting from the input
	 * PatternModel
	 * 
	 * @param patternModel
	 *            the Pattern on which the this instantiated pattern will be
	 *            built. Cannot be {@code null}.
	 */
	public InstantiatedPatternModel(PatternModel patternModel) {
		ArgCheck.checkNullArgument("The pattern", patternModel);
		this.patternModel = patternModel;
	}

	private Map<Variable, Set<OWLObject>> instantiations = new HashMap<Variable, Set<OWLObject>>();
	private String unresolvedOPPLStatementString;

	public Set<OWLObject> getInstantiations(Variable variable) {
		return this.instantiations.get(variable);
	}

	/**
	 * Assigns the input value to the input variable, if the variable is already
	 * in the InstantiatedPatternModel. To add a Variable instance use
	 * {@link InstantiatedPatternModel#addVariable(Variable)}
	 * 
	 * @param variable
	 * @param value
	 */
	public void instantiate(Variable variable, OWLObject value) {
		if (this.patternModel.getVariables().contains(variable)) {
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
		Iterator<? extends Variable> it = this.getInputVariables().iterator();
		Variable variable;
		while (!unassignedVariables && it.hasNext()) {
			variable = it.next();
			unassignedVariables = this.instantiations.get(variable) == null
					|| this.instantiations.get(variable).isEmpty();
		}
		return this.patternModel.isValid() && !unassignedVariables;
	}

	public String getRendering() {
		String toReturn = this.patternModel.getRendering();
		for (Variable variable : this.instantiations.keySet()) {
			Set<OWLObject> instantiation = this.instantiations.get(variable);
			if (instantiation != null) {
				if (instantiation.size() == 1) {
					OWLObject singleInstantiation = instantiation.iterator()
							.next();
					toReturn = toReturn.replaceAll("\\" + variable.getName(),
							this.render(singleInstantiation));
				} else {
					String instantiationReplacement = "{";
					boolean firstInstantiationValue = true;
					for (OWLObject object : instantiation) {
						instantiationReplacement += firstInstantiationValue ? this
								.render(object)
								: ", " + this.render(object);
						firstInstantiationValue = firstInstantiationValue ? false
								: firstInstantiationValue;
					}
					instantiationReplacement += "}";
					toReturn = toReturn.replaceAll("\\" + variable.getName(),
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
		for (Variable variable : this.getInputVariables()) {
			if (!first) {
				toReturn += ", ";
			} else {
				first = false;
			}
			ManchesterSyntaxRenderer renderer = this.patternModel
					.getPatternModelFactory().getRenderer(
							this.getConstraintSystem());
			Set<OWLObject> instantiation = this.instantiations.get(variable);
			if (instantiation != null) {
				if (instantiation.size() == 1) {
					OWLObject singleInstantiation = instantiation.iterator()
							.next();
					singleInstantiation.accept(renderer);
					toReturn += renderer.toString();
				} else {
					toReturn += "{";
					boolean firstInstantiationValue = true;
					for (OWLObject object : instantiation) {
						object.accept(renderer);
						toReturn += firstInstantiationValue ? renderer
								.toString() : ", " + renderer.toString();
						firstInstantiationValue = firstInstantiationValue ? false
								: firstInstantiationValue;
						renderer = this.patternModel.getPatternModelFactory()
								.getRenderer(this.getConstraintSystem());
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
		ManchesterSyntaxRenderer renderer = this.patternModel.factory
				.getRenderer(getConstraintSystem());
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
		List<Variable> inputVariables = this.getInputVariables();
		for (Variable v : inputVariables) {
			v.clearBindings();
			if (this.instantiations.containsKey(v)) {
				for (OWLObject instantiation : this.instantiations.get(v)) {
					try {
						v.addPossibleBinding(instantiation);
					} catch (OWLReasonerException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		Set<Variable> toAssign = new HashSet<Variable>(inputVariables);
		if (this.isClassPattern()) {
			toAssign.add(this.getConstraintSystem().getThisClassVariable());
		}
		BindingNode rootBindingNode = new BindingNode(assignments, toAssign);
		LeafBrusher leafBrusher = new LeafBrusher();
		rootBindingNode.accept(leafBrusher);
		Set<BindingNode> leaves = leafBrusher.getLeaves();
		return leaves;
	}

	public Set<Variable> extractAllPossibleBindingNodes(OWLOntology o,
			Set<OWLEntity> signature) {
		List<Variable> inputVariables = this.getInputVariables();
		for (Variable v : inputVariables) {
			if (!this.instantiations.containsKey(v)) {
				Set<? extends OWLObject> referencedValues = v.getType()
						.getReferencedValues(o);
				for (OWLObject bind : referencedValues) {
					try {
						if (signature.contains(bind)
								&& v.getPossibleBindings().size() == 0) {
							v.addPossibleBinding(bind);
						}
						v.addPossibleBinding(this.patternModel
								.getOWLOntologyManager().getOWLDataFactory()
								.getOWLNothing());
					} catch (OWLReasonerException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		Set<Variable> toAssign = new HashSet<Variable>(inputVariables);
		// if (this.isClassPattern()) {
		// toAssign.add(this.getConstraintSystem().getThisClassVariable());
		// }
		return toAssign;
	}

	@SuppressWarnings("unchecked")
	public Set<? extends OWLAxiom> getOWLAxioms(OWLOntology ontology) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		boolean found = false;
		OWLAnnotationAxiom<? extends OWLObject> annotationAxiom = null;
		OWLClass owlClass;
		Iterator<OWLClass> classIterator = ontology.getReferencedClasses()
				.iterator();
		while (classIterator.hasNext()) {
			owlClass = classIterator.next();
			Iterator<OWLAnnotationAxiom> annotationIterator = owlClass
					.getAnnotationAxioms(ontology).iterator();
			while (annotationIterator.hasNext()) {
				annotationAxiom = annotationIterator.next();
				PatternExtractor patternExtractor = this.patternModel
						.getPatternModelFactory().getPatternExtractor();
				OWLAnnotation<? extends OWLObject> annotation = annotationAxiom
						.getAnnotation();
				PatternOPPLScript script = annotation.accept(patternExtractor);
				found = script != null
						&& this.getName().equals(script.getName());
				if (found) {
					toReturn.add(annotationAxiom);
				}
			}
		}
		// Set<OWLAxiom> axioms = ontology.getAxioms();
		// for (OWLAxiom axiom : axioms) {
		// Set<OWLAxiomAnnotationAxiom> annotationAxioms = axiom
		// .getAnnotationAxioms(ontology);
		// if (Utils.isPatternGenerated(this.patternModel
		// .getPatternLocalName(), annotationAxioms)) {
		// toReturn.add(axiom);
		// }
		// }
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
	public void addVariable(Variable v) {
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
	public List<Variable> getVariables() {
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

	/**
	 * @return the uri
	 */
	public URI getUri() {
		return this.uri;
	}

	/**
	 * @param uri
	 *            the uri to set
	 */
	public void setUri(URI uri) {
		this.uri = uri;
	}

	/**
	 * @return the pattern instantiation rendered
	 */
	public String render() {
		String toReturn = "$" + this.getInstantiatedPatternLocalName();
		boolean first = true;
		toReturn += "(";
		for (Variable variable : this.getInputVariables()) {
			if (!first) {
				toReturn += ", ";
			} else {
				first = false;
			}
			Set<OWLObject> instantiationsValues = this
					.getInstantiations(variable);
			if (instantiationsValues != null && !instantiationsValues.isEmpty()) {
				if (instantiationsValues.size() == 1) {
					OWLObject instantiation = instantiationsValues.iterator()
							.next();
					toReturn += this.render(instantiation);
				} else {
					boolean firstInstantiation = true;
					toReturn += "{";
					for (OWLObject instantiation : instantiationsValues) {
						String instantiationRendering = this
								.render(instantiation);
						toReturn += firstInstantiation ? instantiationRendering
								: ", " + instantiationRendering;
						firstInstantiation = firstInstantiation ? false
								: firstInstantiation;
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

	public String getDefinitorialPortionStrings(List<List<Object>> replacements)
			throws PatternException {
		return this.patternModel.getDefinitorialPortionStrings(replacements);
	}

	public List<Variable> getInputVariables() {
		InputVariableCollector visitor = new InputVariableCollector();
		for (Variable variable : this.getVariables()) {
			variable.accept(visitor);
		}
		return visitor.getCollectedVariables();
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
				PartialOWLObjectInstantiator partialObjectInstantiator = new PartialOWLObjectInstantiator(
						bindingNode, this.getConstraintSystem());
				OWLAxiom axiom = axiomChange.getAxiom();
				OWLAxiom instantiatedAxiom = (OWLAxiom) axiom
						.accept(partialObjectInstantiator);
				OWLAxiomChange instantiatedChange = axiomChange instanceof AddAxiom ? new AddAxiom(
						axiomChange.getOntology(), instantiatedAxiom)
						: new RemoveAxiom(axiomChange.getOntology(),
								instantiatedAxiom);
				toReturn.add(instantiatedChange);
			}
		}
		return toReturn;
	}

	public OPPLQuery getQuery() {
		return null;
	}

	public List<OWLObject> getDefinitorialPortions(
			List<List<Object>> replacementTuples) throws PatternException {
		return this.patternModel.getDefinitorialPortions(replacementTuples);
	}
}
