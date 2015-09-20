package org.coode.oppl.generated;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.regex.Pattern;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public class RegexpGeneratedVariable<O extends OWLObject> implements Variable<O> {

    private final OPPLFunction<Pattern> patternGeneratingOPPLFunction;
    private final String name;
    private final VariableType<O> type;
    private final IRI iri;

    /**
     * @param name
     *        name
     * @param type
     *        type
     * @param patternGeneratingOPPLFunction
     *        patternGeneratingOPPLFunction
     */
    public RegexpGeneratedVariable(String name, VariableType<O> type,
        OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        this.name = checkNotNull(name, "name");
        this.type = checkNotNull(type, "type");
        this.patternGeneratingOPPLFunction = checkNotNull(patternGeneratingOPPLFunction,
            "patternGeneratingOPPLFunction");
        this.iri = IRI.create(ManchesterVariableSyntax.NAMESPACE + this.getName());
    }

    @Override
    public void accept(VariableVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(VariableVisitorEx<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public IRI getIRI() {
        return this.iri;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public VariableType<O> getType() {
        return this.type;
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return String.format("%s:%s= MATCH (%s)", this.getName(), this.getType(), this
            .getPatternGeneratingOPPLFunction().render(constraintSystem));
    }

    /**
     * @return the patternGeneratingOPPLFunction
     */
    public OPPLFunction<Pattern> getPatternGeneratingOPPLFunction() {
        return this.patternGeneratingOPPLFunction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.name == null ? 0 : this.name.hashCode());
        result = prime * result + (this.type == null ? 0 : this.type.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.getName(), this.getType());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        RegexpGeneratedVariable<?> other = (RegexpGeneratedVariable<?>) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!this.type.equals(other.type)) {
            return false;
        }
        return true;
    }
}
