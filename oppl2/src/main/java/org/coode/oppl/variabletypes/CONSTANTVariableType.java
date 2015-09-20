package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 */
public class CONSTANTVariableType extends AbstractVariableType<OWLLiteral>implements
    VariableType<OWLLiteral> {

    /**
     * @param name
     *        name
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
    public RegexpGeneratedVariable<? extends OWLLiteral> getRegexpGeneratedVariable(
        String name, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
        return new RegexpGeneratedVariable<>(name,
            VariableTypeFactory.getCONSTANTVariableType(),
            patternGeneratingOPPLFunction);
    }

    @Override
    public Set<OWLLiteral> getReferencedOWLObjects(
        Collection<? extends OWLOntology> ontologies) {
        Set<OWLLiteral> toReturn = new HashSet<>();
        for (OWLOntology ontology : ontologies) {
            for (OWLAxiom axiom : ontology.getAxioms()) {
                toReturn.addAll(OWLObjectExtractor.getAllOWLLiterals(axiom));
            }
        }
        return toReturn;
    }

    @Override
    public boolean isCompatibleWith(OWLObject o) {
        OWLObjectVisitorExAdapter<Boolean> visitor = new OWLObjectVisitorExAdapter<Boolean>(
            false) {

            @Override
            public Boolean visit(OWLLiteral literal) {
                return true;
            }
        };
        return o.accept(visitor);
    }
}
