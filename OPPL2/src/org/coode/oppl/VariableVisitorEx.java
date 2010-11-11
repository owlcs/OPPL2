package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLObject;

public interface VariableVisitorEx<O> {
	<P extends OWLObject> O visit(InputVariable<P> v);

	<P extends OWLObject> O visit(GeneratedVariable<P> v);

	<P extends OWLObject> O visit(RegexpGeneratedVariable<P> regExpGenerated);
}