package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.bindingtree.BindingNode;

public class SimpleValueComputationParameters implements
		ValueComputationParameters {
	private final ConstraintSystem constraintSystem;
	private final BindingNode bindingNode;
	private final OPPLAbstractFactory factory;

	/**
	 * @param constraintSystem
	 * @param bindingNode
	 * @param fact
	 */
	public SimpleValueComputationParameters(ConstraintSystem constraintSystem,
			BindingNode bindingNode, OPPLAbstractFactory factory) {
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		if (bindingNode == null) {
			throw new NullPointerException("The binding node cannot be null");
		}
		if (factory == null) {
			throw new NullPointerException("The factory cannot be null");
		}
		this.constraintSystem = constraintSystem;
		this.bindingNode = bindingNode;
		this.factory = factory;
	}

	public BindingNode getBindingNode() {
		return this.bindingNode;
	}

	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	public OPPLAbstractFactory getOPPLFactory() {
		return this.factory;
	}
}
