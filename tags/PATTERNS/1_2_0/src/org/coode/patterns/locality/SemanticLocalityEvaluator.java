package org.coode.patterns.locality;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomVisitor;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDescriptionVisitor;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLRuntimeException;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.util.OWLAxiomVisitorAdapter;

/**
 * <p/>
 * Title:
 * </p>
 * <p/>
 * Description:
 * </p>
 * <p/>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p/>
 * Company: Clark & Parsia, LLC. <http://www.clarkparsia.com>
 * </p>
 * 
 * @author Evren Sirin
 */
public final class SemanticLocalityEvaluator implements LocalityEvaluator {
	protected OWLDataFactory df;
	private AxiomLocalityVisitor axiomVisitor = new AxiomLocalityVisitor();
	private BottomReplacer bottomReplacer = new BottomReplacer();
	protected OWLReasoner reasoner;

	public SemanticLocalityEvaluator(OWLOntologyManager man,
			OWLReasoner reasoner) {
		this.df = man.getOWLDataFactory();
		this.reasoner = reasoner;
	}

	private class AxiomLocalityVisitor extends OWLAxiomVisitorAdapter implements
			OWLAxiomVisitor {
		private boolean isLocal;

		public AxiomLocalityVisitor() {
		}

		public boolean isLocal() {
			return this.isLocal;
		}

		public boolean isLocal(OWLAxiom axiom) {
			this.reset();
			axiom.accept(this);
			return this.isLocal();
		}

		public void reset() {
			this.isLocal = false;
		}

		@Override
		public void visit(OWLDisjointClassesAxiom axiom) {
			Set<OWLDescription> disjClasses = axiom.getDescriptions();
			OWLDescription conjunction = SemanticLocalityEvaluator.this.df
					.getOWLObjectIntersectionOf(disjClasses);
			try {
				this.isLocal = SemanticLocalityEvaluator.this.reasoner
						.isEquivalentClass(conjunction,
								SemanticLocalityEvaluator.this.df
										.getOWLNothing());
			} catch (OWLReasonerException e) {
				throw new OWLRuntimeException(e);
			}
		}

		@Override
		public void visit(OWLEquivalentClassesAxiom axiom) {
			Set<OWLDescription> eqClasses = axiom.getDescriptions();
			if (eqClasses.size() != 2)
				return;
			Iterator<OWLDescription> iter = eqClasses.iterator();
			OWLDescription first = iter.next();
			OWLDescription second = iter.next();
			try {
				this.isLocal = SemanticLocalityEvaluator.this.reasoner
						.isEquivalentClass(first, second);
			} catch (OWLReasonerException e) {
				throw new OWLRuntimeException(e);
			}
		}

		@Override
		public void visit(OWLSubClassAxiom axiom) {
			OWLDescription sup = axiom.getSuperClass();
			OWLDescription sub = axiom.getSubClass();
			try {
				this.isLocal = SemanticLocalityEvaluator.this.reasoner
						.isSubClassOf(sub, sup);
			} catch (OWLReasonerException e) {
				throw new OWLRuntimeException(e);
			}
		}
	}

	private class BottomReplacer extends OWLAxiomVisitorAdapter implements
			OWLAxiomVisitor, OWLDescriptionVisitor {
		BottomReplacer() {
		}

		private OWLAxiom newAxiom;
		private OWLDescription newDescription;
		private Set<? extends OWLEntity> signature;

		public OWLAxiom getResult() {
			return this.newAxiom;
		}

		public OWLAxiom replaceBottom(OWLAxiom axiom,
				Set<? extends OWLEntity> sig) {
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

		public Set<OWLDescription> replaceBottom(
				Set<OWLDescription> descriptions) {
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
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		public void visit(OWLDataAllRestriction desc) {
			if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLThing();
		}

		public void visit(OWLDataExactCardinalityRestriction desc) {
			if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		public void visit(OWLDataMaxCardinalityRestriction desc) {
			if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLThing();
		}

		public void visit(OWLDataMinCardinalityRestriction desc) {
			if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		public void visit(OWLDataSomeRestriction desc) {
			if (this.signature.contains(desc.getProperty().asOWLDataProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		@SuppressWarnings("unused")
		public void visit(OWLDataValueRestriction desc) {
			throw new RuntimeException();
		}

		@Override
		public void visit(OWLDisjointClassesAxiom ax) {
			Set<OWLDescription> disjointclasses = this.replaceBottom(ax
					.getDescriptions());
			this.newAxiom = SemanticLocalityEvaluator.this.df
					.getOWLDisjointClassesAxiom(disjointclasses);
		}

		@Override
		public void visit(OWLEquivalentClassesAxiom ax) {
			Set<OWLDescription> eqclasses = this.replaceBottom(ax
					.getDescriptions());
			this.newAxiom = SemanticLocalityEvaluator.this.df
					.getOWLEquivalentClassesAxiom(eqclasses);
		}

		public void visit(OWLObjectAllRestriction desc) {
			if (this.signature.contains(desc.getProperty().getNamedProperty()))
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLObjectAllRestriction(desc.getProperty(), this
								.replaceBottom(desc.getFiller()));
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLThing();
		}

		public void visit(OWLObjectComplementOf desc) {
			this.newDescription = SemanticLocalityEvaluator.this.df
					.getOWLObjectComplementOf(this.replaceBottom(desc
							.getOperand()));
		}

		public void visit(OWLObjectExactCardinalityRestriction desc) {
			if (this.signature.contains(desc.getProperty().getNamedProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		public void visit(OWLObjectIntersectionOf desc) {
			Set<OWLDescription> operands = desc.getOperands();
			this.newDescription = SemanticLocalityEvaluator.this.df
					.getOWLObjectIntersectionOf(this.replaceBottom(operands));
		}

		public void visit(OWLObjectMaxCardinalityRestriction desc) {
			if (this.signature.contains(desc.getProperty().getNamedProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLThing();
		}

		public void visit(OWLObjectMinCardinalityRestriction desc) {
			if (this.signature.contains(desc.getProperty().getNamedProperty()))
				this.newDescription = desc;
			else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		@SuppressWarnings("unused")
		public void visit(OWLObjectOneOf desc) {
			throw new RuntimeException();
		}

		@SuppressWarnings("unused")
		public void visit(OWLObjectSelfRestriction desc) {
			throw new RuntimeException();
		}

		public void visit(OWLObjectSomeRestriction desc) {
			if (this.signature.contains(desc.getProperty().getNamedProperty())) {
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLObjectSomeRestriction(desc.getProperty(), this
								.replaceBottom(desc.getFiller()));
			} else
				this.newDescription = SemanticLocalityEvaluator.this.df
						.getOWLNothing();
		}

		public void visit(OWLObjectUnionOf desc) {
			Set<OWLDescription> operands = desc.getOperands();
			this.newDescription = SemanticLocalityEvaluator.this.df
					.getOWLObjectUnionOf(this.replaceBottom(operands));
		}

		@SuppressWarnings("unused")
		public void visit(OWLObjectValueRestriction desc) {
			throw new RuntimeException();
		}

		@Override
		public void visit(OWLSubClassAxiom ax) {
			OWLDescription sup = this.replaceBottom(ax.getSuperClass());
			OWLDescription sub = this.replaceBottom(ax.getSubClass());
			this.newAxiom = SemanticLocalityEvaluator.this.df
					.getOWLSubClassAxiom(sub, sup);
		}
	}

	/**
	 * True if the axiom is semantically local w.r.t. given signature
	 */
	public boolean isLocal(OWLAxiom axiom, Set<? extends OWLEntity> signature) {
		// System.out.println("Replacing axiom by Bottom: " + axiom);
		// OWLAxiom newAxiom = this.bottomReplacer.replaceBottom(axiom,
		// signature);
		// System.out.println("Replaced  axiom          : " + newAxiom);
		// return newAxiom != null && this.axiomVisitor.isLocal(newAxiom);
		return this.axiomVisitor.isLocal(axiom);
	}
}
