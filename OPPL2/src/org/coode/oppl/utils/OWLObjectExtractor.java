/**
 * 
 */
package org.coode.oppl.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
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
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLIndividual;
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
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * Extracts from an OWLObject a particular kind of OWLObject component.
 * 
 * @author Luigi Iannone
 * 
 */
public final class OWLObjectExtractor<O extends OWLObject> extends
		OWLObjectVisitorExAdapter<Set<O>> implements OWLObjectVisitorEx<Set<O>> {
	private final OWLObjectVisitorEx<Boolean> selector;

	/**
	 * @param selector
	 */
	private OWLObjectExtractor(OWLObjectVisitorEx<Boolean> selector) {
		super(Collections.<O> emptySet());
		if (selector == null) {
			throw new NullPointerException("The selector cannot be null");
		}
		this.selector = selector;
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
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private Set<O> visitOWLPropertyAssertionAxiom(
			OWLPropertyAssertionAxiom<?, ?> axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getProperty().accept(this));
		toReturn.addAll(axiom.getSubject().accept(this));
		toReturn.addAll(axiom.getObject().accept(this));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(this.visitCharacteristicAxiom(axiom));
		return toReturn;
	}

	/**
	 * @param axiom
	 * @return
	 */
	private Set<O> visitCharacteristicAxiom(OWLUnaryPropertyAxiom<?> axiom) {
		return axiom.getProperty().accept(this);
	}

	@Override
	public Set<O> visit(OWLReflexiveObjectPropertyAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(this.visitCharacteristicAxiom(axiom));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLDisjointClassesAxiom axiom) {
		return this.visitOWLNAryClassAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @param toReturn
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
		return this.visitOWLPropertyDomainAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private Set<O> visitOWLPropertyDomainAxiom(OWLPropertyDomainAxiom<?> axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getProperty().accept(this));
		toReturn.addAll(axiom.getDomain().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLImportsDeclaration axiom) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectPropertyDomainAxiom axiom) {
		return this.visitOWLPropertyDomainAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
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
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLDifferentIndividualsAxiom axiom) {
		return this.visitOWLNaryIndividualAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
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
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLDisjointObjectPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLObjectPropertyRangeAxiom axiom) {
		return this.visitOWLPropertyRangeAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private Set<O> visitOWLPropertyRangeAxiom(OWLPropertyRangeAxiom<?, ?> axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getProperty().accept(this));
		toReturn.addAll(axiom.getRange().accept(this));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectPropertyAssertionAxiom axiom) {
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLFunctionalObjectPropertyAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(this.visitCharacteristicAxiom(axiom));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLSubObjectPropertyOfAxiom axiom) {
		return this.visitOWLSubPropertyAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
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
		return this.visitCharacteristicAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLDataPropertyRangeAxiom axiom) {
		return this.visitOWLPropertyRangeAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLFunctionalDataPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLEquivalentDataPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
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
		return this.visitOWLNAryClassAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLDataPropertyAssertionAxiom axiom) {
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLSubDataPropertyOfAxiom axiom) {
		return this.visitOWLSubPropertyAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	@Override
	public Set<O> visit(OWLSameIndividualAxiom axiom) {
		return this.visitOWLNaryIndividualAxiom(axiom);
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
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	@Override
	public Set<O> visit(SWRLRule rule) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLClass desc) {
		return this.visitPrimitive(desc);
	}

	/**
	 * @param owlObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Set<O> visitPrimitive(OWLObject owlObject) {
		Set<O> toReturn = new HashSet<O>();
		if (owlObject.accept(this.getSelector())) {
			toReturn.add((O) owlObject);
		}
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectIntersectionOf desc) {
		return this.visitOWLNaryBooleanExpression(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLNaryBooleanExpression(
			OWLNaryBooleanClassExpression desc) {
		Set<O> toReturn = new HashSet<O>();
		for (OWLObject owlObject : desc.getOperands()) {
			toReturn.addAll(owlObject.accept(this));
		}
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectUnionOf desc) {
		return this.visitOWLNaryBooleanExpression(desc);
	}

	@Override
	public Set<O> visit(OWLObjectComplementOf desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getOperand().accept(this));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectSomeValuesFrom desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLQuantifiedRestriction(
			OWLQuantifiedRestriction<?, ?, ?> desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		toReturn.addAll(desc.getFiller().accept(this));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectAllValuesFrom desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLObjectHasValue desc) {
		return this.visitOWLValueRestriction(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLValueRestriction(OWLHasValueRestriction<?, ?, ?> desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		toReturn.addAll(desc.getValue().accept(this));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectMinCardinality desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLObjectExactCardinality desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLObjectMaxCardinality desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLCardinalityRestriction(
			OWLCardinalityRestriction<?, ?, ?> desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		if (desc.getFiller() != null) {
			toReturn.addAll(desc.getFiller().accept(this));
		}
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLObjectHasSelf desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		return toReturn;
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
		return this.visitOWLQuantifiedRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLDataAllValuesFrom desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLDataHasValue desc) {
		return this.visitOWLValueRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLDataMinCardinality desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLDataExactCardinality desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLDataMaxCardinality desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	@Override
	public Set<O> visit(OWLDatatype node) {
		return this.visitPrimitive(node);
	}

	@Override
	public Set<O> visit(OWLDataComplementOf node) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(node.getDataRange().accept(this));
		return toReturn;
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
		return this.visitPrimitive(node);
	}

	@Override
	public Set<O> visit(OWLObjectProperty property) {
		return this.visitPrimitive(property);
	}

	@Override
	public Set<O> visit(OWLObjectInverseOf property) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(property.getInverse().accept(this));
		return toReturn;
	}

	@Override
	public Set<O> visit(OWLDataProperty property) {
		return this.visitPrimitive(property);
	}

	@Override
	public Set<O> visit(OWLNamedIndividual individual) {
		return this.visitPrimitive(individual);
	}

	/**
	 * @return the selector
	 */
	public OWLObjectVisitorEx<Boolean> getSelector() {
		return this.selector;
	}

	public static Set<OWLClass> getAllClasses(OWLObject owlObject) {
		OWLObjectExtractor<OWLClass> extractor = new OWLObjectExtractor<OWLClass>(
				OWLPrimitiveSelector.getAllOWLClassSelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLObjectProperty> getAllOWLObjectProperties(
			OWLObject owlObject) {
		OWLObjectExtractor<OWLObjectProperty> extractor = new OWLObjectExtractor<OWLObjectProperty>(
				OWLPrimitiveSelector.getAllOWLObjectPropertySelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLDataProperty> getAllOWLDataProperties(
			OWLObject owlObject) {
		OWLObjectExtractor<OWLDataProperty> extractor = new OWLObjectExtractor<OWLDataProperty>(
				OWLPrimitiveSelector.getAllOWLDataPropertySelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLIndividual> getAllOWLIndividuals(OWLObject owlObject) {
		OWLObjectExtractor<OWLIndividual> extractor = new OWLObjectExtractor<OWLIndividual>(
				OWLPrimitiveSelector.getAllOWLIndividualSelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLDatatype> getAllOWLDatatypes(OWLObject owlObject) {
		OWLObjectExtractor<OWLDatatype> extractor = new OWLObjectExtractor<OWLDatatype>(
				OWLPrimitiveSelector.getAllOWLDatatypeSelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLLiteral> getAllOWLLiterals(OWLObject owlObject) {
		OWLObjectExtractor<OWLLiteral> extractor = new OWLObjectExtractor<OWLLiteral>(
				OWLPrimitiveSelector.getAllOWLConstantSelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLEntity> getAllOWLEntities(OWLObject owlObject) {
		OWLObjectExtractor<OWLEntity> extractor = new OWLObjectExtractor<OWLEntity>(
				OWLPrimitiveSelector.getAllOWLEntitySelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLObject> getAllOWLPrimitives(OWLObject owlObject) {
		OWLObjectExtractor<OWLObject> extractor = new OWLObjectExtractor<OWLObject>(
				OWLPrimitiveSelector.getAllPrimitiveSelector());
		return getAll(owlObject, extractor);
	}

	/**
	 * @param owlObject
	 * @return
	 */
	private static <T extends OWLObject> Set<T> getAll(OWLObject owlObject,
			OWLObjectExtractor<T> extractor) {
		return owlObject.accept(extractor);
	}
}
