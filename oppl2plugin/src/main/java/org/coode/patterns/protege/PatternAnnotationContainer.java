package org.coode.patterns.protege;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Iterator;
import java.util.Set;

import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternManager;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.AnnotationContainer;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLOntology;

/** @author Luigi Iannone */
public class PatternAnnotationContainer implements AnnotationContainer {
    private final OWLEditorKit owlEditorKit;
    private final PatternExtractor patternExtractor;

    /** @param owlEditorKit
     *            owlEditorKit */
    public PatternAnnotationContainer(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        patternExtractor = new PatternExtractor(getOntology(), getOWLEditorKit()
                .getOWLModelManager().getOWLOntologyManager(),
                PatternManager.getDefaultErrorListener());
    }

    @Override
    public Set<OWLAnnotation> getAnnotations() {
        OWLOntology activeOntology = getOWLEditorKit().getOWLModelManager()
                .getActiveOntology();
        Set<OWLAnnotation> toReturn = activeOntology.getAnnotations();
        Iterator<OWLAnnotation> iterator = toReturn.iterator();
        while (iterator.hasNext()) {
            OWLAnnotation annotation = iterator.next();
            PatternOPPLScript extracted = getPatternModel(annotation);
            if (extracted == null) {
                iterator.remove();
            }
        }
        return toReturn;
    }

    /** @param annotation
     *            annotation
     * @return pattern model */
    public PatternModel getPatternModel(OWLAnnotation annotation) {
        PatternOPPLScript extracted = annotation.accept(patternExtractor);
        return (PatternModel) extracted;
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @return current ontology */
    public OWLOntology getOntology() {
        return getOWLEditorKit().getOWLModelManager().getActiveOntology();
    }
}
