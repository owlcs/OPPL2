package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;

public interface VariableVisitor<P extends Object> {
	<O extends OWLObject> P visit(Variable<O> v);

	<O extends OWLObject> P visit(GeneratedVariable<O> v);

	<O extends OWLObject> P visit(RegexpGeneratedVariable<O> v);
}