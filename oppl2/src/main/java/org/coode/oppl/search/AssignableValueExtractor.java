package org.coode.oppl.search;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

public final class AssignableValueExtractor implements
        VariableVisitorEx<Set<? extends OWLObject>> {
    private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor;
    private final ValueComputationParameters parameters;

    public AssignableValueExtractor(
            VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor,
            ValueComputationParameters parameters) {
        if (assignableValuesVisitor == null) {
            throw new NullPointerException("The assignable value visitor cannot be null");
        }
        if (parameters == null) {
            throw new NullPointerException(
                    "The value computation parameters cannot be null");
        }
        this.assignableValuesVisitor = assignableValuesVisitor;
        this.parameters = parameters;
    }

    @Override
    public <O extends OWLObject> Set<? extends OWLObject> visit(InputVariable<O> v) {
        return v.getType().accept(assignableValuesVisitor);
    }

    @Override
    public <O extends OWLObject> Set<? extends OWLObject> visit(
            RegexpGeneratedVariable<O> v) {
        Set<? extends OWLObject> toReturn = v.getType().accept(assignableValuesVisitor);
        Iterator<? extends OWLObject> iterator = toReturn.iterator();
        while (iterator.hasNext()) {
            OWLObject owlObject = iterator.next();
            ManchesterSyntaxRenderer renderer = getParameters().getConstraintSystem()
                    .getOPPLFactory()
                    .getManchesterSyntaxRenderer(getParameters().getConstraintSystem());
            owlObject.accept(renderer);
            Pattern pattern = v.getPatternGeneratingOPPLFunction().compute(
                    getParameters());
            if (!pattern.matcher(renderer.toString()).matches()) {
                iterator.remove();
            }
        }
        return toReturn;
    }

    @Override
    public <O extends OWLObject> Set<? extends OWLObject> visit(GeneratedVariable<O> v) {
        return Collections.emptySet();
    }

    /** @return the parameters */
    public ValueComputationParameters getParameters() {
        return parameters;
    }
}
