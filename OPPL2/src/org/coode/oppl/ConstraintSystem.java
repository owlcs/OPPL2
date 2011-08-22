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
package org.coode.oppl;

import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.InvalidVariableNameException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Create;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.VariableDetector;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.utils.VariableRecogniser;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableFactory;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public class ConstraintSystem {
	private final static class VariableSet {
		private final Map<String, Variable<?>> map = new HashMap<String, Variable<?>>();
		private final Map<IRI, Variable<?>> irisMap = new HashMap<IRI, Variable<?>>();

		public VariableSet() {
		}

		public Variable<?> get(String name) {
			return this.map.get(name);
		}

		public Variable<?> get(IRI variableIRI) {
			return this.irisMap.get(variableIRI);
		}

		public void store(Variable<?> variable) {
			this.map.put(variable.getName(), variable);
			this.irisMap.put(variable.getIRI(), variable);
		}

		public boolean containsVariableIRI(IRI variableURI) {
			return this.irisMap.containsKey(variableURI);
		}

		public Set<InputVariable<?>> getInputVariables() {
			Set<InputVariable<?>> toReturn = new HashSet<InputVariable<?>>(this.map.values().size());
			for (Variable<?> v : this.map.values()) {
				if (VariableRecogniser.INPUT_VARIABLE_RECOGNISER.recognise(v)) {
					toReturn.add((InputVariable<?>) v);
				}
			}
			return toReturn;
		}

		public Set<Variable<?>> getAllVariables() {
			return new HashSet<Variable<?>>(this.map.values());
		}

		public Set<GeneratedVariable<?>> getGeneratedVariables() {
			Set<GeneratedVariable<?>> toReturn = new HashSet<GeneratedVariable<?>>(
					this.map.values().size());
			for (Variable<?> v : this.map.values()) {
				if (VariableRecogniser.GENERATED_VARIABLE_RECOGNISER.recognise(v)) {
					toReturn.add((GeneratedVariable<?>) v);
				}
			}
			return toReturn;
		}

		public void remove(String name) {
			Variable<?> removed = this.map.remove(name);
			if (removed != null) {
				this.irisMap.remove(removed.getIRI());
			}
		}

		public void clear() {
			this.map.clear();
			this.irisMap.clear();
		}

		@Override
		public String toString() {
			Set<Variable<?>> allVariables = this.getAllVariables();
			Formatter formatter = new Formatter();
			for (Variable<?> variable : allVariables) {
				formatter.format(
						"Variable name: %s generated: %s \n",
						variable.getName(),
						this.getGeneratedVariables().contains(variable));
			}
			return formatter.toString();
		}
	}

	private final VariableSet variables = new VariableSet();
	private final OWLOntology ontology;
	private Set<BindingNode> leaves = null;
	private OWLReasoner reasoner = null;
	private final OWLOntologyManager ontologyManager;
	private final OPPLAbstractFactory opplFactory;

	public ConstraintSystem(OWLOntology ontology, OWLOntologyManager ontologyManager,
			OPPLAbstractFactory opplFactory) {
		if (ontology == null) {
			throw new NullPointerException("The ontology cannot be null");
		}
		if (ontologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		if (opplFactory == null) {
			throw new NullPointerException("The OPPL factory cannot be null");
		}
		this.opplFactory = opplFactory;
		this.ontology = ontology;
		this.ontologyManager = ontologyManager;
	}

	public ConstraintSystem(OWLOntology ontology, OWLOntologyManager ontologyManager,
			OWLReasoner reasoner, OPPLAbstractFactory opplAbstractFactory) {
		this(ontology, ontologyManager, opplAbstractFactory);
		this.reasoner = reasoner;
	}

	public Variable<?> getVariable(String name) {
		return this.variables.get(name);
	}

	public <O extends OWLObject> InputVariable<O> createVariable(final String name,
			final VariableType<O> type, final VariableScope<?> variableScope) throws OPPLException {
		if (name.matches("\\?([\\p{Alnum}[-_]])+")) {
			Variable<?> newVariable = this.variables.get(name);
			if (newVariable == null) {
				newVariable = type.getInputVariable(name, variableScope);
				this.variables.store(newVariable);
			} else {
				boolean rightKind = newVariable.accept(new VariableVisitorEx<Boolean>() {
					public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
						return true;
					}

					public <P extends OWLObject> Boolean visit(GeneratedVariable<P> v) {
						return false;
					}

					public <P extends OWLObject> Boolean visit(
							RegexpGeneratedVariable<P> regExpGenerated) {
						return false;
					}
				});
				if (!rightKind) {
					throw new OPPLException(String.format(
							"A generated or regexp variable named %s already exists",
							name));
				} else if (type != newVariable.getType()) {
					throw new OPPLException(
							String.format(
									"An input variable named %s already exists but is of a different type %s from the input one %s",
									name,
									newVariable,
									type));
				} else {
					newVariable = newVariable.accept(new VariableVisitorEx<Variable<?>>() {
						public <P extends OWLObject> Variable<?> visit(InputVariable<P> v) {
							Variable<?> toReturn = v;
							if (v.getVariableScope() != variableScope) {
								toReturn = type.getInputVariable(name, variableScope);
								ConstraintSystem.this.variables.store(toReturn);
							}
							return toReturn;
						}

						public <P extends OWLObject> Variable<?> visit(GeneratedVariable<P> v) {
							return v;
						}

						public <P extends OWLObject> Variable<?> visit(
								RegexpGeneratedVariable<P> regExpGenerated) {
							return regExpGenerated;
						}
					});
				}
			}
			return (InputVariable<O>) newVariable;
		} else {
			throw new InvalidVariableNameException("Invalid name: " + name);
		}
	}

	public Set<Variable<?>> getAxiomVariables(OWLAxiom axiom) {
		VariableExtractor axiomVariableExtractor = new VariableExtractor(this, true);
		Set<Variable<?>> axiomVariables = axiomVariableExtractor.extractVariables(axiom);
		return new HashSet<Variable<?>>(axiomVariables);
	}

	public boolean isVariableIRI(IRI uri) {
		return this.variables.containsVariableIRI(uri);
	}

	public Variable<?> getVariable(IRI iri) {
		return this.variables.get(iri);
	}

	public boolean isVariable(OWLClassExpression desc) {
		VariableDetector variableDetector = new VariableDetector(this);
		return desc.accept(variableDetector);
	}

	public boolean isVariable(OWLAnnotationProperty property) {
		return this.isVariableIRI(property.getIRI());
	}

	public boolean isVariable(OWLObjectProperty property) {
		return this.isVariableIRI(property.getIRI());
	}

	public boolean isVariable(OWLDataProperty property) {
		return this.isVariableIRI(property.getIRI());
	}

	public boolean isVariable(OWLNamedIndividual individual) {
		return this.isVariableIRI(individual.getIRI());
	}

	public void addLeaf(BindingNode bindingNode) {
		if (this.leaves == null) {
			this.leaves = new HashSet<BindingNode>();
		}
		this.leaves.add(bindingNode);
	}

	public Set<OWLObject> getVariableBindings(Variable<?> v,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		Set<BindingNode> leaves = this.getLeaves();
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		SimpleValueComputationParameters parameters = new SimpleValueComputationParameters(this,
				BindingNode.getEmptyBindingNode(), runtimeExceptionHandler);
		if (leaves != null) {
			for (BindingNode bindingNode : leaves) {
				OWLObject assignmentValue = bindingNode.getAssignmentValue(v, parameters);
				if (assignmentValue != null) {
					toReturn.add(assignmentValue);
				}
			}
		}
		return toReturn;
	}

	public boolean addLeaf(Variable<?> variable, OWLObject object) {
		boolean toReturn = variable.getType().isCompatibleWith(object);
		if (toReturn) {
			if (this.leaves == null) {
				this.leaves = new HashSet<BindingNode>();
			}
			Assignment assignment = new Assignment(variable, object);
			if (!this.leaves.isEmpty()) {
				for (BindingNode node : this.leaves) {
					node.addAssignment(assignment);
				}
			} else {
				this.leaves.add(new BindingNode(Collections.singleton(assignment),
						Collections.<Variable<?>> emptySet()));
			}
		}
		return toReturn;
	}

	/**
	 * @return the leaves
	 */
	public Set<BindingNode> getLeaves() {
		return this.leaves == null ? this.leaves : new HashSet<BindingNode>(this.leaves);
	}

	public OPPLAbstractFactory getOPPLFactory() {
		return this.opplFactory;
	}

	public Set<InputVariable<?>> getInputVariables() {
		return this.variables.getInputVariables();
	}

	public void removeBinding(BindingNode binding) {
		this.leaves.remove(binding);
	}

	public boolean isVariable(OWLLiteral node) {
		return node.getLiteral().startsWith("?");
	}

	public void setLeaves(Set<BindingNode> newLeaves) {
		this.leaves = newLeaves;
	}

	public void setReasoner(OWLReasoner reasoner) {
		this.reasoner = reasoner;
	}

	public Set<Variable<?>> getVariables() {
		return this.variables.getAllVariables();
	}

	/**
	 * 
	 * 
	 * @return the reasoner
	 * @throws OWLRuntimeException
	 */
	public OWLReasoner getReasoner() {
		return this.reasoner;
	}

	@SuppressWarnings("unchecked")
	public <O extends OWLObject> GeneratedVariable<O> createStringGeneratedVariable(
			final String name, VariableType<O> type, final OPPLFunction<String> value) {
		GeneratedVariable<O> generatedVariable = type.accept(new VariableTypeVisitorEx<GeneratedVariable<O>>() {
			public GeneratedVariable<O> visitCLASSVariableType(CLASSVariableType classVariableType) {
				OPPLFunction<OWLClass> createOWLClass = Create.createOWLClass(value);
				return (GeneratedVariable<O>) VariableFactory.getGeneratedVariable(
						name,
						classVariableType,
						createOWLClass);
			}

			public GeneratedVariable<O> visitOBJECTPROPERTYVariableType(
					OBJECTPROPERTYVariableType objectpropertyVariableType) {
				OPPLFunction<OWLObjectProperty> createOWLObjectProperty = Create.createOWLObjectProperty(value);
				return (GeneratedVariable<O>) VariableFactory.getGeneratedVariable(
						name,
						objectpropertyVariableType,
						createOWLObjectProperty);
			}

			public GeneratedVariable<O> visitDATAPROPERTYVariableType(
					DATAPROPERTYVariableType datapropertyVariableType) {
				OPPLFunction<OWLDataProperty> createOWLDataProperty = Create.createOWLDataProperty(value);
				return (GeneratedVariable<O>) VariableFactory.getGeneratedVariable(
						name,
						datapropertyVariableType,
						createOWLDataProperty);
			}

			public GeneratedVariable<O> visitINDIVIDUALVariableType(
					INDIVIDUALVariableType individualVariableType) {
				OPPLFunction<OWLNamedIndividual> createOWLNamedIndividualProperty = Create.createOWLNamedIndividual(value);
				return (GeneratedVariable<O>) VariableFactory.getGeneratedVariable(
						name,
						individualVariableType,
						createOWLNamedIndividualProperty);
			}

			public GeneratedVariable<O> visitCONSTANTVariableType(
					CONSTANTVariableType constantVariableType) {
				OPPLFunction<OWLLiteral> createOWLLiteralProperty = Create.createOWLLiteral(value);
				return (GeneratedVariable<O>) VariableFactory.getGeneratedVariable(
						name,
						constantVariableType,
						createOWLLiteralProperty);
			}

			public GeneratedVariable<O> visitANNOTATIONPROPERTYVariableType(
					ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
				Create<OPPLFunction<String>, OWLAnnotationProperty> annotationProperty = Create.createOWLAnnotationProperty(value);
				return (GeneratedVariable<O>) VariableFactory.getGeneratedVariable(
						name,
						annotationpropertyVariableType,
						annotationProperty);
			}
		});
		this.variables.store(generatedVariable);
		return generatedVariable;
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	public Set<GeneratedVariable<?>> getGeneratedVariables() {
		return this.variables.getGeneratedVariables();
	}

	public boolean isGenerated(Variable<?> v) {
		return this.variables.getGeneratedVariables().contains(v);
	}

	public void reset() {
		this.leaves = null;
	}

	public void removeVariable(Variable<?> variable) {
		this.variables.remove(variable.getName());
	}

	public GeneratedVariable<OWLClassExpression> createIntersectionGeneratedVariable(
			final String name,
			VariableType<?> type,
			final Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> operands) {
		GeneratedVariable<OWLClassExpression> toReturn = type.accept(new VariableTypeVisitorEx<GeneratedVariable<OWLClassExpression>>() {
			public GeneratedVariable<OWLClassExpression> visitCLASSVariableType(
					CLASSVariableType classVariableType) {
				Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>> function = Aggregation.buildClassExpressionIntersection(
						operands,
						ConstraintSystem.this.getOntologyManager().getOWLDataFactory());
				GeneratedVariable<OWLClassExpression> toReturn = VariableTypeFactory.getCLASSVariableType().getGeneratedVariable(
						name,
						function);
				return toReturn;
			}

			public GeneratedVariable<OWLClassExpression> visitANNOTATIONPROPERTYVariableType(
					ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitOBJECTPROPERTYVariableType(
					OBJECTPROPERTYVariableType objectpropertyVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitDATAPROPERTYVariableType(
					DATAPROPERTYVariableType datapropertyVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitINDIVIDUALVariableType(
					INDIVIDUALVariableType individualVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitCONSTANTVariableType(
					CONSTANTVariableType constantVariableType) {
				return null;
			}
		});
		this.variables.store(toReturn);
		return toReturn;
	}

	public GeneratedVariable<OWLClassExpression> createUnionGeneratedVariable(
			final String name,
			VariableType<?> type,
			final Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> operands) {
		GeneratedVariable<OWLClassExpression> toReturn = type.accept(new VariableTypeVisitorEx<GeneratedVariable<OWLClassExpression>>() {
			public GeneratedVariable<OWLClassExpression> visitCLASSVariableType(
					CLASSVariableType classVariableType) {
				Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>> function = Aggregation.buildClassExpressionUnion(
						operands,
						ConstraintSystem.this.getOntologyManager().getOWLDataFactory());
				GeneratedVariable<OWLClassExpression> toReturn = VariableTypeFactory.getCLASSVariableType().getGeneratedVariable(
						name,
						function);
				return toReturn;
			}

			public GeneratedVariable<OWLClassExpression> visitANNOTATIONPROPERTYVariableType(
					ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitOBJECTPROPERTYVariableType(
					OBJECTPROPERTYVariableType objectpropertyVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitDATAPROPERTYVariableType(
					DATAPROPERTYVariableType datapropertyVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitINDIVIDUALVariableType(
					INDIVIDUALVariableType individualVariableType) {
				return null;
			}

			public GeneratedVariable<OWLClassExpression> visitCONSTANTVariableType(
					CONSTANTVariableType constantVariableType) {
				return null;
			}
		});
		this.variables.store(toReturn);
		return toReturn;
	}

	public <O extends OWLObject> RegexpGeneratedVariable<? extends O> createRegexpGeneratedVariable(
			String name, VariableType<O> type, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		RegexpGeneratedVariable<? extends O> toReturn = type.getRegexpGeneratedVariable(
				name,
				patternGeneratingOPPLFunction);
		this.variables.store(toReturn);
		return toReturn;
	}

	public <O extends OWLObject> GeneratedVariable<O> createExpressionGeneratedVariable(
			final String name, O expression) {
		GeneratedVariable<O> toReturn = expression.accept(new OWLObjectVisitorExAdapter<GeneratedVariable<O>>() {
			@Override
			protected GeneratedVariable<O> getDefaultReturnValue(OWLObject object) {
				return null;
			}

			@Override
			public GeneratedVariable<O> visit(OWLClass desc) {
				return this.getCLASSGeneratedVariable(name, desc);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectIntersectionOf ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectUnionOf ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectComplementOf ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectSomeValuesFrom ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectAllValuesFrom ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectHasValue ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectMinCardinality ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectExactCardinality ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectMaxCardinality ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectHasSelf ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectOneOf ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLDataSomeValuesFrom ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLDataAllValuesFrom ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLDataHasValue ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLDataMinCardinality ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLDataExactCardinality ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLDataMaxCardinality ce) {
				return this.getCLASSGeneratedVariable(name, ce);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectProperty property) {
				return this.getOBJECTPROPERTYGeneratedVariable(name, property);
			}

			@Override
			public GeneratedVariable<O> visit(OWLObjectInverseOf property) {
				return this.getOBJECTPROPERTYGeneratedVariable(name, property);
			}

			@SuppressWarnings("unchecked")
			protected GeneratedVariable<O> getCLASSGeneratedVariable(final String name,
					OWLClassExpression desc) {
				OPPLFunction<? extends OWLClassExpression> adapted = new Expression<OWLClassExpression>(
						desc);
				return (GeneratedVariable<O>) VariableTypeFactory.getCLASSVariableType().getGeneratedVariable(
						name,
						adapted);
			}

			@SuppressWarnings("unchecked")
			protected GeneratedVariable<O> getOBJECTPROPERTYGeneratedVariable(final String name,
					OWLObjectPropertyExpression p) {
				OPPLFunction<? extends OWLObjectPropertyExpression> adapted = new Expression<OWLObjectPropertyExpression>(
						p);
				return (GeneratedVariable<O>) VariableTypeFactory.getOBJECTPROPERTYTypeVariableType().getGeneratedVariable(
						name,
						adapted);
			}
		});
		this.variables.store(toReturn);
		return toReturn;
	}

	public String render(Variable<?> variable) {
		return variable.getName();
	}

	public void importVariable(Variable<?> v) {
		this.variables.store(v);
	}

	public void clearVariables() {
		this.variables.clear();
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}
}
