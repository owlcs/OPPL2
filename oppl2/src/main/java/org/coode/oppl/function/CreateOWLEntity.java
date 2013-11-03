package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityFactory;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntologyManager;

abstract class CreateOWLEntity<I extends OPPLFunction<? extends String>, O extends OWLEntity>
        extends Create<I, O> {
    /** @param input */
    public CreateOWLEntity(I input) {
        super(input);
    }

    @Override
    public ValueComputation<O> getValueComputation(
            final ValueComputationParameters parameters) {
        return new ValueComputation<O>() {
            @Override
            public O compute(OPPLFunction<? extends O> opplFunction) {
                O toReturn = null;
                String value = CreateOWLEntity.this.getInput().compute(parameters);
                ConstraintSystem constraintSystem = parameters.getConstraintSystem();
                OPPLAbstractFactory factory = constraintSystem.getOPPLFactory();
                OWLEntityChecker entityChecker = factory.getOWLEntityChecker();
                toReturn = CreateOWLEntity.this.getExistingEntity(value, entityChecker);
                if (toReturn == null) {
                    OWLEntityFactory entityFactory = factory.getOWLEntityFactory();
                    try {
                        toReturn = CreateOWLEntity.this.createEntity(value,
                                entityFactory, parameters.getConstraintSystem()
                                        .getOntologyManager());
                    } catch (OWLEntityCreationException e) {
                        throw new RuntimeException(e);
                    }
                }
                return toReturn;
            }
        };
    }

    protected abstract O getExistingEntity(String entityRendering,
            OWLEntityChecker entityChecker);

    protected abstract O createEntity(String entityRendering,
            OWLEntityFactory entityFactory, OWLOntologyManager manager)
            throws OWLEntityCreationException;
}
