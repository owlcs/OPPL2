package org.coode.oppl.variablemansyntax;

import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;

public interface PlainVariableVisitor {
	void visit(Variable v);

	void visit(SingleValueGeneratedVariable<?> v);
}