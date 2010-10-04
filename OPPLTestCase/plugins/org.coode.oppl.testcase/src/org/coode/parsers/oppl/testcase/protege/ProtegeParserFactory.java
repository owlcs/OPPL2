/**
 * 
 */
package org.coode.parsers.oppl.testcase.protege;

import java.util.Set;

import org.coode.oppl.protege.ProtegeOWLEntityChecker;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeParserFactory implements AbstractParserFactory {
	private final class ProtegeSymbolTableFactory implements
			SymbolTableFactory<OPPLTestCaseSymbolTable> {
		public OPPLTestCaseSymbolTable createSymbolTable() {
			DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
					ProtegeParserFactory.this.getOWLEntityChecker());
			ShortFormEntityRenderer entityRenderer = ProtegeParserFactory.this
					.getEntityRenderer();
			EntityFinder entityFinder = ProtegeParserFactory.this
					.getEntityFinder();
			return new OPPLTestCaseSymbolTable(new OPPLScope(entityChecker,
					entityFinder, entityRenderer), ProtegeParserFactory.this
					.getOWLEditorKit().getOWLModelManager().getOWLDataFactory());
		}
	}

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

	private final OWLEditorKit owlEditorKit;
	private final ShortFormEntityRenderer entityRenderer;
	private final EntityFinder protegeEntityFinder;
	private final ProtegeOWLEntityChecker protegeOWLEntityChecker;

	/**
	 * @param owlEditorKit
	 */
	public ProtegeParserFactory(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.protegeOWLEntityChecker = new ProtegeOWLEntityChecker(this
				.getOWLEditorKit());
		this.protegeEntityFinder = new ProtegeEntityFinder();
		this.entityRenderer = new ProtegeOWLEntityRenderer();
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory
	 *      #build(org.coode.parsers.ErrorListener)
	 */
	public OPPLTestCaseParser build(ErrorListener errorListener) {
		OWLOntology activeOntology = this.getOWLEditorKit()
				.getOWLModelManager().getActiveOntology();
		OWLOntologyManager ontologyManager = this.getOWLEditorKit()
				.getOWLModelManager().getOWLOntologyManager();
		OWLReasoner reasoner = this.getOWLEditorKit().getOWLModelManager()
				.getReasoner() instanceof NoOpReasoner ? null : this
				.getOWLEditorKit().getOWLModelManager().getReasoner();
		SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
		ParserFactory parserFactory = new ParserFactory(activeOntology,
				ontologyManager, reasoner) {
			@Override
			public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
				return new ProtegeOPPLTestCaseFactory(ProtegeParserFactory.this
						.getOWLEditorKit());
			};
		};
		return parserFactory.build(errorListener, symbolTableFactory);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory
	 *      #getOPPLTestCaseFactory()
	 */
	public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
		return new ProtegeOPPLTestCaseFactory(this.getOWLEditorKit());
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
}
