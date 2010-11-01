package org.coode.oppl.visitors;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;

public class GeneratedVariableCollector implements PlainVariableVisitor {
	private final List<GeneratedVariable<?>> toReturn;

	public GeneratedVariableCollector(List<GeneratedVariable<?>> toReturn) {
		this.toReturn = toReturn;
	}

	public GeneratedVariableCollector() {
		this(new ArrayList<GeneratedVariable<?>>());
	}

	public void visit(GeneratedVariable<?> v) {
		this.toReturn.add(v);
	}

	public void visit(RegexpGeneratedVariable<?> regExpGenerated) {
	}

	public void visit(Variable v) {
		// empty, does not return input variables
	}

	public List<GeneratedVariable<?>> getCollectedVariables() {
		return new ArrayList<GeneratedVariable<?>>(this.toReturn);
	}
}