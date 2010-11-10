package org.coode.oppl.visitors;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;

public class GeneratedVariableCollector implements PlainVariableVisitor {
	private final List<GeneratedVariable<?>> toReturn;

	public GeneratedVariableCollector(List<GeneratedVariable<?>> toReturn) {
		this.toReturn = toReturn;
	}

	public GeneratedVariableCollector() {
		this(new ArrayList<GeneratedVariable<?>>());
	}

	public <O extends OWLObject> void visit(GeneratedVariable<O> v) {
		this.toReturn.add(v);
	}

	public <O extends OWLObject> void visit(RegexpGeneratedVariable<O> regExpGenerated) {
	}

	public <O extends OWLObject> void visit(Variable<O> v) {
		// empty, does not return input variables
	}

	public List<GeneratedVariable<?>> getCollectedVariables() {
		return new ArrayList<GeneratedVariable<?>>(this.toReturn);
	}
}