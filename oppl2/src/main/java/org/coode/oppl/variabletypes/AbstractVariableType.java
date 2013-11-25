package org.coode.oppl.variabletypes;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.EnumSet;

import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
abstract class AbstractVariableType<O extends OWLObject> implements VariableType<O> {
    private final VariableTypeName name;
    private final EnumSet<Direction> allowedDirections = EnumSet.noneOf(Direction.class);

    /** @param name
     * @param allowedDirections */
    public AbstractVariableType(VariableTypeName name,
            EnumSet<Direction> allowedDirections) {
        this.name = checkNotNull(name, "name");
        this.allowedDirections
                .addAll(checkNotNull(allowedDirections, "allowedDirections"));
    }

    /** @return the name */
    public VariableTypeName getName() {
        return this.name;
    }

    /** @return the allowedDirections */
    @Override
    public EnumSet<Direction> getAllowedDirections() {
        return EnumSet.copyOf(this.allowedDirections);
    }

    @Override
    public String toString() {
        return this.getName().toString();
    }

    @Override
    public InputVariable<O> getInputVariable(String n, VariableScope<?> variableScope) {
        return InputVariable.getInputVariable(n, this, variableScope);
    }

    @Override
    public GeneratedVariable<O> getGeneratedVariable(String n,
            OPPLFunction<? extends O> opplFunction) {
        return GeneratedVariable.getGeneratedVariable(n, this, opplFunction);
    }
}
