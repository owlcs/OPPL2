package org.coode.oppl.datafactory;

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
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/** @author Luigi Iannone */
public class OPPLOWLDisjointDataPropertiesAxiom extends
        AbstractInlineSetAxiom<OWLDataPropertyExpression> implements
        OWLDisjointDataPropertiesAxiom {
    private final OWLDisjointDataPropertiesAxiom delegate;
    private final boolean shouldExpandAsPairWise;

    public OPPLOWLDisjointDataPropertiesAxiom(OPPLOWLDataFactory dataFactory,
            InlineSet<OWLDataPropertyExpression> propertyExpressions,
            Set<? extends OWLAnnotation> annotations, boolean shouldExpandAsPairWise) {
        super(propertyExpressions);
        if (dataFactory == null) {
            throw new NullPointerException("The data factory cannot be null");
        }
        if (propertyExpressions == null) {
            throw new NullPointerException("The inline set cannot be null");
        }
        if (annotations == null) {
            throw new NullPointerException("The annotations cannot be null");
        }
        this.shouldExpandAsPairWise = shouldExpandAsPairWise;
        delegate = dataFactory.getDelegate().getOWLDisjointDataPropertiesAxiom(
                propertyExpressions, annotations);
    }

    /** @return the shouldExpandAsPairwise */
    public boolean shouldExpandAsPairWise() {
        return shouldExpandAsPairWise;
    }

    // Delegate methods
    @Override
    public Set<OWLEntity> getSignature() {
        return delegate.getSignature();
    }

    @Override
    public Set<OWLAnonymousIndividual> getAnonymousIndividuals() {
        return delegate.getAnonymousIndividuals();
    }

    @Override
    public Set<OWLDataPropertyExpression> getProperties() {
        return delegate.getProperties();
    }

    @Override
    public Set<OWLDataPropertyExpression> getPropertiesMinus(
            OWLDataPropertyExpression property) {
        return delegate.getPropertiesMinus(property);
    }

    @Override
    public Set<OWLClass> getClassesInSignature() {
        return delegate.getClassesInSignature();
    }

    @Override
    public OWLDisjointDataPropertiesAxiom getAxiomWithoutAnnotations() {
        return delegate.getAxiomWithoutAnnotations();
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
    public Set<OWLAnnotation> getAnnotations() {
        return delegate.getAnnotations();
    }

    @Override
    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return delegate.getDataPropertiesInSignature();
    }

    @Override
    public Set<OWLAnnotation> getAnnotations(OWLAnnotationProperty annotationProperty) {
        return delegate.getAnnotations(annotationProperty);
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
    public OWLAxiom getAnnotatedAxiom(Set<OWLAnnotation> annotations) {
        return delegate.getAnnotatedAxiom(annotations);
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
