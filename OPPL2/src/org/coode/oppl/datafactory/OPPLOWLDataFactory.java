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

/** @author Luigi Iannone */
public class OPPLOWLDataFactory implements OWLDataFactory {
    private final OWLDataFactory delegate;

    /** @param delegate */
    public OPPLOWLDataFactory(OWLDataFactory delegate) {
        if (delegate == null) {
            throw new NullPointerException("The OWL data factory cannot be null");
        }
        this.delegate = delegate;
    }

    public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
            InlineSet<OWLClassExpression> set, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDisjointClassesAxiom(this, set,
                Collections.<OWLAnnotation> emptySet(), shouldExpabdAsPairWise);
    }

    public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
            InlineSet<OWLClassExpression> set, Set<? extends OWLAnnotation> annotations,
            boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDisjointClassesAxiom(this, set, annotations,
                shouldExpabdAsPairWise);
    }

    public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
            InlineSet<OWLObjectPropertyExpression> set, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDisjointObjectPropertiesAxiom(this, set,
                Collections.<OWLAnnotation> emptySet(), shouldExpabdAsPairWise);
    }

    public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
            InlineSet<OWLObjectPropertyExpression> set,
            Set<? extends OWLAnnotation> annotations, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDisjointObjectPropertiesAxiom(this, set, annotations,
                shouldExpabdAsPairWise);
    }

    public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
            InlineSet<OWLDataPropertyExpression> set, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDisjointDataPropertiesAxiom(this, set,
                Collections.<OWLAnnotation> emptySet(), shouldExpabdAsPairWise);
    }

    public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
            InlineSet<OWLDataPropertyExpression> set,
            Set<? extends OWLAnnotation> annotations, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDisjointDataPropertiesAxiom(this, set, annotations,
                shouldExpabdAsPairWise);
    }

    public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
            InlineSet<OWLIndividual> set, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDifferentIndividualsAxiom(this, set,
                Collections.<OWLAnnotation> emptySet(), shouldExpabdAsPairWise);
    }

    public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
            InlineSet<OWLIndividual> set, Set<? extends OWLAnnotation> annotations,
            boolean shouldExpabdAsPairWise) {
        return new OPPLOWLDifferentIndividualsAxiom(this, set, annotations,
                shouldExpabdAsPairWise);
    }

    public OWLSameIndividualAxiom getOWLSameIndividualAxiom(InlineSet<OWLIndividual> set,
            boolean shouldExpabdAsPairWise) {
        return new OPPLOWLSameIndividualAxiom(this, set,
                Collections.<OWLAnnotation> emptySet(), shouldExpabdAsPairWise);
    }

    public OWLSameIndividualAxiom getOWLSameIndividualAxiom(InlineSet<OWLIndividual> set,
            Set<? extends OWLAnnotation> annotations, boolean shouldExpabdAsPairWise) {
        return new OPPLOWLSameIndividualAxiom(this, set, annotations,
                shouldExpabdAsPairWise);
    }

    public OWLDataFactory getDelegate() {
        return delegate;
    }

    @Override
    @Deprecated
    public SWRLRule getSWRLRule(IRI iri, Set<? extends SWRLAtom> body,
            Set<? extends SWRLAtom> head) {
        return delegate.getSWRLRule(iri, body, head);
    }

    @Override
    @Deprecated
    public SWRLRule getSWRLRule(NodeID nodeID, Set<? extends SWRLAtom> body,
            Set<? extends SWRLAtom> head) {
        return delegate.getSWRLRule(nodeID, body, head);
    }

    @Override
    public OWLClass getOWLThing() {
        return delegate.getOWLThing();
    }

    @Override
    public SWRLRule
            getSWRLRule(Set<? extends SWRLAtom> body, Set<? extends SWRLAtom> head) {
        return delegate.getSWRLRule(body, head);
    }

    @Override
    public SWRLRule getSWRLRule(Set<? extends SWRLAtom> body,
            Set<? extends SWRLAtom> head, Set<OWLAnnotation> annotations) {
        return delegate.getSWRLRule(body, head, annotations);
    }

    @Override
    public OWLClass getOWLNothing() {
        return delegate.getOWLNothing();
    }

    @Override
    public OWLObjectProperty getOWLTopObjectProperty() {
        return delegate.getOWLTopObjectProperty();
    }

    @Override
    public OWLDataProperty getOWLTopDataProperty() {
        return delegate.getOWLTopDataProperty();
    }

    @Override
    public OWLObjectProperty getOWLBottomObjectProperty() {
        return delegate.getOWLBottomObjectProperty();
    }

    @Override
    public SWRLClassAtom
            getSWRLClassAtom(OWLClassExpression predicate, SWRLIArgument arg) {
        return delegate.getSWRLClassAtom(predicate, arg);
    }

    @Override
    public OWLDataProperty getOWLBottomDataProperty() {
        return delegate.getOWLBottomDataProperty();
    }

    @Override
    public OWLDatatype getTopDatatype() {
        return delegate.getTopDatatype();
    }

    @Override
    public <E extends OWLEntity> E getOWLEntity(EntityType<E> entityType, IRI iri) {
        return delegate.getOWLEntity(entityType, iri);
    }

    @Override
    public SWRLDataRangeAtom getSWRLDataRangeAtom(OWLDataRange predicate,
            SWRLDArgument arg) {
        return delegate.getSWRLDataRangeAtom(predicate, arg);
    }

    @Override
    public OWLClass getOWLClass(IRI iri) {
        return delegate.getOWLClass(iri);
    }

    @Override
    public SWRLObjectPropertyAtom getSWRLObjectPropertyAtom(
            OWLObjectPropertyExpression property, SWRLIArgument arg0, SWRLIArgument arg1) {
        return delegate.getSWRLObjectPropertyAtom(property, arg0, arg1);
    }

    @Override
    public OWLClass getOWLClass(String abbreviatedIRI, PrefixManager prefixManager) {
        return delegate.getOWLClass(abbreviatedIRI, prefixManager);
    }

    @Override
    public SWRLDataPropertyAtom getSWRLDataPropertyAtom(
            OWLDataPropertyExpression property, SWRLIArgument arg0, SWRLDArgument arg1) {
        return delegate.getSWRLDataPropertyAtom(property, arg0, arg1);
    }

    @Override
    public SWRLBuiltInAtom getSWRLBuiltInAtom(IRI builtInIRI, List<SWRLDArgument> args) {
        return delegate.getSWRLBuiltInAtom(builtInIRI, args);
    }

    @Override
    public OWLObjectProperty getOWLObjectProperty(IRI iri) {
        return delegate.getOWLObjectProperty(iri);
    }

    @Override
    public OWLObjectProperty getOWLObjectProperty(String abbreviatedIRI,
            PrefixManager prefixManager) {
        return delegate.getOWLObjectProperty(abbreviatedIRI, prefixManager);
    }

    @Override
    public SWRLVariable getSWRLVariable(IRI var) {
        return delegate.getSWRLVariable(var);
    }

    @Override
    public SWRLIndividualArgument getSWRLIndividualArgument(OWLIndividual individual) {
        return delegate.getSWRLIndividualArgument(individual);
    }

    @Override
    public SWRLLiteralArgument getSWRLLiteralArgument(OWLLiteral literal) {
        return delegate.getSWRLLiteralArgument(literal);
    }

    @Override
    public SWRLSameIndividualAtom getSWRLSameIndividualAtom(SWRLIArgument arg0,
            SWRLIArgument arg1) {
        return delegate.getSWRLSameIndividualAtom(arg0, arg1);
    }

    @Override
    public SWRLDifferentIndividualsAtom getSWRLDifferentIndividualsAtom(
            SWRLIArgument arg0, SWRLIArgument arg1) {
        return delegate.getSWRLDifferentIndividualsAtom(arg0, arg1);
    }

    @Override
    public OWLObjectInverseOf getOWLObjectInverseOf(OWLObjectPropertyExpression property) {
        return delegate.getOWLObjectInverseOf(property);
    }

    @Override
    public OWLDataProperty getOWLDataProperty(IRI iri) {
        return delegate.getOWLDataProperty(iri);
    }

    @Override
    public OWLDataProperty getOWLDataProperty(String abbreviatedIRI,
            PrefixManager prefixManager) {
        return delegate.getOWLDataProperty(abbreviatedIRI, prefixManager);
    }

    @Override
    public OWLNamedIndividual getOWLNamedIndividual(IRI iri) {
        return delegate.getOWLNamedIndividual(iri);
    }

    @Override
    public OWLNamedIndividual getOWLNamedIndividual(String abbreviatedIRI,
            PrefixManager prefixManager) {
        return delegate.getOWLNamedIndividual(abbreviatedIRI, prefixManager);
    }

    @Override
    public OWLAnonymousIndividual getOWLAnonymousIndividual(String id) {
        return delegate.getOWLAnonymousIndividual(id);
    }

    @Override
    public OWLAnonymousIndividual getOWLAnonymousIndividual() {
        return delegate.getOWLAnonymousIndividual();
    }

    @Override
    public OWLAnnotationProperty getOWLAnnotationProperty(IRI iri) {
        return delegate.getOWLAnnotationProperty(iri);
    }

    @Override
    public OWLAnnotationProperty getOWLAnnotationProperty(String abbreviatedIRI,
            PrefixManager prefixManager) {
        return delegate.getOWLAnnotationProperty(abbreviatedIRI, prefixManager);
    }

    @Override
    public OWLAnnotationProperty getRDFSLabel() {
        return delegate.getRDFSLabel();
    }

    @Override
    public OWLAnnotationProperty getRDFSComment() {
        return delegate.getRDFSComment();
    }

    @Override
    public OWLAnnotationProperty getRDFSSeeAlso() {
        return delegate.getRDFSSeeAlso();
    }

    @Override
    public OWLAnnotationProperty getRDFSIsDefinedBy() {
        return delegate.getRDFSIsDefinedBy();
    }

    @Override
    public OWLAnnotationProperty getOWLVersionInfo() {
        return delegate.getOWLVersionInfo();
    }

    @Override
    public OWLAnnotationProperty getOWLBackwardCompatibleWith() {
        return delegate.getOWLBackwardCompatibleWith();
    }

    @Override
    public OWLAnnotationProperty getOWLIncompatibleWith() {
        return delegate.getOWLIncompatibleWith();
    }

    @Override
    public OWLAnnotationProperty getOWLDeprecated() {
        return delegate.getOWLDeprecated();
    }

    @Override
    public OWLDatatype getRDFPlainLiteral() {
        return delegate.getRDFPlainLiteral();
    }

    @Override
    public OWLDatatype getOWLDatatype(IRI iri) {
        return delegate.getOWLDatatype(iri);
    }

    @Override
    public OWLDatatype getOWLDatatype(String abbreviatedIRI, PrefixManager prefixManager) {
        return delegate.getOWLDatatype(abbreviatedIRI, prefixManager);
    }

    @Override
    public OWLDatatype getIntegerOWLDatatype() {
        return delegate.getIntegerOWLDatatype();
    }

    @Override
    public OWLDatatype getFloatOWLDatatype() {
        return delegate.getFloatOWLDatatype();
    }

    @Override
    public OWLDatatype getDoubleOWLDatatype() {
        return delegate.getDoubleOWLDatatype();
    }

    @Override
    public OWLDatatype getBooleanOWLDatatype() {
        return delegate.getBooleanOWLDatatype();
    }

    @Override
    public OWLLiteral getOWLLiteral(String lexicalValue, OWLDatatype datatype) {
        return delegate.getOWLLiteral(lexicalValue, datatype);
    }

    @Override
    public OWLLiteral getOWLLiteral(String lexicalValue, OWL2Datatype datatype) {
        return delegate.getOWLLiteral(lexicalValue, datatype);
    }

    @Override
    public OWLLiteral getOWLLiteral(int value) {
        return delegate.getOWLLiteral(value);
    }

    @Override
    public OWLLiteral getOWLLiteral(double value) {
        return delegate.getOWLLiteral(value);
    }

    @Override
    public OWLLiteral getOWLLiteral(boolean value) {
        return delegate.getOWLLiteral(value);
    }

    @Override
    public OWLLiteral getOWLLiteral(float value) {
        return delegate.getOWLLiteral(value);
    }

    @Override
    public OWLLiteral getOWLLiteral(String value) {
        return delegate.getOWLLiteral(value);
    }

    @Override
    public OWLLiteral getOWLLiteral(String literal, String lang) {
        return delegate.getOWLLiteral(literal, lang);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(String literal, OWLDatatype datatype) {
        return delegate.getOWLTypedLiteral(literal, datatype);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(String literal, OWL2Datatype datatype) {
        return delegate.getOWLTypedLiteral(literal, datatype);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(int value) {
        return delegate.getOWLTypedLiteral(value);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(double value) {
        return delegate.getOWLTypedLiteral(value);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(boolean value) {
        return delegate.getOWLTypedLiteral(value);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(float value) {
        return delegate.getOWLTypedLiteral(value);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLTypedLiteral(String value) {
        return delegate.getOWLTypedLiteral(value);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLStringLiteral(String literal, String lang) {
        return delegate.getOWLStringLiteral(literal, lang);
    }

    @Override
    @Deprecated
    public OWLLiteral getOWLStringLiteral(String literal) {
        return delegate.getOWLStringLiteral(literal);
    }

    @Override
    public OWLDataOneOf getOWLDataOneOf(Set<? extends OWLLiteral> values) {
        return delegate.getOWLDataOneOf(values);
    }

    @Override
    public OWLDataOneOf getOWLDataOneOf(OWLLiteral... values) {
        return delegate.getOWLDataOneOf(values);
    }

    @Override
    public OWLDataComplementOf getOWLDataComplementOf(OWLDataRange dataRange) {
        return delegate.getOWLDataComplementOf(dataRange);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeRestriction(OWLDatatype dataRange,
            Set<OWLFacetRestriction> facetRestrictions) {
        return delegate.getOWLDatatypeRestriction(dataRange, facetRestrictions);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeRestriction(OWLDatatype dataRange,
            OWLFacet facet, OWLLiteral typedLiteral) {
        return delegate.getOWLDatatypeRestriction(dataRange, facet, typedLiteral);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeRestriction(OWLDatatype dataRange,
            OWLFacetRestriction... facetRestrictions) {
        return delegate.getOWLDatatypeRestriction(dataRange, facetRestrictions);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinInclusiveRestriction(int minInclusive) {
        return delegate.getOWLDatatypeMinInclusiveRestriction(minInclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMaxInclusiveRestriction(int maxInclusive) {
        return delegate.getOWLDatatypeMaxInclusiveRestriction(maxInclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinMaxInclusiveRestriction(
            int minInclusive, int maxInclusive) {
        return delegate.getOWLDatatypeMinMaxInclusiveRestriction(minInclusive,
                maxInclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinExclusiveRestriction(int minExclusive) {
        return delegate.getOWLDatatypeMinExclusiveRestriction(minExclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMaxExclusiveRestriction(int maxExclusive) {
        return delegate.getOWLDatatypeMaxExclusiveRestriction(maxExclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinMaxExclusiveRestriction(
            int minExclusive, int maxExclusive) {
        return delegate.getOWLDatatypeMinMaxExclusiveRestriction(minExclusive,
                maxExclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinInclusiveRestriction(
            double minInclusive) {
        return delegate.getOWLDatatypeMinInclusiveRestriction(minInclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMaxInclusiveRestriction(
            double maxInclusive) {
        return delegate.getOWLDatatypeMaxInclusiveRestriction(maxInclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinMaxInclusiveRestriction(
            double minInclusive, double maxInclusive) {
        return delegate.getOWLDatatypeMinMaxInclusiveRestriction(minInclusive,
                maxInclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinExclusiveRestriction(
            double minExclusive) {
        return delegate.getOWLDatatypeMinExclusiveRestriction(minExclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMaxExclusiveRestriction(
            double maxExclusive) {
        return delegate.getOWLDatatypeMaxExclusiveRestriction(maxExclusive);
    }

    @Override
    public OWLDatatypeRestriction getOWLDatatypeMinMaxExclusiveRestriction(
            double minExclusive, double maxExclusive) {
        return delegate.getOWLDatatypeMinMaxExclusiveRestriction(minExclusive,
                maxExclusive);
    }

    @Override
    public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet,
            OWLLiteral facetValue) {
        return delegate.getOWLFacetRestriction(facet, facetValue);
    }

    @Override
    public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet, int facetValue) {
        return delegate.getOWLFacetRestriction(facet, facetValue);
    }

    @Override
    public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet, double facetValue) {
        return delegate.getOWLFacetRestriction(facet, facetValue);
    }

    @Override
    public OWLFacetRestriction getOWLFacetRestriction(OWLFacet facet, float facetValue) {
        return delegate.getOWLFacetRestriction(facet, facetValue);
    }

    @Override
    public OWLDataUnionOf getOWLDataUnionOf(Set<? extends OWLDataRange> dataRanges) {
        return delegate.getOWLDataUnionOf(dataRanges);
    }

    @Override
    public OWLDataUnionOf getOWLDataUnionOf(OWLDataRange... dataRanges) {
        return delegate.getOWLDataUnionOf(dataRanges);
    }

    @Override
    public OWLDataIntersectionOf getOWLDataIntersectionOf(
            Set<? extends OWLDataRange> dataRanges) {
        return delegate.getOWLDataIntersectionOf(dataRanges);
    }

    @Override
    public OWLDataIntersectionOf getOWLDataIntersectionOf(OWLDataRange... dataRanges) {
        return delegate.getOWLDataIntersectionOf(dataRanges);
    }

    @Override
    public OWLObjectIntersectionOf getOWLObjectIntersectionOf(
            Set<? extends OWLClassExpression> operands) {
        return delegate.getOWLObjectIntersectionOf(operands);
    }

    @Override
    public OWLObjectIntersectionOf getOWLObjectIntersectionOf(
            OWLClassExpression... operands) {
        return delegate.getOWLObjectIntersectionOf(operands);
    }

    @Override
    public OWLDataSomeValuesFrom getOWLDataSomeValuesFrom(
            OWLDataPropertyExpression property, OWLDataRange dataRange) {
        return delegate.getOWLDataSomeValuesFrom(property, dataRange);
    }

    @Override
    public OWLDataAllValuesFrom getOWLDataAllValuesFrom(
            OWLDataPropertyExpression property, OWLDataRange dataRange) {
        return delegate.getOWLDataAllValuesFrom(property, dataRange);
    }

    @Override
    public OWLDataExactCardinality getOWLDataExactCardinality(int cardinality,
            OWLDataPropertyExpression property) {
        return delegate.getOWLDataExactCardinality(cardinality, property);
    }

    @Override
    public OWLDataExactCardinality getOWLDataExactCardinality(int cardinality,
            OWLDataPropertyExpression property, OWLDataRange dataRange) {
        return delegate.getOWLDataExactCardinality(cardinality, property, dataRange);
    }

    @Override
    public OWLDataMaxCardinality getOWLDataMaxCardinality(int cardinality,
            OWLDataPropertyExpression property) {
        return delegate.getOWLDataMaxCardinality(cardinality, property);
    }

    @Override
    public OWLDataMaxCardinality getOWLDataMaxCardinality(int cardinality,
            OWLDataPropertyExpression property, OWLDataRange dataRange) {
        return delegate.getOWLDataMaxCardinality(cardinality, property, dataRange);
    }

    @Override
    public OWLDataMinCardinality getOWLDataMinCardinality(int cardinality,
            OWLDataPropertyExpression property) {
        return delegate.getOWLDataMinCardinality(cardinality, property);
    }

    @Override
    public OWLDataMinCardinality getOWLDataMinCardinality(int cardinality,
            OWLDataPropertyExpression property, OWLDataRange dataRange) {
        return delegate.getOWLDataMinCardinality(cardinality, property, dataRange);
    }

    @Override
    public OWLDataHasValue getOWLDataHasValue(OWLDataPropertyExpression property,
            OWLLiteral value) {
        return delegate.getOWLDataHasValue(property, value);
    }

    @Override
    public OWLObjectComplementOf getOWLObjectComplementOf(OWLClassExpression operand) {
        return delegate.getOWLObjectComplementOf(operand);
    }

    @Override
    public OWLObjectOneOf getOWLObjectOneOf(Set<? extends OWLIndividual> values) {
        return delegate.getOWLObjectOneOf(values);
    }

    @Override
    public OWLObjectOneOf getOWLObjectOneOf(OWLIndividual... individuals) {
        return delegate.getOWLObjectOneOf(individuals);
    }

    @Override
    public OWLObjectAllValuesFrom getOWLObjectAllValuesFrom(
            OWLObjectPropertyExpression property, OWLClassExpression classExpression) {
        return delegate.getOWLObjectAllValuesFrom(property, classExpression);
    }

    @Override
    public OWLObjectSomeValuesFrom getOWLObjectSomeValuesFrom(
            OWLObjectPropertyExpression property, OWLClassExpression classExpression) {
        return delegate.getOWLObjectSomeValuesFrom(property, classExpression);
    }

    @Override
    public OWLObjectExactCardinality getOWLObjectExactCardinality(int cardinality,
            OWLObjectPropertyExpression property) {
        return delegate.getOWLObjectExactCardinality(cardinality, property);
    }

    @Override
    public OWLObjectExactCardinality getOWLObjectExactCardinality(int cardinality,
            OWLObjectPropertyExpression property, OWLClassExpression classExpression) {
        return delegate.getOWLObjectExactCardinality(cardinality, property,
                classExpression);
    }

    @Override
    public OWLObjectMinCardinality getOWLObjectMinCardinality(int cardinality,
            OWLObjectPropertyExpression property) {
        return delegate.getOWLObjectMinCardinality(cardinality, property);
    }

    @Override
    public OWLObjectMinCardinality getOWLObjectMinCardinality(int cardinality,
            OWLObjectPropertyExpression property, OWLClassExpression classExpression) {
        return delegate
                .getOWLObjectMinCardinality(cardinality, property, classExpression);
    }

    @Override
    public OWLObjectMaxCardinality getOWLObjectMaxCardinality(int cardinality,
            OWLObjectPropertyExpression property) {
        return delegate.getOWLObjectMaxCardinality(cardinality, property);
    }

    @Override
    public OWLObjectMaxCardinality getOWLObjectMaxCardinality(int cardinality,
            OWLObjectPropertyExpression property, OWLClassExpression classExpression) {
        return delegate
                .getOWLObjectMaxCardinality(cardinality, property, classExpression);
    }

    @Override
    public OWLObjectHasSelf getOWLObjectHasSelf(OWLObjectPropertyExpression property) {
        return delegate.getOWLObjectHasSelf(property);
    }

    @Override
    public OWLObjectHasValue getOWLObjectHasValue(OWLObjectPropertyExpression property,
            OWLIndividual individual) {
        return delegate.getOWLObjectHasValue(property, individual);
    }

    @Override
    public OWLObjectUnionOf
            getOWLObjectUnionOf(Set<? extends OWLClassExpression> operands) {
        return delegate.getOWLObjectUnionOf(operands);
    }

    @Override
    public OWLObjectUnionOf getOWLObjectUnionOf(OWLClassExpression... operands) {
        return delegate.getOWLObjectUnionOf(operands);
    }

    @Override
    public OWLDeclarationAxiom getOWLDeclarationAxiom(OWLEntity owlEntity) {
        return delegate.getOWLDeclarationAxiom(owlEntity);
    }

    @Override
    public OWLDeclarationAxiom getOWLDeclarationAxiom(OWLEntity owlEntity,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDeclarationAxiom(owlEntity, annotations);
    }

    @Override
    public OWLSubClassOfAxiom getOWLSubClassOfAxiom(OWLClassExpression subClass,
            OWLClassExpression superClass) {
        return delegate.getOWLSubClassOfAxiom(subClass, superClass);
    }

    @Override
    public OWLSubClassOfAxiom getOWLSubClassOfAxiom(OWLClassExpression subClass,
            OWLClassExpression superClass, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSubClassOfAxiom(subClass, superClass, annotations);
    }

    @Override
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            Set<? extends OWLClassExpression> classExpressions) {
        return delegate.getOWLEquivalentClassesAxiom(classExpressions);
    }

    @Override
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            Set<? extends OWLClassExpression> classExpressions,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLEquivalentClassesAxiom(classExpressions, annotations);
    }

    @Override
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            OWLClassExpression... classExpressions) {
        return delegate.getOWLEquivalentClassesAxiom(classExpressions);
    }

    @Override
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            OWLClassExpression clsA, OWLClassExpression clsB) {
        return delegate.getOWLEquivalentClassesAxiom(clsA, clsB);
    }

    @Override
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            OWLClassExpression clsA, OWLClassExpression clsB,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLEquivalentClassesAxiom(clsA, clsB, annotations);
    }

    @Override
    public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
            Set<? extends OWLClassExpression> classExpressions) {
        return delegate.getOWLDisjointClassesAxiom(classExpressions);
    }

    @Override
    public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
            OWLClassExpression... classExpressions) {
        return delegate.getOWLDisjointClassesAxiom(classExpressions);
    }

    @Override
    public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
            Set<? extends OWLClassExpression> classExpressions,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDisjointClassesAxiom(classExpressions, annotations);
    }

    @Override
    public OWLDisjointUnionAxiom getOWLDisjointUnionAxiom(OWLClass owlClass,
            Set<? extends OWLClassExpression> classExpressions) {
        return delegate.getOWLDisjointUnionAxiom(owlClass, classExpressions);
    }

    @Override
    public OWLDisjointUnionAxiom getOWLDisjointUnionAxiom(OWLClass owlClass,
            Set<? extends OWLClassExpression> classExpressions,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDisjointUnionAxiom(owlClass, classExpressions, annotations);
    }

    @Override
    public OWLSubObjectPropertyOfAxiom getOWLSubObjectPropertyOfAxiom(
            OWLObjectPropertyExpression subProperty,
            OWLObjectPropertyExpression superProperty) {
        return delegate.getOWLSubObjectPropertyOfAxiom(subProperty, superProperty);
    }

    @Override
    public OWLSubObjectPropertyOfAxiom getOWLSubObjectPropertyOfAxiom(
            OWLObjectPropertyExpression subProperty,
            OWLObjectPropertyExpression superProperty,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSubObjectPropertyOfAxiom(subProperty, superProperty,
                annotations);
    }

    @Override
    public OWLSubPropertyChainOfAxiom getOWLSubPropertyChainOfAxiom(
            List<? extends OWLObjectPropertyExpression> chain,
            OWLObjectPropertyExpression superProperty) {
        return delegate.getOWLSubPropertyChainOfAxiom(chain, superProperty);
    }

    @Override
    public OWLSubPropertyChainOfAxiom getOWLSubPropertyChainOfAxiom(
            List<? extends OWLObjectPropertyExpression> chain,
            OWLObjectPropertyExpression superProperty,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSubPropertyChainOfAxiom(chain, superProperty, annotations);
    }

    @Override
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            Set<? extends OWLObjectPropertyExpression> properties) {
        return delegate.getOWLEquivalentObjectPropertiesAxiom(properties);
    }

    @Override
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            Set<? extends OWLObjectPropertyExpression> properties,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLEquivalentObjectPropertiesAxiom(properties, annotations);
    }

    @Override
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            OWLObjectPropertyExpression... properties) {
        return delegate.getOWLEquivalentObjectPropertiesAxiom(properties);
    }

    @Override
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            OWLObjectPropertyExpression propertyA, OWLObjectPropertyExpression propertyB) {
        return delegate.getOWLEquivalentObjectPropertiesAxiom(propertyA, propertyB);
    }

    @Override
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            OWLObjectPropertyExpression propertyA, OWLObjectPropertyExpression propertyB,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLEquivalentObjectPropertiesAxiom(propertyA, propertyB,
                annotations);
    }

    @Override
    public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
            Set<? extends OWLObjectPropertyExpression> properties) {
        return delegate.getOWLDisjointObjectPropertiesAxiom(properties);
    }

    @Override
    public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
            OWLObjectPropertyExpression... properties) {
        return delegate.getOWLDisjointObjectPropertiesAxiom(properties);
    }

    @Override
    public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
            Set<? extends OWLObjectPropertyExpression> properties,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDisjointObjectPropertiesAxiom(properties, annotations);
    }

    @Override
    public OWLInverseObjectPropertiesAxiom getOWLInverseObjectPropertiesAxiom(
            OWLObjectPropertyExpression forwardProperty,
            OWLObjectPropertyExpression inverseProperty) {
        return delegate.getOWLInverseObjectPropertiesAxiom(forwardProperty,
                inverseProperty);
    }

    @Override
    public OWLInverseObjectPropertiesAxiom getOWLInverseObjectPropertiesAxiom(
            OWLObjectPropertyExpression forwardProperty,
            OWLObjectPropertyExpression inverseProperty,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLInverseObjectPropertiesAxiom(forwardProperty,
                inverseProperty, annotations);
    }

    @Override
    public OWLObjectPropertyDomainAxiom getOWLObjectPropertyDomainAxiom(
            OWLObjectPropertyExpression property, OWLClassExpression classExpression) {
        return delegate.getOWLObjectPropertyDomainAxiom(property, classExpression);
    }

    @Override
    public OWLObjectPropertyDomainAxiom getOWLObjectPropertyDomainAxiom(
            OWLObjectPropertyExpression property, OWLClassExpression classExpression,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLObjectPropertyDomainAxiom(property, classExpression,
                annotations);
    }

    @Override
    public OWLObjectPropertyRangeAxiom getOWLObjectPropertyRangeAxiom(
            OWLObjectPropertyExpression property, OWLClassExpression range) {
        return delegate.getOWLObjectPropertyRangeAxiom(property, range);
    }

    @Override
    public OWLObjectPropertyRangeAxiom getOWLObjectPropertyRangeAxiom(
            OWLObjectPropertyExpression property, OWLClassExpression range,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLObjectPropertyRangeAxiom(property, range, annotations);
    }

    @Override
    public OWLFunctionalObjectPropertyAxiom getOWLFunctionalObjectPropertyAxiom(
            OWLObjectPropertyExpression property) {
        return delegate.getOWLFunctionalObjectPropertyAxiom(property);
    }

    @Override
    public OWLFunctionalObjectPropertyAxiom
            getOWLFunctionalObjectPropertyAxiom(OWLObjectPropertyExpression property,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLFunctionalObjectPropertyAxiom(property, annotations);
    }

    @Override
    public OWLInverseFunctionalObjectPropertyAxiom
            getOWLInverseFunctionalObjectPropertyAxiom(
                    OWLObjectPropertyExpression property) {
        return delegate.getOWLInverseFunctionalObjectPropertyAxiom(property);
    }

    @Override
    public OWLInverseFunctionalObjectPropertyAxiom
            getOWLInverseFunctionalObjectPropertyAxiom(
                    OWLObjectPropertyExpression property,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLInverseFunctionalObjectPropertyAxiom(property, annotations);
    }

    @Override
    public OWLReflexiveObjectPropertyAxiom getOWLReflexiveObjectPropertyAxiom(
            OWLObjectPropertyExpression property) {
        return delegate.getOWLReflexiveObjectPropertyAxiom(property);
    }

    @Override
    public OWLReflexiveObjectPropertyAxiom
            getOWLReflexiveObjectPropertyAxiom(OWLObjectPropertyExpression property,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLReflexiveObjectPropertyAxiom(property, annotations);
    }

    @Override
    public OWLIrreflexiveObjectPropertyAxiom getOWLIrreflexiveObjectPropertyAxiom(
            OWLObjectPropertyExpression property) {
        return delegate.getOWLIrreflexiveObjectPropertyAxiom(property);
    }

    @Override
    public OWLIrreflexiveObjectPropertyAxiom
            getOWLIrreflexiveObjectPropertyAxiom(OWLObjectPropertyExpression property,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLIrreflexiveObjectPropertyAxiom(property, annotations);
    }

    @Override
    public OWLSymmetricObjectPropertyAxiom getOWLSymmetricObjectPropertyAxiom(
            OWLObjectPropertyExpression property) {
        return delegate.getOWLSymmetricObjectPropertyAxiom(property);
    }

    @Override
    public OWLSymmetricObjectPropertyAxiom
            getOWLSymmetricObjectPropertyAxiom(OWLObjectPropertyExpression property,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSymmetricObjectPropertyAxiom(property, annotations);
    }

    @Override
    public OWLAsymmetricObjectPropertyAxiom getOWLAsymmetricObjectPropertyAxiom(
            OWLObjectPropertyExpression propertyExpression) {
        return delegate.getOWLAsymmetricObjectPropertyAxiom(propertyExpression);
    }

    @Override
    public OWLAsymmetricObjectPropertyAxiom getOWLAsymmetricObjectPropertyAxiom(
            OWLObjectPropertyExpression propertyExpression,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLAsymmetricObjectPropertyAxiom(propertyExpression,
                annotations);
    }

    @Override
    public OWLTransitiveObjectPropertyAxiom getOWLTransitiveObjectPropertyAxiom(
            OWLObjectPropertyExpression property) {
        return delegate.getOWLTransitiveObjectPropertyAxiom(property);
    }

    @Override
    public OWLTransitiveObjectPropertyAxiom
            getOWLTransitiveObjectPropertyAxiom(OWLObjectPropertyExpression property,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLTransitiveObjectPropertyAxiom(property, annotations);
    }

    @Override
    public OWLSubDataPropertyOfAxiom
            getOWLSubDataPropertyOfAxiom(OWLDataPropertyExpression subProperty,
                    OWLDataPropertyExpression superProperty) {
        return delegate.getOWLSubDataPropertyOfAxiom(subProperty, superProperty);
    }

    @Override
    public OWLSubDataPropertyOfAxiom getOWLSubDataPropertyOfAxiom(
            OWLDataPropertyExpression subProperty,
            OWLDataPropertyExpression superProperty,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSubDataPropertyOfAxiom(subProperty, superProperty,
                annotations);
    }

    @Override
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            Set<? extends OWLDataPropertyExpression> properties) {
        return delegate.getOWLEquivalentDataPropertiesAxiom(properties);
    }

    @Override
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            Set<? extends OWLDataPropertyExpression> properties,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLEquivalentDataPropertiesAxiom(properties, annotations);
    }

    @Override
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            OWLDataPropertyExpression... properties) {
        return delegate.getOWLEquivalentDataPropertiesAxiom(properties);
    }

    @Override
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            OWLDataPropertyExpression propertyA, OWLDataPropertyExpression propertyB) {
        return delegate.getOWLEquivalentDataPropertiesAxiom(propertyA, propertyB);
    }

    @Override
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            OWLDataPropertyExpression propertyA, OWLDataPropertyExpression propertyB,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLEquivalentDataPropertiesAxiom(propertyA, propertyB,
                annotations);
    }

    @Override
    public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
            OWLDataPropertyExpression... dataProperties) {
        return delegate.getOWLDisjointDataPropertiesAxiom(dataProperties);
    }

    @Override
    public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
            Set<? extends OWLDataPropertyExpression> properties) {
        return delegate.getOWLDisjointDataPropertiesAxiom(properties);
    }

    @Override
    public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
            Set<? extends OWLDataPropertyExpression> properties,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDisjointDataPropertiesAxiom(properties, annotations);
    }

    @Override
    public OWLDataPropertyDomainAxiom getOWLDataPropertyDomainAxiom(
            OWLDataPropertyExpression property, OWLClassExpression domain) {
        return delegate.getOWLDataPropertyDomainAxiom(property, domain);
    }

    @Override
    public OWLDataPropertyDomainAxiom getOWLDataPropertyDomainAxiom(
            OWLDataPropertyExpression property, OWLClassExpression domain,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDataPropertyDomainAxiom(property, domain, annotations);
    }

    @Override
    public OWLDataPropertyRangeAxiom getOWLDataPropertyRangeAxiom(
            OWLDataPropertyExpression property, OWLDataRange owlDataRange) {
        return delegate.getOWLDataPropertyRangeAxiom(property, owlDataRange);
    }

    @Override
    public OWLDataPropertyRangeAxiom getOWLDataPropertyRangeAxiom(
            OWLDataPropertyExpression property, OWLDataRange owlDataRange,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDataPropertyRangeAxiom(property, owlDataRange, annotations);
    }

    @Override
    public OWLFunctionalDataPropertyAxiom getOWLFunctionalDataPropertyAxiom(
            OWLDataPropertyExpression property) {
        return delegate.getOWLFunctionalDataPropertyAxiom(property);
    }

    @Override
    public OWLFunctionalDataPropertyAxiom getOWLFunctionalDataPropertyAxiom(
            OWLDataPropertyExpression property, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLFunctionalDataPropertyAxiom(property, annotations);
    }

    @Override
    public OWLHasKeyAxiom getOWLHasKeyAxiom(OWLClassExpression ce,
            Set<? extends OWLPropertyExpression<?, ?>> properties) {
        return delegate.getOWLHasKeyAxiom(ce, properties);
    }

    @Override
    public OWLHasKeyAxiom getOWLHasKeyAxiom(OWLClassExpression ce,
            OWLPropertyExpression<?, ?>... properties) {
        return delegate.getOWLHasKeyAxiom(ce, properties);
    }

    @Override
    public OWLHasKeyAxiom getOWLHasKeyAxiom(OWLClassExpression ce,
            Set<? extends OWLPropertyExpression<?, ?>> objectProperties,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLHasKeyAxiom(ce, objectProperties, annotations);
    }

    @Override
    public OWLDatatypeDefinitionAxiom getOWLDatatypeDefinitionAxiom(OWLDatatype datatype,
            OWLDataRange dataRange) {
        return delegate.getOWLDatatypeDefinitionAxiom(datatype, dataRange);
    }

    @Override
    public OWLDatatypeDefinitionAxiom getOWLDatatypeDefinitionAxiom(OWLDatatype datatype,
            OWLDataRange dataRange, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDatatypeDefinitionAxiom(datatype, dataRange, annotations);
    }

    @Override
    public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
            Set<? extends OWLIndividual> individuals) {
        return delegate.getOWLSameIndividualAxiom(individuals);
    }

    @Override
    public OWLSameIndividualAxiom getOWLSameIndividualAxiom(OWLIndividual... individual) {
        return delegate.getOWLSameIndividualAxiom(individual);
    }

    @Override
    public OWLSameIndividualAxiom getOWLSameIndividualAxiom(
            Set<? extends OWLIndividual> individuals,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSameIndividualAxiom(individuals, annotations);
    }

    @Override
    public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
            Set<? extends OWLIndividual> individuals) {
        return delegate.getOWLDifferentIndividualsAxiom(individuals);
    }

    @Override
    public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
            OWLIndividual... individuals) {
        return delegate.getOWLDifferentIndividualsAxiom(individuals);
    }

    @Override
    public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
            Set<? extends OWLIndividual> individuals,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDifferentIndividualsAxiom(individuals, annotations);
    }

    @Override
    public OWLClassAssertionAxiom getOWLClassAssertionAxiom(
            OWLClassExpression classExpression, OWLIndividual individual) {
        return delegate.getOWLClassAssertionAxiom(classExpression, individual);
    }

    @Override
    public OWLClassAssertionAxiom getOWLClassAssertionAxiom(
            OWLClassExpression classExpression, OWLIndividual individual,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLClassAssertionAxiom(classExpression, individual,
                annotations);
    }

    @Override
    public OWLObjectPropertyAssertionAxiom getOWLObjectPropertyAssertionAxiom(
            OWLObjectPropertyExpression property, OWLIndividual individual,
            OWLIndividual object) {
        return delegate.getOWLObjectPropertyAssertionAxiom(property, individual, object);
    }

    @Override
    public OWLObjectPropertyAssertionAxiom getOWLObjectPropertyAssertionAxiom(
            OWLObjectPropertyExpression property, OWLIndividual individual,
            OWLIndividual object, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLObjectPropertyAssertionAxiom(property, individual, object,
                annotations);
    }

    @Override
    public OWLNegativeObjectPropertyAssertionAxiom
            getOWLNegativeObjectPropertyAssertionAxiom(
                    OWLObjectPropertyExpression property, OWLIndividual subject,
                    OWLIndividual object) {
        return delegate.getOWLNegativeObjectPropertyAssertionAxiom(property, subject,
                object);
    }

    @Override
    public OWLNegativeObjectPropertyAssertionAxiom
            getOWLNegativeObjectPropertyAssertionAxiom(
                    OWLObjectPropertyExpression property, OWLIndividual subject,
                    OWLIndividual object, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLNegativeObjectPropertyAssertionAxiom(property, subject,
                object, annotations);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, OWLLiteral object) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, object);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, OWLLiteral object,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, object,
                annotations);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, int value) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, value);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, double value) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, value);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, float value) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, value);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, boolean value) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, value);
    }

    @Override
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            OWLDataPropertyExpression property, OWLIndividual subject, String value) {
        return delegate.getOWLDataPropertyAssertionAxiom(property, subject, value);
    }

    @Override
    public OWLNegativeDataPropertyAssertionAxiom
            getOWLNegativeDataPropertyAssertionAxiom(OWLDataPropertyExpression property,
                    OWLIndividual subject, OWLLiteral object) {
        return delegate.getOWLNegativeDataPropertyAssertionAxiom(property, subject,
                object);
    }

    @Override
    public OWLNegativeDataPropertyAssertionAxiom
            getOWLNegativeDataPropertyAssertionAxiom(OWLDataPropertyExpression property,
                    OWLIndividual subject, OWLLiteral object,
                    Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLNegativeDataPropertyAssertionAxiom(property, subject,
                object, annotations);
    }

    @Override
    public OWLAnnotation getOWLAnnotation(OWLAnnotationProperty property,
            OWLAnnotationValue value) {
        return delegate.getOWLAnnotation(property, value);
    }

    @Override
    public OWLAnnotation getOWLAnnotation(OWLAnnotationProperty property,
            OWLAnnotationValue value, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLAnnotation(property, value, annotations);
    }

    @Override
    public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
            OWLAnnotationProperty property, OWLAnnotationSubject subject,
            OWLAnnotationValue value) {
        return delegate.getOWLAnnotationAssertionAxiom(property, subject, value);
    }

    @Override
    public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
            OWLAnnotationSubject subject, OWLAnnotation annotation) {
        return delegate.getOWLAnnotationAssertionAxiom(subject, annotation);
    }

    @Override
    public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
            OWLAnnotationProperty property, OWLAnnotationSubject subject,
            OWLAnnotationValue value, Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLAnnotationAssertionAxiom(property, subject, value,
                annotations);
    }

    @Override
    public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
            OWLAnnotationSubject subject, OWLAnnotation annotation,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLAnnotationAssertionAxiom(subject, annotation, annotations);
    }

    @Override
    public OWLAnnotationAssertionAxiom getDeprecatedOWLAnnotationAssertionAxiom(
            IRI subject) {
        return delegate.getDeprecatedOWLAnnotationAssertionAxiom(subject);
    }

    @Override
    public OWLImportsDeclaration getOWLImportsDeclaration(IRI importedOntologyIRI) {
        return delegate.getOWLImportsDeclaration(importedOntologyIRI);
    }

    @Override
    public OWLAnnotationPropertyDomainAxiom getOWLAnnotationPropertyDomainAxiom(
            OWLAnnotationProperty prop, IRI domain) {
        return delegate.getOWLAnnotationPropertyDomainAxiom(prop, domain);
    }

    @Override
    public OWLAnnotationPropertyDomainAxiom getOWLAnnotationPropertyDomainAxiom(
            OWLAnnotationProperty prop, IRI domain,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLAnnotationPropertyDomainAxiom(prop, domain, annotations);
    }

    @Override
    public OWLAnnotationPropertyRangeAxiom getOWLAnnotationPropertyRangeAxiom(
            OWLAnnotationProperty prop, IRI range) {
        return delegate.getOWLAnnotationPropertyRangeAxiom(prop, range);
    }

    @Override
    public OWLAnnotationPropertyRangeAxiom getOWLAnnotationPropertyRangeAxiom(
            OWLAnnotationProperty prop, IRI range,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLAnnotationPropertyRangeAxiom(prop, range, annotations);
    }

    @Override
    public OWLSubAnnotationPropertyOfAxiom getOWLSubAnnotationPropertyOfAxiom(
            OWLAnnotationProperty sub, OWLAnnotationProperty sup) {
        return delegate.getOWLSubAnnotationPropertyOfAxiom(sub, sup);
    }

    @Override
    public OWLSubAnnotationPropertyOfAxiom getOWLSubAnnotationPropertyOfAxiom(
            OWLAnnotationProperty sub, OWLAnnotationProperty sup,
            Set<? extends OWLAnnotation> annotations) {
        return delegate.getOWLSubAnnotationPropertyOfAxiom(sub, sup, annotations);
    }

    @Override
    public void purge() {
        delegate.purge();
    }
}
