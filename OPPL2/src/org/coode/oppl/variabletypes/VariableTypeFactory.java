/**
 * 
 */
package org.coode.oppl.variabletypes;

import java.util.EnumMap;

import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableTypeFactory {
	private static final EnumMap<VariableTypeName, VariableType<?>> typesCache = new EnumMap<VariableTypeName, VariableType<?>>(
			VariableTypeName.class);
	static {
		typesCache.put(VariableTypeName.CLASS, new CLASSVariableType(VariableTypeName.CLASS));
		typesCache.put(VariableTypeName.OBJECTPROPERTY, new OBJECTPROPERTYVariableType(
				VariableTypeName.OBJECTPROPERTY));
		typesCache.put(VariableTypeName.DATAPROPERTY, new DATAPROPERTYVariableType(
				VariableTypeName.DATAPROPERTY));
		typesCache.put(VariableTypeName.INDIVIDUAL, new INDIVIDUALVariableType(
				VariableTypeName.INDIVIDUAL));
		typesCache.put(VariableTypeName.CONSTANT, new CONSTANTVariableType(
				VariableTypeName.CONSTANT));
	}

	@SuppressWarnings("unchecked")
	public static VariableType<OWLClassExpression> getCLASSVariableType() {
		return (VariableType<OWLClassExpression>) getVariableType(VariableTypeName.CLASS);
	}

	@SuppressWarnings("unchecked")
	public static VariableType<OWLObjectPropertyExpression> getOBJECTPROPERTYTypeVariableType() {
		return (VariableType<OWLObjectPropertyExpression>) getVariableType(VariableTypeName.OBJECTPROPERTY);
	}

	@SuppressWarnings("unchecked")
	public static VariableType<OWLDataProperty> getDATAPROPERTYVariableType() {
		return (VariableType<OWLDataProperty>) getVariableType(VariableTypeName.DATAPROPERTY);
	}

	@SuppressWarnings("unchecked")
	public static VariableType<OWLIndividual> getINDIVIDUALVariableType() {
		return (VariableType<OWLIndividual>) getVariableType(VariableTypeName.INDIVIDUAL);
	}

	@SuppressWarnings("unchecked")
	public static VariableType<OWLLiteral> getCONSTANTVariableType() {
		return (VariableType<OWLLiteral>) getVariableType(VariableTypeName.CONSTANT);
	}

	public static VariableType<?> getVariableType(VariableTypeName variableTypeName) {
		return variableTypeName == null ? null : typesCache.get(variableTypeName);
	}

	public static VariableType<?> getVariableType(String variableTypeName) {
		return getVariableType(VariableTypeName.getVariableTypeName(variableTypeName));
	}
}
