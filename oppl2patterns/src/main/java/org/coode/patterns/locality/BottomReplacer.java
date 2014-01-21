package org.coode.patterns.locality;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitor;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitor;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.util.OWLAxiomVisitorAdapter;

/** @author Luigi Iannone */
public class BottomReplacer extends OWLAxiomVisitorAdapter implements OWLAxiomVisitor,
        OWLClassExpressionVisitor {
    private final OWLDataFactory df;
    private final OWLClass nothing;
    private final OWLClass thing;

    BottomReplacer(OWLDataFactory df) {
        this.df = df;
        nothing = df.getOWLNothing();
        thing = df.getOWLThing();
    }

    private OWLAxiom newAxiom;
    private OWLClassExpression newDescription;
    private Set<? extends OWLEntity> signature;

    /** @return new axiom */
    public OWLAxiom getResult() {
        return newAxiom;
    }

    /** @param axiom
     *            axiom
     * @param sig
     *            sig
     * @return axiom with bottom replaced */
    public OWLAxiom replaceBottom(OWLAxiom axiom, Set<? extends OWLEntity> sig) {
        reset(sig);
        axiom.accept(this);
        return getResult();
    }

    // Takes an OWLClassExpression and a signature replaces by bottom the
    // entities not in the signature
    /** @param desc
     *            desc
     * @return class expression with bottom replaced */
    public OWLClassExpression replaceBottom(OWLClassExpression desc) {
        newDescription = null;
        desc.accept(this);
        if (newDescription == null) {
            throw new RuntimeException("Unsupported description " + desc);
        }
        return newDescription;
    }

    /** @param descriptions
     *            descriptions
     * @return class expressions with bottom replaced */
    public Set<OWLClassExpression> replaceBottom(Set<OWLClassExpression> descriptions) {
        Set<OWLClassExpression> result = new HashSet<OWLClassExpression>();
        for (OWLClassExpression desc : descriptions) {
            result.add(this.replaceBottom(desc));
        }
        return result;
    }

    /** @param sig
     *            sig */
    public void reset(Set<? extends OWLEntity> sig) {
        signature = sig;
        newAxiom = null;
    }

    @Override
    public void visit(OWLClass desc) {
        if (signature.contains(desc)) {
            newDescription = desc;
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLDataAllValuesFrom desc) {
        if (signature.contains(desc.getProperty().asOWLDataProperty())) {
            newDescription = desc;
        } else {
            newDescription = thing;
        }
    }

    @Override
    public void visit(OWLDataExactCardinality desc) {
        if (signature.contains(desc.getProperty().asOWLDataProperty())) {
            newDescription = desc;
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLDataMaxCardinality desc) {
        if (signature.contains(desc.getProperty().asOWLDataProperty())) {
            newDescription = desc;
        } else {
            newDescription = thing;
        }
    }

    @Override
    public void visit(OWLDataMinCardinality desc) {
        if (signature.contains(desc.getProperty().asOWLDataProperty())) {
            newDescription = desc;
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLDataSomeValuesFrom desc) {
        if (signature.contains(desc.getProperty().asOWLDataProperty())) {
            newDescription = desc;
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLDataHasValue desc) {
        newDescription = desc;
    }

    @Override
    public void visit(OWLDisjointClassesAxiom ax) {
        Set<OWLClassExpression> disjointclasses = this.replaceBottom(ax
                .getClassExpressions());
        newAxiom = df.getOWLDisjointClassesAxiom(disjointclasses);
    }

    @Override
    public void visit(OWLEquivalentClassesAxiom ax) {
        Set<OWLClassExpression> eqclasses = this.replaceBottom(ax.getClassExpressions());
        newAxiom = df.getOWLEquivalentClassesAxiom(eqclasses);
    }

    @Override
    public void visit(OWLObjectAllValuesFrom desc) {
        if (signature.contains(desc.getProperty().getNamedProperty())) {
            newDescription = df.getOWLObjectAllValuesFrom(desc.getProperty(),
                    this.replaceBottom(desc.getFiller()));
        } else {
            newDescription = thing;
        }
    }

    @Override
    public void visit(OWLObjectComplementOf desc) {
        newDescription = df
                .getOWLObjectComplementOf(this.replaceBottom(desc.getOperand()));
    }

    @Override
    public void visit(OWLObjectExactCardinality desc) {
        if (signature.contains(desc.getProperty().getNamedProperty())) {
            newDescription = desc;
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLObjectIntersectionOf desc) {
        Set<OWLClassExpression> operands = desc.getOperands();
        newDescription = df.getOWLObjectIntersectionOf(this.replaceBottom(operands));
    }

    @Override
    public void visit(OWLObjectMaxCardinality desc) {
        if (signature.contains(desc.getProperty().getNamedProperty())) {
            newDescription = desc;
        } else {
            newDescription = thing;
        }
    }

    @Override
    public void visit(OWLObjectMinCardinality desc) {
        if (signature.contains(desc.getProperty().getNamedProperty())) {
            newDescription = desc;
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLObjectOneOf desc) {
        newDescription = desc;
    }

    @Override
    public void visit(OWLObjectHasSelf desc) {
        newDescription = desc;
    }

    @Override
    public void visit(OWLObjectSomeValuesFrom desc) {
        if (signature.contains(desc.getProperty().getNamedProperty())) {
            newDescription = df.getOWLObjectSomeValuesFrom(desc.getProperty(),
                    this.replaceBottom(desc.getFiller()));
        } else {
            newDescription = nothing;
        }
    }

    @Override
    public void visit(OWLObjectUnionOf desc) {
        Set<OWLClassExpression> operands = desc.getOperands();
        newDescription = df.getOWLObjectUnionOf(this.replaceBottom(operands));
    }

    @Override
    public void visit(OWLObjectHasValue desc) {
        newDescription = desc;
    }

    @Override
    public void visit(OWLSubClassOfAxiom ax) {
        OWLClassExpression sup = this.replaceBottom(ax.getSuperClass());
        OWLClassExpression sub = this.replaceBottom(ax.getSubClass());
        newAxiom = df.getOWLSubClassOfAxiom(sub, sup);
    }

    @Override
    public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        nullIfOutside(axiom);
    }

    private void nullIfOutside(OWLAxiom axiom) {
        for (OWLEntity e : axiom.getSignature()) {
            if (!signature.contains(e)) {
                return;
            }
        }
        newAxiom = axiom;
    }

    @Override
    public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDataPropertyDomainAxiom axiom) {
        newAxiom = df.getOWLDataPropertyDomainAxiom(axiom.getProperty(),
                this.replaceBottom(axiom.getDomain()));
    }

    @Override
    public void visit(OWLObjectPropertyDomainAxiom axiom) {
        newAxiom = df.getOWLObjectPropertyDomainAxiom(axiom.getProperty(),
                this.replaceBottom(axiom.getDomain()));
    }

    @Override
    public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDifferentIndividualsAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDisjointDataPropertiesAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLObjectPropertyRangeAxiom axiom) {
        newAxiom = df.getOWLObjectPropertyRangeAxiom(axiom.getProperty(),
                this.replaceBottom(axiom.getRange()));
    }

    @Override
    public void visit(OWLObjectPropertyAssertionAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLSubObjectPropertyOfAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDisjointUnionAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDeclarationAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDataPropertyRangeAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLFunctionalDataPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLClassAssertionAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLDataPropertyAssertionAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLSubDataPropertyOfAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLSameIndividualAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLSubPropertyChainOfAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(OWLInverseObjectPropertiesAxiom axiom) {
        nullIfOutside(axiom);
    }

    @Override
    public void visit(SWRLRule rule) {}
}
