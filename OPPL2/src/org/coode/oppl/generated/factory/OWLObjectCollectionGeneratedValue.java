package org.coode.oppl.generated.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.generated.Attribute;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitor;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

public class OWLObjectCollectionGeneratedValue<O extends OWLObject> extends
		AbstractCollectionGeneratedValue<O> {
	public OWLObjectCollectionGeneratedValue(Variable variable, Attribute attribute,
			ConstraintSystem constraintSystem) {
		super(variable, attribute, constraintSystem);
	}

	public Collection<O> getGeneratedValue(BindingNode node) {
		Set<O> toReturn = null;
		Set<BindingNode> leaves = this.getConstraintSystem().getLeaves();
		if (leaves != null && !leaves.isEmpty()) {
			toReturn = new HashSet<O>();
			for (BindingNode bindingNode : leaves) {
				O assignmentValue = (O) bindingNode.getAssignmentValue(this.getVariable());
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

	public List<Collection<O>> computePossibleValues() {
		List<Collection<O>> toReturn = new ArrayList<Collection<O>>();
		Collection<O> generatedValue = this.getGeneratedValue(null);
		if (generatedValue != null) {
			toReturn.add(Collections.unmodifiableCollection(generatedValue));
		}
		return toReturn;
	}

	public void accept(SingleValueGeneratedValueVisitor visitor) {
		visitor.visitOWLObjectCollectionGeneratedValue(this);
	}

	public <P> P accept(SingleValueGeneratedValueVisitorEx<P> visitor) {
		return visitor.visitOWLObjectCollectionGeneratedValue(this);
	}
}