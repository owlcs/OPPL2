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

import org.coode.oppl.OPPLScript;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.UnsuitableOPPLScriptException;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.util.BidirectionalShortFormProvider;
import org.semanticweb.owl.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owl.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 *         Jun 12, 2008
 */
public class ProtegePatternModel extends PatternModel {
	protected OWLModelManager modelManager;

	/**
	 * @param ontologyManager
	 * @param modelManager
	 * @throws UnsuitableOPPLScriptException
	 */
	public ProtegePatternModel(OPPLScript opplScript,
			OWLModelManager modelManager, AbstractPatternModelFactory f)
			throws UnsuitableOPPLScriptException {
		super(opplScript, modelManager.getOWLOntologyManager(), f);
		this.modelManager = modelManager;
	}

	// @Override
	// public String toString() {
	// // String renderedString = super.toString();
	// // StringBuilder toReturn = new StringBuilder();
	// // StringTokenizer tokenizer = new StringTokenizer(renderedString,
	// // " \n\t,[()];", true);
	// // while (tokenizer.hasMoreTokens()) {
	// // toReturn.append(unRender(tokenizer.nextToken()));
	// // }
	// // return toReturn.toString();
	//		
	// }
	private String unRender(String chunk) {
		String toReturn = chunk;
		OWLEntity object = this.modelManager.getOWLEntity(chunk);
		if (object != null) {
			BidirectionalShortFormProvider bidirectionalShortFormProvider = new BidirectionalShortFormProviderAdapter(
					this.modelManager.getOntologies(),
					new SimpleShortFormProvider());
			String shortForm = bidirectionalShortFormProvider
					.getShortForm(object);
			if (shortForm != null) {
				toReturn = shortForm;
			}
		}
		return toReturn;
	}
}
