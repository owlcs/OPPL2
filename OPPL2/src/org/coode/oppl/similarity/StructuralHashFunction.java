/**
 * 
 */
package org.coode.oppl.similarity;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

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
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public class StructuralHashFunction extends OWLObjectVisitorExAdapter<Integer>
		implements HashFunction, OWLObjectVisitorEx<Integer> {
	private final static Map<AxiomType<?>, Integer> axiomTypeHashCodes = new HashMap<AxiomType<?>, Integer>();
	private final static Map<IRI, Integer> iriHashCodes = new HashMap<IRI, Integer>();
	private final static Map<OWLEntity, Integer> entityHashCodes = new HashMap<OWLEntity, Integer>();
	private final static EnumMap<OWLConstruct, Integer> constructHashCodes = new EnumMap<OWLConstruct, Integer>(
			OWLConstruct.class);
	private final static Map<Integer, Integer> integerHashCodes = new HashMap<Integer, Integer>();
	// private static final Map<OWLObject, Integer> owlConstantHashCodes = new
	// HashMap<OWLObject, Integer>();
	// private static final Map<OrderedPair<?>, Integer> pairHashCodes = new
	// HashMap<OrderedPair<?>, Integer>();
	// private final static Map<List<? extends OWLObject>, Integer>
	// sequenceHashCodes = new HashMap<List<? extends OWLObject>, Integer>();
	private static int maxPrime = 1;

	public StructuralHashFunction() {
		super(1);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLSubClassAxiom)
	 */
	@Override
	public Integer visit(OWLSubClassOfAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getSubClass().accept(this)
				* axiom.getSuperClass().accept(this);
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

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLNegativeObjectPropertyAssertionAxiom)
	 */
	@Override
	public Integer visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLAntiSymmetricObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLObjectPropertyCharacteristicAxiomHashCode(
			OWLObjectPropertyCharacteristicAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLReflexiveObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLReflexiveObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointClassesAxiom)
	 */
	@Override
	public Integer visit(OWLDisjointClassesAxiom axiom) {
		return this.getNaryClassAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getNaryClassAxiomHashCode(OWLNaryClassAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* this.getCollectionHashCode(axiom.getClassExpressions());
	}

	private int getCollectionHashCode(Collection<? extends OWLObject> collection) {
		int toReturn = 1;
		for (OWLObject owlObject : collection) {
			toReturn = toReturn * owlObject.accept(this);
		}
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataPropertyDomainAxiom)
	 */
	@Override
	public Integer visit(OWLDataPropertyDomainAxiom axiom) {
		return this.getOWLPropertyDomainAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLPropertyDomainAxiomHashCode(
			OWLPropertyDomainAxiom<?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getProperty().accept(this)
				* axiom.getDomain().accept(this);
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

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyDomainAxiom)
	 */
	@Override
	public Integer visit(OWLObjectPropertyDomainAxiom axiom) {
		return this.getOWLPropertyDomainAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEquivalentObjectPropertiesAxiom)
	 */
	@Override
	public Integer visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getNaryPropertyAxiomHashCode(OWLNaryPropertyAxiom<?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* this.getCollectionHashCode(axiom.getProperties());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLNegativeDataPropertyAssertionAxiom)
	 */
	@Override
	public Integer visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getPropertyAssertionHashCode(
			OWLPropertyAssertionAxiom<?, ?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getProperty().accept(this)
				* axiom.getSubject().accept(this)
				* axiom.getObject().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDifferentIndividualsAxiom)
	 */
	@Override
	public Integer visit(OWLDifferentIndividualsAxiom axiom) {
		return this.getNaryIndividualAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getNaryIndividualAxiomHashCode(OWLNaryIndividualAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* this.getCollectionHashCode(axiom.getIndividuals());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointDataPropertiesAxiom)
	 */
	@Override
	public Integer visit(OWLDisjointDataPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointObjectPropertiesAxiom)
	 */
	@Override
	public Integer visit(OWLDisjointObjectPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyRangeAxiom)
	 */
	@Override
	public Integer visit(OWLObjectPropertyRangeAxiom axiom) {
		return this.getOWLPropertyRangeAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLPropertyRangeAxiomHashCode(
			OWLPropertyRangeAxiom<?, ?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getProperty().accept(this)
				* axiom.getRange().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyAssertionAxiom)
	 */
	@Override
	public Integer visit(OWLObjectPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLFunctionalObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLFunctionalObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectSubPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLSubObjectPropertyOfAxiom axiom) {
		return this.getOWLSubPropertyAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLSubPropertyAxiomHashCode(OWLSubPropertyAxiom<?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getSubProperty().accept(this)
				* axiom.getSuperProperty().accept(this)
		// * this.getPairHashCode(new OrderedPair<OWLPropertyExpression<?, ?>>(
		// axiom.getSubProperty(), axiom.getSuperProperty()))
		;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointUnionAxiom)
	 */
	@Override
	public Integer visit(OWLDisjointUnionAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* this.getCollectionHashCode(axiom.getClassExpressions());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDeclarationAxiom)
	 */
	@Override
	public Integer visit(OWLDeclarationAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getEntity().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLSymmetricObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLSymmetricObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataPropertyRangeAxiom)
	 */
	@Override
	public Integer visit(OWLDataPropertyRangeAxiom axiom) {
		return this.getOWLPropertyRangeAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLFunctionalDataPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLFunctionalDataPropertyAxiom axiom) {
		return this.getOWLDataPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLDataPropertyCharacteristicAxiomHashCode(
			OWLDataPropertyCharacteristicAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEquivalentDataPropertiesAxiom)
	 */
	@Override
	public Integer visit(OWLEquivalentDataPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLClassAssertionAxiom)
	 */
	@Override
	public Integer visit(OWLClassAssertionAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getClassExpression().accept(this)
				* axiom.getIndividual().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEquivalentClassesAxiom)
	 */
	@Override
	public Integer visit(OWLEquivalentClassesAxiom axiom) {
		return this.getNaryClassAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataPropertyAssertionAxiom)
	 */
	@Override
	public Integer visit(OWLDataPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLTransitiveObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLIrreflexiveObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataSubPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLSubDataPropertyOfAxiom axiom) {
		return this.getOWLSubPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLInverseFunctionalObjectPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLSameIndividualsAxiom)
	 */
	@Override
	public Integer visit(OWLSameIndividualAxiom axiom) {
		return this.getNaryIndividualAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyChainSubPropertyAxiom)
	 */
	@Override
	public Integer visit(OWLSubPropertyChainOfAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getSuperProperty().accept(this)
				* this.getOWLConstructHashCode(OWLConstruct.PROPERTY_CHAIN)
				* this.getCollectionHashCode(axiom.getPropertyChain());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLInverseObjectPropertiesAxiom)
	 */
	@Override
	public Integer visit(OWLInverseObjectPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLRule)
	 */
	@Override
	public Integer visit(SWRLRule axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getBody().hashCode() * axiom.getHead().hashCode();
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLClass)
	 */
	@Override
	public Integer visit(OWLClass owlClass) {
		return this.getOWLEntityHashCode(owlClass);
	}

	@Override
	public Integer visit(IRI iri) {
		return this.getIRIHashCode(iri);
	}

	private int getOWLEntityHashCode(OWLEntity owlEntity) {
		// The same prime will be assigned for the same kind of entity. We do
		// not care about the particular entity in this structural hash
		// function.
		OWLEntity representative = owlEntity
				.accept(new OWLEntityVisitorEx<OWLEntity>() {
					public OWLEntity visit(OWLClass cls) {
						return OWLVocabulary.getOWLThing();
					}

					public OWLEntity visit(OWLObjectProperty property) {
						return OWLVocabulary.getOWLTopObjectProperty();
					}

					public OWLEntity visit(OWLDataProperty property) {
						return OWLVocabulary.getOWLTopDataProperty();
					}

					public OWLEntity visit(OWLAnnotationProperty property) {
						return OWLVocabulary.getTopDatatype();
					}

					public OWLEntity visit(OWLNamedIndividual individual) {
						// We return the same prime as the one corresponding to
						// an
						// OWLClass as there can never be a structure where an
						// OWLClass
						// or an OWLIndividual can appear interchangeably.
						return OWLVocabulary.getOWLThing();
					}

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

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectIntersectionOf)
	 */
	@Override
	public Integer visit(OWLObjectIntersectionOf description) {
		return this.getNaryBooleanClassDescriptionHasCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getNaryBooleanClassDescriptionHasCode(
			OWLNaryBooleanClassExpression description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* this.getCollectionHashCode(description.getOperands());
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

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectUnionOf)
	 */
	@Override
	public Integer visit(OWLObjectUnionOf description) {
		return this.getNaryBooleanClassDescriptionHasCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectComplementOf)
	 */
	@Override
	public Integer visit(OWLObjectComplementOf description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* description.getOperand().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectSomeRestriction)
	 */
	@Override
	public Integer visit(OWLObjectSomeValuesFrom description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getOWLQuantifiedRestrictionHashCode(
			OWLQuantifiedRestriction<?, ?, ?> description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* description.getFiller().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectAllRestriction)
	 */
	@Override
	public Integer visit(OWLObjectAllValuesFrom description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectValueRestriction)
	 */
	@Override
	public Integer visit(OWLObjectHasValue description) {
		return this.getOWLValueRestricitonHashCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getOWLValueRestricitonHashCode(
			OWLHasValueRestriction<?, ?, ?> description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* description.getProperty().accept(this)
				* description.getValue().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectMinCardinalityRestriction)
	 */
	@Override
	public Integer visit(OWLObjectMinCardinality description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getOWLCardinalityRestrictionHashCode(
			OWLCardinalityRestriction<?, ?, ?> description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* this.getIntegerHashCode(description.getCardinality())
				* (description.isQualified() ? description.getFiller().accept(
						this) : 1);
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

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectExactCardinalityRestriction)
	 */
	@Override
	public Integer visit(OWLObjectExactCardinality description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectMaxCardinalityRestriction)
	 */
	@Override
	public Integer visit(OWLObjectMaxCardinality descrption) {
		return this.getOWLCardinalityRestrictionHashCode(descrption);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectSelfRestriction)
	 */
	@Override
	public Integer visit(OWLObjectHasSelf description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* description.getProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectOneOf)
	 */
	@Override
	public Integer visit(OWLObjectOneOf description) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(description))
				* this.getCollectionHashCode(description.getIndividuals());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataSomeRestriction)
	 */
	@Override
	public Integer visit(OWLDataSomeValuesFrom description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataAllRestriction)
	 */
	@Override
	public Integer visit(OWLDataAllValuesFrom description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataValueRestriction)
	 */
	@Override
	public Integer visit(OWLDataHasValue description) {
		return this.getOWLValueRestricitonHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataMinCardinalityRestriction)
	 */
	@Override
	public Integer visit(OWLDataMinCardinality description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataExactCardinalityRestriction)
	 */
	@Override
	public Integer visit(OWLDataExactCardinality description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLClassExpressionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataMaxCardinalityRestriction)
	 */
	@Override
	public Integer visit(OWLDataMaxCardinality description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDatatype)
	 */
	@Override
	public Integer visit(OWLDatatype dataType) {
		return this.getOWLEntityHashCode(dataType);
	}

	private <O extends Object> int createHashCode(O key, Map<O, Integer> map) {
		int toReturn = PrimeNumbersUtils.getNextPrime(this.getMaxPrime());
		map.put(key, toReturn);
		this.setMaxPrime(toReturn);
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataComplementOf)
	 */
	@Override
	public Integer visit(OWLDataComplementOf dataComplementOf) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(dataComplementOf))
				* dataComplementOf.getDataRange().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataOneOf)
	 */
	@Override
	public Integer visit(OWLDataOneOf dataOneOf) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(dataOneOf))
				* this.getCollectionHashCode(dataOneOf.getValues());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataRangeRestriction)
	 */
	@Override
	public Integer visit(OWLDatatypeRestriction dataRangeRestriction) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(dataRangeRestriction))
				* dataRangeRestriction.getDatatype().accept(this)
				* (dataRangeRestriction.getFacetRestrictions().isEmpty() ? 1
						: this.getCollectionHashCode(dataRangeRestriction
								.getFacetRestrictions()));
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLTypedConstant)
	 */
	@Override
	public Integer visit(OWLLiteral constant) {
		return this.getOWLConstantHashCode(constant);
	}

	private Integer getOWLConstantHashCode(OWLLiteral constant) {
		// For each constant a single representative will be used for computing
		// the corresponding prime.
		Integer toReturn = entityHashCodes.get(OWLVocabulary.getTopDatatype());
		if (toReturn == null) {
			toReturn = this.createHashCode(OWLVocabulary.getTopDatatype());
		}
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataRangeFacetRestriction)
	 */
	@Override
	public Integer visit(OWLFacetRestriction facet) {
		return this
				.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(facet))
				* facet.getFacetValue().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.
	 *      semanticweb . owl . model . OWLObjectProperty )
	 */
	@Override
	public Integer visit(OWLObjectProperty property) {
		return this.getOWLEntityHashCode(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.
	 *      semanticweb . owl . model . OWLObjectPropertyInverse )
	 */
	@Override
	public Integer visit(OWLObjectInverseOf inverse) {
		return this.getOWLConstructHashCode(OWLConstruct
				.getOWLConstruct(inverse))
				* inverse.getInverseProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.
	 *      semanticweb . owl . model . OWLDataProperty )
	 */
	@Override
	public Integer visit(OWLDataProperty property) {
		return this.getOWLEntityHashCode(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLEntityVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLIndividual)
	 */
	@Override
	public Integer visit(OWLNamedIndividual individual) {
		return this.getOWLEntityHashCode(individual);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLNamedObjectVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLOntology)
	 */
	@Override
	public Integer visit(OWLOntology ontology) {
		return this.getIRIHashCode(ontology.getOntologyID().getOntologyIRI());
	}

	/**
	 * @return the maxPrime
	 */
	public int getMaxPrime() {
		return maxPrime;
	}

	/**
	 * @param maxPrime
	 *            the maxPrime to set
	 */
	private void setMaxPrime(int maxPrime) {
		StructuralHashFunction.maxPrime = maxPrime;
	}

	public int getHashCode(OWLObject owlObject) {
		return owlObject.accept(this);
	}
}
