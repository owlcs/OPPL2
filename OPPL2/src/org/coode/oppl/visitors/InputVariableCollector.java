package org.coode.oppl.visitors;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;

public class InputVariableCollector implements PlainVariableVisitor {
	private final List<Variable<?>> toReturn;

	public InputVariableCollector(List<Variable<?>> toReturn) {
		this.toReturn = toReturn;
	}

	public InputVariableCollector() {
		this(new ArrayList<Variable<?>>());
	}

	public <O extends OWLObject> void visit(GeneratedVariable<O> v) {
		// empty, does not return generated variables
	}

	public <O extends OWLObject> void visit(RegexpGeneratedVariable<O> regExpGenerated) {
	}

	public <O extends OWLObject> void visit(Variable<O> v) {
		this.toReturn.add(v);
	}

	public List<Variable<?>> getCollectedVariables() {
		return this.toReturn;
	}
}