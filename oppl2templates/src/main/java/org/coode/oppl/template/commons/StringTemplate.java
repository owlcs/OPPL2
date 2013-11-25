package org.coode.oppl.template.commons;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.template.OPPLTemplate;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.oppl.template.ReplacementStrategy;

/** @author Luigi Iannone */
public class StringTemplate<O> implements OPPLTemplate<O> {
    private final String templateString;
    private final ReplacementStrategy<String, String> replacementStrategy;
    private final ParsingStrategy<String, O> parserCreationStrategy;

    /** @param templateString
     * @param replacementStrategy
     * @param parserCreationStrategy */
    public StringTemplate(String templateString,
            ReplacementStrategy<String, String> replacementStrategy,
            ParsingStrategy<String, O> parserCreationStrategy) {
        this.templateString = checkNotNull(templateString, "templateString");
        this.replacementStrategy = checkNotNull(replacementStrategy,
                "replacementStrategy");
        this.parserCreationStrategy = checkNotNull(parserCreationStrategy,
                "parserCreationStrategy");
    }

    @Override
    public O replace() {
        String replacedString = this.getReplacementStrategy().replace(
                this.getTemplateString());
        return this.getParserCreationStrategy().parse(replacedString);
    }

    /** @return the replacementStrategy */
    public ReplacementStrategy<String, String> getReplacementStrategy() {
        return this.replacementStrategy;
    }

    @Override
    public String getTemplateString() {
        return this.templateString;
    }

    /** @return the parserCreationStrategy */
    public ParsingStrategy<String, O> getParserCreationStrategy() {
        return this.parserCreationStrategy;
    }
}
