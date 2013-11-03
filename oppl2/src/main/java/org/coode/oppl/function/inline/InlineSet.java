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
import org.coode.oppl.function.Adapter;
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

/** @author Luigi Iannone */
public final class InlineSet<O extends OWLObject> implements Set<O>, OPPLFunction<Set<O>> {
    private final Set<O> delegate = new HashSet<O>();
    private final Set<Aggregandum<Collection<? extends O>>> aggregandums = new HashSet<Aggregandum<Collection<? extends O>>>();

    /** @param delegate */
    public InlineSet(VariableType<? extends O> variableType,
            Collection<? extends Aggregandum<Collection<? extends O>>> aggregandums,
            final OWLDataFactory dataFactory, final ConstraintSystem constraintSystem) {
        if (aggregandums == null) {
            throw new NullPointerException("The aggregandum collection cannot be null");
        }
        this.aggregandums.addAll(aggregandums);
        this.delegate.add(variableType.accept(new VariableTypeVisitorEx<O>() {
            @Override
            @SuppressWarnings("unchecked")
            public O visitCLASSVariableType(CLASSVariableType classVariableType) {
                return (O) dataFactory.getOWLClass(IRI.create(String.format("%s#%s",
                        ManchesterVariableSyntax.NAMESPACE,
                        InlineSet.this.render(constraintSystem))));
            }

            @Override
            @SuppressWarnings("unchecked")
            public O visitOBJECTPROPERTYVariableType(
                    OBJECTPROPERTYVariableType objectpropertyVariableType) {
                return (O) dataFactory.getOWLObjectProperty(IRI.create(String.format(
                        "%s#%s", ManchesterVariableSyntax.NAMESPACE,
                        InlineSet.this.render(constraintSystem))));
            }

            @Override
            @SuppressWarnings("unchecked")
            public O visitDATAPROPERTYVariableType(
                    DATAPROPERTYVariableType datapropertyVariableType) {
                return (O) dataFactory.getOWLDataProperty(IRI.create(String.format(
                        "%s#%s", ManchesterVariableSyntax.NAMESPACE,
                        InlineSet.this.render(constraintSystem))));
            }

            @Override
            @SuppressWarnings("unchecked")
            public O visitINDIVIDUALVariableType(
                    INDIVIDUALVariableType individualVariableType) {
                return (O) dataFactory.getOWLNamedIndividual(IRI.create(String.format(
                        "%s#%s", ManchesterVariableSyntax.NAMESPACE,
                        InlineSet.this.render(constraintSystem))));
            }

            @Override
            @SuppressWarnings("unchecked")
            public O visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
                return (O) dataFactory.getOWLLiteral(InlineSet.this
                        .render(constraintSystem));
            }

            @Override
            @SuppressWarnings("unchecked")
            public O visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                return (O) dataFactory.getOWLAnnotationProperty(IRI.create(String.format(
                        "%s#%s", ManchesterVariableSyntax.NAMESPACE,
                        InlineSet.this.render(constraintSystem))));
            }
        }));
    }

    public Set<Aggregandum<Collection<? extends O>>> getAggregandums() {
        return new HashSet<Aggregandum<Collection<? extends O>>>(this.aggregandums);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitInlineSet(this);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitInlineSet(this);
    }

    @Override
    public Set<O> compute(ValueComputationParameters params) {
        Set<O> toReturn = new HashSet<O>();
        for (Aggregandum<Collection<? extends O>> aggregandum : this.aggregandums) {
            Set<OPPLFunction<Collection<? extends O>>> opplFunctions = aggregandum
                    .getOPPLFunctions();
            for (OPPLFunction<Collection<? extends O>> opplFunction : opplFunctions) {
                Collection<? extends O> value = opplFunction.compute(params);
                toReturn.addAll(value);
            }
        }
        return toReturn;
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        Formatter out = new Formatter();
        out.format("set(");
        Iterator<Aggregandum<Collection<? extends O>>> aggregandumIterator = this.aggregandums
                .iterator();
        while (aggregandumIterator.hasNext()) {
            Aggregandum<Collection<? extends O>> aggregandum = aggregandumIterator.next();
            String comma = aggregandumIterator.hasNext() ? ", " : "";
            out.format("%s%s", aggregandum.render(constraintSystem), comma);
        }
        out.format(")");
        return out.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        Formatter out = new Formatter();
        out.format("set(");
        Iterator<Aggregandum<Collection<? extends O>>> aggregandumIterator = this.aggregandums
                .iterator();
        while (aggregandumIterator.hasNext()) {
            Aggregandum<Collection<? extends O>> aggregandum = aggregandumIterator.next();
            String comma = aggregandumIterator.hasNext() ? ", " : "";
            out.format("%s%s", aggregandum.render(shortFormProvider), comma);
        }
        out.format(")");
        return out.toString();
    }

    public static <P extends OWLObject> InlineSet<P> buildInlineSet(
            OWLDataFactory dataFactory, ConstraintSystem constraintSystem,
            VariableType<P> variableType, Collection<? extends InlineSet<P>> components,
            P... objects) {
        Set<Aggregandum<Collection<? extends P>>> set = new HashSet<Aggregandum<Collection<? extends P>>>();
        for (InlineSet<P> inlineSet : components) {
            Set<Aggregandum<Collection<? extends P>>> aggregandums = inlineSet
                    .getAggregandums();
            set.addAll(aggregandums);
        }
        for (P p : objects) {
            set.add(Adapter.buildAggregandumOfCollection(p));
        }
        return new InlineSet<P>(variableType, set, dataFactory, constraintSystem);
    }

    // Delegate methods
    @Override
    public boolean add(O o) {
        return this.delegate.add(o);
    }

    @Override
    public boolean addAll(Collection<? extends O> c) {
        return this.delegate.addAll(c);
    }

    @Override
    public void clear() {
        this.delegate.clear();
    }

    @Override
    public boolean contains(Object o) {
        return this.delegate.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.delegate.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return this.delegate.equals(o);
    }

    @Override
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override
    public Iterator<O> iterator() {
        return this.delegate.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return this.delegate.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.delegate.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.delegate.retainAll(c);
    }

    @Override
    public int size() {
        return this.delegate.size();
    }

    @Override
    public Object[] toArray() {
        return this.delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.delegate.toArray(a);
    }
}
