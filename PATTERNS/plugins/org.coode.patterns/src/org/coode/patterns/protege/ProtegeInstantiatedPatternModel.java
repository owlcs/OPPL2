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
package org.coode.patterns.protege;

import java.util.Set;

import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.utils.ProtegeParserFactory;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternModel;
import org.coode.patterns.syntax.PatternParser;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 *         Jun 12, 2008
 */
public class ProtegeInstantiatedPatternModel extends InstantiatedPatternModel {
	protected OWLModelManager modelManager;
	protected OPPLParser parser;

	public ProtegeInstantiatedPatternModel(PatternModel patternModel) {
		super(patternModel);
	}

	public ProtegeInstantiatedPatternModel(ProtegePatternModel patternModel) {
		super(patternModel);
		this.modelManager = patternModel.modelManager;
	}

	protected void initOPPLParser(String s) {
		this.parser = ProtegeParserFactory.initParser(s, this.modelManager,
				null);
	}

	protected PatternParser initParser(String s) {
		return org.coode.patterns.protege.utils.ProtegeParserFactory.initProtegeParser(s,
				this.modelManager);
	}

	@Override
	protected String render(OWLObject owlObject) {
		return this.modelManager.getRendering(owlObject);
	}

	@Override
	public String render() {
		StringBuilder toReturn = new StringBuilder("$"
				+ getInstantiatedPatternLocalName() + "(");
		boolean first = true;
		for (Variable variable : getInputVariables()) {
			if (!first) {
				toReturn.append(", ");
			} else {
				first = false;
			}
			Set<OWLObject> instantiationsValues = getInstantiations(variable);
			if (instantiationsValues != null && !instantiationsValues.isEmpty()) {
				if (instantiationsValues.size() == 1) {
					OWLObject instantiation = instantiationsValues.iterator()
							.next();
					toReturn.append(this.modelManager
							.getRendering(instantiation));
				} else {
					boolean firstInstantiation = true;
					toReturn.append("{");
					for (OWLObject instantiation : instantiationsValues) {
						String instantiationRendering = this.modelManager
								.getRendering(instantiation);
						toReturn
								.append(firstInstantiation ? instantiationRendering
										: ", " + instantiationRendering);
						firstInstantiation = firstInstantiation ? false
								: firstInstantiation;
					}
					toReturn.append("}");
				}
			} else {
				toReturn.append(variable.getName());
			}
		}
		toReturn.append(")");
		return toReturn.toString();
	}
	// @Override
	// public String getRendering() {
	// String toReturn = this.getPatternModel().getName();
	// for (Variable variable : this.getVariables()) {
	// Set<OWLObject> instantiationValues = this
	// .getInstantiations(variable);
	// if (instantiationValues != null) {
	// String replacement = "";
	// if (instantiationValues.size() == 1) {
	// replacement = this.modelManager
	// .getRendering(instantiationValues.iterator().next());
	// } else {
	// replacement += "{";
	// boolean first = true;
	// for (OWLObject object : instantiationValues) {
	// replacement += first ? this.modelManager
	// .getRendering(object) : ", "
	// + this.modelManager.getRendering(object);
	// first = first ? false : first;
	// }
	// replacement += "}";
	// }
	// toReturn = toReturn.replaceAll("\\" + variable.getName(),
	// replacement);
	// }
	// }
	// return toReturn;
	// }
}
