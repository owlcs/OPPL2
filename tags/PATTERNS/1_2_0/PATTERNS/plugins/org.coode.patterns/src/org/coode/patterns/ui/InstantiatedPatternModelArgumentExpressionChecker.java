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

import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternModel;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;

/**
 * @author Luigi Iannone
 * 
 *         Sep 18, 2008
 */
public class InstantiatedPatternModelArgumentExpressionChecker implements
		OWLExpressionChecker<InstantiatedPatternModel> {
	InstantiatedPatternModelExpressionChecker delegate;
	private InstantiatedPatternModel lastCreatedObject;
	private String name;
	private boolean classRequired = false;

	/**
	 * Builds a InstantiatedPatternModelArgumentExpressionChecker for the
	 * pattern with the specified pattern name, irrespective of whether the
	 * pattern is applicable to classes or not.
	 * 
	 * @param patternName
	 * @param owlEditorKit
	 */
	public InstantiatedPatternModelArgumentExpressionChecker(
			String patternName, OWLEditorKit owlEditorKit) {
		this.delegate = new InstantiatedPatternModelExpressionChecker(
				owlEditorKit, this.classRequired);
		this.name = patternName;
	}

	/**
	 * Builds a InstantiatedPatternModelArgumentExpressionChecker for the
	 * pattern with the specified pattern name. Depending on the value of the
	 * classRequired parameter, it will accept (classRequired = false) or not
	 * (classRequired = true) patterns that cannot be applied to OWL classes
	 * 
	 * @see PatternModel#isClassPattern()
	 * 
	 * @param patternName
	 * @param owlEditorKit
	 * @param classRequired
	 */
	public InstantiatedPatternModelArgumentExpressionChecker(
			String patternName, OWLEditorKit owlEditorKit, boolean classRequired) {
		this.delegate = new InstantiatedPatternModelExpressionChecker(
				owlEditorKit, classRequired);
		this.name = patternName;
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#check(java.lang.String)
	 */
	public void check(String text) throws OWLExpressionParserException {
		this.lastCreatedObject = null;
		String string = "$" + this.name + "(" + text + ")";
		this.delegate.check(string);
		this.lastCreatedObject = this.delegate.createObject(string);
	}

	/**
	 * @see org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker#createObject(java.lang.String)
	 */
	public InstantiatedPatternModel createObject(String text)
			throws OWLExpressionParserException {
		return this.lastCreatedObject;
	}
}
