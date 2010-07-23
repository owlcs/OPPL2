/**
 * 
 */
package org.coode.oppl.protege.ui.message;

/**
 * @author Luigi Iannone
 * 
 */
public class Error extends AbstractMessage implements Message {
	/**
	 * @param messageText
	 */
	public Error(String messageText) {
		super(messageText);
	}

	/**
	 * @see org.coode.oppl.protege.ui.message.Message#accept(org.coode.oppl.protege.ui.message.MessageVisitor)
	 */
	public void accept(MessageVisitor visitor) {
		visitor.visitError(this);
	}

	/**
	 * @see org.coode.oppl.protege.ui.message.Message#accept(org.coode.oppl.protege.ui.message.MessageVisitorEx)
	 */
	public <O> O accept(MessageVisitorEx<O> visitor) {
		return visitor.visitError(this);
	}
}
