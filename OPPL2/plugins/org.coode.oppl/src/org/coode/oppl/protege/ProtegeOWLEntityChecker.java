package org.coode.oppl.protege;

import org.coode.oppl.utils.DefaultOWLObjectVisitorEx;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class ProtegeOWLEntityChecker implements OWLEntityChecker {
	private final OWLEditorKit owlEditorKit;

	/**
	 * @param protegeParserFactory
	 */
	public ProtegeOWLEntityChecker(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
	}

	public OWLClass getOWLClass(String name) {
		OWLClass toReturn = null;
		OWLEntity owlEntity = this.getOWLEditorKit().getOWLModelManager().getOWLEntity(name);
		if (owlEntity != null) {
			toReturn = owlEntity.accept(new DefaultOWLObjectVisitorEx<OWLClass>() {
				@Override
				protected OWLClass doDefault(OWLObject object) {
					return null;
				}

				@Override
				public OWLClass visit(OWLClass desc) {
					return desc;
				}
			});
		}
		return toReturn;
	}

	public OWLDataProperty getOWLDataProperty(String name) {
		OWLDataProperty toReturn = null;
		OWLEntity owlEntity = this.getOWLEditorKit().getOWLModelManager().getOWLEntity(name);
		if (owlEntity != null) {
			toReturn = owlEntity.accept(new DefaultOWLObjectVisitorEx<OWLDataProperty>() {
				@Override
				protected OWLDataProperty doDefault(OWLObject object) {
					return null;
				}

				@Override
				public OWLDataProperty visit(OWLDataProperty property) {
					return property;
				}
			});
		}
		return toReturn;
	}

	public OWLObjectProperty getOWLObjectProperty(String name) {
		OWLObjectProperty toReturn = null;
		OWLEntity owlEntity = this.getOWLEditorKit().getOWLModelManager().getOWLEntity(name);
		if (owlEntity != null) {
			toReturn = owlEntity.accept(new DefaultOWLObjectVisitorEx<OWLObjectProperty>() {
				@Override
				protected OWLObjectProperty doDefault(OWLObject object) {
					return null;
				}

				@Override
				public OWLObjectProperty visit(OWLObjectProperty property) {
					return property;
				}
			});
		}
		return toReturn;
	}

	public OWLDatatype getOWLDatatype(String name) {
		OWLDatatype toReturn = null;
		OWLEntity owlEntity = this.getOWLEditorKit().getOWLModelManager().getOWLEntity(name);
		if (owlEntity != null) {
			toReturn = owlEntity.accept(new DefaultOWLObjectVisitorEx<OWLDatatype>() {
				@Override
				protected OWLDatatype doDefault(OWLObject object) {
					return null;
				}

				@Override
				public OWLDatatype visit(OWLDatatype node) {
					return node;
				}
			});
		}
		return toReturn;
	}

	public OWLIndividual getOWLIndividual(String name) {
		OWLIndividual toReturn = null;
		OWLEntity owlEntity = this.getOWLEditorKit().getOWLModelManager().getOWLEntity(name);
		if (owlEntity != null) {
			toReturn = owlEntity.accept(new DefaultOWLObjectVisitorEx<OWLIndividual>() {
				@Override
				protected OWLIndividual doDefault(OWLObject object) {
					return null;
				}

				@Override
				public OWLIndividual visit(OWLIndividual individual) {
					return individual;
				}
			});
		}
		return toReturn;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}
}