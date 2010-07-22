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

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
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
	private final OWLOntologyManager ontologyManager;
	private final ConstraintSystem constraintSystem;

	/**
	 * @param manager
	 * @param constraintSystem
	 */
	public OWLAxiomSearchTree(OWLOntologyManager manager, ConstraintSystem constraintSystem) {
		if (manager == null) {
			throw new NullPointerException("The manager cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		this.ontologyManager = manager;
		this.constraintSystem = constraintSystem;
	}

	@Override
	protected List<OWLAxiom> getChildren(OWLAxiom node) {
		Set<BindingNode> leaves = this.getConstraintSystem().getLeaves();
		List<OWLAxiom> toReturn = new ArrayList<OWLAxiom>();
		VariableExtractor variableExtractor = new VariableExtractor(this.getConstraintSystem(),
				false);
		Set<Variable> variables = variableExtractor.extractVariables(node);
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
				BindingNode bindingNode = new BindingNode(Collections.singleton(assignment),
						variables);
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
		Iterator<OWLOntology> iterator = this.getOntologyManager().getOntologies().iterator();
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
		return this.ontologyManager;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	private Set<OWLClass> getAllClasses() {
		Set<OWLClass> toReturn = new HashSet<OWLClass>();
		Set<OWLOntology> ontologies = this.getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedClasses());
		}
		return toReturn;
	}

	private Set<OWLConstant> getAllConstants() {
		Set<OWLConstant> toReturn = new HashSet<OWLConstant>();
		for (OWLOntology ontology : this.getOntologyManager().getOntologies()) {
			for (OWLAxiom axiom : ontology.getAxioms()) {
				toReturn.addAll(OWLObjectExtractor.getAllOWLConstants(axiom));
			}
		}
		return toReturn;
	}

	private Set<OWLDataProperty> getAllDataProperties() {
		Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
		Set<OWLOntology> ontologies = this.getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedDataProperties());
		}
		return toReturn;
	}

	private Set<OWLIndividual> getAllIndividuals() {
		Set<OWLIndividual> toReturn = new HashSet<OWLIndividual>();
		Set<OWLOntology> ontologies = this.getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedIndividuals());
		}
		return toReturn;
	}

	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {
		public Set<? extends OWLObject> visit(SingleValueGeneratedVariable<?> v) {
			return Collections.emptySet();
		}

		public Set<? extends OWLObject> visit(INDIVIDUALVariable v) {
			return OWLAxiomSearchTree.this.getAllIndividuals();
		}

		public Set<? extends OWLObject> visit(DATAPROPERTYVariable v) {
			return OWLAxiomSearchTree.this.getAllDataProperties();
		}

		public Set<? extends OWLObject> visit(OBJECTPROPERTYVariable v) {
			return OWLAxiomSearchTree.this.getObjectProperties();
		}

		public Set<? extends OWLObject> visit(CONSTANTVariable v) {
			return OWLAxiomSearchTree.this.getAllConstants();
		}

		public Set<? extends OWLObject> visit(CLASSVariable v) {
			return OWLAxiomSearchTree.this.getAllClasses();
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(Variable variable) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable.accept(new VariableVisitor<Set<? extends OWLObject>>() {
			public Set<? extends OWLObject> visit(Variable v) {
				return v.accept(OWLAxiomSearchTree.this.assignableValuesVisitor);
			}

			public Set<? extends OWLObject> visit(RegExpGenerated<?> v) {
				Set<OWLObject> toReturn = new HashSet<OWLObject>();
				Set<BindingNode> leaves = OWLAxiomSearchTree.this.getConstraintSystem().getLeaves();
				if (leaves == null) {
					leaves = Collections.singleton(BindingNode.getEmptyBindingNode());
				}
				for (BindingNode bindingNode : leaves) {
					toReturn.addAll(v.getGeneratedOWLObjectCollection(bindingNode));
				}
				return toReturn;
			}

			public Set<? extends OWLObject> visit(SingleValueGeneratedVariable<?> v) {
				return Collections.emptySet();
			}
		}));
		return toReturn;
	}

	private Set<OWLObjectProperty> getObjectProperties() {
		Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
		Set<OWLOntology> ontologies = this.getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getReferencedObjectProperties());
		}
		return toReturn;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	/**
	 * @return the assignableValuesVisitor
	 */
	public VariableTypeVisitorEx<Set<? extends OWLObject>> getAssignableValuesVisitor() {
		return this.assignableValuesVisitor;
	}
}
