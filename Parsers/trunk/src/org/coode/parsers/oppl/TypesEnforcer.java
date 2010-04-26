/**
 * 
 */
package org.coode.parsers.oppl;

import org.coode.parsers.ManchesterOWLSyntaxTree;

/**
 * @author Luigi Iannone
 * 
 */
public interface TypesEnforcer {
	public void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree subClass,
			ManchesterOWLSyntaxTree superClass);

	public void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs);

	public void enforceIverserOfAxiomTypes(OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty);

	public void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs);

	public void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree aProperty,
			ManchesterOWLSyntaxTree anotherProperty);

	public void enforceRoleAssertionAxiomTypes(OPPLSyntaxTree subject,
			ManchesterOWLSyntaxTree property, ManchesterOWLSyntaxTree object);

	public void enforceTypeAssertionAxiomTypes(ManchesterOWLSyntaxTree classDescription,
			OPPLSyntaxTree subject);

	public void enforceDomainAxiomTypes(OPPLSyntaxTree p, ManchesterOWLSyntaxTree classDescription);

	public void enforceRangeAxiomTypes(OPPLSyntaxTree p, ManchesterOWLSyntaxTree range);

	public void enforceSameIndividualsAxiomTypes(OPPLSyntaxTree anIndividual,
			OPPLSyntaxTree anotherIndividual);

	public void enforceDifferentIndividualsAxiomTypes(OPPLSyntaxTree anIndividual,
			OPPLSyntaxTree anotherIndividual);

	public void enforceFunctionalPropertyAxiomTypes(OPPLSyntaxTree p);

	public void enforceInverseFunctionalPropertyAxiomTypes(OPPLSyntaxTree p);

	public void enforceIrreflexivePropertyAxiomTypes(OPPLSyntaxTree p);

	public void enforceReflexivePropertyAxiomTypes(OPPLSyntaxTree p);

	public void enforceSymmetricPropertyAxiomTypes(OPPLSyntaxTree p);

	public void enforceTransitivePropertyAxiomTypes(OPPLSyntaxTree p);

	public void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree assertion);

	public void enforceDisjunctionTypes(ManchesterOWLSyntaxTree... disjuncts);

	public void enforcePropertyChainTypes(ManchesterOWLSyntaxTree... propertyExpressions);

	public void enforceConjunctionTypes(ManchesterOWLSyntaxTree... conjuncts);

	public void enforceNegatedClassExpression(ManchesterOWLSyntaxTree classExpression);

	public void enforceInverseObjectPropertyTypes(ManchesterOWLSyntaxTree p);

	public void enforceSomeValueRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler);

	public void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler);

	public void enforceMinCardinalityRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler);

	public void enforceMaxCardinalityRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler);

	public void enforceExactCardinalityRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler);

	public void enforceOneOfTypes(ManchesterOWLSyntaxTree... individuals);

	public void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree value);
}
