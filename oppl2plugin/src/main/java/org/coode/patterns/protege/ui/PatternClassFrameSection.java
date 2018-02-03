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

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.protege.ProtegeParserFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.protege.editor.owl.ui.editor.OWLObjectEditor;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrame;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRow;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.search.EntitySearcher;

/**
 * @author Luigi Iannone
 */
public class PatternClassFrameSection extends
    AbstractOWLFrameSection<OWLClass, OWLAnnotationAssertionAxiom, InstantiatedPatternModel> {

    private static final String LABEL = "Patterns";
    private final AbstractPatternModelFactory factory;

    protected PatternClassFrameSection(OWLEditorKit editorKit, OWLFrame<? extends OWLClass> frame,
        AbstractPatternModelFactory f) {
        super(editorKit, LABEL, frame);
        factory = f;
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    protected void clear() {}

    @Override
    public Comparator<OWLFrameSectionRow<OWLClass, OWLAnnotationAssertionAxiom, InstantiatedPatternModel>> getRowComparator() {
        return null;
    }

    @Override
    protected OWLAnnotationAssertionAxiom createAxiom(
        InstantiatedPatternModel instantiatedPattern) {
        OWLDataFactory dataFactory = getOWLDataFactory();
        OWLLiteral constant = dataFactory.getOWLLiteral(instantiatedPattern.toString());
        IRI annotationIRI = IRI.create(PatternModel.NAMESPACE
            + instantiatedPattern.getInstantiatedPatternLocalName() + "PatternInstantiation");
        OWLAnnotation annotation = dataFactory
            .getOWLAnnotation(dataFactory.getOWLAnnotationProperty(annotationIRI), constant);
        OWLAnnotationAssertionAxiom axiom = getOWLDataFactory()
            .getOWLAnnotationAssertionAxiom(getRootObject().getIRI(), annotation);
        return axiom;
    }

    @Override
    public OWLObjectEditor<InstantiatedPatternModel> getObjectEditor() {
        return new PatternInstantiationEditor(getOWLEditorKit(), getRootObject(), factory);
    }

    @Override
    protected void refill(OWLOntology ontology) {
        OWLClass rootObject = getRootObject();
        PatternExtractor patternExtractor =
            factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
        EntitySearcher.getAnnotationAssertionAxioms(rootObject.getIRI(), ontology).forEach(ax -> {
            PatternOPPLScript statementModel = ax.getAnnotation().accept(patternExtractor);
            if (statementModel != null) {
                addRow(new PatternClassFrameSectionRow(getOWLEditorKit(), this, ontology,
                    getRootObject(), ax, factory));
            }
        });
    }

    @Override
    protected void refillInferred() throws OWLRuntimeException {}

    @Override
    public void visit(OWLAnnotationAssertionAxiom annotationAxiom) {
        if (annotationAxiom.getSubject().equals(getRootObject().getIRI())) {
            PatternExtractor patternExtractor =
                factory.getPatternExtractor(ProtegeParserFactory.getDefaultErrorListener());
            OWLAnnotation annotation = annotationAxiom.getAnnotation();
            if (annotation.accept(patternExtractor) != null) {
                reset();
            }
        }
    }

    @Override
    public void handleEditingFinished(Set<InstantiatedPatternModel> editedObjects) {
        Iterator<InstantiatedPatternModel> it = editedObjects.iterator();
        boolean found = false;
        InstantiatedPatternModel instantiatedPatternModel = null;
        while (!found && it.hasNext()) {
            instantiatedPatternModel = it.next();
            found = instantiatedPatternModel.hasScopedVariables()
                && getOWLEditorKit().getModelManager().getReasoner() instanceof NoOpReasoner;
            if (found) {
                JOptionPane.showConfirmDialog(getOWLEditorKit().getWorkspace(), "The pattern model "
                    + instantiatedPatternModel.getName()
                    + " has got scoped variables but you are curently using a NoOpReasoner, the pattern will not work properly unless you activate reasoning.",
                    "No Reasoner", JOptionPane.OK_OPTION);
            } else {
                super.handleEditingFinished(editedObjects);
            }
        }
    }
}
