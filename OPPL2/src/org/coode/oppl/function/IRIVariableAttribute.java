/**
 * 
 */
package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public class IRIVariableAttribute extends VariableAttribute<IRI> {
	/**
	 * @param variable
	 * @param attribute
	 */
	public IRIVariableAttribute(Variable<?> variable) {
		super(variable, AttributeName.IRI);
	}

	/**
	 * @see org.coode.oppl.function.OPPLFunction#accept(org.coode.oppl.function.
	 *      OPPLFunctionVisitorEx)
	 */
	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitIRIVariableAttribute(this);
	}

	/**
	 * @see org.coode.oppl.function.OPPLFunction#accept(org.coode.oppl.function.
	 *      OPPLFunctionVisitor)
	 */
	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitIRIVariableAttribute(this);
	}

	/**
	 * @see org.coode.oppl.function.AbstractOPPLFunction#getValueComputation(org.
	 *      coode.oppl.function.ValueComputationParameters)
	 */
	@Override
	public ValueComputation<IRI> getValueComputation(final ValueComputationParameters parameters) {
		return new ValueComputation<IRI>() {
			public IRI compute(OPPLFunction<? extends IRI> opplFunction) {
				IRI toReturn = null;
				BindingNode bindingNode = parameters.getBindingNode();
				OWLObject assignmentValue = bindingNode.getAssignmentValue(
						IRIVariableAttribute.this.getVariable(),
						parameters);
				if (assignmentValue != null) {
					toReturn = assignmentValue.accept(new OWLObjectVisitorExAdapter<IRI>() {
						@Override
						public IRI visit(OWLAnnotationProperty property) {
							return this.getOWLEntityIRI(property);
						}

						@Override
						public IRI visit(OWLClass desc) {
							return this.getOWLEntityIRI(desc);
						}

						@Override
						public IRI visit(OWLDatatype node) {
							return this.getOWLEntityIRI(node);
						}

						@Override
						public IRI visit(OWLObjectProperty property) {
							return this.getOWLEntityIRI(property);
						}

						@Override
						public IRI visit(OWLNamedIndividual individual) {
							return this.getOWLEntityIRI(individual);
						}

						private IRI getOWLEntityIRI(OWLEntity entity) {
							return entity.getIRI();
						}
					});
				}
				return toReturn;
			}
		};
	}

	public OPPLFunction<IRI> replace(Variable<?> v, OWLObject owlObject,
			ConstraintSystem constraintSystem, RuntimeExceptionHandler handler) {
		return this;
	}
}
