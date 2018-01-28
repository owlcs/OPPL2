package org.coode.oppl.function;

import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.Renderable;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 * @param <I> type
 */
public interface Aggregandum<I> extends Renderable {

    /**
     * @return oppl functions
     * @deprecated use the stream version
     */
    @Deprecated
    Set<OPPLFunction<I>> getOPPLFunctions();

    /**
     * @return oppl functions
     */
    Stream<OPPLFunction<I>> opplFunctions();

    /**
     * @param variableType variableType
     * @return true if compatible
     */
    boolean isCompatible(VariableType<?> variableType);

    /**
     * @param shortFormProvider shortFormProvider
     * @return rendering
     */
    String render(ShortFormProvider shortFormProvider);
}
