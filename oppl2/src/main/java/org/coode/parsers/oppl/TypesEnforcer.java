package org.coode.parsers.oppl;

import org.coode.parsers.ManchesterOWLSyntaxTree;

/** @author Luigi Iannone */
public interface TypesEnforcer {
    /** @param parentExpression
     *            parentExpression
     * @param subClass
     *            subClass
     * @param superClass
     *            superClass */
    void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass);

    /** @param parentExpression
     *            parentExpression
     * @param lhs
     *            lhs
     * @param rhs
     *            rhs */
    void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p
     * @param anotherProperty
     *            anotherProperty */
    void enforceIverserOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty);

    /** @param parentExpression
     *            parentExpression
     * @param lhs
     *            lhs
     * @param rhs
     *            rhs */
    void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs);

    /** @param parentExpression
     *            parentExpression
     * @param aProperty
     *            aProperty
     * @param anotherProperty
     *            anotherProperty */
    void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree aProperty, ManchesterOWLSyntaxTree anotherProperty);

    /** @param parentExpression
     *            parentExpression
     * @param subject
     *            subject
     * @param property
     *            property
     * @param object
     *            object */
    void enforceRoleAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object);

    /** @param parentExpression
     *            parentExpression
     * @param classDescription
     *            classDescription
     * @param subject
     *            subject */
    void enforceTypeAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classDescription, OPPLSyntaxTree subject);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p
     * @param classDescription
     *            classDescription */
    void enforceDomainAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree classDescription);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p
     * @param range
     *            range */
    void enforceRangeAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree range);

    /** @param parentExpression
     *            parentExpression
     * @param anIndividual
     *            anIndividual
     * @param anotherIndividual
     *            anotherIndividual */
    void enforceSameIndividualsAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree anIndividual, OPPLSyntaxTree anotherIndividual);

    /** @param parentExpression
     *            parentExpression
     * @param anIndividual
     *            anIndividual
     * @param anotherIndividual
     *            anotherIndividual */
    void enforceDifferentIndividualsAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree anIndividual, OPPLSyntaxTree anotherIndividual);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceFunctionalPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceInverseFunctionalPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceIrreflexivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceReflexivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceSymmetricPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceTransitivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param assertion
     *            assertion */
    void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree assertion);

    /** @param parentExpression
     *            parentExpression
     * @param disjuncts
     *            disjuncts */
    void enforceDisjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... disjuncts);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpressions
     *            propertyExpressions */
    void enforcePropertyChainTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... propertyExpressions);

    /** @param parentExpression
     *            parentExpression
     * @param conjuncts
     *            conjuncts */
    void enforceConjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... conjuncts);

    /** @param parentExpression
     *            parentExpression
     * @param classExpression
     *            classExpression */
    void enforceNegatedClassExpression(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classExpression);

    /** @param parentExpression
     *            parentExpression
     * @param p
     *            p */
    void enforceInverseObjectPropertyTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree p);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpression
     *            propertyExpression
     * @param filler
     *            filler */
    void enforceSomeValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpression
     *            propertyExpression
     * @param filler
     *            filler */
    void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpression
     *            propertyExpression
     * @param filler
     *            filler */
    void enforceMinCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpression
     *            propertyExpression
     * @param filler
     *            filler */
    void enforceMaxCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpression
     *            propertyExpression
     * @param filler
     *            filler */
    void enforceExactCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    /** @param parentExpression
     *            parentExpression
     * @param individuals
     *            individuals */
    void enforceOneOfTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... individuals);

    /** @param parentExpression
     *            parentExpression
     * @param propertyExpression
     *            propertyExpression
     * @param value
     *            value */
    void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value);
}
