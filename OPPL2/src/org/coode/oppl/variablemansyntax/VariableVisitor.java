package org.coode.oppl.variablemansyntax;

import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;

public interface VariableVisitor<P extends Object> {
	P visit(Variable v);

	P visit(SingleValueGeneratedVariable<?> v);
}