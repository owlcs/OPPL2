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

/** @author Luigi Iannone Jul 3, 2008 */
public class PatternOntologyView extends AbstractActiveOntologyViewComponent {
    private static final long serialVersionUID = 20100L;
    private PatternModelList list;
    private PatternManager patternManager;

    @Override
    protected void disposeOntologyView() {
        if (list != null) {
            list.dispose();
        }
        if (patternManager != null) {
            getOWLEditorKit().getModelManager().removeOntologyChangeListener(
                    patternManager);
        }
        ProtegeParserFactory.getInstance(getOWLEditorKit()).dispose();
    }

    @Override
    protected void initialiseOntologyView() throws Exception {
        setLayout(new BorderLayout());
        list = new PatternModelList(getOWLEditorKit());
        AbstractPatternModelFactory patternFactory = org.coode.patterns.protege.ProtegeParserFactory
                .getInstance(getOWLEditorKit()).getPatternFactory();
        list.setRootObject(new PatternAnnotationContainer(getOWLEditorKit()));
        list.setCellRenderer(new PatternCellRenderer(getOWLEditorKit()));
        JScrollPane listPane = ComponentFactory.createScrollPane(list);
        patternManager = PatternManager.getInstance(getOWLEditorKit().getModelManager()
                .getOWLOntologyManager(), patternFactory);
        getOWLEditorKit().getModelManager().addOntologyChangeListener(patternManager);
        this.add(listPane);
    }

    @Override
    protected void updateView(OWLOntology activeOntology) throws Exception {
        list.setRootObject(new PatternAnnotationContainer(getOWLEditorKit()));
    }
}
