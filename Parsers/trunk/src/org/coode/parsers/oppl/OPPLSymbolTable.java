package org.coode.parsers.oppl;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.Token;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.parsers.DefaultTypeVistorEx;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.OWLType;
import org.coode.parsers.Scope;
import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.VariableAttribute;
import org.coode.parsers.oppl.variableattribute.VariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.VariableAttributeType;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLObject;

public class OPPLSymbolTable extends SymbolTable {
	/**
	 * @param globalScope
	 * @param dataFactory
	 */
	public OPPLSymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
		super(globalScope, dataFactory);
	}

	/**
	 * Defines a new Symbol in this OPPLSymbolTable under the input Token.
	 * 
	 * @param token
	 *            The input token. Cannot be {@code null}.
	 * @param symbol
	 *            The Symbol to be defined. Cannot be {@code null}.
	 * 
	 */
	public void define(Token token, Symbol symbol) {
		if (token == null) {
			throw new NullPointerException("The token cannot be null");
		}
		if (symbol == null) {
			throw new NullPointerException("The symbol cannot be null");
		}
		this.storeSymbol(token, symbol);
	}

	public void defineVariable(ManchesterOWLSyntaxTree identifier,
			ManchesterOWLSyntaxTree variableType) {
		VariableType type = VariableType
				.getVariableType(variableType.getText());
		if (type == null) {
			this.reportIllegalToken(variableType,
					"The variable type is not amongst those recognised");
		} else {
			this.define(identifier.token, type.getSymbol(this.getDataFactory(),
					identifier.token.getText()));
		}
	}

	public Type getClassVariableScopeType(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree classExpression) {
		Type toReturn = null;
		if (!OWLType.isClassExpression(classExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(classExpression, classExpression
					.getEvalType(), parentExpression);
		} else {
			toReturn = classExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getPropertyVariableScopeType(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression) {
		Type toReturn = null;
		if (!OWLType.isPropertyExpression(propertyExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(propertyExpression,
					propertyExpression.getEvalType(), parentExpression);
		} else {
			toReturn = propertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getIndividualVariableScopeType(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree individualExpression) {
		Type toReturn = null;
		if (OWLType.OWL_INDIVIDUAL != individualExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(individualExpression,
					individualExpression.getEvalType(), parentExpression);
		} else {
			toReturn = individualExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getClassGeneratedVariable(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree classExpression) {
		Type toReturn = null;
		if (!OWLType.isClassExpression(classExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(classExpression, classExpression
					.getEvalType(), parentExpression);
		} else {
			toReturn = classExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getObjectPropertyGeneratedVariable(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree objectPropertyExpression) {
		Type toReturn = null;
		if (!OWLType.isObjectPropertyExpression(objectPropertyExpression
				.getEvalType())) {
			this.reportIncompatibleSymbolType(objectPropertyExpression,
					objectPropertyExpression.getEvalType(), parentExpression);
		} else {
			toReturn = objectPropertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getDataPropertyGeneratedVariable(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree dataPropertyExpression) {
		Type toReturn = null;
		if (OWLType.OWL_DATA_PROPERTY != dataPropertyExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(dataPropertyExpression,
					dataPropertyExpression.getEvalType(), parentExpression);
		} else {
			toReturn = dataPropertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getIndividualGeneratedVariable(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree individualExpression) {
		Type toReturn = null;
		if (OWLType.OWL_INDIVIDUAL != individualExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(individualExpression,
					individualExpression.getEvalType(), parentExpression);
		} else {
			toReturn = individualExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getConstantGeneratedVariable(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree constantExpression) {
		Type toReturn = null;
		if (OWLType.OWL_CONSTANT != constantExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(constantExpression,
					constantExpression.getEvalType(), parentExpression);
		} else {
			toReturn = constantExpression.getEvalType();
		}
		return toReturn;
	}

	public org.coode.oppl.variablemansyntax.VariableType getVaribaleType(
			ManchesterOWLSyntaxTree variableType) {
		return VariableType.getVariableType(variableType.getText())
				.getOPPLVariableType();
	}

	public SingleValueGeneratedValue<String> getStringGeneratedValue(
			ManchesterOWLSyntaxTree identifier,
			final ConstraintSystem constraintSystem) {
		Symbol symbol = this.resolve(identifier);
		return symbol
				.accept(new DefaultOPPLSymbolVisitorEx<SingleValueGeneratedValue<String>>() {
					@Override
					public SingleValueGeneratedValue<String> visitStringVariableAttributeSymbol(
							StringVariableAttributeSymbol stringVariableAttributeSymbol) {
						return stringVariableAttributeSymbol
								.create(constraintSystem);
					}

					@Override
					protected SingleValueGeneratedValue<String> doDefault(
							Symbol symbol) {
						return null;
					}
				});
	}

	public void defineGroupAttributeReferenceSymbol(
			ManchesterOWLSyntaxTree name, ManchesterOWLSyntaxTree indexNode) {
		VariableAttributeSymbol<SingleValueGeneratedValue<String>> symbol = VariableAttribute
				.group(Integer.parseInt(indexNode.getText())).getSymbol(
						name.getText());
		this.storeSymbol(symbol.getName(), symbol);
	}

	public void defineAttributeReferenceSymbol(ManchesterOWLSyntaxTree name,
			ManchesterOWLSyntaxTree attribute) {
		VariableAttribute<?> variableAttribute = VariableAttribute
				.getVariableAttribute(attribute.getText());
		if (variableAttribute == null) {
			this.reportIllegalToken(attribute,
					"Unknown attribute name or illegal use of attribute");
		} else {
			VariableAttributeSymbol<?> symbol = variableAttribute
					.getSymbol(name.getText());
			this.storeSymbol(symbol.getName(), symbol);
		}
	}

	public AbstractCollectionGeneratedValue<OWLClass> getCollection(
			ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree identifier,
			final ConstraintSystem constraintSystem) {
		Symbol resolvedSymbol = this.resolve(identifier);
		AbstractCollectionGeneratedValue<OWLClass> toReturn = null;
		if (resolvedSymbol != null) {
			if (resolvedSymbol.getType() != VariableAttributeType.COLLECTION) {
				this.reportIncompatibleSymbolType(identifier, resolvedSymbol
						.getType(), parentExpression);
			} else {
				resolvedSymbol
						.accept(new DefaultOPPLSymbolVisitorEx<AbstractCollectionGeneratedValue<?>>() {
							@Override
							protected AbstractCollectionGeneratedValue<?> doDefault(
									Symbol symbol) {
								return null;
							}

							@Override
							public AbstractCollectionGeneratedValue<?> visitCollectionVariableAttributeSymbol(
									CollectionVariableAttributeSymbol<?> collectionVariableAttributeSymbol) {
								return collectionVariableAttributeSymbol
										.create(constraintSystem);
							}
						});
			}
		} else {
			this.reportUnrecognisedSymbol(identifier);
		}
		return toReturn;
	}

	public InequalityConstraint getInequalityConstraint(
			OPPLSyntaxTree parentExpression, OPPLSyntaxTree variableIdentifier,
			OPPLSyntaxTree expression, ConstraintSystem constraintSystem) {
		Symbol variableSymbol = this.resolve(variableIdentifier);
		final Type variableType = variableSymbol.getType();
		InequalityConstraint toReturn = null;
		if (variableType == null) {
			this.reportIncompatibleSymbolType(variableIdentifier, null,
					parentExpression);
		} else {
			final Type expressionType = expression.getEvalType();
			final boolean compatibleTypes = this.checkCompatibleTypes(
					variableType, expressionType);
			if (!compatibleTypes) {
				this.reportIncompatibleSymbols(parentExpression,
						variableIdentifier, expression);
			} else {
				Variable variable = constraintSystem
						.getVariable(variableIdentifier.getText());
				if (variable == null) {
					this.reportIllegalToken(variableIdentifier,
							"Unknown variable");
				} else if (expression.getOWLObject() != null) {
					toReturn = new InequalityConstraint(variable, expression
							.getOWLObject(), constraintSystem);
				} else {
					this.reportIllegalToken(expression, "No OWL object");
				}
			}
		}
		return toReturn;
	}

	/**
	 * @param variableType
	 * @param expressionType
	 * @return
	 */
	private boolean checkCompatibleTypes(final Type variableType,
			final Type expressionType) {
		return variableType.accept(new DefaultTypeVistorEx<Boolean>() {
			@Override
			protected Boolean doDefault(Type type) {
				return false;
			}

			@Override
			public Boolean visitOWLType(OWLType owlType) {
				boolean toReturn = false;
				switch (owlType) {
				case OWL_CLASS:
				case OWL_DATA_ALL_RESTRICTION:
				case OWL_DATA_EXACT_CARDINALITY_RESTRICTION:
				case OWL_DATA_MAX_CARDINALITY_RESTRICTION:
				case OWL_DATA_MIN_CARDINALITY_RESTRICTION:
				case OWL_DATA_SOME_RESTRICTION:
				case OWL_DATA_VALUE_RESTRICTION:
				case OWL_OBJECT_ALL_RESTRICTION:
				case OWL_OBJECT_COMPLEMENT_OF:
				case OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION:
				case OWL_OBJECT_INTERSECTION_OF:
				case OWL_OBJECT_MAX_CARDINALITY_RESTRICTION:
				case OWL_OBJECT_MIN_CARDINALITY_RESTRICTION:
				case OWL_OBJECT_ONE_OF:
				case OWL_OBJECT_SELF_RESTRICTION:
				case OWL_OBJECT_SOME_RESTRICTION:
				case OWL_OBJECT_UNION_OF:
				case OWL_OBJECT_VALUE_RESTRICTION:
					toReturn = OWLType.isClassExpression(expressionType);
					break;
				case OWL_OBJECT_PROPERTY:
				case OWL_OBJECT_INVERSE_PROPERTY:
					toReturn = OWLType
							.isObjectPropertyExpression(expressionType);
					break;
				case OWL_DATA_PROPERTY:
					toReturn = OWLType.OWL_DATA_PROPERTY == expressionType;
					break;
				case OWL_INDIVIDUAL:
					toReturn = OWLType.OWL_INDIVIDUAL == expressionType;
					break;
				case OWL_CONSTANT:
					toReturn = OWLType.OWL_CONSTANT == expressionType;
					break;
				default:
					toReturn = false;
				}
				return toReturn;
			}
		});
	}

	public InCollectionConstraint<OWLObject> getInSetConstraint(
			OPPLSyntaxTree parentExpression, OPPLSyntaxTree v,
			ConstraintSystem constraintSystem, OPPLSyntaxTree... elements) {
		InCollectionConstraint<OWLObject> toReturn = null;
		boolean allCompatible = true;
		if (elements.length > 0) {
			List<OPPLSyntaxTree> incompatibles = new ArrayList<OPPLSyntaxTree>(
					elements.length);
			List<OWLObject> owlObjects = new ArrayList<OWLObject>(
					elements.length);
			for (OPPLSyntaxTree element : elements) {
				final boolean isCompatible = this.checkCompatibleTypes(v
						.getEvalType(), element.getEvalType())
						&& element.getOWLObject() != null;
				allCompatible = allCompatible && isCompatible;
				if (!isCompatible) {
					incompatibles.add(element);
					owlObjects.add(element.getOWLObject());
				}
			}
			if (allCompatible) {
				Variable variable = constraintSystem.getVariable(v.getText());
				if (variable == null) {
					this.reportIllegalToken(v, "Unknown variable");
				} else {
					toReturn = new InCollectionConstraint<OWLObject>(variable,
							owlObjects, constraintSystem);
				}
			} else {
				incompatibles.add(0, v);
				this.reportIncompatibleSymbols(parentExpression, incompatibles
						.toArray(new OPPLSyntaxTree[incompatibles.size()]));
			}
		} else {
			this.reportIllegalToken(parentExpression, "Empty set");
		}
		return toReturn;
	}

	public Variable getVariable(OPPLSyntaxTree identifier,
			ConstraintSystem constraintSystem) {
		Symbol variableSymbol = this.resolve(identifier);
		Variable toReturn = null;
		if (variableSymbol == null) {
			this.reportIllegalToken(identifier, "Undefined variable ");
		} else {
			toReturn = constraintSystem.getVariable(variableSymbol.getName());
			if (toReturn == null) {
				this.reportIllegalToken(identifier,
						"Undefined variable in the script constraint system");
			}
		}
		return toReturn;
	}
}
