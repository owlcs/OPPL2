package org.coode.oppl.querymatching;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
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

abstract class AbstractAxiomQuery implements AxiomQuery {
	protected abstract Set<BindingNode> match(OWLAxiom axiom);

	private final Set<BindingNode> leaves = new HashSet<BindingNode>();

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDeclarationAxiom)
	 */
	public void visit(OWLDeclarationAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubClassOfAxiom)
	 */
	public void visit(OWLSubClassOfAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom)
	 */
	public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom)
	 */
	public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom)
	 */
	public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointClassesAxiom)
	 */
	public void visit(OWLDisjointClassesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom)
	 */
	public void visit(OWLDataPropertyDomainAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom)
	 */
	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom)
	 */
	public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom)
	 */
	public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom)
	 */
	public void visit(OWLDifferentIndividualsAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom)
	 */
	public void visit(OWLDisjointDataPropertiesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom)
	 */
	public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom)
	 */
	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom)
	 */
	public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom)
	 */
	public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom)
	 */
	public void visit(OWLSubObjectPropertyOfAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointUnionAxiom)
	 */
	public void visit(OWLDisjointUnionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom)
	 */
	public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom)
	 */
	public void visit(OWLDataPropertyRangeAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom)
	 */
	public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom)
	 */
	public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLClassAssertionAxiom)
	 */
	public void visit(OWLClassAssertionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom)
	 */
	public void visit(OWLEquivalentClassesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom)
	 */
	public void visit(OWLDataPropertyAssertionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom)
	 */
	public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom)
	 */
	public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom)
	 */
	public void visit(OWLSubDataPropertyOfAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom)
	 */
	public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSameIndividualAxiom)
	 */
	public void visit(OWLSameIndividualAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom)
	 */
	public void visit(OWLSubPropertyChainOfAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom)
	 */
	public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLHasKeyAxiom)
	 */
	public void visit(OWLHasKeyAxiom axiom) {
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom)
	 */
	public void visit(OWLDatatypeDefinitionAxiom axiom) {
		this.leaves.addAll(this.match(axiom));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.SWRLRule)
	 */
	public void visit(SWRLRule rule) {
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom)
	 */
	public void visit(OWLAnnotationAssertionAxiom axiom) {
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom)
	 */
	public void visit(OWLSubAnnotationPropertyOfAxiom axiom) {
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom)
	 */
	public void visit(OWLAnnotationPropertyDomainAxiom axiom) {
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom)
	 */
	public void visit(OWLAnnotationPropertyRangeAxiom axiom) {
	}

	/**
	 * @return the leaves
	 */
	public Set<BindingNode> getLeaves() {
		return new HashSet<BindingNode>(this.leaves);
	}
}
