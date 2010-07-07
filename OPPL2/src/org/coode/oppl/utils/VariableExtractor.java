/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.PlainVariableVisitor;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.ConcatGeneratedValues;
import org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorAdapter;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variablemansyntax.generated.VariableExpressionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.VariableIndexGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.factory.OWLObjectCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.factory.RenderingVariableGeneratedValue;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyExpression;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataRange;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectAnnotation;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyExpression;
import org.semanticweb.owl.model.OWLObjectPropertyInverse;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLObjectVisitorEx;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.model.SWRLAtomConstantObject;
import org.semanticweb.owl.model.SWRLAtomDVariable;
import org.semanticweb.owl.model.SWRLAtomIVariable;
import org.semanticweb.owl.model.SWRLAtomIndividualObject;
import org.semanticweb.owl.model.SWRLBuiltInAtom;
import org.semanticweb.owl.model.SWRLClassAtom;
import org.semanticweb.owl.model.SWRLDataRangeAtom;
import org.semanticweb.owl.model.SWRLDataValuedPropertyAtom;
import org.semanticweb.owl.model.SWRLDifferentFromAtom;
import org.semanticweb.owl.model.SWRLObjectPropertyAtom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.model.SWRLSameAsAtom;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableExtractor {
	final class ValueVariableExtractor extends SingleValueGeneratedValueVisitorAdapter {
		private Collection<Variable> collection;

		public ValueVariableExtractor(Collection<Variable> collection) {
			this.collection = collection;
		}

		@Override
		public void vistVariableIndexGeneratedValue(
				VariableIndexGeneratedValue variableIndexGeneratedValue) {
			variableIndexGeneratedValue.getVariable().accept(new PlainVariableVisitor() {
				public void visit(SingleValueGeneratedVariable<?> v) {
					if (VariableExtractor.this.isIncludeGenerated()) {
						ValueVariableExtractor.this.collection.add(v);
					}
					// Add the variables this generated variable refers
					// to (they
					// might no be mentioned elsewhere in the axiom)
					v.getValue().accept(
							new ValueVariableExtractor(ValueVariableExtractor.this.collection));
				}

				public void visit(Variable v) {
					ValueVariableExtractor.this.collection.add(v);
				}
			});
		}

		@Override
		public void visitVariableExpressionGeneratedValue(
				VariableExpressionGeneratedValue variableExpressionGeneratedValue) {
			this.collection.addAll(variableExpressionGeneratedValue.getExpression().accept(
					VariableExtractor.this.visitor));
		}

		@Override
		public void visitOWLObjectCollectionGeneratedValue(
				OWLObjectCollectionGeneratedValue owlObjectCollectionGeneratedValue) {
			owlObjectCollectionGeneratedValue.getVariable().accept(new PlainVariableVisitor() {
				public void visit(SingleValueGeneratedVariable<?> v) {
					v.getValue().accept(ValueVariableExtractor.this);
				}

				public void visit(Variable v) {
					ValueVariableExtractor.this.collection.add(v);
				}
			});
		}

		@Override
		public void visitRenderingVariableGeneratedValue(
				RenderingVariableGeneratedValue renderingVariableGeneratedValue) {
			this.collection.add(renderingVariableGeneratedValue.getVariable());
		}

		@Override
		public void visitRegExpGeneratedValue(RegExpGeneratedValue regExpGeneratedValue) {
			regExpGeneratedValue.getExpression().accept(this);
		}

		@Override
		public void visitConcatGeneratedValues(ConcatGeneratedValues concatGeneratedValues) {
			List<SingleValueGeneratedValue<String>> valuesToAggregate = concatGeneratedValues.getValuesToAggregate();
			for (SingleValueGeneratedValue<String> singleValueGeneratedValue : valuesToAggregate) {
				singleValueGeneratedValue.accept(this);
			}
		}
	};

	private final ConstraintSystem constraintSystem;
	private final boolean includeGenerated;
	private final Visitor visitor = new Visitor();
	private static final Map<OWLObject, Set<Variable>> cache = new HashMap<OWLObject, Set<Variable>>();

	/**
	 * @param constraintSystem
	 */
	public VariableExtractor(ConstraintSystem constraintSystem, boolean includeGenerated) {
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		this.constraintSystem = constraintSystem;
		this.includeGenerated = includeGenerated;
	}

	private final class Visitor implements OWLObjectVisitorEx<Set<Variable>> {
		public Set<Variable> visit(OWLSubClassAxiom axiom) {
			OWLDescription subClass = axiom.getSubClass();
			OWLDescription superClass = axiom.getSuperClass();
			Set<Variable> toReturn = new HashSet<Variable>();
			toReturn.addAll(superClass.accept(this));
			toReturn.addAll(subClass.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			OWLIndividual object = axiom.getObject();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLIndividual subject = axiom.getSubject();
			Set<Variable> toReturn = new HashSet<Variable>();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(object.accept(this));
			toReturn.addAll(subject.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLReflexiveObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDisjointClassesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDescription> descriptions = axiom.getDescriptions();
			for (OWLDescription description : descriptions) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDataPropertyDomainAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression property = axiom.getProperty();
			OWLDescription domain = axiom.getDomain();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(domain.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLImportsDeclaration axiom) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLAxiomAnnotationAxiom axiom) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLObjectPropertyDomainAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLDescription domain = axiom.getDomain();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(domain.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
			for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
				toReturn.addAll(objectPropertyExpression.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLConstant object = axiom.getObject();
			OWLDataPropertyExpression property = axiom.getProperty();
			OWLIndividual subject = axiom.getSubject();
			toReturn.addAll(object.accept(this));
			toReturn.addAll(subject.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDifferentIndividualsAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLIndividual> individuals = axiom.getIndividuals();
			for (OWLIndividual individual : individuals) {
				toReturn.addAll(individual.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDisjointDataPropertiesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDataPropertyExpression> properties = axiom.getProperties();
			for (OWLDataPropertyExpression dataPropertyExpression : properties) {
				toReturn.addAll(dataPropertyExpression.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDisjointObjectPropertiesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
			for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
				toReturn.addAll(objectPropertyExpression.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectPropertyRangeAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLDescription range = axiom.getRange();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(range.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectPropertyAssertionAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLIndividual subject = axiom.getSubject();
			OWLIndividual object = axiom.getObject();
			toReturn.addAll(subject.accept(this));
			toReturn.addAll(object.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLFunctionalObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectSubPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
			OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
			toReturn.addAll(subProperty.accept(this));
			toReturn.addAll(superProperty.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDisjointUnionAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDescription> descriptions = axiom.getDescriptions();
			for (OWLDescription description : descriptions) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDeclarationAxiom axiom) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLEntityAnnotationAxiom axiom) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLOntologyAnnotationAxiom axiom) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLSymmetricObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataPropertyRangeAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression property = axiom.getProperty();
			OWLDataRange range = axiom.getRange();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(range.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLFunctionalDataPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLEquivalentDataPropertiesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDataPropertyExpression> properties = axiom.getProperties();
			for (OWLDataPropertyExpression dataPropertyExpression : properties) {
				toReturn.addAll(dataPropertyExpression.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLClassAssertionAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLIndividual individual = axiom.getIndividual();
			OWLDescription description = axiom.getDescription();
			toReturn.addAll(individual.accept(this));
			toReturn.addAll(description.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLEquivalentClassesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDescription> descriptions = axiom.getDescriptions();
			for (OWLDescription description : descriptions) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDataPropertyAssertionAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLConstant object = axiom.getObject();
			OWLIndividual subject = axiom.getSubject();
			OWLDataPropertyExpression property = axiom.getProperty();
			toReturn.addAll(subject.accept(this));
			toReturn.addAll(property.accept(this));
			toReturn.addAll(object.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLTransitiveObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataSubPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression subProperty = axiom.getSubProperty();
			OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
			toReturn.addAll(subProperty.accept(this));
			toReturn.addAll(superProperty.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLSameIndividualsAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLIndividual> individuals = axiom.getIndividuals();
			for (OWLIndividual individual : individuals) {
				toReturn.addAll(individual.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			List<OWLObjectPropertyExpression> propertyChain = axiom.getPropertyChain();
			for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
				toReturn.addAll(objectPropertyExpression.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLInverseObjectPropertiesAxiom axiom) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
			OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
			toReturn.addAll(firstProperty.accept(this));
			toReturn.addAll(secondProperty.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(SWRLRule rule) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLClass desc) {
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(desc);
			final Set<Variable> toReturn = new HashSet<Variable>();
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						desc.getURI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		/**
		 * @param collection
		 * @param variable
		 */
		private void vetoVariableIntoCollection(final Set<Variable> collection, Variable variable) {
			PlainVariableVisitor variableVetoer = new PlainVariableVisitor() {
				public void visit(SingleValueGeneratedVariable<?> v) {
					if (VariableExtractor.this.isIncludeGenerated()) {
						collection.add(v);
					}
					// Add the variables this generated variable refers to (they
					// might no be mentioned elsewhere in the axiom)
					v.getValue().accept(new ValueVariableExtractor(collection));
				}

				public void visit(Variable v) {
					collection.add(v);
				}
			};
			variable.accept(variableVetoer);
		}

		public Set<Variable> visit(OWLObjectIntersectionOf desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDescription> operands = desc.getOperands();
			for (OWLDescription description : operands) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectUnionOf desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLDescription> operands = desc.getOperands();
			for (OWLDescription description : operands) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectComplementOf desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDescription operand = desc.getOperand();
			toReturn.addAll(operand.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectSomeRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDescription filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectAllRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDescription filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectValueRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLIndividual value = desc.getValue();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(value.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectMinCardinalityRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDescription filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectExactCardinalityRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDescription filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectMaxCardinalityRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDescription filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectSelfRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectOneOf desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLIndividual> individuals = desc.getIndividuals();
			for (OWLIndividual individual : individuals) {
				toReturn.addAll(individual.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDataSomeRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression property = desc.getProperty();
			OWLDataRange filler = desc.getFiller();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(filler.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataAllRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression property = desc.getProperty();
			OWLDataRange filler = desc.getFiller();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(filler.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataValueRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataPropertyExpression property = desc.getProperty();
			OWLConstant value = desc.getValue();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(value.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataMinCardinalityRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataRange filler = desc.getFiller();
			OWLDataPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataExactCardinalityRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataRange filler = desc.getFiller();
			OWLDataPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataMaxCardinalityRestriction desc) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataRange filler = desc.getFiller();
			OWLDataPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataType node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLDataComplementOf node) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataRange dataRange = node.getDataRange();
			toReturn.addAll(dataRange.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataOneOf node) {
			Set<Variable> toReturn = new HashSet<Variable>();
			Set<OWLConstant> values = node.getValues();
			for (OWLConstant constant : values) {
				toReturn.addAll(constant.accept(this));
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDataRangeRestriction node) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLDataRange dataRange = node.getDataRange();
			toReturn.addAll(dataRange.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLTypedConstant node) {
			Set<Variable> toReturn = new HashSet<Variable>();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(node);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						node.getLiteral());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLUntypedConstant node) {
			Set<Variable> toReturn = new HashSet<Variable>();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(node);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						node.getLiteral());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLDataRangeFacetRestriction node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLObjectProperty property) {
			Set<Variable> toReturn = new HashSet<Variable>();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(property);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						property.getURI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectPropertyInverse property) {
			Set<Variable> toReturn = new HashSet<Variable>();
			OWLObjectPropertyExpression inverse = property.getInverse();
			toReturn.addAll(inverse.accept(this));
			return toReturn;
		}

		public Set<Variable> visit(OWLDataProperty property) {
			Set<Variable> toReturn = new HashSet<Variable>();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(property);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						property.getURI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLIndividual individual) {
			Set<Variable> toReturn = new HashSet<Variable>();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(individual);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						individual.getURI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		public Set<Variable> visit(OWLObjectAnnotation annotation) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLConstantAnnotation annotation) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLClassAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLDataRangeAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLObjectPropertyAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLDataValuedPropertyAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLBuiltInAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLAtomDVariable node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLAtomIVariable node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLAtomIndividualObject node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLAtomConstantObject node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLSameAsAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(SWRLDifferentFromAtom node) {
			return new HashSet<Variable>();
		}

		public Set<Variable> visit(OWLOntology ontology) {
			return new HashSet<Variable>();
		}
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @return the includeGenerated
	 */
	public boolean isIncludeGenerated() {
		return this.includeGenerated;
	}

	/**
	 * Clears the cache
	 */
	public static void clear() {
		cache.clear();
	}

	public Set<Variable> extractVariables(OWLObject owlObject) {
		Set<Variable> toReturn = cache.get(owlObject);
		if (toReturn == null) {
			toReturn = owlObject.accept(this.visitor);
			cache.put(owlObject, new HashSet<Variable>(toReturn));
		} else {
			// Have to make a defensive copy here to protect the content of the
			// cache
			toReturn = new HashSet<Variable>(toReturn);
		}
		return toReturn;
	}
}
