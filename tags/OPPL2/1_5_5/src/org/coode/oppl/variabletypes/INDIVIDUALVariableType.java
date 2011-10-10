/**
 * 
 */
package org.coode.oppl.variabletypes;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.VariableScopes.Direction;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public class INDIVIDUALVariableType extends AbstractVariableType<OWLIndividual> implements
		VariableType<OWLIndividual> {
	/**
	 * @param name
	 * @param allowedDirections
	 */
	public INDIVIDUALVariableType(VariableTypeName name) {
		super(name, EnumSet.of(Direction.INSTANCEOF));
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#accept(org.coode.oppl.variabletypes
	 *      .VariableTypeVisitor)
	 */
	public void accept(VariableTypeVisitor visitor) {
		visitor.visitINDIVIDUALVariableType(this);
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#accept(org.coode.oppl.variabletypes
	 *      .VariableTypeVisitorEx)
	 */
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visitINDIVIDUALVariableType(this);
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#getRegexpGeneratedVariable
	 *      (java.lang.String, org.coode.oppl.function.OPPLFunction)
	 */
	public RegexpGeneratedVariable<? extends OWLIndividual> getRegexpGeneratedVariable(String name,
			OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		return new RegexpGeneratedVariable<OWLIndividual>(name,
				VariableTypeFactory.getINDIVIDUALVariableType(), patternGeneratingOPPLFunction);
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#getReferencedOWLObjects(java
	 *      .util.Collection)
	 */
	public Set<OWLIndividual> getReferencedOWLObjects(Collection<? extends OWLOntology> ontologies) {
		Set<OWLIndividual> toReturn = new HashSet<OWLIndividual>();
		for (OWLOntology ontology : ontologies) {
			toReturn.addAll(ontology.getIndividualsInSignature());
		}
		return toReturn;
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#isCompatibleWith(org.semanticweb
	 *      .owlapi.model.OWLObject)
	 */
	public boolean isCompatibleWith(OWLObject o) {
		return o.accept(new OWLObjectVisitorExAdapter<Boolean>(false) {
			@Override
			public Boolean visit(OWLAnonymousIndividual individual) {
				return true;
			}

			@Override
			public Boolean visit(OWLNamedIndividual individual) {
				return true;
			}
		});
	}
}
