package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 */
public class CLASSVariableType extends AbstractVariableType<OWLClassExpression>implements
    VariableType<OWLClassExpression> {

    /**
     * @param name
     *        name
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
    public RegexpGeneratedVariable<OWLClassExpression> getRegexpGeneratedVariable(
        String name, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return new RegexpGeneratedVariable<>(name,
            VariableTypeFactory.getCLASSVariableType(), patternGeneratingOPPLFunction);
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

    @Override
    public boolean isCompatibleWith(OWLObject o) {
        return o.accept(new OWLObjectVisitorExAdapter<Boolean>(false) {

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
        }).booleanValue();
    }
}
