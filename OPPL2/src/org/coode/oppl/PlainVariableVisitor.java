package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;

public interface PlainVariableVisitor {
	<P extends OWLObject> void visit(Variable<P> v);

	<P extends OWLObject> void visit(GeneratedVariable<P> v);

	<P extends OWLObject> void visit(RegexpGeneratedVariable<P> regExpGenerated);
}