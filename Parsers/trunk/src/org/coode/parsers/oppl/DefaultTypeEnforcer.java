/**
 * 
 */
package org.coode.parsers.oppl;

import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.OWLType;
import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolTable;

/**
 * @author Luigi Iannone
 * 
 */
public class DefaultTypeEnforcer implements TypesEnforcer {
	private final SymbolTable symbolTable;

	/**
	 * @param symbolTable
	 */
	public DefaultTypeEnforcer(SymbolTable symbolTable) {
		if (symbolTable == null) {
			throw new NullPointerException("The symbol table cannot be null");
		}
		this.symbolTable = symbolTable;
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceAllValueRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceConjunctionTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforceConjunctionTypes(ManchesterOWLSyntaxTree... conjuncts) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDifferentIndividualsAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceDifferentIndividualsAxiomTypes(OPPLSyntaxTree anIndividual,
			OPPLSyntaxTree anotherIndividual) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDisjointWithAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDisjunctionTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforceDisjunctionTypes(ManchesterOWLSyntaxTree... disjuncts) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDomainAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceDomainAxiomTypes(OPPLSyntaxTree p, ManchesterOWLSyntaxTree classDescription) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceEquivalentToAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree lhs,
			ManchesterOWLSyntaxTree rhs) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceExactCardinalityRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceExactCardinalityRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceFunctionalPropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceFunctionalPropertyAxiomTypes(OPPLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceInverseFunctionalPropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceInverseFunctionalPropertyAxiomTypes(OPPLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceInverseObjectPropertyTypes(org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceInverseObjectPropertyTypes(ManchesterOWLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceIrreflexivePropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceIrreflexivePropertyAxiomTypes(OPPLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceIverserOfAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceIverserOfAxiomTypes(OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceMaxCardinalityRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceMaxCardinalityRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceMinCardinalityRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceMinCardinalityRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceNegatedAssertionTypes(org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree assertion) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceNegatedClassExpression(org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceNegatedClassExpression(ManchesterOWLSyntaxTree classExpression) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceOneOfTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforceOneOfTypes(ManchesterOWLSyntaxTree... individuals) {
		if (individuals == null) {
			throw new NullPointerException("The individual array cannot be null");
		}
		for (ManchesterOWLSyntaxTree individual : individuals) {
			this.enforceType(individual, OWLType.OWL_INDIVIDUAL);
		}
	}

	private void enforceType(ManchesterOWLSyntaxTree t, OWLType type) {
		if (t == null) {
			throw new NullPointerException(
					"The expression whose type has to be enforced cannot be null");
		}
		if(type==null){
			throw new  NullPointerException("Cannot enforce a null type");
		}
		if(t.getEvalType()== CreateOnDemand.get()){
			this.getSymbolTable().
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforcePropertyChainTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforcePropertyChainTypes(ManchesterOWLSyntaxTree... propertyExpressions) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceRangeAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceRangeAxiomTypes(OPPLSyntaxTree p, ManchesterOWLSyntaxTree range) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceReflexivePropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceReflexivePropertyAxiomTypes(OPPLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceRoleAssertionAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceRoleAssertionAxiomTypes(OPPLSyntaxTree subject,
			ManchesterOWLSyntaxTree property, ManchesterOWLSyntaxTree object) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSameIndividualsAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceSameIndividualsAxiomTypes(OPPLSyntaxTree anIndividual,
			OPPLSyntaxTree anotherIndividual) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSomeValueRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceSomeValueRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree filler) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSubClassOfAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree subClass,
			ManchesterOWLSyntaxTree superClass) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSubPropertyAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree aProperty,
			ManchesterOWLSyntaxTree anotherProperty) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSymmetricPropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceSymmetricPropertyAxiomTypes(OPPLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceTransitivePropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceTransitivePropertyAxiomTypes(OPPLSyntaxTree p) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceTypeAssertionAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceTypeAssertionAxiomTypes(ManchesterOWLSyntaxTree classDescription,
			OPPLSyntaxTree subject) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceValueRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree propertyExpression,
			ManchesterOWLSyntaxTree value) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the symbolTable
	 */
	public SymbolTable getSymbolTable() {
		return this.symbolTable;
	}
}
