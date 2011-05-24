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
package org.coode.oppl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.function.ValueComputationParameters;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
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
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
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
import org.semanticweb.owlapi.model.OWLOntology;
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
 * Visitor that abstracts OWLObjects into variables.
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLObjectAbstractor extends OWLObjectVisitorExAdapter<OWLObject> implements
		OWLObjectVisitorEx<OWLObject> {
	private final ValueComputationParameters parameters;
	private final Set<Variable<?>> variables = new HashSet<Variable<?>>();
	private final Set<BindingNode> bindingNodes = new HashSet<BindingNode>();

	public OWLObjectAbstractor(Collection<? extends Variable<?>> variables,
			ValueComputationParameters parameters) {
		this(
				variables,
				parameters,
				parameters.getConstraintSystem().getLeaves() != null ? parameters.getConstraintSystem().getLeaves()
						: new HashSet<BindingNode>());
	}

	@Override
	protected OWLObject getDefaultReturnValue(OWLObject object) {
		return object;
	}

	public OWLObjectAbstractor(Collection<? extends Variable<?>> variables,
			ValueComputationParameters parameters, Collection<? extends BindingNode> bindingNodes) {
		if (variables == null) {
			throw new NullPointerException("The variables cannot be null");
		}
		if (parameters == null) {
			throw new NullPointerException("The value computation parameters cannot be null");
		}
		if (bindingNodes == null) {
			throw new NullPointerException("The binding nodes cannot be null");
		}
		this.parameters = parameters;
		this.variables.addAll(variables);
		this.bindingNodes.addAll(bindingNodes);
	}

	private Variable<?> getAbstractingVariable(OWLObject owlObject) {
		boolean found = false;
		Iterator<? extends Variable<?>> it = this.variables.iterator();
		Variable<?> toReturn = null;
		Variable<?> aVariable = null;
		while (!found && it.hasNext()) {
			aVariable = it.next();
			Iterator<BindingNode> bindingNodesIterator = this.getBindingNodes().iterator();
			while (!found && bindingNodesIterator.hasNext()) {
				BindingNode bindingNode = bindingNodesIterator.next();
				found = bindingNode.getAssignmentValue(aVariable, this.getParameters()).equals(
						owlObject);
			}
		}
		if (found) {
			toReturn = aVariable;
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLAsymmetricObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLClass desc) {
		OWLClassExpression toReturn = null;
		Variable<?> v = this.getAbstractingVariable(desc);
		if (v != null) {
			toReturn = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLClass(
					v.getIRI());
		} else {
			toReturn = desc;
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLClassAssertionAxiom axiom) {
		OWLClassExpression description = axiom.getClassExpression();
		OWLIndividual individual = axiom.getIndividual();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLClassAssertionAxiom(
				(OWLClassExpression) description.accept(this),
				(OWLIndividual) individual.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataAllValuesFrom desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataAllValuesFrom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataComplementOf node) {
		OWLDataRange dataRange = node.getDataRange();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataComplementOf(
				(OWLDataRange) dataRange.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataExactCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataExactCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataMaxCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataMaxCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataMinCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataMinCardinality(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataOneOf(
				instantiatedValues);
	}

	@Override
	public OWLObject visit(OWLDataProperty property) {
		OWLDataProperty toReturn = property;
		Variable<?> v = this.getAbstractingVariable(property);
		if (v != null) {
			toReturn = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataProperty(
					v.getIRI());
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLLiteral object = axiom.getObject();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataPropertyAssertionAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLLiteral) object.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
		OWLClassExpression domain = axiom.getDomain();
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataPropertyDomainAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLClassExpression) domain.accept(this));
	}

	@Override
	public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLDataRange range = axiom.getRange();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataPropertyRangeAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) range.accept(this));
	}

	@Override
	public OWLObject visit(OWLDatatypeRestriction node) {
		OWLDatatype dataRange = node.getDatatype();
		Set<OWLFacetRestriction> facetRestrictions = node.getFacetRestrictions();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDatatypeRestriction(
				(OWLDatatype) dataRange.accept(this),
				facetRestrictions);
	}

	@Override
	public OWLObject visit(OWLDataSomeValuesFrom desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataSomeValuesFrom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLSubDataPropertyOfAxiom axiom) {
		OWLDataPropertyExpression subProperty = axiom.getSubProperty();
		OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubDataPropertyOfAxiom(
				(OWLDataPropertyExpression) subProperty.accept(this),
				(OWLDataPropertyExpression) superProperty.accept(this));
	}

	@Override
	public OWLObject visit(OWLDatatype node) {
		return node;
	}

	@Override
	public OWLObject visit(OWLDataHasValue desc) {
		OWLDataPropertyExpression property = desc.getProperty();
		OWLLiteral value = desc.getValue();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataHasValue(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLLiteral) value.accept(this));
	}

	@Override
	public OWLObject visit(OWLDeclarationAxiom axiom) {
		return axiom;
	}

	@Override
	public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDifferentIndividualsAxiom(
				instantiatedIndividuals);
	}

	@Override
	public OWLObject visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Set<OWLClassExpression> instatiatedDescriptions = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : descriptions) {
			instatiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointClassesAxiom(
				instatiatedDescriptions);
	}

	@Override
	public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLDataPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointDataPropertiesAxiom(
				instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointObjectPropertiesAxiom(
				instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLDisjointUnionAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		OWLClass owlClass = axiom.getOWLClass();
		Set<OWLClassExpression> instantiatedDescriptions = axiom.getClassExpressions();
		for (OWLClassExpression description : descriptions) {
			instantiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointUnionAxiom(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLEquivalentClassesAxiom(
				instantiatedDescriptions);
	}

	@Override
	public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			instantiatedProperties.add((OWLDataPropertyExpression) dataPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLEquivalentDataPropertiesAxiom(
				instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLEquivalentObjectPropertiesAxiom(
				instantiatedProperties);
	}

	@Override
	public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLFunctionalDataPropertyAxiom(
				(OWLDataPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLFunctionalObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLNamedIndividual individual) {
		OWLIndividual toReturn = individual;
		Variable<?> v = this.getAbstractingVariable(individual);
		if (v != null) {
			toReturn = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLNamedIndividual(
					v.getIRI());
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLInverseFunctionalObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
		OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
		OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLInverseObjectPropertiesAxiom(
				(OWLObjectPropertyExpression) firstProperty.accept(this),
				(OWLObjectPropertyExpression) secondProperty.accept(this));
	}

	@Override
	public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLIrreflexiveObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLLiteral object = axiom.getObject();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLNegativeDataPropertyAssertionAxiom(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLNegativeObjectPropertyAssertionAxiom(
				instantiatedProperty,
				instantiatedSubject,
				instantiatedObject);
	}

	@Override
	public OWLClassExpression visit(OWLObjectAllValuesFrom desc) {
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectAllValuesFrom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectComplementOf desc) {
		OWLClassExpression operand = desc.getOperand();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectComplementOf(
				(OWLClassExpression) operand.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectExactCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectExactCardinality(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectIntersectionOf(
				instantiatedOperands);
	}

	@Override
	public OWLObject visit(OWLObjectMaxCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectMaxCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectMinCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectMinCardinality(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectOneOf(
				instantiatedIndividuals);
	}

	@Override
	public OWLObject visit(OWLObjectProperty property) {
		OWLObjectProperty toReturn = property;
		Variable<?> v = this.getAbstractingVariable(property);
		if (v != null) {
			toReturn = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectProperty(
					v.getIRI());
		}
		return toReturn;
	}

	@Override
	public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual object = axiom.getObject();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectPropertyAssertionAxiom(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubPropertyChainOfAxiom(
				instantiatedPropertyChain,
				(OWLObjectPropertyExpression) superProperty.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
		OWLClassExpression domain = axiom.getDomain();
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectPropertyDomainAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) domain.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectInverseOf property) {
		OWLObjectPropertyExpression inverse = property.getInverse();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectInverseOf(
				(OWLObjectPropertyExpression) inverse.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLClassExpression range = axiom.getRange();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectPropertyRangeAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) range.accept(this));
	}

	@Override
	public OWLObject visit(OWLObjectHasSelf desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectHasSelf(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectSomeValuesFrom desc) {
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectSomeValuesFrom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	@Override
	public OWLObject visit(OWLSubObjectPropertyOfAxiom axiom) {
		OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubObjectPropertyOfAxiom(
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
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectUnionOf(
				instantiatedOperands);
	}

	@Override
	public OWLClassExpression visit(OWLObjectHasValue desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		OWLIndividual value = desc.getValue();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectHasValue(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) value.accept(this));
	}

	@Override
	public OWLObject visit(OWLOntology ontology) {
		return ontology;
	}

	@Override
	public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLReflexiveObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLSameIndividualAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSameIndividualAxiom(
				instantiatedIndividuals);
	}

	@Override
	public OWLObject visit(OWLSubClassOfAxiom axiom) {
		OWLClassExpression superClass = (OWLClassExpression) axiom.getSuperClass().accept(this);
		OWLClassExpression subClass = (OWLClassExpression) axiom.getSubClass().accept(this);
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubClassOfAxiom(
				subClass,
				superClass);
	}

	@Override
	public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSymmetricObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLTransitiveObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	@Override
	public OWLObject visit(OWLLiteral node) {
		OWLLiteral toReturn = null;
		Variable<?> v = this.getAbstractingVariable(node);
		if (v != null) {
			toReturn = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLLiteral(
					v.getIRI().toString());
		} else {
			toReturn = node;
		}
		return toReturn;
	}

	/**
	 * @return the bindingNodes
	 */
	public Set<BindingNode> getBindingNodes() {
		return this.bindingNodes;
	}

	/**
	 * @return the parameters
	 */
	public ValueComputationParameters getParameters() {
		return this.parameters;
	}
}
