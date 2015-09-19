package org.coode.parsers.test;

import org.coode.parsers.OWLAxiomType;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

@SuppressWarnings("javadoc")
public class TypeAssociation extends OWLObjectVisitorExAdapter<OWLAxiomType> {

    public TypeAssociation() {
        super(null);
    }

    @Override
    public OWLAxiomType visit(OWLSubClassOfAxiom axiom) {
        return OWLAxiomType.SUBCLASS;
    }

    @Override
    public OWLAxiomType visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION;
    }

    @Override
    public OWLAxiomType visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLDisjointClassesAxiom axiom) {
        return OWLAxiomType.DISJOINT_CLASSES;
    }

    @Override
    public OWLAxiomType visit(OWLDataPropertyDomainAxiom axiom) {
        return OWLAxiomType.DATA_PROPERTY_DOMAIN;
    }

    @Override
    public OWLAxiomType visit(OWLObjectPropertyDomainAxiom axiom) {
        return OWLAxiomType.OBJECT_PROPERTY_DOMAIN;
    }

    @Override
    public OWLAxiomType visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES;
    }

    @Override
    public OWLAxiomType visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return OWLAxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION;
    }

    @Override
    public OWLAxiomType visit(OWLDifferentIndividualsAxiom axiom) {
        return OWLAxiomType.DIFFERENT_INDIVIDUALS;
    }

    @Override
    public OWLAxiomType visit(OWLDisjointDataPropertiesAxiom axiom) {
        return OWLAxiomType.DISJOINT_DATA_PROPERTIES;
    }

    @Override
    public OWLAxiomType visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return OWLAxiomType.DISJOINT_OBJECT_PROPERTIES;
    }

    @Override
    public OWLAxiomType visit(OWLObjectPropertyRangeAxiom axiom) {
        return OWLAxiomType.OBJECT_PROPERTY_RANGE;
    }

    @Override
    public OWLAxiomType visit(OWLObjectPropertyAssertionAxiom axiom) {
        return OWLAxiomType.OBJECT_PROPERTY_ASSERTION;
    }

    @Override
    public OWLAxiomType visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLSubObjectPropertyOfAxiom axiom) {
        return OWLAxiomType.SUB_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLHasKeyAxiom axiom) {
        return OWLAxiomType.HAS_KEY;
    }

    @Override
    public OWLAxiomType visit(OWLDisjointUnionAxiom axiom) {
        return null;
    }

    @Override
    public OWLAxiomType visit(OWLDeclarationAxiom axiom) {
        return null;
    }

    @Override
    public OWLAxiomType visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLDataPropertyRangeAxiom axiom) {
        return OWLAxiomType.DATA_PROPERTY_RANGE;
    }

    @Override
    public OWLAxiomType visit(OWLFunctionalDataPropertyAxiom axiom) {
        return OWLAxiomType.FUNCTIONAL_DATA_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return OWLAxiomType.EQUIVALENT_DATA_PROPERTIES;
    }

    @Override
    public OWLAxiomType visit(OWLClassAssertionAxiom axiom) {
        return OWLAxiomType.CLASS_ASSERTION;
    }

    @Override
    public OWLAxiomType visit(OWLEquivalentClassesAxiom axiom) {
        return OWLAxiomType.EQUIVALENT_CLASSES;
    }

    @Override
    public OWLAxiomType visit(OWLDataPropertyAssertionAxiom axiom) {
        return OWLAxiomType.DATA_PROPERTY_ASSERTION;
    }

    @Override
    public OWLAxiomType visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLSubDataPropertyOfAxiom axiom) {
        return OWLAxiomType.SUB_DATA_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLSameIndividualAxiom axiom) {
        return OWLAxiomType.SAME_INDIVIDUAL;
    }

    @Override
    public OWLAxiomType visit(OWLSubPropertyChainOfAxiom axiom) {
        return OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY;
    }

    @Override
    public OWLAxiomType visit(OWLInverseObjectPropertiesAxiom axiom) {
        return OWLAxiomType.INVERSE_OBJECT_PROPERTIES;
    }

    @Override
    public OWLAxiomType visit(OWLAnnotationAssertionAxiom axiom) {
        return OWLAxiomType.ANNOTATION_ASSERTION;
    }

    @Override
    public OWLAxiomType visit(SWRLRule rule) {
        return null;
    }
}
