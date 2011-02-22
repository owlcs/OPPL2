/**
 * 
 */
package org.coode.oppl.datafactory;

import java.util.List;
import java.util.Set;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
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
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLOWLDisjointClassesAxiom extends AbstractInlineSetAxiom<OWLClassExpression>
		implements OWLDisjointClassesAxiom {
	private final OWLDisjointClassesAxiom delegate;
	private final boolean shouldExpandAsPairWise;

	public OPPLOWLDisjointClassesAxiom(OPPLOWLDataFactory dataFactory,
			InlineSet<OWLClassExpression> classExpressions,
			Set<? extends OWLAnnotation> annotations, boolean shouldExpandAsPairWise) {
		super(classExpressions);
		if (dataFactory == null) {
			throw new NullPointerException("The data factory cannot be null");
		}
		if (classExpressions == null) {
			throw new NullPointerException("The inline set cannot be null");
		}
		if (annotations == null) {
			throw new NullPointerException("The annotations cannot be null");
		}
		this.shouldExpandAsPairWise = shouldExpandAsPairWise;
		this.delegate = dataFactory.getDelegate().getOWLDisjointClassesAxiom(
				classExpressions,
				annotations);
	}

	/**
	 * @return the shouldExpandAsPairwise
	 */
	public boolean shouldExpandAsPairWise() {
		return this.shouldExpandAsPairWise;
	}

	// Delegate methods
	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getSignature()
	 */
	public Set<OWLEntity> getSignature() {
		return this.delegate.getSignature();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLNaryClassAxiom#getClassExpressions()
	 */
	public Set<OWLClassExpression> getClassExpressions() {
		return this.delegate.getClassExpressions();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLSubClassOfAxiomSetShortCut#asOWLSubClassOfAxioms()
	 */
	public Set<OWLSubClassOfAxiom> asOWLSubClassOfAxioms() {
		return this.delegate.asOWLSubClassOfAxioms();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDisjointClassesAxiom#asPairwiseAxioms()
	 */
	public Set<OWLDisjointClassesAxiom> asPairwiseAxioms() {
		return this.delegate.asPairwiseAxioms();
	}

	/**
	 * @param visitor
	 * @see org.semanticweb.owlapi.model.OWLAxiom#accept(org.semanticweb.owlapi.model.OWLAxiomVisitor)
	 */
	public void accept(OWLAxiomVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * @param <O>
	 * @param visitor
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#accept(org.semanticweb.owlapi.model.OWLAxiomVisitorEx)
	 */
	public <O> O accept(OWLAxiomVisitorEx<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLNaryClassAxiom#getClassExpressionsAsList()
	 */
	public List<OWLClassExpression> getClassExpressionsAsList() {
		return this.delegate.getClassExpressionsAsList();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getDataPropertiesInSignature()
	 */
	public Set<OWLDataProperty> getDataPropertiesInSignature() {
		return this.delegate.getDataPropertiesInSignature();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getObjectPropertiesInSignature()
	 */
	public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
		return this.delegate.getObjectPropertiesInSignature();
	}

	/**
	 * @param desc
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLNaryClassAxiom#getClassExpressionsMinus(org.semanticweb.owlapi.model.OWLClassExpression[])
	 */
	public Set<OWLClassExpression> getClassExpressionsMinus(OWLClassExpression... desc) {
		return this.delegate.getClassExpressionsMinus(desc);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getIndividualsInSignature()
	 */
	public Set<OWLNamedIndividual> getIndividualsInSignature() {
		return this.delegate.getIndividualsInSignature();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getDatatypesInSignature()
	 */
	public Set<OWLDatatype> getDatatypesInSignature() {
		return this.delegate.getDatatypesInSignature();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getNestedClassExpressions()
	 */
	public Set<OWLClassExpression> getNestedClassExpressions() {
		return this.delegate.getNestedClassExpressions();
	}

	/**
	 * @param visitor
	 * @see org.semanticweb.owlapi.model.OWLObject#accept(org.semanticweb.owlapi.model.OWLObjectVisitor)
	 */
	public void accept(OWLObjectVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * @param <O>
	 * @param visitor
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#accept(org.semanticweb.owlapi.model.OWLObjectVisitorEx)
	 */
	public <O> O accept(OWLObjectVisitorEx<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(OWLObject arg0) {
		return this.delegate.compareTo(arg0);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getClassesInSignature()
	 */
	public Set<OWLClass> getClassesInSignature() {
		return this.delegate.getClassesInSignature();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDisjointClassesAxiom#getAxiomWithoutAnnotations()
	 */
	public OWLDisjointClassesAxiom getAxiomWithoutAnnotations() {
		return this.delegate.getAxiomWithoutAnnotations();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAnnotations()
	 */
	public Set<OWLAnnotation> getAnnotations() {
		return this.delegate.getAnnotations();
	}

	/**
	 * @param annotationProperty
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAnnotations(org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	public Set<OWLAnnotation> getAnnotations(OWLAnnotationProperty annotationProperty) {
		return this.delegate.getAnnotations(annotationProperty);
	}

	/**
	 * @param ce
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLNaryClassAxiom#contains(org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public boolean contains(OWLClassExpression ce) {
		return this.delegate.contains(ce);
	}

	/**
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAnnotatedAxiom(java.util.Set)
	 */
	public OWLAxiom getAnnotatedAxiom(Set<OWLAnnotation> annotations) {
		return this.delegate.getAnnotatedAxiom(annotations);
	}

	/**
	 * @param axiom
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#equalsIgnoreAnnotations(org.semanticweb.owlapi.model.OWLAxiom)
	 */
	public boolean equalsIgnoreAnnotations(OWLAxiom axiom) {
		return this.delegate.equalsIgnoreAnnotations(axiom);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#isTopEntity()
	 */
	public boolean isTopEntity() {
		return this.delegate.isTopEntity();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#isLogicalAxiom()
	 */
	public boolean isLogicalAxiom() {
		return this.delegate.isLogicalAxiom();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#isBottomEntity()
	 */
	public boolean isBottomEntity() {
		return this.delegate.isBottomEntity();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#isAnnotated()
	 */
	public boolean isAnnotated() {
		return this.delegate.isAnnotated();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAxiomType()
	 */
	public AxiomType<?> getAxiomType() {
		return this.delegate.getAxiomType();
	}

	/**
	 * @param axiomTypes
	 * @return
	 * @see 
	 *      org.semanticweb.owlapi.model.OWLAxiom#isOfType(org.semanticweb.owlapi
	 *      .model.AxiomType<?>[])
	 */
	public boolean isOfType(AxiomType<?>... axiomTypes) {
		return this.delegate.isOfType(axiomTypes);
	}

	/**
	 * @param types
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#isOfType(java.util.Set)
	 */
	public boolean isOfType(Set<AxiomType<?>> types) {
		return this.delegate.isOfType(types);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getNNF()
	 */
	public OWLAxiom getNNF() {
		return this.delegate.getNNF();
	}

	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.delegate.equals(obj);
	}

	@Override
	public String toString() {
		return this.delegate.toString();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#isAnnotationAxiom()
	 */
	public boolean isAnnotationAxiom() {
		return this.delegate.isAnnotationAxiom();
	}
}
