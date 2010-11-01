/**
 * 
 */
package org.coode.oppl.generated;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * @author Luigi Iannone
 * 
 */
public class OBJECTPROPERTYGeneratedVariable extends GeneratedVariable<OWLObjectProperty> {
	/**
	 * @param name
	 * @param opplFunction
	 */
	public OBJECTPROPERTYGeneratedVariable(String name, OPPLFunction<OWLObjectProperty> opplFunction) {
		super(name, opplFunction);
	}

	@Override
	protected Variable initDelegate(String name) {
		return new OBJECTPROPERTYVariableImpl(name);
	}
}
