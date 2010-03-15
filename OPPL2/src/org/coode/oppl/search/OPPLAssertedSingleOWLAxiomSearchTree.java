/**
 *
 */
package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.PartialOWLObjectInstantiator;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.coode.oppl.variablemansyntax.bindingtree.Assignment;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CLASSVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CONSTANTVariable;
import org.coode.oppl.variablemansyntax.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variablemansyntax.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variablemansyntax.variabletypes.OBJECTPROPERTYVariable;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLAssertedSingleOWLAxiomSearchTree extends
		SearchTree<OPPLOWLAxiomSearchNode> {
	private final ConstraintSystem constraintSystem;
	private final OWLAxiom targetAxiom;
	// private final Set<OWLOntology> ontologies = new HashSet<OWLOntology>();
	private final Set<OWLClass> allClasses = new HashSet<OWLClass>();
	private final Set<OWLObjectProperty> allObjectProperties = new HashSet<OWLObjectProperty>();
	private final Set<OWLDataProperty> allDataProperties = new HashSet<OWLDataProperty>();
	private final Set<OWLIndividual> allIndividuals = new HashSet<OWLIndividual>();
	private final Set<OWLConstant> allConstants = new HashSet<OWLConstant>();

	public OPPLAssertedSingleOWLAxiomSearchTree(OWLAxiom targetAxiom,
			ConstraintSystem constraintSystem) {
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		this.targetAxiom = targetAxiom;
		this.constraintSystem = constraintSystem;
		this.initAssignableValues();
	}

	/**
	 * @see org.coode.oppl.search.SearchTree#getChildren(java.lang.Object)
	 */
	@Override
	protected List<OPPLOWLAxiomSearchNode> getChildren(
			OPPLOWLAxiomSearchNode node) {
		List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<OPPLOWLAxiomSearchNode>();
		VariableExtractor variableExtractor = new VariableExtractor(this
				.getConstraintSystem(), false);
		Set<Variable> variables = node.getAxiom().accept(variableExtractor);
		BindingNode binding = node.getBinding();
		for (Variable variable : variables) {
			Collection<OWLObject> values = new HashSet<OWLObject>(this
					.getAssignableValues(variable));
			for (OWLObject value : values) {
				Assignment assignment = new Assignment(variable, value);
				BindingNode childBinding = new BindingNode(binding
						.getAssignments(), binding.getUnassignedVariables());
				childBinding.addAssignment(assignment);
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						childBinding, this.getConstraintSystem());
				OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(
						instantiator);
				OPPLOWLAxiomSearchNode child = new OPPLOWLAxiomSearchNode(
						instantiatedAxiom, childBinding);
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
		return this.targetAxiom.equals(start.getAxiom());
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

		public Set<? extends OWLObject> visit(SingleValueGeneratedVariable<?> v) {
			// TODO this needs verification: is this the expected behaviour?
			Set<OWLObject> toReturn = new HashSet<OWLObject>();
			for (SingleValueGeneratedVariable<?> g : OPPLAssertedSingleOWLAxiomSearchTree.this.constraintSystem
					.getGeneratedVariables()) {
				toReturn.addAll(g.getPossibleBindings());
			}
			return toReturn;
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(
			Variable variable) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable.accept(this.assignableValuesVisitor));
		// VariableType type = variable.getType();
		// switch (type) {
		// case CLASS:
		// toReturn.addAll(this.allClasses);
		// break;
		// case DATAPROPERTY:
		// toReturn.addAll(this.allDataProperties);
		// break;
		// case OBJECTPROPERTY:
		// toReturn.addAll(this.allObjectProperties);
		// break;
		// case INDIVIDUAL:
		// toReturn.addAll(this.allIndividuals);
		// break;
		// case CONSTANT:
		// toReturn.addAll(this.allConstants);
		// break;
		// default:
		// break;
		// }
		return toReturn;
	}

	private void initAssignableValues() {
		this.allClasses.addAll(OWLObjectExtractor.getAllClasses(this
				.getTargetAxiom()));
		this.allDataProperties.addAll(OWLObjectExtractor
				.getAllOWLDataProperties(this.getTargetAxiom()));
		this.allObjectProperties.addAll(OWLObjectExtractor
				.getAllOWLObjectProperties(this.getTargetAxiom()));
		this.allIndividuals.addAll(OWLObjectExtractor.getAllOWLIndividuals(this
				.getTargetAxiom()));
		this.allConstants.addAll(OWLObjectExtractor.getAllOWLConstants(this
				.getTargetAxiom()));
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
		if (this.getTargetAxiom().getAxiomType().equals(
				start.getAxiom().getAxiomType())) {
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
