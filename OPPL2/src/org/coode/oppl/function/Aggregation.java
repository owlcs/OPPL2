package org.coode.oppl.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;

public abstract class Aggregation<O, I> extends AbstractOPPLFunction<O> implements OPPLFunction<O> {
	private final List<OPPLFunction<? extends I>> toAggreagte = new ArrayList<OPPLFunction<? extends I>>();

	public Aggregation(Collection<? extends OPPLFunction<? extends I>> toAggregate) {
		if (toAggregate == null) {
			throw new NullPointerException("The collection of elements to aggregate cannot be null");
		}
		if (toAggregate.isEmpty()) {
			throw new IllegalArgumentException(
					"The collection of elements to aggregate cannot be null");
		}
		this.toAggreagte.addAll(toAggregate);
	}

	protected abstract O aggregate(ValueComputationParameters parameters);

	/**
	 * @return the toAggreagte
	 */
	public List<OPPLFunction<? extends I>> getToAggreagte() {
		return this.toAggreagte;
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitAggregation(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitAggregation(this);
	}

	@Override
	public ValueComputation<O> getValueComputation(final ValueComputationParameters parameters) {
		return new ValueComputation<O>() {
			public O compute(OPPLFunction<? extends O> opplFunction) {
				return Aggregation.this.aggregate(parameters);
			}
		};
	}

	public static Aggregation<String, String> buildStringConcatenation(
			Collection<? extends OPPLFunction<String>> toAggregate) {
		return new Aggregation<String, String>(toAggregate) {
			@Override
			protected String aggregate(ValueComputationParameters params) {
				StringBuilder out = new StringBuilder();
				for (OPPLFunction<? extends String> value : this.getToAggreagte()) {
					out.append(value.compute(params));
				}
				return out.toString();
			}

			public String render(ConstraintSystem constraintSystem) {
				return this.renderAggregation(
						constraintSystem,
						this.getToAggreagte(),
						"",
						"",
						"+",
						"");
			}
		};
	}

	public static Aggregation<OWLClassExpression, OWLClassExpression> buildClassExpressionIntersection(
			Collection<? extends OPPLFunction<? extends OWLClassExpression>> toAggregate,
			final OWLDataFactory dataFactory) {
		return new Aggregation<OWLClassExpression, OWLClassExpression>(toAggregate) {
			@Override
			protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
				Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
				for (OPPLFunction<? extends OWLClassExpression> opplFunction : this.getToAggreagte()) {
					operands.add(opplFunction.compute(parameters));
				}
				return dataFactory.getOWLObjectIntersectionOf(operands);
			}

			public String render(ConstraintSystem constraintSystem) {
				return this.renderAggregation(
						constraintSystem,
						this.getToAggreagte(),
						"createIntersection",
						"(",
						",",
						")");
			}
		};
	}

	public static Aggregation<OWLClassExpression, OWLClassExpression> buildClassExpressionUnion(
			Collection<? extends OPPLFunction<? extends OWLClassExpression>> toAggregate,
			final OWLDataFactory dataFactory) {
		return new Aggregation<OWLClassExpression, OWLClassExpression>(toAggregate) {
			@Override
			protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
				Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
				for (OPPLFunction<? extends OWLClassExpression> opplFunction : this.getToAggreagte()) {
					operands.add(opplFunction.compute(parameters));
				}
				return dataFactory.getOWLObjectUnionOf(operands);
			}

			public String render(ConstraintSystem constraintSystem) {
				return this.renderAggregation(
						constraintSystem,
						this.getToAggreagte(),
						"createUnion",
						"(",
						",",
						")");
			}
		};
	}

	/**
	 * @param constraintSystem
	 * @param prefix
	 * @param openDelimiter
	 * @param separator
	 * @param closedDelimiter
	 * @return
	 */
	protected String renderAggregation(ConstraintSystem constraintSystem,
			Collection<? extends OPPLFunction<?>> objects, String prefix, String openDelimiter,
			String separator, String closedDelimiter) {
		Iterator<? extends OPPLFunction<?>> i = objects.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s%s", prefix, openDelimiter));
		while (i.hasNext()) {
			OPPLFunction<?> e = i.next();
			sb.append(e.render(constraintSystem));
			if (i.hasNext()) {
				sb.append(separator);
			}
		}
		sb.append(closedDelimiter);
		return sb.toString();
	}
}
