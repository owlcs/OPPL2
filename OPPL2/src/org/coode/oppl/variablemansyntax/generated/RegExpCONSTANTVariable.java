package org.coode.oppl.variablemansyntax.generated;

import java.util.Collection;
import java.util.Set;

import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.variabletypes.CONSTANTVariableImpl;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

public class RegExpCONSTANTVariable extends CONSTANTVariableImpl implements
		RegExpGenerated {
	private RegExpDelegate delegate;

	public RegExpCONSTANTVariable(String name, RegExpGeneratedValue exp) {
		super(name);
		this.delegate = new RegExpDelegate(exp);
	}

	public String getOPPLFunction() {
		return this.delegate.getOPPLFunction();
	}

	public String getArgumentString() {
		return this.delegate.getArgumentString();
	}

	protected OWLObject generateObject(OWLEntity v) {
		return this.delegate.generateObject(v);
	}

	public OWLEntity getGeneratedOWLObject(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObject(bindingNode);
	}

	public Collection<OWLEntity> getGeneratedOWLObjectCollection(
			BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObjectCollection(bindingNode);
	}

	@Override
	public Set<OWLObject> getPossibleBindings() {
		return this.delegate.getPossibleBindings();
	}

	public RegExpGeneratedValue getValue() {
		return this.delegate.getValue();
	}

	public void setValue(SingleValueGeneratedValue<Collection<OWLEntity>> value) {
		this.delegate = new RegExpDelegate((RegExpGeneratedValue) value);
	}

	public <P> SingleValueGeneratedVariable<P> replaceValue(
			SingleValueGeneratedValue<P> replaceValue) {
		return null;
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.delegate.toString(super.toString());
	}
}
