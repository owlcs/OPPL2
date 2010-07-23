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
package org.coode.oppl.variablemansyntax;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyExpression;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataRange;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectAnnotation;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyExpression;
import org.semanticweb.owl.model.OWLObjectPropertyInverse;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLObjectVisitorEx;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.model.SWRLAtomConstantObject;
import org.semanticweb.owl.model.SWRLAtomDVariable;
import org.semanticweb.owl.model.SWRLAtomIVariable;
import org.semanticweb.owl.model.SWRLAtomIndividualObject;
import org.semanticweb.owl.model.SWRLBuiltInAtom;
import org.semanticweb.owl.model.SWRLClassAtom;
import org.semanticweb.owl.model.SWRLDataRangeAtom;
import org.semanticweb.owl.model.SWRLDataValuedPropertyAtom;
import org.semanticweb.owl.model.SWRLDifferentFromAtom;
import org.semanticweb.owl.model.SWRLObjectPropertyAtom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.model.SWRLSameAsAtom;

/**
 * Visitor that abstracts OWLObjects into variables.
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLObjectAbstractor implements OWLObjectVisitorEx<OWLObject> {
	private final OWLDataFactory dataFactory;
	private final Collection<Variable> variables;

	public OWLObjectAbstractor(Collection<Variable> variables,
			OWLDataFactory dataFactory) {
		this.dataFactory = dataFactory;
		this.variables = variables;
	}

	private Variable getAbstractingVariable(OWLObject owlObject) {
		boolean found = false;
		Iterator<Variable> it = this.variables.iterator();
		Variable toReturn = null;
		Variable aVariable = null;
		while (!found && it.hasNext()) {
			aVariable = it.next();
			found = aVariable.getPossibleBindings().contains(owlObject);
		}
		if (found) {
			toReturn = aVariable;
		}
		return toReturn;
	}

	public OWLObject visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLAntiSymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLAxiomAnnotationAxiom axiom) {
		return axiom;
	}

	public OWLDescription visit(OWLClass desc) {
		OWLDescription toReturn = null;
		Variable v = getAbstractingVariable(desc);
		if (v != null) {
			toReturn = this.dataFactory.getOWLClass(v.getURI());
		} else {
			toReturn = desc;
		}
		return toReturn;
	}

	public OWLObject visit(OWLClassAssertionAxiom axiom) {
		OWLDescription description = axiom.getDescription();
		OWLIndividual individual = axiom.getIndividual();
		return this.dataFactory.getOWLClassAssertionAxiom(
				(OWLIndividual) individual.accept(this),
				(OWLDescription) description.accept(this));
	}

	public OWLObject visit(OWLConstantAnnotation annotation) {
		return annotation;
	}

	public OWLObject visit(OWLDataAllRestriction desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataAllRestriction(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataComplementOf node) {
		OWLDataRange dataRange = node.getDataRange();
		return this.dataFactory.getOWLDataComplementOf((OWLDataRange) dataRange
				.accept(this));
	}

	public OWLObject visit(OWLDataExactCardinalityRestriction desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataExactCardinalityRestriction(
				(OWLDataPropertyExpression) property.accept(this), cardinality,
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataMaxCardinalityRestriction desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataMaxCardinalityRestriction(
				(OWLDataPropertyExpression) property.accept(this), cardinality,
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataMinCardinalityRestriction desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataMinCardinalityRestriction(
				(OWLDataPropertyExpression) property.accept(this), cardinality,
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataOneOf node) {
		Set<OWLConstant> values = node.getValues();
		Set<OWLConstant> instantiatedValues = new HashSet<OWLConstant>();
		for (OWLConstant constant : values) {
			instantiatedValues.add((OWLConstant) constant.accept(this));
		}
		return this.dataFactory.getOWLDataOneOf(instantiatedValues);
	}

	public OWLObject visit(OWLDataProperty property) {
		OWLDataProperty toReturn = property;
		Variable v = getAbstractingVariable(property);
		if (v != null) {
			toReturn = this.dataFactory.getOWLDataProperty(v.getURI());
		}
		return toReturn;
	}

	public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLConstant object = axiom.getObject();
		return this.dataFactory.getOWLDataPropertyAssertionAxiom(
				(OWLIndividual) subject.accept(this),
				(OWLDataPropertyExpression) property.accept(this),
				(OWLConstant) object.accept(this));
	}

	public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
		OWLDescription domain = axiom.getDomain();
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLDataPropertyDomainAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDescription) domain.accept(this));
	}

	public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLDataRange range = axiom.getRange();
		return this.dataFactory.getOWLDataPropertyRangeAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) range.accept(this));
	}

	public OWLObject visit(OWLDataRangeFacetRestriction node) {
		return node;
	}

	public OWLObject visit(OWLDataRangeRestriction node) {
		OWLDataRange dataRange = node.getDataRange();
		Set<OWLDataRangeFacetRestriction> facetRestrictions = node
				.getFacetRestrictions();
		return this.dataFactory.getOWLDataRangeRestriction(
				(OWLDataRange) dataRange.accept(this), facetRestrictions);
	}

	public OWLObject visit(OWLDataSomeRestriction desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLDataSomeRestriction(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataSubPropertyAxiom axiom) {
		OWLDataPropertyExpression subProperty = axiom.getSubProperty();
		OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
		return this.dataFactory.getOWLSubDataPropertyAxiom(
				(OWLDataPropertyExpression) subProperty.accept(this),
				(OWLDataPropertyExpression) superProperty.accept(this));
	}

	public OWLObject visit(OWLDataType node) {
		return node;
	}

	public OWLObject visit(OWLDataValueRestriction desc) {
		OWLDataPropertyExpression property = desc.getProperty();
		OWLConstant value = desc.getValue();
		return this.dataFactory.getOWLDataValueRestriction(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLConstant) value.accept(this));
	}

	public OWLObject visit(OWLDeclarationAxiom axiom) {
		return axiom;
	}

	public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals
					.add((OWLIndividual) individual.accept(this));
		}
		return this.dataFactory
				.getOWLDifferentIndividualsAxiom(instantiatedIndividuals);
	}

	public OWLObject visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		Set<OWLDescription> instatiatedDescriptions = new HashSet<OWLDescription>();
		for (OWLDescription description : descriptions) {
			instatiatedDescriptions.add((OWLDescription) description
					.accept(this));
		}
		return this.dataFactory
				.getOWLDisjointClassesAxiom(instatiatedDescriptions);
	}

	public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties
					.add((OWLDataPropertyExpression) objectPropertyExpression
							.accept(this));
		}
		return this.dataFactory
				.getOWLDisjointDataPropertiesAxiom(instantiatedProperties);
	}

	public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties
					.add((OWLObjectPropertyExpression) objectPropertyExpression
							.accept(this));
		}
		return this.dataFactory
				.getOWLDisjointObjectPropertiesAxiom(instantiatedProperties);
	}

	public OWLObject visit(OWLDisjointUnionAxiom axiom) {
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		OWLClass owlClass = axiom.getOWLClass();
		Set<OWLDescription> instantiatedDescriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			instantiatedDescriptions.add((OWLDescription) description
					.accept(this));
		}
		return this.dataFactory.getOWLDisjointUnionAxiom((OWLClass) owlClass
				.accept(this), instantiatedDescriptions);
	}

	public OWLObject visit(OWLEntityAnnotationAxiom axiom) {
		return axiom;
	}

	public OWLObject visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		Set<OWLDescription> instantiatedDescriptions = new HashSet<OWLDescription>();
		for (OWLDescription description : descriptions) {
			instantiatedDescriptions.add((OWLDescription) description
					.accept(this));
		}
		return this.dataFactory
				.getOWLEquivalentClassesAxiom(instantiatedDescriptions);
	}

	public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			instantiatedProperties
					.add((OWLDataPropertyExpression) dataPropertyExpression
							.accept(this));
		}
		return this.dataFactory
				.getOWLEquivalentDataPropertiesAxiom(instantiatedProperties);
	}

	public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties
					.add((OWLObjectPropertyExpression) objectPropertyExpression
							.accept(this));
		}
		return this.dataFactory
				.getOWLEquivalentObjectPropertiesAxiom(instantiatedProperties);
	}

	public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLFunctionalDataPropertyAxiom((OWLDataPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLImportsDeclaration axiom) {
		return axiom;
	}

	public OWLObject visit(OWLIndividual individual) {
		OWLIndividual toReturn = individual;
		Variable v = getAbstractingVariable(individual);
		if (v != null) {
			toReturn = this.dataFactory.getOWLIndividual(v.getURI());
		}
		return toReturn;
	}

	public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLInverseFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
		OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
		OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
		return this.dataFactory.getOWLInverseObjectPropertiesAxiom(
				(OWLObjectPropertyExpression) firstProperty.accept(this),
				(OWLObjectPropertyExpression) secondProperty.accept(this));
	}

	public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLIrreflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLConstant object = axiom.getObject();
		return this.dataFactory.getOWLNegativeDataPropertyAssertionAxiom(
				(OWLIndividual) subject.accept(this),
				(OWLDataPropertyExpression) property.accept(this),
				(OWLConstant) object.accept(this));
	}

	public OWLObject visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLIndividual object = axiom.getObject();
		OWLIndividual instantiatedSubject = (OWLIndividual) subject
				.accept(this);
		OWLObjectPropertyExpression instantiatedProperty = (OWLObjectPropertyExpression) property
				.accept(this);
		OWLIndividual instantiatedObject = (OWLIndividual) object.accept(this);
		return this.dataFactory.getOWLNegativeObjectPropertyAssertionAxiom(
				instantiatedSubject, instantiatedProperty, instantiatedObject);
	}

	public OWLDescription visit(OWLObjectAllRestriction desc) {
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectAllRestriction(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLDescription) filler.accept(this));
	}

	public OWLObject visit(OWLObjectAnnotation annotation) {
		return annotation;
	}

	public OWLDescription visit(OWLObjectComplementOf desc) {
		OWLDescription operand = desc.getOperand();
		return this.dataFactory
				.getOWLObjectComplementOf((OWLDescription) operand.accept(this));
	}

	public OWLObject visit(OWLObjectExactCardinalityRestriction desc) {
		int cardinality = desc.getCardinality();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectExactCardinalityRestriction(
				(OWLObjectPropertyExpression) property.accept(this),
				cardinality, (OWLDescription) filler.accept(this));
	}

	public OWLDescription visit(OWLObjectIntersectionOf desc) {
		Set<OWLDescription> operands = desc.getOperands();
		Set<OWLDescription> instantiatedOperands = new HashSet<OWLDescription>();
		for (OWLDescription description : operands) {
			instantiatedOperands.add((OWLDescription) description.accept(this));
		}
		return this.dataFactory
				.getOWLObjectIntersectionOf(instantiatedOperands);
	}

	public OWLObject visit(OWLObjectMaxCardinalityRestriction desc) {
		int cardinality = desc.getCardinality();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectMaxCardinalityRestriction(
				(OWLObjectPropertyExpression) property.accept(this),
				cardinality, (OWLDescription) filler.accept(this));
	}

	public OWLObject visit(OWLObjectMinCardinalityRestriction desc) {
		int cardinality = desc.getCardinality();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectMinCardinalityRestriction(
				(OWLObjectPropertyExpression) property.accept(this),
				cardinality, (OWLDescription) filler.accept(this));
	}

	public OWLObject visit(OWLObjectOneOf desc) {
		Set<OWLIndividual> individuals = desc.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals
					.add((OWLIndividual) individual.accept(this));
		}
		return this.dataFactory.getOWLObjectOneOf(instantiatedIndividuals);
	}

	public OWLObject visit(OWLObjectProperty property) {
		OWLObjectProperty toReturn = property;
		Variable v = getAbstractingVariable(property);
		if (v != null) {
			toReturn = this.dataFactory.getOWLObjectProperty(v.getURI());
		}
		return toReturn;
	}

	public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual object = axiom.getObject();
		return this.dataFactory.getOWLObjectPropertyAssertionAxiom(
				(OWLIndividual) subject.accept(this),
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) object.accept(this));
	}

	public OWLObject visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		List<OWLObjectPropertyExpression> propertyChain = axiom
				.getPropertyChain();
		List<OWLObjectPropertyExpression> instantiatedPropertyChain = axiom
				.getPropertyChain();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
			instantiatedPropertyChain
					.add((OWLObjectPropertyExpression) objectPropertyExpression
							.accept(this));
		}
		return this.dataFactory.getOWLObjectPropertyChainSubPropertyAxiom(
				instantiatedPropertyChain,
				(OWLObjectPropertyExpression) superProperty.accept(this));
	}

	public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
		OWLDescription domain = axiom.getDomain();
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory.getOWLObjectPropertyDomainAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLDescription) domain.accept(this));
	}

	public OWLObject visit(OWLObjectPropertyInverse property) {
		OWLObjectPropertyExpression inverse = property.getInverse();
		return this.dataFactory
				.getOWLObjectPropertyInverse((OWLObjectPropertyExpression) inverse
						.accept(this));
	}

	public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLDescription range = axiom.getRange();
		return this.dataFactory.getOWLObjectPropertyRangeAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLDescription) range.accept(this));
	}

	public OWLObject visit(OWLObjectSelfRestriction desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory
				.getOWLObjectSelfRestriction((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLDescription visit(OWLObjectSomeRestriction desc) {
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.dataFactory.getOWLObjectSomeRestriction(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLDescription) filler.accept(this));
	}

	public OWLObject visit(OWLObjectSubPropertyAxiom axiom) {
		OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		return this.dataFactory.getOWLSubObjectPropertyAxiom(
				(OWLObjectPropertyExpression) subProperty.accept(this),
				(OWLObjectPropertyExpression) superProperty.accept(this));
	}

	public OWLDescription visit(OWLObjectUnionOf desc) {
		Set<OWLDescription> operands = desc.getOperands();
		Set<OWLDescription> instantiatedOperands = new HashSet<OWLDescription>();
		for (OWLDescription description : operands) {
			instantiatedOperands.add((OWLDescription) description.accept(this));
		}
		return this.dataFactory.getOWLObjectUnionOf(instantiatedOperands);
	}

	public OWLDescription visit(OWLObjectValueRestriction desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		OWLIndividual value = desc.getValue();
		return this.dataFactory.getOWLObjectValueRestriction(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) value.accept(this));
	}

	public OWLObject visit(OWLOntology ontology) {
		return ontology;
	}

	public OWLObject visit(OWLOntologyAnnotationAxiom axiom) {
		return axiom;
	}

	public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLReflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLSameIndividualsAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals
					.add((OWLIndividual) individual.accept(this));
		}
		return this.dataFactory
				.getOWLSameIndividualsAxiom(instantiatedIndividuals);
	}

	public OWLObject visit(OWLSubClassAxiom axiom) {
		OWLDescription superClass = (OWLDescription) axiom.getSuperClass()
				.accept(this);
		OWLDescription subClass = (OWLDescription) axiom.getSubClass().accept(
				this);
		return this.dataFactory.getOWLSubClassAxiom(subClass, superClass);
	}

	public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLSymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.dataFactory
				.getOWLTransitiveObjectPropertyAxiom((OWLObjectPropertyExpression) property
						.accept(this));
	}

	public OWLObject visit(OWLTypedConstant node) {
		OWLConstant toReturn = null;
		Variable v = getAbstractingVariable(node);
		if (v != null) {
			toReturn = this.dataFactory.getOWLTypedConstant(v.getURI()
					.toString());
		} else {
			toReturn = node;
		}
		return toReturn;
	}

	public OWLObject visit(OWLUntypedConstant node) {
		OWLConstant toReturn = null;
		Variable v = getAbstractingVariable(node);
		if (v != null) {
			toReturn = this.dataFactory.getOWLUntypedConstant(v.getURI()
					.toString());
		} else {
			toReturn = node;
		}
		return toReturn;
	}

	public OWLObject visit(SWRLAtomConstantObject node) {
		return node;
	}

	public OWLObject visit(SWRLAtomDVariable node) {
		return node;
	}

	public OWLObject visit(SWRLAtomIndividualObject node) {
		return node;
	}

	public OWLObject visit(SWRLAtomIVariable node) {
		return node;
	}

	public OWLObject visit(SWRLBuiltInAtom node) {
		return node;
	}

	public OWLObject visit(SWRLClassAtom node) {
		return node;
	}

	public OWLObject visit(SWRLDataRangeAtom node) {
		return node;
	}

	public OWLObject visit(SWRLDataValuedPropertyAtom node) {
		return node;
	}

	public OWLObject visit(SWRLDifferentFromAtom node) {
		return node;
	}

	public OWLObject visit(SWRLObjectPropertyAtom node) {
		return node;
	}

	public OWLObject visit(SWRLRule rule) {
		return rule;
	}

	public OWLObject visit(SWRLSameAsAtom node) {
		return node;
	}
}
