package org.coode.oppl;

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public interface VariableVisitor {
    /** @param v */
    <P extends OWLObject> void visit(InputVariable<P> v);

    /** @param v */
    <P extends OWLObject> void visit(GeneratedVariable<P> v);

    /** @param regExpGenerated */
    <P extends OWLObject> void visit(RegexpGeneratedVariable<P> regExpGenerated);
}
