package org.coode.oppl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.utils.IRIVisitorExAdapter;
import org.coode.parsers.oppl.VariableIRI;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
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
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
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
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
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
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLBuiltInAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLDataRangeAtom;
import org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLSameIndividualAtom;
import org.semanticweb.owlapi.model.SWRLVariable;

abstract class AbstractOWLObjectInstantiator implements OWLObjectVisitorEx<OWLObject> {
	private final ValueComputationParameters parameters;

	protected AbstractOWLObjectInstantiator(ValueComputationParameters parameters) {
		if (parameters == null) {
			throw new NullPointerException("The parameters cannot be null");
		}
		this.parameters = parameters;
	}

	/**
	 * @return the parameters
	 */
	public ValueComputationParameters getParameters() {
		return this.parameters;
	}

	public OWLObject visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLAsymmetricObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLClassExpression visit(OWLClass desc) {
		OWLClassExpression toReturn = null;
		if (this.getParameters().getConstraintSystem().isVariable(desc)) {
			Variable<?> variable = this.getParameters().getConstraintSystem().getVariable(
					desc.getIRI());
			OWLClassExpression assignmentValue = (OWLClassExpression) this.getParameters().getBindingNode().getAssignmentValue(
					variable,
					this.getParameters());
			toReturn = assignmentValue == null ? desc : assignmentValue;
		} else {
			toReturn = desc;
		}
		return toReturn;
	}

	public OWLObject visit(OWLClassAssertionAxiom axiom) {
		OWLClassExpression description = axiom.getClassExpression();
		OWLIndividual individual = axiom.getIndividual();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLClassAssertionAxiom(
				(OWLClassExpression) description.accept(this),
				(OWLIndividual) individual.accept(this));
	}

	public OWLObject visit(OWLDataAllValuesFrom desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataAllValuesFrom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataComplementOf node) {
		OWLDataRange dataRange = node.getDataRange();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataComplementOf(
				(OWLDataRange) dataRange.accept(this));
	}

	public OWLObject visit(OWLDataExactCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataExactCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataMaxCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataMaxCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataMinCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataMinCardinality(
				cardinality,
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLDataOneOf node) {
		Set<OWLLiteral> values = node.getValues();
		Set<OWLLiteral> instantiatedValues = new HashSet<OWLLiteral>();
		for (OWLLiteral constant : values) {
			instantiatedValues.add((OWLLiteral) constant.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataOneOf(
				instantiatedValues);
	}

	public OWLObject visit(OWLDataProperty property) {
		OWLDataProperty toReturn = property;
		if (this.getParameters().getConstraintSystem().isVariable(property)) {
			Variable<?> variable = this.getParameters().getConstraintSystem().getVariable(
					property.getIRI());
			OWLDataProperty assignmentValue = (OWLDataProperty) this.getParameters().getBindingNode().getAssignmentValue(
					variable,
					this.getParameters());
			toReturn = assignmentValue == null ? property : assignmentValue;
		}
		return toReturn;
	}

	public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLLiteral object = axiom.getObject();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataPropertyAssertionAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLLiteral) object.accept(this));
	}

	public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
		OWLClassExpression domain = axiom.getDomain();
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataPropertyDomainAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLClassExpression) domain.accept(this));
	}

	public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLDataRange range = axiom.getRange();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataPropertyRangeAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) range.accept(this));
	}

	public OWLObject visit(OWLDatatypeRestriction node) {
		OWLDataRange dataRange = node.getDatatype();
		Set<OWLFacetRestriction> facetRestrictions = node.getFacetRestrictions();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDatatypeRestriction(
				(OWLDatatype) dataRange.accept(this),
				facetRestrictions);
	}

	public OWLObject visit(OWLDataSomeValuesFrom desc) {
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataSomeValuesFrom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLDataRange) filler.accept(this));
	}

	public OWLObject visit(OWLSubDataPropertyOfAxiom axiom) {
		OWLDataPropertyExpression subProperty = axiom.getSubProperty();
		OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubDataPropertyOfAxiom(
				(OWLDataPropertyExpression) subProperty.accept(this),
				(OWLDataPropertyExpression) superProperty.accept(this));
	}

	public OWLObject visit(OWLDatatype node) {
		return node;
	}

	public OWLObject visit(OWLDataHasValue desc) {
		OWLDataPropertyExpression property = desc.getProperty();
		OWLLiteral value = desc.getValue();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDataHasValue(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLLiteral) value.accept(this));
	}

	public OWLObject visit(OWLDeclarationAxiom axiom) {
		return axiom;
	}

	public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDifferentIndividualsAxiom(
				instantiatedIndividuals);
	}

	public OWLObject visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Set<OWLClassExpression> instatiatedDescriptions = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : descriptions) {
			instatiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointClassesAxiom(
				instatiatedDescriptions);
	}

	public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLDataPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointDataPropertiesAxiom(
				instantiatedProperties);
	}

	public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLDisjointObjectPropertiesAxiom(
				instantiatedProperties);
	}

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

	public OWLObject visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Set<OWLClassExpression> instantiatedDescriptions = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : descriptions) {
			instantiatedDescriptions.add((OWLClassExpression) description.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLEquivalentClassesAxiom(
				instantiatedDescriptions);
	}

	public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			instantiatedProperties.add((OWLDataPropertyExpression) dataPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLEquivalentDataPropertiesAxiom(
				instantiatedProperties);
	}

	public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			instantiatedProperties.add((OWLObjectPropertyExpression) objectPropertyExpression.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLEquivalentObjectPropertiesAxiom(
				instantiatedProperties);
	}

	public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLFunctionalDataPropertyAxiom(
				(OWLDataPropertyExpression) property.accept(this));
	}

	public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLFunctionalObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLObject visit(OWLNamedIndividual individual) {
		OWLNamedIndividual toReturn = individual;
		if (this.getParameters().getConstraintSystem().isVariable(individual)) {
			Variable<?> variable = this.getParameters().getConstraintSystem().getVariable(
					individual.getIRI());
			OWLNamedIndividual assignmentValue = (OWLNamedIndividual) this.getParameters().getBindingNode().getAssignmentValue(
					variable,
					this.getParameters());
			toReturn = assignmentValue == null ? individual : assignmentValue;
		}
		return toReturn;
	}

	public OWLObject visit(OWLAnonymousIndividual individual) {
		return individual;
	}

	public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLInverseFunctionalObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
		OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
		OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLInverseObjectPropertiesAxiom(
				(OWLObjectPropertyExpression) firstProperty.accept(this),
				(OWLObjectPropertyExpression) secondProperty.accept(this));
	}

	public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLIrreflexiveObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLLiteral object = axiom.getObject();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLNegativeDataPropertyAssertionAxiom(
				(OWLDataPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLLiteral) object.accept(this));
	}

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

	public OWLClassExpression visit(OWLObjectAllValuesFrom desc) {
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectAllValuesFrom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	public OWLClassExpression visit(OWLObjectComplementOf desc) {
		OWLClassExpression operand = desc.getOperand();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectComplementOf(
				(OWLClassExpression) operand.accept(this));
	}

	public OWLObject visit(OWLObjectExactCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectExactCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	public OWLClassExpression visit(OWLObjectIntersectionOf desc) {
		Set<OWLClassExpression> operands = desc.getOperands();
		Set<OWLClassExpression> instantiatedOperands = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : operands) {
			instantiatedOperands.add((OWLClassExpression) description.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectIntersectionOf(
				instantiatedOperands);
	}

	public OWLObject visit(OWLObjectMaxCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectMaxCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	public OWLObject visit(OWLObjectMinCardinality desc) {
		int cardinality = desc.getCardinality();
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectMinCardinality(
				cardinality,
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	public OWLObject visit(OWLObjectOneOf desc) {
		Set<OWLIndividual> individuals = desc.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>();
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectOneOf(
				instantiatedIndividuals);
	}

	public OWLObject visit(OWLObjectProperty property) {
		OWLObjectProperty toReturn = property;
		if (this.getParameters().getConstraintSystem().isVariable(property)) {
			Variable<?> variable = this.getParameters().getConstraintSystem().getVariable(
					property.getIRI());
			OWLObjectProperty assignmentValue = (OWLObjectProperty) this.getParameters().getBindingNode().getAssignmentValue(
					variable,
					this.getParameters());
			toReturn = assignmentValue == null ? property : assignmentValue;
		}
		return toReturn;
	}

	public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
		OWLIndividual subject = axiom.getSubject();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual object = axiom.getObject();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectPropertyAssertionAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) subject.accept(this),
				(OWLIndividual) object.accept(this));
	}

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

	public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
		OWLClassExpression domain = axiom.getDomain();
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectPropertyDomainAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) domain.accept(this));
	}

	public OWLObject visit(OWLObjectInverseOf property) {
		OWLObjectPropertyExpression inverse = property.getInverse();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectInverseOf(
				(OWLObjectPropertyExpression) inverse.accept(this));
	}

	public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLClassExpression range = axiom.getRange();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectPropertyRangeAxiom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) range.accept(this));
	}

	public OWLObject visit(OWLObjectHasSelf desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectHasSelf(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLClassExpression visit(OWLObjectSomeValuesFrom desc) {
		OWLClassExpression filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectSomeValuesFrom(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLClassExpression) filler.accept(this));
	}

	public OWLObject visit(OWLSubObjectPropertyOfAxiom axiom) {
		OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubObjectPropertyOfAxiom(
				(OWLObjectPropertyExpression) subProperty.accept(this),
				(OWLObjectPropertyExpression) superProperty.accept(this));
	}

	public OWLClassExpression visit(OWLObjectUnionOf desc) {
		Set<OWLClassExpression> operands = desc.getOperands();
		Set<OWLClassExpression> instantiatedOperands = new HashSet<OWLClassExpression>();
		for (OWLClassExpression description : operands) {
			instantiatedOperands.add((OWLClassExpression) description.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectUnionOf(
				instantiatedOperands);
	}

	public OWLClassExpression visit(OWLObjectHasValue desc) {
		OWLObjectPropertyExpression property = desc.getProperty();
		OWLIndividual value = desc.getValue();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLObjectHasValue(
				(OWLObjectPropertyExpression) property.accept(this),
				(OWLIndividual) value.accept(this));
	}

	public OWLObject visit(OWLOntology ontology) {
		return ontology;
	}

	public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLReflexiveObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLObject visit(OWLSameIndividualAxiom axiom) {
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>(
				axiom.getIndividuals().size());
		for (OWLIndividual individual : individuals) {
			instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
		}
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSameIndividualAxiom(
				instantiatedIndividuals);
	}

	public OWLObject visit(OWLSubClassOfAxiom axiom) {
		OWLClassExpression superClass = (OWLClassExpression) axiom.getSuperClass().accept(this);
		OWLClassExpression subClass = (OWLClassExpression) axiom.getSubClass().accept(this);
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSubClassOfAxiom(
				subClass,
				superClass);
	}

	public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLSymmetricObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
		OWLObjectPropertyExpression property = axiom.getProperty();
		return this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory().getOWLTransitiveObjectPropertyAxiom(
				(OWLObjectPropertyExpression) property.accept(this));
	}

	public abstract OWLObject visit(OWLLiteral node);

	public OWLObject visit(SWRLBuiltInAtom node) {
		return node;
	}

	public OWLObject visit(SWRLClassAtom node) {
		return node;
	}

	public OWLObject visit(SWRLDataRangeAtom node) {
		return node;
	}

	public OWLObject visit(SWRLObjectPropertyAtom node) {
		return node;
	}

	public OWLObject visit(SWRLRule rule) {
		return rule;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLDataPropertyAtom)
	 */
	public OWLObject visit(SWRLDataPropertyAtom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom)
	 */
	public OWLObject visit(SWRLDifferentIndividualsAtom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLIndividualArgument)
	 */
	public OWLObject visit(SWRLIndividualArgument arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLLiteralArgument)
	 */
	public OWLObject visit(SWRLLiteralArgument arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLSameIndividualAtom)
	 */
	public OWLObject visit(SWRLSameIndividualAtom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLVariable)
	 */
	public OWLObject visit(SWRLVariable arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationObjectVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotation)
	 */
	public OWLObject visit(OWLAnnotation annotation) {
		OWLDataFactory dataFactory = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory();
		return dataFactory.getOWLAnnotation(
				(OWLAnnotationProperty) annotation.getProperty().accept(this),
				(OWLAnnotationValue) annotation.getValue().accept(this));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom)
	 */
	public OWLObject visit(OWLAnnotationPropertyDomainAxiom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom)
	 */
	public OWLObject visit(OWLAnnotationPropertyRangeAxiom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom)
	 */
	public OWLObject visit(OWLSubAnnotationPropertyOfAxiom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationValueVisitorEx#visit(org.semanticweb.owlapi.model.IRI)
	 */
	public OWLObject visit(IRI iri) {
		return iri.accept(new IRIVisitorExAdapter<IRI>(iri) {
			@Override
			public IRI visitVariableIRI(VariableIRI iri) {
				IRI value = iri.getAttribute().compute(
						AbstractOWLObjectInstantiator.this.getParameters());
				return value == null ? iri : value;
			}
		});
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLDataVisitorEx#visit(org.semanticweb.owlapi.model.OWLDataIntersectionOf)
	 */
	public OWLObject visit(OWLDataIntersectionOf arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLDataVisitorEx#visit(org.semanticweb.owlapi.model.OWLDataUnionOf)
	 */
	public OWLObject visit(OWLDataUnionOf arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLDataVisitorEx#visit(org.semanticweb.owlapi.model.OWLFacetRestriction)
	 */
	public OWLObject visit(OWLFacetRestriction arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLEntityVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	public OWLObject visit(OWLAnnotationProperty arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom)
	 */
	public OWLObject visit(OWLAnnotationAssertionAxiom axiom) {
		OWLDataFactory dataFactory = this.getParameters().getConstraintSystem().getOntologyManager().getOWLDataFactory();
		return dataFactory.getOWLAnnotationAssertionAxiom(
				(OWLAnnotationSubject) axiom.getSubject().accept(this),
				(OWLAnnotation) axiom.getAnnotation().accept(this));
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom)
	 */
	public OWLObject visit(OWLDatatypeDefinitionAxiom arg0) {
		return arg0;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLHasKeyAxiom)
	 */
	public OWLObject visit(OWLHasKeyAxiom arg0) {
		return arg0;
	}
}
