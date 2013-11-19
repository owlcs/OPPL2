
package org.coode.parsers.oppl;

import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Type;
import org.coode.parsers.TypeVistorAdapter;
import org.semanticweb.owlapi.model.OWLEntity;

/** @author Luigi Iannone */
@SuppressWarnings("incomplete-switch")
public class DefaultTypeEnforcer implements TypesEnforcer {
    private final OPPLSymbolTable symbolTable;
    private final OWLEntityFactory entityFactory;
    private final ErrorListener errorListener;

    /** @param symbolTable
     * @param entityFactory
     * @param listener */
    public DefaultTypeEnforcer(OPPLSymbolTable symbolTable,
            OWLEntityFactory entityFactory, ErrorListener listener) {
        if (symbolTable == null) {
            throw new NullPointerException("The symbol table cannot be null");
        }
        if (entityFactory == null) {
            throw new NullPointerException("The entity factory cannot be null");
        }
        if (listener == null) {
            throw new NullPointerException("The error listener cannot be null");
        }
        this.symbolTable = symbolTable;
        this.entityFactory = entityFactory;
        errorListener = listener;
    }

    @Override
    public void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            final ManchesterOWLSyntaxTree propertyExpression,
            ManchesterOWLSyntaxTree filler) {
        enforceQualifiedRestrictionTypes(parentExpression, propertyExpression, filler);
    }

    /** @param propertyExpression
     * @param filler */
    private void enforceQualifiedRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            final ManchesterOWLSyntaxTree propertyExpression,
            ManchesterOWLSyntaxTree filler) {
        if (propertyExpression == null) {
            throw new NullPointerException("The propertyExpression cannot be null");
        }
        if (filler == null) {
            throw new NullPointerException("The filler cannot be null");
        }
        if (filler.getEvalType() != null) {
            if (filler.getEvalType() == CreateOnDemand.get()
                    && propertyExpression.getEvalType() == CreateOnDemand.get()) {
                getErrorListener().incompatibleSymbols(parentExpression,
                        propertyExpression, filler);
            }
            if (filler.getEvalType() == CreateOnDemand.get()) {
                this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
            } else {
                filler.getEvalType().accept(new TypeVistorAdapter() {
                    @Override
                    public void visitOWLType(OWLType owlType) {
                        if (OWLType.isClassExpression(owlType)) {
                            DefaultTypeEnforcer.this.enforceType(propertyExpression,
                                    OWLType.OWL_OBJECT_PROPERTY);
                        }
                        if (owlType == OWLType.OWL_DATA_TYPE) {
                            DefaultTypeEnforcer.this.enforceType(propertyExpression,
                                    OWLType.OWL_DATA_PROPERTY);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void enforceConjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... conjuncts) {
        enforceNaryClassExpressionTypes(conjuncts);
    }

    /** @param classExpressions */
    private void enforceNaryClassExpressionTypes(
            ManchesterOWLSyntaxTree... classExpressions) {
        for (ManchesterOWLSyntaxTree classExpression : classExpressions) {
            this.enforceType(classExpression, OWLType.OWL_CLASS);
        }
    }

    @Override
    public void enforceDifferentIndividualsAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree anIndividual,
            OPPLSyntaxTree anotherIndividual) {
        enforceBinaryIndividualAxiomType(anIndividual, anotherIndividual);
    }

    /** @param anIndividual
     * @param anotherIndividual */
    private void enforceBinaryIndividualAxiomType(OPPLSyntaxTree anIndividual,
            OPPLSyntaxTree anotherIndividual) {
        this.enforceType(anIndividual, OWLType.OWL_INDIVIDUAL);
        this.enforceType(anotherIndividual, OWLType.OWL_INDIVIDUAL);
    }

    @Override
    public void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expresion cannot be null");
        }
        if (lhs == null) {
            throw new NullPointerException("The left hand side expression cannot be null");
        }
        if (rhs == null) {
            throw new NullPointerException(
                    "The right hand side expression cannot be null");
        }
        enforceBinaryAxiomTypes(parentExpression, lhs, rhs);
    }

    /** @param parentExpression
     * @param lhs
     * @param rhs */
    private void enforceBinaryAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expresion cannot be null");
        }
        if (lhs == null) {
            throw new NullPointerException("The left hand side expression cannot be null");
        }
        if (rhs == null) {
            throw new NullPointerException(
                    "The right hand side expression cannot be null");
        }
        if (lhs.getEvalType() == CreateOnDemand.get()
                && rhs.getEvalType() == CreateOnDemand.get()) {
            getErrorListener().incompatibleSymbols(parentExpression, lhs, rhs);
        } else {
            if (rhs.getEvalType() == CreateOnDemand.get()) {
                this.enforceType(lhs, rhs);
            }
            if (lhs.getEvalType() == CreateOnDemand.get()) {
                this.enforceType(rhs, lhs);
            }
        }
    }

    /** @param from
     * @param to */
    private void enforceType(ManchesterOWLSyntaxTree from, ManchesterOWLSyntaxTree to) {
        if (from == null) {
            throw new NullPointerException("The type source cannot be null");
        }
        if (to == null) {
            throw new NullPointerException("The type destination cannot be null");
        }
        if (OWLType.isObjectPropertyExpression(from.getEvalType())) {
            this.enforceType(to, OWLType.OWL_OBJECT_PROPERTY);
        }
        if (OWLType.isClassExpression(from.getEvalType())) {
            this.enforceType(to, OWLType.OWL_CLASS);
        }
        if (OWLType.OWL_DATA_PROPERTY == from.getEvalType()) {
            this.enforceType(to, OWLType.OWL_DATA_PROPERTY);
        }
    }

    @Override
    public void enforceDisjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... disjuncts) {
        enforceNaryClassExpressionTypes(disjuncts);
    }

    @Override
    public void enforceDomainAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree classDescription) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expresion cannot be null");
        }
        if (p == null) {
            throw new NullPointerException("The property cannot be null");
        }
        if (classDescription == null) {
            throw new NullPointerException("The domain cannot be null");
        }
        if (p.getEvalType() == CreateOnDemand.get()) {
            getErrorListener().illegalToken(
                    p,
                    "Cannot decide whether " + p.getText()
                            + " is a data or an object type property");
        } else {
            this.enforceType(classDescription, OWLType.OWL_CLASS);
        }
    }

    @Override
    public void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expresion cannot be null");
        }
        if (lhs == null) {
            throw new NullPointerException("The left hand side expression cannot be null");
        }
        if (rhs == null) {
            throw new NullPointerException(
                    "The right hand side expression cannot be null");
        }
        enforceBinaryAxiomTypes(parentExpression, lhs, rhs);
    }

    @Override
    public void enforceExactCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        enforceCardinalityRestrictionTypes(parentExpression, propertyExpression, filler);
    }

    /** @param parentExpression
     * @param propertyExpression
     * @param filler */
    private void enforceCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expression cannot be null");
        }
        if (propertyExpression == null) {
            throw new NullPointerException("The property cannot be null");
        }
        if (filler == null) {
            if (propertyExpression.getEvalType() == CreateOnDemand.get()) {
                getErrorListener().illegalToken(
                        propertyExpression,
                        "Cannot decide whether " + propertyExpression.getText()
                                + " is a data or an object property");
            }
        } else {
            if (filler.getEvalType() == CreateOnDemand.get()
                    && propertyExpression.getEvalType() == CreateOnDemand.get()) {
                getErrorListener().incompatibleSymbols(parentExpression,
                        propertyExpression, filler);
            } else {
                if (propertyExpression.getEvalType() == CreateOnDemand.get()) {
                    this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
                } else if (filler.getEvalType() == CreateOnDemand.get()) {
                    this.enforceType(filler, OWLType.OWL_CLASS);
                }
            }
        }
    }

    @Override
    public void enforceFunctionalPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceInverseFunctionalPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceInverseObjectPropertyTypes(
            ManchesterOWLSyntaxTree parentExpression, ManchesterOWLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceIrreflexivePropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceIverserOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty) {
        enforceBinaryAxiomTypes(parentExpression, p, anotherProperty);
    }

    @Override
    public void enforceMaxCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        enforceCardinalityRestrictionTypes(parentExpression, propertyExpression, filler);
    }

    @Override
    public void enforceMinCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        enforceCardinalityRestrictionTypes(parentExpression, propertyExpression, filler);
    }

    @Override
    public void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree assertion) {}

    @Override
    public void enforceNegatedClassExpression(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classExpression) {}

    @Override
    public void enforceOneOfTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... individuals) {
        if (individuals == null) {
            throw new NullPointerException("The individual array cannot be null");
        }
        for (ManchesterOWLSyntaxTree individual : individuals) {
            this.enforceType(individual, OWLType.OWL_INDIVIDUAL);
        }
    }

    /** This method enforces a type only on to symbols that have been marked as
     * create on demand ones. In OPPL syntax those symbols are denoted by an
     * exclamation mark prefix.
     * 
     * @param t
     * @param type */
    protected void enforceType(ManchesterOWLSyntaxTree t, OWLType type) {
        if (t == null) {
            throw new NullPointerException(
                    "The expression whose type has to be enforced cannot be null");
        }
        if (type == null) {
            throw new NullPointerException("Cannot enforce a null type");
        }
        String name = t.getToken().getText();
        if (t.getEvalType() == CreateOnDemand.get()) {
            OWLEntity entity = null;
            String newEntityName = name.replace("!", "");
            switch (type) {
                case OWL_CLASS:
                    try {
                        entity = getOWLEntityFactory()
                                .createOWLClass(newEntityName, null).getOWLEntity();
                    } catch (OWLEntityCreationException e) {
                        errorListener.illegalToken(t,
                                "Unable to create an OWL Class for " + name
                                        + " because of " + e.getMessage());
                    }
                    break;
                case OWL_OBJECT_PROPERTY:
                    try {
                        entity = getOWLEntityFactory().createOWLObjectProperty(
                                newEntityName, null).getOWLEntity();
                    } catch (OWLEntityCreationException e) {
                        errorListener.illegalToken(t,
                                "Unable to create an OWL Object property for " + name
                                        + " because of " + e.getMessage());
                    }
                    break;
                case OWL_DATA_PROPERTY:
                    try {
                        entity = getOWLEntityFactory().createOWLDataProperty(
                                newEntityName, null).getOWLEntity();
                    } catch (OWLEntityCreationException e) {
                        errorListener.illegalToken(t,
                                "Unable to create an OWL Data property for " + name
                                        + " because of " + e.getMessage());
                    }
                    break;
                case OWL_INDIVIDUAL:
                    try {
                        entity = getOWLEntityFactory().createOWLIndividual(newEntityName,
                                null).getOWLEntity();
                    } catch (OWLEntityCreationException e) {
                        errorListener.illegalToken(t,
                                "Unable to create an OWL Individual for " + name
                                        + " because of " + e.getMessage());
                    }
                    break;
                default:
                    break;
            }
            if (entity != null) {
                getSymbolTable().define(t.getToken(), new OWLEntitySymbol(name, entity));
            }
        }
    }

    @Override
    public void enforcePropertyChainTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... propertyExpressions) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expression cannot be null");
        }
        if (propertyExpressions == null) {
            throw new NullPointerException("The property expressions cannot be null");
        }
        for (ManchesterOWLSyntaxTree propertyExpression : propertyExpressions) {
            this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
        }
    }

    @Override
    public void enforceRangeAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            final OPPLSyntaxTree p, ManchesterOWLSyntaxTree range) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expresion cannot be null");
        }
        if (p == null) {
            throw new NullPointerException("The property cannot be null");
        }
        if (range == null) {
            throw new NullPointerException("The range cannot be null");
        }
        Type evalType = range.getEvalType();
        if (evalType == CreateOnDemand.get()) {
            this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
        } else {
            if (evalType != null) {
                evalType.accept(new TypeVistorAdapter() {
                    @Override
                    public void visitOWLType(OWLType owlType) {
                        if (OWLType.isClassExpression(owlType)) {
                            DefaultTypeEnforcer.this.enforceType(p,
                                    OWLType.OWL_OBJECT_PROPERTY);
                        }
                        if (owlType == OWLType.OWL_DATA_TYPE) {
                            DefaultTypeEnforcer.this.enforceType(p,
                                    OWLType.OWL_DATA_PROPERTY);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void enforceReflexivePropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceRoleAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object) {
        this.enforceType(subject, OWLType.OWL_INDIVIDUAL);
        if (object.getEvalType() == CreateOnDemand.get()) {
            this.enforceType(object, OWLType.OWL_INDIVIDUAL);
            this.enforceType(property, OWLType.OWL_OBJECT_PROPERTY);
        } else if (object.getEvalType() == OWLType.OWL_INDIVIDUAL) {
            this.enforceType(property, OWLType.OWL_OBJECT_PROPERTY);
        } else if (object.getEvalType() == OWLType.OWL_CONSTANT) {
            this.enforceType(property, OWLType.OWL_DATA_PROPERTY);
        }
    }

    @Override
    public void enforceSameIndividualsAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree anIndividual,
            OPPLSyntaxTree anotherIndividual) {
        enforceBinaryIndividualAxiomType(anIndividual, anotherIndividual);
    }

    @Override
    public void enforceSomeValueRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
        enforceQualifiedRestrictionTypes(parentExpression, propertyExpression, filler);
    }

    @Override
    public void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
        enforceBinaryAxiomTypes(parentExpression, subClass, superClass);
    }

    @Override
    public void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree aProperty, ManchesterOWLSyntaxTree anotherProperty) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expresion cannot be null");
        }
        if (aProperty == null) {
            throw new NullPointerException("The left hand side expression cannot be null");
        }
        if (anotherProperty == null) {
            throw new NullPointerException(
                    "The right hand side expression cannot be null");
        }
        enforceBinaryAxiomTypes(parentExpression, aProperty, anotherProperty);
    }

    @Override
    public void enforceSymmetricPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceTransitivePropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
        this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
    }

    @Override
    public void enforceTypeAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classDescription, OPPLSyntaxTree subject) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expression cannot  be null");
        }
        if (classDescription == null) {
            throw new NullPointerException("The class description cannot  be null");
        }
        if (subject == null) {
            throw new NullPointerException("The subject cannot  be null");
        }
        this.enforceType(subject, OWLType.OWL_INDIVIDUAL);
        this.enforceType(classDescription, OWLType.OWL_CLASS);
    }

    @Override
    public void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            final ManchesterOWLSyntaxTree propertyExpression,
            ManchesterOWLSyntaxTree value) {
        if (parentExpression == null) {
            throw new NullPointerException("The parent expression cannot be null");
        }
        if (propertyExpression == null) {
            throw new NullPointerException("The propertyExpression cannot be null");
        }
        if (value == null) {
            throw new NullPointerException("The value cannot be null");
        }
        if (value.getEvalType() == CreateOnDemand.get()
                && propertyExpression.getEvalType() == CreateOnDemand.get()) {
            getErrorListener().incompatibleSymbols(parentExpression, propertyExpression,
                    value);
        } else if (value.getEvalType() == CreateOnDemand.get()) {
            this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
        } else {
            value.getEvalType().accept(new TypeVistorAdapter() {
                @Override
                public void visitOWLType(OWLType owlType) {
                    if (OWLType.isClassExpression(owlType)) {
                        DefaultTypeEnforcer.this.enforceType(propertyExpression,
                                OWLType.OWL_OBJECT_PROPERTY);
                    }
                    if (owlType == OWLType.OWL_DATA_TYPE) {
                        DefaultTypeEnforcer.this.enforceType(propertyExpression,
                                OWLType.OWL_DATA_PROPERTY);
                    }
                }
            });
        }
    }

    /** @return the symbolTable */
    public OPPLSymbolTable getSymbolTable() {
        return symbolTable;
    }

    /** @return the entityFactory */
    public OWLEntityFactory getOWLEntityFactory() {
        return entityFactory;
    }

    /** @return the errorListener */
    public ErrorListener getErrorListener() {
        return errorListener;
    }
}
