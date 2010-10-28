package org.coode.oppl.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Aggregation<O> extends AbstractOPPLFunction<O> implements OPPLFunction<O> {
	private final List<OPPLFunction<O>> toAggreagte = new ArrayList<OPPLFunction<O>>();

	public Aggregation(Collection<? extends OPPLFunction<String>> toAggregate) {
	}

	protected abstract O aggregate(ValueComputation<O> valueComputation);

	/**
	 * @return the toAggreagte
	 */
	public List<OPPLFunction<O>> getToAggreagte() {
		return this.toAggreagte;
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitAggregation(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitAggregation(this);
	}

	public static Aggregation<String> buildStringConcatenation(
			Collection<? extends OPPLFunction<String>> toAggregate) {
		return new Aggregation<String>(toAggregate) {
			@Override
			protected String aggregate(ValueComputation<String> valueComputation) {
				StringBuilder out = new StringBuilder();
				for (OPPLFunction<String> value : this.getToAggreagte()) {
					out.append(valueComputation.compute(value));
				}
				return out.toString();
			}
		};
	}
}
