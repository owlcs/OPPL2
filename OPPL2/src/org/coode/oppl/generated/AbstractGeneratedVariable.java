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

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class AbstractGeneratedVariable<N> implements SingleValueGeneratedVariable<N> {
	protected final String name;
	protected final VariableType type;
	protected SingleValueGeneratedValue<N> value;

	/**
	 * @param name
	 * @param type
	 * @param value
	 */
	protected AbstractGeneratedVariable(String name, VariableType type,
			SingleValueGeneratedValue<N> value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.GeneratedVariable#getName()
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.GeneratedVariable#getType()
	 */
	public VariableType getType() {
		return this.type;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.GeneratedVariable.getIRI()
	 */
	public IRI getIRI() {
		return IRI.create(URI.create(ManchesterVariableSyntax.NAMESPACE + this.getName()));
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.GeneratedVariable#getVariableScope()
	 */
	public VariableScope<?> getVariableScope() {
		return null;
	}

	/**
	 * @see org.coode.oppl.variablemansyntax.GeneratedVariable#setVariableScope(org.coode.oppl.VariableScope,
	 *      org.coode.oppl.VariableScopeChecker)
	 */
	public void setVariableScope(VariableScope<?> variableScope,
			VariableScopeChecker variableScopeChecker) {
	}

	public boolean addPossibleBinding(OWLObject object) throws OWLRuntimeException {
		return Boolean.FALSE;
	}

	public void clearBindings() {
	}

	public Set<OWLObject> getPossibleBindings() {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		for (N value1 : this.value.computePossibleValues()) {
			toReturn.add(this.generateObject(value1));
		}
		return toReturn;
	}

	public Set<OWLObject> getPossibleBindings(BindingNode node) {
		// node is not used in this kind of variable
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		for (N value1 : this.value.computePossibleValues()) {
			toReturn.add(this.generateObject(value1));
		}
		return toReturn;
	}

	/**
	 * @param bindingNode
	 * @return the OWLObject that is generated as value for this Variable for
	 *         the input BindingNode, it may return null
	 */
	public OWLObject getGeneratedOWLObject(BindingNode bindingNode) {
		N generatedValue = this.value.getGeneratedValue(bindingNode);
		return generatedValue == null ? null : this.generateObject(generatedValue);
	}

	protected abstract OWLObject generateObject(N v);

	public boolean removePossibleBinding(OWLObject o) {
		return false;
	}

	public <P> P accept(VariableVisitor<P> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the value
	 */
	public SingleValueGeneratedValue<N> getValue() {
		return this.value;
	}

	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	protected abstract SingleValueGeneratedVariable<N> replace(SingleValueGeneratedValue<N> value1);

	@SuppressWarnings("unchecked")
	public <P> SingleValueGeneratedVariable<P> replaceValue(
			SingleValueGeneratedValue<P> replaceValue) {
		return (SingleValueGeneratedVariable<P>) this.replace((SingleValueGeneratedValue<N>) replaceValue);
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(SingleValueGeneratedValue<N> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getName() + ":" + this.getType() + " = " + this.getOPPLFunction();
	}
}
