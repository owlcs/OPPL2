/**
 * 
 */
package org.coode.oppl.similarity;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataRange;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDataVisitorEx;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDescriptionVisitorEx;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectPropertyInverse;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;

enum OWLConstruct {
	AND, OR, OBJECT_NOT, DATA_NOT, OBJECT_ONE_OF, OBJECT_SOME, DATA_SOME, OBJECT_ALL, DATA_ALL, PRIMITIVE, OBJECT_HAS_VALUE, DATA_HAS_VALUE, DATA_MIN, DATA_EXACT, DATA_MAX, OBJECT_MIN, OBJECT_EXACT, OBJECT_MAX, OBJECT_SELF, DATA_ONE_OF, DATA_FACET, DATA_TYPE, DATA_RANGE_RESTRICTION, TYPED_CONSTANT, UNTYPED_CONSTANT, INVERSE, PROPERTY_CHAIN;
	public static OWLConstruct getOWLConstruct(OWLDescription description) {
		return description.accept(new OWLDescriptionVisitorEx<OWLConstruct>() {
			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLClass)
			 */
			public OWLConstruct visit(OWLClass owlClass) {
				return PRIMITIVE;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLDataAllRestriction)
			 */
			public OWLConstruct visit(OWLDataAllRestriction description) {
				return DATA_ALL;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLDataExactCardinalityRestriction )
			 */
			public OWLConstruct visit(OWLDataExactCardinalityRestriction description) {
				return DATA_EXACT;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLDataMaxCardinalityRestriction )
			 */
			public OWLConstruct visit(OWLDataMaxCardinalityRestriction arg0) {
				return DATA_MAX;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLDataMinCardinalityRestriction )
			 */
			public OWLConstruct visit(OWLDataMinCardinalityRestriction arg0) {
				return DATA_MIN;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLDataSomeRestriction)
			 */
			public OWLConstruct visit(OWLDataSomeRestriction arg0) {
				return DATA_SOME;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLDataValueRestriction)
			 */
			public OWLConstruct visit(OWLDataValueRestriction arg0) {
				return DATA_HAS_VALUE;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectAllRestriction)
			 */
			public OWLConstruct visit(OWLObjectAllRestriction arg0) {
				return OBJECT_ALL;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectComplementOf)
			 */
			public OWLConstruct visit(OWLObjectComplementOf arg0) {
				return OBJECT_NOT;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx
			 *      #visit(org.semanticweb.owl.model.
			 *      OWLObjectExactCardinalityRestriction)
			 */
			public OWLConstruct visit(OWLObjectExactCardinalityRestriction arg0) {
				return OBJECT_EXACT;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectIntersectionOf)
			 */
			public OWLConstruct visit(OWLObjectIntersectionOf arg0) {
				return AND;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectMaxCardinalityRestriction )
			 */
			public OWLConstruct visit(OWLObjectMaxCardinalityRestriction arg0) {
				return OBJECT_MAX;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectMinCardinalityRestriction )
			 */
			public OWLConstruct visit(OWLObjectMinCardinalityRestriction arg0) {
				return OBJECT_MIN;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectOneOf)
			 */
			public OWLConstruct visit(OWLObjectOneOf arg0) {
				return OBJECT_ONE_OF;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectSelfRestriction)
			 */
			public OWLConstruct visit(OWLObjectSelfRestriction arg0) {
				return OBJECT_SELF;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectSomeRestriction)
			 */
			public OWLConstruct visit(OWLObjectSomeRestriction arg0) {
				return OBJECT_SOME;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectUnionOf)
			 */
			public OWLConstruct visit(OWLObjectUnionOf arg0) {
				return OR;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDescriptionVisitorEx #visit(org
			 *      .semanticweb.owl.model.OWLObjectValueRestriction)
			 */
			public OWLConstruct visit(OWLObjectValueRestriction arg0) {
				return OBJECT_HAS_VALUE;
			}
		});
	}

	public static OWLConstruct getOWLConstruct(OWLDataRange dataRange) {
		return dataRange.accept(new OWLDataVisitorEx<OWLConstruct>() {
			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataComplementOf)
			 */
			public OWLConstruct visit(OWLDataComplementOf range) {
				return DATA_NOT;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataOneOf)
			 */
			public OWLConstruct visit(OWLDataOneOf range) {
				return DATA_ONE_OF;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataRangeFacetRestriction)
			 */
			public OWLConstruct visit(OWLDataRangeFacetRestriction range) {
				return DATA_FACET;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataRangeRestriction)
			 */
			public OWLConstruct visit(OWLDataRangeRestriction range) {
				return DATA_RANGE_RESTRICTION;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLDataType)
			 */
			public OWLConstruct visit(OWLDataType range) {
				return DATA_TYPE;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLTypedConstant)
			 */
			public OWLConstruct visit(OWLTypedConstant constant) {
				return TYPED_CONSTANT;
			}

			/**
			 * @see org.semanticweb.owl.model.OWLDataVisitorEx#visit(org.semanticweb.owl.model.OWLUntypedConstant)
			 */
			public OWLConstruct visit(OWLUntypedConstant constant) {
				return UNTYPED_CONSTANT;
			}
		});
	}

	public static OWLConstruct getOWLConstruct(OWLDataRangeFacetRestriction facet) {
		return DATA_FACET;
	}

	public static OWLConstruct getOWLConstruct(OWLObjectPropertyInverse inverse) {
		return INVERSE;
	}
}