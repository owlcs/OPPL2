package org.coode.oppl.visitors;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.SingleValueGeneratedVariable;

public class InputVariableCollector implements PlainVariableVisitor {
	private final List<Variable> toReturn;

	public InputVariableCollector(List<Variable> toReturn) {
		this.toReturn = toReturn;
	}

	public InputVariableCollector() {
		this(new ArrayList<Variable>());
	}

	public void visit(SingleValueGeneratedVariable<?> v) {
		// empty, does not return generated variables
	}

	public void visit(RegExpGenerated<?> regExpGenerated) {
	}

	public void visit(Variable v) {
		this.toReturn.add(v);
	}

	public List<Variable> getCollectedVariables() {
		return this.toReturn;
	}
}