
package org.coode.parsers.oppl;

import org.coode.parsers.ManchesterOWLSyntaxTree;

/** @author Luigi Iannone */
public interface TypesEnforcer {
    public void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass);

    public void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs);

    public void enforceIverserOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty);

    public void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs);

    public void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree aProperty, ManchesterOWLSyntaxTree anotherProperty);

    public void enforceRoleAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree subject, ManchesterOWLSyntaxTree property,
            ManchesterOWLSyntaxTree object);

    public void enforceTypeAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classDescription, OPPLSyntaxTree subject);

    public void enforceDomainAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree classDescription);

    public void enforceRangeAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
            OPPLSyntaxTree p, ManchesterOWLSyntaxTree range);

    public void enforceSameIndividualsAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree anIndividual,
            OPPLSyntaxTree anotherIndividual);

    public void enforceDifferentIndividualsAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree anIndividual,
            OPPLSyntaxTree anotherIndividual);

    public void enforceFunctionalPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    public void enforceInverseFunctionalPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    public void enforceIrreflexivePropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    public void enforceReflexivePropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    public void enforceSymmetricPropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    public void enforceTransitivePropertyAxiomTypes(
            ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p);

    public void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree assertion);

    public void enforceDisjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... disjuncts);

    public void enforcePropertyChainTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... propertyExpressions);

    public void enforceConjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... conjuncts);

    public void enforceNegatedClassExpression(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree classExpression);

    public void enforceInverseObjectPropertyTypes(
            ManchesterOWLSyntaxTree parentExpression, ManchesterOWLSyntaxTree p);

    public void enforceSomeValueRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    public void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    public void enforceMinCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    public void enforceMaxCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    public void enforceExactCardinalityRestrictionTypes(
            ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler);

    public void enforceOneOfTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree... individuals);

    public void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
            ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value);
}
