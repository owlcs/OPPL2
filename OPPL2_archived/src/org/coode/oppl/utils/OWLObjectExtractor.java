/**
 *
 */
package org.coode.oppl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityVisitor;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLQuantifiedRestriction;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.util.OWLAxiomVisitorAdapter;
import org.semanticweb.owl.util.OWLObjectVisitorAdapter;

/**
 * Retrieves all the object used to build an axiom
 * 
 * @author Luigi Iannone
 * 
 */
public class OWLObjectExtractor {
	public static Collection<? extends OWLClass> getAllClasses(OWLAxiom axiom) {
		final Set<OWLClass> toReturn = new HashSet<OWLClass>();
		for (OWLEntity entity : axiom.getReferencedEntities()) {
			entity.accept(new OWLEntityVisitor() {
				public void visit(OWLDataType dataType) {
				}

				public void visit(OWLIndividual individual) {
				}

				public void visit(OWLDataProperty property) {
				}

				public void visit(OWLObjectProperty property) {
				}

				public void visit(OWLClass cls) {
					toReturn.add(cls);
				}
			});
		}
		return toReturn;
	}

	public static Collection<? extends OWLObjectProperty> getAllOWLObjectProperties(
			OWLAxiom axiom) {
		final Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
		for (OWLEntity entity : axiom.getReferencedEntities()) {
			entity.accept(new OWLEntityVisitor() {
				public void visit(OWLDataType dataType) {
				}

				public void visit(OWLIndividual individual) {
				}

				public void visit(OWLDataProperty property) {
				}

				public void visit(OWLObjectProperty property) {
					toReturn.add(property);
				}

				public void visit(OWLClass cls) {
				}
			});
		}
		return toReturn;
	}

	public static Collection<? extends OWLDataProperty> getAllOWLDataProperties(
			OWLAxiom axiom) {
		final Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
		for (OWLEntity entity : axiom.getReferencedEntities()) {
			entity.accept(new OWLEntityVisitor() {
				public void visit(OWLDataType dataType) {
				}

				public void visit(OWLIndividual individual) {
				}

				public void visit(OWLDataProperty property) {
					toReturn.add(property);
				}

				public void visit(OWLObjectProperty property) {
				}

				public void visit(OWLClass cls) {
				}
			});
		}
		return toReturn;
	}

	public static Collection<? extends OWLIndividual> getAllOWLIndividuals(
			OWLAxiom axiom) {
		final Set<OWLIndividual> toReturn = new HashSet<OWLIndividual>();
		for (OWLEntity entity : axiom.getReferencedEntities()) {
			entity.accept(new OWLEntityVisitor() {
				public void visit(OWLDataType dataType) {
				}

				public void visit(OWLIndividual individual) {
					toReturn.add(individual);
				}

				public void visit(OWLDataProperty property) {
				}

				public void visit(OWLObjectProperty property) {
				}

				public void visit(OWLClass cls) {
				}
			});
		}
		return toReturn;
	}

	public static Collection<? extends OWLConstant> getAllOWLConstants(
			OWLAxiom axiomToVisit) {
		final Set<OWLConstant> toReturn = new HashSet<OWLConstant>();
		final OWLObjectVisitorAdapter constantExtractor = new OWLObjectVisitorAdapter() {
			protected void visitOWLQuantifiedRestriction(
					OWLQuantifiedRestriction<?, ?> restriction) {
				if (restriction.isQualified()) {
					restriction.getFiller().accept(this);
				}
			}

			@Override
			public void visit(OWLDataMaxCardinalityRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataExactCardinalityRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataMinCardinalityRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataAllRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataSomeRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectOneOf desc) {
			}

			@Override
			public void visit(OWLObjectSelfRestriction desc) {
			}

			@Override
			public void visit(OWLObjectMaxCardinalityRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectExactCardinalityRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectMinCardinalityRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectValueRestriction desc) {
			}

			@Override
			public void visit(OWLObjectAllRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLDataValueRestriction desc) {
				toReturn.add(desc.getValue());
			}

			@Override
			public void visit(OWLObjectSomeRestriction desc) {
				this.visitOWLQuantifiedRestriction(desc);
			}

			@Override
			public void visit(OWLObjectComplementOf desc) {
				desc.getOperand().accept(this);
			}

			protected void visitOWLObjectCollection(
					Collection<? extends OWLObject> collection) {
				for (OWLObject owlObject : collection) {
					owlObject.accept(this);
				}
			}

			@Override
			public void visit(OWLObjectUnionOf desc) {
				this.visitOWLObjectCollection(desc.getOperands());
			}

			@Override
			public void visit(OWLObjectIntersectionOf desc) {
				this.visitOWLObjectCollection(desc.getOperands());
			}
		};
		axiomToVisit.accept(new OWLAxiomVisitorAdapter() {
			@Override
			public void visit(OWLClassAssertionAxiom axiom) {
				axiom.getDescription().accept(constantExtractor);
			}

			@Override
			public void visit(OWLDataPropertyAssertionAxiom axiom) {
				toReturn.add(axiom.getObject());
			}

			@Override
			public void visit(OWLDisjointClassesAxiom axiom) {
				for (OWLDescription description : axiom.getDescriptions()) {
					description.accept(constantExtractor);
				}
			}

			@Override
			public void visit(OWLEquivalentClassesAxiom axiom) {
				for (OWLDescription description : axiom.getDescriptions()) {
					description.accept(constantExtractor);
				}
			}

			@Override
			public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
				toReturn.add(axiom.getObject());
			}

			@Override
			public void visit(OWLSubClassAxiom axiom) {
				axiom.getSubClass().accept(constantExtractor);
				axiom.getSuperClass().accept(constantExtractor);
			}
		});
		return toReturn;
	}

	public static Collection<? extends OWLObject> getAllOWLObjects(
			OWLAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(getAllClasses(axiom));
		toReturn.addAll(getAllOWLObjectProperties(axiom));
		toReturn.addAll(getAllOWLDataProperties(axiom));
		toReturn.addAll(getAllOWLIndividuals(axiom));
		toReturn.addAll(getAllOWLConstants(axiom));
		return toReturn;
	}
}
