package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
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
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

public class CLASSVariableType extends AbstractVariableType<OWLClassExpression> implements
		VariableType<OWLClassExpression> {
	public CLASSVariableType(VariableTypeName name) {
		super(name, EnumSet.of(Direction.SUBCLASSOF, Direction.SUPERCLASSOF));
	}

	public void accept(VariableTypeVisitor visitor) {
		visitor.visitCLASSVariableType(this);
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visitCLASSVariableType(this);
	}

	public OWLClassExpression buildOWLObject(OWLDataFactory factory, IRI iri, String shortName) {
		return factory.getOWLClass(iri);
	}

	public RegexpGeneratedVariable<OWLClassExpression> createRegexpGeneratedVariable(String name,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		return new RegexpGeneratedVariable<OWLClassExpression>(name,
				VariableTypeFactory.getCLASSVariableType(), patternGeneratingOPPLFunction);
	}

	public Set<OWLClassExpression> getReferencedOWLObjects(
			Collection<? extends OWLOntology> ontologies) {
		Set<OWLClassExpression> toReturn = new HashSet<OWLClassExpression>();
		for (OWLOntology ontology : ontologies) {
			toReturn.addAll(ontology.getClassesInSignature());
		}
		return toReturn;
	}

	public Variable<OWLClassExpression> instantiateVariable(String name) {
		return VariableFactory.getCLASSVariable(name);
	}

	public boolean isCompatibleWith(OWLObject o) {
		return o.accept(new OWLObjectVisitorExAdapter<Boolean>(false) {
			@Override
			public Boolean visit(OWLClass ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectIntersectionOf ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectUnionOf ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectComplementOf ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectSomeValuesFrom ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectAllValuesFrom ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectHasValue ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectMinCardinality ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectExactCardinality ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectMaxCardinality ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectHasSelf ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLObjectOneOf ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLDataSomeValuesFrom ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLDataAllValuesFrom ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLDataHasValue ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLDataMinCardinality ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLDataExactCardinality ce) {
				return true;
			}

			@Override
			public Boolean visit(OWLDataMaxCardinality ce) {
				return true;
			}
		});
	}
}
