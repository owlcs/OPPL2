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
package org.coode.oppl.bindingtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.Variable;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class LeafBrusher implements BindingVisitor {
	private Set<BindingNode> leaves = null;
	private final Map<Variable, Set<OWLObject>> bindings = new HashMap<Variable, Set<OWLObject>>();

	public LeafBrusher(Map<Variable, Set<OWLObject>> bindings) {
		if (bindings == null) {
			throw new NullPointerException("The bindings cannot be null");
		}
		this.bindings.putAll(bindings);
	}

	/**
	 * @see org.coode.oppl.bindingtree.BindingVisitor#visit(org.coode.oppl.bindingtree.BindingNode)
	 */
	public void visit(BindingNode bindingNode) {
		if (!bindingNode.isEmpty()) {
			Set<BindingNode> nodes = new HashSet<BindingNode>();
			nodes.add(bindingNode);
			boolean allLeaves = bindingNode.isLeaf();
			while (!allLeaves) {
				for (BindingNode generatedChild : new HashSet<BindingNode>(nodes)) {
					if (!generatedChild.isLeaf()) {
						nodes.remove(generatedChild);
						Set<BindingNode> generatedChildren = this.generateChildren(generatedChild);
						nodes.addAll(generatedChildren);
					}
					allLeaves = this.allLeaves(nodes);
				}
			}
			this.leaves = nodes;
		}
	}

	/**
	 * @param nodes
	 * @param allLeaves
	 * @return
	 */
	private boolean allLeaves(Set<BindingNode> nodes) {
		Iterator<BindingNode> it = nodes.iterator();
		BindingNode generatedChild;
		boolean allLeaves = true;
		while (allLeaves && it.hasNext()) {
			generatedChild = it.next();
			allLeaves = generatedChild.isLeaf();
		}
		return allLeaves;
	}

	/**
	 * @return the leaves
	 */
	public Set<BindingNode> getLeaves() {
		return this.leaves;
	}

	private Set<BindingNode> generateChildren(BindingNode node) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		if (!node.isLeaf()) {
			Set<Variable> unassignedVariables = node.getUnassignedVariables();
			for (Variable variable : unassignedVariables) {
				Set<OWLObject> values = this.getBindings().get(variable);
				if (values != null) {
					for (OWLObject owlObject : values) {
						Set<Variable> childUnassignedVariables = new HashSet<Variable>(
								unassignedVariables);
						childUnassignedVariables.remove(variable);
						Set<Assignment> childAssignements = new HashSet<Assignment>(
								node.getAssignments());
						childAssignements.add(new Assignment(variable, owlObject));
						toReturn.add(new BindingNode(childAssignements, childUnassignedVariables));
					}
				}
			}
		} else {
			toReturn.add(node);
		}
		return toReturn;
	}

	/**
	 * @return the bindings
	 */
	public Map<Variable, Set<OWLObject>> getBindings() {
		return this.bindings;
	}
}
