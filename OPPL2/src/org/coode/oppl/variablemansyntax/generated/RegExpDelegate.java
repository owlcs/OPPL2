package org.coode.oppl.variablemansyntax.generated;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

public class RegExpDelegate {
	private final RegExpGeneratedValue value;

	public RegExpDelegate(RegExpGeneratedValue v) {
		this.value = v;
	}

	public String getOPPLFunction() {
		return "Match(" + this.value + ")";
	}

	public String getArgumentString() {
		return this.value.toString();
	}

	protected OWLObject generateObject(OWLEntity v) {
		return v;
	}

	public OWLEntity getGeneratedOWLObject(BindingNode bindingNode) {
		Collection<OWLEntity> entities = this.value
				.getGeneratedValue(bindingNode);
		//XXX this requires a single result but it's really a set
		if (entities.size() > 0) {
			if (entities.size() > 1) {
				System.out
						.println("RegExpGeneratedVariable.getGeneratedOWLObject() incompleteness bug: only one result returned but more than one available: "
								+ entities);
			}
			return entities.iterator().next();
		}
		return null;
	}

	public Collection<OWLEntity> getGeneratedOWLObjectCollection(
			BindingNode bindingNode) {
		return this.value.getGeneratedValue(bindingNode);
	}

	public Set<OWLObject> getPossibleBindings() {
		return Collections.<OWLObject> unmodifiableSet(new HashSet<OWLEntity>(
				this.value.computePossibleValues().get(0)));
	}

	public RegExpGeneratedValue getValue() {
		return this.value;
	}

	public String toString(String s) {
		return s + "=" + this.getOPPLFunction();
	}
}
