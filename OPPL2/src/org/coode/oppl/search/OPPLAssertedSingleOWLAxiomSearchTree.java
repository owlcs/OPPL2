/**
 *
 */
package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLAssertedSingleOWLAxiomSearchTree extends SearchTree<OPPLOWLAxiomSearchNode> {
	private final ConstraintSystem constraintSystem;
	private final OWLAxiom targetAxiom;
	private final Set<OWLClass> allClasses = new HashSet<OWLClass>();
	private final Set<OWLObjectProperty> allObjectProperties = new HashSet<OWLObjectProperty>();
	private final Set<OWLDataProperty> allDataProperties = new HashSet<OWLDataProperty>();
	private final Set<OWLIndividual> allIndividuals = new HashSet<OWLIndividual>();
	private final Set<OWLLiteral> allConstants = new HashSet<OWLLiteral>();

	public OPPLAssertedSingleOWLAxiomSearchTree(OWLAxiom targetAxiom,
			ConstraintSystem constraintSystem) {
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		this.targetAxiom = targetAxiom;
		this.constraintSystem = constraintSystem;
		this.initAssignableValues();
	}

	/**
	 * @see org.coode.oppl.search.SearchTree#getChildren(java.lang.Object)
	 */
	@Override
	protected List<OPPLOWLAxiomSearchNode> getChildren(OPPLOWLAxiomSearchNode node) {
		List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<OPPLOWLAxiomSearchNode>();
		VariableExtractor variableExtractor = new VariableExtractor(this.getConstraintSystem(),
				false);
		Set<Variable> variables = variableExtractor.extractVariables(node.getAxiom());
		BindingNode binding = node.getBinding();
		for (Variable variable : variables) {
			Collection<OWLObject> values = new HashSet<OWLObject>(
					this.getAssignableValues(variable));
			for (OWLObject value : values) {
				Assignment assignment = new Assignment(variable, value);
				BindingNode childBinding = new BindingNode(binding.getAssignments(),
						binding.getUnassignedVariables());
				childBinding.addAssignment(assignment);
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), childBinding);
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(instantiator);
				OPPLOWLAxiomSearchNode child = new OPPLOWLAxiomSearchNode(instantiatedAxiom,
						childBinding);
				toReturn.add(child);
			}
		}
		return toReturn;
	}

	/**
	 * @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
	 *         represents an OWLAxiom that is equal to the target axiom.
	 * @see org.coode.oppl.search.SearchTree#goalReached(java.lang.Object)
	 */
	@Override
	protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
		return this.targetAxiom.getAxiomWithoutAnnotations().equals(start.getAxiom());
	}

	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {
		public Set<? extends OWLObject> visit(INDIVIDUALVariable v) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allIndividuals;
		}

		public Set<? extends OWLObject> visit(DATAPROPERTYVariable v) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allDataProperties;
		}

		public Set<? extends OWLObject> visit(OBJECTPROPERTYVariable v) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allObjectProperties;
		}

		public Set<? extends OWLObject> visit(CONSTANTVariable v) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allConstants;
		}

		public Set<? extends OWLObject> visit(CLASSVariable v) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allClasses;
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(Variable variable) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable.accept(this.assignableValuesVisitor));
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
		this.allClasses.addAll(OWLObjectExtractor.getAllClasses(this.getTargetAxiom()));
		this.allDataProperties.addAll(OWLObjectExtractor.getAllOWLDataProperties(this.getTargetAxiom()));
		this.allObjectProperties.addAll(OWLObjectExtractor.getAllOWLObjectProperties(this.getTargetAxiom()));
		this.allIndividuals.addAll(OWLObjectExtractor.getAllOWLIndividuals(this.getTargetAxiom()));
		this.allConstants.addAll(OWLObjectExtractor.getAllOWLLiterals(this.getTargetAxiom()));
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @see org.coode.oppl.search.SearchTree#exhaustiveSearchTree(java.lang.Object,
	 *      java.util.List)
	 */
	@Override
	public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
			List<List<OPPLOWLAxiomSearchNode>> solutions) {
		if (start == null) {
			throw new NullPointerException("The starting node cannot be null");
		}
		if (solutions == null) {
			throw new NullPointerException(
					"The list on which solutions will be stored cannot be null");
		}
		boolean found = false;
		if (this.getTargetAxiom().getAxiomType().equals(start.getAxiom().getAxiomType())) {
			found = super.exhaustiveSearchTree(start, solutions);
		}
		return found;
	}

	/**
	 * @return the targetAxiom
	 */
	public OWLAxiom getTargetAxiom() {
		return this.targetAxiom;
	}
}
