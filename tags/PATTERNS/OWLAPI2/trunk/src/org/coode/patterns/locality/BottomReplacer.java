package org.coode.patterns.locality;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiomVisitor;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyExpression;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDescriptionVisitor;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.util.OWLAxiomVisitorAdapter;

public class BottomReplacer implements OWLAxiomVisitor, OWLDescriptionVisitor {
	/**
	 * 
	 */
	private final OWLDataFactory df;
	private final OWLClass nothing;
	private final OWLClass thing;

	BottomReplacer(OWLDataFactory df) {
		this.df = df;
		nothing = df.getOWLNothing();
		thing = df.getOWLThing();
	}

	private OWLAxiom newAxiom;
	private OWLDescription newDescription;
	private Set<? extends OWLEntity> signature;

	public OWLAxiom getResult() {
		return this.newAxiom;
	}

	public OWLAxiom replaceBottom(OWLAxiom axiom, Set<? extends OWLEntity> sig) {
		this.reset(sig);
		axiom.accept(this);
		return this.getResult();
	}

	// Takes an OWLDescription and a signature replaces by bottom the
	// entities not in the signature
	public OWLDescription replaceBottom(OWLDescription desc) {
		this.newDescription = null;
		desc.accept(this);
		if (this.newDescription == null)
			throw new RuntimeException("Unsupported description " + desc);
		return this.newDescription;
	}

	public Set<OWLDescription> replaceBottom(Set<OWLDescription> descriptions) {
		Set<OWLDescription> result = new HashSet<OWLDescription>();
		for (OWLDescription desc : descriptions) {
			result.add(this.replaceBottom(desc));
		}
		return result;
	}

	public void reset(Set<? extends OWLEntity> sig) {
		this.signature = sig;
		this.newAxiom = null;
	}

	public void visit(OWLClass desc) {
		if (this.signature.contains(desc))
			this.newDescription = desc;
		else
			this.newDescription = nothing;
	}

	public void visit(OWLDataAllRestriction desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
			this.newDescription = desc;
		else
			this.newDescription = thing;
	}

	public void visit(OWLDataExactCardinalityRestriction desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
			this.newDescription = desc;
		else
			this.newDescription = nothing;
	}

	public void visit(OWLDataMaxCardinalityRestriction desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
			this.newDescription = desc;
		else
			this.newDescription = thing;
	}

	public void visit(OWLDataMinCardinalityRestriction desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
			this.newDescription = desc;
		else
			this.newDescription = nothing;
	}

	public void visit(OWLDataSomeRestriction desc) {
		if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
			this.newDescription = desc;
		else
			this.newDescription = nothing;
	}

	public void visit(OWLDataValueRestriction desc) {
		newDescription = desc;
	}

	public void visit(OWLDisjointClassesAxiom ax) {
		Set<OWLDescription> disjointclasses = this.replaceBottom(ax
				.getDescriptions());
		this.newAxiom = this.df.getOWLDisjointClassesAxiom(disjointclasses);
	}

	public void visit(OWLEquivalentClassesAxiom ax) {
		Set<OWLDescription> eqclasses = this
				.replaceBottom(ax.getDescriptions());
		this.newAxiom = this.df.getOWLEquivalentClassesAxiom(eqclasses);
	}

	public void visit(OWLObjectAllRestriction desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty()))
			this.newDescription = this.df.getOWLObjectAllRestriction(
					desc.getProperty(), this.replaceBottom(desc.getFiller()));
		else
			this.newDescription = thing;
	}

	public void visit(OWLObjectComplementOf desc) {
		this.newDescription = this.df.getOWLObjectComplementOf(this
				.replaceBottom(desc.getOperand()));
	}

	public void visit(OWLObjectExactCardinalityRestriction desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty()))
			this.newDescription = desc;
		else
			this.newDescription = nothing;
	}

	public void visit(OWLObjectIntersectionOf desc) {
		Set<OWLDescription> operands = desc.getOperands();
		this.newDescription = this.df.getOWLObjectIntersectionOf(this
				.replaceBottom(operands));
	}

	public void visit(OWLObjectMaxCardinalityRestriction desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty()))
			this.newDescription = desc;
		else
			this.newDescription = thing;
	}

	public void visit(OWLObjectMinCardinalityRestriction desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty()))
			this.newDescription = desc;
		else
			this.newDescription = nothing;
	}

	public void visit(OWLObjectOneOf desc) {
		newDescription = desc;
	}

	public void visit(OWLObjectSelfRestriction desc) {
		newDescription = desc;
	}

	public void visit(OWLObjectSomeRestriction desc) {
		if (this.signature.contains(desc.getProperty().getNamedProperty())) {
			this.newDescription = this.df.getOWLObjectSomeRestriction(
					desc.getProperty(), this.replaceBottom(desc.getFiller()));
		} else
			this.newDescription = nothing;
	}

	public void visit(OWLObjectUnionOf desc) {
		Set<OWLDescription> operands = desc.getOperands();
		this.newDescription = this.df.getOWLObjectUnionOf(this
				.replaceBottom(operands));
	}

	public void visit(OWLObjectValueRestriction desc) {
		newDescription = desc;
	}

	public void visit(OWLSubClassAxiom ax) {
		OWLDescription sup = this.replaceBottom(ax.getSuperClass());
		OWLDescription sub = this.replaceBottom(ax.getSubClass());
		this.newAxiom = this.df.getOWLSubClassAxiom(sub, sup);
	}

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

	public void visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDataPropertyDomainAxiom axiom) {
		newAxiom = df.getOWLDataPropertyDomainAxiom(axiom.getProperty(),
				this.replaceBottom(axiom.getDomain()));
	}

	public void visit(OWLImportsDeclaration axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLAxiomAnnotationAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		newAxiom = df.getOWLObjectPropertyDomainAxiom(axiom.getProperty(),
				this.replaceBottom(axiom.getDomain()));
	}

	public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDifferentIndividualsAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDisjointDataPropertiesAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		newAxiom = df.getOWLObjectPropertyRangeAxiom(axiom.getProperty(),
				replaceBottom(axiom.getRange()));
	}

	public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLObjectSubPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDisjointUnionAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDeclarationAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLEntityAnnotationAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLOntologyAnnotationAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDataPropertyRangeAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLClassAssertionAxiom axiom) {
		nullIfOutside(axiom);
//		newAxiom=df.getOWLClassAssertionAxiom(axiom.getIndividual(), replaceBottom(axiom.getDescription()));
	}

	public void visit(OWLDataPropertyAssertionAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLDataSubPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLSameIndividualsAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		nullIfOutside(axiom);
	}

	public void visit(SWRLRule rule) {

	}
}