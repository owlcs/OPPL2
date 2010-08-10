/**
 * 
 */
package org.coode.patterns.protege;

import java.util.Collection;
import java.util.Set;
import java.util.logging.Logger;

import org.coode.oppl.utils.DefaultOWLObjectVisitorEx;
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
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
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

	private class ProtegeOWLEntityChecker implements OWLEntityChecker {
		public OWLClass getOWLClass(String name) {
			OWLClass toReturn = null;
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntity(
					name);
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
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntity(
					name);
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
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntity(
					name);
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
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntity(
					name);
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
			OWLEntity owlEntity = ProtegeParserFactory.this.getOWLEditorKit().getOWLModelManager().getOWLEntity(
					name);
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
		// TODO Auto-generated method stub
		return null;
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
