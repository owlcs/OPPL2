package org.coode.oppl.datafactory;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

public abstract class AbstractInlineSetAxiom<O extends OWLObject> {
	private final InlineSet<O> inlineSet;

	public AbstractInlineSetAxiom(InlineSet<O> inlineSet) {
		if (inlineSet == null) {
			throw new NullPointerException("The inline set cannot be null");
		}
		this.inlineSet = inlineSet;
	}

	/**
	 * @return the inlineSet
	 */
	public InlineSet<O> getInlineSet() {
		return this.inlineSet;
	}
}
