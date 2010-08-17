/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.generated.VariableGeneratedValue;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 *         Jun 26, 2008
 */
public class ReferenceReplacement extends OWLObjectVisitorExAdapter<OWLObject> implements
		OWLObjectVisitorEx<OWLObject> {
	// TODO check that no generated variables are in this list
	// private List<Variable> patternVariables;
	// private List<Object> replacements;
	private final Map<Variable, Object> patternVariablesReplacement = new HashMap<Variable, Object>();
	private final PatternConstraintSystem constraintSystem;
	private final OWLDataFactory dataFactory;

	/**
	 * @param patternVariables
	 * @param replacements
	 * @throws PatternException
	 */
	public ReferenceReplacement(String patternName, List<Variable> patternVariables,
			List<Object> replacements, PatternConstraintSystem constraintSystem,
			OWLDataFactory dataFactory) throws PatternException {
		if (patternVariables.size() == replacements.size()) {
			// this.patternVariables = patternVariables;
			// this.replacements = replacements;
			for (int i = 0; i < patternVariables.size(); i++) {
				this.patternVariablesReplacement.put(patternVariables.get(i), replacements.get(i));
			}
			this.constraintSystem = constraintSystem;
			this.dataFactory = dataFactory;
		} else {
			throw new InvalidNumebrOfArgumentException(patternName, replacements.size(),
					patternVariables.size());
		}
	}

	protected Object replace(Variable v) {
		Object toReturn = null;
		if (this.patternVariablesReplacement.containsKey(v)) {
			toReturn = this.patternVariablesReplacement.get(v);
		} else if (v instanceof SingleValueGeneratedVariable<?>) {
			// generated variable
			SingleValueGeneratedValue<?> value = ((SingleValueGeneratedVariable<?>) v).getValue();
			if (value instanceof VariableGeneratedValue<?>) {
				Variable generatingVariable = ((VariableGeneratedValue<?>) value).getVariable();
				Object generatingVaribaleReplacement = this.replace(generatingVariable);
				if (generatingVaribaleReplacement instanceof Variable) {
					VariableGeneratedValue<?> replaceValue = ((VariableGeneratedValue<?>) value).replaceVariable(
							generatingVariable,
							this.constraintSystem);
					toReturn = ((SingleValueGeneratedVariable<?>) v).replaceValue(replaceValue);
				}
			} else {
				toReturn = v;
			}
		}
		return toReturn;
	}

	@Override
	protected OWLObject getDefaultReturnValue(OWLObject object) {
		return object;
	}

	@Override
	public OWLObject visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLAsymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLNamedIndividual individual) {
		OWLIndividual toReturn = individual;
		if (this.constraintSystem.isVariable(individual)) {
			Variable variable = this.constraintSystem.getVariable(individual.getIRI());
			if (this.constraintSystem.isGenerated(variable)) {
				VariableGeneratedValue<?> variableGeneratedValue = (VariableGeneratedValue<?>) ((SingleValueGeneratedVariable<?>) variable).getValue();
				Object replacement = this.getReplacement(variableGeneratedValue);
				if (replacement instanceof Variable) {
					VariableGeneratedValue<?> replaceValue = variableGeneratedValue.replaceVariable(
							(Variable) replacement,
							this.constraintSystem);
					SingleValueGeneratedVariable<?> replaceVariable = ((SingleValueGeneratedVariable<?>) variable).replaceValue(replaceValue);
					toReturn = this.dataFactory.getOWLNamedIndividual(replaceVariable.getIRI());
				} else {
					toReturn = (OWLIndividual) replacement;
				}
			} else {
				Object replacement = this.replace(variable);
				toReturn = replacement instanceof Variable ? this.dataFactory.getOWLNamedIndividual(((Variable) replacement).getIRI())
						: (OWLIndividual) replacement;
				if (replacement instanceof Variable) {
					this.constraintSystem.importVariable((Variable) replacement);
				}
			}
		}
		return toReturn;
	}

	private Object getReplacement(VariableGeneratedValue<?> variableGeneratedValue) {
		Variable variable2replace = variableGeneratedValue.getVariable();
		return this.replace(variable2replace);
	}

	private VariableGeneratedValue<?> getVGenValue(Variable v) {
		return (VariableGeneratedValue<?>) ((SingleValueGeneratedVariable<?>) v).getValue();
	}

	@Override
	public OWLObject visit(OWLLiteral node) {
		OWLLiteral toReturn = node;
		if (this.constraintSystem.isVariable(node)) {
			Variable variable = this.constraintSystem.getVariable(node.toString());
			if (this.getConstraintSystem().isGenerated(variable)) {
				VariableGeneratedValue<?> vGenValue = this.getVGenValue(variable);
				Object replacement = this.getReplacement(vGenValue);
				if (replacement instanceof Variable) {
					IRI v = this.getReplaceGenVariable(variable, vGenValue, replacement);
					toReturn = this.dataFactory.getOWLLiteral(v.toString());
				} else {
					toReturn = (OWLLiteral) replacement;
				}
			} else {
				Object replacement = this.replace(variable);
				toReturn = replacement instanceof Variable ? this.dataFactory.getOWLLiteral(((Variable) replacement).getIRI().toString())
						: (OWLLiteral) replacement;
				if (replacement instanceof Variable) {
					this.constraintSystem.importVariable((Variable) replacement);
				}
			}
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLObjectProperty property) {
		OWLObjectProperty toReturn = property;
		if (this.constraintSystem.isVariable(property)) {
			Variable variable = this.constraintSystem.getVariable(property.getIRI());
			if (this.getConstraintSystem().isGenerated(variable)) {
				VariableGeneratedValue<?> vGenValue = this.getVGenValue(variable);
				Object replacement = this.getReplacement(vGenValue);
				if (replacement instanceof Variable) {
					IRI v = this.getReplaceGenVariable(variable, vGenValue, replacement);
					toReturn = this.dataFactory.getOWLObjectProperty(v);
				} else {
					toReturn = (OWLObjectProperty) replacement;
				}
			} else {
				Object replacement = this.replace(variable);
				toReturn = replacement instanceof Variable ? this.dataFactory.getOWLObjectProperty(((Variable) replacement).getIRI())
						: (OWLObjectProperty) replacement;
				if (replacement instanceof Variable) {
					this.constraintSystem.importVariable((Variable) replacement);
				}
			}
		}
		return toReturn;
	}

	private IRI getReplaceGenVariable(Variable variable, VariableGeneratedValue<?> vGenValue,
			Object replacement) {
		VariableGeneratedValue<?> replaceValue = vGenValue.replaceVariable(
				(Variable) replacement,
				this.constraintSystem);
		SingleValueGeneratedVariable<?> replaceVariable = ((SingleValueGeneratedVariable<?>) variable).replaceValue(replaceValue);
		return replaceVariable.getIRI();
	}

	@Override
	public OWLObject visit(OWLDataProperty property) {
		OWLDataProperty toReturn = property;
		if (this.constraintSystem.isVariable(property)) {
			Variable variable = this.constraintSystem.getVariable(property.getIRI());
			if (this.getConstraintSystem().isGenerated(variable)) {
				VariableGeneratedValue<?> vGenValue = this.getVGenValue(variable);
				Object replacement = this.getReplacement(vGenValue);
				if (replacement instanceof Variable) {
					IRI v = this.getReplaceGenVariable(variable, vGenValue, replacement);
					toReturn = this.dataFactory.getOWLDataProperty(v);
				} else {
					toReturn = (OWLDataProperty) replacement;
				}
			} else {
				Object replacement = this.replace(variable);
				toReturn = replacement instanceof Variable ? this.dataFactory.getOWLDataProperty(((Variable) replacement).getIRI())
						: (OWLDataProperty) replacement;
				if (replacement instanceof Variable) {
					this.constraintSystem.importVariable((Variable) replacement);
				}
			}
		}
		return toReturn;
	}

	@Override
	public OWLClassExpression visit(OWLClass desc) {
		OWLClassExpression toReturn = null;
		if (this.getConstraintSystem().isVariable(desc)) {
			Variable variable = this.getConstraintSystem().getVariable(desc.getIRI());
			if (!this.getConstraintSystem().isThisClassVariable(variable)) {
				if (this.getConstraintSystem().isGenerated(variable)) {
					VariableGeneratedValue<?> vGenValue = this.getVGenValue(variable);
					Object replacement = this.getReplacement(vGenValue);
					if (replacement instanceof Variable) {
						IRI v = this.getReplaceGenVariable(variable, vGenValue, replacement);
						toReturn = this.dataFactory.getOWLClass(v);
						// TODO check: the other side of the if calls
						// importVariable, this one does not
					} else {
						toReturn = (OWLClassExpression) replacement;
					}
				} else {
					Object replacement = this.replace(variable);
					toReturn = replacement instanceof Variable ? this.dataFactory.getOWLClass(((Variable) replacement).getIRI())
							: (OWLClass) replacement;
					if (replacement instanceof Variable) {
						this.getConstraintSystem().importVariable((Variable) replacement);
					}
				}
			} else {
				toReturn = desc;
			}
		} else {
			toReturn = desc;
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLClassAssertionAxiom axiom) {
		OWLClassExpression description = axiom.getClassExpression();
		OWLIndividual individual = axiom.getIndividual();
		return this.dataFactory.getOWLClassAssertionAxiom(
				(OWLClassExpression) description.accept(this),
				(OWLIndividual) individual.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataAllValuesFrom desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataAllValuesFrom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataComplementOf node) {
		OWLDataRange dataRange = node.getDataRange();
		return this.dataFactory.getOWLDataComplementOf((OWLDataRange) dataRange.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataExactCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataExactCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataMaxCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataMaxCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataMinCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataMinCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataOneOf node) {
		Set<OWLLiteral> values = node.getValues();
		Set<OWLLiteral> instantiatedValues = new HashSet<OWLLiteral>();
		for (OWLLiteral constant : values) {
			instantiatedValues.add((OWLLiteral) constant.accept(this));
		}
		return this.dataFactory.getOWLDataOneOf(instantiatedValues);
	}

	@Override
	public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLLiteral object = axiom.getObject();
		return this.dataFactory.getOWLDataPropertyAssertionAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLLiteral) object.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
		OWLClassExpression domain = axiom.getDomain();
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLDataPropertyDomainAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLClassExpression) domain.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLDataRange range = axiom.getRange();
		return this.dataFactory.getOWLDataPropertyRangeAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) range.accept(this));
	}

	@Override
	public OWLObject visit(OWLDatatypeRestriction node) {
		OWLDatatype dataRange = node.getDatatype();
		Set<OWLFacetRestriction> facetRestrictions = node.getFacetRestrictions();
		return this.dataFactory.getOWLDatatypeRestriction(
				(OWLDatatype) dataRange.accept(this),
				facetRestrictions);
	}

	@Override
	public OWLObject visit(OWLDataSomeValuesFrom desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataSomeValuesFrom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLSubDataPropertyOfAxiom axiom) {
		OWLDataPropertyExpression subProperty = axiom.getSubProperty();
		OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
		return this.dataFactory.getOWLSubDataPropertyOfAxiom(
				(OWLDataPropertyExpression) subProperty.accept(this),
				(OWLDataPropertyExpression) superProperty.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataHasValue desc) {
		OWLDataPropertyExpression property = desc.getProperty();
		OWLLiteral value = desc.getValue();
		return this.dataFactory.getOWLDataHasValue(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLLiteral) value.accept(this));
	}

	@Override
	public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.dataFactory.getOWLDifferentIndividualsAxiom(instantiatedIndividuals);
	}

	@Override
	public OWLObject visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Set<OWLClassExpression> instatiatedDescriptions = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : descriptions) {
			instatiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.dataFactory.getOWLDisjointClassesAxiom(instatiatedDescriptions);
	}

	@Override
	public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLDataPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.dataFactory.getOWLDisjointDataPropertiesAxiom(instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.dataFactory.getOWLDisjointObjectPropertiesAxiom(instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLDisjointUnionAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		OWLClass owlClass = axiom.getOWLClass();
		Set<OWLClassExpression> instantiatedDescriptions = axiom.getClassExpressions();
		for (OWLClassExpression description : descriptions) {
			instantiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.dataFactory.getOWLDisjointUnionAxiom(
				(OWLClass) owlClass.accept(this),
				instantiatedDescriptions);
	}

	@Override
	public OWLObject visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Set<OWLClassExpression> instantiatedDescriptions = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : descriptions) {
			instantiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.dataFactory.getOWLEquivalentClassesAxiom(instantiatedDescriptions);
	}

	@Override
	public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			instantiatedProperties.add((OWLDataPropertyExpression) dataPropertyExpression.accept(this));
		}
		return this.dataFactory.getOWLEquivalentDataPropertiesAxiom(instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.dataFactory.getOWLEquivalentObjectPropertiesAxiom(instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLFunctionalDataPropertyAxiom((OWLDataPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLInverseFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
		OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
		OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
		return this.dataFactory.getOWLInverseObjectPropertiesAxiom(
				(OWLObjectPropertyExpression) firstProperty.accept(this),
				(OWLObjectPropertyExpression) secondProperty.accept(this));
	}

	@Override
	public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLIrreflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLLiteral object = axiom.getObject();
		return this.dataFactory.getOWLNegativeDataPropertyAssertionAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLLiteral) object.accept(this));
	}

	@Override
	public OWLObject visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLIndividual object = axiom.getObject();
		OWLIndividual instantiatedSubject = (OWLIndividual) subject.accept(this);
		OWLObjectPropertyExpression instantiatedProperty = (OWLObjectPropertyExpression) property.accept(this);
		OWLIndividual instantiatedObject = (OWLIndividual) object.accept(this);
		return this.dataFactory.getOWLNegativeObjectPropertyAssertionAxiom(
				instantiatedProperty,
				instantiatedSubject,
				instantiatedObject);
	}

	@Override
	public OWLClassExpression visit(OWLObjectAllValuesFrom desc) {
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectAllValuesFrom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectComplementOf desc) {
		OWLClassExpression operand = desc.getOperand();
		return this.dataFactory.getOWLObjectComplementOf((OWLClassExpression) operand.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectExactCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectExactCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectIntersectionOf desc) {
		Set<OWLClassExpression> operands = desc.getOperands();
		Set<OWLClassExpression> instantiatedOperands = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : operands) {
			instantiatedOperands.add((OWLClassExpression) description.accept(this));
		}
		return this.dataFactory.getOWLObjectIntersectionOf(instantiatedOperands);
	}

	@Override
	public OWLObject visit(OWLObjectMaxCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectMaxCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectMinCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectMinCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectOneOf desc) {
		Set<OWLIndividual> individuals = desc.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.dataFactory.getOWLObjectOneOf(instantiatedIndividuals);
	}

	@Override
	public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual object = axiom.getObject();
		return this.dataFactory.getOWLObjectPropertyAssertionAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLIndividual) object.accept(this));
	}

	@Override
	public OWLObject visit(OWLSubPropertyChainOfAxiom axiom) {
		List<OWLObjectPropertyExpression> propertyChain = axiom.getPropertyChain();
		List<OWLObjectPropertyExpression> instantiatedPropertyChain = axiom.getPropertyChain();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
			instantiatedPropertyChain.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.dataFactory.getOWLSubPropertyChainOfAxiom(
				instantiatedPropertyChain,
				(OWLObjectPropertyExpression) superProperty.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
		OWLClassExpression domain = axiom.getDomain();
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLObjectPropertyDomainAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) domain.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectInverseOf property) {
		OWLObjectPropertyExpression inverse = property.getInverse();
		return this.dataFactory.getOWLObjectInverseOf((OWLObjectPropertyExpression) inverse.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLClassExpression range = axiom.getRange();
		return this.dataFactory.getOWLObjectPropertyRangeAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) range.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectHasSelf desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectHasSelf((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectSomeValuesFrom desc) {
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectSomeValuesFrom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLSubObjectPropertyOfAxiom axiom) {
		OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		return this.dataFactory.getOWLSubObjectPropertyOfAxiom(
				(OWLObjectPropertyExpression) subProperty.accept(this),
				(OWLObjectPropertyExpression) superProperty.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectUnionOf desc) {
		Set<OWLClassExpression> operands = desc.getOperands();
		Set<OWLClassExpression> instantiatedOperands = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : operands) {
			instantiatedOperands.add((OWLClassExpression) description.accept(this));
		}
		return this.dataFactory.getOWLObjectUnionOf(instantiatedOperands);
	}

	@Override
	public OWLClassExpression visit(OWLObjectHasValue desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		OWLIndividual value = desc.getValue();
		return this.dataFactory.getOWLObjectHasValue(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) value.accept(this));
	}

	@Override
	public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLReflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLSameIndividualAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.dataFactory.getOWLSameIndividualAxiom(instantiatedIndividuals);
	}

	@Override
	public OWLObject visit(OWLSubClassOfAxiom axiom) {
		OWLClassExpression superClass = (OWLClassExpression) axiom.getSuperClass().accept(this);
		OWLClassExpression subClass = (OWLClassExpression) axiom.getSubClass().accept(this);
		return this.dataFactory.getOWLSubClassOfAxiom(subClass, superClass);
	}

	@Override
	public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLSymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLTransitiveObjectPropertyAxiom((OWLObjectPropertyExpression) property.accept(this));
	}

	/**
	 * @return the constraintSystem
	 */
	public PatternConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
