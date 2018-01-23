package org.coode.oppl.variabletypes;

import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 */
public class INDIVIDUALVariableType extends AbstractVariableType<OWLIndividual>
    implements VariableType<OWLIndividual> {

    /**
     * @param name name
     */
    public INDIVIDUALVariableType(VariableTypeName name) {
        super(name, EnumSet.of(Direction.INSTANCEOF));
    }

    @Override
    public void accept(VariableTypeVisitor visitor) {
        visitor.visitINDIVIDUALVariableType(this);
    }

    @Override
    public <P> P accept(VariableTypeVisitorEx<P> visitor) {
        return visitor.visitINDIVIDUALVariableType(this);
    }

    @Override
    public RegexpGeneratedVariable<? extends OWLIndividual> getRegexpGeneratedVariable(String name,
        OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return new RegexpGeneratedVariable<>(name, VariableTypeFactory.getINDIVIDUALVariableType(),
            patternGeneratingOPPLFunction);
    }

    @Override
    public Set<OWLIndividual> getReferencedOWLObjects(
        Collection<? extends OWLOntology> ontologies) {
        return asSet(ontologies.stream().flatMap(OWLOntology::individualsInSignature));
    }

    private static final OWLObjectVisitorEx<Boolean> MATCH = new OWLObjectVisitorEx<Boolean>() {
        @Override
        public <T extends Object> Boolean doDefault(T object) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visit(OWLAnonymousIndividual o) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLNamedIndividual o) {
            return Boolean.TRUE;
        }
    };


    @Override
    public boolean isCompatibleWith(OWLObject o) {
        return o.accept(MATCH).booleanValue();
    }
}
