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
	private final I input;

	/**
	 * @param input
	 */
	public CreateOWLEntity(I input) {
		if (input == null) {
			throw new NullPointerException("The input cannot be null");
		}
		this.input = input;
	}

	@Override
	public ValueComputation<O> getValueComputation(
			final ValueComputationParameters parameters) {
		return new ValueComputation<O>() {
			public O compute(OPPLFunction<? extends O> opplFunction) {
				O toReturn = null;
				String value = CreateOWLEntity.this.getInput().compute(
						parameters);
				ConstraintSystem constraintSystem = parameters
						.getConstraintSystem();
				OPPLAbstractFactory factory = constraintSystem.getOPPLFactory();
				OWLEntityChecker entityChecker = factory.getOWLEntityChecker();
				toReturn = CreateOWLEntity.this.getExistingEntity(value,
						entityChecker);
				if (toReturn == null) {
					OWLEntityFactory entityFactory = factory
							.getOWLEntityFactory();
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

	/**
	 * @return the input
	 */
	public I getInput() {
		return this.input;
	}

	protected abstract O getExistingEntity(String entityRendering,
			OWLEntityChecker entityChecker);

	protected abstract O createEntity(String entityRendering,
			OWLEntityFactory entityFactory, OWLOntologyManager manager)
			throws OWLEntityCreationException;
}
