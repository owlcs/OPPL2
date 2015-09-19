package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.coode.oppl.utils.OWLPrimitiveSelector.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * Extracts from an OWLObject a particular kind of OWLObject component.
 * 
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public final class OWLObjectExtractor<O extends OWLObject> extends
    OWLObjectVisitorExAdapter<Set<O>>implements OWLObjectVisitorEx<Set<O>> {

    private final OWLObjectVisitorEx<Boolean> selector;

    /**
     * @param selector
     *        selector
     */
    private OWLObjectExtractor(OWLObjectVisitorEx<Boolean> selector) {
        super(Collections.<O> emptySet());
        this.selector = checkNotNull(selector, "selector");
    }

    @Override
    public Set<O> visit(OWLDeclarationAxiom axiom) {
        return visitPrimitive(axiom.getEntity());
    }

    @Override
    public Set<O> visit(OWLAnnotationAssertionAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getSubject().accept(this));
        toReturn.addAll(axiom.getAnnotation().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLAnnotation annotation) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(annotation.getProperty().accept(this));
        toReturn.addAll(annotation.getValue().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLSubClassOfAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getSubClass().accept(this));
        toReturn.addAll(axiom.getSuperClass().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLPropertyAssertionAxiom(OWLPropertyAssertionAxiom<?, ?> axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getProperty().accept(this));
        toReturn.addAll(axiom.getSubject().accept(this));
        toReturn.addAll(axiom.getObject().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitCharacteristicAxiom(OWLUnaryPropertyAxiom<?> axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Set<O> visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLDisjointClassesAxiom axiom) {
        return visitOWLNAryClassAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLNAryClassAxiom(OWLNaryClassAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLClassExpression owlDescription : axiom.getClassExpressions()) {
            toReturn.addAll(owlDescription.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLDataPropertyDomainAxiom axiom) {
        return visitOWLPropertyDomainAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLPropertyDomainAxiom(OWLPropertyDomainAxiom<?> axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getProperty().accept(this));
        toReturn.addAll(axiom.getDomain().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectPropertyDomainAxiom axiom) {
        return visitOWLPropertyDomainAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLNaryPropertyAxiom(OWLNaryPropertyAxiom<?> axiom) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLObject p : axiom.getProperties()) {
            toReturn.addAll(p.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLDifferentIndividualsAxiom axiom) {
        return visitOWLNaryIndividualAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLNaryIndividualAxiom(OWLNaryIndividualAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLIndividual individual : axiom.getIndividuals()) {
            toReturn.addAll(individual.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLDisjointDataPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLObjectPropertyRangeAxiom axiom) {
        return visitOWLPropertyRangeAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLPropertyRangeAxiom(OWLPropertyRangeAxiom<?, ?> axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getProperty().accept(this));
        toReturn.addAll(axiom.getRange().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLSubObjectPropertyOfAxiom axiom) {
        return visitOWLSubPropertyAxiom(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return set of objects
     */
    private Set<O> visitOWLSubPropertyAxiom(OWLSubPropertyAxiom<?> axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getSubProperty().accept(this));
        toReturn.addAll(axiom.getSuperProperty().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLDisjointUnionAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLClassExpression owlDescription : axiom.getClassExpressions()) {
            toReturn.addAll(owlDescription.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLDataPropertyRangeAxiom axiom) {
        return visitOWLPropertyRangeAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLFunctionalDataPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLClassAssertionAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getClassExpression().accept(this));
        toReturn.addAll(axiom.getIndividual().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLEquivalentClassesAxiom axiom) {
        return visitOWLNAryClassAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLDataPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLSubDataPropertyOfAxiom axiom) {
        return visitOWLSubPropertyAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLSameIndividualAxiom axiom) {
        return visitOWLNaryIndividualAxiom(axiom);
    }

    @Override
    public Set<O> visit(OWLSubPropertyChainOfAxiom axiom) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(axiom.getSuperProperty().accept(this));
        for (OWLObject owlObject : axiom.getPropertyChain()) {
            toReturn.addAll(owlObject.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLInverseObjectPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Set<O> visit(SWRLRule rule) {
        return Collections.emptySet();
    }

    @Override
    public Set<O> visit(OWLClass desc) {
        return visitPrimitive(desc);
    }

    @Override
    public Set<O> visit(OWLAnnotationProperty property) {
        return visitPrimitive(property);
    }

    /**
     * @param owlObject
     *        owlObject
     * @return set of objects
     */
    @SuppressWarnings("unchecked")
    private Set<O> visitPrimitive(OWLObject owlObject) {
        Set<O> toReturn = new HashSet<O>();
        if (owlObject.accept(getSelector())) {
            toReturn.add((O) owlObject);
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectIntersectionOf desc) {
        return visitOWLNaryBooleanExpression(desc);
    }

    /**
     * @param desc
     *        desc
     * @return set of objects
     */
    private Set<O> visitOWLNaryBooleanExpression(OWLNaryBooleanClassExpression desc) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLObject owlObject : desc.getOperands()) {
            toReturn.addAll(owlObject.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectUnionOf desc) {
        return visitOWLNaryBooleanExpression(desc);
    }

    @Override
    public Set<O> visit(OWLObjectComplementOf desc) {
        return desc.getOperand().accept(this);
    }

    @Override
    public Set<O> visit(OWLObjectSomeValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    /**
     * @param desc
     *        desc
     * @return set of objects
     */
    private Set<O> visitOWLQuantifiedRestriction(OWLQuantifiedRestriction<?> desc) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(desc.getProperty().accept(this));
        toReturn.addAll(desc.getFiller().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectAllValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLObjectHasValue desc) {
        return visitOWLValueRestriction(desc);
    }

    /**
     * @param desc
     *        desc
     * @return set of objects
     */
    private Set<O> visitOWLValueRestriction(OWLHasValueRestriction<?> desc) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(desc.getProperty().accept(this));
        toReturn.addAll(desc.getValue().accept(this));
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectMinCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLObjectExactCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLObjectMaxCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    /**
     * @param desc
     *        desc
     * @return set of objects
     */
    private Set<O> visitOWLCardinalityRestriction(OWLCardinalityRestriction<?> desc) {
        Set<O> toReturn = new HashSet<O>();
        toReturn.addAll(desc.getProperty().accept(this));
        if (desc.getFiller() != null) {
            toReturn.addAll(desc.getFiller().accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLObjectHasSelf desc) {
        return desc.getProperty().accept(this);
    }

    @Override
    public Set<O> visit(OWLObjectOneOf desc) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLObject owlObject : desc.getIndividuals()) {
            toReturn.addAll(owlObject.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLDataSomeValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLDataAllValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLDataHasValue desc) {
        return visitOWLValueRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLDataMinCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLDataExactCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLDataMaxCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Set<O> visit(OWLDatatype node) {
        return visitPrimitive(node);
    }

    @Override
    public Set<O> visit(OWLDataComplementOf node) {
        return node.getDataRange().accept(this);
    }

    @Override
    public Set<O> visit(OWLDataOneOf node) {
        Set<O> toReturn = new HashSet<O>();
        for (OWLObject owlObject : node.getValues()) {
            toReturn.addAll(owlObject.accept(this));
        }
        return toReturn;
    }

    @Override
    public Set<O> visit(OWLLiteral node) {
        return visitPrimitive(node);
    }

    @Override
    public Set<O> visit(OWLObjectProperty property) {
        return visitPrimitive(property);
    }

    @Override
    public Set<O> visit(OWLObjectInverseOf property) {
        return property.getInverse().accept(this);
    }

    @Override
    public Set<O> visit(OWLDataProperty property) {
        return visitPrimitive(property);
    }

    @Override
    public Set<O> visit(OWLNamedIndividual individual) {
        return visitPrimitive(individual);
    }

    /**
     * @return the selector
     */
    public OWLObjectVisitorEx<Boolean> getSelector() {
        return selector;
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all classes
     */
    public static Set<OWLClass> getAllClasses(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLClassSelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all object properties
     */
    public static Set<OWLObjectProperty> getAllOWLObjectProperties(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLObjectPropertySelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all data properties
     */
    public static Set<OWLDataProperty> getAllOWLDataProperties(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLDataPropertySelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all individuals
     */
    public static Set<OWLNamedIndividual> getAllOWLIndividuals(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLIndividualSelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all datatypes
     */
    public static Set<OWLDatatype> getAllOWLDatatypes(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLDatatypeSelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all literals
     */
    public static Set<OWLLiteral> getAllOWLLiterals(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLConstantSelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all all entities
     */
    public static Set<OWLEntity> getAllOWLEntities(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLEntitySelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all primitives
     */
    public static Set<OWLObject> getAllOWLPrimitives(OWLObject owlObject) {
        return getAll(owlObject, getAllPrimitiveSelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @return all annotation properties
     */
    public static Set<OWLAnnotationProperty> getAllAnnotationProperties(
        OWLObject owlObject) {
        return getAll(owlObject, getAllOWLAnnotationPropertySelector());
    }

    /**
     * @param owlObject
     *        owlObject
     * @param extractor
     *        extractor
     * @return all types of owl objects
     */
    private static <T extends OWLObject> Set<T> getAll(OWLObject owlObject,
        OWLObjectVisitorEx<Boolean> extractor) {
        return owlObject.accept(new OWLObjectExtractor<T>(extractor));
    }
}
