package org.coode.oppl.queryplanner;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLQuantifiedRestriction;

/**
 * @author Luigi Iannone
 */
public class ConstantExtractor implements OWLObjectVisitor {

    private final Set<OWLLiteral> toReturn;

    /**
     * @param toReturn toReturn
     */
    public ConstantExtractor(Set<OWLLiteral> toReturn) {
        this.toReturn = toReturn;
    }

    protected void visitOWLQuantifiedRestriction(OWLQuantifiedRestriction<?> restriction) {
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
        toReturn.add(desc.getFiller());
    }

    @Override
    public void visit(OWLObjectSomeValuesFrom desc) {
        visitOWLQuantifiedRestriction(desc);
    }

    @Override
    public void visit(OWLObjectComplementOf desc) {
        desc.getOperand().accept(this);
    }


    @Override
    public void visit(OWLObjectUnionOf desc) {
        desc.operands().forEach(c -> c.accept(this));
    }

    @Override
    public void visit(OWLObjectIntersectionOf desc) {
        desc.operands().forEach(c -> c.accept(this));
    }
}
