package org.coode.oppl.utils;

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
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;

public class DefaultOWLAxiomVisitorAdapter extends OWLAxiomVisitorAdapter {
    protected void doDefault(OWLAxiom axiom) {}

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLAsymmetricObjectPropertyAxiom) */
    @Override
    public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLClassAssertionAxiom) */
    @Override
    public void visit(OWLClassAssertionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDataPropertyAssertionAxiom) */
    @Override
    public void visit(OWLDataPropertyAssertionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDataPropertyDomainAxiom) */
    @Override
    public void visit(OWLDataPropertyDomainAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDataPropertyRangeAxiom) */
    @Override
    public void visit(OWLDataPropertyRangeAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDeclarationAxiom) */
    @Override
    public void visit(OWLDeclarationAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDifferentIndividualsAxiom) */
    @Override
    public void visit(OWLDifferentIndividualsAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDisjointClassesAxiom) */
    @Override
    public void visit(OWLDisjointClassesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDisjointDataPropertiesAxiom) */
    @Override
    public void visit(OWLDisjointDataPropertiesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDisjointObjectPropertiesAxiom) */
    @Override
    public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDisjointUnionAxiom) */
    @Override
    public void visit(OWLDisjointUnionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLEquivalentClassesAxiom) */
    @Override
    public void visit(OWLEquivalentClassesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLEquivalentDataPropertiesAxiom) */
    @Override
    public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLEquivalentObjectPropertiesAxiom) */
    @Override
    public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLFunctionalDataPropertyAxiom) */
    @Override
    public void visit(OWLFunctionalDataPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLFunctionalObjectPropertyAxiom) */
    @Override
    public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLHasKeyAxiom) */
    @Override
    public void visit(OWLHasKeyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLInverseFunctionalObjectPropertyAxiom) */
    @Override
    public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLInverseObjectPropertiesAxiom) */
    @Override
    public void visit(OWLInverseObjectPropertiesAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLIrreflexiveObjectPropertyAxiom) */
    @Override
    public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLNegativeDataPropertyAssertionAxiom) */
    @Override
    public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLNegativeObjectPropertyAssertionAxiom) */
    @Override
    public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLObjectPropertyAssertionAxiom) */
    @Override
    public void visit(OWLObjectPropertyAssertionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSubPropertyChainOfAxiom) */
    @Override
    public void visit(OWLSubPropertyChainOfAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLObjectPropertyDomainAxiom) */
    @Override
    public void visit(OWLObjectPropertyDomainAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLObjectPropertyRangeAxiom) */
    @Override
    public void visit(OWLObjectPropertyRangeAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLReflexiveObjectPropertyAxiom) */
    @Override
    public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSameIndividualAxiom) */
    @Override
    public void visit(OWLSameIndividualAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSubClassOfAxiom) */
    @Override
    public void visit(OWLSubClassOfAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSubDataPropertyOfAxiom) */
    @Override
    public void visit(OWLSubDataPropertyOfAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSubObjectPropertyOfAxiom) */
    @Override
    public void visit(OWLSubObjectPropertyOfAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSymmetricObjectPropertyAxiom) */
    @Override
    public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLTransitiveObjectPropertyAxiom) */
    @Override
    public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.SWRLRule) */
    @Override
    public void visit(SWRLRule rule) {
        doDefault(rule);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLAnnotationAssertionAxiom) */
    @Override
    public void visit(OWLAnnotationAssertionAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLAnnotationPropertyDomainAxiom) */
    @Override
    public void visit(OWLAnnotationPropertyDomainAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLAnnotationPropertyRangeAxiom) */
    @Override
    public void visit(OWLAnnotationPropertyRangeAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLSubAnnotationPropertyOfAxiom) */
    @Override
    public void visit(OWLSubAnnotationPropertyOfAxiom axiom) {
        doDefault(axiom);
    }

    /** @see org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter#visit(org.semanticweb
     *      .owlapi.model.OWLDatatypeDefinitionAxiom) */
    @Override
    public void visit(OWLDatatypeDefinitionAxiom axiom) {
        doDefault(axiom);
    }
}
