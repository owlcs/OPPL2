package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLAnnotationPropertySelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLClassSelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLConstantSelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLDataPropertySelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLDatatypeSelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLEntitySelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLIndividualSelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllOWLObjectPropertySelector;
import static org.coode.oppl.utils.OWLPrimitiveSelector.getAllPrimitiveSelector;

import java.util.stream.Stream;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasValueRestriction;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNaryBooleanClassExpression;
import org.semanticweb.owlapi.model.OWLNaryClassAxiom;
import org.semanticweb.owlapi.model.OWLNaryIndividualAxiom;
import org.semanticweb.owlapi.model.OWLNaryPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
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
import org.semanticweb.owlapi.model.OWLPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLQuantifiedRestriction;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLUnaryPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;

/**
 * Extracts from an OWLObject a particular kind of OWLObject component.
 * 
 * @author Luigi Iannone
 * @param <O> type
 */
public final class OWLObjectExtractor<O extends OWLObject>
    implements OWLObjectVisitorEx<Stream<O>> {

    private final OWLObjectVisitorEx<Boolean> selector;

    /**
     * @param selector selector
     */
    private OWLObjectExtractor(OWLObjectVisitorEx<Boolean> selector) {
        this.selector = checkNotNull(selector, "selector");
    }

    @Override
    public <T> Stream<O> doDefault(T object) {
        return Stream.empty();
    }

    @Override
    public Stream<O> visit(OWLDeclarationAxiom axiom) {
        return visitPrimitive(axiom.getEntity());
    }

    @Override
    public Stream<O> visit(OWLAnnotationAssertionAxiom axiom) {
        return Stream.of(axiom.getSubject(), axiom.getAnnotation()).flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLAnnotation annotation) {
        return Stream.of(annotation.getProperty(), annotation.getValue())
            .flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLSubClassOfAxiom axiom) {
        return Stream.of(axiom.getSubClass(), axiom.getSuperClass()).flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLPropertyAssertionAxiom(OWLPropertyAssertionAxiom<?, ?> axiom) {
        return Stream.of(axiom.getProperty(), axiom.getSubject(), axiom.getObject())
            .flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitCharacteristicAxiom(OWLUnaryPropertyAxiom<?> axiom) {
        return axiom.getProperty().accept(this);
    }

    @Override
    public Stream<O> visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLDisjointClassesAxiom axiom) {
        return visitOWLNAryClassAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLNAryClassAxiom(OWLNaryClassAxiom axiom) {
        return axiom.classExpressions().flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLDataPropertyDomainAxiom axiom) {
        return visitOWLPropertyDomainAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLPropertyDomainAxiom(OWLPropertyDomainAxiom<?> axiom) {
        return Stream.of(axiom.getProperty(), axiom.getDomain()).flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLObjectPropertyDomainAxiom axiom) {
        return visitOWLPropertyDomainAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLNaryPropertyAxiom(OWLNaryPropertyAxiom<?> axiom) {
        return axiom.properties().flatMap(p -> p.accept(this));
    }

    @Override
    public Stream<O> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLDifferentIndividualsAxiom axiom) {
        return visitOWLNaryIndividualAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLNaryIndividualAxiom(OWLNaryIndividualAxiom axiom) {
        return axiom.individuals().flatMap(i -> i.accept(this));
    }

    @Override
    public Stream<O> visit(OWLDisjointDataPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLObjectPropertyRangeAxiom axiom) {
        return visitOWLPropertyRangeAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLPropertyRangeAxiom(OWLPropertyRangeAxiom<?, ?> axiom) {
        return Stream.of(axiom.getProperty(), axiom.getRange()).flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLObjectPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLSubObjectPropertyOfAxiom axiom) {
        return visitOWLSubPropertyAxiom(axiom);
    }

    /**
     * @param axiom axiom
     * @return set of objects
     */
    private Stream<O> visitOWLSubPropertyAxiom(OWLSubPropertyAxiom<?> axiom) {
        return Stream.of(axiom.getSubProperty(), axiom.getSuperProperty())
            .flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLDisjointUnionAxiom axiom) {
        return axiom.classExpressions().flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLDataPropertyRangeAxiom axiom) {
        return visitOWLPropertyRangeAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLFunctionalDataPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLClassAssertionAxiom axiom) {
        return Stream.of(axiom.getClassExpression(), axiom.getIndividual())
            .flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLEquivalentClassesAxiom axiom) {
        return visitOWLNAryClassAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLDataPropertyAssertionAxiom axiom) {
        return visitOWLPropertyAssertionAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLSubDataPropertyOfAxiom axiom) {
        return visitOWLSubPropertyAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return visitCharacteristicAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLSameIndividualAxiom axiom) {
        return visitOWLNaryIndividualAxiom(axiom);
    }

    @Override
    public Stream<O> visit(OWLSubPropertyChainOfAxiom axiom) {
        return Stream.concat(axiom.getSuperProperty().accept(this),
            axiom.getPropertyChain().stream().flatMap(c -> c.accept(this)));
    }

    @Override
    public Stream<O> visit(OWLInverseObjectPropertiesAxiom axiom) {
        return visitOWLNaryPropertyAxiom(axiom);
    }

    @Override
    public Stream<O> visit(SWRLRule rule) {
        return Stream.empty();
    }

    @Override
    public Stream<O> visit(OWLClass desc) {
        return visitPrimitive(desc);
    }

    @Override
    public Stream<O> visit(OWLAnnotationProperty property) {
        return visitPrimitive(property);
    }

    /**
     * @param owlObject owlObject
     * @return set of objects
     */
    @SuppressWarnings("unchecked")
    private Stream<O> visitPrimitive(OWLObject owlObject) {
        if (owlObject.accept(getSelector()).booleanValue()) {
            return Stream.of((O) owlObject);
        }
        return Stream.empty();
    }

    @Override
    public Stream<O> visit(OWLObjectIntersectionOf desc) {
        return visitOWLNaryBooleanExpression(desc);
    }

    /**
     * @param desc desc
     * @return set of objects
     */
    private Stream<O> visitOWLNaryBooleanExpression(OWLNaryBooleanClassExpression desc) {
        return desc.operands().flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLObjectUnionOf desc) {
        return visitOWLNaryBooleanExpression(desc);
    }

    @Override
    public Stream<O> visit(OWLObjectComplementOf desc) {
        return desc.getOperand().accept(this);
    }

    @Override
    public Stream<O> visit(OWLObjectSomeValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    /**
     * @param desc desc
     * @return set of objects
     */
    private Stream<O> visitOWLQuantifiedRestriction(OWLQuantifiedRestriction<?> desc) {
        return Stream.concat(desc.getProperty().accept(this), desc.getFiller().accept(this));
    }

    @Override
    public Stream<O> visit(OWLObjectAllValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLObjectHasValue desc) {
        return visitOWLValueRestriction(desc);
    }

    /**
     * @param desc desc
     * @return set of objects
     */
    private Stream<O> visitOWLValueRestriction(OWLHasValueRestriction<?> desc) {
        return Stream.concat(desc.getProperty().accept(this), desc.getFiller().accept(this));
    }

    @Override
    public Stream<O> visit(OWLObjectMinCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLObjectExactCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLObjectMaxCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    /**
     * @param desc desc
     * @return set of objects
     */
    private Stream<O> visitOWLCardinalityRestriction(OWLCardinalityRestriction<?> desc) {
        return Stream.concat(desc.getProperty().accept(this), desc.getFiller().accept(this));
    }

    @Override
    public Stream<O> visit(OWLObjectHasSelf desc) {
        return desc.getProperty().accept(this);
    }

    @Override
    public Stream<O> visit(OWLObjectOneOf desc) {
        return desc.individuals().flatMap(c -> c.accept(this));
    }

    @Override
    public Stream<O> visit(OWLDataSomeValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLDataAllValuesFrom desc) {
        return visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLDataHasValue desc) {
        return visitOWLValueRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLDataMinCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLDataExactCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLDataMaxCardinality desc) {
        return visitOWLCardinalityRestriction(desc);
    }

    @Override
    public Stream<O> visit(OWLDatatype node) {
        return visitPrimitive(node);
    }

    @Override
    public Stream<O> visit(OWLDataComplementOf node) {
        return node.getDataRange().accept(this);
    }

    @Override
    public Stream<O> visit(OWLDataOneOf node) {
        return node.values().flatMap(o -> o.accept(this));
    }

    @Override
    public Stream<O> visit(OWLLiteral node) {
        return visitPrimitive(node);
    }

    @Override
    public Stream<O> visit(OWLObjectProperty property) {
        return visitPrimitive(property);
    }

    @Override
    public Stream<O> visit(OWLObjectInverseOf property) {
        return property.getInverse().accept(this);
    }

    @Override
    public Stream<O> visit(OWLDataProperty property) {
        return visitPrimitive(property);
    }

    @Override
    public Stream<O> visit(OWLNamedIndividual individual) {
        return visitPrimitive(individual);
    }

    /**
     * @return the selector
     */
    public OWLObjectVisitorEx<Boolean> getSelector() {
        return selector;
    }

    /**
     * @param owlObject owlObject
     * @return all classes
     */
    public static Stream<OWLClass> getAllClasses(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLClassSelector());
    }

    /**
     * @param owlObject owlObject
     * @return all object properties
     */
    public static Stream<OWLObjectProperty> getAllOWLObjectProperties(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLObjectPropertySelector());
    }

    /**
     * @param owlObject owlObject
     * @return all data properties
     */
    public static Stream<OWLDataProperty> getAllOWLDataProperties(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLDataPropertySelector());
    }

    /**
     * @param owlObject owlObject
     * @return all individuals
     */
    public static Stream<OWLNamedIndividual> getAllOWLIndividuals(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLIndividualSelector());
    }

    /**
     * @param owlObject owlObject
     * @return all datatypes
     */
    public static Stream<OWLDatatype> getAllOWLDatatypes(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLDatatypeSelector());
    }

    /**
     * @param owlObject owlObject
     * @return all literals
     */
    public static Stream<OWLLiteral> getAllOWLLiterals(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLConstantSelector());
    }

    /**
     * @param owlObject owlObject
     * @return all all entities
     */
    public static Stream<OWLEntity> getAllOWLEntities(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLEntitySelector());
    }

    /**
     * @param owlObject owlObject
     * @return all primitives
     */
    public static Stream<OWLObject> getAllOWLPrimitives(OWLObject owlObject) {
        return getAll(owlObject, getAllPrimitiveSelector());
    }

    /**
     * @param owlObject owlObject
     * @return all annotation properties
     */
    public static Stream<OWLAnnotationProperty> getAllAnnotationProperties(OWLObject owlObject) {
        return getAll(owlObject, getAllOWLAnnotationPropertySelector());
    }

    /**
     * @param owlObject owlObject
     * @param extractor extractor
     * @return all types of owl objects
     */
    private static <T extends OWLObject> Stream<T> getAll(OWLObject owlObject,
        OWLObjectVisitorEx<Boolean> extractor) {
        return owlObject.accept(new OWLObjectExtractor<T>(extractor));
    }
}
