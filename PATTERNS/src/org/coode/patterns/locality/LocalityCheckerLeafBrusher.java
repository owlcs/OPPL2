package org.coode.patterns.locality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.bindingtree.BindingVisitor;
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
	private final Set<OWLEntity> signature = new HashSet<OWLEntity>();
	private final Map<Variable, Set<OWLObject>> variableBindings = new HashMap<Variable, Set<OWLObject>>();
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
			Map<Variable, Set<OWLObject>> variableBindings, Set<OWLEntity> signature) {
		if (evaluator == null) {
			throw new NullPointerException("The evaluator cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (variableBindings == null) {
			throw new NullPointerException("The bindings cannot be null");
		}
		if (signature == null) {
			throw new NullPointerException("The signature cannot be null");
		}
		this.evaluator = evaluator;
		this.constraintSystem = constraintSystem;
		this.patternModel = patternModel;
		this.signature.addAll(signature);
	}

	/**
	 * @see org.coode.oppl.bindingtree.BindingVisitor#visit(org.coode.oppl.bindingtree.BindingNode)
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
		PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(bindingNode,
				this.constraintSystem);
		this.exploredBindings.add(bindingNode);
		List<OWLAxiomChange> changes = this.patternModel.getActions();
		boolean safe = true;
		for (int i = 0; i < changes.size(); i++) {
			OWLAxiom axiom = changes.get(i).getAxiom();
			OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
			try {
				if (!this.evaluator.isLocal(instantiatedAxiom, this.signature)) {
					this.foundNonLocals.add(instantiatedAxiom);
					safe = false;
				}
			} catch (OWLRuntimeException e) {
				e.printStackTrace();
				throw e;
			}
		}
		this.exploredBindingsLocality.add(Boolean.valueOf(safe));
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
		Set<Variable> unassignedVariables = node.getUnassignedVariables();
		for (Variable variable : unassignedVariables) {
			if (this.getVariableBindings().get(variable).size() == 0) {
				System.out.println("LocalityCheckerLeafBrusher.generateChildren() no values for: "
						+ variable);
			} else {
				for (OWLObject owlObject : this.getVariableBindings().get(variable)) {
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

	/**
	 * @return the signature
	 */
	public Set<OWLEntity> getSignature() {
		return new HashSet<OWLEntity>(this.signature);
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	public void setSignature(Collection<? extends OWLEntity> signature) {
		this.signature.clear();
		this.signature.addAll(signature);
	}

	/**
	 * @return the variableBindings
	 */
	public Map<Variable, Set<OWLObject>> getVariableBindings() {
		return this.variableBindings;
	}
}
