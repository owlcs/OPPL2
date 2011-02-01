/**
 * 
 */
package org.coode.oppl.function.inline;

import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.OPPLFunctionVisitor;
import org.coode.oppl.function.OPPLFunctionVisitorEx;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public final class InlineSet<O extends OWLObject> implements Set<O>, OPPLFunction<Set<O>> {
	private final Set<O> delegate = new HashSet<O>();
	private final Set<Aggregandum<Collection<? extends O>>> aggregandums = new HashSet<Aggregandum<Collection<? extends O>>>();

	/**
	 * @param delegate
	 */
	public InlineSet(VariableType<? extends O> variableType,
			Collection<? extends Aggregandum<Collection<? extends O>>> aggregandums,
			final OWLDataFactory dataFactory, final ConstraintSystem constraintSystem) {
		if (aggregandums == null) {
			throw new NullPointerException("The aggregandum collection cannot be null");
		}
		this.aggregandums.addAll(aggregandums);
		this.delegate.add(variableType.accept(new VariableTypeVisitorEx<O>() {
			@SuppressWarnings("unchecked")
			public O visitCLASSVariableType(CLASSVariableType classVariableType) {
				return (O) dataFactory.getOWLClass(IRI.create(String.format(
						"%s#%s",
						ManchesterVariableSyntax.NAMESPACE,
						InlineSet.this.render(constraintSystem))));
			}

			@SuppressWarnings("unchecked")
			public O visitOBJECTPROPERTYVariableType(
					OBJECTPROPERTYVariableType objectpropertyVariableType) {
				return (O) dataFactory.getOWLObjectProperty(IRI.create(String.format(
						"%s#%s",
						ManchesterVariableSyntax.NAMESPACE,
						InlineSet.this.render(constraintSystem))));
			}

			@SuppressWarnings("unchecked")
			public O visitDATAPROPERTYVariableType(DATAPROPERTYVariableType datapropertyVariableType) {
				return (O) dataFactory.getOWLDataProperty(IRI.create(String.format(
						"%s#%s",
						ManchesterVariableSyntax.NAMESPACE,
						InlineSet.this.render(constraintSystem))));
			}

			@SuppressWarnings("unchecked")
			public O visitINDIVIDUALVariableType(INDIVIDUALVariableType individualVariableType) {
				return (O) dataFactory.getOWLNamedIndividual(IRI.create(String.format(
						"%s#%s",
						ManchesterVariableSyntax.NAMESPACE,
						InlineSet.this.render(constraintSystem))));
			}

			@SuppressWarnings("unchecked")
			public O visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
				return (O) dataFactory.getOWLLiteral(InlineSet.this.render(constraintSystem));
			}

			@SuppressWarnings("unchecked")
			public O visitANNOTATIONPROPERTYVariableType(
					ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
				return (O) dataFactory.getOWLAnnotationProperty(IRI.create(String.format(
						"%s#%s",
						ManchesterVariableSyntax.NAMESPACE,
						InlineSet.this.render(constraintSystem))));
			}
		}));
	}

	public Set<Aggregandum<Collection<? extends O>>> getAggregandums() {
		return new HashSet<Aggregandum<Collection<? extends O>>>(this.aggregandums);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitInlineSet(this);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitInlineSet(this);
	}

	public Set<O> compute(ValueComputationParameters params) {
		Set<O> toReturn = new HashSet<O>();
		for (Aggregandum<Collection<? extends O>> aggregandum : this.aggregandums) {
			Set<OPPLFunction<Collection<? extends O>>> opplFunctions = aggregandum.getOPPLFunctions();
			for (OPPLFunction<Collection<? extends O>> opplFunction : opplFunctions) {
				Collection<? extends O> value = opplFunction.compute(params);
				toReturn.addAll(value);
			}
		}
		return toReturn;
	}

	public String render(ConstraintSystem constraintSystem) {
		Formatter out = new Formatter();
		out.format("set(");
		Iterator<Aggregandum<Collection<? extends O>>> aggregandumIterator = this.aggregandums.iterator();
		while (aggregandumIterator.hasNext()) {
			Aggregandum<Collection<? extends O>> aggregandum = aggregandumIterator.next();
			String comma = aggregandumIterator.hasNext() ? ", " : "";
			out.format("%s%s", aggregandum.render(constraintSystem), comma);
		}
		out.format(")");
		return out.toString();
	}

	public String render(ShortFormProvider shortFormProvider) {
		Formatter out = new Formatter();
		out.format("set(");
		Iterator<Aggregandum<Collection<? extends O>>> aggregandumIterator = this.aggregandums.iterator();
		while (aggregandumIterator.hasNext()) {
			Aggregandum<Collection<? extends O>> aggregandum = aggregandumIterator.next();
			String comma = aggregandumIterator.hasNext() ? ", " : "";
			out.format("%s%s", aggregandum.render(shortFormProvider), comma);
		}
		out.format(")");
		return out.toString();
	}

	public static <P extends OWLObject> InlineSet<P> buildInlineSet(
			Collection<? extends InlineSet<P>> components, P... objects) {
		Set<InlineSet<P>> set = new HashSet<InlineSet<P>>(components.size() + objects.length);
		return 
	}

	// Delegate methods
	/**
	 * @param o
	 * @return
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean add(O o) {
		return this.delegate.add(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Set#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends O> c) {
		return this.delegate.addAll(c);
	}

	/**
	 * 
	 * @see java.util.Set#clear()
	 */
	public void clear() {
		this.delegate.clear();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return this.delegate.contains(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return this.delegate.containsAll(c);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Set#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return this.delegate.equals(o);
	}

	/**
	 * @return
	 * @see java.util.Set#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}

	/**
	 * @return
	 * @see java.util.Set#isEmpty()
	 */
	public boolean isEmpty() {
		return this.delegate.isEmpty();
	}

	/**
	 * @return
	 * @see java.util.Set#iterator()
	 */
	public Iterator<O> iterator() {
		return this.delegate.iterator();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return this.delegate.remove(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Set#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return this.delegate.removeAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Set#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return this.delegate.retainAll(c);
	}

	/**
	 * @return
	 * @see java.util.Set#size()
	 */
	public int size() {
		return this.delegate.size();
	}

	/**
	 * @return
	 * @see java.util.Set#toArray()
	 */
	public Object[] toArray() {
		return this.delegate.toArray();
	}

	/**
	 * @param <T>
	 * @param a
	 * @return
	 * @see java.util.Set#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return this.delegate.toArray(a);
	}
}
