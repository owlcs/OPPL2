
package org.coode.parsers.ui.autocompletionmatcher;

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
        if (entityRenderer == null) {
            throw new NullPointerException("The entity renderer cannot be null");
        }
        if (ontologyManager == null) {
            throw new NullPointerException("The ontology manager cannot be null");
        }
        delegate = new MultipleAutoCompletionMatcher(
                Arrays.asList(new OWLEntityRendererAutoCompletionMatcher(entityRenderer,
                        ontologyManager), new KeywordAutoCompletionMatcher(getKeywords())));
    }

    @Override
    public List<String> getMatches(String string2Complete) {
        if (string2Complete == null) {
            throw new NullPointerException("The string to complete cannot be null");
        }
        return delegate.getMatches(string2Complete);
    }

    public static List<String> getKeywords() {
        return Arrays.asList("sameAs", "disjointWith", "only", "subPropertyOf", "max",
                "types", "inverseOf", "not", "and", "subClassOf", "differentFrom",
                "equivalentTo", "some", "instanceOf", "HasKey", "Reflexive", "Symmetric",
                "Asymmetric", "Transitive", "exactly", "range", "min", "value", "domain",
                "INV", "InverseFunctional", "Irreflexive", "or", "Functional");
    }
}
