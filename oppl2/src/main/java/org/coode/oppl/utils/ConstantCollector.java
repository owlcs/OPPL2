package org.coode.oppl.utils;

import java.util.Set;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;

/**
 * @author Luigi Iannone
 */
public final class ConstantCollector extends OWLAxiomVisitorAdapter {

    private final Set<OWLLiteral> toReturn;
    private final OWLClassExpressionVisitor constantExtractor;

    /**
     * @param toReturn
     *        toReturn
     * @param constantExtractor
     *        constantExtractor
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
        for (OWLClassExpression description : axiom.getClassExpressions()) {
            description.accept(constantExtractor);
        }
    }

    @Override
    public void visit(OWLEquivalentClassesAxiom axiom) {
        for (OWLClassExpression description : axiom.getClassExpressions()) {
            description.accept(constantExtractor);
        }
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
