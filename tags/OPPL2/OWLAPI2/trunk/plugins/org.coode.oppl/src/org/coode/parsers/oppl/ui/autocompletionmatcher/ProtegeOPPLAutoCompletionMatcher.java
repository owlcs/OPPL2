/**
 * 
 */
package org.coode.parsers.oppl.ui.autocompletionmatcher;

import java.util.Arrays;
import java.util.List;

import org.coode.parsers.OWLEntityRenderer;
import org.coode.parsers.ui.autocompletionmatcher.AutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.KeywordAutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.ManchesterOWLSyntaxSimpleAutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.MultipleAutoCompletionMatcher;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owl.model.OWLEntity;

/**
 * @author Luigi Iannone
 * 
 */
public final class ProtegeOPPLAutoCompletionMatcher implements AutoCompletionMatcher {
	private static final KeywordAutoCompletionMatcher OPPL_KEYWORD_AUTO_COMPLETION_MATCHER = new KeywordAutoCompletionMatcher(
			getKeywords());
	private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
		public void handleChange(OWLModelManagerChangeEvent event) {
			ProtegeOPPLAutoCompletionMatcher.this.reset();
		}
	};
	private final OWLEditorKit owlEditorKit;
	private AutoCompletionMatcher delegate;

	public ProtegeOPPLAutoCompletionMatcher(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The owl editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.getOWLEditorKit().getOWLModelManager().addListener(this.modelManagerListener);
		this.reset();
	}

	/**
	 * @see org.coode.parsers.ui.autocompletionmatcher.AutoCompletionMatcher#getMatches
	 *      (java.lang.String)
	 */
	public List<String> getMatches(String string2Complete) {
		return this.delegate.getMatches(string2Complete);
	}

	public void dispose() {
		this.getOWLEditorKit().getOWLModelManager().removeListener(this.modelManagerListener);
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	private void reset() {
		OWLEntityRenderer entityRenderer = new OWLEntityRenderer() {
			public String render(OWLEntity entity) {
				return ProtegeOPPLAutoCompletionMatcher.this.getOWLEditorKit().getOWLModelManager().getRendering(
						entity);
			}
		};
		this.delegate = new MultipleAutoCompletionMatcher(Arrays.asList(
				new ManchesterOWLSyntaxSimpleAutoCompletionMatcher(entityRenderer,
						this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()),
				OPPL_KEYWORD_AUTO_COMPLETION_MATCHER));
	}

	public static List<String> getKeywords() {
		return Arrays.asList(
				"WHERE",
				"IN",
				"SELECT",
				"ASSERTED",
				"create",
				"createIntersection",
				"createDisjuntion",
				"BEGIN",
				"END;",
				"superClassOf",
				"superPropertyOf",
				"CLASS",
				"OBJECTPROPERTY",
				"DATAPROPERTY",
				"INDIVIDUAL",
				"CONSTANT",
				"ADD",
				"REMOVE",
				"subPropertyOf",
				"MATCH",
				"VALUES",
				"RENDERING",
				"GROUPS",
				"FAIL");
	}
}
