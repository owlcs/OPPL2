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
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public class ANNOTATIONPROPERTYVariableType extends AbstractVariableType<OWLAnnotationProperty>
		implements VariableType<OWLAnnotationProperty> {
	public ANNOTATIONPROPERTYVariableType(VariableTypeName name) {
		super(name, EnumSet.noneOf(Direction.class));
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#getReferencedOWLObjects(java.util.Collection)
	 */
	public Set<OWLAnnotationProperty> getReferencedOWLObjects(
			Collection<? extends OWLOntology> ontologies) {
		Set<OWLAnnotationProperty> toReturn = new HashSet<OWLAnnotationProperty>();
		for (OWLOntology ontology : ontologies) {
			toReturn.addAll(ontology.getAnnotationPropertiesInSignature());
		}
		return toReturn;
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#isCompatibleWith(org.semanticweb.owlapi.model.OWLObject)
	 */
	public boolean isCompatibleWith(OWLObject o) {
		return o.accept(new OWLObjectVisitorExAdapter<Boolean>(false) {
			@Override
			public Boolean visit(OWLAnnotationProperty property) {
				return true;
			}
		});
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#getRegexpGeneratedVariable(java.lang.String,
	 *      org.coode.oppl.function.OPPLFunction)
	 */
	public RegexpGeneratedVariable<? extends OWLAnnotationProperty> getRegexpGeneratedVariable(
			String name, OPPLFunction<Pattern> patternGeneratingOPPLFunction) {
		return VariableFactory.getRegexpGeneratedVariable(name, this, patternGeneratingOPPLFunction);
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#accept(org.coode.oppl.variabletypes.VariableTypeVisitor)
	 */
	public void accept(VariableTypeVisitor visitor) {
		visitor.visitANNOTATIONPROPERTYVariableType(this);
	}

	/**
	 * @see org.coode.oppl.variabletypes.VariableType#accept(org.coode.oppl.variabletypes.VariableTypeVisitorEx)
	 */
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visitANNOTATIONPROPERTYVariableType(this);
	}
}
