/**
 * 
 */
package org.coode.oppl.protege;

import java.util.Set;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLParser.AbstractParserFactory;
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
		public Set<OWLDatatype> getMatchingOWLDataTypes(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLDatatypes(match);
		}

		public Set<OWLDatatype> getMatchingOWLDataTypes(String match,
				boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLDatatypes(match, fullRegExp);
		}

		public Set<OWLEntity> getEntities(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLEntities(match);
		}

		public Set<OWLEntity> getEntities(String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLEntities(match, fullRegExp);
		}

		public Set<OWLClass> getMatchingOWLClasses(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLClasses(match);
		}

		public Set<OWLClass> getMatchingOWLClasses(String match,
				boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLClasses(match, fullRegExp);
		}

		public Set<OWLObjectProperty> getMatchingOWLObjectProperties(
				String match) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLObjectProperties(match);
		}

		public Set<OWLObjectProperty> getMatchingOWLObjectProperties(
				String match, boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLObjectProperties(match, fullRegExp);
		}

		public Set<OWLDataProperty> getMatchingOWLDataProperties(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLDataProperties(match);
		}

		public Set<OWLDataProperty> getMatchingOWLDataProperties(String match,
				boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLDataProperties(match, fullRegExp);
		}

		public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLIndividuals(match);
		}

		public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match,
				boolean fullRegExp) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getOWLEntityFinder()
					.getMatchingOWLIndividuals(match, fullRegExp);
		}
	}

	private class ProtegeSymbolTableFactory implements
			SymbolTableFactory<OPPLSymbolTable> {
		public OPPLSymbolTable createSymbolTable() {
			DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
					ProtegeParserFactory.this.getOWLEntityChecker());
			ShortFormEntityRenderer entityRenderer = ProtegeParserFactory.this
					.getEntityRenderer();
			EntityFinder entityFinder = ProtegeParserFactory.this
					.getEntityFinder();
			return new OPPLSymbolTable(new OPPLScope(entityChecker,
					entityFinder, entityRenderer), ProtegeParserFactory.this
					.getOWLEditorKit().getOWLModelManager().getOWLDataFactory());
		}
	}

	private class ProtegeOWLEntityRenderer extends ShortFormEntityRenderer {
		public ProtegeOWLEntityRenderer() {
			super(new SimpleShortFormProvider());
		}

		@Override
		public String render(OWLEntity entity) {
			return ProtegeParserFactory.this.getOWLEditorKit()
					.getOWLModelManager().getRendering(entity);
		}
	}

	private static ProtegeParserFactory instance = null;
	private final OWLEditorKit owlEditorKit;
	private final ProtegeOWLEntityChecker protegeOWLEntityChecker;
	private final EntityFinder protegeEntityFinder;
	private final OPPLAbstractFactory opplFactory;
	private final ShortFormEntityRenderer entityRenderer;
	private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
		public void handleChange(OWLModelManagerChangeEvent event) {
			reset();
		}
	};

	/**
	 * @param owlEditorKit
	 */
	private ProtegeParserFactory(OWLEditorKit owlEditorKit) {
		assert owlEditorKit != null;
		this.owlEditorKit = owlEditorKit;
		this.owlEditorKit.getOWLModelManager().addListener(
				this.modelManagerListener);
		this.protegeOWLEntityChecker = new ProtegeOWLEntityChecker(this
				.getOWLEditorKit());
		this.protegeEntityFinder = new ProtegeEntityFinder();
		this.opplFactory = new ProtegeOPPLFactory(this.getOWLEditorKit());
		this.entityRenderer = new ProtegeOWLEntityRenderer();
	}

	/**
	 * @see org.coode.oppl.OPPLParser.AbstractParserFactory#build(org.coode.parsers
	 *      .ErrorListener)
	 */
	public OPPLParser build(ErrorListener errorListener) {
		SymbolTableFactory<OPPLSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
		OPPLParser parser = new OPPLParser(this.getOPPLFactory(),
				errorListener, symbolTableFactory);
		return parser;
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

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	public OWLEntityChecker getOWLEntityChecker() {
		return this.protegeOWLEntityChecker;
	}

	public EntityFinder getEntityFinder() {
		return this.protegeEntityFinder;
	}

	/**
	 * @return the opplFactory
	 */
	public OPPLAbstractFactory getOPPLFactory() {
		return this.opplFactory;
	}

	/**
	 * @return the entityRenderer
	 */
	public ShortFormEntityRenderer getEntityRenderer() {
		return this.entityRenderer;
	}

	public void dispose() {
		this.owlEditorKit.getOWLModelManager().removeListener(
				this.modelManagerListener);
	}

	public static void reset() {
		instance = null;
	}
}
