/**
 * 
 */
package org.coode.oppl.search;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.PlainVariableVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

public final class AssignableValueExtractor implements
		PlainVariableVisitorEx<Set<? extends OWLObject>> {
	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor;
	private final ValueComputationParameters parameters;

	public AssignableValueExtractor(
			VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor,
			ValueComputationParameters parameters) {
		if (assignableValuesVisitor == null) {
			throw new NullPointerException("The assignable value visitor cannot be null");
		}
		if (parameters == null) {
			throw new NullPointerException("The value computation parameters cannot be null");
		}
		this.assignableValuesVisitor = assignableValuesVisitor;
		this.parameters = parameters;
	}

	public <O extends OWLObject> Set<? extends OWLObject> visit(Variable<O> v) {
		return v.getType().accept(this.assignableValuesVisitor);
	}

	public <O extends OWLObject> Set<? extends OWLObject> visit(RegexpGeneratedVariable<O> v) {
		Set<? extends OWLObject> toReturn = v.getType().accept(this.assignableValuesVisitor);
		Iterator<? extends OWLObject> iterator = toReturn.iterator();
		while (iterator.hasNext()) {
			OWLObject owlObject = iterator.next();
			ManchesterSyntaxRenderer renderer = this.getParameters().getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
					this.getParameters().getConstraintSystem());
			owlObject.accept(renderer);
			Pattern pattern = v.getPatternGeneratingOPPLFunction().compute(this.getParameters());
			if (!pattern.matcher(renderer.toString()).matches()) {
				iterator.remove();
			}
		}
		return toReturn;
	}

	public <O extends OWLObject> Set<? extends OWLObject> visit(GeneratedVariable<O> v) {
		return Collections.emptySet();
	}

	/**
	 * @return the parameters
	 */
	public ValueComputationParameters getParameters() {
		return this.parameters;
	}
}