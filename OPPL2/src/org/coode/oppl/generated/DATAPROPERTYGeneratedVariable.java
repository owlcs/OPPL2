/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLDataProperty;

/**
 * @author Luigi Iannone
 * 
 */
public class DATAPROPERTYGeneratedVariable extends GeneratedVariable<OWLDataProperty> {
	/**
	 * @param name
	 * @param opplFunction
	 */
	public DATAPROPERTYGeneratedVariable(String name, OPPLFunction<OWLDataProperty> opplFunction) {
		super(name, opplFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new DATAPROPERTYVariableImpl(name);
	}
}
