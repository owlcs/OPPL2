package org.coode.oppl.variabletypes;

import org.coode.oppl.Variable;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

public class VariableFactory {
	public static Variable<OWLClassExpression> getCLASSVariable(String name) {
		return new VariableImpl<OWLClassExpression>(name,
				VariableTypeFactory.getCLASSVariableType());
	}

	public static Variable<OWLObjectPropertyExpression> getOBJECTPROPERTYVariable(String name) {
		return new VariableImpl<OWLObjectPropertyExpression>(name,
				VariableTypeFactory.getOBJECTPROPERTYTypeVariableType());
	}

	public static Variable<OWLDataProperty> getDATAPROPERTYVariable(String name) {
		return new VariableImpl<OWLDataProperty>(name,
				VariableTypeFactory.getDATAPROPERTYVariableType());
	}

	public static Variable<OWLIndividual> getINDIVIDUALVariable(String name) {
		return new VariableImpl<OWLIndividual>(name,
				VariableTypeFactory.getINDIVIDUALVariableType());
	}

	public static Variable<OWLLiteral> getCONSTANTVariable(String name) {
		return new VariableImpl<OWLLiteral>(name, VariableTypeFactory.getCONSTANTVariableType());
	}

	public static <O extends OWLObject> GeneratedVariable<O> getGeneratedVariable(String name,
			VariableType<O> type, OPPLFunction<? extends O> opplFunction) {
		return new GeneratedVariable<O>(name, type, opplFunction);
	}
}
