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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.generated.CLASSRegexpGeneratedVariable;
import org.coode.oppl.generated.CONSTANTRegexpGeneratedVariable;
import org.coode.oppl.generated.DATAPROPERTYRegexpGeneratedVariable;
import org.coode.oppl.generated.INDIVIDUALRegexpGeneratedVariable;
import org.coode.oppl.generated.OBJECTPROPERTYRegexpGeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.variabletypes.CLASSVariableImpl;
import org.coode.oppl.variabletypes.CONSTANTVariableImpl;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableImpl;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;
import org.semanticweb.owlapi.expression.ParserException;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorAdapter;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

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
				referencedValues.addAll(owlOntology.getClassesInSignature());
			}
			return referencedValues;
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new CLASSVariableImpl(name);
		}

		@Override
		public RegexpGeneratedVariable<OWLClass> createRegexpGeneratedVariable(String name,
				Pattern pattern) {
			return new CLASSRegexpGeneratedVariable(name, pattern);
		}

		@Override
		public VariableScope<OWLClassExpression> parseVariable(VariableScopes.Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			OWLClassExpression description = parser.parseClassExpression();
			if (direction.equals(Direction.SUBCLASSOF)) {
				return VariableScopes.buildSubClassVariableScope(description);
			} else {
				return VariableScopes.buildSuperClassVariableScope(description);
			}
		}

		@Override
		public RegexpGeneratedVariable<OWLClass> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, Pattern exp,
				Collection<? extends OWLOntology> ontologies) {
			return new CLASSRegexpGeneratedVariable(name, exp);
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return OWLClass.class;
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, IRI iri, String name) {
			return factory.getOWLClass(iri);
		}
	},
	DATAPROPERTY("DATAPROPERTY", EnumSet.of(Direction.SUBPROPERTYOF, Direction.SUPERPROPERTYOF)) {
		@Override
		public Set<OWLDataProperty> getReferencedOWLObjects(
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLDataProperty> referenceValues = new HashSet<OWLDataProperty>();
			for (OWLOntology owlOntology : ontologies) {
				referenceValues.addAll(owlOntology.getDataPropertiesInSignature());
			}
			return referenceValues;
		}

		@Override
		public RegexpGeneratedVariable<OWLDataProperty> createRegexpGeneratedVariable(String name,
				Pattern pattern) {
			return new DATAPROPERTYRegexpGeneratedVariable(name, pattern);
		}

		@Override
		public RegexpGeneratedVariable<OWLDataProperty> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, Pattern exp,
				Collection<? extends OWLOntology> ontologies) {
			return new DATAPROPERTYRegexpGeneratedVariable(name, exp);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new DATAPROPERTYVariableImpl(name);
		}

		@Override
		public PropertyVariableScope<OWLDataProperty> parseVariable(Direction direction,
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
		public OWLObject buildOWLObject(OWLDataFactory factory, IRI iri, String name) {
			return factory.getOWLDataProperty(iri);
		}
	},
	OBJECTPROPERTY("OBJECTPROPERTY", EnumSet.of(Direction.SUBPROPERTYOF, Direction.SUPERPROPERTYOF)) {
		@Override
		public Set<OWLObjectProperty> getReferencedOWLObjects(
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLObjectProperty> referenceValues = new HashSet<OWLObjectProperty>();
			for (OWLOntology owlOntology : ontologies) {
				referenceValues.addAll(owlOntology.getObjectPropertiesInSignature());
			}
			return referenceValues;
		}

		@Override
		public RegexpGeneratedVariable<?> createRegexpGeneratedVariable(String name, Pattern pattern) {
			return new OBJECTPROPERTYRegexpGeneratedVariable(name, pattern);
		}

		@Override
		public RegexpGeneratedVariable<OWLObjectProperty> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, Pattern exp,
				Collection<? extends OWLOntology> ontologies) {
			return new OBJECTPROPERTYRegexpGeneratedVariable(name, exp);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new OBJECTPROPERTYVariableImpl(name);
		}

		@Override
		public PropertyVariableScope<OWLObjectProperty> parseVariable(Direction direction,
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
		public OWLObject buildOWLObject(OWLDataFactory factory, IRI iri, String name) {
			return factory.getOWLObjectProperty(iri);
		}
	},
	INDIVIDUAL("INDIVIDUAL", EnumSet.of(Direction.INSTANCEOF)) {
		@Override
		public Set<OWLNamedIndividual> getReferencedOWLObjects(
				Collection<? extends OWLOntology> ontologies) {
			Set<OWLNamedIndividual> referenceValues = new HashSet<OWLNamedIndividual>();
			for (OWLOntology owlOntology : ontologies) {
				referenceValues.addAll(owlOntology.getIndividualsInSignature());
			}
			return referenceValues;
		}

		@Override
		public RegexpGeneratedVariable<?> createRegexpGeneratedVariable(String name, Pattern pattern) {
			return new INDIVIDUALRegexpGeneratedVariable(name, pattern);
		}

		@Override
		public RegexpGeneratedVariable<OWLNamedIndividual> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, Pattern exp,
				Collection<? extends OWLOntology> ontologies) {
			return new INDIVIDUALRegexpGeneratedVariable(name, exp);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new INDIVIDUALVariableImpl(name);
		}

		@Override
		public IndividualVariableScope parseVariable(Direction direction,
				ManchesterOWLSyntaxEditorParser parser) throws ParserException {
			OWLClassExpression description = parser.parseClassExpression();
			return VariableScopes.buildIndividualVariableScope(description);
		}

		@Override
		public Class<? extends OWLEntity> getOWLEntityClass() {
			return OWLNamedIndividual.class;
		}

		@Override
		public OWLObject buildOWLObject(OWLDataFactory factory, IRI iri, String name) {
			return factory.getOWLNamedIndividual(iri);
		}
	},
	CONSTANT("CONSTANT", EnumSet.noneOf(Direction.class)) {
		@Override
		public Set<OWLLiteral> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies) {
			Set<OWLLiteral> referencedValues = new HashSet<OWLLiteral>();
			for (OWLOntology owlOntology : ontologies) {
				for (OWLAxiom axiom : owlOntology.getAxioms()) {
					referencedValues.addAll(OWLObjectExtractor.getAllOWLLiterals(axiom));
				}
			}
			return referencedValues;
		}

		@Override
		public RegexpGeneratedVariable<?> createRegexpGeneratedVariable(String name, Pattern pattern) {
			return new CONSTANTRegexpGeneratedVariable(name, pattern);
		}

		@Override
		public RegexpGeneratedVariable<OWLLiteral> getRegExpGenerated(String name,
				OWLEntityRenderer entityRenderer, Pattern exp,
				Collection<? extends OWLOntology> ontologies) {
			return new CONSTANTRegexpGeneratedVariable(name, exp);
		}

		@Override
		public Variable instantiateVariable(String name) {
			return new CONSTANTVariableImpl(name);
		}

		@Override
		public VariableScope<?> parseVariable(Direction direction,
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
		public OWLObject buildOWLObject(OWLDataFactory factory, IRI iri, String name) {
			return factory.getOWLLiteral(name);
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

	public abstract VariableScope<?> parseVariable(VariableScopes.Direction direction,
			ManchesterOWLSyntaxEditorParser parser) throws ParserException;

	/**
	 * calls the appropriate factory method according to the type; either uri or
	 * name are null
	 */
	public abstract OWLObject buildOWLObject(OWLDataFactory factory, IRI iri, String name);

	public abstract Set<? extends OWLObject> getReferencedOWLObjects(
			Collection<? extends OWLOntology> ontologies);

	public abstract RegexpGeneratedVariable<?> getRegExpGenerated(String name,
			OWLEntityRenderer entityRenderer, Pattern exp,
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
		public void visit(OWLObjectSomeValuesFrom desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectAllValuesFrom desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectHasValue desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectMinCardinality desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectExactCardinality desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectMaxCardinality desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectHasSelf desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLObjectOneOf desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataSomeValuesFrom desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataAllValuesFrom desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataHasValue desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataMinCardinality desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataExactCardinality desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataMaxCardinality desc) {
			this.foundValue = CLASS;
		}

		@Override
		public void visit(OWLDataProperty owlDataProperty) {
			this.foundValue = DATAPROPERTY;
		}

		@Override
		public void visit(OWLNamedIndividual owlIndividual) {
			this.foundValue = INDIVIDUAL;
		}

		@Override
		public void visit(OWLObjectProperty owlObjectProperty) {
			this.foundValue = OBJECTPROPERTY;
		}
	}

	private final class CompatibilityChecker extends OWLObjectVisitorExAdapter<Boolean> implements
			OWLObjectVisitorEx<Boolean> {
		private final VariableType variableType;

		/**
		 * @param variableType
		 */
		CompatibilityChecker(VariableType variableType) {
			super(false);
			this.variableType = variableType;
		}

		@Override
		public Boolean visit(OWLClass cls) {
			return this.checkClass();
		}

		private Boolean checkClass() {
			return this.variableType.equals(VariableType.CLASS);
		}

		@Override
		public Boolean visit(OWLObjectProperty property) {
			return this.variableType.equals(VariableType.OBJECTPROPERTY);
		}

		@Override
		public Boolean visit(OWLDataProperty property) {
			return this.variableType.equals(VariableType.DATAPROPERTY);
		}

		@Override
		public Boolean visit(OWLNamedIndividual individual) {
			return this.variableType.equals(VariableType.INDIVIDUAL);
		}

		@Override
		public Boolean visit(OWLDatatype dataType) {
			return false;
		}

		@Override
		public Boolean visit(OWLObjectIntersectionOf desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectUnionOf desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectComplementOf desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectSomeValuesFrom desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectAllValuesFrom desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectHasValue desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectMinCardinality desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectExactCardinality desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectMaxCardinality desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectHasSelf desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLObjectOneOf desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLDataSomeValuesFrom desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLDataAllValuesFrom desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLDataHasValue desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLDataMinCardinality desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLDataExactCardinality desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLDataMaxCardinality desc) {
			return this.checkClass();
		}

		@Override
		public Boolean visit(OWLLiteral node) {
			return this.variableType.equals(CONSTANT);
		}
	}

	public abstract RegexpGeneratedVariable<?> createRegexpGeneratedVariable(String name,
			Pattern pattern);
}
