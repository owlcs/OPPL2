package org.coode.oppl.datafactory;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public abstract class AbstractInlineSetAxiom<O extends OWLObject> {

    private final InlineSet<O> inlineSet;

    /**
     * @param inlineSet
     *        inlineSet
     */
    public AbstractInlineSetAxiom(InlineSet<O> inlineSet) {
        this.inlineSet = checkNotNull(inlineSet, "inlineSet");
    }

    /**
     * @return the inlineSet
     */
    public InlineSet<O> getInlineSet() {
        return this.inlineSet;
    }
}
