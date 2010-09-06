/**
 * 
 */
package org.coode.oppl.similarity;

import java.net.URI;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.coode.oppl.utils.OWLVocabulary;
import org.coode.oppl.utils.PrimeNumbersUtils;
import org.semanticweb.owl.model.*;

/**
 * @author Luigi Iannone
 * 
 */
public class StructuralHashFunction implements HashFunction, OWLObjectVisitorEx<Integer> {
	private final static Map<AxiomType<?>, Integer> axiomTypeHashCodes = new HashMap<AxiomType<?>, Integer>();
	private final static Map<URI, Integer> uriHashCodes = new HashMap<URI, Integer>();
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

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLSubClassAxiom)
	 */
	public Integer visit(OWLSubClassAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getSubClass().accept(this)
				* axiom.getSuperClass().accept(this)
		// * this.getPairHashCode(new
		// OrderedPair<OWLDescription>(axiom.getSubClass(),
		// axiom.getSuperClass()));
		;
	}

	// private Integer getPairHashCode(OrderedPair<?> pair) {
	// Integer toReturn = pairHashCodes.get(pair);
	// if (toReturn == null) {
	// toReturn = this.createHashCode(pair);
	// }
	// return toReturn;
	// }
	// protected int createHashCode(OrderedPair<?> pair) {
	// return this.createHashCode(pair, StructuralHashFunction.pairHashCodes);
	// }
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
	public Integer visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLAntiSymmetricObjectPropertyAxiom)
	 */
	public Integer visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLObjectPropertyCharacteristicAxiomHashCode(
			OWLObjectPropertyCharacteristicAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLReflexiveObjectPropertyAxiom)
	 */
	public Integer visit(OWLReflexiveObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointClassesAxiom)
	 */
	public Integer visit(OWLDisjointClassesAxiom axiom) {
		return this.getNaryClassAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getNaryClassAxiomHashCode(OWLNaryClassAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* this.getCollectionHashCode(axiom.getDescriptions());
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
	public Integer visit(OWLDataPropertyDomainAxiom axiom) {
		return this.getOWLPropertyDomainAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLPropertyDomainAxiomHashCode(OWLPropertyDomainAxiom<?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getProperty().accept(this)
				* axiom.getDomain().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLImportsDeclaration)
	 */
	public Integer visit(OWLImportsDeclaration axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* this.getURIHashCode(axiom.getImportedOntologyURI());
	}

	private Integer getURIHashCode(URI uri) {
		Integer toReturn = uriHashCodes.get(uri);
		if (toReturn == null) {
			toReturn = this.createHashCode(uri);
		}
		return toReturn;
	}

	protected int createHashCode(URI uri) {
		return this.createHashCode(uri, uriHashCodes);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLAxiomAnnotationAxiom)
	 */
	public Integer visit(OWLAxiomAnnotationAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getAnnotation().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyDomainAxiom)
	 */
	public Integer visit(OWLObjectPropertyDomainAxiom axiom) {
		return this.getOWLPropertyDomainAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEquivalentObjectPropertiesAxiom)
	 */
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
	public Integer visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getPropertyAssertionHashCode(OWLPropertyAssertionAxiom<?, ?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getProperty().accept(this)
				* axiom.getSubject().accept(this) * axiom.getObject().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDifferentIndividualsAxiom)
	 */
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
	public Integer visit(OWLDisjointDataPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointObjectPropertiesAxiom)
	 */
	public Integer visit(OWLDisjointObjectPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyRangeAxiom)
	 */
	public Integer visit(OWLObjectPropertyRangeAxiom axiom) {
		return this.getOWLPropertyRangeAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLPropertyRangeAxiomHashCode(OWLPropertyRangeAxiom<?, ?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getProperty().accept(this)
				* axiom.getRange().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyAssertionAxiom)
	 */
	public Integer visit(OWLObjectPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLFunctionalObjectPropertyAxiom)
	 */
	public Integer visit(OWLFunctionalObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectSubPropertyAxiom)
	 */
	public Integer visit(OWLObjectSubPropertyAxiom axiom) {
		return this.getOWLSubPropertyAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLSubPropertyAxiomHashCode(OWLSubPropertyAxiom<?> axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getSubProperty().accept(this) * axiom.getSuperProperty().accept(this)
		// * this.getPairHashCode(new OrderedPair<OWLPropertyExpression<?, ?>>(
		// axiom.getSubProperty(), axiom.getSuperProperty()))
		;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDisjointUnionAxiom)
	 */
	public Integer visit(OWLDisjointUnionAxiom axiom) {
		return this.getNaryClassAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDeclarationAxiom)
	 */
	public Integer visit(OWLDeclarationAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getEntity().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEntityAnnotationAxiom)
	 */
	public Integer visit(OWLEntityAnnotationAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getAnnotation().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLOntologyAnnotationAxiom)
	 */
	public Integer visit(OWLOntologyAnnotationAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getSubject().accept(this)
				* axiom.getAnnotation().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLSymmetricObjectPropertyAxiom)
	 */
	public Integer visit(OWLSymmetricObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataPropertyRangeAxiom)
	 */
	public Integer visit(OWLDataPropertyRangeAxiom axiom) {
		return this.getOWLPropertyRangeAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLFunctionalDataPropertyAxiom)
	 */
	public Integer visit(OWLFunctionalDataPropertyAxiom axiom) {
		return this.getOWLDataPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private int getOWLDataPropertyCharacteristicAxiomHashCode(
			OWLDataPropertyCharacteristicAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEquivalentDataPropertiesAxiom)
	 */
	public Integer visit(OWLEquivalentDataPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLClassAssertionAxiom)
	 */
	public Integer visit(OWLClassAssertionAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getDescription().accept(this) * axiom.getIndividual().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLEquivalentClassesAxiom)
	 */
	public Integer visit(OWLEquivalentClassesAxiom axiom) {
		return this.getNaryClassAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataPropertyAssertionAxiom)
	 */
	public Integer visit(OWLDataPropertyAssertionAxiom axiom) {
		return this.getPropertyAssertionHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLTransitiveObjectPropertyAxiom)
	 */
	public Integer visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLIrreflexiveObjectPropertyAxiom)
	 */
	public Integer visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLDataSubPropertyAxiom)
	 */
	public Integer visit(OWLDataSubPropertyAxiom axiom) {
		return this.getOWLSubPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLInverseFunctionalObjectPropertyAxiom)
	 */
	public Integer visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return this.getOWLObjectPropertyCharacteristicAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLSameIndividualsAxiom)
	 */
	public Integer visit(OWLSameIndividualsAxiom axiom) {
		return this.getNaryIndividualAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLObjectPropertyChainSubPropertyAxiom)
	 */
	public Integer visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType())
				* axiom.getSuperProperty().accept(this)
				* this.getOWLConstructHashCode(OWLConstruct.PROPERTY_CHAIN)
				* this.getCollectionHashCode(axiom.getPropertyChain())
		// * this.getSequenceHashCode(axiom.getPropertyChain())
		;
	}

	// private Integer getSequenceHashCode(List<? extends OWLObject> sequence) {
	// Integer toReturn =
	// StructuralHashFunction.sequenceHashCodes.get(sequence);
	// if (toReturn == null) {
	// toReturn = this.createHashCode(sequence);
	// }
	// return toReturn;
	// }
	// protected int createHashCode(List<? extends OWLObject> sequence) {
	// return this.createHashCode(sequence,
	// StructuralHashFunction.sequenceHashCodes);
	// }
	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLInverseObjectPropertiesAxiom)
	 */
	public Integer visit(OWLInverseObjectPropertiesAxiom axiom) {
		return this.getNaryPropertyAxiomHashCode(axiom);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAxiomVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLRule)
	 */
	public Integer visit(SWRLRule axiom) {
		return this.getAxiomTypeHashValue(axiom.getAxiomType()) * axiom.getBody().hashCode()
				* axiom.getHead().hashCode();
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLClass)
	 */
	public Integer visit(OWLClass owlClass) {
		return this.getOWLEntityHashCode(owlClass);
	}

	private int getOWLEntityHashCode(OWLEntity owlEntity) {
		// The same prime will be assigned for the same kind of entity. We do
		// not care about the particular entity in this structural hash
		// function.
		OWLEntity representative = owlEntity.accept(new OWLEntityVisitorEx<OWLEntity>() {
			public OWLEntity visit(OWLClass cls) {
				return OWLVocabulary.getOWLThing();
			}

			public OWLEntity visit(OWLObjectProperty property) {
				return OWLVocabulary.getTopOWLObjectProperty();
			}

			public OWLEntity visit(OWLDataProperty property) {
				return OWLVocabulary.getTopOWLDataProperty();
			}

			public OWLEntity visit(OWLIndividual individual) {
				// We return the same prime as the one corresponding to
				// an
				// OWLClass as there can never be a structure where an
				// OWLClass
				// or an OWLIndividual can appear interchangeably.
				return OWLVocabulary.getOWLThing();
			}

			public OWLEntity visit(OWLDataType dataType) {
				return OWLVocabulary.getTopDataType();
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
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectIntersectionOf)
	 */
	public Integer visit(OWLObjectIntersectionOf description) {
		return this.getNaryBooleanClassDescriptionHasCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getNaryBooleanClassDescriptionHasCode(OWLNaryBooleanDescription description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
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
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectUnionOf)
	 */
	public Integer visit(OWLObjectUnionOf description) {
		return this.getNaryBooleanClassDescriptionHasCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectComplementOf)
	 */
	public Integer visit(OWLObjectComplementOf description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
				* description.getOperand().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectSomeRestriction)
	 */
	public Integer visit(OWLObjectSomeRestriction description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getOWLQuantifiedRestrictionHashCode(OWLQuantifiedRestriction<?, ?> description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
				* description.getFiller().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectAllRestriction)
	 */
	public Integer visit(OWLObjectAllRestriction description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectValueRestriction)
	 */
	public Integer visit(OWLObjectValueRestriction description) {
		return this.getOWLValueRestricitonHashCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getOWLValueRestricitonHashCode(OWLValueRestriction<?, ?> description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
				* description.getProperty().accept(this) * description.getValue().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectMinCardinalityRestriction)
	 */
	public Integer visit(OWLObjectMinCardinalityRestriction description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @param description
	 * @return
	 */
	private int getOWLCardinalityRestrictionHashCode(OWLCardinalityRestriction<?, ?> description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
				* this.getIntegerHashCode(description.getCardinality())
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

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectExactCardinalityRestriction)
	 */
	public Integer visit(OWLObjectExactCardinalityRestriction description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectMaxCardinalityRestriction)
	 */
	public Integer visit(OWLObjectMaxCardinalityRestriction descrption) {
		return this.getOWLCardinalityRestrictionHashCode(descrption);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectSelfRestriction)
	 */
	public Integer visit(OWLObjectSelfRestriction description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
				* description.getProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectOneOf)
	 */
	public Integer visit(OWLObjectOneOf description) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(description))
				* this.getCollectionHashCode(description.getIndividuals());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataSomeRestriction)
	 */
	public Integer visit(OWLDataSomeRestriction description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataAllRestriction)
	 */
	public Integer visit(OWLDataAllRestriction description) {
		return this.getOWLQuantifiedRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataValueRestriction)
	 */
	public Integer visit(OWLDataValueRestriction description) {
		return this.getOWLValueRestricitonHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataMinCardinalityRestriction)
	 */
	public Integer visit(OWLDataMinCardinalityRestriction description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataExactCardinalityRestriction)
	 */
	public Integer visit(OWLDataExactCardinalityRestriction description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLDataMaxCardinalityRestriction)
	 */
	public Integer visit(OWLDataMaxCardinalityRestriction description) {
		return this.getOWLCardinalityRestrictionHashCode(description);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataType)
	 */
	public Integer visit(OWLDataType dataType) {
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
	public Integer visit(OWLDataComplementOf dataComplementOf) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataComplementOf))
				* dataComplementOf.getDataRange().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataOneOf)
	 */
	public Integer visit(OWLDataOneOf dataOneOf) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataOneOf))
				* this.getCollectionHashCode(dataOneOf.getValues());
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataRangeRestriction)
	 */
	public Integer visit(OWLDataRangeRestriction dataRangeRestriction) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(dataRangeRestriction))
				* dataRangeRestriction.getDataRange().accept(this)
				* (dataRangeRestriction.getFacetRestrictions().isEmpty() ? 1
						: this.getCollectionHashCode(dataRangeRestriction.getFacetRestrictions()));
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLTypedConstant)
	 */
	public Integer visit(OWLTypedConstant constant) {
		return this.getOWLConstantHashCode(constant);
	}

	private Integer getOWLConstantHashCode(OWLConstant constant) {
		// For each constant a single representative will be used for computing
		// the corresponding prime.
		Integer toReturn = entityHashCodes.get(OWLVocabulary.getTopDataType());
		if (toReturn == null) {
			toReturn = this.createHashCode(OWLVocabulary.getTopDataType());
		}
		return toReturn;
	}

	// protected int createHashCode(OWLConstant constant) {
	// return this.createHashCode(OWLVocabulary.getTopDataType(),
	// entityHashCodes);
	// }
	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLUntypedConstant)
	 */
	public Integer visit(OWLUntypedConstant constant) {
		return this.getOWLConstantHashCode(constant);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.
	 *      model.OWLDataRangeFacetRestriction)
	 */
	public Integer visit(OWLDataRangeFacetRestriction facet) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(facet))
				* facet.getFacetValue().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.
	 *      semanticweb . owl . model . OWLObjectProperty )
	 */
	public Integer visit(OWLObjectProperty property) {
		return this.getOWLEntityHashCode(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.
	 *      semanticweb . owl . model . OWLObjectPropertyInverse )
	 */
	public Integer visit(OWLObjectPropertyInverse inverse) {
		return this.getOWLConstructHashCode(OWLConstruct.getOWLConstruct(inverse))
				* inverse.getInverseProperty().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLPropertyExpressionVisitorEx#visit(org.
	 *      semanticweb . owl . model . OWLDataProperty )
	 */
	public Integer visit(OWLDataProperty property) {
		return this.getOWLEntityHashCode(property);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLEntityVisitorEx#visit(org.semanticweb.owl
	 *      .model.OWLIndividual)
	 */
	public Integer visit(OWLIndividual individual) {
		return this.getOWLEntityHashCode(individual);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAnnotationVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLObjectAnnotation)
	 */
	public Integer visit(OWLObjectAnnotation objectAnnotation) {
		return this.getURIHashCode(objectAnnotation.getAnnotationURI())
				* objectAnnotation.getAnnotationValue().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.OWLAnnotationVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLConstantAnnotation)
	 */
	public Integer visit(OWLConstantAnnotation annotation) {
		return this.getURIHashCode(annotation.getAnnotationURI())
				* annotation.getAnnotationValue().accept(this);
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLClassAtom)
	 */
	public Integer visit(SWRLClassAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLDataRangeAtom)
	 */
	public Integer visit(SWRLDataRangeAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLObjectPropertyAtom)
	 */
	public Integer visit(SWRLObjectPropertyAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLDataValuedPropertyAtom)
	 */
	public Integer visit(SWRLDataValuedPropertyAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLBuiltInAtom)
	 */
	public Integer visit(SWRLBuiltInAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLAtomDVariable)
	 */
	public Integer visit(SWRLAtomDVariable arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLAtomIVariable)
	 */
	public Integer visit(SWRLAtomIVariable arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLAtomIndividualObject)
	 */
	public Integer visit(SWRLAtomIndividualObject arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLAtomConstantObject)
	 */
	public Integer visit(SWRLAtomConstantObject arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLSameAsAtom)
	 */
	public Integer visit(SWRLSameAsAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.SWRLObjectVisitorEx#visit(org.semanticweb.owl
	 *      .model.SWRLDifferentFromAtom)
	 */
	public Integer visit(SWRLDifferentFromAtom arg0) {
		return 1;
	}

	/**
	 * @see org.semanticweb.owl.model.OWLNamedObjectVisitorEx#visit(org.semanticweb
	 *      .owl.model.OWLOntology)
	 */
	public Integer visit(OWLOntology ontology) {
		return this.getURIHashCode(ontology.getURI());
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
