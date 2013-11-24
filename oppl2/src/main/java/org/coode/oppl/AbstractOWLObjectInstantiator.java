package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.datafactory.OPPLOWLDifferentIndividualsAxiom;
import org.coode.oppl.datafactory.OPPLOWLDisjointClassesAxiom;
import org.coode.oppl.datafactory.OPPLOWLDisjointDataPropertiesAxiom;
import org.coode.oppl.datafactory.OPPLOWLDisjointObjectPropertiesAxiom;
import org.coode.oppl.datafactory.OPPLOWLSameIndividualAxiom;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.function.inline.InlineSet;
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
    private final OWLDataFactory df;

    protected AbstractOWLObjectInstantiator(ValueComputationParameters parameters) {
        this.parameters = checkNotNull(parameters, "The parameters");
        df = parameters.getConstraintSystem().getOntologyManager().getOWLDataFactory();
    }

    /** @return the parameters */
    public ValueComputationParameters getParameters() {
        return parameters;
    }

    @Override
    public OWLAsymmetricObjectPropertyAxiom visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df
                .getOWLAsymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public OWLClassExpression visit(OWLClass desc) {
        OWLClassExpression toReturn = null;
        if (getParameters().getConstraintSystem().isVariable(desc)) {
            Variable<?> variable = getParameters().getConstraintSystem().getVariable(
                    desc.getIRI());
            OWLClassExpression assignmentValue = (OWLClassExpression) getParameters()
                    .getBindingNode().getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? desc : assignmentValue;
        } else {
            toReturn = desc;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLClassAssertionAxiom axiom) {
        OWLClassExpression description = axiom.getClassExpression();
        OWLIndividual individual = axiom.getIndividual();
        return df.getOWLClassAssertionAxiom(
                (OWLClassExpression) description.accept(this),
                (OWLIndividual) individual.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataAllValuesFrom desc) {
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataAllValuesFrom(
                (OWLDataPropertyExpression) property.accept(this),
                (OWLDataRange) filler.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataComplementOf node) {
        OWLDataRange dataRange = node.getDataRange();
        return df.getOWLDataComplementOf((OWLDataRange) dataRange.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataExactCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataExactCardinality(cardinality,
                (OWLDataPropertyExpression) property.accept(this),
                (OWLDataRange) filler.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataMaxCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataMaxCardinality(cardinality,
                (OWLDataPropertyExpression) property.accept(this),
                (OWLDataRange) filler.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataMinCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataMinCardinality(cardinality,
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
        return df.getOWLDataOneOf(instantiatedValues);
    }

    @Override
    public OWLObject visit(OWLDataProperty property) {
        OWLDataProperty toReturn = property;
        if (getParameters().getConstraintSystem().isVariable(property)) {
            Variable<?> variable = getParameters().getConstraintSystem().getVariable(
                    property.getIRI());
            OWLDataProperty assignmentValue = (OWLDataProperty) getParameters()
                    .getBindingNode().getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? property : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
        OWLIndividual subject = axiom.getSubject();
        OWLDataPropertyExpression property = axiom.getProperty();
        OWLLiteral object = axiom.getObject();
        return df.getOWLDataPropertyAssertionAxiom(
                (OWLDataPropertyExpression) property.accept(this),
                (OWLIndividual) subject.accept(this), (OWLLiteral) object.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
        OWLClassExpression domain = axiom.getDomain();
        OWLDataPropertyExpression property = axiom.getProperty();
        return df.getOWLDataPropertyDomainAxiom(
                (OWLDataPropertyExpression) property.accept(this),
                (OWLClassExpression) domain.accept(this));
    }

    @Override
    public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
        OWLDataPropertyExpression property = axiom.getProperty();
        OWLDataRange range = axiom.getRange();
        return df.getOWLDataPropertyRangeAxiom(
                (OWLDataPropertyExpression) property.accept(this),
                (OWLDataRange) range.accept(this));
    }

    @Override
    public OWLObject visit(OWLDatatypeRestriction node) {
        OWLDataRange dataRange = node.getDatatype();
        Set<OWLFacetRestriction> facetRestrictions = node.getFacetRestrictions();
        return df.getOWLDatatypeRestriction((OWLDatatype) dataRange.accept(this),
                facetRestrictions);
    }

    @Override
    public OWLObject visit(OWLDataSomeValuesFrom desc) {
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataSomeValuesFrom(
                (OWLDataPropertyExpression) property.accept(this),
                (OWLDataRange) filler.accept(this));
    }

    @Override
    public OWLObject visit(OWLSubDataPropertyOfAxiom axiom) {
        OWLDataPropertyExpression subProperty = axiom.getSubProperty();
        OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
        return df.getOWLSubDataPropertyOfAxiom(
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
        return df.getOWLDataHasValue((OWLDataPropertyExpression) property.accept(this),
                (OWLLiteral) value.accept(this));
    }

    @Override
    public OWLObject visit(OWLDeclarationAxiom axiom) {
        return axiom;
    }

    @Override
    public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
        Set<OWLIndividual> individuals = axiom.getIndividuals();
        Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>();
        if (OPPLOWLDifferentIndividualsAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLIndividual> inlineSet = ((OPPLOWLDifferentIndividualsAxiom) axiom)
                    .getInlineSet();
            instantiatedIndividuals.addAll(inlineSet.compute(getParameters()));
        } else {
            for (OWLIndividual individual : individuals) {
                instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
            }
        }
        return df.getOWLDifferentIndividualsAxiom(instantiatedIndividuals);
    }

    @Override
    public OWLObject visit(OWLDisjointClassesAxiom axiom) {
        Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
        Set<OWLClassExpression> instatiatedDescriptions = new HashSet<OWLClassExpression>();
        if (OPPLOWLDisjointClassesAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLClassExpression> inlineSet = ((OPPLOWLDisjointClassesAxiom) axiom)
                    .getInlineSet();
            instatiatedDescriptions.addAll(inlineSet.compute(getParameters()));
        } else {
            for (OWLClassExpression description : descriptions) {
                instatiatedDescriptions
                        .add((OWLClassExpression) description.accept(this));
            }
        }
        return df.getOWLDisjointClassesAxiom(instatiatedDescriptions);
    }

    @Override
    public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
        Set<OWLDataPropertyExpression> properties = axiom.getProperties();
        Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
        if (OPPLOWLDisjointDataPropertiesAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLDataPropertyExpression> inlineSet = ((OPPLOWLDisjointDataPropertiesAxiom) axiom)
                    .getInlineSet();
            instantiatedProperties.addAll(inlineSet.compute(getParameters()));
        } else {
            for (OWLDataPropertyExpression objectPropertyExpression : properties) {
                instantiatedProperties
                        .add((OWLDataPropertyExpression) objectPropertyExpression
                                .accept(this));
            }
        }
        return df.getOWLDisjointDataPropertiesAxiom(instantiatedProperties);
    }

    @Override
    public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
        Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
        Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
        if (OPPLOWLDisjointObjectPropertiesAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLObjectPropertyExpression> inlineSet = ((OPPLOWLDisjointObjectPropertiesAxiom) axiom)
                    .getInlineSet();
            instantiatedProperties.addAll(inlineSet.compute(getParameters()));
        } else {
            for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
                instantiatedProperties
                        .add((OWLObjectPropertyExpression) objectPropertyExpression
                                .accept(this));
            }
        }
        return df.getOWLDisjointObjectPropertiesAxiom(instantiatedProperties);
    }

    @Override
    public OWLObject visit(OWLDisjointUnionAxiom axiom) {
        Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
        OWLClass owlClass = axiom.getOWLClass();
        Set<OWLClassExpression> instantiatedDescriptions = axiom.getClassExpressions();
        for (OWLClassExpression description : descriptions) {
            instantiatedDescriptions.add((OWLClassExpression) description.accept(this));
        }
        return df.getOWLDisjointUnionAxiom((OWLClass) owlClass.accept(this),
                instantiatedDescriptions);
    }

    @Override
    public OWLObject visit(OWLEquivalentClassesAxiom axiom) {
        Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
        Set<OWLClassExpression> instantiatedDescriptions = new HashSet<OWLClassExpression>();
        for (OWLClassExpression description : descriptions) {
            instantiatedDescriptions.add((OWLClassExpression) description.accept(this));
        }
        return df.getOWLEquivalentClassesAxiom(instantiatedDescriptions);
    }

    @Override
    public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
        Set<OWLDataPropertyExpression> properties = axiom.getProperties();
        Set<OWLDataPropertyExpression> instantiatedProperties = new HashSet<OWLDataPropertyExpression>();
        for (OWLDataPropertyExpression dataPropertyExpression : properties) {
            instantiatedProperties.add((OWLDataPropertyExpression) dataPropertyExpression
                    .accept(this));
        }
        return df.getOWLEquivalentDataPropertiesAxiom(instantiatedProperties);
    }

    @Override
    public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
        Set<OWLObjectPropertyExpression> instantiatedProperties = new HashSet<OWLObjectPropertyExpression>();
        for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
            instantiatedProperties
                    .add((OWLObjectPropertyExpression) objectPropertyExpression
                            .accept(this));
        }
        return df.getOWLEquivalentObjectPropertiesAxiom(instantiatedProperties);
    }

    @Override
    public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
        OWLDataPropertyExpression property = axiom.getProperty();
        return df.getOWLFunctionalDataPropertyAxiom((OWLDataPropertyExpression) property
                .accept(this));
    }

    @Override
    public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df
                .getOWLFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public OWLObject visit(OWLNamedIndividual individual) {
        OWLNamedIndividual toReturn = individual;
        if (getParameters().getConstraintSystem().isVariable(individual)) {
            Variable<?> variable = getParameters().getConstraintSystem().getVariable(
                    individual.getIRI());
            OWLNamedIndividual assignmentValue = (OWLNamedIndividual) getParameters()
                    .getBindingNode().getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? individual : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLAnonymousIndividual individual) {
        return individual;
    }

    @Override
    public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df
                .getOWLInverseFunctionalObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
        OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
        OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
        return df.getOWLInverseObjectPropertiesAxiom(
                (OWLObjectPropertyExpression) firstProperty.accept(this),
                (OWLObjectPropertyExpression) secondProperty.accept(this));
    }

    @Override
    public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df
                .getOWLIrreflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        OWLDataPropertyExpression property = axiom.getProperty();
        OWLIndividual subject = axiom.getSubject();
        OWLLiteral object = axiom.getObject();
        return df.getOWLNegativeDataPropertyAssertionAxiom(
                (OWLDataPropertyExpression) property.accept(this),
                (OWLIndividual) subject.accept(this), (OWLLiteral) object.accept(this));
    }

    @Override
    public OWLObject visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        OWLIndividual subject = axiom.getSubject();
        OWLIndividual object = axiom.getObject();
        OWLIndividual instantiatedSubject = (OWLIndividual) subject.accept(this);
        OWLObjectPropertyExpression instantiatedProperty = (OWLObjectPropertyExpression) property
                .accept(this);
        OWLIndividual instantiatedObject = (OWLIndividual) object.accept(this);
        return df.getOWLNegativeObjectPropertyAssertionAxiom(instantiatedProperty,
                instantiatedSubject, instantiatedObject);
    }

    @Override
    public OWLClassExpression visit(OWLObjectAllValuesFrom desc) {
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectAllValuesFrom(
                (OWLObjectPropertyExpression) property.accept(this),
                (OWLClassExpression) filler.accept(this));
    }

    @Override
    public OWLClassExpression visit(OWLObjectComplementOf desc) {
        OWLClassExpression operand = desc.getOperand();
        return df.getOWLObjectComplementOf((OWLClassExpression) operand.accept(this));
    }

    @Override
    public OWLObject visit(OWLObjectExactCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectExactCardinality(cardinality,
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
        return df.getOWLObjectIntersectionOf(instantiatedOperands);
    }

    @Override
    public OWLObject visit(OWLObjectMaxCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectMaxCardinality(cardinality,
                (OWLObjectPropertyExpression) property.accept(this),
                (OWLClassExpression) filler.accept(this));
    }

    @Override
    public OWLObject visit(OWLObjectMinCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectMinCardinality(cardinality,
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
        return df.getOWLObjectOneOf(instantiatedIndividuals);
    }

    @Override
    public OWLObject visit(OWLObjectProperty property) {
        OWLObjectProperty toReturn = property;
        if (getParameters().getConstraintSystem().isVariable(property)) {
            Variable<?> variable = getParameters().getConstraintSystem().getVariable(
                    property.getIRI());
            OWLObjectProperty assignmentValue = (OWLObjectProperty) getParameters()
                    .getBindingNode().getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? property : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
        OWLIndividual subject = axiom.getSubject();
        OWLObjectPropertyExpression property = axiom.getProperty();
        OWLIndividual object = axiom.getObject();
        return df
                .getOWLObjectPropertyAssertionAxiom(
                        (OWLObjectPropertyExpression) property.accept(this),
                        (OWLIndividual) subject.accept(this),
                        (OWLIndividual) object.accept(this));
    }

    @Override
    public OWLObject visit(OWLSubPropertyChainOfAxiom axiom) {
        List<OWLObjectPropertyExpression> propertyChain = axiom.getPropertyChain();
        List<OWLObjectPropertyExpression> instantiatedPropertyChain = new ArrayList<OWLObjectPropertyExpression>();
        OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
        for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
            instantiatedPropertyChain
                    .add((OWLObjectPropertyExpression) objectPropertyExpression
                            .accept(this));
        }
        return df.getOWLSubPropertyChainOfAxiom(instantiatedPropertyChain,
                (OWLObjectPropertyExpression) superProperty.accept(this));
    }

    @Override
    public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
        OWLClassExpression domain = axiom.getDomain();
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLObjectPropertyDomainAxiom(
                (OWLObjectPropertyExpression) property.accept(this),
                (OWLClassExpression) domain.accept(this));
    }

    @Override
    public OWLObject visit(OWLObjectInverseOf property) {
        OWLObjectPropertyExpression inverse = property.getInverse();
        return df.getOWLObjectInverseOf((OWLObjectPropertyExpression) inverse
                .accept(this));
    }

    @Override
    public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        OWLClassExpression range = axiom.getRange();
        return df.getOWLObjectPropertyRangeAxiom(
                (OWLObjectPropertyExpression) property.accept(this),
                (OWLClassExpression) range.accept(this));
    }

    @Override
    public OWLObject visit(OWLObjectHasSelf desc) {
        OWLObjectPropertyExpression property = desc.getProperty();
        return df
                .getOWLObjectHasSelf((OWLObjectPropertyExpression) property.accept(this));
    }

    @Override
    public OWLClassExpression visit(OWLObjectSomeValuesFrom desc) {
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectSomeValuesFrom(
                (OWLObjectPropertyExpression) property.accept(this),
                (OWLClassExpression) filler.accept(this));
    }

    @Override
    public OWLObject visit(OWLSubObjectPropertyOfAxiom axiom) {
        OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
        OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
        return df.getOWLSubObjectPropertyOfAxiom(
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
        return df.getOWLObjectUnionOf(instantiatedOperands);
    }

    @Override
    public OWLClassExpression visit(OWLObjectHasValue desc) {
        OWLObjectPropertyExpression property = desc.getProperty();
        OWLIndividual value = desc.getValue();
        return df.getOWLObjectHasValue(
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
        return df
                .getOWLReflexiveObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public OWLObject visit(OWLSameIndividualAxiom axiom) {
        Set<OWLIndividual> individuals = axiom.getIndividuals();
        Set<OWLIndividual> instantiatedIndividuals = new HashSet<OWLIndividual>(axiom
                .getIndividuals().size());
        if (OPPLOWLSameIndividualAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLIndividual> inlineSet = ((OPPLOWLSameIndividualAxiom) axiom)
                    .getInlineSet();
            instantiatedIndividuals.addAll(inlineSet.compute(getParameters()));
        } else {
            for (OWLIndividual individual : individuals) {
                instantiatedIndividuals.add((OWLIndividual) individual.accept(this));
            }
        }
        return df.getOWLSameIndividualAxiom(instantiatedIndividuals);
    }

    @Override
    public OWLObject visit(OWLSubClassOfAxiom axiom) {
        OWLClassExpression superClass = (OWLClassExpression) axiom.getSuperClass()
                .accept(this);
        OWLClassExpression subClass = (OWLClassExpression) axiom.getSubClass().accept(
                this);
        return df.getOWLSubClassOfAxiom(subClass, superClass);
    }

    @Override
    public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df
                .getOWLSymmetricObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df
                .getOWLTransitiveObjectPropertyAxiom((OWLObjectPropertyExpression) property
                        .accept(this));
    }

    @Override
    public abstract OWLObject visit(OWLLiteral node);

    @Override
    public OWLObject visit(SWRLBuiltInAtom node) {
        return node;
    }

    @Override
    public OWLObject visit(SWRLClassAtom node) {
        return node;
    }

    @Override
    public OWLObject visit(SWRLDataRangeAtom node) {
        return node;
    }

    @Override
    public OWLObject visit(SWRLObjectPropertyAtom node) {
        return node;
    }

    @Override
    public OWLObject visit(SWRLRule rule) {
        return rule;
    }

    @Override
    public OWLObject visit(SWRLDataPropertyAtom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(SWRLDifferentIndividualsAtom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(SWRLIndividualArgument arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(SWRLLiteralArgument arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(SWRLSameIndividualAtom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(SWRLVariable arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLAnnotation annotation) {
        return df.getOWLAnnotation((OWLAnnotationProperty) annotation.getProperty()
                .accept(this), (OWLAnnotationValue) annotation.getValue().accept(this));
    }

    @Override
    public OWLObject visit(OWLAnnotationPropertyDomainAxiom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLAnnotationPropertyRangeAxiom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLSubAnnotationPropertyOfAxiom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(IRI iri) {
        return iri.accept(new IRIVisitorExAdapter<IRI>(iri) {
            @Override
            public IRI visitVariableIRI(VariableIRI i) {
                IRI value = i.getAttribute().compute(
                        AbstractOWLObjectInstantiator.this.getParameters());
                return value == null ? i : value;
            }
        });
    }

    @Override
    public OWLObject visit(OWLDataIntersectionOf arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLDataUnionOf arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLFacetRestriction arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLAnnotationProperty property) {
        OWLAnnotationProperty toReturn = property;
        if (getParameters().getConstraintSystem().isVariable(property)) {
            Variable<?> variable = getParameters().getConstraintSystem().getVariable(
                    property.getIRI());
            OWLAnnotationProperty assignmentValue = (OWLAnnotationProperty) getParameters()
                    .getBindingNode().getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? property : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLAnnotationAssertionAxiom axiom) {
        return df.getOWLAnnotationAssertionAxiom((OWLAnnotationSubject) axiom
                .getSubject().accept(this),
                (OWLAnnotation) axiom.getAnnotation().accept(this));
    }

    @Override
    public OWLObject visit(OWLDatatypeDefinitionAxiom arg0) {
        return arg0;
    }

    @Override
    public OWLObject visit(OWLHasKeyAxiom arg0) {
        return arg0;
    }
}
