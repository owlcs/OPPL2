/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.INDIVIDUALVariableImpl;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

/**
 * @author Luigi Iannone
 * 
 */
public class INDIVIDUALGeneratedVariable extends GeneratedVariable<OWLNamedIndividual> {
	/**
	 * @param name
	 * @param opplFunction
	 */
	public INDIVIDUALGeneratedVariable(String name, OPPLFunction<OWLNamedIndividual> opplFunction) {
		super(name, opplFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new INDIVIDUALVariableImpl(name);
	}
}
