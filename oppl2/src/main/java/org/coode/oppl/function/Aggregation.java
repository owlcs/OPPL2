package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.coode.oppl.ConstraintSystem;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 * @param <O> function type
 * @param <I> type
 */
public abstract class Aggregation<O, I> extends AbstractOPPLFunction<O> implements OPPLFunction<O> {

    protected final List<Aggregandum<I>> toAggregate = new ArrayList<>();

    /**
     * @param toAggregate toAggregate
     */
    public Aggregation(Collection<? extends Aggregandum<I>> toAggregate) {
        this.toAggregate.addAll(checkNotNull(toAggregate, "toAggregate"));
        if (toAggregate.isEmpty()) {
            throw new IllegalArgumentException(
                "The collection of elements to aggregate cannot be null");
        }
    }

    protected abstract O aggregate(ValueComputationParameters parameters);

    /**
     * @return the toAggreagte
     * @deprecated use the stream version
     */
    @Deprecated
    public List<Aggregandum<I>> getToAggregate() {
        // Defensive copy
        return new ArrayList<>(this.toAggregate);
    }

    /**
     * @return the toAggreagte
     */
    public Stream<Aggregandum<I>> toAggregate() {
        return this.toAggregate.stream();
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
    public ValueComputation<O> getValueComputation(final ValueComputationParameters parameters) {
        return opplFunction -> Aggregation.this.aggregate(parameters);
    }

    /**
     * @param a a
     * @return string concatenation aggregation
     */
    public static Aggregation<String, String> buildStringConcatenation(
        Collection<? extends Aggregandum<String>> a) {
        return new StringConcatAggregation(a);
    }

    /**
     * @param a a
     * @param dataFactory dataFactory
     * @return class expression intersection aggregation
     */
    public static Aggregation<OWLClassExpression, Collection<OWLClassExpression>> buildClassExpressionIntersection(
        Collection<Aggregandum<Collection<OWLClassExpression>>> a, OWLDataFactory dataFactory) {
        return new ClassIntersectionAggregation(a, dataFactory);
    }

    /**
     * @param a a
     * @param dataFactory dataFactory
     * @return class expression union aggregation
     */
    public static Aggregation<OWLClassExpression, Collection<OWLClassExpression>> buildClassExpressionUnion(
        Collection<Aggregandum<Collection<OWLClassExpression>>> a, OWLDataFactory dataFactory) {
        return new ClassUnionAggregation(a, dataFactory);
    }

    /**
     * @param constraintSystem constraintSystem
     * @param prefix prefix
     * @param openDelimiter openDelimiter
     * @param separator separator
     * @param closedDelimiter closedDelimiter
     * @return rendering
     */
    protected String renderAggregation(ConstraintSystem constraintSystem, String prefix,
        String openDelimiter, String separator, String closedDelimiter) {
        return toAggregate.stream().flatMap(Aggregandum::opplFunctions)
            .map(f -> f.render(constraintSystem))
            .collect(Collectors.joining(separator, prefix + openDelimiter, closedDelimiter));
    }

    protected String renderAggregation(ShortFormProvider shortFormProvider, String prefix,
        String openDelimiter, String separator, String closedDelimiter) {
        return toAggregate.stream().flatMap(Aggregandum::opplFunctions)
            .map(f -> f.render(shortFormProvider))
            .collect(Collectors.joining(separator, prefix + openDelimiter, closedDelimiter));
    }
}


class StringConcatAggregation extends Aggregation<String, String> {

    StringConcatAggregation(Collection<? extends Aggregandum<String>> toAggregate) {
        super(toAggregate);
    }

    @Override
    protected String aggregate(ValueComputationParameters params) {
        return toAggregate.stream().flatMap(Aggregandum::opplFunctions).map(v -> v.compute(params))
            .collect(Collectors.joining());
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


class ClassUnionAggregation
    extends Aggregation<OWLClassExpression, Collection<OWLClassExpression>> {

    private final OWLDataFactory dataFactory;

    ClassUnionAggregation(Collection<Aggregandum<Collection<OWLClassExpression>>> toAggregate,
        OWLDataFactory dataFactory) {
        super(toAggregate);
        this.dataFactory = dataFactory;
    }

    @Override
    protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
        List<OWLClassExpression> operands = asList(
            toAggregate.stream().flatMap(Aggregandum::opplFunctions).map(f -> f.compute(parameters))
                .filter(Objects::nonNull).flatMap(Collection::stream));
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


class ClassIntersectionAggregation
    extends Aggregation<OWLClassExpression, Collection<OWLClassExpression>> {

    private final OWLDataFactory dataFactory;

    ClassIntersectionAggregation(
        Collection<Aggregandum<Collection<OWLClassExpression>>> toAggregate,
        OWLDataFactory dataFactory) {
        super(toAggregate);
        this.dataFactory = dataFactory;
    }

    @Override
    protected OWLClassExpression aggregate(ValueComputationParameters parameters) {
        List<OWLClassExpression> operands = asList(
            toAggregate.stream().flatMap(Aggregandum::opplFunctions).map(f -> f.compute(parameters))
                .filter(Objects::nonNull).flatMap(Collection::stream));
        return operands.isEmpty() ? null : dataFactory.getOWLObjectIntersectionOf(operands);
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return this.renderAggregation(constraintSystem, "createIntersection", "(", ", ", ")");
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return this.renderAggregation(shortFormProvider, "createIntersection", "(", ", ", ")");
    }
}
