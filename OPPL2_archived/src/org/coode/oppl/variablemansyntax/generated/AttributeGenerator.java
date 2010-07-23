package org.coode.oppl.variablemansyntax.generated;

import java.util.List;

import org.coode.oppl.variablemansyntax.Variable;
import org.semanticweb.owl.model.OWLObject;

public interface AttributeGenerator<N> {
	/**
	 * @author Luigi Iannone
	 * 
	 */
	List<N> getValues(Variable aVariable);

	N getValue(OWLObject object);
}