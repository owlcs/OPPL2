package org.coode.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLPropertyChain;
import org.semanticweb.owlapi.model.OWLPropertyChainImpl;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLQuantifiedRestriction;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
import org.semanticweb.owlapi.vocab.OWLFacet;

public class SymbolTable {
    private static abstract class OWLTypeOnlyVisitor implements TypeVisitorEx<Boolean> {
        @Override
        public Boolean visitOWLAxiomType(OWLAxiomType owlAxiomType) {
            return false;
        }

        @Override
        public Boolean visitNonOWLType(Type type) {
            return false;
        }
    }

    private static abstract class OWLAxiomTypeOnlyVisitor implements
            TypeVisitorEx<Boolean> {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return false;
        }

        @Override
        public Boolean visitNonOWLType(Type type) {
            return false;
        }
    }

    private final Scope globalScope;
    private final OWLDataFactory dataFactory;
    private final Map<String, Symbol> symbols = new HashMap<String, Symbol>();
    private ErrorListener errorListener;
    private final OWLTypeOnlyVisitor owlClassTypeDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isClassExpression(owlType);
        }
    };
    private final OWLTypeOnlyVisitor owlDataTypeExpressionDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isDataTypeExpression(owlType);
        }
    };
    private final OWLTypeOnlyVisitor owlObjectPropertyTypeDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isObjectPropertyExpression(owlType);
        }
    };
    private final OWLTypeOnlyVisitor owlPropertyTypeDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isObjectPropertyExpression(owlType)
                    || owlType == OWLType.OWL_DATA_PROPERTY;
        }
    };
    private final OWLAxiomTypeOnlyVisitor simpleAssertionDetector = new OWLAxiomTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLAxiomType(OWLAxiomType owlAxiomType) {
            return OWLAxiomType.isAssertion(owlAxiomType)
                    && (owlAxiomType == OWLAxiomType.OBJECT_PROPERTY_ASSERTION || owlAxiomType == OWLAxiomType.DATA_PROPERTY_ASSERTION);
        }
    };
    private final OWLTypeOnlyVisitor owlAnnotationObjectTypeDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return owlType == OWLType.OWL_CONSTANT || owlType == OWLType.IRI;
        }
    };

    /** @param globalScope */
    public SymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
        if (globalScope == null) {
            throw new NullPointerException("The scope cannot be null");
        }
        if (dataFactory == null) {
            throw new NullPointerException("The data factory cannot be null");
        }
        this.globalScope = globalScope;
        this.dataFactory = dataFactory;
    }

    /** @return the globalScope */
    public Scope getGlobalScope() {
        return globalScope;
    }

    public Symbol resolve(ManchesterOWLSyntaxTree node) {
        String name = node.getToken().getText();
        Symbol toReturn = retrieveSymbol(name);
        if (toReturn == null) {
            toReturn = getGlobalScope().resolve(name);
            if (toReturn == null && getErrorListener() != null) {
                reportUnrecognisedSymbol(node);
            } else if (toReturn != null) {
                symbols.put(name, toReturn);
            }
        }
        if (toReturn != null) {
            node.setEvalType(toReturn.getType());
            node.setOWLObject(toReturn.accept(new SymbolVisitorEx<OWLObject>() {
                @Override
                public OWLObject visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                    return owlEntitySymbol.getEntity();
                }

                @Override
                public OWLObject visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
                    return owlConstantSymbol.getOWLLiteral();
                }

                @Override
                public OWLObject visitIRI(IRISymbol iriSymbol) {
                    return null;
                }

                @Override
                public OWLObject visitSymbol(Symbol symbol) {
                    return null;
                }
            }));
        }
        return toReturn;
    }

    /** @param name
     * @return */
    protected Symbol retrieveSymbol(String name) {
        return symbols.get(name);
    }

    /** @return the errorListener */
    public ErrorListener getErrorListener() {
        return errorListener;
    }

    /** @param errorListener
     *            the errorListener to set */
    public void setErrorListener(ErrorListener errorListener) {
        this.errorListener = errorListener;
    }

    public Type getSubClassAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
        Type toReturn = null;
        if (subClass.getEvalType() == null
                || !subClass.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(subClass, subClass.getEvalType(), expression);
        } else if (superClass.getEvalType() == null
                || !superClass.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(superClass, superClass.getEvalType(), expression);
        } else {
            toReturn = OWLAxiomType.SUBCLASS;
        }
        return toReturn;
    }

    /** @param tree
     * @param parentExpression
     * @param toReturn */
    protected void reportIncompatibleSymbolType(CommonTree tree, Type type,
            CommonTree parentExpression) {
        if (getErrorListener() != null) {
            getErrorListener().incompatibleSymbolType(tree, type, parentExpression);
        }
    }

    protected void reportIncompatibleSymbols(CommonTree parentExpression,
            CommonTree... expressions) {
        if (getErrorListener() != null) {
            getErrorListener().incompatibleSymbols(parentExpression, expressions);
        }
    }

    public void reportIllegalToken(CommonTree expression, String message) {
        if (getErrorListener() != null) {
            getErrorListener().illegalToken(expression, message);
        }
    }

    public Type getDisjunctionType(CommonTree expression,
            ManchesterOWLSyntaxTree... disjuncts) {
        boolean allFine = true;
        Type toReturn = null;
        Type rest = null;
        for (ManchesterOWLSyntaxTree disjunct : disjuncts) {
            if (disjunct.getEvalType() == null
                    || !isNAryDescriptionCompatible(rest, disjunct.getEvalType())) {
                allFine = allFine && false;
                reportIncompatibleSymbolType(disjunct, disjunct.getEvalType(), expression);
            } else {
                rest = rest == null ? disjunct.getEvalType() : rest;
            }
        }
        if (allFine) {
            toReturn = rest.accept(owlClassTypeDetector) ? OWLType.OWL_OBJECT_INTERSECTION_OF
                    : OWLType.OWL_DATA_UNION_OF;
        }
        return toReturn;
    }

    public Type getConjunctionType(CommonTree expression,
            ManchesterOWLSyntaxTree... conjuncts) {
        boolean allFine = true;
        Type toReturn = null;
        Type rest = null;
        for (ManchesterOWLSyntaxTree conjunct : conjuncts) {
            if (conjunct.getEvalType() == null
                    || !isNAryDescriptionCompatible(rest, conjunct.getEvalType())) {
                allFine = allFine && false;
                reportIncompatibleSymbolType(conjunct, conjunct.getEvalType(), expression);
            } else {
                rest = rest == null ? conjunct.getEvalType() : rest;
            }
        }
        if (allFine) {
            toReturn = rest.accept(owlClassTypeDetector) ? OWLType.OWL_OBJECT_INTERSECTION_OF
                    : OWLType.OWL_DATA_INTERSECTION_OF;
        }
        return toReturn;
    }

    private boolean isNAryDescriptionCompatible(Type rest, Type operandType) {
        // If this is the first one (rest ==null) the it can either a data type
        // or a class expression. Otherwise the type of the rest determines what
        // is expected from the operand type
        return rest == null ? operandType.accept(owlClassTypeDetector)
                || operandType.accept(owlDataTypeExpressionDetector) : rest
                .accept(owlClassTypeDetector)
                && operandType.accept(owlClassTypeDetector)
                || rest.accept(owlDataTypeExpressionDetector)
                && operandType.accept(owlDataTypeExpressionDetector);
    }

    public Type getNegatedClassExpressionType(CommonTree expression,
            ManchesterOWLSyntaxTree node) {
        Type toReturn = null;
        if (node.getEvalType() == null
                || !node.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(node, node.getEvalType(), expression);
        } else {
            toReturn = OWLType.OWL_OBJECT_COMPLEMENT_OF;
        }
        return toReturn;
    }

    public Type getInversePropertyType(CommonTree expression,
            ManchesterOWLSyntaxTree property) {
        Type toReturn = null;
        if (property.getEvalType() == null
                || !property.getEvalType().accept(owlObjectPropertyTypeDetector)) {
            reportIncompatibleSymbolType(property, property.getEvalType(), expression);
        } else {
            toReturn = OWLType.OWL_OBJECT_INVERSE_PROPERTY;
        }
        return toReturn;
    }

    public Type getSubPropertyAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree subProperty, ManchesterOWLSyntaxTree superProperty) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (subProperty.getEvalType() == null
                || !subProperty.getEvalType().accept(owlPropertyTypeDetector)
                && subProperty.getEvalType() != OWLType.OWL_PROPERTY_CHAIN) {
            reportIncompatibleSymbolType(subProperty, subProperty.getEvalType(),
                    expression);
            rightKinds = false;
        }
        if (superProperty.getEvalType() == null
                || !superProperty.getEvalType().accept(owlPropertyTypeDetector)) {
            rightKinds = false;
            reportIncompatibleSymbolType(superProperty, superProperty.getEvalType(),
                    expression);
        }
        boolean areChildrenCompatible = subProperty.getEvalType() == superProperty
                .getEvalType()
                || subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN
                && superProperty.getEvalType() == OWLType.OWL_OBJECT_PROPERTY;
        if (rightKinds && areChildrenCompatible) {
            if (areChildrenCompatible) {
                toReturn = subProperty.getEvalType()
                        .accept(owlObjectPropertyTypeDetector) ? OWLAxiomType.SUB_OBJECT_PROPERTY
                        : OWLAxiomType.SUB_DATA_PROPERTY;
                // There is a special axiom for property chain sub-property
                toReturn = subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN ? OWLAxiomType.PROPERTY_CHAIN_SUB_PROPERTY
                        : toReturn;
            } else {
                reportIncompatibleSymbols(expression, subProperty, superProperty);
            }
        } else {
            reportIncompatibleSymbols(expression, subProperty, superProperty);
        }
        return toReturn;
    }

    public Type getSomeValueRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(owlClassTypeDetector) || filler
                        .getEvalType().accept(owlDataTypeExpressionDetector))) {
            reportIncompatibleSymbolType(filler, filler.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(owlDataTypeExpressionDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_SOME_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_SOME_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    public Type getAllValueRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(owlClassTypeDetector) || filler
                        .getEvalType().accept(owlDataTypeExpressionDetector))) {
            reportIncompatibleSymbolType(filler, filler.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(owlDataTypeExpressionDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_ALL_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_ALL_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    public Type getMinCardinalityRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_MIN_CARDINALITY_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (filler != null
                        && (filler.getEvalType() == null || !filler.getEvalType().accept(
                                owlClassTypeDetector))) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_MIN_CARDINALITY_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    public Type getMaxCardinalityRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_MAX_CARDINALITY_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (filler != null
                        && (filler.getEvalType() == null || !filler.getEvalType().accept(
                                owlClassTypeDetector))) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_MAX_CARDINALITY_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    public Type getExactCardinalityRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_EXACT_CARDINALITY_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (filler != null
                        && (filler.getEvalType() == null || !filler.getEvalType().accept(
                                owlClassTypeDetector))) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    public Type getOneOfType(CommonTree expression,
            ManchesterOWLSyntaxTree... individuals) {
        boolean allFine = true;
        Type toReturn = null;
        for (ManchesterOWLSyntaxTree individual : individuals) {
            if (individual.getEvalType() == null
                    || individual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                allFine = false;
                reportIncompatibleSymbolType(individual, individual.getEvalType(),
                        expression);
            }
        }
        if (allFine) {
            toReturn = OWLType.OWL_OBJECT_ONE_OF;
        }
        return toReturn;
    }

    public Type getValueRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (value.getEvalType() == null) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (value.getEvalType() != OWLType.OWL_CONSTANT) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = OWLType.OWL_DATA_VALUE_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (value.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = OWLType.OWL_OBJECT_VALUE_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    public OWLClassExpression getValueRestriction(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value) {
        OWLClassExpression toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (value.getEvalType() != OWLType.OWL_CONSTANT) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = getDataFactory()
                            .getOWLDataHasValue(
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLLiteral) value.getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (value.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = getDataFactory()
                            .getOWLObjectHasValue(
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLIndividual) value.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public Type getRoleAssertionAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, subject.getEvalType(), expression);
            rightKinds = false;
        }
        if (property.getEvalType() == null
                || !property.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(property, property.getEvalType(), expression);
            rightKinds = false;
        }
        if (object.getEvalType() == null
                || object.getEvalType() != OWLType.OWL_INDIVIDUAL
                && object.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(object, object.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (property.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (object.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, property, object);
                } else {
                    toReturn = OWLAxiomType.OBJECT_PROPERTY_ASSERTION;
                }
            } else if (property.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (object.getEvalType() != OWLType.OWL_CONSTANT) {
                    reportIncompatibleSymbols(expression, property, object);
                } else {
                    toReturn = OWLAxiomType.DATA_PROPERTY_ASSERTION;
                }
            }
        }
        return toReturn;
    }

    public void clear() {
        symbols.clear();
    }

    public Type getEquivalentAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(owlClassTypeDetector)
                && !lhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(lhs, lhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(owlClassTypeDetector)
                && !rhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(rhs, rhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(owlClassTypeDetector)) {
                if (!rhs.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.EQUIVALENT_CLASSES;
                }
            } else if (lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.EQUIVALENT_OBJECT_PROPERTIES;
                }
            } else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.EQUIVALENT_DATA_PROPERTIES;
                }
            }
        }
        return toReturn;
    }

    public Type getDomainAxiomType(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree domain) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
            rightKinds = false;
        }
        if (domain.getEvalType() == null
                || !domain.getEvalType().accept(owlClassTypeDetector)
                && domain.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(domain, domain.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!domain.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = OWLAxiomType.OBJECT_PROPERTY_DOMAIN;
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!domain.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = OWLAxiomType.DATA_PROPERTY_DOMAIN;
                }
            }
        }
        return toReturn;
    }

    public Type getRangeAxiomType(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree range) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
            rightKinds = false;
        }
        if (range.getEvalType() == null
                || !range.getEvalType().accept(owlClassTypeDetector)
                && range.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(range, range.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!range.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, p, range);
                } else {
                    toReturn = OWLAxiomType.OBJECT_PROPERTY_RANGE;
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (range.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, p, range);
                } else {
                    toReturn = OWLAxiomType.DATA_PROPERTY_RANGE;
                }
            }
        }
        return toReturn;
    }

    public Type getPropertyChainType(CommonTree expression,
            ManchesterOWLSyntaxTree... chainItems) {
        boolean allFine = true;
        Type toReturn = null;
        for (ManchesterOWLSyntaxTree item : chainItems) {
            if (item.getEvalType() == null
                    || !item.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                allFine = false;
                reportIncompatibleSymbolType(item, item.getEvalType(), expression);
            }
        }
        if (allFine) {
            toReturn = OWLType.OWL_PROPERTY_CHAIN;
        }
        return toReturn;
    }

    public Type getDisjointAxiomType(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(owlClassTypeDetector)
                && !lhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(lhs, lhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(owlClassTypeDetector)
                && !rhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(rhs, rhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(owlClassTypeDetector)) {
                if (!rhs.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.DISJOINT_CLASSES;
                }
            } else if (lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.DISJOINT_OBJECT_PROPERTIES;
                }
            } else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.DISJOINT_DATA_PROPERTIES;
                }
            }
        }
        return toReturn;
    }

    public Type getSameIndividualsAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, anIndividual.getEvalType(),
                    expression);
        }
        if (anotherIndividual.getEvalType() == null
                || anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual,
                    anotherIndividual.getEvalType(), expression);
        }
        if (rightKinds) {
            toReturn = OWLAxiomType.SAME_INDIVIDUAL;
        }
        return toReturn;
    }

    public Type getDifferentIndividualsAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, anIndividual.getEvalType(),
                    expression);
        }
        if (anotherIndividual.getEvalType() == null
                || anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual,
                    anotherIndividual.getEvalType(), expression);
        }
        if (rightKinds) {
            toReturn = OWLAxiomType.DIFFERENT_INDIVIDUALS;
        }
        return toReturn;
    }

    public Type
            getFunctionalPropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            rightKinds = false;
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        }
        if (rightKinds) {
            toReturn = p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY ? OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY
                    : OWLAxiomType.FUNCTIONAL_DATA_PROPERTY;
        }
        return toReturn;
    }

    public Type getInverseFunctionalPropertyType(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY;
        }
        return toReturn;
    }

    public Type getIrreflexivePropertyType(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY;
        }
        return toReturn;
    }

    public Type
            getReflexivePropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY;
        }
        return toReturn;
    }

    public Type
            getSymmetricPropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
        }
        return toReturn;
    }

    public Type
            getTransitivePropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY;
        }
        return toReturn;
    }

    public Type getInverseOfAxiomType(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null
                || !lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
            reportIncompatibleSymbolType(lhs, lhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null
                || !rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
            reportIncompatibleSymbolType(rhs, rhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.INVERSE_OBJECT_PROPERTIES;
                }
            }
        }
        return toReturn;
    }

    public Type getNegatedAssertionType(CommonTree expression,
            ManchesterOWLSyntaxTree assertion) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (assertion.getEvalType() == null
                || !assertion.getEvalType().accept(simpleAssertionDetector)) {
            reportIncompatibleSymbolType(assertion, assertion.getEvalType(), expression);
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

    public Type getClassAssertionAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree description, ManchesterOWLSyntaxTree subject) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (description.getEvalType() == null
                || !description.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(description, description.getEvalType(),
                    expression);
            rightKinds = false;
        }
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, subject.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            toReturn = OWLAxiomType.CLASS_ASSERTION;
        }
        return toReturn;
    }

    /** @return the dataFactory */
    public OWLDataFactory getDataFactory() {
        return dataFactory;
    }

    public OWLObject
            getOneOf(CommonTree expression, ManchesterOWLSyntaxTree[] individuals) {
        boolean allFine = true;
        OWLObjectOneOf toReturn = null;
        List<OWLIndividual> individualList = new ArrayList<OWLIndividual>(
                individuals.length);
        for (ManchesterOWLSyntaxTree individual : individuals) {
            if (individual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                allFine = false;
                reportIncompatibleSymbolType(individual, individual.getEvalType(),
                        expression);
            } else {
                individualList.add((OWLIndividual) individual.getOWLObject());
            }
        }
        if (allFine) {
            toReturn = getDataFactory().getOWLObjectOneOf(
                    individualList.toArray(new OWLIndividual[individualList.size()]));
        }
        return toReturn;
    }

    public OWLObject getExactCardinalityRestriction(CommonTree expression, int i,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLCardinalityRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? getDataFactory()
                            .getOWLDataExactCardinality(
                                    i,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject()) : getDataFactory()
                            .getOWLDataExactCardinality(
                                    i,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLDataRange) filler.getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (filler != null && !filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? getDataFactory()
                            .getOWLObjectExactCardinality(
                                    i,
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject()) : getDataFactory()
                            .getOWLObjectExactCardinality(
                                    i,
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLClassExpression) filler.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLObject getMaxCardinalityRestriction(CommonTree expression, int cardinality,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLCardinalityRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? getDataFactory()
                            .getOWLDataMaxCardinality(
                                    cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject()) : getDataFactory()
                            .getOWLDataMaxCardinality(
                                    cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLDataRange) filler.getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (filler != null && !filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? getDataFactory()
                            .getOWLObjectMaxCardinality(
                                    cardinality,
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject()) : getDataFactory()
                            .getOWLObjectMaxCardinality(
                                    cardinality,
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLClassExpression) filler.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLObject getMinCardinalityRestriction(CommonTree expression, int cardinality,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLCardinalityRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? getDataFactory()
                            .getOWLDataMinCardinality(
                                    cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject()) : getDataFactory()
                            .getOWLDataMinCardinality(
                                    cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLDataRange) filler.getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (filler != null && !filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? getDataFactory()
                            .getOWLObjectMinCardinality(
                                    cardinality,
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject()) : getDataFactory()
                            .getOWLObjectMinCardinality(
                                    cardinality,
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLClassExpression) filler.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLObject getAllValueRestriction(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLQuantifiedRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(owlClassTypeDetector) || filler
                        .getEvalType().accept(owlDataTypeExpressionDetector))) {
            reportIncompatibleSymbolType(filler, filler.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(owlDataTypeExpressionDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = getDataFactory().getOWLDataAllValuesFrom(
                            (OWLDataPropertyExpression) propertyExpression,
                            (OWLDataRange) filler);
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = getDataFactory()
                            .getOWLObjectAllValuesFrom(
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLClassExpression) filler.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLObject getSomeValueRestriction(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLQuantifiedRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(propertyExpression,
                    propertyExpression.getEvalType(), expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(owlClassTypeDetector) || filler
                        .getEvalType().accept(owlDataTypeExpressionDetector))) {
            reportIncompatibleSymbolType(filler, filler.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(owlDataTypeExpressionDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = getDataFactory()
                            .getOWLDataSomeValuesFrom(
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLDataRange) filler.getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!filler.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = getDataFactory()
                            .getOWLObjectSomeValuesFrom(
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(),
                                    (OWLClassExpression) filler.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLObject getInverseProperty(CommonTree expression,
            ManchesterOWLSyntaxTree property) {
        OWLObjectPropertyExpression toReturn = null;
        if (property.getEvalType() == null
                || !property.getEvalType().accept(owlObjectPropertyTypeDetector)) {
            reportIncompatibleSymbolType(property, property.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLObjectInverseOf(
                    (OWLObjectPropertyExpression) property.getOWLObject());
        }
        return toReturn;
    }

    public OWLObject getOWLObject(final ManchesterOWLSyntaxTree node) {
        Symbol symbol = symbols.get(node.getToken().getText());
        if (symbol == null) {
            symbol = getGlobalScope().resolve(node.getToken().getText());
            if (symbol == null && getErrorListener() != null) {
                reportUnrecognisedSymbol(node);
            } else if (symbol != null) {
                symbols.put(node.getToken().getText(), symbol);
            }
        }
        OWLObject toReturn = null;
        if (symbol != null) {
            toReturn = symbol.accept(new SymbolVisitorEx<OWLObject>() {
                @Override
                public OWLEntity visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                    return owlEntitySymbol.getEntity();
                }

                @Override
                public OWLLiteral visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
                    return owlConstantSymbol.getOWLLiteral();
                }

                @Override
                public OWLObject visitIRI(IRISymbol iriSymbol) {
                    return iriSymbol.getIRI();
                }

                @Override
                public OWLEntity visitSymbol(Symbol symbol) {
                    SymbolTable.this.reportIncompatibleSymbolType(node, symbol.getType(),
                            node);
                    return null;
                }
            });
        }
        return toReturn;
    }

    /** @param node */
    protected void reportUnrecognisedSymbol(ManchesterOWLSyntaxTree node) {
        if (getErrorListener() != null) {
            getErrorListener().unrecognisedSymbol(node);
        }
    }

    public OWLObject getNegatedClassExpression(CommonTree expression,
            ManchesterOWLSyntaxTree node) {
        OWLObjectComplementOf toReturn = null;
        if (node.getEvalType() == null
                || !node.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(node, node.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLObjectComplementOf(
                    (OWLClassExpression) node.getOWLObject());
        }
        return toReturn;
    }

    public OWLLiteral getOWLTypedConstant(final CommonTree expression,
            final ManchesterOWLSyntaxTree value,
            final ManchesterOWLSyntaxTree constantType) {
        Symbol typeSymbol = resolve(constantType);
        OWLLiteral toReturn = null;
        if (typeSymbol != null) {
            toReturn = typeSymbol.accept(new SymbolVisitorEx<OWLLiteral>() {
                @Override
                public OWLLiteral visitSymbol(Symbol symbol) {
                    SymbolTable.this.reportIncompatibleSymbolType(constantType, null,
                            expression);
                    return null;
                }

                @Override
                public OWLLiteral visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
                    SymbolTable.this.reportIncompatibleSymbolType(constantType, null,
                            expression);
                    return null;
                }

                @Override
                public OWLLiteral visitIRI(IRISymbol iriSymbol) {
                    return null;
                }

                @Override
                public OWLLiteral visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                    OWLLiteral toReturn = null;
                    if (owlEntitySymbol.getType() == OWLType.OWL_DATA_TYPE) {
                        toReturn = SymbolTable.this.getDataFactory().getOWLLiteral(
                                value.getToken().getText(),
                                (OWLDatatype) owlEntitySymbol.getEntity());
                    }
                    return toReturn;
                }
            });
        } else {
            errorListener.illegalToken(constantType,
                    "The type is not amongst the available ones");
        }
        return toReturn;
    }

    public OWLLiteral getOWLUntypedConstant(CommonTree expression,
            ManchesterOWLSyntaxTree value, ManchesterOWLSyntaxTree lang) {
        return value == null ? null : lang == null ? getDataFactory().getOWLLiteral(
                value.getText()) : getDataFactory().getOWLLiteral(value.getText(),
                lang.getText());
    }

    public OWLObject getConjunction(CommonTree expression,
            ManchesterOWLSyntaxTree[] conjuncts) {
        boolean allFine = true;
        OWLObject toReturn = null;
        List<OWLClassExpression> conjunctList = new ArrayList<OWLClassExpression>(
                conjuncts.length);
        List<OWLDataRange> owlDataRangeList = new ArrayList<OWLDataRange>(
                conjuncts.length);
        Type rest = null;
        for (ManchesterOWLSyntaxTree conjunct : conjuncts) {
            if (conjunct.getEvalType() == null
                    || !isNAryDescriptionCompatible(rest, conjunct.getEvalType())) {
                allFine = allFine && false;
                reportIncompatibleSymbolType(conjunct, conjunct.getEvalType(), expression);
            } else {
                rest = rest == null ? conjunct.getEvalType() : rest;
                if (rest.accept(owlClassTypeDetector)) {
                    conjunctList.add((OWLClassExpression) conjunct.getOWLObject());
                } else {
                    owlDataRangeList.add((OWLDataRange) conjunct.getOWLObject());
                }
            }
        }
        if (allFine) {
            if (rest.accept(owlClassTypeDetector)) {
                toReturn = getDataFactory()
                        .getOWLObjectIntersectionOf(
                                conjunctList.toArray(new OWLClassExpression[conjunctList
                                        .size()]));
            } else {
                toReturn = getDataFactory()
                        .getOWLDataIntersectionOf(
                                owlDataRangeList
                                        .toArray(new OWLDataRange[owlDataRangeList.size()]));
            }
        }
        return toReturn;
    }

    public OWLPropertyChain getPropertyChain(CommonTree expression,
            ManchesterOWLSyntaxTree[] chainItems) {
        OWLPropertyChain toReturn = null;
        boolean allFine = chainItems.length >= 2;
        if (allFine) {
            List<OWLObjectPropertyExpression> items = new ArrayList<OWLObjectPropertyExpression>(
                    chainItems.length);
            for (ManchesterOWLSyntaxTree item : chainItems) {
                if (item.getEvalType() == null
                        || !item.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    allFine = false;
                    reportIncompatibleSymbolType(item, item.getEvalType(), expression);
                } else {
                    items.add((OWLObjectPropertyExpression) item.getOWLObject());
                }
            }
            if (allFine) {
                toReturn = items.size() > 2 ? createOWLPropertyChain(
                        items.get(0),
                        items.get(1),
                        items.subList(2, items.size()).toArray(
                                new OWLObjectPropertyExpression[items.size()]))
                        : createOWLPropertyChain(items.get(0), items.get(1));
            }
        } else {
            reportIllegalToken(expression,
                    "The property chain contain at least two elements, in fact it contains "
                            + chainItems.length);
        }
        return toReturn;
    }

    protected org.semanticweb.owlapi.model.OWLPropertyChain createOWLPropertyChain(
            OWLObjectPropertyExpression firstPropertyExpression,
            OWLObjectPropertyExpression secondPropertyExpression,
            OWLObjectPropertyExpression... others) {
        List<OWLObjectPropertyExpression> a = new ArrayList<OWLObjectPropertyExpression>(
                Arrays.asList(others));
        a.add(0, secondPropertyExpression);
        a.add(0, firstPropertyExpression);
        return new OWLPropertyChainImpl(a);
    }

    public OWLObject getDisjunction(CommonTree expression,
            ManchesterOWLSyntaxTree[] disjuncts) {
        boolean allFine = true;
        OWLObject toReturn = null;
        List<OWLClassExpression> disjunctList = new ArrayList<OWLClassExpression>(
                disjuncts.length);
        List<OWLDataRange> owlDataRangeList = new ArrayList<OWLDataRange>(
                disjuncts.length);
        Type rest = null;
        for (ManchesterOWLSyntaxTree disjunct : disjuncts) {
            if (disjunct.getEvalType() == null
                    || !isNAryDescriptionCompatible(rest, disjunct.getEvalType())) {
                allFine = allFine && false;
                reportIncompatibleSymbolType(disjunct, disjunct.getEvalType(), expression);
            } else {
                rest = rest == null ? disjunct.getEvalType() : rest;
                if (rest.accept(owlClassTypeDetector)) {
                    disjunctList.add((OWLClassExpression) disjunct.getOWLObject());
                } else {
                    owlDataRangeList.add((OWLDataRange) disjunct.getOWLObject());
                }
            }
        }
        if (allFine) {
            if (rest.accept(owlClassTypeDetector)) {
                toReturn = getDataFactory()
                        .getOWLObjectUnionOf(
                                disjunctList.toArray(new OWLClassExpression[disjunctList
                                        .size()]));
            } else {
                toReturn = getDataFactory()
                        .getOWLDataUnionOf(
                                owlDataRangeList
                                        .toArray(new OWLDataRange[owlDataRangeList.size()]));
            }
        }
        return toReturn;
    }

    public OWLAxiom getNegatedAssertion(CommonTree expression,
            ManchesterOWLSyntaxTree assertion) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (assertion.getEvalType() == null
                || !assertion.getEvalType().accept(simpleAssertionDetector)) {
            reportIncompatibleSymbolType(assertion, assertion.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (assertion.getEvalType() == OWLAxiomType.OBJECT_PROPERTY_ASSERTION) {
                OWLObjectPropertyAssertionAxiom owlObjectPropertyAssertionAxiom = (OWLObjectPropertyAssertionAxiom) assertion
                        .getOWLObject();
                toReturn = getDataFactory().getOWLNegativeObjectPropertyAssertionAxiom(
                        owlObjectPropertyAssertionAxiom.getProperty(),
                        owlObjectPropertyAssertionAxiom.getSubject(),
                        owlObjectPropertyAssertionAxiom.getObject());
            } else if (assertion.getEvalType() == OWLAxiomType.DATA_PROPERTY_ASSERTION) {
                OWLDataPropertyAssertionAxiom owlObjectPropertyAssertionAxiom = (OWLDataPropertyAssertionAxiom) assertion
                        .getOWLObject();
                toReturn = getDataFactory().getOWLNegativeDataPropertyAssertionAxiom(
                        owlObjectPropertyAssertionAxiom.getProperty(),
                        owlObjectPropertyAssertionAxiom.getSubject(),
                        owlObjectPropertyAssertionAxiom.getObject());
            }
        }
        return toReturn;
    }

    public OWLAxiom
            getTransitiveProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        OWLTransitiveObjectPropertyAxiom toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLTransitiveObjectPropertyAxiom(
                    (OWLObjectPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom
            getSymmetricProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        OWLSymmetricObjectPropertyAxiom toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLSymmetricObjectPropertyAxiom(
                    (OWLObjectPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom
            getAsymmetricProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        OWLAsymmetricObjectPropertyAxiom toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLAsymmetricObjectPropertyAxiom(
                    (OWLObjectPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom
            getReflexiveProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        OWLReflexiveObjectPropertyAxiom toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLReflexiveObjectPropertyAxiom(
                    (OWLObjectPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom getIrreflexiveProperty(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        OWLIrreflexiveObjectPropertyAxiom toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLIrreflexiveObjectPropertyAxiom(
                    (OWLObjectPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom getInverseFunctionalProperty(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        OWLInverseFunctionalObjectPropertyAxiom toReturn = null;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLInverseFunctionalObjectPropertyAxiom(
                    (OWLObjectPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom
            getFunctionalProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            rightKinds = false;
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
        }
        if (rightKinds) {
            toReturn = p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY ? getDataFactory()
                    .getOWLFunctionalObjectPropertyAxiom(
                            (OWLObjectPropertyExpression) p.getOWLObject())
                    : getDataFactory().getOWLFunctionalDataPropertyAxiom(
                            (OWLDataPropertyExpression) p.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom getDifferentIndividualsAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        OWLDifferentIndividualsAxiom toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, anIndividual.getEvalType(),
                    expression);
        }
        if (anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual,
                    anotherIndividual.getEvalType(), expression);
        }
        if (rightKinds) {
            toReturn = getDataFactory().getOWLDifferentIndividualsAxiom(
                    (OWLIndividual) anIndividual.getOWLObject(),
                    (OWLIndividual) anotherIndividual.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom getSameIndividualsAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        OWLSameIndividualAxiom toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, anIndividual.getEvalType(),
                    expression);
        }
        if (anotherIndividual.getEvalType() == null
                || anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual,
                    anotherIndividual.getEvalType(), expression);
        }
        if (rightKinds) {
            toReturn = getDataFactory().getOWLSameIndividualAxiom(
                    new HashSet<OWLIndividual>(Arrays.asList(
                            (OWLIndividual) anIndividual.getOWLObject(),
                            (OWLIndividual) anotherIndividual.getOWLObject())));
        }
        return toReturn;
    }

    public OWLAxiom getRangeAxiom(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree range) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
            rightKinds = false;
        }
        if (range.getEvalType() == null
                || !range.getEvalType().accept(owlClassTypeDetector)
                && range.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(range, range.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!range.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, p, range);
                } else {
                    toReturn = getDataFactory().getOWLObjectPropertyRangeAxiom(
                            (OWLObjectPropertyExpression) p.getOWLObject(),
                            (OWLClassExpression) range.getOWLObject());
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (range.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, p, range);
                } else {
                    toReturn = getDataFactory().getOWLDataPropertyRangeAxiom(
                            (OWLDataPropertyExpression) p.getOWLObject(),
                            (OWLDataRange) range.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLAxiom getDomainAxiom(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree domain) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, p.getEvalType(), expression);
            rightKinds = false;
        }
        if (domain.getEvalType() == null
                || !domain.getEvalType().accept(owlClassTypeDetector)
                && domain.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(domain, domain.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!domain.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = getDataFactory().getOWLObjectPropertyDomainAxiom(
                            (OWLObjectPropertyExpression) p.getOWLObject(),
                            (OWLClassExpression) domain.getOWLObject());
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!domain.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = getDataFactory().getOWLDataPropertyDomainAxiom(
                            (OWLDataPropertyExpression) p.getOWLObject(),
                            (OWLClassExpression) domain.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLAxiom getClassAssertionAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree description, ManchesterOWLSyntaxTree subject) {
        OWLClassAssertionAxiom toReturn = null;
        boolean rightKinds = true;
        if (description.getEvalType() == null
                || !description.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(description, description.getEvalType(),
                    expression);
            rightKinds = false;
        }
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, subject.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            toReturn = getDataFactory().getOWLClassAssertionAxiom(
                    (OWLClassExpression) description.getOWLObject(),
                    (OWLIndividual) subject.getOWLObject());
        }
        return toReturn;
    }

    public OWLAxiom getRoleAssertionAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, subject.getEvalType(), expression);
            rightKinds = false;
        }
        if (property.getEvalType() == null
                || !property.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(property, property.getEvalType(), expression);
            rightKinds = false;
        }
        if (object.getEvalType() == null
                || object.getEvalType() != OWLType.OWL_INDIVIDUAL
                && object.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(object, object.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (property.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (object.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, property, object);
                } else {
                    toReturn = getDataFactory().getOWLObjectPropertyAssertionAxiom(
                            (OWLObjectPropertyExpression) property.getOWLObject(),
                            (OWLIndividual) subject.getOWLObject(),
                            (OWLIndividual) object.getOWLObject());
                }
            } else if (property.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (object.getEvalType() != OWLType.OWL_CONSTANT) {
                    reportIncompatibleSymbols(expression, property, object);
                } else {
                    toReturn = getDataFactory().getOWLDataPropertyAssertionAxiom(
                            (OWLDataPropertyExpression) property.getOWLObject(),
                            (OWLIndividual) subject.getOWLObject(),
                            (OWLLiteral) object.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLAxiom getSubPropertyAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree subProperty, ManchesterOWLSyntaxTree superProperty) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (subProperty.getEvalType() == null
                || !subProperty.getEvalType().accept(owlPropertyTypeDetector)
                && subProperty.getEvalType() != OWLType.OWL_PROPERTY_CHAIN) {
            reportIncompatibleSymbolType(subProperty, subProperty.getEvalType(),
                    expression);
            rightKinds = false;
        }
        if (superProperty.getEvalType() == null
                || !superProperty.getEvalType().accept(owlPropertyTypeDetector)) {
            rightKinds = false;
            reportIncompatibleSymbolType(superProperty, superProperty.getEvalType(),
                    expression);
        }
        boolean areChildrenCompatible = subProperty.getEvalType() == superProperty
                .getEvalType()
                || subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN
                && superProperty.getEvalType() == OWLType.OWL_OBJECT_PROPERTY;
        if (rightKinds && areChildrenCompatible) {
            if (areChildrenCompatible) {
                // There is a special axiom for property chain sub-property
                toReturn = subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN ? getDataFactory()
                        .getOWLSubPropertyChainOfAxiom(
                                (OWLPropertyChain) subProperty.getOWLObject(),
                                (OWLObjectPropertyExpression) superProperty
                                        .getOWLObject()) : toReturn;
                if (toReturn == null) {
                    toReturn = subProperty.getEvalType().accept(
                            owlObjectPropertyTypeDetector) ? getDataFactory()
                            .getOWLSubObjectPropertyOfAxiom(
                                    (OWLObjectPropertyExpression) subProperty
                                            .getOWLObject(),
                                    (OWLObjectPropertyExpression) superProperty
                                            .getOWLObject())
                            : getDataFactory()
                                    .getOWLSubDataPropertyOfAxiom(
                                            (OWLDataPropertyExpression) subProperty
                                                    .getOWLObject(),
                                            (OWLDataPropertyExpression) superProperty
                                                    .getOWLObject());
                }
            } else {
                reportIncompatibleSymbols(expression, subProperty, superProperty);
            }
        } else {
            reportIncompatibleSymbols(expression, subProperty, superProperty);
        }
        return toReturn;
    }

    public OWLAxiom getDisjointAxiom(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(owlClassTypeDetector)
                && !lhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(lhs, lhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(owlClassTypeDetector)
                && !rhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(rhs, rhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(owlClassTypeDetector)) {
                if (!rhs.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLDisjointClassesAxiom(
                            (OWLClassExpression) lhs.getOWLObject(),
                            (OWLClassExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLDisjointObjectPropertiesAxiom(
                            (OWLObjectPropertyExpression) lhs.getOWLObject(),
                            (OWLObjectPropertyExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLDisjointDataPropertiesAxiom(
                            (OWLDataPropertyExpression) lhs.getOWLObject(),
                            (OWLDataPropertyExpression) rhs.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLAxiom getInverseOfAxiom(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        OWLInverseObjectPropertiesAxiom toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null
                || !lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
            reportIncompatibleSymbolType(lhs, lhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null
                || !rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
            reportIncompatibleSymbolType(rhs, rhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLInverseObjectPropertiesAxiom(
                            (OWLObjectPropertyExpression) lhs.getOWLObject(),
                            (OWLObjectPropertyExpression) rhs.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLAxiom getEquivalentAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(owlClassTypeDetector)
                && !lhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(lhs, lhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(owlClassTypeDetector)
                && !rhs.getEvalType().accept(owlPropertyTypeDetector)) {
            reportIncompatibleSymbolType(rhs, rhs.getEvalType(), expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(owlClassTypeDetector)) {
                if (!rhs.getEvalType().accept(owlClassTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLEquivalentClassesAxiom(
                            (OWLClassExpression) lhs.getOWLObject(),
                            (OWLClassExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                if (!rhs.getEvalType().accept(owlObjectPropertyTypeDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLEquivalentObjectPropertiesAxiom(
                            (OWLObjectPropertyExpression) lhs.getOWLObject(),
                            (OWLObjectPropertyExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = getDataFactory().getOWLEquivalentDataPropertiesAxiom(
                            (OWLDataPropertyExpression) lhs.getOWLObject(),
                            (OWLDataPropertyExpression) rhs.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    public OWLAxiom getSubClassAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
        OWLSubClassOfAxiom toReturn = null;
        if (subClass.getEvalType() == null
                || !subClass.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(subClass, subClass.getEvalType(), expression);
        } else if (superClass.getEvalType() == null
                || !superClass.getEvalType().accept(owlClassTypeDetector)) {
            reportIncompatibleSymbolType(superClass, superClass.getEvalType(), expression);
        } else {
            toReturn = getDataFactory().getOWLSubClassOfAxiom(
                    (OWLClassExpression) subClass.getOWLObject(),
                    (OWLClassExpression) superClass.getOWLObject());
        }
        return toReturn;
    }

    /** Retrieves a set of String representing the symbols matching with the
     * input prefix.
     * 
     * @param prefix
     *            The input prefix. Cannot be {@code null}.
     * @return A Set of String elements.
     * @throws NullPointerException
     *             if the input is {@code null}. */
    public Set<String> match(String prefix) {
        Set<Symbol> matches = getGlobalScope().match(prefix);
        Set<String> toReturn = new HashSet<String>(matches.size());
        for (Symbol symbol : matches) {
            toReturn.add(symbol.getName());
        }
        return toReturn;
    }

    public Set<String> getOWLObjectPropertyCompletions() {
        return getAllCompletions(OWLType.OWL_OBJECT_PROPERTY);
    }

    public Set<String> getOWLDataPropertyCompletions() {
        return getAllCompletions(OWLType.OWL_DATA_PROPERTY);
    }

    public Set<String> getOWLClassCompletions() {
        return getAllCompletions(OWLType.OWL_CLASS);
    }

    public Set<String> getCompletions(Type type) {
        Set<String> toReturn = new HashSet<String>();
        if (OWLType.isClassExpression(type)) {
            toReturn.addAll(getOWLClassCompletions());
        }
        if (OWLType.isObjectPropertyExpression(type)) {
            toReturn.addAll(getOWLObjectPropertyCompletions());
        }
        if (OWLType.OWL_DATA_PROPERTY == type) {
            toReturn.addAll(getOWLDataPropertyCompletions());
        }
        if (OWLType.OWL_INDIVIDUAL == type) {
            toReturn.addAll(getOWLIndividualCompletions());
        }
        return toReturn;
    }

    public Set<String> getOWLPropertyCompletions(Type type) {
        Set<String> toReturn = new HashSet<String>();
        if (OWLType.isObjectPropertyExpression(type)) {
            toReturn.addAll(getOWLObjectPropertyCompletions());
        }
        if (OWLType.OWL_DATA_PROPERTY == type) {
            toReturn.addAll(getOWLDataPropertyCompletions());
        }
        return toReturn;
    }

    public Set<String> getOWLIndividualCompletions() {
        return getAllCompletions(OWLType.OWL_INDIVIDUAL);
    }

    public Set<String> getAllCompletions(Type... types) {
        Set<String> toReturn = new HashSet<String>();
        for (Type type : types) {
            Set<Symbol> symbols = getGlobalScope().getAllSymbols(type);
            for (Symbol symbol : symbols) {
                toReturn.add(symbol.getName());
            }
        }
        return toReturn;
    }

    /** Stores the input Symbol under the input Token.
     * 
     * @param token
     *            The input Token. Cannot be {@code null}.
     * @param symbol
     *            The Symbol to be stored. cannot be {@code null}.
     * @throws NullPointerException
     *             if either input is {@code null}. */
    protected void storeSymbol(Token token, Symbol symbol) {
        if (token == null) {
            throw new NullPointerException("The token cannot be null");
        }
        if (symbol == null) {
            throw new NullPointerException("The symbol cannot be null");
        }
        symbols.put(token.getText(), symbol);
    }

    /** Stores the input Symbol under the input name.
     * 
     * @param name
     *            The input name. Cannot be {@code null}.
     * @param symbol
     *            The Symbol to be stored. cannot be {@code null}.
     * @throws NullPointerException
     *             if either input is {@code null}. */
    protected void storeSymbol(String name, Symbol symbol) {
        if (name == null) {
            throw new NullPointerException("The token cannot be null");
        }
        if (symbol == null) {
            throw new NullPointerException("The symbol cannot be null");
        }
        symbols.put(name, symbol);
    }

    /** Removes the Symbol corresponding to the input Token.
     * 
     * @param token
     *            The input Token.
     * @return The removed Symbol if it appeared in this SymbolTable
     *         {@code null} otherwise. */
    protected Symbol removeSymbol(Token token) {
        return symbols.remove(token.getText());
    }

    /** Retrieves all the Symbos that have been stored in this Symbol table.
     * Please notice that this may be a proper sub-set of all the possible
     * symbols as there may be many more which have not been used but are still
     * valid ones.
     * 
     * @return a Set of Symbol elements. */
    public Set<Symbol> getDefinedSymbols() {
        return new HashSet<Symbol>(symbols.values());
    }

    public void dispose() {
        getGlobalScope().dispose();
    }

    public OWLType getOWLFacetRestrictionType(ManchesterOWLSyntaxTree facet,
            ManchesterOWLSyntaxTree value, CommonTree parentExpression) {
        OWLType toReturn = null;
        OWLFacet facetByShortName = OWLFacet.getFacetBySymbolicName(facet.getText());
        if (facetByShortName == null) {
            reportIllegalToken(facet, "Invalid facet token");
        } else if (value.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(value, value.getEvalType(), parentExpression);
        } else {
            toReturn = OWLType.OWL_DATA_FACET;
        }
        return toReturn;
    }

    public OWLFacetRestriction getOWLFacetRestriction(ManchesterOWLSyntaxTree facet,
            ManchesterOWLSyntaxTree value, CommonTree parentExpression) {
        OWLFacetRestriction toReturn = null;
        OWLFacet facetByShortName = OWLFacet.getFacetBySymbolicName(facet.getText());
        if (facetByShortName == null) {
            reportIllegalToken(facet, "Invalid facet token");
        } else if (value.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(value, value.getEvalType(), parentExpression);
        } else {
            toReturn = getDataFactory().getOWLFacetRestriction(facetByShortName,
                    (OWLLiteral) value.getOWLObject());
        }
        return toReturn;
    }

    public OWLType getOWLDataRangeType(ManchesterOWLSyntaxTree dataType,
            ManchesterOWLSyntaxTree parentExpression, ManchesterOWLSyntaxTree... facets) {
        OWLType toReturn = null;
        if (dataType.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(dataType, dataType.getEvalType(),
                    parentExpression);
        } else {
            Set<OWLFacetRestriction> facetRestrictions = new HashSet<OWLFacetRestriction>(
                    facets.length);
            boolean allFine = true;
            for (ManchesterOWLSyntaxTree facet : facets) {
                if (facet == null || facet.getOWLObject() == null) {
                    allFine = false;
                    reportIllegalToken(facet, "NUll facet ");
                } else if (facet.getEvalType() != OWLType.OWL_DATA_FACET
                        || !(facet.getOWLObject() instanceof OWLFacetRestriction)) {
                    allFine = false;
                    reportIncompatibleSymbolType(facet, facet.getEvalType(),
                            parentExpression);
                } else {
                    facetRestrictions.add((OWLFacetRestriction) facet.getOWLObject());
                }
            }
            if (allFine) {
                toReturn = OWLType.OWL_DATA_TYPE_RESTRICTION;
            }
        }
        return toReturn;
    }

    public OWLDatatypeRestriction getOWLDataRange(ManchesterOWLSyntaxTree dataType,
            ManchesterOWLSyntaxTree parentExpression, ManchesterOWLSyntaxTree... facets) {
        OWLDatatypeRestriction toReturn = null;
        if (dataType.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(dataType, dataType.getEvalType(),
                    parentExpression);
        } else {
            Set<OWLFacetRestriction> facetRestrictions = new HashSet<OWLFacetRestriction>(
                    facets.length);
            boolean allFine = true;
            for (ManchesterOWLSyntaxTree facet : facets) {
                if (facet == null || facet.getOWLObject() == null) {
                    allFine = false;
                    reportIllegalToken(facet, "NUll facet ");
                } else if (facet.getEvalType() != OWLType.OWL_DATA_FACET
                        || !(facet.getOWLObject() instanceof OWLFacetRestriction)) {
                    allFine = false;
                    reportIncompatibleSymbolType(facet, facet.getEvalType(),
                            parentExpression);
                } else {
                    facetRestrictions.add((OWLFacetRestriction) facet.getOWLObject());
                }
            }
            if (allFine) {
                toReturn = getDataFactory().getOWLDatatypeRestriction(
                        (OWLDatatype) dataType.getOWLObject(), facetRestrictions);
            }
        }
        return toReturn;
    }

    public Type
            getHasKeyType(ManchesterOWLSyntaxTree manchesterOWLSyntaxTree,
                    ManchesterOWLSyntaxTree node,
                    Set<ManchesterOWLSyntaxTree> propertyExpressions) {
        Type toReturn = null;
        if (node.getEvalType() == null
                || !node.getEvalType().accept(owlClassTypeDetector)) {
            reportIllegalToken(node, "A class expression is expected here");
        } else {
            boolean allFine = true;
            Iterator<ManchesterOWLSyntaxTree> iterator = propertyExpressions.iterator();
            while (allFine && iterator.hasNext()) {
                ManchesterOWLSyntaxTree propertyNode = iterator.next();
                allFine = propertyNode.getEvalType() != null
                        && propertyNode.getEvalType().accept(owlPropertyTypeDetector);
            }
            if (allFine) {
                toReturn = OWLAxiomType.HAS_KEY;
            }
        }
        return toReturn;
    }

    public OWLHasKeyAxiom
            getHasKey(ManchesterOWLSyntaxTree manchesterOWLSyntaxTree,
                    ManchesterOWLSyntaxTree node,
                    Set<ManchesterOWLSyntaxTree> propertyExpressions) {
        OWLHasKeyAxiom toReturn = null;
        OWLClassExpression ce = null;
        if (node.getEvalType() == null
                || !node.getEvalType().accept(owlClassTypeDetector)
                || node.getOWLObject() == null) {
            reportIllegalToken(node, "A class expression is expected here");
        } else {
            ce = (OWLClassExpression) node.getOWLObject();
            boolean allFine = true;
            Iterator<ManchesterOWLSyntaxTree> iterator = propertyExpressions.iterator();
            Set<OWLPropertyExpression<?, ?>> pes = new HashSet<OWLPropertyExpression<?, ?>>();
            while (allFine && iterator.hasNext()) {
                ManchesterOWLSyntaxTree propertyNode = iterator.next();
                allFine = propertyNode.getEvalType() != null
                        && propertyNode.getEvalType().accept(owlPropertyTypeDetector)
                        && propertyNode.getOWLObject() != null;
                if (allFine) {
                    pes.add((OWLPropertyExpression<?, ?>) propertyNode.getOWLObject());
                }
            }
            if (allFine) {
                toReturn = getDataFactory().getOWLHasKeyAxiom(ce, pes);
            }
        }
        return toReturn;
    }

    public Type
            getAnnotationAssertionType(final ManchesterOWLSyntaxTree parentExpression,
                    final ManchesterOWLSyntaxTree iri,
                    ManchesterOWLSyntaxTree annotationPropertyNode,
                    ManchesterOWLSyntaxTree object) {
        Type toReturn = null;
        Symbol subjectIRISymbol = retrieveSymbol(iri.getText());
        IRI subjectIRI = subjectIRISymbol != null ? subjectIRISymbol
                .accept(new SymbolVisitorEx<IRI>() {
                    @Override
                    public IRI visitSymbol(Symbol symbol) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri,
                                symbol.getType(), parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri,
                                owlConstantSymbol.getType(), parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri,
                                owlEntitySymbol.getType(), parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitIRI(IRISymbol iriSymbol) {
                        return iriSymbol.getIRI();
                    }
                }) : IRI.create(iri.getText());
        if (subjectIRI != null) {
            this.storeSymbol(iri.getToken(), new IRISymbol(iri.getText(), subjectIRI));
        }
        if (subjectIRI == null) {
            reportIllegalToken(iri, "Illegal IRI");
        } else if (annotationPropertyNode.getEvalType() == null
                || annotationPropertyNode.getEvalType() != OWLType.OWL_ANNOTATION_PROPERTY) {
            reportIncompatibleSymbolType(annotationPropertyNode,
                    annotationPropertyNode.getEvalType(), parentExpression);
        } else if (object.getEvalType() == null
                || !object.getEvalType().accept(owlAnnotationObjectTypeDetector)) {
            reportIncompatibleSymbols(parentExpression, object);
        } else {
            toReturn = OWLAxiomType.ANNOTATION_ASSERTION;
        }
        return toReturn;
    }

    public OWLAnnotationAssertionAxiom getAnnotationAssertion(
            final ManchesterOWLSyntaxTree parentExpression,
            final ManchesterOWLSyntaxTree iri,
            final ManchesterOWLSyntaxTree annotationPropertyNode,
            ManchesterOWLSyntaxTree object) {
        OWLAnnotationAssertionAxiom toReturn = null;
        IRI subjectIRI = resolve(iri) == null ? IRI.create(iri.getText()) : resolve(iri)
                .accept(new SymbolVisitorEx<IRI>() {
                    @Override
                    public IRI visitSymbol(Symbol symbol) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri,
                                symbol.getType(), parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri,
                                owlConstantSymbol.getType(), parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri,
                                owlEntitySymbol.getType(), parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitIRI(IRISymbol iriSymbol) {
                        return iriSymbol.getIRI();
                    }
                });
        if (subjectIRI == null) {
            reportIllegalToken(iri, "Illegal IRI");
        } else if (annotationPropertyNode.getEvalType() == null
                || annotationPropertyNode.getEvalType() != OWLType.OWL_ANNOTATION_PROPERTY) {
            reportIncompatibleSymbolType(annotationPropertyNode,
                    annotationPropertyNode.getEvalType(), parentExpression);
        } else if (annotationPropertyNode.getOWLObject() == null) {
            reportIllegalToken(annotationPropertyNode, "Invalid annotation property");
        } else if (object.getEvalType() == null
                || !object.getEvalType().accept(owlAnnotationObjectTypeDetector)) {
            reportIncompatibleSymbols(parentExpression, object);
        } else if (object.getOWLObject() == null) {
            reportIllegalToken(object, "Invalid object");
        } else {
            OWLAnnotation annotation = object.getOWLObject().accept(
                    new OWLObjectVisitorExAdapter<OWLAnnotation>() {
                        @Override
                        public OWLAnnotation visit(IRI iri) {
                            return SymbolTable.this.getDataFactory().getOWLAnnotation(
                                    (OWLAnnotationProperty) annotationPropertyNode
                                            .getOWLObject(), iri);
                        }

                        @Override
                        public OWLAnnotation visit(OWLLiteral literal) {
                            return SymbolTable.this.getDataFactory().getOWLAnnotation(
                                    (OWLAnnotationProperty) annotationPropertyNode
                                            .getOWLObject(), literal);
                        }
                    });
            toReturn = getDataFactory().getOWLAnnotationAssertionAxiom(subjectIRI,
                    annotation);
        }
        return toReturn;
    }

    public Symbol resolveIRI(ManchesterOWLSyntaxTree node) {
        Symbol toReturn = retrieveSymbol(node.getText());
        if (toReturn == null) {
            String name = node.getToken().getText();
            IRI iri = IRI.create(node.getText());
            if (iri != null) {
                toReturn = new IRISymbol(name, iri);
            }
            symbols.put(name, toReturn);
        }
        return toReturn;
    }
}
