package org.coode.oppl.variablemansyntax.generated.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.variablemansyntax.generated.Attribute;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitor;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValueVisitorEx;
import org.semanticweb.owl.model.OWLObject;

public class OWLObjectCollectionGeneratedValue extends
		AbstractCollectionGeneratedValue<OWLObject> {
	private final ConstraintSystem constraintSystem;

	public OWLObjectCollectionGeneratedValue(Variable variable,
			Attribute attribute, ConstraintSystem constraintSystem,
			ConstraintSystem constraintSystem2) {
		super(variable, attribute, constraintSystem);
		this.constraintSystem = constraintSystem2;
	}

	public Collection<OWLObject> getGeneratedValue(BindingNode node) {
		Set<OWLObject> toReturn = null;
		Set<BindingNode> leaves = this.constraintSystem.getLeaves();
		if (leaves != null && !leaves.isEmpty()) {
			toReturn = new HashSet<OWLObject>();
			for (BindingNode bindingNode : leaves) {
				OWLObject assignmentValue = bindingNode.getAssignmentValue(this
						.getVariable());
				if (assignmentValue != null) {
					toReturn.add(assignmentValue);
				}
			}
			// must not return an empty collection, otherwise bad rendering
			// happens in Patterns
			if (toReturn.size() == 0) {
				toReturn = null;
			}
		}
		return toReturn;
	}

	public List<Collection<OWLObject>> computePossibleValues() {
		List<Collection<OWLObject>> toReturn = new ArrayList<Collection<OWLObject>>();
		Collection<OWLObject> generatedValue = this.getGeneratedValue(null);
		if (generatedValue != null) {
			toReturn.add(Collections.unmodifiableCollection(generatedValue));
		}
		return toReturn;
	}

	public void accept(SingleValueGeneratedValueVisitor visitor) {
		visitor.visitOWLObjectCollectionGeneratedValue(this);
	}

	public <O> O accept(SingleValueGeneratedValueVisitorEx<O> visitor) {
		return visitor.visitOWLObjectCollectionGeneratedValue(this);
	}
}