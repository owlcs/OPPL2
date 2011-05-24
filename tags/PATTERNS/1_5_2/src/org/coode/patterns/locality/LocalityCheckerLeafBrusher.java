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
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.patterns.PatternModel;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 * 
 */
public class LocalityCheckerLeafBrusher implements BindingVisitor {
	private LocalityEvaluator evaluator;
	private final ConstraintSystem constraintSystem;
	private final PatternModel patternModel;
	private final RuntimeExceptionHandler handler;
	private final Set<OWLEntity> signature = new HashSet<OWLEntity>();
	private final Map<Variable<?>, SigmaPlusSigmaMinus> variableBindings = new HashMap<Variable<?>, SigmaPlusSigmaMinus>();
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
			Map<Variable<?>, SigmaPlusSigmaMinus> variableBindings, Set<OWLEntity> signature,
			RuntimeExceptionHandler runtimeExceptionHandler) {
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
		if (runtimeExceptionHandler == null) {
			throw new NullPointerException("The runtime exception handler cannot be null");
		}
		this.evaluator = evaluator;
		this.constraintSystem = constraintSystem;
		this.patternModel = patternModel;
		this.handler = runtimeExceptionHandler;
		this.signature.addAll(signature);
		this.variableBindings.putAll(variableBindings);
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
		ValueComputationParameters parameters = new SimpleValueComputationParameters(
				this.getConstraintSystem(), bindingNode, this.getHandler());
		PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(parameters);
		this.exploredBindings.add(bindingNode);
		List<OWLAxiomChange> changes = this.patternModel.getActions();
		boolean safe = true;
		for (int i = 0; i < changes.size(); i++) {
			OWLAxiom axiom = changes.get(i).getAxiom();
			OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instantiator);
			try {
				Set<OWLEntity> actualSignature = new HashSet<OWLEntity>(this.signature);
				for (SigmaPlusSigmaMinus s : this.variableBindings.values()) {
					actualSignature.add(s.getPlus());
				}
				if (!this.evaluator.isLocal(instantiatedAxiom, actualSignature)) {
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
		Set<Variable<?>> unassignedVariables = node.getUnassignedVariables();
		for (Variable<?> variable : unassignedVariables) {
			for (OWLObject owlObject : this.variableBindings.get(variable)) {
				Set<Variable<?>> childUnassignedVariables = new HashSet<Variable<?>>(
						unassignedVariables);
				childUnassignedVariables.remove(variable);
				Set<Assignment> childAssignements = new HashSet<Assignment>(node.getAssignments());
				childAssignements.add(new Assignment(variable, owlObject));
				BindingNode newNode = new BindingNode(childAssignements, childUnassignedVariables);
				toReturn.add(newNode);
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
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @return the handler
	 */
	public RuntimeExceptionHandler getHandler() {
		return this.handler;
	}
}
