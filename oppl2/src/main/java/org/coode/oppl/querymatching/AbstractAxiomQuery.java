package org.coode.oppl.querymatching;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.*;

abstract class AbstractAxiomQuery implements AxiomQuery {

    private final RuntimeExceptionHandler runtimeExceptionHandler;

    protected abstract Set<BindingNode> match(OWLAxiom axiom);

    private final Set<BindingNode> leaves = new HashSet<>();

    /**
     * @param runtimeExceptionHandler
     *        runtimeExceptionHandler
     */
    AbstractAxiomQuery(RuntimeExceptionHandler runtimeExceptionHandler) {
        this.runtimeExceptionHandler = checkNotNull(runtimeExceptionHandler,
            "runtimeExceptionHandler");
    }

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
        return new HashSet<>(leaves);
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }
}
