package org.coode.oppl.datafactory;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLPairwiseVisitor;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/**
 * @author Luigi Iannone
 */
public class OPPLOWLDisjointClassesAxiom extends AbstractInlineSetAxiom<OWLClassExpression>
    implements OWLDisjointClassesAxiom {

    private static final long serialVersionUID = 20100L;
    private final OWLDisjointClassesAxiom delegate;
    private final boolean shouldExpandAsPairWise;

    /**
     * @param dataFactory dataFactory
     * @param classExpressions classExpressions
     * @param annotations annotations
     * @param shouldExpandAsPairWise shouldExpandAsPairWise
     */
    public OPPLOWLDisjointClassesAxiom(OPPLOWLDataFactory dataFactory,
        InlineSet<OWLClassExpression> classExpressions, Collection<OWLAnnotation> annotations,
        boolean shouldExpandAsPairWise) {
        super(classExpressions);
        checkNotNull(dataFactory, "dataFactory");
        checkNotNull(classExpressions, "classExpressions");
        checkNotNull(annotations, "annotations");
        this.shouldExpandAsPairWise = shouldExpandAsPairWise;
        delegate =
            dataFactory.getDelegate().getOWLDisjointClassesAxiom(classExpressions, annotations);
    }

    /**
     * @return the shouldExpandAsPairwise
     */
    public boolean shouldExpandAsPairWise() {
        return shouldExpandAsPairWise;
    }

    // Delegate methods
    @Override
    public Set<OWLEntity> getSignature() {
        return delegate.getSignature();
    }

    @Override
    public boolean containsEntityInSignature(OWLEntity owlEntity) {
        return delegate.containsEntityInSignature(owlEntity);
    }

    @Override
    public Set<OWLAnonymousIndividual> getAnonymousIndividuals() {
        return delegate.getAnonymousIndividuals();
    }

    @Override
    public Stream<OWLClassExpression> classExpressions() {
        return delegate.classExpressions();
    }

    @Override
    public Collection<OWLSubClassOfAxiom> asOWLSubClassOfAxioms() {
        return delegate.asOWLSubClassOfAxioms();
    }

    @Override
    public Collection<OWLDisjointClassesAxiom> asPairwiseAxioms() {
        return delegate.asPairwiseAxioms();
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
    public List<OWLClassExpression> getClassExpressionsAsList() {
        return delegate.getClassExpressionsAsList();
    }

    @Override
    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return delegate.getDataPropertiesInSignature();
    }

    @Override
    public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
        return delegate.getObjectPropertiesInSignature();
    }

    @Override
    public Set<OWLClassExpression> getClassExpressionsMinus(OWLClassExpression... desc) {
        return delegate.getClassExpressionsMinus(desc);
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
    public int compareTo(OWLObject arg0) {
        return delegate.compareTo(arg0);
    }

    @Override
    public Set<OWLClass> getClassesInSignature() {
        return delegate.getClassesInSignature();
    }

    @Override
    public OWLDisjointClassesAxiom getAxiomWithoutAnnotations() {
        return delegate.getAxiomWithoutAnnotations();
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
    public boolean contains(OWLClassExpression ce) {
        return delegate.contains(ce);
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
    public boolean isAnnotationAxiom() {
        return delegate.isAnnotationAxiom();
    }

    @Override
    public Set<OWLAnnotationProperty> getAnnotationPropertiesInSignature() {
        return delegate.getAnnotationPropertiesInSignature();
    }

    @Override
    public Collection<OWLDisjointClassesAxiom> splitToAnnotatedPairs() {
        return delegate.splitToAnnotatedPairs();
    }

    @Override
    public <T> Collection<T> walkPairwise(OWLPairwiseVisitor<T, OWLClassExpression> visitor) {
        return delegate.walkPairwise(visitor);
    }

    @Override
    public <T extends OWLAxiom> T getAnnotatedAxiom(Stream<OWLAnnotation> annotations) {
        return delegate.getAnnotatedAxiom(annotations);
    }
}
