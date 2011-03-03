/**
 * 
 */
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
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class AssertedAxiomPlannerItem extends AbstractQueryPlannerItem {
	private final OWLAxiom axiom;

	/**
	 * @param constraintSystem
	 * @param axiom
	 */
	public AssertedAxiomPlannerItem(ConstraintSystem constraintSystem, OWLAxiom axiom) {
		super(constraintSystem);
		if (axiom == null) {
			throw new NullPointerException("The axiom cannot be null");
		}
		this.axiom = axiom;
	}

	/**
	 * @see org.coode.oppl.queryplanner.QueryPlannerItem#match(java.util.Collection,
	 *      org.coode.oppl.exceptions.RuntimeExceptionHandler)
	 */
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
				Set<BindingNode> newLeaves = this.updateBindingsAssertedAxiom(
						instantiatedAxiom,
						runtimeExceptionHandler);
				toReturn.addAll(this.merge(bindingNode, newLeaves));
			}
		} else {
			toReturn.addAll(this.updateBindingsAssertedAxiom(
					this.getAxiom(),
					runtimeExceptionHandler));
		}
		return toReturn;
	}

	private Set<BindingNode> updateBindingsAssertedAxiom(OWLAxiom axiom,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		assert axiom != null;
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		Logging.getQueryLogger().log(
				Level.FINE,
				"Initial size: "
						+ (this.getConstraintSystem().getLeaves() == null ? "empty"
								: this.getConstraintSystem().getLeaves().size()));
		AxiomQuery query = new AssertedSolvabilityBasedAxiomQuery(
				this.getConstraintSystem().getOntologyManager().getOntologies(),
				this.getConstraintSystem(), runtimeExceptionHandler);
		axiom.accept(query);
		toReturn.addAll(query.getLeaves());
		return toReturn;
	}

	/**
	 * @see org.coode.oppl.queryplanner.QueryPlannerItem#accept(org.coode.oppl.
	 *      queryplanner.QueryPlannerVisitor)
	 */
	public void accept(QueryPlannerVisitor visitor) {
		visitor.visitAssertedAxiomPlannerItem(this);
	}

	/**
	 * @see org.coode.oppl.queryplanner.QueryPlannerItem#accept(org.coode.oppl.
	 *      queryplanner.QueryPlannerVisitorEx)
	 */
	public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
		return visitor.visitAssertedAxiomPlannerItem(this);
	}

	/**
	 * @return the axiom
	 */
	public OWLAxiom getAxiom() {
		return this.axiom;
	}

	@Override
	public String toString() {
		ManchesterSyntaxRenderer renderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
				this.getConstraintSystem());
		this.getAxiom().accept(renderer);
		return String.format("ASSERTED %s ", renderer.toString());
	}
}
