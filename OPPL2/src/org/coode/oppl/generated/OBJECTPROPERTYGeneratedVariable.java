/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/**
 * @author Luigi Iannone
 * 
 */
public class OBJECTPROPERTYGeneratedVariable extends GeneratedVariable<OWLObjectPropertyExpression> {
	/**
	 * @param name
	 * @param opplFunction
	 */
	public OBJECTPROPERTYGeneratedVariable(String name,
			OPPLFunction<? extends OWLObjectPropertyExpression> opplFunction) {
		super(name, opplFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new OBJECTPROPERTYVariableImpl(name);
	}
}
