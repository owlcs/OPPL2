package org.coode.parsers.ui.autocompletionmatcher;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Arrays;
import java.util.List;

import org.coode.parsers.OWLEntityRenderer;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone */
public class ManchesterOWLSyntaxSimpleAutoCompletionMatcher implements
        AutoCompletionMatcher {
    private final AutoCompletionMatcher delegate;

    public ManchesterOWLSyntaxSimpleAutoCompletionMatcher(
            OWLEntityRenderer entityRenderer, OWLOntologyManager ontologyManager) {
        checkNotNull(entityRenderer, "entityRenderer");
        checkNotNull(ontologyManager, "ontologyManager");
        delegate = new MultipleAutoCompletionMatcher(
                Arrays.asList(new OWLEntityRendererAutoCompletionMatcher(entityRenderer,
                        ontologyManager), new KeywordAutoCompletionMatcher(getKeywords())));
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        return delegate.getMatches(checkNotNull(string2Complete, "string2Complete"));
    }

    public static List<String> getKeywords() {
        return Arrays.asList("sameAs", "disjointWith", "only", "subPropertyOf", "max",
                "types", "inverseOf", "not", "and", "subClassOf", "differentFrom",
                "equivalentTo", "some", "instanceOf", "HasKey", "Reflexive", "Symmetric",
                "Asymmetric", "Transitive", "exactly", "range", "min", "value", "domain",
                "INV", "InverseFunctional", "Irreflexive", "or", "Functional");
    }
}
