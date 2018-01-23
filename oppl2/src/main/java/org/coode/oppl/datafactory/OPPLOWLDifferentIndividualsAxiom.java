package org.coode.oppl.datafactory;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitor;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLPairwiseVisitor;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/**
 * @author Luigi Iannone
 */
public class OPPLOWLDifferentIndividualsAxiom extends AbstractInlineSetAxiom<OWLIndividual>
    implements OWLDifferentIndividualsAxiom {

    private static final long serialVersionUID = 20100L;
    private final OWLDifferentIndividualsAxiom delegate;
    private final boolean shouldExpandAsPairWise;

    /**
     * @param dataFactory dataFactory
     * @param individuals individuals
     * @param annotations annotations
     * @param shouldExpandAsPairWise shouldExpandAsPairWise
     */
    public OPPLOWLDifferentIndividualsAxiom(OPPLOWLDataFactory dataFactory,
        InlineSet<OWLIndividual> individuals, Collection<OWLAnnotation> annotations,
        boolean shouldExpandAsPairWise) {
        super(individuals);
        checkNotNull(dataFactory, "dataFactory");
        checkNotNull(individuals, "individuals");
        checkNotNull(annotations, "annotations");
        this.shouldExpandAsPairWise = shouldExpandAsPairWise;
        delegate =
            dataFactory.getDelegate().getOWLDifferentIndividualsAxiom(individuals, annotations);
    }

    /**
     * @return the shouldExpandAsPairwise
     */
    public boolean shouldExpandAsPairWise() {
        return shouldExpandAsPairWise;
    }

    // Delegate methods

    @Override
    public boolean containsEntityInSignature(OWLEntity owlEntity) {
        return delegate.containsEntityInSignature(owlEntity);
    }

    @Override
    public boolean isAnnotationAxiom() {
        return delegate.isAnnotationAxiom();
    }

    @Override
    public List<OWLIndividual> getIndividualsAsList() {
        return delegate.getIndividualsAsList();
    }

    @Override
    public Collection<OWLSubClassOfAxiom> asOWLSubClassOfAxioms() {
        return delegate.asOWLSubClassOfAxioms();
    }

    @Override
    public void accept(OWLAxiomVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <O> O accept(OWLAxiomVisitorEx<O> visitor) {
        return visitor.visit(this);
    }


    @Override
    public Collection<OWLDifferentIndividualsAxiom> asPairwiseAxioms() {
        return delegate.asPairwiseAxioms();
    }


    @Override
    public void accept(OWLObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <O> O accept(OWLObjectVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public int compareTo(OWLObject o) {
        return delegate.compareTo(o);
    }

    @Override
    public OWLDifferentIndividualsAxiom getAxiomWithoutAnnotations() {
        return delegate.getAxiomWithoutAnnotations();
    }


    @Override
    public boolean containsAnonymousIndividuals() {
        return delegate.containsAnonymousIndividuals();
    }

    @Override
    public boolean equalsIgnoreAnnotations(OWLAxiom axiom) {
        return delegate.equalsIgnoreAnnotations(axiom);
    }

    @Override
    public boolean isTopEntity() {
        return delegate.isTopEntity();
    }

    @Override
    public boolean isLogicalAxiom() {
        return delegate.isLogicalAxiom();
    }

    @Override
    public boolean isBottomEntity() {
        return delegate.isBottomEntity();
    }

    @Override
    public boolean isAnnotated() {
        return delegate.isAnnotated();
    }

    @Override
    public AxiomType<?> getAxiomType() {
        return delegate.getAxiomType();
    }

    @Override
    public boolean isOfType(AxiomType<?>... axiomTypes) {
        return delegate.isOfType(axiomTypes);
    }

    @Override
    public boolean isOfType(Collection<AxiomType<?>> types) {
        return delegate.isOfType(types);
    }

    @Override
    public OWLAxiom getNNF() {
        return delegate.getNNF();
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public Collection<OWLDifferentIndividualsAxiom> splitToAnnotatedPairs() {
        return delegate.splitToAnnotatedPairs();
    }

    @Override
    public <T> Collection<T> walkPairwise(OWLPairwiseVisitor<T, OWLIndividual> visitor) {
        return delegate.walkPairwise(visitor);
    }

    @Override
    public <T extends OWLAxiom> T getAnnotatedAxiom(Stream<OWLAnnotation> annotations) {
        return delegate.getAnnotatedAxiom(annotations);
    }

    @Override
    public Stream<OWLIndividual> individuals() {
        return delegate.individuals();
    }

}
