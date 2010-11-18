package org.coode.oppl.function;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.coode.oppl.ConstraintSystem;
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

public class Adapter {
	public static <O> OPPLFunction<O> buildObjectAdater(O value) {
		if (value == null) {
			throw new NullPointerException("The value cannot be null");
		}
		return new Constant<O>(value);
	}

	public static <O extends OWLObject> Set<Aggregandum<O>> buildOWLObjectCollectionAdapter(
			Collection<? extends O> collection) {
		if (collection == null) {
			throw new NullPointerException("The collection cannot be null");
		}
		Set<Aggregandum<O>> toReturn = new HashSet<Aggregandum<O>>(collection.size());
		for (O o : collection) {
			toReturn.add(buildSingletonAggregandum(o));
		}
		return toReturn;
	}

	public static <I> Aggregandum<I> buildSingletonAggregandum(final OPPLFunction<I> singleton) {
		if (singleton == null) {
			throw new NullPointerException("The OPPL function cannot be null");
		}
		return new Aggregandum<I>() {
			public Set<OPPLFunction<I>> getOPPLFunctions() {
				return Collections.<OPPLFunction<I>> singleton(singleton);
			}

			public boolean isCompatible(VariableType<?> variableType) {
				return Adapter.isCompatible(this, variableType);
			}

			public String render(ConstraintSystem constraintSystem) {
				return Adapter.renderAggregandum(this, constraintSystem);
			}
		};
	}

	public static <I> Aggregandum<I> buildSingletonAggregandum(I singleton) {
		if (singleton == null) {
			throw new NullPointerException("The OPPL function cannot be null");
		}
		final OPPLFunction<I> adapted = buildObjectAdater(singleton);
		return new Aggregandum<I>() {
			public Set<OPPLFunction<I>> getOPPLFunctions() {
				return Collections.<OPPLFunction<I>> singleton(adapted);
			}

			public boolean isCompatible(VariableType<?> variableType) {
				return Adapter.isCompatible(this, variableType);
			}

			public String render(ConstraintSystem constraintSystem) {
				return Adapter.renderAggregandum(this, constraintSystem);
			}
		};
	}

	public static <I extends OWLObject> Set<Aggregandum<I>> buildAggregandumOWLObjectCollection(
			Collection<? extends I> collection) {
		if (collection == null) {
			throw new NullPointerException("The collection cannot be null");
		}
		final Set<Aggregandum<I>> adapted = new HashSet<Aggregandum<I>>(collection.size());
		for (I i : collection) {
			adapted.add(buildSingletonAggregandum(i));
		}
		return adapted;
	}

	public static <I extends OWLObject> Aggregandum<I> buildAggregandumCollection(
			final Collection<? extends OPPLFunction<I>> collection) {
		return new Aggregandum<I>() {
			public Set<OPPLFunction<I>> getOPPLFunctions() {
				return new HashSet<OPPLFunction<I>>(collection);
			}

			public boolean isCompatible(VariableType<?> variableType) {
				return Adapter.isCompatible(this, variableType);
			}

			public String render(ConstraintSystem constraintSystem) {
				return Adapter.renderAggregandum(this, constraintSystem);
			}
		};
	}

	public static OPPLFunction<Pattern> buildRegexpPatternAdapter(
			final OPPLFunction<String> stringOPPLFunction) {
		return new OPPLFunction<Pattern>() {
			public String render(ConstraintSystem constraintSystem) {
				return stringOPPLFunction.render(constraintSystem);
			}

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

			public void accept(OPPLFunctionVisitor visitor) {
				stringOPPLFunction.accept(visitor);
			}

			public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
				return stringOPPLFunction.accept(visitor);
			}
		};
	}

	private static <I> boolean isCompatible(Aggregandum<I> aggregandum, final VariableType<?> type) {
		boolean isCompatible = true;
		Iterator<OPPLFunction<I>> iterator = aggregandum.getOPPLFunctions().iterator();
		while (isCompatible && iterator.hasNext()) {
			OPPLFunction<I> opplFunction = iterator.next();
			isCompatible = opplFunction.accept(new OPPLFunctionVisitorEx<Boolean>() {
				public <O, T> Boolean visitAggregation(Aggregation<O, T> aggregation) {
					boolean isCompatible = true;
					Iterator<Aggregandum<T>> it = aggregation.getToAggreagte().iterator();
					while (it.hasNext()) {
						Aggregandum<T> aggregandum = it.next();
						isCompatible = Adapter.isCompatible(aggregandum, type);
					}
					return isCompatible;
				}

				public <O> Boolean visitConstant(Constant<O> constant) {
					final O value = constant.getValue();
					return type.accept(new VariableTypeVisitorEx<Boolean>() {
						public Boolean visitCLASSVariableType(CLASSVariableType classVariableType) {
							return value instanceof OWLClassExpression;
						}

						public Boolean visitOBJECTPROPERTYVariableType(
								OBJECTPROPERTYVariableType objectpropertyVariableType) {
							return value instanceof OWLObjectPropertyExpression;
						}

						public Boolean visitDATAPROPERTYVariableType(
								DATAPROPERTYVariableType datapropertyVariableType) {
							return value instanceof OWLDataPropertyExpression;
						}

						public Boolean visitINDIVIDUALVariableType(
								INDIVIDUALVariableType individualVariableType) {
							return value instanceof OWLIndividual;
						}

						public Boolean visitCONSTANTVariableType(
								CONSTANTVariableType constantVariableType) {
							return value instanceof OWLLiteral;
						}

						public Boolean visitANNOTATIONPROPERTYVariableType(
								ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
							return value instanceof OWLAnnotationProperty;
						}
					});
				}

				public <O extends OWLObject> Boolean visitValuesVariableAtttribute(
						ValuesVariableAtttribute<O> valuesVariableAtttribute) {
					return valuesVariableAtttribute.getVariable().getType() == type;
				}

				public Boolean visitRenderingVariableAttribute(
						RenderingVariableAttribute renderingVariableAttribute) {
					return false;
				}

				public <O extends OWLObject> Boolean visitGroupVariableAttribute(
						GroupVariableAttribute<O> groupVariableAttribute) {
					return false;
				}

				public <O extends OWLObject> Boolean visitExpression(Expression<O> expression) {
					return type.isCompatibleWith(expression.getExpression());
				}

				public <O, T extends OPPLFunction<?>> Boolean visitCreate(Create<T, O> create) {
					return create.isCompatible(type);
				}

				public Boolean visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute) {
					return false;
				}
			});
		}
		return isCompatible;
	}

	private static <I> String renderAggregandum(Aggregandum<I> aggregandum,
			ConstraintSystem constraintSystem) {
		StringBuilder builder = new StringBuilder();
		Iterator<OPPLFunction<I>> iterator = aggregandum.getOPPLFunctions().iterator();
		while (iterator.hasNext()) {
			OPPLFunction<I> opplFunction = iterator.next();
			builder.append(String.format(
					"%s %s",
					opplFunction.render(constraintSystem),
					iterator.hasNext() ? ", " : ""));
		}
		return builder.toString();
	}
}
