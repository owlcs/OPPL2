/**
 * 
 */
package org.coode.oppl.utils;

import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultOWLAxiomVisitorEx<O> implements OWLAxiomVisitorEx<O> {
	protected abstract O doDefault(OWLAxiom axiom);

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLSubClassAxiom)
	 */
	public O visit(OWLSubClassOfAxiom axiom) {
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
	public O visit(OWLAsymmetricObjectPropertyAxiom axiom) {
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
		return this.doDefault(axiom);
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
		return this.doDefault(axiom);
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
	public O visit(OWLSubObjectPropertyOfAxiom axiom) {
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
	public O visit(OWLSubDataPropertyOfAxiom axiom) {
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
	public O visit(OWLSameIndividualAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom)
	 */
	public O visit(OWLSubPropertyChainOfAxiom axiom) {
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
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom)
	 */
	public O visit(OWLSubAnnotationPropertyOfAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom)
	 */
	public O visit(OWLAnnotationPropertyDomainAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom)
	 */
	public O visit(OWLAnnotationPropertyRangeAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom)
	 */
	public O visit(OWLAnnotationAssertionAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLHasKeyAxiom)
	 */
	public O visit(OWLHasKeyAxiom axiom) {
		return this.doDefault(axiom);
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom)
	 */
	public O visit(OWLDatatypeDefinitionAxiom axiom) {
		return this.doDefault(axiom);
	}
}
