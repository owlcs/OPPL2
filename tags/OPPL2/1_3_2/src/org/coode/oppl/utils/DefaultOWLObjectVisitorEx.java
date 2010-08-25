/**
 * 
 */
package org.coode.oppl.utils;

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
import org.semanticweb.owl.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultOWLObjectVisitorEx<O> extends
		OWLObjectVisitorExAdapter<O> {
	protected abstract O doDefault(OWLObject object);

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLAxiomAnnotationAxiom)
	 */
	@Override
	public O visit(OWLAxiomAnnotationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLClass)
	 */
	@Override
	public O visit(OWLClass desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLClassAssertionAxiom)
	 */
	@Override
	public O visit(OWLClassAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLConstantAnnotation)
	 */
	@Override
	public O visit(OWLConstantAnnotation annotation) {
		return this.doDefault(annotation);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataAllRestriction)
	 */
	@Override
	public O visit(OWLDataAllRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataComplementOf)
	 */
	@Override
	public O visit(OWLDataComplementOf node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataExactCardinalityRestriction)
	 */
	@Override
	public O visit(OWLDataExactCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction)
	 */
	@Override
	public O visit(OWLDataMaxCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataMinCardinalityRestriction)
	 */
	@Override
	public O visit(OWLDataMinCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataOneOf)
	 */
	@Override
	public O visit(OWLDataOneOf node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataProperty)
	 */
	@Override
	public O visit(OWLDataProperty property) {
		return this.doDefault(property);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom)
	 */
	@Override
	public O visit(OWLDataPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataPropertyDomainAxiom)
	 */
	@Override
	public O visit(OWLDataPropertyDomainAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataPropertyRangeAxiom)
	 */
	@Override
	public O visit(OWLDataPropertyRangeAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataRangeFacetRestriction)
	 */
	@Override
	public O visit(OWLDataRangeFacetRestriction node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataRangeRestriction)
	 */
	@Override
	public O visit(OWLDataRangeRestriction node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataSomeRestriction)
	 */
	@Override
	public O visit(OWLDataSomeRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataSubPropertyAxiom)
	 */
	@Override
	public O visit(OWLDataSubPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataType)
	 */
	@Override
	public O visit(OWLDataType node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDataValueRestriction)
	 */
	@Override
	public O visit(OWLDataValueRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDeclarationAxiom)
	 */
	@Override
	public O visit(OWLDeclarationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDifferentIndividualsAxiom)
	 */
	@Override
	public O visit(OWLDifferentIndividualsAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDisjointClassesAxiom)
	 */
	@Override
	public O visit(OWLDisjointClassesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom)
	 */
	@Override
	public O visit(OWLDisjointDataPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom)
	 */
	@Override
	public O visit(OWLDisjointObjectPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLDisjointUnionAxiom)
	 */
	@Override
	public O visit(OWLDisjointUnionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLEntityAnnotationAxiom)
	 */
	@Override
	public O visit(OWLEntityAnnotationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLEquivalentClassesAxiom)
	 */
	@Override
	public O visit(OWLEquivalentClassesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom)
	 */
	@Override
	public O visit(OWLEquivalentDataPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom)
	 */
	@Override
	public O visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom)
	 */
	@Override
	public O visit(OWLFunctionalDataPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLFunctionalObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLImportsDeclaration)
	 */
	@Override
	public O visit(OWLImportsDeclaration axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLIndividual)
	 */
	@Override
	public O visit(OWLIndividual individual) {
		return this.doDefault(individual);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom)
	 */
	@Override
	public O visit(OWLInverseObjectPropertiesAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom)
	 */
	@Override
	public O visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom)
	 */
	@Override
	public O visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectAllRestriction)
	 */
	@Override
	public O visit(OWLObjectAllRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectAnnotation)
	 */
	@Override
	public O visit(OWLObjectAnnotation annotation) {
		return this.doDefault(annotation);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectComplementOf)
	 */
	@Override
	public O visit(OWLObjectComplementOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction)
	 */
	@Override
	public O visit(OWLObjectExactCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectIntersectionOf)
	 */
	@Override
	public O visit(OWLObjectIntersectionOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction)
	 */
	@Override
	public O visit(OWLObjectMaxCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction)
	 */
	@Override
	public O visit(OWLObjectMinCardinalityRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectOneOf)
	 */
	@Override
	public O visit(OWLObjectOneOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectProperty)
	 */
	@Override
	public O visit(OWLObjectProperty property) {
		return this.doDefault(property);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom)
	 */
	@Override
	public O visit(OWLObjectPropertyAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom)
	 */
	@Override
	public O visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom)
	 */
	@Override
	public O visit(OWLObjectPropertyDomainAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectPropertyInverse)
	 */
	@Override
	public O visit(OWLObjectPropertyInverse property) {
		return this.doDefault(property);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom)
	 */
	@Override
	public O visit(OWLObjectPropertyRangeAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectSelfRestriction)
	 */
	@Override
	public O visit(OWLObjectSelfRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectSomeRestriction)
	 */
	@Override
	public O visit(OWLObjectSomeRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectSubPropertyAxiom)
	 */
	@Override
	public O visit(OWLObjectSubPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectUnionOf)
	 */
	@Override
	public O visit(OWLObjectUnionOf desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLObjectValueRestriction)
	 */
	@Override
	public O visit(OWLObjectValueRestriction desc) {
		return this.doDefault(desc);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLOntology)
	 */
	@Override
	public O visit(OWLOntology ontology) {
		return this.doDefault(ontology);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLOntologyAnnotationAxiom)
	 */
	@Override
	public O visit(OWLOntologyAnnotationAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLReflexiveObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLSameIndividualsAxiom)
	 */
	@Override
	public O visit(OWLSameIndividualsAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLSubClassAxiom)
	 */
	@Override
	public O visit(OWLSubClassAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLSymmetricObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom)
	 */
	@Override
	public O visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLTypedConstant)
	 */
	@Override
	public O visit(OWLTypedConstant node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.OWLUntypedConstant)
	 */
	@Override
	public O visit(OWLUntypedConstant node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLAtomConstantObject)
	 */
	@Override
	public O visit(SWRLAtomConstantObject node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLAtomDVariable)
	 */
	@Override
	public O visit(SWRLAtomDVariable node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLAtomIndividualObject)
	 */
	@Override
	public O visit(SWRLAtomIndividualObject node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLAtomIVariable)
	 */
	@Override
	public O visit(SWRLAtomIVariable node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLBuiltInAtom)
	 */
	@Override
	public O visit(SWRLBuiltInAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLClassAtom)
	 */
	@Override
	public O visit(SWRLClassAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLDataRangeAtom)
	 */
	@Override
	public O visit(SWRLDataRangeAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLDataValuedPropertyAtom)
	 */
	@Override
	public O visit(SWRLDataValuedPropertyAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLDifferentFromAtom)
	 */
	@Override
	public O visit(SWRLDifferentFromAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLObjectPropertyAtom)
	 */
	@Override
	public O visit(SWRLObjectPropertyAtom node) {
		return this.doDefault(node);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLRule)
	 */
	@Override
	public O visit(SWRLRule rule) {
		return this.doDefault(rule);
	}

	/**
	 * @see org.semanticweb.owl.util.OWLObjectVisitorExAdapter#visit(org.semanticweb.owl.model.SWRLSameAsAtom)
	 */
	@Override
	public O visit(SWRLSameAsAtom node) {
		return this.doDefault(node);
	}
}
