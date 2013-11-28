package org.coode.parsers;

import java.util.EnumSet;

/** @author Luigi Iannone */
public enum OWLAxiomType implements Type {
    /** CLASS */
    CLASS_ASSERTION,
    /** DATA_PROPERTY */
    DATA_PROPERTY_ASSERTION,
    /** DATA_PROPERTY_DOMAIN */
    DATA_PROPERTY_DOMAIN,
    /** DATA_PROPERTY_RANGE */
    DATA_PROPERTY_RANGE,
    /** DECLARATION */
    DECLARATION,
    /** DIFFERENT_INDIVIDUALS */
    DIFFERENT_INDIVIDUALS,
    /** DISJOINT_CLASSES */
    DISJOINT_CLASSES,
    /** DISJOINT_DATA_PROPERTIES */
    DISJOINT_DATA_PROPERTIES,
    /** DISJOINT_OBJECT_PROPERTIES */
    DISJOINT_OBJECT_PROPERTIES,
    /** DISJOINT_UNION */
    DISJOINT_UNION,
    /** ENTITY_ANNOTATION */
    ENTITY_ANNOTATION,
    /** EQUIVALENT_CLASSES */
    EQUIVALENT_CLASSES,
    /** EQUIVALENT_DATA_PROPERTIES */
    EQUIVALENT_DATA_PROPERTIES,
    /** EQUIVALENT_OBJECT_PROPERTIES */
    EQUIVALENT_OBJECT_PROPERTIES,
    /** FUNCTIONAL_DATA_PROPERTY */
    FUNCTIONAL_DATA_PROPERTY,
    /** FUNCTIONAL_OBJECT_PROPERTY */
    FUNCTIONAL_OBJECT_PROPERTY,
    /** IMPORTS_DECLARATION */
    IMPORTS_DECLARATION,
    /** INVERSE_FUNCTIONAL_OBJECT_PROPERTY */
    INVERSE_FUNCTIONAL_OBJECT_PROPERTY,
    /** INVERSE_OBJECT_PROPERTIES */
    INVERSE_OBJECT_PROPERTIES,
    /** IRREFLEXIVE_OBJECT_PROPERTY */
    IRREFLEXIVE_OBJECT_PROPERTY,
    /** NEGATIVE_DATA_PROPERTY */
    NEGATIVE_DATA_PROPERTY_ASSERTION,
    /** NEGATIVE_OBJECT_PROPERTY */
    NEGATIVE_OBJECT_PROPERTY_ASSERTION,
    /** OBJECT_PROPERTY */
    OBJECT_PROPERTY_ASSERTION,
    /** OBJECT_PROPERTY_DOMAIN */
    OBJECT_PROPERTY_DOMAIN,
    /** OBJECT_PROPERTY_RANGE */
    OBJECT_PROPERTY_RANGE,
    /** ONTOLOGY_ANNOTATION */
    ONTOLOGY_ANNOTATION,
    /** PROPERTY_CHAIN_SUB_PROPERTY */
    PROPERTY_CHAIN_SUB_PROPERTY,
    /** REFLEXIVE_OBJECT_PROPERTY */
    REFLEXIVE_OBJECT_PROPERTY,
    /** SAME_INDIVIDUAL */
    SAME_INDIVIDUAL,
    /** SUB_DATA_PROPERTY */
    SUB_DATA_PROPERTY,
    /** SUB_OBJECT_PROPERTY */
    SUB_OBJECT_PROPERTY,
    /** SUBCLASS */
    SUBCLASS,
    /** SWRL_RULE */
    SWRL_RULE,
    /** SYMMETRIC_OBJECT_PROPERTY */
    SYMMETRIC_OBJECT_PROPERTY,
    /** TRANSITIVE_OBJECT_PROPERTY */
    TRANSITIVE_OBJECT_PROPERTY,
    /** HAS_KEY */
    HAS_KEY,
    /** ANNOTATION */
    ANNOTATION_ASSERTION;
    @Override
    public void accept(TypeVisitor visitor) {
        visitor.visitOWLAxiomType(this);
    }

    @Override
    public <O> O accept(TypeVisitorEx<O> visitor) {
        return visitor.visitOWLAxiomType(this);
    }

    private static EnumSet<OWLAxiomType> getAssertionOWLAxiomTypes() {
        return EnumSet.of(DATA_PROPERTY_ASSERTION, OBJECT_PROPERTY_ASSERTION,
                CLASS_ASSERTION, NEGATIVE_DATA_PROPERTY_ASSERTION,
                NEGATIVE_OBJECT_PROPERTY_ASSERTION);
    }

    /** @param type
     * @return true if abox axiom */
    public static boolean isAssertion(OWLAxiomType type) {
        return getAssertionOWLAxiomTypes().contains(type);
    }
}
