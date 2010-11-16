package org.coode.oppl.function;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.variabletypes.VariableType;

public interface Aggregandum<I> {
	public Set<OPPLFunction<I>> getOPPLFunctions();

	public boolean isCompatible(VariableType<?> variableType);

	public String render(ConstraintSystem constraintSystem);
}
