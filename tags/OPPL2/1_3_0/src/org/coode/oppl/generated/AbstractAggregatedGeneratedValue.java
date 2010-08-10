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
package org.coode.oppl.generated;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.bindingtree.BindingNode;

/**
 * Aggregates several GeneratedValue instances into one
 * 
 * 
 * @author Luigi Iannone
 * 
 */
public abstract class AbstractAggregatedGeneratedValue<N> implements
		SingleValueGeneratedValue<N> {
	private final List<SingleValueGeneratedValue<N>> values2Aggregate;

	/**
	 * @param values
	 */
	protected AbstractAggregatedGeneratedValue(
			List<SingleValueGeneratedValue<N>> values) {
		this.values2Aggregate = values;
	}

	public List<N> computePossibleValues() {
		List<N> toReturn = new ArrayList<N>();
		ValueTree<N> tree = new ValueTree<N>(this.values2Aggregate);
		for (ValueTreeNode<N> leaf : tree.getLeaves()) {
			N aggregation = this.aggregateValues(leaf.assigned);
			toReturn.add(aggregation);
		}
		return toReturn;
	}

	public N getGeneratedValue(BindingNode node) {
		List<N> toAggregate = new ArrayList<N>();
		for (SingleValueGeneratedValue<N> value : this.values2Aggregate) {
			toAggregate.add(value.getGeneratedValue(node));
		}
		// if any of the items is null, then null should be returned
		// fixes a bug with StringGeneratedVariables when there is no assigned
		// variable yet
		for (N n : toAggregate) {
			if (n == null) {
				return null;
			}
		}
		return this.aggregateValues(toAggregate);
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		boolean first = true;
		for (SingleValueGeneratedValue<N> value2Aggregate : this.values2Aggregate) {
			String aggregator = first ? "" : this.getAggregatorSymbol() + " ";
			first = false;
			buffer.append(aggregator);
			buffer.append(value2Aggregate.toString());
		}
		return buffer.toString();
	}

	/**
	 * @return an aggregation of the values
	 * @see {@link AbstractAggregatedGeneratedValue#getValuesToAggregate()}
	 */
	protected abstract N aggregateValues(List<N> values);

	protected abstract String getAggregatorSymbol();

	// internals
	private static class ValueTreeNode<N> {
		protected final List<List<N>> toAssign;
		protected final List<N> assigned;

		ValueTreeNode(List<List<N>> toAssign, List<N> assigned) {
			this.toAssign = toAssign;
			this.assigned = assigned;
		}

		boolean isLeaf() {
			return this.toAssign.isEmpty();
		}

		@Override
		public String toString() {
			return "assigned: " + this.assigned.toString() + " to assign: "
					+ this.toAssign.toString();
		}
	}

	private static class ValueTree<N> {
		private final ValueTreeNode<N> rootNode;

		ValueTree(List<SingleValueGeneratedValue<N>> root) {
			List<List<N>> rootNode2Assign = new ArrayList<List<N>>();
			for (SingleValueGeneratedValue<N> generatedValue : root) {
				List<N> computePossibleValues = generatedValue
						.computePossibleValues();
				rootNode2Assign.add(computePossibleValues);
			}
			this.rootNode = new ValueTreeNode<N>(rootNode2Assign,
					new ArrayList<N>());
		}

		List<ValueTreeNode<N>> getLeaves() {
			List<ValueTreeNode<N>> nodes = new ArrayList<ValueTreeNode<N>>();
			nodes.add(this.rootNode);
			while (!this.allLeaves(nodes)) {
				for (ValueTreeNode<N> child : new ArrayList<ValueTreeNode<N>>(
						nodes)) {
					if (!child.isLeaf()) {
						nodes.remove(child);
						nodes.addAll(this.generateChildren(child));
					}
				}
			}
			return nodes;
		}

		private boolean allLeaves(List<ValueTreeNode<N>> nodes) {
			for (ValueTreeNode<N> aNode : nodes) {
				if (!aNode.isLeaf()) {
					return false;
				}
			}
			return true;
		}

		private List<ValueTreeNode<N>> generateChildren(ValueTreeNode<N> node) {
			List<ValueTreeNode<N>> toReturn = new ArrayList<ValueTreeNode<N>>();
			if (!node.isLeaf()) {
				List<List<N>> values2Assign = new ArrayList<List<N>>(
						node.toAssign);
				List<N> head = values2Assign.remove(0);
				for (N value : head) {
					List<List<N>> childUnassignedVariables = new ArrayList<List<N>>(
							values2Assign);
					List<N> assigned = node.assigned;
					List<N> childAssignements = new ArrayList<N>(assigned);
					childAssignements.add(value);
					toReturn.add(new ValueTreeNode<N>(childUnassignedVariables,
							childAssignements));
				}
			} else {
				toReturn.add(node);
			}
			return toReturn;
		}
	}

	/**
	 * @return the values2Aggregate
	 */
	public List<SingleValueGeneratedValue<N>> getValuesToAggregate() {
		return this.values2Aggregate;
	}
}
