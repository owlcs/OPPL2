package org.coode.oppl.datafactory;

import java.util.List;
import java.util.Set;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitor;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/** @author Luigi Iannone */
public class OPPLOWLSameIndividualAxiom extends AbstractInlineSetAxiom<OWLIndividual>
        implements OWLSameIndividualAxiom {
    private static final long serialVersionUID = 20100L;
    private final OWLSameIndividualAxiom delegate;
    private final boolean shouldExpandAsPairWise;

    /** @param dataFactory
     * @param individuals
     * @param annotations
     * @param shouldExpandAsPairWise */
    public OPPLOWLSameIndividualAxiom(OPPLOWLDataFactory dataFactory,
            InlineSet<OWLIndividual> individuals,
            Set<? extends OWLAnnotation> annotations, boolean shouldExpandAsPairWise) {
        super(individuals);
        if (dataFactory == null) {
            throw new NullPointerException("The data factory cannot be null");
        }
        if (annotations == null) {
            throw new NullPointerException("The annotations cannot be null");
        }
        delegate = dataFactory.getDelegate().getOWLSameIndividualAxiom(individuals,
                annotations);
        this.shouldExpandAsPairWise = shouldExpandAsPairWise;
    }

    /** @return the shouldExpandAsPairwise */
    public boolean shouldExpandAsPairWise() {
        return shouldExpandAsPairWise;
    }

    @Override
    public Set<OWLEntity> getSignature() {
        return delegate.getSignature();
    }

    @Override
    public Set<OWLAnonymousIndividual> getAnonymousIndividuals() {
        return delegate.getAnonymousIndividuals();
    }

    @Override
    public Set<OWLIndividual> getIndividuals() {
        return delegate.getIndividuals();
    }

    @Override
    public List<OWLIndividual> getIndividualsAsList() {
        return delegate.getIndividualsAsList();
    }

    @Override
    public Set<OWLSubClassOfAxiom> asOWLSubClassOfAxioms() {
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
    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return delegate.getDataPropertiesInSignature();
    }

    @Override
    public Set<OWLSameIndividualAxiom> asPairwiseAxioms() {
        return delegate.asPairwiseAxioms();
    }

    @Override
    public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
        return delegate.getObjectPropertiesInSignature();
    }

    @Override
    public Set<OWLNamedIndividual> getIndividualsInSignature() {
        return delegate.getIndividualsInSignature();
    }

    @Override
    public Set<OWLDatatype> getDatatypesInSignature() {
        return delegate.getDatatypesInSignature();
    }

    @Override
    public Set<OWLClassExpression> getNestedClassExpressions() {
        return delegate.getNestedClassExpressions();
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
    public OWLSameIndividualAxiom getAxiomWithoutAnnotations() {
        return delegate.getAxiomWithoutAnnotations();
    }

    @Override
    public Set<OWLClass> getClassesInSignature() {
        return delegate.getClassesInSignature();
    }

    @Override
    public boolean containsAnonymousIndividuals() {
        return delegate.containsAnonymousIndividuals();
    }

    @Override
    public Set<OWLAnnotation> getAnnotations() {
        return delegate.getAnnotations();
    }

    @Override
    public Set<OWLAnnotation> getAnnotations(OWLAnnotationProperty annotationProperty) {
        return delegate.getAnnotations(annotationProperty);
    }

    @Override
    public OWLAxiom getAnnotatedAxiom(Set<OWLAnnotation> annotations) {
        return delegate.getAnnotatedAxiom(annotations);
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
    public boolean isOfType(Set<AxiomType<?>> types) {
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
    public boolean isAnnotationAxiom() {
        return delegate.isAnnotationAxiom();
    }
}
