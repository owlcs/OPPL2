/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.VariableIndexGeneratedValue;

final class GroupAttributeSymbolFactory extends SingleValueGeneratedValueFactory<String> {
	private final String name;
	private final int index;

	GroupAttributeSymbolFactory(String name, int index) {
		assert name != null;
		assert index >= 0;
		this.name = name;
		this.index = index;
	}

	public SingleValueGeneratedValue<String> create(ConstraintSystem constraintSystem) {
		VariableIndexGeneratedValue<?> toReturn = null;
		Variable v = constraintSystem.getVariable(this.getOriginatingVariableName());
		if (v != null) {
			RegExpGenerated<?> gv = (RegExpGenerated<?>) v;
			toReturn = gv.getVariableIndexGeneratedVariable(this.index);
		}
		return toReturn;
	}

	private String getOriginatingVariableName() {
		String toReturn = this.getName();
		Pattern pattern = Pattern.compile("(.*)\\.GROUPS.*", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(this.getName());
		boolean matches = matcher.matches();
		if (matches) {
			toReturn = matcher.group(1);
		}
		return toReturn;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}