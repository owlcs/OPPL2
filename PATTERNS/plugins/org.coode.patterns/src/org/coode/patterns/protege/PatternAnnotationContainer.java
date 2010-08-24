/**
 * 
 */
package org.coode.patterns.protege;

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

/**
 * @author Luigi Iannone
 * 
 */
public class PatternAnnotationContainer implements AnnotationContainer {
	private final OWLEditorKit owlEditorKit;
	private final PatternExtractor patternExtractor;

	/**
	 * @param owlEditorKit
	 */
	public PatternAnnotationContainer(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor Kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.patternExtractor = ProtegeParserFactory.getInstance(
				this.getOWLEditorKit()).getPatternFactory()
				.getPatternExtractor(PatternManager.getDefaultErrorListener());
	}

	/**
	 * @see org.protege.editor.owl.model.AnnotationContainer#getAnnotations()
	 */
	public Set<OWLAnnotation> getAnnotations() {
		OWLOntology activeOntology = this.getOWLEditorKit()
				.getOWLModelManager().getActiveOntology();
		Set<OWLAnnotation> toReturn = activeOntology.getAnnotations();
		Iterator<OWLAnnotation> iterator = toReturn.iterator();
		while (iterator.hasNext()) {
			OWLAnnotation annotation = iterator.next();
			PatternOPPLScript extracted = this.getPatternModel(annotation);
			if (extracted == null) {
				iterator.remove();
			}
		}
		return toReturn;
	}

	/**
	 * @param annotation
	 * @return
	 */
	public PatternModel getPatternModel(OWLAnnotation annotation) {
		PatternOPPLScript extracted = annotation.accept(this.patternExtractor);
		return (PatternModel) extracted;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	public OWLOntology getOntology() {
		return this.getOWLEditorKit().getOWLModelManager().getActiveOntology();
	}
}
