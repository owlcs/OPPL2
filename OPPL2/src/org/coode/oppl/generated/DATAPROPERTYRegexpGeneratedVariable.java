package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableImpl;
import org.semanticweb.owlapi.model.OWLDataProperty;

public class DATAPROPERTYRegexpGeneratedVariable extends
		RegexpGeneratedVariable<OWLDataProperty> {
	/**
	 * @param name
	 * @param type
	 * @param pattern
	 */
	public DATAPROPERTYRegexpGeneratedVariable(String name, VariableType type,
			Pattern pattern) {
		super(name, VariableType.DATAPROPERTY, pattern);
	}

	@Override
	protected Variable initDelegate() {
		return new DATAPROPERTYVariableImpl(this.getName());
	}
}
