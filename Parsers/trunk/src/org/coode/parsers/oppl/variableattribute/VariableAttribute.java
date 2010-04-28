/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.Attribute;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.factory.RenderingVariableGeneratedValue;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class VariableAttribute<O> {
	public static final VariableAttribute<SingleValueGeneratedValue<String>> RENDERING = new VariableAttribute<SingleValueGeneratedValue<String>>() {
		@Override
		public StringVariableAttributeSymbol getSymbol(final String variableName) {
			return new StringVariableAttributeSymbol(variableName + ".RENDERING",
					new SingleValueGeneratedValueFactory<String>() {
						public SingleValueGeneratedValue<String> create(
								ConstraintSystem constraintSystem) {
							Variable variable = constraintSystem.getVariable(variableName);
							return new RenderingVariableGeneratedValue(variable,
									Attribute.RENDERING, constraintSystem);
						}
					}) {
				@Override
				public String toString() {
					return variableName + ".RENDERING";
				}
			};
		}
	};
	public static final VariableAttribute<AbstractCollectionGeneratedValue<OWLObject>> VALUES = new VariableAttribute<AbstractCollectionGeneratedValue<OWLObject>>() {
		@Override
		public CollectionVariableAttributeSymbol<OWLObject> getSymbol(final String variableName) {
			return new CollectionVariableAttributeSymbol<OWLObject>(variableName + ".VALUES",
					new AbstractCollectionGeneratedValueFactory<OWLObject>() {
						public AbstractCollectionGeneratedValue<OWLObject> create(
								ConstraintSystem constraintSystem) {
							AbstractCollectionGeneratedValue<OWLObject> toReturn = null;
							Variable v = constraintSystem.getVariable(variableName);
							if (v != null) {
								toReturn = org.coode.oppl.variablemansyntax.generated.factory.AttributeFactory.getCollectionGeneratedValue(
										Attribute.VALUES,
										v,
										constraintSystem);
							}
							return toReturn;
						}
					}) {
				@Override
				public String toString() {
					return variableName + ".VALUES";
				}
			};
		}
	};

	private VariableAttribute() {
	}

	public abstract VariableAttributeSymbol<O> getSymbol(String variableName);

	public final static VariableAttribute<SingleValueGeneratedValue<String>> group(final int index) {
		return new VariableAttribute<SingleValueGeneratedValue<String>>() {
			@Override
			public VariableAttributeSymbol<SingleValueGeneratedValue<String>> getSymbol(
					final String variableName) {
				return new GroupVariableAttributeSymbol(variableName, index);
			}
		};
	}
}
