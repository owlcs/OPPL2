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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.utils.ParserFactory;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntologyChange;
import org.semanticweb.owl.model.OWLOntologyChangeException;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableShortFormEntityChecker implements OWLEntityChecker {
	private static class CreatedAssignementTreeNode {
		private final Set<String> unassigned;
		private final Set<CreationAssignemnt> assignments;

		/**
		 * @param unassigned
		 * @param assignements
		 */
		public CreatedAssignementTreeNode(Set<String> unassigned,
				Set<CreationAssignemnt> assignements) {
			this.unassigned = new HashSet<String>(unassigned);
			this.assignments = new HashSet<CreationAssignemnt>(assignements);
		}

		/**
		 * @return true if there are not any unassigned created elements, false
		 *         otherwise
		 */
		public boolean isLeaf() {
			return this.unassigned.isEmpty();
		}

		/**
		 * @return the unassigned
		 */
		public Set<String> getUnassigned() {
			return this.unassigned;
		}

		/**
		 * @return the assignments
		 */
		public Set<CreationAssignemnt> getAssignments() {
			return this.assignments;
		}

		public Set<CreatedAssignementTreeNode> getLeaves() {
			Set<CreatedAssignementTreeNode> nodes = new HashSet<CreatedAssignementTreeNode>();
			nodes.add(this);
			boolean allLeaves = this.isLeaf();
			while (!allLeaves) {
				for (CreatedAssignementTreeNode generatedChild : new HashSet<CreatedAssignementTreeNode>(
						nodes)) {
					if (!generatedChild.isLeaf()) {
						nodes.remove(generatedChild);
						Set<CreatedAssignementTreeNode> generatedChildren = this
								.generateChildren(generatedChild);
						nodes.addAll(generatedChildren);
					}
					allLeaves = this.allLeaves(nodes);
				}
			}
			return nodes;
		}

		private Set<CreatedAssignementTreeNode> generateChildren(
				CreatedAssignementTreeNode node) {
			Set<CreatedAssignementTreeNode> toReturn = new HashSet<CreatedAssignementTreeNode>();
			if (!node.isLeaf()) {
				Set<String> unassignedElements = node.unassigned;
				for (String element : unassignedElements) {
					for (VariableType owlObject : VariableType.values()) {
						Set<String> childUnassignedElements = new HashSet<String>(
								unassignedElements);
						childUnassignedElements.remove(element);
						Set<CreationAssignemnt> childAssignements = new HashSet<CreationAssignemnt>(
								node.assignments);
						childAssignements.add(new CreationAssignemnt(element,
								owlObject));
						toReturn.add(new CreatedAssignementTreeNode(
								childUnassignedElements, childAssignements));
					}
				}
			} else {
				toReturn.add(node);
			}
			return toReturn;
		}

		/**
		 * @param nodes
		 * @param allLeaves
		 * @return
		 */
		private boolean allLeaves(Set<CreatedAssignementTreeNode> nodes) {
			Iterator<CreatedAssignementTreeNode> it = nodes.iterator();
			CreatedAssignementTreeNode generatedChild;
			boolean allLeaves = true;
			while (allLeaves && it.hasNext()) {
				generatedChild = it.next();
				allLeaves = generatedChild.isLeaf();
			}
			return allLeaves;
		}
	}

	private static class CreationAssignemnt {
		private final String name;
		private final VariableType type;

		/**
		 * @param name
		 * @param type
		 */
		public CreationAssignemnt(String name, VariableType type) {
			this.name = name;
			this.type = type;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * @return the type
		 */
		public VariableType getType() {
			return this.type;
		}

		@Override
		public String toString() {
			return this.name + " = " + this.type;
		}
	}

	private final ConstraintSystem constraintSystems;
	private final OWLEntityChecker simpleOWLEntityChecker;
	private final List<OWLOntologyChange> lastAdditions = new ArrayList<OWLOntologyChange>();
	private final Queue<Set<CreationAssignemnt>> assignementQueue = new LinkedList<Set<CreationAssignemnt>>();
	private final Map<String, OWLEntity> created = new HashMap<String, OWLEntity>();

	/**
	 * @param simpleOWLEntityChecker
	 * @param constraintSystems
	 */
	public VariableShortFormEntityChecker(
			OWLEntityChecker simpleOWLEntityChecker,
			ConstraintSystem constraintSystems) {
		this.simpleOWLEntityChecker = simpleOWLEntityChecker;
		this.constraintSystems = constraintSystems;
	}

	public OWLClass getOWLClass(String name) {
		OWLClass toReturn = null;
		if (name.startsWith("!")) {
			String entityName = name.substring(name.indexOf("!") + 1);
			OWLEntity createdEntity = this.created.get(entityName);
			if (createdEntity != null && createdEntity instanceof OWLClass) {
				toReturn = (OWLClass) createdEntity;
			} else if (createdEntity == null) {
				CreationAssignemnt creationAssignemnt = this.fetch(name);
				if (creationAssignemnt != null
						&& creationAssignemnt.getType().equals(
								VariableType.CLASS)) {
					try {
						toReturn = (OWLClass) this.create(entityName,
								VariableType.CLASS).getOWLEntity();
					} catch (OWLEntityCreationException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			toReturn = this.simpleOWLEntityChecker.getOWLClass(name);
			if (toReturn == null) {
				Variable variable = this.constraintSystems.getVariable(name);
				if (variable != null
						&& variable.getType().equals(VariableType.CLASS)) {
					toReturn = ParserFactory.getInstance().getOPPLFactory()
							.getOWLDataFactory().getOWLClass(variable.getURI());
				}
			}
		}
		return toReturn;
	}

	public OWLDataProperty getOWLDataProperty(String name) {
		OWLDataProperty toReturn = null;
		if (name.startsWith("!")) {
			String entityName = name.substring(name.indexOf("!") + 1);
			OWLEntity createdEntity = this.created.get(entityName);
			if (createdEntity != null
					&& createdEntity instanceof OWLDataProperty) {
				toReturn = (OWLDataProperty) createdEntity;
			} else if (createdEntity == null) {
				CreationAssignemnt creationAssignemnt = this.fetch(name);
				if (creationAssignemnt != null
						&& creationAssignemnt.getType().equals(
								VariableType.DATAPROPERTY)) {
					try {
						toReturn = (OWLDataProperty) this.create(entityName,
								VariableType.DATAPROPERTY).getOWLEntity();
					} catch (OWLEntityCreationException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			toReturn = this.simpleOWLEntityChecker.getOWLDataProperty(name);
			if (toReturn == null) {
				Variable variable = this.constraintSystems.getVariable(name);
				if (variable != null
						&& variable.getType().equals(VariableType.DATAPROPERTY)) {
					toReturn = ParserFactory.getInstance().getOPPLFactory()
							.getOWLDataFactory().getOWLDataProperty(
									variable.getURI());
				}
			}
		}
		return toReturn;
	}

	public OWLObjectProperty getOWLObjectProperty(String name) {
		OWLObjectProperty toReturn = null;
		if (name.startsWith("!")) {
			String entityName = name.substring(name.indexOf("!") + 1);
			OWLEntity createdEntity = this.created.get(entityName);
			if (createdEntity != null
					&& createdEntity instanceof OWLObjectProperty) {
				toReturn = (OWLObjectProperty) createdEntity;
			} else if (createdEntity == null) {
				CreationAssignemnt creationAssignemnt = this.fetch(name);
				if (creationAssignemnt != null
						&& creationAssignemnt.getType().equals(
								VariableType.OBJECTPROPERTY)) {
					try {
						toReturn = (OWLObjectProperty) this.create(entityName,
								VariableType.OBJECTPROPERTY).getOWLEntity();
					} catch (OWLEntityCreationException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			toReturn = this.simpleOWLEntityChecker.getOWLObjectProperty(name);
			if (toReturn == null) {
				Variable variable = this.constraintSystems.getVariable(name);
				if (variable != null
						&& variable.getType().equals(
								VariableType.OBJECTPROPERTY)) {
					toReturn = ParserFactory.getInstance().getOPPLFactory()
							.getOWLDataFactory().getOWLObjectProperty(
									variable.getURI());
				}
			}
		}
		return toReturn;
	}

	public OWLIndividual getOWLIndividual(String name) {
		OWLIndividual toReturn = null;
		if (name.startsWith("!")) {
			String entityName = name.substring(name.indexOf("!") + 1);
			OWLEntity createdEntity = this.created.get(entityName);
			if (createdEntity != null && createdEntity instanceof OWLIndividual) {
				toReturn = (OWLIndividual) createdEntity;
			} else if (createdEntity == null) {
				CreationAssignemnt creationAssignemnt = this.fetch(name);
				if (creationAssignemnt != null
						&& creationAssignemnt.getType().equals(
								VariableType.INDIVIDUAL)) {
					try {
						toReturn = (OWLIndividual) this.create(entityName,
								VariableType.INDIVIDUAL).getOWLEntity();
					} catch (OWLEntityCreationException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			toReturn = this.simpleOWLEntityChecker.getOWLIndividual(name);
			if (toReturn == null) {
				Variable variable = this.constraintSystems.getVariable(name);
				if (variable != null
						&& variable.getType().equals(VariableType.INDIVIDUAL)) {
					toReturn = ParserFactory.getInstance().getOPPLFactory()
							.getOWLDataFactory().getOWLIndividual(
									variable.getURI());
				}
			}
		}
		return toReturn;
	}

	public void applyAdditions() {
		try {
			if (this.lastAdditions != null && !this.lastAdditions.isEmpty()) {
				ParserFactory.getInstance().getOWLOntologyManager()
						.applyChanges(this.lastAdditions);
			}
		} catch (OWLOntologyChangeException e) {
			e.printStackTrace();
		}
	}

	public OWLDataType getOWLDataType(String name) {
		return this.simpleOWLEntityChecker.getOWLDataType(name);
	}

	public CreationAssignemnt fetch(String name) {
		Iterator<CreationAssignemnt> it = this.assignementQueue.element()
				.iterator();
		boolean found = false;
		VariableShortFormEntityChecker.CreationAssignemnt creationAssignement = null;
		CreationAssignemnt toReturn = null;
		while (!found && it.hasNext()) {
			creationAssignement = it.next();
			found = creationAssignement.getName().equals(name);
		}
		toReturn = found ? creationAssignement : null;
		return toReturn;
	}

	private OWLEntityCreationSet<? extends OWLEntity> create(String shortName,
			VariableType type) throws OWLEntityCreationException {
		Class<? extends OWLEntity> clazz = type.getOWLEntityClass();
		// switch (type) {
		// case CLASS:
		// clazz = OWLClass.class;
		// break;
		// case OBJECTPROPERTY:
		// clazz = OWLObjectProperty.class;
		// break;
		// case DATAPROPERTY:
		// clazz = OWLDataProperty.class;
		// break;
		// case INDIVIDUAL:
		// clazz = OWLIndividual.class;
		// break;
		// default:
		// break;
		// }
		OWLEntityCreationSet<? extends OWLEntity> toReturn = null;
		if (clazz != null) {
			org.coode.oppl.entity.OWLEntityFactory owlEntityFactory = ParserFactory
					.getInstance().getOPPLFactory().getOWLEntityFactory();
			toReturn = owlEntityFactory.createOWLEntity(clazz, shortName, null);
			this.created.put(shortName, toReturn.getOWLEntity());
			this.lastAdditions.addAll(toReturn.getOntologyChanges());
		}
		return toReturn;
	}

	/**
	 * Removes the current alternative for created element assignments
	 */
	public void discard() {
		if (!this.assignementQueue.isEmpty()) {
			this.created.clear();
			this.assignementQueue.remove();
		}
	}

	/**
	 * @return true if there are more alternatives for assigning the created
	 *         elements
	 */
	public boolean hasAlternatives() {
		return !this.assignementQueue.isEmpty();
	}

	public void generate(Set<String> createdElements) {
		CreatedAssignementTreeNode root = new CreatedAssignementTreeNode(
				createdElements, new HashSet<CreationAssignemnt>());
		Set<CreatedAssignementTreeNode> leaves = root.getLeaves();
		this.assignementQueue.clear();
		if (!createdElements.isEmpty()) {
			for (CreatedAssignementTreeNode leaf : leaves) {
				this.assignementQueue.add(leaf.getAssignments());
			}
		}
	}
}
