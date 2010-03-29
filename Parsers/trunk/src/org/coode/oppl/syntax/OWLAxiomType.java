/**
 * 
 */
package org.coode.oppl.syntax;

import java.util.EnumSet;

/**
 * @author Luigi Iannone
 * 
 */
public enum OWLAxiomType implements Type {
	CLASS_ASSERTION, DATA_PROPERTY_ASSERTION, DATA_PROPERTY_DOMAIN, DATA_PROPERTY_RANGE, DECLARATION, DIFFERENT_INDIVIDUALS, DISJOINT_CLASSES, DISJOINT_DATA_PROPERTIES, DISJOINT_OBJECT_PROPERTIES, DISJOINT_UNION, ENTITY_ANNOTATION, EQUIVALENT_CLASSES, EQUIVALENT_DATA_PROPERTIES, EQUIVALENT_OBJECT_PROPERTIES, FUNCTIONAL_DATA_PROPERTY, FUNCTIONAL_OBJECT_PROPERTY, IMPORTS_DECLARATION, INVERSE_FUNCTIONAL_OBJECT_PROPERTY, INVERSE_OBJECT_PROPERTIES, IRREFLEXIVE_OBJECT_PROPERTY, NEGATIVE_DATA_PROPERTY_ASSERTION, NEGATIVE_OBJECT_PROPERTY_ASSERTION, OBJECT_PROPERTY_ASSERTION, OBJECT_PROPERTY_DOMAIN, OBJECT_PROPERTY_RANGE, ONTOLOGY_ANNOTATION, PROPERTY_CHAIN_SUB_PROPERTY, REFLEXIVE_OBJECT_PROPERTY, SAME_INDIVIDUAL, SUB_DATA_PROPERTY, SUB_OBJECT_PROPERTY, SUBCLASS, SWRL_RULE, SYMMETRIC_OBJECT_PROPERTY, TRANSITIVE_OBJECT_PROPERTY;
	public void accept(TypeVisitor visitor) {
		visitor.visitOWLAxiomType(this);
	}

	public <O> O accept(TypeVisitorEx<O> visitor) {
		return visitor.visitOWLAxiomType(this);
	}

	private static EnumSet<OWLAxiomType> getAssertionOWLAxiomTypes() {
		return EnumSet.of(DATA_PROPERTY_ASSERTION, OBJECT_PROPERTY_ASSERTION,
				CLASS_ASSERTION, NEGATIVE_DATA_PROPERTY_ASSERTION,
				NEGATIVE_OBJECT_PROPERTY_ASSERTION);
	}

	public static boolean isAssertion(OWLAxiomType type) {
		return getAssertionOWLAxiomTypes().contains(type);
	}
}