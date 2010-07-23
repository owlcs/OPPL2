/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl.protege;

import java.util.List;

import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptVisitor;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.protege.ui.VariableOWLObjectRenderer;
import org.coode.oppl.protege.ui.rendering.ShortFormVariableOWLEntityRenderer;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeOPPLScript implements OPPLScript {
	private final OPPLScript opplScript;
	private final VariableOWLObjectRenderer variableOWLObjectRenderer;
	private final ShortFormVariableOWLEntityRenderer entityRenderer;

	/**
	 * @param opplScript
	 * @param modelManager
	 */
	public ProtegeOPPLScript(OPPLScript opplScript, OWLModelManager modelManager) {
		this.opplScript = opplScript;
		this.variableOWLObjectRenderer = new VariableOWLObjectRenderer(
				modelManager);
		this.entityRenderer = new ShortFormVariableOWLEntityRenderer(opplScript
				.getConstraintSystem());
	}

	/**
	 * @see org.coode.oppl.OPPLScript#accept(org.coode.oppl.OPPLScriptVisitor)
	 */
	public void accept(OPPLScriptVisitor visitor) {
		this.opplScript.accept(visitor);
	}

	/**
	 * @see org.coode.oppl.OPPLScript#accept(org.coode.oppl.OPPLScriptVisitorEx)
	 */
	public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
		return this.opplScript.accept(visitor);
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getActions()
	 */
	public List<OWLAxiomChange> getActions() {
		return this.opplScript.getActions();
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getConstraintSystem()
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.opplScript.getConstraintSystem();
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getInputVariables()
	 */
	public List<Variable> getInputVariables() {
		return this.opplScript.getInputVariables();
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getQuery()
	 */
	public OPPLQuery getQuery() {
		return this.opplScript.getQuery();
	}

	/**
	 * @see org.coode.oppl.OPPLScript#getVariables()
	 */
	public List<Variable> getVariables() {
		return this.opplScript.getVariables();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		boolean first = true;
		for (Variable v : getVariables()) {
			String commaString = first ? "" : ", ";
			first = false;
			buffer.append(commaString);
			buffer.append(v.toString());
		}
		buffer.append(' ');
		OPPLQuery opplQuery = getQuery();
		if (getQuery() != null) {
			buffer.append(opplQuery.toString());
		}
		if (getActions().size() > 0) {
			buffer.append(" BEGIN ");
			first = true;
			for (OWLAxiomChange action : getActions()) {
				String commaString = first ? "" : ", ";
				String actionString = action instanceof AddAxiom ? "ADD "
						: "REMOVE ";
				first = false;
				buffer.append(commaString);
				buffer.append(actionString);
				buffer.append(this.variableOWLObjectRenderer.render(action
						.getAxiom(), this.entityRenderer));
			}
			buffer.append(" END;");
		}
		return buffer.toString();
	}

	public String render() {
		return this.opplScript.render();
	}

	public void addVariable(Variable variable) {
		this.opplScript.addVariable(variable);
	}
}
