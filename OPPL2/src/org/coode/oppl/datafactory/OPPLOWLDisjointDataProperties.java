/**
 * 
 */
package org.coode.oppl.datafactory;

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
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLOWLDisjointDataProperties extends
		AbstractInlineSetAxiom<OWLDataPropertyExpression> implements
		OWLDisjointDataPropertiesAxiom {
	private final OWLDisjointDataPropertiesAxiom delegate;

	public OPPLOWLDisjointDataProperties(OPPLOWLDataFactory dataFactory,
			InlineSet<OWLDataPropertyExpression> propertyExpressions,
			Set<? extends OWLAnnotation> annotations) {
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
		this.delegate = dataFactory.getDelegate()
				.getOWLDisjointDataPropertiesAxiom(propertyExpressions,
						annotations);
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
	 * @see org.semanticweb.owlapi.model.OWLNaryPropertyAxiom#getProperties()
	 */
	public Set<OWLDataPropertyExpression> getProperties() {
		return this.delegate.getProperties();
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLNaryPropertyAxiom#getPropertiesMinus(org.semanticweb.owlapi.model.OWLPropertyExpression)
	 */
	public Set<OWLDataPropertyExpression> getPropertiesMinus(
			OWLDataPropertyExpression property) {
		return this.delegate.getPropertiesMinus(property);
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
	 * @see org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom#getAxiomWithoutAnnotations()
	 */
	public OWLDisjointDataPropertiesAxiom getAxiomWithoutAnnotations() {
		return this.delegate.getAxiomWithoutAnnotations();
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
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAnnotations()
	 */
	public Set<OWLAnnotation> getAnnotations() {
		return this.delegate.getAnnotations();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getDataPropertiesInSignature()
	 */
	public Set<OWLDataProperty> getDataPropertiesInSignature() {
		return this.delegate.getDataPropertiesInSignature();
	}

	/**
	 * @param annotationProperty
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAnnotations(org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	public Set<OWLAnnotation> getAnnotations(
			OWLAnnotationProperty annotationProperty) {
		return this.delegate.getAnnotations(annotationProperty);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLObject#getObjectPropertiesInSignature()
	 */
	public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
		return this.delegate.getObjectPropertiesInSignature();
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
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLAxiom#getAnnotatedAxiom(java.util.Set)
	 */
	public OWLAxiom getAnnotatedAxiom(Set<OWLAnnotation> annotations) {
		return this.delegate.getAnnotatedAxiom(annotations);
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
	 * @param o
	 * @return
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(OWLObject o) {
		return this.delegate.compareTo(o);
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
}
