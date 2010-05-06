package org.coode.oppl.visitors;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.variablemansyntax.PlainVariableVisitor;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;

public class GeneratedVariableCollector implements PlainVariableVisitor {
	private final List<SingleValueGeneratedVariable<?>> toReturn;

	public GeneratedVariableCollector(
			List<SingleValueGeneratedVariable<?>> toReturn) {
		this.toReturn = toReturn;
	}

	public GeneratedVariableCollector() {
		this(new ArrayList<SingleValueGeneratedVariable<?>>());
	}

	public void visit(SingleValueGeneratedVariable<?> v) {
		this.toReturn.add(v);
	}

	@SuppressWarnings("unused")
	public void visit(Variable v) {
		// empty, does not return input variables
	}

	public List<SingleValueGeneratedVariable<?>> getCollectedVariables() {
		return this.toReturn;
	}
}