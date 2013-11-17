/**
 * 
 */
package org.coode.oppl.template.commons;

import org.coode.oppl.template.OPPLTemplate;
import org.coode.oppl.template.ParsingStrategy;
import org.coode.oppl.template.ReplacementStrategy;

/** @author Luigi Iannone */
public class StringTemplate<O> implements OPPLTemplate<O> {
    private final String templateString;
    private final ReplacementStrategy<String, String> replacementStrategy;
    private final ParsingStrategy<String, O> parserCreationStrategy;

    public StringTemplate(String templateString,
            ReplacementStrategy<String, String> replacementStrategy,
            ParsingStrategy<String, O> parserCreationStrategy) {
        if (templateString == null) {
            throw new NullPointerException("The template string cannot be null");
        }
        if (replacementStrategy == null) {
            throw new NullPointerException("The replacement strategy cannot be null");
        }
        if (parserCreationStrategy == null) {
            throw new NullPointerException("The parser factory cannot be null");
        }
        this.templateString = templateString;
        this.replacementStrategy = replacementStrategy;
        this.parserCreationStrategy = parserCreationStrategy;
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
