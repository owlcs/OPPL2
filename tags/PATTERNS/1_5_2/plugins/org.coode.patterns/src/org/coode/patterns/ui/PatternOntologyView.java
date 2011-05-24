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

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternManager;
import org.coode.patterns.protege.PatternAnnotationContainer;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 *         Jul 3, 2008
 */
public class PatternOntologyView extends AbstractActiveOntologyViewComponent {
	/**
	 *
	 */
	private static final long serialVersionUID = -8110091764534100865L;
	private PatternModelList list;
	private PatternManager patternManager;

	// private AbstractPatternModelFactory factory;
	/**
	 * @see org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent#disposeOntologyView()
	 */
	@Override
	protected void disposeOntologyView() {
		if (this.list != null) {
			this.list.dispose();
		}
		if (this.patternManager != null) {
			this.getOWLEditorKit().getModelManager().removeOntologyChangeListener(
					this.patternManager);
		}
		ProtegeParserFactory.getInstance(this.getOWLEditorKit()).dispose();
	}

	/**
	 * @see org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent#initialiseOntologyView()
	 */
	@Override
	protected void initialiseOntologyView() throws Exception {
		this.setLayout(new BorderLayout());
		this.list = new PatternModelList(this.getOWLEditorKit());
		AbstractPatternModelFactory patternFactory = org.coode.patterns.protege.ProtegeParserFactory.getInstance(
				this.getOWLEditorKit()).getPatternFactory();
		this.list.setRootObject(new PatternAnnotationContainer(this.getOWLEditorKit()));
		this.list.setCellRenderer(new PatternCellRenderer(this.getOWLEditorKit(), patternFactory));
		JScrollPane listPane = ComponentFactory.createScrollPane(this.list);
		this.patternManager = PatternManager.getInstance(
				this.getOWLEditorKit().getModelManager().getOWLOntologyManager(),
				patternFactory);
		this.getOWLEditorKit().getModelManager().addOntologyChangeListener(this.patternManager);
		this.add(listPane);
	}

	/**
	 * @see org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent#updateView(org.semanticweb.owl.model.OWLOntology)
	 */
	@Override
	protected void updateView(OWLOntology activeOntology) throws Exception {
		this.list.setRootObject(new PatternAnnotationContainer(this.getOWLEditorKit()));
	}
}
