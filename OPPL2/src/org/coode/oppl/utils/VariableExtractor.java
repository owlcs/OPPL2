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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.ConcatGeneratedValues;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.RegExpGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitorAdapter;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.generated.VariableExpressionGeneratedValue;
import org.coode.oppl.generated.VariableIndexGeneratedValue;
import org.coode.oppl.generated.factory.OWLObjectCollectionGeneratedValue;
import org.coode.oppl.generated.factory.RenderingVariableGeneratedValue;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
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
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

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
				VariableIndexGeneratedValue<?> variableIndexGeneratedValue) {
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

				public void visit(RegExpGenerated<?> regExpGenerated) {
					ValueVariableExtractor.this.collection.add(regExpGenerated);
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

				public void visit(RegExpGenerated<?> regExpGenerated) {
					ValueVariableExtractor.this.collection.add(regExpGenerated);
				}
			});
		}

		@Override
		public void visitRenderingVariableGeneratedValue(
				RenderingVariableGeneratedValue renderingVariableGeneratedValue) {
			this.collection.add(renderingVariableGeneratedValue.getVariable());
		}

		@Override
		public void visitRegExpGeneratedValue(RegExpGeneratedValue<?> regExpGeneratedValue) {
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

	private final class Visitor extends OWLObjectVisitorExAdapter<Set<Variable>> {
		public Visitor() {
			super(Collections.<Variable> emptySet());
		}

		@Override
		public Set<Variable> visit(OWLSubClassOfAxiom axiom) {
			OWLClassExpression subClass = axiom.getSubClass();
			OWLClassExpression superClass = axiom.getSuperClass();
			Set<Variable> toReturn = Collections.emptySet();
			toReturn.addAll(superClass.accept(this));
			toReturn.addAll(subClass.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			OWLIndividual object = axiom.getObject();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLIndividual subject = axiom.getSubject();
			Set<Variable> toReturn = Collections.emptySet();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(object.accept(this));
			toReturn.addAll(subject.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLReflexiveObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDisjointClassesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
			for (OWLClassExpression description : descriptions) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataPropertyDomainAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression property = axiom.getProperty();
			OWLClassExpression domain = axiom.getDomain();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(domain.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectPropertyDomainAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLClassExpression domain = axiom.getDomain();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(domain.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
			for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
				toReturn.addAll(objectPropertyExpression.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLLiteral object = axiom.getObject();
			OWLDataPropertyExpression property = axiom.getProperty();
			OWLIndividual subject = axiom.getSubject();
			toReturn.addAll(object.accept(this));
			toReturn.addAll(subject.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDifferentIndividualsAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLIndividual> individuals = axiom.getIndividuals();
			for (OWLIndividual individual : individuals) {
				toReturn.addAll(individual.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDisjointDataPropertiesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLDataPropertyExpression> properties = axiom.getProperties();
			for (OWLDataPropertyExpression dataPropertyExpression : properties) {
				toReturn.addAll(dataPropertyExpression.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDisjointObjectPropertiesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
			for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
				toReturn.addAll(objectPropertyExpression.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectPropertyRangeAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLClassExpression range = axiom.getRange();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(range.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectPropertyAssertionAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			OWLIndividual subject = axiom.getSubject();
			OWLIndividual object = axiom.getObject();
			toReturn.addAll(subject.accept(this));
			toReturn.addAll(object.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLFunctionalObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLSubObjectPropertyOfAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
			OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
			toReturn.addAll(subProperty.accept(this));
			toReturn.addAll(superProperty.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDisjointUnionAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
			for (OWLClassExpression description : descriptions) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLSymmetricObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataPropertyRangeAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression property = axiom.getProperty();
			OWLDataRange range = axiom.getRange();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(range.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLFunctionalDataPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLEquivalentDataPropertiesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLDataPropertyExpression> properties = axiom.getProperties();
			for (OWLDataPropertyExpression dataPropertyExpression : properties) {
				toReturn.addAll(dataPropertyExpression.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLClassAssertionAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLIndividual individual = axiom.getIndividual();
			OWLClassExpression description = axiom.getClassExpression();
			toReturn.addAll(individual.accept(this));
			toReturn.addAll(description.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLEquivalentClassesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
			for (OWLClassExpression description : descriptions) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataPropertyAssertionAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLLiteral object = axiom.getObject();
			OWLIndividual subject = axiom.getSubject();
			OWLDataPropertyExpression property = axiom.getProperty();
			toReturn.addAll(subject.accept(this));
			toReturn.addAll(property.accept(this));
			toReturn.addAll(object.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLTransitiveObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLSubDataPropertyOfAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression subProperty = axiom.getSubProperty();
			OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
			toReturn.addAll(subProperty.accept(this));
			toReturn.addAll(superProperty.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = axiom.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLSameIndividualAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLIndividual> individuals = axiom.getIndividuals();
			for (OWLIndividual individual : individuals) {
				toReturn.addAll(individual.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLSubPropertyChainOfAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			List<OWLObjectPropertyExpression> propertyChain = axiom.getPropertyChain();
			for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
				toReturn.addAll(objectPropertyExpression.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLInverseObjectPropertiesAxiom axiom) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
			OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
			toReturn.addAll(firstProperty.accept(this));
			toReturn.addAll(secondProperty.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLClass desc) {
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(desc);
			final Set<Variable> toReturn = Collections.emptySet();
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						desc.getIRI());
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

				public void visit(RegExpGenerated<?> regExpGenerated) {
					collection.add(regExpGenerated);
				}
			};
			variable.accept(variableVetoer);
		}

		@Override
		public Set<Variable> visit(OWLObjectIntersectionOf desc) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLClassExpression> operands = desc.getOperands();
			for (OWLClassExpression description : operands) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectUnionOf desc) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLClassExpression> operands = desc.getOperands();
			for (OWLClassExpression description : operands) {
				toReturn.addAll(description.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectComplementOf desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLClassExpression operand = desc.getOperand();
			toReturn.addAll(operand.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectSomeValuesFrom desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLClassExpression filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectAllValuesFrom desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLClassExpression filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectHasValue desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLIndividual value = desc.getValue();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(value.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectMinCardinality desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLClassExpression filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectExactCardinality desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLClassExpression filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectMaxCardinality desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLClassExpression filler = desc.getFiller();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectHasSelf desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression property = desc.getProperty();
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectOneOf desc) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLIndividual> individuals = desc.getIndividuals();
			for (OWLIndividual individual : individuals) {
				toReturn.addAll(individual.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataSomeValuesFrom desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression property = desc.getProperty();
			OWLDataRange filler = desc.getFiller();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(filler.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataAllValuesFrom desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression property = desc.getProperty();
			OWLDataRange filler = desc.getFiller();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(filler.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataHasValue desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataPropertyExpression property = desc.getProperty();
			OWLLiteral value = desc.getValue();
			toReturn.addAll(property.accept(this));
			toReturn.addAll(value.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataMinCardinality desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataRange filler = desc.getFiller();
			OWLDataPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataExactCardinality desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataRange filler = desc.getFiller();
			OWLDataPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataMaxCardinality desc) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataRange filler = desc.getFiller();
			OWLDataPropertyExpression property = desc.getProperty();
			toReturn.addAll(filler.accept(this));
			toReturn.addAll(property.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataComplementOf node) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataRange dataRange = node.getDataRange();
			toReturn.addAll(dataRange.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataOneOf node) {
			Set<Variable> toReturn = Collections.emptySet();
			Set<OWLLiteral> values = node.getValues();
			for (OWLLiteral constant : values) {
				toReturn.addAll(constant.accept(this));
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDatatypeRestriction node) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLDataRange dataRange = node.getDatatype();
			toReturn.addAll(dataRange.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLLiteral node) {
			Set<Variable> toReturn = Collections.emptySet();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(node);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						node.getLiteral());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectProperty property) {
			Set<Variable> toReturn = Collections.emptySet();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(property);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						property.getIRI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLObjectInverseOf property) {
			Set<Variable> toReturn = Collections.emptySet();
			OWLObjectPropertyExpression inverse = property.getInverse();
			toReturn.addAll(inverse.accept(this));
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLDataProperty property) {
			Set<Variable> toReturn = Collections.emptySet();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(property);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						property.getIRI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
		}

		@Override
		public Set<Variable> visit(OWLNamedIndividual individual) {
			Set<Variable> toReturn = Collections.emptySet();
			boolean isVariable = VariableExtractor.this.getConstraintSystem().isVariable(individual);
			if (isVariable) {
				Variable variable = VariableExtractor.this.getConstraintSystem().getVariable(
						individual.getIRI());
				this.vetoVariableIntoCollection(toReturn, variable);
			}
			return toReturn;
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
