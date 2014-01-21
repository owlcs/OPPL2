package org.coode.oppl.protege.ui.message;

/** @author Luigi Iannone */
public class Error extends AbstractMessage implements Message {
    /** @param messageText
     *            messageText */
    public Error(String messageText) {
        super(messageText);
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visitError(this);
    }

    @Override
    public <O> O accept(MessageVisitorEx<O> visitor) {
        return visitor.visitError(this);
    }
}
