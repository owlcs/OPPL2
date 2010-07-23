package org.coode.oppl.variablemansyntax.generated.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.generated.AttributeGenerator;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;

final class RenderingAttributeGenerator implements AttributeGenerator<String> {
	private final OWLEntityRenderer entityRenderer;
	private static RenderingAttributeGenerator instance = null;
	private final ConstraintSystem constraintSystem;

	private RenderingAttributeGenerator(ConstraintSystem cs) {
		assert cs != null;
		this.constraintSystem = cs;
		this.entityRenderer = ParserFactory.getInstance().getOPPLFactory()
				.getOWLEntityRenderer(this.constraintSystem);
	}

	protected synchronized static RenderingAttributeGenerator getInstance(
			ConstraintSystem cs) {
		if (instance == null) {
			instance = new RenderingAttributeGenerator(cs);
		}
		return instance;
	}

	public String getValue(OWLObject object) {
		String toReturn = null;
		if (object instanceof OWLEntity) {
			toReturn = this.entityRenderer.render((OWLEntity) object);
		} else if (object instanceof OWLConstant) {
			toReturn = ((OWLConstant) object).getLiteral();
		} else {
			toReturn = object == null ? null : object.toString();
		}
		return toReturn;
	}

	public List<String> getValues(Variable variable) {
		List<String> toReturn = new ArrayList<String>();
		Set<OWLObject> possibleBindings = variable.getPossibleBindings();
		for (OWLObject object : possibleBindings) {
			if (object instanceof OWLEntity) {
				toReturn.add(this.entityRenderer.render((OWLEntity) object));
			} else {
				toReturn.add(object.toString());
			}
		}
		return toReturn;
	}
}