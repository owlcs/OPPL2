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
package org.coode.oppl.rendering;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.io.StringWriter;

import org.semanticweb.owlapi.manchestersyntax.renderer.ManchesterOWLSyntaxObjectRenderer;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class ManchesterSyntaxRenderer implements OWLObjectVisitor {

    private final OWLObjectVisitor delegate;
    private final StringWriter out = new StringWriter();

    /**
     * Builds a renderer in Manchester OWL Syntax <b>non frame based</b>
     * 
     * @param shortFormProvider
     *        The ShortFormProvide this rendere will use. Cannot be {@code null}
     *        .
     * @throws NullPointerException
     *         if any of the inputs is {@code null}.
     */
    public ManchesterSyntaxRenderer(ShortFormProvider shortFormProvider) {
        delegate = new ManchesterOWLSyntaxObjectRenderer(out, checkNotNull(
            shortFormProvider, "shortFormProvider"));
    }

    @Override
    public String toString() {
        return out.toString();
    }

    @Override
    public void visit(SWRLClassAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLDataRangeAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLObjectPropertyAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLDataPropertyAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLBuiltInAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLVariable node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLIndividualArgument node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLLiteralArgument node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLSameIndividualAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(SWRLDifferentIndividualsAtom node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLAnonymousIndividual individual) {
        delegate.visit(individual);
    }

    @Override
    public void visit(OWLAnnotation node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLAnnotationAssertionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLLiteral node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLDatatype node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLObjectProperty property) {
        delegate.visit(property);
    }

    @Override
    public void visit(OWLSubAnnotationPropertyOfAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(IRI iri) {
        delegate.visit(iri);
    }

    @Override
    public void visit(OWLFacetRestriction node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLDataOneOf node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLObjectInverseOf property) {
        delegate.visit(property);
    }

    @Override
    public void visit(OWLDataComplementOf node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLAnnotationPropertyDomainAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDeclarationAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataProperty property) {
        delegate.visit(property);
    }

    @Override
    public void visit(OWLClass ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDataIntersectionOf node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLNamedIndividual individual) {
        delegate.visit(individual);
    }

    @Override
    public void visit(OWLAnnotationPropertyRangeAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLOntology ontology) {
        delegate.visit(ontology);
    }

    @Override
    public void visit(OWLSubClassOfAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectIntersectionOf ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDataUnionOf node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectUnionOf ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDatatypeRestriction node) {
        delegate.visit(node);
    }

    @Override
    public void visit(OWLAnnotationProperty property) {
        delegate.visit(property);
    }

    @Override
    public void visit(OWLObjectComplementOf ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectSomeValuesFrom ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectAllValuesFrom ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLObjectHasValue ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDisjointClassesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectMinCardinality ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDataPropertyDomainAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectExactCardinality ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLObjectPropertyDomainAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectMaxCardinality ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLObjectHasSelf ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLObjectOneOf ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataSomeValuesFrom ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDifferentIndividualsAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataAllValuesFrom ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDataHasValue ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDisjointDataPropertiesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataMinCardinality ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataExactCardinality ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLObjectPropertyRangeAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataMaxCardinality ce) {
        delegate.visit(ce);
    }

    @Override
    public void visit(OWLObjectPropertyAssertionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLSubObjectPropertyOfAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDisjointUnionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataPropertyRangeAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLFunctionalDataPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLClassAssertionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLEquivalentClassesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDataPropertyAssertionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLSubDataPropertyOfAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLSameIndividualAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLSubPropertyChainOfAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLInverseObjectPropertiesAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLHasKeyAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(OWLDatatypeDefinitionAxiom axiom) {
        delegate.visit(axiom);
    }

    @Override
    public void visit(SWRLRule rule) {
        delegate.visit(rule);
    }
}
