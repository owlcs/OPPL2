package org.coode.oppl.variabletypes;

import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 */
public class ANNOTATIONPROPERTYVariableType extends AbstractVariableType<OWLAnnotationProperty>
    implements VariableType<OWLAnnotationProperty> {

    /**
     * @param name name
     */
    public ANNOTATIONPROPERTYVariableType(VariableTypeName name) {
        super(name, EnumSet.noneOf(Direction.class));
    }

    @Override
    public Set<OWLAnnotationProperty> getReferencedOWLObjects(
        Collection<? extends OWLOntology> ontologies) {
        return asSet(ontologies.stream().flatMap(OWLOntology::annotationPropertiesInSignature));
    }

    private static final OWLObjectVisitorEx<Boolean> MATCH = new OWLObjectVisitorEx<Boolean>() {
        @Override
        public <T extends Object> Boolean doDefault(T object) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visit(OWLAnnotationProperty property) {
            return Boolean.TRUE;
        }
    };

    @Override
    public boolean isCompatibleWith(OWLObject o) {
        return o.accept(MATCH).booleanValue();
    }

    @Override
    public RegexpGeneratedVariable<? extends OWLAnnotationProperty> getRegexpGeneratedVariable(
        String name, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return VariableFactory.getRegexpGeneratedVariable(name, this,
            patternGeneratingOPPLFunction);
    }

    @Override
    public void accept(VariableTypeVisitor visitor) {
        visitor.visitANNOTATIONPROPERTYVariableType(this);
    }

    @Override
    public <P> P accept(VariableTypeVisitorEx<P> visitor) {
        return visitor.visitANNOTATIONPROPERTYVariableType(this);
    }
}
