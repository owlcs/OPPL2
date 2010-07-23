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

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import org.apache.log4j.Logger;
import org.coode.patterns.protege.utils.ProtegeParserFactory;
import org.coode.patterns.syntax.ParseException;
import org.coode.patterns.syntax.PatternParser;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLDescriptionAutoCompleter;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;

/**
 * @author Luigi Iannone
 * 
 *         Jul 2, 2008
 */
@SuppressWarnings("unchecked")
public class InstantiatedPatternCompleter extends
		AbstractInstantiatedPatternCompleter {
	private static final Logger logger = Logger
			.getLogger(OWLDescriptionAutoCompleter.class);

	@Override
	protected Logger getLogger() {
		return logger;
	}

	public InstantiatedPatternCompleter(OWLEditorKit owlEditorKit,
			JTextComponent tc, OWLExpressionChecker checker) {
		super(owlEditorKit, tc);
	}

	@Override
	protected List<? extends Object> getMatches() {
		PatternParser parser = ProtegeParserFactory.initProtegeParser(
				this.textComponent.getText(), this.owlEditorKit
						.getModelManager());
		List<? extends Object> toReturn = new ArrayList<Object>();
		try {
			parser.Start();
			toReturn = parser.getCompletions();
		} catch (ParseException e) {
			toReturn = parser.getCompletions();
		} finally {
			String wordToComplete = getWordToComplete();
			if (wordToComplete.trim().length() > 0) {
				for (Object object : new ArrayList(toReturn)) {
					if (!object.toString().startsWith(wordToComplete)) {
						toReturn.remove(object);
					}
				}
			}
		}
		return toReturn;
	}

	@Override
	protected int getWordIndex() {
		try {
			int caretPos = this.textComponent.getCaretPosition() - 1;
			for (int index = caretPos; index > -1; index--) {
				if (this.wordDelimeters.contains(this.textComponent
						.getDocument().getText(index, 1))) {
					return index + 1;
				}
				if (index == 0) {
					return 0;
				}
			}
		} catch (BadLocationException e) {
			logger.error(e);
		}
		return -1;
	}
}
