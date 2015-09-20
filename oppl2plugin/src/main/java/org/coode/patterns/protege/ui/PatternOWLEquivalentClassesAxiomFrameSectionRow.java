package org.coode.patterns.protege.ui;

import org.coode.patterns.PatternModel;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.cls.OWLEquivalentClassesAxiomFrameSectionRow;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLOntology;

/** frame section row for equivalent classes */
public class PatternOWLEquivalentClassesAxiomFrameSectionRow extends
    OWLEquivalentClassesAxiomFrameSectionRow {

    private final PatternModel generatingPatternModel;

    /**
     * @param owlEditorKit
     *        owlEditorKit
     * @param section
     *        section
     * @param ontology
     *        ontology
     * @param rootObject
     *        rootObject
     * @param axiom
     *        axiom
     * @param generatingPatternModel
     *        generatingPatternModel
     */
    public PatternOWLEquivalentClassesAxiomFrameSectionRow(OWLEditorKit owlEditorKit,
        PatternOWLEquivalentClassesAxiomFrameSection section, OWLOntology ontology,
        OWLClass rootObject, OWLEquivalentClassesAxiom axiom,
        PatternModel generatingPatternModel) {
        super(owlEditorKit, section, ontology, rootObject, axiom);
        this.generatingPatternModel = generatingPatternModel;
    }

    @Override
    public boolean isDeleteable() {
        return false;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    /**
     * @return the generatingPatternModel
     */
    public final PatternModel getGeneratingPatternModel() {
        return generatingPatternModel;
    }
}
