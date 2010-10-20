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
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeParserFactory implements AbstractParserFactory {
	private class ProtegeEntityFinder implements EntityFinder {
		public Set<OWLEntity> getEntities(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLEntities(
					match);
		}

		public Set<OWLEntity> getEntities(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLEntities(
					match,
					fullRegExp);
		}

		public Set<OWLClass> getMatchingOWLClasses(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLClasses(
					match);
		}

		public Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLClasses(
					match,
					fullRegExp);
		}

		public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLObjectProperties(
					match);
		}

		public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match,
				boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLObjectProperties(
					match,
					fullRegExp);
		}

		public Set<OWLDataProperty> getMatchingOWLDataProperties(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLDataProperties(
					match);
		}

		public Set<OWLDataProperty> getMatchingOWLDataProperties(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLDataProperties(
					match,
					fullRegExp);
		}

		public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLIndividuals(
					match);
		}

		public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLIndividuals(
					match,
					fullRegExp);
		}

		public Set<OWLDatatype> getMatchingOWLDataTypes(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLDatatypes(
					match);
		}

		public Set<OWLDatatype> getMatchingOWLDataTypes(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getMatchingOWLDatatypes(
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
			return new OPPLSymbolTable(
					new OPPLScope(entityChecker, new ProtegeEntityFinder(), entityRenderer),
					ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLDataFactory());
		}
	}

	private final OWLEditorKit owlEditorKit;
	private final OPPLLintAbstractFactory opplLintAbstractFactory;
	private static final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
		public void handleChange(OWLModelManagerChangeEvent event) {
			reset();
		}
	};
	private static ProtegeParserFactory instance = null;

	/**
	 * @param modelManager
	 */
	private ProtegeParserFactory(OWLEditorKit owlEditorKit) {
		assert owlEditorKit != null;
		this.owlEditorKit = owlEditorKit;
		this.owlEditorKit.getOWLModelManager().addListener(modelManagerListener);
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

	/**
	 * @return the entityRenderer
	 */
	public ShortFormEntityRenderer getEntityRenderer() {
		return new ProtegeOWLEntityRenderer();
	}

	public OWLEntityChecker getOWLEntityChecker() {
		return new ProtegeOWLEntityChecker(this.getOWLEditorKit());
	}

	public static void reset() {
		instance.dispose();
		instance = null;
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

	public void dispose() {
		this.owlEditorKit.getOWLModelManager().removeListener(modelManagerListener);
	}
}
