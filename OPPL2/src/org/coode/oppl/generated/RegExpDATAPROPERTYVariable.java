package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;

public class RegExpDATAPROPERTYVariable extends DATAPROPERTYVariableImpl implements
		RegExpGenerated<OWLDataProperty> {
	private RegExpDelegate<OWLDataProperty> delegate;

	public RegExpDATAPROPERTYVariable(String name, RegExpGeneratedValue<OWLDataProperty> exp) {
		super(name);
		this.delegate = new RegExpDelegate<OWLDataProperty>(exp);
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

	public OWLDataProperty getGeneratedOWLObject(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObject(bindingNode);
	}

	public List<OWLDataProperty> getGeneratedOWLObjectCollection(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObjectCollection(bindingNode);
	}

	public RegExpGeneratedValue<OWLDataProperty> getValue() {
		return this.delegate.getValue();
	}

	public void setValue(SingleValueGeneratedValue<List<OWLDataProperty>> value) {
		this.delegate = new RegExpDelegate<OWLDataProperty>(
				(RegExpGeneratedValue<OWLDataProperty>) value);
	}

	public <P> SingleValueGeneratedVariable<P> replaceValue(
			SingleValueGeneratedValue<P> replaceValue) {
		return null;
	}

	@Override
	public <P> P accept(VariableVisitor<P> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.delegate.toString(super.toString());
	}

	public VariableIndexGeneratedValue<OWLDataProperty> getVariableIndexGeneratedVariable(int index) {
		return new VariableIndexGeneratedValue<OWLDataProperty>(this, index,
				this.delegate.getPossibleBindings());
	}
}
