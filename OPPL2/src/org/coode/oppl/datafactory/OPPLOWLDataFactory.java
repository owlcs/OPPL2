/**
 * 
 */
package org.coode.oppl.datafactory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.OWLFacet;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLOWLDataFactory implements OWLDataFactory {
	private final OWLDataFactory delegate;

	/**
	 * @param delegate
	 */
	public OPPLOWLDataFactory(OWLDataFactory delegate) {
		if (delegate == null) {
			throw new NullPointerException(
					"The OWL data factory cannot be null");
		}
		this.delegate = delegate;
	}

	public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
			InlineSet<OWLClassExpression> set) {
		return new OPPLOWLDisjointClassesAxiom(this, set,
				Collections.<OWLAnnotation> emptySet());
	}

	public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
			InlineSet<OWLClassExpression> set,
			Set<? extends OWLAnnotation> annotations) {
		return new OPPLOWLDisjointClassesAxiom(this, set, annotations);
	}

	public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
			InlineSet<OWLObjectPropertyExpression> set) {
		return new OPPLOWLDisjointObjectProperties(this, set,
				Collections.<OWLAnnotation> emptySet());
	}

	public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
			InlineSet<OWLObjectPropertyExpression> set,
			Set<? extends OWLAnnotation> annotations) {
		return new OPPLOWLDisjointObjectProperties(this, set, annotations);
	}

	public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
			InlineSet<OWLDataPropertyExpression> set) {
		return new OPPLOWLDisjointDataProperties(this, set,
				Collections.<OWLAnnotation> emptySet());
	}

	public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
			InlineSet<OWLDataPropertyExpression> set,
			Set<? extends OWLAnnotation> annotations) {
		return new OPPLOWLDisjointDataProperties(this, set, annotations);
	}

	public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
			InlineSet<OWLIndividual> set) {
		return new OPPLOWLDifferentIndividualsAxiom(this, set,
				Collections.<OWLAnnotation> emptySet());
	}

	public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
			InlineSet<OWLIndividual> set,
			Set<? extends OWLAnnotation> annotations) {
		return new OPPLOWLDifferentIndividualsAxiom(this, set, annotations);
	}

	public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
			InlineSet<OWLIndividual> set) {
		return new OPPLOWLSameIndividualAxiom(this, set,
				Collections.<OWLAnnotation> emptySet());
	}

	public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
			InlineSet<OWLIndividual> set,
			Set<? extends OWLAnnotation> annotations) {
		return new OPPLOWLSameIndividualAxiom(this, set, annotations);
	}

	public OWLDataFactory getDelegate() {
		return this.delegate;
	}

	// Delegate methods
	/**
	 * @param iri
	 * @param body
	 * @param head
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLRule(org.semanticweb.owlapi.model.IRI,
	 *      java.util.Set, java.util.Set)
	 */
	@Deprecated
	public SWRLRule getSWRLRule(IRI iri, Set<? extends SWRLAtom> body,
			Set<? extends SWRLAtom> head) {
		return this.delegate.getSWRLRule(iri, body, head);
	}

	/**
	 * @param nodeID
	 * @param body
	 * @param head
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLRule(org.semanticweb.owlapi.model.NodeID,
	 *      java.util.Set, java.util.Set)
	 */
	@Deprecated
	public SWRLRule getSWRLRule(NodeID nodeID, Set<? extends SWRLAtom> body,
			Set<? extends SWRLAtom> head) {
		return this.delegate.getSWRLRule(nodeID, body, head);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLThing()
	 */
	public OWLClass getOWLThing() {
		return this.delegate.getOWLThing();
	}

	/**
	 * @param body
	 * @param head
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLRule(java.util.Set,
	 *      java.util.Set)
	 */
	public SWRLRule getSWRLRule(Set<? extends SWRLAtom> body,
			Set<? extends SWRLAtom> head) {
		return this.delegate.getSWRLRule(body, head);
	}

	/**
	 * @param body
	 * @param head
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLRule(java.util.Set,
	 *      java.util.Set, java.util.Set)
	 */
	public SWRLRule getSWRLRule(Set<? extends SWRLAtom> body,
			Set<? extends SWRLAtom> head, Set<OWLAnnotation> annotations) {
		return this.delegate.getSWRLRule(body, head, annotations);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNothing()
	 */
	public OWLClass getOWLNothing() {
		return this.delegate.getOWLNothing();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTopObjectProperty()
	 */
	public OWLObjectProperty getOWLTopObjectProperty() {
		return this.delegate.getOWLTopObjectProperty();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTopDataProperty()
	 */
	public OWLDataProperty getOWLTopDataProperty() {
		return this.delegate.getOWLTopDataProperty();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLBottomObjectProperty()
	 */
	public OWLObjectProperty getOWLBottomObjectProperty() {
		return this.delegate.getOWLBottomObjectProperty();
	}

	/**
	 * @param predicate
	 * @param arg
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLClassAtom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.SWRLIArgument)
	 */
	public SWRLClassAtom getSWRLClassAtom(OWLClassExpression predicate,
			SWRLIArgument arg) {
		return this.delegate.getSWRLClassAtom(predicate, arg);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLBottomDataProperty()
	 */
	public OWLDataProperty getOWLBottomDataProperty() {
		return this.delegate.getOWLBottomDataProperty();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getTopDatatype()
	 */
	public OWLDatatype getTopDatatype() {
		return this.delegate.getTopDatatype();
	}

	/**
	 * @param <E>
	 * @param entityType
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEntity(org.semanticweb.owlapi.model.EntityType,
	 *      org.semanticweb.owlapi.model.IRI)
	 */
	public <E extends OWLEntity> E getOWLEntity(EntityType<E> entityType,
			IRI iri) {
		return this.delegate.getOWLEntity(entityType, iri);
	}

	/**
	 * @param predicate
	 * @param arg
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLDataRangeAtom(org.semanticweb.owlapi.model.OWLDataRange,
	 *      org.semanticweb.owlapi.model.SWRLDArgument)
	 */
	public SWRLDataRangeAtom getSWRLDataRangeAtom(OWLDataRange predicate,
			SWRLDArgument arg) {
		return this.delegate.getSWRLDataRangeAtom(predicate, arg);
	}

	/**
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLClass(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLClass getOWLClass(IRI iri) {
		return this.delegate.getOWLClass(iri);
	}

	/**
	 * @param property
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLObjectPropertyAtom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.SWRLIArgument,
	 *      org.semanticweb.owlapi.model.SWRLIArgument)
	 */
	public SWRLObjectPropertyAtom getSWRLObjectPropertyAtom(
			OWLObjectPropertyExpression property, SWRLIArgument arg0,
			SWRLIArgument arg1) {
		return this.delegate.getSWRLObjectPropertyAtom(property, arg0, arg1);
	}

	/**
	 * @param abbreviatedIRI
	 * @param prefixManager
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLClass(java.lang.String,
	 *      org.semanticweb.owlapi.model.PrefixManager)
	 */
	public OWLClass getOWLClass(String abbreviatedIRI,
			PrefixManager prefixManager) {
		return this.delegate.getOWLClass(abbreviatedIRI, prefixManager);
	}

	/**
	 * @param property
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLDataPropertyAtom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.SWRLIArgument,
	 *      org.semanticweb.owlapi.model.SWRLDArgument)
	 */
	public SWRLDataPropertyAtom getSWRLDataPropertyAtom(
			OWLDataPropertyExpression property, SWRLIArgument arg0,
			SWRLDArgument arg1) {
		return this.delegate.getSWRLDataPropertyAtom(property, arg0, arg1);
	}

	/**
	 * @param builtInIRI
	 * @param args
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLBuiltInAtom(org.semanticweb.owlapi.model.IRI,
	 *      java.util.List)
	 */
	public SWRLBuiltInAtom getSWRLBuiltInAtom(IRI builtInIRI,
			List<SWRLDArgument> args) {
		return this.delegate.getSWRLBuiltInAtom(builtInIRI, args);
	}

	/**
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectProperty(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLObjectProperty getOWLObjectProperty(IRI iri) {
		return this.delegate.getOWLObjectProperty(iri);
	}

	/**
	 * @param abbreviatedIRI
	 * @param prefixManager
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectProperty(java.lang.String,
	 *      org.semanticweb.owlapi.model.PrefixManager)
	 */
	public OWLObjectProperty getOWLObjectProperty(String abbreviatedIRI,
			PrefixManager prefixManager) {
		return this.delegate
				.getOWLObjectProperty(abbreviatedIRI, prefixManager);
	}

	/**
	 * @param var
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLVariable(org.semanticweb.owlapi.model.IRI)
	 */
	public SWRLVariable getSWRLVariable(IRI var) {
		return this.delegate.getSWRLVariable(var);
	}

	/**
	 * @param individual
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLIndividualArgument(org.semanticweb.owlapi.model.OWLIndividual)
	 */
	public SWRLIndividualArgument getSWRLIndividualArgument(
			OWLIndividual individual) {
		return this.delegate.getSWRLIndividualArgument(individual);
	}

	/**
	 * @param literal
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLLiteralArgument(org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public SWRLLiteralArgument getSWRLLiteralArgument(OWLLiteral literal) {
		return this.delegate.getSWRLLiteralArgument(literal);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLSameIndividualAtom(org.semanticweb.owlapi.model.SWRLIArgument,
	 *      org.semanticweb.owlapi.model.SWRLIArgument)
	 */
	public SWRLSameIndividualAtom getSWRLSameIndividualAtom(SWRLIArgument arg0,
			SWRLIArgument arg1) {
		return this.delegate.getSWRLSameIndividualAtom(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.semanticweb.owlapi.model.SWRLDataFactory#getSWRLDifferentIndividualsAtom(org.semanticweb.owlapi.model.SWRLIArgument,
	 *      org.semanticweb.owlapi.model.SWRLIArgument)
	 */
	public SWRLDifferentIndividualsAtom getSWRLDifferentIndividualsAtom(
			SWRLIArgument arg0, SWRLIArgument arg1) {
		return this.delegate.getSWRLDifferentIndividualsAtom(arg0, arg1);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectInverseOf(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLObjectInverseOf getOWLObjectInverseOf(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLObjectInverseOf(property);
	}

	/**
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataProperty(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLDataProperty getOWLDataProperty(IRI iri) {
		return this.delegate.getOWLDataProperty(iri);
	}

	/**
	 * @param abbreviatedIRI
	 * @param prefixManager
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataProperty(java.lang.String,
	 *      org.semanticweb.owlapi.model.PrefixManager)
	 */
	public OWLDataProperty getOWLDataProperty(String abbreviatedIRI,
			PrefixManager prefixManager) {
		return this.delegate.getOWLDataProperty(abbreviatedIRI, prefixManager);
	}

	/**
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNamedIndividual(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLNamedIndividual getOWLNamedIndividual(IRI iri) {
		return this.delegate.getOWLNamedIndividual(iri);
	}

	/**
	 * @param abbreviatedIRI
	 * @param prefixManager
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNamedIndividual(java.lang.String,
	 *      org.semanticweb.owlapi.model.PrefixManager)
	 */
	public OWLNamedIndividual getOWLNamedIndividual(String abbreviatedIRI,
			PrefixManager prefixManager) {
		return this.delegate.getOWLNamedIndividual(abbreviatedIRI,
				prefixManager);
	}

	/**
	 * @param id
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnonymousIndividual(java.lang.String)
	 */
	public OWLAnonymousIndividual getOWLAnonymousIndividual(String id) {
		return this.delegate.getOWLAnonymousIndividual(id);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnonymousIndividual()
	 */
	public OWLAnonymousIndividual getOWLAnonymousIndividual() {
		return this.delegate.getOWLAnonymousIndividual();
	}

	/**
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationProperty(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLAnnotationProperty getOWLAnnotationProperty(IRI iri) {
		return this.delegate.getOWLAnnotationProperty(iri);
	}

	/**
	 * @param abbreviatedIRI
	 * @param prefixManager
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationProperty(java.lang.String,
	 *      org.semanticweb.owlapi.model.PrefixManager)
	 */
	public OWLAnnotationProperty getOWLAnnotationProperty(
			String abbreviatedIRI, PrefixManager prefixManager) {
		return this.delegate.getOWLAnnotationProperty(abbreviatedIRI,
				prefixManager);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getRDFSLabel()
	 */
	public OWLAnnotationProperty getRDFSLabel() {
		return this.delegate.getRDFSLabel();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getRDFSComment()
	 */
	public OWLAnnotationProperty getRDFSComment() {
		return this.delegate.getRDFSComment();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getRDFSSeeAlso()
	 */
	public OWLAnnotationProperty getRDFSSeeAlso() {
		return this.delegate.getRDFSSeeAlso();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getRDFSIsDefinedBy()
	 */
	public OWLAnnotationProperty getRDFSIsDefinedBy() {
		return this.delegate.getRDFSIsDefinedBy();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLVersionInfo()
	 */
	public OWLAnnotationProperty getOWLVersionInfo() {
		return this.delegate.getOWLVersionInfo();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLBackwardCompatibleWith()
	 */
	public OWLAnnotationProperty getOWLBackwardCompatibleWith() {
		return this.delegate.getOWLBackwardCompatibleWith();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLIncompatibleWith()
	 */
	public OWLAnnotationProperty getOWLIncompatibleWith() {
		return this.delegate.getOWLIncompatibleWith();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDeprecated()
	 */
	public OWLAnnotationProperty getOWLDeprecated() {
		return this.delegate.getOWLDeprecated();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getRDFPlainLiteral()
	 */
	public OWLDatatype getRDFPlainLiteral() {
		return this.delegate.getRDFPlainLiteral();
	}

	/**
	 * @param iri
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatype(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLDatatype getOWLDatatype(IRI iri) {
		return this.delegate.getOWLDatatype(iri);
	}

	/**
	 * @param abbreviatedIRI
	 * @param prefixManager
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatype(java.lang.String,
	 *      org.semanticweb.owlapi.model.PrefixManager)
	 */
	public OWLDatatype getOWLDatatype(String abbreviatedIRI,
			PrefixManager prefixManager) {
		return this.delegate.getOWLDatatype(abbreviatedIRI, prefixManager);
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getIntegerOWLDatatype()
	 */
	public OWLDatatype getIntegerOWLDatatype() {
		return this.delegate.getIntegerOWLDatatype();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getFloatOWLDatatype()
	 */
	public OWLDatatype getFloatOWLDatatype() {
		return this.delegate.getFloatOWLDatatype();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getDoubleOWLDatatype()
	 */
	public OWLDatatype getDoubleOWLDatatype() {
		return this.delegate.getDoubleOWLDatatype();
	}

	/**
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getBooleanOWLDatatype()
	 */
	public OWLDatatype getBooleanOWLDatatype() {
		return this.delegate.getBooleanOWLDatatype();
	}

	/**
	 * @param lexicalValue
	 * @param datatype
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(java.lang.String,
	 *      org.semanticweb.owlapi.model.OWLDatatype)
	 */
	public OWLLiteral getOWLLiteral(String lexicalValue, OWLDatatype datatype) {
		return this.delegate.getOWLLiteral(lexicalValue, datatype);
	}

	/**
	 * @param lexicalValue
	 * @param datatype
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(java.lang.String,
	 *      org.semanticweb.owlapi.vocab.OWL2Datatype)
	 */
	public OWLLiteral getOWLLiteral(String lexicalValue, OWL2Datatype datatype) {
		return this.delegate.getOWLLiteral(lexicalValue, datatype);
	}

	/**
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(int)
	 */
	public OWLLiteral getOWLLiteral(int value) {
		return this.delegate.getOWLLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(double)
	 */
	public OWLLiteral getOWLLiteral(double value) {
		return this.delegate.getOWLLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(boolean)
	 */
	public OWLLiteral getOWLLiteral(boolean value) {
		return this.delegate.getOWLLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(float)
	 */
	public OWLLiteral getOWLLiteral(float value) {
		return this.delegate.getOWLLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(java.lang.String)
	 */
	public OWLLiteral getOWLLiteral(String value) {
		return this.delegate.getOWLLiteral(value);
	}

	/**
	 * @param literal
	 * @param lang
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLLiteral(java.lang.String,
	 *      java.lang.String)
	 */
	public OWLLiteral getOWLLiteral(String literal, String lang) {
		return this.delegate.getOWLLiteral(literal, lang);
	}

	/**
	 * @param literal
	 * @param datatype
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(java.lang.String,
	 *      org.semanticweb.owlapi.model.OWLDatatype)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(String literal, OWLDatatype datatype) {
		return this.delegate.getOWLTypedLiteral(literal, datatype);
	}

	/**
	 * @param literal
	 * @param datatype
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(java.lang.String,
	 *      org.semanticweb.owlapi.vocab.OWL2Datatype)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(String literal, OWL2Datatype datatype) {
		return this.delegate.getOWLTypedLiteral(literal, datatype);
	}

	/**
	 * @param value
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(int)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(int value) {
		return this.delegate.getOWLTypedLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(double)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(double value) {
		return this.delegate.getOWLTypedLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(boolean)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(boolean value) {
		return this.delegate.getOWLTypedLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(float)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(float value) {
		return this.delegate.getOWLTypedLiteral(value);
	}

	/**
	 * @param value
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTypedLiteral(java.lang.String)
	 */
	@Deprecated
	public OWLLiteral getOWLTypedLiteral(String value) {
		return this.delegate.getOWLTypedLiteral(value);
	}

	/**
	 * @param literal
	 * @param lang
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLStringLiteral(java.lang.String,
	 *      java.lang.String)
	 */
	@Deprecated
	public OWLLiteral getOWLStringLiteral(String literal, String lang) {
		return this.delegate.getOWLStringLiteral(literal, lang);
	}

	/**
	 * @param literal
	 * @return
	 * @deprecated
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLStringLiteral(java.lang.String)
	 */
	@Deprecated
	public OWLLiteral getOWLStringLiteral(String literal) {
		return this.delegate.getOWLStringLiteral(literal);
	}

	/**
	 * @param values
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataOneOf(java.util.Set)
	 */
	public OWLDataOneOf getOWLDataOneOf(Set<? extends OWLLiteral> values) {
		return this.delegate.getOWLDataOneOf(values);
	}

	/**
	 * @param values
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataOneOf(org.semanticweb.owlapi.model.OWLLiteral[])
	 */
	public OWLDataOneOf getOWLDataOneOf(OWLLiteral... values) {
		return this.delegate.getOWLDataOneOf(values);
	}

	/**
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataComplementOf(org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataComplementOf getOWLDataComplementOf(OWLDataRange dataRange) {
		return this.delegate.getOWLDataComplementOf(dataRange);
	}

	/**
	 * @param dataRange
	 * @param facetRestrictions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeRestriction(org.semanticweb.owlapi.model.OWLDatatype,
	 *      java.util.Set)
	 */
	public OWLDatatypeRestriction getOWLDatatypeRestriction(
			OWLDatatype dataRange, Set<OWLFacetRestriction> facetRestrictions) {
		return this.delegate.getOWLDatatypeRestriction(dataRange,
				facetRestrictions);
	}

	/**
	 * @param dataRange
	 * @param facet
	 * @param typedLiteral
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeRestriction(org.semanticweb.owlapi.model.OWLDatatype,
	 *      org.semanticweb.owlapi.vocab.OWLFacet,
	 *      org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public OWLDatatypeRestriction getOWLDatatypeRestriction(
			OWLDatatype dataRange, OWLFacet facet, OWLLiteral typedLiteral) {
		return this.delegate.getOWLDatatypeRestriction(dataRange, facet,
				typedLiteral);
	}

	/**
	 * @param dataRange
	 * @param facetRestrictions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeRestriction(org.semanticweb.owlapi.model.OWLDatatype,
	 *      org.semanticweb.owlapi.model.OWLFacetRestriction[])
	 */
	public OWLDatatypeRestriction getOWLDatatypeRestriction(
			OWLDatatype dataRange, OWLFacetRestriction... facetRestrictions) {
		return this.delegate.getOWLDatatypeRestriction(dataRange,
				facetRestrictions);
	}

	/**
	 * @param minInclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinInclusiveRestriction(int)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinInclusiveRestriction(
			int minInclusive) {
		return this.delegate
				.getOWLDatatypeMinInclusiveRestriction(minInclusive);
	}

	/**
	 * @param maxInclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMaxInclusiveRestriction(int)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMaxInclusiveRestriction(
			int maxInclusive) {
		return this.delegate
				.getOWLDatatypeMaxInclusiveRestriction(maxInclusive);
	}

	/**
	 * @param minInclusive
	 * @param maxInclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinMaxInclusiveRestriction(int,
	 *      int)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinMaxInclusiveRestriction(
			int minInclusive, int maxInclusive) {
		return this.delegate.getOWLDatatypeMinMaxInclusiveRestriction(
				minInclusive, maxInclusive);
	}

	/**
	 * @param minExclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinExclusiveRestriction(int)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinExclusiveRestriction(
			int minExclusive) {
		return this.delegate
				.getOWLDatatypeMinExclusiveRestriction(minExclusive);
	}

	/**
	 * @param maxExclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMaxExclusiveRestriction(int)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMaxExclusiveRestriction(
			int maxExclusive) {
		return this.delegate
				.getOWLDatatypeMaxExclusiveRestriction(maxExclusive);
	}

	/**
	 * @param minExclusive
	 * @param maxExclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinMaxExclusiveRestriction(int,
	 *      int)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinMaxExclusiveRestriction(
			int minExclusive, int maxExclusive) {
		return this.delegate.getOWLDatatypeMinMaxExclusiveRestriction(
				minExclusive, maxExclusive);
	}

	/**
	 * @param minInclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinInclusiveRestriction(double)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinInclusiveRestriction(
			double minInclusive) {
		return this.delegate
				.getOWLDatatypeMinInclusiveRestriction(minInclusive);
	}

	/**
	 * @param maxInclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMaxInclusiveRestriction(double)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMaxInclusiveRestriction(
			double maxInclusive) {
		return this.delegate
				.getOWLDatatypeMaxInclusiveRestriction(maxInclusive);
	}

	/**
	 * @param minInclusive
	 * @param maxInclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinMaxInclusiveRestriction(double,
	 *      double)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinMaxInclusiveRestriction(
			double minInclusive, double maxInclusive) {
		return this.delegate.getOWLDatatypeMinMaxInclusiveRestriction(
				minInclusive, maxInclusive);
	}

	/**
	 * @param minExclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinExclusiveRestriction(double)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinExclusiveRestriction(
			double minExclusive) {
		return this.delegate
				.getOWLDatatypeMinExclusiveRestriction(minExclusive);
	}

	/**
	 * @param maxExclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMaxExclusiveRestriction(double)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMaxExclusiveRestriction(
			double maxExclusive) {
		return this.delegate
				.getOWLDatatypeMaxExclusiveRestriction(maxExclusive);
	}

	/**
	 * @param minExclusive
	 * @param maxExclusive
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeMinMaxExclusiveRestriction(double,
	 *      double)
	 */
	public OWLDatatypeRestriction getOWLDatatypeMinMaxExclusiveRestriction(
			double minExclusive, double maxExclusive) {
		return this.delegate.getOWLDatatypeMinMaxExclusiveRestriction(
				minExclusive, maxExclusive);
	}

	/**
	 * @param facet
	 * @param facetValue
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFacetRestriction(org.semanticweb.owlapi.vocab.OWLFacet,
	 *      org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet,
			OWLLiteral facetValue) {
		return this.delegate.getOWLFacetRestriction(facet, facetValue);
	}

	/**
	 * @param facet
	 * @param facetValue
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFacetRestriction(org.semanticweb.owlapi.vocab.OWLFacet,
	 *      int)
	 */
	public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet,
			int facetValue) {
		return this.delegate.getOWLFacetRestriction(facet, facetValue);
	}

	/**
	 * @param facet
	 * @param facetValue
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFacetRestriction(org.semanticweb.owlapi.vocab.OWLFacet,
	 *      double)
	 */
	public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet,
			double facetValue) {
		return this.delegate.getOWLFacetRestriction(facet, facetValue);
	}

	/**
	 * @param facet
	 * @param facetValue
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFacetRestriction(org.semanticweb.owlapi.vocab.OWLFacet,
	 *      float)
	 */
	public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet,
			float facetValue) {
		return this.delegate.getOWLFacetRestriction(facet, facetValue);
	}

	/**
	 * @param dataRanges
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataUnionOf(java.util.Set)
	 */
	public OWLDataUnionOf getOWLDataUnionOf(
			Set<? extends OWLDataRange> dataRanges) {
		return this.delegate.getOWLDataUnionOf(dataRanges);
	}

	/**
	 * @param dataRanges
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataUnionOf(org.semanticweb.owlapi.model.OWLDataRange[])
	 */
	public OWLDataUnionOf getOWLDataUnionOf(OWLDataRange... dataRanges) {
		return this.delegate.getOWLDataUnionOf(dataRanges);
	}

	/**
	 * @param dataRanges
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataIntersectionOf(java.util.Set)
	 */
	public OWLDataIntersectionOf getOWLDataIntersectionOf(
			Set<? extends OWLDataRange> dataRanges) {
		return this.delegate.getOWLDataIntersectionOf(dataRanges);
	}

	/**
	 * @param dataRanges
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataIntersectionOf(org.semanticweb.owlapi.model.OWLDataRange[])
	 */
	public OWLDataIntersectionOf getOWLDataIntersectionOf(
			OWLDataRange... dataRanges) {
		return this.delegate.getOWLDataIntersectionOf(dataRanges);
	}

	/**
	 * @param operands
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectIntersectionOf(java.util.Set)
	 */
	public OWLObjectIntersectionOf getOWLObjectIntersectionOf(
			Set<? extends OWLClassExpression> operands) {
		return this.delegate.getOWLObjectIntersectionOf(operands);
	}

	/**
	 * @param operands
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectIntersectionOf(org.semanticweb.owlapi.model.OWLClassExpression[])
	 */
	public OWLObjectIntersectionOf getOWLObjectIntersectionOf(
			OWLClassExpression... operands) {
		return this.delegate.getOWLObjectIntersectionOf(operands);
	}

	/**
	 * @param property
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataSomeValuesFrom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataSomeValuesFrom getOWLDataSomeValuesFrom(
			OWLDataPropertyExpression property, OWLDataRange dataRange) {
		return this.delegate.getOWLDataSomeValuesFrom(property, dataRange);
	}

	/**
	 * @param property
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataAllValuesFrom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataAllValuesFrom getOWLDataAllValuesFrom(
			OWLDataPropertyExpression property, OWLDataRange dataRange) {
		return this.delegate.getOWLDataAllValuesFrom(property, dataRange);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataExactCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression)
	 */
	public OWLDataExactCardinality getOWLDataExactCardinality(int cardinality,
			OWLDataPropertyExpression property) {
		return this.delegate.getOWLDataExactCardinality(cardinality, property);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataExactCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataExactCardinality getOWLDataExactCardinality(int cardinality,
			OWLDataPropertyExpression property, OWLDataRange dataRange) {
		return this.delegate.getOWLDataExactCardinality(cardinality, property,
				dataRange);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataMaxCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression)
	 */
	public OWLDataMaxCardinality getOWLDataMaxCardinality(int cardinality,
			OWLDataPropertyExpression property) {
		return this.delegate.getOWLDataMaxCardinality(cardinality, property);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataMaxCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataMaxCardinality getOWLDataMaxCardinality(int cardinality,
			OWLDataPropertyExpression property, OWLDataRange dataRange) {
		return this.delegate.getOWLDataMaxCardinality(cardinality, property,
				dataRange);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataMinCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression)
	 */
	public OWLDataMinCardinality getOWLDataMinCardinality(int cardinality,
			OWLDataPropertyExpression property) {
		return this.delegate.getOWLDataMinCardinality(cardinality, property);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataMinCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataMinCardinality getOWLDataMinCardinality(int cardinality,
			OWLDataPropertyExpression property, OWLDataRange dataRange) {
		return this.delegate.getOWLDataMinCardinality(cardinality, property,
				dataRange);
	}

	/**
	 * @param property
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataHasValue(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public OWLDataHasValue getOWLDataHasValue(
			OWLDataPropertyExpression property, OWLLiteral value) {
		return this.delegate.getOWLDataHasValue(property, value);
	}

	/**
	 * @param operand
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectComplementOf(org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectComplementOf getOWLObjectComplementOf(
			OWLClassExpression operand) {
		return this.delegate.getOWLObjectComplementOf(operand);
	}

	/**
	 * @param values
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectOneOf(java.util.Set)
	 */
	public OWLObjectOneOf getOWLObjectOneOf(Set<? extends OWLIndividual> values) {
		return this.delegate.getOWLObjectOneOf(values);
	}

	/**
	 * @param individuals
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectOneOf(org.semanticweb.owlapi.model.OWLIndividual[])
	 */
	public OWLObjectOneOf getOWLObjectOneOf(OWLIndividual... individuals) {
		return this.delegate.getOWLObjectOneOf(individuals);
	}

	/**
	 * @param property
	 * @param classExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectAllValuesFrom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectAllValuesFrom getOWLObjectAllValuesFrom(
			OWLObjectPropertyExpression property,
			OWLClassExpression classExpression) {
		return this.delegate.getOWLObjectAllValuesFrom(property,
				classExpression);
	}

	/**
	 * @param property
	 * @param classExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectSomeValuesFrom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectSomeValuesFrom getOWLObjectSomeValuesFrom(
			OWLObjectPropertyExpression property,
			OWLClassExpression classExpression) {
		return this.delegate.getOWLObjectSomeValuesFrom(property,
				classExpression);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectExactCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLObjectExactCardinality getOWLObjectExactCardinality(
			int cardinality, OWLObjectPropertyExpression property) {
		return this.delegate
				.getOWLObjectExactCardinality(cardinality, property);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @param classExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectExactCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectExactCardinality getOWLObjectExactCardinality(
			int cardinality, OWLObjectPropertyExpression property,
			OWLClassExpression classExpression) {
		return this.delegate.getOWLObjectExactCardinality(cardinality,
				property, classExpression);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectMinCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLObjectMinCardinality getOWLObjectMinCardinality(int cardinality,
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLObjectMinCardinality(cardinality, property);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @param classExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectMinCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectMinCardinality getOWLObjectMinCardinality(int cardinality,
			OWLObjectPropertyExpression property,
			OWLClassExpression classExpression) {
		return this.delegate.getOWLObjectMinCardinality(cardinality, property,
				classExpression);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectMaxCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLObjectMaxCardinality getOWLObjectMaxCardinality(int cardinality,
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLObjectMaxCardinality(cardinality, property);
	}

	/**
	 * @param cardinality
	 * @param property
	 * @param classExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectMaxCardinality(int,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectMaxCardinality getOWLObjectMaxCardinality(int cardinality,
			OWLObjectPropertyExpression property,
			OWLClassExpression classExpression) {
		return this.delegate.getOWLObjectMaxCardinality(cardinality, property,
				classExpression);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectHasSelf(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLObjectHasSelf getOWLObjectHasSelf(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLObjectHasSelf(property);
	}

	/**
	 * @param property
	 * @param individual
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectHasValue(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual)
	 */
	public OWLObjectHasValue getOWLObjectHasValue(
			OWLObjectPropertyExpression property, OWLIndividual individual) {
		return this.delegate.getOWLObjectHasValue(property, individual);
	}

	/**
	 * @param operands
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectUnionOf(java.util.Set)
	 */
	public OWLObjectUnionOf getOWLObjectUnionOf(
			Set<? extends OWLClassExpression> operands) {
		return this.delegate.getOWLObjectUnionOf(operands);
	}

	/**
	 * @param operands
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectUnionOf(org.semanticweb.owlapi.model.OWLClassExpression[])
	 */
	public OWLObjectUnionOf getOWLObjectUnionOf(OWLClassExpression... operands) {
		return this.delegate.getOWLObjectUnionOf(operands);
	}

	/**
	 * @param owlEntity
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDeclarationAxiom(org.semanticweb.owlapi.model.OWLEntity)
	 */
	public OWLDeclarationAxiom getOWLDeclarationAxiom(OWLEntity owlEntity) {
		return this.delegate.getOWLDeclarationAxiom(owlEntity);
	}

	/**
	 * @param owlEntity
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDeclarationAxiom(org.semanticweb.owlapi.model.OWLEntity,
	 *      java.util.Set)
	 */
	public OWLDeclarationAxiom getOWLDeclarationAxiom(OWLEntity owlEntity,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDeclarationAxiom(owlEntity, annotations);
	}

	/**
	 * @param subClass
	 * @param superClass
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubClassOfAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLSubClassOfAxiom getOWLSubClassOfAxiom(
			OWLClassExpression subClass, OWLClassExpression superClass) {
		return this.delegate.getOWLSubClassOfAxiom(subClass, superClass);
	}

	/**
	 * @param subClass
	 * @param superClass
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubClassOfAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression, java.util.Set)
	 */
	public OWLSubClassOfAxiom getOWLSubClassOfAxiom(
			OWLClassExpression subClass, OWLClassExpression superClass,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLSubClassOfAxiom(subClass, superClass,
				annotations);
	}

	/**
	 * @param classExpressions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentClassesAxiom(java.util.Set)
	 */
	public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
			Set<? extends OWLClassExpression> classExpressions) {
		return this.delegate.getOWLEquivalentClassesAxiom(classExpressions);
	}

	/**
	 * @param classExpressions
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentClassesAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
			Set<? extends OWLClassExpression> classExpressions,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLEquivalentClassesAxiom(classExpressions,
				annotations);
	}

	/**
	 * @param classExpressions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentClassesAxiom(org.semanticweb.owlapi.model.OWLClassExpression[])
	 */
	public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
			OWLClassExpression... classExpressions) {
		return this.delegate.getOWLEquivalentClassesAxiom(classExpressions);
	}

	/**
	 * @param clsA
	 * @param clsB
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentClassesAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
			OWLClassExpression clsA, OWLClassExpression clsB) {
		return this.delegate.getOWLEquivalentClassesAxiom(clsA, clsB);
	}

	/**
	 * @param clsA
	 * @param clsB
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentClassesAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression, java.util.Set)
	 */
	public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
			OWLClassExpression clsA, OWLClassExpression clsB,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLEquivalentClassesAxiom(clsA, clsB,
				annotations);
	}

	/**
	 * @param classExpressions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointClassesAxiom(java.util.Set)
	 */
	public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
			Set<? extends OWLClassExpression> classExpressions) {
		return this.delegate.getOWLDisjointClassesAxiom(classExpressions);
	}

	/**
	 * @param classExpressions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointClassesAxiom(org.semanticweb.owlapi.model.OWLClassExpression[])
	 */
	public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
			OWLClassExpression... classExpressions) {
		return this.delegate.getOWLDisjointClassesAxiom(classExpressions);
	}

	/**
	 * @param classExpressions
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointClassesAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
			Set<? extends OWLClassExpression> classExpressions,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDisjointClassesAxiom(classExpressions,
				annotations);
	}

	/**
	 * @param owlClass
	 * @param classExpressions
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointUnionAxiom(org.semanticweb.owlapi.model.OWLClass,
	 *      java.util.Set)
	 */
	public OWLDisjointUnionAxiom getOWLDisjointUnionAxiom(OWLClass owlClass,
			Set<? extends OWLClassExpression> classExpressions) {
		return this.delegate.getOWLDisjointUnionAxiom(owlClass,
				classExpressions);
	}

	/**
	 * @param owlClass
	 * @param classExpressions
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointUnionAxiom(org.semanticweb.owlapi.model.OWLClass,
	 *      java.util.Set, java.util.Set)
	 */
	public OWLDisjointUnionAxiom getOWLDisjointUnionAxiom(OWLClass owlClass,
			Set<? extends OWLClassExpression> classExpressions,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDisjointUnionAxiom(owlClass,
				classExpressions, annotations);
	}

	/**
	 * @param subProperty
	 * @param superProperty
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubObjectPropertyOfAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLSubObjectPropertyOfAxiom getOWLSubObjectPropertyOfAxiom(
			OWLObjectPropertyExpression subProperty,
			OWLObjectPropertyExpression superProperty) {
		return this.delegate.getOWLSubObjectPropertyOfAxiom(subProperty,
				superProperty);
	}

	/**
	 * @param subProperty
	 * @param superProperty
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubObjectPropertyOfAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLSubObjectPropertyOfAxiom getOWLSubObjectPropertyOfAxiom(
			OWLObjectPropertyExpression subProperty,
			OWLObjectPropertyExpression superProperty,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLSubObjectPropertyOfAxiom(subProperty,
				superProperty, annotations);
	}

	/**
	 * @param chain
	 * @param superProperty
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubPropertyChainOfAxiom(java.util.List,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLSubPropertyChainOfAxiom getOWLSubPropertyChainOfAxiom(
			List<? extends OWLObjectPropertyExpression> chain,
			OWLObjectPropertyExpression superProperty) {
		return this.delegate
				.getOWLSubPropertyChainOfAxiom(chain, superProperty);
	}

	/**
	 * @param chain
	 * @param superProperty
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubPropertyChainOfAxiom(java.util.List,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLSubPropertyChainOfAxiom getOWLSubPropertyChainOfAxiom(
			List<? extends OWLObjectPropertyExpression> chain,
			OWLObjectPropertyExpression superProperty,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLSubPropertyChainOfAxiom(chain,
				superProperty, annotations);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentObjectPropertiesAxiom(java.util.Set)
	 */
	public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
			Set<? extends OWLObjectPropertyExpression> properties) {
		return this.delegate.getOWLEquivalentObjectPropertiesAxiom(properties);
	}

	/**
	 * @param properties
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentObjectPropertiesAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
			Set<? extends OWLObjectPropertyExpression> properties,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLEquivalentObjectPropertiesAxiom(properties,
				annotations);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentObjectPropertiesAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression[])
	 */
	public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
			OWLObjectPropertyExpression... properties) {
		return this.delegate.getOWLEquivalentObjectPropertiesAxiom(properties);
	}

	/**
	 * @param propertyA
	 * @param propertyB
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentObjectPropertiesAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
			OWLObjectPropertyExpression propertyA,
			OWLObjectPropertyExpression propertyB) {
		return this.delegate.getOWLEquivalentObjectPropertiesAxiom(propertyA,
				propertyB);
	}

	/**
	 * @param propertyA
	 * @param propertyB
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentObjectPropertiesAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
			OWLObjectPropertyExpression propertyA,
			OWLObjectPropertyExpression propertyB,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLEquivalentObjectPropertiesAxiom(propertyA,
				propertyB, annotations);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointObjectPropertiesAxiom(java.util.Set)
	 */
	public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
			Set<? extends OWLObjectPropertyExpression> properties) {
		return this.delegate.getOWLDisjointObjectPropertiesAxiom(properties);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointObjectPropertiesAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression[])
	 */
	public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
			OWLObjectPropertyExpression... properties) {
		return this.delegate.getOWLDisjointObjectPropertiesAxiom(properties);
	}

	/**
	 * @param properties
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointObjectPropertiesAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
			Set<? extends OWLObjectPropertyExpression> properties,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDisjointObjectPropertiesAxiom(properties,
				annotations);
	}

	/**
	 * @param forwardProperty
	 * @param inverseProperty
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLInverseObjectPropertiesAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLInverseObjectPropertiesAxiom getOWLInverseObjectPropertiesAxiom(
			OWLObjectPropertyExpression forwardProperty,
			OWLObjectPropertyExpression inverseProperty) {
		return this.delegate.getOWLInverseObjectPropertiesAxiom(
				forwardProperty, inverseProperty);
	}

	/**
	 * @param forwardProperty
	 * @param inverseProperty
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLInverseObjectPropertiesAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLInverseObjectPropertiesAxiom getOWLInverseObjectPropertiesAxiom(
			OWLObjectPropertyExpression forwardProperty,
			OWLObjectPropertyExpression inverseProperty,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLInverseObjectPropertiesAxiom(
				forwardProperty, inverseProperty, annotations);
	}

	/**
	 * @param property
	 * @param classExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectPropertyDomainAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectPropertyDomainAxiom getOWLObjectPropertyDomainAxiom(
			OWLObjectPropertyExpression property,
			OWLClassExpression classExpression) {
		return this.delegate.getOWLObjectPropertyDomainAxiom(property,
				classExpression);
	}

	/**
	 * @param property
	 * @param classExpression
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectPropertyDomainAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression, java.util.Set)
	 */
	public OWLObjectPropertyDomainAxiom getOWLObjectPropertyDomainAxiom(
			OWLObjectPropertyExpression property,
			OWLClassExpression classExpression,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLObjectPropertyDomainAxiom(property,
				classExpression, annotations);
	}

	/**
	 * @param property
	 * @param range
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectPropertyRangeAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLObjectPropertyRangeAxiom getOWLObjectPropertyRangeAxiom(
			OWLObjectPropertyExpression property, OWLClassExpression range) {
		return this.delegate.getOWLObjectPropertyRangeAxiom(property, range);
	}

	/**
	 * @param property
	 * @param range
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectPropertyRangeAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression, java.util.Set)
	 */
	public OWLObjectPropertyRangeAxiom getOWLObjectPropertyRangeAxiom(
			OWLObjectPropertyExpression property, OWLClassExpression range,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLObjectPropertyRangeAxiom(property, range,
				annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFunctionalObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLFunctionalObjectPropertyAxiom getOWLFunctionalObjectPropertyAxiom(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLFunctionalObjectPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFunctionalObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLFunctionalObjectPropertyAxiom getOWLFunctionalObjectPropertyAxiom(
			OWLObjectPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLFunctionalObjectPropertyAxiom(property,
				annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLInverseFunctionalObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLInverseFunctionalObjectPropertyAxiom getOWLInverseFunctionalObjectPropertyAxiom(
			OWLObjectPropertyExpression property) {
		return this.delegate
				.getOWLInverseFunctionalObjectPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLInverseFunctionalObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLInverseFunctionalObjectPropertyAxiom getOWLInverseFunctionalObjectPropertyAxiom(
			OWLObjectPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLInverseFunctionalObjectPropertyAxiom(
				property, annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLReflexiveObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLReflexiveObjectPropertyAxiom getOWLReflexiveObjectPropertyAxiom(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLReflexiveObjectPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLReflexiveObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLReflexiveObjectPropertyAxiom getOWLReflexiveObjectPropertyAxiom(
			OWLObjectPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLReflexiveObjectPropertyAxiom(property,
				annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLIrreflexiveObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLIrreflexiveObjectPropertyAxiom getOWLIrreflexiveObjectPropertyAxiom(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLIrreflexiveObjectPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLIrreflexiveObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLIrreflexiveObjectPropertyAxiom getOWLIrreflexiveObjectPropertyAxiom(
			OWLObjectPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLIrreflexiveObjectPropertyAxiom(property,
				annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSymmetricObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLSymmetricObjectPropertyAxiom getOWLSymmetricObjectPropertyAxiom(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLSymmetricObjectPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSymmetricObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLSymmetricObjectPropertyAxiom getOWLSymmetricObjectPropertyAxiom(
			OWLObjectPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLSymmetricObjectPropertyAxiom(property,
				annotations);
	}

	/**
	 * @param propertyExpression
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAsymmetricObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLAsymmetricObjectPropertyAxiom getOWLAsymmetricObjectPropertyAxiom(
			OWLObjectPropertyExpression propertyExpression) {
		return this.delegate
				.getOWLAsymmetricObjectPropertyAxiom(propertyExpression);
	}

	/**
	 * @param propertyExpression
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAsymmetricObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLAsymmetricObjectPropertyAxiom getOWLAsymmetricObjectPropertyAxiom(
			OWLObjectPropertyExpression propertyExpression,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLAsymmetricObjectPropertyAxiom(
				propertyExpression, annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTransitiveObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression)
	 */
	public OWLTransitiveObjectPropertyAxiom getOWLTransitiveObjectPropertyAxiom(
			OWLObjectPropertyExpression property) {
		return this.delegate.getOWLTransitiveObjectPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLTransitiveObjectPropertyAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLTransitiveObjectPropertyAxiom getOWLTransitiveObjectPropertyAxiom(
			OWLObjectPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLTransitiveObjectPropertyAxiom(property,
				annotations);
	}

	/**
	 * @param subProperty
	 * @param superProperty
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubDataPropertyOfAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression)
	 */
	public OWLSubDataPropertyOfAxiom getOWLSubDataPropertyOfAxiom(
			OWLDataPropertyExpression subProperty,
			OWLDataPropertyExpression superProperty) {
		return this.delegate.getOWLSubDataPropertyOfAxiom(subProperty,
				superProperty);
	}

	/**
	 * @param subProperty
	 * @param superProperty
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubDataPropertyOfAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLSubDataPropertyOfAxiom getOWLSubDataPropertyOfAxiom(
			OWLDataPropertyExpression subProperty,
			OWLDataPropertyExpression superProperty,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLSubDataPropertyOfAxiom(subProperty,
				superProperty, annotations);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentDataPropertiesAxiom(java.util.Set)
	 */
	public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
			Set<? extends OWLDataPropertyExpression> properties) {
		return this.delegate.getOWLEquivalentDataPropertiesAxiom(properties);
	}

	/**
	 * @param properties
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentDataPropertiesAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
			Set<? extends OWLDataPropertyExpression> properties,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLEquivalentDataPropertiesAxiom(properties,
				annotations);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentDataPropertiesAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression[])
	 */
	public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
			OWLDataPropertyExpression... properties) {
		return this.delegate.getOWLEquivalentDataPropertiesAxiom(properties);
	}

	/**
	 * @param propertyA
	 * @param propertyB
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentDataPropertiesAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression)
	 */
	public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
			OWLDataPropertyExpression propertyA,
			OWLDataPropertyExpression propertyB) {
		return this.delegate.getOWLEquivalentDataPropertiesAxiom(propertyA,
				propertyB);
	}

	/**
	 * @param propertyA
	 * @param propertyB
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLEquivalentDataPropertiesAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
			OWLDataPropertyExpression propertyA,
			OWLDataPropertyExpression propertyB,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLEquivalentDataPropertiesAxiom(propertyA,
				propertyB, annotations);
	}

	/**
	 * @param dataProperties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointDataPropertiesAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression[])
	 */
	public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
			OWLDataPropertyExpression... dataProperties) {
		return this.delegate.getOWLDisjointDataPropertiesAxiom(dataProperties);
	}

	/**
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointDataPropertiesAxiom(java.util.Set)
	 */
	public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
			Set<? extends OWLDataPropertyExpression> properties) {
		return this.delegate.getOWLDisjointDataPropertiesAxiom(properties);
	}

	/**
	 * @param properties
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDisjointDataPropertiesAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
			Set<? extends OWLDataPropertyExpression> properties,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDisjointDataPropertiesAxiom(properties,
				annotations);
	}

	/**
	 * @param property
	 * @param domain
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyDomainAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression)
	 */
	public OWLDataPropertyDomainAxiom getOWLDataPropertyDomainAxiom(
			OWLDataPropertyExpression property, OWLClassExpression domain) {
		return this.delegate.getOWLDataPropertyDomainAxiom(property, domain);
	}

	/**
	 * @param property
	 * @param domain
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyDomainAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLClassExpression, java.util.Set)
	 */
	public OWLDataPropertyDomainAxiom getOWLDataPropertyDomainAxiom(
			OWLDataPropertyExpression property, OWLClassExpression domain,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDataPropertyDomainAxiom(property, domain,
				annotations);
	}

	/**
	 * @param property
	 * @param owlDataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyRangeAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDataPropertyRangeAxiom getOWLDataPropertyRangeAxiom(
			OWLDataPropertyExpression property, OWLDataRange owlDataRange) {
		return this.delegate.getOWLDataPropertyRangeAxiom(property,
				owlDataRange);
	}

	/**
	 * @param property
	 * @param owlDataRange
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyRangeAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLDataRange, java.util.Set)
	 */
	public OWLDataPropertyRangeAxiom getOWLDataPropertyRangeAxiom(
			OWLDataPropertyExpression property, OWLDataRange owlDataRange,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDataPropertyRangeAxiom(property,
				owlDataRange, annotations);
	}

	/**
	 * @param property
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFunctionalDataPropertyAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression)
	 */
	public OWLFunctionalDataPropertyAxiom getOWLFunctionalDataPropertyAxiom(
			OWLDataPropertyExpression property) {
		return this.delegate.getOWLFunctionalDataPropertyAxiom(property);
	}

	/**
	 * @param property
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLFunctionalDataPropertyAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      java.util.Set)
	 */
	public OWLFunctionalDataPropertyAxiom getOWLFunctionalDataPropertyAxiom(
			OWLDataPropertyExpression property,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLFunctionalDataPropertyAxiom(property,
				annotations);
	}

	/**
	 * @param ce
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLHasKeyAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      java.util.Set)
	 */
	public OWLHasKeyAxiom getOWLHasKeyAxiom(OWLClassExpression ce,
			Set<? extends OWLPropertyExpression> properties) {
		return this.delegate.getOWLHasKeyAxiom(ce, properties);
	}

	/**
	 * @param ce
	 * @param properties
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLHasKeyAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLPropertyExpression[])
	 */
	public OWLHasKeyAxiom getOWLHasKeyAxiom(OWLClassExpression ce,
			OWLPropertyExpression... properties) {
		return this.delegate.getOWLHasKeyAxiom(ce, properties);
	}

	/**
	 * @param ce
	 * @param objectProperties
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLHasKeyAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      java.util.Set, java.util.Set)
	 */
	public OWLHasKeyAxiom getOWLHasKeyAxiom(OWLClassExpression ce,
			Set<? extends OWLPropertyExpression> objectProperties,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLHasKeyAxiom(ce, objectProperties,
				annotations);
	}

	/**
	 * @param datatype
	 * @param dataRange
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeDefinitionAxiom(org.semanticweb.owlapi.model.OWLDatatype,
	 *      org.semanticweb.owlapi.model.OWLDataRange)
	 */
	public OWLDatatypeDefinitionAxiom getOWLDatatypeDefinitionAxiom(
			OWLDatatype datatype, OWLDataRange dataRange) {
		return this.delegate.getOWLDatatypeDefinitionAxiom(datatype, dataRange);
	}

	/**
	 * @param datatype
	 * @param dataRange
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDatatypeDefinitionAxiom(org.semanticweb.owlapi.model.OWLDatatype,
	 *      org.semanticweb.owlapi.model.OWLDataRange, java.util.Set)
	 */
	public OWLDatatypeDefinitionAxiom getOWLDatatypeDefinitionAxiom(
			OWLDatatype datatype, OWLDataRange dataRange,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDatatypeDefinitionAxiom(datatype, dataRange,
				annotations);
	}

	/**
	 * @param individuals
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSameIndividualAxiom(java.util.Set)
	 */
	public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
			Set<? extends OWLIndividual> individuals) {
		return this.delegate.getOWLSameIndividualAxiom(individuals);
	}

	/**
	 * @param individual
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSameIndividualAxiom(org.semanticweb.owlapi.model.OWLIndividual[])
	 */
	public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
			OWLIndividual... individual) {
		return this.delegate.getOWLSameIndividualAxiom(individual);
	}

	/**
	 * @param individuals
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSameIndividualAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
			Set<? extends OWLIndividual> individuals,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate
				.getOWLSameIndividualAxiom(individuals, annotations);
	}

	/**
	 * @param individuals
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDifferentIndividualsAxiom(java.util.Set)
	 */
	public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
			Set<? extends OWLIndividual> individuals) {
		return this.delegate.getOWLDifferentIndividualsAxiom(individuals);
	}

	/**
	 * @param individuals
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDifferentIndividualsAxiom(org.semanticweb.owlapi.model.OWLIndividual[])
	 */
	public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
			OWLIndividual... individuals) {
		return this.delegate.getOWLDifferentIndividualsAxiom(individuals);
	}

	/**
	 * @param individuals
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDifferentIndividualsAxiom(java.util.Set,
	 *      java.util.Set)
	 */
	public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
			Set<? extends OWLIndividual> individuals,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDifferentIndividualsAxiom(individuals,
				annotations);
	}

	/**
	 * @param classExpression
	 * @param individual
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLClassAssertionAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual)
	 */
	public OWLClassAssertionAxiom getOWLClassAssertionAxiom(
			OWLClassExpression classExpression, OWLIndividual individual) {
		return this.delegate.getOWLClassAssertionAxiom(classExpression,
				individual);
	}

	/**
	 * @param classExpression
	 * @param individual
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLClassAssertionAxiom(org.semanticweb.owlapi.model.OWLClassExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual, java.util.Set)
	 */
	public OWLClassAssertionAxiom getOWLClassAssertionAxiom(
			OWLClassExpression classExpression, OWLIndividual individual,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLClassAssertionAxiom(classExpression,
				individual, annotations);
	}

	/**
	 * @param property
	 * @param individual
	 * @param object
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLIndividual)
	 */
	public OWLObjectPropertyAssertionAxiom getOWLObjectPropertyAssertionAxiom(
			OWLObjectPropertyExpression property, OWLIndividual individual,
			OWLIndividual object) {
		return this.delegate.getOWLObjectPropertyAssertionAxiom(property,
				individual, object);
	}

	/**
	 * @param property
	 * @param individual
	 * @param object
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLObjectPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLIndividual, java.util.Set)
	 */
	public OWLObjectPropertyAssertionAxiom getOWLObjectPropertyAssertionAxiom(
			OWLObjectPropertyExpression property, OWLIndividual individual,
			OWLIndividual object, Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLObjectPropertyAssertionAxiom(property,
				individual, object, annotations);
	}

	/**
	 * @param property
	 * @param subject
	 * @param object
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNegativeObjectPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLIndividual)
	 */
	public OWLNegativeObjectPropertyAssertionAxiom getOWLNegativeObjectPropertyAssertionAxiom(
			OWLObjectPropertyExpression property, OWLIndividual subject,
			OWLIndividual object) {
		return this.delegate.getOWLNegativeObjectPropertyAssertionAxiom(
				property, subject, object);
	}

	/**
	 * @param property
	 * @param subject
	 * @param object
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNegativeObjectPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLObjectPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLIndividual, java.util.Set)
	 */
	public OWLNegativeObjectPropertyAssertionAxiom getOWLNegativeObjectPropertyAssertionAxiom(
			OWLObjectPropertyExpression property, OWLIndividual subject,
			OWLIndividual object, Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLNegativeObjectPropertyAssertionAxiom(
				property, subject, object, annotations);
	}

	/**
	 * @param property
	 * @param subject
	 * @param object
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			OWLLiteral object) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, object);
	}

	/**
	 * @param property
	 * @param subject
	 * @param object
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLLiteral, java.util.Set)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			OWLLiteral object, Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, object, annotations);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual, int)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject, int value) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, value);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual, double)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			double value) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, value);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual, float)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			float value) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, value);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual, boolean)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			boolean value) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, value);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual, java.lang.String)
	 */
	public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			String value) {
		return this.delegate.getOWLDataPropertyAssertionAxiom(property,
				subject, value);
	}

	/**
	 * @param property
	 * @param subject
	 * @param object
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNegativeDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public OWLNegativeDataPropertyAssertionAxiom getOWLNegativeDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			OWLLiteral object) {
		return this.delegate.getOWLNegativeDataPropertyAssertionAxiom(property,
				subject, object);
	}

	/**
	 * @param property
	 * @param subject
	 * @param object
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLNegativeDataPropertyAssertionAxiom(org.semanticweb.owlapi.model.OWLDataPropertyExpression,
	 *      org.semanticweb.owlapi.model.OWLIndividual,
	 *      org.semanticweb.owlapi.model.OWLLiteral, java.util.Set)
	 */
	public OWLNegativeDataPropertyAssertionAxiom getOWLNegativeDataPropertyAssertionAxiom(
			OWLDataPropertyExpression property, OWLIndividual subject,
			OWLLiteral object, Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLNegativeDataPropertyAssertionAxiom(property,
				subject, object, annotations);
	}

	/**
	 * @param property
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotation(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.OWLAnnotationValue)
	 */
	public OWLAnnotation getOWLAnnotation(OWLAnnotationProperty property,
			OWLAnnotationValue value) {
		return this.delegate.getOWLAnnotation(property, value);
	}

	/**
	 * @param property
	 * @param value
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotation(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.OWLAnnotationValue, java.util.Set)
	 */
	public OWLAnnotation getOWLAnnotation(OWLAnnotationProperty property,
			OWLAnnotationValue value, Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLAnnotation(property, value, annotations);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationAssertionAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.OWLAnnotationSubject,
	 *      org.semanticweb.owlapi.model.OWLAnnotationValue)
	 */
	public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
			OWLAnnotationProperty property, OWLAnnotationSubject subject,
			OWLAnnotationValue value) {
		return this.delegate.getOWLAnnotationAssertionAxiom(property, subject,
				value);
	}

	/**
	 * @param subject
	 * @param annotation
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationAssertionAxiom(org.semanticweb.owlapi.model.OWLAnnotationSubject,
	 *      org.semanticweb.owlapi.model.OWLAnnotation)
	 */
	public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
			OWLAnnotationSubject subject, OWLAnnotation annotation) {
		return this.delegate
				.getOWLAnnotationAssertionAxiom(subject, annotation);
	}

	/**
	 * @param property
	 * @param subject
	 * @param value
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationAssertionAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.OWLAnnotationSubject,
	 *      org.semanticweb.owlapi.model.OWLAnnotationValue, java.util.Set)
	 */
	public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
			OWLAnnotationProperty property, OWLAnnotationSubject subject,
			OWLAnnotationValue value, Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLAnnotationAssertionAxiom(property, subject,
				value, annotations);
	}

	/**
	 * @param subject
	 * @param annotation
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationAssertionAxiom(org.semanticweb.owlapi.model.OWLAnnotationSubject,
	 *      org.semanticweb.owlapi.model.OWLAnnotation, java.util.Set)
	 */
	public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
			OWLAnnotationSubject subject, OWLAnnotation annotation,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLAnnotationAssertionAxiom(subject,
				annotation, annotations);
	}

	/**
	 * @param subject
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getDeprecatedOWLAnnotationAssertionAxiom(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLAnnotationAssertionAxiom getDeprecatedOWLAnnotationAssertionAxiom(
			IRI subject) {
		return this.delegate.getDeprecatedOWLAnnotationAssertionAxiom(subject);
	}

	/**
	 * @param importedOntologyIRI
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLImportsDeclaration(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLImportsDeclaration getOWLImportsDeclaration(
			IRI importedOntologyIRI) {
		return this.delegate.getOWLImportsDeclaration(importedOntologyIRI);
	}

	/**
	 * @param prop
	 * @param domain
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationPropertyDomainAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.IRI)
	 */
	public OWLAnnotationPropertyDomainAxiom getOWLAnnotationPropertyDomainAxiom(
			OWLAnnotationProperty prop, IRI domain) {
		return this.delegate.getOWLAnnotationPropertyDomainAxiom(prop, domain);
	}

	/**
	 * @param prop
	 * @param domain
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationPropertyDomainAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.IRI, java.util.Set)
	 */
	public OWLAnnotationPropertyDomainAxiom getOWLAnnotationPropertyDomainAxiom(
			OWLAnnotationProperty prop, IRI domain,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLAnnotationPropertyDomainAxiom(prop, domain,
				annotations);
	}

	/**
	 * @param prop
	 * @param range
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationPropertyRangeAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.IRI)
	 */
	public OWLAnnotationPropertyRangeAxiom getOWLAnnotationPropertyRangeAxiom(
			OWLAnnotationProperty prop, IRI range) {
		return this.delegate.getOWLAnnotationPropertyRangeAxiom(prop, range);
	}

	/**
	 * @param prop
	 * @param range
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLAnnotationPropertyRangeAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.IRI, java.util.Set)
	 */
	public OWLAnnotationPropertyRangeAxiom getOWLAnnotationPropertyRangeAxiom(
			OWLAnnotationProperty prop, IRI range,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLAnnotationPropertyRangeAxiom(prop, range,
				annotations);
	}

	/**
	 * @param sub
	 * @param sup
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubAnnotationPropertyOfAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	public OWLSubAnnotationPropertyOfAxiom getOWLSubAnnotationPropertyOfAxiom(
			OWLAnnotationProperty sub, OWLAnnotationProperty sup) {
		return this.delegate.getOWLSubAnnotationPropertyOfAxiom(sub, sup);
	}

	/**
	 * @param sub
	 * @param sup
	 * @param annotations
	 * @return
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#getOWLSubAnnotationPropertyOfAxiom(org.semanticweb.owlapi.model.OWLAnnotationProperty,
	 *      org.semanticweb.owlapi.model.OWLAnnotationProperty, java.util.Set)
	 */
	public OWLSubAnnotationPropertyOfAxiom getOWLSubAnnotationPropertyOfAxiom(
			OWLAnnotationProperty sub, OWLAnnotationProperty sup,
			Set<? extends OWLAnnotation> annotations) {
		return this.delegate.getOWLSubAnnotationPropertyOfAxiom(sub, sup,
				annotations);
	}

	/**
	 * 
	 * @see org.semanticweb.owlapi.model.OWLDataFactory#purge()
	 */
	public void purge() {
		this.delegate.purge();
	}
}
