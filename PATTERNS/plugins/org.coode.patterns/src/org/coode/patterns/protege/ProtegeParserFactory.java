/**
 * 
 */
package org.coode.patterns.protege;

import java.util.Collection;
import java.util.Set;
import java.util.logging.Logger;

import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.LoggerErrorListener;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.OPPLPatternParser.AbstractParserFactory;
import org.coode.patterns.VisitedPatternReferenceResolver;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
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

	private class ProtegeOWLEntityChecker implements OWLEntityChecker {
		public OWLClass getOWLClass(String name) {
			OWLClass toReturn = null;
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getOWLEntity(
					name);
			if (owlEntity != null) {
				toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLClass>() {
					@Override
					public OWLClass visit(OWLClass desc) {
						return desc;
					}
				});
			}
			return toReturn;
		}

		public OWLAnnotationProperty getOWLAnnotationProperty(String name) {
			OWLAnnotationProperty toReturn = null;
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getOWLEntity(
					name);
			if (owlEntity != null) {
				toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLAnnotationProperty>() {
					@Override
					public OWLAnnotationProperty visit(OWLAnnotationProperty property) {
						return property;
					}
				});
			}
			return toReturn;
		}

		public OWLDataProperty getOWLDataProperty(String name) {
			OWLDataProperty toReturn = null;
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getOWLEntity(
					name);
			if (owlEntity != null) {
				toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLDataProperty>() {
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
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getOWLEntity(
					name);
			if (owlEntity != null) {
				toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLObjectProperty>() {
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
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getOWLEntity(
					name);
			if (owlEntity != null) {
				toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLDatatype>() {
					@Override
					public OWLDatatype visit(OWLDatatype node) {
						return node;
					}
				});
			}
			return toReturn;
		}

		public OWLNamedIndividual getOWLIndividual(String name) {
			OWLNamedIndividual toReturn = null;
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntityFinder().getOWLEntity(
					name);
			if (owlEntity != null) {
				toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLNamedIndividual>() {
					@Override
					public OWLNamedIndividual visit(OWLNamedIndividual individual) {
						return individual;
					}
				});
			}
			return toReturn;
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

	private class ProtegeSymbolTableFactory implements SymbolTableFactory<OPPLPatternsSymbolTable> {
		public OPPLPatternsSymbolTable createSymbolTable() {
			DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
					ProtegeParserFactory.this.getOWLEntityChecker());
			ShortFormEntityRenderer entityRenderer = ProtegeParserFactory.this.getEntityRenderer();
			EntityFinder entityFinder = ProtegeParserFactory.this.getEntityFinder();
			return new OPPLPatternsSymbolTable(
					new OPPLScope(entityChecker, entityFinder, entityRenderer),
					ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager());
		}
	}

	private final OWLEditorKit owlEditorKit;
	private final EntityFinder protegeEntityFinder;
	private final ShortFormEntityRenderer entityRenderer;
	private final ProtegeOWLEntityChecker protegeOWLEntityChecker;
	private static ProtegeParserFactory instance = null;

	/**
	 * @param owlEditorKit
	 */
	public ProtegeParserFactory(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.protegeOWLEntityChecker = new ProtegeOWLEntityChecker();
		this.protegeEntityFinder = new ProtegeEntityFinder();
		this.entityRenderer = new ProtegeOWLEntityRenderer();
	}

	/**
	 * @see org.coode.patterns.OPPLPatternParser.AbstractParserFactory#build(org.coode.parsers.ErrorListener)
	 */
	public OPPLPatternParser build(ErrorListener errorListener) {
		SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
		return new OPPLPatternParser(this.getPatternFactory(), errorListener, symbolTableFactory);
	}

	/**
	 * @see org.coode.patterns.OPPLPatternParser.AbstractParserFactory#build(java.util.Collection,
	 *      org.coode.parsers.ErrorListener)
	 */
	public OPPLPatternParser build(Collection<? extends String> visitedPatterns,
			ErrorListener errorListener) {
		SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
		return new OPPLPatternParser(this.getPatternFactory(), errorListener, symbolTableFactory,
				new VisitedPatternReferenceResolver(visitedPatterns));
	}

	/**
	 * @see org.coode.patterns.OPPLPatternParser.AbstractParserFactory#getPatternFactory()
	 */
	public AbstractPatternModelFactory getPatternFactory() {
		return new ProtegePatternModelFactory(this.getOWLEditorKit().getModelManager());
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

	public OWLEntityChecker getOWLEntityChecker() {
		return this.protegeOWLEntityChecker;
	}

	/**
	 * @return the entityRenderer
	 */
	public ShortFormEntityRenderer getEntityRenderer() {
		return this.entityRenderer;
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

	public static ErrorListener getDefaultErrorListener() {
		Logger logger = Logger.getLogger("org.coode.patterns.protege");
		return new LoggerErrorListener(logger);
	}
}
