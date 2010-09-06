package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.variabletypes.CONSTANTVariableImpl;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

public class RegExpCONSTANTVariable extends CONSTANTVariableImpl implements
		RegExpGenerated<OWLConstant> {
	private RegExpDelegate<OWLConstant> delegate;

	public RegExpCONSTANTVariable(String name, RegExpGeneratedValue<OWLConstant> exp) {
		super(name);
		this.delegate = new RegExpDelegate<OWLConstant>(exp);
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

	public OWLConstant getGeneratedOWLObject(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObject(bindingNode);
	}

	public List<OWLConstant> getGeneratedOWLObjectCollection(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObjectCollection(bindingNode);
	}

	public RegExpGeneratedValue<OWLConstant> getValue() {
		return this.delegate.getValue();
	}

	public void setValue(SingleValueGeneratedValue<List<OWLConstant>> value) {
		this.delegate = new RegExpDelegate<OWLConstant>((RegExpGeneratedValue<OWLConstant>) value);
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

	public VariableIndexGeneratedValue<OWLConstant> getVariableIndexGeneratedVariable(int index) {
		return new VariableIndexGeneratedValue<OWLConstant>(this, index,
				this.delegate.getPossibleBindings());
	}
}
