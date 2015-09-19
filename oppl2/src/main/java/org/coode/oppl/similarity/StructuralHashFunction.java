package org.coode.oppl.similarity;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.coode.oppl.utils.OWLVocabulary;
import org.coode.oppl.utils.PrimeNumbersUtils;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 */
public class StructuralHashFunction extends OWLObjectVisitorExAdapter<Integer>implements
    HashFunction, OWLObjectVisitorEx<Integer> {

    private final static Map<AxiomType<?>, Integer> axiomTypeHashCodes = new HashMap<AxiomType<?>, Integer>();
    private final static Map<IRI, Integer> iriHashCodes = new HashMap<IRI, Integer>();
    private final static Map<OWLEntity, Integer> entityHashCodes = new HashMap<OWLEntity, Integer>();
    private final static EnumMap<OWLConstruct, Integer> constructHashCodes = new EnumMap<OWLConstruct, Integer>(
        OWLConstruct.class);
    private final static Map<Integer, Integer> integerHashCodes = new HashMap<Integer, Integer>();
    private static int maxPrime = 1;

    /**
     * 
     */
    public StructuralHashFunction() {
        super(1);
    }

    @Override
    public Integer visit(OWLSubClassOfAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getSubClass().accept(this) * axiom.getSuperClass().accept(this);
    }

    private Integer getAxiomTypeHashValue(AxiomType<?> axiomType) {
        Integer toReturn = axiomTypeHashCodes.get(axiomType);
        if (toReturn == null) {
            toReturn = this.createHashCode(axiomType);
        }
        return toReturn;
    }

    protected int createHashCode(AxiomType<?> axiomType) {
        return this.createHashCode(axiomType, axiomTypeHashCodes);
    }

    @Override
    public Integer visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return getPropertyAssertionHashCode(axiom);
    }

    @Override
    public Integer visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getOWLObjectPropertyCharacteristicAxiomHashCode(
        OWLObjectPropertyCharacteristicAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getProperty().accept(this);
    }

    @Override
    public Integer visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLDisjointClassesAxiom axiom) {
        return getNaryClassAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getNaryClassAxiomHashCode(OWLNaryClassAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * getCollectionHashCode(axiom.getClassExpressions());
    }

    private int getCollectionHashCode(Collection<? extends OWLObject> collection) {
        int toReturn = 1;
        for (OWLObject owlObject : collection) {
            toReturn = toReturn * owlObject.accept(this);
        }
        return toReturn;
    }

    @Override
    public Integer visit(OWLDataPropertyDomainAxiom axiom) {
        return getOWLPropertyDomainAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getOWLPropertyDomainAxiomHashCode(OWLPropertyDomainAxiom<?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getProperty().accept(this) * axiom.getDomain().accept(this);
    }

    private Integer getIRIHashCode(IRI uri) {
        Integer toReturn = iriHashCodes.get(uri);
        if (toReturn == null) {
            toReturn = this.createHashCode(uri);
        }
        return toReturn;
    }

    protected int createHashCode(IRI uri) {
        return this.createHashCode(uri, iriHashCodes);
    }

    @Override
    public Integer visit(OWLObjectPropertyDomainAxiom axiom) {
        return getOWLPropertyDomainAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return getNaryPropertyAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getNaryPropertyAxiomHashCode(OWLNaryPropertyAxiom<?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * getCollectionHashCode(axiom.getProperties());
    }

    @Override
    public Integer visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return getPropertyAssertionHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getPropertyAssertionHashCode(OWLPropertyAssertionAxiom<?, ?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getProperty().accept(this) * axiom.getSubject().accept(this)
            * axiom.getObject().accept(this);
    }

    @Override
    public Integer visit(OWLDifferentIndividualsAxiom axiom) {
        return getNaryIndividualAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getNaryIndividualAxiomHashCode(OWLNaryIndividualAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * getCollectionHashCode(axiom.getIndividuals());
    }

    @Override
    public Integer visit(OWLDisjointDataPropertiesAxiom axiom) {
        return getNaryPropertyAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return getNaryPropertyAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLObjectPropertyRangeAxiom axiom) {
        return getOWLPropertyRangeAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getOWLPropertyRangeAxiomHashCode(OWLPropertyRangeAxiom<?, ?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getProperty().accept(this) * axiom.getRange().accept(this);
    }

    @Override
    public Integer visit(OWLObjectPropertyAssertionAxiom axiom) {
        return getPropertyAssertionHashCode(axiom);
    }

    @Override
    public Integer visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLSubObjectPropertyOfAxiom axiom) {
        return getOWLSubPropertyAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getOWLSubPropertyAxiomHashCode(OWLSubPropertyAxiom<?> axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getSubProperty().accept(this)
            * axiom.getSuperProperty().accept(this)
            // * this.getPairHashCode(new OrderedPair<OWLPropertyExpression<?,
            // ?>>(
            // axiom.getSubProperty(), axiom.getSuperProperty()))
        ;
    }

    @Override
    public Integer visit(OWLDisjointUnionAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * getCollectionHashCode(axiom.getClassExpressions());
    }

    @Override
    public Integer visit(OWLDeclarationAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getEntity().accept(this);
    }

    @Override
    public Integer visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLDataPropertyRangeAxiom axiom) {
        return getOWLPropertyRangeAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLFunctionalDataPropertyAxiom axiom) {
        return getOWLDataPropertyCharacteristicAxiomHashCode(axiom);
    }

    /**
     * @param axiom
     *        axiom
     * @return hashcode
     */
    private int getOWLDataPropertyCharacteristicAxiomHashCode(
        OWLDataPropertyCharacteristicAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getProperty().accept(this);
    }

    @Override
    public Integer visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return getNaryPropertyAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLClassAssertionAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getClassExpression().accept(this)
            * axiom.getIndividual().accept(this);
    }

    @Override
    public Integer visit(OWLEquivalentClassesAxiom axiom) {
        return getNaryClassAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLDataPropertyAssertionAxiom axiom) {
        return getPropertyAssertionHashCode(axiom);
    }

    @Override
    public Integer visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLSubDataPropertyOfAxiom axiom) {
        return getOWLSubPropertyAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLSameIndividualAxiom axiom) {
        return getNaryIndividualAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(OWLSubPropertyChainOfAxiom axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType())
            * axiom.getSuperProperty().accept(this)
            * getOWLConstructHashCode(OWLConstruct.PROPERTY_CHAIN)
            * getCollectionHashCode(axiom.getPropertyChain());
    }

    @Override
    public Integer visit(OWLInverseObjectPropertiesAxiom axiom) {
        return getNaryPropertyAxiomHashCode(axiom);
    }

    @Override
    public Integer visit(SWRLRule axiom) {
        return getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getBody().hashCode()
            * axiom.getHead().hashCode();
    }

    @Override
    public Integer visit(OWLClass owlClass) {
        return getOWLEntityHashCode(owlClass);
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
            toReturn = this.createHashCode(representative);
        }
        return toReturn;
    }

    protected int createHashCode(OWLEntity owlEntity) {
        return this.createHashCode(owlEntity, entityHashCodes);
    }

    @Override
    public Integer visit(OWLObjectIntersectionOf description) {
        return getNaryBooleanClassDescriptionHasCode(description);
    }

    /**
     * @param description
     *        description
     * @return hashcode
     */
    private int getNaryBooleanClassDescriptionHasCode(
        OWLNaryBooleanClassExpression description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * getCollectionHashCode(description.getOperands());
    }

    private int getOWLConstructHashCode(OWLConstruct owlConstruct) {
        Integer toReturn = constructHashCodes.get(owlConstruct);
        if (toReturn == null) {
            toReturn = this.createHashCode(owlConstruct);
        }
        return toReturn;
    }

    protected int createHashCode(OWLConstruct owlConstruct) {
        return this.createHashCode(owlConstruct, constructHashCodes);
    }

    @Override
    public Integer visit(OWLObjectUnionOf description) {
        return getNaryBooleanClassDescriptionHasCode(description);
    }

    @Override
    public Integer visit(OWLObjectComplementOf description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getOperand().accept(this);
    }

    @Override
    public Integer visit(OWLObjectSomeValuesFrom description) {
        return getOWLQuantifiedRestrictionHashCode(description);
    }

    /**
     * @param description
     *        description
     * @return hashcode
     */
    private int getOWLQuantifiedRestrictionHashCode(
        OWLQuantifiedRestriction<?> description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getFiller().accept(this);
    }

    @Override
    public Integer visit(OWLObjectAllValuesFrom description) {
        return getOWLQuantifiedRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLObjectHasValue description) {
        return getOWLValueRestricitonHashCode(description);
    }

    /**
     * @param description
     *        description
     * @return hashcode
     */
    private int getOWLValueRestricitonHashCode(OWLHasValueRestriction<?> description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getProperty().accept(this)
            * description.getValue().accept(this);
    }

    @Override
    public Integer visit(OWLObjectMinCardinality description) {
        return getOWLCardinalityRestrictionHashCode(description);
    }

    /**
     * @param description
     *        description
     * @return hashcode
     */
    private int getOWLCardinalityRestrictionHashCode(
        OWLCardinalityRestriction<?> description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * getIntegerHashCode(description.getCardinality())
            * (description.isQualified() ? description.getFiller().accept(this) : 1);
    }

    private int getIntegerHashCode(int cardinality) {
        Integer toReturn = integerHashCodes.get(cardinality);
        if (toReturn == null) {
            toReturn = this.createHashCode(cardinality);
        }
        return toReturn;
    }

    protected int createHashCode(int n) {
        return this.createHashCode(n, integerHashCodes);
    }

    @Override
    public Integer visit(OWLObjectExactCardinality description) {
        return getOWLCardinalityRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLObjectMaxCardinality descrption) {
        return getOWLCardinalityRestrictionHashCode(descrption);
    }

    @Override
    public Integer visit(OWLObjectHasSelf description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * description.getProperty().accept(this);
    }

    @Override
    public Integer visit(OWLObjectOneOf description) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
            * getCollectionHashCode(description.getIndividuals());
    }

    @Override
    public Integer visit(OWLDataSomeValuesFrom description) {
        return getOWLQuantifiedRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLDataAllValuesFrom description) {
        return getOWLQuantifiedRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLDataHasValue description) {
        return getOWLValueRestricitonHashCode(description);
    }

    @Override
    public Integer visit(OWLDataMinCardinality description) {
        return getOWLCardinalityRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLDataExactCardinality description) {
        return getOWLCardinalityRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLDataMaxCardinality description) {
        return getOWLCardinalityRestrictionHashCode(description);
    }

    @Override
    public Integer visit(OWLDatatype dataType) {
        return getOWLEntityHashCode(dataType);
    }

    private <O extends Object> int createHashCode(O key, Map<O, Integer> map) {
        int toReturn = PrimeNumbersUtils.getNextPrime(getMaxPrime());
        map.put(key, toReturn);
        setMaxPrime(toReturn);
        return toReturn;
    }

    @Override
    public Integer visit(OWLDataComplementOf dataComplementOf) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataComplementOf))
            * dataComplementOf.getDataRange().accept(this);
    }

    @Override
    public Integer visit(OWLDataOneOf dataOneOf) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataOneOf))
            * getCollectionHashCode(dataOneOf.getValues());
    }

    @Override
    public Integer visit(OWLDatatypeRestriction dataRangeRestriction) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataRangeRestriction))
            * dataRangeRestriction.getDatatype().accept(this)
            * (dataRangeRestriction.getFacetRestrictions().isEmpty() ? 1
                : getCollectionHashCode(dataRangeRestriction
                    .getFacetRestrictions()));
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
            toReturn = this.createHashCode(OWLVocabulary.getTopDatatype());
        }
        return toReturn;
    }

    @Override
    public Integer visit(OWLFacetRestriction facet) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(facet))
            * facet.getFacetValue().accept(this);
    }

    @Override
    public Integer visit(OWLObjectProperty property) {
        return getOWLEntityHashCode(property);
    }

    @Override
    public Integer visit(OWLObjectInverseOf inverse) {
        return getOWLConstructHashCode(OWLConstruct.getOWLConstruct(inverse))
            * inverse.getInverseProperty().accept(this);
    }

    @Override
    public Integer visit(OWLDataProperty property) {
        return getOWLEntityHashCode(property);
    }

    @Override
    public Integer visit(OWLNamedIndividual individual) {
        return getOWLEntityHashCode(individual);
    }

    @Override
    public Integer visit(OWLOntology ontology) {
        return getIRIHashCode(ontology.getOntologyID().getOntologyIRI().orNull());
    }

    /**
     * @return the maxPrime
     */
    public int getMaxPrime() {
        return maxPrime;
    }

    /**
     * @param maxPrime
     *        the maxPrime to set
     */
    private void setMaxPrime(int maxPrime) {
        StructuralHashFunction.maxPrime = maxPrime;
    }

    @Override
    public int getHashCode(OWLObject owlObject) {
        return owlObject.accept(this);
    }
}
