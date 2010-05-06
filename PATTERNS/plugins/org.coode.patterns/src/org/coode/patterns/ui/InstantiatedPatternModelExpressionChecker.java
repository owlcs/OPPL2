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
package org.coode.patterns.ui;

import org.coode.patterns.NonClassAssignablePatternException;
import org.coode.patterns.protege.ProtegeInstantiatedPatternModel;
import org.coode.patterns.protege.utils.ProtegeParserFactory;
import org.coode.patterns.syntax.ParseException;
import org.coode.patterns.syntax.PatternParser;
import org.coode.patterns.syntax.TokenMgrError;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;

/**
 * @author Luigi Iannone
 * 
 *         Jul 2, 2008
 */
public class InstantiatedPatternModelExpressionChecker implements
		OWLExpressionChecker<ProtegeInstantiatedPatternModel> {
	private OWLEditorKit owlEditorKit;
	private ProtegeInstantiatedPatternModel lastCreatedObject;
	private boolean classPatternRequired;

	/**
	 * Builds an ExpressionChecker for instantiated pattern models, if the
	 * parameter classPatterRequired is true, this will accept only patterns
	 * that can be applied to an OWL class
	 * 
	 * @param owlEditorKit
	 * @param classPatternRequired
	 */
	public InstantiatedPatternModelExpressionChecker(OWLEditorKit owlEditorKit,
			boolean classPatternRequired) {
		this.owlEditorKit = owlEditorKit;
		this.classPatternRequired = classPatternRequired;
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#check(java.lang.String)
	 */
	public void check(String text) throws OWLExpressionParserException {
		this.lastCreatedObject = null;
		PatternParser parser = ProtegeParserFactory.initProtegeParser(text,
				this.owlEditorKit.getModelManager());
		try {
			ProtegeInstantiatedPatternModel pattern = (ProtegeInstantiatedPatternModel) parser
					.Start();
			if (!this.classPatternRequired || pattern.isClassPattern()) {
				this.lastCreatedObject = pattern;
			} else {
				this.lastCreatedObject = null;
				throw new OWLExpressionParserException(
						new NonClassAssignablePatternException(pattern
								.getInstantiatedPatternLocalName()));
			}
		} catch (ParseException e) {
			this.lastCreatedObject = null;
			throw new OWLExpressionParserException(e);
		} catch (TokenMgrError e) {
			this.lastCreatedObject = null;
			throw new OWLExpressionParserException(e);
		}
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#createObject(java.lang.String)
	 */
	public ProtegeInstantiatedPatternModel createObject(String text)
			throws OWLExpressionParserException {
		return this.lastCreatedObject;
	}
}
