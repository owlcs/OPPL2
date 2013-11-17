/**
 * 
 */
package org.coode.oppl.protege.ui.message;

/** @author Luigi Iannone */
public class Warning extends AbstractMessage implements Message {
    /** @param messageText
     *            the text of this Warning. Cannot be {@code null}. */
    public Warning(String messageText) {
        super(messageText);
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visitWarning(this);
    }

    @Override
    public <O> O accept(MessageVisitorEx<O> visitor) {
        return visitor.visitWarning(this);
    }
}
