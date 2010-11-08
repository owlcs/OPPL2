package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.CONSTANTRegexpGeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

public class CONSTANTVariableType extends AbstractVariableType<OWLLiteral>
		implements VariableType<OWLLiteral> {
	/**
	 * @param name
	 * @param allowedDirections
	 */
	public CONSTANTVariableType(VariableTypeName name) {
		super(name, EnumSet.noneOf(Direction.class));
	}

	public void accept(VariableTypeVisitor visitor) {
		visitor.visitCONSTANTVariableType(this);
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visitCONSTANTVariableType(this);
	}

	public OWLLiteral buildOWLObject(OWLDataFactory factory, IRI iri,
			String shortName) {
		return factory.getOWLLiteral(shortName);
	}

	public RegexpGeneratedVariable<? extends OWLLiteral> createRegexpGeneratedVariable(
			String name, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		return new CONSTANTRegexpGeneratedVariable(name,
				patternGeneratingOPPLFunction);
	}

	public Set<OWLLiteral> getReferencedOWLObjects(
			Collection<? extends OWLOntology> ontologies) {
		Set<OWLLiteral> toReturn = new HashSet<OWLLiteral>();
		for (OWLOntology ontology : ontologies) {
			for (OWLAxiom axiom : ontology.getAxioms()) {
				toReturn.addAll(OWLObjectExtractor.getAllOWLLiterals(axiom));
			}
		}
		return toReturn;
	}

	public Variable instantiateVariable(String name) {
		return new CONSTANTVariableImpl(name);
	}

	public boolean isCompatibleWith(OWLObject o) {
		return o.accept(new OWLObjectVisitorExAdapter<Boolean>() {
			@Override
			public Boolean visit(OWLLiteral literal) {
				return true;
			}
		});
	}
}
