package org.coode.oppl.function;

import java.util.Set;

import org.coode.oppl.Renderable;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.util.ShortFormProvider;

public interface Aggregandum<I> extends Renderable {
    Set<OPPLFunction<I>> getOPPLFunctions();

    boolean isCompatible(VariableType<?> variableType);

    String render(ShortFormProvider shortFormProvider);
}
