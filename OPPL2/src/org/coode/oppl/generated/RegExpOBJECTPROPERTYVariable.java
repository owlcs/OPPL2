package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class RegExpOBJECTPROPERTYVariable extends OBJECTPROPERTYVariableImpl implements
		RegExpGenerated<OWLObjectProperty> {
	private RegExpDelegate<OWLObjectProperty> delegate;

	public RegExpOBJECTPROPERTYVariable(String name, RegExpGeneratedValue<OWLObjectProperty> exp) {
		super(name);
		this.delegate = new RegExpDelegate<OWLObjectProperty>(exp);
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

	public OWLObjectProperty getGeneratedOWLObject(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObject(bindingNode);
	}

	public List<OWLObjectProperty> getGeneratedOWLObjectCollection(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObjectCollection(bindingNode);
	}

	public RegExpGeneratedValue<OWLObjectProperty> getValue() {
		return this.delegate.getValue();
	}

	public void setValue(SingleValueGeneratedValue<List<OWLObjectProperty>> value) {
		this.delegate = new RegExpDelegate<OWLObjectProperty>(
				(RegExpGeneratedValue<OWLObjectProperty>) value);
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
	public <P> P accept(VariableVisitor<P> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.delegate.toString(super.toString());
	}

	public VariableIndexGeneratedValue<OWLObjectProperty> getVariableIndexGeneratedVariable(
			int index) {
		return new VariableIndexGeneratedValue<OWLObjectProperty>(this, index,
				this.delegate.getPossibleBindings());
	}
}
