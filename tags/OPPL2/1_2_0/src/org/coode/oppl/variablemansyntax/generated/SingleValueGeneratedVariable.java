package org.coode.oppl.variablemansyntax.generated;

import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.semanticweb.owl.model.OWLObject;

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