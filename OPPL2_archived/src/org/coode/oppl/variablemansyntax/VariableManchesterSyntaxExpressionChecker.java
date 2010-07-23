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
package org.coode.oppl.variablemansyntax;

import java.util.List;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.syntax.OPPLParser;
import org.coode.oppl.syntax.ParseException;
import org.coode.oppl.syntax.TokenMgrError;
import org.coode.oppl.utils.ParserFactory;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class VariableManchesterSyntaxExpressionChecker implements
		OWLExpressionChecker<OPPLScript> {
	private final OWLOntologyManager manager;
	private final OWLReasoner reasoner;
	private OWLOntology ontology;
	private OPPLScript lastCheckedObject = null;

	public VariableManchesterSyntaxExpressionChecker(OWLOntologyManager mgr,
			OWLOntology onto, OWLReasoner r) {
		this.manager = mgr;
		this.ontology = onto;
		this.reasoner = r;
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#check(java.lang.String)
	 */
	public void check(String text) throws OWLExpressionParserException {
		this.lastCheckedObject = null;
		OPPLParser parser = initParser(text);
		try {
			OPPLScript statementModel = parser.Start();
			if (this.reasoner == null || this.reasoner instanceof NoOpReasoner) {
				List<Variable> variables = statementModel.getInputVariables();
				for (Variable v : variables) {
					if (v.getVariableScope() != null) {
						throw new OWLExpressionParserException(
								new Exception(
										"Variable "
												+ v.toString()
												+ " has got a scope restriction and there is no Reasoner activated to check"));
					}
				}
			}
			this.lastCheckedObject = statementModel;
		} catch (ParseException e) {
			throw new OWLExpressionParserException(e);
		} catch (TokenMgrError tme) {
			throw new OWLExpressionParserException(tme);
		}
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#createObject(java.lang.String)
	 */
	public OPPLScript createObject(String text)
			throws OWLExpressionParserException {
		check(text);
		return this.lastCheckedObject;
	}

	/**
	 * @param text
	 * @return
	 */
	protected OPPLParser initParser(String text) {
		return ParserFactory.initParser(text, this.ontology, this.manager,
				this.reasoner);
	}
}
