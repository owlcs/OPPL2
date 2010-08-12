/**
 * 
 */
package org.coode.oppl.utils;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * This class determines if an OWLObject is either an OWLEntity or a an
 * OWLConstant.
 * 
 * @author Luigi Iannone
 * 
 */
public final class OWLPrimitiveSelector {
	private static final OWLObjectVisitorEx<Boolean> allPrimitiveSelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
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
		public Boolean visit(OWLNamedIndividual individual) {
			return true;
		}

		@Override
		public Boolean visit(OWLLiteral constant) {
			return true;
		}

		@Override
		public Boolean visit(OWLDatatype node) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLEntitySelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
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
		public Boolean visit(OWLNamedIndividual individual) {
			return true;
		}

		@Override
		public Boolean visit(OWLDatatype dataType) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLClassSelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
		@Override
		public Boolean visit(OWLClass desc) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLDataPropertySelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
		@Override
		public Boolean visit(OWLDataProperty property) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLObjectPropertySelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
		@Override
		public Boolean visit(OWLObjectProperty property) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLIndividualSelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
		@Override
		public Boolean visit(OWLNamedIndividual individual) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLDatatypeSelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
		@Override
		public Boolean visit(OWLDatatype dataType) {
			return true;
		}
	};
	private static final OWLObjectVisitorEx<Boolean> allOWLConstantSelector = new OWLObjectVisitorExAdapter<Boolean>(
			false) {
		@Override
		public Boolean visit(OWLLiteral constant) {
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
	 * visiting an {@link OWLDatatype}.
	 * 
	 * @return an {@link OWLObjectVisitorEx} returning {@code true} if visiting
	 *         an {@link OWLDatatype}.
	 */
	public static OWLObjectVisitorEx<Boolean> getAllOWLDatatypeSelector() {
		return allOWLDatatypeSelector;
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
