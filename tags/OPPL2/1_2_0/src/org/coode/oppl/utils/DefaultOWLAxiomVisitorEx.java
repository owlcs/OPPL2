/**
 * 
 */
package org.coode.oppl.utils;

import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiomVisitorEx;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
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
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.SWRLRule;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class DefaultOWLAxiomVisitorEx<O> implements
		OWLAxiomVisitorEx<O> {
	protected abstract O doDefault(OWLAxiom axiom);

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
}
