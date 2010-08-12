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

import java.io.StringWriter;

import org.coode.oppl.utils.ArgCheck;
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

/**
 * @author Luigi Iannone
 * 
 */
public class ManchesterSyntaxRenderer implements OWLObjectVisitor {
	private final OWLObjectVisitor delegate;
	private final StringWriter out = new StringWriter();

	/**
	 * Builds a renderer in Manchester OWL Syntax <b>non frame based</b>
	 * 
	 * @param shortFormProvider
	 *            The ShortFormProvide this rendere will use. Cannot be
	 *            {@code null}.
	 * @throws NullPointerException
	 *             if any of the inputs is {@code null}.
	 */
	public ManchesterSyntaxRenderer(ShortFormProvider shortFormProvider) {
		ArgCheck.checkNullArgument("The short form provider", shortFormProvider);
		this.delegate = new ManchesterOWLSyntaxObjectRenderer(this.out, shortFormProvider);
	}

	@Override
	public String toString() {
		return this.out.toString();
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLClassAtom)
	 */
	public void visit(SWRLClassAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLDataRangeAtom)
	 */
	public void visit(SWRLDataRangeAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLObjectPropertyAtom)
	 */
	public void visit(SWRLObjectPropertyAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLDataPropertyAtom)
	 */
	public void visit(SWRLDataPropertyAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLBuiltInAtom)
	 */
	public void visit(SWRLBuiltInAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLVariable)
	 */
	public void visit(SWRLVariable node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLIndividualArgument)
	 */
	public void visit(SWRLIndividualArgument node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLLiteralArgument)
	 */
	public void visit(SWRLLiteralArgument node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLSameIndividualAtom)
	 */
	public void visit(SWRLSameIndividualAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitor#visit(org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom)
	 */
	public void visit(SWRLDifferentIndividualsAtom node) {
		this.delegate.visit(node);
	}

	/**
	 * @param individual
	 * @see org.semanticweb.owlapi.model.OWLIndividualVisitor#visit(org.semanticweb.owlapi.model.OWLAnonymousIndividual)
	 */
	public void visit(OWLAnonymousIndividual individual) {
		this.delegate.visit(individual);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLAnnotationObjectVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotation)
	 */
	public void visit(OWLAnnotation node) {
		this.delegate.visit(node);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom)
	 */
	public void visit(OWLAnnotationAssertionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataVisitor#visit(org.semanticweb.owlapi.model.OWLLiteral)
	 */
	public void visit(OWLLiteral node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataRangeVisitor#visit(org.semanticweb.owlapi.model.OWLDatatype)
	 */
	public void visit(OWLDatatype node) {
		this.delegate.visit(node);
	}

	/**
	 * @param property
	 * @see org.semanticweb.owlapi.model.OWLPropertyExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectProperty)
	 */
	public void visit(OWLObjectProperty property) {
		this.delegate.visit(property);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom)
	 */
	public void visit(OWLSubAnnotationPropertyOfAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param iri
	 * @see org.semanticweb.owlapi.model.OWLAnnotationValueVisitor#visit(org.semanticweb.owlapi.model.IRI)
	 */
	public void visit(IRI iri) {
		this.delegate.visit(iri);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataVisitor#visit(org.semanticweb.owlapi.model.OWLFacetRestriction)
	 */
	public void visit(OWLFacetRestriction node) {
		this.delegate.visit(node);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataRangeVisitor#visit(org.semanticweb.owlapi.model.OWLDataOneOf)
	 */
	public void visit(OWLDataOneOf node) {
		this.delegate.visit(node);
	}

	/**
	 * @param property
	 * @see org.semanticweb.owlapi.model.OWLPropertyExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectInverseOf)
	 */
	public void visit(OWLObjectInverseOf property) {
		this.delegate.visit(property);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataRangeVisitor#visit(org.semanticweb.owlapi.model.OWLDataComplementOf)
	 */
	public void visit(OWLDataComplementOf node) {
		this.delegate.visit(node);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom)
	 */
	public void visit(OWLAnnotationPropertyDomainAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDeclarationAxiom)
	 */
	public void visit(OWLDeclarationAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param property
	 * @see org.semanticweb.owlapi.model.OWLPropertyExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataProperty)
	 */
	public void visit(OWLDataProperty property) {
		this.delegate.visit(property);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLClass)
	 */
	public void visit(OWLClass ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataRangeVisitor#visit(org.semanticweb.owlapi.model.OWLDataIntersectionOf)
	 */
	public void visit(OWLDataIntersectionOf node) {
		this.delegate.visit(node);
	}

	/**
	 * @param individual
	 * @see org.semanticweb.owlapi.model.OWLEntityVisitor#visit(org.semanticweb.owlapi.model.OWLNamedIndividual)
	 */
	public void visit(OWLNamedIndividual individual) {
		this.delegate.visit(individual);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom)
	 */
	public void visit(OWLAnnotationPropertyRangeAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ontology
	 * @see org.semanticweb.owlapi.model.OWLObjectVisitor#visit(org.semanticweb.owlapi.model.OWLOntology)
	 */
	public void visit(OWLOntology ontology) {
		this.delegate.visit(ontology);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubClassOfAxiom)
	 */
	public void visit(OWLSubClassOfAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectIntersectionOf)
	 */
	public void visit(OWLObjectIntersectionOf ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataRangeVisitor#visit(org.semanticweb.owlapi.model.OWLDataUnionOf)
	 */
	public void visit(OWLDataUnionOf node) {
		this.delegate.visit(node);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom)
	 */
	public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectUnionOf)
	 */
	public void visit(OWLObjectUnionOf ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param node
	 * @see org.semanticweb.owlapi.model.OWLDataRangeVisitor#visit(org.semanticweb.owlapi.model.OWLDatatypeRestriction)
	 */
	public void visit(OWLDatatypeRestriction node) {
		this.delegate.visit(node);
	}

	/**
	 * @param property
	 * @see org.semanticweb.owlapi.model.OWLEntityVisitor#visit(org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	public void visit(OWLAnnotationProperty property) {
		this.delegate.visit(property);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectComplementOf)
	 */
	public void visit(OWLObjectComplementOf ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom)
	 */
	public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom)
	 */
	public void visit(OWLObjectSomeValuesFrom ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom)
	 */
	public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectAllValuesFrom)
	 */
	public void visit(OWLObjectAllValuesFrom ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectHasValue)
	 */
	public void visit(OWLObjectHasValue ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointClassesAxiom)
	 */
	public void visit(OWLDisjointClassesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectMinCardinality)
	 */
	public void visit(OWLObjectMinCardinality ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom)
	 */
	public void visit(OWLDataPropertyDomainAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectExactCardinality)
	 */
	public void visit(OWLObjectExactCardinality ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom)
	 */
	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectMaxCardinality)
	 */
	public void visit(OWLObjectMaxCardinality ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom)
	 */
	public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectHasSelf)
	 */
	public void visit(OWLObjectHasSelf ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLObjectOneOf)
	 */
	public void visit(OWLObjectOneOf ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom)
	 */
	public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataSomeValuesFrom)
	 */
	public void visit(OWLDataSomeValuesFrom ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom)
	 */
	public void visit(OWLDifferentIndividualsAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataAllValuesFrom)
	 */
	public void visit(OWLDataAllValuesFrom ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataHasValue)
	 */
	public void visit(OWLDataHasValue ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom)
	 */
	public void visit(OWLDisjointDataPropertiesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataMinCardinality)
	 */
	public void visit(OWLDataMinCardinality ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom)
	 */
	public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataExactCardinality)
	 */
	public void visit(OWLDataExactCardinality ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom)
	 */
	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param ce
	 * @see org.semanticweb.owlapi.model.OWLClassExpressionVisitor#visit(org.semanticweb.owlapi.model.OWLDataMaxCardinality)
	 */
	public void visit(OWLDataMaxCardinality ce) {
		this.delegate.visit(ce);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom)
	 */
	public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom)
	 */
	public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom)
	 */
	public void visit(OWLSubObjectPropertyOfAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDisjointUnionAxiom)
	 */
	public void visit(OWLDisjointUnionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom)
	 */
	public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom)
	 */
	public void visit(OWLDataPropertyRangeAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom)
	 */
	public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom)
	 */
	public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLClassAssertionAxiom)
	 */
	public void visit(OWLClassAssertionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom)
	 */
	public void visit(OWLEquivalentClassesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom)
	 */
	public void visit(OWLDataPropertyAssertionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom)
	 */
	public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom)
	 */
	public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom)
	 */
	public void visit(OWLSubDataPropertyOfAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom)
	 */
	public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSameIndividualAxiom)
	 */
	public void visit(OWLSameIndividualAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom)
	 */
	public void visit(OWLSubPropertyChainOfAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom)
	 */
	public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLHasKeyAxiom)
	 */
	public void visit(OWLHasKeyAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param axiom
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom)
	 */
	public void visit(OWLDatatypeDefinitionAxiom axiom) {
		this.delegate.visit(axiom);
	}

	/**
	 * @param rule
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitor#visit(org.semanticweb.owlapi.model.SWRLRule)
	 */
	public void visit(SWRLRule rule) {
		this.delegate.visit(rule);
	}
}
