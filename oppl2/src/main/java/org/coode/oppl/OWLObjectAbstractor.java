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

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
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
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
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

/**
 * Visitor that abstracts OWLObjects into variables.
 * 
 * @author Luigi Iannone
 */
public class OWLObjectAbstractor implements OWLObjectVisitorEx<OWLObject> {

    private final ValueComputationParameters parameters;
    private final Set<Variable<?>> variables = new HashSet<>();
    private final Set<BindingNode> bindingNodes = new HashSet<>();
    private final OWLDataFactory df;

    /**
     * @param variables variables
     * @param parameters parameters
     */
    public OWLObjectAbstractor(Collection<? extends Variable<?>> variables,
        ValueComputationParameters parameters) {
        this(variables, parameters, parameters.getConstraintSystem().getLeaves());
    }

    /**
     * @param variables variables
     * @param parameters parameters
     * @param bindingNodes bindingNodes
     */
    public OWLObjectAbstractor(Collection<? extends Variable<?>> variables,
        ValueComputationParameters parameters, Collection<? extends BindingNode> bindingNodes) {
        this.variables.addAll(checkNotNull(variables, "variables"));
        this.parameters = checkNotNull(parameters, "parameters");
        if (bindingNodes != null) {
            this.bindingNodes.addAll(bindingNodes);
        }
        df = parameters.getConstraintSystem().getOntologyManager().getOWLDataFactory();
    }

    @Override
    public <T> OWLObject doDefault(T object) {
        return (OWLObject) object;
    }

    private <T extends OWLObject> T abs(T property) {
        return (T) property.accept(this);
    }

    private <T extends OWLObject> Set<T> abs(Collection<T> c) {
        Set<T> values = new HashSet<>();
        for (T v : c) {
            values.add(abs(v));
        }
        return values;
    }

    private Variable<?> getAbstractingVariable(OWLObject owlObject) {
        boolean found = false;
        Iterator<? extends Variable<?>> it = variables.iterator();
        Variable<?> toReturn = null;
        Variable<?> aVariable = null;
        while (!found && it.hasNext()) {
            aVariable = it.next();
            Iterator<BindingNode> bindingNodesIterator = getBindingNodes().iterator();
            while (!found && bindingNodesIterator.hasNext()) {
                BindingNode bindingNode = bindingNodesIterator.next();
                found =
                    bindingNode.getAssignmentValue(aVariable, getParameters()).equals(owlObject);
            }
        }
        if (found) {
            toReturn = aVariable;
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        return df.getOWLAsymmetricObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLClassExpression visit(OWLClass desc) {
        OWLClassExpression toReturn = desc;
        Variable<?> v = getAbstractingVariable(desc);
        if (v != null) {
            toReturn = df.getOWLClass(v.getIRI());
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLClassAssertionAxiom axiom) {
        return df.getOWLClassAssertionAxiom(abs(axiom.getClassExpression()),
            abs(axiom.getIndividual()));
    }

    @Override
    public OWLObject visit(OWLDataAllValuesFrom desc) {
        return df.getOWLDataAllValuesFrom(abs(desc.getProperty()), abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLDataComplementOf node) {
        return df.getOWLDataComplementOf(abs(node.getDataRange()));
    }

    @Override
    public OWLObject visit(OWLDataExactCardinality desc) {
        int cardinality = desc.getCardinality();
        return df.getOWLDataExactCardinality(cardinality, abs(desc.getProperty()),
            abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLDataMaxCardinality desc) {
        int cardinality = desc.getCardinality();
        return df.getOWLDataMaxCardinality(cardinality, abs(desc.getProperty()),
            abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLDataMinCardinality desc) {
        int cardinality = desc.getCardinality();
        return df.getOWLDataMinCardinality(cardinality, abs(desc.getProperty()),
            abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLDataOneOf node) {
        return df.getOWLDataOneOf(abs(node.getValues()));
    }

    @Override
    public OWLObject visit(OWLDataProperty property) {
        OWLDataProperty toReturn = property;
        Variable<?> v = getAbstractingVariable(property);
        if (v != null) {
            toReturn = df.getOWLDataProperty(v.getIRI());
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
        return df.getOWLDataPropertyAssertionAxiom(abs(axiom.getProperty()),
            abs(axiom.getSubject()), abs(axiom.getObject()));
    }

    @Override
    public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
        return df.getOWLDataPropertyDomainAxiom(abs(axiom.getProperty()), abs(axiom.getDomain()));
    }

    @Override
    public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
        return df.getOWLDataPropertyRangeAxiom(abs(axiom.getProperty()), abs(axiom.getRange()));
    }

    @Override
    public OWLObject visit(OWLDatatypeRestriction node) {
        return df.getOWLDatatypeRestriction(abs(node.getDatatype()), node.getFacetRestrictions());
    }

    @Override
    public OWLObject visit(OWLDataSomeValuesFrom desc) {
        return df.getOWLDataSomeValuesFrom(abs(desc.getProperty()), abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLSubDataPropertyOfAxiom axiom) {
        return df.getOWLSubDataPropertyOfAxiom(abs(axiom.getSubProperty()),
            abs(axiom.getSuperProperty()));
    }

    @Override
    public OWLObject visit(OWLDatatype node) {
        return node;
    }

    @Override
    public OWLObject visit(OWLDataHasValue desc) {
        return df.getOWLDataHasValue(abs(desc.getProperty()), abs(desc.getValue()));
    }

    @Override
    public OWLObject visit(OWLDeclarationAxiom axiom) {
        return axiom;
    }

    @Override
    public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
        return df.getOWLDifferentIndividualsAxiom(abs(axiom.getIndividuals()));
    }

    @Override
    public OWLObject visit(OWLDisjointClassesAxiom axiom) {
        return df.getOWLDisjointClassesAxiom(abs(axiom.getClassExpressions()));
    }

    @Override
    public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
        return df.getOWLDisjointDataPropertiesAxiom(abs(axiom.getProperties()));
    }

    @Override
    public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
        return df.getOWLDisjointObjectPropertiesAxiom(abs(axiom.getProperties()));
    }

    @Override
    public OWLObject visit(OWLDisjointUnionAxiom axiom) {
        return df.getOWLDisjointUnionAxiom(abs(axiom.getOWLClass()),
            abs(axiom.getClassExpressions()));
    }

    @Override
    public OWLObject visit(OWLEquivalentClassesAxiom axiom) {
        return df.getOWLEquivalentClassesAxiom(abs(axiom.getClassExpressions()));
    }

    @Override
    public OWLObject visit(OWLEquivalentDataPropertiesAxiom axiom) {
        return df.getOWLEquivalentDataPropertiesAxiom(abs(axiom.getProperties()));
    }

    @Override
    public OWLObject visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        return df.getOWLEquivalentObjectPropertiesAxiom(abs(axiom.getProperties()));
    }

    @Override
    public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
        return df.getOWLFunctionalDataPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
        return df.getOWLFunctionalObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLNamedIndividual individual) {
        OWLIndividual toReturn = individual;
        Variable<?> v = getAbstractingVariable(individual);
        if (v != null) {
            toReturn = df.getOWLNamedIndividual(v.getIRI());
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        return df.getOWLInverseFunctionalObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
        return df.getOWLInverseObjectPropertiesAxiom(abs(axiom.getFirstProperty()),
            abs(axiom.getSecondProperty()));
    }

    @Override
    public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        return df.getOWLIrreflexiveObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        return df.getOWLNegativeDataPropertyAssertionAxiom(abs(axiom.getProperty()),
            abs(axiom.getSubject()), abs(axiom.getObject()));
    }

    @Override
    public OWLObject visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        return df.getOWLNegativeObjectPropertyAssertionAxiom(abs(axiom.getProperty()),
            abs(axiom.getSubject()), abs(axiom.getObject()));
    }

    @Override
    public OWLClassExpression visit(OWLObjectAllValuesFrom desc) {
        return df.getOWLObjectAllValuesFrom(abs(desc.getProperty()), abs(desc.getFiller()));
    }

    @Override
    public OWLClassExpression visit(OWLObjectComplementOf desc) {
        return df.getOWLObjectComplementOf(abs(desc.getOperand()));
    }

    @Override
    public OWLObject visit(OWLObjectExactCardinality desc) {
        int cardinality = desc.getCardinality();
        return df.getOWLObjectExactCardinality(cardinality, abs(desc.getProperty()),
            abs(desc.getFiller()));
    }

    @Override
    public OWLClassExpression visit(OWLObjectIntersectionOf desc) {
        return df.getOWLObjectIntersectionOf(abs(desc.getOperands()));
    }

    @Override
    public OWLObject visit(OWLObjectMaxCardinality desc) {
        int cardinality = desc.getCardinality();
        return df.getOWLObjectMaxCardinality(cardinality, abs(desc.getProperty()),
            abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLObjectMinCardinality desc) {
        int cardinality = desc.getCardinality();
        return df.getOWLObjectMinCardinality(cardinality, abs(desc.getProperty()),
            abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLObjectOneOf desc) {
        return df.getOWLObjectOneOf(abs(desc.getIndividuals()));
    }

    @Override
    public OWLObject visit(OWLObjectProperty property) {
        OWLObjectProperty toReturn = property;
        Variable<?> v = getAbstractingVariable(property);
        if (v != null) {
            toReturn = df.getOWLObjectProperty(v.getIRI());
        }
        return toReturn;
    }

    @Override
    public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
        return df.getOWLObjectPropertyAssertionAxiom(abs(axiom.getProperty()),
            abs(axiom.getSubject()), abs(axiom.getObject()));
    }

    @Override
    public OWLObject visit(OWLSubPropertyChainOfAxiom axiom) {
        List<OWLObjectPropertyExpression> propertyChain = axiom.getPropertyChain();
        List<OWLObjectPropertyExpression> values = new ArrayList<>();
        for (OWLObjectPropertyExpression v : propertyChain) {
            values.add(abs(v));
        }
        return df.getOWLSubPropertyChainOfAxiom(values, abs(axiom.getSuperProperty()));
    }

    @Override
    public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
        return df.getOWLObjectPropertyDomainAxiom(abs(axiom.getProperty()), abs(axiom.getDomain()));
    }

    @Override
    public OWLObject visit(OWLObjectInverseOf property) {
        return df.getOWLObjectInverseOf(abs(property.getInverse().asOWLObjectProperty()));
    }

    @Override
    public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
        return df.getOWLObjectPropertyRangeAxiom(abs(axiom.getProperty()), abs(axiom.getRange()));
    }

    @Override
    public OWLObject visit(OWLObjectHasSelf desc) {
        return df.getOWLObjectHasSelf(abs(desc.getProperty()));
    }

    @Override
    public OWLClassExpression visit(OWLObjectSomeValuesFrom desc) {
        return df.getOWLObjectSomeValuesFrom(abs(desc.getProperty()), abs(desc.getFiller()));
    }

    @Override
    public OWLObject visit(OWLSubObjectPropertyOfAxiom axiom) {
        return df.getOWLSubObjectPropertyOfAxiom(abs(axiom.getSubProperty()),
            abs(axiom.getSuperProperty()));
    }

    @Override
    public OWLClassExpression visit(OWLObjectUnionOf desc) {
        return df.getOWLObjectUnionOf(abs(desc.getOperands()));
    }

    @Override
    public OWLClassExpression visit(OWLObjectHasValue desc) {
        return df.getOWLObjectHasValue(abs(desc.getProperty()), abs(desc.getValue()));
    }

    @Override
    public OWLObject visit(OWLOntology ontology) {
        return ontology;
    }

    @Override
    public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
        return df.getOWLReflexiveObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLSameIndividualAxiom axiom) {
        return df.getOWLSameIndividualAxiom(abs(axiom.getIndividuals()));
    }

    @Override
    public OWLObject visit(OWLSubClassOfAxiom axiom) {
        return df.getOWLSubClassOfAxiom(abs(axiom.getSubClass()), abs(axiom.getSuperClass()));
    }

    @Override
    public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
        return df.getOWLSymmetricObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
        return df.getOWLTransitiveObjectPropertyAxiom(abs(axiom.getProperty()));
    }

    @Override
    public OWLObject visit(OWLLiteral node) {
        OWLLiteral toReturn = node;
        Variable<?> v = getAbstractingVariable(node);
        if (v != null) {
            toReturn = df.getOWLLiteral(v.getIRI().toString());
        }
        return toReturn;
    }

    /**
     * @return the bindingNodes
     */
    public Set<BindingNode> getBindingNodes() {
        return bindingNodes;
    }

    /**
     * @return the parameters
     */
    public ValueComputationParameters getParameters() {
        return parameters;
    }
}
