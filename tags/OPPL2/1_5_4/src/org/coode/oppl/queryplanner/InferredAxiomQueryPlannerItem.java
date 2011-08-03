package org.coode.oppl.queryplanner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.log.Logging;
import org.coode.oppl.querymatching.AssertedSolvabilityBasedAxiomQuery;
import org.coode.oppl.querymatching.AxiomQuery;
import org.coode.oppl.querymatching.InferredSolvabilityBasedTreeSearchAxiomQuery;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLRuntimeException;

public class InferredAxiomQueryPlannerItem extends AbstractQueryPlannerItem {
	private final OWLAxiom axiom;

	/**
	 * @param constraintSystem
	 * @param axiom
	 */
	public InferredAxiomQueryPlannerItem(ConstraintSystem constraintSystem, OWLAxiom axiom) {
		super(constraintSystem);
		if (axiom == null) {
			throw new NullPointerException("The axiom cannot be null");
		}
		this.axiom = axiom;
	}

	/**
	 * @return the axiom
	 */
	public OWLAxiom getAxiom() {
		return this.axiom;
	}

	public Set<BindingNode> match(Collection<? extends BindingNode> currentLeaves,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		if (currentLeaves != null) {
			for (BindingNode bindingNode : currentLeaves) {
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), bindingNode, runtimeExceptionHandler);
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom instantiatedAxiom = (OWLAxiom) this.getAxiom().accept(instantiator);
				Set<BindingNode> newLeaves = this.updateBindings(
						instantiatedAxiom,
						runtimeExceptionHandler);
				toReturn.addAll(this.merge(bindingNode, newLeaves));
			}
		} else {
			toReturn.addAll(this.updateBindings(this.getAxiom(), runtimeExceptionHandler));
		}
		return toReturn;
	}

	private Set<BindingNode> updateBindings(OWLAxiom axiom,
			RuntimeExceptionHandler runtimeExceptionHandler) throws OWLRuntimeException {
		assert axiom != null;
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		Logging.getQueryLogger().log(
				Level.INFO,
				"Initial size: "
						+ (this.getConstraintSystem().getLeaves() == null ? "empty"
								: this.getConstraintSystem().getLeaves().size()));
		AxiomQuery query = this.getConstraintSystem().getReasoner() == null
				|| !axiom.isLogicalAxiom() ? new AssertedSolvabilityBasedAxiomQuery(
				this.getConstraintSystem().getOntologyManager().getOntologies(),
				this.getConstraintSystem(), runtimeExceptionHandler)
				: new InferredSolvabilityBasedTreeSearchAxiomQuery(this.getConstraintSystem(),
						runtimeExceptionHandler);
		Logging.getQueryTestLogging().log(Level.INFO, "Used engine: " + query.getClass().getName());
		axiom.accept(query);
		toReturn.addAll(query.getLeaves());
		return toReturn;
	}

	public void accept(QueryPlannerVisitor visitor) {
		visitor.visitInferredAxiomQueryPlannerItem(this);
	}

	public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
		return visitor.visitInferredAxiomQueryPlannerItem(this);
	}

	@Override
	public String toString() {
		ManchesterSyntaxRenderer renderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
				this.getConstraintSystem());
		this.getAxiom().accept(renderer);
		return String.format("INFERRED %s ", renderer.toString());
	}
}
