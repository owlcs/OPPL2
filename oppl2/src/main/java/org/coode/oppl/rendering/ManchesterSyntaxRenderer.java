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

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
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
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
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
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
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
import org.semanticweb.owlapi.util.ShortFormProvider;

import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxObjectRenderer;

/** @author Luigi Iannone */
public class ManchesterSyntaxRenderer implements OWLObjectVisitor {
    private final OWLObjectVisitor delegate;
    private final StringWriter out = new StringWriter();

    /** Builds a renderer in Manchester OWL Syntax <b>non frame based</b>
     * 
     * @param shortFormProvider
     *            The ShortFormProvide this rendere will use. Cannot be
     *            {@code null}.
     * @throws NullPointerException
     *             if any of the inputs is {@code null}. */
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
