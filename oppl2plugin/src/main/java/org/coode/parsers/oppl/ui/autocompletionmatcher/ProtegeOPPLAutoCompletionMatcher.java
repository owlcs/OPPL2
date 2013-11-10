/**
 * 
 */
package org.coode.parsers.oppl.ui.autocompletionmatcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.parsers.OWLEntityRenderer;
import org.coode.parsers.ui.autocompletionmatcher.AutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.KeywordAutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.ManchesterOWLSyntaxSimpleAutoCompletionMatcher;
import org.coode.parsers.ui.autocompletionmatcher.MultipleAutoCompletionMatcher;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.model.OWLEntity;

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
	private final List<String> fragments = Arrays.asList(
			":CLASS",
			":OBJECTPROPERTY",
			":DATAPROPERTY",
			":INDIVIDUAL",
			":CONSTANT",
			".toLowerCase",
			".toUpperCase",
			".VALUES",
			".RENDERING",
			".GROUPS");

	public ProtegeOPPLAutoCompletionMatcher(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The owl editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
		this.getOWLEditorKit().getOWLModelManager().addListener(this.modelManagerListener);
		this.reset();
	}

    @Override
	public List<String> getMatches(String string2Complete) {
		List<String> matches = this.delegate.getMatches(string2Complete);
		matches.addAll(this.matchFragments(string2Complete));
		return matches;
	}

	private Set<String> matchFragments(String string2Complete) {
		Set<String> toReturn = new HashSet<String>();
		for (int i = string2Complete.length() - 1; i >= 0; i--) {
			String fragmentStart = string2Complete.substring(i);
			for (String string : this.fragments) {
				Pattern pattern = Pattern.compile(
						String.format("(%s).*", fragmentStart.replaceAll("\\?", "\\\\?")),
						Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(string);
				if (matcher.matches()) {
					String rest = string.replace(matcher.group(1), "");
					toReturn.add(String.format("%s%s", string2Complete, rest));
				}
			}
		}
		return toReturn;
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
				"FAIL",
				"SET(",
				"DisjointClasses:",
				"DisjointProperties:",
				"DifferentIndividuals:",
				"SameIndividual:");
	}

}
