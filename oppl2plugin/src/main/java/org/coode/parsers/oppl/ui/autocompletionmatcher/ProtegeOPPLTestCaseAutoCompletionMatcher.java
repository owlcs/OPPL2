package org.coode.parsers.oppl.ui.autocompletionmatcher;

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

/** @author Luigi Iannone */
public final class ProtegeOPPLTestCaseAutoCompletionMatcher implements
        AutoCompletionMatcher {
    private static final KeywordAutoCompletionMatcher OPPL_KEYWORD_AUTO_COMPLETION_MATCHER = new KeywordAutoCompletionMatcher(
            getKeywords());
    private final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {
        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            ProtegeOPPLTestCaseAutoCompletionMatcher.this.reset();
        }
    };
    private final OWLEditorKit owlEditorKit;
    private AutoCompletionMatcher delegate;

    /** @param owlEditorKit
     *            owlEditorKit */
    public ProtegeOPPLTestCaseAutoCompletionMatcher(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
        reset();
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        return delegate.getMatches(string2Complete);
    }

    /** dispose */
    public void dispose() {
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    protected void reset() {
        OWLEntityRenderer entityRenderer = new OWLEntityRenderer() {
            @Override
            public String render(OWLEntity entity) {
                return ProtegeOPPLTestCaseAutoCompletionMatcher.this.getOWLEditorKit()
                        .getOWLModelManager().getRendering(entity);
            }
        };
        delegate = new MultipleAutoCompletionMatcher(Arrays.asList(
                new ManchesterOWLSyntaxSimpleAutoCompletionMatcher(entityRenderer,
                        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()),
                OPPL_KEYWORD_AUTO_COMPLETION_MATCHER));
    }

    /** @return keywords */
    public static List<String> getKeywords() {
        // XXX group these with the other keywords
        return Arrays.asList("WHERE", "IN", "SELECT", "ASSERTED", "create",
                "createIntersection", "createDisjuntion", "superClassOf",
                "superPropertyOf", "CLASS", "OBJECTPROPERTY", "DATAPROPERTY",
                "INDIVIDUAL", "CONSTANT", "subPropertyOf", "MATCH", "VALUES",
                "RENDERING", "GROUPS", "FAIL", "count", "INFERENCE;", "CONTAINS",
                "ASSERT");
    }
}
