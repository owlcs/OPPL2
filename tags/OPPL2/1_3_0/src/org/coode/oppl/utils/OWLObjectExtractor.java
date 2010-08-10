/**
 * 
 */
package org.coode.oppl.utils;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLCardinalityRestriction;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNaryBooleanDescription;
import org.semanticweb.owl.model.OWLNaryClassAxiom;
import org.semanticweb.owl.model.OWLNaryIndividualAxiom;
import org.semanticweb.owl.model.OWLNaryPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectAnnotation;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyInverse;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLObjectVisitorEx;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLQuantifiedRestriction;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSubPropertyAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUnaryPropertyAxiom;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.model.OWLValueRestriction;
import org.semanticweb.owl.model.SWRLAtomConstantObject;
import org.semanticweb.owl.model.SWRLAtomDVariable;
import org.semanticweb.owl.model.SWRLAtomIVariable;
import org.semanticweb.owl.model.SWRLAtomIndividualObject;
import org.semanticweb.owl.model.SWRLBuiltInAtom;
import org.semanticweb.owl.model.SWRLClassAtom;
import org.semanticweb.owl.model.SWRLDataRangeAtom;
import org.semanticweb.owl.model.SWRLDataValuedPropertyAtom;
import org.semanticweb.owl.model.SWRLDifferentFromAtom;
import org.semanticweb.owl.model.SWRLObjectPropertyAtom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.model.SWRLSameAsAtom;

/**
 * Extracts from an OWLObject a particular kind of OWLObject component.
 * 
 * @author Luigi Iannone
 * 
 */
public final class OWLObjectExtractor<O extends OWLObject> implements OWLObjectVisitorEx<Set<O>> {
	private final OWLObjectVisitorEx<Boolean> selector;

	/**
	 * @param selector
	 */
	private OWLObjectExtractor(OWLObjectVisitorEx<Boolean> selector) {
		if (selector == null) {
			throw new NullPointerException("The selector cannot be null");
		}
		this.selector = selector;
	}

	public Set<O> visit(OWLSubClassAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getSubClass().accept(this));
		toReturn.addAll(axiom.getSuperClass().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @return
	 */
	private Set<O> visitOWLPropertyAssertionAxiom(OWLPropertyAssertionAxiom<?, ?> axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getProperty().accept(this));
		toReturn.addAll(axiom.getSubject().accept(this));
		toReturn.addAll(axiom.getObject().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
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

	public Set<O> visit(OWLReflexiveObjectPropertyAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(this.visitCharacteristicAxiom(axiom));
		return toReturn;
	}

	public Set<O> visit(OWLDisjointClassesAxiom axiom) {
		return this.visitOWLNAryClassAxiom(axiom);
	}

	/**
	 * @param axiom
	 * @param toReturn
	 */
	private Set<O> visitOWLNAryClassAxiom(OWLNaryClassAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		for (OWLDescription owlDescription : axiom.getDescriptions()) {
			toReturn.addAll(owlDescription.accept(this));
		}
		return toReturn;
	}

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

	public Set<O> visit(OWLAxiomAnnotationAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLObjectPropertyDomainAxiom axiom) {
		return this.visitOWLPropertyDomainAxiom(axiom);
	}

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

	public Set<O> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

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

	public Set<O> visit(OWLDisjointDataPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	public Set<O> visit(OWLDisjointObjectPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

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

	public Set<O> visit(OWLObjectPropertyAssertionAxiom axiom) {
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	public Set<O> visit(OWLFunctionalObjectPropertyAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(this.visitCharacteristicAxiom(axiom));
		return toReturn;
	}

	public Set<O> visit(OWLObjectSubPropertyAxiom axiom) {
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

	public Set<O> visit(OWLDisjointUnionAxiom axiom) {
		return this.visitOWLNAryClassAxiom(axiom);
	}

	public Set<O> visit(OWLDeclarationAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLEntityAnnotationAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLOntologyAnnotationAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLSymmetricObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	public Set<O> visit(OWLDataPropertyRangeAxiom axiom) {
		return this.visitOWLPropertyRangeAxiom(axiom);
	}

	public Set<O> visit(OWLFunctionalDataPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	public Set<O> visit(OWLEquivalentDataPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	public Set<O> visit(OWLClassAssertionAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getDescription().accept(this));
		toReturn.addAll(axiom.getIndividual().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLEquivalentClassesAxiom axiom) {
		return this.visitOWLNAryClassAxiom(axiom);
	}

	public Set<O> visit(OWLDataPropertyAssertionAxiom axiom) {
		return this.visitOWLPropertyAssertionAxiom(axiom);
	}

	public Set<O> visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	public Set<O> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	public Set<O> visit(OWLDataSubPropertyAxiom axiom) {
		return this.visitOWLSubPropertyAxiom(axiom);
	}

	public Set<O> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return this.visitCharacteristicAxiom(axiom);
	}

	public Set<O> visit(OWLSameIndividualsAxiom axiom) {
		return this.visitOWLNaryIndividualAxiom(axiom);
	}

	public Set<O> visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(axiom.getSuperProperty().accept(this));
		for (OWLObject owlObject : axiom.getPropertyChain()) {
			toReturn.addAll(owlObject.accept(this));
		}
		return toReturn;
	}

	public Set<O> visit(OWLInverseObjectPropertiesAxiom axiom) {
		return this.visitOWLNaryPropertyAxiom(axiom);
	}

	public Set<O> visit(SWRLRule rule) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

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

	public Set<O> visit(OWLObjectIntersectionOf desc) {
		return this.visitOWLNaryBooleanDescription(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLNaryBooleanDescription(OWLNaryBooleanDescription desc) {
		Set<O> toReturn = new HashSet<O>();
		for (OWLObject owlObject : desc.getOperands()) {
			toReturn.addAll(owlObject.accept(this));
		}
		return toReturn;
	}

	public Set<O> visit(OWLObjectUnionOf desc) {
		return this.visitOWLNaryBooleanDescription(desc);
	}

	public Set<O> visit(OWLObjectComplementOf desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getOperand().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLObjectSomeRestriction desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLQuantifiedRestriction(OWLQuantifiedRestriction<?, ?> desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		toReturn.addAll(desc.getFiller().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLObjectAllRestriction desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	public Set<O> visit(OWLObjectValueRestriction desc) {
		return this.visitOWLValueRestriction(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLValueRestriction(OWLValueRestriction<?, ?> desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		toReturn.addAll(desc.getValue().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLObjectMinCardinalityRestriction desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	public Set<O> visit(OWLObjectExactCardinalityRestriction desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	public Set<O> visit(OWLObjectMaxCardinalityRestriction desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	/**
	 * @param desc
	 * @return
	 */
	private Set<O> visitOWLCardinalityRestriction(OWLCardinalityRestriction<?, ?> desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		if (desc.getFiller() != null) {
			toReturn.addAll(desc.getFiller().accept(this));
		}
		return toReturn;
	}

	public Set<O> visit(OWLObjectSelfRestriction desc) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(desc.getProperty().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLObjectOneOf desc) {
		Set<O> toReturn = new HashSet<O>();
		for (OWLObject owlObject : desc.getIndividuals()) {
			toReturn.addAll(owlObject.accept(this));
		}
		return toReturn;
	}

	public Set<O> visit(OWLDataSomeRestriction desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	public Set<O> visit(OWLDataAllRestriction desc) {
		return this.visitOWLQuantifiedRestriction(desc);
	}

	public Set<O> visit(OWLDataValueRestriction desc) {
		return this.visitOWLValueRestriction(desc);
	}

	public Set<O> visit(OWLDataMinCardinalityRestriction desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	public Set<O> visit(OWLDataExactCardinalityRestriction desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	public Set<O> visit(OWLDataMaxCardinalityRestriction desc) {
		return this.visitOWLCardinalityRestriction(desc);
	}

	public Set<O> visit(OWLDataType node) {
		return this.visitPrimitive(node);
	}

	public Set<O> visit(OWLDataComplementOf node) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(node.getDataRange().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLDataOneOf node) {
		Set<O> toReturn = new HashSet<O>();
		for (OWLObject owlObject : node.getValues()) {
			toReturn.addAll(owlObject.accept(this));
		}
		return toReturn;
	}

	public Set<O> visit(OWLDataRangeRestriction node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLTypedConstant node) {
		return this.visitPrimitive(node);
	}

	public Set<O> visit(OWLUntypedConstant node) {
		return this.visitPrimitive(node);
	}

	public Set<O> visit(OWLDataRangeFacetRestriction node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLObjectProperty property) {
		return this.visitPrimitive(property);
	}

	public Set<O> visit(OWLObjectPropertyInverse property) {
		Set<O> toReturn = new HashSet<O>();
		toReturn.addAll(property.getInverse().accept(this));
		return toReturn;
	}

	public Set<O> visit(OWLDataProperty property) {
		return this.visitPrimitive(property);
	}

	public Set<O> visit(OWLIndividual individual) {
		return this.visitPrimitive(individual);
	}

	public Set<O> visit(OWLObjectAnnotation annotation) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLConstantAnnotation annotation) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLClassAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLDataRangeAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLObjectPropertyAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLDataValuedPropertyAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLBuiltInAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLAtomDVariable node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLAtomIVariable node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLAtomIndividualObject node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLAtomConstantObject node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLSameAsAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(SWRLDifferentFromAtom node) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
	}

	public Set<O> visit(OWLOntology ontology) {
		Set<O> toReturn = new HashSet<O>();
		return toReturn;
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

	public static Set<OWLObjectProperty> getAllOWLObjectProperties(OWLObject owlObject) {
		OWLObjectExtractor<OWLObjectProperty> extractor = new OWLObjectExtractor<OWLObjectProperty>(
				OWLPrimitiveSelector.getAllOWLObjectPropertySelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLDataProperty> getAllOWLDataProperties(OWLObject owlObject) {
		OWLObjectExtractor<OWLDataProperty> extractor = new OWLObjectExtractor<OWLDataProperty>(
				OWLPrimitiveSelector.getAllOWLDataPropertySelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLIndividual> getAllOWLIndividuals(OWLObject owlObject) {
		OWLObjectExtractor<OWLIndividual> extractor = new OWLObjectExtractor<OWLIndividual>(
				OWLPrimitiveSelector.getAllOWLIndividualSelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLDataType> getAllOWLDataTypes(OWLObject owlObject) {
		OWLObjectExtractor<OWLDataType> extractor = new OWLObjectExtractor<OWLDataType>(
				OWLPrimitiveSelector.getAllOWLDataTypeSelector());
		return getAll(owlObject, extractor);
	}

	public static Set<OWLConstant> getAllOWLConstants(OWLObject owlObject) {
		OWLObjectExtractor<OWLConstant> extractor = new OWLObjectExtractor<OWLConstant>(
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
