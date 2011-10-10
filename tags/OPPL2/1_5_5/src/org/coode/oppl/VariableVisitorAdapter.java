package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLObject;

public abstract class VariableVisitorAdapter implements VariableVisitor {
	public <P extends OWLObject> void visit(InputVariable<P> v) {
	}

	public <P extends OWLObject> void visit(GeneratedVariable<P> v) {
	}

	public <P extends OWLObject> void visit(RegexpGeneratedVariable<P> regExpGenerated) {
	}
}
