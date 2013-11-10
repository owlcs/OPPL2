package org.coode.oppl.function;

import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Renderable;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.util.ShortFormProvider;

public interface Aggregandum<I> extends Renderable {
    public Set<OPPLFunction<I>> getOPPLFunctions();

    public boolean isCompatible(VariableType<?> variableType);

    public String render(ConstraintSystem constraintSystem);

    public String render(ShortFormProvider shortFormProvider);
}
