package org.coode.oppl.utils;

import org.coode.oppl.ConstraintSystem;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLBuiltInAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLDataRangeAtom;
import org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLSameIndividualAtom;
import org.semanticweb.owlapi.model.SWRLVariable;

/**
 * @author Luigi Iannone
 */
public abstract class AbstractVariableDetector implements OWLObjectVisitorEx<Boolean> {

    protected ConstraintSystem constraintSystem;

    /**
     * @param constraintSystem constraintSystem
     */
    protected AbstractVariableDetector(ConstraintSystem constraintSystem) {
        this.constraintSystem = constraintSystem;
    }

    @Override
    public Boolean visit(OWLObjectIntersectionOf desc) {
        return Boolean.valueOf(desc.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectUnionOf desc) {
        return Boolean.valueOf(desc.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectComplementOf desc) {
        return desc.getOperand().accept(this);
    }

    @Override
    public Boolean visit(OWLObjectSomeValuesFrom desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
            || desc.getFiller().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLObjectAllValuesFrom desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
            || desc.getFiller().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLObjectHasValue desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
            || desc.getFiller().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLAnonymousIndividual individual) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLObjectMinCardinality desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
            || (desc.getFiller() == null ? false : desc.getFiller().accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectExactCardinality desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
            || (desc.getFiller() == null ? false : desc.getFiller().accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectMaxCardinality desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
            || (desc.getFiller() == null ? false : desc.getFiller().accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectHasSelf desc) {
        return Boolean
            .valueOf(constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty()));
    }

    @Override
    public Boolean visit(OWLObjectOneOf desc) {
        return Boolean.valueOf(desc.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLDataSomeValuesFrom desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLDataProperty()));
    }

    @Override
    public Boolean visit(OWLDataAllValuesFrom desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLDataProperty()));
    }

    @Override
    public Boolean visit(OWLDataHasValue desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLDataProperty()));
    }

    @Override
    public Boolean visit(OWLDataMinCardinality desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLDataProperty()));
    }

    @Override
    public Boolean visit(OWLDataExactCardinality desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLDataProperty()));
    }

    @Override
    public Boolean visit(OWLDataMaxCardinality desc) {
        return Boolean.valueOf(constraintSystem.isVariable(desc.getProperty().asOWLDataProperty()));
    }

    @Override
    public Boolean visit(OWLSubClassOfAxiom axiom) {
        return Boolean.valueOf(axiom.getSubClass().accept(this).booleanValue()
            || axiom.getSuperClass().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getSubject().accept(this).booleanValue()
            || axiom.getObject().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLDisjointClassesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLDataPropertyDomainAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getDomain().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLObjectPropertyDomainAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getDomain().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getSubject().accept(this).booleanValue()
            || axiom.getObject().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLDifferentIndividualsAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLDisjointDataPropertiesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectPropertyRangeAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getRange().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLObjectPropertyAssertionAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getSubject().accept(this).booleanValue()
            || axiom.getObject().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLSubObjectPropertyOfAxiom axiom) {
        return Boolean.valueOf(axiom.getSubProperty().accept(this).booleanValue()
            || axiom.getSuperProperty().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLDisjointUnionAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLDeclarationAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLDataPropertyRangeAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getRange().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLFunctionalDataPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLClassAssertionAxiom axiom) {
        return Boolean.valueOf(axiom.getClassExpression().accept(this).booleanValue()
            || axiom.getIndividual().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLEquivalentClassesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLDataPropertyAssertionAxiom axiom) {
        return Boolean.valueOf(axiom.getProperty().accept(this).booleanValue()
            || axiom.getSubject().accept(this).booleanValue()
            || axiom.getObject().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLSubDataPropertyOfAxiom axiom) {
        return Boolean.valueOf(axiom.getSubProperty().accept(this).booleanValue()
            || axiom.getSuperProperty().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLSameIndividualAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLSubPropertyChainOfAxiom axiom) {
        boolean found =
            axiom.getPropertyChain().stream().anyMatch(o -> o.accept(this).booleanValue());
        return Boolean.valueOf(found || axiom.getSuperProperty().accept(this).booleanValue());
    }

    @Override
    public Boolean visit(OWLInverseObjectPropertiesAxiom axiom) {
        return Boolean.valueOf(axiom.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(SWRLRule rule) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLDatatype node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLDataComplementOf node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLDataOneOf node) {
        return Boolean.valueOf(node.operands().anyMatch(o -> o.accept(this).booleanValue()));
    }

    @Override
    public Boolean visit(OWLObjectInverseOf property) {
        return property.getInverseProperty().accept(this);
    }

    @Override
    public Boolean visit(OWLDatatypeRestriction node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLClassAtom node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLDataRangeAtom node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLObjectPropertyAtom node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLOntology ontology) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLSubAnnotationPropertyOfAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLAnnotationPropertyDomainAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLAnnotationPropertyRangeAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLAnnotation node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(IRI iri) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLAnnotationProperty property) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLDataIntersectionOf node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLDataUnionOf node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLFacetRestriction node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLAnnotationAssertionAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLHasKeyAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(OWLDatatypeDefinitionAxiom axiom) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLDataPropertyAtom node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLBuiltInAtom node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLVariable node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLIndividualArgument node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLLiteralArgument node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLSameIndividualAtom node) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(SWRLDifferentIndividualsAtom node) {
        return Boolean.FALSE;
    }
}
