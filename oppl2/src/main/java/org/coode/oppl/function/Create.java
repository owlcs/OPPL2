package org.coode.oppl.function;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone
 * @param <I>
 *            type
 * @param <O>
 *            return type */
public abstract class Create<I extends OPPLFunction<?>, O> extends
        AbstractOPPLFunction<O> implements OPPLFunction<O> {
    @Override
    public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
        return visitor.visitCreate(this);
    }

    @Override
    public void accept(OPPLFunctionVisitor visitor) {
        visitor.visitCreate(this);
    }

    private final I input;

    /** @param input
     *            input */
    protected Create(I input) {
        this.input = checkNotNull(input, "input");
    }

    /** @param variableType
     *            variableType
     * @return true if variableType is compatible */
    public abstract boolean isCompatible(VariableType<?> variableType);

    /** @return the input */
    public I getInput() {
        return this.input;
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return String.format("create(%s)", this.getInput().render(constraintSystem));
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return String.format("create(%s)", this.getInput().render(shortFormProvider));
    }

    /** @param t
     *            t
     * @param <T>
     *            type
     * @return Create with owl class */
    public static <T extends OPPLFunction<? extends String>> Create<T, OWLClass>
            createOWLClass(final T t) {
        return new CreateOWLEntity<T, OWLClass>(t) {
            @Override
            protected OWLClass createEntity(String entityRendering,
                    OWLEntityFactory entityFactory, OWLOntologyManager manager)
                    throws OWLEntityCreationException {
                OWLEntityCreationSet<OWLClass> entitySet = entityFactory.createOWLClass(
                        entityRendering, null);
                // manager.applyChanges(entitySet.getOntologyChanges());
                return entitySet.getOWLEntity();
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return variableType == VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            protected OWLClass getExistingEntity(String entityRendering,
                    OWLEntityChecker entityChecker) {
                return entityChecker.getOWLClass(entityRendering);
            }
        };
    }

    /** @param t
     *            t
     * @param <T>
     *            type
     * @return Create with object property */
    public static <T extends OPPLFunction<? extends String>> Create<T, OWLObjectProperty>
            createOWLObjectProperty(final T t) {
        return new CreateOWLEntity<T, OWLObjectProperty>(t) {
            @Override
            protected OWLObjectProperty createEntity(String entityRendering,
                    OWLEntityFactory entityFactory, OWLOntologyManager manager)
                    throws OWLEntityCreationException {
                OWLEntityCreationSet<OWLObjectProperty> entitySet = entityFactory
                        .createOWLObjectProperty(entityRendering, null);
                // manager.applyChanges(entitySet.getOntologyChanges());
                return entitySet.getOWLEntity();
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return variableType == VariableTypeFactory
                        .getOBJECTPROPERTYTypeVariableType();
            }

            @Override
            protected OWLObjectProperty getExistingEntity(String entityRendering,
                    OWLEntityChecker entityChecker) {
                return entityChecker.getOWLObjectProperty(entityRendering);
            }
        };
    }

    /** @param t
     *            t
     * @param <T>
     *            type
     * @return Create with data property */
    public static <T extends OPPLFunction<? extends String>> Create<T, OWLDataProperty>
            createOWLDataProperty(final T t) {
        return new CreateOWLEntity<T, OWLDataProperty>(t) {
            @Override
            protected OWLDataProperty createEntity(String entityRendering,
                    OWLEntityFactory entityFactory, OWLOntologyManager manager)
                    throws OWLEntityCreationException {
                OWLEntityCreationSet<OWLDataProperty> entitySet = entityFactory
                        .createOWLDataProperty(entityRendering, null);
                // manager.applyChanges(entitySet.getOntologyChanges());
                return entitySet.getOWLEntity();
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return variableType == VariableTypeFactory.getDATAPROPERTYVariableType();
            }

            @Override
            protected OWLDataProperty getExistingEntity(String entityRendering,
                    OWLEntityChecker entityChecker) {
                return entityChecker.getOWLDataProperty(entityRendering);
            }
        };
    }

    /** @param t
     *            t
     * @param <T>
     *            type
     * @return Create with named individual */
    public static <T extends OPPLFunction<? extends String>>
            Create<T, OWLNamedIndividual> createOWLNamedIndividual(final T t) {
        return new CreateOWLEntity<T, OWLNamedIndividual>(t) {
            @Override
            protected OWLNamedIndividual createEntity(String entityRendering,
                    OWLEntityFactory entityFactory, OWLOntologyManager manager)
                    throws OWLEntityCreationException {
                OWLEntityCreationSet<OWLNamedIndividual> entitySet = entityFactory
                        .createOWLIndividual(entityRendering, null);
                // manager.applyChanges(entitySet.getOntologyChanges());
                return entitySet.getOWLEntity();
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return variableType == VariableTypeFactory.getINDIVIDUALVariableType();
            }

            @Override
            protected OWLNamedIndividual getExistingEntity(String entityRendering,
                    OWLEntityChecker entityChecker) {
                return entityChecker.getOWLIndividual(entityRendering);
            }
        };
    }

    /** @param value
     *            value
     * @return create with literal */
    public static OPPLFunction<OWLLiteral> createOWLLiteral(OPPLFunction<String> value) {
        return new Create<OPPLFunction<String>, OWLLiteral>(value) {
            @Override
            public ValueComputation<OWLLiteral> getValueComputation(
                    final ValueComputationParameters parameters) {
                return new ValueComputation<OWLLiteral>() {
                    @Override
                    public OWLLiteral compute(
                            OPPLFunction<? extends OWLLiteral> opplFunction) {
                        OWLDataFactory dataFactory = parameters.getConstraintSystem()
                                .getOntologyManager().getOWLDataFactory();
                        return dataFactory.getOWLLiteral(getInput().compute(parameters));
                    }
                };
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return variableType == VariableTypeFactory.getCONSTANTVariableType();
            }
        };
    }

    /** @param t
     *            t
     * @param <T>
     *            type
     * @return create with annotation property */
    public static <T extends OPPLFunction<? extends String>>
            Create<T, OWLAnnotationProperty> createOWLAnnotationProperty(final T t) {
        return new CreateOWLEntity<T, OWLAnnotationProperty>(t) {
            @Override
            protected OWLAnnotationProperty createEntity(String entityRendering,
                    OWLEntityFactory entityFactory, OWLOntologyManager manager)
                    throws OWLEntityCreationException {
                OWLEntityCreationSet<OWLAnnotationProperty> entitySet = entityFactory
                        .createOWLAnnotationProperty(entityRendering, null);
                // manager.applyChanges(entitySet.getOntologyChanges());
                return entitySet.getOWLEntity();
            }

            @Override
            public boolean isCompatible(VariableType<?> variableType) {
                return variableType == VariableTypeFactory.getDATAPROPERTYVariableType();
            }

            @Override
            protected OWLAnnotationProperty getExistingEntity(String entityRendering,
                    OWLEntityChecker entityChecker) {
                return entityChecker.getOWLAnnotationProperty(entityRendering);
            }
        };
    }
}
