/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.CLASSVariableImpl;
import org.semanticweb.owlapi.model.OWLClassExpression;

/**
 * @author Luigi Iannone
 * 
 */
public class CLASSGeneratedVariable extends GeneratedVariable<OWLClassExpression> {
	/**
	 * @param name
	 * @param opplFunction
	 */
	public CLASSGeneratedVariable(String name,
			OPPLFunction<? extends OWLClassExpression> opplFunction) {
		super(name, opplFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new CLASSVariableImpl(name);
	}
}
