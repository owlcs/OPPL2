package org.coode.oppl;

import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.SingleValueGeneratedVariable;

public interface VariableVisitor<P extends Object> {
	P visit(Variable v);

	P visit(SingleValueGeneratedVariable<?> v);

	P visit(RegExpGenerated<?> v);
}