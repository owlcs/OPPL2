package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

public class DATAPROPERTYVariableType extends
        AbstractVariableType<OWLDataPropertyExpression> implements
        VariableType<OWLDataPropertyExpression> {
    public DATAPROPERTYVariableType(VariableTypeName name) {
        super(name, EnumSet.of(Direction.SUBPROPERTYOF, Direction.SUPERPROPERTYOF));
    }

    @Override
    public void accept(VariableTypeVisitor visitor) {
        visitor.visitDATAPROPERTYVariableType(this);
    }

    @Override
    public <P> P accept(VariableTypeVisitorEx<P> visitor) {
        return visitor.visitDATAPROPERTYVariableType(this);
    }

    @Override
    public RegexpGeneratedVariable<? extends OWLDataPropertyExpression>
            getRegexpGeneratedVariable(String name,
                    OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return new RegexpGeneratedVariable<OWLDataPropertyExpression>(name,
                VariableTypeFactory.getDATAPROPERTYVariableType(),
                patternGeneratingOPPLFunction);
    }

    @Override
    public Set<OWLDataPropertyExpression> getReferencedOWLObjects(
            Collection<? extends OWLOntology> ontologies) {
        Set<OWLDataPropertyExpression> toReturn = new HashSet<OWLDataPropertyExpression>();
        for (OWLOntology ontology : ontologies) {
            toReturn.addAll(ontology.getDataPropertiesInSignature());
        }
        return toReturn;
    }

    @Override
    public boolean isCompatibleWith(OWLObject o) {
        return o.accept(new OWLObjectVisitorExAdapter<Boolean>(false) {
            @Override
            public Boolean visit(OWLDataProperty property) {
                return true;
            }
        });
    }
}
