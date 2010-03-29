/**
 * 
 */
package org.semanticweb.owl.model.utils;

import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectAnnotation;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyInverse;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLObjectVisitorEx;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.model.SWRLAtomConstantObject;
import org.semanticweb.owl.model.SWRLAtomDVariable;
import org.semanticweb.owl.model.SWRLAtomIVariable;
import org.semanticweb.owl.model.SWRLAtomIndividualObject;
import org.semanticweb.owl.model.SWRLBuiltInAtom;
import org.semanticweb.owl.model.SWRLClassAtom;
import org.semanticweb.owl.model.SWRLDataRangeAtom;
import org.semanticweb.owl.model.SWRLDataValuedPropertyAtom;
import org.semanticweb.owl.model.SWRLDifferentFromAtom;
import org.semanticweb.owl.model.SWRLObjectPropertyAtom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.model.SWRLSameAsAtom;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultOWLObjectVisitorEx<O> implements
		OWLObjectVisitorEx<O> {
	protected abstract O doDefault(OWLObject owlObject);

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSubClassAxiom)
	 */
	public O visit(OWLSubClassAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom)
	 */
	public O visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom)
	 */
	public O visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom)
	 */
	public O visit(OWLReflexiveObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointClassesAxiom)
	 */
	public O visit(OWLDisjointClassesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataPropertyDomainAxiom)
	 */
	public O visit(OWLDataPropertyDomainAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLImportsDeclaration)
	 */
	public O visit(OWLImportsDeclaration axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLAxiomAnnotationAxiom)
	 */
	public O visit(OWLAxiomAnnotationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom)
	 */
	public O visit(OWLObjectPropertyDomainAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom)
	 */
	public O visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom)
	 */
	public O visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		return null;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDifferentIndividualsAxiom)
	 */
	public O visit(OWLDifferentIndividualsAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom)
	 */
	public O visit(OWLDisjointDataPropertiesAxiom axiom) {
		return null;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom)
	 */
	public O visit(OWLDisjointObjectPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom)
	 */
	public O visit(OWLObjectPropertyRangeAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom)
	 */
	public O visit(OWLObjectPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom)
	 */
	public O visit(OWLFunctionalObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectSubPropertyAxiom)
	 */
	public O visit(OWLObjectSubPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDisjointUnionAxiom)
	 */
	public O visit(OWLDisjointUnionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDeclarationAxiom)
	 */
	public O visit(OWLDeclarationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEntityAnnotationAxiom)
	 */
	public O visit(OWLEntityAnnotationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLOntologyAnnotationAxiom)
	 */
	public O visit(OWLOntologyAnnotationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom)
	 */
	public O visit(OWLSymmetricObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataPropertyRangeAxiom)
	 */
	public O visit(OWLDataPropertyRangeAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom)
	 */
	public O visit(OWLFunctionalDataPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom)
	 */
	public O visit(OWLEquivalentDataPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLClassAssertionAxiom)
	 */
	public O visit(OWLClassAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLEquivalentClassesAxiom)
	 */
	public O visit(OWLEquivalentClassesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom)
	 */
	public O visit(OWLDataPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom)
	 */
	public O visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom)
	 */
	public O visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLDataSubPropertyAxiom)
	 */
	public O visit(OWLDataSubPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom)
	 */
	public O visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSameIndividualsAxiom)
	 */
	public O visit(OWLSameIndividualsAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom)
	 */
	public O visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom)
	 */
	public O visit(OWLInverseObjectPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.SWRLRule)
	 */
	public O visit(SWRLRule rule) {
		return this.doDefault(rule);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLClass)
	 */
	public O visit(OWLClass desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectIntersectionOf)
	 */
	public O visit(OWLObjectIntersectionOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectUnionOf)
	 */
	public O visit(OWLObjectUnionOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectComplementOf)
	 */
	public O visit(OWLObjectComplementOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectSomeRestriction)
	 */
	public O visit(OWLObjectSomeRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectAllRestriction)
	 */
	public O visit(OWLObjectAllRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectValueRestriction)
	 */
	public O visit(OWLObjectValueRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction)
	 */
	public O visit(OWLObjectMinCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction)
	 */
	public O visit(OWLObjectExactCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction)
	 */
	public O visit(OWLObjectMaxCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectSelfRestriction)
	 */
	public O visit(OWLObjectSelfRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectOneOf)
	 */
	public O visit(OWLObjectOneOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLDataSomeRestriction)
	 */
	public O visit(OWLDataSomeRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLDataAllRestriction)
	 */
	public O visit(OWLDataAllRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLDataValueRestriction)
	 */
	public O visit(OWLDataValueRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLDataMinCardinalityRestriction)
	 */
	public O visit(OWLDataMinCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLDataExactCardinalityRestriction)
	 */
	public O visit(OWLDataExactCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction)
	 */
	public O visit(OWLDataMaxCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataType)
	 */
	public O visit(OWLDataType node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataComplementOf)
	 */
	public O visit(OWLDataComplementOf node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataOneOf)
	 */
	public O visit(OWLDataOneOf node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataRangeRestriction)
	 */
	public O visit(OWLDataRangeRestriction node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLTypedConstant)
	 */
	public O visit(OWLTypedConstant node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLUntypedConstant)
	 */
	public O visit(OWLUntypedConstant node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataRangeFacetRestriction)
	 */
	public O visit(OWLDataRangeFacetRestriction node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectProperty)
	 */
	public O visit(OWLObjectProperty property) {
		return this.doDefault(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyInverse)
	 */
	public O visit(OWLObjectPropertyInverse property) {
		return this.doDefault(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.semanticweb.owl.model.OWLDataProperty)
	 */
	public O visit(OWLDataProperty property) {
		return this.doDefault(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLEntityVisitorEx#visit(org.semanticweb.owl.model.OWLIndividual)
	 */
	public O visit(OWLIndividual individual) {
		return this.doDefault(individual);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAnnotationVisitorEx#visit(org.semanticweb.owl.model.OWLObjectAnnotation)
	 */
	public O visit(OWLObjectAnnotation annotation) {
		return this.doDefault(annotation);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAnnotationVisitorEx#visit(org.semanticweb.owl.model.OWLConstantAnnotation)
	 */
	public O visit(OWLConstantAnnotation annotation) {
		return this.doDefault(annotation);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLClassAtom)
	 */
	public O visit(SWRLClassAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLDataRangeAtom)
	 */
	public O visit(SWRLDataRangeAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLObjectPropertyAtom)
	 */
	public O visit(SWRLObjectPropertyAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLDataValuedPropertyAtom)
	 */
	public O visit(SWRLDataValuedPropertyAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLBuiltInAtom)
	 */
	public O visit(SWRLBuiltInAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLAtomDVariable)
	 */
	public O visit(SWRLAtomDVariable node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLAtomIVariable)
	 */
	public O visit(SWRLAtomIVariable node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLAtomIndividualObject)
	 */
	public O visit(SWRLAtomIndividualObject node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLAtomConstantObject)
	 */
	public O visit(SWRLAtomConstantObject node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLSameAsAtom)
	 */
	public O visit(SWRLSameAsAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl.model.SWRLDifferentFromAtom)
	 */
	public O visit(SWRLDifferentFromAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLNamedObjectVisitorEx#visit(org.semanticweb.owl.model.OWLOntology)
	 */
	public O visit(OWLOntology ontology) {
		return this.doDefault(ontology);
	}
}
