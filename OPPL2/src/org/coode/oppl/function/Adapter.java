package org.coode.oppl.function;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.ConstraintSystem;
import org.semanticweb.owlapi.model.OWLObject;

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

	public static <I> Aggregandum<I> buildSingletonAggregandum(
			final OPPLFunction<? extends I> singleton) {
		if (singleton == null) {
			throw new NullPointerException("The OPPL function cannot be null");
		}
		return new Aggregandum<I>() {
			public Set<OPPLFunction<? extends I>> getOPPLFunctions() {
				return Collections.<OPPLFunction<? extends I>> singleton(singleton);
			}
		};
	}

	public static <I> Aggregandum<I> buildSingletonAggregandum(I singleton) {
		if (singleton == null) {
			throw new NullPointerException("The OPPL function cannot be null");
		}
		final OPPLFunction<I> adapted = buildObjectAdater(singleton);
		return new Aggregandum<I>() {
			public Set<OPPLFunction<? extends I>> getOPPLFunctions() {
				return Collections.<OPPLFunction<? extends I>> singleton(adapted);
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
			final Collection<? extends OPPLFunction<? extends I>> collection) {
		return new Aggregandum<I>() {
			public Set<OPPLFunction<? extends I>> getOPPLFunctions() {
				return new HashSet<OPPLFunction<? extends I>>(collection);
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
				return Pattern.compile(string);
			}

			public void accept(OPPLFunctionVisitor visitor) {
				stringOPPLFunction.accept(visitor);
			}

			public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
				return stringOPPLFunction.accept(visitor);
			}
		};
	}
}
