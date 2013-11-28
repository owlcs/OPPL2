package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.coode.oppl.semanticweb.owlapi.model.OWLPropertyChain;
import org.coode.oppl.semanticweb.owlapi.model.OWLPropertyChainImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
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
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLQuantifiedRestriction;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
import org.semanticweb.owlapi.vocab.OWLFacet;

/** @author Luigi Iannone */
public class SymbolTable {
    private static abstract class OWLTypeOnlyVisitor implements TypeVisitorEx<Boolean> {
        public OWLTypeOnlyVisitor() {}

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
        public OWLAxiomTypeOnlyVisitor() {}

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
    protected final OWLDataFactory df;
    private final Map<String, Symbol> symbols = new HashMap<String, Symbol>();
    private ErrorListener errorListener;
    private final OWLTypeOnlyVisitor classDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isClassExpression(owlType);
        }
    };
    private final OWLTypeOnlyVisitor dtDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isDataTypeExpression(owlType);
        }
    };
    private final OWLTypeOnlyVisitor opDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return OWLType.isObjectPropertyExpression(owlType);
        }
    };
    private final OWLTypeOnlyVisitor pDetector = new OWLTypeOnlyVisitor() {
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
    private final OWLTypeOnlyVisitor annDetector = new OWLTypeOnlyVisitor() {
        @Override
        public Boolean visitOWLType(OWLType owlType) {
            return owlType == OWLType.OWL_CONSTANT || owlType == OWLType.IRI;
        }
    };

    /** @param globalScope
     * @param dataFactory */
    public SymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
        this.globalScope = checkNotNull(globalScope, "globalScope");
        df = checkNotNull(dataFactory, "dataFactory");
    }

    /** @return the globalScope */
    public Scope getGlobalScope() {
        return globalScope;
    }

    /** @param node
     * @return resolved symbol */
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

    /** @param expression
     * @param subClass
     * @param superClass
     * @return type for expression */
    public Type getSubClassAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
        Type toReturn = null;
        if (subClass.getEvalType() == null
                || !subClass.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(subClass, expression);
        } else if (superClass.getEvalType() == null
                || !superClass.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(superClass, expression);
        } else {
            toReturn = OWLAxiomType.SUBCLASS;
        }
        return toReturn;
    }

    /** @param tree
     * @param parentExpression */
    public void reportIncompatibleSymbolType(ManchesterOWLSyntaxTree tree,
            CommonTree parentExpression) {
        reportIncompatibleSymbolType(tree, tree.getEvalType(), parentExpression);
    }

    /** @param tree
     * @param t
     * @param parentExpression */
    public void reportIncompatibleSymbolType(CommonTree tree, Type t,
            CommonTree parentExpression) {
        if (getErrorListener() != null) {
            getErrorListener().incompatibleSymbolType(tree, t, parentExpression);
        }
    }

    /** @param parentExpression
     * @param expressions */
    public void reportIncompatibleSymbols(CommonTree parentExpression,
            CommonTree... expressions) {
        if (getErrorListener() != null) {
            getErrorListener().incompatibleSymbols(parentExpression, expressions);
        }
    }

    /** @param expression
     * @param message */
    public void reportIllegalToken(CommonTree expression, String message) {
        if (getErrorListener() != null) {
            getErrorListener().illegalToken(expression, message);
        }
    }

    /** @param expression
     * @param disjuncts
     * @return type for expression */
    public Type getDisjunctionType(CommonTree expression,
            ManchesterOWLSyntaxTree... disjuncts) {
        boolean allFine = true;
        Type toReturn = null;
        Type rest = null;
        for (ManchesterOWLSyntaxTree disjunct : disjuncts) {
            if (disjunct.getEvalType() == null
                    || !isNAryDescriptionCompatible(rest, disjunct.getEvalType())) {
                allFine = false;
                reportIncompatibleSymbolType(disjunct, expression);
            } else {
                if (rest == null) {
                    rest = disjunct.getEvalType();
                }
            }
        }
        if (allFine) {
            if (rest != null) {
                toReturn = rest.accept(classDetector) ? OWLType.OWL_OBJECT_INTERSECTION_OF
                        : OWLType.OWL_DATA_UNION_OF;
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param conjuncts
     * @return type for expression */
    public Type getConjunctionType(CommonTree expression,
            ManchesterOWLSyntaxTree... conjuncts) {
        boolean allFine = true;
        Type toReturn = null;
        Type rest = null;
        for (ManchesterOWLSyntaxTree conjunct : conjuncts) {
            if (conjunct.getEvalType() == null
                    || !isNAryDescriptionCompatible(rest, conjunct.getEvalType())) {
                allFine = allFine && false;
                reportIncompatibleSymbolType(conjunct, expression);
            } else {
                rest = rest == null ? conjunct.getEvalType() : rest;
            }
        }
        if (allFine && rest != null) {
            toReturn = rest.accept(classDetector) ? OWLType.OWL_OBJECT_INTERSECTION_OF
                    : OWLType.OWL_DATA_INTERSECTION_OF;
        }
        return toReturn;
    }

    private boolean isNAryDescriptionCompatible(Type rest, Type operandType) {
        // If this is the first one (rest ==null) the it can either a data type
        // or a class expression. Otherwise the type of the rest determines what
        // is expected from the operand type
        return rest == null ? operandType.accept(classDetector)
                || operandType.accept(dtDetector) : rest.accept(classDetector)
                && operandType.accept(classDetector) || rest.accept(dtDetector)
                && operandType.accept(dtDetector);
    }

    /** @param expression
     * @param node
     * @return type for expression */
    public Type getNegatedClassExpressionType(CommonTree expression,
            ManchesterOWLSyntaxTree node) {
        Type toReturn = null;
        if (node.getEvalType() == null || !node.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(node, expression);
        } else {
            toReturn = OWLType.OWL_OBJECT_COMPLEMENT_OF;
        }
        return toReturn;
    }

    /** @param expression
     * @param property
     * @return type for expression */
    public Type getInversePropertyType(CommonTree expression,
            ManchesterOWLSyntaxTree property) {
        Type toReturn = null;
        if (property.getEvalType() == null || !property.getEvalType().accept(opDetector)) {
            reportIncompatibleSymbolType(property, expression);
        } else {
            toReturn = OWLType.OWL_OBJECT_INVERSE_PROPERTY;
        }
        return toReturn;
    }

    /** @param expression
     * @param subProperty
     * @param superProperty
     * @return type for expression */
    public Type getSubPropertyAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree subProperty, ManchesterOWLSyntaxTree superProperty) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (subProperty.getEvalType() == null
                || !subProperty.getEvalType().accept(pDetector)
                && subProperty.getEvalType() != OWLType.OWL_PROPERTY_CHAIN) {
            reportIncompatibleSymbolType(subProperty, expression);
            rightKinds = false;
        }
        if (superProperty.getEvalType() == null
                || !superProperty.getEvalType().accept(pDetector)) {
            rightKinds = false;
            reportIncompatibleSymbolType(superProperty, expression);
        }
        boolean areChildrenCompatible = subProperty.getEvalType() == superProperty
                .getEvalType()
                || subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN
                && superProperty.getEvalType() == OWLType.OWL_OBJECT_PROPERTY;
        if (rightKinds && areChildrenCompatible) {
            if (areChildrenCompatible) {
                toReturn = subProperty.getEvalType().accept(opDetector) ? OWLAxiomType.SUB_OBJECT_PROPERTY
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

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return type for expression */
    public Type getSomeValueRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(classDetector) || filler.getEvalType()
                        .accept(dtDetector))) {
            reportIncompatibleSymbolType(filler, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(dtDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_SOME_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (!filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_SOME_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return type for expression */
    public Type getAllValueRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(classDetector) || filler.getEvalType()
                        .accept(dtDetector))) {
            reportIncompatibleSymbolType(filler, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(dtDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_DATA_ALL_RESTRICTION;
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (!filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_ALL_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return type for expression */
    public Type getMinCardinalityRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
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
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (filler != null
                        && (filler.getEvalType() == null || !filler.getEvalType().accept(
                                classDetector))) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_MIN_CARDINALITY_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return type for expression */
    public Type getMaxCardinalityRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
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
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (filler != null
                        && (filler.getEvalType() == null || !filler.getEvalType().accept(
                                classDetector))) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_MAX_CARDINALITY_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return type for expression */
    public Type getExactCardinalityRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
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
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (filler != null
                        && (filler.getEvalType() == null || !filler.getEvalType().accept(
                                classDetector))) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = OWLType.OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param individuals
     * @return type for expression */
    public Type getOneOfType(CommonTree expression,
            ManchesterOWLSyntaxTree... individuals) {
        boolean allFine = true;
        Type toReturn = null;
        for (ManchesterOWLSyntaxTree individual : individuals) {
            if (individual.getEvalType() == null
                    || individual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                allFine = false;
                reportIncompatibleSymbolType(individual, expression);
            }
        }
        if (allFine) {
            toReturn = OWLType.OWL_OBJECT_ONE_OF;
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param value
     * @return type for expression */
    public Type getValueRestrictionType(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (value.getEvalType() == null) {
            reportIncompatibleSymbolType(propertyExpression, expression);
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
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (value.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = OWLType.OWL_OBJECT_VALUE_RESTRICTION;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param value
     * @return value restriction */
    public OWLClassExpression getValueRestriction(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value) {
        OWLClassExpression toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (value.getEvalType() != OWLType.OWL_CONSTANT) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = df
                            .getOWLDataHasValue(
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(), (OWLLiteral) value
                                            .getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (value.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, propertyExpression, value);
                } else {
                    toReturn = df
                            .getOWLObjectHasValue(
                                    (OWLObjectPropertyExpression) propertyExpression
                                            .getOWLObject(), (OWLIndividual) value
                                            .getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param subject
     * @param property
     * @param object
     * @return type for expression */
    public Type getRoleAssertionAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, expression);
            rightKinds = false;
        }
        if (property.getEvalType() == null || !property.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(property, expression);
            rightKinds = false;
        }
        if (object.getEvalType() == null
                || object.getEvalType() != OWLType.OWL_INDIVIDUAL
                && object.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(object, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (property.getEvalType().accept(opDetector)) {
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

    /** clear symbols */
    public void clear() {
        symbols.clear();
    }

    /** @param expression
     * @param lhs
     * @param rhs
     * @return type for expression */
    public Type getEquivalentAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(classDetector)
                && !lhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(lhs, expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(classDetector)
                && !rhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(rhs, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(classDetector)) {
                if (!rhs.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.EQUIVALENT_CLASSES;
                }
            } else if (lhs.getEvalType().accept(opDetector)) {
                if (!rhs.getEvalType().accept(opDetector)) {
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

    /** @param expression
     * @param p
     * @param domain
     * @return type for expression */
    public Type getDomainAxiomType(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree domain) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, expression);
            rightKinds = false;
        }
        if (domain.getEvalType() == null || !domain.getEvalType().accept(classDetector)
                && domain.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(domain, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!domain.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = OWLAxiomType.OBJECT_PROPERTY_DOMAIN;
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!domain.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = OWLAxiomType.DATA_PROPERTY_DOMAIN;
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param p
     * @param range
     * @return type for expression */
    public Type getRangeAxiomType(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree range) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, expression);
            rightKinds = false;
        }
        if (range.getEvalType() == null || !range.getEvalType().accept(classDetector)
                && range.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(range, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!range.getEvalType().accept(classDetector)) {
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

    /** @param expression
     * @param chainItems
     * @return type for expression */
    public Type getPropertyChainType(CommonTree expression,
            ManchesterOWLSyntaxTree... chainItems) {
        boolean allFine = true;
        Type toReturn = null;
        for (ManchesterOWLSyntaxTree item : chainItems) {
            if (item.getEvalType() == null || !item.getEvalType().accept(opDetector)) {
                allFine = false;
                reportIncompatibleSymbolType(item, expression);
            }
        }
        if (allFine) {
            toReturn = OWLType.OWL_PROPERTY_CHAIN;
        }
        return toReturn;
    }

    /** @param expression
     * @param lhs
     * @param rhs
     * @return type for expression */
    public Type getDisjointAxiomType(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(classDetector)
                && !lhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(lhs, expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(classDetector)
                && !rhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(rhs, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(classDetector)) {
                if (!rhs.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = OWLAxiomType.DISJOINT_CLASSES;
                }
            } else if (lhs.getEvalType().accept(opDetector)) {
                if (!rhs.getEvalType().accept(opDetector)) {
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

    /** @param expression
     * @param anIndividual
     * @param anotherIndividual
     * @return type for expression */
    public Type getSameIndividualsAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, expression);
        }
        if (anotherIndividual.getEvalType() == null
                || anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual, expression);
        }
        if (rightKinds) {
            toReturn = OWLAxiomType.SAME_INDIVIDUAL;
        }
        return toReturn;
    }

    /** @param expression
     * @param anIndividual
     * @param anotherIndividual
     * @return type for expression */
    public Type getDifferentIndividualsAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, expression);
        }
        if (anotherIndividual.getEvalType() == null
                || anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual, expression);
        }
        if (rightKinds) {
            toReturn = OWLAxiomType.DIFFERENT_INDIVIDUALS;
        }
        return toReturn;
    }

    /** @param expression
     * @param p
     * @return type for expression */
    public Type
            getFunctionalPropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            rightKinds = false;
            reportIncompatibleSymbolType(p, expression);
        }
        if (rightKinds) {
            toReturn = p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY ? OWLAxiomType.FUNCTIONAL_OBJECT_PROPERTY
                    : OWLAxiomType.FUNCTIONAL_DATA_PROPERTY;
        }
        return toReturn;
    }

    /** @param expression
     * @param p
     * @return type for expression */
    public Type getInverseFunctionalPropertyType(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return OWLAxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY;
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return type for expression */
    public Type getIrreflexivePropertyType(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return OWLAxiomType.IRREFLEXIVE_OBJECT_PROPERTY;
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return type for expression */
    public Type
            getReflexivePropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return OWLAxiomType.REFLEXIVE_OBJECT_PROPERTY;
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return type for expression */
    public Type
            getSymmetricPropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return OWLAxiomType.SYMMETRIC_OBJECT_PROPERTY;
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return type for expression */
    public Type
            getTransitivePropertyType(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return OWLAxiomType.TRANSITIVE_OBJECT_PROPERTY;
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param lhs
     * @param rhs
     * @return type for expression */
    public Type getInverseOfAxiomType(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(opDetector)) {
            reportIncompatibleSymbolType(lhs, expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(opDetector)) {
            reportIncompatibleSymbolType(rhs, expression);
            rightKinds = false;
        }
        if (rightKinds && lhs.getEvalType().accept(opDetector)) {
            if (!rhs.getEvalType().accept(opDetector)) {
                reportIncompatibleSymbols(expression, lhs, rhs);
            } else {
                toReturn = OWLAxiomType.INVERSE_OBJECT_PROPERTIES;
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param assertion
     * @return type for expression */
    public Type getNegatedAssertionType(CommonTree expression,
            ManchesterOWLSyntaxTree assertion) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (assertion.getEvalType() == null
                || !assertion.getEvalType().accept(simpleAssertionDetector)) {
            reportIncompatibleSymbolType(assertion, expression);
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

    /** @param expression
     * @param description
     * @param subject
     * @return type for expression */
    public Type getClassAssertionAxiomType(CommonTree expression,
            ManchesterOWLSyntaxTree description, ManchesterOWLSyntaxTree subject) {
        Type toReturn = null;
        boolean rightKinds = true;
        if (description.getEvalType() == null
                || !description.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(description, expression);
            rightKinds = false;
        }
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            toReturn = OWLAxiomType.CLASS_ASSERTION;
        }
        return toReturn;
    }

    /** @return the dataFactory */
    public OWLDataFactory getDataFactory() {
        return df;
    }

    /** @param expression
     * @param individuals
     * @return symbol replaced owl object */
    public OWLObject
            getOneOf(CommonTree expression, ManchesterOWLSyntaxTree[] individuals) {
        boolean allFine = true;
        OWLObjectOneOf toReturn = null;
        List<OWLIndividual> individualList = new ArrayList<OWLIndividual>(
                individuals.length);
        for (ManchesterOWLSyntaxTree individual : individuals) {
            if (individual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                allFine = false;
                reportIncompatibleSymbolType(individual, expression);
            } else {
                individualList.add((OWLIndividual) individual.getOWLObject());
            }
        }
        if (allFine) {
            toReturn = df.getOWLObjectOneOf(individualList
                    .toArray(new OWLIndividual[individualList.size()]));
        }
        return toReturn;
    }

    /** @param expression
     * @param i
     * @param propertyExpression
     * @param filler
     * @return symbol replaced owl object */
    public OWLObject getExactCardinalityRestriction(CommonTree expression, int i,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLCardinalityRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? df
                            .getOWLDataExactCardinality(i,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject()) : df
                            .getOWLDataExactCardinality(i,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(), (OWLDataRange) filler
                                            .getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (filler != null && !filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? df.getOWLObjectExactCardinality(i,
                            (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject()) : df.getOWLObjectExactCardinality(i,
                            (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject(), (OWLClassExpression) filler
                                    .getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param cardinality
     * @param propertyExpression
     * @param filler
     * @return symbol replaced owl object */
    public OWLObject getMaxCardinalityRestriction(CommonTree expression, int cardinality,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLCardinalityRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? df
                            .getOWLDataMaxCardinality(cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject()) : df
                            .getOWLDataMaxCardinality(cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(), (OWLDataRange) filler
                                            .getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (filler != null && !filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? df.getOWLObjectMaxCardinality(
                            cardinality, (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject()) : df.getOWLObjectMaxCardinality(
                            cardinality, (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject(), (OWLClassExpression) filler
                                    .getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param cardinality
     * @param propertyExpression
     * @param filler
     * @return symbol replaced owl object */
    public OWLObject getMinCardinalityRestriction(CommonTree expression, int cardinality,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLCardinalityRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (filler != null && filler.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? df
                            .getOWLDataMinCardinality(cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject()) : df
                            .getOWLDataMinCardinality(cardinality,
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(), (OWLDataRange) filler
                                            .getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (filler != null && !filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = filler == null ? df.getOWLObjectMinCardinality(
                            cardinality, (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject()) : df.getOWLObjectMinCardinality(
                            cardinality, (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject(), (OWLClassExpression) filler
                                    .getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return symbol replaced owl object */
    public OWLObject getAllValueRestriction(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLQuantifiedRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(classDetector) || filler.getEvalType()
                        .accept(dtDetector))) {
            reportIncompatibleSymbolType(filler, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(dtDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = df.getOWLDataAllValuesFrom(
                            (OWLDataPropertyExpression) propertyExpression,
                            (OWLDataRange) filler);
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (!filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = df.getOWLObjectAllValuesFrom(
                            (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject(), (OWLClassExpression) filler
                                    .getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param propertyExpression
     * @param filler
     * @return symbol replaced owl object */
    public OWLObject getSomeValueRestriction(CommonTree expression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        OWLQuantifiedRestriction<?, ?, ?> toReturn = null;
        boolean rightKinds = true;
        if (propertyExpression.getEvalType() == null
                || !propertyExpression.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(propertyExpression, expression);
            rightKinds = false;
        }
        if (filler.getEvalType() == null
                || !(filler.getEvalType().accept(classDetector) || filler.getEvalType()
                        .accept(dtDetector))) {
            reportIncompatibleSymbolType(filler, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (propertyExpression.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!filler.getEvalType().accept(dtDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = df
                            .getOWLDataSomeValuesFrom(
                                    (OWLDataPropertyExpression) propertyExpression
                                            .getOWLObject(), (OWLDataRange) filler
                                            .getOWLObject());
                }
            }
            if (propertyExpression.getEvalType().accept(opDetector)) {
                if (!filler.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, propertyExpression, filler);
                } else {
                    toReturn = df.getOWLObjectSomeValuesFrom(
                            (OWLObjectPropertyExpression) propertyExpression
                                    .getOWLObject(), (OWLClassExpression) filler
                                    .getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param property
     * @return symbol replaced owl object */
    public OWLObject getInverseProperty(CommonTree expression,
            ManchesterOWLSyntaxTree property) {
        OWLObjectPropertyExpression toReturn = null;
        if (property.getEvalType() == null || !property.getEvalType().accept(opDetector)) {
            reportIncompatibleSymbolType(property, expression);
        } else {
            toReturn = df.getOWLObjectInverseOf((OWLObjectPropertyExpression) property
                    .getOWLObject());
        }
        return toReturn;
    }

    /** @param node
     * @return symbol replaced owl object */
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
                public OWLEntity visitSymbol(Symbol s) {
                    SymbolTable.this.reportIncompatibleSymbolType(node, s.getType(), node);
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

    /** @param expression
     * @param node
     * @return symbol replaced owl object */
    public OWLObject getNegatedClassExpression(CommonTree expression,
            ManchesterOWLSyntaxTree node) {
        OWLObjectComplementOf toReturn = null;
        if (node.getEvalType() == null || !node.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(node, expression);
        } else {
            toReturn = df.getOWLObjectComplementOf((OWLClassExpression) node
                    .getOWLObject());
        }
        return toReturn;
    }

    /** @param expression
     * @param value
     * @param constantType
     * @return symbol replaced owl object */
    public OWLLiteral getOWLTypedConstant(final CommonTree expression,
            final ManchesterOWLSyntaxTree value,
            final ManchesterOWLSyntaxTree constantType) {
        Symbol typeSymbol = resolve(constantType);
        OWLLiteral toReturn = null;
        if (typeSymbol != null) {
            toReturn = typeSymbol.accept(new SymbolVisitorEx<OWLLiteral>() {
                @Override
                public OWLLiteral visitSymbol(Symbol symbol) {
                    SymbolTable.this.reportIncompatibleSymbolType(constantType,
                            expression);
                    return null;
                }

                @Override
                public OWLLiteral visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
                    SymbolTable.this.reportIncompatibleSymbolType(constantType,
                            expression);
                    return null;
                }

                @Override
                public OWLLiteral visitIRI(IRISymbol iriSymbol) {
                    return null;
                }

                @Override
                public OWLLiteral visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
                    if (owlEntitySymbol.getType() == OWLType.OWL_DATA_TYPE) {
                        return df.getOWLLiteral(value.getToken().getText(),
                                (OWLDatatype) owlEntitySymbol.getEntity());
                    }
                    return null;
                }
            });
        } else {
            errorListener.illegalToken(constantType,
                    "The type is not amongst the available ones");
        }
        return toReturn;
    }

    /** @param expression
     * @param value
     * @param lang
     * @return symbol replaced owl object */
    public OWLLiteral getOWLUntypedConstant(CommonTree expression,
            ManchesterOWLSyntaxTree value, ManchesterOWLSyntaxTree lang) {
        return value == null ? null : lang == null ? df.getOWLLiteral(value.getText())
                : df.getOWLLiteral(value.getText(), lang.getText());
    }

    /** @param expression
     * @param conjuncts
     * @return symbol replaced owl object */
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
                allFine = false;
                reportIncompatibleSymbolType(conjunct, expression);
            } else {
                rest = rest == null ? conjunct.getEvalType() : rest;
                if (rest != null) {
                    if (rest.accept(classDetector)) {
                        conjunctList.add((OWLClassExpression) conjunct.getOWLObject());
                    } else {
                        owlDataRangeList.add((OWLDataRange) conjunct.getOWLObject());
                    }
                }
            }
        }
        if (allFine && rest != null) {
            if (rest.accept(classDetector)) {
                toReturn = df.getOWLObjectIntersectionOf(conjunctList
                        .toArray(new OWLClassExpression[conjunctList.size()]));
            } else {
                toReturn = df.getOWLDataIntersectionOf(owlDataRangeList
                        .toArray(new OWLDataRange[owlDataRangeList.size()]));
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param chainItems
     * @return symbol replaced owl object */
    public OWLPropertyChain getPropertyChain(CommonTree expression,
            ManchesterOWLSyntaxTree[] chainItems) {
        OWLPropertyChain toReturn = null;
        boolean allFine = chainItems.length >= 2;
        if (allFine) {
            List<OWLObjectPropertyExpression> items = new ArrayList<OWLObjectPropertyExpression>(
                    chainItems.length);
            for (ManchesterOWLSyntaxTree item : chainItems) {
                if (item.getEvalType() == null || !item.getEvalType().accept(opDetector)) {
                    allFine = false;
                    reportIncompatibleSymbolType(item, expression);
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

    /** @param expression
     * @param disjuncts
     * @return symbol replaced owl object */
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
                reportIncompatibleSymbolType(disjunct, expression);
            } else {
                rest = rest == null ? disjunct.getEvalType() : rest;
                if (rest != null) {
                    if (rest.accept(classDetector)) {
                        disjunctList.add((OWLClassExpression) disjunct.getOWLObject());
                    } else {
                        owlDataRangeList.add((OWLDataRange) disjunct.getOWLObject());
                    }
                }
            }
        }
        if (allFine && rest != null) {
            if (rest.accept(classDetector)) {
                toReturn = df.getOWLObjectUnionOf(disjunctList
                        .toArray(new OWLClassExpression[disjunctList.size()]));
            } else {
                toReturn = df.getOWLDataUnionOf(owlDataRangeList
                        .toArray(new OWLDataRange[owlDataRangeList.size()]));
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param assertion
     * @return symbol replaced owl object */
    public OWLAxiom getNegatedAssertion(CommonTree expression,
            ManchesterOWLSyntaxTree assertion) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (assertion.getEvalType() == null
                || !assertion.getEvalType().accept(simpleAssertionDetector)) {
            reportIncompatibleSymbolType(assertion, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (assertion.getEvalType() == OWLAxiomType.OBJECT_PROPERTY_ASSERTION) {
                OWLObjectPropertyAssertionAxiom owlObjectPropertyAssertionAxiom = (OWLObjectPropertyAssertionAxiom) assertion
                        .getOWLObject();
                toReturn = df.getOWLNegativeObjectPropertyAssertionAxiom(
                        owlObjectPropertyAssertionAxiom.getProperty(),
                        owlObjectPropertyAssertionAxiom.getSubject(),
                        owlObjectPropertyAssertionAxiom.getObject());
            } else if (assertion.getEvalType() == OWLAxiomType.DATA_PROPERTY_ASSERTION) {
                OWLDataPropertyAssertionAxiom owlObjectPropertyAssertionAxiom = (OWLDataPropertyAssertionAxiom) assertion
                        .getOWLObject();
                toReturn = df.getOWLNegativeDataPropertyAssertionAxiom(
                        owlObjectPropertyAssertionAxiom.getProperty(),
                        owlObjectPropertyAssertionAxiom.getSubject(),
                        owlObjectPropertyAssertionAxiom.getObject());
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom
            getTransitiveProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return df.getOWLTransitiveObjectPropertyAxiom((OWLObjectPropertyExpression) p
                    .getOWLObject());
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom
            getSymmetricProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return df.getOWLSymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) p
                    .getOWLObject());
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom
            getAsymmetricProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return df.getOWLAsymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) p
                    .getOWLObject());
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom
            getReflexiveProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return df.getOWLReflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) p
                    .getOWLObject());
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom getIrreflexiveProperty(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return df
                    .getOWLIrreflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) p
                            .getOWLObject());
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom getInverseFunctionalProperty(CommonTree expression,
            ManchesterOWLSyntaxTree p) {
        if (OWLType.OWL_OBJECT_PROPERTY.match(p.getEvalType())) {
            return df
                    .getOWLInverseFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) p
                            .getOWLObject());
        }
        reportIncompatibleSymbolType(p, expression);
        return null;
    }

    /** @param expression
     * @param p
     * @return symbol replaced owl object */
    public OWLAxiom
            getFunctionalProperty(CommonTree expression, ManchesterOWLSyntaxTree p) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            rightKinds = false;
            reportIncompatibleSymbolType(p, expression);
        }
        if (rightKinds) {
            toReturn = p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY ? df
                    .getOWLFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) p
                            .getOWLObject()) : df
                    .getOWLFunctionalDataPropertyAxiom((OWLDataPropertyExpression) p
                            .getOWLObject());
        }
        return toReturn;
    }

    /** @param expression
     * @param anIndividual
     * @param anotherIndividual
     * @return symbol replaced owl object */
    public OWLAxiom getDifferentIndividualsAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        OWLDifferentIndividualsAxiom toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, expression);
        }
        if (anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual, expression);
        }
        if (rightKinds) {
            toReturn = df.getOWLDifferentIndividualsAxiom(
                    (OWLIndividual) anIndividual.getOWLObject(),
                    (OWLIndividual) anotherIndividual.getOWLObject());
        }
        return toReturn;
    }

    /** @param expression
     * @param anIndividual
     * @param anotherIndividual
     * @return symbol replaced owl object */
    public OWLAxiom getSameIndividualsAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree anIndividual,
            ManchesterOWLSyntaxTree anotherIndividual) {
        OWLSameIndividualAxiom toReturn = null;
        boolean rightKinds = true;
        if (anIndividual.getEvalType() == null
                || anIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anIndividual, expression);
        }
        if (anotherIndividual.getEvalType() == null
                || anotherIndividual.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            rightKinds = false;
            reportIncompatibleSymbolType(anotherIndividual, expression);
        }
        if (rightKinds) {
            toReturn = df.getOWLSameIndividualAxiom(new HashSet<OWLIndividual>(Arrays
                    .asList((OWLIndividual) anIndividual.getOWLObject(),
                            (OWLIndividual) anotherIndividual.getOWLObject())));
        }
        return toReturn;
    }

    /** @param expression
     * @param p
     * @param range
     * @return symbol replaced owl object */
    public OWLAxiom getRangeAxiom(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree range) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, expression);
            rightKinds = false;
        }
        if (range.getEvalType() == null || !range.getEvalType().accept(classDetector)
                && range.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(range, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!range.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, p, range);
                } else {
                    toReturn = df.getOWLObjectPropertyRangeAxiom(
                            (OWLObjectPropertyExpression) p.getOWLObject(),
                            (OWLClassExpression) range.getOWLObject());
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (range.getEvalType() != OWLType.OWL_DATA_TYPE) {
                    reportIncompatibleSymbols(expression, p, range);
                } else {
                    toReturn = df.getOWLDataPropertyRangeAxiom(
                            (OWLDataPropertyExpression) p.getOWLObject(),
                            (OWLDataRange) range.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param p
     * @param domain
     * @return symbol replaced owl object */
    public OWLAxiom getDomainAxiom(CommonTree expression, ManchesterOWLSyntaxTree p,
            ManchesterOWLSyntaxTree domain) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (p.getEvalType() == null || p.getEvalType() != OWLType.OWL_OBJECT_PROPERTY
                && p.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
            reportIncompatibleSymbolType(p, expression);
            rightKinds = false;
        }
        if (domain.getEvalType() == null || !domain.getEvalType().accept(classDetector)
                && domain.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(domain, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (p.getEvalType() == OWLType.OWL_OBJECT_PROPERTY) {
                if (!domain.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = df.getOWLObjectPropertyDomainAxiom(
                            (OWLObjectPropertyExpression) p.getOWLObject(),
                            (OWLClassExpression) domain.getOWLObject());
                }
            } else if (p.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (!domain.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, p, domain);
                } else {
                    toReturn = df.getOWLDataPropertyDomainAxiom(
                            (OWLDataPropertyExpression) p.getOWLObject(),
                            (OWLClassExpression) domain.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param description
     * @param subject
     * @return symbol replaced owl object */
    public OWLAxiom getClassAssertionAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree description, ManchesterOWLSyntaxTree subject) {
        OWLClassAssertionAxiom toReturn = null;
        boolean rightKinds = true;
        if (description.getEvalType() == null
                || !description.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(description, expression);
            rightKinds = false;
        }
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            toReturn = df.getOWLClassAssertionAxiom(
                    (OWLClassExpression) description.getOWLObject(),
                    (OWLIndividual) subject.getOWLObject());
        }
        return toReturn;
    }

    /** @param expression
     * @param subject
     * @param property
     * @param object
     * @return symbol replaced owl object */
    public OWLAxiom getRoleAssertionAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (subject.getEvalType() == null
                || subject.getEvalType() != OWLType.OWL_INDIVIDUAL) {
            reportIncompatibleSymbolType(subject, expression);
            rightKinds = false;
        }
        if (property.getEvalType() == null || !property.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(property, expression);
            rightKinds = false;
        }
        if (object.getEvalType() == null
                || object.getEvalType() != OWLType.OWL_INDIVIDUAL
                && object.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(object, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (property.getEvalType().accept(opDetector)) {
                if (object.getEvalType() != OWLType.OWL_INDIVIDUAL) {
                    reportIncompatibleSymbols(expression, property, object);
                } else {
                    toReturn = df.getOWLObjectPropertyAssertionAxiom(
                            (OWLObjectPropertyExpression) property.getOWLObject(),
                            (OWLIndividual) subject.getOWLObject(),
                            (OWLIndividual) object.getOWLObject());
                }
            } else if (property.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (object.getEvalType() != OWLType.OWL_CONSTANT) {
                    reportIncompatibleSymbols(expression, property, object);
                } else {
                    toReturn = df.getOWLDataPropertyAssertionAxiom(
                            (OWLDataPropertyExpression) property.getOWLObject(),
                            (OWLIndividual) subject.getOWLObject(),
                            (OWLLiteral) object.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param subProperty
     * @param superProperty
     * @return symbol replaced owl object */
    public OWLAxiom getSubPropertyAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree subProperty, ManchesterOWLSyntaxTree superProperty) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (subProperty.getEvalType() == null
                || !subProperty.getEvalType().accept(pDetector)
                && subProperty.getEvalType() != OWLType.OWL_PROPERTY_CHAIN) {
            reportIncompatibleSymbolType(subProperty, expression);
            rightKinds = false;
        }
        if (superProperty.getEvalType() == null
                || !superProperty.getEvalType().accept(pDetector)) {
            rightKinds = false;
            reportIncompatibleSymbolType(superProperty, expression);
        }
        boolean areChildrenCompatible = subProperty.getEvalType() == superProperty
                .getEvalType()
                || subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN
                && superProperty.getEvalType() == OWLType.OWL_OBJECT_PROPERTY;
        if (rightKinds && areChildrenCompatible) {
            if (areChildrenCompatible) {
                // There is a special axiom for property chain sub-property
                toReturn = subProperty.getEvalType() == OWLType.OWL_PROPERTY_CHAIN ? df
                        .getOWLSubPropertyChainOfAxiom((OWLPropertyChain) subProperty
                                .getOWLObject(),
                                (OWLObjectPropertyExpression) superProperty
                                        .getOWLObject()) : toReturn;
                if (toReturn == null) {
                    toReturn = subProperty.getEvalType().accept(opDetector) ? df
                            .getOWLSubObjectPropertyOfAxiom(
                                    (OWLObjectPropertyExpression) subProperty
                                            .getOWLObject(),
                                    (OWLObjectPropertyExpression) superProperty
                                            .getOWLObject()) : df
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

    /** @param expression
     * @param lhs
     * @param rhs
     * @return symbol replaced owl object */
    public OWLAxiom getDisjointAxiom(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(classDetector)
                && !lhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(lhs, expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(classDetector)
                && !rhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(rhs, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(classDetector)) {
                if (!rhs.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = df.getOWLDisjointClassesAxiom(
                            (OWLClassExpression) lhs.getOWLObject(),
                            (OWLClassExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType().accept(opDetector)) {
                if (!rhs.getEvalType().accept(opDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = df.getOWLDisjointObjectPropertiesAxiom(
                            (OWLObjectPropertyExpression) lhs.getOWLObject(),
                            (OWLObjectPropertyExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = df.getOWLDisjointDataPropertiesAxiom(
                            (OWLDataPropertyExpression) lhs.getOWLObject(),
                            (OWLDataPropertyExpression) rhs.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param lhs
     * @param rhs
     * @return symbol replaced owl object */
    public OWLAxiom getInverseOfAxiom(CommonTree expression, ManchesterOWLSyntaxTree lhs,
            ManchesterOWLSyntaxTree rhs) {
        OWLInverseObjectPropertiesAxiom toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(opDetector)) {
            reportIncompatibleSymbolType(lhs, expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(opDetector)) {
            reportIncompatibleSymbolType(rhs, expression);
            rightKinds = false;
        }
        if (rightKinds && lhs.getEvalType().accept(opDetector)) {
            if (!rhs.getEvalType().accept(opDetector)) {
                reportIncompatibleSymbols(expression, lhs, rhs);
            } else {
                toReturn = df.getOWLInverseObjectPropertiesAxiom(
                        (OWLObjectPropertyExpression) lhs.getOWLObject(),
                        (OWLObjectPropertyExpression) rhs.getOWLObject());
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param lhs
     * @param rhs
     * @return symbol replaced owl object */
    public OWLAxiom getEquivalentAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        OWLAxiom toReturn = null;
        boolean rightKinds = true;
        if (lhs.getEvalType() == null || !lhs.getEvalType().accept(classDetector)
                && !lhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(lhs, expression);
            rightKinds = false;
        }
        if (rhs.getEvalType() == null || !rhs.getEvalType().accept(classDetector)
                && !rhs.getEvalType().accept(pDetector)) {
            reportIncompatibleSymbolType(rhs, expression);
            rightKinds = false;
        }
        if (rightKinds) {
            if (lhs.getEvalType().accept(classDetector)) {
                if (!rhs.getEvalType().accept(classDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = df.getOWLEquivalentClassesAxiom(
                            (OWLClassExpression) lhs.getOWLObject(),
                            (OWLClassExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType().accept(opDetector)) {
                if (!rhs.getEvalType().accept(opDetector)) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = df.getOWLEquivalentObjectPropertiesAxiom(
                            (OWLObjectPropertyExpression) lhs.getOWLObject(),
                            (OWLObjectPropertyExpression) rhs.getOWLObject());
                }
            } else if (lhs.getEvalType() == OWLType.OWL_DATA_PROPERTY) {
                if (rhs.getEvalType() != OWLType.OWL_DATA_PROPERTY) {
                    reportIncompatibleSymbols(expression, lhs, rhs);
                } else {
                    toReturn = df.getOWLEquivalentDataPropertiesAxiom(
                            (OWLDataPropertyExpression) lhs.getOWLObject(),
                            (OWLDataPropertyExpression) rhs.getOWLObject());
                }
            }
        }
        return toReturn;
    }

    /** @param expression
     * @param subClass
     * @param superClass
     * @return symbol replaced owl object */
    public OWLAxiom getSubClassAxiom(CommonTree expression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
        OWLSubClassOfAxiom toReturn = null;
        if (subClass.getEvalType() == null
                || !subClass.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(subClass, expression);
        } else if (superClass.getEvalType() == null
                || !superClass.getEvalType().accept(classDetector)) {
            reportIncompatibleSymbolType(superClass, expression);
        } else {
            toReturn = df.getOWLSubClassOfAxiom(
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

    /** @return object property completions */
    public Set<String> getOWLObjectPropertyCompletions() {
        return getAllCompletions(OWLType.OWL_OBJECT_PROPERTY);
    }

    /** @return data property completions */
    public Set<String> getOWLDataPropertyCompletions() {
        return getAllCompletions(OWLType.OWL_DATA_PROPERTY);
    }

    /** @return class completions */
    public Set<String> getOWLClassCompletions() {
        return getAllCompletions(OWLType.OWL_CLASS);
    }

    /** @param type
     * @return completions */
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

    /** @param type
     * @return property completions */
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

    /** @return individual completions */
    public Set<String> getOWLIndividualCompletions() {
        return getAllCompletions(OWLType.OWL_INDIVIDUAL);
    }

    /** @param types
     * @return all completions */
    public Set<String> getAllCompletions(Type... types) {
        Set<String> toReturn = new HashSet<String>();
        for (Type type : types) {
            for (Symbol symbol : getGlobalScope().getAllSymbols(type)) {
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
        symbols.put(checkNotNull(token, "token").getText(),
                checkNotNull(symbol, "symbol"));
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
        symbols.put(checkNotNull(name, "name"), checkNotNull(symbol, "symbol"));
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

    /** dispose */
    public void dispose() {
        getGlobalScope().dispose();
    }

    /** @param facet
     * @param value
     * @param parentExpression
     * @return facet restriction type */
    public OWLType getOWLFacetRestrictionType(ManchesterOWLSyntaxTree facet,
            ManchesterOWLSyntaxTree value, CommonTree parentExpression) {
        OWLType toReturn = null;
        OWLFacet facetByShortName = OWLFacet.getFacetBySymbolicName(facet.getText());
        if (facetByShortName == null) {
            reportIllegalToken(facet, "Invalid facet token");
        } else if (value.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(value, parentExpression);
        } else {
            toReturn = OWLType.OWL_DATA_FACET;
        }
        return toReturn;
    }

    /** @param facet
     * @param value
     * @param parentExpression
     * @return owl facet restriction */
    public OWLFacetRestriction getOWLFacetRestriction(ManchesterOWLSyntaxTree facet,
            ManchesterOWLSyntaxTree value, CommonTree parentExpression) {
        OWLFacetRestriction toReturn = null;
        OWLFacet facetByShortName = OWLFacet.getFacetBySymbolicName(facet.getText());
        if (facetByShortName == null) {
            reportIllegalToken(facet, "Invalid facet token");
        } else if (value.getEvalType() != OWLType.OWL_CONSTANT) {
            reportIncompatibleSymbolType(value, parentExpression);
        } else {
            toReturn = df.getOWLFacetRestriction(facetByShortName,
                    (OWLLiteral) value.getOWLObject());
        }
        return toReturn;
    }

    /** @param dataType
     * @param parentExpression
     * @param facets
     * @return data range type */
    public OWLType getOWLDataRangeType(ManchesterOWLSyntaxTree dataType,
            ManchesterOWLSyntaxTree parentExpression, ManchesterOWLSyntaxTree... facets) {
        OWLType toReturn = null;
        if (dataType.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(dataType, parentExpression);
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
                    reportIncompatibleSymbolType(facet, parentExpression);
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

    /** @param dataType
     * @param parentExpression
     * @param facets
     * @return datatype restriction */
    public OWLDatatypeRestriction getOWLDataRange(ManchesterOWLSyntaxTree dataType,
            ManchesterOWLSyntaxTree parentExpression, ManchesterOWLSyntaxTree... facets) {
        OWLDatatypeRestriction toReturn = null;
        if (dataType.getEvalType() != OWLType.OWL_DATA_TYPE) {
            reportIncompatibleSymbolType(dataType, parentExpression);
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
                    reportIncompatibleSymbolType(facet, parentExpression);
                } else {
                    facetRestrictions.add((OWLFacetRestriction) facet.getOWLObject());
                }
            }
            if (allFine) {
                toReturn = df.getOWLDatatypeRestriction(
                        (OWLDatatype) dataType.getOWLObject(), facetRestrictions);
            }
        }
        return toReturn;
    }

    /** @param manchesterOWLSyntaxTree
     * @param node
     * @param propertyExpressions
     * @return haskey type */
    public Type
            getHasKeyType(ManchesterOWLSyntaxTree manchesterOWLSyntaxTree,
                    ManchesterOWLSyntaxTree node,
                    Set<ManchesterOWLSyntaxTree> propertyExpressions) {
        Type toReturn = null;
        if (node.getEvalType() == null || !node.getEvalType().accept(classDetector)) {
            reportIllegalToken(node, "A class expression is expected here");
        } else {
            boolean allFine = true;
            Iterator<ManchesterOWLSyntaxTree> iterator = propertyExpressions.iterator();
            while (allFine && iterator.hasNext()) {
                ManchesterOWLSyntaxTree propertyNode = iterator.next();
                allFine = propertyNode.getEvalType() != null
                        && propertyNode.getEvalType().accept(pDetector);
            }
            if (allFine) {
                toReturn = OWLAxiomType.HAS_KEY;
            }
        }
        return toReturn;
    }

    /** @param manchesterOWLSyntaxTree
     * @param node
     * @param propertyExpressions
     * @return haskey */
    public OWLHasKeyAxiom
            getHasKey(ManchesterOWLSyntaxTree manchesterOWLSyntaxTree,
                    ManchesterOWLSyntaxTree node,
                    Set<ManchesterOWLSyntaxTree> propertyExpressions) {
        OWLHasKeyAxiom toReturn = null;
        OWLClassExpression ce = null;
        if (node.getEvalType() == null || !node.getEvalType().accept(classDetector)
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
                        && propertyNode.getEvalType().accept(pDetector)
                        && propertyNode.getOWLObject() != null;
                if (allFine) {
                    pes.add((OWLPropertyExpression<?, ?>) propertyNode.getOWLObject());
                }
            }
            if (allFine) {
                toReturn = df.getOWLHasKeyAxiom(ce, pes);
            }
        }
        return toReturn;
    }

    /** @param parentExpression
     * @param iri
     * @param annotationPropertyNode
     * @param object
     * @return annotation assertion type */
    public Type
            getAnnotationAssertionType(final ManchesterOWLSyntaxTree parentExpression,
                    final ManchesterOWLSyntaxTree iri,
                    ManchesterOWLSyntaxTree annotationPropertyNode,
                    ManchesterOWLSyntaxTree object) {
        Type toReturn = null;
        Symbol test = retrieveSymbol(iri.getText());
        IRI subjectIRI = getIRI(test, iri, parentExpression);
        if (subjectIRI != null) {
            this.storeSymbol(iri.getToken(), new IRISymbol(iri.getText(), subjectIRI));
        }
        if (subjectIRI == null) {
            reportIllegalToken(iri, "Illegal IRI");
        } else if (annotationPropertyNode.getEvalType() == null
                || annotationPropertyNode.getEvalType() != OWLType.OWL_ANNOTATION_PROPERTY) {
            reportIncompatibleSymbolType(annotationPropertyNode, parentExpression);
        } else if (object.getEvalType() == null
                || !object.getEvalType().accept(annDetector)) {
            reportIncompatibleSymbols(parentExpression, object);
        } else {
            toReturn = OWLAxiomType.ANNOTATION_ASSERTION;
        }
        return toReturn;
    }

    IRI getIRI(Symbol test, final ManchesterOWLSyntaxTree iri,
            final ManchesterOWLSyntaxTree parentExpression) {
        return test == null ? IRI.create(iri.getText()) : test
                .accept(new SymbolVisitorEx<IRI>() {
                    @Override
                    public IRI visitSymbol(Symbol s) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri, s.getType(),
                                parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitOWLLiteral(OWLLiteralSymbol c) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri, c.getType(),
                                parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitOWLEntity(OWLEntitySymbol e) {
                        SymbolTable.this.reportIncompatibleSymbolType(iri, e.getType(),
                                parentExpression);
                        return null;
                    }

                    @Override
                    public IRI visitIRI(IRISymbol iriSymbol) {
                        return iriSymbol.getIRI();
                    }
                });
    }

    /** @param parentExpression
     * @param iri
     * @param annotationPropertyNode
     * @param object
     * @return annotation assertion */
    public OWLAnnotationAssertionAxiom getAnnotationAssertion(
            final ManchesterOWLSyntaxTree parentExpression,
            final ManchesterOWLSyntaxTree iri,
            final ManchesterOWLSyntaxTree annotationPropertyNode,
            ManchesterOWLSyntaxTree object) {
        OWLAnnotationAssertionAxiom toReturn = null;
        Symbol test = resolve(iri);
        IRI subjectIRI = getIRI(test, iri, parentExpression);
        if (subjectIRI == null) {
            reportIllegalToken(iri, "Illegal IRI");
        } else if (annotationPropertyNode.getEvalType() == null
                || annotationPropertyNode.getEvalType() != OWLType.OWL_ANNOTATION_PROPERTY) {
            reportIncompatibleSymbolType(annotationPropertyNode, parentExpression);
        } else if (annotationPropertyNode.getOWLObject() == null) {
            reportIllegalToken(annotationPropertyNode, "Invalid annotation property");
        } else if (object.getEvalType() == null
                || !object.getEvalType().accept(annDetector)) {
            reportIncompatibleSymbols(parentExpression, object);
        } else if (object.getOWLObject() == null) {
            reportIllegalToken(object, "Invalid object");
        } else {
            OWLAnnotation annotation = object.getOWLObject().accept(
                    new OWLObjectVisitorExAdapter<OWLAnnotation>() {
                        @Override
                        public OWLAnnotation visit(IRI i) {
                            return df.getOWLAnnotation(
                                    (OWLAnnotationProperty) annotationPropertyNode
                                            .getOWLObject(), i);
                        }

                        @Override
                        public OWLAnnotation visit(OWLLiteral literal) {
                            return df.getOWLAnnotation(
                                    (OWLAnnotationProperty) annotationPropertyNode
                                            .getOWLObject(), literal);
                        }
                    });
            toReturn = df.getOWLAnnotationAssertionAxiom(subjectIRI, annotation);
        }
        return toReturn;
    }

    /** @param node
     * @return symbol */
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
