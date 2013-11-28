package org.coode.oppl.function;

import java.util.Set;

import org.coode.oppl.Renderable;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone
 * @param <I> */
public interface Aggregandum<I> extends Renderable {
    /** @return oppl functions */
    Set<OPPLFunction<I>> getOPPLFunctions();

    /** @param variableType
     * @return true if compatible */
    boolean isCompatible(VariableType<?> variableType);

    /** @param shortFormProvider
     * @return rendering */
    String render(ShortFormProvider shortFormProvider);
}
