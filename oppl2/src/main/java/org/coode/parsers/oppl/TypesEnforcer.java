package org.coode.parsers.oppl;

import org.coode.parsers.ManchesterOWLSyntaxTree;

/** @author Luigi Iannone */
public interface TypesEnforcer {
    /** @param parentExpression
     * @param subClass
     * @param superClass */
    void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass);

    /** @param parentExpression
     * @param lhs
     * @param rhs */
    void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs);

    /** @param parentExpression
     * @param p
     * @param anotherProperty */
    void enforceIverserOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty);

    /** @param parentExpression
     * @param lhs
     * @param rhs */
    void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs);

    /** @param parentExpression
     * @param aProperty
     * @param anotherProperty */
    void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree aProperty, ManchesterOWLSyntaxTree anotherProperty);

    /** @param parentExpression
     * @param subject
     * @param property
     * @param object */
    void enforceRoleAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object);

    /** @param parentExpression
     * @param classDescription
     * @param subject */
    void enforceTypeAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classDescription, OPPLSyntaxTree subject);

    /** @param parentExpression
     * @param p
     * @param classDescription */
    void enforceDomainAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree classDescription);

    /** @param parentExpression
     * @param p
     * @param range */
    void enforceRangeAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree range);

    /** @param parentExpression
     * @param anIndividual
     * @param anotherIndividual */
    void enforceSameIndividualsAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree anIndividual, OPPLSyntaxTree anotherIndividual);

    /** @param parentExpression
     * @param anIndividual
     * @param anotherIndividual */
    void enforceDifferentIndividualsAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree anIndividual, OPPLSyntaxTree anotherIndividual);

    /** @param parentExpression
     * @param p */
    void enforceFunctionalPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     * @param p */
    void enforceInverseFunctionalPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    /** @param parentExpression
     * @param p */
    void enforceIrreflexivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     * @param p */
    void enforceReflexivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     * @param p */
    void enforceSymmetricPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     * @param p */
    void enforceTransitivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     * @param assertion */
    void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree assertion);

    /** @param parentExpression
     * @param disjuncts */
    void enforceDisjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... disjuncts);

    /** @param parentExpression
     * @param propertyExpressions */
    void enforcePropertyChainTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... propertyExpressions);

    /** @param parentExpression
     * @param conjuncts */
    void enforceConjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... conjuncts);

    /** @param parentExpression
     * @param classExpression */
    void enforceNegatedClassExpression(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classExpression);

    /** @param parentExpression
     * @param p */
    void enforceInverseObjectPropertyTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree p);

    /** @param parentExpression
     * @param propertyExpression
     * @param filler */
    void enforceSomeValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     * @param propertyExpression
     * @param filler */
    void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     * @param propertyExpression
     * @param filler */
    void enforceMinCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     * @param propertyExpression
     * @param filler */
    void enforceMaxCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     * @param propertyExpression
     * @param filler */
    void enforceExactCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     * @param individuals */
    void enforceOneOfTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... individuals);

    /** @param parentExpression
     * @param propertyExpression
     * @param value */
    void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value);
}
