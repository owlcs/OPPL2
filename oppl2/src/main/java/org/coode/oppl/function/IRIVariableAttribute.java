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
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/**
 * @author Luigi Iannone
 */
public class IRIVariableAttribute extends VariableAttribute<IRI> {

    /**
     * @param variable variable
     */
    public IRIVariableAttribute(Variable<?> variable) {
        super(variable, AttributeName.IRI);
    }

    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitIRIVariableAttribute(this);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitIRIVariableAttribute(this);
    }

    @Override
    public ValueComputation<IRI> getValueComputation(final ValueComputationParameters parameters) {
        return opplFunction -> {
            IRI toReturn = null;
            BindingNode bindingNode = parameters.getBindingNode();
            OWLObject assignmentValue =
                bindingNode.getAssignmentValue(IRIVariableAttribute.this.getVariable(), parameters);
            if (assignmentValue != null) {
                toReturn = assignmentValue.accept(new OWLObjectVisitorEx<IRI>() {
                    @Override
                    public <T> IRI doDefault(T object) {
                        return null;
                    }

                    @Override
                    public IRI visit(OWLAnnotationProperty property) {
                        return getOWLEntityIRI(property);
                    }

                    @Override
                    public IRI visit(OWLClass desc) {
                        return getOWLEntityIRI(desc);
                    }

                    @Override
                    public IRI visit(OWLDatatype node) {
                        return getOWLEntityIRI(node);
                    }

                    @Override
                    public IRI visit(OWLObjectProperty property) {
                        return getOWLEntityIRI(property);
                    }

                    @Override
                    public IRI visit(OWLNamedIndividual individual) {
                        return getOWLEntityIRI(individual);
                    }

                    private IRI getOWLEntityIRI(OWLEntity entity) {
                        return entity.getIRI();
                    }
                });
            }
            return toReturn;
        };
    }

    /**
     * @param v v
     * @param owlObject owlObject
     * @param constraintSystem constraintSystem
     * @param handler handler
     * @return oppl function
     */
    @SuppressWarnings("unused")
    public OPPLFunction<IRI> replace(Variable<?> v, OWLObject owlObject,
        ConstraintSystem constraintSystem, RuntimeExceptionHandler handler) {
        return this;
    }
}
