package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone
 * @param <O> */
public interface VariableVisitorEx<O> {
    /** @param v
     * @return visitor value */
    <P extends OWLObject> O visit(InputVariable<P> v);

    /** @param v
     * @return visitor value */
    <P extends OWLObject> O visit(GeneratedVariable<P> v);

    /** @param regExpGenerated
     * @return visitor value */
    <P extends OWLObject> O visit(RegexpGeneratedVariable<P> regExpGenerated);
}
