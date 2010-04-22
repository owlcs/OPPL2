package org.coode.parsers.oppl;

import java.util.Set;

import org.antlr.runtime.Token;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.OWLEntityCheckerScope;
import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.VariableAttribute;
import org.coode.parsers.oppl.variableattribute.VariableAttributeSymbol;
import org.semanticweb.owl.model.OWLDataFactory;

public class OPPLSymbolTable extends SymbolTable {
	/**
	 * @param globalScope
	 * @param dataFactory
	 */
	public OPPLSymbolTable(OWLEntityCheckerScope globalScope, OWLDataFactory dataFactory) {
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
		VariableType type = VariableType.getVariableType(variableType.getText());
		if (type == null) {
			this.reportIllegalToken(
					variableType,
					"The variable type is not amongst those recognised");
		} else {
			this.define(identifier.token, type.getSymbol(
					this.getDataFactory(),
					identifier.token.getText()));
			Set<Symbol> attributeSymbols = type.getAttributeSymbols(identifier.getText());
			for (Symbol symbol : attributeSymbols) {
				this.storeSymbol(symbol.getName(), symbol);
			}
		}
	}

	public Type getClassVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree classExpression) {
		Type toReturn = null;
		if (!OWLType.isClassExpression(classExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(
					classExpression,
					classExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = classExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getPropertyVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression) {
		Type toReturn = null;
		if (!OWLType.isPropertyExpression(propertyExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(
					propertyExpression,
					propertyExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = propertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getIndividualVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree individualExpression) {
		Type toReturn = null;
		if (OWLType.OWL_INDIVIDUAL != individualExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(
					individualExpression,
					individualExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = individualExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getClassGeneratedVariable(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree classExpression) {
		Type toReturn = null;
		if (!OWLType.isClassExpression(classExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(
					classExpression,
					classExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = classExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getObjectPropertyGeneratedVariable(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree objectPropertyExpression) {
		Type toReturn = null;
		if (!OWLType.isObjectPropertyExpression(objectPropertyExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(
					objectPropertyExpression,
					objectPropertyExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = objectPropertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getDataPropertyGeneratedVariable(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree dataPropertyExpression) {
		Type toReturn = null;
		if (OWLType.OWL_DATA_PROPERTY != dataPropertyExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(
					dataPropertyExpression,
					dataPropertyExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = dataPropertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getIndividualGeneratedVariable(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree individualExpression) {
		Type toReturn = null;
		if (OWLType.OWL_INDIVIDUAL != individualExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(
					individualExpression,
					individualExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = individualExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getConstantGeneratedVariable(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree constantExpression) {
		Type toReturn = null;
		if (OWLType.OWL_CONSTANT != constantExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(
					constantExpression,
					constantExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = constantExpression.getEvalType();
		}
		return toReturn;
	}

	public org.coode.oppl.variablemansyntax.VariableType getVaribaleType(
			ManchesterOWLSyntaxTree variableType) {
		return VariableType.getVariableType(variableType.getText()).getOPPLVariableType();
	}

	public SingleValueGeneratedValue<String> getStringGeneratedValue(
			ManchesterOWLSyntaxTree identifier, final ConstraintSystem constraintSystem) {
		Symbol symbol = this.resolve(identifier);
		return symbol.accept(new OPPLSymbolVisitorEx<SingleValueGeneratedValue<String>>() {
			public SingleValueGeneratedValue<String> visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
				return null;
			}

			public SingleValueGeneratedValue<String> visitSymbol(Symbol symbol) {
				return null;
			}

			public SingleValueGeneratedValue<String> visitStringVariableAttributeSymbol(
					StringVariableAttributeSymbol stringVariableAttributeSymbol) {
				return stringVariableAttributeSymbol.create(constraintSystem);
			}

			public SingleValueGeneratedValue<String> visitCollectionVariableAttributeSymbol(
					CollectionVariableAttributeSymbol<?> collectionVariableAttributeSymbol) {
				return null;
			}
		});
	}

	public void defineGroupAttributeRefernceSymbol(ManchesterOWLSyntaxTree name,
			ManchesterOWLSyntaxTree indexNode) {
		VariableAttributeSymbol<SingleValueGeneratedValue<String>> symbol = VariableAttribute.group(
				Integer.parseInt(indexNode.getText())).getSymbol(name.getText());
		this.storeSymbol(symbol.getName(), symbol);
	}
}
