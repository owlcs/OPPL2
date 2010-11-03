package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;

public interface PlainVariableVisitorEx<O> {
	O visit(Variable v);

	O visit(GeneratedVariable<?> v);

	O visit(RegexpGeneratedVariable<?> regExpGenerated);
}