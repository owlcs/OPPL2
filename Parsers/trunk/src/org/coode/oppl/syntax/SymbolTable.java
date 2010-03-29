package org.coode.oppl.syntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.Token;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLCardinalityRestriction;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyExpression;
import org.semanticweb.owl.model.OWLDataRange;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyExpression;
import org.semanticweb.owl.model.OWLPropertyChain;
import org.semanticweb.owl.model.OWLPropertyChainImpl;
import org.semanticweb.owl.model.OWLQuantifiedRestriction;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;

public class SymbolTable {
	private static abstract class OWLTypeOnlyVisitor implements
			TypeVisitorEx<Boolean> {
		public Boolean visitOWLAxiomType(OWLAxiomType owlAxiomType) {
			return false;
		}
	}

	private static abstract class OWLAxiomTypeOnlyVisitor implements
			TypeVisitorEx<Boolean> {
		public Boolean visitOWLType(OWLType owlType) {
			return false;
		}
	}

	private final OWLEntityCheckerScope globalScope;
	private final OWLDataFactory dataFactory;
	private final Map<Token, Symbol> symbols = new HashMap<Token, Symbol>();
	private ErrorListener errorListener;
	private final OWLTypeOnlyVisitor owlClassTypeDetector = new OWLTypeOnlyVisitor() {
		public Boolean visitOWLType(OWLType owlType) {
			return OWLType.isClassExpression(owlType);
		}
	};
	private final OWLTypeOnlyVisitor owlObjectPropertyTypeDetector = new OWLTypeOnlyVisitor() {
		public Boolean visitOWLType(OWLType owlType) {
			return OWLType.isObjectPropertyExpression(owlType);
		}
	};
	private final OWLTypeOnlyVisitor owlPropertyTypeDetector = new OWLTypeOnlyVisitor() {
		public Boolean visitOWLType(OWLType owlType) {
			return OWLType.isObjectPropertyExpression(owlType)
					|| owlType == OWLType.OWL_DATA_PROPERTY;
		}
	};
	private final OWLAxiomTypeOnlyVisitor simpleAssertionDetector = new OWLAxiomTypeOnlyVisitor() {
		public Boolean visitOWLAxiomType(OWLAxiomType owlAxiomType) {
			return OWLAxiomType.isAssertion(owlAxiomType)
					&& (owlAxiomType == OWLAxiomType.OBJECT_PROPERTY_ASSERTION || owlAxiomType == OWLAxiomType.DATA_PROPERTY_ASSERTION);
		}
	};

	/**
	 * @param globalScope
	 */
	public SymbolTable(OWLEntityCheckerScope globalScope,
			OWLDataFactory dataFactory) {
		if (globalScope == null) {
			throw new NullPointerException("The scope cannot be null");
		}
		if (dataFactory == null) {
			throw new NullPointerException("The data factory cannot be null");
		}
		this.globalScope = globalScope;
		this.dataFactory = dataFactory;
	}

	/**
	 * @return the globalScope
	 */
	public OWLEntityCheckerScope getGlobalScope() {
		return this.globalScope;
	}

	public Symbol resolve(ManchesterOWLSyntaxTree node) {
		Symbol toReturn = this.symbols.get(node.getToken());
		if (toReturn == null) {
			toReturn = this.getGlobalScope().resolve(node.token.getText());
			if (toReturn == null && this.getErrorListener() != null) {
				this.getErrorListener().unrecognisedSymbol(node.token);
			} else if (toReturn != null) {
				this.symbols.put(node.getToken(), toReturn);
			}
		}
		if (toReturn != null) {
			node.setEvalType(toReturn.getType());
			node.setOWLObject(toReturn.accept(new SymbolVisitorEx<OWLObject>() {
				public OWLObject visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
					return owlEntitySymbol.getEntity();
				}

				public OWLObject visitSymbol(Symbol symbol) {
					return null;
				}
			}));
		}
		return toReturn;
	}

	/**
	 * @return the errorListener
	 */
	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	/**
	 * @param errorListener
	 *            the errorListener to set
	 */
	public void setErrorListener(ErrorListener errorListener) {
		this.errorListener = errorListener;
	}

	public Type getSubClassAxiomType(Token token,
			ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
		Type toReturn = null;
		if (subClass.getEvalType() == null
				|| !subClass.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(subClass.token, subClass
					.getEvalType(), token);
		} else if (superClass.getEvalType() == null
				|| !superClass.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(superClass.token, superClass
					.getEvalType(), token);
		} else {
			toReturn = OWLAxiomType.SUBCLASS;
		}
		return toReturn;
	}

	/**
	 * @param token
	 * @param parentExpression
	 * @param toReturn
	 */
	private void reportIncompatibleSymbolType(Token token, Type type,
			Token parentExpression) {
		if (this.getErrorListener() != null) {
			this.getErrorListener().incompatibleSymbolType(token, type,
					parentExpression);
		}
	}

	private void reportIncompatibleSymbols(Token parentExpression,
			Token... tokens) {
		if (this.getErrorListener() != null) {
			this.getErrorListener().incompatibleSymbols(parentExpression,
					tokens);
		}
	}

	private void reportIllegalToken(Token token, String message) {
		if (this.getErrorListener() != null) {
			this.getErrorListener().illegalToken(token, message);
		}
	}

	public Type getDisjunctionType(Token token,
			ManchesterOWLSyntaxTree... disjuncts) {
		boolean allFine = true;
		Type toReturn = null;
		for (ManchesterOWLSyntaxTree disjunct : disjuncts) {
			if (!disjunct.getEvalType().accept(this.owlClassTypeDetector)) {
				allFine = false;
				this.reportIncompatibleSymbolType(disjunct.token, disjunct
						.getEvalType(), token);
			}
		}
		if (allFine) {
			toReturn = OWLType.OWL_OBJECT_UNION_OF;
		}
		return toReturn;
	}

	public Type getConjunctionType(Token token,
			ManchesterOWLSyntaxTree... conjuncts) {
		boolean allFine = true;
		Type toReturn = null;
		for (ManchesterOWLSyntaxTree conjunct : conjuncts) {
			if (conjunct.getEvalType() == null
					|| !conjunct.getEvalType()
							.accept(this.owlClassTypeDetector)) {
				allFine = false;
				this.reportIncompatibleSymbolType(conjunct.token, conjunct
						.getEvalType(), token);
			}
		}
		if (allFine) {
			toReturn = OWLType.OWL_OBJECT_INTERSECTION_OF;
		}
		return toReturn;
	}

	public Type getNegatedClassExpressionType(Token token,
			ManchesterOWLSyntaxTree node) {
		Type toReturn = null;
		if (node.getEvalType() == null
				|| !node.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(node.token, node.getEvalType(),
					token);
		} else {
			toReturn = OWLType.OWL_OBJECT_COMPLEMENT_OF;
		}
		return toReturn;
	}

	public Type getInversePropertyType(Token token,
			ManchesterOWLSyntaxTree property) {
		Type toReturn = null;
		if (property.getEvalType() == null
				|| !property.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(property.token, property
					.getEvalType(), token);
		} else {
			toReturn = OWLType.OWL_OBJECT_INVERSE_PROPERTY;
		}
		return toReturn;
	}

	public Type getSubPropertyAxiomType(Token token,
			ManchesterOWLSyntaxTree subProperty,
			ManchesterOWLSyntaxTree superProperty) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (subProperty.getEvalType() == null
				|| !subProperty.getEvalType().accept(
						this.owlPropertyTypeDetector)
				&& subProperty.getEvalType() != OWLType.OWL_PROPERTY_CHAIN) {
			this.reportIncompatibleSymbolType(subProperty.token, subProperty
					.getEvalType(), token);
			rightKinds = false;
		}
		if (superProperty.getEvalType() == null
				|| !superProperty.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(superProperty.token,
					superProperty.getEvalType(), token);
		}
		boolean areChildrenCompatible = subProperty.getEvalType() == superProperty
				.getEvalType()
				|| subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN
				&& superProperty.getEvalType() == OWLType.OWL_OBJECT_PROPERTY;
		if (rightKinds && areChildrenCompatible) {
			if (areChildrenCompatible) {
				toReturn = subProperty.getEvalType().accept(
						this.owlObjectPropertyTypeDetector) ? OWLAxiomType.SUB_OBJECT_PROPERTY
						: OWLAxiomType.SUB_DATA_PROPERTY;
				// There is a special axiom for property chain sub-property
				toReturn = subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN ? OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY
						: toReturn;
			} else {
				this.reportIncompatibleSymbols(token, subProperty.token,
						superProperty.token);
			}
		} else {
			this.reportIncompatibleSymbols(token, subProperty.token,
					superProperty.token);
		}
		return toReturn;
	}

	public Type getSomeValueRestrictionType(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (filler.getEvalType() == null
				|| !filler.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(filler.token, filler
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_DATA_SOME_RESTRICTION;
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!filler.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_OBJECT_SOME_RESTRICTION;
				}
			}
		}
		return toReturn;
	}

	public Type getAllValueRestrictionType(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_DATA_ALL_RESTRICTION;
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!filler.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_OBJECT_ALL_RESTRICTION;
				}
			}
		}
		return toReturn;
	}

	public Type getMinCardinalityRestrictionType(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler != null
						&& filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_DATA_MIN_CARDINALITY_RESTRICTION;
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (filler != null
						&& !filler.getEvalType().accept(
								this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_OBJECT_MIN_CARDINALITY_RESTRICTION;
				}
			}
		}
		return toReturn;
	}

	public Type getMaxCardinalityRestrictionType(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler != null
						&& filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_DATA_MAX_CARDINALITY_RESTRICTION;
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (filler != null
						&& !filler.getEvalType().accept(
								this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_OBJECT_MAX_CARDINALITY_RESTRICTION;
				}
			}
		}
		return toReturn;
	}

	public Type getExactCardinalityRestrictionType(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler != null
						&& filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_DATA_EXACT_CARDINALITY_RESTRICTION;
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (filler != null
						&& !filler.getEvalType().accept(
								this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = OWLType.OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION;
				}
			}
		}
		return toReturn;
	}

	public Type getOneOfType(Token token,
			ManchesterOWLSyntaxTree... individuals) {
		boolean allFine = true;
		Type toReturn = null;
		for (ManchesterOWLSyntaxTree individual : individuals) {
			if (individual.getEvalType() == null
					|| individual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
				allFine = false;
				this.reportIncompatibleSymbolType(individual.token, individual
						.getEvalType(), token);
			}
		}
		if (allFine) {
			toReturn = OWLType.OWL_OBJECT_ONE_OF;
		}
		return toReturn;
	}

	public Type getValueRestrictionType(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree value) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (value.getEvalType() == null) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (value.getEvalType() != OWLType.OWL_CONSTANT) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, value.token);
				} else {
					toReturn = OWLType.OWL_DATA_VALUE_RESTRICTION;
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (value.getEvalType() != OWLType.OWL_INDIVIDUAL) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, value.token);
				} else {
					toReturn = OWLType.OWL_OBJECT_VALUE_RESTRICTION;
				}
			}
		}
		return toReturn;
	}

	public OWLDescription getValueRestriction(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree value) {
		OWLDescription toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (value.getEvalType() != OWLType.OWL_CONSTANT) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, value.token);
				} else {
					toReturn = this
							.getDataFactory()
							.getOWLDataValueRestriction(
									(OWLDataPropertyExpression) propertyExpression
											.getOWLObject(),
									(OWLConstant) value.getOWLObject());
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (value.getEvalType() != OWLType.OWL_INDIVIDUAL) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, value.token);
				} else {
					toReturn = this
							.getDataFactory()
							.getOWLObjectValueRestriction(
									(OWLObjectPropertyExpression) propertyExpression
											.getOWLObject(),
									(OWLIndividual) value.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public Type getRoleAssertionAxiomType(Token token,
			ManchesterOWLSyntaxTree subject, ManchesterOWLSyntaxTree property,
			ManchesterOWLSyntaxTree object) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (subject.getEvalType() == null
				|| subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			this.reportIncompatibleSymbolType(subject.token, subject
					.getEvalType(), token);
			rightKinds = false;
		}
		if (property.getEvalType() == null
				|| !property.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(property.token, property
					.getEvalType(), token);
			rightKinds = false;
		}
		if (object.getEvalType() == null
				|| object.getEvalType() != OWLType.OWL_INDIVIDUAL
				&& object.getEvalType() != OWLType.OWL_CONSTANT) {
			this.reportIncompatibleSymbolType(object.token, object
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (property.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (object.getEvalType() != OWLType.OWL_INDIVIDUAL) {
					this.reportIncompatibleSymbols(token, property.token,
							object.token);
				} else {
					toReturn = OWLAxiomType.OBJECT_PROPERTY_ASSERTION;
				}
			} else if (property.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (object.getEvalType() != OWLType.OWL_CONSTANT) {
					this.reportIncompatibleSymbols(token, property.token,
							object.token);
				} else {
					toReturn = OWLAxiomType.DATA_PROPERTY_ASSERTION;
				}
			}
		}
		return toReturn;
	}

	public void clear() {
		this.symbols.clear();
	}

	public Type getEquivalentAxiomType(Token token,
			ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (lhs.getEvalType() == null
				|| !lhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !lhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(lhs.token, lhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rhs.getEvalType() == null
				|| !rhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !rhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(rhs.token, rhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (lhs.getEvalType().accept(this.owlClassTypeDetector)) {
				if (!rhs.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.EQUIVALENT_CLASSES;
				}
			} else if (lhs.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!rhs.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES;
				}
			} else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.EQUIVALENT_DATA_PROPERTIES;
				}
			}
		}
		return toReturn;
	}

	public Type getDomainAxiomType(Token token, ManchesterOWLSyntaxTree p,
			ManchesterOWLSyntaxTree domain) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
				&& p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
			rightKinds = false;
		}
		if (domain.getEvalType() == null
				|| !domain.getEvalType().accept(this.owlClassTypeDetector)
				&& domain.getEvalType() != OWLType.OWL_DATA_TYPE) {
			this.reportIncompatibleSymbolType(domain.token, domain
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
				if (!domain.getEvalType().accept(this.owlClassTypeDetector)) {
					this
							.reportIncompatibleSymbols(token, p.token,
									domain.token);
				} else {
					toReturn = OWLAxiomType.OBJECT_PROPERTY_DOMAIN;
				}
			} else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (!domain.getEvalType().accept(this.owlClassTypeDetector)) {
					this
							.reportIncompatibleSymbols(token, p.token,
									domain.token);
				} else {
					toReturn = OWLAxiomType.DATA_PROPERTY_DOMAIN;
				}
			}
		}
		return toReturn;
	}

	public Type getRangeAxiomType(Token token, ManchesterOWLSyntaxTree p,
			ManchesterOWLSyntaxTree range) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
				&& p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
			rightKinds = false;
		}
		if (range.getEvalType() == null
				|| !range.getEvalType().accept(this.owlClassTypeDetector)
				&& range.getEvalType() != OWLType.OWL_DATA_TYPE) {
			this.reportIncompatibleSymbolType(range.token, range.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
				if (!range.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token, p.token, range.token);
				} else {
					toReturn = OWLAxiomType.OBJECT_PROPERTY_RANGE;
				}
			} else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (range.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token, p.token, range.token);
				} else {
					toReturn = OWLAxiomType.DATA_PROPERTY_RANGE;
				}
			}
		}
		return toReturn;
	}

	public Type getPropertyChainType(Token token,
			ManchesterOWLSyntaxTree... chainItems) {
		boolean allFine = true;
		Type toReturn = null;
		for (ManchesterOWLSyntaxTree item : chainItems) {
			if (item.getEvalType() == null
					|| !item.getEvalType().accept(
							this.owlObjectPropertyTypeDetector)) {
				allFine = false;
				this.reportIncompatibleSymbolType(item.token, item
						.getEvalType(), token);
			}
		}
		if (allFine) {
			toReturn = OWLType.OWL_PROPERTY_CHAIN;
		}
		return toReturn;
	}

	public Type getDisjointAxiomType(Token token, ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (lhs.getEvalType() == null
				|| !lhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !lhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(lhs.token, lhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rhs.getEvalType() == null
				|| !rhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !rhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(rhs.token, rhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (lhs.getEvalType().accept(this.owlClassTypeDetector)) {
				if (!rhs.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.DISJOINT_CLASSES;
				}
			} else if (lhs.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!rhs.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.DISJOINT_OBJECT_PROPERTIES;
				}
			} else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.DISJOINT_DATA_PROPERTIES;
				}
			}
		}
		return toReturn;
	}

	public Type getSameIndividualsAxiomType(Token token,
			ManchesterOWLSyntaxTree anIndividual,
			ManchesterOWLSyntaxTree anotherIndividual) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (anIndividual.getEvalType() == null
				|| anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anIndividual.token, anIndividual
					.getEvalType(), token);
		}
		if (anotherIndividual.getEvalType() == null
				|| anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anotherIndividual.token,
					anotherIndividual.getEvalType(), token);
		}
		if (rightKinds) {
			toReturn = OWLAxiomType.SAME_INDIVIDUAL;
		}
		return toReturn;
	}

	public Type getDifferentIndividualsAxiomType(Token token,
			ManchesterOWLSyntaxTree anIndividual,
			ManchesterOWLSyntaxTree anotherIndividual) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (anIndividual.getEvalType() == null
				|| anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anIndividual.token, anIndividual
					.getEvalType(), token);
		}
		if (anotherIndividual.getEvalType() == null
				|| anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anotherIndividual.token,
					anotherIndividual.getEvalType(), token);
		}
		if (rightKinds) {
			toReturn = OWLAxiomType.DIFFERENT_INDIVIDUALS;
		}
		return toReturn;
	}

	public Type getFunctionalPropertyType(Token token, ManchesterOWLSyntaxTree p) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
				&& p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		}
		if (rightKinds) {
			toReturn = p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY ? OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY
					: OWLAxiomType.FUNCTIONAL_DATA_PROPERTY;
		}
		return toReturn;
	}

	public Type getInverseFunctionalPropertyType(Token token,
			ManchesterOWLSyntaxTree p) {
		Type toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY;
		}
		return toReturn;
	}

	public Type getIrreflexivePropertyType(Token token,
			ManchesterOWLSyntaxTree p) {
		Type toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY;
		}
		return toReturn;
	}

	public Type getReflexivePropertyType(Token token, ManchesterOWLSyntaxTree p) {
		Type toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY;
		}
		return toReturn;
	}

	public Type getSymmetricPropertyType(Token token, ManchesterOWLSyntaxTree p) {
		Type toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
		}
		return toReturn;
	}

	public Type getTransitivePropertyType(Token token, ManchesterOWLSyntaxTree p) {
		Type toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY;
		}
		return toReturn;
	}

	public Type getInverseOfAxiomType(Token token, ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (lhs.getEvalType() == null
				|| !lhs.getEvalType()
						.accept(this.owlObjectPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(lhs.token, lhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rhs.getEvalType() == null
				|| !rhs.getEvalType()
						.accept(this.owlObjectPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(rhs.token, rhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (lhs.getEvalType().accept(this.owlObjectPropertyTypeDetector)) {
				if (!rhs.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = OWLAxiomType.INVERSE_OBJECT_PROPERTIES;
				}
			}
		}
		return toReturn;
	}

	public Type getNegatedAssertionType(Token token,
			ManchesterOWLSyntaxTree assertion) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (assertion.getEvalType() == null
				|| !assertion.getEvalType()
						.accept(this.simpleAssertionDetector)) {
			this.reportIncompatibleSymbolType(assertion.token, assertion
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (assertion.getEvalType() == OWLAxiomType.OBJECT_PROPERTY_ASSERTION) {
				toReturn = OWLAxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION;
			} else if (assertion.getEvalType() == OWLAxiomType.DATA_PROPERTY_ASSERTION) {
				toReturn = OWLAxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION;
			}
		}
		return toReturn;
	}

	public Type getClassAssertionAxiomType(Token token,
			ManchesterOWLSyntaxTree description, ManchesterOWLSyntaxTree subject) {
		Type toReturn = null;
		boolean rightKinds = true;
		if (description.getEvalType() == null
				|| !description.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(description.token, description
					.getEvalType(), token);
			rightKinds = false;
		}
		if (subject.getEvalType() == null
				|| subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			this.reportIncompatibleSymbolType(subject.token, subject
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			toReturn = OWLAxiomType.CLASS_ASSERTION;
		}
		return toReturn;
	}

	/**
	 * @return the dataFactory
	 */
	public OWLDataFactory getDataFactory() {
		return this.dataFactory;
	}

	public OWLObject getOneOf(Token token, ManchesterOWLSyntaxTree[] individuals) {
		boolean allFine = true;
		OWLObjectOneOf toReturn = null;
		List<OWLIndividual> individualList = new ArrayList<OWLIndividual>(
				individuals.length);
		for (ManchesterOWLSyntaxTree individual : individuals) {
			if (individual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
				allFine = false;
				this.reportIncompatibleSymbolType(individual.token, individual
						.getEvalType(), token);
			} else {
				individualList.add((OWLIndividual) individual.getOWLObject());
			}
		}
		if (allFine) {
			toReturn = this.getDataFactory().getOWLObjectOneOf(
					individualList.toArray(new OWLIndividual[individualList
							.size()]));
		}
		return toReturn;
	}

	public OWLObject getExactCardinalityRestriction(Token token, int i,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		OWLCardinalityRestriction<?, ?> toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler != null
						&& filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = filler == null ? this
							.getDataFactory()
							.getOWLDataExactCardinalityRestriction(
									(OWLDataPropertyExpression) propertyExpression
											.getOWLObject(), i)
							: this
									.getDataFactory()
									.getOWLDataExactCardinalityRestriction(
											(OWLDataPropertyExpression) propertyExpression
													.getOWLObject(), i,
											(OWLDataRange) filler);
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (filler != null
						&& !filler.getEvalType().accept(
								this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = filler == null ? this
							.getDataFactory()
							.getOWLObjectExactCardinalityRestriction(
									(OWLObjectPropertyExpression) propertyExpression
											.getOWLObject(), i)
							: this
									.getDataFactory()
									.getOWLObjectExactCardinalityRestriction(
											(OWLObjectPropertyExpression) propertyExpression
													.getOWLObject(), i,
											(OWLDescription) filler);
				}
			}
		}
		return toReturn;
	}

	public OWLObject getMaxCardinalityRestriction(Token token, int cardinality,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		OWLCardinalityRestriction<?, ?> toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler != null
						&& filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = filler == null ? this
							.getDataFactory()
							.getOWLDataMaxCardinalityRestriction(
									(OWLDataPropertyExpression) propertyExpression
											.getOWLObject(), cardinality)
							: this
									.getDataFactory()
									.getOWLDataMaxCardinalityRestriction(
											(OWLDataPropertyExpression) propertyExpression
													.getOWLObject(),
											cardinality, (OWLDataRange) filler);
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (filler != null
						&& !filler.getEvalType().accept(
								this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = filler == null ? this
							.getDataFactory()
							.getOWLObjectMaxCardinalityRestriction(
									(OWLObjectPropertyExpression) propertyExpression
											.getOWLObject(), cardinality)
							: this
									.getDataFactory()
									.getOWLObjectMaxCardinalityRestriction(
											(OWLObjectPropertyExpression) propertyExpression
													.getOWLObject(),
											cardinality,
											(OWLDescription) filler);
				}
			}
		}
		return toReturn;
	}

	public OWLObject getMinCardinalityRestriction(Token token, int cardinality,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		OWLCardinalityRestriction<?, ?> toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler != null
						&& filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = filler == null ? this
							.getDataFactory()
							.getOWLDataMinCardinalityRestriction(
									(OWLDataPropertyExpression) propertyExpression
											.getOWLObject(), cardinality)
							: this
									.getDataFactory()
									.getOWLDataMinCardinalityRestriction(
											(OWLDataPropertyExpression) propertyExpression
													.getOWLObject(),
											cardinality, (OWLDataRange) filler);
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (filler != null
						&& !filler.getEvalType().accept(
								this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = filler == null ? this
							.getDataFactory()
							.getOWLObjectMinCardinalityRestriction(
									(OWLObjectPropertyExpression) propertyExpression
											.getOWLObject(), cardinality)
							: this
									.getDataFactory()
									.getOWLObjectMinCardinalityRestriction(
											(OWLObjectPropertyExpression) propertyExpression
													.getOWLObject(),
											cardinality,
											(OWLDescription) filler
													.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLObject getAllValueRestriction(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		OWLQuantifiedRestriction<?, ?> toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = this.getDataFactory().getOWLDataAllRestriction(
							(OWLDataPropertyExpression) propertyExpression,
							(OWLDataRange) filler);
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!filler.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = this
							.getDataFactory()
							.getOWLObjectAllRestriction(
									(OWLObjectPropertyExpression) propertyExpression,
									(OWLDescription) filler);
				}
			}
		}
		return toReturn;
	}

	public OWLObject getSomeValueRestriction(Token token,
			ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		OWLQuantifiedRestriction<?, ?> toReturn = null;
		boolean rightKinds = true;
		if (propertyExpression.getEvalType() == null
				|| !propertyExpression.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(propertyExpression.token,
					propertyExpression.getEvalType(), token);
			rightKinds = false;
		}
		if (filler.getEvalType() == null
				|| !filler.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(filler.token, filler
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = this.getDataFactory().getOWLDataSomeRestriction(
							(OWLDataPropertyExpression) propertyExpression
									.getOWLObject(),
							(OWLDataRange) filler.getOWLObject());
				}
			}
			if (propertyExpression.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!filler.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token,
							propertyExpression.token, filler.token);
				} else {
					toReturn = this
							.getDataFactory()
							.getOWLObjectSomeRestriction(
									(OWLObjectPropertyExpression) propertyExpression
											.getOWLObject(),
									(OWLDescription) filler.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLObject getInverseProperty(Token token,
			ManchesterOWLSyntaxTree property) {
		OWLObjectPropertyExpression toReturn = null;
		if (property.getEvalType() == null
				|| !property.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(property.token, property
					.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory().getOWLObjectPropertyInverse(
					(OWLObjectPropertyExpression) property.getOWLObject());
		}
		return toReturn;
	}

	public OWLEntity getOWLEntity(final ManchesterOWLSyntaxTree node) {
		Symbol symbol = this.symbols.get(node.getToken());
		if (symbol == null) {
			symbol = this.getGlobalScope().resolve(node.token.getText());
			if (symbol == null && this.getErrorListener() != null) {
				this.getErrorListener().unrecognisedSymbol(node.token);
			} else if (symbol != null) {
				this.symbols.put(node.getToken(), symbol);
			}
		}
		OWLEntity toReturn = null;
		if (symbol != null) {
			toReturn = symbol.accept(new SymbolVisitorEx<OWLEntity>() {
				public OWLEntity visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
					return owlEntitySymbol.getEntity();
				}

				public OWLEntity visitSymbol(Symbol symbol) {
					SymbolTable.this.getErrorListener().incompatibleSymbolType(
							node.token, symbol.getType(), node.getToken());
					return null;
				}
			});
		}
		return toReturn;
	}

	public OWLObject getNegatedClassExpression(Token token,
			ManchesterOWLSyntaxTree node) {
		OWLObjectComplementOf toReturn = null;
		if (node.getEvalType() == null
				|| !node.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(node.token, node.getEvalType(),
					token);
		} else {
			toReturn = this.getDataFactory().getOWLObjectComplementOf(
					(OWLDescription) node.getOWLObject());
		}
		return toReturn;
	}

	public OWLTypedConstant getOWLTypedConstant(final Token token,
			final ManchesterOWLSyntaxTree value,
			final ManchesterOWLSyntaxTree constantType) {
		Symbol typeSymbol = this.resolve(constantType);
		OWLTypedConstant toReturn = null;
		if (typeSymbol != null) {
			toReturn = typeSymbol
					.accept(new SymbolVisitorEx<OWLTypedConstant>() {
						public OWLTypedConstant visitSymbol(Symbol symbol) {
							SymbolTable.this.reportIncompatibleSymbolType(
									constantType.token, null, token);
							return null;
						}

						public OWLTypedConstant visitOWLEntity(
								OWLEntitySymbol owlEntitySymbol) {
							OWLTypedConstant toReturn = null;
							if (owlEntitySymbol.getType() == OWLType.OWL_DATA_TYPE) {
								toReturn = SymbolTable.this.getDataFactory()
										.getOWLTypedConstant(
												value.token.getText(),
												(OWLDataType) owlEntitySymbol
														.getEntity());
							}
							return toReturn;
						}
					});
		}
		return toReturn;
	}

	public OWLUntypedConstant getOWLUntypedConstant(Token token,
			ManchesterOWLSyntaxTree value) {
		return value == null ? null : this.getDataFactory()
				.getOWLUntypedConstant(value.getText());
	}

	public OWLDescription getConjunction(Token token,
			ManchesterOWLSyntaxTree[] conjuncts) {
		boolean allFine = true;
		OWLDescription toReturn = null;
		List<OWLDescription> conjunctList = new ArrayList<OWLDescription>(
				conjuncts.length);
		for (ManchesterOWLSyntaxTree conjunct : conjuncts) {
			if (conjunct.getEvalType() == null
					|| !conjunct.getEvalType()
							.accept(this.owlClassTypeDetector)) {
				allFine = false;
				this.reportIncompatibleSymbolType(conjunct.token, conjunct
						.getEvalType(), token);
			} else {
				conjunctList.add((OWLDescription) conjunct.getOWLObject());
			}
		}
		if (allFine) {
			toReturn = this.getDataFactory().getOWLObjectIntersectionOf(
					conjunctList
							.toArray(new OWLDescription[conjunctList.size()]));
		}
		return toReturn;
	}

	public OWLPropertyChain getPropertyChain(Token token,
			ManchesterOWLSyntaxTree[] chainItems) {
		OWLPropertyChain toReturn = null;
		boolean allFine = chainItems.length >= 2;
		if (allFine) {
			List<OWLObjectPropertyExpression> items = new ArrayList<OWLObjectPropertyExpression>(
					chainItems.length);
			for (ManchesterOWLSyntaxTree item : chainItems) {
				if (item.getEvalType() == null
						|| !item.getEvalType().accept(
								this.owlObjectPropertyTypeDetector)) {
					allFine = false;
					this.reportIncompatibleSymbolType(item.token, item
							.getEvalType(), token);
				} else {
					items
							.add((OWLObjectPropertyExpression) item
									.getOWLObject());
				}
			}
			if (allFine) {
				toReturn = items.size() > 2 ? this
						.createOWLPropertyChain(items.get(0), items.get(1),
								items.subList(2, items.size()).toArray(
										new OWLObjectPropertyExpression[items
												.size()])) : this
						.createOWLPropertyChain(items.get(0), items.get(1));
			}
		} else {
			this.reportIllegalToken(token,
					"The property chain contain at least two elements, in fact it contains "
							+ chainItems.length);
		}
		return toReturn;
	}

	protected OWLPropertyChain createOWLPropertyChain(
			OWLObjectPropertyExpression firstPropertyExpression,
			OWLObjectPropertyExpression secondPropertyExpression,
			OWLObjectPropertyExpression... others) {
		List<OWLObjectPropertyExpression> a = new ArrayList<OWLObjectPropertyExpression>(
				Arrays.asList(others));
		a.add(0, secondPropertyExpression);
		a.add(0, firstPropertyExpression);
		return new OWLPropertyChainImpl(a);
	}

	public OWLDescription getDisjunction(Token token,
			ManchesterOWLSyntaxTree[] disjuncts) {
		boolean allFine = true;
		OWLDescription toReturn = null;
		List<OWLDescription> disjunctList = new ArrayList<OWLDescription>(
				disjuncts.length);
		for (ManchesterOWLSyntaxTree disjunct : disjuncts) {
			if (disjunct.getEvalType() == null
					|| !disjunct.getEvalType()
							.accept(this.owlClassTypeDetector)) {
				allFine = false;
				this.reportIncompatibleSymbolType(disjunct.token, disjunct
						.getEvalType(), token);
			} else {
				disjunctList.add((OWLDescription) disjunct.getOWLObject());
			}
		}
		if (allFine) {
			toReturn = this.getDataFactory().getOWLObjectUnionOf(
					disjunctList
							.toArray(new OWLDescription[disjunctList.size()]));
		}
		return toReturn;
	}

	public OWLAxiom getNegatedAssertion(Token token,
			ManchesterOWLSyntaxTree assertion) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (assertion.getEvalType() == null
				|| !assertion.getEvalType()
						.accept(this.simpleAssertionDetector)) {
			this.reportIncompatibleSymbolType(assertion.token, assertion
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (assertion.getEvalType() == OWLAxiomType.OBJECT_PROPERTY_ASSERTION) {
				OWLObjectPropertyAssertionAxiom owlObjectPropertyAssertionAxiom = (OWLObjectPropertyAssertionAxiom) assertion
						.getOWLObject();
				toReturn = this.getDataFactory()
						.getOWLNegativeObjectPropertyAssertionAxiom(
								owlObjectPropertyAssertionAxiom.getSubject(),
								owlObjectPropertyAssertionAxiom.getProperty(),
								owlObjectPropertyAssertionAxiom.getObject());
			} else if (assertion.getEvalType() == OWLAxiomType.DATA_PROPERTY_ASSERTION) {
				OWLDataPropertyAssertionAxiom owlObjectPropertyAssertionAxiom = (OWLDataPropertyAssertionAxiom) assertion;
				toReturn = this.getDataFactory()
						.getOWLNegativeDataPropertyAssertionAxiom(
								owlObjectPropertyAssertionAxiom.getSubject(),
								owlObjectPropertyAssertionAxiom.getProperty(),
								owlObjectPropertyAssertionAxiom.getObject());
			}
		}
		return toReturn;
	}

	public OWLAxiom getTransitiveProperty(Token token, ManchesterOWLSyntaxTree p) {
		OWLTransitiveObjectPropertyAxiom toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory()
					.getOWLTransitiveObjectPropertyAxiom(
							(OWLObjectPropertyExpression) p.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getSymmetricProperty(Token token, ManchesterOWLSyntaxTree p) {
		OWLSymmetricObjectPropertyAxiom toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory()
					.getOWLSymmetricObjectPropertyAxiom(
							(OWLObjectPropertyExpression) p.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getReflexiveProperty(Token token, ManchesterOWLSyntaxTree p) {
		OWLReflexiveObjectPropertyAxiom toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory()
					.getOWLReflexiveObjectPropertyAxiom(
							(OWLObjectPropertyExpression) p.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getIrreflexiveProperty(Token token,
			ManchesterOWLSyntaxTree p) {
		OWLIrreflexiveObjectPropertyAxiom toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory()
					.getOWLIrreflexiveObjectPropertyAxiom(
							(OWLObjectPropertyExpression) p.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getInverseFunctionalProperty(Token token,
			ManchesterOWLSyntaxTree p) {
		OWLInverseFunctionalObjectPropertyAxiom toReturn = null;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory()
					.getOWLInverseFunctionalObjectPropertyAxiom(
							(OWLObjectPropertyExpression) p.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getFunctionalProperty(Token token, ManchesterOWLSyntaxTree p) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
				&& p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
		}
		if (rightKinds) {
			toReturn = p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY ? this
					.getDataFactory().getOWLFunctionalObjectPropertyAxiom(
							(OWLObjectPropertyExpression) p.getOWLObject())
					: this.getDataFactory().getOWLFunctionalDataPropertyAxiom(
							(OWLDataPropertyExpression) p.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getDifferentIndividualsAxiom(Token token,
			ManchesterOWLSyntaxTree anIndividual,
			ManchesterOWLSyntaxTree anotherIndividual) {
		OWLDifferentIndividualsAxiom toReturn = null;
		boolean rightKinds = true;
		if (anIndividual.getEvalType() == null
				|| anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anIndividual.token, anIndividual
					.getEvalType(), token);
		}
		if (anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anotherIndividual.token,
					anotherIndividual.getEvalType(), token);
		}
		if (rightKinds) {
			toReturn = this.getDataFactory().getOWLDifferentIndividualsAxiom(
					(OWLIndividual) anIndividual.getOWLObject(),
					(OWLIndividual) anotherIndividual.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getSameIndividualsAxiom(Token token,
			ManchesterOWLSyntaxTree anIndividual,
			ManchesterOWLSyntaxTree anotherIndividual) {
		OWLSameIndividualsAxiom toReturn = null;
		boolean rightKinds = true;
		if (anIndividual.getEvalType() == null
				|| anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anIndividual.token, anIndividual
					.getEvalType(), token);
		}
		if (anotherIndividual.getEvalType() == null
				|| anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(anotherIndividual.token,
					anotherIndividual.getEvalType(), token);
		}
		if (rightKinds) {
			toReturn = this.getDataFactory().getOWLSameIndividualsAxiom(
					new HashSet<OWLIndividual>(Arrays.asList(
							(OWLIndividual) anIndividual.getOWLObject(),
							(OWLIndividual) anotherIndividual.getOWLObject())));
		}
		return toReturn;
	}

	public OWLAxiom getRangeAxiom(Token token, ManchesterOWLSyntaxTree p,
			ManchesterOWLSyntaxTree range) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
				&& p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
			rightKinds = false;
		}
		if (range.getEvalType() == null
				|| !range.getEvalType().accept(this.owlClassTypeDetector)
				&& range.getEvalType() != OWLType.OWL_DATA_TYPE) {
			this.reportIncompatibleSymbolType(range.token, range.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
				if (!range.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token, p.token, range.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLObjectPropertyRangeAxiom(
									(OWLObjectPropertyExpression) p
											.getOWLObject(),
									(OWLDescription) range.getOWLObject());
				}
			} else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (range.getEvalType() != OWLType.OWL_DATA_TYPE) {
					this.reportIncompatibleSymbols(token, p.token, range.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLDataPropertyRangeAxiom(
									(OWLDataPropertyExpression) p
											.getOWLObject(),
									(OWLDataRange) range.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLAxiom getDomainAxiom(Token token, ManchesterOWLSyntaxTree p,
			ManchesterOWLSyntaxTree domain) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (p.getEvalType() == null
				|| p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
				&& p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
			this.reportIncompatibleSymbolType(p.token, p.getEvalType(), token);
			rightKinds = false;
		}
		if (domain.getEvalType() == null
				|| !domain.getEvalType().accept(this.owlClassTypeDetector)
				&& domain.getEvalType() != OWLType.OWL_DATA_TYPE) {
			this.reportIncompatibleSymbolType(domain.token, domain
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
				if (!domain.getEvalType().accept(this.owlClassTypeDetector)) {
					this
							.reportIncompatibleSymbols(token, p.token,
									domain.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLObjectPropertyDomainAxiom(
									(OWLObjectPropertyExpression) p
											.getOWLObject(),
									(OWLDescription) domain.getOWLObject());
				}
			} else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (!domain.getEvalType().accept(this.owlClassTypeDetector)) {
					this
							.reportIncompatibleSymbols(token, p.token,
									domain.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLDataPropertyDomainAxiom(
									(OWLDataPropertyExpression) p
											.getOWLObject(),
									(OWLDescription) domain.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLAxiom getClassAssertionAxiom(Token token,
			ManchesterOWLSyntaxTree description, ManchesterOWLSyntaxTree subject) {
		OWLClassAssertionAxiom toReturn = null;
		boolean rightKinds = true;
		if (description.getEvalType() == null
				|| !description.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(description.token, description
					.getEvalType(), token);
			rightKinds = false;
		}
		if (subject.getEvalType() == null
				|| subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			this.reportIncompatibleSymbolType(subject.token, subject
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			toReturn = this.getDataFactory().getOWLClassAssertionAxiom(
					(OWLIndividual) subject.getOWLObject(),
					(OWLDescription) description.getOWLObject());
		}
		return toReturn;
	}

	public OWLAxiom getRoleAssertionAxiom(Token token,
			ManchesterOWLSyntaxTree subject, ManchesterOWLSyntaxTree property,
			ManchesterOWLSyntaxTree object) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (subject.getEvalType() == null
				|| subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
			this.reportIncompatibleSymbolType(subject.token, subject
					.getEvalType(), token);
			rightKinds = false;
		}
		if (property.getEvalType() == null
				|| !property.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(property.token, property
					.getEvalType(), token);
			rightKinds = false;
		}
		if (object.getEvalType() == null
				|| object.getEvalType() != OWLType.OWL_INDIVIDUAL
				&& object.getEvalType() != OWLType.OWL_CONSTANT) {
			this.reportIncompatibleSymbolType(object.token, object
					.getEvalType(), token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (property.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (object.getEvalType() != OWLType.OWL_INDIVIDUAL) {
					this.reportIncompatibleSymbols(token, property.token,
							object.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLObjectPropertyAssertionAxiom(
									(OWLIndividual) subject.getOWLObject(),
									(OWLObjectPropertyExpression) property
											.getOWLObject(),
									(OWLIndividual) object.getOWLObject());
				}
			} else if (property.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (object.getEvalType() != OWLType.OWL_CONSTANT) {
					this.reportIncompatibleSymbols(token, property.token,
							object.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLDataPropertyAssertionAxiom(
									(OWLIndividual) subject.getOWLObject(),
									(OWLDataPropertyExpression) property
											.getOWLObject(),
									(OWLConstant) object.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLAxiom getSubPropertyAxiom(Token token,
			ManchesterOWLSyntaxTree subProperty,
			ManchesterOWLSyntaxTree superProperty) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (subProperty.getEvalType() == null
				|| !subProperty.getEvalType().accept(
						this.owlPropertyTypeDetector)
				&& subProperty.getEvalType() != OWLType.OWL_PROPERTY_CHAIN) {
			this.reportIncompatibleSymbolType(subProperty.token, subProperty
					.getEvalType(), token);
			rightKinds = false;
		}
		if (superProperty.getEvalType() == null
				|| !superProperty.getEvalType().accept(
						this.owlPropertyTypeDetector)) {
			rightKinds = false;
			this.reportIncompatibleSymbolType(superProperty.token,
					superProperty.getEvalType(), token);
		}
		boolean areChildrenCompatible = subProperty.getEvalType() == superProperty
				.getEvalType()
				|| subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN
				&& superProperty.getEvalType() == OWLType.OWL_OBJECT_PROPERTY;
		if (rightKinds && areChildrenCompatible) {
			if (areChildrenCompatible) {
				// There is a special axiom for property chain sub-property
				toReturn = subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN ? this
						.getDataFactory()
						.getOWLObjectPropertyChainSubPropertyAxiom(
								(OWLPropertyChain) subProperty.getOWLObject(),
								(OWLObjectPropertyExpression) superProperty
										.getOWLObject())
						: toReturn;
				if (toReturn == null) {
					toReturn = subProperty.getEvalType().accept(
							this.owlObjectPropertyTypeDetector) ? this
							.getDataFactory().getOWLSubObjectPropertyAxiom(
									(OWLObjectPropertyExpression) subProperty
											.getOWLObject(),
									(OWLObjectPropertyExpression) superProperty
											.getOWLObject()) : this
							.getDataFactory().getOWLSubDataPropertyAxiom(
									(OWLDataPropertyExpression) subProperty
											.getOWLObject(),
									(OWLDataPropertyExpression) superProperty
											.getOWLObject());
				}
			} else {
				this.reportIncompatibleSymbols(token, subProperty.token,
						superProperty.token);
			}
		} else {
			this.reportIncompatibleSymbols(token, subProperty.token,
					superProperty.token);
		}
		return toReturn;
	}

	public OWLAxiom getDisjointAxiom(Token token, ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (lhs.getEvalType() == null
				|| !lhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !lhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(lhs.token, lhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rhs.getEvalType() == null
				|| !rhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !rhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(rhs.token, rhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (lhs.getEvalType().accept(this.owlClassTypeDetector)) {
				if (!rhs.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLDisjointClassesAxiom(
									(OWLDescription) lhs.getOWLObject(),
									(OWLDescription) rhs.getOWLObject());
				}
			} else if (lhs.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!rhs.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLDisjointObjectPropertiesAxiom(
									(OWLObjectPropertyExpression) lhs
											.getOWLObject(),
									(OWLObjectPropertyExpression) rhs
											.getOWLObject());
				}
			} else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLDisjointDataPropertiesAxiom(
									(OWLDataPropertyExpression) lhs
											.getOWLObject(),
									(OWLDataPropertyExpression) rhs
											.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLAxiom getInverseOfAxiom(Token token, ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs) {
		OWLInverseObjectPropertiesAxiom toReturn = null;
		boolean rightKinds = true;
		if (lhs.getEvalType() == null
				|| !lhs.getEvalType()
						.accept(this.owlObjectPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(lhs.token, lhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rhs.getEvalType() == null
				|| !rhs.getEvalType()
						.accept(this.owlObjectPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(rhs.token, rhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (lhs.getEvalType().accept(this.owlObjectPropertyTypeDetector)) {
				if (!rhs.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLInverseObjectPropertiesAxiom(
									(OWLObjectPropertyExpression) lhs
											.getOWLObject(),
									(OWLObjectPropertyExpression) rhs
											.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLAxiom getEquivalentAxiom(Token token,
			ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
		OWLAxiom toReturn = null;
		boolean rightKinds = true;
		if (lhs.getEvalType() == null
				|| !lhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !lhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(lhs.token, lhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rhs.getEvalType() == null
				|| !rhs.getEvalType().accept(this.owlClassTypeDetector)
				&& !rhs.getEvalType().accept(this.owlPropertyTypeDetector)) {
			this.reportIncompatibleSymbolType(rhs.token, rhs.getEvalType(),
					token);
			rightKinds = false;
		}
		if (rightKinds) {
			if (lhs.getEvalType().accept(this.owlClassTypeDetector)) {
				if (!rhs.getEvalType().accept(this.owlClassTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLEquivalentClassesAxiom(
									(OWLDescription) lhs.getOWLObject(),
									(OWLDescription) rhs.getOWLObject());
				}
			} else if (lhs.getEvalType().accept(
					this.owlObjectPropertyTypeDetector)) {
				if (!rhs.getEvalType().accept(
						this.owlObjectPropertyTypeDetector)) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLEquivalentObjectPropertiesAxiom(
									(OWLObjectPropertyExpression) lhs
											.getOWLObject(),
									(OWLObjectPropertyExpression) rhs
											.getOWLObject());
				}
			} else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
				if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
					this.reportIncompatibleSymbols(token, lhs.token, rhs.token);
				} else {
					toReturn = this.getDataFactory()
							.getOWLEquivalentDataPropertiesAxiom(
									(OWLDataPropertyExpression) lhs
											.getOWLObject(),
									(OWLDataPropertyExpression) rhs
											.getOWLObject());
				}
			}
		}
		return toReturn;
	}

	public OWLAxiom getSubClassAxiom(Token token,
			ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
		OWLSubClassAxiom toReturn = null;
		if (subClass.getEvalType() == null
				|| !subClass.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(subClass.token, subClass
					.getEvalType(), token);
		} else if (superClass.getEvalType() == null
				|| !superClass.getEvalType().accept(this.owlClassTypeDetector)) {
			this.reportIncompatibleSymbolType(superClass.token, superClass
					.getEvalType(), token);
		} else {
			toReturn = this.getDataFactory().getOWLSubClassAxiom(
					(OWLDescription) subClass.getOWLObject(),
					(OWLDescription) superClass.getOWLObject());
		}
		return toReturn;
	}
}
