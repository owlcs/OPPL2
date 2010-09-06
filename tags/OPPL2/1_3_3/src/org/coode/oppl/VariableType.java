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
package org.coode.oppl;

import java.net.URI;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.coode.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.RegExpGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.variabletypes.CLASSVariableImpl;
import org.coode.oppl.variabletypes.CONSTANTVariableImpl;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableImpl;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owl.expression.ParserException;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
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
import org.semanticweb.owl.model.OWLEntity;
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
import org.semanticweb.owl.util.OWLObjectVisitorAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public enum VariableType {
	CLASS("CLASS", EnumSet.of(Direction.SUBCLASSOF, Direction.SUPERCLASSOF)) {
		@Override
		public Set<OWLClass> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies) {
			Set<OWLClass> referencedValues = new HashSet<OWLClass>();
			for (OWLOntology owlOntology : ontologies) {
				referencedValues.addAll(owlOntology.getReferencedClasses());
			}
			return referencedValues;
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new CLASSVariableImpl(name);
		}

		@Override
		public VariableScope parseVariable(VariableScopes.Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			OWLDescription description = parser.parseDescription();
			if (direction.equals(Direction.SUBCLASSOF)) {
				return VariableScopes.buildSubClassVariableScope(description);
			} else {
				return VariableScopes.buildSuperClassVariableScope(description);
			}
		}

		@Override
		public RegExpGenerated<OWLClass> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, SingleValueGeneratedValue<String> exp,
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLClass> referencedValues = new HashSet<OWLClass>();
			for (OWLOntology owlOntology : ontologies) {
				referencedValues.addAll(owlOntology.getReferencedClasses());
			}
			return RegExpGeneratedValue.getOWLClassExpGeneratedValue(
					referencedValues,
					exp,
					entityRenderer).getGeneratedVariable(name);
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return OWLClass.class;
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, URI uri, String name) {
			return factory.getOWLClass(uri);
		}
	},
	DATAPROPERTY("DATAPROPERTY", EnumSet.of(Direction.SUBPROPERTYOF, Direction.SUPERPROPERTYOF)) {
		@Override
		public Set<OWLDataProperty> getReferencedOWLObjects(
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLDataProperty> referenceValues = new HashSet<OWLDataProperty>();
			for (OWLOntology owlOntology : ontologies) {
				referenceValues.addAll(owlOntology.getReferencedDataProperties());
			}
			return referenceValues;
		}

		@Override
		public RegExpGenerated<OWLDataProperty> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, SingleValueGeneratedValue<String> exp,
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLDataProperty> referencedValues = new HashSet<OWLDataProperty>();
			for (OWLOntology owlOntology : ontologies) {
				referencedValues.addAll(owlOntology.getReferencedDataProperties());
			}
			return RegExpGeneratedValue.getOWLDataPropertyExpGeneratedValue(
					referencedValues,
					exp,
					entityRenderer).getGeneratedVariable(name);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new DATAPROPERTYVariableImpl(name);
		}

		@Override
		public VariableScope parseVariable(Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			OWLDataProperty dataProperty = parser.parseDataProperty();
			if (direction.equals(Direction.SUPERPROPERTYOF)) {
				return VariableScopes.buildSuperPropertyVariableScope(dataProperty);
			} else {
				return VariableScopes.buildSubPropertyVariableScope(dataProperty);
			}
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return OWLDataProperty.class;
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, URI uri, String name) {
			return factory.getOWLDataProperty(uri);
		}
	},
	OBJECTPROPERTY("OBJECTPROPERTY", EnumSet.of(Direction.SUBPROPERTYOF, Direction.SUPERPROPERTYOF)) {
		@Override
		public Set<OWLObjectProperty> getReferencedOWLObjects(
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLObjectProperty> referenceValues = new HashSet<OWLObjectProperty>();
			for (OWLOntology owlOntology : ontologies) {
				referenceValues.addAll(owlOntology.getReferencedObjectProperties());
			}
			return referenceValues;
		}

		@Override
		public RegExpGenerated<OWLObjectProperty> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, SingleValueGeneratedValue<String> exp,
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLObjectProperty> referencedValues = new HashSet<OWLObjectProperty>();
			for (OWLOntology owlOntology : ontologies) {
				referencedValues.addAll(owlOntology.getReferencedObjectProperties());
			}
			return RegExpGeneratedValue.getOWLObjectPropertyExpGeneratedValue(
					referencedValues,
					exp,
					entityRenderer).getGeneratedVariable(name);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new OBJECTPROPERTYVariableImpl(name);
		}

		@Override
		public VariableScope parseVariable(Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			OWLObjectProperty objectProperty = (OWLObjectProperty) parser.parseObjectPropertyExpression();
			if (direction.equals(Direction.SUPERPROPERTYOF)) {
				return VariableScopes.buildSuperPropertyVariableScope(objectProperty);
			} else {
				return VariableScopes.buildSubPropertyVariableScope(objectProperty);
			}
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return OWLObjectProperty.class;
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, URI uri, String name) {
			return factory.getOWLObjectProperty(uri);
		}
	},
	INDIVIDUAL("INDIVIDUAL", EnumSet.of(Direction.INSTANCEOF)) {
		@Override
		public Set<OWLIndividual> getReferencedOWLObjects(
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLIndividual> referenceValues = new HashSet<OWLIndividual>();
			for (OWLOntology owlOntology : ontologies) {
				referenceValues.addAll(owlOntology.getReferencedIndividuals());
			}
			return referenceValues;
		}

		@Override
		public RegExpGenerated<OWLIndividual> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, SingleValueGeneratedValue<String> exp,
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLIndividual> referencedValues = new HashSet<OWLIndividual>();
			for (OWLOntology owlOntology : ontologies) {
				referencedValues.addAll(owlOntology.getReferencedIndividuals());
			}
			return RegExpGeneratedValue.getOWLIndividualExpGeneratedValue(
					referencedValues,
					exp,
					entityRenderer).getGeneratedVariable(name);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new INDIVIDUALVariableImpl(name);
		}

		@Override
		public VariableScope parseVariable(Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			OWLDescription description = parser.parseDescription();
			return VariableScopes.buildIndividualVariableScope(description);
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return OWLIndividual.class;
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, URI uri, String name) {
			return factory.getOWLIndividual(uri);
		}
	},
	CONSTANT("CONSTANT", EnumSet.noneOf(Direction.class)) {
		@Override
		public Set<OWLConstant> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies) {
			Set<OWLConstant> referencedValues = new HashSet<OWLConstant>();
			for (OWLOntology owlOntology : ontologies) {
				for (OWLAxiom axiom : owlOntology.getAxioms()) {
					referencedValues.addAll(OWLObjectExtractor.getAllOWLConstants(axiom));
				}
			}
			return referencedValues;
		}

		@Override
		public RegExpGenerated<OWLConstant> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, SingleValueGeneratedValue<String> exp,
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLConstant> referencedValues = new HashSet<OWLConstant>();
			for (OWLOntology owlOntology : ontologies) {
				for (OWLAxiom axiom : owlOntology.getAxioms()) {
					referencedValues.addAll(OWLObjectExtractor.getAllOWLConstants(axiom));
				}
			}
			return RegExpGeneratedValue.getOWLConstantExpGeneratedValue(
					referencedValues,
					exp,
					entityRenderer).getGeneratedVariable(name);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new CONSTANTVariableImpl(name);
		}

		@Override
		public VariableScope parseVariable(Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			return null;
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return null;
			// throw new RuntimeException(
			// "A CONSTANT Variable does not specify an OWLEntity class");
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, URI uri, String name) {
			return factory.getOWLUntypedConstant(name);
		}
	};
	private final String rendering;
	private final EnumSet<Direction> allowedDirections;
	private final CompatibilityChecker checker;

	private VariableType(String rendering, EnumSet<Direction> directions) {
		this.rendering = rendering;
		this.allowedDirections = directions;
		this.checker = new CompatibilityChecker(this);
	}

	public abstract Variable instantiateVariable(String name);

	public abstract VariableScope parseVariable(VariableScopes.Direction direction,
			ManchesterOWLSyntaxEditorParser parser) throws ParserException;

	/**
	 * calls the appropriate factory method according to the type; either uri or
	 * name are null
	 */
	public abstract OWLObject buildOWLObject(OWLDataFactory factory, URI uri, String name);

	public abstract Set<? extends OWLObject> getReferencedOWLObjects(
			Collection<? extends OWLOntology> ontologies);

	public abstract RegExpGenerated<?> getRegExpGenerated(String name,
			OWLEntityRenderer entityRenderer, SingleValueGeneratedValue<String> exp,
			Collection<? extends OWLOntology> ontologies);

	public abstract Class<? extends OWLEntity> getOWLEntityClass();

	@Override
	public String toString() {
		return this.rendering;
	}

	public EnumSet<Direction> getAllowedDirections() {
		return this.allowedDirections;
	}

	public static VariableType valueOfIgnoreCase(String s) {
		for (VariableType t : values()) {
			if (t.rendering.equalsIgnoreCase(s.trim())) {
				return t;
			}
		}
		return null;
	}

	public boolean isCompatibleWith(OWLObject o) {
		return o.accept(this.checker);
	}

	public static VariableType getVariableType(OWLObject owlObject) {
		OWLEntityTypeChecker c = new OWLEntityTypeChecker();
		owlObject.accept(c);
		return c.foundValue;
	}

	private static final class OWLEntityTypeChecker extends OWLObjectVisitorAdapter {
		VariableType foundValue;

		public OWLEntityTypeChecker() {
		}

		@Override
		public void visit(OWLClass desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectIntersectionOf desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectUnionOf desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectComplementOf desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectSomeRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectAllRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectValueRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectMinCardinalityRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectExactCardinalityRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectMaxCardinalityRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectSelfRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectOneOf desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataSomeRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataAllRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataValueRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataMinCardinalityRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataExactCardinalityRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataMaxCardinalityRestriction desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataProperty owlDataProperty) {
			this.foundValue = DATAPROPERTY;
		}

		@Override
		public void visit(OWLIndividual owlIndividual) {
			this.foundValue = INDIVIDUAL;
		}

		@Override
		public void visit(OWLObjectProperty owlObjectProperty) {
			this.foundValue = OBJECTPROPERTY;
		}
	}

	private final class CompatibilityChecker extends Empty implements OWLObjectVisitorEx<Boolean> {
		private final VariableType variableType;

		/**
		 * @param variableType
		 */
		CompatibilityChecker(VariableType variableType) {
			this.variableType = variableType;
		}

		public Boolean visit(OWLClass cls) {
			return this.checkClass();
		}

		private Boolean checkClass() {
			return this.variableType.equals(VariableType.CLASS);
		}

		public Boolean visit(OWLObjectProperty property) {
			return this.variableType.equals(VariableType.OBJECTPROPERTY);
		}

		public Boolean visit(OWLDataProperty property) {
			return this.variableType.equals(VariableType.DATAPROPERTY);
		}

		public Boolean visit(OWLIndividual individual) {
			return this.variableType.equals(VariableType.INDIVIDUAL);
		}

		public Boolean visit(OWLDataType dataType) {
			return false;
		}

		public Boolean visit(OWLObjectIntersectionOf desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectUnionOf desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectComplementOf desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectSomeRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectAllRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectValueRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectMinCardinalityRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectExactCardinalityRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectMaxCardinalityRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectSelfRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLObjectOneOf desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLDataSomeRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLDataAllRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLDataValueRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLDataMinCardinalityRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLDataExactCardinalityRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLDataMaxCardinalityRestriction desc) {
			return this.checkClass();
		}

		public Boolean visit(OWLTypedConstant node) {
			return this.variableType.equals(CONSTANT);
		}

		public Boolean visit(OWLUntypedConstant node) {
			return this.variableType.equals(CONSTANT);
		}
	}

	private static abstract class Empty {
		public Empty() {
		}

		public Boolean visit(OWLSubClassAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLReflexiveObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDisjointClassesAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDataPropertyDomainAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLImportsDeclaration axiom) {
			return null;
		}

		public Boolean visit(OWLAxiomAnnotationAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLObjectPropertyDomainAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDifferentIndividualsAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDisjointDataPropertiesAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDisjointObjectPropertiesAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLObjectPropertyRangeAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLObjectPropertyAssertionAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLFunctionalObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLObjectSubPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDisjointUnionAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDeclarationAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLEntityAnnotationAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLOntologyAnnotationAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLSymmetricObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDataPropertyRangeAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLFunctionalDataPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLEquivalentDataPropertiesAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLClassAssertionAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLEquivalentClassesAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDataPropertyAssertionAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLTransitiveObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLDataSubPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLSameIndividualsAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
			return null;
		}

		public Boolean visit(OWLInverseObjectPropertiesAxiom axiom) {
			return null;
		}

		public Boolean visit(SWRLRule rule) {
			return null;
		}

		public Boolean visit(OWLDataComplementOf node) {
			return null;
		}

		public Boolean visit(OWLDataOneOf node) {
			return null;
		}

		public Boolean visit(OWLDataRangeRestriction node) {
			return null;
		}

		public Boolean visit(OWLDataRangeFacetRestriction node) {
			return null;
		}

		public Boolean visit(OWLObjectPropertyInverse property) {
			return null;
		}

		public Boolean visit(OWLObjectAnnotation annotation) {
			return null;
		}

		public Boolean visit(OWLConstantAnnotation annotation) {
			return null;
		}

		public Boolean visit(SWRLClassAtom node) {
			return null;
		}

		public Boolean visit(SWRLDataRangeAtom node) {
			return null;
		}

		public Boolean visit(SWRLObjectPropertyAtom node) {
			return null;
		}

		public Boolean visit(SWRLDataValuedPropertyAtom node) {
			return null;
		}

		public Boolean visit(SWRLBuiltInAtom node) {
			return null;
		}

		public Boolean visit(SWRLAtomDVariable node) {
			return null;
		}

		public Boolean visit(SWRLAtomIVariable node) {
			return null;
		}

		public Boolean visit(SWRLAtomIndividualObject node) {
			return null;
		}

		public Boolean visit(SWRLAtomConstantObject node) {
			return null;
		}

		public Boolean visit(SWRLSameAsAtom node) {
			return null;
		}

		public Boolean visit(SWRLDifferentFromAtom node) {
			return null;
		}

		public Boolean visit(OWLOntology ontology) {
			return null;
		}
	}
}
