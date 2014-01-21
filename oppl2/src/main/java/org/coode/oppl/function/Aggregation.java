package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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

/** @author Luigi Iannone
 * @param <O>
 *            function type
 * @param <I>
 *            type */
public abstract class Aggregation<O, I> extends AbstractOPPLFunction<O> implements
        OPPLFunction<O> {
    protected final List<Aggregandum<I>> toAggregate = new ArrayList<Aggregandum<I>>();

    /** @param toAggregate
     *            toAggregate */
    public Aggregation(Collection<? extends Aggregandum<I>> toAggregate) {
        this.toAggregate.addAll(checkNotNull(toAggregate, "toAggregate"));
        if (toAggregate.isEmpty()) {
            throw new IllegalArgumentException(
                    "The collection of elements to aggregate cannot be null");
        }
    }

    protected abstract O aggregate(ValueComputationParameters parameters);

    /** @return the toAggreagte */
    public List<Aggregandum<I>> getToAggregate() {
        // Defensive copy
        return new ArrayList<Aggregandum<I>>(this.toAggregate);
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

    /** @param a
     *            a
     * @return string concatenation aggregation */
    public static Aggregation<String, String> buildStringConcatenation(
            Collection<? extends Aggregandum<String>> a) {
        return new StringConcatAggregation(a);
    }

    /** @param a
     *            a
     * @param dataFactory
     *            dataFactory
     * @return class expression intersection aggregation */
    public static
            Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>>
            buildClassExpressionIntersection(
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> a,
                    OWLDataFactory dataFactory) {
        return new ClassIntersectionAggregation(a, dataFactory);
    }

    /** @param a
     *            a
     * @param dataFactory
     *            dataFactory
     * @return class expression union aggregation */
    public static
            Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>>
            buildClassExpressionUnion(
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> a,
                    OWLDataFactory dataFactory) {
        return new ClassUnionAggregation(a, dataFactory);
    }

    /** @param constraintSystem
     *            constraintSystem
     * @param prefix
     *            prefix
     * @param openDelimiter
     *            openDelimiter
     * @param separator
     *            separator
     * @param closedDelimiter
     *            closedDelimiter
     * @return rendering */
    protected String renderAggregation(ConstraintSystem constraintSystem, String prefix,
            String openDelimiter, String separator, String closedDelimiter) {
        Iterator<Aggregandum<I>> i = toAggregate.iterator();
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
        Iterator<Aggregandum<I>> i = this.toAggregate.iterator();
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

class StringConcatAggregation extends Aggregation<String, String> {
    StringConcatAggregation(Collection<? extends Aggregandum<String>> toAggregate) {
        super(toAggregate);
    }

    @Override
    protected String aggregate(ValueComputationParameters params) {
        StringBuilder out = new StringBuilder();
        for (Aggregandum<? extends String> aggregandum : toAggregate) {
            for (OPPLFunction<? extends String> value : aggregandum.getOPPLFunctions()) {
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
}

class ClassUnionAggregation extends
        Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>> {
    private final OWLDataFactory dataFactory;

    ClassUnionAggregation(
            Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> toAggregate,
            OWLDataFactory dataFactory) {
        super(toAggregate);
        this.dataFactory = dataFactory;
    }

    @Override
    protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
        Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
        for (Aggregandum<? extends Collection<? extends OWLClassExpression>> aggregandum : toAggregate) {
            for (OPPLFunction<? extends Collection<? extends OWLClassExpression>> opplFunction : aggregandum
                    .getOPPLFunctions()) {
                Collection<? extends OWLClassExpression> compute = opplFunction
                        .compute(parameters);
                if (compute != null) {
                    operands.addAll(compute);
                }
            }
        }
        return operands.isEmpty() ? null : dataFactory.getOWLObjectUnionOf(operands);
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return this.renderAggregation(constraintSystem, "createUnion", "(", ", ", ")");
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return this.renderAggregation(shortFormProvider, "createUnion", "(", ", ", ")");
    }
}

class ClassIntersectionAggregation extends
        Aggregation<OWLClassExpression, Collection<? extends OWLClassExpression>> {
    private final OWLDataFactory dataFactory;

    ClassIntersectionAggregation(
            Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> toAggregate,
            OWLDataFactory dataFactory) {
        super(toAggregate);
        this.dataFactory = dataFactory;
    }

    @Override
    protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
        Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
        for (Aggregandum<Collection<? extends OWLClassExpression>> aggregandum : toAggregate) {
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
        return this.renderAggregation(constraintSystem, "createIntersection", "(", ", ",
                ")");
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return this.renderAggregation(shortFormProvider, "createIntersection", "(", ", ",
                ")");
    }
}
