package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitor;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLQuantifiedRestriction;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;
import org.semanticweb.owlapi.util.OWLObjectVisitorAdapter;

public abstract class AbstractOPPLAxiomSearchTree extends SearchTree<OPPLOWLAxiomSearchNode> {
	/** test */
	private final class ConstantCollector extends OWLAxiomVisitorAdapter {
		private final Set<OWLLiteral> toReturn;
		private final OWLClassExpressionVisitor constantExtractor;

		ConstantCollector(Set<OWLLiteral> toReturn, OWLClassExpressionVisitor constantExtractor) {
			this.toReturn = toReturn;
			this.constantExtractor = constantExtractor;
		}

		@Override
		public void visit(OWLClassAssertionAxiom axiom) {
			axiom.getClassExpression().accept(this.constantExtractor);
		}

		@Override
		public void visit(OWLDataPropertyAssertionAxiom axiom) {
			this.toReturn.add(axiom.getObject());
		}

		@Override
		public void visit(OWLDisjointClassesAxiom axiom) {
			for (OWLClassExpression description : axiom.getClassExpressions()) {
				description.accept(this.constantExtractor);
			}
		}

		@Override
		public void visit(OWLEquivalentClassesAxiom axiom) {
			for (OWLClassExpression description : axiom.getClassExpressions()) {
				description.accept(this.constantExtractor);
			}
		}

		@Override
		public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			this.toReturn.add(axiom.getObject());
		}

		@Override
		public void visit(OWLSubClassOfAxiom axiom) {
			axiom.getSubClass().accept(this.constantExtractor);
			axiom.getSuperClass().accept(this.constantExtractor);
		}
	}

	private final ConstraintSystem constraintSystem;
	private final RuntimeExceptionHandler runtimeExceptionHandler;
	private final Set<OWLClass> allClasses = new HashSet<OWLClass>();
	private final Set<OWLObjectProperty> allObjectProperties = new HashSet<OWLObjectProperty>();
	private final Set<OWLDataProperty> allDataProperties = new HashSet<OWLDataProperty>();
	private final Set<OWLIndividual> allIndividuals = new HashSet<OWLIndividual>();
	private final Set<OWLLiteral> allConstants = new HashSet<OWLLiteral>();

	protected AbstractOPPLAxiomSearchTree(ConstraintSystem constraintSystem,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (runtimeExceptionHandler == null) {
			throw new NullPointerException("The runtime exception handler cannot be null");
		}
		this.constraintSystem = constraintSystem;
		this.runtimeExceptionHandler = runtimeExceptionHandler;
	}

	@Override
	protected abstract boolean goalReached(OPPLOWLAxiomSearchNode start);

	/**
	 * @see org.coode.oppl.search.SearchTree#getChildren(java.lang.Object)
	 */
	@Override
	protected List<OPPLOWLAxiomSearchNode> getChildren(OPPLOWLAxiomSearchNode node) {
		List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<OPPLOWLAxiomSearchNode>();
		VariableExtractor variableExtractor = new VariableExtractor(this.getConstraintSystem(),
				false);
		Set<Variable<?>> variables = variableExtractor.extractVariables(node.getAxiom());
		BindingNode binding = node.getBinding();
		ValueComputationParameters parameters = new SimpleValueComputationParameters(
				this.getConstraintSystem(), node.getBinding(), this.getRuntimeExceptionHandler());
		for (Variable<?> variable : variables) {
			Set<OWLObject> values = new HashSet<OWLObject>();
			values.addAll(this.getAssignableValues(variable, parameters));
			for (OWLObject value : values) {
				Assignment assignment = new Assignment(variable, value);
				BindingNode childBinding = new BindingNode(binding.getAssignments(),
						binding.getUnassignedVariables());
				childBinding.addAssignment(assignment);
				ValueComputationParameters newParameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), childBinding, this.getRuntimeExceptionHandler());
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						newParameters);
				OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(instantiator);
				OPPLOWLAxiomSearchNode child = new OPPLOWLAxiomSearchNode(instantiatedAxiom,
						childBinding);
				toReturn.add(child);
			}
		}
		return toReturn;
	}

	private Collection<OWLClass> getAllClasses() {
		Set<OWLClass> toReturn = new HashSet<OWLClass>();
		for (OWLOntology owlOntology : this.getConstraintSystem().getOntologyManager().getOntologies()) {
			toReturn.addAll(owlOntology.getClassesInSignature());
		}
		return toReturn;
	}

	private Collection<OWLLiteral> getAllConstants() {
		final Set<OWLLiteral> toReturn = new HashSet<OWLLiteral>();
		final OWLObjectVisitorAdapter constantExtractor = new OWLObjectVisitorAdapter() {
			protected void visitOWLQuantifiedRestriction(
					OWLQuantifiedRestriction<?, ?, ?> restriction) {
				if (restriction.getFiller() != null) {
					restriction.getFiller().accept(this);
				}
			}

			@Override
			public void visit(OWLDataMaxCardinality desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataExactCardinality desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataMinCardinality desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataAllValuesFrom desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataSomeValuesFrom desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectOneOf desc) {
			}

			@Override
			public void visit(OWLObjectHasSelf desc) {
			}

			@Override
			public void visit(OWLObjectMaxCardinality desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectExactCardinality desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectMinCardinality desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectHasValue desc) {
			}

			@Override
			public void visit(OWLObjectAllValuesFrom desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataHasValue desc) {
				toReturn.add(desc.getValue());
			}

			@Override
			public void visit(OWLObjectSomeValuesFrom desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectComplementOf desc) {
				desc.getOperand().accept(this);
			}

			protected void visitOWLObjectCollection(Collection<? extends OWLObject> collection) {
				for (OWLObject owlObject : collection) {
					owlObject.accept(this);
				}
			}

			@Override
			public void visit(OWLObjectUnionOf desc) {
				this.visitOWLObjectCollection(desc.getOperands());
			}

			@Override
			public void visit(OWLObjectIntersectionOf desc) {
				this.visitOWLObjectCollection(desc.getOperands());
			}
		};
		ConstantCollector visitor = new ConstantCollector(toReturn, constantExtractor);
		for (OWLOntology owlOntology : this.getConstraintSystem().getOntologyManager().getOntologies()) {
			for (OWLAxiom axiomToVisit : owlOntology.getAxioms()) {
				axiomToVisit.accept(visitor);
			}
		}
		return toReturn;
	}

	private Collection<OWLDataProperty> getAllDataProperties() {
		Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
		for (OWLOntology owlOntology : this.getConstraintSystem().getOntologyManager().getOntologies()) {
			toReturn.addAll(owlOntology.getDataPropertiesInSignature());
		}
		return toReturn;
	}

	private Collection<OWLIndividual> getAllIndividuals() {
		Set<OWLIndividual> toReturn = new HashSet<OWLIndividual>();
		for (OWLOntology owlOntology : this.getConstraintSystem().getOntologyManager().getOntologies()) {
			toReturn.addAll(owlOntology.getIndividualsInSignature());
		}
		return toReturn;
	}

	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {
		public Set<? extends OWLObject> visitCLASSVariableType(CLASSVariableType classVariableType) {
			return AbstractOPPLAxiomSearchTree.this.allClasses;
		}

		public Set<? extends OWLObject> visitOBJECTPROPERTYVariableType(
				OBJECTPROPERTYVariableType objectpropertyVariableType) {
			return AbstractOPPLAxiomSearchTree.this.allObjectProperties;
		}

		public Set<? extends OWLObject> visitDATAPROPERTYVariableType(
				DATAPROPERTYVariableType datapropertyVariableType) {
			return AbstractOPPLAxiomSearchTree.this.allDataProperties;
		}

		public Set<? extends OWLObject> visitINDIVIDUALVariableType(
				INDIVIDUALVariableType individualVariableType) {
			return AbstractOPPLAxiomSearchTree.this.allIndividuals;
		}

		public Set<? extends OWLObject> visitCONSTANTVariableType(
				CONSTANTVariableType constantVariableType) {
			// TODO Auto-generated method stub
			return null;
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(Variable<?> variable,
			ValueComputationParameters parameters) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable.accept(new AssignableValueExtractor(this.assignableValuesVisitor,
				parameters)));
		VariableScope<?> variableScope = variable.getVariableScope();
		if (variableScope != null) {
			Iterator<OWLObject> iterator = toReturn.iterator();
			while (iterator.hasNext()) {
				OWLObject owlObject = iterator.next();
				try {
					boolean inScope = variableScope.check(
							owlObject,
							this.getConstraintSystem().getOPPLFactory().getVariableScopeChecker());
					if (!inScope) {
						iterator.remove();
					}
				} catch (OWLRuntimeException e) {
					e.printStackTrace();
				} catch (OPPLException e) {
					e.printStackTrace();
				}
			}
		}
		return toReturn;
	}

	private void initAssignableValues() {
		this.allClasses.addAll(this.getAllClasses());
		Logging.getQueryLogger().log(Level.FINE, "Possible class values " + this.allClasses.size());
		this.allDataProperties.addAll(this.getAllDataProperties());
		Logging.getQueryLogger().log(
				Level.FINE,
				"Possible data property values " + this.allDataProperties.size());
		this.allObjectProperties.addAll(this.getObjectProperties());
		Logging.getQueryLogger().log(
				Level.FINE,
				"Possible object property values " + this.allObjectProperties.size());
		this.allIndividuals.addAll(this.getAllIndividuals());
		Logging.getQueryLogger().log(
				Level.FINE,
				"Possible individual  values " + this.allIndividuals.size());
		this.allConstants.addAll(this.getAllConstants());
		Logging.getQueryLogger().log(
				Level.FINE,
				"Possible constant  values " + this.allConstants.size());
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	private Collection<OWLObjectProperty> getObjectProperties() {
		Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
		for (OWLOntology owlOntology : this.getConstraintSystem().getOntologyManager().getOntologies()) {
			toReturn.addAll(owlOntology.getObjectPropertiesInSignature());
		}
		return toReturn;
	}

	/**
	 * @see org.coode.oppl.search.SearchTree#exhaustiveSearchTree(java.lang.Object,
	 *      java.util.List)
	 */
	@Override
	public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
			List<List<OPPLOWLAxiomSearchNode>> solutions) {
		this.initAssignableValues();
		Set<BindingNode> existingLeaves = this.getConstraintSystem().getLeaves();
		boolean found = false;
		if (existingLeaves != null) {
			Logging.getQueryTestLogging().log(
					Level.INFO,
					"Existing leaves count: " + existingLeaves.size());
			int leafIndex = 1;
			for (BindingNode bindingNode : existingLeaves) {
				Logging.getQueryTestLogging().log(
						Level.FINER,
						"Exhaustive search on leaf: " + leafIndex++ + " out of "
								+ existingLeaves.size());
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), bindingNode, this.getRuntimeExceptionHandler());
				PartialOWLObjectInstantiator partialObjectInstantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom newStartAxiom = (OWLAxiom) start.getAxiom().accept(
						partialObjectInstantiator);
				VariableExtractor variableExtractor = new VariableExtractor(
						this.getConstraintSystem(), false);
				BindingNode newBindingNode = new BindingNode(bindingNode.getAssignments(),
						variableExtractor.extractVariables(newStartAxiom));
				OPPLOWLAxiomSearchNode newStart = new OPPLOWLAxiomSearchNode(newStartAxiom,
						newBindingNode);
				List<List<OPPLOWLAxiomSearchNode>> bindingNodeSolutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
				boolean bindingNodeSearch = super.exhaustiveSearchTree(
						newStart,
						bindingNodeSolutions);
				found = found || bindingNodeSearch;
				if (bindingNodeSearch) {
					solutions.addAll(bindingNodeSolutions);
				}
			}
		} else {
			found = super.exhaustiveSearchTree(start, solutions);
		}
		Set<BindingNode> newLeaves = new HashSet<BindingNode>();
		for (List<OPPLOWLAxiomSearchNode> path : solutions) {
			OPPLOWLAxiomSearchNode leafSerachNode = path.get(path.size() - 1);
			BindingNode newLeaf = leafSerachNode.getBinding();
			newLeaves.add(newLeaf);
		}
		// this.constraintSystem.setLeaves(newLeaves);
		return found;
	}

	/**
	 * @return the runtimeExceptionHandler
	 */
	public RuntimeExceptionHandler getRuntimeExceptionHandler() {
		return this.runtimeExceptionHandler;
	}
}
