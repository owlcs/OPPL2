package org.coode.oppl;

import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.SingleValueGeneratedVariable;

public interface PlainVariableVisitor {
	void visit(Variable v);

	void visit(SingleValueGeneratedVariable<?> v);

	void visit(RegExpGenerated<?> regExpGenerated);
}