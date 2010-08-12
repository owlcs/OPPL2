package org.coode.oppl.generated;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;

public class RegExpDelegate<O extends OWLObject> {
	private final RegExpGeneratedValue<O> value;

	public RegExpDelegate(RegExpGeneratedValue<O> v) {
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

	public O getGeneratedOWLObject(BindingNode bindingNode) {
		Collection<O> entities = this.value.getGeneratedValue(bindingNode);
		// XXX this requires a single result but it's really a set
		if (entities.size() > 0) {
			if (entities.size() > 1) {
				System.out.println("RegExpGeneratedVariable.getGeneratedOWLObject() incompleteness bug: only one result returned but more than one available: "
						+ entities);
			}
			return entities.iterator().next();
		}
		return null;
	}

	public List<O> getGeneratedOWLObjectCollection(BindingNode bindingNode) {
		return this.value.getGeneratedValue(bindingNode);
	}

	public Set<O> getPossibleBindings() {
		return Collections.<O> unmodifiableSet(new HashSet<O>(
				this.value.computePossibleValues().get(0)));
	}

	public RegExpGeneratedValue<O> getValue() {
		return this.value;
	}

	public String toString(String s) {
		return s + "=" + this.getOPPLFunction();
	}
}
