package org.coode.oppl.queryplanner;

import java.util.Collection;
import java.util.Set;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorAdapter;

/**
 * @author Luigi Iannone
 */
public class ConstantExtractor extends OWLObjectVisitorAdapter {

    private final Set<OWLLiteral> toReturn;

    /**
     * @param toReturn
     *        toReturn
     */
    public ConstantExtractor(Set<OWLLiteral> toReturn) {
        this.toReturn = toReturn;
    }

    protected void visitOWLQuantifiedRestriction(
        OWLQuantifiedRestriction<?> restriction) {
        if (restriction.getFiller() != null) {
            restriction.getFiller().accept(this);
        }
    }

    @Override
    public void visit(OWLDataMaxCardinality desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLDataExactCardinality desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLDataMinCardinality desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLDataAllValuesFrom desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLDataSomeValuesFrom desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLObjectOneOf desc) {}

    @Override
    public void visit(OWLObjectHasSelf desc) {}

    @Override
    public void visit(OWLObjectMaxCardinality desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLObjectExactCardinality desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLObjectMinCardinality desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLObjectHasValue desc) {}

    @Override
    public void visit(OWLObjectAllValuesFrom desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLDataHasValue desc) {
        toReturn.add(desc.getValue());
    }

    @Override
    public void visit(OWLObjectSomeValuesFrom desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLObjectComplementOf desc) {
        desc.getOperand().accept(this);
    }

    protected void visitOWLObjectCollection(Collection<? extends OWLObject> collection) {
        for (OWLObject owlObject : collection) {
            owlObject.accept(this);
        }
    }

    @Override
    public void visit(OWLObjectUnionOf desc) {
        visitOWLObjectCollection(desc.getOperands());
    }

    @Override
    public void visit(OWLObjectIntersectionOf desc) {
        visitOWLObjectCollection(desc.getOperands());
    }
}
