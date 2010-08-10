package org.coode.patterns.locality;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.antlr.grammar.v3.ANTLRv3Parser.throwsSpec_return;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.*;
import org.semanticweb.owl.vocab.OWLRDFVocabulary;

public class AxiomLocalityVisitor implements OWLAxiomVisitor {
	/**
	 * 
	 */
	private boolean isLocal;
	private OWLReasoner reasoner;
	private OWLDataFactory df;

	public AxiomLocalityVisitor(OWLReasoner r, OWLDataFactory df) {
		this.reasoner = r;
		this.df = df;
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

	public void visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLDescription> disjClasses = axiom.getDescriptions();
		OWLDescription conjunction = this.df
				.getOWLObjectIntersectionOf(disjClasses);
		checkInconsistent(conjunction);
	}

	private void checkInconsistent(OWLDescription conjunction) {
		try {
			this.isLocal = this.reasoner.isEquivalentClass(conjunction,
					this.df.getOWLNothing());
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLDescription> eqClasses = axiom.getDescriptions();
		isLocal = true;
		try {
			for (OWLDescription d : eqClasses) {
				if (!reasoner.getEquivalentClasses(d).containsAll(eqClasses)) {
					isLocal = false;
					return;
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLSubClassAxiom axiom) {
		try {
			this.isLocal = this.reasoner.isSubClassOf(axiom.getSubClass(),
					axiom.getSuperClass());
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		try {
			isLocal = reasoner.getObjectPropertyRelationships(
					axiom.getSubject()).containsKey(axiom.getProperty());
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isAntiSymmetric(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isReflexive(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDataPropertyDomainAxiom axiom) {
		isLocal = false;
		try {
			if (!axiom.getProperty().isAnonymous()) {
				Set<Set<OWLDescription>> set = reasoner
						.getDomains((OWLDataProperty) axiom.getProperty());
				for (Set<OWLDescription> s : set) {
					for (OWLDescription d : s) {
						if (reasoner.isSubClassOf(axiom.getDomain(), d)) {
							isLocal = true;
							return;
						}
					}
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	public void visit(OWLImportsDeclaration axiom) {
		isLocal = true;
	}

	@SuppressWarnings("unused")
	public void visit(OWLAxiomAnnotationAxiom axiom) {
		isLocal = true;
	}

	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		isLocal = false;
		try {
			if (!axiom.getProperty().isAnonymous()) {
				Set<Set<OWLDescription>> set = reasoner
						.getDomains((OWLObjectProperty) axiom.getProperty());
				for (Set<OWLDescription> s : set) {
					for (OWLDescription d : s) {
						if (reasoner.isSubClassOf(axiom.getDomain(), d)) {
							isLocal = true;
							return;
						}
					}
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		isLocal = true;
		Set<OWLObjectPropertyExpression> set = axiom.getProperties();
		for (OWLObjectPropertyExpression o1 : set) {
			for (OWLObjectPropertyExpression o2 : set) {
				if (o1 != o2 && !o1.isAnonymous()) {
					try {
						if (!reasoner.getEquivalentProperties(
								(OWLObjectProperty) o1).contains(o2)) {
							isLocal = false;
							return;
						}
					} catch (OWLReasonerException e) {
						throw new OWLRuntimeException(e);
					}
				}
			}
		}
	}

	public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		try {
			isLocal = !reasoner
					.getDataPropertyRelationships(axiom.getSubject())
					.containsKey(axiom.getProperty());
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDifferentIndividualsAxiom axiom) {
		isLocal = true;
		try {
			for (OWLIndividual i : axiom.getIndividuals()) {
				if (!reasoner
						.getObjectPropertyRelationships(i)
						.get(df.getOWLObjectProperty(OWLRDFVocabulary.OWL_DIFFERENT_FROM
								.getURI())).containsAll(axiom.getIndividuals())) {
					isLocal = false;
					return;
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDisjointDataPropertiesAxiom axiom) {
		// TODO Auto-generated method stub
	}

	public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		// TODO Auto-generated method stub
	}

	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		isLocal = false;
		try {
			if (!axiom.getProperty().isAnonymous()) {
				Set<OWLDescription> set = reasoner
						.getRanges((OWLObjectProperty) axiom.getProperty());
				for (OWLDescription d : set) {
					if (reasoner.isSubClassOf(axiom.getRange(), d)) {
						isLocal = true;
						return;
					}
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		try {
			isLocal = reasoner
					.getObjectPropertyRelationships(axiom.getSubject())
					.get(axiom.getProperty()).contains(axiom.getObject());
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isFunctional(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLObjectSubPropertyAxiom axiom) {
		try {
			if (!axiom.getSuperProperty().isAnonymous()) {
				isLocal = reasoner.getSubProperties(
						axiom.getSuperProperty().asOWLObjectProperty())
						.contains(axiom.getSubProperty());
			} else {
				if (!axiom.getSubProperty().isAnonymous()) {
					isLocal = reasoner.getSuperProperties(
							axiom.getSubProperty().asOWLObjectProperty())
							.contains(axiom.getSuperProperty());
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDisjointUnionAxiom axiom) {
		// TODO Auto-generated method stub
	}

	public void visit(OWLDeclarationAxiom axiom) {
		try {
			if (axiom.getEntity() instanceof OWLClass) {
				isLocal = reasoner.isDefined((OWLClass) axiom.getEntity());
			}
			if (axiom.getEntity() instanceof OWLDataProperty) {
				isLocal = reasoner.isDefined((OWLDataProperty) axiom
						.getEntity());
			}
			if (axiom.getEntity() instanceof OWLIndividual) {
				isLocal = reasoner.isDefined((OWLIndividual) axiom.getEntity());
			}
			if (axiom.getEntity() instanceof OWLObjectProperty) {
				isLocal = reasoner.isDefined((OWLObjectProperty) axiom
						.getEntity());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	public void visit(OWLEntityAnnotationAxiom axiom) {
		isLocal = true;
	}

	@SuppressWarnings("unused")
	public void visit(OWLOntologyAnnotationAxiom axiom) {
		isLocal = true;
	}

	public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isSymmetric(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDataPropertyRangeAxiom axiom) {
		isLocal = false;
		try {
			if (!axiom.getProperty().isAnonymous()) {
				Set<OWLDataRange> set = reasoner
						.getRanges((OWLDataProperty) axiom.getProperty());
				isLocal = set.contains(axiom.getRange());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isFunctional(axiom.getProperty()
						.asOWLDataProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
		isLocal = true;
		Set<OWLDataPropertyExpression> set = axiom.getProperties();
		for (OWLDataPropertyExpression o1 : set) {
			for (OWLDataPropertyExpression o2 : set) {
				if (o1 != o2 && !o1.isAnonymous()) {
					try {
						if (!reasoner.getEquivalentProperties(
								(OWLDataProperty) o1).contains(o2)) {
							isLocal = false;
							return;
						}
					} catch (OWLReasonerException e) {
						throw new OWLRuntimeException(e);
					}
				}
			}
		}
	}

	public void visit(OWLClassAssertionAxiom axiom) {
		try {
			isLocal = reasoner.hasType(axiom.getIndividual(),
					axiom.getDescription(), false);
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDataPropertyAssertionAxiom axiom) {
		try {
			isLocal = reasoner.getDataPropertyRelationships(axiom.getSubject())
					.get(axiom.getProperty()).contains(axiom.getObject());
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isTransitive(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isIrreflexive(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLDataSubPropertyAxiom axiom) {
		try {
			if (!axiom.getSuperProperty().isAnonymous()) {
				isLocal = reasoner.getSubProperties(
						axiom.getSuperProperty().asOWLDataProperty()).contains(
						axiom.getSubProperty());
			} else {
				if (!axiom.getSubProperty().isAnonymous()) {
					isLocal = reasoner.getSuperProperties(
							axiom.getSubProperty().asOWLDataProperty())
							.contains(axiom.getSuperProperty());
				}
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		try {
			if (!axiom.getProperty().isAnonymous()) {
				isLocal = reasoner.isInverseFunctional(axiom.getProperty()
						.asOWLObjectProperty());
			}
		} catch (OWLReasonerException e) {
			throw new OWLRuntimeException(e);
		}
	}

	public void visit(OWLSameIndividualsAxiom axiom) {
		// TODO Auto-generated method stub
	}

	public void visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		// TODO Auto-generated method stub
	}

	public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		// TODO Auto-generated method stub
	}

	public void visit(SWRLRule rule) {
		// TODO Auto-generated method stub
	}
}