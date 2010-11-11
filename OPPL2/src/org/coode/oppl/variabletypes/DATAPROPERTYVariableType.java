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
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

public class DATAPROPERTYVariableType extends AbstractVariableType<OWLDataProperty> implements
		VariableType<OWLDataProperty> {
	public DATAPROPERTYVariableType(VariableTypeName name) {
		super(name, EnumSet.of(Direction.SUBPROPERTYOF, Direction.SUPERPROPERTYOF));
	}

	public void accept(VariableTypeVisitor visitor) {
		visitor.visitDATAPROPERTYVariableType(this);
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visitDATAPROPERTYVariableType(this);
	}

	public RegexpGeneratedVariable<? extends OWLDataProperty> getRegexpGeneratedVariable(
			String name, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		return new RegexpGeneratedVariable<OWLDataProperty>(name,
				VariableTypeFactory.getDATAPROPERTYVariableType(), patternGeneratingOPPLFunction);
	}

	public Set<OWLDataProperty> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies) {
		Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
		for (OWLOntology ontology : ontologies) {
			toReturn.addAll(ontology.getDataPropertiesInSignature());
		}
		return toReturn;
	}

	public boolean isCompatibleWith(OWLObject o) {
		return o.accept(new OWLObjectVisitorExAdapter<Boolean>(false) {
			@Override
			public Boolean visit(OWLDataProperty property) {
				return true;
			}
		});
	}
}
