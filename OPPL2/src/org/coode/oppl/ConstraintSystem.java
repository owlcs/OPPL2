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

import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.InvalidVariableNameException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Create;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.generated.CLASSGeneratedVariable;
import org.coode.oppl.generated.DATAPROPERTYGeneratedVariable;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.INDIVIDUALGeneratedVariable;
import org.coode.oppl.generated.OBJECTPROPERTYGeneratedVariable;
import org.coode.oppl.utils.VariableDetector;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.visitors.GeneratedVariableCollector;
import org.coode.oppl.visitors.InputVariableCollector;
import org.semanticweb.owlapi.model.IRI;
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
 */
public class ConstraintSystem {
	private final static class VariableSet {
		private final Map<String, Variable> map = new HashMap<String, Variable>();
		private final Map<IRI, Variable> irisMap = new HashMap<IRI, Variable>();

		public VariableSet() {
		}

		public Variable get(String name) {
			return this.map.get(name);
		}

		public Variable get(IRI variableIRI) {
			return this.irisMap.get(variableIRI);
		}

		public void store(Variable variable) {
			this.map.put(variable.getName(), variable);
			this.irisMap.put(variable.getIRI(), variable);
		}

		public boolean containsVariableIRI(IRI variableURI) {
			return this.irisMap.containsKey(variableURI);
		}

		public Set<Variable> getInputVariables() {
			InputVariableCollector visitor = new InputVariableCollector();
			for (Variable variable : this.map.values()) {
				variable.accept(visitor);
			}
			return new HashSet<Variable>(visitor.getCollectedVariables());
		}

		public Set<Variable> getAllVariables() {
			return new HashSet<Variable>(this.map.values());
		}

		public Set<GeneratedVariable<?>> getGeneratedVariables() {
			GeneratedVariableCollector visitor = new GeneratedVariableCollector();
			for (Variable v : this.map.values()) {
				v.accept(visitor);
			}
			return new HashSet<GeneratedVariable<?>>(visitor.getCollectedVariables());
		}

		public void remove(String name) {
			Variable removed = this.map.remove(name);
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
			Set<Variable> allVariables = this.getAllVariables();
			Formatter formatter = new Formatter();
			for (Variable variable : allVariables) {
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

	public Variable getVariable(String name) {
		return this.variables.get(name);
	}

	public Variable createVariable(String name, VariableType type) throws OPPLException {
		if (name.matches("\\?([\\p{Alnum}[-_]])+")) {
			Variable newVariable = type.instantiateVariable(name);
			// new VariableImpl(name.trim(), type);
			this.variables.store(newVariable);
			return newVariable;
		} else {
			throw new InvalidVariableNameException("Invalid name: " + name);
		}
	}

	public Set<Variable> getAxiomVariables(OWLAxiom axiom) {
		VariableExtractor axiomVariableExtractor = new VariableExtractor(this, true);
		Set<Variable> axiomVariables = axiomVariableExtractor.extractVariables(axiom);
		return new HashSet<Variable>(axiomVariables);
	}

	public boolean isVariableIRI(IRI uri) {
		return this.variables.containsVariableIRI(uri);
	}

	public Variable getVariable(IRI iri) {
		return this.variables.get(iri);
	}

	public boolean isVariable(OWLClassExpression desc) {
		VariableDetector variableDetector = new VariableDetector(this);
		return desc.accept(variableDetector);
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

	public Set<OWLObject> getVariableBindings(Variable v) {
		Set<BindingNode> leaves = this.getLeaves();
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		SimpleValueComputationParameters parameters = new SimpleValueComputationParameters(this,
				BindingNode.getEmptyBindingNode());
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

	public boolean addLeaf(Variable variable, OWLObject object) {
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
						Collections.<Variable> emptySet()));
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

	public Set<Variable> getInputVariables() {
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

	public Set<Variable> getVariables() {
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

	public GeneratedVariable<?> createStringGeneratedVariable(String name, VariableType type,
			OPPLFunction<String> value) {
		GeneratedVariable<?> generatedVariable = null;
		switch (type) {
		case CLASS:
			generatedVariable = new CLASSGeneratedVariable(name, Create.createOWLClass(value));
			break;
		case OBJECTPROPERTY:
			generatedVariable = new OBJECTPROPERTYGeneratedVariable(name,
					Create.createOWLObjectProperty(value));
			break;
		case DATAPROPERTY:
			generatedVariable = new DATAPROPERTYGeneratedVariable(name,
					Create.createOWLDataProperty(value));
			break;
		case INDIVIDUAL:
			generatedVariable = new INDIVIDUALGeneratedVariable(name,
					Create.createOWLNamedIndividual(value));
			break;
		default:
			break;
		}
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

	public boolean isGenerated(Variable v) {
		return this.variables.getGeneratedVariables().contains(v);
	}

	public void reset() {
		this.leaves = null;
	}

	public void removeVariable(Variable variable) {
		this.variables.remove(variable.getName());
	}

	public GeneratedVariable<OWLClassExpression> createIntersectionGeneratedVariable(String name,
			VariableType type,
			Collection<? extends OPPLFunction<? extends OWLClassExpression>> operands) {
		GeneratedVariable<OWLClassExpression> toReturn = null;
		switch (type) {
		case CLASS:
			Aggregation<OWLClassExpression, OWLClassExpression> function = Aggregation.buildClassExpressionIntersection(
					operands,
					this.getOntologyManager().getOWLDataFactory());
			toReturn = new CLASSGeneratedVariable(name, function);
			break;
		default:
			break;
		}
		return toReturn;
	}

	public GeneratedVariable<OWLClassExpression> createUnionGeneratedVariable(String name,
			VariableType type,
			Collection<? extends OPPLFunction<? extends OWLClassExpression>> operands) {
		GeneratedVariable<OWLClassExpression> toReturn = null;
		switch (type) {
		case CLASS:
			Aggregation<OWLClassExpression, OWLClassExpression> function = Aggregation.buildClassExpressionUnion(
					operands,
					this.getOntologyManager().getOWLDataFactory());
			toReturn = new CLASSGeneratedVariable(name, function);
			break;
		default:
			break;
		}
		return toReturn;
	}

	public String render(Variable variable) {
		return variable.getName();
	}

	public void importVariable(Variable v) {
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
