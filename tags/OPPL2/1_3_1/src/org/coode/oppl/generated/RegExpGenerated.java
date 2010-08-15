package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owl.model.OWLObject;

public interface RegExpGenerated<P extends OWLObject> extends Variable {
	public RegExpGeneratedValue<P> getValue();

	public String getOPPLFunction();

	public P getGeneratedOWLObject(BindingNode bindingNode);

	public VariableIndexGeneratedValue<P> getVariableIndexGeneratedVariable(int index);

	public List<P> getGeneratedOWLObjectCollection(BindingNode bindingNode);
}