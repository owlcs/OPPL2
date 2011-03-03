/**
 * 
 */
package org.coode.oppl.queryplanner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.querymatching.ConstraintChecker;

/**
 * @author Luigi Iannone
 * 
 */
public class ConstraintQueryPlannerItem extends AbstractQueryPlannerItem {
	private final AbstractConstraint constraint;

	/**
	 * @param constraintSystem
	 * @param constraint
	 */
	public ConstraintQueryPlannerItem(ConstraintSystem constraintSystem,
			AbstractConstraint constraint) {
		super(constraintSystem);
		if (constraint == null) {
			throw new NullPointerException("The constraint cannot be null");
		}
		this.constraint = constraint;
	}

	/**
	 * @see org.coode.oppl.queryplanner.QueryPlannerItem#match(java.util.Collection,
	 *      org.coode.oppl.exceptions.RuntimeExceptionHandler)
	 */
	public Set<BindingNode> match(Collection<? extends BindingNode> currentLeaves,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		if (currentLeaves != null && !currentLeaves.isEmpty()) {
			Iterator<? extends BindingNode> it = currentLeaves.iterator();
			BindingNode leaf;
			while (it.hasNext()) {
				leaf = it.next();
				boolean holdingLeaf = this.checkConstraint(
						leaf,
						this.getConstraint(),
						runtimeExceptionHandler);
				if (!holdingLeaf) {
					it.remove();
				}
			}
		}
		return new HashSet<BindingNode>(currentLeaves);
	}

	private boolean checkConstraint(BindingNode leaf, AbstractConstraint c,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		boolean hold = true;
		ValueComputationParameters parameters = new SimpleValueComputationParameters(
				this.getConstraintSystem(), leaf, runtimeExceptionHandler);
		ConstraintChecker constraintChecker = new ConstraintChecker(parameters);
		hold = c.accept(constraintChecker);
		return hold;
	}

	/**
	 * @see org.coode.oppl.queryplanner.QueryPlannerItem#accept(org.coode.oppl.
	 *      queryplanner.QueryPlannerVisitor)
	 */
	public void accept(QueryPlannerVisitor visitor) {
		visitor.visitConstraintQueryPlannerItem(this);
	}

	/**
	 * @see org.coode.oppl.queryplanner.QueryPlannerItem#accept(org.coode.oppl.
	 *      queryplanner.QueryPlannerVisitorEx)
	 */
	public <O> O accept(QueryPlannerVisitorEx<O> visitor) {
		return visitor.visitConstraintQueryPlannerItem(this);
	}

	/**
	 * @return the constraint
	 */
	public AbstractConstraint getConstraint() {
		return this.constraint;
	}

	@Override
	public String toString() {
		return this.getConstraint().render(this.getConstraintSystem());
	}
}
