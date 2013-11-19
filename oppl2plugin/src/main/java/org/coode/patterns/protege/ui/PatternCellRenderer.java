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
package org.coode.patterns.protege.ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.coode.patterns.utils.Utils;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/** @author Luigi Iannone Jun 19, 2008 */
public class PatternCellRenderer implements ListCellRenderer {
    private final OWLEditorKit owlEditorKit;
    private final OWLCellRenderer owlCellRenderer;

    /** @param owlEditorKit
     * @param f */
    public PatternCellRenderer(OWLEditorKit owlEditorKit) {
        ArgCheck.checkNullArgument("The OWL Editor Kit", owlEditorKit);
        this.owlEditorKit = owlEditorKit;
        owlCellRenderer = new OWLCellRenderer(this.owlEditorKit);
        owlCellRenderer.setHighlightKeywords(true);
        owlCellRenderer.setWrap(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        JPanel toReturn = new JPanel(new FlowLayout());
        PatternExtractor patternExtractor = ProtegeParserFactory
                .getInstance(getOWLEditorKit()).getPatternFactory()
                .getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
        if (value instanceof PatternClassFrameSectionRow) {
            JLabel valueRendering = new JLabel();
            OWLAnnotationAssertionAxiom annotationAxAnnotation = ((PatternClassFrameSectionRow) value)
                    .getAxiom();
            OWLAnnotation annotation = annotationAxAnnotation.getAnnotation();
            PatternOPPLScript patternModel = annotation.accept(patternExtractor);
            if (patternModel != null) {
                valueRendering.setText(patternModel.getRendering());
            } else {
                valueRendering.setText(value.toString());
            }
            toReturn.add(valueRendering);
        } else if (value instanceof PatternModelList.PatternListItem) {
            PatternModelList.PatternListItem row = (PatternModelList.PatternListItem) value;
            OWLAnnotation annotation = row.getAnnotation();
            PatternModel patternModel = (PatternModel) annotation
                    .accept(patternExtractor);
            if (patternModel != null) {
                String rendering = patternModel.getRendering();
                if (rendering == null) {
                    // Then rendering is patternName(?var1,...,?varn)
                    StringBuilder b = new StringBuilder(patternModel.getName());
                    b.append("(");
                    List<InputVariable<?>> variableList = patternModel
                            .getInputVariables();
                    for (int i = 0; i < variableList.size(); i++) {
                        if (i > 0) {
                            b.append(" , ");
                        }
                        b.append(variableList.get(i).getName());
                    }
                    b.append(")");
                    rendering = b.toString();
                }
                toReturn.add(new JLabel(rendering));
            } else {
                toReturn.add(new JLabel(value.toString()));
            }
        } else if (value instanceof PatternOWLEquivalentClassesAxiomFrameSectionRow) {
            OWLEquivalentClassesAxiom annotationAxiom = ((PatternOWLEquivalentClassesAxiomFrameSectionRow) value)
                    .getAxiom();
            Set<OWLAnnotation> annotations = annotationAxiom.getAnnotations();
            if (Utils.isPatternGenerated(annotations)) {
                Set<OWLClassExpression> descriptions = new HashSet<OWLClassExpression>(
                        annotationAxiom.getClassExpressions());
                descriptions
                        .remove(((PatternOWLEquivalentClassesAxiomFrameSectionRow) value)
                                .getRoot());
                return owlCellRenderer.getListCellRendererComponent(list, descriptions
                        .iterator().next(), index, isSelected, cellHasFocus);
            }
        } else if (value instanceof PatternOWLSubClassAxiomFrameSectionRow) {
            OWLSubClassOfAxiom annotationAxiom = ((PatternOWLSubClassAxiomFrameSectionRow) value)
                    .getAxiom();
            Set<OWLAnnotation> annotations = annotationAxiom.getAnnotations();
            if (Utils.isPatternGenerated(annotations)) {
                return owlCellRenderer.getListCellRendererComponent(list,
                        annotationAxiom.getSuperClass(), index, isSelected, cellHasFocus);
            }
        }
        return toReturn;
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }
}
