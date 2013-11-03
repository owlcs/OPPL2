package org.coode.oppl.protege;

import java.util.Set;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.find.OWLEntityFinder;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public final class ProtegeOWLEntityChecker implements OWLEntityChecker {
	private final OWLEditorKit owlEditorKit;
	private final OWLEntityFinder delegate;

	/**
	 * @param protegeParserFactory
	 */
	public ProtegeOWLEntityChecker(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.delegate = this.getOWLEditorKit().getOWLModelManager()
				.getOWLEntityFinder();
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLAnnotationProperty(java.lang.String)
	 */
	public OWLAnnotationProperty getOWLAnnotationProperty(String rendering) {
		return this.delegate.getOWLAnnotationProperty(rendering);
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLClass(java.lang.String)
	 */
	public OWLClass getOWLClass(String rendering) {
		return this.delegate.getOWLClass(rendering);
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLDataProperty(java.lang.String)
	 */
	public OWLDataProperty getOWLDataProperty(String rendering) {
		return this.delegate.getOWLDataProperty(rendering);
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLDatatype(java.lang.String)
	 */
	public OWLDatatype getOWLDatatype(String rendering) {
		return this.delegate.getOWLDatatype(rendering);
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLEntity(java.lang.String)
	 */
	public OWLEntity getOWLEntity(String rendering) {
		return this.delegate.getOWLEntity(rendering);
	}

	/**
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLEntityRenderings()
	 */
	public Set<String> getOWLEntityRenderings() {
		return this.delegate.getOWLEntityRenderings();
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLIndividual(java.lang.String)
	 */
	public OWLNamedIndividual getOWLIndividual(String rendering) {
		return this.delegate.getOWLIndividual(rendering);
	}

	/**
	 * @param rendering
	 * @return
	 * @see org.protege.editor.owl.model.find.OWLEntityFinder#getOWLObjectProperty(java.lang.String)
	 */
	public OWLObjectProperty getOWLObjectProperty(String rendering) {
		return this.delegate.getOWLObjectProperty(rendering);
	}
}