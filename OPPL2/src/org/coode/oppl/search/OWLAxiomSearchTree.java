/**
 *
 */
package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class OWLAxiomSearchTree extends SearchTree<OWLAxiom> {
	private final OWLOntologyManager manager;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param manager
	 * @param constraintSystem
	 */
	public OWLAxiomSearchTree(OWLOntologyManager manager,
			ConstraintSystem constraintSystem) {
		if (manager == null) {
			throw new NullPointerException("The manager cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		this.manager = manager;
		this.constraintSystem = constraintSystem;
	}

	@Override
	protected List<OWLAxiom> getChildren(OWLAxiom node) {
		Set<BindingNode> leaves = this.getConstraintSystem().getLeaves();
		List<OWLAxiom> toReturn = new ArrayList<OWLAxiom>();
		VariableExtractor variableExtractor = new VariableExtractor(this
				.getConstraintSystem(), false);
		Set<Variable> variables = node.accept(variableExtractor);
		for (Variable variable : variables) {
			Collection<OWLObject> values = new HashSet<OWLObject>();
			if (leaves == null) {
				values.addAll(this.getAssignableValues(variable));
			} else {
				for (BindingNode bindingNode : leaves) {
					if (bindingNode.getAssignedVariables().contains(variable)) {
						values.add(bindingNode.getAssignmentValue(variable));
					} else {
						values.addAll(this.getAssignableValues(variable));
					}
				}
			}
			for (OWLObject value : values) {
				Assignment assignment = new Assignment(variable, value);
				BindingNode bindingNode = new BindingNode(Collections
						.singleton(assignment), variables);
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						bindingNode, this.getConstraintSystem());
				toReturn.add((OWLAxiom) node.accept(instantiator));
			}
		}
		return toReturn;
	}

	@Override
	protected boolean goalReached(OWLAxiom start) {
		boolean found = false;
		Iterator<OWLOntology> iterator = this.manager.getOntologies()
				.iterator();
		while (!found && iterator.hasNext()) {
			OWLOntology ontology = iterator.next();
			found = ontology.containsAxiom(start);
		}
		return found;
	}

	/**
	 * @return the manager
	 */
	public OWLOntologyManager getManager() {
		return this.manager;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	private Collection<? extends OWLObject> getAllClasses() {
		Set<OWLClass> toReturn = new HashSet<OWLClass>();
		Set<OWLOntology> ontologies = this.manager.getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedClasses());
		}
		return toReturn;
	}

	private Collection<? extends OWLObject> getAllConstants() {
		return Collections.emptySet();
	}

	private Collection<? extends OWLObject> getAllDataProperties() {
		Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
		Set<OWLOntology> ontologies = this.manager.getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedDataProperties());
		}
		return toReturn;
	}

	private Collection<? extends OWLObject> getAllIndividuals() {
		Set<OWLIndividual> toReturn = new HashSet<OWLIndividual>();
		Set<OWLOntology> ontologies = this.manager.getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedIndividuals());
		}
		return toReturn;
	}

	private final VariableTypeVisitorEx<Collection<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Collection<? extends OWLObject>>() {
		public Collection<? extends OWLObject> visit(
				SingleValueGeneratedVariable<?> v) {
			return v.getPossibleBindings();
		}

		public Collection<? extends OWLObject> visit(INDIVIDUALVariable v) {
			return OWLAxiomSearchTree.this.getAllIndividuals();
		}

		public Collection<? extends OWLObject> visit(DATAPROPERTYVariable v) {
			return OWLAxiomSearchTree.this.getAllDataProperties();
		}

		public Collection<? extends OWLObject> visit(OBJECTPROPERTYVariable v) {
			return OWLAxiomSearchTree.this.getObjectProperties();
		}

		public Collection<? extends OWLObject> visit(CONSTANTVariable v) {
			return OWLAxiomSearchTree.this.getAllConstants();
		}

		public Collection<? extends OWLObject> visit(CLASSVariable v) {
			return OWLAxiomSearchTree.this.getAllClasses();
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(
			Variable variable) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable.accept(this.assignableValuesVisitor));
		// VariableType type = variable.getType();
		// switch (type) {
		// case CLASS:
		// toReturn.addAll(this.getAllClasses());
		// break;
		// case DATAPROPERTY:
		// toReturn.addAll(this.getAllDataProperties());
		// break;
		// case OBJECTPROPERTY:
		// toReturn.addAll(this.getObjectProperties());
		// break;
		// case INDIVIDUAL:
		// toReturn.addAll(this.getAllIndividuals());
		// break;
		// case CONSTANT:
		// toReturn.addAll(this.getAllConstants());
		// break;
		// default:
		// break;
		// }
		return toReturn;
	}

	private Collection<? extends OWLObject> getObjectProperties() {
		Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
		Set<OWLOntology> ontologies = this.manager.getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedObjectProperties());
		}
		return toReturn;
	}
}
