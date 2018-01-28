package org.coode.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asList;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * @return the parameters
     */
    public ValueComputationParameters getParameters() {
        return parameters;
    }

    private <T extends OWLObject> T v(T t) {
        return (T) t.accept(this);
    }

    @Override
    public OWLAsymmetricObjectPropertyAxiom visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLAsymmetricObjectPropertyAxiom(v(property));
    }

    @Override
    public OWLClassExpression visit(OWLClass desc) {
        OWLClassExpression toReturn = null;
        if (getParameters().getConstraintSystem().isVariable(desc)) {
            Variable<?> variable = getParameters().getConstraintSystem().getVariable(desc.getIRI());
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
        return df.getOWLClassAssertionAxiom(v(description), v(individual));
    }

    @Override
    public OWLObject visit(OWLDataAllValuesFrom desc) {
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataAllValuesFrom(v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLDataComplementOf node) {
        OWLDataRange dataRange = node.getDataRange();
        return df.getOWLDataComplementOf(v(dataRange));
    }

    @Override
    public OWLObject visit(OWLDataExactCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataExactCardinality(cardinality, v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLDataMaxCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataMaxCardinality(cardinality, v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLDataMinCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataMinCardinality(cardinality, v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLDataOneOf node) {
        return df.getOWLDataOneOf(node.values().map(this::v));
    }

    @Override
    public OWLObject visit(OWLDataProperty property) {
        OWLDataProperty toReturn = property;
        if (getParameters().getConstraintSystem().isVariable(property)) {
            Variable<?> variable =
                getParameters().getConstraintSystem().getVariable(property.getIRI());
            OWLDataProperty assignmentValue = (OWLDataProperty) getParameters().getBindingNode()
                .getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? property : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
        OWLIndividual subject = axiom.getSubject();
        OWLDataPropertyExpression property = axiom.getProperty();
        OWLLiteral object = axiom.getObject();
        return df.getOWLDataPropertyAssertionAxiom(v(property), v(subject), v(object));
    }

    @Override
    public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
        OWLClassExpression domain = axiom.getDomain();
        OWLDataPropertyExpression property = axiom.getProperty();
        return df.getOWLDataPropertyDomainAxiom(v(property), v(domain));
    }

    @Override
    public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
        OWLDataPropertyExpression property = axiom.getProperty();
        OWLDataRange range = axiom.getRange();
        return df.getOWLDataPropertyRangeAxiom(v(property), v(range));
    }

    @Override
    public OWLObject visit(OWLDatatypeRestriction node) {
        return df.getOWLDatatypeRestriction((OWLDatatype) node.getDatatype().accept(this),
            asList(node.facetRestrictions()));
    }

    @Override
    public OWLObject visit(OWLDataSomeValuesFrom desc) {
        OWLDataRange filler = desc.getFiller();
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataSomeValuesFrom(v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLSubDataPropertyOfAxiom axiom) {
        OWLDataPropertyExpression subProperty = axiom.getSubProperty();
        OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
        return df.getOWLSubDataPropertyOfAxiom(v(subProperty), v(superProperty));
    }

    @Override
    public OWLObject visit(OWLDatatype node) {
        return node;
    }

    @Override
    public OWLObject visit(OWLDataHasValue desc) {
        OWLDataPropertyExpression property = desc.getProperty();
        return df.getOWLDataHasValue(v(property), (OWLLiteral) desc.getFiller().accept(this));
    }

    @Override
    public OWLObject visit(OWLDeclarationAxiom axiom) {
        return axiom;
    }

    @Override
    public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
        if (OPPLOWLDifferentIndividualsAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLIndividual> inlineSet =
                ((OPPLOWLDifferentIndividualsAxiom) axiom).getInlineSet();
            return df.getOWLDifferentIndividualsAxiom(inlineSet.compute(getParameters()));
        }

        return df.getOWLDifferentIndividualsAxiom(asList(axiom.individuals().map(this::v)));
    }

    @Override
    public OWLObject visit(OWLDisjointClassesAxiom axiom) {
        if (OPPLOWLDisjointClassesAxiom.class.isAssignableFrom(axiom.getClass())) {
            OPPLOWLDisjointClassesAxiom ax = (OPPLOWLDisjointClassesAxiom) axiom;
            return df.getOWLDisjointClassesAxiom(ax.getInlineSet().compute(getParameters()));
        }
        return df.getOWLDisjointClassesAxiom(axiom.classExpressions().map(this::v));
    }

    @Override
    public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
        if (OPPLOWLDisjointDataPropertiesAxiom.class.isAssignableFrom(axiom.getClass())) {
            OPPLOWLDisjointDataPropertiesAxiom ax = (OPPLOWLDisjointDataPropertiesAxiom) axiom;
            return df.getOWLDisjointDataPropertiesAxiom(ax.getInlineSet().compute(getParameters()));
        }
        return df.getOWLDisjointDataPropertiesAxiom(asList(axiom.properties().map(this::v)));
    }

    @Override
    public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
        if (OPPLOWLDisjointObjectPropertiesAxiom.class.isAssignableFrom(axiom.getClass())) {
            OPPLOWLDisjointObjectPropertiesAxiom ax = (OPPLOWLDisjointObjectPropertiesAxiom) axiom;
            return df
                .getOWLDisjointObjectPropertiesAxiom(ax.getInlineSet().compute(getParameters()));
        }
        return df.getOWLDisjointObjectPropertiesAxiom(asList(axiom.properties().map(this::v)));
    }

    @Override
    public OWLObject visit(OWLDisjointUnionAxiom axiom) {
        return df.getOWLDisjointUnionAxiom((OWLClass) axiom.getOWLClass().accept(this),
            axiom.classExpressions().map(this::v));
    }

    @Override
    public OWLObject visit(OWLEquivalentClassesAxiom axiom) {
        return df.getOWLEquivalentClassesAxiom(axiom.classExpressions().map(this::v));
    }

    @Override
    public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return df.getOWLEquivalentDataPropertiesAxiom(asList(axiom.properties().map(this::v)));
    }

    @Override
    public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return df.getOWLEquivalentObjectPropertiesAxiom(asList(axiom.properties().map(this::v)));
    }

    @Override
    public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
        OWLDataPropertyExpression property = axiom.getProperty();
        return df.getOWLFunctionalDataPropertyAxiom(v(property));
    }

    @Override
    public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLFunctionalObjectPropertyAxiom(v(property));
    }

    @Override
    public OWLObject visit(OWLNamedIndividual individual) {
        OWLNamedIndividual toReturn = individual;
        if (getParameters().getConstraintSystem().isVariable(individual)) {
            Variable<?> variable =
                getParameters().getConstraintSystem().getVariable(individual.getIRI());
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
        return df.getOWLInverseFunctionalObjectPropertyAxiom(v(property));
    }

    @Override
    public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
        OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
        OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
        return df.getOWLInverseObjectPropertiesAxiom(v(firstProperty), v(secondProperty));
    }

    @Override
    public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLIrreflexiveObjectPropertyAxiom(v(property));
    }

    @Override
    public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        OWLDataPropertyExpression property = axiom.getProperty();
        OWLIndividual subject = axiom.getSubject();
        OWLLiteral object = axiom.getObject();
        return df.getOWLNegativeDataPropertyAssertionAxiom(v(property), v(subject), v(object));
    }

    @Override
    public OWLObject visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        OWLIndividual subject = axiom.getSubject();
        OWLIndividual object = axiom.getObject();
        OWLIndividual instantiatedSubject = v(subject);
        OWLObjectPropertyExpression instantiatedProperty = v(property);
        OWLIndividual instantiatedObject = v(object);
        return df.getOWLNegativeObjectPropertyAssertionAxiom(instantiatedProperty,
            instantiatedSubject, instantiatedObject);
    }

    @Override
    public OWLClassExpression visit(OWLObjectAllValuesFrom desc) {
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectAllValuesFrom(v(property), v(filler));
    }

    @Override
    public OWLClassExpression visit(OWLObjectComplementOf desc) {
        OWLClassExpression operand = desc.getOperand();
        return df.getOWLObjectComplementOf(v(operand));
    }

    @Override
    public OWLObject visit(OWLObjectExactCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectExactCardinality(cardinality, v(property), v(filler));
    }

    @Override
    public OWLClassExpression visit(OWLObjectIntersectionOf desc) {
        return df.getOWLObjectIntersectionOf(desc.operands().map(this::v));
    }

    @Override
    public OWLObject visit(OWLObjectMaxCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectMaxCardinality(cardinality, v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLObjectMinCardinality desc) {
        int cardinality = desc.getCardinality();
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectMinCardinality(cardinality, v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLObjectOneOf desc) {
        return df.getOWLObjectOneOf(desc.individuals().map(this::v));
    }

    @Override
    public OWLObject visit(OWLObjectProperty property) {
        OWLObjectProperty toReturn = property;
        if (getParameters().getConstraintSystem().isVariable(property)) {
            Variable<?> variable =
                getParameters().getConstraintSystem().getVariable(property.getIRI());
            OWLObjectProperty assignmentValue = (OWLObjectProperty) getParameters().getBindingNode()
                .getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? property : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
        OWLIndividual subject = axiom.getSubject();
        OWLObjectPropertyExpression property = axiom.getProperty();
        OWLIndividual object = axiom.getObject();
        return df.getOWLObjectPropertyAssertionAxiom(v(property), v(subject), v(object));
    }

    @Override
    public OWLObject visit(OWLSubPropertyChainOfAxiom axiom) {
        List<OWLObjectPropertyExpression> propertyChain = axiom.getPropertyChain();
        List<OWLObjectPropertyExpression> instantiatedPropertyChain = new ArrayList<>();
        OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
        for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
            instantiatedPropertyChain.add(v(objectPropertyExpression));
        }
        return df.getOWLSubPropertyChainOfAxiom(instantiatedPropertyChain, v(superProperty));
    }

    @Override
    public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
        OWLClassExpression domain = axiom.getDomain();
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLObjectPropertyDomainAxiom(v(property), v(domain));
    }

    @Override
    public OWLObject visit(OWLObjectInverseOf property) {
        OWLObjectPropertyExpression inverse = property.getInverse();
        if (inverse.isAnonymous()) {
            return inverse.getNamedProperty();
        }
        return df.getOWLObjectInverseOf(v(inverse).getNamedProperty());
    }

    @Override
    public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        OWLClassExpression range = axiom.getRange();
        return df.getOWLObjectPropertyRangeAxiom(v(property), v(range));
    }

    @Override
    public OWLObject visit(OWLObjectHasSelf desc) {
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectHasSelf(v(property));
    }

    @Override
    public OWLClassExpression visit(OWLObjectSomeValuesFrom desc) {
        OWLClassExpression filler = desc.getFiller();
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectSomeValuesFrom(v(property), v(filler));
    }

    @Override
    public OWLObject visit(OWLSubObjectPropertyOfAxiom axiom) {
        OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
        OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
        return df.getOWLSubObjectPropertyOfAxiom(v(subProperty), v(superProperty));
    }

    @Override
    public OWLClassExpression visit(OWLObjectUnionOf desc) {
        return df.getOWLObjectUnionOf(desc.operands().map(this::v));
    }

    @Override
    public OWLClassExpression visit(OWLObjectHasValue desc) {
        OWLObjectPropertyExpression property = desc.getProperty();
        return df.getOWLObjectHasValue(v(property), (OWLIndividual) desc.getFiller().accept(this));
    }

    @Override
    public OWLObject visit(OWLOntology ontology) {
        return ontology;
    }

    @Override
    public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLReflexiveObjectPropertyAxiom(v(property));
    }

    @Override
    public OWLObject visit(OWLSameIndividualAxiom axiom) {
        if (OPPLOWLSameIndividualAxiom.class.isAssignableFrom(axiom.getClass())) {
            InlineSet<OWLIndividual> inlineSet =
                ((OPPLOWLSameIndividualAxiom) axiom).getInlineSet();
            return df.getOWLSameIndividualAxiom(inlineSet.compute(getParameters()));
        }
        return df.getOWLSameIndividualAxiom(asList(axiom.individuals().map(this::v)));
    }

    @Override
    public OWLObject visit(OWLSubClassOfAxiom axiom) {
        OWLClassExpression superClass = (OWLClassExpression) axiom.getSuperClass().accept(this);
        OWLClassExpression subClass = (OWLClassExpression) axiom.getSubClass().accept(this);
        return df.getOWLSubClassOfAxiom(subClass, superClass);
    }

    @Override
    public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLSymmetricObjectPropertyAxiom(v(property));
    }

    @Override
    public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
        OWLObjectPropertyExpression property = axiom.getProperty();
        return df.getOWLTransitiveObjectPropertyAxiom(v(property));
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
        return df.getOWLAnnotation((OWLAnnotationProperty) annotation.getProperty().accept(this),
            (OWLAnnotationValue) annotation.getValue().accept(this));
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
                IRI value =
                    i.getAttribute().compute(AbstractOWLObjectInstantiator.this.getParameters());
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
            Variable<?> variable =
                getParameters().getConstraintSystem().getVariable(property.getIRI());
            OWLAnnotationProperty assignmentValue = (OWLAnnotationProperty) getParameters()
                .getBindingNode().getAssignmentValue(variable, getParameters());
            toReturn = assignmentValue == null ? property : assignmentValue;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLAnnotationAssertionAxiom axiom) {
        return df.getOWLAnnotationAssertionAxiom(
            (OWLAnnotationSubject) axiom.getSubject().accept(this),
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
