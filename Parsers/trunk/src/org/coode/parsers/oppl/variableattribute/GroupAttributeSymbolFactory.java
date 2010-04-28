/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.RegExpGenerated;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.VariableIndexGeneratedValue;
import org.semanticweb.owl.model.OWLObject;

final class GroupAttributeSymbolFactory extends SingleValueGeneratedValueFactory<String> {
	private final String name;
	private final int index;

	GroupAttributeSymbolFactory(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public SingleValueGeneratedValue<String> create(ConstraintSystem constraintSystem) {
		VariableIndexGeneratedValue toReturn = null;
		Variable v = constraintSystem.getVariable(this.getOriginatingVariableName());
		if (v != null) {
			RegExpGenerated gv = (RegExpGenerated) v;
			Set<OWLObject> bindings = gv.getPossibleBindings();
			if (bindings.size() > 0) {
				toReturn = new VariableIndexGeneratedValue(gv, this.index, bindings);
			}
		}
		return toReturn;
	}

	private String getOriginatingVariableName() {
		String toReturn = this.name;
		Pattern pattern = Pattern.compile("(.*)\\.GROUPS.*", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(this.name);
		boolean matches = matcher.matches();
		if (matches) {
			toReturn = matcher.group(1);
		}
		return toReturn;
	}
}