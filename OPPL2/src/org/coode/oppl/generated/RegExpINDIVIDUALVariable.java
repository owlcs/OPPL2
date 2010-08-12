package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;

public class RegExpINDIVIDUALVariable extends INDIVIDUALVariableImpl implements
		RegExpGenerated<OWLIndividual> {
	private RegExpDelegate<OWLIndividual> delegate;

	public RegExpINDIVIDUALVariable(String name, RegExpGeneratedValue<OWLIndividual> exp) {
		super(name);
		this.delegate = new RegExpDelegate<OWLIndividual>(exp);
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

	public OWLIndividual getGeneratedOWLObject(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObject(bindingNode);
	}

	public List<OWLIndividual> getGeneratedOWLObjectCollection(BindingNode bindingNode) {
		return this.delegate.getGeneratedOWLObjectCollection(bindingNode);
	}

	public RegExpGeneratedValue<OWLIndividual> getValue() {
		return this.delegate.getValue();
	}

	public void setValue(SingleValueGeneratedValue<List<OWLIndividual>> value) {
		this.delegate = new RegExpDelegate<OWLIndividual>(
				(RegExpGeneratedValue<OWLIndividual>) value);
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

	public VariableIndexGeneratedValue<OWLIndividual> getVariableIndexGeneratedVariable(int index) {
		return new VariableIndexGeneratedValue<OWLIndividual>(this, index,
				this.delegate.getPossibleBindings());
	}
}
