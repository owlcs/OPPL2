/**
 *
 */
package org.coode.oppl.protege.ui.message;

import org.coode.oppl.utils.ArgCheck;

/** @author Luigi Iannone */
public abstract class AbstractMessage implements Message {
    private final String messageText;

    /** Build this AstractMessage starting from the input string.
     * 
     * @param messageText
     *            the text in this AbstractMessage. Cannot be {@code null}. */
    protected AbstractMessage(String messageText) {
        ArgCheck.checkNullArgument("The message text", messageText);
        this.messageText = messageText;
    }

    @Override
    public String getMessageText() {
        return messageText;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
