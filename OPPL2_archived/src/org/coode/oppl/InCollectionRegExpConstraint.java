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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

/**
 * Constraint that verifies whether a variable values are contained in a
 * collection
 * 
 * @author Luigi Iannone
 * 
 */
public class InCollectionRegExpConstraint implements AbstractConstraint {
	private final Variable variable;
	private final Map<OWLEntity, List<String>> collection = new HashMap<OWLEntity, List<String>>();
	private final SingleValueGeneratedValue<String> expression;
	private ConstraintSystem cs;
	private final WeakHashMap<String, Collection<OWLEntity>> cache = new WeakHashMap<String, Collection<OWLEntity>>();

	/**
	 * @param variable
	 * @param collection
	 * @param constraintSystem
	 */
	public InCollectionRegExpConstraint(Variable variable,
			SingleValueGeneratedValue<String> exp, ConstraintSystem cs) {
		this.variable = variable;
		this.cs = cs;
		this.expression = exp;
	}

	private Map<OWLEntity, List<String>> getMatches(String exp) {
		Map<OWLEntity, List<String>> toReturn = new HashMap<OWLEntity, List<String>>();
		Pattern regExpression = Pattern.compile(exp);
		OWLEntityRenderer entityRenderer = ParserFactory.getInstance()
				.getOPPLFactory().getOWLEntityRenderer(this.cs);
		for (OWLObject o : this.variable.getType().getReferencedValues(
				this.cs.getOntology())) {
			if (o instanceof OWLEntity) {
				OWLEntity e = (OWLEntity) o;
				String toMatch = entityRenderer.render(e);
				List<String> group = RegExpGeneratedValue.actualMatch(
						regExpression, toMatch);
				if (group.size() > 0) {
					toReturn.put(e, group);
				}
			}
		}
		return toReturn;
	}

	/**
	 * Visitor pattern required method
	 * 
	 * @return the specific output of the visit (dependent on the implementation
	 *         of the visitor input instance)
	 * @see org.coode.oppl.AbstractConstraint#accept(org.coode.oppl.ConstraintVisitorEx)
	 */
	public <O> O accept(ConstraintVisitorEx<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return this.variable;
	}

	/**
	 * @return the collection
	 */
	public Collection<OWLEntity> getCollection(BindingNode node) {
		String regexp = this.expression.getGeneratedValue(node);
		if (regexp == null) {
			return Collections.emptyList();
		}
		if (!this.cache.containsKey(regexp)) {
			Map<OWLEntity, List<String>> matches = this.getMatches(regexp);
			this.collection.putAll(matches);
			this.cache.put(regexp, this.collection.keySet());
		}
		return this.cache.get(regexp);
	}

	@Override
	public int hashCode() {
		return 3 * this.variable.hashCode() * 5
				* this.collection.keySet().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean toReturn = false;
		if (obj instanceof InCollectionRegExpConstraint) {
			InCollectionRegExpConstraint toCompare = (InCollectionRegExpConstraint) obj;
			toReturn = this.getVariable().equals(toCompare.variable)
					&& this.expression.equals(toCompare.expression);
		}
		return toReturn;
	}

	@Override
	public String toString() {
		return this.variable.getName() + " Match(" + this.expression + ")";
	}

	public String render() {
		return this.toString();
	}

	public void accept(ConstraintVisitor visitor) {
		visitor.visitInCollectionConstraint(this);
	}
}
