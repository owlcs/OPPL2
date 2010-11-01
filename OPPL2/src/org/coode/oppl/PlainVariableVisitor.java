package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;

public interface PlainVariableVisitor {
	void visit(Variable v);

	void visit(GeneratedVariable<?> v);

	void visit(RegexpGeneratedVariable<?> regExpGenerated);
}