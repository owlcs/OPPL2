package org.coode.oppl.generated;

import java.util.List;

import org.coode.oppl.Variable;
import org.semanticweb.owl.model.OWLObject;

public interface AttributeGenerator<N> {
	/**
	 * @author Luigi Iannone
	 * 
	 */
	List<N> getValues(Variable aVariable);

	N getValue(OWLObject object);
}