package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.variabletypes.CONSTANTVariableImpl;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;

public class RegExpCONSTANTVariable extends CONSTANTVariableImpl implements
		RegExpGenerated<OWLLiteral> {
	private RegExpDelegate<OWLLiteral> delegate;

	public RegExpCONSTANTVariable(String name, RegExpGeneratedValue<OWLLiteral> exp) {
		super(name);
		this.delegate = new RegExpDelegate<OWLLiteral>(exp);
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

	public OWLLiteral getGeneratedOWLObject(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObject(bindingNode);
	}

	public List<OWLLiteral> getGeneratedOWLObjectCollection(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObjectCollection(bindingNode);
	}

	public RegExpGeneratedValue<OWLLiteral> getValue() {
		return this.delegate.getValue();
	}

	public void setValue(SingleValueGeneratedValue<List<OWLLiteral>> value) {
		this.delegate = new RegExpDelegate<OWLLiteral>((RegExpGeneratedValue<OWLLiteral>) value);
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

	public VariableIndexGeneratedValue<OWLLiteral> getVariableIndexGeneratedVariable(int index) {
		return new VariableIndexGeneratedValue<OWLLiteral>(this, index,
				this.delegate.getPossibleBindings());
	}
}
