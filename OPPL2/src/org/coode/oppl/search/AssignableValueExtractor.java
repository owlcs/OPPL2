/**
 * 
 */
package org.coode.oppl.search;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;

public final class AssignableValueExtractor implements
		VariableVisitor<Set<? extends OWLObject>> {
	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor;
	private final ValueComputationParameters parameters;

	public AssignableValueExtractor(
			VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor,
			ValueComputationParameters parameters) {
		if (assignableValuesVisitor == null) {
			throw new NullPointerException(
					"The assignable value visitor cannot be null");
		}
		if (parameters == null) {
			throw new NullPointerException(
					"The value computation parameters cannot be null");
		}
		this.assignableValuesVisitor = assignableValuesVisitor;
		this.parameters = parameters;
	}

	public Set<? extends OWLObject> visit(Variable v) {
		return v.accept(this.assignableValuesVisitor);
	}

	public Set<? extends OWLObject> visit(RegexpGeneratedVariable<?> v) {
		Set<? extends OWLObject> toReturn = v
				.accept(this.assignableValuesVisitor);
		Iterator<? extends OWLObject> iterator = toReturn.iterator();
		while (iterator.hasNext()) {
			OWLObject owlObject = iterator.next();
			ManchesterSyntaxRenderer renderer = this.getParameters()
					.getConstraintSystem().getOPPLFactory()
					.getManchesterSyntaxRenderer(
							this.getParameters().getConstraintSystem());
			owlObject.accept(renderer);
			Pattern pattern = v.getPatternGeneratingOPPLFunction().compute(
					this.getParameters());
			if (!pattern.matcher(renderer.toString()).matches()) {
				iterator.remove();
			}
		}
		return toReturn;
	}

	public Set<? extends OWLObject> visit(GeneratedVariable<?> v) {
		return Collections.emptySet();
	}

	/**
	 * @return the parameters
	 */
	public ValueComputationParameters getParameters() {
		return this.parameters;
	}
}