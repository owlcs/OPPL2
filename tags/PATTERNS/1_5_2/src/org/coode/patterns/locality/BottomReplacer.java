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

public class BottomReplacer extends OWLAxiomVisitorAdapter implements OWLAxiomVisitor,
		OWLClassExpressionVisitor {
	/**
	 * 
	 */
	private final OWLDataFactory df;
	private final OWLClass nothing;
	private final OWLClass thing;

	BottomReplacer(OWLDataFactory df) {
		this.df = df;
		this.nothing = df.getOWLNothing();
		this.thing = df.getOWLThing();
	}

	private OWLAxiom newAxiom;
	private OWLClassExpression newDescription;
	private Set<? extends OWLEntity> signature;

	public OWLAxiom getResult() {
		return this.newAxiom;
	}

	public OWLAxiom replaceBottom(OWLAxiom axiom, Set<? extends OWLEntity> sig) {
		this.reset(sig);
		axiom.accept(this);
		return this.getResult();
	}

	// Takes an OWLClassExpression and a signature replaces by bottom the
	// entities not in the signature
	public OWLClassExpression replaceBottom(OWLClassExpression desc) {
		this.newDescription = null;
		desc.accept(this);
		if (this.newDescription == null) {
			throw new RuntimeException("Unsupported description " + desc);
		}
		return this.newDescription;
	}

	public Set<OWLClassExpression> replaceBottom(Set<OWLClassExpression> descriptions) {
		Set<OWLClassExpression> result = new HashSet<OWLClassExpression>();
		for (OWLClassExpression desc : descriptions) {
			result.add(this.replaceBottom(desc));
		}
		return result;
	}

	public void reset(Set<? extends OWLEntity> sig) {
		this.signature = sig;
		this.newAxiom = null;
	}

	public void visit(OWLClass desc) {
		if (this.signature.contains(desc)) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLDataAllValuesFrom desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.thing;
		}
	}

	public void visit(OWLDataExactCardinality desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLDataMaxCardinality desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.thing;
		}
	}

	public void visit(OWLDataMinCardinality desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLDataSomeValuesFrom desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLDataHasValue desc) {
		this.newDescription = desc;
	}

	@Override
	public void visit(OWLDisjointClassesAxiom ax) {
		Set<OWLClassExpression> disjointclasses = this.replaceBottom(ax.getClassExpressions());
		this.newAxiom = this.df.getOWLDisjointClassesAxiom(disjointclasses);
	}

	@Override
	public void visit(OWLEquivalentClassesAxiom ax) {
		Set<OWLClassExpression> eqclasses = this.replaceBottom(ax.getClassExpressions());
		this.newAxiom = this.df.getOWLEquivalentClassesAxiom(eqclasses);
	}

	public void visit(OWLObjectAllValuesFrom desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty())) {
			this.newDescription = this.df.getOWLObjectAllValuesFrom(
					desc.getProperty(),
					this.replaceBottom(desc.getFiller()));
		} else {
			this.newDescription = this.thing;
		}
	}

	public void visit(OWLObjectComplementOf desc) {
		this.newDescription = this.df.getOWLObjectComplementOf(this.replaceBottom(desc.getOperand()));
	}

	public void visit(OWLObjectExactCardinality desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLObjectIntersectionOf desc) {
		Set<OWLClassExpression> operands = desc.getOperands();
		this.newDescription = this.df.getOWLObjectIntersectionOf(this.replaceBottom(operands));
	}

	public void visit(OWLObjectMaxCardinality desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.thing;
		}
	}

	public void visit(OWLObjectMinCardinality desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty())) {
			this.newDescription = desc;
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLObjectOneOf desc) {
		this.newDescription = desc;
	}

	public void visit(OWLObjectHasSelf desc) {
		this.newDescription = desc;
	}

	public void visit(OWLObjectSomeValuesFrom desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty())) {
			this.newDescription = this.df.getOWLObjectSomeValuesFrom(
					desc.getProperty(),
					this.replaceBottom(desc.getFiller()));
		} else {
			this.newDescription = this.nothing;
		}
	}

	public void visit(OWLObjectUnionOf desc) {
		Set<OWLClassExpression> operands = desc.getOperands();
		this.newDescription = this.df.getOWLObjectUnionOf(this.replaceBottom(operands));
	}

	public void visit(OWLObjectHasValue desc) {
		this.newDescription = desc;
	}

	@Override
	public void visit(OWLSubClassOfAxiom ax) {
		OWLClassExpression sup = this.replaceBottom(ax.getSuperClass());
		OWLClassExpression sub = this.replaceBottom(ax.getSubClass());
		this.newAxiom = this.df.getOWLSubClassOfAxiom(sub, sup);
	}

	@Override
	public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	private void nullIfOutside(OWLAxiom axiom) {
		for (OWLEntity e : axiom.getSignature()) {
			if (!this.signature.contains(e)) {
				return;
			}
		}
		this.newAxiom = axiom;
	}

	@Override
	public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDataPropertyDomainAxiom axiom) {
		this.newAxiom = this.df.getOWLDataPropertyDomainAxiom(
				axiom.getProperty(),
				this.replaceBottom(axiom.getDomain()));
	}

	@Override
	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		this.newAxiom = this.df.getOWLObjectPropertyDomainAxiom(
				axiom.getProperty(),
				this.replaceBottom(axiom.getDomain()));
	}

	@Override
	public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDifferentIndividualsAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDisjointDataPropertiesAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		this.newAxiom = this.df.getOWLObjectPropertyRangeAxiom(
				axiom.getProperty(),
				this.replaceBottom(axiom.getRange()));
	}

	@Override
	public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLSubObjectPropertyOfAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDisjointUnionAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDeclarationAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDataPropertyRangeAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLClassAssertionAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLDataPropertyAssertionAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLSubDataPropertyOfAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLSameIndividualAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLSubPropertyChainOfAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		this.nullIfOutside(axiom);
	}

	@Override
	public void visit(SWRLRule rule) {
	}
}