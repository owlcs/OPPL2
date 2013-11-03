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
import org.semanticweb.owlapi.util.ShortFormProvider;

public abstract class Aggregation<O, I> extends AbstractOPPLFunction<O> implements
        OPPLFunction<O> {
    private final List<Aggregandum<I>> toAggreagte = new ArrayList<Aggregandum<I>>();

    public Aggregation(Collection<? extends Aggregandum<I>> toAggregate) {
        if (toAggregate == null) {
            throw new NullPointerException(
                    "The collection of elements to aggregate cannot be null");
        }
        if (toAggregate.isEmpty()) {
            throw new IllegalArgumentException(
                    "The collection of elements to aggregate cannot be null");
        }
        this.toAggreagte.addAll(toAggregate);
    }

    protected abstract O aggregate(ValueComputationParameters parameters);

    /** @return the toAggreagte */
    public List<Aggregandum<I>> getToAggreagte() {
        // Defensive copy
        return new ArrayList<Aggregandum<I>>(this.toAggreagte);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitAggregation(this);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitAggregation(this);
    }

    @Override
    public ValueComputation<O> getValueComputation(
            final ValueComputationParameters parameters) {
        return new ValueComputation<O>() {
            @Override
            public O compute(OPPLFunction<? extends O> opplFunction) {
                return Aggregation.this.aggregate(parameters);
            }
        };
    }

    public static Aggregation<String, String> buildStringConcatenation(
            Collection<? extends Aggregandum<String>> toAggregate) {
        return new Aggregation<String, String>(toAggregate) {
            @Override
            protected String aggregate(ValueComputationParameters params) {
                StringBuilder out = new StringBuilder();
                for (Aggregandum<? extends String> aggregandum : getToAggreagte()) {
                    for (OPPLFunction<? extends String> value : aggregandum
                            .getOPPLFunctions()) {
                        out.append(value.compute(params));
                    }
                }
                return out.toString();
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return this.renderAggregation(constraintSystem, "", "", "+", "");
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return this.renderAggregation(shortFormProvider, "", "", "+", "");
            }
        };
    }

    public static
            Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>>
            buildClassExpressionIntersection(
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> toAggregate,
                    final OWLDataFactory dataFactory) {
        return new Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>>(
                toAggregate) {
            @Override
            protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
                Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
                for (Aggregandum<Collection<? extends OWLClassExpression>> aggregandum : getToAggreagte()) {
                    for (OPPLFunction<Collection<? extends OWLClassExpression>> opplFunction : aggregandum
                            .getOPPLFunctions()) {
                        Collection<? extends OWLClassExpression> compute = opplFunction
                                .compute(parameters);
                        if (compute != null) {
                            operands.addAll(compute);
                        }
                    }
                }
                return operands.isEmpty() ? null : dataFactory
                        .getOWLObjectIntersectionOf(operands);
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return this.renderAggregation(constraintSystem, "createIntersection",
                        "(", ", ", ")");
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return this.renderAggregation(shortFormProvider, "createIntersection",
                        "(", ", ", ")");
            }
        };
    }

    public static
            Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>>
            buildClassExpressionUnion(
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> toAggregate,
                    final OWLDataFactory dataFactory) {
        return new Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>>(
                toAggregate) {
            @Override
            protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
                Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
                for (Aggregandum<? extends Collection<? extends OWLClassExpression>> aggregandum : getToAggreagte()) {
                    for (OPPLFunction<? extends Collection<? extends OWLClassExpression>> opplFunction : aggregandum
                            .getOPPLFunctions()) {
                        Collection<? extends OWLClassExpression> compute = opplFunction
                                .compute(parameters);
                        if (compute != null) {
                            operands.addAll(compute);
                        }
                    }
                }
                return operands.isEmpty() ? null : dataFactory
                        .getOWLObjectUnionOf(operands);
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return this.renderAggregation(constraintSystem, "createUnion", "(", ", ",
                        ")");
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return this.renderAggregation(shortFormProvider, "createUnion", "(",
                        ", ", ")");
            }
        };
    }

    /** @param constraintSystem
     * @param prefix
     * @param openDelimiter
     * @param separator
     * @param closedDelimiter
     * @return */
    protected String renderAggregation(ConstraintSystem constraintSystem, String prefix,
            String openDelimiter, String separator, String closedDelimiter) {
        Iterator<Aggregandum<I>> i = this.getToAggreagte().iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%s", prefix, openDelimiter));
        while (i.hasNext()) {
            Aggregandum<? extends I> aggregation = i.next();
            Iterator<? extends OPPLFunction<?>> iterator = aggregation.getOPPLFunctions()
                    .iterator();
            while (iterator.hasNext()) {
                OPPLFunction<?> opplFunction = iterator.next();
                sb.append(opplFunction.render(constraintSystem));
                if (iterator.hasNext()) {
                    sb.append(separator);
                }
            }
            if (i.hasNext()) {
                sb.append(separator);
            }
        }
        sb.append(closedDelimiter);
        return sb.toString();
    }

    protected String
            renderAggregation(ShortFormProvider shortFormProvider, String prefix,
                    String openDelimiter, String separator, String closedDelimiter) {
        Iterator<Aggregandum<I>> i = this.getToAggreagte().iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%s", prefix, openDelimiter));
        while (i.hasNext()) {
            Aggregandum<? extends I> aggregation = i.next();
            Iterator<? extends OPPLFunction<?>> iterator = aggregation.getOPPLFunctions()
                    .iterator();
            while (iterator.hasNext()) {
                OPPLFunction<?> opplFunction = iterator.next();
                sb.append(opplFunction.render(shortFormProvider));
                if (iterator.hasNext()) {
                    sb.append(separator);
                }
            }
            if (i.hasNext()) {
                sb.append(separator);
            }
        }
        sb.append(closedDelimiter);
        return sb.toString();
    }
}
