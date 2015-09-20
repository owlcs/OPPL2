package org.coode.parsers.oppl.patterns.ui.autocompletionmatcher;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * @author Luigi Iannone
 */
public final class ProtegeOPPLPatternsAutoCompletionMatcher implements
    AutoCompletionMatcher {

    private static final KeywordAutoCompletionMatcher OPPL_PATTERNS_KEYWORD_AUTO_COMPLETION_MATCHER = new KeywordAutoCompletionMatcher(
        getKeywords());
    private final OWLEditorKit owlEditorKit;
    private AutoCompletionMatcher delegate;
    private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {

        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            ProtegeOPPLPatternsAutoCompletionMatcher.this.reset();
        }
    };

    /**
     * @param owlEditorKit
     *        owlEditorKit
     */
    public ProtegeOPPLPatternsAutoCompletionMatcher(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
        reset();
    }

    @Override
    public List<String> getMatches(String input) {
        return delegate.getMatches(input);
    }

    /**
     * @return keywords
     */
    public static List<String> getKeywords() {
        // XXX more keywords
        return Arrays.asList("create", "createIntersection", "createDisjuntion", "BEGIN",
            "END;", "superClassOf", "superPropertyOf", "CLASS", "OBJECTPROPERTY",
            "DATAPROPERTY", "INDIVIDUAL", "CONSTANT", "ADD", "REMOVE",
            "subPropertyOf", "VALUES", "RENDERING", "GROUPS", "$thisClass", "RETURN");
    }

    /**
     * @return the owlEditorKit
     */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** dispose */
    public void dispose() {
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
    }

    protected void reset() {
        OWLEntityRenderer entityRenderer = new OWLEntityRenderer() {

            @Override
            public String render(OWLEntity entity) {
                return ProtegeOPPLPatternsAutoCompletionMatcher.this.getOWLEditorKit()
                    .getOWLModelManager().getRendering(entity);
            }
        };
        delegate = new MultipleAutoCompletionMatcher(Arrays.asList(
            new ManchesterOWLSyntaxSimpleAutoCompletionMatcher(entityRenderer,
                getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()),
            OPPL_PATTERNS_KEYWORD_AUTO_COMPLETION_MATCHER));
    }
}
