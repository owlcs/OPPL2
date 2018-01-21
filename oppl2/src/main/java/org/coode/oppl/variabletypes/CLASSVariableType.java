package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 */
public class CLASSVariableType extends AbstractVariableType<OWLClassExpression>
    implements VariableType<OWLClassExpression> {

    /**
     * @param name name
     */
    public CLASSVariableType(VariableTypeName name) {
        super(name, EnumSet.of(Direction.SUBCLASSOF, Direction.SUPERCLASSOF));
    }

    @Override
    public void accept(VariableTypeVisitor visitor) {
        visitor.visitCLASSVariableType(this);
    }

    @Override
    public <P> P accept(VariableTypeVisitorEx<P> visitor) {
        return visitor.visitCLASSVariableType(this);
    }

    @Override
    public RegexpGeneratedVariable<OWLClassExpression> getRegexpGeneratedVariable(String name,
        OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return new RegexpGeneratedVariable<>(name, VariableTypeFactory.getCLASSVariableType(),
            patternGeneratingOPPLFunction);
    }

    @Override
    public Set<OWLClassExpression> getReferencedOWLObjects(
        Collection<? extends OWLOntology> ontologies) {
        Set<OWLClassExpression> toReturn = new HashSet<>();
        for (OWLOntology ontology : ontologies) {
            toReturn.addAll(ontology.getClassesInSignature());
        }
        return toReturn;
    }

    private static final OWLObjectVisitorEx<Boolean> MATCH = new OWLObjectVisitorEx<Boolean>() {
        @Override
        public <T extends Object> Boolean doDefault(T object) {
            return Boolean.FALSE;
        }

        @Override
        public Boolean visit(OWLClass ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectIntersectionOf ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectUnionOf ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectComplementOf ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectSomeValuesFrom ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectAllValuesFrom ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectHasValue ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectMinCardinality ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectExactCardinality ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectMaxCardinality ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectHasSelf ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLObjectOneOf ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLDataSomeValuesFrom ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLDataAllValuesFrom ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLDataHasValue ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLDataMinCardinality ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLDataExactCardinality ce) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean visit(OWLDataMaxCardinality ce) {
            return Boolean.TRUE;
        }
    };

    @Override
    public boolean isCompatibleWith(OWLObject o) {
        return o.accept(MATCH).booleanValue();
    }
}
