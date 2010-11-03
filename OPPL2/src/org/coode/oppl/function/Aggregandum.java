package org.coode.oppl.function;

import java.util.Set;

public interface Aggregandum<I> {
	public Set<OPPLFunction<? extends I>> getOPPLFunctions();
}
