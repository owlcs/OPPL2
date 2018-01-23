package org.coode.oppl.utils;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLAxiomVisitor;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitor;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/**
 * @author Luigi Iannone
 */
public final class ConstantCollector implements OWLAxiomVisitor {

    private final Set<OWLLiteral> toReturn;
    private final OWLClassExpressionVisitor constantExtractor;

    /**
     * @param toReturn toReturn
     * @param constantExtractor constantExtractor
     */
    public ConstantCollector(Set<OWLLiteral> toReturn,
        OWLClassExpressionVisitor constantExtractor) {
        this.toReturn = toReturn;
        this.constantExtractor = constantExtractor;
    }

    @Override
    public void visit(OWLClassAssertionAxiom axiom) {
        axiom.getClassExpression().accept(constantExtractor);
    }

    @Override
    public void visit(OWLDataPropertyAssertionAxiom axiom) {
        toReturn.add(axiom.getObject());
    }

    @Override
    public void visit(OWLDisjointClassesAxiom axiom) {
        axiom.classExpressions().forEach(c -> c.accept(constantExtractor));
    }

    @Override
    public void visit(OWLEquivalentClassesAxiom axiom) {
        axiom.classExpressions().forEach(c -> c.accept(constantExtractor));
    }

    @Override
    public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        toReturn.add(axiom.getObject());
    }

    @Override
    public void visit(OWLSubClassOfAxiom axiom) {
        axiom.getSubClass().accept(constantExtractor);
        axiom.getSuperClass().accept(constantExtractor);
    }
}
