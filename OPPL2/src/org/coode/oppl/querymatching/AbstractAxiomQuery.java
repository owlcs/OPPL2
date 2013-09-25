package org.coode.oppl.querymatching;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
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
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;

abstract class AbstractAxiomQuery implements AxiomQuery {
    private final RuntimeExceptionHandler runtimeExceptionHandler;

    /** @param runtimeExceptionHandler */
    AbstractAxiomQuery(RuntimeExceptionHandler runtimeExceptionHandler) {
        if (runtimeExceptionHandler == null) {
            throw new NullPointerException("The runtime exception handler cannot be null");
        }
        this.runtimeExceptionHandler = runtimeExceptionHandler;
    }

    protected abstract Set<BindingNode> match(OWLAxiom axiom);

    private final Set<BindingNode> leaves = new HashSet<BindingNode>();

    @Override
    public void visit(OWLDeclarationAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSubClassOfAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDisjointClassesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDataPropertyDomainAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLObjectPropertyDomainAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDifferentIndividualsAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDisjointDataPropertiesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLObjectPropertyRangeAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLObjectPropertyAssertionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSubObjectPropertyOfAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDisjointUnionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDataPropertyRangeAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLFunctionalDataPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLClassAssertionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLEquivalentClassesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLDataPropertyAssertionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSubDataPropertyOfAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSameIndividualAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSubPropertyChainOfAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLInverseObjectPropertiesAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLHasKeyAxiom axiom) {}

    @Override
    public void visit(OWLDatatypeDefinitionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(SWRLRule rule) {}

    @Override
    public void visit(OWLAnnotationAssertionAxiom axiom) {
        leaves.addAll(match(axiom));
    }

    @Override
    public void visit(OWLSubAnnotationPropertyOfAxiom axiom) {}

    @Override
    public void visit(OWLAnnotationPropertyDomainAxiom axiom) {}

    @Override
    public void visit(OWLAnnotationPropertyRangeAxiom axiom) {}

    @Override
    public Set<BindingNode> getLeaves() {
        return new HashSet<BindingNode>(leaves);
    }

    /** @return the runtimeExceptionHandler */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
