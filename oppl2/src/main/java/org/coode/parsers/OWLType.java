package org.coode.parsers;

import java.util.EnumSet;

import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityVisitorEx;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/** @author Luigi Iannone */
public enum OWLType implements Type {
    /** OWL_CLASS */
    OWL_CLASS,
    /** OWL_DATA_FACET */
    OWL_DATA_FACET,
    /** OWL_DATA_TYPE_RESTRICTION */
    OWL_DATA_TYPE_RESTRICTION,
    /** OWL_DATA_ALL_RESTRICTION */
    OWL_DATA_ALL_RESTRICTION,
    /** OWL_DATA_PROPERTY */
    OWL_DATA_PROPERTY,
    /** OWL_OBJECT_PROPERTY */
    OWL_OBJECT_PROPERTY,
    /** OWL_OBJECT_INVERSE_PROPERTY */
    OWL_OBJECT_INVERSE_PROPERTY,
    /** OWL_INDIVIDUAL */
    OWL_INDIVIDUAL,
    /** OWL_DATA_TYPE */
    OWL_DATA_TYPE,
    /** OWL_PROPERTY_CHAIN */
    OWL_PROPERTY_CHAIN,
    /** OWL_CONSTANT */
    OWL_CONSTANT,
    /** OWL_DATA_EXACT_CARDINALITY_RESTRICTION */
    OWL_DATA_EXACT_CARDINALITY_RESTRICTION,
    /** OWL_DATA_MAX_CARDINALITY_RESTRICTION */
    OWL_DATA_MAX_CARDINALITY_RESTRICTION,
    /** OWL_DATA_MIN_CARDINALITY_RESTRICTION */
    OWL_DATA_MIN_CARDINALITY_RESTRICTION,
    /** OWL_DATA_SOME_RESTRICTION */
    OWL_DATA_SOME_RESTRICTION,
    /** OWL_DATA_VALUE_RESTRICTION */
    OWL_DATA_VALUE_RESTRICTION,
    /** OWL_OBJECT_ALL_RESTRICTION */
    OWL_OBJECT_ALL_RESTRICTION,
    /** OWL_OBJECT_COMPLEMENT_OF */
    OWL_OBJECT_COMPLEMENT_OF,
    /** OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION */
    OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION,
    /** OWL_OBJECT_INTERSECTION_OF */
    OWL_OBJECT_INTERSECTION_OF,
    /** OWL_OBJECT_MAX_CARDINALITY_RESTRICTION */
    OWL_OBJECT_MAX_CARDINALITY_RESTRICTION,
    /** OWL_OBJECT_MIN_CARDINALITY_RESTRICTION */
    OWL_OBJECT_MIN_CARDINALITY_RESTRICTION,
    /** OWL_OBJECT_ONE_OF */
    OWL_OBJECT_ONE_OF,
    /** OWL_OBJECT_SELF_RESTRICTION */
    OWL_OBJECT_SELF_RESTRICTION,
    /** OWL_OBJECT_SOME_RESTRICTION */
    OWL_OBJECT_SOME_RESTRICTION,
    /** OWL_OBJECT_UNION_OF */
    OWL_OBJECT_UNION_OF,
    /** OWL_OBJECT_VALUE_RESTRICTION */
    OWL_OBJECT_VALUE_RESTRICTION,
    /** OWL_ANNOTATION_PROPERTY */
    OWL_ANNOTATION_PROPERTY,
    /** OWL_DATA_INTERSECTION_OF */
    OWL_DATA_INTERSECTION_OF,
    /** OWL_DATA_UNION_OF */
    OWL_DATA_UNION_OF,
    /** IRI */
    IRI;
    private static EnumSet<OWLType> getClassDescriptionTypes() {
        return EnumSet.of(OWL_CLASS, OWL_DATA_ALL_RESTRICTION,
                OWL_DATA_EXACT_CARDINALITY_RESTRICTION,
                OWL_DATA_MAX_CARDINALITY_RESTRICTION,
                OWL_DATA_MIN_CARDINALITY_RESTRICTION, OWL_DATA_SOME_RESTRICTION,
                OWL_DATA_VALUE_RESTRICTION, OWL_OBJECT_ALL_RESTRICTION,
                OWL_OBJECT_COMPLEMENT_OF, OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION,
                OWL_OBJECT_INTERSECTION_OF, OWL_OBJECT_MAX_CARDINALITY_RESTRICTION,
                OWL_OBJECT_MIN_CARDINALITY_RESTRICTION, OWL_OBJECT_ONE_OF,
                OWL_OBJECT_SELF_RESTRICTION, OWL_OBJECT_SOME_RESTRICTION,
                OWL_OBJECT_UNION_OF, OWL_OBJECT_VALUE_RESTRICTION);
    }

    /** @param t
     *            t
     * @return true if matched */
    public boolean match(Type t) {
        return this == t;
    }

    private static EnumSet<OWLType> getDataRestrictionTypes() {
        return EnumSet.of(OWL_DATA_TYPE_RESTRICTION, OWL_DATA_INTERSECTION_OF,
                OWL_DATA_UNION_OF);
    }

    /** @param type
     *            type
     * @return true if class expression */
    public static boolean isClassExpression(Type type) {
        return getClassDescriptionTypes().contains(type);
    }

    /** @param type
     *            type
     * @return true if datatype expression */
    public static boolean isDataTypeExpression(Type type) {
        return getDataRestrictionTypes().contains(type);
    }

    /** @param type
     *            type
     * @return true if object property expression */
    public static boolean isObjectPropertyExpression(Type type) {
        return type == OWL_OBJECT_PROPERTY || type == OWL_OBJECT_INVERSE_PROPERTY;
    }

    /** @param type
     *            type
     * @return true if property */
    public static boolean isPropertyExpression(Type type) {
        return type == OWL_OBJECT_PROPERTY || type == OWL_OBJECT_INVERSE_PROPERTY
                || type == OWL_DATA_PROPERTY;
    }

    @Override
    public void accept(TypeVisitor visitor) {
        visitor.visitOWLType(this);
    }

    @Override
    public <O> O accept(TypeVisitorEx<O> visitor) {
        return visitor.visitOWLType(this);
    }

    /** @param entity
     *            entity
     * @return owl type */
    public static OWLType get(OWLEntity entity) {
        return entity.accept(new OWLEntityVisitorEx<OWLType>() {
            @Override
            public OWLType visit(OWLClass arg0) {
                return OWL_CLASS;
            }

            @Override
            public OWLType visit(OWLDataProperty arg0) {
                return OWL_DATA_PROPERTY;
            }

            @Override
            public OWLType visit(OWLDatatype arg0) {
                return OWL_DATA_TYPE;
            }

            @Override
            public OWLType visit(OWLNamedIndividual arg0) {
                return OWL_INDIVIDUAL;
            }

            @Override
            public OWLType visit(OWLObjectProperty arg0) {
                return OWL_OBJECT_PROPERTY;
            }

            @Override
            public OWLType visit(OWLAnnotationProperty property) {
                return OWL_ANNOTATION_PROPERTY;
            }
        });
    }
}
