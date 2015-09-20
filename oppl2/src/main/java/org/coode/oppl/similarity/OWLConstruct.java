package org.coode.oppl.similarity;

import org.semanticweb.owlapi.model.*;

enum OWLConstruct {
    AND,
    OR,
    OBJECT_NOT,
    DATA_NOT,
    OBJECT_ONE_OF,
    OBJECT_SOME,
    DATA_SOME,
    OBJECT_ALL,
    DATA_ALL,
    PRIMITIVE,
    OBJECT_HAS_VALUE,
    DATA_HAS_VALUE,
    DATA_MIN,
    DATA_EXACT,
    DATA_MAX,
    OBJECT_MIN,
    OBJECT_EXACT,
    OBJECT_MAX,
    OBJECT_SELF,
    DATA_ONE_OF,
    DATA_FACET,
    DATA_TYPE,
    DATA_RANGE_RESTRICTION,
    TYPED_CONSTANT,
    UNTYPED_CONSTANT,
    INVERSE,
    PROPERTY_CHAIN,
    DATA_INTERSECTION_OF,
    DATA_UNION_OF;

    public static OWLConstruct getOWLConstruct(OWLClassExpression description) {
        return description.accept(new OWLClassExpressionVisitorEx<OWLConstruct>() {

            @Override
            public OWLConstruct visit(OWLClass owlClass) {
                return PRIMITIVE;
            }

            @Override
            public OWLConstruct visit(OWLDataAllValuesFrom d) {
                return DATA_ALL;
            }

            @Override
            public OWLConstruct visit(OWLDataExactCardinality d) {
                return DATA_EXACT;
            }

            @Override
            public OWLConstruct visit(OWLDataMaxCardinality arg0) {
                return DATA_MAX;
            }

            @Override
            public OWLConstruct visit(OWLDataMinCardinality arg0) {
                return DATA_MIN;
            }

            @Override
            public OWLConstruct visit(OWLDataSomeValuesFrom arg0) {
                return DATA_SOME;
            }

            @Override
            public OWLConstruct visit(OWLDataHasValue arg0) {
                return DATA_HAS_VALUE;
            }

            @Override
            public OWLConstruct visit(OWLObjectAllValuesFrom arg0) {
                return OBJECT_ALL;
            }

            @Override
            public OWLConstruct visit(OWLObjectComplementOf arg0) {
                return OBJECT_NOT;
            }

            @Override
            public OWLConstruct visit(OWLObjectExactCardinality arg0) {
                return OBJECT_EXACT;
            }

            @Override
            public OWLConstruct visit(OWLObjectIntersectionOf arg0) {
                return AND;
            }

            @Override
            public OWLConstruct visit(OWLObjectMaxCardinality arg0) {
                return OBJECT_MAX;
            }

            @Override
            public OWLConstruct visit(OWLObjectMinCardinality arg0) {
                return OBJECT_MIN;
            }

            @Override
            public OWLConstruct visit(OWLObjectOneOf arg0) {
                return OBJECT_ONE_OF;
            }

            @Override
            public OWLConstruct visit(OWLObjectHasSelf arg0) {
                return OBJECT_SELF;
            }

            @Override
            public OWLConstruct visit(OWLObjectSomeValuesFrom arg0) {
                return OBJECT_SOME;
            }

            @Override
            public OWLConstruct visit(OWLObjectUnionOf arg0) {
                return OR;
            }

            @Override
            public OWLConstruct visit(OWLObjectHasValue arg0) {
                return OBJECT_HAS_VALUE;
            }
        });
    }

    public static OWLConstruct getOWLConstruct(OWLDataRange dataRange) {
        return dataRange.accept(new OWLDataVisitorEx<OWLConstruct>() {

            @Override
            public OWLConstruct visit(OWLDataComplementOf range) {
                return DATA_NOT;
            }

            @Override
            public OWLConstruct visit(OWLDataIntersectionOf node) {
                return DATA_INTERSECTION_OF;
            }

            @Override
            public OWLConstruct visit(OWLDataUnionOf node) {
                return DATA_UNION_OF;
            }

            @Override
            public OWLConstruct visit(OWLDataOneOf range) {
                return DATA_ONE_OF;
            }

            @Override
            public OWLConstruct visit(OWLFacetRestriction range) {
                return DATA_FACET;
            }

            @Override
            public OWLConstruct visit(OWLDatatypeRestriction range) {
                return DATA_RANGE_RESTRICTION;
            }

            @Override
            public OWLConstruct visit(OWLDatatype range) {
                return DATA_TYPE;
            }

            @Override
            public OWLConstruct visit(OWLLiteral constant) {
                return constant.isRDFPlainLiteral() ? UNTYPED_CONSTANT : TYPED_CONSTANT;
            }
        });
    }

    public static OWLConstruct getOWLConstruct(
        @SuppressWarnings("unused") OWLFacetRestriction facet) {
        return DATA_FACET;
    }

    public static OWLConstruct getOWLConstruct(
        @SuppressWarnings("unused") OWLObjectInverseOf inverse) {
        return INVERSE;
    }
}
