/**
 * 
 */
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

/**
 * @author Luigi Iannone
 * 
 */
public enum OWLType implements Type {
	OWL_CLASS, OWL_DATA_ALL_RESTRICTION, OWL_DATA_PROPERTY, OWL_OBJECT_PROPERTY, OWL_OBJECT_INVERSE_PROPERTY, OWL_INDIVIDUAL, OWL_DATA_TYPE, OWL_PROPERTY_CHAIN, OWL_CONSTANT, OWL_DATA_EXACT_CARDINALITY_RESTRICTION, OWL_DATA_MAX_CARDINALITY_RESTRICTION, OWL_DATA_MIN_CARDINALITY_RESTRICTION, OWL_DATA_SOME_RESTRICTION, OWL_DATA_VALUE_RESTRICTION, OWL_OBJECT_ALL_RESTRICTION, OWL_OBJECT_COMPLEMENT_OF, OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION, OWL_OBJECT_INTERSECTION_OF, OWL_OBJECT_MAX_CARDINALITY_RESTRICTION, OWL_OBJECT_MIN_CARDINALITY_RESTRICTION, OWL_OBJECT_ONE_OF, OWL_OBJECT_SELF_RESTRICTION, OWL_OBJECT_SOME_RESTRICTION, OWL_OBJECT_UNION_OF, OWL_OBJECT_VALUE_RESTRICTION, OWL_ANNOTATION_PROPERTY;
	private static EnumSet<OWLType> getClassDescriptionTypes() {
		return EnumSet.of(
				OWL_CLASS,
				OWL_DATA_ALL_RESTRICTION,
				OWL_DATA_EXACT_CARDINALITY_RESTRICTION,
				OWL_DATA_MAX_CARDINALITY_RESTRICTION,
				OWL_DATA_MIN_CARDINALITY_RESTRICTION,
				OWL_DATA_SOME_RESTRICTION,
				OWL_DATA_VALUE_RESTRICTION,
				OWL_OBJECT_ALL_RESTRICTION,
				OWL_OBJECT_COMPLEMENT_OF,
				OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION,
				OWL_OBJECT_INTERSECTION_OF,
				OWL_OBJECT_MAX_CARDINALITY_RESTRICTION,
				OWL_OBJECT_MIN_CARDINALITY_RESTRICTION,
				OWL_OBJECT_ONE_OF,
				OWL_OBJECT_SELF_RESTRICTION,
				OWL_OBJECT_SOME_RESTRICTION,
				OWL_OBJECT_UNION_OF,
				OWL_OBJECT_VALUE_RESTRICTION);
	}

	public static boolean isClassExpression(Type type) {
		return getClassDescriptionTypes().contains(type);
	}

	private static EnumSet<OWLType> getObjectPropertyDescriptionTypes() {
		return EnumSet.of(OWL_OBJECT_PROPERTY, OWL_OBJECT_INVERSE_PROPERTY);
	}

	public static boolean isObjectPropertyExpression(Type type) {
		return getObjectPropertyDescriptionTypes().contains(type);
	}

	public static boolean isPropertyExpression(Type type) {
		EnumSet<OWLType> proertyDescriptionTypes = getObjectPropertyDescriptionTypes();
		proertyDescriptionTypes.add(OWL_DATA_PROPERTY);
		return proertyDescriptionTypes.contains(type);
	}

	public void accept(TypeVisitor visitor) {
		visitor.visitOWLType(this);
	}

	public <O> O accept(TypeVisitorEx<O> visitor) {
		return visitor.visitOWLType(this);
	}

	public static OWLType get(OWLEntity entity) {
		return entity.accept(new OWLEntityVisitorEx<OWLType>() {
			public OWLType visit(OWLClass arg0) {
				return OWL_CLASS;
			}

			public OWLType visit(OWLDataProperty arg0) {
				return OWL_DATA_PROPERTY;
			}

			public OWLType visit(OWLDatatype arg0) {
				return OWL_DATA_TYPE;
			}

			public OWLType visit(OWLNamedIndividual arg0) {
				return OWL_INDIVIDUAL;
			}

			public OWLType visit(OWLObjectProperty arg0) {
				return OWL_OBJECT_PROPERTY;
			}

			public OWLType visit(OWLAnnotationProperty property) {
				return OWL_ANNOTATION_PROPERTY;
			}
		});
	}
}
