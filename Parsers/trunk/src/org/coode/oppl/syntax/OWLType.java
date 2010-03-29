/**
 * 
 */
package org.coode.oppl.syntax;

import java.util.EnumSet;

/**
 * @author Luigi Iannone
 * 
 */
public enum OWLType implements Type {
	OWL_CLASS, OWL_DATA_ALL_RESTRICTION, OWL_DATA_PROPERTY, OWL_OBJECT_PROPERTY, OWL_OBJECT_INVERSE_PROPERTY, OWL_INDIVIDUAL, OWL_DATA_TYPE, OWL_PROPERTY_CHAIN, OWL_CONSTANT, OWL_DATA_EXACT_CARDINALITY_RESTRICTION, OWL_DATA_MAX_CARDINALITY_RESTRICTION, OWL_DATA_MIN_CARDINALITY_RESTRICTION, OWL_DATA_SOME_RESTRICTION, OWL_DATA_VALUE_RESTRICTION, OWL_OBJECT_ALL_RESTRICTION, OWL_OBJECT_COMPLEMENT_OF, OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION, OWL_OBJECT_INTERSECTION_OF, OWL_OBJECT_MAX_CARDINALITY_RESTRICTION, OWL_OBJECT_MIN_CARDINALITY_RESTRICTION, OWL_OBJECT_ONE_OF, OWL_OBJECT_SELF_RESTRICTION, OWL_OBJECT_SOME_RESTRICTION, OWL_OBJECT_UNION_OF, OWL_OBJECT_VALUE_RESTRICTION;
	private static EnumSet<OWLType> getClassDescriptionTypes() {
		return EnumSet.of(OWL_CLASS, OWL_DATA_ALL_RESTRICTION,
				OWL_DATA_EXACT_CARDINALITY_RESTRICTION,
				OWL_DATA_MAX_CARDINALITY_RESTRICTION,
				OWL_DATA_MIN_CARDINALITY_RESTRICTION,
				OWL_DATA_SOME_RESTRICTION, OWL_DATA_VALUE_RESTRICTION,
				OWL_OBJECT_ALL_RESTRICTION, OWL_OBJECT_COMPLEMENT_OF,
				OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION,
				OWL_OBJECT_INTERSECTION_OF,
				OWL_OBJECT_MAX_CARDINALITY_RESTRICTION,
				OWL_OBJECT_MIN_CARDINALITY_RESTRICTION, OWL_OBJECT_ONE_OF,
				OWL_OBJECT_SELF_RESTRICTION, OWL_OBJECT_SOME_RESTRICTION,
				OWL_OBJECT_UNION_OF, OWL_OBJECT_VALUE_RESTRICTION);
	}

	public static boolean isClassExpression(OWLType type) {
		return getClassDescriptionTypes().contains(type);
	}

	private static EnumSet<OWLType> getObjectProertyDescriptionTypes() {
		return EnumSet.of(OWL_OBJECT_PROPERTY, OWL_OBJECT_INVERSE_PROPERTY);
	}

	public static boolean isObjectPropertyExpression(OWLType type) {
		return getObjectProertyDescriptionTypes().contains(type);
	}

	public void accept(TypeVisitor visitor) {
		visitor.visitOWLType(this);
	}

	public <O> O accept(TypeVisitorEx<O> visitor) {
		return visitor.visitOWLType(this);
	}
}
