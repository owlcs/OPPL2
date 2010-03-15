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
package org.coode.oppl.variablemansyntax;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class PossibleValueExtractor implements
		OWLObjectVisitorEx<Set<OWLObject>> {
	protected VariableType variableType;

	public PossibleValueExtractor(VariableType variableType) {
		this.variableType = variableType;
	}

	public Set<OWLObject> visit(OWLSubClassAxiom axiom) {
		OWLDescription subClass = axiom.getSubClass();
		OWLDescription superClass = axiom.getSuperClass();
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(superClass.accept(this));
		toReturn.addAll(subClass.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		OWLIndividual object = axiom.getObject();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(object.accept(this));
		toReturn.addAll(subject.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLReflexiveObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			toReturn.addAll(description.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataPropertyDomainAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLDescription domain = axiom.getDomain();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(domain.accept(this));
		return toReturn;
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLImportsDeclaration axiom) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLAxiomAnnotationAxiom axiom) {
		return new HashSet<OWLObject>();
	}

	public Set<OWLObject> visit(OWLObjectPropertyDomainAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLDescription domain = axiom.getDomain();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(domain.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			toReturn.addAll(objectPropertyExpression.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLConstant object = axiom.getObject();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		toReturn.addAll(object.accept(this));
		toReturn.addAll(subject.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			toReturn.addAll(individual.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			toReturn.addAll(dataPropertyExpression.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			toReturn.addAll(objectPropertyExpression.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectPropertyRangeAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLDescription range = axiom.getRange();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(range.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectPropertyAssertionAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		OWLIndividual subject = axiom.getSubject();
		OWLIndividual object = axiom.getObject();
		toReturn.addAll(subject.accept(this));
		toReturn.addAll(object.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLFunctionalObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectSubPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression subProperty = axiom.getSubProperty();
		OWLObjectPropertyExpression superProperty = axiom.getSuperProperty();
		toReturn.addAll(subProperty.accept(this));
		toReturn.addAll(superProperty.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDisjointUnionAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			toReturn.addAll(description.accept(this));
		}
		return toReturn;
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLDeclarationAxiom axiom) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLEntityAnnotationAxiom axiom) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLOntologyAnnotationAxiom axiom) {
		return new HashSet<OWLObject>();
	}

	public Set<OWLObject> visit(OWLSymmetricObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataPropertyRangeAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression property = axiom.getProperty();
		OWLDataRange range = axiom.getRange();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(range.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLFunctionalDataPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			toReturn.addAll(dataPropertyExpression.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLClassAssertionAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLIndividual individual = axiom.getIndividual();
		OWLDescription description = axiom.getDescription();
		toReturn.addAll(individual.accept(this));
		toReturn.addAll(description.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			toReturn.addAll(description.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataPropertyAssertionAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLConstant object = axiom.getObject();
		OWLIndividual subject = axiom.getSubject();
		OWLDataPropertyExpression property = axiom.getProperty();
		toReturn.addAll(subject.accept(this));
		toReturn.addAll(property.accept(this));
		toReturn.addAll(object.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLTransitiveObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataSubPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression subProperty = axiom.getSubProperty();
		OWLDataPropertyExpression superProperty = axiom.getSuperProperty();
		toReturn.addAll(subProperty.accept(this));
		toReturn.addAll(superProperty.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = axiom.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLSameIndividualsAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			toReturn.addAll(individual.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		List<OWLObjectPropertyExpression> propertyChain = axiom
				.getPropertyChain();
		for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
			toReturn.addAll(objectPropertyExpression.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLInverseObjectPropertiesAxiom axiom) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression firstProperty = axiom.getFirstProperty();
		OWLObjectPropertyExpression secondProperty = axiom.getSecondProperty();
		toReturn.addAll(firstProperty.accept(this));
		toReturn.addAll(secondProperty.accept(this));
		return toReturn;
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLRule rule) {
		return new HashSet<OWLObject>();
	}

	public Set<OWLObject> visit(OWLClass desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.variableType.isCompatibleWith(desc)) {
			toReturn.add(desc);
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectIntersectionOf desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDescription> operands = desc.getOperands();
		for (OWLDescription description : operands) {
			toReturn.addAll(description.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectUnionOf desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLDescription> operands = desc.getOperands();
		for (OWLDescription description : operands) {
			toReturn.addAll(description.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectComplementOf desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDescription operand = desc.getOperand();
		toReturn.addAll(operand.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectSomeRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectAllRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectValueRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLIndividual value = desc.getValue();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(value.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectMinCardinalityRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectExactCardinalityRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectMaxCardinalityRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDescription filler = desc.getFiller();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectSelfRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression property = desc.getProperty();
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectOneOf desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLIndividual> individuals = desc.getIndividuals();
		for (OWLIndividual individual : individuals) {
			toReturn.addAll(individual.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataSomeRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression property = desc.getProperty();
		OWLDataRange filler = desc.getFiller();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(filler.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataAllRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression property = desc.getProperty();
		OWLDataRange filler = desc.getFiller();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(filler.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataValueRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataPropertyExpression property = desc.getProperty();
		OWLConstant value = desc.getValue();
		toReturn.addAll(property.accept(this));
		toReturn.addAll(value.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataMinCardinalityRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataExactCardinalityRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataMaxCardinalityRestriction desc) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataRange filler = desc.getFiller();
		OWLDataPropertyExpression property = desc.getProperty();
		toReturn.addAll(filler.accept(this));
		toReturn.addAll(property.accept(this));
		return toReturn;
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLDataType node) {
		return new HashSet<OWLObject>();
	}

	public Set<OWLObject> visit(OWLDataComplementOf node) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataRange dataRange = node.getDataRange();
		toReturn.addAll(dataRange.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataOneOf node) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		Set<OWLConstant> values = node.getValues();
		for (OWLConstant constant : values) {
			toReturn.addAll(constant.accept(this));
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataRangeRestriction node) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLDataRange dataRange = node.getDataRange();
		toReturn.addAll(dataRange.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLTypedConstant node) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.variableType.isCompatibleWith(node)) {
			toReturn.add(node);
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLUntypedConstant node) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.variableType.isCompatibleWith(node)) {
			toReturn.add(node);
		}
		return toReturn;
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLDataRangeFacetRestriction node) {
		return new HashSet<OWLObject>();
	}

	public Set<OWLObject> visit(OWLObjectProperty property) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.variableType.isCompatibleWith(property)) {
			toReturn.add(property);
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLObjectPropertyInverse property) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		OWLObjectPropertyExpression inverse = property.getInverse();
		toReturn.addAll(inverse.accept(this));
		return toReturn;
	}

	public Set<OWLObject> visit(OWLDataProperty property) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.variableType.isCompatibleWith(property)) {
			toReturn.add(property);
		}
		return toReturn;
	}

	public Set<OWLObject> visit(OWLIndividual individual) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		if (this.variableType.isCompatibleWith(individual)) {
			toReturn.add(individual);
		}
		return toReturn;
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLObjectAnnotation annotation) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLConstantAnnotation annotation) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLClassAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLDataRangeAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLObjectPropertyAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLDataValuedPropertyAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLBuiltInAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLAtomDVariable node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLAtomIVariable node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLAtomIndividualObject node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLAtomConstantObject node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLSameAsAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(SWRLDifferentFromAtom node) {
		return new HashSet<OWLObject>();
	}

	@SuppressWarnings("unused")
	public Set<OWLObject> visit(OWLOntology ontology) {
		return new HashSet<OWLObject>();
	}
}
