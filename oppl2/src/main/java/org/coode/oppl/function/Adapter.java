package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class Adapter {

    static class VarVisitor<O> implements VariableTypeVisitorEx<Boolean> {
        private final O value;

        VarVisitor(O value) {
            this.value = value;
        }

        @Override
        public Boolean visitCLASSVariableType(CLASSVariableType classVariableType) {
            return Boolean.valueOf(this.value instanceof OWLClassExpression);
        }

        @Override
        public Boolean visitOBJECTPROPERTYVariableType(
            OBJECTPROPERTYVariableType objectpropertyVariableType) {
            return Boolean.valueOf(this.value instanceof OWLObjectPropertyExpression);
        }

        @Override
        public Boolean visitDATAPROPERTYVariableType(
            DATAPROPERTYVariableType datapropertyVariableType) {
            return Boolean.valueOf(this.value instanceof OWLDataPropertyExpression);
        }

        @Override
        public Boolean visitINDIVIDUALVariableType(INDIVIDUALVariableType individualVariableType) {
            return Boolean.valueOf(this.value instanceof OWLIndividual);
        }

        @Override
        public Boolean visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
            return Boolean.valueOf(this.value instanceof OWLLiteral);
        }

        @Override
        public Boolean visitANNOTATIONPROPERTYVariableType(
            ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
            return Boolean.valueOf(this.value instanceof OWLAnnotationProperty);
        }
    }

    /**
     * @param value value
     * @param <O> function type
     * @return oppl function
     */
    public static <O> OPPLFunction<O> buildObjectAdater(O value) {
        return new Constant<>(checkNotNull(value, "value"));
    }

    /**
     * @param collection collection
     * @param <O> aggregate type
     * @return aggregandum set
     */
    public static <O extends OWLObject> Set<Aggregandum<Collection<O>>> buildOWLObjectCollectionAdapter(
        Collection<? extends O> collection) {
        checkNotNull(collection, "collection");
        return asSet(collection.stream().map(Adapter::buildAggregandumOfCollection));
    }

    /**
     * @param singleton singleton
     * @param <I> aggregate type
     * @return aggregandum
     */
    public static <I> Aggregandum<I> buildSingletonAggregandum(final OPPLFunction<I> singleton) {
        checkNotNull(singleton, "singleton");
        return new Aggregandum<I>() {

            @Override
            public Set<OPPLFunction<I>> getOPPLFunctions() {
                return Collections.<OPPLFunction<I>>singleton(singleton);
            }

            @Override
            public Stream<OPPLFunction<I>> opplFunctions() {
                return Stream.of(singleton);
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return Adapter.isCompatible(this, variableType);
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return Adapter.renderAggregandum(this, constraintSystem);
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return Adapter.renderAggregandum(this, shortFormProvider);
            }
        };
    }

    /**
     * @param singleton singleton
     * @param <I> aggregate type
     * @return aggregandum of collection
     */
    public static <I> Aggregandum<Collection<I>> buildAggregandumOfCollection(I singleton) {
        checkNotNull(singleton, "singleton");
        final OPPLFunction<I> adapted = buildObjectAdater(singleton);
        OPPLFunction<Collection<I>> s = new OPPLFunction<Collection<I>>() {

            @Override
            public Collection<I> compute(ValueComputationParameters params) {
                I value = adapted.compute(params);
                return Collections.singleton(value);
            }

            @Override
            public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
                return adapted.accept(visitor);
            }

            @Override
            public void accept(OPPLFunctionVisitor visitor) {
                adapted.accept(visitor);
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return adapted.render(constraintSystem);
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return adapted.render(shortFormProvider);
            }
        };
        return new Aggregandum<Collection<I>>() {

            @Override
            public Set<OPPLFunction<Collection<I>>> getOPPLFunctions() {
                return Collections.singleton(s);
            }

            @Override
            public Stream<OPPLFunction<Collection<I>>> opplFunctions() {
                return Stream.of(s);
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return Adapter.isCompatible(this, variableType);
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return renderAggregandum(this, constraintSystem);
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return renderAggregandum(this, shortFormProvider);
            }
        };
    }

    /**
     * @param collection collection
     * @param <I> aggregate type
     * @return aggregandum of collection
     */
    public static <I> Aggregandum<I> buildAggregandumCollection(
        final Collection<OPPLFunction<I>> collection) {
        return new Aggregandum<I>() {

            @Override
            public Set<OPPLFunction<I>> getOPPLFunctions() {
                return new HashSet<>(collection);
            }

            @Override
            public Stream<OPPLFunction<I>> opplFunctions() {
                return collection.stream();
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return Adapter.isCompatible(this, variableType);
            }

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return Adapter.renderAggregandum(this, constraintSystem);
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return renderAggregandum(this, shortFormProvider);
            }
        };
    }

    /**
     * @param stringOPPLFunction stringOPPLFunction
     * @return oppl function
     */
    public static OPPLFunction<Pattern> buildRegexpPatternAdapter(
        final OPPLFunction<String> stringOPPLFunction) {
        return new OPPLFunction<Pattern>() {

            @Override
            public String render(ConstraintSystem constraintSystem) {
                return stringOPPLFunction.render(constraintSystem);
            }

            @Override
            public String render(ShortFormProvider shortFormProvider) {
                return stringOPPLFunction.render(shortFormProvider);
            }

            @Override
            public Pattern compute(ValueComputationParameters params) {
                String string = stringOPPLFunction.compute(params);
                Pattern pattern = null;
                try {
                    pattern = Pattern.compile(string);
                } catch (PatternSyntaxException e) {
                    params.getRuntimeExceptionHandler().handlePatternSyntaxExcpetion(e);
                }
                return pattern;
            }

            @Override
            public void accept(OPPLFunctionVisitor visitor) {
                stringOPPLFunction.accept(visitor);
            }

            @Override
            public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
                return stringOPPLFunction.accept(visitor);
            }
        };
    }

    protected static <I> boolean isCompatible(Aggregandum<I> aggregandum,
        final VariableType<?> type) {
        boolean isCompatible = true;
        Iterator<OPPLFunction<I>> iterator = aggregandum.opplFunctions().iterator();
        while (isCompatible && iterator.hasNext()) {
            OPPLFunction<I> opplFunction = iterator.next();
            isCompatible = opplFunction.accept(new OPPLFunctionVisitorEx<Boolean>() {

                @Override
                public <O, T> Boolean visitAggregation(Aggregation<O, T> aggregation) {
                    return Boolean.valueOf(
                        aggregation.toAggregate().allMatch(t -> Adapter.isCompatible(t, type)));
                }

                @Override
                public <O extends OWLObject> Boolean visitInlineSet(InlineSet<O> inlineSet) {
                    return Boolean.valueOf(
                        inlineSet.aggregandums().allMatch(t -> Adapter.isCompatible(t, type)));
                }

                @Override
                public <P extends OWLObject> Boolean visitGenericOPPLFunction(OPPLFunction<P> f) {
                    return Boolean.FALSE;
                }

                @Override
                public <O> Boolean visitConstant(Constant<O> constant) {
                    final O value = constant.getValue();
                    return type.accept(new VarVisitor<O>(value));
                }

                @Override
                public <O extends OWLObject> Boolean visitValuesVariableAtttribute(
                    ValuesVariableAtttribute<O> valuesVariableAtttribute) {
                    return Boolean
                        .valueOf(valuesVariableAtttribute.getVariable().getType() == type);
                }

                @Override
                public Boolean visitRenderingVariableAttribute(
                    RenderingVariableAttribute renderingVariableAttribute) {
                    return Boolean.FALSE;
                }

                @Override
                public <O extends OWLObject> Boolean visitGroupVariableAttribute(
                    GroupVariableAttribute<O> groupVariableAttribute) {
                    return Boolean.FALSE;
                }

                @Override
                public <O extends OWLObject> Boolean visitExpression(Expression<O> expression) {
                    return Boolean.valueOf(type.isCompatibleWith(expression.getExpression()));
                }

                @Override
                public <O, T extends OPPLFunction<?>> Boolean visitCreate(Create<T, O> create) {
                    return Boolean.valueOf(create.isCompatible(type));
                }

                @Override
                public Boolean visitIRIVariableAttribute(
                    IRIVariableAttribute iriVariableAttribute) {
                    return Boolean.FALSE;
                }

                @Override
                public Boolean visitToLowerCaseStringManipulationOPPLFunction(
                    ToLowerCaseStringManipulationOPPLFunction toLowerCaseStringManipulationOPPLFunction) {
                    return Boolean.FALSE;
                }

                @Override
                public Boolean visitToUpperCaseStringManipulationOPPLFunction(
                    ToUpperCaseStringManipulationOPPLFunction upperCaseStringManipulationOPPLFunction) {
                    return Boolean.FALSE;
                }
            }).booleanValue();
        }
        return isCompatible;
    }

    protected static <I> String renderAggregandum(Aggregandum<I> aggregandum,
        ConstraintSystem constraintSystem) {
        return aggregandum.opplFunctions().map(f -> f.render(constraintSystem))
            .collect(Collectors.joining(" : "));
    }

    protected static <I> String renderAggregandum(Aggregandum<I> aggregandum,
        ShortFormProvider shortFormProvider) {
        return aggregandum.opplFunctions().map(f -> f.render(shortFormProvider))
            .collect(Collectors.joining(" : "));
    }
}
