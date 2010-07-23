package org.coode.patterns.locality;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.PartialOWLObjectInstantiator;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.Assignment;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.bindingtree.BindingVisitor;
import org.coode.patterns.PatternModel;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 * 
 */
public class LocalityCheckerLeafBrusher implements BindingVisitor {
	private LocalityEvaluator evaluator;
	private ConstraintSystem constraintSystem;
	private PatternModel patternModel;
	private Set<OWLEntity> entities;
	private List<BindingNode> exploredBindings = new ArrayList<BindingNode>();

	public List<BindingNode> getExploredBindings() {
		return this.exploredBindings;
	}

	public List<Boolean> getExploredBindingsLocality() {
		return this.exploredBindingsLocality;
	}

	private List<Boolean> exploredBindingsLocality = new ArrayList<Boolean>();
	private List<OWLAxiom> foundNonLocals = new ArrayList<OWLAxiom>();

	public LocalityCheckerLeafBrusher(LocalityEvaluator evaluator,
			ConstraintSystem constraintSystem, PatternModel patternModel,
			Set<OWLEntity> entities) {
		this.evaluator = evaluator;
		this.constraintSystem = constraintSystem;
		this.patternModel = patternModel;
		this.entities = entities;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.bindingtree.BindingVisitor#visit(org.coode.oppl.variablemansyntax.bindingtree.BindingNode)
	 */
	public void visit(BindingNode bindingNode) {
		if (!bindingNode.isEmpty()) {
			Set<BindingNode> allLeaves = new HashSet<BindingNode>();
			List<BindingNode> nodes = new ArrayList<BindingNode>();
			nodes.add(bindingNode);
			while (nodes.size() > 0) {
				BindingNode node = nodes.remove(0);
				if (!node.isLeaf()) {
					nodes.addAll(this.generateChildren(node));
				} else {
					allLeaves.add(node);
				}
			}
			for (BindingNode node : allLeaves) {
				this.checkLocal(node);
			}
		}
	}

	private void checkLocal(BindingNode bindingNode) {
		// once found non local, stay non local
		// if (this.isLocal()) {
		PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
				bindingNode, this.constraintSystem);
		this.exploredBindings.add(bindingNode);
		List<OWLAxiomChange> changes = this.patternModel.getActions();
		boolean safe = true;
		for (int i = 0; i < changes.size(); i++) {
			OWLAxiom axiom = changes.get(i).getAxiom();
			OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
			try {
				if (!this.evaluator.isLocal(instantiatedAxiom, this.entities)) {
					this.foundNonLocals.add(instantiatedAxiom);
					safe = false;
				}
			} catch (OWLRuntimeException e) {
				e.printStackTrace();
				OWLAxiom ax = (OWLAxiom) axiom.accept(instantiator);
				throw e;
			}
		}
		this.exploredBindingsLocality.add(Boolean.valueOf(safe));
		// }
	}

	/**
	 * @return the leaves
	 */
	public boolean isLocal() {
		return this.foundNonLocals.size() == 0;
	}

	public List<OWLAxiom> getNonLocalAxioms() {
		return this.foundNonLocals;
	}

	private Set<BindingNode> generateChildren(BindingNode node) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		// if (!this.isLocal()) {
		// return toReturn;
		// }
		Set<Variable> unassignedVariables = node.getUnassignedVariables();
		for (Variable variable : unassignedVariables) {
			if (variable.getPossibleBindings().size() == 0) {
				System.out
						.println("LocalityCheckerLeafBrusher.generateChildren() no values for: "
								+ variable);
			} else {
				for (OWLObject owlObject : variable.getPossibleBindings()) {
					// OWLObject owlObject = variable.getPossibleBindings()
					// .iterator().next();
					Set<Variable> childUnassignedVariables = new HashSet<Variable>(
							unassignedVariables);
					childUnassignedVariables.remove(variable);
					Set<Assignment> childAssignements = new HashSet<Assignment>(
							node.getAssignments());
					childAssignements.add(new Assignment(variable, owlObject));
					BindingNode newNode = new BindingNode(childAssignements,
							childUnassignedVariables);
					toReturn.add(newNode);
				}
			}
		}
		return toReturn;
	}
}
