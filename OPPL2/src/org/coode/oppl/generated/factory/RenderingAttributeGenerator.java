package org.coode.oppl.generated.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.AttributeGenerator;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owl.model.OWLObject;

final class RenderingAttributeGenerator implements AttributeGenerator<String> {
	private static RenderingAttributeGenerator instance = null;
	private final ConstraintSystem constraintSystem;

	private RenderingAttributeGenerator(ConstraintSystem cs) {
		assert cs != null;
		this.constraintSystem = cs;
	}

	protected synchronized static RenderingAttributeGenerator getInstance(ConstraintSystem cs) {
		if (instance == null) {
			instance = new RenderingAttributeGenerator(cs);
		}
		return instance;
	}

	public String getValue(OWLObject object) {
		String toReturn = null;
		if (object != null) {
			ManchesterSyntaxRenderer manchesterSyntaxRenderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
					this.getConstraintSystem());
			object.accept(manchesterSyntaxRenderer);
			toReturn = manchesterSyntaxRenderer.toString();
		}
		return toReturn;
	}

	public List<String> getValues(Variable variable) {
		List<String> toReturn = new ArrayList<String>();
		Set<BindingNode> leaves = this.getConstraintSystem().getLeaves();
		for (BindingNode bindingNode : leaves) {
			OWLObject assignmentValue = bindingNode.getAssignmentValue(variable);
			if (assignmentValue != null) {
				ManchesterSyntaxRenderer manchesterSyntaxRenderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
						this.getConstraintSystem());
				assignmentValue.accept(manchesterSyntaxRenderer);
				toReturn.add(manchesterSyntaxRenderer.toString());
			}
		}
		return toReturn;
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}