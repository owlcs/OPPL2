package org.coode.oppl.variablemansyntax.generated.factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.Attribute;
import org.coode.oppl.variablemansyntax.generated.VariableGeneratedValue;
import org.semanticweb.owl.model.OWLObject;

public class AttributeFactory {
	private static final Set<VariableType> acceptedTypes = new HashSet<VariableType>(
			Arrays.asList(VariableType.CLASS, VariableType.OBJECTPROPERTY,
					VariableType.DATAPROPERTY, VariableType.INDIVIDUAL,
					VariableType.CONSTANT));

	public static AbstractCollectionGeneratedValue<OWLObject> getCollectionGeneratedValue(
			Attribute a, Variable v, ConstraintSystem c) {
		if (acceptedTypes.contains(v.getType())) {
			return new OWLObjectCollectionGeneratedValue(v, a, c, c);
		}
		return null;
	}

	public static VariableGeneratedValue<String> getVariableGeneratedValue(
			Attribute a, Variable v, ConstraintSystem c) {
		return new RenderingVariableGeneratedValue(v, a, c);
	}
}
