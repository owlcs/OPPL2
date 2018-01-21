package org.coode.parsers.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.Token;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.datafactory.OPPLOWLDataFactory;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.VariableAttribute;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.DefaultTypeVistorEx;
import org.coode.parsers.IRISymbol;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLLiteralSymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Scope;
import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.ValuesVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.VariableAttributeSymbol;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/**
 * @author ignazio
 */
@SuppressWarnings("incomplete-switch")
public class OPPLSymbolTable extends SymbolTable {

    // XXX this hack is due to the impossibility of relating P and O to R and S
    // in OPPLSymbolVisitorEx
    // The previous hack did not work any more on JDK 1.7
    private static class CollectionVisitor<T> implements OPPLSymbolVisitorEx<T> {

        private final OPPLSymbolTable ost;
        private final VariableType<?> type;
        private final OPPLSyntaxTree attributeSyntaxTree;

        CollectionVisitor(OPPLSymbolTable ost, VariableType<?> type,
            OPPLSyntaxTree attributeSyntaxTree) {
            this.ost = ost;
            this.type = type;
            this.attributeSyntaxTree = attributeSyntaxTree;
        }

        @Override
        public T visitSymbol(Symbol symbol) {
            ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            return null;
        }

        @Override
        public T visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
            ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            return null;
        }

        @Override
        public T visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
            ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            return null;
        }

        @Override
        public T visitStringVariableAttributeSymbol(
            StringVariableAttributeSymbol stringVariableAttributeSymbol) {
            ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            return null;
        }

        @Override
        public T visitIRI(IRISymbol iriSymbol) {
            ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            return null;
        }

        @Override
        public <R extends OWLObject, S extends VariableAttribute<Collection<? extends R>>> T visitCollectionVariableAttributeSymbol(
            CollectionVariableAttributeSymbol<R, S> collectionVariableAttributeSymbol) {
            T toReturn = null;
            if (collectionVariableAttributeSymbol.getVariableAttribute().getVariable()
                .getType() == this.type) {
                toReturn = (T) collectionVariableAttributeSymbol;
            } else {
                ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            }
            return toReturn;
        }

        @Override
        public T visitCreateOnDemandIdentifier(CreateOnDemandIdentifier createOnDemandIdentifier) {
            ost.reportIllegalToken(this.attributeSyntaxTree, "Wrong kind of symbol ");
            return null;
        }
    }

    private static class CV<P extends OWLObject, O extends VariableAttribute<Collection<? extends P>>>
        extends CollectionVisitor<CollectionVariableAttributeSymbol<P, O>> {

        CV(OPPLSymbolTable ost, VariableType<?> type, OPPLSyntaxTree attributeSyntaxTree) {
            super(ost, type, attributeSyntaxTree);
        }
    }

    /**
     * @param globalScope globalScope
     * @param dataFactory dataFactory
     */
    public OPPLSymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
        super(globalScope, dataFactory);
    }

    @Override
    public OPPLOWLDataFactory getDataFactory() {
        return new OPPLOWLDataFactory(super.getDataFactory());
    }

    /**
     * Defines a new Symbol in this OPPLSymbolTable under the input Token.
     * 
     * @param token The input token. Cannot be {@code null}.
     * @param symbol The Symbol to be defined. Cannot be {@code null}.
     */
    public void define(Token token, Symbol symbol) {
        this.storeSymbol(checkNotNull(token, "token"), checkNotNull(symbol, "symbol"));
    }

    /**
     * @param identifier identifier
     * @param variableType variableType
     * @param constraintSystem constraintSystem
     */
    public void defineVariable(ManchesterOWLSyntaxTree identifier,
        ManchesterOWLSyntaxTree variableType, ConstraintSystem constraintSystem) {
        VariableTypes type = VariableTypes.getVariableType(variableType.getText());
        if (type == null) {
            reportIllegalToken(variableType, "The variable type is not amongst those recognised");
        } else {
            define(identifier.token, type.getSymbol(getDataFactory(), identifier.token.getText()));
            try {
                constraintSystem.createVariable(identifier.token.getText(),
                    type.getOPPLVariableType(), null);
            } catch (OPPLException e) {
                reportIllegalToken(identifier, "Error in creating variable: " + e.getMessage());
            }
        }
    }

    /**
     * @param parentExpression parentExpression
     * @param classExpression classExpression
     * @return type
     */
    public Type getClassVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
        ManchesterOWLSyntaxTree classExpression) {
        Type toReturn = null;
        if (!OWLType.isClassExpression(classExpression.getEvalType())) {
            reportIncompatibleSymbolType(classExpression, classExpression.getEvalType(),
                parentExpression);
        } else {
            toReturn = classExpression.getEvalType();
        }
        return toReturn;
    }

    /**
     * @param parentExpression parentExpression
     * @param propertyExpression propertyExpression
     * @return type
     */
    public Type getPropertyVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
        ManchesterOWLSyntaxTree propertyExpression) {
        Type toReturn = null;
        if (!OWLType.isPropertyExpression(propertyExpression.getEvalType())) {
            reportIncompatibleSymbolType(propertyExpression, propertyExpression.getEvalType(),
                parentExpression);
        } else {
            toReturn = propertyExpression.getEvalType();
        }
        return toReturn;
    }

    /**
     * @param parentExpression parentExpression
     * @param individualExpression individualExpression
     * @return type
     */
    public Type getIndividualVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
        ManchesterOWLSyntaxTree individualExpression) {
        Type toReturn = null;
        if (OWLType.OWL_INDIVIDUAL != individualExpression.getEvalType()) {
            reportIncompatibleSymbolType(individualExpression, individualExpression.getEvalType(),
                parentExpression);
        } else {
            toReturn = individualExpression.getEvalType();
        }
        return toReturn;
    }

    /**
     * @param parentExpression parentExpression
     * @param variableType variableType
     * @param expression expression
     * @return type
     */
    public Type getExpressionGeneratedVariableType(ManchesterOWLSyntaxTree parentExpression,
        ManchesterOWLSyntaxTree variableType, ManchesterOWLSyntaxTree expression) {
        Type toReturn = null;
        VariableType<?> opplVariableVariableType =
            VariableTypeFactory.getVariableType(variableType.getText());
        if (opplVariableVariableType == null) {
            reportIllegalToken(variableType, "Unknown variable type");
        } else if (expression.getOWLObject() == null) {
            reportIllegalToken(expression, "Null OWL Object in expression");
        } else if (!opplVariableVariableType.isCompatibleWith(expression.getOWLObject())) {
            reportIncompatibleSymbols(parentExpression, variableType, expression);
        } else {
            toReturn = expression.getEvalType();
        }
        return toReturn;
    }

    /**
     * @param variableType variableType
     * @return variable type
     */
    public VariableType<?> getVariableType(ManchesterOWLSyntaxTree variableType) {
        return VariableTypes.getVariableType(variableType.getText()).getOPPLVariableType();
    }

    /**
     * @param variableSyntaxTree variableSyntaxTree
     * @param indexNode indexNode
     * @param constraintSystem constraintSystem
     * @return oppl function
     */
    public OPPLFunction<String> defineGroupAttributeReferenceSymbol(
        final OPPLSyntaxTree variableSyntaxTree, ManchesterOWLSyntaxTree indexNode,
        ConstraintSystem constraintSystem) {
        Variable<?> v = constraintSystem.getVariable(variableSyntaxTree.getText());
        OPPLFunction<String> toReturn = null;
        if (v != null) {
            try {
                final int index = Integer.parseInt(indexNode.getText());
                VariableAttributeSymbol<VariableAttribute<String>> symbol = v.accept(
                    new VariableVisitorEx<VariableAttributeSymbol<VariableAttribute<String>>>() {

                        @Override
                        public <P extends OWLObject> VariableAttributeSymbol<VariableAttribute<String>> visit(
                            InputVariable<P> iv) {
                            OPPLSymbolTable.this.reportIllegalToken(variableSyntaxTree,
                                "The variable has to be a regular expression variable");
                            return null;
                        }

                        @Override
                        public <P extends OWLObject> VariableAttributeSymbol<VariableAttribute<String>> visit(
                            GeneratedVariable<P> iv) {
                            OPPLSymbolTable.this.reportIllegalToken(variableSyntaxTree,
                                "The variable has to be a regular expression variable");
                            return null;
                        }

                        @Override
                        public <P extends OWLObject> VariableAttributeSymbol<VariableAttribute<String>> visit(
                            RegexpGeneratedVariable<P> regExpGenerated) {
                            return StringVariableAttributeSymbol.getGroup(regExpGenerated, index);
                        }
                    });
                if (symbol != null) {
                    this.storeSymbol(symbol.getName(), symbol);
                    toReturn = symbol.getVariableAttribute();
                } else {
                    reportUnrecognisedSymbol(variableSyntaxTree);
                }
            } catch (NumberFormatException e) {
                getErrorListener().reportThrowable(e, indexNode.getLine(),
                    indexNode.getCharPositionInLine(), indexNode.getText().length());
            }
        } else {
            reportUnrecognisedSymbol(variableSyntaxTree);
        }
        return toReturn;
    }

    /**
     * @param variableSyntaxTree variableSyntaxTree
     * @param constraintSystem constraintSystem
     * @return variable attribute
     */
    public VariableAttribute<String> defineRenderingAttributeReferenceSymbol(
        OPPLSyntaxTree variableSyntaxTree, ConstraintSystem constraintSystem) {
        VariableAttribute<String> toReturn = null;
        Variable<?> v = constraintSystem.getVariable(variableSyntaxTree.getText());
        if (v != null) {
            VariableAttributeSymbol<VariableAttribute<String>> symbol =
                StringVariableAttributeSymbol.getRendering(v);
            this.storeSymbol(symbol.getName(), symbol);
            toReturn = symbol.getVariableAttribute();
        } else {
            reportUnrecognisedSymbol(variableSyntaxTree);
        }
        return toReturn;
    }

    /**
     * @param variableSyntaxTree variableSyntaxTree
     * @param constraintSystem constraintSystem
     * @return variable attribute
     */
    public VariableAttribute<?> defineValuesAttributeReferenceSymbol(
        OPPLSyntaxTree variableSyntaxTree, ConstraintSystem constraintSystem) {
        VariableAttribute<?> toReturn = null;
        Variable<?> v = constraintSystem.getVariable(variableSyntaxTree.getText());
        if (v != null) {
            ValuesVariableAtttribute<?> valuesVariableAtttribute =
                ValuesVariableAtttribute.getValuesVariableAtttribute(v);
            ValuesVariableAttributeSymbol<?> symbol = ValuesVariableAttributeSymbol
                .getValuesVariableAttributeSymbol(v.getName(), valuesVariableAtttribute);
            this.storeSymbol(symbol.getName(), symbol);
            toReturn = symbol.getVariableAttribute();
        } else {
            reportUnrecognisedSymbol(variableSyntaxTree);
        }
        return toReturn;
    }

    /**
     * @param parentExpression parentExpression
     * @param variableIdentifier variableIdentifier
     * @param expression expression
     * @param constraintSystem constraintSystem
     * @return inequality constraint
     */
    public InequalityConstraint getInequalityConstraint(OPPLSyntaxTree parentExpression,
        OPPLSyntaxTree variableIdentifier, OPPLSyntaxTree expression,
        ConstraintSystem constraintSystem) {
        Symbol variableSymbol = resolve(variableIdentifier);
        final Type variableType = variableSymbol.getType();
        InequalityConstraint toReturn = null;
        if (variableType == null) {
            reportIncompatibleSymbolType(variableIdentifier, null, parentExpression);
        } else {
            final Type expressionType = expression.getEvalType();
            final boolean compatibleTypes = checkCompatibleTypes(variableType, expressionType);
            if (!compatibleTypes) {
                reportIncompatibleSymbols(parentExpression, variableIdentifier, expression);
            } else {
                Variable<?> variable = constraintSystem.getVariable(variableIdentifier.getText());
                if (variable == null) {
                    reportIllegalToken(variableIdentifier, "Unknown variable");
                } else if (expression.getOWLObject() != null) {
                    toReturn = new InequalityConstraint(variable, expression.getOWLObject(),
                        constraintSystem);
                } else {
                    reportIllegalToken(expression, "No OWL object");
                }
            }
        }
        return toReturn;
    }

    /**
     * @param variableType variableType
     * @param expressionType expressionType
     * @return true if compatible
     */
    private static boolean checkCompatibleTypes(final Type variableType,
        final Type expressionType) {
        return variableType.accept(new DefaultTypeVistorEx<Boolean>() {

            @Override
            protected Boolean doDefault(Type type) {
                return Boolean.FALSE;
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
                        toReturn = OWLType.isObjectPropertyExpression(expressionType);
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
                return Boolean.valueOf(toReturn);
            }
        }).booleanValue();
    }

    /**
     * @param parentExpression parentExpression
     * @param v v
     * @param constraintSystem constraintSystem
     * @param elements elements
     * @return in collection constraint
     */
    public InCollectionConstraint<OWLObject> getInSetConstraint(OPPLSyntaxTree parentExpression,
        OPPLSyntaxTree v, ConstraintSystem constraintSystem, OPPLSyntaxTree... elements) {
        InCollectionConstraint<OWLObject> toReturn = null;
        boolean allCompatible = true;
        if (elements.length > 0) {
            List<OPPLSyntaxTree> incompatibles = new ArrayList<>(elements.length);
            List<OWLObject> owlObjects = new ArrayList<>(elements.length);
            Symbol variableSymbol = resolve(v);
            final Type variableType = variableSymbol.getType();
            for (OPPLSyntaxTree element : elements) {
                Symbol resolvedElement = resolve(element);
                if (resolvedElement == null) {
                    reportUnrecognisedSymbol(element);
                    allCompatible = false;
                }
            }
            if (allCompatible) {
                for (OPPLSyntaxTree element : elements) {
                    Symbol resolvedElement = resolve(element);
                    final boolean isCompatible = resolvedElement != null
                        && checkCompatibleTypes(variableType, resolvedElement.getType())
                        && element.getOWLObject() != null;
                    allCompatible = allCompatible && isCompatible;
                    if (!isCompatible) {
                        incompatibles.add(element);
                    } else {
                        owlObjects.add(element.getOWLObject());
                    }
                }
            }
            if (allCompatible) {
                Variable variable = constraintSystem.getVariable(v.getText());
                if (variable == null) {
                    reportIllegalToken(v, "Unknown variable");
                } else {
                    toReturn = InCollectionConstraint.getInCollectionConstraint(variable,
                        owlObjects, constraintSystem);
                }
            } else if (!incompatibles.isEmpty()) {
                incompatibles.add(0, v);
                reportIncompatibleSymbols(parentExpression,
                    incompatibles.toArray(new OPPLSyntaxTree[incompatibles.size()]));
            }
        } else {
            reportIllegalToken(parentExpression, "Empty set");
        }
        return toReturn;
    }

    /**
     * @param identifier identifier
     * @param constraintSystem constraintSystem
     * @return variable
     */
    public Variable<?> getVariable(OPPLSyntaxTree identifier, ConstraintSystem constraintSystem) {
        Symbol variableSymbol = resolve(identifier);
        Variable<?> toReturn = null;
        if (variableSymbol == null) {
            reportIllegalToken(identifier, "Undefined variable ");
        } else {
            toReturn = constraintSystem.getVariable(variableSymbol.getName());
            if (toReturn == null) {
                reportIllegalToken(identifier,
                    "Undefined variable in the script constraint system");
            }
        }
        return toReturn;
    }

    /**
     * Import all the variables in the input ConstraintSystem into this OPPLSymbolTable.
     * 
     * @param constraintSystem The input constraint system. It cannot be {@code null}.
     * @throws NullPointerException if the input is {@code null}.
     */
    public void importConstraintSystem(ConstraintSystem constraintSystem) {
        Set<Variable<?>> variables = constraintSystem.getVariables();
        for (Variable<?> variable : variables) {
            importVariable(variable);
        }
    }

    private void importVariable(Variable<?> variable) {
        VariableTypes type = VariableTypes.getVariableType(variable.getType().toString());
        Symbol symbol = type.getSymbol(getDataFactory(), variable.getName());
        this.storeSymbol(variable.getName(), symbol);
    }

    /**
     * @param variableAttributeSyntaxTree variableAttributeSyntaxTree
     * @return variable attribute
     */
    public VariableAttribute<String> getStringVariableAttribute(
        final OPPLSyntaxTree variableAttributeSyntaxTree) {
        Symbol symbol = retrieveSymbol(variableAttributeSyntaxTree.getText());
        VariableAttribute<String> toReturn = null;
        if (symbol != null) {
            toReturn = symbol.accept(new OPPLSymbolVisitorEx<VariableAttribute<String>>() {

                @Override
                public VariableAttribute<String> visitSymbol(Symbol s) {
                    OPPLSymbolTable.this.reportIllegalToken(variableAttributeSyntaxTree,
                        "Invalid symbol or variable attribute");
                    return null;
                }

                @Override
                public VariableAttribute<String> visitOWLLiteral(
                    OWLLiteralSymbol owlConstantSymbol) {
                    OPPLSymbolTable.this.reportIllegalToken(variableAttributeSyntaxTree,
                        "Invalid symbol or variable attribute");
                    return null;
                }

                @Override
                public VariableAttribute<String> visitIRI(IRISymbol iriSymbol) {
                    OPPLSymbolTable.this.reportIllegalToken(variableAttributeSyntaxTree,
                        "Invalid symbol or variable attribute");
                    return null;
                }

                @Override
                public VariableAttribute<String> visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                    OPPLSymbolTable.this.reportIllegalToken(variableAttributeSyntaxTree,
                        "Invalid symbol or variable attribute");
                    return null;
                }

                @Override
                public VariableAttribute<String> visitStringVariableAttributeSymbol(
                    StringVariableAttributeSymbol stringVariableAttributeSymbol) {
                    return stringVariableAttributeSymbol.getVariableAttribute();
                }

                @Override
                public <P extends OWLObject, T extends VariableAttribute<Collection<? extends P>>> VariableAttribute<String> visitCollectionVariableAttributeSymbol(
                    CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol) {
                    OPPLSymbolTable.this.reportIllegalToken(variableAttributeSyntaxTree,
                        "Invalid symbol or variable attribute");
                    return null;
                }

                @Override
                public VariableAttribute<String> visitCreateOnDemandIdentifier(
                    CreateOnDemandIdentifier createOnDemandIdentifier) {
                    OPPLSymbolTable.this.reportIllegalToken(variableAttributeSyntaxTree,
                        "Invalid symbol or variable attribute");
                    return null;
                }
            });
        } else {
            reportIllegalToken(variableAttributeSyntaxTree, "Invalid symbol or variable attribute");
        }
        return toReturn;
    }

    /**
     * @param type type
     * @param attributeSyntaxTree attributeSyntaxTree
     * @param <O> variable type
     * @param <P> attribute type
     * @return collection variable
     */
    public <P extends OWLObject, O extends VariableAttribute<Collection<? extends P>>> CollectionVariableAttributeSymbol<P, O> getCollectionVariableAttributeSymbol(
        final VariableType<?> type, final OPPLSyntaxTree attributeSyntaxTree) {
        Symbol symbol = retrieveSymbol(attributeSyntaxTree.getText());
        CollectionVariableAttributeSymbol<P, O> toReturn = null;
        if (symbol != null) {
            toReturn = symbol.accept(new CV<P, O>(this, type, attributeSyntaxTree));
        } else {
            reportUnrecognisedSymbol(attributeSyntaxTree);
        }
        return toReturn;
    }

    /**
     * @param iriTree iriTree
     * @param variableNameTree variableNameTree
     * @param constraintSystem constraintSystem
     */
    public void defineVariableIRI(OPPLSyntaxTree iriTree, OPPLSyntaxTree variableNameTree,
        ConstraintSystem constraintSystem) {
        Symbol toReturn = retrieveSymbol(iriTree.getText());
        if (toReturn == null) {
            String name = variableNameTree.getToken().getText();
            Variable<?> variable = constraintSystem.getVariable(name);
            if (variable != null) {
                toReturn = new IRISymbol(name, new VariableIRI(variable));
                this.storeSymbol(iriTree.getText(), toReturn);
            } else {
                reportUnrecognisedSymbol(variableNameTree);
            }
        }
    }

    /**
     * @param expression expression
     * @param aggregandums aggregandums
     * @param aggregdandumTrees aggregdandumTrees
     * @param constraintSystem constraintSystem
     * @return disjoint axiom
     */
    public OWLAxiom getDisjointAxiom(final OPPLSyntaxTree expression,
        final Collection<? extends Aggregandum<?>> aggregandums,
        final List<OPPLSyntaxTree> aggregdandumTrees, final ConstraintSystem constraintSystem) {
        VariableType<?> aggregandumCollectionType =
            getAggregandumCollectionType(aggregandums, aggregdandumTrees, expression);
        OWLAxiom toReturn = null;
        if (aggregandumCollectionType != null) {
            toReturn = aggregandumCollectionType.accept(new VariableTypeVisitorEx<OWLAxiom>() {

                @Override
                public OWLAxiom visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                    OPPLSymbolTable.this.reportIncompatibleSymbolType(expression,
                        VariableTypes.ANNOTATIONPROPERTY, expression);
                    return null;
                }

                @Override
                public OWLAxiom visitCONSTANTVariableType(
                    CONSTANTVariableType constantVariableType) {
                    OPPLSymbolTable.this.reportIncompatibleSymbolType(expression,
                        VariableTypes.CONSTANT, expression);
                    return null;
                }

                @Override
                public OWLAxiom visitINDIVIDUALVariableType(
                    INDIVIDUALVariableType individualVariableType) {
                    OPPLSymbolTable.this.reportIncompatibleSymbolType(expression,
                        VariableTypes.INDIVIDUAL, expression);
                    return null;
                }

                @Override
                public OWLAxiom visitCLASSVariableType(CLASSVariableType classVariableType) {
                    Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> aggregandumCollection =
                        OPPLSymbolTable.this.getAggregandumCollection(classVariableType,
                            aggregandums, aggregdandumTrees, expression);
                    InlineSet<OWLClassExpression> inlineSet =
                        new InlineSet<>(classVariableType, aggregandumCollection,
                            OPPLSymbolTable.this.getDataFactory(), constraintSystem);
                    return OPPLSymbolTable.this.getDataFactory()
                        .getOWLDisjointClassesAxiom(inlineSet, inlineSet.size() == 2);
                }

                @Override
                public OWLAxiom visitDATAPROPERTYVariableType(
                    DATAPROPERTYVariableType datapropertyVariableType) {
                    Collection<? extends Aggregandum<Collection<? extends OWLDataPropertyExpression>>> aggregandumCollection =
                        OPPLSymbolTable.this.getAggregandumCollection(datapropertyVariableType,
                            aggregandums, aggregdandumTrees, expression);
                    InlineSet<OWLDataPropertyExpression> inlineSet =
                        new InlineSet<>(datapropertyVariableType, aggregandumCollection,
                            OPPLSymbolTable.this.getDataFactory(), constraintSystem);
                    return OPPLSymbolTable.this.getDataFactory()
                        .getOWLDisjointDataPropertiesAxiom(inlineSet, inlineSet.size() == 2);
                }

                @Override
                public OWLAxiom visitOBJECTPROPERTYVariableType(
                    OBJECTPROPERTYVariableType objectpropertyVariableType) {
                    Collection<? extends Aggregandum<Collection<? extends OWLObjectPropertyExpression>>> aggregandumCollection =
                        OPPLSymbolTable.this.getAggregandumCollection(objectpropertyVariableType,
                            aggregandums, aggregdandumTrees, expression);
                    InlineSet<OWLObjectPropertyExpression> inlineSet =
                        new InlineSet<>(objectpropertyVariableType, aggregandumCollection,
                            OPPLSymbolTable.this.getDataFactory(), constraintSystem);
                    return OPPLSymbolTable.this.getDataFactory()
                        .getOWLDisjointObjectPropertiesAxiom(inlineSet, inlineSet.size() == 2);
                }
            });
        } else {
            reportIncompatibleSymbols(expression,
                aggregdandumTrees.toArray(new OPPLSyntaxTree[aggregdandumTrees.size()]));
        }
        return toReturn;
    }

    /**
     * @param variableType variableType
     * @param aggregandums aggregandums
     * @param aggregandumsTrees aggregandumsTrees
     * @param parentExpression parentExpression
     * @param <O> variable type
     * @return aggregandum
     */
    @SuppressWarnings("unchecked")
    public <O extends OWLObject> Collection<? extends Aggregandum<Collection<? extends O>>> getAggregandumCollection(
        VariableType<O> variableType, Collection<? extends Aggregandum<?>> aggregandums,
        List<OPPLSyntaxTree> aggregandumsTrees, OPPLSyntaxTree parentExpression) {
        List<Aggregandum<Collection<? extends O>>> toReturn = new ArrayList<>(aggregandums.size());
        boolean allFine = true;
        Iterator<? extends Aggregandum<?>> iterator = aggregandums.iterator();
        int i = 0;
        while (allFine && iterator.hasNext()) {
            Aggregandum<?> aggregandum = iterator.next();
            allFine = aggregandum.isCompatible(variableType);
            if (allFine) {
                toReturn.add((Aggregandum<Collection<? extends O>>) aggregandum);
            } else {
                OPPLSyntaxTree opplSyntaxTree = aggregandumsTrees.get(i);
                reportIncompatibleSymbolType(opplSyntaxTree, opplSyntaxTree.getEvalType(),
                    parentExpression);
            }
            i++;
        }
        return allFine ? toReturn : null;
    }

    /**
     * @param aggregandums aggregandums
     * @param aggregandumsTrees aggregandumsTrees
     * @param parentExpression parentExpression
     * @return aggregandum collection type
     */
    public VariableType<?> getAggregandumCollectionType(
        Collection<? extends Aggregandum<?>> aggregandums, List<OPPLSyntaxTree> aggregandumsTrees,
        OPPLSyntaxTree parentExpression) {
        VariableType<?> toReturn = null;
        boolean allFine = true;
        Iterator<? extends Aggregandum<?>> iterator = aggregandums.iterator();
        int i = 0;
        while (allFine && iterator.hasNext()) {
            Aggregandum<?> aggregandum = iterator.next();
            VariableType<?> aggregandumVariableType = getAggregandumVariableType(aggregandum);
            allFine = toReturn == null || toReturn.equals(aggregandumVariableType);
            if (allFine) {
                toReturn = aggregandumVariableType;
            } else {
                OPPLSyntaxTree opplSyntaxTree = aggregandumsTrees.get(i);
                reportIncompatibleSymbolType(opplSyntaxTree, opplSyntaxTree.getEvalType(),
                    parentExpression);
            }
            i++;
        }
        return allFine ? toReturn : null;
    }

    private static VariableType<?> getAggregandumVariableType(Aggregandum<?> aggregandum) {
        VariableType<?> toReturn = null;
        Iterator<VariableType<?>> iterator = VariableTypeFactory.getAllVariableTypes().iterator();
        boolean found = false;
        while (!found && iterator.hasNext()) {
            VariableType<?> variableType = iterator.next();
            found = aggregandum.isCompatible(variableType);
            if (found) {
                toReturn = variableType;
            }
        }
        return toReturn;
    }

    /**
     * @param opplSyntaxTree opplSyntaxTree
     * @param list list
     * @param tokenList tokenList
     * @param constraintSystem constraintSystem
     * @return different individual axiom
     */
    public OWLAxiom getDifferentIndividualsAxiom(OPPLSyntaxTree opplSyntaxTree,
        List<Aggregandum<?>> list, List<OPPLSyntaxTree> tokenList,
        ConstraintSystem constraintSystem) {
        OWLAxiom toReturn = null;
        VariableType<?> aggregandumCollectionType =
            getAggregandumCollectionType(list, tokenList, opplSyntaxTree);
        if (aggregandumCollectionType == VariableTypeFactory.getINDIVIDUALVariableType()) {
            Collection<? extends Aggregandum<Collection<? extends OWLIndividual>>> aggregandumCollection =
                this.getAggregandumCollection(VariableTypeFactory.getINDIVIDUALVariableType(), list,
                    tokenList, opplSyntaxTree);
            InlineSet<OWLIndividual> individuals =
                new InlineSet<>(VariableTypeFactory.getINDIVIDUALVariableType(),
                    aggregandumCollection, getDataFactory(), constraintSystem);
            toReturn = getDataFactory().getOWLDifferentIndividualsAxiom(individuals,
                individuals.size() == 2);
        } else {
            reportIncompatibleSymbolType(opplSyntaxTree,
                VariableTypes.getVariableType(aggregandumCollectionType), opplSyntaxTree);
        }
        return toReturn;
    }

    /**
     * @param opplSyntaxTree opplSyntaxTree
     * @param list list
     * @param tokenList tokenList
     * @param constraintSystem constraintSystem
     * @return same individual axiom
     */
    public OWLAxiom getSameIndividualAxiom(OPPLSyntaxTree opplSyntaxTree, List<Aggregandum<?>> list,
        List<OPPLSyntaxTree> tokenList, ConstraintSystem constraintSystem) {
        OWLAxiom toReturn = null;
        VariableType<?> aggregandumCollectionType =
            getAggregandumCollectionType(list, tokenList, opplSyntaxTree);
        if (aggregandumCollectionType == VariableTypeFactory.getINDIVIDUALVariableType()) {
            Collection<? extends Aggregandum<Collection<? extends OWLIndividual>>> aggregandumCollection =
                this.getAggregandumCollection(VariableTypeFactory.getINDIVIDUALVariableType(), list,
                    tokenList, opplSyntaxTree);
            InlineSet<OWLIndividual> individuals =
                new InlineSet<>(VariableTypeFactory.getINDIVIDUALVariableType(),
                    aggregandumCollection, getDataFactory(), constraintSystem);
            toReturn =
                getDataFactory().getOWLSameIndividualAxiom(individuals, individuals.size() == 2);
        } else {
            reportIncompatibleSymbolType(opplSyntaxTree,
                VariableTypes.getVariableType(aggregandumCollectionType), opplSyntaxTree);
        }
        return toReturn;
    }
}
