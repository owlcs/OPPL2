/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.CONSTANTVariableImpl;
import org.semanticweb.owlapi.model.OWLLiteral;

/**
 * @author Luigi Iannone
 * 
 */
public class CONSTANTGeneratedVariable extends GeneratedVariable<OWLLiteral> {
	/**
	 * @param name
	 * @param opplFunction
	 */
	public CONSTANTGeneratedVariable(String name, OPPLFunction<OWLLiteral> opplFunction) {
		super(name, opplFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new CONSTANTVariableImpl(name);
	}
}
