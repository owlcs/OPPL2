package org.coode.oppl.variabletypes;

import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 */
public class CONSTANTVariableType extends AbstractVariableType<OWLLiteral>
    implements VariableType<OWLLiteral> {

    /**
     * @param name name
     */
    public CONSTANTVariableType(VariableTypeName name) {
        super(name, EnumSet.noneOf(Direction.class));
    }

    @Override
    public void accept(VariableTypeVisitor visitor) {
        visitor.visitCONSTANTVariableType(this);
    }

    @Override
    public <P> P accept(VariableTypeVisitorEx<P> visitor) {
        return visitor.visitCONSTANTVariableType(this);
    }

    @Override
    public RegexpGeneratedVariable<? extends OWLLiteral> getRegexpGeneratedVariable(String name,
        OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return new RegexpGeneratedVariable<>(name, VariableTypeFactory.getCONSTANTVariableType(),
            patternGeneratingOPPLFunction);
    }

    @Override
    public Set<OWLLiteral> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies) {
        return asSet(ontologies.stream().flatMap(OWLOntology::axioms)
            .flatMap(OWLObjectExtractor::getAllOWLLiterals));
    }

    private static final OWLObjectVisitorEx<Boolean> MATCH = new OWLObjectVisitorEx<Boolean>() {
        @Override
        public <T extends Object> Boolean doDefault(T object) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visit(OWLLiteral o) {
            return Boolean.TRUE;
        }
    };

    @Override
    public boolean isCompatibleWith(OWLObject o) {
        return o.accept(MATCH).booleanValue();
    }
}
