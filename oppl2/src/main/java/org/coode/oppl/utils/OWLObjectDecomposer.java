package org.coode.oppl.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
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
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
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
import org.semanticweb.owlapi.model.OWLObjectProperty;
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

/** @author Luigi Iannone */
public final class OWLObjectDecomposer implements OWLObjectVisitorEx<List<Object>> {
    @Override
    public List<Object> visit(OWLSubClassOfAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getSubClass());
        toReturn.add(axiom.getSuperClass());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getSubject());
        toReturn.add(axiom.getObject());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLReflexiveObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDisjointClassesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getClassExpressions());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataPropertyDomainAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getDomain());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectPropertyDomainAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getDomain());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getProperties());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getSubject());
        toReturn.add(axiom.getObject());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDifferentIndividualsAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getIndividuals());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDisjointDataPropertiesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getProperties());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDisjointObjectPropertiesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getProperties());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectPropertyRangeAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getRange());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectPropertyAssertionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getSubject());
        toReturn.add(axiom.getObject());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLFunctionalObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLSubObjectPropertyOfAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getSubProperty());
        toReturn.add(axiom.getSuperProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDisjointUnionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getClassExpressions());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDeclarationAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getEntity());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLAnnotationAssertionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getSubject());
        toReturn.add(axiom.getAnnotation());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLSymmetricObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataPropertyRangeAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getRange());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLFunctionalDataPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLEquivalentDataPropertiesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getProperties());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLClassAssertionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getClassExpression());
        toReturn.add(axiom.getIndividual());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLEquivalentClassesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getClassExpressions());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataPropertyAssertionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getSubject());
        toReturn.add(axiom.getObject());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLTransitiveObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLSubDataPropertyOfAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getSubProperty());
        toReturn.add(axiom.getSuperProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLSameIndividualAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getIndividuals());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLSubPropertyChainOfAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(axiom.getPropertyChain());
        toReturn.add(axiom.getSuperProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLInverseObjectPropertiesAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getFirstProperty());
        toReturn.add(axiom.getSecondProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLHasKeyAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getClassExpression());
        toReturn.addAll(axiom.getPropertyExpressions());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDatatypeDefinitionAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getDatatype());
        toReturn.add(axiom.getDataRange());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLRule rule) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(rule.getHead());
        toReturn.addAll(rule.getBody());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLSubAnnotationPropertyOfAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getSubProperty());
        toReturn.add(axiom.getSuperProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLAnnotationPropertyDomainAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getDomain());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLAnnotationPropertyRangeAxiom axiom) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(axiom.getProperty());
        toReturn.add(axiom.getRange());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLClass ce) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLObjectIntersectionOf ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(ce.getOperands());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectUnionOf ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(ce.getOperands());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectComplementOf ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getOperand());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectSomeValuesFrom ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectAllValuesFrom ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectHasValue ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getValue());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectMinCardinality ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getCardinality());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectExactCardinality ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getCardinality());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectMaxCardinality ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getCardinality());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectHasSelf ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectOneOf ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(ce.getIndividuals());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataSomeValuesFrom ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataAllValuesFrom ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataHasValue ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getValue());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataMinCardinality ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getCardinality());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataExactCardinality ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getCardinality());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataMaxCardinality ce) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(ce.getProperty());
        toReturn.add(ce.getCardinality());
        toReturn.add(ce.getFiller());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDatatype node) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLDataComplementOf node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getDataRange());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataOneOf node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(node.getValues());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataIntersectionOf node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(node.getOperands());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataUnionOf node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(node.getOperands());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDatatypeRestriction node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.addAll(node.getFacetRestrictions());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLLiteral node) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLFacetRestriction node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getFacet());
        toReturn.add(node.getFacetValue());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLObjectProperty property) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLObjectInverseOf property) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(property.getInverse());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLDataProperty property) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLNamedIndividual individual) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLAnnotationProperty property) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLAnnotation node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getProperty());
        toReturn.add(node.getValue());
        return toReturn;
    }

    @Override
    public List<Object> visit(IRI iri) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(OWLAnonymousIndividual individual) {
        return Collections.emptyList();
    }

    @Override
    public List<Object> visit(SWRLClassAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getPredicate());
        toReturn.add(node.getArgument());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLDataRangeAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getPredicate());
        toReturn.add(node.getArgument());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLObjectPropertyAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getPredicate());
        toReturn.add(node.getFirstArgument());
        toReturn.add(node.getSecondArgument());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLDataPropertyAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getPredicate());
        toReturn.add(node.getFirstArgument());
        toReturn.add(node.getSecondArgument());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLBuiltInAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getPredicate());
        toReturn.add(node.getArguments());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLVariable node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getIRI());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLIndividualArgument node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getIndividual());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLLiteralArgument node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getLiteral());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLSameIndividualAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getFirstArgument());
        toReturn.add(node.getSecondArgument());
        return toReturn;
    }

    @Override
    public List<Object> visit(SWRLDifferentIndividualsAtom node) {
        List<Object> toReturn = new ArrayList<Object>();
        toReturn.add(node.getFirstArgument());
        toReturn.add(node.getSecondArgument());
        return toReturn;
    }

    @Override
    public List<Object> visit(OWLOntology ontology) {
        return Collections.emptyList();
    }
}
