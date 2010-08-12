package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLObject;

public interface SingleValueGeneratedVariable<N> extends Variable {
	/**
	 * @return the OPPL function String serialisation
	 */
	public String getOPPLFunction();

	public String getArgumentString();

	public OWLObject getGeneratedOWLObject(BindingNode bindingNode);

	public SingleValueGeneratedValue<N> getValue();

	public void setValue(SingleValueGeneratedValue<N> value);

	public <P> SingleValueGeneratedVariable<P> replaceValue(
			SingleValueGeneratedValue<P> replaceValue);
}