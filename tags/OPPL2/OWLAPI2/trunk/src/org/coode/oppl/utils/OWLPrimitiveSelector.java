/**
 * 
 */
package org.coode.oppl.utils;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectVisitorEx;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;

/**
 * This class determines if an OWLObject is either an OWLEntity or a an
 * OWLConstant.
 * 
 * @author Luigi Iannone
 * 
 */
public final class OWLPrimitiveSelector {
	private static final OWLObjectVisitorEx<Boolean> allPrimitiveSelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLClass desc) {
			return true;
		}

		@Override
		public Boolean visit(OWLDataProperty property) {
			return true;
		}

		@Override
		public Boolean visit(OWLObjectProperty property) {
			return true;
		}

		@Override
		public Boolean visit(OWLIndividual individual) {
			return true;
		}

		@Override
		public Boolean visit(OWLUntypedConstant constant) {
			return true;
		}

		@Override
		public Boolean visit(OWLTypedConstant constant) {
			return true;
		}

		@Override
		public Boolean visit(OWLDataType node) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLEntitySelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLClass desc) {
			return true;
		}

		@Override
		public Boolean visit(OWLDataProperty property) {
			return true;
		}

		@Override
		public Boolean visit(OWLObjectProperty property) {
			return true;
		}

		@Override
		public Boolean visit(OWLIndividual individual) {
			return true;
		}

		@Override
		public Boolean visit(OWLDataType dataType) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLClassSelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLClass desc) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLDataPropertySelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLDataProperty property) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLObjectPropertySelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLObjectProperty property) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLIndividualSelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLIndividual individual) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLDataTypeSelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLDataType dataType) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLConstantSelector = new DefaultOWLObjectVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLUntypedConstant constant) {
			return true;
		}

		@Override
		public Boolean visit(OWLTypedConstant constant) {
			return true;
		}
	};

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting either an OWLEntity or an OWLConstant.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         either an {@link OWLEntity} or an {@link OWLConstant}
	 */
	public static OWLObjectVisitorEx<Boolean> getAllPrimitiveSelector() {
		return allPrimitiveSelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting either an OWLClass.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLClass}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLClassSelector() {
		return allOWLClassSelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting an {@link OWLDataProperty}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLDataProperty}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLDataPropertySelector() {
		return allOWLDataPropertySelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting either an {@link OWLObjectProperty}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLObjectProperty}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLObjectPropertySelector() {
		return allOWLObjectPropertySelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting an {@link OWLIndividual}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLIndividual}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLIndividualSelector() {
		return allOWLIndividualSelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting an {@link OWLDataType}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLDataType}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLDataTypeSelector() {
		return allOWLDataTypeSelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting an {@link OWLConstant}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLConstant}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLConstantSelector() {
		return allOWLConstantSelector;
	}

	/**
	 * Retrieves an {@link OWLObjectVisitorEx} returning {@code true} if
	 * visiting an {@link OWLEntity}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLEntity}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLEntitySelector() {
		return allOWLEntitySelector;
	}
}
