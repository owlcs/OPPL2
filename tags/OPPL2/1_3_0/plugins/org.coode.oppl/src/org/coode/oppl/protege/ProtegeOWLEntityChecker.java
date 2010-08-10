package org.coode.oppl.protege;

import org.coode.oppl.utils.DefaultOWLObjectVisitorEx;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;

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

	public OWLDataType getOWLDataType(String name) {
		OWLDataType toReturn = null;
		OWLEntity owlEntity = this.getOWLEditorKit().getOWLModelManager().getOWLEntity(name);
		if (owlEntity != null) {
			toReturn = owlEntity.accept(new DefaultOWLObjectVisitorEx<OWLDataType>() {
				@Override
				protected OWLDataType doDefault(OWLObject object) {
					return null;
				}

				@Override
				public OWLDataType visit(OWLDataType node) {
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