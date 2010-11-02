package org.coode.oppl.function;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public abstract class Create<I extends OPPLFunction<?>, O> extends AbstractOPPLFunction<O>
		implements OPPLFunction<O> {
	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitCreate(this);
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitCreate(this);
	}

	private final I input;

	/**
	 * @param input
	 */
	protected Create(I input) {
		if (input == null) {
			throw new NullPointerException("The input cannot be null");
		}
		this.input = input;
	}

	/**
	 * @return the input
	 */
	public I getInput() {
		return this.input;
	}

	public String render(ConstraintSystem constraintSystem) {
		return String.format("create(%s)", this.getInput().render(constraintSystem));
	}

	public static <T extends OPPLFunction<? extends String>> Create<T, OWLClass> createOWLClass(
			final T t) {
		return new CreateOWLEntity<T, OWLClass>(t) {
			@Override
			protected OWLClass createEntity(String entityRendering, OWLEntityFactory entityFactory,
					OWLOntologyManager manager) throws OWLEntityCreationException {
				OWLEntityCreationSet<OWLClass> entitySet = entityFactory.createOWLClass(
						entityRendering,
						null);
				manager.applyChanges(entitySet.getOntologyChanges());
				return entitySet.getOWLEntity();
			}

			@Override
			protected OWLClass getExistingEntity(String entityRendering,
					OWLEntityChecker entityChecker) {
				return entityChecker.getOWLClass(entityRendering);
			}
		};
	}

	public static <T extends OPPLFunction<? extends String>> Create<T, OWLObjectProperty> createOWLObjectProperty(
			final T t) {
		return new CreateOWLEntity<T, OWLObjectProperty>(t) {
			@Override
			protected OWLObjectProperty createEntity(String entityRendering,
					OWLEntityFactory entityFactory, OWLOntologyManager manager)
					throws OWLEntityCreationException {
				OWLEntityCreationSet<OWLObjectProperty> entitySet = entityFactory.createOWLObjectProperty(
						entityRendering,
						null);
				manager.applyChanges(entitySet.getOntologyChanges());
				return entitySet.getOWLEntity();
			}

			@Override
			protected OWLObjectProperty getExistingEntity(String entityRendering,
					OWLEntityChecker entityChecker) {
				return entityChecker.getOWLObjectProperty(entityRendering);
			}
		};
	}

	public static <T extends OPPLFunction<? extends String>> Create<T, OWLDataProperty> createOWLDataProperty(
			final T t) {
		return new CreateOWLEntity<T, OWLDataProperty>(t) {
			@Override
			protected OWLDataProperty createEntity(String entityRendering,
					OWLEntityFactory entityFactory, OWLOntologyManager manager)
					throws OWLEntityCreationException {
				OWLEntityCreationSet<OWLDataProperty> entitySet = entityFactory.createOWLDataProperty(
						entityRendering,
						null);
				manager.applyChanges(entitySet.getOntologyChanges());
				return entitySet.getOWLEntity();
			}

			@Override
			protected OWLDataProperty getExistingEntity(String entityRendering,
					OWLEntityChecker entityChecker) {
				return entityChecker.getOWLDataProperty(entityRendering);
			}
		};
	}

	public static <T extends OPPLFunction<? extends String>> Create<T, OWLNamedIndividual> createOWLNamedIndividual(
			final T t) {
		return new CreateOWLEntity<T, OWLNamedIndividual>(t) {
			@Override
			protected OWLNamedIndividual createEntity(String entityRendering,
					OWLEntityFactory entityFactory, OWLOntologyManager manager)
					throws OWLEntityCreationException {
				OWLEntityCreationSet<OWLNamedIndividual> entitySet = entityFactory.createOWLIndividual(
						entityRendering,
						null);
				manager.applyChanges(entitySet.getOntologyChanges());
				return entitySet.getOWLEntity();
			}

			@Override
			protected OWLNamedIndividual getExistingEntity(String entityRendering,
					OWLEntityChecker entityChecker) {
				return entityChecker.getOWLIndividual(entityRendering);
			}
		};
	}
}
