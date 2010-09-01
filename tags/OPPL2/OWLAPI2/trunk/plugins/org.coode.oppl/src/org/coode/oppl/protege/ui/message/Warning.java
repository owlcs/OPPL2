/**
 * 
 */
package org.coode.oppl.protege.ui.message;

/**
 * @author Luigi Iannone
 * 
 */
public class Warning extends AbstractMessage implements Message {
	/**
	 * @param messageText
	 *            the text of this Warning. Cannot be {@code null}.
	 */
	public Warning(String messageText) {
		super(messageText);
	}

	/**
	 * @see org.coode.oppl.protege.ui.message.Message#accept(org.coode.oppl.protege.ui.message.MessageVisitor)
	 */
	public void accept(MessageVisitor visitor) {
		visitor.visitWarning(this);
	}

	/**
	 * @see org.coode.oppl.protege.ui.message.Message#accept(org.coode.oppl.protege.ui.message.MessageVisitorEx)
	 */
	public <O> O accept(MessageVisitorEx<O> visitor) {
		return visitor.visitWarning(this);
	}
}
