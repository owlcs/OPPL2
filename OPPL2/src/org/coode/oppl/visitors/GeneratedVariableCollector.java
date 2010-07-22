package org.coode.oppl.visitors;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.SingleValueGeneratedVariable;

public class GeneratedVariableCollector implements PlainVariableVisitor {
	private final List<SingleValueGeneratedVariable<?>> toReturn;

	public GeneratedVariableCollector(List<SingleValueGeneratedVariable<?>> toReturn) {
		this.toReturn = toReturn;
	}

	public GeneratedVariableCollector() {
		this(new ArrayList<SingleValueGeneratedVariable<?>>());
	}

	public void visit(SingleValueGeneratedVariable<?> v) {
		this.toReturn.add(v);
	}

	public void visit(RegExpGenerated<?> regExpGenerated) {
	}

	public void visit(Variable v) {
		// empty, does not return input variables
	}

	public List<SingleValueGeneratedVariable<?>> getCollectedVariables() {
		return new ArrayList<SingleValueGeneratedVariable<?>>(this.toReturn);
	}
}