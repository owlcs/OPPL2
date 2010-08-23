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
package org.coode.oppl.lint.protege;

import java.util.Set;

import org.coode.oppl.lint.OPPLLintAbstractFactory;
import org.coode.oppl.lint.OPPLLintParser;
import org.coode.oppl.lint.OPPLLintParser.AbstractParserFactory;
import org.coode.oppl.protege.ProtegeOWLEntityChecker;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeParserFactory implements AbstractParserFactory {
	private class ProtegeEntityFinder implements EntityFinder {
		public Set<OWLEntity> getEntities(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getEntities(
					match);
		}

		public Set<OWLEntity> getEntities(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getEntities(
					match,
					fullRegExp);
		}

		public Set<OWLClass> getMatchingOWLClasses(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLClasses(
					match);
		}

		public Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLClasses(
					match,
					fullRegExp);
		}

		public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLObjectProperties(
					match);
		}

		public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match,
				boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLObjectProperties(
					match,
					fullRegExp);
		}

		public Set<OWLDataProperty> getMatchingOWLDataProperties(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLDataProperties(
					match);
		}

		public Set<OWLDataProperty> getMatchingOWLDataProperties(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLDataProperties(
					match,
					fullRegExp);
		}

		public Set<OWLIndividual> getMatchingOWLIndividuals(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLIndividuals(
					match);
		}

		public Set<OWLIndividual> getMatchingOWLIndividuals(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLIndividuals(
					match,
					fullRegExp);
		}

		public Set<OWLDataType> getMatchingOWLDataTypes(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLDataTypes(
					match);
		}

		public Set<OWLDataType> getMatchingOWLDataTypes(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getEntityFinder().getMatchingOWLDataTypes(
					match,
					fullRegExp);
		}
	}

	private class ProtegeOWLEntityRenderer extends ShortFormEntityRenderer {
		public ProtegeOWLEntityRenderer() {
			super(new SimpleShortFormProvider());
		}

		@Override
		public String render(OWLEntity entity) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getRendering(
					entity);
		}
	}

	private class ProtegeSymbolTableFactory implements SymbolTableFactory<OPPLSymbolTable> {
		public OPPLSymbolTable createSymbolTable() {
			DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
					ProtegeParserFactory.this.getOWLEntityChecker());
			ShortFormEntityRenderer entityRenderer = ProtegeParserFactory.this.getEntityRenderer();
			EntityFinder entityFinder = ProtegeParserFactory.this.getEntityFinder();
			return new OPPLSymbolTable(
					new OPPLScope(entityChecker, entityFinder, entityRenderer),
					ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLDataFactory());
		}
	}

	private final OWLEditorKit owlEditorKit;
	private final ProtegeOWLEntityChecker protegeOWLEntityChecker;
	private final EntityFinder protegeEntityFinder;
	private final ShortFormEntityRenderer entityRenderer;
	private final OPPLLintAbstractFactory opplLintAbstractFactory;
	private static ProtegeParserFactory instance = null;

	/**
	 * @param modelManager
	 */
	private ProtegeParserFactory(OWLEditorKit owlEditorKit) {
		assert owlEditorKit != null;
		this.owlEditorKit = owlEditorKit;
		this.protegeOWLEntityChecker = new ProtegeOWLEntityChecker(this.getOWLEditorKit());
		this.protegeEntityFinder = new ProtegeEntityFinder();
		this.entityRenderer = new ProtegeOWLEntityRenderer();
		this.opplLintAbstractFactory = new ProtegeOPPLLintFactory(this.getOWLEditorKit());
	}

	public OPPLLintParser build(ErrorListener errorListener) {
		SymbolTableFactory<OPPLSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
		return new OPPLLintParser(this.getOPPLLintAbstractFactory(), errorListener,
				symbolTableFactory);
	}

	public OPPLLintAbstractFactory getOPPLLintAbstractFactory() {
		return this.opplLintAbstractFactory;
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	public EntityFinder getEntityFinder() {
		return this.protegeEntityFinder;
	}

	/**
	 * @return the entityRenderer
	 */
	public ShortFormEntityRenderer getEntityRenderer() {
		return this.entityRenderer;
	}

	public OWLEntityChecker getOWLEntityChecker() {
		return this.protegeOWLEntityChecker;
	}

	public static ProtegeParserFactory getInstance(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWLEditorKit cannot be null");
		}
		if (instance == null) {
			instance = new ProtegeParserFactory(owlEditorKit);
		}
		return instance;
	}
}
