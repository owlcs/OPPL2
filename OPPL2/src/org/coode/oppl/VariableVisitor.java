package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;

public interface VariableVisitor<P extends Object> {
	P visit(Variable v);

	P visit(GeneratedVariable<?> v);

	P visit(RegexpGeneratedVariable<?> v);
}