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
package org.coode.oppl.rendering.xquery;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ConstraintVisitor;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InCollectionRegExpConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.log.Logging;
import org.coode.oppl.utils.ArgCheck;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiomVisitorEx;
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
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDataVisitor;
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
import org.semanticweb.owl.model.OWLEntityVisitor;
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
import org.semanticweb.owl.model.OWLPropertyExpressionVisitor;
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

final class PathNode {
	private final List<PathNode> children = new ArrayList<PathNode>();
	private final String name;
	private final PathNode parent;
	private final Map<String, Integer> nameIndexesMap = new HashMap<String, Integer>();

	/**
	 * @return the parent
	 */
	PathNode getParent() {
		return this.parent;
	}

	PathNode(String name, PathNode parent) {
		ArgCheck.checkNullArgument("The name", name);
		this.name = name;
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	List<PathNode> getChildren() {
		return new ArrayList<PathNode>(this.children);
	}

	PathNode addChild(String name1) {
		ArgCheck.checkNullArgument("The child name", name1);
		Integer index = this.nameIndexesMap.get(name1);
		if (index == null) {
			index = 0;
		}
		index++;
		this.nameIndexesMap.put(name1, index);
		String indexString = name1.startsWith("@") ? "" : "[" + index + "]";
		PathNode toReturn = new PathNode(name1 + indexString, this);
		this.addChild(toReturn);
		return toReturn;
	}

	void addChild(PathNode node) {
		this.children.add(node);
	}

	void removeChild(PathNode node) {
		this.children.remove(node);
	}

	void clearChildren(PathNode node) {
		this.children.clear();
	}

	/**
	 * @return the name
	 */
	String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	public String getPathToRoot() {
		String parentPathString = this.parent == null ? "" : this.parent
				.getPathToRoot();
		String separator = this.parent == null ? "" : "/";
		return parentPathString + separator + this.name;
	}
}

/**
 * @author Luigi Iannone
 * 
 */
public class VariableXQueryBuilder implements OWLAxiomVisitorEx<String>,
		ConstraintVisitor {
	public VariableXQueryBuilder(String axiomName,
			ConstraintSystem constraintSystem) {
		this.constraintSystem = constraintSystem;
		this.axiomName = axiomName;
	}

	private final class SpecializedOWLEntityVisitor2 implements
			OWLEntityVisitor {
		private static final String DIFFERENT = " != ";
		private final String variableReference;

		SpecializedOWLEntityVisitor2(String variableReference) {
			this.variableReference = variableReference;
		}

		public void visit(OWLClass cls) {
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(cls)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(cls.getURI());
				VariableXQueryBuilder.this.whereConditions.add(this
						.diffReplace(v));
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + DIFFERENT + cls.getURI());
			}
		}

		private String diffReplace(Variable v) {
			return this.variableReference + DIFFERENT
					+ v.getName().replace('?', '$');
		}

		public void visit(OWLObjectProperty property) {
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(property)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(property.getURI());
				VariableXQueryBuilder.this.whereConditions.add(this
						.diffReplace(v));
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + DIFFERENT
								+ property.getURI());
			}
		}

		public void visit(OWLDataProperty property) {
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(property)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(property.getURI());
				VariableXQueryBuilder.this.whereConditions.add(this
						.diffReplace(v));
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + DIFFERENT
								+ property.getURI());
			}
		}

		public void visit(OWLIndividual individual) {
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(individual)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(individual.getURI());
				VariableXQueryBuilder.this.whereConditions.add(this
						.diffReplace(v));
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + DIFFERENT
								+ individual.getURI());
			}
		}

		public void visit(OWLDataType dataType) {
		}
	}

	private final class SpecializedOWLEntityVisitor implements OWLEntityVisitor {
		private static final String EQUALS = " = ";
		private final StringWriter writer;
		private final String variableReference;

		SpecializedOWLEntityVisitor(StringWriter writer,
				String variableReference) {
			this.writer = writer;
			this.variableReference = variableReference;
		}

		public void visit(OWLClass cls) {
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(cls)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(cls.getURI());
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(this.replace(v));
			} else {
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(cls.getURI().toString());
			}
		}

		private String replace(Variable v) {
			return v.getName().replace('?', '$');
		}

		public void visit(OWLObjectProperty property) {
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(property)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(property.getURI());
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(this.replace(v));
			} else {
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(property.getURI().toString());
			}
		}

		public void visit(OWLDataProperty property) {
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(property)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(property.getURI());
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(this.replace(v));
			} else {
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(property.getURI().toString());
			}
		}

		public void visit(OWLIndividual individual) {
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(individual)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(individual.getURI());
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(this.replace(v));
			} else {
				this.writer.append(this.variableReference);
				this.writer.append(EQUALS);
				this.writer.append(individual.getURI().toString());
			}
		}

		public void visit(OWLDataType dataType) {
		}
	}

	private final class SpecializedOWLDataVisitor implements OWLDataVisitor {
		private final String variableReference;
		private final StringWriter writer;

		SpecializedOWLDataVisitor(String variableReference, StringWriter writer) {
			this.variableReference = variableReference;
			this.writer = writer;
		}

		public void visit(OWLDataType node) {
		}

		public void visit(OWLDataComplementOf node) {
		}

		public void visit(OWLDataOneOf node) {
		}

		public void visit(OWLDataRangeRestriction node) {
		}

		public void visit(OWLTypedConstant node) {
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(node)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(node.toString());
				this.writer.append(this.variableReference);
				this.writer.append(" = ");
				this.writer.append(v.getName().replace('?', '$'));
			} else {
				this.writer.append(this.variableReference);
				this.writer.append(" = ");
				this.writer.append(node.getLiteral());
			}
		}

		public void visit(OWLUntypedConstant node) {
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(node)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(node.toString());
				this.writer.append(this.variableReference);
				this.writer.append(" = ");
				this.writer.append(v.getName().replace('?', '$'));
			} else {
				this.writer.append(this.variableReference);
				this.writer.append(" = ");
				this.writer.append(node.getLiteral());
			}
		}

		public void visit(OWLDataRangeFacetRestriction node) {
		}
	}

	private final class MyDataVisitor implements OWLDataVisitor {
		private final String variableReference;

		MyDataVisitor(String variableReference) {
			this.variableReference = variableReference;
		}

		public void visit(OWLDataType node) {
		}

		public void visit(OWLDataComplementOf node) {
		}

		public void visit(OWLDataOneOf node) {
		}

		public void visit(OWLDataRangeRestriction node) {
		}

		public void visit(OWLTypedConstant node) {
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(node)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(node.toString());
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + " != "
								+ v.getName().replace('?', '$'));
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + " != "
								+ node.getLiteral());
			}
		}

		public void visit(OWLUntypedConstant node) {
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(node)) {
				Variable v = VariableXQueryBuilder.this.constraintSystem
						.getVariable(node.toString());
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + " != "
								+ v.getName().replace('?', '$'));
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(this.variableReference + " != "
								+ node.getLiteral());
			}
		}

		public void visit(OWLDataRangeFacetRestriction node) {
		}
	}

	private final class PathExtractor implements OWLDescriptionVisitor,
			OWLEntityVisitor, OWLPropertyExpressionVisitor, OWLDataVisitor {
		public PathExtractor() {
		}

		public void visit(OWLClass desc) {
			PathNode entityNode = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			PathNode uriChild = entityNode.addChild("@URI");
			VariableXQueryBuilder.this.currentNode = uriChild;
			String pathToRoot = VariableXQueryBuilder.this.currentNode
					.getPathToRoot();
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(desc)) {
				Variable variable = VariableXQueryBuilder.this.constraintSystem
						.getVariable(desc.getURI());
				List<String> paths = VariableXQueryBuilder.this.variablePaths
						.get(variable);
				if (paths == null) {
					paths = new ArrayList<String>();
				}
				paths.add(pathToRoot);
				VariableXQueryBuilder.this.variablePaths.put(variable, paths);
			} else {
				VariableXQueryBuilder.this.whereConditions.add(pathToRoot
						+ " = \"" + desc.getURI() + "\"");
			}
		}

		public void visit(OWLObjectIntersectionOf desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			Set<OWLDescription> operands = desc.getOperands();
			for (OWLDescription description : operands) {
				VariableXQueryBuilder.this.currentNode = child;
				description.accept(this);
			}
		}

		public void visit(OWLObjectUnionOf desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			Set<OWLDescription> operands = desc.getOperands();
			for (OWLDescription description : operands) {
				VariableXQueryBuilder.this.currentNode = child;
				description.accept(this);
			}
		}

		public void visit(OWLObjectComplementOf desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getOperand().accept(this);
		}

		public void visit(OWLObjectSomeRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			desc.getFiller().accept(this);
		}

		public void visit(OWLObjectAllRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			desc.getFiller().accept(this);
		}

		public void visit(OWLObjectValueRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			desc.getValue().accept(this);
		}

		public void visit(OWLObjectMinCardinalityRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			if (desc.getFiller() != null) {
				desc.getFiller().accept(this);
			}
		}

		public void visit(OWLObjectExactCardinalityRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			if (desc.getFiller() != null) {
				desc.getFiller().accept(this);
			}
		}

		public void visit(OWLObjectMaxCardinalityRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			if (desc.getFiller() != null) {
				desc.getFiller().accept(this);
			}
		}

		public void visit(OWLObjectSelfRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
		}

		public void visit(OWLObjectOneOf desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			Set<OWLIndividual> individuals = desc.getIndividuals();
			for (OWLIndividual individual : individuals) {
				VariableXQueryBuilder.this.currentNode = child;
				individual.accept(this);
			}
		}

		public void visit(OWLDataSomeRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			desc.getFiller().accept(this);
		}

		public void visit(OWLDataAllRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			desc.getFiller().accept(this);
		}

		public void visit(OWLDataValueRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			desc.getValue().accept(this);
		}

		public void visit(OWLDataMinCardinalityRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			if (desc.getFiller() != null) {
				desc.getFiller().accept(this);
			}
		}

		public void visit(OWLDataExactCardinalityRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			if (desc.getFiller() != null) {
				desc.getFiller().accept(this);
			}
		}

		public void visit(OWLDataMaxCardinalityRestriction desc) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(desc
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			desc.getProperty().accept(this);
			VariableXQueryBuilder.this.currentNode = child;
			if (desc.getFiller() != null) {
				desc.getFiller().accept(this);
			}
		}

		public void visit(OWLObjectProperty property) {
			PathNode entityNode = VariableXQueryBuilder.this.currentNode
					.addChild(property
							.accept(VariableXQueryBuilder.this.vocabulary));
			PathNode uriChild = entityNode.addChild("@URI");
			VariableXQueryBuilder.this.currentNode = uriChild;
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(property)) {
				Variable variable = VariableXQueryBuilder.this.constraintSystem
						.getVariable(property.getURI());
				List<String> paths = VariableXQueryBuilder.this.variablePaths
						.get(variable);
				if (paths == null) {
					paths = new ArrayList<String>();
				}
				paths.add(VariableXQueryBuilder.this.currentNode
						.getPathToRoot());
				VariableXQueryBuilder.this.variablePaths.put(variable, paths);
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(VariableXQueryBuilder.this.currentNode
								.getPathToRoot()
								+ " = \"" + property.getURI() + "\"");
			}
		}

		public void visit(OWLDataProperty property) {
			PathNode entityNode = VariableXQueryBuilder.this.currentNode
					.addChild(property
							.accept(VariableXQueryBuilder.this.vocabulary));
			PathNode uriChild = entityNode.addChild("@URI");
			VariableXQueryBuilder.this.currentNode = uriChild;
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(property)) {
				Variable variable = VariableXQueryBuilder.this.constraintSystem
						.getVariable(property.getURI());
				List<String> paths = VariableXQueryBuilder.this.variablePaths
						.get(variable);
				if (paths == null) {
					paths = new ArrayList<String>();
				}
				paths.add(VariableXQueryBuilder.this.currentNode
						.getPathToRoot());
				VariableXQueryBuilder.this.variablePaths.put(variable, paths);
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(VariableXQueryBuilder.this.currentNode
								.getPathToRoot()
								+ " = \"" + property.getURI() + "\"");
			}
		}

		public void visit(OWLIndividual individual) {
			PathNode entityNode = VariableXQueryBuilder.this.currentNode
					.addChild(individual
							.accept(VariableXQueryBuilder.this.vocabulary));
			PathNode uriChild = entityNode.addChild("@URI");
			VariableXQueryBuilder.this.currentNode = uriChild;
			if (VariableXQueryBuilder.this.constraintSystem
					.isVariable(individual)) {
				Variable variable = VariableXQueryBuilder.this.constraintSystem
						.getVariable(individual.getURI());
				List<String> paths = VariableXQueryBuilder.this.variablePaths
						.get(variable);
				if (paths == null) {
					paths = new ArrayList<String>();
				}
				paths.add(VariableXQueryBuilder.this.currentNode
						.getPathToRoot());
				VariableXQueryBuilder.this.variablePaths.put(variable, paths);
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(VariableXQueryBuilder.this.currentNode
								.getPathToRoot()
								+ " = \"" + individual.getURI() + "\"");
			}
		}

		public void visit(OWLDataType dataType) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(dataType
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
		}

		public void visit(OWLObjectPropertyInverse property) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(property
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			property.getInverseProperty().accept(this);
		}

		public void visit(OWLDataComplementOf node) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(node
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
			node.getDataRange().accept(this);
		}

		public void visit(OWLDataOneOf node) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(node
							.accept(VariableXQueryBuilder.this.vocabulary));
			Set<OWLConstant> values = node.getValues();
			for (OWLConstant constant : values) {
				VariableXQueryBuilder.this.currentNode = child;
				constant.accept(this);
			}
		}

		public void visit(OWLDataRangeRestriction node) {
			PathNode child = new PathNode(node
					.accept(VariableXQueryBuilder.this.vocabulary),
					VariableXQueryBuilder.this.currentNode);
			VariableXQueryBuilder.this.currentNode = child;
			node.getDataRange().accept(this);
		}

		public void visit(OWLTypedConstant node) {
			PathNode entityNode = VariableXQueryBuilder.this.currentNode
					.addChild(node
							.accept(VariableXQueryBuilder.this.vocabulary));
			PathNode uriChild = entityNode.addChild("text()");
			VariableXQueryBuilder.this.currentNode = uriChild;
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(node)) {
				Variable variable = VariableXQueryBuilder.this.constraintSystem
						.getVariable(node.getLiteral());
				List<String> paths = VariableXQueryBuilder.this.variablePaths
						.get(variable);
				if (paths == null) {
					paths = new ArrayList<String>();
				}
				paths.add(VariableXQueryBuilder.this.currentNode
						.getPathToRoot());
				VariableXQueryBuilder.this.variablePaths.put(variable, paths);
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(VariableXQueryBuilder.this.currentNode
								.getPathToRoot()
								+ " = \"" + node.getLiteral() + "\"");
			}
		}

		public void visit(OWLUntypedConstant node) {
			PathNode entityNode = VariableXQueryBuilder.this.currentNode
					.addChild(node
							.accept(VariableXQueryBuilder.this.vocabulary));
			PathNode uriChild = entityNode.addChild("text()");
			VariableXQueryBuilder.this.currentNode = uriChild;
			if (VariableXQueryBuilder.this.constraintSystem.isVariable(node)) {
				Variable variable = VariableXQueryBuilder.this.constraintSystem
						.getVariable(node.getLiteral());
				List<String> paths = VariableXQueryBuilder.this.variablePaths
						.get(variable);
				if (paths == null) {
					paths = new ArrayList<String>();
				}
				paths.add(VariableXQueryBuilder.this.currentNode
						.getPathToRoot());
				VariableXQueryBuilder.this.variablePaths.put(variable, paths);
			} else {
				VariableXQueryBuilder.this.whereConditions
						.add(VariableXQueryBuilder.this.currentNode
								.getPathToRoot()
								+ " = \"" + node.getLiteral() + "\"");
			}
		}

		public void visit(OWLDataRangeFacetRestriction node) {
			PathNode child = VariableXQueryBuilder.this.currentNode
					.addChild(node
							.accept(VariableXQueryBuilder.this.vocabulary));
			VariableXQueryBuilder.this.currentNode = child;
		}
	}

	protected final ConstraintSystem constraintSystem;
	private static final String OWLXML_NAMESPACE_ABBREVIATION = "owl2xml";
	protected PathNode currentNode;
	protected final OWLAxiomVocabulary vocabulary = new OWLAxiomVocabulary();
	private final PathExtractor pathExtractor = new PathExtractor();
	protected Map<Variable, List<String>> variablePaths = new HashMap<Variable, List<String>>();
	protected final List<String> whereConditions = new ArrayList<String>();
	private String axiomPath;
	private final String axiomName;

	private static final class OWLAxiomVocabulary implements
			OWLObjectVisitorEx<String> {
		public OWLAxiomVocabulary() {
		}

		public String visit(OWLSubClassAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":SubClassOf";
		}

		public String visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION
					+ ":NegativeObjectPropertyAssertion";
		}

		public String visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":AsymmetricObjectProperty";
		}

		public String visit(OWLReflexiveObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ReflexiveObjectProperty";
		}

		public String visit(OWLDisjointClassesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DisjointClasses";
		}

		public String visit(OWLDataPropertyDomainAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DisjointClasses";
		}

		public String visit(OWLImportsDeclaration axiom) {
			return "";
		}

		public String visit(OWLAxiomAnnotationAxiom axiom) {
			return "";
		}

		public String visit(OWLObjectPropertyDomainAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectPropertyDomain";
		}

		public String visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION
					+ ":EquivalentObjectProperties";
		}

		public String visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION
					+ ":NegativeDataPropertyAssertion";
		}

		public String visit(OWLDifferentIndividualsAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DifferentIndividuals";
		}

		public String visit(OWLDisjointDataPropertiesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DisjointDataProperties";
		}

		public String visit(OWLDisjointObjectPropertiesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DisjointObjectProperties";
		}

		public String visit(OWLObjectPropertyRangeAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectPropertyRange";
		}

		public String visit(OWLObjectPropertyAssertionAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectPropertyAssertion";
		}

		public String visit(OWLFunctionalObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":FunctionalObjectProperty";
		}

		public String visit(OWLObjectSubPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":SubObjectPropertyOf";
		}

		public String visit(OWLDisjointUnionAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DisjointUnion";
		}

		public String visit(OWLDeclarationAxiom axiom) {
			return "";
		}

		public String visit(OWLEntityAnnotationAxiom axiom) {
			return "";
		}

		public String visit(OWLOntologyAnnotationAxiom axiom) {
			return "";
		}

		public String visit(OWLSymmetricObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":SymmetricObjectProperty";
		}

		public String visit(OWLDataPropertyRangeAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataPropertyRange";
		}

		public String visit(OWLFunctionalDataPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":FunctionalDataProperty";
		}

		public String visit(OWLEquivalentDataPropertiesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":EquivalentDataProperties";
		}

		public String visit(OWLClassAssertionAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ClassAssertion";
		}

		public String visit(OWLEquivalentClassesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":EquivalentClasses";
		}

		public String visit(OWLDataPropertyAssertionAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataPropertyAssertion";
		}

		public String visit(OWLTransitiveObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":TransitiveObjectProperty";
		}

		public String visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION
					+ ":EquivalentObjectProperties";
		}

		public String visit(OWLDataSubPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":IrreflexiveObjectProperty";
		}

		public String visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION
					+ ":InverseFunctionalObjectProperty";
		}

		public String visit(OWLSameIndividualsAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":SameIndividual";
		}

		public String visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":PropertyChain";
		}

		public String visit(OWLInverseObjectPropertiesAxiom axiom) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":InverseObjectProperties";
		}

		public String visit(SWRLRule rule) {
			return "";
		}

		public String visit(OWLClass desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":Class";
		}

		public String visit(OWLObjectIntersectionOf desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectIntersectionOf";
		}

		public String visit(OWLObjectUnionOf desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectUnionOf";
		}

		public String visit(OWLObjectComplementOf desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectComplementOf";
		}

		public String visit(OWLObjectSomeRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectSomeValuesFrom";
		}

		public String visit(OWLObjectAllRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectSomeValuesFrom";
		}

		public String visit(OWLObjectValueRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectAllValuesFrom";
		}

		public String visit(OWLObjectMinCardinalityRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectMinCardinality";
		}

		public String visit(OWLObjectExactCardinalityRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectExactCardinality";
		}

		public String visit(OWLObjectMaxCardinalityRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectMaxCardinality";
		}

		public String visit(OWLObjectSelfRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectSelfRestriction";
		}

		public String visit(OWLObjectOneOf desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectOneOf";
		}

		public String visit(OWLDataSomeRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataSomeValuesFrom";
		}

		public String visit(OWLDataAllRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectSomeValuesFrom";
		}

		public String visit(OWLDataValueRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataAllValuesFrom";
		}

		public String visit(OWLDataMinCardinalityRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataMinCardinality";
		}

		public String visit(OWLDataExactCardinalityRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataExactCardinality";
		}

		public String visit(OWLDataMaxCardinalityRestriction desc) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataMaxCardinality";
		}

		public String visit(OWLDataType node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":Datatype";
		}

		public String visit(OWLDataComplementOf node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataComplementOf";
		}

		public String visit(OWLDataOneOf node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataOneOf";
		}

		public String visit(OWLDataRangeRestriction node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataPropertyRange";
		}

		public String visit(OWLTypedConstant node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":Literal";
		}

		public String visit(OWLUntypedConstant node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":Literal";
		}

		public String visit(OWLDataRangeFacetRestriction node) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DatatypeRestriction";
		}

		public String visit(OWLObjectProperty property) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":ObjectProperty";
		}

		public String visit(OWLObjectPropertyInverse property) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":InverseObjectProperty";
		}

		public String visit(OWLDataProperty property) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":DataProperty";
		}

		public String visit(OWLIndividual individual) {
			return OWLXML_NAMESPACE_ABBREVIATION + ":NamedIndividual";
		}

		public String visit(OWLObjectAnnotation annotation) {
			return "";
		}

		public String visit(OWLConstantAnnotation annotation) {
			return "";
		}

		public String visit(SWRLClassAtom node) {
			return "";
		}

		public String visit(SWRLDataRangeAtom node) {
			return "";
		}

		public String visit(SWRLObjectPropertyAtom node) {
			return "";
		}

		public String visit(SWRLDataValuedPropertyAtom node) {
			return "";
		}

		public String visit(SWRLBuiltInAtom node) {
			return "";
		}

		public String visit(SWRLAtomDVariable node) {
			return "";
		}

		public String visit(SWRLAtomIVariable node) {
			return "";
		}

		public String visit(SWRLAtomIndividualObject node) {
			return "";
		}

		public String visit(SWRLAtomConstantObject node) {
			return "";
		}

		public String visit(SWRLSameAsAtom node) {
			return "";
		}

		public String visit(SWRLDifferentFromAtom node) {
			return "";
		}

		public String visit(OWLOntology ontology) {
			return OWLXML_NAMESPACE_ABBREVIATION + "Ontology";
		}
	}

	private void initialisePaths(OWLAxiom axiom) {
		this.axiomPath = this.buildAxiomQuery(axiom);
		this.variablePaths.clear();
		this.whereConditions.clear();
		this.currentNode = new PathNode(this.axiomName, null);
	}

	public String visit(OWLSubClassAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getSubClass().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSuperClass().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSubject().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getObject().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLReflexiveObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLDisjointClassesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			this.currentNode = axiomNode;
			description.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLDataPropertyDomainAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getDomain().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLImportsDeclaration axiom) {
		return "";
	}

	public String visit(OWLAxiomAnnotationAxiom axiom) {
		return "";
	}

	public String visit(OWLObjectPropertyDomainAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getDomain().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			this.currentNode = axiomNode;
			objectPropertyExpression.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSubject().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getObject().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLDifferentIndividualsAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			this.currentNode = axiomNode;
			individual.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLDisjointDataPropertiesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			this.currentNode = axiomNode;
			dataPropertyExpression.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLDisjointObjectPropertiesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLObjectPropertyExpression> properties = axiom.getProperties();
		for (OWLObjectPropertyExpression objectPropertyExpression : properties) {
			this.currentNode = axiomNode;
			objectPropertyExpression.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLObjectPropertyRangeAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getRange().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLObjectPropertyAssertionAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSubject().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getObject().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLFunctionalObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLObjectSubPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getSubProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSuperProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLDisjointUnionAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			this.currentNode = axiomNode;
			description.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLDeclarationAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getEntity().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLEntityAnnotationAxiom axiom) {
		return "";
	}

	public String visit(OWLOntologyAnnotationAxiom axiom) {
		return "";
	}

	public String visit(OWLSymmetricObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLDataPropertyRangeAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getRange().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLFunctionalDataPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLEquivalentDataPropertiesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLDataPropertyExpression> properties = axiom.getProperties();
		for (OWLDataPropertyExpression dataPropertyExpression : properties) {
			this.currentNode = axiomNode;
			dataPropertyExpression.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLClassAssertionAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getDescription().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getIndividual().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLEquivalentClassesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLDescription> descriptions = axiom.getDescriptions();
		for (OWLDescription description : descriptions) {
			this.currentNode = axiomNode;
			description.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLDataPropertyAssertionAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSubject().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSubject().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLTransitiveObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLDataSubPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getSubProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSuperProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		axiom.getProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(OWLSameIndividualsAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		Set<OWLIndividual> individuals = axiom.getIndividuals();
		for (OWLIndividual individual : individuals) {
			this.currentNode = axiomNode;
			individual.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getSuperProperty().accept(this.pathExtractor);
		List<OWLObjectPropertyExpression> propertyChain = axiom
				.getPropertyChain();
		for (OWLObjectPropertyExpression objectPropertyExpression : propertyChain) {
			this.currentNode = axiomNode;
			objectPropertyExpression.accept(this.pathExtractor);
		}
		return this.axiomPath;
	}

	public String visit(OWLInverseObjectPropertiesAxiom axiom) {
		this.initialisePaths(axiom);
		PathNode axiomNode = this.currentNode;
		axiom.getFirstProperty().accept(this.pathExtractor);
		this.currentNode = axiomNode;
		axiom.getSecondProperty().accept(this.pathExtractor);
		return this.axiomPath;
	}

	public String visit(SWRLRule rule) {
		return "";
	}

	public List<String> getWhereConditions() {
		return new ArrayList<String>(this.whereConditions);
	}

	private String buildAxiomQuery(OWLAxiom axiom) {
		String toReturn = OWLXML_NAMESPACE_ABBREVIATION + ":Ontology/"
				+ axiom.accept(this.vocabulary);
		return toReturn;
	}

	public Map<Variable, List<String>> getVariablePaths() {
		Map<Variable, List<String>> toReturn = new HashMap<Variable, List<String>>(
				this.variablePaths);
		return toReturn;
	}

	public void visitInequalityConstraint(InequalityConstraint c) {
		final String variableReference = c.getVariable().getName().replace('?',
				'$');
		OWLObject expression = c.getExpression();
		if (expression instanceof OWLEntity) {
			((OWLEntity) expression).accept(new SpecializedOWLEntityVisitor2(
					variableReference));
		} else if (expression instanceof OWLConstant) {
			((OWLConstant) expression).accept(new MyDataVisitor(
					variableReference));
		}
	}

	public void visitInCollectionConstraint(InCollectionConstraint<?> c) {
		final String variableReference = c.getVariable().getName().replace('?',
				'$');
		final StringWriter writer = new StringWriter();
		writer.append("( ");
		Collection<? extends OWLObject> collection = c.getCollection();
		boolean first = true;
		for (OWLObject object : collection) {
			String andString = " ";
			if (!first) {
				andString = " or ";
			}
			first = first ? false : first;
			writer.append(andString);
			if (object instanceof OWLEntity) {
				((OWLEntity) object).accept(new SpecializedOWLEntityVisitor(
						writer, variableReference));
			} else if (object instanceof OWLConstant) {
				((OWLConstant) object).accept(new SpecializedOWLDataVisitor(
						variableReference, writer));
			}
		}
		writer.append(")");
		this.whereConditions.add(writer.toString());
	}

	public void visitInCollectionConstraint(InCollectionRegExpConstraint c) {
		final String variableReference = c.getVariable().getName().replace('?',
				'$');
		final StringWriter writer = new StringWriter();
		writer.append("( ");
		// XXX a bindingnode is needed here
		Collection<? extends OWLObject> collection = c.getCollection(null);
		boolean first = true;
		for (OWLObject object : collection) {
			String andString = " ";
			if (!first) {
				andString = " or ";
			}
			first = first ? false : first;
			writer.append(andString);
			if (object instanceof OWLEntity) {
				((OWLEntity) object).accept(new SpecializedOWLEntityVisitor(
						writer, variableReference));
			} else if (object instanceof OWLConstant) {
				((OWLConstant) object).accept(new SpecializedOWLDataVisitor(
						variableReference, writer));
			}
		}
		writer.append(")");
		this.whereConditions.add(writer.toString());
	}

	public void visit(NAFConstraint nafConstraint) {
		Logging.getMainLogger().log(Level.WARNING,
				"Unsuported kind of constraint " + nafConstraint.render());
	}
}
