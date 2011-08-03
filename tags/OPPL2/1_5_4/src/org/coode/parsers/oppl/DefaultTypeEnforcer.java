/**
 * 
 */
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

/**
 * @author Luigi Iannone
 * 
 */
public class DefaultTypeEnforcer implements TypesEnforcer {
	private final OPPLSymbolTable symbolTable;
	private final OWLEntityFactory entityFactory;
	private final ErrorListener errorListener;

	/**
	 * @param symbolTable
	 */
	public DefaultTypeEnforcer(OPPLSymbolTable symbolTable, OWLEntityFactory entityFactory,
			ErrorListener listener) {
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
		this.errorListener = listener;
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceAllValueRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceAllValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			final ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		this.enforceQualifiedRestrictionTypes(parentExpression, propertyExpression, filler);
	}

	/**
	 * @param propertyExpression
	 * @param filler
	 */
	private void enforceQualifiedRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			final ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		if (propertyExpression == null) {
			throw new NullPointerException("The propertyExpression cannot be null");
		}
		if (filler == null) {
			throw new NullPointerException("The filler cannot be null");
		}
		if (filler.getEvalType() != null) {
			if (filler.getEvalType() == CreateOnDemand.get()
					&& propertyExpression.getEvalType() == CreateOnDemand.get()) {
				this.getErrorListener().incompatibleSymbols(
						parentExpression,
						propertyExpression,
						filler);
			}
			if (filler.getEvalType() == CreateOnDemand.get()) {
				this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
			} else {
				filler.getEvalType().accept(new TypeVistorAdapter() {
					@Override
					public void visitOWLType(OWLType owlType) {
						if (OWLType.isClassExpression(owlType)) {
							DefaultTypeEnforcer.this.enforceType(
									propertyExpression,
									OWLType.OWL_OBJECT_PROPERTY);
						}
						if (owlType == OWLType.OWL_DATA_TYPE) {
							DefaultTypeEnforcer.this.enforceType(
									propertyExpression,
									OWLType.OWL_DATA_PROPERTY);
						}
					}
				});
			}
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceConjunctionTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforceConjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree... conjuncts) {
		this.enforceNaryClassExpressionTypes(conjuncts);
	}

	/**
	 * @param classExpressions
	 */
	private void enforceNaryClassExpressionTypes(ManchesterOWLSyntaxTree... classExpressions) {
		for (ManchesterOWLSyntaxTree classExpression : classExpressions) {
			this.enforceType(classExpression, OWLType.OWL_CLASS);
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDifferentIndividualsAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceDifferentIndividualsAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree anIndividual, OPPLSyntaxTree anotherIndividual) {
		this.enforceBinaryIndividualAxiomType(anIndividual, anotherIndividual);
	}

	/**
	 * @param anIndividual
	 * @param anotherIndividual
	 */
	private void enforceBinaryIndividualAxiomType(OPPLSyntaxTree anIndividual,
			OPPLSyntaxTree anotherIndividual) {
		this.enforceType(anIndividual, OWLType.OWL_INDIVIDUAL);
		this.enforceType(anotherIndividual, OWLType.OWL_INDIVIDUAL);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDisjointWithAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceDisjointWithAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
		if (parentExpression == null) {
			throw new NullPointerException("The parent expresion cannot be null");
		}
		if (lhs == null) {
			throw new NullPointerException("The left hand side expression cannot be null");
		}
		if (rhs == null) {
			throw new NullPointerException("The right hand side expression cannot be null");
		}
		this.enforceBinaryAxiomTypes(parentExpression, lhs, rhs);
	}

	/**
	 * @param parentExpression
	 * @param lhs
	 * @param rhs
	 */
	private void enforceBinaryAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
		if (parentExpression == null) {
			throw new NullPointerException("The parent expresion cannot be null");
		}
		if (lhs == null) {
			throw new NullPointerException("The left hand side expression cannot be null");
		}
		if (rhs == null) {
			throw new NullPointerException("The right hand side expression cannot be null");
		}
		if (lhs.getEvalType() == CreateOnDemand.get() && rhs.getEvalType() == CreateOnDemand.get()) {
			this.getErrorListener().incompatibleSymbols(parentExpression, lhs, rhs);
		} else {
			if (rhs.getEvalType() == CreateOnDemand.get()) {
				this.enforceType(lhs, rhs);
			}
			if (lhs.getEvalType() == CreateOnDemand.get()) {
				this.enforceType(rhs, lhs);
			}
		}
	}

	/**
	 * @param from
	 * @param to
	 */
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

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDisjunctionTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforceDisjunctionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree... disjuncts) {
		this.enforceNaryClassExpressionTypes(disjuncts);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceDomainAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceDomainAxiomTypes(ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p,
			ManchesterOWLSyntaxTree classDescription) {
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
			this.getErrorListener().illegalToken(
					p,
					"Cannot decide whether " + p.getText()
							+ " is a data or an object type property");
		} else {
			this.enforceType(classDescription, OWLType.OWL_CLASS);
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceEquivalentToAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceEquivalentToAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree lhs, ManchesterOWLSyntaxTree rhs) {
		if (parentExpression == null) {
			throw new NullPointerException("The parent expresion cannot be null");
		}
		if (lhs == null) {
			throw new NullPointerException("The left hand side expression cannot be null");
		}
		if (rhs == null) {
			throw new NullPointerException("The right hand side expression cannot be null");
		}
		this.enforceBinaryAxiomTypes(parentExpression, lhs, rhs);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceExactCardinalityRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceExactCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		this.enforceCardinalityRestrictionTypes(parentExpression, propertyExpression, filler);
	}

	/**
	 * @param parentExpression
	 * @param propertyExpression
	 * @param filler
	 */
	private void enforceCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		if (parentExpression == null) {
			throw new NullPointerException("The parent expression cannot be null");
		}
		if (propertyExpression == null) {
			throw new NullPointerException("The property cannot be null");
		}
		if (filler == null) {
			if (propertyExpression.getEvalType() == CreateOnDemand.get()) {
				this.getErrorListener().illegalToken(
						propertyExpression,
						"Cannot decide whether " + propertyExpression.getText()
								+ " is a data or an object property");
			}
		} else {
			if (filler.getEvalType() == CreateOnDemand.get()
					&& propertyExpression.getEvalType() == CreateOnDemand.get()) {
				this.getErrorListener().incompatibleSymbols(
						parentExpression,
						propertyExpression,
						filler);
			} else {
				if (propertyExpression.getEvalType() == CreateOnDemand.get()) {
					this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
				} else if (filler.getEvalType() == CreateOnDemand.get()) {
					this.enforceType(filler, OWLType.OWL_CLASS);
				}
			}
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceFunctionalPropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceFunctionalPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceInverseFunctionalPropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceInverseFunctionalPropertyAxiomTypes(
			ManchesterOWLSyntaxTree parentExpression, OPPLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceInverseObjectPropertyTypes(org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceInverseObjectPropertyTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceIrreflexivePropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceIrreflexivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceIverserOfAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceIverserOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree p, OPPLSyntaxTree anotherProperty) {
		this.enforceBinaryAxiomTypes(parentExpression, p, anotherProperty);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceMaxCardinalityRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceMaxCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		this.enforceCardinalityRestrictionTypes(parentExpression, propertyExpression, filler);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceMinCardinalityRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceMinCardinalityRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		this.enforceCardinalityRestrictionTypes(parentExpression, propertyExpression, filler);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceNegatedAssertionTypes(org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceNegatedAssertionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree assertion) {
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceNegatedClassExpression(org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceNegatedClassExpression(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree classExpression) {
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceOneOfTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
	public void enforceOneOfTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree... individuals) {
		if (individuals == null) {
			throw new NullPointerException("The individual array cannot be null");
		}
		for (ManchesterOWLSyntaxTree individual : individuals) {
			this.enforceType(individual, OWLType.OWL_INDIVIDUAL);
		}
	}

	/**
	 * This method enforces a type only on to symbols that have been marked as
	 * create on demand ones. In OPPL syntax those symbols are denoted by an
	 * exclamation mark prefix.
	 * 
	 * @param t
	 * @param type
	 */
	private void enforceType(ManchesterOWLSyntaxTree t, OWLType type) {
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
					entity = this.getOWLEntityFactory().createOWLClass(newEntityName, null).getOWLEntity();
				} catch (OWLEntityCreationException e) {
					this.errorListener.illegalToken(t, "Unable to create an OWL Class for " + name
							+ " because of " + e.getMessage());
				}
				break;
			case OWL_OBJECT_PROPERTY:
				try {
					entity = this.getOWLEntityFactory().createOWLObjectProperty(newEntityName, null).getOWLEntity();
				} catch (OWLEntityCreationException e) {
					this.errorListener.illegalToken(
							t,
							"Unable to create an OWL Object property for " + name + " because of "
									+ e.getMessage());
				}
				break;
			case OWL_DATA_PROPERTY:
				try {
					entity = this.getOWLEntityFactory().createOWLDataProperty(newEntityName, null).getOWLEntity();
				} catch (OWLEntityCreationException e) {
					this.errorListener.illegalToken(t, "Unable to create an OWL Data property for "
							+ name + " because of " + e.getMessage());
				}
				break;
			case OWL_INDIVIDUAL:
				try {
					entity = this.getOWLEntityFactory().createOWLIndividual(newEntityName, null).getOWLEntity();
				} catch (OWLEntityCreationException e) {
					this.errorListener.illegalToken(t, "Unable to create an OWL Individual for "
							+ name + " because of " + e.getMessage());
				}
				break;
			default:
				break;
			}
			if (entity != null) {
				this.getSymbolTable().define(t.getToken(), new OWLEntitySymbol(name, entity));
			}
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforcePropertyChainTypes(org.coode.parsers.ManchesterOWLSyntaxTree[])
	 */
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

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceRangeAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
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
							DefaultTypeEnforcer.this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
						}
						if (owlType == OWLType.OWL_DATA_TYPE) {
							DefaultTypeEnforcer.this.enforceType(p, OWLType.OWL_DATA_PROPERTY);
						}
					}
				});
			}
		}
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceReflexivePropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceReflexivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceRoleAssertionAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceRoleAssertionAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree subject, ManchesterOWLSyntaxTree property, ManchesterOWLSyntaxTree object) {
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

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSameIndividualsAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceSameIndividualsAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree anIndividual, OPPLSyntaxTree anotherIndividual) {
		this.enforceBinaryIndividualAxiomType(anIndividual, anotherIndividual);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSomeValueRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceSomeValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree filler) {
		this.enforceQualifiedRestrictionTypes(parentExpression, propertyExpression, filler);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSubClassOfAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceSubClassOfAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree subClass, ManchesterOWLSyntaxTree superClass) {
		this.enforceBinaryAxiomTypes(parentExpression, subClass, superClass);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSubPropertyAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceSubPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree aProperty, ManchesterOWLSyntaxTree anotherProperty) {
		if (parentExpression == null) {
			throw new NullPointerException("The parent expresion cannot be null");
		}
		if (aProperty == null) {
			throw new NullPointerException("The left hand side expression cannot be null");
		}
		if (anotherProperty == null) {
			throw new NullPointerException("The right hand side expression cannot be null");
		}
		this.enforceBinaryAxiomTypes(parentExpression, aProperty, anotherProperty);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceSymmetricPropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceSymmetricPropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceTransitivePropertyAxiomTypes(org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
	public void enforceTransitivePropertyAxiomTypes(ManchesterOWLSyntaxTree parentExpression,
			OPPLSyntaxTree p) {
		this.enforceType(p, OWLType.OWL_OBJECT_PROPERTY);
	}

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceTypeAssertionAxiomTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.oppl.OPPLSyntaxTree)
	 */
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

	/**
	 * @see org.coode.parsers.oppl.TypesEnforcer#enforceValueRestrictionTypes(org.coode.parsers.ManchesterOWLSyntaxTree,
	 *      org.coode.parsers.ManchesterOWLSyntaxTree)
	 */
	public void enforceValueRestrictionTypes(ManchesterOWLSyntaxTree parentExpression,
			final ManchesterOWLSyntaxTree propertyExpression, ManchesterOWLSyntaxTree value) {
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
			this.getErrorListener().incompatibleSymbols(parentExpression, propertyExpression, value);
		} else if (value.getEvalType() == CreateOnDemand.get()) {
			this.enforceType(propertyExpression, OWLType.OWL_OBJECT_PROPERTY);
		} else {
			value.getEvalType().accept(new TypeVistorAdapter() {
				@Override
				public void visitOWLType(OWLType owlType) {
					if (OWLType.isClassExpression(owlType)) {
						DefaultTypeEnforcer.this.enforceType(
								propertyExpression,
								OWLType.OWL_OBJECT_PROPERTY);
					}
					if (owlType == OWLType.OWL_DATA_TYPE) {
						DefaultTypeEnforcer.this.enforceType(
								propertyExpression,
								OWLType.OWL_DATA_PROPERTY);
					}
				}
			});
		}
	}

	/**
	 * @return the symbolTable
	 */
	public OPPLSymbolTable getSymbolTable() {
		return this.symbolTable;
	}

	/**
	 * @return the entityFactory
	 */
	public OWLEntityFactory getOWLEntityFactory() {
		return this.entityFactory;
	}

	/**
	 * @return the errorListener
	 */
	public ErrorListener getErrorListener() {
		return this.errorListener;
	}
}
