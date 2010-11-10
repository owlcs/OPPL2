package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;

public interface PlainVariableVisitorEx<O> {
	<P extends OWLObject> O visit(Variable<P> v);

	<P extends OWLObject> O visit(GeneratedVariable<P> v);

	<P extends OWLObject> O visit(RegexpGeneratedVariable<P> regExpGenerated);
}