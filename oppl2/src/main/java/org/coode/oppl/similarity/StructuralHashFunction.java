package org.coode.oppl.similarity;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.coode.oppl.utils.OWLVocabulary;
import org.coode.oppl.utils.PrimeNumbersUtils;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
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
import org.semanticweb.owlapi.model.OWLDataPropertyCharacteristicAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityVisitorEx;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
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
import org.semanticweb.owlapi.model.OWLObjectPropertyCharacteristicAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
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
import org.semanticweb.owlapi.model.SWRLRule;

/**
 * @author Luigi Iannone
 */
public class StructuralHashFunction implements HashFunction, OWLObjectVisitorEx<Integer> {

    private static final Map<AxiomType<?>, Integer> axiomTypeHashCodes = new HashMap<>();
    private static final Map<IRI, Integer> iriHashCodes = new HashMap<>();
    private static final Map<OWLEntity, Integer> entityHashCodes = new HashMap<>();
    private static final EnumMap<OWLConstruct, Integer> constructHashCodes =
        new EnumMap<>(OWLConstruct.class);
    private static final Map<Integer, Integer> integerHashCodes = new HashMap<>();
    private static int maxPrime = 1;
    private static final Integer ONE = Integer.valueOf(1);

    @Override
    public <T extends Object> Integer doDefault(T object) {
        return ONE;
    }

    @Override
    public Integer visit(OWLSubClassOfAxiom axiom) {
        return Integer.valueOf(getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getSubClass().accept(this).intValue()
            * axiom.getSuperClass().accept(this).intValue());
    }

    private Integer getAxiomTypeHashValue(AxiomType<?> axiomType) {
        return axiomTypeHashCodes.computeIfAbsent(axiomType,
            x -> Integer.valueOf(this.createHashCode(x)));
    }

    protected int createHashCode(AxiomType<?> axiomType) {
        return this.createHashCode(axiomType, axiomTypeHashCodes);
    }

    @Override
    public Integer visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return Integer.valueOf(getPropertyAssertionHashCode(axiom));
    }

    @Override
    public Integer visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getOWLObjectPropertyCharacteristicAxiomHashCode(
        OWLObjectPropertyCharacteristicAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getProperty().accept(this).intValue();
    }

    @Override
    public Integer visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLDisjointClassesAxiom axiom) {
        return Integer.valueOf(getNaryClassAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getNaryClassAxiomHashCode(OWLNaryClassAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * getCollectionHashCode(axiom.classExpressions());
    }

    private int getCollectionHashCode(Collection<? extends OWLObject> collection) {
        int toReturn = 1;
        for (OWLObject owlObject : collection) {
            toReturn = toReturn * owlObject.accept(this).intValue();
        }
        return toReturn;
    }

    private int getCollectionHashCode(Stream<? extends OWLObject> collection) {
        AtomicInteger toReturn = new AtomicInteger(1);
        collection.forEach(o -> toReturn.set(toReturn.get() * o.accept(this).intValue()));
        return toReturn.get();
    }

    @Override
    public Integer visit(OWLDataPropertyDomainAxiom axiom) {
        return Integer.valueOf(getOWLPropertyDomainAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getOWLPropertyDomainAxiomHashCode(OWLPropertyDomainAxiom<?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getProperty().accept(this).intValue()
            * axiom.getDomain().accept(this).intValue();
    }

    private Integer getIRIHashCode(IRI uri) {
        Integer toReturn = iriHashCodes.get(uri);
        if (toReturn == null) {
            toReturn = Integer.valueOf(this.createHashCode(uri));
        }
        return toReturn;
    }

    protected int createHashCode(IRI uri) {
        return this.createHashCode(uri, iriHashCodes);
    }

    @Override
    public Integer visit(OWLObjectPropertyDomainAxiom axiom) {
        return Integer.valueOf(getOWLPropertyDomainAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return Integer.valueOf(getNaryPropertyAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getNaryPropertyAxiomHashCode(OWLNaryPropertyAxiom<?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * getCollectionHashCode(axiom.properties());
    }

    @Override
    public Integer visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return Integer.valueOf(getPropertyAssertionHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getPropertyAssertionHashCode(OWLPropertyAssertionAxiom<?, ?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getProperty().accept(this).intValue()
            * axiom.getSubject().accept(this).intValue()
            * axiom.getObject().accept(this).intValue();
    }

    @Override
    public Integer visit(OWLDifferentIndividualsAxiom axiom) {
        return Integer.valueOf(getNaryIndividualAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getNaryIndividualAxiomHashCode(OWLNaryIndividualAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * getCollectionHashCode(axiom.individuals());
    }

    @Override
    public Integer visit(OWLDisjointDataPropertiesAxiom axiom) {
        return Integer.valueOf(getNaryPropertyAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return Integer.valueOf(getNaryPropertyAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLObjectPropertyRangeAxiom axiom) {
        return Integer.valueOf(getOWLPropertyRangeAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getOWLPropertyRangeAxiomHashCode(OWLPropertyRangeAxiom<?, ?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getProperty().accept(this).intValue()
            * axiom.getRange().accept(this).intValue();
    }

    @Override
    public Integer visit(OWLObjectPropertyAssertionAxiom axiom) {
        return Integer.valueOf(getPropertyAssertionHashCode(axiom));
    }

    @Override
    public Integer visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLSubObjectPropertyOfAxiom axiom) {
        return Integer.valueOf(getOWLSubPropertyAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getOWLSubPropertyAxiomHashCode(OWLSubPropertyAxiom<?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getSubProperty().accept(this).intValue()
            * axiom.getSuperProperty().accept(this).intValue()
        // * this.getPairHashCode(new OrderedPair<OWLPropertyExpression<?,
        // ?>>(
        // axiom.getSubProperty(), axiom.getSuperProperty()))
        ;
    }

    @Override
    public Integer visit(OWLDisjointUnionAxiom axiom) {
        return Integer.valueOf(getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * getCollectionHashCode(axiom.classExpressions()));
    }

    @Override
    public Integer visit(OWLDeclarationAxiom axiom) {
        return Integer.valueOf(getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getEntity().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLDataPropertyRangeAxiom axiom) {
        return Integer.valueOf(getOWLPropertyRangeAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLFunctionalDataPropertyAxiom axiom) {
        return Integer.valueOf(getOWLDataPropertyCharacteristicAxiomHashCode(axiom));
    }

    /**
     * @param axiom axiom
     * @return hashcode
     */
    private int getOWLDataPropertyCharacteristicAxiomHashCode(
        OWLDataPropertyCharacteristicAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getProperty().accept(this).intValue();
    }

    @Override
    public Integer visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return Integer.valueOf(getNaryPropertyAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLClassAssertionAxiom axiom) {
        return Integer.valueOf(getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getClassExpression().accept(this).intValue()
            * axiom.getIndividual().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLEquivalentClassesAxiom axiom) {
        return Integer.valueOf(getNaryClassAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLDataPropertyAssertionAxiom axiom) {
        return Integer.valueOf(getPropertyAssertionHashCode(axiom));
    }

    @Override
    public Integer visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLSubDataPropertyOfAxiom axiom) {
        return Integer.valueOf(getOWLSubPropertyAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return Integer.valueOf(getOWLObjectPropertyCharacteristicAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLSameIndividualAxiom axiom) {
        return Integer.valueOf(getNaryIndividualAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(OWLSubPropertyChainOfAxiom axiom) {
        return Integer.valueOf(getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.getSuperProperty().accept(this).intValue()
            * getOWLConstructHashCode(OWLConstruct.PROPERTY_CHAIN)
            * getCollectionHashCode(axiom.getPropertyChain()));
    }

    @Override
    public Integer visit(OWLInverseObjectPropertiesAxiom axiom) {
        return Integer.valueOf(getNaryPropertyAxiomHashCode(axiom));
    }

    @Override
    public Integer visit(SWRLRule axiom) {
        return Integer.valueOf(getAxiomTypeHashValue(axiom.getAxiomType()).intValue()
            * axiom.bodyList().hashCode() * axiom.headList().hashCode());
    }

    @Override
    public Integer visit(OWLClass owlClass) {
        return Integer.valueOf(getOWLEntityHashCode(owlClass));
    }

    @Override
    public Integer visit(IRI iri) {
        return getIRIHashCode(iri);
    }

    private int getOWLEntityHashCode(OWLEntity owlEntity) {
        // The same prime will be assigned for the same kind of entity. We do
        // not care about the particular entity in this structural hash
        // function.
        OWLEntity representative = owlEntity.accept(new OWLEntityVisitorEx<OWLEntity>() {

            @Override
            public OWLEntity visit(OWLClass cls) {
                return OWLVocabulary.getOWLThing();
            }

            @Override
            public OWLEntity visit(OWLObjectProperty property) {
                return OWLVocabulary.getOWLTopObjectProperty();
            }

            @Override
            public OWLEntity visit(OWLDataProperty property) {
                return OWLVocabulary.getOWLTopDataProperty();
            }

            @Override
            public OWLEntity visit(OWLAnnotationProperty property) {
                return OWLVocabulary.getTopDatatype();
            }

            @Override
            public OWLEntity visit(OWLNamedIndividual individual) {
                // We return the same prime as the one corresponding to
                // an
                // OWLClass as there can never be a structure where an
                // OWLClass
                // or an OWLIndividual can appear interchangeably.
                return OWLVocabulary.getOWLThing();
            }

            @Override
            public OWLEntity visit(OWLDatatype dataType) {
                return OWLVocabulary.getTopDatatype();
            }
        });
        Integer toReturn = entityHashCodes.get(representative);
        if (toReturn == null) {
            toReturn = Integer.valueOf(this.createHashCode(representative));
        }
        return toReturn.intValue();
    }

    protected int createHashCode(OWLEntity owlEntity) {
        return this.createHashCode(owlEntity, entityHashCodes);
    }

    @Override
    public Integer visit(OWLObjectIntersectionOf description) {
        return Integer.valueOf(getNaryBooleanClassDescriptionHasCode(description));
    }

    /**
     * @param description description
     * @return hashcode
     */
    private int getNaryBooleanClassDescriptionHasCode(OWLNaryBooleanClassExpression description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * getCollectionHashCode(description.operands());
    }

    private int getOWLConstructHashCode(OWLConstruct owlConstruct) {
        Integer toReturn = constructHashCodes.get(owlConstruct);
        if (toReturn == null) {
            toReturn = Integer.valueOf(this.createHashCode(owlConstruct));
        }
        return toReturn.intValue();
    }

    protected int createHashCode(OWLConstruct owlConstruct) {
        return this.createHashCode(owlConstruct, constructHashCodes);
    }

    @Override
    public Integer visit(OWLObjectUnionOf description) {
        return Integer.valueOf(getNaryBooleanClassDescriptionHasCode(description));
    }

    @Override
    public Integer visit(OWLObjectComplementOf description) {
        return Integer.valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getOperand().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLObjectSomeValuesFrom description) {
        return Integer.valueOf(getOWLQuantifiedRestrictionHashCode(description));
    }

    /**
     * @param description description
     * @return hashcode
     */
    private int getOWLQuantifiedRestrictionHashCode(OWLQuantifiedRestriction<?> description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getFiller().accept(this).intValue();
    }

    @Override
    public Integer visit(OWLObjectAllValuesFrom description) {
        return Integer.valueOf(getOWLQuantifiedRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLObjectHasValue description) {
        return Integer.valueOf(getOWLValueRestricitonHashCode(description));
    }

    /**
     * @param description description
     * @return hashcode
     */
    private int getOWLValueRestricitonHashCode(OWLHasValueRestriction<?> description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getProperty().accept(this).intValue()
            * description.getFiller().accept(this).intValue();
    }

    @Override
    public Integer visit(OWLObjectMinCardinality description) {
        return Integer.valueOf(getOWLCardinalityRestrictionHashCode(description));
    }

    /**
     * @param description description
     * @return hashcode
     */
    private int getOWLCardinalityRestrictionHashCode(OWLCardinalityRestriction<?> description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * getIntegerHashCode(description.getCardinality())
            * (description.isQualified() ? description.getFiller().accept(this).intValue() : 1);
    }

    private int getIntegerHashCode(int cardinality) {
        Integer toReturn = integerHashCodes.get(Integer.valueOf(cardinality));
        if (toReturn == null) {
            toReturn = Integer.valueOf(this.createHashCode(cardinality));
        }
        return toReturn.intValue();
    }

    protected int createHashCode(int n) {
        return this.createHashCode(Integer.valueOf(n), integerHashCodes);
    }

    @Override
    public Integer visit(OWLObjectExactCardinality description) {
        return Integer.valueOf(getOWLCardinalityRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLObjectMaxCardinality descrption) {
        return Integer.valueOf(getOWLCardinalityRestrictionHashCode(descrption));
    }

    @Override
    public Integer visit(OWLObjectHasSelf description) {
        return Integer.valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getProperty().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLObjectOneOf description) {
        return Integer.valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * getCollectionHashCode(description.individuals()));
    }

    @Override
    public Integer visit(OWLDataSomeValuesFrom description) {
        return Integer.valueOf(getOWLQuantifiedRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLDataAllValuesFrom description) {
        return Integer.valueOf(getOWLQuantifiedRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLDataHasValue description) {
        return Integer.valueOf(getOWLValueRestricitonHashCode(description));
    }

    @Override
    public Integer visit(OWLDataMinCardinality description) {
        return Integer.valueOf(getOWLCardinalityRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLDataExactCardinality description) {
        return Integer.valueOf(getOWLCardinalityRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLDataMaxCardinality description) {
        return Integer.valueOf(getOWLCardinalityRestrictionHashCode(description));
    }

    @Override
    public Integer visit(OWLDatatype dataType) {
        return Integer.valueOf(getOWLEntityHashCode(dataType));
    }

    private <O extends Object> int createHashCode(O key, Map<O, Integer> map) {
        int toReturn = PrimeNumbersUtils.getNextPrime(getMaxPrime());
        map.put(key, Integer.valueOf(toReturn));
        setMaxPrime(toReturn);
        return toReturn;
    }

    @Override
    public Integer visit(OWLDataComplementOf dataComplementOf) {
        return Integer
            .valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataComplementOf))
                * dataComplementOf.getDataRange().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLDataOneOf dataOneOf) {
        return Integer.valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataOneOf))
            * getCollectionHashCode(dataOneOf.values()));
    }

    @Override
    public Integer visit(OWLDatatypeRestriction dataRangeRestriction) {
        return Integer
            .valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataRangeRestriction))
                * dataRangeRestriction.getDatatype().accept(this).intValue()
                * getCollectionHashCode(dataRangeRestriction.facetRestrictions()));
    }

    @Override
    public Integer visit(OWLLiteral constant) {
        return getOWLConstantHashCode();
    }

    private Integer getOWLConstantHashCode() {
        // For each constant a single representative will be used for computing
        // the corresponding prime.
        Integer toReturn = entityHashCodes.get(OWLVocabulary.getTopDatatype());
        if (toReturn == null) {
            toReturn = Integer.valueOf(this.createHashCode(OWLVocabulary.getTopDatatype()));
        }
        return toReturn;
    }

    @Override
    public Integer visit(OWLFacetRestriction facet) {
        return Integer.valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(facet))
            * facet.getFacetValue().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLObjectProperty property) {
        return Integer.valueOf(getOWLEntityHashCode(property));
    }

    @Override
    public Integer visit(OWLObjectInverseOf inverse) {
        return Integer.valueOf(getOWLConstructHashCode(OWLConstruct.getOWLConstruct(inverse))
            * inverse.getInverseProperty().accept(this).intValue());
    }

    @Override
    public Integer visit(OWLDataProperty property) {
        return Integer.valueOf(getOWLEntityHashCode(property));
    }

    @Override
    public Integer visit(OWLNamedIndividual individual) {
        return Integer.valueOf(getOWLEntityHashCode(individual));
    }

    @Override
    public Integer visit(OWLOntology ontology) {
        return getIRIHashCode(ontology.getOntologyID().getOntologyIRI().orElse(null));
    }

    /**
     * @return the maxPrime
     */
    public int getMaxPrime() {
        return maxPrime;
    }

    /**
     * @param maxPrime the maxPrime to set
     */
    private static void setMaxPrime(int maxPrime) {
        StructuralHashFunction.maxPrime = maxPrime;
    }

    @Override
    public int getHashCode(OWLObject owlObject) {
        return owlObject.accept(this).intValue();
    }
}
